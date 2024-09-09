package com.bytedance.sdk.openadsdk.core;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.io.Serializable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ba extends com.bytedance.sdk.openadsdk.ys.w.xv.sr implements Bridge, Serializable {

    /* renamed from: c  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.ys.w.xv.sr f31996c;

    public ba(com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar) {
        super(null);
        this.f31996c = srVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public String a() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            return super.a();
        }
        return srVar.a();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public boolean c() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            if (super.c() && com.bytedance.sdk.openadsdk.core.j.ux.c().c(ls.getContext(), "android.permission.ACCESS_COARSE_LOCATION") && com.bytedance.sdk.openadsdk.core.j.ux.c().c(ls.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                return true;
            }
        } else if (srVar.c() && com.bytedance.sdk.openadsdk.core.j.ux.c().c(ls.getContext(), "android.permission.ACCESS_COARSE_LOCATION") && com.bytedance.sdk.openadsdk.core.j.ux.c().c(ls.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            return true;
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 262101:
                return (T) Boolean.valueOf(c());
            case 262102:
                return (T) ev();
            case 262103:
                return (T) Boolean.valueOf(w());
            case 262104:
                return (T) Boolean.valueOf(xv());
            case 262105:
                return (T) gd();
            case 262106:
                return (T) Boolean.valueOf(sr());
            case 262107:
                return (T) p();
            case 262108:
                return (T) Boolean.valueOf(ux());
            case 262109:
                return (T) k();
            case 262110:
                return (T) Boolean.valueOf(f());
            case 262111:
                return (T) Boolean.valueOf(r());
            case 262112:
                return (T) a();
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public com.bytedance.sdk.openadsdk.ys.w.xv.xv ev() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            return super.ev();
        }
        return srVar.ev();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public boolean f() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            return super.f();
        }
        return srVar.f();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public String gd() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            return super.gd();
        }
        return srVar.gd();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public String k() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            return super.k();
        }
        return srVar.k();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public String p() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            return super.p();
        }
        return srVar.p();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public boolean r() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public boolean sr() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            return super.sr();
        }
        return srVar.sr() && com.bytedance.sdk.openadsdk.core.j.ux.c().c(ls.getContext(), "android.permission.ACCESS_WIFI_STATE");
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public boolean ux() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            return super.ux();
        }
        return srVar.ux() && com.bytedance.sdk.openadsdk.core.j.ux.c().c(ls.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public boolean w() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            return super.w();
        }
        return srVar.w();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.xv.sr
    public boolean xv() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = this.f31996c;
        if (srVar == null) {
            return super.xv();
        }
        return srVar.xv() && com.bytedance.sdk.openadsdk.core.j.ux.c().c(ls.getContext(), "android.permission.READ_PHONE_STATE");
    }
}
