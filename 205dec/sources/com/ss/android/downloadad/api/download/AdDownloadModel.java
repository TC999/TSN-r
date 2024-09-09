package com.ss.android.downloadad.api.download;

import android.text.TextUtils;
import com.ss.android.download.api.bl.a;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.s;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.h.ok;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class AdDownloadModel implements DownloadModel {
    protected String mAppIcon;
    protected String mAppName;
    protected boolean mAutoInstallWithoutNotification;
    protected List<String> mBackupUrls;
    protected List<String> mClickTrackUrl;
    protected DeepLink mDeepLink;
    protected boolean mDistinctDir;
    protected JSONObject mDownloadSettings;
    protected String mDownloadUrl;
    protected long mExpectFileLength;
    protected JSONObject mExtra;
    protected long mExtraValue;
    protected String mFileName;
    protected String mFilePath;
    protected IDownloadFileUriProvider mFileUriProvider;
    protected Map<String, String> mHeaders;
    protected long mId;
    protected boolean mIndependentProcess;
    @Deprecated
    protected boolean mIsInExternalPublicDir;
    protected String mLogExtra;
    protected String mMd5;
    protected String mMimeType;
    protected int mModelType;
    protected String mNotificationJumpUrl;
    protected String mPackageName;
    protected s mQuickAppModel;
    protected String mSdkMonitorScene;
    protected String mStartToast;
    protected String mTaskKey;
    protected int mVersionCode;
    protected String mVersionName;
    protected boolean mIsAd = true;
    protected boolean mIsShowToast = true;
    protected boolean mIsShowNotification = true;
    protected boolean mAutoInstall = true;
    protected boolean mNeedWifi = false;
    protected int mExecutorGroup = 2;
    protected boolean mEnablePause = true;
    protected int mFunnelType = 1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Builder {
        AdDownloadModel model = new AdDownloadModel();

        public AdDownloadModel build() {
            return this.model;
        }

        @Deprecated
        public Builder setAdId(long j4) {
            return setId(j4);
        }

        public Builder setAppIcon(String str) {
            this.model.mAppIcon = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.model.mAppName = str;
            return this;
        }

        public Builder setAutoInstall(boolean z3) {
            this.model.mAutoInstall = z3;
            return this;
        }

        public Builder setAutoInstallWithoutNotification(boolean z3) {
            this.model.mAutoInstallWithoutNotification = z3;
            return this;
        }

        public Builder setBackupUrls(List<String> list) {
            this.model.mBackupUrls = list;
            return this;
        }

        public Builder setClickTrackUrl(List<String> list) {
            this.model.mClickTrackUrl = list;
            return this;
        }

        public Builder setDeepLink(DeepLink deepLink) {
            this.model.mDeepLink = deepLink;
            return this;
        }

        public Builder setDistinctDir(boolean z3) {
            this.model.mDistinctDir = z3;
            return this;
        }

        public Builder setDownloadSettings(JSONObject jSONObject) {
            this.model.mDownloadSettings = jSONObject;
            return this;
        }

        public Builder setDownloadUrl(String str) {
            this.model.mDownloadUrl = str;
            return this;
        }

        public Builder setEnablePause(boolean z3) {
            this.model.mEnablePause = z3;
            return this;
        }

        public Builder setExecutorGroup(int i4) {
            this.model.mExecutorGroup = i4;
            return this;
        }

        public Builder setExpectFileLength(long j4) {
            this.model.mExpectFileLength = j4;
            return this;
        }

        public Builder setExtra(JSONObject jSONObject) {
            this.model.mExtra = jSONObject;
            return this;
        }

        public Builder setExtraValue(long j4) {
            this.model.mExtraValue = j4;
            return this;
        }

        public Builder setFileName(String str) {
            this.model.mFileName = str;
            return this;
        }

        public Builder setFilePath(String str) {
            this.model.mFilePath = str;
            return this;
        }

        public Builder setFileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
            this.model.mFileUriProvider = iDownloadFileUriProvider;
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.model.mHeaders = map;
            return this;
        }

        public Builder setId(long j4) {
            this.model.mId = j4;
            return this;
        }

        public Builder setIsAd(boolean z3) {
            this.model.mIsAd = z3;
            return this;
        }

        @Deprecated
        public Builder setIsInExternalPublicDir(boolean z3) {
            this.model.mIsInExternalPublicDir = z3;
            return this;
        }

        public Builder setIsShowNotification(boolean z3) {
            this.model.mIsShowNotification = z3;
            return this;
        }

        public Builder setIsShowToast(boolean z3) {
            this.model.mIsShowToast = z3;
            return this;
        }

        public Builder setLogExtra(String str) {
            this.model.mLogExtra = str;
            return this;
        }

        public Builder setMd5(String str) {
            this.model.mMd5 = str;
            return this;
        }

        public Builder setMimeType(String str) {
            this.model.mMimeType = str;
            return this;
        }

        public Builder setModelType(int i4) {
            this.model.mModelType = i4;
            return this;
        }

        public Builder setNeedIndependentProcess(boolean z3) {
            this.model.mIndependentProcess = z3;
            return this;
        }

        public Builder setNeedWifi(boolean z3) {
            this.model.mNeedWifi = z3;
            return this;
        }

        public Builder setNotificationJumpUrl(String str) {
            this.model.mNotificationJumpUrl = str;
            return this;
        }

        public Builder setPackageName(String str) {
            this.model.mPackageName = str;
            return this;
        }

        public Builder setQuickAppModel(s sVar) {
            this.model.mQuickAppModel = sVar;
            return this;
        }

        public Builder setSdkMonitorScene(String str) {
            this.model.mSdkMonitorScene = str;
            return this;
        }

        public Builder setStartToast(String str) {
            this.model.mStartToast = str;
            return this;
        }

        public Builder setTaskKey(String str) {
            this.model.mTaskKey = str;
            return this;
        }

        public Builder setVersionCode(int i4) {
            this.model.mVersionCode = i4;
            return this;
        }

        public Builder setVersionName(String str) {
            this.model.mVersionName = str;
            return this;
        }
    }

    protected AdDownloadModel() {
    }

    private static void appendBackupUrlsFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray optJSONArray = jSONObject.optJSONArray("backup_urls");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            arrayList.add(optJSONArray.optString(i4));
        }
        builder.setBackupUrls(arrayList);
    }

    private static void appendDeepLinkFromJson(JSONObject jSONObject, Builder builder) {
        builder.setDeepLink(new DeepLink(jSONObject.optString("open_url"), jSONObject.optString("web_url"), null));
    }

    private static void appendHeaderMapFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray optJSONArray = jSONObject.optJSONArray("header_keys");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("header_values");
        if (optJSONArray == null || optJSONArray2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            hashMap.put(optJSONArray.optString(i4), optJSONArray2.optString(i4));
        }
        builder.setHeaders(hashMap);
    }

    private static void appendQuickAppUrlFromJson(JSONObject jSONObject, Builder builder) {
        String optString = jSONObject.optString("quick_app_url");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        builder.setQuickAppModel(new s.ok().ok(optString).ok());
    }

    private static void appendTrackUrlFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray optJSONArray = jSONObject.optJSONArray("click_track_urls");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                arrayList.add(optJSONArray.optString(i4));
            }
            builder.setClickTrackUrl(arrayList);
        }
    }

    public static AdDownloadModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            boolean z3 = true;
            Builder distinctDir = builder.setAdId(a.ok(jSONObject, "id")).setIsAd(jSONObject.optInt("is_ad", 1) == 1).setModelType(jSONObject.optInt("model_type")).setMimeType(jSONObject.optString("mime_type")).setExtraValue(a.ok(jSONObject, "ext_value")).setLogExtra(jSONObject.optString("log_extra")).setPackageName(jSONObject.optString("package_name")).setDownloadUrl(jSONObject.optString(com.mbridge.msdk.foundation.download.database.DownloadModel.DOWNLOAD_URL)).setAppName(jSONObject.optString("app_name")).setAppIcon(jSONObject.optString("app_icon")).setIsShowToast(jSONObject.optInt("is_show_toast", 1) == 1).setIsShowNotification(jSONObject.optInt("show_notification", 1) == 1).setNeedWifi(jSONObject.optInt("need_wifi") == 1).setMd5(jSONObject.optString("md5")).setExpectFileLength(jSONObject.optLong("expect_file_length")).setNeedIndependentProcess(jSONObject.optInt("independent_process") == 1).setVersionCode(jSONObject.optInt("version_code")).setVersionName(jSONObject.optString("version_name")).setFilePath(jSONObject.optString("file_path")).setFileName(jSONObject.optString(com.mbridge.msdk.foundation.download.database.DownloadModel.FILE_NAME)).setNotificationJumpUrl(jSONObject.optString("notification_jump_url")).setAutoInstallWithoutNotification(jSONObject.optInt("auto_install_without_notify") == 1).setExecutorGroup(jSONObject.optInt("executor_group")).setDownloadSettings(jSONObject.optJSONObject("download_settings")).setExtra(jSONObject.optJSONObject("extra")).setStartToast(jSONObject.optString("start_toast")).setSdkMonitorScene(jSONObject.optString("sdk_monitor_scene")).setAutoInstall(jSONObject.optInt("auto_install", 1) == 1).setDistinctDir(jSONObject.optInt("distinct_dir") == 1);
            if (jSONObject.optInt("enable_pause", 1) != 1) {
                z3 = false;
            }
            distinctDir.setEnablePause(z3).setTaskKey(jSONObject.optString("task_key"));
            appendDeepLinkFromJson(jSONObject, builder);
            appendQuickAppUrlFromJson(jSONObject, builder);
            appendTrackUrlFromJson(jSONObject, builder);
            appendHeaderMapFromJson(jSONObject, builder);
            appendBackupUrlsFromJson(jSONObject, builder);
        } catch (Exception e4) {
            r.u().ok(e4, "AdDownloadModel fromJson");
        }
        return builder.build();
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean autoInstallWithoutNotification() {
        return this.mAutoInstallWithoutNotification;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean distinctDir() {
        return this.mDistinctDir;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean enablePause() {
        return this.mEnablePause;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideNotification() {
        this.mIsShowNotification = false;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideToast() {
        this.mIsShowToast = false;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceWifi() {
        this.mNeedWifi = true;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getAppIcon() {
        return this.mAppIcon;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public List<String> getBackupUrls() {
        return this.mBackupUrls;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public List<String> getClickTrackUrl() {
        return this.mClickTrackUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public DeepLink getDeepLink() {
        return this.mDeepLink;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public IDownloadFileUriProvider getDownloadFileUriProvider() {
        return this.mFileUriProvider;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public JSONObject getDownloadSettings() {
        return this.mDownloadSettings;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getExecutorGroup() {
        return this.mExecutorGroup;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExpectFileLength() {
        return this.mExpectFileLength;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public JSONObject getExtra() {
        return this.mExtra;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExtraValue() {
        return this.mExtraValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getFileName() {
        return this.mFileName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getFilePath() {
        return this.mFilePath;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getFunnelType() {
        return this.mFunnelType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getId() {
        return this.mId;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getLogExtra() {
        return this.mLogExtra;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getMd5() {
        return this.mMd5;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getMimeType() {
        return this.mMimeType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getModelType() {
        return this.mModelType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getName() {
        return this.mAppName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getNotificationJumpUrl() {
        return this.mNotificationJumpUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public s getQuickAppModel() {
        return this.mQuickAppModel;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getSdkMonitorScene() {
        return this.mSdkMonitorScene;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getStartToast() {
        return this.mStartToast;
    }

    public String getTaskKey() {
        return this.mTaskKey;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getVersionName() {
        return this.mVersionName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAd() {
        return this.mIsAd;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAutoInstall() {
        return this.mAutoInstall;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isInExternalPublicDir() {
        return this.mIsInExternalPublicDir;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isNeedWifi() {
        return this.mNeedWifi;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowNotification() {
        return this.mIsShowNotification;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowToast() {
        return this.mIsShowToast;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isVisibleInDownloadsUi() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean needIndependentProcess() {
        return this.mIndependentProcess;
    }

    @Deprecated
    public AdDownloadModel setAdId(long j4) {
        return setId(j4);
    }

    public AdDownloadModel setAppIcon(String str) {
        this.mAppIcon = str;
        return this;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public AdDownloadModel setAutoInstallWithoutNotification(boolean z3) {
        this.mAutoInstallWithoutNotification = z3;
        return this;
    }

    public AdDownloadModel setBackupUrls(List<String> list) {
        this.mBackupUrls = list;
        return this;
    }

    public AdDownloadModel setClickTrackUrl(List<String> list) {
        this.mClickTrackUrl = list;
        return this;
    }

    public AdDownloadModel setDeepLink(DeepLink deepLink) {
        this.mDeepLink = deepLink;
        return this;
    }

    public AdDownloadModel setDownloadUrl(String str) {
        this.mDownloadUrl = str;
        return this;
    }

    public void setExpectFileLength(long j4) {
        this.mExpectFileLength = j4;
    }

    public void setExtra(JSONObject jSONObject) {
        this.mExtra = jSONObject;
    }

    public void setExtraValue(long j4) {
        this.mExtraValue = j4;
    }

    public AdDownloadModel setFileName(String str) {
        this.mFileName = str;
        return this;
    }

    public AdDownloadModel setFileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.mFileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public AdDownloadModel setFunnelType(int i4) {
        this.mFunnelType = i4;
        return this;
    }

    public AdDownloadModel setHeaders(Map<String, String> map) {
        this.mHeaders = map;
        return this;
    }

    public AdDownloadModel setId(long j4) {
        this.mId = j4;
        return this;
    }

    public AdDownloadModel setIsAd(boolean z3) {
        this.mIsAd = z3;
        return this;
    }

    public AdDownloadModel setIsShowNotification(boolean z3) {
        this.mIsShowNotification = z3;
        return this;
    }

    public void setIsShowToast(boolean z3) {
        this.mIsShowToast = z3;
    }

    public AdDownloadModel setLogExtra(String str) {
        this.mLogExtra = str;
        return this;
    }

    public void setMd5(String str) {
        this.mMd5 = str;
    }

    public AdDownloadModel setMimeType(String str) {
        this.mMimeType = str;
        return this;
    }

    public AdDownloadModel setModelType(int i4) {
        this.mModelType = i4;
        return this;
    }

    public AdDownloadModel setNeedIndependentProcess(boolean z3) {
        this.mIndependentProcess = z3;
        return this;
    }

    public void setNeedWifi(boolean z3) {
        this.mNeedWifi = z3;
    }

    public AdDownloadModel setNotificationJumpUrl(String str) {
        this.mNotificationJumpUrl = str;
        return this;
    }

    public AdDownloadModel setPackageName(String str) {
        this.mPackageName = str;
        return this;
    }

    public AdDownloadModel setQuickAppModel(s sVar) {
        this.mQuickAppModel = sVar;
        return this;
    }

    public void setSdkMonitorScene(String str) {
        this.mSdkMonitorScene = str;
    }

    public void setStartToast(String str) {
        this.mStartToast = str;
    }

    public void setTaskKey(String str) {
        this.mTaskKey = str;
    }

    public AdDownloadModel setVersionCode(int i4) {
        this.mVersionCode = i4;
        return this;
    }

    public AdDownloadModel setVersionName(String str) {
        this.mVersionName = str;
        return this;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean shouldDownloadWithPatchApply() {
        return a.ok(ok.ok(getDownloadSettings()), getMimeType());
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.mId);
            int i4 = 1;
            jSONObject.put("is_ad", this.mIsAd ? 1 : 0);
            jSONObject.putOpt("model_type", Integer.valueOf(this.mModelType));
            jSONObject.putOpt("mime_type", this.mMimeType);
            jSONObject.putOpt("ext_value", Long.valueOf(this.mExtraValue));
            jSONObject.putOpt("log_extra", this.mLogExtra);
            jSONObject.putOpt("package_name", this.mPackageName);
            jSONObject.putOpt(com.mbridge.msdk.foundation.download.database.DownloadModel.DOWNLOAD_URL, this.mDownloadUrl);
            jSONObject.putOpt("app_name", this.mAppName);
            jSONObject.putOpt("app_icon", this.mAppIcon);
            jSONObject.putOpt("is_show_toast", Integer.valueOf(this.mIsShowToast ? 1 : 0));
            jSONObject.putOpt("show_notification", Integer.valueOf(this.mIsShowNotification ? 1 : 0));
            jSONObject.put("need_wifi", this.mNeedWifi ? 1 : 0);
            jSONObject.put("md5", this.mMd5);
            jSONObject.put("expect_file_length", this.mExpectFileLength);
            jSONObject.put("independent_process", this.mIndependentProcess ? 1 : 0);
            jSONObject.put("version_code", this.mVersionCode);
            jSONObject.putOpt("version_name", this.mVersionName);
            jSONObject.putOpt("file_path", this.mFilePath);
            jSONObject.putOpt(com.mbridge.msdk.foundation.download.database.DownloadModel.FILE_NAME, this.mFileName);
            jSONObject.putOpt("notification_jump_url", this.mNotificationJumpUrl);
            jSONObject.putOpt("auto_install_without_notify", Integer.valueOf(this.mAutoInstallWithoutNotification ? 1 : 0));
            jSONObject.putOpt("executor_group", Integer.valueOf(this.mExecutorGroup));
            jSONObject.putOpt("start_toast", this.mStartToast);
            jSONObject.putOpt("sdk_monitor_scene", this.mSdkMonitorScene);
            jSONObject.putOpt("auto_install", Integer.valueOf(this.mAutoInstall ? 1 : 0));
            jSONObject.putOpt("distinct_dir", Integer.valueOf(this.mDistinctDir ? 1 : 0));
            if (!this.mEnablePause) {
                i4 = 0;
            }
            jSONObject.putOpt("enable_pause", Integer.valueOf(i4));
            jSONObject.putOpt("task_key", this.mTaskKey);
            Object obj = this.mDownloadSettings;
            if (obj != null) {
                jSONObject.put("download_settings", obj);
            }
            List<String> list = this.mBackupUrls;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.mBackupUrls) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("backup_urls", jSONArray);
            }
            DeepLink deepLink = this.mDeepLink;
            if (deepLink != null) {
                if (!TextUtils.isEmpty(deepLink.getOpenUrl())) {
                    jSONObject.put("open_url", this.mDeepLink.getOpenUrl());
                }
                if (!TextUtils.isEmpty(this.mDeepLink.getWebUrl())) {
                    jSONObject.put("web_url", this.mDeepLink.getWebUrl());
                }
            }
            s sVar = this.mQuickAppModel;
            if (sVar != null) {
                jSONObject.putOpt("quick_app_url", sVar.ok());
            }
            List<String> list2 = this.mClickTrackUrl;
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : this.mClickTrackUrl) {
                    jSONArray2.put(str2);
                }
                jSONObject.put("click_track_urls", jSONArray2);
            }
            Object obj2 = this.mExtra;
            if (obj2 != null) {
                jSONObject.put("extra", obj2);
            }
            Map<String, String> map = this.mHeaders;
            if (map != null && !map.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
                    jSONArray3.put(entry.getKey());
                    jSONArray4.put(entry.getKey());
                }
                jSONObject.put("header_keys", jSONArray3);
                jSONObject.put("header_values", jSONArray4);
            }
        } catch (Exception e4) {
            r.u().ok(e4, "AdDownloadModel toJson");
        }
        return jSONObject;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public AdDownloadModel setFilePath(String str) {
        this.mFilePath = str;
        return this;
    }
}
