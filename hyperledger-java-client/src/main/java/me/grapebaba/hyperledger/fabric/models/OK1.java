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

import java.util.*;

/**
 * Model of OK1.
 */
public class OK1 {

    private static final Logger LOG = LoggerFactory.getLogger(OK1.class);

    @SerializedName("OK")
    private List<String> ok;

    private String message;

    OK1(final List<String> ok, final String message) {
        this.ok = ok;
        this.message = message;
    }

    /**
     * Builder of OK1.
     */
    public static class OK1Builder {

        private List<String> ok;

        private String message;

        OK1Builder() {
        }

        /**
         * Set ok.
         *
         * @param ok ok
         * @return OK1Builder
         */
        public OK1Builder ok(final String ok) {
            if (this.ok == null) this.ok = new ArrayList<>();
            this.ok.add(ok);
            return this;
        }

        /**
         * Set ok.
         *
         * @param ok ok
         * @return OK1Builder
         */
        public OK1Builder ok(final Collection<? extends String> ok) {
            if (this.ok == null) this.ok = new ArrayList<>();
            this.ok.addAll(ok);
            return this;
        }

        /**
         * Clear ok.
         *
         * @return OK1Builder
         */
        public OK1Builder clearOk() {
            if (this.ok != null) this.ok.clear();
            return this;
        }

        /**
         * Set message.
         *
         * @param message message
         * @return OK1Builder
         */
        public OK1Builder message(final String message) {
            this.message = message;
            return this;
        }

        /**
         * Build OK1.
         *
         * @return OK1
         */
        public OK1 build() {
            List<String> ok;
            switch (this.ok == null ? 0 : this.ok.size()) {
                case 0:
                    ok = Collections.emptyList();
                    break;

                case 1:
                    ok = Collections.singletonList(this.ok.get(0));
                    break;

                default:
                    ok = Collections.unmodifiableList(new ArrayList<>(this.ok));
            }
            return new OK1(ok, message);
        }

        @Override
        public java.lang.String toString() {
            return "OK1.OK1Builder(ok=" + this.ok + ", message=" + this.message + ")";
        }
    }

    /**
     * Create OK1Builder.
     *
     * @return OK1Builder
     */
    public static OK1Builder builder() {
        return new OK1Builder();
    }

    /**
     * Get ok.
     *
     * @return ok
     */
    public List<String> getOk() {
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
    public void setOk(final List<String> ok) {
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
        OK1 ok1 = (OK1) o;
        return Objects.equals(ok, ok1.ok) &&
                Objects.equals(message, ok1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ok, message);
    }

    @Override
    public java.lang.String toString() {
        return "OK1(ok=" + this.getOk() + ", message=" + this.getMessage() + ")";
    }
}
