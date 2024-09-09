package com.bytedance.sdk.component.f.xv.w;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.xv;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements com.bytedance.sdk.component.f.xv.c {

    /* renamed from: w  reason: collision with root package name */
    private static final Map<String, com.bytedance.sdk.component.f.c> f29803w = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private c f29804c;

    private w(String str, Context context) {
        this.f29804c = c.c(str, context);
    }

    public static com.bytedance.sdk.component.f.c c(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        if (context == null) {
            context = xv.getContext();
        }
        Map<String, com.bytedance.sdk.component.f.c> map = f29803w;
        com.bytedance.sdk.component.f.c cVar = map.get(str);
        if (cVar == null) {
            w wVar = new w(str, context);
            map.put(str, wVar);
            return wVar;
        }
        return cVar;
    }

    @Override // com.bytedance.sdk.component.f.c
    public int w(String str, int i4) {
        return this.f29804c.w(str, i4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public long w(String str, long j4) {
        return this.f29804c.w(str, j4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public float w(String str, float f4) {
        return this.f29804c.w(str, f4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public boolean w(String str, boolean z3) {
        return this.f29804c.w(str, z3);
    }

    @Override // com.bytedance.sdk.component.f.c
    public String w(String str, String str2) {
        return this.f29804c.w(str, str2);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, int i4) {
        this.f29804c.c(str, i4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public Set<String> w(String str, Set<String> set) {
        return this.f29804c.w(str, set);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, long j4) {
        this.f29804c.c(str, j4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void w() {
        this.f29804c.w();
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, float f4) {
        this.f29804c.c(str, f4);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, boolean z3) {
        this.f29804c.c(str, z3);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, String str2) {
        this.f29804c.c(str, str2);
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str, Set<String> set) {
        this.f29804c.c(str, set);
    }

    @Override // com.bytedance.sdk.component.f.c
    public Map<String, ?> c() {
        return this.f29804c.c();
    }

    @Override // com.bytedance.sdk.component.f.c
    public void c(String str) {
        this.f29804c.c(str);
    }
}
