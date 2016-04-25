package io.grapebaba.hyperledger.fabric;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Builder
@Data
public class ChaincodeInput {
    private String type;

    @Singular
    private List<String> args;
}
