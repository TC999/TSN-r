package com.p518qq.p519e.ads.nativ;

import com.p518qq.p519e.comm.util.AdError;

/* renamed from: com.qq.e.ads.nativ.NativeADEventListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface NativeADEventListener {
    void onADClicked();

    void onADError(AdError adError);

    void onADExposed();

    void onADStatusChanged();
}
