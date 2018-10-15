package com.usc.Response;

/**
 * @Author Weever Lu
 * @Date Oct 14, 2017
 */
public class SingleResponse<T> {
    private Integer status;
    private T data;

    public SingleResponse(){

    }

    public SingleResponse(Integer status, T data){
        this.status = status;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
