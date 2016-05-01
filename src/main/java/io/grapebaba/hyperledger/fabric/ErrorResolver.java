package io.grapebaba.hyperledger.fabric;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public final class ErrorResolver {

    @SuppressWarnings("unchecked")
    public static <T> T resolve(Throwable throwable, Class<T> tClass) {
        HttpException exception = (HttpException) throwable;
        Converter<ResponseBody, ?> converter = GsonConverterFactory.create().responseBodyConverter(tClass, null, null);
        try (ResponseBody responseBody = exception.response().errorBody()) {
            return (T) converter.convert(responseBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
