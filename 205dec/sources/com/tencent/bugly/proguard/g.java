package com.tencent.bugly.proguard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class g extends m {

    /* renamed from: g  reason: collision with root package name */
    public byte[] f51242g;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f51244i;

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f51245j;

    /* renamed from: m  reason: collision with root package name */
    static final /* synthetic */ boolean f51235m = true;

    /* renamed from: k  reason: collision with root package name */
    static byte[] f51233k = null;

    /* renamed from: l  reason: collision with root package name */
    static Map<String, String> f51234l = null;

    /* renamed from: a  reason: collision with root package name */
    public short f51236a = 0;

    /* renamed from: b  reason: collision with root package name */
    public byte f51237b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f51238c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f51239d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f51240e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f51241f = null;

    /* renamed from: h  reason: collision with root package name */
    public int f51243h = 0;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f51236a, 1);
        lVar.a(this.f51237b, 2);
        lVar.a(this.f51238c, 3);
        lVar.a(this.f51239d, 4);
        lVar.a(this.f51240e, 5);
        lVar.a(this.f51241f, 6);
        lVar.a(this.f51242g, 7);
        lVar.a(this.f51243h, 8);
        lVar.a((Map) this.f51244i, 9);
        lVar.a((Map) this.f51245j, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f51235m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        g gVar = (g) obj;
        return n.a(1, (int) gVar.f51236a) && n.a(1, (int) gVar.f51237b) && n.a(1, gVar.f51238c) && n.a(1, gVar.f51239d) && n.a((Object) 1, (Object) gVar.f51240e) && n.a((Object) 1, (Object) gVar.f51241f) && n.a((Object) 1, (Object) gVar.f51242g) && n.a(1, gVar.f51243h) && n.a((Object) 1, (Object) gVar.f51244i) && n.a((Object) 1, (Object) gVar.f51245j);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        try {
            this.f51236a = kVar.a(this.f51236a, 1, true);
            this.f51237b = kVar.a(this.f51237b, 2, true);
            this.f51238c = kVar.a(this.f51238c, 3, true);
            this.f51239d = kVar.a(this.f51239d, 4, true);
            this.f51240e = kVar.b(5, true);
            this.f51241f = kVar.b(6, true);
            if (f51233k == null) {
                f51233k = new byte[]{0};
            }
            this.f51242g = kVar.c(7, true);
            this.f51243h = kVar.a(this.f51243h, 8, true);
            if (f51234l == null) {
                HashMap hashMap = new HashMap();
                f51234l = hashMap;
                hashMap.put("", "");
            }
            this.f51244i = (Map) kVar.a((k) f51234l, 9, true);
            if (f51234l == null) {
                HashMap hashMap2 = new HashMap();
                f51234l = hashMap2;
                hashMap2.put("", "");
            }
            this.f51245j = (Map) kVar.a((k) f51234l, 10, true);
        } catch (Exception e4) {
            e4.printStackTrace();
            PrintStream printStream = System.out;
            printStream.println("RequestPacket decode error " + f.a(this.f51242g));
            throw new RuntimeException(e4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i4) {
        i iVar = new i(sb, i4);
        iVar.a(this.f51236a, "iVersion");
        iVar.a(this.f51237b, "cPacketType");
        iVar.a(this.f51238c, "iMessageType");
        iVar.a(this.f51239d, "iRequestId");
        iVar.a(this.f51240e, "sServantName");
        iVar.a(this.f51241f, "sFuncName");
        iVar.a(this.f51242g, "sBuffer");
        iVar.a(this.f51243h, "iTimeout");
        iVar.a((Map) this.f51244i, "context");
        iVar.a((Map) this.f51245j, "status");
    }
}
