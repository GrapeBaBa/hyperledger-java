package io.grapebaba.hyperledger.fabric.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Secret {
    private String enrollId;

    private String enrollSecret;

}
