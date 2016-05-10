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

import java.util.*;

/**
 * Model of Block.
 */
public class Block {

    private static final Logger LOG = LoggerFactory.getLogger(Block.class);

    private List<Transaction> transactions;

    private Timestamp timestamp;

    private String transactionsHash;

    private String stateHash;

    private String previousBlockHash;

    private String consensusMetadata;

    private NonHashData nonHashData;

    Block(final List<Transaction> transactions, final Timestamp timestamp, final String transactionsHash, final String stateHash, final String previousBlockHash, final String consensusMetadata, final NonHashData nonHashData) {
        this.transactions = transactions;
        this.timestamp = timestamp;
        this.transactionsHash = transactionsHash;
        this.stateHash = stateHash;
        this.previousBlockHash = previousBlockHash;
        this.consensusMetadata = consensusMetadata;
        this.nonHashData = nonHashData;
    }

    /**
     * Builder of Block.
     */
    public static class BlockBuilder {
        private List<Transaction> transactions;

        private Timestamp timestamp;

        private String transactionsHash;

        private String stateHash;

        private String previousBlockHash;

        private String consensusMetadata;

        private NonHashData nonHashData;

        BlockBuilder() {
        }

        /**
         * Set transaction.
         *
         * @param transaction transaction
         * @return BlockBuilder
         */
        public BlockBuilder transaction(final Transaction transaction) {
            if (this.transactions == null) {
                this.transactions = new ArrayList<>();
            }
            this.transactions.add(transaction);
            return this;
        }

        /**
         * Set a set of transaction.
         *
         * @param transactions transactions
         * @return BlockBuilder
         */
        public BlockBuilder transactions(final Collection<? extends Transaction> transactions) {
            if (this.transactions == null) {
                this.transactions = new ArrayList<>();
            }
            this.transactions.addAll(transactions);
            return this;
        }

        /**
         * Clear transactions.
         *
         * @return BlockBuilder
         */
        public BlockBuilder clearTransactions() {
            if (this.transactions != null) {
                this.transactions.clear();
            }
            return this;
        }

        /**
         * Set timestamp.
         *
         * @param timestamp timestamp
         * @return BlockBuilder
         */
        public BlockBuilder timestamp(final Timestamp timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Set transactionsHash.
         *
         * @param transactionsHash transactionsHash
         * @return BlockBuilder
         */
        public BlockBuilder transactionsHash(final String transactionsHash) {
            this.transactionsHash = transactionsHash;
            return this;
        }

        /**
         * Set stateHash.
         *
         * @param stateHash stateHash
         * @return BlockBuilder
         */
        public BlockBuilder stateHash(final String stateHash) {
            this.stateHash = stateHash;
            return this;
        }

        /**
         * Set previousBlockHash.
         *
         * @param previousBlockHash previousBlockHash
         * @return BlockBuilder
         */
        public BlockBuilder previousBlockHash(final String previousBlockHash) {
            this.previousBlockHash = previousBlockHash;
            return this;
        }

        /**
         * Set consensusMetadata.
         *
         * @param consensusMetadata consensusMetadata
         * @return BlockBuilder
         */
        public BlockBuilder consensusMetadata(final String consensusMetadata) {
            this.consensusMetadata = consensusMetadata;
            return this;
        }

        /**
         * Set nonHashData
         *
         * @param nonHashData nonHashData
         * @return BlockBuilder
         */
        public BlockBuilder nonHashData(final NonHashData nonHashData) {
            this.nonHashData = nonHashData;
            return this;
        }

        /**
         * Build Block.
         *
         * @return Block
         */
        public Block build() {
            List<Transaction> transactions;
            switch (this.transactions == null ? 0 : this.transactions.size()) {
                case 0:
                    transactions = Collections.emptyList();
                    break;

                case 1:
                    transactions = Collections.singletonList(this.transactions.get(0));
                    break;

                default:
                    transactions = Collections.unmodifiableList(new ArrayList<>(this.transactions));
            }
            return new Block(transactions, timestamp, transactionsHash, stateHash, previousBlockHash, consensusMetadata, nonHashData);
        }

        @Override
        public String toString() {
            return "Block.BlockBuilder(transactions=" + this.transactions + ", timestamp=" + this.timestamp + ", transactionsHash=" + this.transactionsHash + ", stateHash=" + this.stateHash + ", previousBlockHash=" + this.previousBlockHash + ", consensusMetadata=" + this.consensusMetadata + ", nonHashData=" + this.nonHashData + ")";
        }
    }

    /**
     * Create block builder.
     *
     * @return BlockBuilder
     */
    public static BlockBuilder builder() {
        return new BlockBuilder();
    }

    /**
     * Get transactions.
     *
     * @return transactions
     */
    public List<Transaction> getTransactions() {
        return this.transactions;
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
     * Get transactionsHash.
     *
     * @return transactionsHash
     */
    public String getTransactionsHash() {
        return this.transactionsHash;
    }

    /**
     * Get stateHash.
     *
     * @return stateHash
     */
    public String getStateHash() {
        return this.stateHash;
    }

    /**
     * Get previousBlockHash.
     *
     * @return previousBlockHash
     */
    public String getPreviousBlockHash() {
        return this.previousBlockHash;
    }

    /**
     * Get consensusMetadata.
     *
     * @return consensusMetadata
     */
    public String getConsensusMetadata() {
        return this.consensusMetadata;
    }

    /**
     * Get nonHashData.
     *
     * @return nonHashData
     */
    public NonHashData getNonHashData() {
        return this.nonHashData;
    }

    /**
     * Set a set of transaction.
     *
     * @param transactions transactions
     */
    public void setTransactions(final List<Transaction> transactions) {
        this.transactions = transactions;
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
     * Set transactionsHash.
     *
     * @param transactionsHash transactionsHash
     */
    public void setTransactionsHash(final String transactionsHash) {
        this.transactionsHash = transactionsHash;
    }

    /**
     * Set stateHash.
     *
     * @param stateHash stateHash
     */
    public void setStateHash(final String stateHash) {
        this.stateHash = stateHash;
    }

    /**
     * Set previousBlockHash.
     *
     * @param previousBlockHash previousBlockHash
     */
    public void setPreviousBlockHash(final String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    /**
     * Set consensusMetadata.
     *
     * @param consensusMetadata consensusMetadata
     */
    public void setConsensusMetadata(final String consensusMetadata) {
        this.consensusMetadata = consensusMetadata;
    }

    /**
     * Set nonHashData.
     *
     * @param nonHashData nonHashData
     */
    public void setNonHashData(final NonHashData nonHashData) {
        this.nonHashData = nonHashData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(transactions, block.transactions) &&
                Objects.equals(timestamp, block.timestamp) &&
                Objects.equals(transactionsHash, block.transactionsHash) &&
                Objects.equals(stateHash, block.stateHash) &&
                Objects.equals(previousBlockHash, block.previousBlockHash) &&
                Objects.equals(consensusMetadata, block.consensusMetadata) &&
                Objects.equals(nonHashData, block.nonHashData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions, timestamp, transactionsHash, stateHash, previousBlockHash, consensusMetadata, nonHashData);
    }

    @Override
    public String toString() {
        return "Block(transactions=" + this.getTransactions() + ", timestamp=" + this.getTimestamp() + ", transactionsHash=" + this.getTransactionsHash() + ", stateHash=" + this.getStateHash() + ", previousBlockHash=" + this.getPreviousBlockHash() + ", consensusMetadata=" + this.getConsensusMetadata() + ", nonHashData=" + this.getNonHashData() + ")";
    }
}
