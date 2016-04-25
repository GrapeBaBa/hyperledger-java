package io.grapebaba.hyperledger.fabric;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.DELETE;

/**
 *
 */
public interface Fabric {
    @GET("chain")
    Call<BlockchainInfo> getBlockchain();

    @GET("chain/blocks/{blockID}")
    Call<Block> getBlock(@Path("blockID") String blockID);

    @POST("chaincode")
    Call<ChaincodeOpSuccess> chaincode(@Body ChaincodeOpPayload chaincodeOpPayload);

    @GET("transactions/{uuid}")
    Call<Transaction> getTransaction(@Path("uuid") String uuid);

    @POST("registrar")
    Call<OK> createRegistrar(@Body Secret secret);

    @GET("registrar/{enrollmentID}")
    Call<OK> getRegistrar(@Path("enrollmentID") String enrollmentID);

    @DELETE("registrar/{enrollmentID}")
    Call<OK> deleteRegistrar(@Path("enrollmentID") String enrollmentID);

    @GET("registrar/{enrollmentID}/ecert")
    Call<OK> getRegistrarECERT(@Path("enrollmentID") String enrollmentID);

    @GET("registrar/{enrollmentID}/tcert")
    Call<OK> getRegistrarTCERT(@Path("enrollmentID") String enrollmentID);

    @GET("network/peers")
    Call<PeersMessage> getNetworkPeers();
}
