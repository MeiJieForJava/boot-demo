package com.boot.domain.user;

import lombok.Data;
import lombok.ToString;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/11/13
 * Time : 11:02
 */
@Data
@ToString
public class User {

    private String name;

    private String address;

    private Integer age;

    private Long id;

    private Integer status;

    private String userId;



}
