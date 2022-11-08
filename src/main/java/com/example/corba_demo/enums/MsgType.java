package com.example.corba_demo.enums;

public enum MsgType {
    MSGTYPE_Alarm((short) 1);
    private short msgType;

    MsgType(short msgType) {
        this.msgType = msgType;
    }

    public short getMsgType() {
        return msgType;
    }
}
