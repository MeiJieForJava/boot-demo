package com.boot.common.exception;

/**
 * 专门用于处理审核消息从数据库读取ad/ad_modify_audit时取不到数的情况<br/>
 * 取不到数两种可能：<br/>
 * 1提交ad的commit没有执行完，2提交ad出错回滚缺失没有数据(用jmq超时跳过线上设置120000ms)
 *
 * @author chengchao1
 */
public class DspMqException extends RuntimeException {

    private static final long serialVersionUID = -4697053430656515267L;

    public DspMqException() {
        super();
    }

    public DspMqException(String message) {
        super(message);
    }
}
