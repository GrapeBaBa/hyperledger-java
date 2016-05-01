package io.grapebaba.hyperledger.fabric;

import lombok.Builder;

@Builder
public class TransactionResult {
    private String uuid;

    private String result;

    private int errorCode;

    private String error;
}
