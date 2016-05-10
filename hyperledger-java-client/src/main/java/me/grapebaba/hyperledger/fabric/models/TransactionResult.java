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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Model of transaction result.
 */
public class TransactionResult {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionResult.class);

    private String uuid;

    private String result;

    private int errorCode;

    private String error;

    TransactionResult(final String uuid, final String result, final int errorCode, final String error) {
        this.uuid = uuid;
        this.result = result;
        this.errorCode = errorCode;
        this.error = error;
    }

    /**
     * Builder of TransactionResult.
     */
    public static class TransactionResultBuilder {

        private String uuid;

        private String result;

        private int errorCode;

        private String error;

        TransactionResultBuilder() {
        }

        /**
         * Set uuid.
         *
         * @param uuid uuid
         * @return TransactionResultBuilder
         */
        public TransactionResultBuilder uuid(final String uuid) {
            this.uuid = uuid;
            return this;
        }

        /**
         * Set result.
         *
         * @param result result
         * @return TransactionResultBuilder
         */
        public TransactionResultBuilder result(final String result) {
            this.result = result;
            return this;
        }

        /**
         * Set errorCode.
         *
         * @param errorCode errorCode
         * @return TransactionResultBuilder
         */
        public TransactionResultBuilder errorCode(final int errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        /**
         * Set error.
         *
         * @param error error
         * @return TransactionResultBuilder
         */
        public TransactionResultBuilder error(final String error) {
            this.error = error;
            return this;
        }

        /**
         * Build TransactionResult.
         *
         * @return TransactionResult
         */
        public TransactionResult build() {
            return new TransactionResult(uuid, result, errorCode, error);
        }

        @Override
        public java.lang.String toString() {
            return "TransactionResult.TransactionResultBuilder(uuid=" + this.uuid + ", result=" + this.result + ", errorCode=" + this.errorCode + ", error=" + this.error + ")";
        }
    }

    /**
     * Create TransactionResultBuilder.
     *
     * @return TransactionResultBuilder
     */
    public static TransactionResultBuilder builder() {
        return new TransactionResultBuilder();
    }

    /**
     * Get uuid.
     *
     * @return uuid
     */
    public String getUuid() {
        return this.uuid;
    }

    /**
     * Get result.
     *
     * @return result
     */
    public String getResult() {
        return this.result;
    }

    /**
     * Get errorCode.
     *
     * @return errorCode
     */
    public int getErrorCode() {
        return this.errorCode;
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
     * Set uuid.
     *
     * @param uuid uuid
     */
    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    /**
     * Set result.
     *
     * @param result result
     */
    public void setResult(final String result) {
        this.result = result;
    }

    /**
     * Set errorCode.
     *
     * @param errorCode errorCode
     */
    public void setErrorCode(final int errorCode) {
        this.errorCode = errorCode;
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
        TransactionResult that = (TransactionResult) o;
        return errorCode == that.errorCode &&
                Objects.equals(uuid, that.uuid) &&
                Objects.equals(result, that.result) &&
                Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, result, errorCode, error);
    }

    @Override
    public java.lang.String toString() {
        return "TransactionResult(uuid=" + this.getUuid() + ", result=" + this.getResult() + ", errorCode=" + this.getErrorCode() + ", error=" + this.getError() + ")";
    }
}
