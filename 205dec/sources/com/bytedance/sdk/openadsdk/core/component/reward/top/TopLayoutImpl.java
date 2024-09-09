package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TopLayoutImpl extends FrameLayout implements c<TopLayoutImpl> {

    /* renamed from: a  reason: collision with root package name */
    private View f32578a;
    private View bk;

    /* renamed from: c  reason: collision with root package name */
    private View f32579c;
    private View ev;

    /* renamed from: f  reason: collision with root package name */
    private View f32580f;
    private me fp;
    private TextView gd;

    /* renamed from: k  reason: collision with root package name */
    private TextView f32581k;

    /* renamed from: p  reason: collision with root package name */
    private View f32582p;

    /* renamed from: r  reason: collision with root package name */
    private View f32583r;
    private View sr;

    /* renamed from: t  reason: collision with root package name */
    private boolean f32584t;
    private TextView ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f32585w;
    private View xv;
    private w ys;

    public TopLayoutImpl(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public View getCloseButton() {
        return this.f32582p;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public boolean getSkipOrCloseVisible() {
        return xk.sr(this.f32582p) || (this.f32580f != null && xk.sr(this.f32581k) && !TextUtils.isEmpty(this.f32581k.getText()));
    }

    public w getTopListener() {
        return this.ys;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setDislikeLeft(boolean z3) {
        if (this.f32579c.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f32579c.getLayoutParams();
            layoutParams.gravity = z3 ? 8388611 : 8388613;
            this.f32579c.setLayoutParams(layoutParams);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setListener(w wVar) {
        this.ys = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setPlayAgainEntranceText(String str) {
        xk.c(this.ux, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setShowAgain(boolean z3) {
        xk.c(this.sr, z3 ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setShowBack(boolean z3) {
        View view = this.xv;
        if (view != null) {
            view.setVisibility(z3 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setShowDislike(boolean z3) {
        View view = this.f32579c;
        if (view != null) {
            view.setVisibility(z3 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setShowSound(boolean z3) {
        ImageView imageView = this.f32585w;
        if (imageView != null) {
            imageView.setVisibility(z3 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setSoundMute(boolean z3) {
        Drawable xv;
        this.f32584t = z3;
        if (z3) {
            xv = i.xv(getContext(), "tt_mute");
        } else {
            xv = i.xv(getContext(), "tt_unmute");
        }
        this.f32585w.setImageDrawable(xv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void setVisible(boolean z3) {
        setVisibility(z3 ? 0 : 8);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void sr() {
        xk.c(this.f32579c, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.ys != null) {
                    TopLayoutImpl.this.ys.xv(view);
                }
            }
        }, "top_dislike_button");
        xk.c(this.f32585w, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopLayoutImpl topLayoutImpl = TopLayoutImpl.this;
                topLayoutImpl.f32584t = !topLayoutImpl.f32584t;
                TopLayoutImpl.this.f32585w.setImageDrawable(TopLayoutImpl.this.f32584t ? i.xv(TopLayoutImpl.this.getContext(), "tt_mute") : i.xv(TopLayoutImpl.this.getContext(), "tt_unmute"));
                if (TopLayoutImpl.this.ys != null) {
                    TopLayoutImpl.this.ys.w(view);
                }
            }
        }, "top_mute_button");
        xk.c(this.f32583r, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "top_before_button");
        xk.c(this.f32582p, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", TopLayoutImpl.this.ys);
                    jSONObject.put("topImpl", 1);
                } catch (Throwable unused) {
                }
                if (!ls.c(TopLayoutImpl.this.fp) || com.bytedance.sdk.openadsdk.core.bk.sr.c(String.valueOf(wv.gd(TopLayoutImpl.this.fp)))) {
                    a.c().c(TopLayoutImpl.this.fp, "stats_reward_full_click_native_close", jSONObject);
                }
                if (TopLayoutImpl.this.ys != null) {
                    TopLayoutImpl.this.ys.c(view);
                }
            }
        }, "top_skip_button");
        xk.c(this.xv, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.ys != null) {
                    TopLayoutImpl.this.ys.sr(view);
                }
            }
        }, "top_back_button");
        xk.c(this.sr, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.ys != null) {
                    TopLayoutImpl.this.ys.ux(view);
                }
            }
        }, "top_again_button");
        xk.c(this.f32580f, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.ys != null) {
                    TopLayoutImpl.this.ys.f(view);
                }
            }
        }, "top_skip_border");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void w() {
        ImageView imageView = this.f32585w;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void xv() {
        View view = this.f32579c;
        if (view != null) {
            view.performClick();
        }
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    public TopLayoutImpl c(me meVar) {
        this.fp = meVar;
        if (fp.k(meVar)) {
            addView(com.bytedance.sdk.openadsdk.res.ux.ev(getContext()));
        } else {
            addView(com.bytedance.sdk.openadsdk.res.ux.r(getContext()));
        }
        this.f32579c = findViewById(2114387848);
        this.f32585w = (ImageView) findViewById(2114387760);
        this.xv = findViewById(2114387822);
        this.sr = findViewById(2114387672);
        this.ux = (TextView) findViewById(2114387631);
        this.f32580f = findViewById(2114387712);
        this.f32583r = findViewById(2114387951);
        this.ev = findViewById(2114387725);
        this.gd = (TextView) findViewById(2114387605);
        this.f32582p = findViewById(2114387634);
        this.f32581k = (TextView) findViewById(2114387787);
        this.f32578a = findViewById(2114387739);
        this.bk = findViewById(2114387930);
        View view = this.f32582p;
        if (view != null) {
            view.setEnabled(false);
            this.f32582p.setClickable(false);
        }
        sr();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void c(boolean z3, String str, String str2, boolean z4, boolean z5) {
        xk.c(this.f32580f, 0);
        boolean z6 = true;
        boolean z7 = z3 || !TextUtils.isEmpty(str);
        boolean z8 = z4 || !TextUtils.isEmpty(str2);
        z6 = (z7 && z8) ? false : false;
        xk.c(this.f32580f, (z7 || z8) ? 0 : 4);
        xk.c(this.f32583r, z7 ? 0 : 8);
        xk.c(this.f32582p, z8 ? 0 : 8);
        xk.c(this.bk, z6 ? 0 : 8);
        xk.c(this.ev, z3 ? 0 : 8);
        xk.c((View) this.gd, !TextUtils.isEmpty(str) ? 0 : 8);
        xk.c(this.f32578a, z4 ? 0 : 8);
        xk.c((View) this.f32581k, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            xk.c(this.gd, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            xk.c(this.f32581k, str2);
        }
        View view = this.f32582p;
        if (view != null) {
            view.setEnabled(z5);
            this.f32582p.setClickable(z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.c
    public void c() {
        View view = this.f32582p;
        if (view != null) {
            view.performClick();
        }
    }
}
