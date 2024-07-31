package com.beizi.p051ad;

/* renamed from: com.beizi.ad.AdLifeControl */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface AdLifeControl {
    void cancel();

    void onCreateLifeCycle();

    void onDestoryLifeCycle();

    void onPauseLifeCycle();

    void onRestartLifeCycle();

    void onResumeLifeCycle();

    void onStartLifeCycle();

    void onStopLifeCycle();

    void openAdInNativeBrowser(boolean z);
}
