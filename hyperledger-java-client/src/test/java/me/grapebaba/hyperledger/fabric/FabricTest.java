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

package me.grapebaba.hyperledger.fabric;

import me.grapebaba.hyperledger.fabric.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Path;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import rx.Observable;
import rx.functions.Action1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * A behavior mock test for fabric API
 */
public class FabricTest {

    private Fabric fabric;

    @Before
    public void setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:5000")
                .addCallAdapterFactory(Hyperledger.CALL_ADAPTER_FACTORY)
                .addConverterFactory(Hyperledger.CONVERTER_FACTORY)
                .build();
        MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
                .build();
        final BehaviorDelegate<Fabric> delegate = mockRetrofit.create(Fabric.class);

        fabric = new Fabric() {

            @Override
            public Observable<BlockchainInfo> getBlockchain() {
                BlockchainInfo blockchainInfo = BlockchainInfo.builder()
                        .previousBlockHash("dOKffieBa9Res8AVwUVeIMOoUdLRovrL5BpYYMRvvVMGa5Qc+/31tJgBn4gPkI7YLqqQuETJkCsgHM2f3buD6g==")
                        .currentBlockHash("gUpW23N3n+zIZ3y94YV78pBiQYimC3L7PbpBu/RNpqE/jHXHGDxvsLerwcjqZuHwBZWHc5KiXGi6103yv26+NA==")
                        .height(5)
                        .build();
                return delegate.returningResponse(blockchainInfo).getBlockchain();
            }

            @Override
            public Observable<Block> getBlock(@Path("index") int index) {
                NonHashData nonHashData = NonHashData.builder()
                        .localLedgerCommitTimestamp(Timestamp.builder().nanos(913250562).seconds(1468914218).build())
                        .build();

                Transaction transaction = Transaction.builder()
                        .chaincodeID("CkBnaXRodWIuY29tL2h5cGVybGVkZ2VyL2ZhYnJpYy9jb3JlL3N5c3RlbV9jaGFpbmNvZGUvc2FtcGxlX3N5c2NjEgxzYW1wbGVfc3lzY2M=")
                        .payload("CnMIARJQCkBnaXRodWIuY29tL2h5cGVybGVkZ2VyL2ZhYnJpYy9jb3JlL3N5c3RlbV9jaGFpbmNvZGUvc2FtcGxlX3N5c2NjEgxzYW1wbGVfc3lzY2MaHQoGcHV0dmFsEghncmVldGluZxIJaGV5IHRoZXJl")
                        .type(Transaction.Type.CHAINCODE_INVOKE)
                        .uuid("0a815d57-8918-449a-9acc-a3d8e2e70189")
                        .timestamp(Timestamp.builder().nanos(910596873).seconds(1468914218).build())
                        .build();

                Block block = Block.builder()
                        .stateHash("zcp+UXwCBpdBCop6136fQMpwDdatQTBKT45K5NSB/5HqlMfYKZlqX7jqpqSn4ju6KUqpSBS0tXMmFj5YGoNPUg==")
                        .nonHashData(nonHashData)
                        .transaction(transaction)
                        .build();

                return delegate.returningResponse(block).getBlock(0);
            }

            @Override
            public Observable<ChaincodeOpResult> chaincode(@Body ChaincodeOpPayload chaincodeOpPayload) {
                ChaincodeOpResult chaincodeOpResult = null;
                switch (chaincodeOpPayload.getMethod()) {
                    case "deploy":
                        chaincodeOpResult = ChaincodeOpResult.builder()
                                .jsonrpc("2.0")
                                .result(RpcResponse.builder()
                                        .message("mycc")
                                        .status("OK")
                                        .build())
                                .id(1)
                                .build();
                        break;
                    case "invoke":
                        chaincodeOpResult = ChaincodeOpResult.builder()
                                .jsonrpc("2.0")
                                .result(RpcResponse.builder()
                                        .message("83203ede-4292-454b-9ade-130f61ee6f00")
                                        .status("OK")
                                        .build())
                                .id(1)
                                .build();
                        break;
                    case "query":
                        chaincodeOpResult = ChaincodeOpResult.builder()
                                .jsonrpc("2.0")
                                .result(RpcResponse.builder()
                                        .message("210")
                                        .status("OK")
                                        .build())
                                .id(1)
                                .build();
                        break;
                }

                return delegate.returningResponse(chaincodeOpResult).chaincode(chaincodeOpPayload);
            }

            @Override
            public Observable<Transaction> getTransaction(@Path("uuid") String uuid) {
                Transaction transaction = Transaction.builder()
                        .chaincodeID("BJQebdd8VyYDIaiuOH2poMhbr4LeQIvwXRWqX+mlNgjKrSVbx/wbsgmS0cADJDuOB0OhuuEe6MxTPLVVHCfpiVTWTjhUExf/NjKsGTNBUatFbJ6zIGwNd+ayBVKRuboDCjsvLf0wW5pmvTYXp3q4Ak6cxTMdYJw=")
                        .payload("BHjIOF6268QoMYjTfj4dNMJqzKqvph9mN230hcJkgmjpsF1rkhECSbXvwiDGIYa7iOXLOp0CaO6GP9WplAEonnNJrs5n9wFwzL4QgC3wlNqnf+eFAO/wGfsZaWlduy86X0TFzgQJOOJHriMrVIV2X4SkqdNhue2uiwhUuXtMJjajvm3ntwGC6BgXYs0pdmLKrnv5")
                        .type(Transaction.Type.CHAINCODE_INVOKE)
                        .uuid(uuid)
                        .timestamp(Timestamp.builder().nanos(584632580).seconds(1469520839).build())
                        .confidentialityLevel(ConfidentialityLevel.CONFIDENTIAL)
                        .confidentialityProtocolVersion("1.2")
                        .nonce("9oaeflIqo2dY5A8M9UYhf278E/U1UcQy")
                        .toValidators("BD8Y9bPDIHjuQn3iWwFW0B9PJ1jinSUDYFyfd0Hjvx8opR8ZyeTcgN78EeQUs4extc4q1ICjGsv39CrjAdX1dEf4j3QI0KteWZUw2buv5T2wzH60yJo0eF10SwtuXnM7qsost6iwsG+alZ78ry5kYCwJ0A/8iOfHdVJ1tPrM1bZda/gAtBK8b6oqD+3DZl3umm1jazc3PHDU3OLcU7/LRj8qkYcE4wTNky1X1pzBrLDKYIpsXrQTv4IpzeJ3rFLk2d9DTnjw+2VVURQ59sxSVuGoaaUW/zhYW58IHzwyAJzpEYV3Vqi+CLFKGGjrFfbG")
                        .cert("MIICQTCCAeigAwIBAgIRALM4sDNYGEMNuc9GjDQbriUwCgYIKoZIzj0EAwMwMTELMAkGA1UEBhMCVVMxFDASBgNVBAoTC0h5cGVybGVkZ2VyMQwwCgYDVQQDEwN0Y2EwHhcNMTYwNzI2MDgxMjU5WhcNMTYxMDI0MDgxMjU5WjBFMQswCQYDVQQGEwJVUzEUMBIGA1UEChMLSHlwZXJsZWRnZXIxIDAeBgNVBAMTF1RyYW5zYWN0aW9uIENlcnRpZmljYXRlMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE8TDp0aI3nqRNNZ5RBMEiIYNmdk7S9O9+u47GHOwvY1rY3Bt50wH8iAxTDyjvZVZHueKWdbxIoGlafyKbDncb06OBzDCByTAOBgNVHQ8BAf8EBAMCB4AwDAYDVR0TAQH/BAIwADANBgNVHQ4EBgQEAQIDBDAPBgNVHSMECDAGgAQBAgMEME0GBioDBAUGBwEB/wRANfj/AaY4XoRnaGpeG6/ORYB8XnV0lVbomNzw1UJqsZQzUh7vNbDTfyjIQjUg/wvnN2iocJ3AJqIuwXsl5AIgFzA6BgYqAwQFBggEMD0IFZ03GfqzkJ3KxWvnuOCTWp6KGJV5Egx9E9zv8pK0pMyrQOiSfxa3V6va8D/XEzAKBggqhkjOPQQDAwNHADBEAiAT8X7aWr63WuGLlvirthycwo1n20HLg2cq9ZtjsMfO5gIgVRwYVbszyg/SaXqyGj2NeyKBA3vElbdS76AoQYwA960=")
                        .signature("MEQCIFtAulWQTLnYQ2g7IXaH5xxFb2FCQFzYpbdBNAxB4iJFAiBuCUxoXqtZspsBleC8M6/xZPBSh3G/RyEYKP4CjQABkg==")
                        .build();

                return delegate.returningResponse(transaction).getTransaction(uuid);
            }

            @Override
            public Observable<OK> createRegistrar(@Body Secret secret) {
                OK ok = OK.builder()
                        .ok(String.format("Login successful for user '%s'.", secret.getEnrollId()))
                        .build();
                return delegate.returningResponse(ok).createRegistrar(secret);
            }

            @Override
            public Observable<OK> getRegistrar(@Path("enrollmentID") String enrollmentID) {
                OK ok = OK.builder()
                        .ok(String.format("User %s is already logged in.", enrollmentID))
                        .build();
                return delegate.returningResponse(ok).getRegistrar(enrollmentID);
            }

            @Override
            public Observable<OK> deleteRegistrar(@Path("enrollmentID") String enrollmentID) {
                OK ok = OK.builder()
                        .ok(String.format("Deleted login token and directory for user %s.", enrollmentID))
                        .build();
                return delegate.returningResponse(ok).deleteRegistrar(enrollmentID);
            }

            @Override
            public Observable<OK> getRegistrarECERT(@Path("enrollmentID") String enrollmentID) {
                OK ok = OK.builder()
                        .ok("-----BEGIN+CERTIFICATE-----%0AMIIBpzCCAU6gAwIBAgIBATAKBggqhkjOPQQDAzAxMQswCQYDVQQGEwJVUzEUMBIG%0AA1UEChMLSHlwZXJsZWRnZXIxDDAKBgNVBAMTA2VjYTAeFw0xNjA3MjYwODEyNTha%0AFw0xNjEwMjQwODEyNThaMDgxCzAJBgNVBAYTAlVTMRQwEgYDVQQKEwtIeXBlcmxl%0AZGdlcjETMBEGA1UEAwwKamltXGJhbmtfYTBZMBMGByqGSM49AgEGCCqGSM49AwEH%0AA0IABHpYWewZn3BCW%2FVntqm%2FoMukMwF6Z12SPzs%2FXBAgpZX6ICq2tIhMT7hGe3T3%0ADROImKQDEWuQQJlmiV3tmkZb0d%2BjUDBOMA4GA1UdDwEB%2FwQEAwIHgDAMBgNVHRMB%0AAf8EAjAAMA0GA1UdDgQGBAQBAgMEMA8GA1UdIwQIMAaABAECAwQwDgYGUQMEBQYH%0AAQH%2FBAExMAoGCCqGSM49BAMDA0cAMEQCIDTJ9WhyUYpvl2DUxbk0F0wp%2B%2BW4sIig%0ASxepS12WU9NnAiAnJINH3jjlVOAPWdNUD0ZR6t8aVIP0LUo0GeIFjQMjtg%3D%3D%0A-----END+CERTIFICATE-----%0A")
                        .build();
                return delegate.returningResponse(ok).getRegistrarECERT(enrollmentID);
            }

            @Override
            public Observable<OK1> getRegistrarTCERT(@Path("enrollmentID") String enrollmentID) {
                OK1 ok1 = OK1.builder()
                        .ok("-----BEGIN+CERTIFICATE-----%0AMIICQTCCAeegAwIBAgIQU0T0KG4DS7iK%2B1Zrt%2F6MEzAKBggqhkjOPQQDAzAxMQsw%0ACQYDVQQGEwJVUzEUMBIGA1UEChMLSHlwZXJsZWRnZXIxDDAKBgNVBAMTA3RjYTAe%0AFw0xNjA3MjYwODEyNTlaFw0xNjEwMjQwODEyNTlaMEUxCzAJBgNVBAYTAlVTMRQw%0AEgYDVQQKEwtIeXBlcmxlZGdlcjEgMB4GA1UEAxMXVHJhbnNhY3Rpb24gQ2VydGlm%0AaWNhdGUwWTATBgcqhkjOPQIBBggqhkjOPQMBBwNCAAT%2By63T%2FKzwmDagqRRyzDMp%0AWsjy4yHcQJumqDONjAEtpT9Ws4RcOCx8Sdr6updH%2FS8Wnzu%2FkyMmdlbb%2Bb1yCBRf%0Ao4HMMIHJMA4GA1UdDwEB%2FwQEAwIHgDAMBgNVHRMBAf8EAjAAMA0GA1UdDgQGBAQB%0AAgMEMA8GA1UdIwQIMAaABAECAwQwTQYGKgMEBQYHAQH%2FBEBCkVWPlT53%2F4dC68iC%0Ah1ov%2FcRhaUKkMLCub90JJsgLVXML4fp1adKjtUPBFQQ6kij9kquJSlZRrTxYquV%2F%0Aai8cMDoGBioDBAUGCAQwOihyQ9CTKmUss4Elnlwe8oE8F7m9TbZj2D1L3DKnp1y4%0AtxMNfS7DVHoJylfgwtbVMAoGCCqGSM49BAMDA0gAMEUCIQC%2F1G5P5uJAZWo3fzhY%0AiR9ezVJUAiP%2Fqgd3MgL01prq9gIgHG%2BzaysyK0%2FJqqu%2FEDWcJ%2FCEgaMdwCpCywvy%0AezNCAoI%3D%0A-----END+CERTIFICATE-----%0A")
                        .build();
                return delegate.returningResponse(ok1).getRegistrarTCERT(enrollmentID);
            }

            @Override
            public Observable<PeersMessage> getNetworkPeers() {
                PeersMessage peersMessage = PeersMessage.builder()
                        .peer(PeerEndpoint.builder()
                                .address("0.0.0.0:30303")
                                .id(PeerID.builder()
                                        .name("jdoe").build())
                                .type(PeerEndpoint.Type.VALIDATOR)
                                .pkiID("kqoAmCzXd+YU0bzGQWgw/ayMDvSjom4VmdGyjbQKHtA=").build())
                        .build();

                return delegate.returningResponse(peersMessage).getNetworkPeers();
            }
        };
    }

    @Test
    public void createRegistrarSuccess() {
        Secret secret = Secret.builder()
                .enrollId("jim")
                .enrollSecret("6avZQLwcUe9b")
                .build();

        fabric.createRegistrar(secret).subscribe(new Action1<OK>() {
            @Override
            public void call(OK ok) {
                Assert.assertEquals("Login successful for user 'jim'.", ok.getOk());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });
    }

    @Test
    public void getRegistrarSuccess() {
        fabric.getRegistrar("jim").subscribe(new Action1<OK>() {
            @Override
            public void call(OK ok) {
                Assert.assertEquals("User jim is already logged in.", ok.getOk());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });
    }

    @Test
    public void deleteRegistrarSuccess() {
        fabric.deleteRegistrar("jim").subscribe(new Action1<OK>() {
            @Override
            public void call(OK ok) {
                Assert.assertEquals("Deleted login token and directory for user jim.", ok.getOk());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });
    }

    @Test
    public void getRegistrarECERTSuccess() {
        fabric.getRegistrarECERT("jim").subscribe(new Action1<OK>() {
            @Override
            public void call(OK ok) {
                Assert.assertEquals("-----BEGIN+CERTIFICATE-----%0AMIIBpzCCAU6gAwIBAgIBATAKBggqhkjOPQQDAzAxMQswCQYDVQQGEwJVUzEUMBIG%0AA1UEChMLSHlwZXJsZWRnZXIxDDAKBgNVBAMTA2VjYTAeFw0xNjA3MjYwODEyNTha%0AFw0xNjEwMjQwODEyNThaMDgxCzAJBgNVBAYTAlVTMRQwEgYDVQQKEwtIeXBlcmxl%0AZGdlcjETMBEGA1UEAwwKamltXGJhbmtfYTBZMBMGByqGSM49AgEGCCqGSM49AwEH%0AA0IABHpYWewZn3BCW%2FVntqm%2FoMukMwF6Z12SPzs%2FXBAgpZX6ICq2tIhMT7hGe3T3%0ADROImKQDEWuQQJlmiV3tmkZb0d%2BjUDBOMA4GA1UdDwEB%2FwQEAwIHgDAMBgNVHRMB%0AAf8EAjAAMA0GA1UdDgQGBAQBAgMEMA8GA1UdIwQIMAaABAECAwQwDgYGUQMEBQYH%0AAQH%2FBAExMAoGCCqGSM49BAMDA0cAMEQCIDTJ9WhyUYpvl2DUxbk0F0wp%2B%2BW4sIig%0ASxepS12WU9NnAiAnJINH3jjlVOAPWdNUD0ZR6t8aVIP0LUo0GeIFjQMjtg%3D%3D%0A-----END+CERTIFICATE-----%0A", ok.getOk());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });
    }

    @Test
    public void getRegistrarTCERTSuccess() {
        fabric.getRegistrarTCERT("jim").subscribe(new Action1<OK1>() {
            @Override
            public void call(OK1 ok1) {
                Assert.assertTrue(ok1.getOk().size() == 1);
                Assert.assertEquals("-----BEGIN+CERTIFICATE-----%0AMIICQTCCAeegAwIBAgIQU0T0KG4DS7iK%2B1Zrt%2F6MEzAKBggqhkjOPQQDAzAxMQsw%0ACQYDVQQGEwJVUzEUMBIGA1UEChMLSHlwZXJsZWRnZXIxDDAKBgNVBAMTA3RjYTAe%0AFw0xNjA3MjYwODEyNTlaFw0xNjEwMjQwODEyNTlaMEUxCzAJBgNVBAYTAlVTMRQw%0AEgYDVQQKEwtIeXBlcmxlZGdlcjEgMB4GA1UEAxMXVHJhbnNhY3Rpb24gQ2VydGlm%0AaWNhdGUwWTATBgcqhkjOPQIBBggqhkjOPQMBBwNCAAT%2By63T%2FKzwmDagqRRyzDMp%0AWsjy4yHcQJumqDONjAEtpT9Ws4RcOCx8Sdr6updH%2FS8Wnzu%2FkyMmdlbb%2Bb1yCBRf%0Ao4HMMIHJMA4GA1UdDwEB%2FwQEAwIHgDAMBgNVHRMBAf8EAjAAMA0GA1UdDgQGBAQB%0AAgMEMA8GA1UdIwQIMAaABAECAwQwTQYGKgMEBQYHAQH%2FBEBCkVWPlT53%2F4dC68iC%0Ah1ov%2FcRhaUKkMLCub90JJsgLVXML4fp1adKjtUPBFQQ6kij9kquJSlZRrTxYquV%2F%0Aai8cMDoGBioDBAUGCAQwOihyQ9CTKmUss4Elnlwe8oE8F7m9TbZj2D1L3DKnp1y4%0AtxMNfS7DVHoJylfgwtbVMAoGCCqGSM49BAMDA0gAMEUCIQC%2F1G5P5uJAZWo3fzhY%0AiR9ezVJUAiP%2Fqgd3MgL01prq9gIgHG%2BzaysyK0%2FJqqu%2FEDWcJ%2FCEgaMdwCpCywvy%0AezNCAoI%3D%0A-----END+CERTIFICATE-----%0A", ok1.getOk().get(0));
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });
    }

    @Test
    public void getNetworkPeersSuccess() {
        fabric.getNetworkPeers().subscribe(new Action1<PeersMessage>() {
            @Override
            public void call(PeersMessage peersMessage) {
                Assert.assertTrue(peersMessage.getPeers().size() == 1);
                Assert.assertEquals("kqoAmCzXd+YU0bzGQWgw/ayMDvSjom4VmdGyjbQKHtA=", peersMessage.getPeers().get(0).getPkiID());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });
    }

    @Test
    public void getTransactionSuccess() {
        fabric.getTransaction("83203ede-4292-454b-9ade-130f61ee6f00").subscribe(new Action1<Transaction>() {
            @Override
            public void call(Transaction transaction) {
                Assert.assertEquals("83203ede-4292-454b-9ade-130f61ee6f00", transaction.getUuid());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });
    }

    @Test
    public void chaincodeSuccess() {
        fabric.chaincode(
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
                                        .type(ChaincodeSpec.Type.GOLANG)
                                        .build())
                        .build()
        ).subscribe(new Action1<ChaincodeOpResult>() {
            @Override
            public void call(ChaincodeOpResult chaincodeOpResult) {
                Assert.assertEquals("210", chaincodeOpResult.getResult().getMessage());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });


        fabric.chaincode(
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
                                        .type(ChaincodeSpec.Type.GOLANG)
                                        .build())
                        .build()
        ).subscribe(new Action1<ChaincodeOpResult>() {
            @Override
            public void call(ChaincodeOpResult chaincodeOpResult) {
                Assert.assertEquals("83203ede-4292-454b-9ade-130f61ee6f00", chaincodeOpResult.getResult().getMessage());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });

        fabric.chaincode(
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
                                        .type(ChaincodeSpec.Type.GOLANG)
                                        .build())
                        .build()
        ).subscribe(new Action1<ChaincodeOpResult>() {
            @Override
            public void call(ChaincodeOpResult chaincodeOpResult) {
                Assert.assertEquals("mycc", chaincodeOpResult.getResult().getMessage());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });
    }

    @Test
    public void getBlockSuccess() {
        fabric.getBlock(0).subscribe(new Action1<Block>() {
            @Override
            public void call(Block block) {
                Assert.assertEquals("zcp+UXwCBpdBCop6136fQMpwDdatQTBKT45K5NSB/5HqlMfYKZlqX7jqpqSn4ju6KUqpSBS0tXMmFj5YGoNPUg==", block.getStateHash());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });
    }

    @Test
    public void getBlockchain() {
        fabric.getBlockchain().subscribe(new Action1<BlockchainInfo>() {
            @Override
            public void call(BlockchainInfo blockchainInfo) {
                Assert.assertEquals("gUpW23N3n+zIZ3y94YV78pBiQYimC3L7PbpBu/RNpqE/jHXHGDxvsLerwcjqZuHwBZWHc5KiXGi6103yv26+NA==", blockchainInfo.getCurrentBlockHash());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Assert.assertTrue(throwable instanceof IOException);
            }
        });
    }
}