package com.baidu.mobads.sdk.api;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface INativeVideoListener {
    void onCompletion();

    void onError();

    void onPause();

    void onRenderingStart();

    void onResume();
}