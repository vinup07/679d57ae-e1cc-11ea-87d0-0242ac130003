package com.telstra.b2b.dig.Tester.utils;

import lombok.Data;

import java.util.List;

@Data
public class SFImport {

    @JsonProperty(value="Order_Id")
    String orderId;

    @JsonProperty(value="Order_Type")
    String orderType;

    @JsonProperty(value="Attached_Mobile_Numbers")
    List<String> Msisdns;
}
