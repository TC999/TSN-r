package com.p521ss.android.download.api.download;

import org.json.JSONObject;

/* renamed from: com.ss.android.download.api.download.DownloadController */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface DownloadController {
    boolean enableAH();

    boolean enableAM();

    boolean enableNewActivity();

    boolean enableShowComplianceDialog();

    @Deprecated
    int getDowloadChunkCount();

    int getDownloadMode();

    Object getExtraClickOperation();

    JSONObject getExtraJson();

    Object getExtraObject();

    int getInterceptFlag();

    int getLinkMode();

    boolean isAddToDownloadManage();

    boolean isAutoDownloadOnCardShow();

    boolean isEnableBackDialog();

    @Deprecated
    boolean isEnableMultipleDownload();

    void setDownloadMode(int i);

    void setEnableNewActivity(boolean z);

    void setEnableShowComplianceDialog(boolean z);

    void setLinkMode(int i);

    boolean shouldUseNewWebView();
}
