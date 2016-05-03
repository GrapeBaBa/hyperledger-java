package io.grapebaba.hyperledger.fabric.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PeerEndpoint {

    public enum Type {
        @SerializedName("0")
        UNDEFINED,
        @SerializedName("1")
        VALIDATOR,
        @SerializedName("2")
        NON_VALIDATOR
    }

    @SerializedName("ID")
    private PeerID id;

    private String address;

    private Type type;

    private String pkiID;
}
