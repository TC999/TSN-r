package xyz.adscope.amps.ad.nativead.adapter;

import android.view.View;
import xyz.adscope.amps.base.AMPSBaseListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSNativeAdExpressListener implements AMPSBaseListener {
    public abstract void onAdClicked();

    public abstract void onAdClosed(View view);

    public abstract void onAdShow();

    public abstract void onRenderFail(View view, String str, int i4);

    public abstract void onRenderSuccess(View view, float f4, float f5);
}
