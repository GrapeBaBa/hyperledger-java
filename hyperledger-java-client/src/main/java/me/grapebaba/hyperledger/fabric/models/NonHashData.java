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

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Model of non-hash data.
 */
public class NonHashData {

    private static final Logger LOG = LoggerFactory.getLogger(NonHashData.class);

    private Timestamp localLedgerCommitTimestamp;

    private List<TransactionResult> transactionResults;

    NonHashData(final Timestamp localLedgerCommitTimestamp, final List<TransactionResult> transactionResults) {
        this.localLedgerCommitTimestamp = localLedgerCommitTimestamp;
        this.transactionResults = transactionResults;
    }

    /**
     * Builder of NonHashData.
     */
    public static class NonHashDataBuilder {

        private Timestamp localLedgerCommitTimestamp;

        private java.util.ArrayList<TransactionResult> transactionResults;

        NonHashDataBuilder() {
        }

        /**
         * Set localLedgerCommitTimestamp.
         *
         * @param localLedgerCommitTimestamp localLedgerCommitTimestamp
         * @return NonHashDataBuilder
         */
        public NonHashDataBuilder localLedgerCommitTimestamp(final Timestamp localLedgerCommitTimestamp) {
            this.localLedgerCommitTimestamp = localLedgerCommitTimestamp;
            return this;
        }

        /**
         * Set transactionResult.
         *
         * @param transactionResult transactionResult
         * @return NonHashDataBuilder
         */
        public NonHashDataBuilder transactionResult(final TransactionResult transactionResult) {
            if (this.transactionResults == null) this.transactionResults = new java.util.ArrayList<TransactionResult>();
            this.transactionResults.add(transactionResult);
            return this;
        }

        /**
         * Set a set of transactionResult.
         *
         * @param transactionResults transactionResults
         * @return NonHashDataBuilder
         */
        public NonHashDataBuilder transactionResults(final Collection<? extends TransactionResult> transactionResults) {
            if (this.transactionResults == null) this.transactionResults = new java.util.ArrayList<>();
            this.transactionResults.addAll(transactionResults);
            return this;
        }

        /**
         * Clear transactionResults.
         *
         * @return NonHashDataBuilder
         */
        public NonHashDataBuilder clearTransactionResults() {
            if (this.transactionResults != null) this.transactionResults.clear();
            return this;
        }

        /**
         * Build NonHashData.
         *
         * @return NonHashData
         */
        public NonHashData build() {
            List<TransactionResult> transactionResults;
            switch (this.transactionResults == null ? 0 : this.transactionResults.size()) {
                case 0:
                    transactionResults = Collections.emptyList();
                    break;

                case 1:
                    transactionResults = Collections.singletonList(this.transactionResults.get(0));
                    break;

                default:
                    transactionResults = Collections.unmodifiableList(new java.util.ArrayList<>(this.transactionResults));
            }
            return new NonHashData(localLedgerCommitTimestamp, transactionResults);
        }

        @Override
        public java.lang.String toString() {
            return "NonHashData.NonHashDataBuilder(localLedgerCommitTimestamp=" + this.localLedgerCommitTimestamp + ", transactionResults=" + this.transactionResults + ")";
        }
    }

    /**
     * Create NonHashDataBuilder.
     *
     * @return NonHashDataBuilder
     */
    public static NonHashDataBuilder builder() {
        return new NonHashDataBuilder();
    }

    /**
     * Get localLedgerCommitTimestamp.
     *
     * @return localLedgerCommitTimestamp
     */
    public Timestamp getLocalLedgerCommitTimestamp() {
        return this.localLedgerCommitTimestamp;
    }

    /**
     * Get transactionResults.
     *
     * @return transactionResults
     */
    public List<TransactionResult> getTransactionResults() {
        return this.transactionResults;
    }

    /**
     * Set localLedgerCommitTimestamp.
     *
     * @param localLedgerCommitTimestamp localLedgerCommitTimestamp
     */
    public void setLocalLedgerCommitTimestamp(final Timestamp localLedgerCommitTimestamp) {
        this.localLedgerCommitTimestamp = localLedgerCommitTimestamp;
    }

    /**
     * Set a set of transactionResult.
     *
     * @param transactionResults transactionResults
     */
    public void setTransactionResults(final List<TransactionResult> transactionResults) {
        this.transactionResults = transactionResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonHashData that = (NonHashData) o;
        return Objects.equals(localLedgerCommitTimestamp, that.localLedgerCommitTimestamp) &&
                Objects.equals(transactionResults, that.transactionResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localLedgerCommitTimestamp, transactionResults);
    }

    @Override
    public java.lang.String toString() {
        return "NonHashData(localLedgerCommitTimestamp=" + this.getLocalLedgerCommitTimestamp() + ", transactionResults=" + this.getTransactionResults() + ")";
    }
}
