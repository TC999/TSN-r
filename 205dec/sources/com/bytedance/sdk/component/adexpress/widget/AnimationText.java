package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.sdk.component.adexpress.dynamic.sr.k;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, n.c {

    /* renamed from: a  reason: collision with root package name */
    private int f29470a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    Animation.AnimationListener f29471c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private TextView f29472f;
    private float gd;

    /* renamed from: k  reason: collision with root package name */
    private int f29473k;

    /* renamed from: p  reason: collision with root package name */
    private int f29474p;

    /* renamed from: r  reason: collision with root package name */
    private int f29475r;
    private final int sr;

    /* renamed from: t  reason: collision with root package name */
    private Handler f29476t;
    private Context ux;

    /* renamed from: w  reason: collision with root package name */
    private List<String> f29477w;
    private int xv;

    public AnimationText(Context context, int i4, float f4, int i5, int i6) {
        super(context);
        this.f29477w = new ArrayList();
        this.xv = 0;
        this.sr = 1;
        this.f29476t = new n(Looper.getMainLooper(), this);
        this.f29471c = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.f29472f != null) {
                    AnimationText.this.f29472f.setText("");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.ux = context;
        this.ev = i4;
        this.gd = f4;
        this.f29474p = i5;
        this.bk = i6;
        xv();
    }

    private void xv() {
        setFactory(this);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.f29472f = textView;
        textView.setTextColor(this.ev);
        this.f29472f.setTextSize(this.gd);
        this.f29472f.setMaxLines(this.f29474p);
        this.f29472f.setTextAlignment(this.bk);
        return this.f29472f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f29476t.sendEmptyMessageDelayed(1, this.f29475r);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f29476t.removeMessages(1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(k.w(this.f29477w.get(this.f29473k), this.gd, false)[0], 1073741824), i4);
        } catch (Exception unused) {
            super.onMeasure(i4, i5);
        }
    }

    public void setAnimationDuration(int i4) {
        this.f29475r = i4;
    }

    public void setAnimationText(List<String> list) {
        this.f29477w = list;
    }

    public void setAnimationType(int i4) {
        this.f29470a = i4;
    }

    public void setMaxLines(int i4) {
        this.f29474p = i4;
    }

    public void setTextColor(int i4) {
        this.ev = i4;
    }

    public void setTextSize(float f4) {
        this.gd = f4;
    }

    public void w() {
        List<String> list = this.f29477w;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i4 = this.xv;
        this.xv = i4 + 1;
        this.f29473k = i4;
        setText(this.f29477w.get(i4));
        if (this.xv > this.f29477w.size() - 1) {
            this.xv = 0;
        }
    }

    public void c() {
        int i4 = this.f29470a;
        if (i4 == 1) {
            setInAnimation(getContext(), i.gd(this.ux, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), i.gd(this.ux, "tt_text_animation_y_out"));
        } else if (i4 == 0) {
            setInAnimation(getContext(), i.gd(this.ux, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), i.gd(this.ux, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.f29471c);
            getOutAnimation().setAnimationListener(this.f29471c);
        }
        this.f29476t.sendEmptyMessage(1);
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what != 1) {
            return;
        }
        w();
        this.f29476t.sendEmptyMessageDelayed(1, this.f29475r);
    }
}
