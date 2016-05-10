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

import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.HttpException;

import java.io.IOException;

/**
 * A utility for resolving error.
 */
public final class ErrorResolver {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorResolver.class);

    /**
     * Resolve error.
     *
     * @param throwable throwable
     * @param tClass    tClass
     * @param <T>       T
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T resolve(Throwable throwable, Class<T> tClass) {
        HttpException exception = (HttpException) throwable;
        Converter<ResponseBody, ?> converter = Hyperledger.CONVERTER_FACTORY.responseBodyConverter(tClass, null, null);
        try (ResponseBody responseBody = exception.response().errorBody()) {
            return (T) converter.convert(responseBody);
        } catch (IOException e) {
            LOG.error("", e);
            throw new RuntimeException(e);
        }
    }
}
