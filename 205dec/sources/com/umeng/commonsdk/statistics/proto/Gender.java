package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bv;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum Gender implements bv {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);
    
    private final int value;

    Gender(int i4) {
        this.value = i4;
    }

    public static Gender findByValue(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return null;
                }
                return UNKNOWN;
            }
            return FEMALE;
        }
        return MALE;
    }

    @Override // com.umeng.analytics.pro.bv
    public int getValue() {
        return this.value;
    }
}
