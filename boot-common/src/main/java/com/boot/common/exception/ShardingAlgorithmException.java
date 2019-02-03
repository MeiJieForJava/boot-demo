package com.boot.common.exception;

/**
 * Created by meijie on 2019/2/3.
 */
public class ShardingAlgorithmException extends RuntimeException {

    private String serviceMsg;

    public ShardingAlgorithmException() {
        super();
        this.serviceMsg = "";
    }

    public ShardingAlgorithmException(String serviceMsg) {
        super(serviceMsg, null);
        this.serviceMsg = serviceMsg;
    }

    public ShardingAlgorithmException(String msg, Throwable cause) {
        super(msg, cause);
        this.serviceMsg = msg;
    }

    public ShardingAlgorithmException(Throwable cause) {
        super(cause);
    }

    public ShardingAlgorithmException(String serviceMsg, String exceptionMsg) {
        super(exceptionMsg, null);
        this.serviceMsg = serviceMsg;
    }

    public ShardingAlgorithmException(String serviceMsg, String exceptionMsg, Throwable cause) {
        super(exceptionMsg, cause);
        this.serviceMsg = serviceMsg;
    }

    public String getServiceMsg() {
        return serviceMsg;
    }


}
