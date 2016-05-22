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
 * Model of chaincode spec.
 */
public class ChaincodeSpec {

    private static final Logger LOG = LoggerFactory.getLogger(ChaincodeSpec.class);

    /**
     * Chaincode type.
     */
    public enum Type {
        UNDEFINED,
        GOLANG,
        NODE
    }

    private Type type;

    private ChaincodeID chaincodeID;

    private ChaincodeInput ctorMsg;

    private String secureContext;

    private ConfidentialityLevel confidentialityLevel;

    ChaincodeSpec(final Type type, final ChaincodeID chaincodeID, final ChaincodeInput ctorMsg, final String secureContext, final ConfidentialityLevel confidentialityLevel) {
        this.type = type;
        this.chaincodeID = chaincodeID;
        this.ctorMsg = ctorMsg;
        this.secureContext = secureContext;
        this.confidentialityLevel = confidentialityLevel;
    }

    /**
     * Builder of ChaincodeSpec.
     */
    public static class ChaincodeSpecBuilder {

        private Type type;

        private ChaincodeID chaincodeID;

        private ChaincodeInput ctorMsg;

        private String secureContext;

        private ConfidentialityLevel confidentialityLevel;

        ChaincodeSpecBuilder() {
        }

        /**
         * Set type.
         *
         * @param type type
         * @return ChaincodeSpecBuilder
         */
        public ChaincodeSpecBuilder type(final Type type) {
            this.type = type;
            return this;
        }

        /**
         * Set chaincodeID
         *
         * @param chaincodeID chaincodeID
         * @return ChaincodeSpecBuilder
         */
        public ChaincodeSpecBuilder chaincodeID(final ChaincodeID chaincodeID) {
            this.chaincodeID = chaincodeID;
            return this;
        }

        /**
         * Set ctorMsg.
         *
         * @param ctorMsg ctorMsg
         * @return ChaincodeSpecBuilder
         */
        public ChaincodeSpecBuilder ctorMsg(final ChaincodeInput ctorMsg) {
            this.ctorMsg = ctorMsg;
            return this;
        }

        /**
         * Set secureContext.
         *
         * @param secureContext secureContext
         * @return ChaincodeSpecBuilder
         */
        public ChaincodeSpecBuilder secureContext(final String secureContext) {
            this.secureContext = secureContext;
            return this;
        }

        /**
         * Set confidentialityLevel.
         *
         * @param confidentialityLevel confidentialityLevel
         * @return ChaincodeSpecBuilder
         */
        public ChaincodeSpecBuilder confidentialityLevel(final ConfidentialityLevel confidentialityLevel) {
            this.confidentialityLevel = confidentialityLevel;
            return this;
        }

        /**
         * Create ChaincodeSpec.
         *
         * @return ChaincodeSpec
         */
        public ChaincodeSpec build() {
            return new ChaincodeSpec(type, chaincodeID, ctorMsg, secureContext, confidentialityLevel);
        }

        @Override
        public java.lang.String toString() {
            return "ChaincodeSpec.ChaincodeSpecBuilder(type=" + this.type + ", chaincodeID=" + this.chaincodeID + ", ctorMsg=" + this.ctorMsg + ", secureContext=" + this.secureContext + ", confidentialityLevel=" + this.confidentialityLevel + ")";
        }
    }

    /**
     * Create ChaincodeSpecBuilder.
     *
     * @return ChaincodeSpecBuilder
     */
    public static ChaincodeSpecBuilder builder() {
        return new ChaincodeSpecBuilder();
    }

    /**
     * Get type.
     *
     * @return type
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Get chaincodeID.
     *
     * @return chaincodeID
     */
    public ChaincodeID getChaincodeID() {
        return this.chaincodeID;
    }

    /**
     * Get ctorMsg.
     *
     * @return ctorMsg
     */
    public ChaincodeInput getCtorMsg() {
        return this.ctorMsg;
    }

    /**
     * Get secureContext.
     *
     * @return secureContext
     */
    public String getSecureContext() {
        return this.secureContext;
    }

    /**
     * Get confidentialityLevel.
     *
     * @return confidentialityLevel
     */
    public ConfidentialityLevel getConfidentialityLevel() {
        return this.confidentialityLevel;
    }

    /**
     * Set type.
     *
     * @param type type
     */
    public void setType(final Type type) {
        this.type = type;
    }

    /**
     * Set chaincodeID.
     *
     * @param chaincodeID chaincodeID
     */
    public void setChaincodeID(final ChaincodeID chaincodeID) {
        this.chaincodeID = chaincodeID;
    }

    /**
     * Set ctorMsg.
     *
     * @param ctorMsg ctorMsg
     */
    public void setCtorMsg(final ChaincodeInput ctorMsg) {
        this.ctorMsg = ctorMsg;
    }

    /**
     * Set secureContext.
     *
     * @param secureContext secureContext
     */
    public void setSecureContext(final String secureContext) {
        this.secureContext = secureContext;
    }

    /**
     * Set confidentialityLevel.
     *
     * @param confidentialityLevel confidentialityLevel
     */
    public void setConfidentialityLevel(final ConfidentialityLevel confidentialityLevel) {
        this.confidentialityLevel = confidentialityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChaincodeSpec that = (ChaincodeSpec) o;
        return type == that.type &&
                Objects.equals(chaincodeID, that.chaincodeID) &&
                Objects.equals(ctorMsg, that.ctorMsg) &&
                Objects.equals(secureContext, that.secureContext) &&
                confidentialityLevel == that.confidentialityLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, chaincodeID, ctorMsg, secureContext, confidentialityLevel);
    }

    @Override
    public java.lang.String toString() {
        return "ChaincodeSpec(type=" + this.getType() + ", chaincodeID=" + this.getChaincodeID() + ", ctorMsg=" + this.getCtorMsg() + ", secureContext=" + this.getSecureContext() + ", confidentialityLevel=" + this.getConfidentialityLevel() + ")";
    }
}
