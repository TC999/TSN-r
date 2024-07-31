package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.o8 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TCell extends Table {
    /* renamed from: a */
    private static int m54361a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.m53692n();
    }

    /* renamed from: b */
    public static int m54360b(FlatBufferBuilder flatBufferBuilder, int i, byte b, int i2, int i3) {
        flatBufferBuilder.m53689q(4);
        m54354h(flatBufferBuilder, i3);
        m54355g(flatBufferBuilder, i2);
        m54357e(flatBufferBuilder, i);
        m54358d(flatBufferBuilder, b);
        return m54361a(flatBufferBuilder);
    }

    /* renamed from: c */
    public static int m54359c(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.m53698h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.m53701e(iArr[length]);
        }
        return flatBufferBuilder.m53705a();
    }

    /* renamed from: d */
    private static void m54358d(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.m53700f(1, b);
    }

    /* renamed from: e */
    private static void m54357e(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53688r(0, i);
    }

    /* renamed from: f */
    public static int m54356f(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.m53698h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.m53701e(iArr[length]);
        }
        return flatBufferBuilder.m53705a();
    }

    /* renamed from: g */
    private static void m54355g(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53688r(2, i);
    }

    /* renamed from: h */
    private static void m54354h(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53688r(3, i);
    }
}
