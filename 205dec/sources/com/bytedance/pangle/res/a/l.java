package com.bytedance.pangle.res.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class l {
    public static void a(g gVar) {
        gVar.b(0);
        int readInt = gVar.readInt();
        int readInt2 = gVar.readInt();
        int readInt3 = gVar.readInt();
        gVar.skipBytes(4);
        int readInt4 = gVar.readInt();
        int readInt5 = gVar.readInt();
        gVar.skipBytes(readInt2 * 4);
        if (readInt3 != 0) {
            gVar.skipBytes(readInt3 * 4);
        }
        gVar.skipBytes((readInt5 == 0 ? readInt : readInt5) - readInt4);
        if (readInt5 == 0) {
            return;
        }
        int i4 = readInt - readInt5;
        gVar.skipBytes(i4);
        int i5 = i4 % 4;
        if (i5 <= 0) {
            return;
        }
        while (true) {
            int i6 = i5 - 1;
            if (i5 <= 0) {
                return;
            }
            gVar.readByte();
            i5 = i6;
        }
    }
}
