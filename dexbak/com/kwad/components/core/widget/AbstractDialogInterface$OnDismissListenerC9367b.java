package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.core.widget.C9362a;
import com.kwad.components.core.widget.C9371c;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p403h.AbstractC10384b;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.C11063bm;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.widget.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractDialogInterface$OnDismissListenerC9367b<T extends AdResultData, R extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, InterfaceC10385c {
    public InterfaceC9370a abm;
    private long abn;

    /* renamed from: bQ */
    private C9366b f29458bQ;

    /* renamed from: bT */
    private AbstractC10384b f29459bT;
    public AdInfo mAdInfo;
    @NonNull
    protected T mAdResultData;
    @NonNull
    public R mAdTemplate;
    @NonNull
    public Context mContext;
    private C11063bm mTimerHelper;

    /* renamed from: ms */
    protected boolean f29460ms;

    /* renamed from: com.kwad.components.core.widget.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9370a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public AbstractDialogInterface$OnDismissListenerC9367b(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: c */
    public static void m28887c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof C9362a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    private void initView() {
        C10887l.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        mo28890bc();
        this.f29458bQ = new C9366b(this, 70);
    }

    /* renamed from: aL */
    public final void m28893aL(int i) {
        C9908c.m27349a(this.mAdTemplate, i, getTouchCoords());
        InterfaceC9370a interfaceC9370a = this.abm;
        if (interfaceC9370a != null) {
            interfaceC9370a.onAdClicked();
        }
    }

    /* renamed from: aM */
    public void mo26182aM() {
    }

    /* renamed from: aN */
    public void mo26181aN() {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public void mo23565ac() {
        super.mo23565ac();
        this.f29458bQ.mo26187a(this);
        this.f29458bQ.mo26187a(this.f29459bT);
        this.f29458bQ.m28900tw();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public void mo23564ad() {
        super.mo23564ad();
        this.f29458bQ.m28899tx();
        this.f29458bQ.mo26186b(this);
        mo28889bf();
    }

    /* renamed from: b */
    public void mo28891b(@NonNull T t) {
        this.mAdResultData = t;
        R r = (R) C10485c.m25661n(t);
        this.mAdTemplate = r;
        this.mAdInfo = C10487e.m25641dQ(r);
        m28896a((ViewGroup) this);
    }

    /* renamed from: bc */
    protected abstract void mo28890bc();

    /* renamed from: bf */
    public void mo28889bf() {
    }

    /* renamed from: bv */
    protected void mo28888bv() {
        InterfaceC9370a interfaceC9370a;
        if (!this.mAdTemplate.mPvReported && (interfaceC9370a = this.abm) != null) {
            interfaceC9370a.onAdShow();
        }
        C9913b c9913b = new C9913b();
        C9893a.C9894a c9894a = new C9893a.C9894a();
        FeedType fromInt = FeedType.fromInt(this.mAdTemplate.type);
        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        c9894a.templateId = String.valueOf(fromInt.getType());
        c9913b.m27268b(c9894a);
        c9913b.m27245v(getHeight(), getWidth());
        C8934b.m29570qY().m29571a(this.mAdTemplate, null, c9913b);
    }

    protected float getHWRatio() {
        return 0.0f;
    }

    protected abstract int getLayoutId();

    public long getStayTime() {
        return this.abn + getTimerHelper().getTime();
    }

    public C11063bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new C11063bm();
        }
        return this.mTimerHelper;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        InterfaceC9370a interfaceC9370a = this.abm;
        if (interfaceC9370a != null) {
            interfaceC9370a.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        InterfaceC9370a interfaceC9370a = this.abm;
        if (interfaceC9370a != null) {
            interfaceC9370a.onDownloadTipsDialogShow();
        }
    }

    public void setInnerAdInteractionListener(InterfaceC9370a interfaceC9370a) {
        this.abm = interfaceC9370a;
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        setBackgroundColor(-1);
    }

    public void setPageExitListener(AbstractC10384b abstractC10384b) {
        this.f29459bT = abstractC10384b;
    }

    /* renamed from: tj */
    public final void m28885tj() {
        InterfaceC9370a interfaceC9370a = this.abm;
        if (interfaceC9370a != null) {
            interfaceC9370a.onAdClicked();
        }
    }

    /* renamed from: tk */
    public final void m28884tk() {
        C9908c.m27330bE(this.mAdTemplate);
        InterfaceC9370a interfaceC9370a = this.abm;
        if (interfaceC9370a != null) {
            interfaceC9370a.onDislikeClicked();
        }
    }

    public AbstractDialogInterface$OnDismissListenerC9367b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractDialogInterface$OnDismissListenerC9367b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    /* renamed from: a */
    private void m28896a(ViewGroup viewGroup) {
        if (!C10251d.m26541Cn() && C10251d.m26542Cm() >= 0.0f) {
            m28887c(viewGroup);
            C9362a c9362a = new C9362a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(c9362a);
            c9362a.setViewCallback(new C9362a.InterfaceC9363a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.C9362a.InterfaceC9363a
                /* renamed from: ac */
                public final void mo28883ac() {
                }

                @Override // com.kwad.components.core.widget.C9362a.InterfaceC9363a
                /* renamed from: ad */
                public final void mo28882ad() {
                    if (AbstractDialogInterface$OnDismissListenerC9367b.this.mAdTemplate.mPvReported) {
                        AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b = AbstractDialogInterface$OnDismissListenerC9367b.this;
                        if (abstractDialogInterface$OnDismissListenerC9367b.f29460ms) {
                            long m23864Nq = abstractDialogInterface$OnDismissListenerC9367b.getTimerHelper().m23864Nq();
                            AbstractDialogInterface$OnDismissListenerC9367b.this.abn += m23864Nq;
                            C9908c.m27346a(AbstractDialogInterface$OnDismissListenerC9367b.this.mAdTemplate, m23864Nq, (JSONObject) null);
                            AbstractDialogInterface$OnDismissListenerC9367b.this.f29460ms = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.C9362a.InterfaceC9363a
                /* renamed from: ep */
                public final void mo28881ep() {
                    if (AbstractDialogInterface$OnDismissListenerC9367b.this.mAdTemplate.mPvReported) {
                        AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b = AbstractDialogInterface$OnDismissListenerC9367b.this;
                        if (abstractDialogInterface$OnDismissListenerC9367b.f29460ms) {
                            long m23864Nq = abstractDialogInterface$OnDismissListenerC9367b.getTimerHelper().m23864Nq();
                            AbstractDialogInterface$OnDismissListenerC9367b.this.abn += m23864Nq;
                            C9908c.m27346a(AbstractDialogInterface$OnDismissListenerC9367b.this.mAdTemplate, m23864Nq, (JSONObject) null);
                            AbstractDialogInterface$OnDismissListenerC9367b.this.f29460ms = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.C9362a.InterfaceC9363a
                /* renamed from: k */
                public final void mo28880k(View view) {
                    if (!AbstractDialogInterface$OnDismissListenerC9367b.this.mAdTemplate.mPvReported) {
                        AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b = AbstractDialogInterface$OnDismissListenerC9367b.this;
                        if (abstractDialogInterface$OnDismissListenerC9367b.abm != null) {
                            abstractDialogInterface$OnDismissListenerC9367b.f29460ms = true;
                            abstractDialogInterface$OnDismissListenerC9367b.mo28888bv();
                            AbstractDialogInterface$OnDismissListenerC9367b.this.getTimerHelper().startTiming();
                        }
                    }
                    AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b2 = AbstractDialogInterface$OnDismissListenerC9367b.this;
                    if (!abstractDialogInterface$OnDismissListenerC9367b2.f29460ms) {
                        abstractDialogInterface$OnDismissListenerC9367b2.getTimerHelper().startTiming();
                    }
                    AbstractDialogInterface$OnDismissListenerC9367b.this.f29460ms = true;
                }
            });
            c9362a.m28904ti();
            return;
        }
        C9371c m28892b = m28892b(viewGroup);
        if (m28892b == null) {
            m28892b = new C9371c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(m28892b);
        }
        m28892b.setViewCallback(new C9371c.InterfaceC9372a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.C9371c.InterfaceC9372a
            /* renamed from: eq */
            public final void mo28875eq() {
                AbstractDialogInterface$OnDismissListenerC9367b.this.mo28888bv();
            }
        });
        m28892b.setNeedCheckingShow(true);
    }

    /* renamed from: b */
    private static C9371c m28892b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof C9371c) {
                return (C9371c) childAt;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final void m28886c(@NonNull C9913b c9913b) {
        c9913b.m27247f(getTouchCoords());
        C9908c.m27340a(this.mAdTemplate, c9913b, (JSONObject) null);
        InterfaceC9370a interfaceC9370a = this.abm;
        if (interfaceC9370a != null) {
            interfaceC9370a.onAdClicked();
        }
    }
}
