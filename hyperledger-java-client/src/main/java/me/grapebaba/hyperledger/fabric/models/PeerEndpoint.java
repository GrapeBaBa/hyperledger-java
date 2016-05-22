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
 * Model of peer endpoint.
 */
public class PeerEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(PeerEndpoint.class);

    /**
     * Peer endpoint type.
     */
    public enum Type {
        UNDEFINED,
        VALIDATOR,
        NON_VALIDATOR
    }

    @SerializedName("ID")
    private PeerID id;

    private String address;

    private Type type;

    private String pkiID;

    PeerEndpoint(final PeerID id, final String address, final Type type, final String pkiID) {
        this.id = id;
        this.address = address;
        this.type = type;
        this.pkiID = pkiID;
    }

    /**
     * Builder of PeerEndpoint.
     */
    public static class PeerEndpointBuilder {

        private PeerID id;

        private String address;

        private Type type;

        private String pkiID;

        PeerEndpointBuilder() {
        }

        /**
         * Set id.
         *
         * @param id id
         * @return PeerEndpointBuilder
         */
        public PeerEndpointBuilder id(final PeerID id) {
            this.id = id;
            return this;
        }

        /**
         * Set address.
         *
         * @param address address
         * @return PeerEndpointBuilder
         */
        public PeerEndpointBuilder address(final String address) {
            this.address = address;
            return this;
        }

        /**
         * Set type.
         *
         * @param type type
         * @return PeerEndpointBuilder
         */
        public PeerEndpointBuilder type(final Type type) {
            this.type = type;
            return this;
        }

        /**
         * Set pkiID.
         *
         * @param pkiID pkiID
         * @return PeerEndpointBuilder
         */
        public PeerEndpointBuilder pkiID(final String pkiID) {
            this.pkiID = pkiID;
            return this;
        }

        /**
         * Build PeerEndpoint.
         *
         * @return PeerEndpoint
         */
        public PeerEndpoint build() {
            return new PeerEndpoint(id, address, type, pkiID);
        }

        @Override
        public java.lang.String toString() {
            return "PeerEndpoint.PeerEndpointBuilder(id=" + this.id + ", address=" + this.address + ", type=" + this.type + ", pkiID=" + this.pkiID + ")";
        }
    }

    /**
     * Create PeerEndpointBuilder.
     *
     * @return PeerEndpointBuilder
     */
    public static PeerEndpointBuilder builder() {
        return new PeerEndpointBuilder();
    }

    /**
     * Get id.
     *
     * @return id
     */
    public PeerID getId() {
        return this.id;
    }

    /**
     * Get address.
     *
     * @return address
     */
    public String getAddress() {
        return this.address;
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
     * Get pkiID.
     *
     * @return pkiID
     */
    public String getPkiID() {
        return this.pkiID;
    }

    /**
     * Set id.
     *
     * @param id id
     */
    public void setId(final PeerID id) {
        this.id = id;
    }

    /**
     * Set address.
     *
     * @param address address
     */
    public void setAddress(final String address) {
        this.address = address;
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
     * Set pkiID.
     *
     * @param pkiID pkiID
     */
    public void setPkiID(final String pkiID) {
        this.pkiID = pkiID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeerEndpoint that = (PeerEndpoint) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(address, that.address) &&
                type == that.type &&
                Objects.equals(pkiID, that.pkiID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, type, pkiID);
    }

    @Override
    public java.lang.String toString() {
        return "PeerEndpoint(id=" + this.getId() + ", address=" + this.getAddress() + ", type=" + this.getType() + ", pkiID=" + this.getPkiID() + ")";
    }
}
