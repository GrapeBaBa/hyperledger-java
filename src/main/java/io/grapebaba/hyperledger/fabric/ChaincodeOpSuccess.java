package io.grapebaba.hyperledger.fabric;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChaincodeOpSuccess {
   private String jsonrpc;

   private RpcResponse result;

   private long id;

}
