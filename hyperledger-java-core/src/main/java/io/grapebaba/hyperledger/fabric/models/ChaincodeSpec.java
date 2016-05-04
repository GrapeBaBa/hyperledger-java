/*
Copyright 2016 281165273@qq.com

Licensed under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

    [http://www.apache.org/licenses/LICENSE-2.0]

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
*/

package io.grapebaba.hyperledger.fabric.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Model of chaincode spec.
 */
@Builder
@Data
@Slf4j
public class ChaincodeSpec {

    /**
     * Chaincode type.
     */
    public enum Type {
        @SerializedName("0")
        UNDEFINED,
        @SerializedName("1")
        GOLANG,
        @SerializedName("2")
        NODE
    }

    /**
     * Type.
     */
    private Type type;

    /**
     * Chaincode id.
     */
    private ChaincodeID chaincodeID;

    /**
     * Ctor message.
     */
    private ChaincodeInput ctorMsg;

    /**
     * Secure context.
     */
    private String secureContext;

    /**
     * Confidential level.
     */
    private ConfidentialityLevel confidentialityLevel;
}
