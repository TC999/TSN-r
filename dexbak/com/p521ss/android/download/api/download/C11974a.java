package com.p521ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* renamed from: com.ss.android.download.api.download.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11974a implements DownloadController {
    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean enableAH() {
        return true;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean enableAM() {
        return true;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean enableNewActivity() {
        return true;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean enableShowComplianceDialog() {
        return true;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public int getDowloadChunkCount() {
        return 0;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public int getDownloadMode() {
        return 0;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public Object getExtraClickOperation() {
        return null;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public Object getExtraObject() {
        return null;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public int getInterceptFlag() {
        return 0;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public int getLinkMode() {
        return 0;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean isAddToDownloadManage() {
        return false;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return false;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean isEnableBackDialog() {
        return false;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public void setDownloadMode(int i) {
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public void setEnableNewActivity(boolean z) {
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public void setEnableShowComplianceDialog(boolean z) {
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public void setLinkMode(int i) {
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean shouldUseNewWebView() {
        return false;
    }
}
