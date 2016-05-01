package io.grapebaba.hyperledger.fabric;

import lombok.Builder;

@Builder
public class Timestamp {
    private long seconds;

    private int nanos;
}
