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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Model of chaincode input.
 */
public class ChaincodeInput {

    private static final Logger LOG = LoggerFactory.getLogger(ChaincodeInput.class);

    private String function;

    private List<String> args;

    ChaincodeInput(final String function, final List<String> args) {
        this.function = function;
        this.args = args;
    }

    /**
     * Builder of ChaincodeInput.
     */
    public static class ChaincodeInputBuilder {

        private String function;

        private List<String> args;

        ChaincodeInputBuilder() {
        }

        /**
         * Set function.
         *
         * @param function function
         * @return ChaincodeInputBuilder
         */
        public ChaincodeInputBuilder function(final String function) {
            this.function = function;
            return this;
        }

        /**
         * Set arg.
         *
         * @param arg arg
         * @return ChaincodeInputBuilder
         */
        public ChaincodeInputBuilder arg(final String arg) {
            if (this.args == null) this.args = new ArrayList<>();
            this.args.add(arg);
            return this;
        }

        /**
         * Set a set of arg.
         *
         * @param args args
         * @return ChaincodeInputBuilder
         */
        public ChaincodeInputBuilder args(final java.util.Collection<? extends String> args) {
            if (this.args == null) this.args = new ArrayList<>();
            this.args.addAll(args);
            return this;
        }

        /**
         * Clear args.
         *
         * @return ChaincodeInputBuilder
         */
        public ChaincodeInputBuilder clearArgs() {
            if (this.args != null) this.args.clear();
            return this;
        }

        /**
         * Build ChaincodeInput.
         *
         * @return ChaincodeInput
         */
        public ChaincodeInput build() {
            List<String> args;
            switch (this.args == null ? 0 : this.args.size()) {
                case 0:
                    args = Collections.emptyList();
                    break;

                case 1:
                    args = Collections.singletonList(this.args.get(0));
                    break;

                default:
                    args = Collections.unmodifiableList(new ArrayList<>(this.args));
            }
            return new ChaincodeInput(function, args);
        }

        @Override
        public java.lang.String toString() {
            return "ChaincodeInput.ChaincodeInputBuilder(function=" + this.function + ", args=" + this.args + ")";
        }
    }

    /**
     * Create ChaincodeInputBuilder.
     *
     * @return ChaincodeInputBuilder
     */
    public static ChaincodeInputBuilder builder() {
        return new ChaincodeInputBuilder();
    }

    /**
     * Get function.
     *
     * @return function
     */
    public String getFunction() {
        return this.function;
    }

    /**
     * Get args.
     *
     * @return args
     */
    public List<String> getArgs() {
        return this.args;
    }

    /**
     * Set function.
     *
     * @param function function
     */
    public void setFunction(final String function) {
        this.function = function;
    }

    /**
     * Set args.
     *
     * @param args args
     */
    public void setArgs(final List<String> args) {
        this.args = args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChaincodeInput that = (ChaincodeInput) o;
        return Objects.equals(function, that.function) &&
                Objects.equals(args, that.args);
    }

    @Override
    public int hashCode() {
        return Objects.hash(function, args);
    }

    @Override
    public java.lang.String toString() {
        return "ChaincodeInput(function=" + this.getFunction() + ", args=" + this.getArgs() + ")";
    }
}
