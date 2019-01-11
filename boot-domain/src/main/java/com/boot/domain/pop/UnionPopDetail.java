package com.boot.domain.pop;

import com.boot.domain.base.IDomain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/11/13
 * Time : 11:02
 */
@Data
@ToString
public class UnionPopDetail implements IDomain {

    private long pk;
    private Long popId;
    private Long shopId;
    private String popName;
    private String pin;
    private int status;
    private String popQQ;
    private Date insertTime;
    private Date updateTime;
    private Integer agreeStatus;
    private Integer freezeState;

    private String adowner;
    private Integer adownerType;
    private String financepin;
    private String supplierCode;

    private Date lateloginTime;
    private Date indexloginTime;

    private String accountNo;

    /***
     * add by liuqun 20151224 增加用户子类型字段
     */
    private Integer ufnType;

    /**
     * 店铺url(pc端)
     */
    private String shopUrl;
    //2014-12-18	日新增字段
    /**
     * 店铺主图url(pc端)
     */
    private String shopMainurl;
    /**
     * 店铺主图url(移动端)
     */
    private String mobileShopMainurl;
    /**
     * 店铺url(移动端)
     */
    private String mobileShopUrl;

    /**
     * add by meijie pop结算接口升级jsf
     */
    private Integer colType;//判断商品的仓库信息，00是SOP(自己的仓库) 1是FBP(京东的仓库)

    private Integer isAgreeCpa;//是否同意CPA协议 0否1是

    private Date agreeCpaTime;//同意CPA协议时间

    private Integer financialPer;//pop商家账期类型：1月结, 2半月结, 3旬结, 负数为t+1商家

    private String mainCategoryIds;

    private String mainCategoryNames;

    private Date taskListTime;

    private String remark;

    private Integer quitStatus;

    private Date quitTime;

    public Date getTaskListTime() {
        return taskListTime;
    }

    public void setTaskListTime(Date taskListTime) {
        this.taskListTime = taskListTime;
    }

    private int agreeWx;//是否已同意无限期补充协议,0否1是

    private Date agreeWxTime;//同意无限期补充协议时间

    private int agreeTripartite;//是否已同意无限期补充协议,0否1是

    private Date agreeTripartiteTime;//同意无限期补充协议时间

    private Integer autoAssign;//充值类商家是否同意欠款发生时系统自动从商家账号划拨：1表示已同意，0或null未同意

}
