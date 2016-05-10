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
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import rx.Observable;

/**
 * API interface of fabric.
 */
public interface Fabric {
    /**
     * Get blockchain.
     *
     * @return Info of blockchain.
     */
    @GET("chain")
    Observable<BlockchainInfo> getBlockchain();

    /**
     * Get block.
     *
     * @param index index.
     * @return Info of block.
     */
    @GET("chain/blocks/{index}")
    Observable<Block> getBlock(@Path("index") int index);

    /**
     * Invoke chaincode interface.
     *
     * @param chaincodeOpPayload chaincodeOpPayload.
     * @return chaincodeOpResult.
     */
    @POST("chaincode")
    Observable<ChaincodeOpResult> chaincode(@Body ChaincodeOpPayload chaincodeOpPayload);

    /**
     * Get transaction.
     *
     * @param uuid uuid.
     * @return transaction.
     */
    @GET("transactions/{uuid}")
    Observable<Transaction> getTransaction(@Path("uuid") String uuid);

    /**
     * Create registrar.
     *
     * @param secret secret.
     * @return OK.
     */
    @POST("registrar")
    Observable<OK> createRegistrar(@Body Secret secret);

    /**
     * Get registrar.
     *
     * @param enrollmentID enrollmentID.
     * @return OK.
     */
    @GET("registrar/{enrollmentID}")
    Observable<OK> getRegistrar(@Path("enrollmentID") String enrollmentID);

    /**
     * Delete registrar.
     *
     * @param enrollmentID enrollmentID.
     * @return OK.
     */
    @DELETE("registrar/{enrollmentID}")
    Observable<OK> deleteRegistrar(@Path("enrollmentID") String enrollmentID);

    /**
     * Get registrar ecert.
     *
     * @param enrollmentID enrollmentID.
     * @return OK.
     */
    @GET("registrar/{enrollmentID}/ecert")
    Observable<OK> getRegistrarECERT(@Path("enrollmentID") String enrollmentID);

    /**
     * Get registrar tcert.
     *
     * @param enrollmentID enrollmentID.
     * @return OK1.
     */
    @GET("registrar/{enrollmentID}/tcert")
    Observable<OK1> getRegistrarTCERT(@Path("enrollmentID") String enrollmentID);

    /**
     * Get network peers.
     *
     * @return peers message.
     */
    @GET("network/peers")
    Observable<PeersMessage> getNetworkPeers();
}
