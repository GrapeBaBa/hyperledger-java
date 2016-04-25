package io.grapebaba.hyperledger.fabric;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Transaction {
    public enum Type {
        UNDEFINED,
        CHAINCODE_DEPLOY,
        CHAINCODE_INVOKE,
        CHAINCODE_QUERY,
        CHAINCODE_TERMINATE
    }

    private Type type;

    private String chaincodeID;

    private String payload;

    private String uuid;

    private Timestamp timestamp;

    private ConfidentialityLevel confidentialityLevel;

    private String nonce;

    private String cert;

    private String signature;
}
