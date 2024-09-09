package com.tencent.gatherer.a.a.a.g;

import java.nio.ByteBuffer;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {
    public static short a(ByteBuffer byteBuffer) {
        return (short) (byteBuffer.get() & 255);
    }

    public static long b(ByteBuffer byteBuffer) {
        return byteBuffer.getInt() & 4294967295L;
    }

    public static void a(ByteBuffer byteBuffer, int i4) {
        byteBuffer.position(i4);
    }

    public static byte[] b(ByteBuffer byteBuffer, int i4) {
        byte[] bArr = new byte[i4];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static void a(ByteBuffer byteBuffer, long j4) {
        a(byteBuffer, d.a(j4));
    }
}
