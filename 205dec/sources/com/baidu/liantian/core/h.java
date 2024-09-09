package com.baidu.liantian.core;

import android.content.IntentFilter;
import android.text.TextUtils;

/* compiled from: PluginloaderIntentFilter.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public String f12218a;

    /* renamed from: b  reason: collision with root package name */
    public String f12219b;

    /* renamed from: c  reason: collision with root package name */
    public String f12220c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f12221d;

    public h(String str, IntentFilter intentFilter, String str2, String str3) {
        this.f12218a = str;
        this.f12221d = intentFilter;
        this.f12219b = str2;
        this.f12220c = str3;
    }

    public final boolean a(h hVar) {
        if (hVar != null) {
            try {
                if (!TextUtils.isEmpty(hVar.f12218a) && !TextUtils.isEmpty(hVar.f12219b) && !TextUtils.isEmpty(hVar.f12220c) && hVar.f12218a.equals(this.f12218a) && hVar.f12219b.equals(this.f12219b) && hVar.f12220c.equals(this.f12220c)) {
                    IntentFilter intentFilter = hVar.f12221d;
                    if (intentFilter != null) {
                        IntentFilter intentFilter2 = this.f12221d;
                        return intentFilter2 == null || intentFilter2 == intentFilter;
                    }
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
        }
        return false;
    }

    public final String toString() {
        try {
            return "PluginloaderIntentFilter:" + this.f12218a + "-" + this.f12219b + "-" + this.f12220c + "-" + this.f12221d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
