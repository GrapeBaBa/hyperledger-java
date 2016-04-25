package io.grapebaba.hyperledger.fabric;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PeerEndpoint {

    public enum Type {
        UNDEFINED, VALIDATOR, NON_VALIDATOR
    }

    @SerializedName("ID")
    private PeerID id;

    private String address;

    private Type type;

    private String pkiID;
}
