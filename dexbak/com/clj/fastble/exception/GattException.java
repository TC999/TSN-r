package com.clj.fastble.exception;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GattException extends BleException {
    private int gattStatus;

    public GattException(int i) {
        super(101, "Gatt Exception Occurred! ");
        this.gattStatus = i;
    }

    public int getGattStatus() {
        return this.gattStatus;
    }

    public GattException setGattStatus(int i) {
        this.gattStatus = i;
        return this;
    }

    @Override // com.clj.fastble.exception.BleException
    public String toString() {
        return "GattException{gattStatus=" + this.gattStatus + "} " + super.toString();
    }
}
