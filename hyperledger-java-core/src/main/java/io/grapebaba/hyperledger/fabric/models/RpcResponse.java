package io.grapebaba.hyperledger.fabric.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RpcResponse {
  private String status;

  private String message;

}
