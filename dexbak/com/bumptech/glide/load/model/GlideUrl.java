package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.C3770j;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.model.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GlideUrl implements Key {

    /* renamed from: j */
    private static final String f13968j = "@#&=*+-_.,:!?()/~'%;$";

    /* renamed from: c */
    private final InterfaceC3670h f13969c;
    @Nullable

    /* renamed from: d */
    private final URL f13970d;
    @Nullable

    /* renamed from: e */
    private final String f13971e;
    @Nullable

    /* renamed from: f */
    private String f13972f;
    @Nullable

    /* renamed from: g */
    private URL f13973g;
    @Nullable

    /* renamed from: h */
    private volatile byte[] f13974h;

    /* renamed from: i */
    private int f13975i;

    public GlideUrl(URL url) {
        this(url, InterfaceC3670h.f13977b);
    }

    /* renamed from: d */
    private byte[] m45093d() {
        if (this.f13974h == null) {
            this.f13974h = m45094c().getBytes(Key.f13470b);
        }
        return this.f13974h;
    }

    /* renamed from: f */
    private String m45091f() {
        if (TextUtils.isEmpty(this.f13972f)) {
            String str = this.f13971e;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) C3770j.m44392d(this.f13970d)).toString();
            }
            this.f13972f = Uri.encode(str, f13968j);
        }
        return this.f13972f;
    }

    /* renamed from: g */
    private URL m45090g() throws MalformedURLException {
        if (this.f13973g == null) {
            this.f13973g = new URL(m45091f());
        }
        return this.f13973g;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(m45093d());
    }

    /* renamed from: c */
    public String m45094c() {
        String str = this.f13971e;
        return str != null ? str : ((URL) C3770j.m44392d(this.f13970d)).toString();
    }

    /* renamed from: e */
    public Map<String, String> m45092e() {
        return this.f13969c.getHeaders();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GlideUrl) {
            GlideUrl glideUrl = (GlideUrl) obj;
            return m45094c().equals(glideUrl.m45094c()) && this.f13969c.equals(glideUrl.f13969c);
        }
        return false;
    }

    /* renamed from: h */
    public String m45089h() {
        return m45091f();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f13975i == 0) {
            int hashCode = m45094c().hashCode();
            this.f13975i = hashCode;
            this.f13975i = (hashCode * 31) + this.f13969c.hashCode();
        }
        return this.f13975i;
    }

    /* renamed from: i */
    public URL m45088i() throws MalformedURLException {
        return m45090g();
    }

    public String toString() {
        return m45094c();
    }

    public GlideUrl(String str) {
        this(str, InterfaceC3670h.f13977b);
    }

    public GlideUrl(URL url, InterfaceC3670h interfaceC3670h) {
        this.f13970d = (URL) C3770j.m44392d(url);
        this.f13971e = null;
        this.f13969c = (InterfaceC3670h) C3770j.m44392d(interfaceC3670h);
    }

    public GlideUrl(String str, InterfaceC3670h interfaceC3670h) {
        this.f13970d = null;
        this.f13971e = C3770j.m44394b(str);
        this.f13969c = (InterfaceC3670h) C3770j.m44392d(interfaceC3670h);
    }
}
