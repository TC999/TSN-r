package com.p521ss.android.download.api.download;

import org.json.JSONObject;

/* renamed from: com.ss.android.download.api.download.DownloadEventConfig */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    void setDownloadScene(int i);

    void setRefer(String str);
}
