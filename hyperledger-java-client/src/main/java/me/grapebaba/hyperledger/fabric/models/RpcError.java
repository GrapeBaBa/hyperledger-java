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
 * Model of rpc error.
 */
public class RpcError {

    private static final Logger LOG = LoggerFactory.getLogger(RpcError.class);

    private long code;

    private String message;

    private String data;

    RpcError(final long code, final String message, final String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Builder of RpcError.
     */
    public static class RpcErrorBuilder {

        private long code;

        private String message;

        private String data;

        RpcErrorBuilder() {
        }

        /**
         * Set code.
         *
         * @param code code
         * @return RpcErrorBuilder
         */
        public RpcErrorBuilder code(final long code) {
            this.code = code;
            return this;
        }

        /**
         * Set message.
         *
         * @param message message
         * @return RpcErrorBuilder
         */
        public RpcErrorBuilder message(final String message) {
            this.message = message;
            return this;
        }

        /**
         * Set data.
         *
         * @param data data
         * @return RpcErrorBuilder
         */
        public RpcErrorBuilder data(final String data) {
            this.data = data;
            return this;
        }

        /**
         * Build RpcError.
         *
         * @return RpcError
         */
        public RpcError build() {
            return new RpcError(code, message, data);
        }

        @Override
        public java.lang.String toString() {
            return "RpcError.RpcErrorBuilder(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
        }
    }

    /**
     * Create RpcErrorBuilder.
     *
     * @return RpcErrorBuilder
     */
    public static RpcErrorBuilder builder() {
        return new RpcErrorBuilder();
    }

    /**
     * Get code.
     *
     * @return code
     */
    public long getCode() {
        return this.code;
    }

    /**
     * Get message.
     *
     * @return message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Get data.
     *
     * @return data
     */
    public String getData() {
        return this.data;
    }

    /**
     * Set code.
     *
     * @param code code
     */
    public void setCode(final long code) {
        this.code = code;
    }

    /**
     * Set message.
     *
     * @param message message
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Set data.
     *
     * @param data data
     */
    public void setData(final String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RpcError rpcError = (RpcError) o;
        return code == rpcError.code &&
                Objects.equals(message, rpcError.message) &&
                Objects.equals(data, rpcError.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }

    @Override
    public java.lang.String toString() {
        return "RpcError(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}
