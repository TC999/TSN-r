package com.bytedance.sdk.openadsdk.mediation.bridge;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface IMediationCustomizeVideo {
    String getVideoUrl();

    void reportVideoAutoStart();

    void reportVideoBreak(long j);

    void reportVideoContinue(long j);

    void reportVideoError(long j, int i, int i2);

    void reportVideoFinish();

    void reportVideoPause(long j);

    void reportVideoStart();

    void reportVideoStartError(int i, int i2);
}
