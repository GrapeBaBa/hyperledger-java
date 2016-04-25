package io.grapebaba.hyperledger.fabric;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChaincodeSpec {

    public enum Type {
        UNDEFINED,
        GOLANG,
        NODE
    }

    private Type type;

    private ChaincodeID chaincodeID;

    private ChaincodeInput ctorMsg;

    private String secureContext;

    private ConfidentialityLevel confidentialityLevel;
}
