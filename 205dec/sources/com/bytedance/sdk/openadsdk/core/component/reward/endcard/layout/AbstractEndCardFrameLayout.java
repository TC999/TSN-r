package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.w.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class AbstractEndCardFrameLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    protected final TTBaseVideoActivity f32331c;

    /* renamed from: w  reason: collision with root package name */
    protected final me f32332w;

    public AbstractEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, me meVar) {
        super(tTBaseVideoActivity);
        this.f32331c = tTBaseVideoActivity;
        this.f32332w = meVar;
        c();
    }

    abstract void c();

    public abstract SSWebView getEndCardWebView();

    public abstract SSWebView getPlayableWebView();

    public abstract FrameLayout getVideoArea();

    public abstract void setClickListener(w wVar);

    public void w() {
    }
}
