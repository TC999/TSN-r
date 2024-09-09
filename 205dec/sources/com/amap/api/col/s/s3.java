package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MobileUpdateStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s3 extends v3 {

    /* renamed from: c  reason: collision with root package name */
    private Context f10214c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10215d;

    /* renamed from: e  reason: collision with root package name */
    private int f10216e;

    /* renamed from: f  reason: collision with root package name */
    private int f10217f;

    /* renamed from: b  reason: collision with root package name */
    private String f10213b = "iKey";

    /* renamed from: g  reason: collision with root package name */
    private int f10218g = 0;

    public s3(Context context, boolean z3, int i4, int i5, String str, int i6) {
        f(context, z3, i4, i5, str, i6);
    }

    private void f(Context context, boolean z3, int i4, int i5, String str, int i6) {
        this.f10214c = context;
        this.f10215d = z3;
        this.f10216e = i4;
        this.f10217f = i5;
        this.f10213b = str;
        this.f10218g = i6;
    }

    @Override // com.amap.api.col.s.v3
    public final void a(int i4) {
        if (c1.D(this.f10214c) == 1) {
            return;
        }
        String c4 = j1.c(System.currentTimeMillis(), "yyyyMMdd");
        String a4 = e2.a(this.f10214c, this.f10213b);
        if (!TextUtils.isEmpty(a4)) {
            String[] split = a4.split("\\|");
            if (split != null && split.length >= 2) {
                if (c4.equals(split[0])) {
                    i4 += Integer.parseInt(split[1]);
                }
            } else {
                e2.g(this.f10214c, this.f10213b);
            }
        }
        Context context = this.f10214c;
        String str = this.f10213b;
        e2.d(context, str, c4 + "|" + i4);
    }

    @Override // com.amap.api.col.s.v3
    protected final boolean c() {
        if (c1.D(this.f10214c) == 1) {
            return true;
        }
        if (this.f10215d) {
            String a4 = e2.a(this.f10214c, this.f10213b);
            if (TextUtils.isEmpty(a4)) {
                return true;
            }
            String[] split = a4.split("\\|");
            if (split != null && split.length >= 2) {
                return !j1.c(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f10217f;
            }
            e2.g(this.f10214c, this.f10213b);
            return true;
        }
        return false;
    }

    @Override // com.amap.api.col.s.v3
    public final int d() {
        int i4;
        int i5 = Integer.MAX_VALUE;
        if ((c1.D(this.f10214c) != 1 && (i4 = this.f10216e) > 0) || ((i4 = this.f10218g) > 0 && i4 < Integer.MAX_VALUE)) {
            i5 = i4;
        }
        v3 v3Var = this.f10346a;
        return v3Var != null ? Math.max(i5, v3Var.d()) : i5;
    }
}
