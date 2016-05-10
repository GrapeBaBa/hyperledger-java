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
 * Model of chaincode operation result.
 */
public class ChaincodeOpResult {

    private static final Logger LOG = LoggerFactory.getLogger(ChaincodeOpResult.class);

    private String jsonrpc;

    private long id;

    private RpcError error;

    private RpcResponse result;

    ChaincodeOpResult(final String jsonrpc, final long id, final RpcError error, final RpcResponse result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.error = error;
        this.result = result;
    }

    /**
     * Builder of ChaincodeOpResult.
     */
    public static class ChaincodeOpResultBuilder {

        private String jsonrpc;

        private long id;

        private RpcError error;

        private RpcResponse result;

        ChaincodeOpResultBuilder() {
        }

        /**
         * Set jsonrpc.
         *
         * @param jsonrpc jsonrpc
         * @return ChaincodeOpResultBuilder
         */
        public ChaincodeOpResultBuilder jsonrpc(final String jsonrpc) {
            this.jsonrpc = jsonrpc;
            return this;
        }

        /**
         * Set id.
         *
         * @param id id
         * @return ChaincodeOpResultBuilder
         */
        public ChaincodeOpResultBuilder id(final long id) {
            this.id = id;
            return this;
        }

        /**
         * Set error.
         *
         * @param error error
         * @return ChaincodeOpResultBuilder
         */
        public ChaincodeOpResultBuilder error(final RpcError error) {
            this.error = error;
            return this;
        }

        /**
         * Set result.
         *
         * @param result result
         * @return ChaincodeOpResultBuilder
         */
        public ChaincodeOpResultBuilder result(final RpcResponse result) {
            this.result = result;
            return this;
        }

        /**
         * Build ChaincodeOpResult.
         *
         * @return ChaincodeOpResult
         */
        public ChaincodeOpResult build() {
            return new ChaincodeOpResult(jsonrpc, id, error, result);
        }

        @Override
        public java.lang.String toString() {
            return "ChaincodeOpResult.ChaincodeOpResultBuilder(jsonrpc=" + this.jsonrpc + ", id=" + this.id + ", error=" + this.error + ", result=" + this.result + ")";
        }
    }

    /**
     * Create ChaincodeOpResultBuilder.
     *
     * @return ChaincodeOpResultBuilder
     */
    public static ChaincodeOpResultBuilder builder() {
        return new ChaincodeOpResultBuilder();
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
     * Get id.
     *
     * @return id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Get error.
     *
     * @return result
     */
    public RpcError getError() {
        return this.error;
    }

    /**
     * Get result.
     *
     * @return result
     */
    public RpcResponse getResult() {
        return this.result;
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
     * Set id.
     *
     * @param id id
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * Set error.
     *
     * @param error error
     */
    public void setError(final RpcError error) {
        this.error = error;
    }

    /**
     * Set result.
     *
     * @param result result
     */
    public void setResult(final RpcResponse result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChaincodeOpResult that = (ChaincodeOpResult) o;
        return id == that.id &&
                Objects.equals(jsonrpc, that.jsonrpc) &&
                Objects.equals(error, that.error) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jsonrpc, id, error, result);
    }

    @Override
    public java.lang.String toString() {
        return "ChaincodeOpResult(jsonrpc=" + this.getJsonrpc() + ", id=" + this.getId() + ", error=" + this.getError() + ", result=" + this.getResult() + ")";
    }
}
