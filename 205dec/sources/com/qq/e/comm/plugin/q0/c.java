package com.qq.e.comm.plugin.q0;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.util.d1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements h {

    /* renamed from: c  reason: collision with root package name */
    private final e f45447c;

    /* renamed from: d  reason: collision with root package name */
    private final a f45448d;

    /* renamed from: e  reason: collision with root package name */
    private final b f45449e;

    /* renamed from: f  reason: collision with root package name */
    private Context f45450f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f45451g;

    /* renamed from: h  reason: collision with root package name */
    private final String f45452h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f45453i;

    public c(Context context, String str, boolean z3) {
        b bVar;
        b bVar2;
        e eVar = new e();
        this.f45447c = eVar;
        eVar.a(this);
        this.f45448d = new a();
        this.f45451g = z3;
        this.f45452h = str;
        if (z3 && !TextUtils.isEmpty(str)) {
            bVar2 = m.a().a(context, str);
        } else {
            try {
                bVar = new b(context);
            } catch (Resources.NotFoundException unused) {
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 21 && i4 < 23) {
                    bVar = new b(context.createConfigurationContext(new Configuration()));
                } else {
                    bVar = new b(context.getApplicationContext());
                }
            }
            bVar2 = bVar;
        }
        if (bVar2 != null) {
            bVar2.a(this.f45447c);
            bVar2.a(this.f45448d);
        }
        this.f45449e = bVar2;
    }

    public void a(com.qq.e.comm.plugin.g0.e eVar) {
        this.f45447c.a(eVar);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void addJavascriptInterface(Object obj, String str) {
        this.f45449e.addJavascriptInterface(obj, str);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void b(boolean z3) {
        this.f45449e.setHorizontalScrollBarEnabled(z3);
        this.f45449e.setVerticalScrollBarEnabled(z3);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public com.qq.e.comm.plugin.q0.s.g c() {
        return this.f45449e.c();
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public boolean canGoBack() {
        return this.f45449e.canGoBack();
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public boolean canGoBackOrForward(int i4) {
        return this.f45449e.canGoBackOrForward(i4);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void d() {
        this.f45449e.d();
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void e() {
        this.f45453i = true;
        if (this.f45451g) {
            m.a().a(this.f45449e, this.f45452h);
        } else {
            this.f45449e.destroy();
        }
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void f(boolean z3) {
        this.f45447c.a(z3);
    }

    protected void finalize() {
        d1.a("Webview\u590d\u7528:\u56de\u6536 " + this.f45453i, new Object[0]);
        try {
            super.finalize();
        } catch (Throwable unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public Context getContext() {
        Context context = this.f45450f;
        if (context != null) {
            return context;
        }
        b bVar = this.f45449e;
        if (bVar != null && bVar.getContext() != null) {
            return this.f45449e.getContext();
        }
        return com.qq.e.comm.plugin.d0.a.d().a();
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void goBack() {
        this.f45449e.goBack();
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f45449e.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void loadUrl(String str) {
        this.f45449e.loadUrl(str);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void onPause() {
        b bVar = this.f45449e;
        if (bVar == null) {
            return;
        }
        try {
            bVar.getClass().getMethod("onPause", new Class[0]).invoke(this.f45449e, null);
        } catch (Exception unused) {
            d1.a("InnerBrowser onPause err");
        }
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void onResume() {
        b bVar = this.f45449e;
        if (bVar == null) {
            return;
        }
        try {
            bVar.getClass().getMethod("onResume", new Class[0]).invoke(this.f45449e, null);
        } catch (Exception unused) {
            d1.a("InnerBrowser onResume err");
        }
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void setFocusable(boolean z3) {
        this.f45449e.setFocusable(z3);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void setFocusableInTouchMode(boolean z3) {
        this.f45449e.setFocusableInTouchMode(z3);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void setVisibility(int i4) {
        this.f45449e.setVisibility(i4);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void a(boolean z3) {
        this.f45447c.b(z3);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void c(boolean z3) {
        this.f45449e.c(z3);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void d(boolean z3) {
        b bVar = this.f45449e;
        if (bVar == null) {
            return;
        }
        bVar.d(z3);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public String f() {
        WebSettings settings;
        b bVar = this.f45449e;
        if (bVar == null || (settings = bVar.getSettings()) == null) {
            return null;
        }
        return settings.getUserAgentString();
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void a(int i4) {
        this.f45447c.a(i4);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public p b() {
        return this.f45449e.b();
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void a(f fVar) {
        this.f45447c.a(fVar);
        this.f45448d.a(fVar);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public View a() {
        return this.f45449e;
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void e(boolean z3) {
        this.f45449e.e(z3);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void a(com.qq.e.comm.plugin.q0.s.g gVar) {
        this.f45447c.a(gVar);
        this.f45448d.a(gVar);
        this.f45449e.a(gVar);
    }

    @Override // com.qq.e.comm.plugin.q0.o
    public void a(String str) {
        a(str, null);
    }

    @Override // com.qq.e.comm.plugin.q0.o
    public void a(String str, ValueCallback<String> valueCallback) {
        if (this.f45449e.k()) {
            return;
        }
        try {
            this.f45449e.a(str, valueCallback);
        } catch (Exception unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void a(com.qq.e.comm.plugin.q0.t.b bVar) {
        this.f45449e.a(bVar);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void a(h.a aVar) {
        this.f45449e.a(aVar);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void a(com.qq.e.comm.plugin.q0.t.a aVar) {
        this.f45449e.a(aVar);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void a(com.qq.e.comm.plugin.apkmanager.w.a aVar) {
        this.f45449e.a(aVar);
    }

    @Override // com.qq.e.comm.plugin.q0.h
    public void a(Context context) {
        this.f45450f = context;
    }
}
