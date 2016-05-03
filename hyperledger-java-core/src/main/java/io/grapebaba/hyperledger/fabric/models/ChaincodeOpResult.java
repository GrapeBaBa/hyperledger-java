package io.grapebaba.hyperledger.fabric.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChaincodeOpResult {
    private String jsonrpc;

    private long id;

    private RpcError error;

    private RpcResponse result;
}
