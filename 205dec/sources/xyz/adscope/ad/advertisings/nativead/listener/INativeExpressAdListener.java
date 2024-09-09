package xyz.adscope.ad.advertisings.nativead.listener;

import android.view.View;
import xyz.adscope.ad.advertisings.base.IBaseAdListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface INativeExpressAdListener extends IBaseAdListener {
    void onAdClicked(View view, int i4);

    void onAdClose(View view);

    void onAdExposure(View view, int i4);

    void onAdShow(View view, int i4);

    void onRenderFail(View view, String str, int i4);

    void onRenderSuccess(View view, float f4, float f5);
}
