package io.grapebaba.hyperledger.fabric.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChaincodeID {
    private String path;

    private String name;
}
