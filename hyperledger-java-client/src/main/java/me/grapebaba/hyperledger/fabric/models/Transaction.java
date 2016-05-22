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
 * Model of transaction.
 */
public class Transaction {

    private static final Logger LOG = LoggerFactory.getLogger(Transaction.class);

    /**
     * Model of transaction type.
     */
    public enum Type {
        UNDEFINED,
        CHAINCODE_DEPLOY,
        CHAINCODE_INVOKE,
        CHAINCODE_QUERY,
        CHAINCODE_TERMINATE
    }

    private Type type;

    private String chaincodeID;

    private String payload;

    private String metadata;

    private String uuid;

    private Timestamp timestamp;

    private ConfidentialityLevel confidentialityLevel;

    private String nonce;

    private String confidentialityProtocolVersion;

    private String toValidators;

    private String cert;

    private String signature;

    Transaction(final Type type, final String chaincodeID, final String payload, final String metadata, final String uuid, final Timestamp timestamp, final ConfidentialityLevel confidentialityLevel, final String nonce, final String confidentialityProtocolVersion, final String toValidators, final String cert, final String signature) {
        this.type = type;
        this.chaincodeID = chaincodeID;
        this.payload = payload;
        this.metadata = metadata;
        this.uuid = uuid;
        this.timestamp = timestamp;
        this.confidentialityLevel = confidentialityLevel;
        this.nonce = nonce;
        this.confidentialityProtocolVersion = confidentialityProtocolVersion;
        this.toValidators = toValidators;
        this.cert = cert;
        this.signature = signature;
    }

    /**
     * Builder of Transaction.
     */
    public static class TransactionBuilder {
        private Type type;

        private String chaincodeID;

        private String payload;

        private String metadata;

        private String uuid;

        private Timestamp timestamp;

        private ConfidentialityLevel confidentialityLevel;

        private String nonce;

        private String confidentialityProtocolVersion;

        private String toValidators;

        private String cert;

        private String signature;

        TransactionBuilder() {
        }

        /**
         * Set type.
         *
         * @param type type
         * @return TransactionBuilder
         */
        public TransactionBuilder type(final Type type) {
            this.type = type;
            return this;
        }

        /**
         * Set chaincodeID.
         *
         * @param chaincodeID chaincodeID
         * @return TransactionBuilder
         */
        public TransactionBuilder chaincodeID(final String chaincodeID) {
            this.chaincodeID = chaincodeID;
            return this;
        }

        /**
         * Set payload.
         *
         * @param payload payload
         * @return TransactionBuilder
         */
        public TransactionBuilder payload(final String payload) {
            this.payload = payload;
            return this;
        }

