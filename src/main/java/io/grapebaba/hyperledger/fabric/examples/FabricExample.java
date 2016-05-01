package io.grapebaba.hyperledger.fabric.examples;

import io.grapebaba.hyperledger.fabric.*;
import io.grapebaba.hyperledger.fabric.Error;
import rx.functions.Action1;

public class FabricExample {

    private static final Fabric FABRIC = Hyperledger.fabric("http://localhost:3000/");

    public static void main(String[] args) throws Exception {
        FABRIC.getBlockchain().subscribe(new Action1<BlockchainInfo>() {

            @Override
            public void call(BlockchainInfo blockchainInfo) {
                System.out.printf("Chain height:%d, currentBlockHash:%s, previousBlockHash:%s\n", blockchainInfo.getHeight(), blockchainInfo.getCurrentBlockHash(), blockchainInfo.getPreviousBlockHash());
            }
        });

        FABRIC.getBlock(0).subscribe(new Action1<Block>() {
            @Override
            public void call(Block block) {
                System.out.printf("Block info:" + block + "\n");
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Error error = ErrorResolver.resolve(throwable, Error.class);
                System.out.printf("Error message:%s\n", error.getError());
            }
        });

        FABRIC.getBlock(1).subscribe(new Action1<Block>() {
            @Override
            public void call(Block block) {
                System.out.printf("Block info:" + block + "\n");
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Error error = ErrorResolver.resolve(throwable, Error.class);
                System.out.printf("Block info:%s\n", error.getError());
            }
        });

        FABRIC.getNetworkPeers().subscribe(new Action1<PeersMessage>() {
            @Override
            public void call(PeersMessage peersMessage) {
                System.out.printf("Peer message:" + peersMessage.getPeers().get(0).getPkiID() + "\n");
            }
        });
    }
}
