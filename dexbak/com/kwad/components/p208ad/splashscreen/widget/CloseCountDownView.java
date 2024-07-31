package com.kwad.components.p208ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.ad.splashscreen.widget.CloseCountDownView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CloseCountDownView extends LinearLayout {

    /* renamed from: EI */
    private InterfaceC8504a f27912EI;

    /* renamed from: FJ */
    private String f27913FJ;

    /* renamed from: FK */
    private int f27914FK;

    /* renamed from: FL */
    private TextView f27915FL;

    /* renamed from: FM */
    private TextView f27916FM;

    /* renamed from: FN */
    private ImageView f27917FN;

    /* renamed from: FO */
    private Runnable f27918FO;

    /* renamed from: nD */
    private boolean f27919nD;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CloseCountDownView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8504a {
        /* renamed from: df */
        void mo30514df();

        /* renamed from: lb */
        void mo30513lb();
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.f27913FJ = "%ss";
        this.f27914FK = 5;
        this.f27919nD = false;
        this.f27918FO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.f27919nD) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.f27914FK > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.m30522ab(closeCountDownView.f27914FK);
                    CloseCountDownView.m30518d(CloseCountDownView.this);
                } else if (CloseCountDownView.this.f27912EI != null) {
                    CloseCountDownView.this.f27912EI.mo30513lb();
                }
            }
        };
        m30528V(context);
    }

    /* renamed from: V */
    private void m30528V(Context context) {
        setOrientation(0);
        C10887l.inflate(context, C9659R.C9663layout.ksad_endcard_close_view, this);
        this.f27915FL = (TextView) findViewById(C9659R.C9662id.ksad_ad_endcard_second);
        this.f27916FM = (TextView) findViewById(C9659R.C9662id.ksad_ad_endcard_line);
        ImageView imageView = (ImageView) findViewById(C9659R.C9662id.ksad_splash_endcard_close_img);
        this.f27917FN = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CloseCountDownView.this.f27912EI != null) {
                    CloseCountDownView.this.f27912EI.mo30514df();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ab */
    public void m30522ab(int i) {
        this.f27915FL.setText(String.format(this.f27913FJ, Integer.valueOf(i)));
    }

    /* renamed from: d */
    static /* synthetic */ int m30518d(CloseCountDownView closeCountDownView) {
        int i = closeCountDownView.f27914FK;
        closeCountDownView.f27914FK = i - 1;
        return i;
    }

    /* renamed from: eF */
    private void m30517eF() {
        post(this.f27918FO);
    }

    /* renamed from: eG */
    private void m30516eG() {
        this.f27919nD = true;
    }

    /* renamed from: eH */
    private void m30515eH() {
        this.f27919nD = false;
    }

    /* renamed from: aM */
    public final void m30524aM() {
        m30515eH();
    }

    /* renamed from: aN */
    public final void m30523aN() {
        m30516eG();
    }

    /* renamed from: bf */
    public final void m30520bf() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public void setOnViewClickListener(InterfaceC8504a interfaceC8504a) {
        this.f27912EI = interfaceC8504a;
    }

    /* renamed from: a */
    public final void m30525a(AdInfo adInfo) {
        boolean m25813cm = C10483a.m25813cm(adInfo);
        this.f27914FK = C10483a.m25814cl(adInfo);
        if (m25813cm) {
            this.f27915FL.setVisibility(0);
            this.f27916FM.setVisibility(0);
            m30522ab(this.f27914FK);
            setPadding(C10751a.m24924a(getContext(), 12.0f), 0, C10751a.m24924a(getContext(), 12.0f), 0);
        } else {
            setPadding(C10751a.m24924a(getContext(), 4.0f), 0, C10751a.m24924a(getContext(), 4.0f), 0);
        }
        m30517eF();
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27913FJ = "%ss";
        this.f27914FK = 5;
        this.f27919nD = false;
        this.f27918FO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.f27919nD) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.f27914FK > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.m30522ab(closeCountDownView.f27914FK);
                    CloseCountDownView.m30518d(CloseCountDownView.this);
                } else if (CloseCountDownView.this.f27912EI != null) {
                    CloseCountDownView.this.f27912EI.mo30513lb();
                }
            }
        };
        m30528V(context);
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27913FJ = "%ss";
        this.f27914FK = 5;
        this.f27919nD = false;
        this.f27918FO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.f27919nD) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.f27914FK > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.m30522ab(closeCountDownView.f27914FK);
                    CloseCountDownView.m30518d(CloseCountDownView.this);
                } else if (CloseCountDownView.this.f27912EI != null) {
                    CloseCountDownView.this.f27912EI.mo30513lb();
                }
            }
        };
        m30528V(context);
    }

    @RequiresApi(api = 21)
    public CloseCountDownView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f27913FJ = "%ss";
        this.f27914FK = 5;
        this.f27919nD = false;
        this.f27918FO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.f27919nD) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.f27914FK > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.m30522ab(closeCountDownView.f27914FK);
                    CloseCountDownView.m30518d(CloseCountDownView.this);
                } else if (CloseCountDownView.this.f27912EI != null) {
                    CloseCountDownView.this.f27912EI.mo30513lb();
                }
            }
        };
        m30528V(context);
    }
}
