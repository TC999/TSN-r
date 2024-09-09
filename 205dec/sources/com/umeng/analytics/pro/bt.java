package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TByteArrayOutputStream.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bt extends ByteArrayOutputStream {
    public bt(int i4) {
        super(i4);
    }

    public byte[] a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int b() {
        return ((ByteArrayOutputStream) this).count;
    }

    public bt() {
    }
}
