package com.google.zxing.pdf417.encoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class BarcodeRow {
    private int currentLocation = 0;
    private final byte[] row;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BarcodeRow(int i4) {
        this.row = new byte[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addBar(boolean z3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.currentLocation;
            this.currentLocation = i6 + 1;
            set(i6, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getScaledRow(int i4) {
        int length = this.row.length * i4;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr[i5] = this.row[i5 / i4];
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(int i4, byte b4) {
        this.row[i4] = b4;
    }

    private void set(int i4, boolean z3) {
        this.row[i4] = z3 ? (byte) 1 : (byte) 0;
    }
}
