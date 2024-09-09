package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ct extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12715a = "ContainerView";

    /* renamed from: b  reason: collision with root package name */
    private a f12716b;

    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void onAttachedToWindow();

        @SuppressLint({"MissingSuperCall"})
        void onDetachedFromWindow();

        boolean onKeyDown(int i4, KeyEvent keyEvent);

        void onLayoutComplete(int i4, int i5);

        void onWindowFocusChanged(boolean z3);

        void onWindowVisibilityChanged(int i4);
    }

    public ct(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f12716b = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f12716b;
        if (aVar != null) {
            aVar.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f12716b;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        a aVar = this.f12716b;
        if (aVar != null) {
            return aVar.onKeyDown(i4, keyEvent);
        }
        super.onKeyDown(i4, keyEvent);
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        a aVar;
        super.onLayout(z3, i4, i5, i6, i7);
        if (!z3 || (aVar = this.f12716b) == null) {
            return;
        }
        aVar.onLayoutComplete(getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        a aVar = this.f12716b;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z3);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        a aVar = this.f12716b;
        if (aVar != null) {
            aVar.onWindowVisibilityChanged(i4);
        }
    }
}
