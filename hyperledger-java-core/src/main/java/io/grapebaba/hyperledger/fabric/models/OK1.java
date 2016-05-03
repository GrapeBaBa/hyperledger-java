package io.grapebaba.hyperledger.fabric.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Builder
@Data
public class OK1 {
    @Singular("ok")
    @SerializedName("OK")
    private List<String> ok;

    private String message;
}
