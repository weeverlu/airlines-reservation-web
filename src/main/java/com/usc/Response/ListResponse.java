package com.usc.Response;

import java.util.List;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
public class ListResponse<T> {
    private Integer status;
    private List<T> list;

    public ListResponse(){

    }

    public ListResponse(Integer status, List<T> list) {
        this.status = status;
        this.list = list;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
