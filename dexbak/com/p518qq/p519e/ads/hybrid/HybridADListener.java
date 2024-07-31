package com.p518qq.p519e.ads.hybrid;

import com.p518qq.p519e.comm.util.AdError;

/* renamed from: com.qq.e.ads.hybrid.HybridADListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface HybridADListener {
    void onClose();

    void onError(AdError adError);

    void onLoadFinished();

    void onPageShow();
}
