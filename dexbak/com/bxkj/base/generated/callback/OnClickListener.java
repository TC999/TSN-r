package com.bxkj.base.generated.callback;

import android.view.View;

/* renamed from: com.bxkj.base.generated.callback.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OnClickListener implements View.OnClickListener {

    /* renamed from: a */
    final InterfaceC3872a f14795a;

    /* renamed from: b */
    final int f14796b;

    /* compiled from: OnClickListener.java */
    /* renamed from: com.bxkj.base.generated.callback.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3872a {
        void _internalCallbackOnClick(int i, View view);
    }

    public OnClickListener(InterfaceC3872a interfaceC3872a, int i) {
        this.f14795a = interfaceC3872a;
        this.f14796b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f14795a._internalCallbackOnClick(this.f14796b, view);
    }
}
