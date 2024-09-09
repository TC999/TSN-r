package com.kwad.sdk.export.proxy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface AdHttpResponseListener {
    boolean onReadProgress(long j4, long j5);

    void onResponseEnd();

    void onResponseStart();
}
