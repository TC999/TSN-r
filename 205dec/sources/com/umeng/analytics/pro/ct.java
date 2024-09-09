package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ck;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TProtocolUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ct {

    /* renamed from: a  reason: collision with root package name */
    private static int f52838a = Integer.MAX_VALUE;

    public static void a(int i4) {
        f52838a = i4;
    }

    public static void a(cq cqVar, byte b4) throws bx {
        a(cqVar, b4, f52838a);
    }

    public static void a(cq cqVar, byte b4, int i4) throws bx {
        if (i4 > 0) {
            int i5 = 0;
            switch (b4) {
                case 2:
                    cqVar.t();
                    return;
                case 3:
                    cqVar.u();
                    return;
                case 4:
                    cqVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    cqVar.v();
                    return;
                case 8:
                    cqVar.w();
                    return;
                case 10:
                    cqVar.x();
                    return;
                case 11:
                    cqVar.A();
                    return;
                case 12:
                    cqVar.j();
                    while (true) {
                        byte b5 = cqVar.l().f52815b;
                        if (b5 == 0) {
                            cqVar.k();
                            return;
                        } else {
                            a(cqVar, b5, i4 - 1);
                            cqVar.m();
                        }
                    }
                case 13:
                    cn n4 = cqVar.n();
                    while (i5 < n4.f52821c) {
                        int i6 = i4 - 1;
                        a(cqVar, n4.f52819a, i6);
                        a(cqVar, n4.f52820b, i6);
                        i5++;
                    }
                    cqVar.o();
                    return;
                case 14:
                    cu r3 = cqVar.r();
                    while (i5 < r3.f52840b) {
                        a(cqVar, r3.f52839a, i4 - 1);
                        i5++;
                    }
                    cqVar.s();
                    return;
                case 15:
                    cm p3 = cqVar.p();
                    while (i5 < p3.f52818b) {
                        a(cqVar, p3.f52817a, i4 - 1);
                        i5++;
                    }
                    cqVar.q();
                    return;
            }
        } else {
            throw new bx("Maximum skip depth exceeded");
        }
    }

    public static cs a(byte[] bArr, cs csVar) {
        if (bArr[0] > 16) {
            return new ck.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? csVar : new ck.a();
    }
}
