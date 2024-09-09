package com.bxkj.base.generated.callback;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: OnClickListener.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final InterfaceC0195a f18280a;

    /* renamed from: b  reason: collision with root package name */
    final int f18281b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OnClickListener.java */
    /* renamed from: com.bxkj.base.generated.callback.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface InterfaceC0195a {
        void _internalCallbackOnClick(int i4, View view);
    }

    public a(InterfaceC0195a interfaceC0195a, int i4) {
        this.f18280a = interfaceC0195a;
        this.f18281b = i4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f18280a._internalCallbackOnClick(this.f18281b, view);
    }
}
