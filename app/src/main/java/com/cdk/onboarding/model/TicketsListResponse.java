package com.cdk.onboarding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TicketsListResponse {

    @SerializedName("data")
    @Expose
    private List<TicketListData> data = new ArrayList<TicketListData>();
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private int status;

    /**
     * @return The data
     */
    public List<TicketListData> getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(List<TicketListData> data) {
        this.data = data;
    }

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(int status) {
        this.status = status;
    }

}