package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.mbbanner.a.a;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MBBannerView extends RelativeLayout {
    private String bidToken;
    private a controller;
    private boolean hadAttached;
    private boolean isVisible;
    private BannerAdListener mBannerAdListener;
    private MBridgeIds mBridgeIds;

    public MBBannerView(Context context) {
        this(context, null);
    }

    private void delayedNotify() {
        postDelayed(new Runnable() { // from class: com.mbridge.msdk.out.MBBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (MBBannerView.this.controller == null || b.f39072c) {
                    return;
                }
                MBBannerView.this.controller.c(true);
            }
        }, 200L);
    }

    private void updateAttachedState(boolean z3) {
        this.hadAttached = z3;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(z3);
        }
    }

    public String getRequestId() {
        a aVar = this.controller;
        return aVar != null ? aVar.a() : "";
    }

    public void init(BannerSize bannerSize, String str, String str2) {
        this.mBridgeIds = new MBridgeIds(str, str2);
        String f4 = ac.f(str2);
        if (!TextUtils.isEmpty(f4)) {
            ac.a(str2, f4);
        }
        a aVar = new a(this, bannerSize, str, str2);
        this.controller = aVar;
        aVar.c(this.isVisible);
        this.controller.b(this.hadAttached);
    }

    public void load() {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(this.hadAttached);
            this.controller.a("");
            return;
        }
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.mBridgeIds, "banner controler init error\uff0cplease check it");
        }
    }

    public void loadFromBid(String str) {
        this.bidToken = str;
        if (this.controller != null) {
            if (!TextUtils.isEmpty(str)) {
                this.controller.b(this.hadAttached);
                this.controller.a(0);
                this.controller.a(str);
                return;
            }
            BannerAdListener bannerAdListener = this.mBannerAdListener;
            if (bannerAdListener != null) {
                bannerAdListener.onLoadFailed(this.mBridgeIds, "banner token is null or empty\uff0cplease check it");
                return;
            }
            return;
        }
        BannerAdListener bannerAdListener2 = this.mBannerAdListener;
        if (bannerAdListener2 != null) {
            bannerAdListener2.onLoadFailed(this.mBridgeIds, "banner controler init error\uff0cplease check it");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateAttachedState(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        updateAttachedState(false);
    }

    public void onPause() {
        if (this.controller == null || !TextUtils.isEmpty(this.bidToken)) {
            return;
        }
        this.controller.d();
    }

    public void onResume() {
        if (this.controller == null || !TextUtils.isEmpty(this.bidToken) || b.f39072c) {
            return;
        }
        this.controller.e();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i4, i5, i6, i7);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        this.isVisible = i4 == 0;
        a aVar = this.controller;
        if (aVar != null) {
            if (i4 == 0) {
                delayedNotify();
            } else {
                aVar.c(false);
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        this.isVisible = i4 == 0;
        if (this.controller != null) {
            if (i4 == 0) {
                delayedNotify();
            } else if (b.f39072c) {
            } else {
                this.controller.c(false);
            }
        }
    }

    public void release() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener = null;
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((BannerAdListener) null);
            this.controller.b();
        }
        removeAllViews();
    }

    public void setAllowShowCloseBtn(boolean z3) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(z3);
        }
    }

    public void setBannerAdListener(BannerAdListener bannerAdListener) {
        this.mBannerAdListener = bannerAdListener;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerAdListener);
        }
    }

    public void setRefreshTime(int i4) {
        a aVar = this.controller;
        if (aVar == null || i4 < 0) {
            return;
        }
        aVar.a(i4);
    }

    public void updateBannerSize(BannerSize bannerSize) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerSize);
        }
    }

    public MBBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBBannerView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.hadAttached = false;
        this.isVisible = false;
        com.mbridge.msdk.foundation.controller.a.f().a(context);
    }
}
