package com.p201hw.videoprocessor.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.UByte;

/* renamed from: com.hw.videoprocessor.util.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AudioFadeUtil {
    /* renamed from: a */
    public static void m34926a(String str, int i, int i2, float f, float f2) throws IOException {
        float f3 = ((i * 16) / 8) * i2;
        int i3 = (int) (f * f3);
        int i4 = (int) (f3 * f2);
        byte[] bArr = new byte[i3];
        byte[] bArr2 = new byte[i4];
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        randomAccessFile.read(bArr, 0, i3);
        long j = i4;
        randomAccessFile.seek((int) (randomAccessFile.length() - j));
        randomAccessFile.read(bArr2, 0, i4);
        m34925b(bArr);
        m34924c(bArr2);
        randomAccessFile.seek(0L);
        randomAccessFile.write(bArr, 0, i3);
        randomAccessFile.seek((int) (randomAccessFile.length() - j));
        randomAccessFile.write(bArr2, 0, i4);
        randomAccessFile.close();
    }

    /* renamed from: b */
    private static void m34925b(byte[] bArr) {
        float length = 1.0f / (bArr.length / 2.0f);
        float f = 0.0f;
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = i + 1;
            int i3 = (int) (((short) ((bArr[i] & UByte.f41242c) | ((bArr[i2] & UByte.f41242c) << 8))) * f);
            if (i3 > 32767) {
                i3 = 32767;
            } else if (i3 < -32768) {
                i3 = -32768;
            }
            bArr[i] = (byte) (i3 & 255);
            bArr[i2] = (byte) ((i3 >>> 8) & 255);
            f += length;
        }
    }

    /* renamed from: c */
    private static void m34924c(byte[] bArr) {
        float f = 1.0f;
        float length = 1.0f / (bArr.length / 2.0f);
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = i + 1;
            int i3 = (int) (((short) ((bArr[i] & UByte.f41242c) | ((bArr[i2] & UByte.f41242c) << 8))) * f);
            if (i3 > 32767) {
                i3 = 32767;
            } else if (i3 < -32768) {
                i3 = -32768;
            }
            bArr[i] = (byte) (i3 & 255);
            bArr[i2] = (byte) ((i3 >>> 8) & 255);
            f -= length;
        }
    }
}
