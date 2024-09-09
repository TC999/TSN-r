package xyz.adscope.ad.control.track.inter;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface ITrackEventStatus {
    void adClose();

    void downloadComplete();

    void downloadContinue();

    void installComplete();

    void installStart();

    void installedApp();

    void invokeFail();

    void invokeSuccess();

    void notInstall();

    void openAppSuccess();

    void pauseDownload();

    void startDownload();

    void startInvoke();
}
