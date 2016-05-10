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
 * Model of rpc response
 */
public class RpcResponse {

    private static final Logger LOG = LoggerFactory.getLogger(RpcResponse.class);

    private String status;

    private String message;

    RpcResponse(final String status, final String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * Builder of RpcResponse.
     */
    public static class RpcResponseBuilder {

        private String status;

        private String message;

        RpcResponseBuilder() {
        }

        /**
         * Set status.
         *
         * @param status status
         * @return RpcResponseBuilder
         */
        public RpcResponseBuilder status(final String status) {
            this.status = status;
            return this;
        }

        /**
         * Set message.
         *
         * @param message message
         * @return RpcResponseBuilder
         */
        public RpcResponseBuilder message(final String message) {
            this.message = message;
            return this;
        }

        /**
         * Build RpcResponse.
         *
         * @return RpcResponse
         */
        public RpcResponse build() {
            return new RpcResponse(status, message);
        }

        @Override
        public java.lang.String toString() {
            return "RpcResponse.RpcResponseBuilder(status=" + this.status + ", message=" + this.message + ")";
        }
    }

    /**
     * Create RpcResponseBuilder.
     *
     * @return RpcResponseBuilder
     */
    public static RpcResponseBuilder builder() {
        return new RpcResponseBuilder();
    }

    /**
     * Get status.
     *
     * @return status
     */
    public String getStatus() {
        return this.status;
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
     * Get status.
     *
     * @param status status
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Set message.
     *
     * @param message message
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RpcResponse that = (RpcResponse) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }

    @Override
    public java.lang.String toString() {
        return "RpcResponse(status=" + this.getStatus() + ", message=" + this.getMessage() + ")";
    }
}
