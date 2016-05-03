package io.grapebaba.hyperledger.fabric.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChaincodeOpPayload {
    private String jsonrpc;

    private String method;

    private ChaincodeSpec params;

    private long id;
}
