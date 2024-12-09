package com.yupi.springbootinit.api;

import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * @description:
 * @author: CGM
 * @create: 2024-12-07 17:44
 */
public class BaiduAiApi {

    static final OkHttpClient HTTP_CLIENT = new OkHttpClient();

    public static void main(String []args) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://qianfan.baidubce.com/v2/app/conversation")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Appbuilder-Authorization", "Bearer bce-v3/ALTAK-4m****70a7a3")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(response.body().string());

    }

}
