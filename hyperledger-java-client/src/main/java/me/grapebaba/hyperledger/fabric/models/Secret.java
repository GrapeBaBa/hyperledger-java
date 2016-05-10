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
 * Model of secret.
 */
public class Secret {

    private static final Logger LOG = LoggerFactory.getLogger(Secret.class);

    private String enrollId;

    private String enrollSecret;

    Secret(final String enrollId, final String enrollSecret) {
        this.enrollId = enrollId;
        this.enrollSecret = enrollSecret;
    }

    /**
     * Builder of Secret.
     */
    public static class SecretBuilder {

        private String enrollId;

        private String enrollSecret;

        SecretBuilder() {
        }

        /**
         * Set enrollId.
         *
         * @param enrollId enrollId
         * @return SecretBuilder
         */
        public SecretBuilder enrollId(final String enrollId) {
            this.enrollId = enrollId;
            return this;
        }

        /**
         * Set enrollSecret.
         *
         * @param enrollSecret enrollSecret
         * @return SecretBuilder
         */
        public SecretBuilder enrollSecret(final String enrollSecret) {
            this.enrollSecret = enrollSecret;
            return this;
        }

        /**
         * Build Secret.
         *
         * @return Secret
         */
        public Secret build() {
            return new Secret(enrollId, enrollSecret);
        }

        @Override
        public java.lang.String toString() {
            return "Secret.SecretBuilder(enrollId=" + this.enrollId + ", enrollSecret=" + this.enrollSecret + ")";
        }
    }

    /**
     * Create SecretBuilder.
     *
     * @return SecretBuilder
     */
    public static SecretBuilder builder() {
        return new SecretBuilder();
    }

    /**
     * Get enrollId.
     *
     * @return enrollId
     */
    public String getEnrollId() {
        return this.enrollId;
    }

    /**
     * Get enrollSecret.
     *
     * @return enrollSecret
     */
    public String getEnrollSecret() {
        return this.enrollSecret;
    }

    /**
     * Set enrollId.
     *
     * @param enrollId enrollId
     */
    public void setEnrollId(final String enrollId) {
        this.enrollId = enrollId;
    }

    /**
     * Set enrollSecret.
     *
     * @param enrollSecret enrollSecret
     */
    public void setEnrollSecret(final String enrollSecret) {
        this.enrollSecret = enrollSecret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secret secret = (Secret) o;
        return Objects.equals(enrollId, secret.enrollId) &&
                Objects.equals(enrollSecret, secret.enrollSecret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollId, enrollSecret);
    }

    @Override
    public java.lang.String toString() {
        return "Secret(enrollId=" + this.getEnrollId() + ", enrollSecret=" + this.getEnrollSecret() + ")";
    }
}
