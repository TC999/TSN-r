package com.clj.fastble.exception;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class GattException extends BleException {
    private int gattStatus;

    public GattException(int i4) {
        super(101, "Gatt Exception Occurred! ");
        this.gattStatus = i4;
    }

    public int getGattStatus() {
        return this.gattStatus;
    }

    public GattException setGattStatus(int i4) {
        this.gattStatus = i4;
        return this;
    }

    @Override // com.clj.fastble.exception.BleException
    public String toString() {
        return "GattException{gattStatus=" + this.gattStatus + "} " + super.toString();
    }
}
