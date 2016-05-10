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

import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Model of chaincode operation payload.
 */
public class ChaincodeOpPayload {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ChaincodeOpPayload.class);

    private String jsonrpc;

    private String method;

    private ChaincodeSpec params;

    private long id;

    ChaincodeOpPayload(final String jsonrpc, final String method, final ChaincodeSpec params, final long id) {
        this.jsonrpc = jsonrpc;
        this.method = method;
        this.params = params;
        this.id = id;
    }

    public static class ChaincodeOpPayloadBuilder {

        private String jsonrpc;

        private String method;

        private ChaincodeSpec params;

        private long id;

        ChaincodeOpPayloadBuilder() {
        }

        /**
         * Set jsonrpc.
         *
         * @param jsonrpc jsonrpc
         * @return ChaincodeOpPayloadBuilder
         */
        public ChaincodeOpPayloadBuilder jsonrpc(final String jsonrpc) {
            this.jsonrpc = jsonrpc;
            return this;
        }

        /**
         * Set method.
         *
         * @param method method
         * @return ChaincodeOpPayloadBuilder
         */
        public ChaincodeOpPayloadBuilder method(final String method) {
            this.method = method;
            return this;
        }

        /**
         * Set params.
         *
         * @param params params
         * @return ChaincodeOpPayloadBuilder
         */
        public ChaincodeOpPayloadBuilder params(final ChaincodeSpec params) {
            this.params = params;
            return this;
        }

        /**
         * Set id.
         *
         * @param id id
         * @return ChaincodeOpPayloadBuilder
         */
        public ChaincodeOpPayloadBuilder id(final long id) {
            this.id = id;
            return this;
        }

        /**
         * Create ChaincodeOpPayload.
         *
         * @return ChaincodeOpPayload
         */
        public ChaincodeOpPayload build() {
            return new ChaincodeOpPayload(jsonrpc, method, params, id);
        }

        @Override
        public java.lang.String toString() {
            return "ChaincodeOpPayload.ChaincodeOpPayloadBuilder(jsonrpc=" + this.jsonrpc + ", method=" + this.method + ", params=" + this.params + ", id=" + this.id + ")";
        }
    }

    /**
     * Create ChaincodeOpPayloadBuilder.
     *
     * @return ChaincodeOpPayloadBuilder
     */
    public static ChaincodeOpPayloadBuilder builder() {
        return new ChaincodeOpPayloadBuilder();
    }

    /**
     * Get jsonrpc.
     *
     * @return jsonrpc
     */
    public String getJsonrpc() {
        return this.jsonrpc;
    }

    /**
     * Get method.
     *
     * @return method
     */
    public String getMethod() {
        return this.method;
    }

    /**
     * Get params.
     *
     * @return params
     */
    public ChaincodeSpec getParams() {
        return this.params;
    }

    /**
     * Get id.
     *
     * @return id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Set jsonrpc.
     *
     * @param jsonrpc jsonrpc
     */
    public void setJsonrpc(final String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    /**
     * Set method.
     *
     * @param method method
     */
    public void setMethod(final String method) {
        this.method = method;
    }

    /**
     * Set params.
     *
     * @param params params
     */
    public void setParams(final ChaincodeSpec params) {
        this.params = params;
    }

    /**
     * Set id.
     *
     * @param id id
     */
    public void setId(final long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChaincodeOpPayload that = (ChaincodeOpPayload) o;
        return id == that.id &&
                Objects.equals(jsonrpc, that.jsonrpc) &&
                Objects.equals(method, that.method) &&
                Objects.equals(params, that.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jsonrpc, method, params, id);
    }

    @Override
    public java.lang.String toString() {
        return "ChaincodeOpPayload(jsonrpc=" + this.getJsonrpc() + ", method=" + this.getMethod() + ", params=" + this.getParams() + ", id=" + this.getId() + ")";
    }
}
