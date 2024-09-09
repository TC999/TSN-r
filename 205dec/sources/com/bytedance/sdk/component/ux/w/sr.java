package com.bytedance.sdk.component.ux.w;

import com.bytedance.sdk.component.ux.f;
import com.bytedance.sdk.component.ux.r;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr<T> implements f {

    /* renamed from: c  reason: collision with root package name */
    Map<String, String> f30247c;
    private String sr;
    private r ux;

    /* renamed from: w  reason: collision with root package name */
    private int f30248w;
    private T xv;

    public sr(int i4, T t3, String str) {
        this.f30248w = i4;
        this.xv = t3;
        this.sr = str;
    }

    @Override // com.bytedance.sdk.component.ux.f
    public r c() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.component.ux.f
    public String sr() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.component.ux.f
    public Map<String, String> ux() {
        return this.f30247c;
    }

    @Override // com.bytedance.sdk.component.ux.f
    public int w() {
        return this.f30248w;
    }

    @Override // com.bytedance.sdk.component.ux.f
    public T xv() {
        return this.xv;
    }

    public void c(r rVar) {
        this.ux = rVar;
    }

    public sr(int i4, T t3, String str, Map<String, String> map) {
        this(i4, t3, str);
        this.f30247c = map;
    }
}
