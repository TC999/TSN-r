package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.C2610ay;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.baidu.mobads.sdk.internal.C2671cq;
import com.baidu.mobads.sdk.internal.C2673cr;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AdView extends RelativeLayout {
    private static final boolean AUTOPLAY = true;
    private static final float HEIGHT_FACTOR = 0.15f;
    protected static final String P_VERSION = "3.61";
    private AtomicBoolean hasCalledRequestMethod;
    private C2673cr mAdProd;

    public AdView(Context context) {
        super(context);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callRequest() {
        if (this.hasCalledRequestMethod.get()) {
            return;
        }
        this.hasCalledRequestMethod.set(true);
        this.mAdProd.mo50356a();
    }

    public void destroy() {
        C2673cr c2673cr = this.mAdProd;
        if (c2673cr != null) {
            c2673cr.m50810e();
        }
    }

    public void setAppSid(String str) {
        C2673cr c2673cr = this.mAdProd;
        if (c2673cr != null) {
            c2673cr.m50809h(str);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C2634bs.m50744a().m50737a("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        DisplayMetrics m50846f = C2610ay.m50846f(getContext());
        int i3 = m50846f.widthPixels;
        int i4 = m50846f.heightPixels;
        float f = m50846f.density;
        C2634bs.m50744a().m50737a("AdView.setLayoutParams", Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f));
        if (i <= 0) {
            i = Math.min(i3, i4);
        } else if (i > 0) {
            float f2 = 200.0f * f;
            if (i < f2) {
                i = (int) f2;
            }
        }
        if (i2 <= 0) {
            i2 = (int) (Math.min(i3, i4) * HEIGHT_FACTOR);
        } else if (i2 > 0) {
            float f3 = f * 30.0f;
            if (i2 < f3) {
                i2 = (int) f3;
            }
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        C2673cr c2673cr = this.mAdProd;
        if (c2673cr != null) {
            c2673cr.m50590a(i);
            this.mAdProd.m50587c(i2);
        }
        C2634bs.m50744a().m50737a("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(AdViewListener adViewListener) {
        C2673cr c2673cr = this.mAdProd;
        if (c2673cr != null) {
            c2673cr.m50589a(adViewListener);
        }
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    AdView(Context context, boolean z, AdSize adSize, String str) {
        this(context, null, z, adSize, str);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z, AdSize adSize, String str) {
        super(context, attributeSet);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
        C2671cq c2671cq = new C2671cq(context);
        this.mAdProd = new C2673cr(this, context, c2671cq, str, z);
        c2671cq.m50591a(new C2671cq.InterfaceC2672a() { // from class: com.baidu.mobads.sdk.api.AdView.1
            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onAttachedToWindow() {
                AdView.this.callRequest();
                AdView.this.mAdProd.m50804o();
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                AdView.this.mAdProd.m50803p();
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                return AdView.this.mAdProd.m50828a(i, keyEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onLayoutComplete(int i, int i2) {
                AdView.this.callRequest();
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onWindowFocusChanged(boolean z2) {
                AdView.this.mAdProd.m50817a(z2);
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onWindowVisibilityChanged(int i) {
                AdView.this.mAdProd.m50816b(i);
            }
        });
        addView(c2671cq, new ViewGroup.LayoutParams(-1, -1));
    }
}
