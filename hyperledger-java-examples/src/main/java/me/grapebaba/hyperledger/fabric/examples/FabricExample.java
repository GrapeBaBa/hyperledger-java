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

package me.grapebaba.hyperledger.fabric.examples;

import me.grapebaba.hyperledger.fabric.ErrorResolver;
import me.grapebaba.hyperledger.fabric.Fabric;
import me.grapebaba.hyperledger.fabric.Hyperledger;
import me.grapebaba.hyperledger.fabric.models.*;
import me.grapebaba.hyperledger.fabric.models.Error;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Fabric API endpoint usage.
 */
public class FabricExample {

    private static final Fabric FABRIC = Hyperledger.fabric("http://localhost:3000/");

    public static void main(String[] args) throws Exception {
        FABRIC.chaincode(
                ChaincodeOpPayload.builder()
                        .jsonrpc("2.0")
                        .id(1)
                        .method("deploy")
                        .params(
                                ChaincodeSpec.builder()
                                        .chaincodeID(
                                                ChaincodeID.builder()
                                                        .name("mycc")
                                                        .build())
                                        .ctorMsg(
                                                ChaincodeInput.builder()
                                                        .function("init")
                                                        .args(Arrays.asList("a", "100", "b", "200"))
                                                        .build())
                                        .secureContext("jim")
                                        .build())
                        .build())
                .subscribe(new Action1<ChaincodeOpResult>() {
                    @Override
                    public void call(ChaincodeOpResult chaincodeOpResult) {
                        System.out.printf("Deploy chaincode result:%s\n", chaincodeOpResult);
                    }
                });

        FABRIC.chaincode(
                ChaincodeOpPayload.builder()
                        .jsonrpc("2.0")
                        .id(1)
                        .method("invoke")
                        .params(
                                ChaincodeSpec.builder()
                                        .chaincodeID(
                                                ChaincodeID.builder()
                                                        .name("mycc")
                                                        .build())
                                        .ctorMsg(
                                                ChaincodeInput.builder()
                                                        .function("invoke")
                                                        .args(Arrays.asList("a", "b", "10"))
                                                        .build())
                                        .secureContext("jim")
                                        .build())
                        .build())
                .flatMap(new Func1<ChaincodeOpResult, Observable<Transaction>>() {
                    @Override
                    public Observable<Transaction> call(ChaincodeOpResult chaincodeOpResult) {
                        System.out.printf("Invoke chaincode result:%s\n", chaincodeOpResult);
                        try {
                            TimeUnit.SECONDS.sleep(3L);
                        } catch (InterruptedException e) {

                        }
                        return FABRIC.getTransaction(chaincodeOpResult.getResult().getMessage());
                    }
                })
                .subscribe(new Action1<Transaction>() {
                    @Override
                    public void call(Transaction transaction) {
                        System.out.printf("Get transaction:%s\n", transaction);
                    }
                });


        FABRIC.chaincode(
                ChaincodeOpPayload.builder()
                        .jsonrpc("2.0")
                        .id(1)
                        .method("query")
                        .params(
                                ChaincodeSpec.builder()
                                        .chaincodeID(
                                                ChaincodeID.builder()
                                                        .name("mycc")
                                                        .build())
                                        .ctorMsg(
                                                ChaincodeInput.builder()
                                                        .function("query")
                                                        .args(Collections.singletonList("b"))
                                                        .build())
                                        .secureContext("jim")
                                        .build())
                        .build())
                .subscribe(new Action1<ChaincodeOpResult>() {
                    @Override
                    public void call(ChaincodeOpResult chaincodeOpResult) {
                        System.out.printf("Query chaincode result:%s\n", chaincodeOpResult);
                    }
                });

        FABRIC.chaincode(
                ChaincodeOpPayload.builder()
                        .jsonrpc("2.0")
                        .id(1)
                        .method("query")
                        .params(
                                ChaincodeSpec.builder()
                                        .chaincodeID(
                                                ChaincodeID.builder()
                                                        .name("mycc")
                                                        .build())
                                        .ctorMsg(
                                                ChaincodeInput.builder()
                                                        .function("query")
                                                        .args(Collections.singletonList("c"))
                                                        .build())
                                        .secureContext("jim")
                                        .build())
                        .build())
                .subscribe(new Action1<ChaincodeOpResult>() {
                    @Override
                    public void call(ChaincodeOpResult chaincodeOpResult) {
                        System.out.printf("Query chaincode result:%s\n", chaincodeOpResult);
                    }
                });


        FABRIC.getBlockchain()
                .subscribe(new Action1<BlockchainInfo>() {

                    @Override
                    public void call(BlockchainInfo blockchainInfo) {
                        System.out.printf("Get blockchain info:%s\n", blockchainInfo);
                    }
                });

        FABRIC.getBlock(0)
                .subscribe(new Action1<Block>() {
                    @Override
                    public void call(Block block) {
                        System.out.printf("Get Block info:%s\n", block);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Error error = ErrorResolver.resolve(throwable, Error.class);
                        System.out.printf("Error message:%s\n", error.getError());
                    }
                });

        FABRIC.getBlock(1)
                .subscribe(new Action1<Block>() {
                    @Override
                    public void call(Block block) {
                        System.out.printf("Get Block info:%s\n", block);
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
                for (PeerEndpoint peerEndpoint : peersMessage.getPeers()) {
                    System.out.printf("Peer message:%s\n", peerEndpoint);
                }

            }
        });

        FABRIC.deleteRegistrar("lukas").subscribe(new Action1<OK>() {
            @Override
            public void call(OK ok) {
                System.out.printf("Delete registrar ok message:%s\n", ok);
            }
        });

        FABRIC.createRegistrar(
                Secret.builder()
                        .enrollId("lukas")
                        .enrollSecret("NPKYL39uKbkj1")
                        .build())
                .subscribe(new Action1<OK>() {
                    @Override
                    public void call(OK ok) {
                        System.out.printf("Create registrar ok message:%s\n", ok);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Error error = ErrorResolver.resolve(throwable, Error.class);
                        System.out.printf("Error message:%s\n", error);
                    }
                });

        FABRIC.createRegistrar(
                Secret.builder()
                        .enrollId("jim")
                        .enrollSecret("6avZQLwcUe9b")
                        .build())
                .subscribe(new Action1<OK>() {
                    @Override
                    public void call(OK ok) {
                        System.out.printf("Create registrar ok message:%s\n", ok);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Error error = ErrorResolver.resolve(throwable, Error.class);
                        System.out.printf("Error message:%s\n", error);
                    }
                });

        FABRIC.getRegistrar("jim")
                .subscribe(new Action1<OK>() {
                    @Override
                    public void call(OK ok) {
                        System.out.printf("Get registrar ok message:%s\n", ok);
                    }
                });

        FABRIC.getRegistrarECERT("jim")
                .subscribe(new Action1<OK>() {
                    @Override
                    public void call(OK ok) {
                        System.out.printf("Get registrar ecert ok message:%s\n", ok);
                    }
                });

        FABRIC.getRegistrarTCERT("jim")
                .subscribe(new Action1<OK1>() {
                    @Override
                    public void call(OK1 ok) {
                        for (String okString : ok.getOk()) {
                            System.out.printf("Get registrar tcert ok message:%s\n", okString);
                        }
                    }
                });


    }
}
