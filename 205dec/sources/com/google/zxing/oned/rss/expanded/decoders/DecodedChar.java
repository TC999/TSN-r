package com.google.zxing.oned.rss.expanded.decoders;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class DecodedChar extends DecodedObject {
    static final char FNC1 = '$';
    private final char value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodedChar(int i4, char c4) {
        super(i4);
        this.value = c4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char getValue() {
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFNC1() {
        return this.value == '$';
    }
}
