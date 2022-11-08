package com.example.corba_demo.model;

import com.example.corba_demo.enums.AlarmData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AlarmModel {

    @JsonProperty("ALARM_KEY")
    private String alarmKey;
    @JsonProperty("TID")
    private String tid;
    @JsonProperty("MASTER_TID")
    private String masterTid;
    @JsonProperty("AGW_NAME")
    private String agwName;
    @JsonProperty("AGW_TYPE")
    private String agwType;
    @JsonProperty("MIH_IP")
    private String mihIp;
    @JsonProperty("AGW_ID")
    private String agwId;
    @JsonProperty("GROUP_ID_1")
    private String GroupId1;
    @JsonProperty("GROUP_ID_2")
    private String GroupId2;
    @JsonProperty("GROUP_ID_3")
    private String GroupId3;
    @JsonProperty("GROUP_ID_4")
    private String GroupId4;
    @JsonProperty("GROUP_NAME_1")
    private String GroupName1;
    @JsonProperty("GROUP_NAME_2")
    private String GroupName2;
    @JsonProperty("GROUP_NAME_3")
    private String GroupName3;
    @JsonProperty("GROUP_NAME_4")
    private String GroupName4;
    @JsonProperty("ALARM_CODE")
    private String alarmCode;
    @JsonProperty("ALARM_GRADE")
    private AlarmData alarmData;
    @JsonProperty("CREATE_TIME")
    private String createTime;
    @JsonProperty("INFORMATION")
    private String information;

}
