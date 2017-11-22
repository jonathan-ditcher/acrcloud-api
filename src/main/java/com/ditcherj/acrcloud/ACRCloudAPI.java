package com.ditcherj.acrcloud;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ditcherj.acrcloud.dto.MonitorResponse;
import com.ditcherj.acrcloud.response.IdentifyResponse;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Jonathan Ditcher on 22/11/2017.
 */
public class ACRCloudAPI {

    private static final Logger logger = LoggerFactory.getLogger(ACRCloudAPI.class);
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/octet-stream");
    private static final Integer BUFFER_SIZE = 1024 * 1024;
    private static final String POST_METHOD = "POST";
    private static final String DEFAULT_DATA_TYPE = "audio";
    private static final String DEFAULT_SIG_VERSION = "1";
    private static final String API_ENDPOINT = "https://api.acrcloud.com";
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    private final ObjectMapper mapper = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();

    public ACRCloudAPI() {
    }

    public IdentifyResponse identify(File src, String host, String accessKey, String secretKey) throws IOException {
        logger.trace("");

        if(!src.exists())
            throw new IOException("file["+src.getAbsolutePath()+"] does not exist");

        String endpoint = "/v1/identify";
        String timestamp = String.valueOf(new Date().getTime());
        byte[] queryData = new byte[BUFFER_SIZE];
        try(InputStream inputStream = new FileInputStream(src)){
            inputStream.read(queryData);
        }

        String signature = POST_METHOD + "\n" +
                        endpoint + "\n" +
                        accessKey + "\n" +
                        DEFAULT_DATA_TYPE + "\n" +
                        DEFAULT_SIG_VERSION + "\n" +
                        timestamp;
        String hmac = null;
        try {
            hmac = generateSignature(signature.getBytes(), secretKey.getBytes());
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            logger.error(e.getMessage(), e);
        }

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("access_key", accessKey)
                .addFormDataPart("sample_bytes", String.valueOf(queryData.length))
                .addFormDataPart("sample", "sample", RequestBody.create(MEDIA_TYPE, queryData))
                .addFormDataPart("timestamp", timestamp)
                .addFormDataPart("signature", hmac)
                .addFormDataPart("data_type", DEFAULT_DATA_TYPE)
                .addFormDataPart("signature_version", DEFAULT_SIG_VERSION)
                .build();

        Request request = new Request.Builder()
                .url("http://" + host + endpoint)
                .post(requestBody)
                .build();

        Response response = this.client.newCall(request).execute();
        return this.mapper.readValue(response.body().string(), IdentifyResponse.class);
    }

    public MonitorResponse monitor(String streamId, String accessKey) throws IOException {
        logger.trace("");

        String endpoint = API_ENDPOINT +"/v1/monitor-streams/" + streamId + "/results?access_key=" + accessKey + "&type=current";
        logger.trace("endpoint[{}]", endpoint);

        Request request = new Request.Builder()
                .url(endpoint)
                .get()
                .build();

        Response response = this.client.newCall(request).execute();
        return this.mapper.readValue(response.body().string(), MonitorResponse.class);
    }

    public List<MonitorResponse> monitor(String streamId, String accessKey, Integer numResults) throws IOException {
        logger.trace("numResults[{}], numResults");

        if(numResults == null)
            numResults = 1;

        String endpoint = API_ENDPOINT +"/v1/monitor-streams/" + streamId + "/results?access_key=" + accessKey + "&limit=" + numResults;
        logger.trace("endpoint[{}]", endpoint);

        Request request = new Request.Builder()
                .url(endpoint)
                .get()
                .build();

        Response response = this.client.newCall(request).execute();

        JavaType javaType = this.mapper.getTypeFactory().constructCollectionType(List.class, MonitorResponse.class);
        return this.mapper.readValue(response.body().string(), javaType);
    }

    public List<MonitorResponse> monitor(String streamId, String accessKey, Date date) throws IOException {
        logger.trace("date[{}], date");

        if(date == null)
            date = new Date();

        String endpoint = API_ENDPOINT +"/v1/monitor-streams/" + streamId + "/results?access_key=" + accessKey + "&date=" + new SimpleDateFormat("yyyy-MM-dd").format(date);
        logger.trace("endpoint[{}]", endpoint);

        Request request = new Request.Builder()
                .url(endpoint)
                .get()
                .build();

        Response response = this.client.newCall(request).execute();

        JavaType javaType = this.mapper.getTypeFactory().constructCollectionType(List.class, MonitorResponse.class);
        List<MonitorResponse> monitorResponse = this.mapper.readValue(response.body().string(), javaType);
        return monitorResponse;
    }

    private static String generateSignature(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        return Base64.getEncoder().encodeToString(mac.doFinal(data));
    }

}
