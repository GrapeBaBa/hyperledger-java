package io.grapebaba.hyperledger.fabric.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Error {
    @SerializedName("Error")
    private String error;
}
