A java client SDK for Hyperledger
===============================

----------

Easy to use
----------------------------------------------------------

      FABRIC.getNetworkPeers().subscribe(new Action1<PeersMessage>() {
            @Override
            public void call(PeersMessage peersMessage) {
                for (PeerEndpoint peerEndpoint : peersMessage.getPeers()) {
                    System.out.printf("Peer message:%s\n", peerEndpoint);
                }

            }
        });