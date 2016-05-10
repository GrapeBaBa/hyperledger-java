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
 * Model of peer id.
 */
public class PeerID {

    private static final Logger LOG = LoggerFactory.getLogger(PeerID.class);

    private String name;

    PeerID(final String name) {
        this.name = name;
    }

    /**
     * Builder of PeerID
     */
    public static class PeerIDBuilder {

        private String name;

        PeerIDBuilder() {
        }

        /**
         * Set name.
         *
         * @param name name
         * @return PeerIDBuilder
         */
        public PeerIDBuilder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Build PeerID
         *
         * @return PeerID
         */
        public PeerID build() {
            return new PeerID(name);
        }

        @Override
        public java.lang.String toString() {
            return "PeerID.PeerIDBuilder(name=" + this.name + ")";
        }
    }

    /**
     * Create PeerIDBuilder.
     *
     * @return PeerIDBuilder
     */
    public static PeerIDBuilder builder() {
        return new PeerIDBuilder();
    }

    /**
     * Get name.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set name.
     *
     * @param name name
     */
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeerID peerID = (PeerID) o;
        return Objects.equals(name, peerID.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public java.lang.String toString() {
        return "PeerID(name=" + this.getName() + ")";
    }
}
