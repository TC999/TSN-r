package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class br extends m {

    /* renamed from: i  reason: collision with root package name */
    static byte[] f51176i;

    /* renamed from: j  reason: collision with root package name */
    static Map<String, String> f51177j;

    /* renamed from: a  reason: collision with root package name */
    public byte f51178a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f51179b = 0;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f51180c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f51181d = "";

    /* renamed from: e  reason: collision with root package name */
    public long f51182e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f51183f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f51184g = "";

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f51185h = null;

    static {
        f51176i = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f51177j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f51178a, 0);
        lVar.a(this.f51179b, 1);
        byte[] bArr = this.f51180c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
        String str = this.f51181d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.f51182e, 4);
        String str2 = this.f51183f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        String str3 = this.f51184g;
        if (str3 != null) {
            lVar.a(str3, 6);
        }
        Map<String, String> map = this.f51185h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f51178a = kVar.a(this.f51178a, 0, true);
        this.f51179b = kVar.a(this.f51179b, 1, true);
        this.f51180c = kVar.c(2, false);
        this.f51181d = kVar.b(3, false);
        this.f51182e = kVar.a(this.f51182e, 4, false);
        this.f51183f = kVar.b(5, false);
        this.f51184g = kVar.b(6, false);
        this.f51185h = (Map) kVar.a((k) f51177j, 7, false);
    }
}
