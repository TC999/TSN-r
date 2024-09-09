package com.bytedance.pangle.util.b.a;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f28984a = new byte[2];

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f28985b = new byte[4];

    public final int a(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f28985b);
        return b(this.f28985b);
    }

    public final int b(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f28984a);
        return a(this.f28984a);
    }

    private static int b(byte[] bArr) {
        return ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16) | (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream, int i4) {
        a(this.f28984a, i4);
        byteArrayOutputStream.write(this.f28984a);
    }

    private static void b(byte[] bArr, int i4) {
        bArr[3] = (byte) (i4 >>> 24);
        bArr[2] = (byte) (i4 >>> 16);
        bArr[1] = (byte) (i4 >>> 8);
        bArr[0] = (byte) (i4 & 255);
    }

    public final void a(OutputStream outputStream, int i4) {
        b(this.f28985b, i4);
        outputStream.write(this.f28985b);
    }

    private static int a(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    public static void a(byte[] bArr, int i4) {
        bArr[1] = (byte) (i4 >>> 8);
        bArr[0] = (byte) (i4 & 255);
    }
}
