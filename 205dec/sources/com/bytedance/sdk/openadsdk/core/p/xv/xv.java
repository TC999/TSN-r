package com.bytedance.sdk.openadsdk.core.p.xv;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.bytedance.sdk.openadsdk.core.pr;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class xv implements com.bytedance.sdk.openadsdk.core.p.w.xv {
    protected WeakReference<c.InterfaceC0499c> ev;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f34382r = true;

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void c(c.InterfaceC0499c interfaceC0499c) {
        this.ev = new WeakReference<>(interfaceC0499c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.xv
    public void ux(boolean z3) {
        this.f34382r = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(Context context, me meVar, String str) {
        if (this.f34382r && com.bytedance.sdk.openadsdk.core.eq.f.c(meVar) && pr.c(context, meVar, wv.c(str), str, c())) {
            TTNativePageActivity.c(this);
            return true;
        }
        return false;
    }

    private String c() {
        c.InterfaceC0499c interfaceC0499c;
        com.bytedance.sdk.openadsdk.core.multipro.w.c eq;
        WeakReference<c.InterfaceC0499c> weakReference = this.ev;
        if (weakReference == null || (interfaceC0499c = weakReference.get()) == null || (eq = interfaceC0499c.eq()) == null) {
            return null;
        }
        return eq.c().toString();
    }
}
