/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;
import com.dp.model.ApexBean;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;
/**
 *
 * @author Siddhrajsinh_Atodari
 */
public class AjaxResponseBody {

    @JsonView(Views.Public.class)
    String msg;

    @JsonView(Views.Public.class)
    String code;

    @JsonView(Views.Public.class)
    List<ApexBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ApexBean> getResult() {
        return result;
    }

    public void setResult(List<ApexBean> result) {
        this.result = result;
    }

}
