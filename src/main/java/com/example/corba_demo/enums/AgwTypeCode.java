package com.example.corba_demo.enums;

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
