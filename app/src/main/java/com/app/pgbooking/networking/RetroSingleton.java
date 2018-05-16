package com.app.pgbooking.networking;

import android.support.annotation.NonNull;

import com.app.pgbooking.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroSingleton {

    private static RetroSingleton mInstance = null;

    public static RetroSingleton getInstance() {
        if (mInstance == null)
            mInstance = new RetroSingleton();
        return mInstance;
    }

    public RestApi getRestApi() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder();
                Request request = requestBuilder.build();
                Response response = chain.proceed(request);

                // Re-write response CC header to force use of cache
                return response.newBuilder()
                        .header("Cache-Control", "public, max-age=86400") // 1 day
                        .build();
            }
        });
        httpClient.addInterceptor(logging);

        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(RestApi.class);
    }

}
