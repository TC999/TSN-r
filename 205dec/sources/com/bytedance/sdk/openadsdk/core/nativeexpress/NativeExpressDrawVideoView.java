package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeExpressDrawVideoView extends NativeExpressVideoView {

    /* renamed from: u  reason: collision with root package name */
    private int f34003u;

    public NativeExpressDrawVideoView(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str) {
        super(context, meVar, wVar, str);
        this.f34003u = getResources().getConfiguration().orientation;
    }

    private void q() {
        int i4 = getResources().getConfiguration().orientation;
        if (this.f34003u != i4) {
            this.f34003u = i4;
            xk.c(this, new xk.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressDrawVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.eq.xk.c
                public void c(View view) {
                    int width = NativeExpressDrawVideoView.this.getWidth();
                    int height = NativeExpressDrawVideoView.this.getHeight();
                    NativeExpressDrawVideoView nativeExpressDrawVideoView = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView.c(nativeExpressDrawVideoView.bk, width, height);
                    View findViewById = NativeExpressDrawVideoView.this.bk.findViewById(2114387713);
                    NativeExpressDrawVideoView.this.c(findViewById, width, height);
                    if (findViewById != null) {
                        findViewById.requestLayout();
                    }
                    NativeExpressDrawVideoView nativeExpressDrawVideoView2 = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView2.c(nativeExpressDrawVideoView2.getWebView(), width, height);
                    ExpressVideoView expressVideoView = ((NativeExpressVideoView) NativeExpressDrawVideoView.this).f34005c;
                    if (expressVideoView != null) {
                        expressVideoView.c(width, height);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView, com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        q();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        q();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView
    protected ExpressVideoView c(Context context, me meVar, String str) {
        return new ExpressVideoView(context, meVar, str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i4;
        layoutParams.height = i5;
        view.setLayoutParams(layoutParams);
    }
}
