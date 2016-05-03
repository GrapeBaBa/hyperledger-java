package io.grapebaba.hyperledger.fabric.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionResult {
    private String uuid;

    private String result;

    private int errorCode;

    private String error;
}
