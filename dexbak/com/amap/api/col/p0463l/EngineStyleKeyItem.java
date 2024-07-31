package com.amap.api.col.p0463l;

import android.text.TextUtils;

/* renamed from: com.amap.api.col.3l.z1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class EngineStyleKeyItem {

    /* renamed from: a */
    int f5810a;

    /* renamed from: b */
    int[] f5811b;

    /* renamed from: c */
    int f5812c;

    /* renamed from: d */
    int f5813d;

    /* renamed from: e */
    String f5814e;

    /* renamed from: f */
    String f5815f;

    /* renamed from: g */
    String f5816g;

    public EngineStyleKeyItem(int i, int[] iArr, String str, String str2, String str3) {
        this.f5810a = i;
        this.f5811b = iArr;
        this.f5814e = str;
        this.f5815f = str2;
        this.f5816g = str3;
        str = TextUtils.isEmpty(str) ? str2 : str;
        this.f5812c = -1000;
        if ("regions".equals(str)) {
            this.f5812c = 1001;
        } else if ("water".equals(str)) {
            this.f5812c = 1002;
        } else if ("buildings".equals(str)) {
            this.f5812c = 1003;
        } else if ("roads".equals(str)) {
            this.f5812c = 1004;
        } else if ("labels".equals(str)) {
            this.f5812c = 1005;
        } else if ("borders".equals(str)) {
            this.f5812c = 1006;
        }
        this.f5813d = (i * 1000) + iArr.hashCode();
    }
}
