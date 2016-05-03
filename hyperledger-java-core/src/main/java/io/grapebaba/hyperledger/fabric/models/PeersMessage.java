package io.grapebaba.hyperledger.fabric.models;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Builder
@Data
public class PeersMessage {
    @Singular
    private List<PeerEndpoint> peers;
}
