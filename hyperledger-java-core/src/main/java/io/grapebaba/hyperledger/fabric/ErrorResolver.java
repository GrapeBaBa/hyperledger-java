/*
Copyright 2016 281165273@qq.com

Licensed under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

    [http://www.apache.org/licenses/LICENSE-2.0]

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
*/

package io.grapebaba.hyperledger.fabric;

import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.HttpException;

import java.io.IOException;

/**
 * A utility for resolving error.
 */
@Slf4j
public final class ErrorResolver {

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
            log.error("", e);
            throw new RuntimeException(e);
        }
    }
}
