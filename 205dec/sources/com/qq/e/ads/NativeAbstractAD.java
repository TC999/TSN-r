package com.qq.e.ads;

import com.qq.e.comm.util.AdError;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class NativeAbstractAD<T> extends AbstractAD<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(T t3) {
    }
}
