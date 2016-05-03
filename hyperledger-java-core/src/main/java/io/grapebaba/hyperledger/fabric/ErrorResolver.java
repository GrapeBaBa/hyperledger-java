package io.grapebaba.hyperledger.fabric;

import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Slf4j
public final class ErrorResolver {

    @SuppressWarnings("unchecked")
    public static <T> T resolve(Throwable throwable, Class<T> tClass) {
        HttpException exception = (HttpException) throwable;
        Converter<ResponseBody, ?> converter = Hyperledger.CONVERTER_FACTORY.responseBodyConverter(tClass, null, null);
        try (ResponseBody responseBody = exception.response().errorBody()) {
            return (T) converter.convert(responseBody);
        } catch (IOException e) {
            log.error("", e);
            throw new RuntimeException(e);
        }
    }
}
