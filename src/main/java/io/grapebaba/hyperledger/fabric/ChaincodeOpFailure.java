package io.grapebaba.hyperledger.fabric;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChaincodeOpFailure {
    private String jsonrpc;

    private RpcError error;

    private long id;
}
