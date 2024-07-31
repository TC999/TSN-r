package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.r8 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TData extends Table {
    /* renamed from: a */
    private static int m54026a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.m53692n();
    }

    /* renamed from: b */
    public static int m54025b(FlatBufferBuilder flatBufferBuilder, byte b, int i) {
        flatBufferBuilder.m53689q(2);
        m54022e(flatBufferBuilder, i);
        m54023d(flatBufferBuilder, b);
        return m54026a(flatBufferBuilder);
    }

    /* renamed from: c */
    public static int m54024c(FlatBufferBuilder flatBufferBuilder, byte[] bArr) {
        flatBufferBuilder.m53698h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.m53702d(bArr[length]);
        }
        return flatBufferBuilder.m53705a();
    }

    /* renamed from: d */
    private static void m54023d(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.m53700f(0, b);
    }

    /* renamed from: e */
    private static void m54022e(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53688r(1, i);
    }
}
