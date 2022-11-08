package com.example.corba_demo.enums;

public enum OnOff {
    ON(1),
    OFF(0);

    private int onOffValue;

    OnOff(int onOffValue) {
        this.onOffValue = onOffValue;
    }


    public int getOnOffValue(){
        return this.onOffValue;
    }

    public static OnOff getOnOff(int onOffValue){
        if(onOffValue == OnOff.ON.getOnOffValue()){
            return OnOff.ON;
        }
        else{
            return OnOff.OFF;
        }
    }
}
