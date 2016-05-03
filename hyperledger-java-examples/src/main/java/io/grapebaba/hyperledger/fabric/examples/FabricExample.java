package io.grapebaba.hyperledger.fabric.examples;

import io.grapebaba.hyperledger.fabric.ErrorResolver;
import io.grapebaba.hyperledger.fabric.Fabric;
import io.grapebaba.hyperledger.fabric.Hyperledger;
import io.grapebaba.hyperledger.fabric.models.*;
import io.grapebaba.hyperledger.fabric.models.Error;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

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
                System.out.printf("Error message:%s\n", error.getError());
            }
        });

        FABRIC.getNetworkPeers().subscribe(new Action1<PeersMessage>() {
            @Override
            public void call(PeersMessage peersMessage) {
                System.out.printf("Peer message pkid:%s\n", peersMessage.getPeers().get(0).getPkiID());
            }
        });

        FABRIC.createRegistrar(Secret.builder().enrollId("lukas").enrollSecret("NPKYL39uKbkj1").build()).subscribe(new Action1<OK>() {
            @Override
            public void call(OK ok) {
                System.out.printf("Create registrar ok message:%s\n", ok.getOk());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Error error = ErrorResolver.resolve(throwable, Error.class);
                System.out.printf("Error message:%s\n", error.getError());
            }
        });

        FABRIC.createRegistrar(Secret.builder().enrollId("jim").enrollSecret("6avZQLwcUe9b").build()).subscribe(new Action1<OK>() {
            @Override
            public void call(OK ok) {
                System.out.printf("Create registrar ok message:%s\n", ok.getOk());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Error error = ErrorResolver.resolve(throwable, Error.class);
                System.out.printf("Error message:%s\n", error.getError());
            }
        });

        FABRIC.getRegistrar("jim").subscribe(new Action1<OK>() {
            @Override
            public void call(OK ok) {
                System.out.printf("Get registrar ok message:%s\n", ok.getOk());
            }
        });

        FABRIC.getRegistrarECERT("jim").subscribe(new Action1<OK>() {
            @Override
            public void call(OK ok) {
                System.out.printf("Get registrar ecert ok message:%s\n", ok.getOk());
            }
        });

        FABRIC.getRegistrarTCERT("jim").subscribe(new Action1<OK1>() {
            @Override
            public void call(OK1 ok) {
                System.out.printf("Get registrar tcert ok message:%s\n", ok.getOk().get(0));
            }
        });

        FABRIC.chaincode(ChaincodeOpPayload.builder().jsonrpc("2.0").id(1).method("deploy").params(ChaincodeSpec.builder().chaincodeID(ChaincodeID.builder().name("mycc").build()).ctorMsg(ChaincodeInput.builder().function("init").args(Arrays.asList("a", "100", "b", "200")).build()).secureContext("jim").build()).build()).subscribe(new Action1<ChaincodeOpResult>() {
            @Override
            public void call(ChaincodeOpResult chaincodeOpResult) {
                System.out.printf("Get registrar tcert ok message:%s\n", chaincodeOpResult.toString());
            }
        });

        FABRIC.chaincode(ChaincodeOpPayload.builder().jsonrpc("2.0").id(1).method("invoke").params(ChaincodeSpec.builder().chaincodeID(ChaincodeID.builder().name("mycc").build()).ctorMsg(ChaincodeInput.builder().function("invoke").args(Arrays.asList("a", "b", "10")).build()).secureContext("jim").build()).build())
                .flatMap(new Func1<ChaincodeOpResult, Observable<Transaction>>() {
                    @Override
                    public Observable<Transaction> call(ChaincodeOpResult chaincodeOpResult) {
                        System.out.printf("Get registrar tcert ok message:%s\n", chaincodeOpResult.getResult().getMessage());
                        try {
                            TimeUnit.SECONDS.sleep(1L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return FABRIC.getTransaction(chaincodeOpResult.getResult().getMessage());
                    }
                }).forEach(new Action1<Transaction>() {
            @Override
            public void call(Transaction transaction) {
                System.out.printf("Get registrar tcert ok message:%s\n", transaction.toString());
            }
        });


        FABRIC.chaincode(ChaincodeOpPayload.builder().jsonrpc("2.0").id(1).method("query").params(ChaincodeSpec.builder().chaincodeID(ChaincodeID.builder().name("mycc").build()).ctorMsg(ChaincodeInput.builder().function("query").args(Collections.singletonList("b")).build()).secureContext("jim").build()).build()).subscribe(new Action1<ChaincodeOpResult>() {
            @Override
            public void call(ChaincodeOpResult chaincodeOpResult) {
                System.out.printf("Get registrar tcert ok message:%s\n", chaincodeOpResult.toString());
            }
        });

        FABRIC.chaincode(ChaincodeOpPayload.builder().jsonrpc("2.0").id(1).method("query").params(ChaincodeSpec.builder().chaincodeID(ChaincodeID.builder().name("mycc").build()).ctorMsg(ChaincodeInput.builder().function("query").args(Arrays.asList("b", "a")).build()).secureContext("jim").build()).build()).subscribe(new Action1<ChaincodeOpResult>() {
            @Override
            public void call(ChaincodeOpResult chaincodeOpResult) {
                System.out.printf("Get registrar tcert ok message:%s\n", chaincodeOpResult.toString());
            }
        });
    }
}
