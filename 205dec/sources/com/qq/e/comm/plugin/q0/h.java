package com.qq.e.comm.plugin.q0;

import android.content.Context;
import android.view.View;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface h extends o {

    /* compiled from: A */
    @Deprecated
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a {
        void c();
    }

    View a();

    void a(int i4);

    void a(Context context);

    @Deprecated
    void a(com.qq.e.comm.plugin.apkmanager.w.a aVar);

    void a(f fVar);

    @Deprecated
    void a(a aVar);

    void a(com.qq.e.comm.plugin.q0.s.g gVar);

    void a(com.qq.e.comm.plugin.q0.t.a aVar);

    @Deprecated
    void a(com.qq.e.comm.plugin.q0.t.b bVar);

    void a(boolean z3);

    void addJavascriptInterface(Object obj, String str);

    p b();

    void b(boolean z3);

    com.qq.e.comm.plugin.q0.s.g c();

    void c(boolean z3);

    boolean canGoBack();

    boolean canGoBackOrForward(int i4);

    void d();

    void d(boolean z3);

    void e();

    void e(boolean z3);

    String f();

    void f(boolean z3);

    Context getContext();

    void goBack();

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void onPause();

    void onResume();

    void setFocusable(boolean z3);

    void setFocusableInTouchMode(boolean z3);

    void setVisibility(int i4);
}
