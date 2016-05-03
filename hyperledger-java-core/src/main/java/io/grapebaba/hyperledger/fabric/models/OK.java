package io.grapebaba.hyperledger.fabric.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OK {
    @SerializedName("OK")
    private String ok;

    private String message;
}
