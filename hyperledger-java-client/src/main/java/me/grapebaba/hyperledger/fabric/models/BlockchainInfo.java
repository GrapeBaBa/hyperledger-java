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
 * Model of blockchain.
 */
public class BlockchainInfo {

    private static final Logger LOG = LoggerFactory.getLogger(BlockchainInfo.class);

    private long height;

    private String currentBlockHash;

    private String previousBlockHash;

    BlockchainInfo(final long height, final String currentBlockHash, final String previousBlockHash) {
        this.height = height;
        this.currentBlockHash = currentBlockHash;
        this.previousBlockHash = previousBlockHash;
    }

    /**
     * Builder of BlockchainInfo.
     */
    public static class BlockchainInfoBuilder {

        private long height;

        private String currentBlockHash;

        private String previousBlockHash;

        BlockchainInfoBuilder() {
        }

        /**
         * Set height.
         *
         * @param height height
         * @return BlockchainInfoBuilder
         */
        public BlockchainInfoBuilder height(final long height) {
            this.height = height;
            return this;
        }

        /**
         * Set currentBlockHash.
         *
         * @param currentBlockHash currentBlockHash
         * @return BlockchainInfoBuilder
         */
        public BlockchainInfoBuilder currentBlockHash(final String currentBlockHash) {
            this.currentBlockHash = currentBlockHash;
            return this;
        }

        /**
         * Set previousBlockHash.
         *
         * @param previousBlockHash previousBlockHash
         * @return BlockchainInfoBuilder
         */
        public BlockchainInfoBuilder previousBlockHash(final String previousBlockHash) {
            this.previousBlockHash = previousBlockHash;
            return this;
        }

        /**
         * Build BlockchainInfo.
         *
         * @return BlockchainInfo
         */
        public BlockchainInfo build() {
            return new BlockchainInfo(height, currentBlockHash, previousBlockHash);
        }

        @Override
        public java.lang.String toString() {
            return "BlockchainInfo.BlockchainInfoBuilder(height=" + this.height + ", currentBlockHash=" + this.currentBlockHash + ", previousBlockHash=" + this.previousBlockHash + ")";
        }
    }

    /**
     * Create BlockchainInfoBuilder.
     *
     * @return BlockchainInfoBuilder
     */
    public static BlockchainInfoBuilder builder() {
        return new BlockchainInfoBuilder();
    }

    /**
     * Get height.
     *
     * @return height
     */
    public long getHeight() {
        return this.height;
    }

    /**
     * Get currentBlockHash.
     *
     * @return currentBlockHash
     */
    public String getCurrentBlockHash() {
        return this.currentBlockHash;
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
     * Set height.
     *
     * @param height height
     */
    public void setHeight(final long height) {
        this.height = height;
    }

    /**
     * Set currentBlockHash.
     *
     * @param currentBlockHash currentBlockHash
     */
    public void setCurrentBlockHash(final String currentBlockHash) {
        this.currentBlockHash = currentBlockHash;
    }

    /**
     * Set previousBlockHash.
     *
     * @param previousBlockHash previousBlockHash
     */
    public void setPreviousBlockHash(final String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockchainInfo that = (BlockchainInfo) o;
        return height == that.height &&
                Objects.equals(currentBlockHash, that.currentBlockHash) &&
                Objects.equals(previousBlockHash, that.previousBlockHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, currentBlockHash, previousBlockHash);
    }

    @Override
    public java.lang.String toString() {
        return "BlockchainInfo(height=" + this.getHeight() + ", currentBlockHash=" + this.getCurrentBlockHash() + ", previousBlockHash=" + this.getPreviousBlockHash() + ")";
    }
}
