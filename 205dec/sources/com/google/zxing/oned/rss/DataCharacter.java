package com.google.zxing.oned.rss;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DataCharacter {
    private final int checksumPortion;
    private final int value;

    public DataCharacter(int i4, int i5) {
        this.value = i4;
        this.checksumPortion = i5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DataCharacter) {
            DataCharacter dataCharacter = (DataCharacter) obj;
            return this.value == dataCharacter.value && this.checksumPortion == dataCharacter.checksumPortion;
        }
        return false;
    }

    public final int getChecksumPortion() {
        return this.checksumPortion;
    }

    public final int getValue() {
        return this.value;
    }

    public final int hashCode() {
        return this.value ^ this.checksumPortion;
    }

    public final String toString() {
        return this.value + "(" + this.checksumPortion + ')';
    }
}