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
 * Model of timestamp.
 */
public class Timestamp {

    private static final Logger LOG = LoggerFactory.getLogger(Timestamp.class);

    private long seconds;

    private int nanos;

    Timestamp(final long seconds, final int nanos) {
        this.seconds = seconds;
        this.nanos = nanos;
    }

    /**
     * Builder of Timestamp.
     */
    public static class TimestampBuilder {

        private long seconds;

        private int nanos;

        TimestampBuilder() {
        }

        /**
         * Set seconds.
         *
         * @param seconds seconds
         * @return TimestampBuilder
         */
        public TimestampBuilder seconds(final long seconds) {
            this.seconds = seconds;
            return this;
        }

        /**
         * Set nanos.
         *
         * @param nanos nanos
         * @return TimestampBuilder
         */
        public TimestampBuilder nanos(final int nanos) {
            this.nanos = nanos;
            return this;
        }

        /**
         * Build Timestamp.
         *
         * @return Timestamp
         */
        public Timestamp build() {
            return new Timestamp(seconds, nanos);
        }

        @Override
        public java.lang.String toString() {
            return "Timestamp.TimestampBuilder(seconds=" + this.seconds + ", nanos=" + this.nanos + ")";
        }
    }

    /**
     * Create TimestampBuilder.
     *
     * @return TimestampBuilder
     */
    public static TimestampBuilder builder() {
        return new TimestampBuilder();
    }

    /**
     * Get seconds.
     *
     * @return seconds
     */
    public long getSeconds() {
        return this.seconds;
    }

    /**
     * Get nanos.
     *
     * @return nanos
     */
    public int getNanos() {
        return this.nanos;
    }

    /**
     * Set seconds.
     *
     * @param seconds seconds
     */
    public void setSeconds(final long seconds) {
        this.seconds = seconds;
    }

    /**
     * Set nanos.
     *
     * @param nanos nanos
     */
    public void setNanos(final int nanos) {
        this.nanos = nanos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timestamp timestamp = (Timestamp) o;
        return seconds == timestamp.seconds &&
                nanos == timestamp.nanos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seconds, nanos);
    }

    @Override
    public java.lang.String toString() {
        return "Timestamp(seconds=" + this.getSeconds() + ", nanos=" + this.getNanos() + ")";
    }
}
