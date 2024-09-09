package com.tencent.gatherer.a.a.a.g;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f51548a;

    public c(ByteBuffer byteBuffer) {
        com.tencent.gatherer.a.a.a.d.a("buffer:" + byteBuffer.toString());
        this.f51548a = byteBuffer;
        byteBuffer.position(0);
        this.f51548a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private String a(int i4) {
        char[] cArr = new char[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            short a4 = a.a(this.f51548a);
            if ((a4 & 128) == 0) {
                cArr[i5] = (char) a4;
            } else if ((a4 & 224) == 192) {
                cArr[i5] = (char) (((a4 & 31) << 6) | (a.a(this.f51548a) & 63));
            } else if ((a4 & 240) == 224) {
                cArr[i5] = (char) (((a4 & 15) << 12) | ((a.a(this.f51548a) & 63) << 6) | (a.a(this.f51548a) & 63));
            }
            char c4 = cArr[i5];
        }
        return new String(cArr);
    }

    private b b() {
        this.f51548a.getInt();
        a.b(this.f51548a, 20);
        b bVar = new b();
        bVar.d(a.b(this.f51548a));
        bVar.e(a.b(this.f51548a));
        a.b(this.f51548a);
        bVar.g(a.b(this.f51548a));
        bVar.f(a.b(this.f51548a));
        bVar.h(a.b(this.f51548a));
        bVar.f(this.f51548a.getInt());
        bVar.k(a.b(this.f51548a));
        bVar.g(this.f51548a.getInt());
        bVar.l(a.b(this.f51548a));
        bVar.e(this.f51548a.getInt());
        bVar.j(a.b(this.f51548a));
        bVar.c(this.f51548a.getInt());
        bVar.c(a.b(this.f51548a));
        bVar.d(this.f51548a.getInt());
        bVar.i(a.b(this.f51548a));
        bVar.a(this.f51548a.getInt());
        bVar.a(a.b(this.f51548a));
        bVar.b(this.f51548a.getInt());
        bVar.b(a.b(this.f51548a));
        a.a(this.f51548a, bVar.a());
        return bVar;
    }

    private String c() {
        return a(d());
    }

    private int d() {
        short a4;
        int i4 = 0;
        int i5 = 0;
        do {
            if (i4 > 4) {
                com.tencent.gatherer.a.a.a.d.a("readVarInts count error!");
            }
            a4 = a.a(this.f51548a);
            i5 |= (a4 & 127) << (i4 * 7);
            i4++;
        } while ((a4 & 128) != 0);
        return i5;
    }

    public String a() {
        String str = new String(a.b(this.f51548a, 8));
        if (!str.startsWith("dex\n")) {
            com.tencent.gatherer.a.a.a.d.a("dex magic error");
            return "";
        }
        if (Integer.parseInt(str.substring(4, 7)) < 35) {
            com.tencent.gatherer.a.a.a.d.a("dex version error");
        }
        b b4 = b();
        long b5 = b4.b();
        long c4 = b4.c();
        if (c4 > 50000) {
            c4 = 50000;
        }
        com.tencent.gatherer.a.a.a.d.b("stringIdsOff: " + b5 + ", size:" + c4);
        for (int i4 = 0; i4 < c4; i4++) {
            a.a(this.f51548a, (i4 * 4) + b5);
            a.a(this.f51548a, a.b(this.f51548a));
            String c5 = c();
            if (a(c5)) {
                com.tencent.gatherer.a.a.a.d.b("check true: " + c5);
                return c5;
            }
        }
        com.tencent.gatherer.a.a.a.d.b("not found chrome version");
        return "";
    }

    public static boolean a(String str) {
        return a(str.getBytes());
    }

    public static boolean a(byte[] bArr) {
        if (bArr.length >= 5 && bArr[0] >= 53) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (byte b4 : bArr) {
                if (b4 < 48 && b4 != 46) {
                    return false;
                }
                if (b4 > 57 && b4 != 46) {
                    return false;
                }
                if (i4 == 2 && b4 != 46) {
                    i6++;
                }
                if (b4 == 46) {
                    i4++;
                }
                if (i4 == 0) {
                    i5 = (i5 * 10) + (b4 - 48);
                }
            }
            return i4 >= 3 && i5 >= 50 && i6 == 4;
        }
        return false;
    }
}
