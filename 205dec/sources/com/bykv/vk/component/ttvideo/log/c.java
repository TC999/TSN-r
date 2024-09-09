package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public a f24863a;

    /* renamed from: b  reason: collision with root package name */
    public String f24864b;

    /* renamed from: g  reason: collision with root package name */
    public String f24869g;

    /* renamed from: c  reason: collision with root package name */
    public String f24865c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f24866d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f24867e = "";

    /* renamed from: h  reason: collision with root package name */
    public int f24870h = Integer.MIN_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public String f24868f = com.bykv.vk.component.ttvideo.utils.b.a(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Context context) {
        this.f24863a = aVar;
    }

    public void a() {
        b();
    }

    public void a(String str) {
        this.f24864b = str;
        this.f24868f = com.bykv.vk.component.ttvideo.utils.b.b(str);
    }

    public void b() {
        Map versionInfo;
        a aVar = this.f24863a;
        if (aVar == null || (versionInfo = aVar.versionInfo()) == null) {
            return;
        }
        this.f24865c = (String) versionInfo.get("pc");
        this.f24866d = (String) versionInfo.get("sv");
        this.f24867e = (String) versionInfo.get("sdk_version");
    }

    public void b(String str) {
    }
}
