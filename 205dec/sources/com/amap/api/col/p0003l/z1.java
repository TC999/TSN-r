package com.amap.api.col.p0003l;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: EngineStyleKeyItem.java */
/* renamed from: com.amap.api.col.3l.z1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class z1 {

    /* renamed from: a  reason: collision with root package name */
    int f9575a;

    /* renamed from: b  reason: collision with root package name */
    int[] f9576b;

    /* renamed from: c  reason: collision with root package name */
    int f9577c;

    /* renamed from: d  reason: collision with root package name */
    int f9578d;

    /* renamed from: e  reason: collision with root package name */
    String f9579e;

    /* renamed from: f  reason: collision with root package name */
    String f9580f;

    /* renamed from: g  reason: collision with root package name */
    String f9581g;

    public z1(int i4, int[] iArr, String str, String str2, String str3) {
        this.f9575a = i4;
        this.f9576b = iArr;
        this.f9579e = str;
        this.f9580f = str2;
        this.f9581g = str3;
        str = TextUtils.isEmpty(str) ? str2 : str;
        this.f9577c = -1000;
        if ("regions".equals(str)) {
            this.f9577c = 1001;
        } else if ("water".equals(str)) {
            this.f9577c = 1002;
        } else if ("buildings".equals(str)) {
            this.f9577c = 1003;
        } else if ("roads".equals(str)) {
            this.f9577c = 1004;
        } else if ("labels".equals(str)) {
            this.f9577c = 1005;
        } else if ("borders".equals(str)) {
            this.f9577c = 1006;
        }
        this.f9578d = (i4 * 1000) + iArr.hashCode();
    }
}
