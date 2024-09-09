package com.beizi.ad;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface AdLifeControl {
    void cancel();

    void onCreateLifeCycle();

    void onDestoryLifeCycle();

    void onPauseLifeCycle();

    void onRestartLifeCycle();

    void onResumeLifeCycle();

    void onStartLifeCycle();

    void onStopLifeCycle();

    void openAdInNativeBrowser(boolean z3);
}
