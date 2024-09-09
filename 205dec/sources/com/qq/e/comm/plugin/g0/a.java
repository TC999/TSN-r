package com.qq.e.comm.plugin.g0;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    String f43467a;

    /* renamed from: b  reason: collision with root package name */
    String f43468b;

    /* renamed from: c  reason: collision with root package name */
    long f43469c;

    /* renamed from: d  reason: collision with root package name */
    String f43470d;

    /* renamed from: e  reason: collision with root package name */
    String f43471e;

    /* renamed from: f  reason: collision with root package name */
    String f43472f;

    /* renamed from: g  reason: collision with root package name */
    String f43473g;

    /* renamed from: h  reason: collision with root package name */
    String f43474h;

    /* renamed from: i  reason: collision with root package name */
    String f43475i;

    public String a() {
        return this.f43467a;
    }

    public String b() {
        return this.f43468b;
    }

    public String c() {
        return this.f43473g;
    }

    public String d() {
        return this.f43474h;
    }

    public long e() {
        return this.f43469c;
    }

    public String f() {
        return this.f43470d;
    }

    public String g() {
        return this.f43471e;
    }

    public void h(String str) {
        this.f43472f = str;
    }

    public String i() {
        return this.f43472f;
    }

    public String toString() {
        return "AppChannelInfo{appName='" + this.f43467a + "', authorName='" + this.f43468b + "', packageSizeBytes=" + this.f43469c + ", permissionsUrl='" + this.f43470d + "', privacyAgreement='" + this.f43471e + "', versionName='" + this.f43472f + "', descriptionUrl='" + this.f43473g + "', icpNumber='" + this.f43474h + "', suitableAge='" + this.f43475i + "'}";
    }

    public void a(String str) {
        this.f43467a = str;
    }

    public void b(String str) {
        this.f43468b = str;
    }

    public void c(String str) {
        this.f43473g = str;
    }

    public void d(String str) {
        this.f43474h = str;
    }

    public void e(String str) {
        this.f43470d = str;
    }

    public void f(String str) {
        this.f43471e = str;
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "-";
        }
        this.f43475i = str;
    }

    public String h() {
        return this.f43475i;
    }

    public void a(long j4) {
        this.f43469c = j4;
    }
}
