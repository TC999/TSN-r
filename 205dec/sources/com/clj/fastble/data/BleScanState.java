package com.clj.fastble.data;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public enum BleScanState {
    STATE_IDLE(-1),
    STATE_SCANNING(1);
    
    private int code;

    BleScanState(int i4) {
        this.code = i4;
    }

    public int getCode() {
        return this.code;
    }
}
