package com.bytedance.sdk.component.adexpress.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface w {
    void adAnalysisData(String str);

    String adInfo();

    String appInfo();

    void changeVideoState(String str);

    void clickEvent(String str);

    void dynamicTrack(String str);

    String getCurrentVideoState();

    String getTemplateInfo();

    void initRenderFinish();

    void muteVideo(String str);

    void renderDidFinish(String str);

    void requestPauseVideo(String str);

    void skipVideo();
}
