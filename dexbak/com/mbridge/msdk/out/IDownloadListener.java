package com.mbridge.msdk.out;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IDownloadListener {
    void onEnd(int i, int i2, String str);

    void onProgressUpdate(int i);

    void onStart();

    void onStatus(int i);
}
