package io.grapebaba.hyperledger.fabric;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Secret {
    private String enrollId;

    private String enrollSecret;

}
