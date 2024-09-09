package com.qq.e.comm.plugin.gdtnativead.p.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.qq.e.comm.plugin.gdtnativead.p.b.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements f {

    /* renamed from: c  reason: collision with root package name */
    private final e f43964c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.q0.h f43965d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f43966e;

    /* renamed from: f  reason: collision with root package name */
    private h.a f43967f;

    /* renamed from: g  reason: collision with root package name */
    private ObjectAnimator f43968g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements h.a {
        a() {
        }

        @Override // com.qq.e.comm.plugin.gdtnativead.p.b.h.a
        public void a(View view, String str) {
            c.this.a(view, str);
        }

        @Override // com.qq.e.comm.plugin.gdtnativead.p.b.h.a
        public void a() {
            c.this.c();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.gdtnativead.p.b.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0842c extends AnimatorListenerAdapter {
        C0842c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            View a4 = c.this.a();
            if (a4 != null) {
                a4.setAlpha(1.0f);
                c.this.b();
            }
            c.this.f43968g = null;
        }
    }

    public c(e eVar, com.qq.e.comm.plugin.q0.h hVar) {
        this.f43964c = eVar;
        this.f43965d = hVar;
        a(eVar);
    }

    private void d() {
        this.f43965d.a(new b());
    }

    void c() {
        h.a aVar = this.f43967f;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public void destroy() {
        this.f43965d.e();
        e eVar = this.f43964c;
        if (eVar != null) {
            eVar.destroy();
        }
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public void dismiss() {
        if (a() == null || !this.f43966e) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a(), View.ALPHA, 0.0f);
        this.f43968g = ofFloat;
        ofFloat.setDuration(700L);
        this.f43968g.addListener(new C0842c());
        this.f43968g.start();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public void loadUrl(String str) {
        this.f43965d.loadUrl(str);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public boolean show() {
        View a4;
        e eVar = this.f43964c;
        if (eVar != null) {
            eVar.f();
            if (this.f43964c.c() && (a4 = a()) != null) {
                ObjectAnimator objectAnimator = this.f43968g;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                a4.setVisibility(0);
                this.f43966e = true;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        View a4 = a();
        if (a4 != null) {
            a4.setVisibility(4);
        }
        this.f43966e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends com.qq.e.comm.plugin.q0.j {
        b() {
        }

        @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
        public void a(int i4, String str, String str2) {
            super.a(i4, str, str2);
            if (c.this.f43964c != null) {
                c.this.f43964c.a(str2);
            }
        }

        @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
        public void c(String str) {
            super.c(str);
            if (c.this.f43964c != null) {
                c.this.f43964c.e();
            }
        }

        @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f.a
        public void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Uri url;
            super.a(webView, webResourceRequest, webResourceResponse);
            String uri = (Build.VERSION.SDK_INT < 21 || webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? "" : url.toString();
            if (c.this.f43964c != null) {
                c.this.f43964c.a(uri);
            }
        }
    }

    private void a(e eVar) {
        a(eVar.d());
        d();
        View a4 = a();
        if (a4 != null) {
            a4.setBackgroundColor(0);
        }
        b();
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.q0.s.g c4 = this.f43965d.c();
        if (c4 == null) {
            return;
        }
        c4.a("videoService", new j(eVar, new a()));
    }

    void a(View view, String str) {
        h.a aVar = this.f43967f;
        if (aVar != null) {
            aVar.a(view, str);
        }
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public View a() {
        return this.f43965d.a();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.f
    public void a(h.a aVar) {
        this.f43967f = aVar;
    }
}
