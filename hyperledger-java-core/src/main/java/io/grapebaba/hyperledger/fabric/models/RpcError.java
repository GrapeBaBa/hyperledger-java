package io.grapebaba.hyperledger.fabric.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RpcError {
    private long code;

    private String message;

    private String data;
}
