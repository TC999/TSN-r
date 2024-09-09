package com.mbridge.msdk.out;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface AdapterListener {
    void onAdClicked(Campaign campaign);

    void onAdLoaded(List<Campaign> list);

    void onError(String str);

    void onFrameAdLoaded(List<Frame> list);
}
