package com.lbsation.auto_open.enums;

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
