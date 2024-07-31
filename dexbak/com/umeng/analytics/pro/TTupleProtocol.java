package com.umeng.analytics.pro;

import java.util.BitSet;

/* renamed from: com.umeng.analytics.pro.cw */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class TTupleProtocol extends TCompactProtocol {

    /* compiled from: TTupleProtocol.java */
    /* renamed from: com.umeng.analytics.pro.cw$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13142a implements TProtocolFactory {
        @Override // com.umeng.analytics.pro.TProtocolFactory
        /* renamed from: a */
        public TProtocol mo14389a(TTransport tTransport) {
            return new TTupleProtocol(tTransport);
        }
    }

    public TTupleProtocol(TTransport tTransport) {
        super(tTransport);
    }

    @Override // com.umeng.analytics.pro.TProtocol
    /* renamed from: D */
    public Class<? extends IScheme> mo14394D() {
        return TupleScheme.class;
    }

    /* renamed from: a */
    public void m14393a(BitSet bitSet, int i) throws TException {
        for (byte b : m14390b(bitSet, i)) {
            mo14438a(b);
        }
    }

    /* renamed from: b */
    public BitSet m14391b(int i) throws TException {
        double d = i;
        Double.isNaN(d);
        int ceil = (int) Math.ceil(d / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            bArr[i2] = mo14405u();
        }
        return m14392a(bArr);
    }

    /* renamed from: a */
    public static BitSet m14392a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    /* renamed from: b */
    public static byte[] m14390b(BitSet bitSet, int i) {
        double d = i;
        Double.isNaN(d);
        int ceil = (int) Math.ceil(d / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int i3 = (ceil - (i2 / 8)) - 1;
                bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
            }
        }
        return bArr;
    }
}
