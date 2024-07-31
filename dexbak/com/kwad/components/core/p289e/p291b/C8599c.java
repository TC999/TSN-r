package com.kwad.components.core.p289e.p291b;

import com.kwad.sdk.core.p385a.C9886c;
import java.nio.ByteBuffer;
import okhttp3.internal.p629ws.WebSocketProtocol;

/* renamed from: com.kwad.components.core.e.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8599c {

    /* renamed from: Kd */
    private final int[] f28174Kd;

    private C8599c(int[] iArr) {
        this.f28174Kd = iArr;
    }

    /* renamed from: a */
    public static C8599c m30281a(int[] iArr) {
        return new C8599c(iArr);
    }

    /* renamed from: b */
    private static long m30278b(long j, int[] iArr) {
        int i = 31;
        while (i > 23) {
            j = m30276d(i, iArr, j);
            i--;
        }
        while (i > 15) {
            j = m30277c(i, iArr, j);
            i--;
        }
        while (i > 7) {
            j = m30276d(i, iArr, j);
            i--;
        }
        while (i >= 0) {
            j = m30277c(i, iArr, j);
            i--;
        }
        return j;
    }

    /* renamed from: c */
    private static long m30277c(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j4 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = j & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long m30274f = m30274f(i, iArr, j3);
        return ((i + 1) ^ (j2 ^ j3)) | (j5 << 16) | (m30274f << 48) | (j4 << 32);
    }

    /* renamed from: d */
    private static long m30276d(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j4 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = j & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long m30274f = m30274f(i, iArr, j3);
        return (((i + 1) ^ (m30274f(i, iArr, j3) ^ j4)) << 32) | (m30274f << 48) | (j5 << 16) | j2;
    }

    /* renamed from: e */
    private static long m30275e(int i, int[] iArr, long j) {
        int i2 = (int) (j >>> 8);
        int i3 = (int) (j & 255);
        int i4 = i * 4;
        int i5 = iArr[i4 % 10];
        int i6 = iArr[(i4 + 1) % 10];
        int i7 = iArr[(i4 + 2) % 10];
        int i8 = iArr[(i4 + 3) % 10];
        int[] iArr2 = C8598b.f28173Kc;
        int i9 = iArr2[i5 ^ i3] ^ i2;
        int i10 = i3 ^ iArr2[i6 ^ i9];
        int i11 = i9 ^ iArr2[i10 ^ i7];
        return (i11 << 8) | (iArr2[i8 ^ i11] ^ i10);
    }

    /* renamed from: f */
    private static long m30274f(int i, int[] iArr, long j) {
        int i2 = (int) (j >>> 8);
        int i3 = i * 4;
        int i4 = iArr[(i3 + 3) % 10];
        int i5 = iArr[(i3 + 2) % 10];
        int i6 = iArr[(i3 + 1) % 10];
        int i7 = iArr[i3 % 10];
        int[] iArr2 = C8598b.f28173Kc;
        int i8 = iArr2[i4 ^ i2] ^ ((int) (255 & j));
        int i9 = i2 ^ iArr2[i8 ^ i5];
        int i10 = i8 ^ iArr2[i9 ^ i6];
        return ((iArr2[i7 ^ i10] ^ i9) << 8) | i10;
    }

    /* renamed from: ad */
    public final long m30280ad(String str) {
        byte[] decode = C9886c.m27441Dv().decode(str);
        if (decode != null && decode.length == 8) {
            return m30278b(ByteBuffer.wrap(decode).getLong(), this.f28174Kd);
        }
        throw new RuntimeException("fail to decode: " + str);
    }

    /* renamed from: u */
    public final String m30273u(long j) {
        return C9886c.m27443Dt().encodeToString(ByteBuffer.allocate(8).putLong(m30282a(j, this.f28174Kd)).array());
    }

    /* renamed from: a */
    private static long m30282a(long j, int[] iArr) {
        int i = 0;
        while (i < 8) {
            j = m30283a(i, iArr, j);
            i++;
        }
        while (i < 16) {
            j = m30279b(i, iArr, j);
            i++;
        }
        while (i < 24) {
            j = m30283a(i, iArr, j);
            i++;
        }
        while (i < 32) {
            j = m30279b(i, iArr, j);
            i++;
        }
        return j;
    }

    /* renamed from: b */
    private static long m30279b(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j4 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = j & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long m30275e = m30275e(i, iArr, j2);
        return (((i + 1) ^ (j2 ^ j3)) << 16) | (j5 << 48) | (m30275e << 32) | j4;
    }

    /* renamed from: a */
    private static long m30283a(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        return (m30275e(i, iArr, j2) << 32) | ((((j & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ m30275e(i, iArr, j2)) ^ (i + 1)) << 48) | (j3 << 16) | ((j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }
}
