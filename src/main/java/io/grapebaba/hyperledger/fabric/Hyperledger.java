package io.grapebaba.hyperledger.fabric;

import retrofit2.Retrofit;


public final class Hyperledger {

    public static Fabric fabric(String baseUrl) {
        return new Retrofit.Builder().baseUrl(baseUrl).build().create(Fabric.class);
    }
}
