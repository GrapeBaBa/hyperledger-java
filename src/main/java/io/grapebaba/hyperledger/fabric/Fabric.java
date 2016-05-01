package io.grapebaba.hyperledger.fabric;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import rx.Observable;

/**
 *
 */
public interface Fabric {
    @GET("chain")
    Observable<BlockchainInfo> getBlockchain();

    @GET("chain/blocks/{index}")
    Observable<Block> getBlock(@Path("index") int index);

    @POST("chaincode")
    Observable<ChaincodeOpSuccess> chaincode(@Body ChaincodeOpPayload chaincodeOpPayload);

    @GET("transactions/{uuid}")
    Observable<Transaction> getTransaction(@Path("uuid") String uuid);

    @POST("registrar")
    Observable<OK> createRegistrar(@Body Secret secret);

    @GET("registrar/{enrollmentID}")
    Observable<OK> getRegistrar(@Path("enrollmentID") String enrollmentID);

    @DELETE("registrar/{enrollmentID}")
    Observable<OK> deleteRegistrar(@Path("enrollmentID") String enrollmentID);

    @GET("registrar/{enrollmentID}/ecert")
    Observable<OK> getRegistrarECERT(@Path("enrollmentID") String enrollmentID);

    @GET("registrar/{enrollmentID}/tcert")
    Observable<OK> getRegistrarTCERT(@Path("enrollmentID") String enrollmentID);

    @GET("network/peers")
    Observable<PeersMessage> getNetworkPeers();
}
