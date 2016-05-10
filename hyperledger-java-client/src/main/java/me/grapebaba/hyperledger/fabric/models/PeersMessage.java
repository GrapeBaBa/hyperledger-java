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
 * Model of peers message.
 */
public class PeersMessage {

    private static final Logger LOG = LoggerFactory.getLogger(PeersMessage.class);

    private List<PeerEndpoint> peers;

    PeersMessage(final List<PeerEndpoint> peers) {
        this.peers = peers;
    }

    /**
     * Builder of PeersMessage.
     */
    public static class PeersMessageBuilder {

        private List<PeerEndpoint> peers;

        PeersMessageBuilder() {
        }

        /**
         * Set peer.
         *
         * @param peer peer
         * @return PeersMessageBuilder
         */
        public PeersMessageBuilder peer(final PeerEndpoint peer) {
            if (this.peers == null) this.peers = new ArrayList<>();
            this.peers.add(peer);
            return this;
        }

        /**
         * Set a set of peer.
         *
         * @param peers peers.
         * @return PeersMessageBuilder
         */
        public PeersMessageBuilder peers(final Collection<? extends PeerEndpoint> peers) {
            if (this.peers == null) this.peers = new ArrayList<>();
            this.peers.addAll(peers);
            return this;
        }

        /**
         * Clear peers.
         *
         * @return PeersMessageBuilder
         */
        public PeersMessageBuilder clearPeers() {
            if (this.peers != null) this.peers.clear();
            return this;
        }

        /**
         * Build PeersMessage.
         *
         * @return PeersMessage
         */
        public PeersMessage build() {
            List<PeerEndpoint> peers;
            switch (this.peers == null ? 0 : this.peers.size()) {
                case 0:
                    peers = Collections.emptyList();
                    break;

                case 1:
                    peers = Collections.singletonList(this.peers.get(0));
                    break;

                default:
                    peers = Collections.unmodifiableList(new ArrayList<>(this.peers));
            }
            return new PeersMessage(peers);
        }

        @Override
        public java.lang.String toString() {
            return "PeersMessage.PeersMessageBuilder(peers=" + this.peers + ")";
        }
    }

    /**
     * Create PeersMessageBuilder.
     *
     * @return PeersMessageBuilder
     */
    public static PeersMessageBuilder builder() {
        return new PeersMessageBuilder();
    }

    /**
     * Get peers.
     *
     * @return peers
     */
    public List<PeerEndpoint> getPeers() {
        return this.peers;
    }

    /**
     * Set peers.
     *
     * @param peers peers
     */
    public void setPeers(final List<PeerEndpoint> peers) {
        this.peers = peers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeersMessage that = (PeersMessage) o;
        return Objects.equals(peers, that.peers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peers);
    }

    @Override
    public java.lang.String toString() {
        return "PeersMessage(peers=" + this.getPeers() + ")";
    }
}
