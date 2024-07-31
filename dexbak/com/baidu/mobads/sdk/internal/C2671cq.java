package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

/* renamed from: com.baidu.mobads.sdk.internal.cq */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2671cq extends RelativeLayout {

    /* renamed from: a */
    public static final String f8895a = "ContainerView";

    /* renamed from: b */
    private InterfaceC2672a f8896b;

    /* renamed from: com.baidu.mobads.sdk.internal.cq$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2672a {
        void onAttachedToWindow();

        @SuppressLint({"MissingSuperCall"})
        void onDetachedFromWindow();

        boolean onKeyDown(int i, KeyEvent keyEvent);

        void onLayoutComplete(int i, int i2);

        void onWindowFocusChanged(boolean z);

        void onWindowVisibilityChanged(int i);
    }

    public C2671cq(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void m50591a(InterfaceC2672a interfaceC2672a) {
        this.f8896b = interfaceC2672a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC2672a interfaceC2672a = this.f8896b;
        if (interfaceC2672a != null) {
            interfaceC2672a.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC2672a interfaceC2672a = this.f8896b;
        if (interfaceC2672a != null) {
            interfaceC2672a.onDetachedFromWindow();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterfaceC2672a interfaceC2672a = this.f8896b;
        if (interfaceC2672a != null) {
            return interfaceC2672a.onKeyDown(i, keyEvent);
        }
        super.onKeyDown(i, keyEvent);
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        InterfaceC2672a interfaceC2672a;
        super.onLayout(z, i, i2, i3, i4);
        if (!z || (interfaceC2672a = this.f8896b) == null) {
            return;
        }
        interfaceC2672a.onLayoutComplete(getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        InterfaceC2672a interfaceC2672a = this.f8896b;
        if (interfaceC2672a != null) {
            interfaceC2672a.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        InterfaceC2672a interfaceC2672a = this.f8896b;
        if (interfaceC2672a != null) {
            interfaceC2672a.onWindowVisibilityChanged(i);
        }
    }
}
