package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* renamed from: com.umeng.analytics.pro.bt */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TByteArrayOutputStream extends ByteArrayOutputStream {
    public TByteArrayOutputStream(int i) {
        super(i);
    }

    /* renamed from: a */
    public byte[] m14523a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    /* renamed from: b */
    public int m14522b() {
        return ((ByteArrayOutputStream) this).count;
    }

    public TByteArrayOutputStream() {
    }
}
