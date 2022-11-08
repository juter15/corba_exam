package com.example.corba_demo.enums;

public enum AlarmData {
    MIN("MINOR", (short)4),
    MAJ("MAJOR", (short)3),
    CRI("CRITICAL", (short)6),
    DIS("DISCONN", (short) 99),
    CONN("", (short)99);
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
