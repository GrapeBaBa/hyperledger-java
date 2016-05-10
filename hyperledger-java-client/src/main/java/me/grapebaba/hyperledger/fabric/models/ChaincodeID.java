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
 * Model of chaincode id.
 */
public class ChaincodeID {

    private static final Logger LOG = LoggerFactory.getLogger(ChaincodeID.class);

    private String path;

    private String name;

    ChaincodeID(final String path, final String name) {
        this.path = path;
        this.name = name;
    }

    /**
     * Builder of ChaincodeIDBuilder.
     */
    public static class ChaincodeIDBuilder {

        private String path;

        private String name;

        ChaincodeIDBuilder() {
        }

        /**
         * Set path.
         *
         * @param path path
         * @return ChaincodeIDBuilder
         */
        public ChaincodeIDBuilder path(final String path) {
            this.path = path;
            return this;
        }

        /**
         * Set name.
         *
         * @param name name
         * @return ChaincodeIDBuilder
         */
        public ChaincodeIDBuilder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Build ChaincodeID.
         *
         * @return ChaincodeID
         */
        public ChaincodeID build() {
            return new ChaincodeID(path, name);
        }

        @Override
        public java.lang.String toString() {
            return "ChaincodeID.ChaincodeIDBuilder(path=" + this.path + ", name=" + this.name + ")";
        }
    }

    /**
     * Create ChaincodeIDBuilder.
     *
     * @return ChaincodeIDBuilder
     */
    public static ChaincodeIDBuilder builder() {
        return new ChaincodeIDBuilder();
    }

    /**
     * Get path.
     *
     * @return path
     */
    public String getPath() {
        return this.path;
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
     * Set path.
     *
     * @param path path
     */
    public void setPath(final String path) {
        this.path = path;
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
        ChaincodeID that = (ChaincodeID) o;
        return Objects.equals(path, that.path) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, name);
    }

    @Override
    public java.lang.String toString() {
        return "ChaincodeID(path=" + this.getPath() + ", name=" + this.getName() + ")";
    }
}
