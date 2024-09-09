package com.qq.e.comm.plugin.rewardvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.qq.e.comm.plugin.g0.f0;
import com.qq.e.comm.plugin.util.d1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f45971a = "k";

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, Pair<com.qq.e.comm.plugin.q0.h, Boolean>> f45972b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f45973c;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f45974d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements com.qq.e.comm.plugin.q0.f {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f0 f45975c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.h f45976d;

        a(f0 f0Var, com.qq.e.comm.plugin.q0.h hVar) {
            this.f45975c = f0Var;
            this.f45976d = hVar;
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(int i4) {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(int i4, String str, String str2) {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(ValueCallback<Uri> valueCallback, Intent intent) {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(String str) {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(String str, Bitmap bitmap) {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void b(String str) {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
            return false;
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void c(String str) {
            d1.a(k.f45971a, "onPageFinished");
            k.f45972b.put(this.f45975c.K0(), new Pair(this.f45976d, Boolean.TRUE));
        }
    }

    static {
        f45973c = com.qq.e.comm.plugin.d0.a.d().f().a("dwajwl", 0) == 1;
        f45974d = com.qq.e.comm.plugin.d0.a.d().f().a("rpdtpsblr", 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, f0 f0Var) {
        if (context == null || f0Var == null || !com.qq.e.comm.plugin.b.b.a(f0Var.b0())) {
            return;
        }
        d1.a(f45971a, "preload");
        com.qq.e.comm.plugin.q0.h a4 = new com.qq.e.comm.plugin.q0.d(context, f0Var).a();
        if (a4.c() != null) {
            a4.c().a("videoService", new j());
        }
        f45972b.put(f0Var.K0(), new Pair<>(a4, Boolean.FALSE));
        a4.a(new a(f0Var, a4));
        if (f45974d) {
            a4.f(f45973c);
            a4.a(6);
        } else {
            a4.a(5);
        }
        a4.loadUrl(f0Var.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        Object obj;
        Pair<com.qq.e.comm.plugin.q0.h, Boolean> remove = f45972b.remove(str);
        if (remove == null || (obj = remove.first) == null) {
            return;
        }
        ((com.qq.e.comm.plugin.q0.h) obj).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<com.qq.e.comm.plugin.q0.h, Boolean> a(String str) {
        return f45972b.get(str);
    }
}
