package com.qq.e.ads.dfa;

import com.qq.e.comm.util.AdError;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface IGDTApkListener {
    void onApkLoad(GDTApk gDTApk);

    void onError(AdError adError);
}