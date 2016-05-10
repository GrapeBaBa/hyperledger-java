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
 * Model of OK.
 */
public class OK {

    private static final Logger LOG = LoggerFactory.getLogger(OK.class);

    @SerializedName("OK")
    private String ok;

    private String message;

    OK(final String ok, final String message) {
        this.ok = ok;
        this.message = message;
    }

    /**
     * Builder of OK.
     */
    public static class OKBuilder {

        private String ok;

        private String message;

        OKBuilder() {
        }

        /**
         * Get ok.
         *
         * @param ok ok
         * @return OKBuilder
         */
        public OKBuilder ok(final String ok) {
            this.ok = ok;
            return this;
        }

        /**
         * Get message.
         *
         * @param message message
         * @return OKBuilder
         */
        public OKBuilder message(final String message) {
            this.message = message;
            return this;
        }

        /**
         * Build OK.
         *
         * @return OK.
         */
        public OK build() {
            return new OK(ok, message);
        }

        @Override
        public java.lang.String toString() {
            return "OK.OKBuilder(ok=" + this.ok + ", message=" + this.message + ")";
        }
    }

    /**
     * Create OKBuilder.
     *
     * @return OKBuilder
     */
    public static OKBuilder builder() {
        return new OKBuilder();
    }

    /**
     * Get ok.
     *
     * @return ok
     */
    public String getOk() {
        return this.ok;
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
     * Set ok.
     *
     * @param ok ok
     */
    public void setOk(final String ok) {
        this.ok = ok;
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
        OK ok1 = (OK) o;
        return Objects.equals(ok, ok1.ok) &&
                Objects.equals(message, ok1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ok, message);
    }

    @Override
    public java.lang.String toString() {
        return "OK(ok=" + this.getOk() + ", message=" + this.getMessage() + ")";
    }
}
