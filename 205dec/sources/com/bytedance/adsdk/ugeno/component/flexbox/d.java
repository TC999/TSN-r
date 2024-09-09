package com.bytedance.adsdk.ugeno.component.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    int f26118e;

    /* renamed from: f  reason: collision with root package name */
    int f26119f;

    /* renamed from: g  reason: collision with root package name */
    int f26120g;

    /* renamed from: h  reason: collision with root package name */
    int f26121h;

    /* renamed from: i  reason: collision with root package name */
    int f26122i;

    /* renamed from: j  reason: collision with root package name */
    float f26123j;

    /* renamed from: k  reason: collision with root package name */
    float f26124k;

    /* renamed from: l  reason: collision with root package name */
    int f26125l;

    /* renamed from: m  reason: collision with root package name */
    int f26126m;

    /* renamed from: o  reason: collision with root package name */
    int f26128o;

    /* renamed from: p  reason: collision with root package name */
    int f26129p;

    /* renamed from: q  reason: collision with root package name */
    boolean f26130q;

    /* renamed from: r  reason: collision with root package name */
    boolean f26131r;

    /* renamed from: a  reason: collision with root package name */
    int f26114a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    int f26115b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    int f26116c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    int f26117d = Integer.MIN_VALUE;

    /* renamed from: n  reason: collision with root package name */
    List<Integer> f26127n = new ArrayList();

    public int a() {
        return this.f26120g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, int i4, int i5, int i6, int i7) {
        w wVar = (w) view.getLayoutParams();
        this.f26114a = Math.min(this.f26114a, (view.getLeft() - wVar.bk()) - i4);
        this.f26115b = Math.min(this.f26115b, (view.getTop() - wVar.t()) - i5);
        this.f26116c = Math.max(this.f26116c, view.getRight() + wVar.ys() + i6);
        this.f26117d = Math.max(this.f26117d, view.getBottom() + wVar.fp() + i7);
    }

    public int c() {
        return this.f26121h - this.f26122i;
    }
}
