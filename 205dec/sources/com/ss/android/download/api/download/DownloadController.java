package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    void setDownloadMode(int i4);

    void setEnableNewActivity(boolean z3);

    void setEnableShowComplianceDialog(boolean z3);

    void setLinkMode(int i4);

    boolean shouldUseNewWebView();
}
