package com.boot.common.entity;

import com.boot.common.entity.JsonCommonResponse;
import com.boot.common.enums.ResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author caiqingmao
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class JsonDataResponse<T> extends JsonCommonResponse {
    private T data;

    public static <T> JsonDataResponse<T> success() {
        return success(null);
    }
    public static <T> JsonDataResponse<T> success(T data) {
        JsonDataResponse<T> commonResponse = new JsonDataResponse<T>();
        commonResponse.setSuccess(true);
        commonResponse.setCode(ResponseEnum.SUCCESS.getCode());
        commonResponse.setMsg(ResponseEnum.SUCCESS.getMessage());
        commonResponse.setData(data);
        return commonResponse;
    }
    public static <T> JsonDataResponse<T> faild(ResponseEnum code) {
        return faild(code.getCode(), code.getMessage());
    }
    public static <T> JsonDataResponse<T> faild(ResponseEnum code,String msg) {
        return faild(code.getCode(), msg);
    }
    public static <T> JsonDataResponse<T> faild(String code,String msg) {
        JsonDataResponse<T> commonResponse = new JsonDataResponse<T>();
        commonResponse.setSuccess(true);
        commonResponse.setCode(code);
        commonResponse.setMsg(msg);
        return commonResponse;
    }
}
