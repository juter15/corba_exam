package com.example.corba_demo.model;

import com.example.corba_demo.enums.OnOff;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AlarmInfoModel {
    @JsonProperty("ONOFF")
    private OnOff onoff;
    @JsonProperty("TYPE")
    private String type;
    @JsonProperty("ALARM")
    private List<AlarmModel> alarmModel;
}
