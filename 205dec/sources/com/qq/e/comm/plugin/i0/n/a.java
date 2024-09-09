package com.qq.e.comm.plugin.i0.n;

import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.g2;
import com.qq.e.comm.plugin.util.t2;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a implements f {

    /* renamed from: c  reason: collision with root package name */
    private int f44386c;

    /* renamed from: d  reason: collision with root package name */
    private int f44387d;

    /* renamed from: e  reason: collision with root package name */
    private String f44388e;

    /* renamed from: j  reason: collision with root package name */
    private f.a f44393j;

    /* renamed from: m  reason: collision with root package name */
    private g2.h f44396m;

    /* renamed from: n  reason: collision with root package name */
    private int f44397n;

    /* renamed from: p  reason: collision with root package name */
    private byte[] f44399p;

    /* renamed from: a  reason: collision with root package name */
    private boolean f44384a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f44385b = true;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f44389f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f44390g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private Map<String, String> f44391h = Collections.unmodifiableMap(this.f44389f);

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f44392i = Collections.unmodifiableMap(this.f44390g);

    /* renamed from: k  reason: collision with root package name */
    private boolean f44394k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f44395l = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f44398o = true;

    public a(String str, f.a aVar, byte[] bArr) {
        this.f44388e = str;
        this.f44393j = aVar;
        if (bArr == null) {
            this.f44399p = null;
        } else {
            this.f44399p = (byte[]) bArr.clone();
        }
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public void a(String str, String str2) {
        this.f44390g.put(str, str2);
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f44389f.put(str, str2);
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public int b() {
        return this.f44387d;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public void c(boolean z3) {
        this.f44384a = z3;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public void d(boolean z3) {
        this.f44394k = z3;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public boolean e() {
        return this.f44384a;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public Map<String, String> f() {
        return this.f44391h;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public boolean g() {
        return this.f44398o;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public f.a getMethod() {
        return this.f44393j;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public String getUrl() {
        return this.f44388e;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public int h() {
        return this.f44386c;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public String i() {
        if (l().isEmpty()) {
            return getUrl();
        }
        Uri.Builder buildUpon = Uri.parse(getUrl()).buildUpon();
        for (Map.Entry<String, String> entry : l().entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public boolean j() {
        return this.f44385b;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public byte[] k() throws Exception {
        return this.f44399p;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public Map<String, String> l() {
        return this.f44392i;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public boolean m() {
        return this.f44395l;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public void n() {
        byte[] a4 = t2.a(this.f44399p);
        if (a4 != null) {
            this.f44399p = a4;
            addHeader("Content-Encoding", "gzip");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getMethod() == f.a.GET ? "get " : "post ");
        sb2.append("url, ");
        sb.append(sb2.toString());
        sb.append(i());
        if (getMethod() == f.a.POST) {
            try {
                sb.append(" , " + URLDecoder.decode(new String(this.f44399p, com.qq.e.comm.plugin.k.a.f44515a)));
            } catch (Exception e4) {
                d1.a(e4.getMessage(), e4);
            }
        }
        return sb.toString();
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public boolean a() {
        return this.f44394k;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public void b(boolean z3) {
        this.f44385b = z3;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public int c() {
        return this.f44397n;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public g2.h d() {
        return this.f44396m;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public void e(boolean z3) {
        this.f44398o = z3;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public void a(boolean z3) {
        this.f44395l = z3;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public void a(g2.h hVar) {
        this.f44396m = hVar;
    }

    @Override // com.qq.e.comm.plugin.i0.n.f
    public void a(int i4) {
        this.f44397n = i4;
    }

    public a(String str, Map<String, String> map, f.a aVar) {
        this.f44388e = str;
        this.f44393j = aVar;
        if (f.a.POST == aVar) {
            StringBuilder sb = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String encode = URLEncoder.encode(entry.getKey(), "UTF-8");
                    String encode2 = URLEncoder.encode(entry.getValue(), "UTF-8");
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                }
                if (sb.length() > 0) {
                    this.f44399p = sb.toString().getBytes("UTF-8");
                    addHeader("Content-Type", "application/x-www-form-urlencoded");
                }
            } catch (UnsupportedEncodingException e4) {
                throw new IllegalArgumentException(e4);
            }
        }
    }
}
