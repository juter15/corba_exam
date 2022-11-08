package com.lbsation.auto_open.enums;

public enum AgwTypeCode {
    MERCURY_AGW((short) 94);
    private short agwTypeCode;

    AgwTypeCode(short agwTypeCode) {
        this.agwTypeCode = agwTypeCode;
    }

    public short getAgwTypeCode(){
        return this.agwTypeCode;
    }
}
