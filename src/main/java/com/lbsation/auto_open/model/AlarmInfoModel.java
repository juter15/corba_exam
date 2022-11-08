package com.lbsation.auto_open.model;

import com.lbsation.auto_open.enums.OnOff;
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
