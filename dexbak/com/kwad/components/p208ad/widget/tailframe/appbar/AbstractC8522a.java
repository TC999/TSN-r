package com.kwad.components.p208ad.widget.tailframe.appbar;

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
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.p208ad.p237i.C7680a;
import com.kwad.components.p208ad.widget.AppScoreView;
import com.kwad.components.p208ad.widget.KsAppTagsView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import java.util.List;

/* renamed from: com.kwad.components.ad.widget.tailframe.appbar.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8522a extends LinearLayout {

    /* renamed from: BH */
    protected TextProgressBar f28029BH;

    /* renamed from: Br */
    protected AppScoreView f28030Br;

    /* renamed from: Hh */
    protected View f28031Hh;

    /* renamed from: Ir */
    protected TextView f28032Ir;

    /* renamed from: dH */
    protected TextView f28033dH;

    /* renamed from: jo */
    protected ValueAnimator f28034jo;

    /* renamed from: kT */
    protected ImageView f28035kT;

    /* renamed from: kU */
    protected TextView f28036kU;

    /* renamed from: ya */
    protected View f28037ya;

    /* renamed from: yb */
    protected Button f28038yb;

    /* renamed from: yc */
    protected Button f28039yc;

    /* renamed from: yi */
    protected KsAppTagsView f28040yi;

    /* renamed from: yl */
    protected C7680a f28041yl;

    /* renamed from: ym */
    private Runnable f28042ym;

    public AbstractC8522a(Context context) {
        this(context, null);
    }

    private void initView() {
        this.f28031Hh = C10887l.inflate(getContext(), getLayoutId(), this);
        this.f28035kT = (ImageView) findViewById(C9659R.C9662id.ksad_app_icon);
        this.f28036kU = (TextView) findViewById(C9659R.C9662id.ksad_app_name);
        this.f28030Br = (AppScoreView) findViewById(C9659R.C9662id.ksad_app_score);
        this.f28033dH = (TextView) findViewById(C9659R.C9662id.ksad_app_download_count);
        this.f28032Ir = (TextView) findViewById(C9659R.C9662id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(C9659R.C9662id.ksad_download_bar);
        this.f28029BH = textProgressBar;
        textProgressBar.setTextDimen(C10751a.m24924a(getContext(), 16.0f));
        this.f28029BH.setTextColor(-1);
        this.f28040yi = (KsAppTagsView) findViewById(C9659R.C9662id.ksad_reward_apk_info_tags);
        this.f28038yb = (Button) findViewById(C9659R.C9662id.ksad_reward_apk_info_install_action);
        this.f28039yc = (Button) findViewById(C9659R.C9662id.ksad_reward_apk_info_install_start);
        this.f28037ya = findViewById(C9659R.C9662id.ksad_reward_apk_info_install_container);
        this.f28041yl = new C7680a(this.f28031Hh);
    }

    /* renamed from: mq */
    private void m30420mq() {
        ValueAnimator valueAnimator = this.f28034jo;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f28034jo = ofFloat;
            ofFloat.setDuration(1200L);
            this.f28034jo.setRepeatCount(-1);
            this.f28034jo.setRepeatMode(1);
            this.f28034jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    AbstractC8522a.this.f28029BH.setScaleY(floatValue);
                    AbstractC8522a.this.f28029BH.setScaleX(floatValue);
                }
            });
            this.f28034jo.start();
        }
    }

    /* renamed from: D */
    public final void m30423D(@NonNull AdInfo adInfo) {
        int i = adInfo.status;
        if (i != 1 && i != 2 && i != 3) {
            m30420mq();
        } else {
            m30421km();
        }
    }

    /* renamed from: b */
    public void mo30422b(@NonNull AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (C10487e.m25654F(adTemplate)) {
            KSImageLoader.loadAppIcon(this.f28035kT, C10483a.m25845cI(m25641dQ), adTemplate, 12);
        } else {
            KSImageLoader.loadAppIcon(this.f28035kT, C10483a.m25820cf(m25641dQ), adTemplate, 12);
        }
        this.f28036kU.setText(C10483a.m25823cc(m25641dQ));
        if (!C10487e.m25654F(adTemplate)) {
            float m25961aA = C10483a.m25961aA(m25641dQ);
            if (m25961aA >= 3.0f) {
                this.f28030Br.setScore(m25961aA);
                this.f28030Br.setVisibility(0);
            } else {
                this.f28030Br.setVisibility(8);
            }
            String m25910az = C10483a.m25910az(m25641dQ);
            if (!TextUtils.isEmpty(m25910az)) {
                this.f28033dH.setText(m25910az);
                this.f28033dH.setVisibility(0);
            } else {
                this.f28033dH.setVisibility(8);
            }
        }
        this.f28032Ir.setText(C10483a.m25915au(m25641dQ));
        if (C10487e.m25654F(adTemplate)) {
            this.f28029BH.setVisibility(8);
            this.f28037ya.setVisibility(0);
            this.f28039yc.setText("查看详情");
            Button button = this.f28038yb;
            StringBuilder sb = new StringBuilder();
            sb.append(C10251d.m26548Cg());
            button.setText(String.format("浏览详情页%s秒，领取奖励", sb.toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.f28042ym == null) {
                    this.f28042ym = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AbstractC8522a.this.f28041yl.m32654hT();
                        }
                    };
                }
                this.f28037ya.postDelayed(this.f28042ym, 1600L);
            }
        } else {
            this.f28029BH.setVisibility(0);
            this.f28037ya.setVisibility(8);
            Runnable runnable = this.f28042ym;
            if (runnable != null) {
                this.f28037ya.removeCallbacks(runnable);
                this.f28042ym = null;
            }
            m30423D(C10487e.m25641dQ(adTemplate));
        }
        if (C10487e.m25654F(adTemplate)) {
            List<String> m25655dH = C10486d.m25655dH(adTemplate);
            if (m25655dH.size() > 0) {
                this.f28040yi.setVisibility(0);
            } else {
                this.f28040yi.setVisibility(8);
            }
            this.f28040yi.setAppTags(m25655dH);
        }
    }

    public View getBtnInstallContainer() {
        return this.f28037ya;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        return this.f28029BH;
    }

    /* renamed from: km */
    public final void m30421km() {
        ValueAnimator valueAnimator = this.f28034jo;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f28034jo.cancel();
            this.f28034jo.end();
        }
        Runnable runnable = this.f28042ym;
        if (runnable != null) {
            this.f28037ya.removeCallbacks(runnable);
            this.f28042ym = null;
        }
        this.f28041yl.m32652mb();
    }

    public AbstractC8522a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractC8522a(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C10887l.wrapContextIfNeed(context), attributeSet, i);
        initView();
    }
}
