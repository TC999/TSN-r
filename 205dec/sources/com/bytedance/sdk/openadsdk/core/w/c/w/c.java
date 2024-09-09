package com.bytedance.sdk.openadsdk.core.w.c.w;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.u;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends w {

    /* renamed from: f  reason: collision with root package name */
    private int f35302f;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.xv ux;

    public c() {
    }

    public void c(com.bytedance.sdk.openadsdk.core.nativeexpress.xv xvVar) {
        this.ux = xvVar;
    }

    public c(me meVar, Context context) {
        this.f35278c = meVar;
        this.f35279w = context;
    }

    public void c(int i4) {
        this.f35302f = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c
    public void c(View view) {
        this.sr = view;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(Map<String, Object> map) {
        if (this.ux == null) {
            return false;
        }
        if (this.xv == null) {
            this.xv = new com.bytedance.sdk.openadsdk.core.u.gd();
        }
        View ux = this.xv.ux();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (ux != null) {
            iArr = xk.c(ux);
            iArr2 = xk.xv(ux);
        }
        this.ux.c(this.sr, this.f35302f, new u.c().sr(this.xv.bk()).xv(this.xv.t()).w(this.xv.ys()).c(this.xv.fp()).w(this.xv.k()).c(this.xv.a()).c(iArr[0]).w(iArr[1]).xv(iArr2[0]).sr(iArr2[1]).c(this.xv.sr()).c(this.xv.gd()).c());
        return true;
    }
}
