package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.q8 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TCellInfo extends Table {
    /* renamed from: a */
    private static int m54098a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.m53692n();
    }

    /* renamed from: b */
    public static int m54097b(FlatBufferBuilder flatBufferBuilder, byte b, byte b2, short s, byte b3, int i) {
        flatBufferBuilder.m53689q(5);
        m54095d(flatBufferBuilder, i);
        m54094e(flatBufferBuilder, s);
        m54092g(flatBufferBuilder, b3);
        m54093f(flatBufferBuilder, b2);
        m54096c(flatBufferBuilder, b);
        return m54098a(flatBufferBuilder);
    }

    /* renamed from: c */
    private static void m54096c(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.m53700f(0, b);
    }

    /* renamed from: d */
    private static void m54095d(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53688r(4, i);
    }

    /* renamed from: e */
    private static void m54094e(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.m53696j(2, s);
    }

    /* renamed from: f */
    private static void m54093f(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.m53700f(1, b);
    }

    /* renamed from: g */
    private static void m54092g(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.m53700f(3, b);
    }
}
