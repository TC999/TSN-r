package com.ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements DownloadController {
    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAH() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAM() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableNewActivity() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableShowComplianceDialog() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDowloadChunkCount() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDownloadMode() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public Object getExtraClickOperation() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public Object getExtraObject() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getInterceptFlag() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getLinkMode() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAddToDownloadManage() {
        return false;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return false;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableBackDialog() {
        return false;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setDownloadMode(int i4) {
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableNewActivity(boolean z3) {
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableShowComplianceDialog(boolean z3) {
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setLinkMode(int i4) {
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean shouldUseNewWebView() {
        return false;
    }
}
