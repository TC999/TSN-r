package com.clj.fastble.exception;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class BleException implements Serializable {
    public static final int ERROR_CODE_GATT = 101;
    public static final int ERROR_CODE_OTHER = 102;
    public static final int ERROR_CODE_TIMEOUT = 100;
    private static final long serialVersionUID = 8004414918500865564L;
    private int code;
    private String description;

    public BleException(int i4, String str) {
        this.code = i4;
        this.description = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public BleException setCode(int i4) {
        this.code = i4;
        return this;
    }

    public BleException setDescription(String str) {
        this.description = str;
        return this;
    }

    public String toString() {
        return "BleException { code=" + this.code + ", description='" + this.description + "'}";
    }
}
