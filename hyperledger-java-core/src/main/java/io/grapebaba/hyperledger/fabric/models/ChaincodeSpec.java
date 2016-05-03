package io.grapebaba.hyperledger.fabric.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChaincodeSpec {

    public enum Type {
        @SerializedName("0")
        UNDEFINED,
        @SerializedName("1")
        GOLANG,
        @SerializedName("2")
        NODE
    }

    private Type type;

    private ChaincodeID chaincodeID;

    private ChaincodeInput ctorMsg;

    private String secureContext;

    private ConfidentialityLevel confidentialityLevel;
}
