package io.grapebaba.hyperledger.fabric;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Builder
@Data
public class Block {
    @Singular
    private List<Transaction> transactions;

    private Timestamp timestamp;

    private String transactionsHash;

    private String stateHash;

    private String previousBlockHash;

    private String consensusMetadata;

    private String nonHashData;
}
