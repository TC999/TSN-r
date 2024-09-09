package com.kwad.components.ad.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a extends LinearLayout {
    protected TextProgressBar BH;
    protected AppScoreView Br;
    protected View Hh;
    protected TextView Ir;
    protected TextView dH;
    protected ValueAnimator jo;
    protected ImageView kT;
    protected TextView kU;
    protected View ya;
    protected Button yb;
    protected Button yc;
    protected KsAppTagsView yi;
    protected com.kwad.components.ad.i.a yl;
    private Runnable ym;

    public a(Context context) {
        this(context, null);
    }

    private void initView() {
        this.Hh = l.inflate(getContext(), getLayoutId(), this);
        this.kT = (ImageView) findViewById(R.id.ksad_app_icon);
        this.kU = (TextView) findViewById(R.id.ksad_app_name);
        this.Br = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dH = (TextView) findViewById(R.id.ksad_app_download_count);
        this.Ir = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.BH = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.d.a.a.a(getContext(), 16.0f));
        this.BH.setTextColor(-1);
        this.yi = (KsAppTagsView) findViewById(R.id.ksad_reward_apk_info_tags);
        this.yb = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
        this.yc = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
        this.ya = findViewById(R.id.ksad_reward_apk_info_install_container);
        this.yl = new com.kwad.components.ad.i.a(this.Hh);
    }

    private void mq() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.jo = ofFloat;
            ofFloat.setDuration(1200L);
            this.jo.setRepeatCount(-1);
            this.jo.setRepeatMode(1);
            this.jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    a.this.BH.setScaleY(floatValue);
                    a.this.BH.setScaleX(floatValue);
                }
            });
            this.jo.start();
        }
    }

    public final void D(@NonNull AdInfo adInfo) {
        int i4 = adInfo.status;
        if (i4 != 1 && i4 != 2 && i4 != 3) {
            mq();
        } else {
            km();
        }
    }

    public void b(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        if (e.F(adTemplate)) {
            KSImageLoader.loadAppIcon(this.kT, com.kwad.sdk.core.response.b.a.cI(dQ), adTemplate, 12);
        } else {
            KSImageLoader.loadAppIcon(this.kT, com.kwad.sdk.core.response.b.a.cf(dQ), adTemplate, 12);
        }
        this.kU.setText(com.kwad.sdk.core.response.b.a.cc(dQ));
        if (!e.F(adTemplate)) {
            float aA = com.kwad.sdk.core.response.b.a.aA(dQ);
            if (aA >= 3.0f) {
                this.Br.setScore(aA);
                this.Br.setVisibility(0);
            } else {
                this.Br.setVisibility(8);
            }
            String az = com.kwad.sdk.core.response.b.a.az(dQ);
            if (!TextUtils.isEmpty(az)) {
                this.dH.setText(az);
                this.dH.setVisibility(0);
            } else {
                this.dH.setVisibility(8);
            }
        }
        this.Ir.setText(com.kwad.sdk.core.response.b.a.au(dQ));
        if (e.F(adTemplate)) {
            this.BH.setVisibility(8);
            this.ya.setVisibility(0);
            this.yc.setText("\u67e5\u770b\u8be6\u60c5");
            Button button = this.yb;
            StringBuilder sb = new StringBuilder();
            sb.append(d.Cg());
            button.setText(String.format("\u6d4f\u89c8\u8be6\u60c5\u9875%s\u79d2\uff0c\u9886\u53d6\u5956\u52b1", sb.toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.ym == null) {
                    this.ym = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.yl.hT();
                        }
                    };
                }
                this.ya.postDelayed(this.ym, 1600L);
            }
        } else {
            this.BH.setVisibility(0);
            this.ya.setVisibility(8);
            Runnable runnable = this.ym;
            if (runnable != null) {
                this.ya.removeCallbacks(runnable);
                this.ym = null;
            }
            D(e.dQ(adTemplate));
        }
        if (e.F(adTemplate)) {
            List<String> dH = com.kwad.sdk.core.response.b.d.dH(adTemplate);
            if (dH.size() > 0) {
                this.yi.setVisibility(0);
            } else {
                this.yi.setVisibility(8);
            }
            this.yi.setAppTags(dH);
        }
    }

    public View getBtnInstallContainer() {
        return this.ya;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        return this.BH;
    }

    public final void km() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.jo.cancel();
            this.jo.end();
        }
        Runnable runnable = this.ym;
        if (runnable != null) {
            this.ya.removeCallbacks(runnable);
            this.ym = null;
        }
        this.yl.mb();
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(l.wrapContextIfNeed(context), attributeSet, i4);
        initView();
    }
}
