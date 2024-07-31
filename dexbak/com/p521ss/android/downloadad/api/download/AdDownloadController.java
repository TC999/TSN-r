package com.p521ss.android.downloadad.api.download;

import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.downloadlib.addownload.C12128r;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadad.api.download.AdDownloadController */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AdDownloadController implements DownloadController {
    protected int mDownloadMode;
    protected Object mExtraClickOperation;
    protected JSONObject mExtraJson;
    protected Object mExtraObject;
    protected int mInterceptFlag;
    protected boolean mIsAddToDownloadManage;
    protected boolean mIsAutoDownloadOnCardShow;
    protected boolean mIsEnableBackDialog;
    protected int mLinkMode;
    protected boolean mShouldUseNewWebView;
    protected boolean mEnableShowComplianceDialog = true;
    protected boolean mEnableNewActivity = true;
    protected boolean mEnableAH = true;
    protected boolean mEnableAM = true;
    protected boolean mEnableOppoAutoDownload = true;

    /* renamed from: com.ss.android.downloadad.api.download.AdDownloadController$Builder */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Builder {
        AdDownloadController controller = new AdDownloadController();

        public AdDownloadController build() {
            return this.controller;
        }

        @Deprecated
        public Builder setDowloadChunkCount(int i) {
            return this;
        }

        public Builder setDownloadMode(int i) {
            this.controller.mDownloadMode = i;
            return this;
        }

        public Builder setEnableAH(boolean z) {
            this.controller.mEnableAH = z;
            return this;
        }

        public Builder setEnableAM(boolean z) {
            this.controller.mEnableAM = z;
            return this;
        }

        public Builder setEnableNewActivity(boolean z) {
            this.controller.mEnableNewActivity = z;
            return this;
        }

        public Builder setEnableOppoAutoDownload(boolean z) {
            this.controller.mEnableOppoAutoDownload = z;
            return this;
        }

        public Builder setEnableShowComplianceDialog(boolean z) {
            this.controller.mEnableShowComplianceDialog = z;
            return this;
        }

        public Builder setExtraJson(JSONObject jSONObject) {
            this.controller.mExtraJson = jSONObject;
            return this;
        }

        public Builder setExtraObject(Object obj) {
            this.controller.mExtraObject = obj;
            return this;
        }

        @Deprecated
        public Builder setExtraOperation(Object obj) {
            this.controller.mExtraClickOperation = obj;
            return this;
        }

        public Builder setInterceptFlag(int i) {
            this.controller.mInterceptFlag = i;
            return this;
        }

        public Builder setIsAddToDownloadManage(boolean z) {
            this.controller.mIsAddToDownloadManage = z;
            return this;
        }

        public Builder setIsAutoDownloadOnCardShow(boolean z) {
            this.controller.mIsAutoDownloadOnCardShow = z;
            return this;
        }

        public Builder setIsEnableBackDialog(boolean z) {
            this.controller.mIsEnableBackDialog = z;
            return this;
        }

        @Deprecated
        public Builder setIsEnableMultipleDownload(boolean z) {
            return this;
        }

        public Builder setLinkMode(int i) {
            this.controller.mLinkMode = i;
            return this;
        }

        public Builder setShouldUseNewWebView(boolean z) {
            this.controller.mShouldUseNewWebView = z;
            return this;
        }
    }

    public static AdDownloadController fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            builder.setLinkMode(jSONObject.optInt("link_mode"));
            builder.setDownloadMode(jSONObject.optInt("download_mode"));
            builder.setIsEnableBackDialog(jSONObject.optInt("enable_back_dialog") == 1);
            builder.setIsAddToDownloadManage(jSONObject.optInt("add_to_manage") == 1);
            builder.setShouldUseNewWebView(jSONObject.optInt("use_new_webview") == 1);
            builder.setInterceptFlag(jSONObject.optInt("intercept_flag"));
            builder.setEnableShowComplianceDialog(jSONObject.optInt("enable_show_compliance_dialog", 1) == 1);
            builder.setIsAutoDownloadOnCardShow(jSONObject.optInt("is_auto_download_on_card_show") == 1);
            builder.setEnableNewActivity(jSONObject.optInt("enable_new_activity", 1) == 1);
            builder.setEnableAH(jSONObject.optInt("enable_ah", 1) == 1);
            builder.setEnableAM(jSONObject.optInt("enable_am", 1) == 1);
            builder.setExtraJson(jSONObject.optJSONObject("extra"));
            builder.setEnableOppoAutoDownload(jSONObject.optInt("enable_oppo_auto_download", 1) == 1);
        } catch (Exception e) {
            C12128r.m18940u().mo18637ok(e, "AdDownloadController fromJson");
        }
        return builder.build();
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean enableAH() {
        return this.mEnableAH;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean enableAM() {
        return this.mEnableAM;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean enableNewActivity() {
        return this.mEnableNewActivity;
    }

    public boolean enableOppoAutoDownload() {
        return this.mEnableOppoAutoDownload;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean enableShowComplianceDialog() {
        return this.mEnableShowComplianceDialog;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public int getDowloadChunkCount() {
        return 1;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public int getDownloadMode() {
        return this.mDownloadMode;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public Object getExtraClickOperation() {
        return this.mExtraClickOperation;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public JSONObject getExtraJson() {
        return this.mExtraJson;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public Object getExtraObject() {
        return this.mExtraObject;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public int getInterceptFlag() {
        return this.mInterceptFlag;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public int getLinkMode() {
        return this.mLinkMode;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean isAddToDownloadManage() {
        return this.mIsAddToDownloadManage;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return this.mIsAutoDownloadOnCardShow;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean isEnableBackDialog() {
        return this.mIsEnableBackDialog;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public void setDownloadMode(int i) {
        this.mDownloadMode = i;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public void setEnableNewActivity(boolean z) {
        this.mEnableNewActivity = z;
    }

    public void setEnableOppoAutoDownload(boolean z) {
        this.mEnableOppoAutoDownload = z;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public void setEnableShowComplianceDialog(boolean z) {
        this.mEnableShowComplianceDialog = z;
    }

    public void setExtraJson(JSONObject jSONObject) {
        this.mExtraJson = jSONObject;
    }

    public void setExtraObject(Object obj) {
        this.mExtraObject = obj;
    }

    public void setIsAutoDownloadOnCardShow(boolean z) {
        this.mIsAutoDownloadOnCardShow = z;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public void setLinkMode(int i) {
        this.mLinkMode = i;
    }

    @Override // com.p521ss.android.download.api.download.DownloadController
    public boolean shouldUseNewWebView() {
        return this.mShouldUseNewWebView;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("link_mode", Integer.valueOf(this.mLinkMode));
            jSONObject.putOpt("download_mode", Integer.valueOf(this.mDownloadMode));
            int i = 1;
            jSONObject.putOpt("enable_back_dialog", Integer.valueOf(this.mIsEnableBackDialog ? 1 : 0));
            jSONObject.putOpt("add_to_manage", Integer.valueOf(this.mIsAddToDownloadManage ? 1 : 0));
            jSONObject.putOpt("use_new_webview", Integer.valueOf(this.mShouldUseNewWebView ? 1 : 0));
            jSONObject.putOpt("intercept_flag", Integer.valueOf(this.mInterceptFlag));
            jSONObject.putOpt("enable_show_compliance_dialog", Integer.valueOf(this.mEnableShowComplianceDialog ? 1 : 0));
            jSONObject.putOpt("is_auto_download_on_card_show", Integer.valueOf(this.mIsAutoDownloadOnCardShow ? 1 : 0));
            jSONObject.putOpt("extra", this.mExtraJson);
            jSONObject.putOpt("enable_new_activity", Integer.valueOf(this.mEnableNewActivity ? 1 : 0));
            jSONObject.putOpt("enable_ah", Integer.valueOf(this.mEnableAH ? 1 : 0));
            jSONObject.putOpt("enable_am", Integer.valueOf(this.mEnableAM ? 1 : 0));
            if (!this.mEnableOppoAutoDownload) {
                i = 0;
            }
            jSONObject.putOpt("enable_oppo_auto_download", Integer.valueOf(i));
        } catch (Exception e) {
            C12128r.m18940u().mo18637ok(e, "AdDownloadController toJson");
        }
        return jSONObject;
    }
}
