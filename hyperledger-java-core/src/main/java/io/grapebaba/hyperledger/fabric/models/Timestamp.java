package io.grapebaba.hyperledger.fabric.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Timestamp {
    private long seconds;

    private int nanos;
}
