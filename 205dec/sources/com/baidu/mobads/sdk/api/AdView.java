package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.bb;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.cu;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class AdView extends RelativeLayout {
    private static final boolean AUTOPLAY = true;
    private static final float HEIGHT_FACTOR = 0.15f;
    protected static final String P_VERSION = "3.61";
    private AtomicBoolean hasCalledRequestMethod;
    private cu mAdProd;

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
        this.mAdProd.a();
    }

    public void destroy() {
        cu cuVar = this.mAdProd;
        if (cuVar != null) {
            cuVar.e();
        }
    }

    public void setAppSid(String str) {
        cu cuVar = this.mAdProd;
        if (cuVar != null) {
            cuVar.h(str);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        bv.a().a("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i4 = layoutParams.width;
        int i5 = layoutParams.height;
        DisplayMetrics f4 = bb.f(getContext());
        int i6 = f4.widthPixels;
        int i7 = f4.heightPixels;
        float f5 = f4.density;
        bv.a().a("AdView.setLayoutParams", Integer.valueOf(i6), Integer.valueOf(i7), Float.valueOf(f5));
        if (i4 <= 0) {
            i4 = Math.min(i6, i7);
        } else if (i4 > 0) {
            float f6 = 200.0f * f5;
            if (i4 < f6) {
                i4 = (int) f6;
            }
        }
        if (i5 <= 0) {
            i5 = (int) (Math.min(i6, i7) * 0.15f);
        } else if (i5 > 0) {
            float f7 = f5 * 30.0f;
            if (i5 < f7) {
                i5 = (int) f7;
            }
        }
        layoutParams.width = i4;
        layoutParams.height = i5;
        cu cuVar = this.mAdProd;
        if (cuVar != null) {
            cuVar.a(i4);
            this.mAdProd.c(i5);
        }
        bv.a().a("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(AdViewListener adViewListener) {
        cu cuVar = this.mAdProd;
        if (cuVar != null) {
            cuVar.a(adViewListener);
        }
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    AdView(Context context, boolean z3, AdSize adSize, String str) {
        this(context, null, z3, adSize, str);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z3, AdSize adSize, String str) {
        super(context, attributeSet);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
        ct ctVar = new ct(context);
        this.mAdProd = new cu(this, context, ctVar, str, z3);
        ctVar.a(new ct.a() { // from class: com.baidu.mobads.sdk.api.AdView.1
            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onAttachedToWindow() {
                AdView.this.callRequest();
                AdView.this.mAdProd.o();
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                AdView.this.mAdProd.p();
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public boolean onKeyDown(int i4, KeyEvent keyEvent) {
                return AdView.this.mAdProd.a(i4, keyEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onLayoutComplete(int i4, int i5) {
                AdView.this.callRequest();
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowFocusChanged(boolean z4) {
                AdView.this.mAdProd.a(z4);
            }

            @Override // com.baidu.mobads.sdk.internal.ct.a
            public void onWindowVisibilityChanged(int i4) {
                AdView.this.mAdProd.b(i4);
            }
        });
        addView(ctVar, new ViewGroup.LayoutParams(-1, -1));
    }
}
