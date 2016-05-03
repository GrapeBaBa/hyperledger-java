package io.grapebaba.hyperledger.fabric.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Transaction {
    public enum Type {
        @SerializedName("0")
        UNDEFINED,
        @SerializedName("1")
        CHAINCODE_DEPLOY,
        @SerializedName("2")
        CHAINCODE_INVOKE,
        @SerializedName("3")
        CHAINCODE_QUERY,
        @SerializedName("4")
        CHAINCODE_TERMINATE
    }

    private Type type;

    private String chaincodeID;

    private String payload;

    private String metadata;

    private String uuid;

    private Timestamp timestamp;

    private ConfidentialityLevel confidentialityLevel;

    private String nonce;

    private String confidentialityProtocolVersion;

    private String toValidators;

    private String cert;

    private String signature;
}
