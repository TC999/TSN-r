package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.w8 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TMainCellCDMAHistory extends Table {
    /* renamed from: a */
    public static int m53575a(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, short s) {
        flatBufferBuilder.m53689q(5);
        m53569g(flatBufferBuilder, i3);
        m53570f(flatBufferBuilder, i2);
        m53573c(flatBufferBuilder, i);
        m53572d(flatBufferBuilder, s);
        m53574b(flatBufferBuilder);
        return m53571e(flatBufferBuilder);
    }

    /* renamed from: b */
    private static void m53574b(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.m53700f(0, (byte) 2);
    }

    /* renamed from: c */
    private static void m53573c(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53699g(1, i);
    }

    /* renamed from: d */
    private static void m53572d(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.m53696j(4, s);
    }

    /* renamed from: e */
    private static int m53571e(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.m53692n();
    }

    /* renamed from: f */
    private static void m53570f(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53699g(2, i);
    }

    /* renamed from: g */
    private static void m53569g(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53699g(3, i);
    }
}
