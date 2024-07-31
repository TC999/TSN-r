package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.TEnum;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum Gender implements TEnum {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);
    
    private final int value;

    Gender(int i) {
        this.value = i;
    }

    public static Gender findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return UNKNOWN;
            }
            return FEMALE;
        }
        return MALE;
    }

    @Override // com.umeng.analytics.pro.TEnum
    public int getValue() {
        return this.value;
    }
}
