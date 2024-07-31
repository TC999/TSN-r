package com.mbridge.msdk.mbjscommon.windvane;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.out.IDownloadListener;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbsMbridgeDownload extends AbsFeedBackForH5 {
    private static final int HANDLER_WHAT_KEY = 1;
    private Object currentObject;
    private String downloadUrl;
    private int mProgress;
    private int mStatus;
    private String packageName;
    private WindVaneWebView webView;
    private String TAG = "MbridgeDownload";
    private String JSON_KEY_AKDLUI = DomainCampaignEx.JSON_KEY_AKDLUI;
    private String JSON_KEY_DOWNLOAD_PROGRESS_NOTIFY_INTERVAL = "progressNotifyInterval";
    private String JSON_KEY_UNIQUE = "uniqueKey";
    private String JSON_KEY_URL = "apkURL";
    private String JSON_KEY_PACKAGE_NAME = TTDownloadField.TT_PACKAGE_NAME;
    private String JSON_KEY_STATUS = "status";
    private String JSON_KEY_PROGRESS = NotificationCompat.CATEGORY_PROGRESS;
    private String JSON_KEY_CAMPAIGN = "campaign";
    private HashMap<String, IDownloadListener> keyListenerMap = new HashMap<>();
    private long DEFAULT_PROGRESS_NOTIFY_INTERVAL = 2000;
    private long progressNotifyInterval = 2000;
    private boolean canNotifyProgress = true;
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            AbsMbridgeDownload.this.canNotifyProgress = true;
        }
    };

    private void addDownloadListening(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                IDownloadListener iDownloadListener = getiDownloadListenerByUniqueKey(str);
                ADownloadManager.class.getMethod("addDownloadListener", String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str, iDownloadListener);
                callbackSuccess(obj);
                return;
            } catch (Throwable th) {
                SameLogTool.m21738a(this.TAG, th.getMessage());
                callbackExcep(obj, th.getMessage());
                return;
            }
        }
        callbackExcep(obj, "uniqueKey is null");
    }

    private void addMultipleDownloaderListener(Object obj, String str) {
        this.currentObject = obj;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("akdluiList");
            if (optJSONArray != null) {
                if (optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        addDownloadListening(obj, optJSONArray.optString(i));
                    }
                    return;
                }
                callbackExcep(obj, "akdluiList is 0");
                return;
            }
            callbackExcep(obj, "akdluiList is null");
        } catch (JSONException e) {
            e.printStackTrace();
            callbackExcep(obj, e.getMessage());
        }
    }

    private void checkMustParamsAndFillDefaultIfNull(JSONObject jSONObject, String str, Object obj) {
        try {
            if (jSONObject.opt(str) == null) {
                jSONObject.put(str, obj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONObject getDownloadStatus(Object obj, String str) {
        try {
            this.currentObject = obj;
        } catch (Throwable th) {
            SameLogTool.m21738a(this.TAG, th.getMessage());
            callbackExcep(obj, th.getMessage());
        }
        if (!TextUtils.isEmpty(str)) {
            Object invoke = ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            int intValue = ((Integer) ADownloadManager.class.getMethod("getTaskStatusByUniqueKey", String.class).invoke(invoke, str)).intValue();
            int intValue2 = ((Integer) ADownloadManager.class.getMethod("getTaskProgressByUniqueKey", String.class).invoke(invoke, str)).intValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", statusIntToString(intValue));
            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, intValue2);
            return jSONObject;
        }
        callbackExcep(obj, "uniqueKey is null");
        return null;
    }

    private String getUniqueKeyAndIntervalTimeFromCampaign(JSONObject jSONObject) {
        String str;
        str = "";
        if (jSONObject != null) {
            try {
                str = jSONObject.opt(this.JSON_KEY_AKDLUI) != null ? jSONObject.getString(this.JSON_KEY_AKDLUI) : "";
                if (jSONObject.opt(this.JSON_KEY_DOWNLOAD_PROGRESS_NOTIFY_INTERVAL) != null) {
                    this.progressNotifyInterval = jSONObject.optLong(this.JSON_KEY_DOWNLOAD_PROGRESS_NOTIFY_INTERVAL, this.DEFAULT_PROGRESS_NOTIFY_INTERVAL);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    private String getUniqueKeyAndUrl(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString(this.JSON_KEY_UNIQUE);
        this.downloadUrl = jSONObject.getString(this.JSON_KEY_URL);
        this.packageName = jSONObject.optString(this.JSON_KEY_PACKAGE_NAME);
        return string;
    }

    private IDownloadListener getiDownloadListenerByUniqueKey(final String str) {
        if (this.keyListenerMap.containsKey(str)) {
            return this.keyListenerMap.get(str);
        }
        IDownloadListener iDownloadListener = new IDownloadListener() { // from class: com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload.2
            @Override // com.mbridge.msdk.out.IDownloadListener
            public final void onEnd(int i, int i2, String str2) {
                String str3 = AbsMbridgeDownload.this.TAG;
                SameLogTool.m21736b(str3, "download listener onEnd result = " + i + " nid = " + i2 + " file = " + str2);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                File file = new File(str2);
                if (file.exists()) {
                    CommonClickUtil.m23077a(AbsMbridgeDownload.this.mContext, Uri.fromFile(file), AbsMbridgeDownload.this.downloadUrl, str);
                }
            }

            @Override // com.mbridge.msdk.out.IDownloadListener
            public final void onProgressUpdate(int i) {
                SameLogTool.m21738a("click control", "onProgressUpdate:" + i);
                if (AbsMbridgeDownload.this.canNotifyProgress || (i == 100 && AbsMbridgeDownload.this.mProgress != i)) {
                    SameLogTool.m21738a("click control", "=============onProgressUpdate:" + i);
                    AbsMbridgeDownload.this.canNotifyProgress = false;
                    AbsMbridgeDownload.this.handler.sendEmptyMessageDelayed(1, AbsMbridgeDownload.this.progressNotifyInterval);
                    AbsMbridgeDownload.this.mProgress = i;
                    AbsMbridgeDownload.this.onDownloadAPKProgressChange(i, str);
                }
            }

            @Override // com.mbridge.msdk.out.IDownloadListener
            public final void onStart() {
            }

            @Override // com.mbridge.msdk.out.IDownloadListener
            public final void onStatus(int i) {
                SameLogTool.m21738a("click control", "onStatus:" + i);
                if (AbsMbridgeDownload.this.mStatus != i) {
                    SameLogTool.m21738a("click control", "========onStatus:" + i);
                    AbsMbridgeDownload.this.mStatus = i;
                    AbsMbridgeDownload.this.onDownloadAPKStatusChange(i, str);
                }
            }
        };
        this.keyListenerMap.put(str, iDownloadListener);
        return iDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadAPKProgressChange(int i, String str) {
        CallMethodContext callMethodContext;
        WindVaneWebView windVaneWebView;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(this.JSON_KEY_UNIQUE, str);
            jSONObject.put(this.JSON_KEY_URL, this.downloadUrl);
            jSONObject.put(this.JSON_KEY_PROGRESS, i);
            final String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            Object obj = this.currentObject;
            if (!(obj instanceof CallMethodContext) || (windVaneWebView = (callMethodContext = (CallMethodContext) obj).f31554a) == null || windVaneWebView.isDestoryed()) {
                return;
            }
            callMethodContext.f31554a.post(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload.4
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneCallJs.m21387a().m21383a(AbsMbridgeDownload.this.currentObject, "onDownloadAPKProgressChange", encodeToString);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadAPKStatusChange(int i, String str) {
        CallMethodContext callMethodContext;
        WindVaneWebView windVaneWebView;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(this.JSON_KEY_UNIQUE, str);
            jSONObject.put(this.JSON_KEY_URL, this.downloadUrl);
            jSONObject.put(this.JSON_KEY_STATUS, statusIntToString(i));
            final String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            Object obj = this.currentObject;
            if (!(obj instanceof CallMethodContext) || (windVaneWebView = (callMethodContext = (CallMethodContext) obj).f31554a) == null || windVaneWebView.isDestoryed()) {
                return;
            }
            callMethodContext.f31554a.post(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload.3
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneCallJs.m21387a().m21383a(AbsMbridgeDownload.this.currentObject, "onDownloadAPKStatusChange", encodeToString);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseActionEvent(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.opt(this.JSON_KEY_CAMPAIGN) != null) {
                sendNoticeAndCallBackClick(obj, jSONObject.getString(this.JSON_KEY_CAMPAIGN));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String statusIntToString(int i) {
        return i != 1 ? i != 2 ? (i == 5 || i == 6) ? CampaignEx.JSON_NATIVE_VIDEO_PAUSE : i != 8 ? i != 9 ? "undownload" : "installed" : CommonNetImpl.FAIL : "downloading" : "success";
    }

    public void activateAPK(Object obj, String str) {
        try {
            getUniqueKeyAndUrl(str);
            parseActionEvent(obj, str);
            callbackSuccess(obj);
        } catch (Exception e) {
            callbackExcep(obj, e.getMessage());
        }
    }

    public String addDownloaderListener(Object obj, String str) {
        SameLogTool.m21733d("=====AbsMbridgeDownload", "====before---params:" + str);
        this.currentObject = obj;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String uniqueKeyAndIntervalTimeFromCampaign = getUniqueKeyAndIntervalTimeFromCampaign(jSONObject);
                checkMustParamsAndFillDefaultIfNull(jSONObject, this.JSON_KEY_AKDLUI, "");
                checkMustParamsAndFillDefaultIfNull(jSONObject, DomainCampaignEx.JSON_KEY_ATAT_TYPE, 0);
                checkMustParamsAndFillDefaultIfNull(jSONObject, DomainCampaignEx.JSON_KEY_NTBARPASBL, 0);
                checkMustParamsAndFillDefaultIfNull(jSONObject, DomainCampaignEx.JSON_KEY_NTBARPT, 0);
                addDownloadListening(obj, uniqueKeyAndIntervalTimeFromCampaign);
                str = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                callbackExcep(obj, e.getMessage());
            }
        }
        SameLogTool.m21733d("=====AbsMbridgeDownload", "====end--params:" + str);
        return str;
    }

    public void getDownloadAPKStatus(Object obj, String str) {
        this.currentObject = obj;
        try {
            JSONObject downloadStatus = getDownloadStatus(obj, getUniqueKeyAndUrl(str));
            if (downloadStatus != null) {
                callbackSuccessWithData(obj, downloadStatus);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            callbackExcep(obj, th.getMessage());
        }
    }

    public void getMultipleDownloadAPKStatus(Object obj, String str) {
        String optString;
        JSONObject downloadStatus;
        this.currentObject = obj;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = new JSONArray();
                JSONArray optJSONArray = jSONObject.optJSONArray("downloaderList");
                if (optJSONArray != null) {
                    if (optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null && (downloadStatus = getDownloadStatus(obj, (optString = optJSONObject.optString("uniqueKey")))) != null) {
                                downloadStatus.put("uniqueKey", optString);
                                jSONArray.put(downloadStatus);
                            }
                        }
                    } else {
                        callbackExcep(obj, "downloaderList is 0");
                    }
                } else {
                    callbackExcep(obj, "downloaderList is null");
                }
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("downloaderList", jSONArray);
                    callbackSuccessWithData(obj, jSONObject2);
                    return;
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                callbackExcep(obj, th.getMessage());
                return;
            }
        }
        callbackExcep(obj, "params is null");
    }

    public void installAPK(Object obj, String str) {
        try {
            getUniqueKeyAndUrl(str);
            parseActionEvent(obj, str);
            callbackSuccess(obj);
        } catch (Throwable th) {
            SameLogTool.m21738a(this.TAG, th.getMessage());
            callbackExcep(obj, th.getMessage());
        }
    }

    public void pauseDownloadAPK(Object obj, String str) {
        try {
            String uniqueKeyAndUrl = getUniqueKeyAndUrl(str);
            ADownloadManager.class.getMethod(CampaignEx.JSON_NATIVE_VIDEO_PAUSE, String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), uniqueKeyAndUrl);
            parseActionEvent(obj, str);
            callbackSuccess(obj);
        } catch (Throwable th) {
            SameLogTool.m21738a(this.TAG, th.getMessage());
            callbackExcep(obj, th.getMessage());
        }
    }

    public void restartDownloadAPK(Object obj, String str) {
        this.currentObject = obj;
        try {
            String uniqueKeyAndUrl = getUniqueKeyAndUrl(str);
            IDownloadListener iDownloadListener = getiDownloadListenerByUniqueKey(uniqueKeyAndUrl);
            Object invoke = ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            ADownloadManager.class.getMethod("addDownloadListener", String.class, IDownloadListener.class).invoke(invoke, uniqueKeyAndUrl, iDownloadListener);
            ADownloadManager.class.getMethod(CampaignEx.JSON_NATIVE_VIDEO_START, String.class, String.class).invoke(invoke, uniqueKeyAndUrl, this.downloadUrl);
            parseActionEvent(obj, str);
            callbackSuccess(obj);
        } catch (Throwable th) {
            SameLogTool.m21738a(this.TAG, th.getMessage());
            callbackExcep(obj, th.getMessage());
        }
    }

    public abstract void sendNoticeAndCallBackClick(Object obj, String str);
}
