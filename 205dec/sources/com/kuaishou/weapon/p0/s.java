package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public int f38415a;

    /* renamed from: b  reason: collision with root package name */
    public int f38416b;

    /* renamed from: c  reason: collision with root package name */
    public String f38417c;

    /* renamed from: d  reason: collision with root package name */
    public String f38418d;

    /* renamed from: e  reason: collision with root package name */
    public String f38419e;

    /* renamed from: f  reason: collision with root package name */
    public Context f38420f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f38421g;

    /* renamed from: h  reason: collision with root package name */
    public String f38422h;

    /* renamed from: i  reason: collision with root package name */
    public String f38423i;

    /* renamed from: j  reason: collision with root package name */
    public String f38424j;

    /* renamed from: k  reason: collision with root package name */
    public String f38425k;

    /* renamed from: l  reason: collision with root package name */
    public ActivityInfo[] f38426l;

    /* renamed from: m  reason: collision with root package name */
    public String f38427m;

    /* renamed from: n  reason: collision with root package name */
    public String f38428n;

    /* renamed from: o  reason: collision with root package name */
    public String f38429o;

    /* renamed from: p  reason: collision with root package name */
    public int f38430p;

    /* renamed from: q  reason: collision with root package name */
    public int f38431q;

    /* renamed from: r  reason: collision with root package name */
    public PackageInfo f38432r;

    /* renamed from: s  reason: collision with root package name */
    public long f38433s;

    /* renamed from: t  reason: collision with root package name */
    public int f38434t;

    /* renamed from: u  reason: collision with root package name */
    public int f38435u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f38436v;

    /* renamed from: w  reason: collision with root package name */
    public int f38437w;

    /* renamed from: x  reason: collision with root package name */
    public int f38438x = -1;

    /* renamed from: y  reason: collision with root package name */
    public boolean f38439y;

    public s() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            s sVar = (s) obj;
            String str = this.f38417c;
            if (str == null) {
                if (sVar.f38417c != null) {
                    return false;
                }
            } else if (!str.equals(sVar.f38417c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f38417c;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public s(PackageInfo packageInfo, int i4, String str, String str2, String str3, String str4) {
        this.f38432r = packageInfo;
        this.f38415a = i4;
        this.f38417c = str;
        this.f38418d = str2;
        this.f38423i = str3;
        this.f38424j = str4;
    }
}
