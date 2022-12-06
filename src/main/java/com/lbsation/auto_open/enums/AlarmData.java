package com.lbsation.auto_open.enums;

public enum AlarmData {
    CRI("CRITICAL", (short)2),
    MAJ("MAJOR", (short)3),
    MIN("MINOR", (short)4),
    DIS("DISCONN", (short) 2),
    CLEAR("CLEAR", (short) 6),
    CONN("CONN", (short)6);
    private String alarmGrade;
    private short serverity;

    AlarmData(String alarmGrade, short serverity) {
        this.alarmGrade = alarmGrade;
        this.serverity = serverity;
    }

    public String getAlarmGrade(){
        return this.alarmGrade;
    }

    public short getServerity(){
        return this.serverity;
    }
}
