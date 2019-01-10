package com.boot.common.exception;

/**
 * 业务异常
 *
 * @author caiqingmao
 */
public class UnionServiceException extends RuntimeException {
    private String serviceMsg;

    public UnionServiceException() {
        super();
        this.serviceMsg = "";
    }

    public UnionServiceException(String serviceMsg) {
        super(serviceMsg, null);
        this.serviceMsg = serviceMsg;
    }

    public UnionServiceException(String msg, Throwable cause) {
        super(msg, cause);
        this.serviceMsg = msg;
    }

    public UnionServiceException(Throwable cause) {
        super(cause);
    }

    public UnionServiceException(String serviceMsg, String exceptionMsg) {
        super(exceptionMsg, null);
        this.serviceMsg = serviceMsg;
    }

    public UnionServiceException(String serviceMsg, String exceptionMsg, Throwable cause) {
        super(exceptionMsg, cause);
        this.serviceMsg = serviceMsg;
    }

    public String getServiceMsg() {
        return serviceMsg;
    }

}
