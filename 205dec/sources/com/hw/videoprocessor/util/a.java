package com.hw.videoprocessor.util;

import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: AudioFadeUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {
    public static void a(String str, int i4, int i5, float f4, float f5) throws IOException {
        float f6 = ((i4 * 16) / 8) * i5;
        int i6 = (int) (f4 * f6);
        int i7 = (int) (f6 * f5);
        byte[] bArr = new byte[i6];
        byte[] bArr2 = new byte[i7];
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        randomAccessFile.read(bArr, 0, i6);
        long j4 = i7;
        randomAccessFile.seek((int) (randomAccessFile.length() - j4));
        randomAccessFile.read(bArr2, 0, i7);
        b(bArr);
        c(bArr2);
        randomAccessFile.seek(0L);
        randomAccessFile.write(bArr, 0, i6);
        randomAccessFile.seek((int) (randomAccessFile.length() - j4));
        randomAccessFile.write(bArr2, 0, i7);
        randomAccessFile.close();
    }

    private static void b(byte[] bArr) {
        float length = 1.0f / (bArr.length / 2.0f);
        float f4 = 0.0f;
        for (int i4 = 0; i4 < bArr.length; i4 += 2) {
            int i5 = i4 + 1;
            int i6 = (int) (((short) ((bArr[i4] & 255) | ((bArr[i5] & 255) << 8))) * f4);
            if (i6 > 32767) {
                i6 = 32767;
            } else if (i6 < -32768) {
                i6 = -32768;
            }
            bArr[i4] = (byte) (i6 & 255);
            bArr[i5] = (byte) ((i6 >>> 8) & 255);
            f4 += length;
        }
    }

    private static void c(byte[] bArr) {
        float f4 = 1.0f;
        float length = 1.0f / (bArr.length / 2.0f);
        for (int i4 = 0; i4 < bArr.length; i4 += 2) {
            int i5 = i4 + 1;
            int i6 = (int) (((short) ((bArr[i4] & 255) | ((bArr[i5] & 255) << 8))) * f4);
            if (i6 > 32767) {
                i6 = 32767;
            } else if (i6 < -32768) {
                i6 = -32768;
            }
            bArr[i4] = (byte) (i6 & 255);
            bArr[i5] = (byte) ((i6 >>> 8) & 255);
            f4 -= length;
        }
    }
}
