package com.lbsation.auto_open.enums;

public enum AlarmData {
    CRI("CRITICAL", (short)2),
    MAJ("MAJOR", (short)3),
    MIN("MINOR", (short)4),
    DIS("DISCONN", (short) 99);
   // CONN("", (short)99);
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
