package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.n.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.a {
    private a FD;
    private Runnable FO;
    private final b GW;
    private View GX;
    private TextView GY;
    private TextView GZ;
    private int Ha;
    private boolean nD;
    private boolean sB;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void Y(int i4);

        void la();

        void lb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b {
        private int FK;
        private String Hc;
        private String Hd;
        private int He;
        private boolean Hf;
        private boolean Hg;

        private b() {
            this.Hc = "\u8df3\u8fc7";
            this.Hd = "";
            this.He = 5;
            this.FK = 5;
            this.Hf = true;
            this.Hg = true;
        }

        static /* synthetic */ int d(b bVar) {
            int i4 = bVar.FK;
            bVar.FK = i4 - 1;
            return i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean ma() {
            return this.Hf && this.Hg;
        }

        public final void W(String str) {
            this.FK = -1;
            this.Hd = str;
        }

        public final void ad(int i4) {
            this.He = i4;
            this.FK = i4;
        }

        public final String lY() {
            int i4 = this.FK;
            if (i4 < 0) {
                return this.Hd;
            }
            if (i4 == 0) {
                return this.Hd + 1;
            }
            return this.Hd + this.FK;
        }

        public final boolean lZ() {
            return this.FK <= 0;
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }

    public SkipView(Context context) {
        this(context, null);
    }

    private void C(AdInfo adInfo) {
        setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cy(adInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i4) {
        a aVar = this.FD;
        if (aVar != null) {
            aVar.Y(i4);
        }
    }

    private void eF() {
        a(this.GW);
        post(this.FO);
    }

    private void eG() {
        this.nD = true;
    }

    private void eH() {
        this.nD = false;
    }

    private void init() {
        setOrientation(0);
        l.inflate(getContext(), R.layout.ksad_skip_view, this);
        this.GY = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.GZ = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.GX = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SkipView.this.FD != null) {
                    SkipView.this.FD.la();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    private void lX() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void A(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            return;
        }
        eG();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void B(AdInfo adInfo) {
        if (this.sB) {
            lX();
        }
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            return;
        }
        eH();
    }

    public final void W(String str) {
        if (str == null) {
            return;
        }
        this.GW.W(str);
        a(this.GW);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int aa(int i4) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = com.kwad.sdk.d.a.a.a(getContext(), 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bf() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.Ha = layoutParams.width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(a aVar) {
        this.FD = aVar;
    }

    public void setSkipBtnVisible(boolean z3) {
        this.GW.Hf = z3;
        a(this.GW);
    }

    public void setSkipText(String str) {
        this.GW.Hc = str;
        a(this.GW);
    }

    public void setTimerBtnVisible(boolean z3) {
        this.GW.Hg = z3;
        a(this.GW);
    }

    public void setTimerPrefixText(String str) {
        this.GW.Hd = str;
        a(this.GW);
    }

    public void setTimerSecond(int i4) {
        this.GW.ad(i4);
        a(this.GW);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(l.wrapContextIfNeed(context), attributeSet, i4);
        this.GW = new b((byte) 0);
        this.Ha = -1;
        this.nD = false;
        this.sB = true;
        this.FO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.nD) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.GW);
                SkipView skipView2 = SkipView.this;
                skipView2.X(skipView2.GW.He - SkipView.this.GW.FK);
                if (!SkipView.this.GW.lZ()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.d(SkipView.this.GW);
                } else if (SkipView.this.FD != null) {
                    SkipView.this.FD.lb();
                }
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.GY != null) {
            if (bVar.Hc != null) {
                this.GY.setText(bVar.Hc);
            }
            this.GY.setVisibility(this.GW.Hf ? 0 : 8);
        }
        String lY = bVar.lY();
        TextView textView = this.GZ;
        if (textView != null) {
            if (lY != null) {
                textView.setText(lY);
            }
            this.GZ.setVisibility(this.GW.Hg ? 0 : 8);
        }
        if (this.GX != null) {
            boolean ma = this.GW.ma();
            this.GX.setVisibility(ma ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!ma) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i4 = this.Ha;
                if (i4 > 0) {
                    layoutParams.width = i4;
                    invalidate();
                }
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.sB = com.kwad.sdk.core.response.b.a.cx(adInfo);
        setTimerPrefixText(com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CN));
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            eF();
        }
        setSkipText(com.kwad.sdk.core.response.b.a.cj(adInfo));
        setVisibility(8);
        C(adInfo);
    }
}
