package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.p;
import com.bytedance.sdk.component.utils.q;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class WriggleGuideAnimationView extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private TextView f29639c;

    /* renamed from: f  reason: collision with root package name */
    private LottieAnimationView f29640f;

    /* renamed from: r  reason: collision with root package name */
    private p f29641r;
    private c sr;
    private LinearLayout ux;

    /* renamed from: w  reason: collision with root package name */
    private q f29642w;
    private TextView xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();
    }

    public WriggleGuideAnimationView(Context context, View view, p pVar) {
        super(context);
        this.f29641r = pVar;
        c(context, view);
    }

    public TextView getTopTextView() {
        return this.f29639c;
    }

    public LinearLayout getWriggleLayout() {
        return this.ux;
    }

    public View getWriggleProgressIv() {
        return this.f29640f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.f29642w == null) {
                this.f29642w = new q(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), 2);
            }
            this.f29642w.c(new q.c() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.2
                @Override // com.bytedance.sdk.component.utils.q.c
                public void c(int i4) {
                    if (i4 == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.sr != null) {
                        WriggleGuideAnimationView.this.sr.c();
                    }
                }
            });
            p pVar = this.f29641r;
            if (pVar != null) {
                this.f29642w.w(pVar.xv());
                this.f29642w.w(this.f29641r.ux());
                this.f29642w.c(this.f29641r.f());
            }
            this.f29642w.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q qVar = this.f29642w;
        if (qVar != null) {
            qVar.w();
        }
        try {
            LottieAnimationView lottieAnimationView = this.f29640f;
            if (lottieAnimationView != null) {
                lottieAnimationView.xv();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        q qVar = this.f29642w;
        if (qVar != null) {
            if (z3) {
                qVar.c();
            } else {
                qVar.w();
            }
        }
    }

    public void setOnShakeViewListener(c cVar) {
        this.sr = cVar;
    }

    public void setShakeText(String str) {
        this.xv.setText(str);
    }

    private void c(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.ux = (LinearLayout) findViewById(2097610722);
        this.f29639c = (TextView) findViewById(2097610719);
        this.xv = (TextView) findViewById(2097610718);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(2097610706);
        this.f29640f = lottieAnimationView;
        lottieAnimationView.setAnimation("lottie_json/twist_multi_angle.json");
        this.f29640f.setImageAssetsFolder("images/");
        this.f29640f.w(true);
    }

    public void c() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WriggleGuideAnimationView.this.f29640f.c();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }
}
