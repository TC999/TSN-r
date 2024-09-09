package com.qq.e.ads.nativ;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class NativeADEventListenerWithClickInfo implements NativeADEventListener {
    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public final void onADClicked() {
    }

    public abstract void onADClicked(View view);
}
