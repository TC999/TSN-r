package com.bytedance.pangle.res.p124a;

/* renamed from: com.bytedance.pangle.res.a.l */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6214l {
    /* renamed from: a */
    public static void m36966a(C6209g c6209g) {
        c6209g.m36978b(0);
        int readInt = c6209g.readInt();
        int readInt2 = c6209g.readInt();
        int readInt3 = c6209g.readInt();
        c6209g.skipBytes(4);
        int readInt4 = c6209g.readInt();
        int readInt5 = c6209g.readInt();
        c6209g.skipBytes(readInt2 * 4);
        if (readInt3 != 0) {
            c6209g.skipBytes(readInt3 * 4);
        }
        c6209g.skipBytes((readInt5 == 0 ? readInt : readInt5) - readInt4);
        if (readInt5 == 0) {
            return;
        }
        int i = readInt - readInt5;
        c6209g.skipBytes(i);
        int i2 = i % 4;
        if (i2 <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            c6209g.readByte();
            i2 = i3;
        }
    }
}
