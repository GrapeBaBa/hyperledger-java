package io.grapebaba.hyperledger.fabric;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public final class Hyperledger {

    public static Fabric fabric(String baseUrl) {
        return new Retrofit.Builder().baseUrl(baseUrl).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build().create(Fabric.class);
    }
}
