package com.bxkj.student.generated.callback;

import android.view.View;

/* compiled from: OnClickListener.java */
/* renamed from: com.bxkj.student.generated.callback.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class View$OnClickListenerC4297a implements View.OnClickListener {

    /* renamed from: a */
    final InterfaceC4298a f16291a;

    /* renamed from: b */
    final int f16292b;

    /* compiled from: OnClickListener.java */
    /* renamed from: com.bxkj.student.generated.callback.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC4298a {
        void _internalCallbackOnClick(int sourceId, View callbackArg_0);
    }

    public View$OnClickListenerC4297a(InterfaceC4298a listener, int sourceId) {
        this.f16291a = listener;
        this.f16292b = sourceId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View callbackArg_0) {
        this.f16291a._internalCallbackOnClick(this.f16292b, callbackArg_0);
    }
}
