/*
 * Copyright 2016 281165273@qq.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package me.grapebaba.hyperledger.fabric;

import com.google.gson.GsonBuilder;
import me.grapebaba.hyperledger.fabric.models.ChaincodeSpec;
import me.grapebaba.hyperledger.fabric.models.ConfidentialityLevel;
import me.grapebaba.hyperledger.fabric.models.PeerEndpoint;
import me.grapebaba.hyperledger.fabric.models.Transaction;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A utility for creating api endpoints.
 */
public final class Hyperledger {

    /**
     * Adapter factory.
     */
    static final CallAdapter.Factory CALL_ADAPTER_FACTORY = RxJavaCallAdapterFactory.create();

    /**
     * Converter factory.
     */
    static final Converter.Factory CONVERTER_FACTORY = GsonConverterFactory.create(new GsonBuilder()
            .registerTypeAdapter(ChaincodeSpec.Type.class, new ChaincodeSpecTypeEnumTypeAdapter())
            .registerTypeAdapter(ConfidentialityLevel.class, new ConfidentialityLevelEnumTypeAdapter())
            .registerTypeAdapter(PeerEndpoint.Type.class, new PeerEndpointTypeEnumTypeAdapter())
            .registerTypeAdapter(Transaction.Type.class, new TransactionTypeEnumTypeAdapter())
            .create());

    /**
     * Create fabric API endpoint from base url.
     *
     * @param baseUrl baseUrl.
     * @return Fabric API endpoint.
     */
    public static Fabric fabric(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(CALL_ADAPTER_FACTORY)
                .addConverterFactory(CONVERTER_FACTORY)
                .build()
                .create(Fabric.class);
    }

    /**
     * Create fabric API endpoint from base url and interceptors.
     *
     * @param baseUrl      baseUrl
     * @param interceptors interceptors
     * @return Fabric API endpoint.
     */
    public static Fabric fabric(String baseUrl, Interceptor... interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        for (Interceptor interceptor : interceptors) {
            builder.addInterceptor(interceptor);
        }

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(CALL_ADAPTER_FACTORY)
                .addConverterFactory(CONVERTER_FACTORY)
                .client(builder.build())
                .build()
                .create(Fabric.class);
    }
}
