package com.kwad.components.p208ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.p208ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.p208ad.splashscreen.p277b.C8363a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.ad.splashscreen.widget.SkipView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SkipView extends LinearLayout implements InterfaceC8512a {

    /* renamed from: FD */
    private InterfaceC8510a f27953FD;

    /* renamed from: FO */
    private Runnable f27954FO;

    /* renamed from: GW */
    private final C8511b f27955GW;

    /* renamed from: GX */
    private View f27956GX;

    /* renamed from: GY */
    private TextView f27957GY;

    /* renamed from: GZ */
    private TextView f27958GZ;

    /* renamed from: Ha */
    private int f27959Ha;

    /* renamed from: nD */
    private boolean f27960nD;

    /* renamed from: sB */
    private boolean f27961sB;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.SkipView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8510a {
        /* renamed from: Y */
        void mo30483Y(int i);

        /* renamed from: la */
        void mo30482la();

        /* renamed from: lb */
        void mo30481lb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.splashscreen.widget.SkipView$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8511b {

        /* renamed from: FK */
        private int f27964FK;

        /* renamed from: Hc */
        private String f27965Hc;

        /* renamed from: Hd */
        private String f27966Hd;

        /* renamed from: He */
        private int f27967He;

        /* renamed from: Hf */
        private boolean f27968Hf;

        /* renamed from: Hg */
        private boolean f27969Hg;

        private C8511b() {
            this.f27965Hc = "跳过";
            this.f27966Hd = "";
            this.f27967He = 5;
            this.f27964FK = 5;
            this.f27968Hf = true;
            this.f27969Hg = true;
        }

        /* renamed from: d */
        static /* synthetic */ int m30472d(C8511b c8511b) {
            int i = c8511b.f27964FK;
            c8511b.f27964FK = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ma */
        public boolean m30465ma() {
            return this.f27968Hf && this.f27969Hg;
        }

        /* renamed from: W */
        public final void m30480W(String str) {
            this.f27964FK = -1;
            this.f27966Hd = str;
        }

        /* renamed from: ad */
        public final void m30477ad(int i) {
            this.f27967He = i;
            this.f27964FK = i;
        }

        /* renamed from: lY */
        public final String m30467lY() {
            int i = this.f27964FK;
            if (i < 0) {
                return this.f27966Hd;
            }
            if (i == 0) {
                return this.f27966Hd + 1;
            }
            return this.f27966Hd + this.f27964FK;
        }

        /* renamed from: lZ */
        public final boolean m30466lZ() {
            return this.f27964FK <= 0;
        }

        /* synthetic */ C8511b(byte b) {
            this();
        }
    }

    public SkipView(Context context) {
        this(context, null);
    }

    /* renamed from: C */
    private void m30496C(AdInfo adInfo) {
        setTimerBtnVisible(C10483a.m25801cy(adInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public void m30494X(int i) {
        InterfaceC8510a interfaceC8510a = this.f27953FD;
        if (interfaceC8510a != null) {
            interfaceC8510a.mo30483Y(i);
        }
    }

    /* renamed from: eF */
    private void m30487eF() {
        m30493a(this.f27955GW);
        post(this.f27954FO);
    }

    /* renamed from: eG */
    private void m30486eG() {
        this.f27960nD = true;
    }

    /* renamed from: eH */
    private void m30485eH() {
        this.f27960nD = false;
    }

    private void init() {
        setOrientation(0);
        C10887l.inflate(getContext(), C9659R.C9663layout.ksad_skip_view, this);
        this.f27957GY = (TextView) findViewById(C9659R.C9662id.ksad_skip_view_skip);
        this.f27958GZ = (TextView) findViewById(C9659R.C9662id.ksad_skip_view_timer);
        this.f27956GX = findViewById(C9659R.C9662id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SkipView.this.f27953FD != null) {
                    SkipView.this.f27953FD.mo30482la();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    /* renamed from: lX */
    private void m30484lX() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    /* renamed from: A */
    public final void mo30464A(AdInfo adInfo) {
        if (C10483a.m25877bc(adInfo)) {
            return;
        }
        m30486eG();
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    /* renamed from: B */
    public final void mo30463B(AdInfo adInfo) {
        if (this.f27961sB) {
            m30484lX();
        }
        if (C10483a.m25877bc(adInfo)) {
            return;
        }
        m30485eH();
    }

    /* renamed from: W */
    public final void m30495W(String str) {
        if (str == null) {
            return;
        }
        this.f27955GW.m30480W(str);
        m30493a(this.f27955GW);
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    /* renamed from: aa */
    public final int mo30461aa(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = C10751a.m24924a(getContext(), 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    /* renamed from: bf */
    public final void mo30460bf() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f27959Ha = layoutParams.width;
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    public void setOnViewListener(InterfaceC8510a interfaceC8510a) {
        this.f27953FD = interfaceC8510a;
    }

    public void setSkipBtnVisible(boolean z) {
        this.f27955GW.f27968Hf = z;
        m30493a(this.f27955GW);
    }

    public void setSkipText(String str) {
        this.f27955GW.f27965Hc = str;
        m30493a(this.f27955GW);
    }

    public void setTimerBtnVisible(boolean z) {
        this.f27955GW.f27969Hg = z;
        m30493a(this.f27955GW);
    }

    public void setTimerPrefixText(String str) {
        this.f27955GW.f27966Hd = str;
        m30493a(this.f27955GW);
    }

    public void setTimerSecond(int i) {
        this.f27955GW.m30477ad(i);
        m30493a(this.f27955GW);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C10887l.wrapContextIfNeed(context), attributeSet, i);
        this.f27955GW = new C8511b((byte) 0);
        this.f27959Ha = -1;
        this.f27960nD = false;
        this.f27961sB = true;
        this.f27954FO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.f27960nD) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.m30493a(skipView.f27955GW);
                SkipView skipView2 = SkipView.this;
                skipView2.m30494X(skipView2.f27955GW.f27967He - SkipView.this.f27955GW.f27964FK);
                if (!SkipView.this.f27955GW.m30466lZ()) {
                    SkipView.this.postDelayed(this, 1000L);
                    C8511b.m30472d(SkipView.this.f27955GW);
                } else if (SkipView.this.f27953FD != null) {
                    SkipView.this.f27953FD.mo30481lb();
                }
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m30493a(C8511b c8511b) {
        if (c8511b == null) {
            return;
        }
        if (this.f27957GY != null) {
            if (c8511b.f27965Hc != null) {
                this.f27957GY.setText(c8511b.f27965Hc);
            }
            this.f27957GY.setVisibility(this.f27955GW.f27968Hf ? 0 : 8);
        }
        String m30467lY = c8511b.m30467lY();
        TextView textView = this.f27958GZ;
        if (textView != null) {
            if (m30467lY != null) {
                textView.setText(m30467lY);
            }
            this.f27958GZ.setVisibility(this.f27955GW.f27969Hg ? 0 : 8);
        }
        if (this.f27956GX != null) {
            boolean m30465ma = this.f27955GW.m30465ma();
            this.f27956GX.setVisibility(m30465ma ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!m30465ma) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i = this.f27959Ha;
                if (i > 0) {
                    layoutParams.width = i;
                    invalidate();
                }
            }
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a
    /* renamed from: a */
    public final void mo30462a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.f27961sB = C10483a.m25802cx(adInfo);
        setTimerPrefixText(C10251d.m26522a(C8363a.f27625CN));
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!C10483a.m25877bc(adInfo)) {
            m30487eF();
        }
        setSkipText(C10483a.m25816cj(adInfo));
        setVisibility(8);
        m30496C(adInfo);
    }
}
