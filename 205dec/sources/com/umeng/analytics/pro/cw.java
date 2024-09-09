package com.umeng.analytics.pro;

import java.util.BitSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TTupleProtocol.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class cw extends ck {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TTupleProtocol.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a implements cs {
        @Override // com.umeng.analytics.pro.cs
        public cq a(de deVar) {
            return new cw(deVar);
        }
    }

    public cw(de deVar) {
        super(deVar);
    }

    @Override // com.umeng.analytics.pro.cq
    public Class<? extends cy> D() {
        return db.class;
    }

    public void a(BitSet bitSet, int i4) throws bx {
        for (byte b4 : b(bitSet, i4)) {
            a(b4);
        }
    }

    public BitSet b(int i4) throws bx {
        double d4 = i4;
        Double.isNaN(d4);
        int ceil = (int) Math.ceil(d4 / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i5 = 0; i5 < ceil; i5++) {
            bArr[i5] = u();
        }
        return a(bArr);
    }

    public static BitSet a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i4 = 0; i4 < bArr.length * 8; i4++) {
            if ((bArr[(bArr.length - (i4 / 8)) - 1] & (1 << (i4 % 8))) > 0) {
                bitSet.set(i4);
            }
        }
        return bitSet;
    }

    public static byte[] b(BitSet bitSet, int i4) {
        double d4 = i4;
        Double.isNaN(d4);
        int ceil = (int) Math.ceil(d4 / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i5 = 0; i5 < bitSet.length(); i5++) {
            if (bitSet.get(i5)) {
                int i6 = (ceil - (i5 / 8)) - 1;
                bArr[i6] = (byte) ((1 << (i5 % 8)) | bArr[i6]);
            }
        }
        return bArr;
    }
}
