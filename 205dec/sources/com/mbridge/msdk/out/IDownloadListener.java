package com.mbridge.msdk.out;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IDownloadListener {
    void onEnd(int i4, int i5, String str);

    void onProgressUpdate(int i4);

    void onStart();

    void onStatus(int i4);
}