        /**
         * Set metadata.
         *
         * @param metadata metadata
         * @return TransactionBuilder
         */
        public TransactionBuilder metadata(final String metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Set uuid.
         *
         * @param uuid uuid
         * @return TransactionBuilder
         */
        public TransactionBuilder uuid(final String uuid) {
            this.uuid = uuid;
            return this;
        }

        /**
         * Set timestamp.
         *
         * @param timestamp timestamp
         * @return TransactionBuilder
         */
        public TransactionBuilder timestamp(final Timestamp timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Set confidentialityLevel.
         *
         * @param confidentialityLevel confidentialityLevel
         * @return TransactionBuilder
         */
        public TransactionBuilder confidentialityLevel(final ConfidentialityLevel confidentialityLevel) {
            this.confidentialityLevel = confidentialityLevel;
            return this;
        }

        /**
         * Set nonce.
         *
         * @param nonce nonce
         * @return TransactionBuilder
         */
        public TransactionBuilder nonce(final String nonce) {
            this.nonce = nonce;
            return this;
        }

        /**
         * Set confidentialityProtocolVersion.
         *
         * @param confidentialityProtocolVersion confidentialityProtocolVersion
         * @return TransactionBuilder
         */
        public TransactionBuilder confidentialityProtocolVersion(final String confidentialityProtocolVersion) {
            this.confidentialityProtocolVersion = confidentialityProtocolVersion;
            return this;
        }

        /**
         * Set toValidators.
         *
         * @param toValidators toValidators
         * @return TransactionBuilder
         */
        public TransactionBuilder toValidators(final String toValidators) {
            this.toValidators = toValidators;
            return this;
        }

        /**
         * Set cert.
         *
         * @param cert cert
         * @return TransactionBuilder
         */
        public TransactionBuilder cert(final String cert) {
            this.cert = cert;
            return this;
        }

        /**
         * Set signature.
         *
         * @param signature signature
         * @return TransactionBuilder
         */
        public TransactionBuilder signature(final String signature) {
            this.signature = signature;
            return this;
        }

        /**
         * Build Transaction.
         *
         * @return Transaction
         */
        public Transaction build() {
            return new Transaction(type, chaincodeID, payload, metadata, uuid, timestamp, confidentialityLevel, nonce, confidentialityProtocolVersion, toValidators, cert, signature);
        }

        @Override
        public java.lang.String toString() {
            return "Transaction.TransactionBuilder(type=" + this.type + ", chaincodeID=" + this.chaincodeID + ", payload=" + this.payload + ", metadata=" + this.metadata + ", uuid=" + this.uuid + ", timestamp=" + this.timestamp + ", confidentialityLevel=" + this.confidentialityLevel + ", nonce=" + this.nonce + ", confidentialityProtocolVersion=" + this.confidentialityProtocolVersion + ", toValidators=" + this.toValidators + ", cert=" + this.cert + ", signature=" + this.signature + ")";
        }
    }

    /**
     * Create TransactionBuilder.
     *
     * @return TransactionBuilder
     */
    public static TransactionBuilder builder() {
        return new TransactionBuilder();
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
    public String getChaincodeID() {
        return this.chaincodeID;
    }

    /**
     * Get payload.
     *
     * @return payload
     */
    public String getPayload() {
        return this.payload;
    }

    /**
     * Get metadata.
     *
     * @return metadata
     */
    public String getMetadata() {
        return this.metadata;
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
     * Get timestamp.
     *
     * @return timestamp
     */
    public Timestamp getTimestamp() {
        return this.timestamp;
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
     * Get nonce.
     *
     * @return nonce
     */
    public String getNonce() {
        return this.nonce;
    }

    /**
     * Get confidentialityProtocolVersion.
     *
     * @return confidentialityProtocolVersion
     */
    public String getConfidentialityProtocolVersion() {
        return this.confidentialityProtocolVersion;
    }

    /**
     * Get toValidators.
     *
     * @return toValidators
     */
    public String getToValidators() {
        return this.toValidators;
    }

    /**
     * Get cert.
     *
     * @return cert
     */
    public String getCert() {
        return this.cert;
    }

    /**
     * Get signature.
     *
     * @return signature
     */
    public String getSignature() {
        return this.signature;
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
    public void setChaincodeID(final String chaincodeID) {
        this.chaincodeID = chaincodeID;
    }

    /**
     * Set payload.
     *
     * @param payload payload
     */
    public void setPayload(final String payload) {
        this.payload = payload;
    }

    /**
     * Set metadata.
     *
     * @param metadata metadata
     */
    public void setMetadata(final String metadata) {
        this.metadata = metadata;
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
     * Set timestamp.
     *
     * @param timestamp timestamp
     */
    public void setTimestamp(final Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Set confidentialityLevel.
     *
     * @param confidentialityLevel confidentialityLevel
     */
    public void setConfidentialityLevel(final ConfidentialityLevel confidentialityLevel) {
        this.confidentialityLevel = confidentialityLevel;
    }

    /**
     * Set nonce.
     *
     * @param nonce nonce
     */
    public void setNonce(final String nonce) {
        this.nonce = nonce;
    }

    /**
     * Set confidentialityProtocolVersion.
     *
     * @param confidentialityProtocolVersion confidentialityProtocolVersion
     */
    public void setConfidentialityProtocolVersion(final String confidentialityProtocolVersion) {
        this.confidentialityProtocolVersion = confidentialityProtocolVersion;
    }

    /**
     * Set toValidators.
     *
     * @param toValidators toValidators
     */
    public void setToValidators(final String toValidators) {
        this.toValidators = toValidators;
    }

    /**
     * Set cert.
     *
     * @param cert cert
     */
    public void setCert(final String cert) {
        this.cert = cert;
    }

    /**
     * Set signature.
     *
     * @param signature signature
     */
    public void setSignature(final String signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return type == that.type &&
                Objects.equals(chaincodeID, that.chaincodeID) &&
                Objects.equals(payload, that.payload) &&
                Objects.equals(metadata, that.metadata) &&
                Objects.equals(uuid, that.uuid) &&
                Objects.equals(timestamp, that.timestamp) &&
                confidentialityLevel == that.confidentialityLevel &&
                Objects.equals(nonce, that.nonce) &&
                Objects.equals(confidentialityProtocolVersion, that.confidentialityProtocolVersion) &&
                Objects.equals(toValidators, that.toValidators) &&
                Objects.equals(cert, that.cert) &&
                Objects.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, chaincodeID, payload, metadata, uuid, timestamp, confidentialityLevel, nonce, confidentialityProtocolVersion, toValidators, cert, signature);
    }

    @Override
    public java.lang.String toString() {
        return "Transaction(type=" + this.getType() + ", chaincodeID=" + this.getChaincodeID() + ", payload=" + this.getPayload() + ", metadata=" + this.getMetadata() + ", uuid=" + this.getUuid() + ", timestamp=" + this.getTimestamp() + ", confidentialityLevel=" + this.getConfidentialityLevel() + ", nonce=" + this.getNonce() + ", confidentialityProtocolVersion=" + this.getConfidentialityProtocolVersion() + ", toValidators=" + this.getToValidators() + ", cert=" + this.getCert() + ", signature=" + this.getSignature() + ")";
    }
}
