package com.bxkj.student.generated.callback;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: OnClickListener.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final InterfaceC0220a f19681a;

    /* renamed from: b  reason: collision with root package name */
    final int f19682b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OnClickListener.java */
    /* renamed from: com.bxkj.student.generated.callback.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface InterfaceC0220a {
        void _internalCallbackOnClick(int sourceId, View callbackArg_0);
    }

    public a(InterfaceC0220a listener, int sourceId) {
        this.f19681a = listener;
        this.f19682b = sourceId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View callbackArg_0) {
        this.f19681a._internalCallbackOnClick(this.f19682b, callbackArg_0);
    }
}
