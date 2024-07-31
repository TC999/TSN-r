package com.kwad.components.p208ad.interstitial.aggregate;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.p208ad.interstitial.p245g.C7796c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {

    /* renamed from: iR */
    private ImageView f26028iR;

    /* renamed from: iS */
    private ImageView f26029iS;

    /* renamed from: iT */
    private ImageView f26030iT;

    /* renamed from: iU */
    private int f26031iU;

    /* renamed from: iV */
    private int f26032iV;

    /* renamed from: iW */
    private final ViewPager.OnPageChangeListener f26033iW;

    /* renamed from: iv */
    private TransViewPager f26034iv;
    private AdTemplate mAdTemplate;
    private final Context mContext;

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    /* renamed from: cz */
    private void m32643cz() {
        int i = this.f26031iU;
        if (i < this.f26032iV - 1) {
            this.f26034iv.setCurrentItem(i + 1, true);
        }
    }

    private void initView() {
        C10887l.inflate(this.mContext, C9659R.C9663layout.ksad_interstitial_aggregate_manual_tips, this);
        this.f26028iR = (ImageView) findViewById(C9659R.C9662id.ksad_interstitial_aggregate_cut);
        this.f26029iS = (ImageView) findViewById(C9659R.C9662id.ksad_interstitial_aggregate_refresh);
        ImageView imageView = (ImageView) findViewById(C9659R.C9662id.ksad_interstitial_aggregate_convert);
        this.f26030iT = imageView;
        C10751a.m24923a(this, this.f26028iR, this.f26029iS, imageView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C7796c m32639y;
        if (view.equals(this.f26028iR)) {
            m32643cz();
            C9908c.m27287p(this.mAdTemplate, Opcodes.IF_ICMPGE);
        } else if (view.equals(this.f26029iS)) {
            m32643cz();
            C9908c.m27287p(this.mAdTemplate, 36);
        } else if (!view.equals(this.f26030iT) || (m32639y = this.f26034iv.m32639y(this.f26031iU)) == null) {
        } else {
            m32639y.m32353eb();
        }
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26033iW = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                InterstitialAggregateManualTipsView.this.f26031iU = i2;
                if (InterstitialAggregateManualTipsView.this.f26031iU == InterstitialAggregateManualTipsView.this.f26032iV - 1) {
                    InterstitialAggregateManualTipsView.this.f26028iR.setAlpha(0.5f);
                    InterstitialAggregateManualTipsView.this.f26029iS.setAlpha(0.5f);
                    return;
                }
                InterstitialAggregateManualTipsView.this.f26028iR.setAlpha(1.0f);
                InterstitialAggregateManualTipsView.this.f26029iS.setAlpha(1.0f);
            }
        };
        this.mContext = context;
        initView();
    }

    /* renamed from: a */
    public final void m32646a(@NonNull AdTemplate adTemplate, @NonNull TransViewPager transViewPager) {
        this.mAdTemplate = adTemplate;
        this.f26034iv = transViewPager;
        this.f26031iU = transViewPager.getCurrentItem();
        C7693a c7693a = (C7693a) transViewPager.getAdapter();
        if (c7693a == null) {
            return;
        }
        this.f26032iV = c7693a.getCount();
        new C7717d(this.f26034iv.getContext()).m32579a(this.f26034iv);
        this.f26034iv.addOnPageChangeListener(this.f26033iW);
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        String m25692dp = C10484b.m25692dp(m25641dQ);
        String m25690dq = C10484b.m25690dq(m25641dQ);
        String m25688dr = C10484b.m25688dr(m25641dQ);
        if (!TextUtils.isEmpty(m25692dp) && !TextUtils.isEmpty(m25690dq) && !TextUtils.isEmpty(m25688dr)) {
            KSImageLoader.loadImage(this.f26028iR, m25692dp);
            KSImageLoader.loadImage(this.f26029iS, m25690dq);
            KSImageLoader.loadImage(this.f26030iT, m25688dr);
            C9908c.m27337b(adTemplate, (int) Opcodes.IF_ICMPGE, (JSONObject) null);
            return;
        }
        setVisibility(8);
    }
}
