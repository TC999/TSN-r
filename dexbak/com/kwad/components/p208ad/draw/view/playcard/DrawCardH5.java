package com.kwad.components.p208ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.C11102k;

/* renamed from: com.kwad.components.ad.draw.view.playcard.DrawCardH5 */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {

    /* renamed from: du */
    private ValueAnimator f25393du;

    /* renamed from: dw */
    private InterfaceC7411a f25394dw;

    /* renamed from: dx */
    private ImageView f25395dx;

    /* renamed from: dy */
    private TextView f25396dy;

    /* renamed from: dz */
    private TextView f25397dz;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private int mHeight;
    private KsLogoView mLogoView;

    /* renamed from: com.kwad.components.ad.draw.view.playcard.DrawCardH5$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7411a {
        /* renamed from: av */
        void mo33317av();

        /* renamed from: aw */
        void mo33316aw();
    }

    public DrawCardH5(Context context) {
        super(context);
        m33324B(context);
    }

    /* renamed from: B */
    private void m33324B(Context context) {
        this.mContext = context;
        C10887l.inflate(context, C9659R.C9663layout.ksad_draw_card_h5, this);
        this.f25395dx = (ImageView) findViewById(C9659R.C9662id.ksad_card_close);
        this.f25396dy = (TextView) findViewById(C9659R.C9662id.ksad_card_ad_desc);
        this.f25397dz = (TextView) findViewById(C9659R.C9662id.ksad_card_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_draw_h5_logo);
    }

    /* renamed from: aG */
    private void m33321aG() {
        ValueAnimator valueAnimator = this.f25393du;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f25393du.cancel();
        }
    }

    /* renamed from: aQ */
    private void m33319aQ() {
        m33318d(this.mHeight, 0);
    }

    /* renamed from: d */
    private void m33318d(int i, int i2) {
        m33321aG();
        ValueAnimator m29528b = C8951n.m29528b(this, i, i2);
        this.f25393du = m29528b;
        m29528b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f25393du.setDuration(300L);
        this.f25393du.start();
    }

    /* renamed from: aO */
    public final void m33320aO() {
        m33318d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f25395dx) {
            m33319aQ();
            InterfaceC7411a interfaceC7411a = this.f25394dw;
            if (interfaceC7411a != null) {
                interfaceC7411a.mo33317av();
                return;
            }
            return;
        }
        C8615a.m30233a(new C8615a.C8616a(getContext()).m30198aq(this.mAdTemplate).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                if (DrawCardH5.this.f25394dw != null) {
                    DrawCardH5.this.f25394dw.mo33316aw();
                }
            }
        }));
    }

    public final void release() {
        m33321aG();
    }

    /* renamed from: a */
    public final void m33322a(@NonNull AdTemplate adTemplate, InterfaceC7411a interfaceC7411a) {
        this.mAdTemplate = adTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.f25394dw = interfaceC7411a;
        this.f25396dy.setText(C10483a.m25915au(m25641dQ));
        this.f25397dz.setText(C10483a.m25957aE(m25641dQ));
        this.f25395dx.setOnClickListener(this);
        this.f25397dz.setOnClickListener(this);
        this.mLogoView.m28912aD(adTemplate);
        setOnClickListener(this);
        this.f25396dy.measure(View.MeasureSpec.makeMeasureSpec((C11102k.getScreenWidth(this.mContext) - (C10751a.m24924a(this.mContext, 16.0f) * 2)) - (C10751a.m24924a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mHeight = C10751a.m24924a(this.mContext, 100.0f) + this.f25396dy.getMeasuredHeight();
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m33324B(context);
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33324B(context);
    }
}
