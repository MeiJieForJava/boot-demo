package com.boot.common.exception;

/**
 * 业务异常
 *
 * @author caiqingmao
 */
public class ServiceException extends RuntimeException {
    private String serviceMsg;

    public ServiceException() {
        super();
        this.serviceMsg = "";
    }

    public ServiceException(String serviceMsg) {
        super(serviceMsg, null);
        this.serviceMsg = serviceMsg;
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
        this.serviceMsg = msg;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String serviceMsg, String exceptionMsg) {
        super(exceptionMsg, null);
        this.serviceMsg = serviceMsg;
    }

    public ServiceException(String serviceMsg, String exceptionMsg, Throwable cause) {
        super(exceptionMsg, cause);
        this.serviceMsg = serviceMsg;
    }

    public String getServiceMsg() {
        return serviceMsg;
    }

}
