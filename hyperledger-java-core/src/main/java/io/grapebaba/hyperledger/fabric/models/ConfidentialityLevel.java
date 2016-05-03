package io.grapebaba.hyperledger.fabric.models;


import com.google.gson.annotations.SerializedName;

public enum ConfidentialityLevel {
    @SerializedName("0")
    PUBLIC,
    @SerializedName("1")
    CONFIDENTIAL
}
