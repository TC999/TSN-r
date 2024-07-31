package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.m8 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RootTUploadData extends Table {
    /* renamed from: a */
    private static int m54464a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.m53692n();
    }

    /* renamed from: b */
    public static int m54463b(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3) {
        flatBufferBuilder.m53689q(3);
        m54457h(flatBufferBuilder, i3);
        m54458g(flatBufferBuilder, i2);
        m54460e(flatBufferBuilder, i);
        return m54464a(flatBufferBuilder);
    }

    /* renamed from: c */
    public static int m54462c(FlatBufferBuilder flatBufferBuilder, byte[] bArr) {
        flatBufferBuilder.m53698h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.m53702d(bArr[length]);
        }
        return flatBufferBuilder.m53705a();
    }

    /* renamed from: d */
    public static int m54461d(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.m53698h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.m53701e(iArr[length]);
        }
        return flatBufferBuilder.m53705a();
    }

    /* renamed from: e */
    private static void m54460e(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53688r(0, i);
    }

    /* renamed from: f */
    public static int m54459f(FlatBufferBuilder flatBufferBuilder, byte[] bArr) {
        flatBufferBuilder.m53698h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.m53702d(bArr[length]);
        }
        return flatBufferBuilder.m53705a();
    }

    /* renamed from: g */
    private static void m54458g(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53688r(1, i);
    }

    /* renamed from: h */
    private static void m54457h(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53688r(2, i);
    }
}
