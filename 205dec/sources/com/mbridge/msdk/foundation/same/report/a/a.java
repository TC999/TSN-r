package com.mbridge.msdk.foundation.same.report.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.tools.t;

/* compiled from: CampaignRequestTimeUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private j f39670a;

    /* renamed from: b  reason: collision with root package name */
    private i f39671b;

    /* renamed from: c  reason: collision with root package name */
    private Context f39672c;

    public a(j jVar) {
        Context context;
        this.f39671b = null;
        this.f39670a = jVar;
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        this.f39672c = j4;
        this.f39671b = i.a(j4);
        if (this.f39670a == null || (context = this.f39672c) == null) {
            return;
        }
        int D = t.D(context);
        this.f39670a.e(D);
        this.f39670a.c(t.a(this.f39672c, D));
        this.f39670a.d(2);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f39670a.a(str);
    }

    public final void b(int i4) {
        j jVar = this.f39670a;
        if (jVar != null) {
            jVar.c(i4);
        }
    }

    public final void c(int i4) {
        j jVar = this.f39670a;
        if (jVar != null) {
            jVar.a(i4);
        }
    }

    public final void b(String str) {
        j jVar = this.f39670a;
        if (jVar != null) {
            jVar.b(str);
        }
    }

    public final void a(int i4) {
        j jVar = this.f39670a;
        if (jVar != null) {
            jVar.b(i4);
        }
    }

    public final void a() {
        if (this.f39670a != null) {
            m.a(this.f39671b).a(this.f39670a);
        }
    }
}
