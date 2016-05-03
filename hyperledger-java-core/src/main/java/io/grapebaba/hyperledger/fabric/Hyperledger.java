package io.grapebaba.hyperledger.fabric;

import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public final class Hyperledger {

    static final CallAdapter.Factory CALL_ADAPTER_FACTORY = RxJavaCallAdapterFactory.create();

    static final Converter.Factory CONVERTER_FACTORY = GsonConverterFactory.create();

    public static Fabric fabric(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(CALL_ADAPTER_FACTORY)
                .addConverterFactory(CONVERTER_FACTORY)
                .build()
                .create(Fabric.class);
    }
}
