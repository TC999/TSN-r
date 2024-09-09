package com.google.zxing.oned.rss.expanded.decoders;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class DecodedInformation extends DecodedObject {
    private final String newString;
    private final boolean remaining;
    private final int remainingValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodedInformation(int i4, String str) {
        super(i4);
        this.newString = str;
        this.remaining = false;
        this.remainingValue = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getNewString() {
        return this.newString;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRemainingValue() {
        return this.remainingValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isRemaining() {
        return this.remaining;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodedInformation(int i4, String str, int i5) {
        super(i4);
        this.remaining = true;
        this.remainingValue = i5;
        this.newString = str;
    }
}
