package com.boot.common.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class JsonCommonResponse {
    private boolean success;
    private String code;
    private String msg;
}
