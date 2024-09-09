package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface DownloadEventConfig {
    String getClickButtonTag();

    String getClickContinueLabel();

    String getClickInstallLabel();

    String getClickItemTag();

    String getClickLabel();

    String getClickPauseLabel();

    String getClickStartLabel();

    int getDownloadScene();

    Object getExtraEventObject();

    JSONObject getExtraJson();

    JSONObject getParamsJson();

    String getRefer();

    String getStorageDenyLabel();

    boolean isEnableClickEvent();

    boolean isEnableV3Event();

    void setDownloadScene(int i4);

    void setRefer(String str);
}
