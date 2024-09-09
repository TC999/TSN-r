package com.qq.e.comm.plugin.g0;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    String f43489a;

    /* renamed from: b  reason: collision with root package name */
    String f43490b;

    /* renamed from: c  reason: collision with root package name */
    String f43491c;

    /* renamed from: d  reason: collision with root package name */
    String f43492d;

    /* renamed from: e  reason: collision with root package name */
    String f43493e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(JSONObject jSONObject) {
        d.a(this, jSONObject);
        this.f43489a = "\u7acb\u5373\u4e0b\u8f7d";
        if (TextUtils.isEmpty(this.f43490b)) {
            this.f43490b = "\u4e0b\u8f7d\u4e2d";
        }
        if (TextUtils.isEmpty(this.f43491c)) {
            this.f43491c = "\u7ee7\u7eed\u4e0b\u8f7d";
        }
        if (TextUtils.isEmpty(this.f43492d)) {
            this.f43492d = "\u7acb\u5373\u5b89\u88c5";
        }
        if (TextUtils.isEmpty(this.f43493e)) {
            this.f43493e = "\u7acb\u5373\u6253\u5f00";
        }
    }

    public String a() {
        return this.f43492d;
    }

    public String b() {
        return this.f43491c;
    }

    public String c() {
        return this.f43490b;
    }

    public String d() {
        return this.f43489a;
    }

    public String e() {
        return this.f43493e;
    }

    public void a(String str) {
        this.f43489a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        this.f43489a = "\u7acb\u5373\u4e0b\u8f7d";
        this.f43490b = "\u4e0b\u8f7d\u4e2d";
        this.f43491c = "\u7ee7\u7eed\u4e0b\u8f7d";
        this.f43492d = "\u7acb\u5373\u5b89\u88c5";
        this.f43493e = "\u7acb\u5373\u6253\u5f00";
    }
}
