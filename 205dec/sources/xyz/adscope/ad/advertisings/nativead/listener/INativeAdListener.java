package xyz.adscope.ad.advertisings.nativead.listener;

import java.util.List;
import xyz.adscope.ad.advertisings.base.IBaseAdListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface INativeAdListener extends IBaseAdListener {
    void onAdFailedToLoad(int i4, String str);

    void onAdLoad(List<INativeAdView> list);
}
