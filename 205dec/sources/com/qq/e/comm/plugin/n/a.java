package com.qq.e.comm.plugin.n;

import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a implements GDTApk {

    /* renamed from: a  reason: collision with root package name */
    private final String f44699a;

    /* renamed from: b  reason: collision with root package name */
    private final String f44700b;

    /* renamed from: c  reason: collision with root package name */
    private final String f44701c;

    /* renamed from: d  reason: collision with root package name */
    private final String f44702d;

    /* renamed from: e  reason: collision with root package name */
    private final String f44703e;

    /* renamed from: f  reason: collision with root package name */
    private final ApkDownloadTask f44704f;

    public a(String str, String str2, String str3, String str4, String str5, ApkDownloadTask apkDownloadTask) {
        this.f44699a = str;
        this.f44700b = str2;
        this.f44701c = str3;
        this.f44702d = str4;
        this.f44703e = str5;
        this.f44704f = apkDownloadTask;
    }

    public ApkDownloadTask a() {
        return this.f44704f;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getAppName() {
        return this.f44702d;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getDesc() {
        return this.f44701c;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getLogoUrl() {
        return this.f44703e;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getPackageName() {
        return this.f44699a;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getTitle() {
        return this.f44700b;
    }

    public String toString() {
        return "Apk{packageName='" + this.f44699a + "', title='" + this.f44700b + "', desc='" + this.f44701c + "', appName='" + this.f44702d + "', logoUrl='" + this.f44703e + "'}";
    }
}
