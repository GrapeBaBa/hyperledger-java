package io.grapebaba.hyperledger.fabric;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RpcResponse {
  private String Status;

  private String Message;

}
