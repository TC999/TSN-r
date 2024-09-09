package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RewardBrowserMixTopLayoutImpl extends FrameLayout implements c<RewardBrowserMixTopLayoutImpl> {

    /* renamed from: c  reason: collision with root package name */
    private View f32575c;

    /* renamed from: w  reason: collision with root package name */
    private w f32576w;
    private me xv;

    public RewardBrowserMixTopLayoutImpl(Context context) {
        this(context, null);
    }

    private void sr() {
        xk.c(this.f32575c, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", RewardBrowserMixTopLayoutImpl.this.f32576w);
                    jSONObject.put("topImpl", 2);
                } catch (Throwable unused) {
                }
                a.c().c(RewardBrowserMixTopLayoutImpl.this.xv, "stats_reward_full_click_native_close", jSONObject);
                if (RewardBrowserMixTopLayoutImpl.this.f32576w != null) {
                    RewardBrowserMixTopLayoutImpl.this.f32576w.c(view);
                }
            }
        }, "top_skip_border");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void c(boolean z3, String str, String str2, boolean z4, boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public View getCloseButton() {
        return this.f32575c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public boolean getSkipOrCloseVisible() {
        return xk.sr(this.f32575c);
    }

    public w getTopListener() {
        return this.f32576w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setDislikeLeft(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setListener(w wVar) {
        this.f32576w = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setPlayAgainEntranceText(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setShowAgain(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setShowBack(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setShowDislike(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setShowSound(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setSoundMute(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setVisible(boolean z3) {
        setVisibility(z3 ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void w() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void xv() {
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardBrowserMixTopLayoutImpl c(me meVar) {
        this.xv = meVar;
        addView(com.bytedance.sdk.openadsdk.res.ux.ev(getContext()));
        if (fp.bk(meVar)) {
            this.f32575c = findViewById(2114387872);
        } else {
            this.f32575c = findViewById(2114387712);
        }
        View view = this.f32575c;
        if (view != null) {
            view.setVisibility(0);
            this.f32575c.setEnabled(true);
            this.f32575c.setClickable(true);
        }
        sr();
        return this;
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void c() {
        View view = this.f32575c;
        if (view != null) {
            view.performClick();
        }
    }
}
