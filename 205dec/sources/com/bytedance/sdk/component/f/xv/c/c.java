package com.bytedance.sdk.component.f.xv.c;

import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.f.xv.c {

    /* renamed from: w  reason: collision with root package name */
    private static final Map<String, com.bytedance.sdk.component.f.c> f29795w = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private String f29796c;

    private c(String str) {
        this.f29796c = str;
    }

    public static com.bytedance.sdk.component.f.c w(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        Map<String, com.bytedance.sdk.component.f.c> map = f29795w;
        com.bytedance.sdk.component.f.c cVar = map.get(str);
        if (cVar == null) {
            c cVar2 = new c(str);
            map.put(str, cVar2);
            return cVar2;
        }
        return cVar;
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, int i4) {
        w.c(this.f29796c, str, Integer.valueOf(i4));
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, long j4) {
        w.c(this.f29796c, str, Long.valueOf(j4));
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, float f4) {
        w.c(this.f29796c, str, Float.valueOf(f4));
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, boolean z3) {
        w.c(this.f29796c, str, Boolean.valueOf(z3));
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, String str2) {
        w.c(this.f29796c, str, str2);
    }

    @Override // com.bytedance.sdk.component.f.c
    public int w(String str, int i4) {
        return w.c(this.f29796c, str, i4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, Set<String> set) {
        w.c(this.f29796c, str, set);
    }

    @Override // com.bytedance.sdk.component.f.c
    public long w(String str, long j4) {
        return w.c(this.f29796c, str, j4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public Map<String, ?> c() {
        return w.w(this.f29796c);
    }

    @Override // com.bytedance.sdk.component.f.c
    public float w(String str, float f4) {
        return w.c(this.f29796c, str, f4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str) {
        w.c(this.f29796c, str);
    }

    @Override // com.bytedance.sdk.component.f.c
    public boolean w(String str, boolean z3) {
        return w.c(this.f29796c, str, z3);
    }

    @Override // com.bytedance.sdk.component.f.c
    public String w(String str, String str2) {
        return w.w(this.f29796c, str, str2);
    }

    @Override // com.bytedance.sdk.component.f.c
    public Set<String> w(String str, Set<String> set) {
        return w.w(this.f29796c, str, set);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void w() {
        w.c(this.f29796c);
    }
}
