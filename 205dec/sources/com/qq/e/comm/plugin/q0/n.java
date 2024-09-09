package com.qq.e.comm.plugin.q0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.i.u;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i2;
import com.qq.e.comm.plugin.util.q0;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private boolean f45506a = true;

    /* renamed from: b  reason: collision with root package name */
    private int f45507b = 0;

    /* renamed from: c  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.c f45508c;

    private boolean c(String str) {
        Context a4;
        Intent a5;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a6 = a(str);
        if (TextUtils.isEmpty(a6) || (a5 = q0.a((a4 = com.qq.e.comm.plugin.d0.a.d().a()), a6, Long.MAX_VALUE)) == null) {
            return false;
        }
        a4.startActivity(a5);
        return true;
    }

    public void a(com.qq.e.comm.plugin.g0.e eVar) {
        this.f45508c = com.qq.e.comm.plugin.n0.c.a(eVar);
    }

    public boolean b(String str) {
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(str) || i2.c(parse)) {
            return false;
        }
        if (!i2.b(parse) && this.f45506a) {
            boolean e4 = i2.e(str);
            try {
                v.a(9120004, this.f45508c, Integer.valueOf(e4 ? 1 : 0), Integer.valueOf(this.f45507b), null);
                d1.a("Try to open third party scheme: " + str, new Object[0]);
                if (!c(str)) {
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(268435456);
                    if (!e4) {
                        u.a(intent, (String) null, str, true);
                    }
                    com.qq.e.comm.plugin.d0.a.d().a().startActivity(intent);
                }
                v.a(9120005, this.f45508c, Integer.valueOf(e4 ? 1 : 0), Integer.valueOf(this.f45507b), null);
            } catch (Exception e5) {
                a(e5, e4 ? 1 : 0, this.f45507b);
            }
        }
        return true;
    }

    String a(String str) {
        Uri parse;
        return (str.contains("market://details?id=") && (parse = Uri.parse(str)) != null) ? parse.getQueryParameter("id") : "";
    }

    public void a(h hVar, String str, boolean z3) {
        if (hVar == null || hVar.b() == null) {
            return;
        }
        hVar.b().e();
    }

    public Pair<? extends InputStream, i2.a> a(boolean z3, Uri uri) {
        if (z3) {
            l d4 = l.d();
            if (d4.b() && !d4.b(uri)) {
                return d4.a(uri);
            }
            d1.a("UnJsWebViewDelegate", "enableProxy == false or uri prefix in blacklist");
            return null;
        }
        return null;
    }

    private void a(Exception exc, int i4, int i5) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        if (exc != null) {
            dVar.a("ot", exc.toString());
        }
        v.a(9120003, this.f45508c, Integer.valueOf(i4), Integer.valueOf(i5), dVar);
    }

    public void a(boolean z3) {
        this.f45506a = z3;
    }

    public void a(int i4) {
        this.f45507b = i4;
    }
}
