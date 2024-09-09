package com.tencent.turingfd.sdk.ams.au;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Apple extends Draco {

    /* renamed from: i  reason: collision with root package name */
    public byte[] f51879i;

    /* renamed from: k  reason: collision with root package name */
    public Map<String, String> f51881k;

    /* renamed from: l  reason: collision with root package name */
    public Map<String, String> f51882l;

    /* renamed from: o  reason: collision with root package name */
    public static final /* synthetic */ boolean f51872o = !Apple.class.desiredAssertionStatus();

    /* renamed from: m  reason: collision with root package name */
    public static byte[] f51870m = null;

    /* renamed from: n  reason: collision with root package name */
    public static Map<String, String> f51871n = null;

    /* renamed from: c  reason: collision with root package name */
    public short f51873c = 0;

    /* renamed from: d  reason: collision with root package name */
    public byte f51874d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f51875e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f51876f = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f51877g = null;

    /* renamed from: h  reason: collision with root package name */
    public String f51878h = null;

    /* renamed from: j  reason: collision with root package name */
    public int f51880j = 0;

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Dorado dorado) {
        dorado.a(this.f51873c, 1);
        dorado.a(this.f51874d, 2);
        dorado.a(this.f51875e, 3);
        dorado.a(this.f51876f, 4);
        dorado.a(this.f51877g, 5);
        dorado.a(this.f51878h, 6);
        dorado.a(this.f51879i, 7);
        dorado.a(this.f51880j, 8);
        dorado.a((Map) this.f51881k, 9);
        dorado.a((Map) this.f51882l, 10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f51872o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        Apple apple = (Apple) obj;
        Integer num = 1;
        return Eridanus.a(1, (int) apple.f51873c) && Eridanus.a(1, (int) apple.f51874d) && Eridanus.a(1, apple.f51875e) && Eridanus.a(1, apple.f51876f) && num.equals(apple.f51877g) && num.equals(apple.f51878h) && num.equals(apple.f51879i) && Eridanus.a(1, apple.f51880j) && num.equals(apple.f51881k) && num.equals(apple.f51882l);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Draco
    public void a(Cygnus cygnus) {
        String str;
        try {
            this.f51873c = cygnus.a(this.f51873c, 1, true);
            this.f51874d = cygnus.a(this.f51874d, 2, true);
            this.f51875e = cygnus.a(this.f51875e, 3, true);
            this.f51876f = cygnus.a(this.f51876f, 4, true);
            this.f51877g = cygnus.b(5, true);
            this.f51878h = cygnus.b(6, true);
            if (f51870m == null) {
                f51870m = new byte[]{0};
            }
            this.f51879i = cygnus.a(7, true);
            this.f51880j = cygnus.a(this.f51880j, 8, true);
            if (f51871n == null) {
                HashMap hashMap = new HashMap();
                f51871n = hashMap;
                hashMap.put("", "");
            }
            this.f51881k = (Map) cygnus.a((Cygnus) f51871n, 9, true);
            if (f51871n == null) {
                HashMap hashMap2 = new HashMap();
                f51871n = hashMap2;
                hashMap2.put("", "");
            }
            this.f51882l = (Map) cygnus.a((Cygnus) f51871n, 10, true);
        } catch (Exception e4) {
            e4.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder a4 = Almond.a("RequestPacket decode error ");
            byte[] bArr = this.f51879i;
            if (bArr == null || bArr.length == 0) {
                str = null;
            } else {
                char[] cArr = new char[bArr.length * 2];
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    byte b4 = bArr[i4];
                    int i5 = i4 * 2;
                    char[] cArr2 = Mandarin.f52149a;
                    cArr[i5 + 1] = cArr2[b4 & 15];
                    cArr[i5 + 0] = cArr2[((byte) (b4 >>> 4)) & 15];
                }
                str = new String(cArr);
            }
            a4.append(str);
            printStream.println(a4.toString());
            throw new RuntimeException(e4);
        }
    }
}
