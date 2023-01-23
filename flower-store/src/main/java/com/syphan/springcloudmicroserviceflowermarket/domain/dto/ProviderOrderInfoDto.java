package com.syphan.springcloudmicroserviceflowermarket.domain.dto;

public class ProviderOrderInfoDto {

    private long id;

    private int leadTime;


    public ProviderOrderInfoDto() { }

    public ProviderOrderInfoDto(long id, int leadTime) {
        this.id = id;
        this.leadTime = leadTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(int leadTime) {
        this.leadTime = leadTime;
    }
}
