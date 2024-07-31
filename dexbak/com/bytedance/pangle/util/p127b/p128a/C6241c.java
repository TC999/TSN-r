package com.bytedance.pangle.util.p127b.p128a;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import kotlin.UByte;

/* renamed from: com.bytedance.pangle.util.b.a.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6241c {

    /* renamed from: a */
    public final byte[] f22214a = new byte[2];

    /* renamed from: b */
    private final byte[] f22215b = new byte[4];

    /* renamed from: a */
    public final int m36919a(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f22215b);
        return m36915b(this.f22215b);
    }

    /* renamed from: b */
    public final int m36916b(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.f22214a);
        return m36918a(this.f22214a);
    }

    /* renamed from: b */
    private static int m36915b(byte[] bArr) {
        return ((((bArr[3] & UByte.f41242c) << 8) | (bArr[2] & UByte.f41242c)) << 16) | (bArr[0] & UByte.f41242c) | ((bArr[1] & UByte.f41242c) << 8);
    }

    /* renamed from: a */
    public final void m36921a(ByteArrayOutputStream byteArrayOutputStream, int i) {
        m36917a(this.f22214a, i);
        byteArrayOutputStream.write(this.f22214a);
    }

    /* renamed from: b */
    private static void m36914b(byte[] bArr, int i) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    /* renamed from: a */
    public final void m36920a(OutputStream outputStream, int i) {
        m36914b(this.f22215b, i);
        outputStream.write(this.f22215b);
    }

    /* renamed from: a */
    private static int m36918a(byte[] bArr) {
        return ((bArr[1] & UByte.f41242c) << 8) | (bArr[0] & UByte.f41242c);
    }

    /* renamed from: a */
    public static void m36917a(byte[] bArr, int i) {
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }
}
