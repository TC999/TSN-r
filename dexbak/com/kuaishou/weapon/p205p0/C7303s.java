package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;

/* renamed from: com.kuaishou.weapon.p0.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7303s {

    /* renamed from: a */
    public int f25019a;

    /* renamed from: b */
    public int f25020b;

    /* renamed from: c */
    public String f25021c;

    /* renamed from: d */
    public String f25022d;

    /* renamed from: e */
    public String f25023e;

    /* renamed from: f */
    public Context f25024f;

    /* renamed from: g */
    public ClassLoader f25025g;

    /* renamed from: h */
    public String f25026h;

    /* renamed from: i */
    public String f25027i;

    /* renamed from: j */
    public String f25028j;

    /* renamed from: k */
    public String f25029k;

    /* renamed from: l */
    public ActivityInfo[] f25030l;

    /* renamed from: m */
    public String f25031m;

    /* renamed from: n */
    public String f25032n;

    /* renamed from: o */
    public String f25033o;

    /* renamed from: p */
    public int f25034p;

    /* renamed from: q */
    public int f25035q;

    /* renamed from: r */
    public PackageInfo f25036r;

    /* renamed from: s */
    public long f25037s;

    /* renamed from: t */
    public int f25038t;

    /* renamed from: u */
    public int f25039u;

    /* renamed from: v */
    public boolean f25040v;

    /* renamed from: w */
    public int f25041w;

    /* renamed from: x */
    public int f25042x = -1;

    /* renamed from: y */
    public boolean f25043y;

    public C7303s() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C7303s c7303s = (C7303s) obj;
            String str = this.f25021c;
            if (str == null) {
                if (c7303s.f25021c != null) {
                    return false;
                }
            } else if (!str.equals(c7303s.f25021c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f25021c;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public C7303s(PackageInfo packageInfo, int i, String str, String str2, String str3, String str4) {
        this.f25036r = packageInfo;
        this.f25019a = i;
        this.f25021c = str;
        this.f25022d = str2;
        this.f25027i = str3;
        this.f25028j = str4;
    }
}
