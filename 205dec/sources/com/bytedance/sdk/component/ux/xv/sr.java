package com.bytedance.sdk.component.ux.xv;

import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr<T> implements k {

    /* renamed from: c  reason: collision with root package name */
    private String f30299c;
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private int f30300f;
    private boolean gd;

    /* renamed from: k  reason: collision with root package name */
    private int f30301k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.component.ux.r f30302p;

    /* renamed from: r  reason: collision with root package name */
    private Map<String, String> f30303r;
    private T sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private String f30304w;
    private T xv;

    public sr c(xv xvVar, T t3) {
        this.xv = t3;
        this.f30299c = xvVar.r();
        this.f30304w = xvVar.w();
        this.ux = xvVar.xv();
        this.f30300f = xvVar.sr();
        this.gd = xvVar.fp();
        this.f30302p = xvVar.ia();
        this.f30301k = xvVar.s();
        return this;
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(9)
    public boolean ev() {
        return this.ev;
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(7)
    public int f() {
        return this.f30300f;
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(10)
    public boolean gd() {
        return this.gd;
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(12)
    public int k() {
        return this.f30301k;
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(11)
    public com.bytedance.sdk.component.ux.r p() {
        return this.f30302p;
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(8)
    public Map<String, String> r() {
        return this.f30303r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(5)
    public void setResult(Object obj) {
        this.sr = this.xv;
        this.xv = obj;
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(4)
    public T sr() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(6)
    public int ux() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(2)
    public String w() {
        return this.f30304w;
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(3)
    public T xv() {
        return this.xv;
    }

    public sr c(xv xvVar, T t3, Map<String, String> map, boolean z3) {
        this.f30303r = map;
        this.ev = z3;
        return c(xvVar, t3);
    }

    @Override // com.bytedance.sdk.component.ux.k
    @ATSMethod(1)
    public String c() {
        return this.f30299c;
    }
}
