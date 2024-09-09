package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.col.p0003l.by;
import com.amap.api.col.p0003l.w0;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OfflineMapDownloadTask.java */
/* renamed from: com.amap.api.col.3l.h0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h0 extends a8 implements w0.a {

    /* renamed from: a  reason: collision with root package name */
    private w0 f7953a;

    /* renamed from: b  reason: collision with root package name */
    private y0 f7954b;

    /* renamed from: c  reason: collision with root package name */
    private b1 f7955c;

    /* renamed from: d  reason: collision with root package name */
    private Context f7956d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f7957e;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7958g;

    private h0(b1 b1Var, Context context) {
        this.f7957e = new Bundle();
        this.f7958g = false;
        this.f7955c = b1Var;
        this.f7956d = context;
    }

    private String d() {
        return a3.f0(this.f7956d);
    }

    private void e() throws IOException {
        w0 w0Var = new w0(new x0(this.f7955c.getUrl(), d(), this.f7955c.v(), this.f7955c.w()), this.f7955c.getUrl(), this.f7956d, this.f7955c);
        this.f7953a = w0Var;
        w0Var.c(this);
        b1 b1Var = this.f7955c;
        this.f7954b = new y0(b1Var, b1Var);
        if (this.f7958g) {
            return;
        }
        this.f7953a.a();
    }

    public final void a() {
        this.f7958g = true;
        w0 w0Var = this.f7953a;
        if (w0Var != null) {
            w0Var.d();
        } else {
            cancelTask();
        }
        y0 y0Var = this.f7954b;
        if (y0Var != null) {
            y0Var.b();
        }
    }

    public final void b() {
        Bundle bundle = this.f7957e;
        if (bundle != null) {
            bundle.clear();
            this.f7957e = null;
        }
    }

    @Override // com.amap.api.col.p0003l.w0.a
    public final void c() {
        y0 y0Var = this.f7954b;
        if (y0Var != null) {
            y0Var.h();
        }
    }

    @Override // com.amap.api.col.p0003l.a8
    public final void runTask() {
        if (this.f7955c.u()) {
            this.f7955c.e(by.a.file_io_exception);
            return;
        }
        try {
            e();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public h0(b1 b1Var, Context context, byte b4) {
        this(b1Var, context);
    }
}
