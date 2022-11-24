package com.lbsation.auto_open.enums;

public enum RecvItType {
    EMSINFO("7C002000"),
    SESSIONINFO("50000000"),
    EQUIPIFO("7d000001")
    ;

    private String typeHax;
    RecvItType(String typeHax) {
        this.typeHax = typeHax;
    }

    public String getTypeHax() {
        return typeHax;
    }
}
