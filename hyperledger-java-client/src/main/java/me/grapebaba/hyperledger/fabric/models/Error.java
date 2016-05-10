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
package me.grapebaba.hyperledger.fabric.models;

import com.google.gson.annotations.SerializedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Model of error.
 */
public class Error {

    private static final Logger LOG = LoggerFactory.getLogger(Error.class);

    @SerializedName("Error")
    private String error;

    Error(final String error) {
        this.error = error;
    }

    /**
     * Builder of Error.
     */
    public static class ErrorBuilder {

        private String error;

        ErrorBuilder() {
        }

        /**
         * Set error.
         *
         * @param error error
         * @return ErrorBuilder
         */
        public ErrorBuilder error(final String error) {
            this.error = error;
            return this;
        }

        /**
         * Build Error.
         *
         * @return Error
         */
        public Error build() {
            return new Error(error);
        }

        @Override
        public java.lang.String toString() {
            return "Error.ErrorBuilder(error=" + this.error + ")";
        }
    }

    /**
     * Create ErrorBuilder.
     *
     * @return ErrorBuilder
     */
    public static ErrorBuilder builder() {
        return new ErrorBuilder();
    }

    /**
     * Get error.
     *
     * @return error
     */
    public String getError() {
        return this.error;
    }

    /**
     * Set error.
     *
     * @param error error
     */
    public void setError(final String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error1 = (Error) o;
        return Objects.equals(error, error1.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error);
    }

    @Override
    public java.lang.String toString() {
        return "Error(error=" + this.getError() + ")";
    }
}
