package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GlideUrl.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class g implements com.bumptech.glide.load.c {

    /* renamed from: j  reason: collision with root package name */
    private static final String f17285j = "@#&=*+-_.,:!?()/~'%;$";

    /* renamed from: c  reason: collision with root package name */
    private final h f17286c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final URL f17287d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f17288e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f17289f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private URL f17290g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private volatile byte[] f17291h;

    /* renamed from: i  reason: collision with root package name */
    private int f17292i;

    public g(URL url) {
        this(url, h.f17294b);
    }

    private byte[] d() {
        if (this.f17291h == null) {
            this.f17291h = c().getBytes(com.bumptech.glide.load.c.f16793b);
        }
        return this.f17291h;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f17289f)) {
            String str = this.f17288e;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) com.bumptech.glide.util.j.d(this.f17287d)).toString();
            }
            this.f17289f = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f17289f;
    }

    private URL g() throws MalformedURLException {
        if (this.f17290g == null) {
            this.f17290g = new URL(f());
        }
        return this.f17290g;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f17288e;
        return str != null ? str : ((URL) com.bumptech.glide.util.j.d(this.f17287d)).toString();
    }

    public Map<String, String> e() {
        return this.f17286c.getHeaders();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return c().equals(gVar.c()) && this.f17286c.equals(gVar.f17286c);
        }
        return false;
    }

    public String h() {
        return f();
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.f17292i == 0) {
            int hashCode = c().hashCode();
            this.f17292i = hashCode;
            this.f17292i = (hashCode * 31) + this.f17286c.hashCode();
        }
        return this.f17292i;
    }

    public URL i() throws MalformedURLException {
        return g();
    }

    public String toString() {
        return c();
    }

    public g(String str) {
        this(str, h.f17294b);
    }

    public g(URL url, h hVar) {
        this.f17287d = (URL) com.bumptech.glide.util.j.d(url);
        this.f17288e = null;
        this.f17286c = (h) com.bumptech.glide.util.j.d(hVar);
    }

    public g(String str, h hVar) {
        this.f17287d = null;
        this.f17288e = com.bumptech.glide.util.j.b(str);
        this.f17286c = (h) com.bumptech.glide.util.j.d(hVar);
    }
}
