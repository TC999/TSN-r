package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.z8 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TWifi extends Table {
    /* renamed from: a */
    private static int m53311a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.m53692n();
    }

    /* renamed from: b */
    public static int m53310b(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53689q(1);
        m53308d(flatBufferBuilder, i);
        return m53311a(flatBufferBuilder);
    }

    /* renamed from: c */
    public static int m53309c(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.m53698h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.m53701e(iArr[length]);
        }
        return flatBufferBuilder.m53705a();
    }

    /* renamed from: d */
    private static void m53308d(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.m53688r(0, i);
    }
}
