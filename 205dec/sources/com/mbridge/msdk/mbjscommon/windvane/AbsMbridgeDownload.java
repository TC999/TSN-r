package com.mbridge.msdk.mbjscommon.windvane;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.out.IDownloadListener;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
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
    private String JSON_KEY_PACKAGE_NAME = "packageName";
    private String JSON_KEY_STATUS = "status";
    private String JSON_KEY_PROGRESS = "progress";
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
                x.a(this.TAG, th.getMessage());
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
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        addDownloadListening(obj, optJSONArray.optString(i4));
                    }
                    return;
                }
                callbackExcep(obj, "akdluiList is 0");
                return;
            }
            callbackExcep(obj, "akdluiList is null");
        } catch (JSONException e4) {
            e4.printStackTrace();
            callbackExcep(obj, e4.getMessage());
        }
    }

    private void checkMustParamsAndFillDefaultIfNull(JSONObject jSONObject, String str, Object obj) {
        try {
            if (jSONObject.opt(str) == null) {
                jSONObject.put(str, obj);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private JSONObject getDownloadStatus(Object obj, String str) {
        try {
            this.currentObject = obj;
        } catch (Throwable th) {
            x.a(this.TAG, th.getMessage());
            callbackExcep(obj, th.getMessage());
        }
        if (!TextUtils.isEmpty(str)) {
            Object invoke = ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            int intValue = ((Integer) ADownloadManager.class.getMethod("getTaskStatusByUniqueKey", String.class).invoke(invoke, str)).intValue();
            int intValue2 = ((Integer) ADownloadManager.class.getMethod("getTaskProgressByUniqueKey", String.class).invoke(invoke, str)).intValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", statusIntToString(intValue));
            jSONObject.put("progress", intValue2);
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
            } catch (JSONException e4) {
                e4.printStackTrace();
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
            public final void onEnd(int i4, int i5, String str2) {
                String str3 = AbsMbridgeDownload.this.TAG;
                x.b(str3, "download listener onEnd result = " + i4 + " nid = " + i5 + " file = " + str2);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                File file = new File(str2);
                if (file.exists()) {
                    com.mbridge.msdk.click.c.a(AbsMbridgeDownload.this.mContext, Uri.fromFile(file), AbsMbridgeDownload.this.downloadUrl, str);
                }
            }

            @Override // com.mbridge.msdk.out.IDownloadListener
            public final void onProgressUpdate(int i4) {
                x.a("click control", "onProgressUpdate:" + i4);
                if (AbsMbridgeDownload.this.canNotifyProgress || (i4 == 100 && AbsMbridgeDownload.this.mProgress != i4)) {
                    x.a("click control", "=============onProgressUpdate:" + i4);
                    AbsMbridgeDownload.this.canNotifyProgress = false;
                    AbsMbridgeDownload.this.handler.sendEmptyMessageDelayed(1, AbsMbridgeDownload.this.progressNotifyInterval);
                    AbsMbridgeDownload.this.mProgress = i4;
                    AbsMbridgeDownload.this.onDownloadAPKProgressChange(i4, str);
                }
            }

            @Override // com.mbridge.msdk.out.IDownloadListener
            public final void onStart() {
            }

            @Override // com.mbridge.msdk.out.IDownloadListener
            public final void onStatus(int i4) {
                x.a("click control", "onStatus:" + i4);
                if (AbsMbridgeDownload.this.mStatus != i4) {
                    x.a("click control", "========onStatus:" + i4);
                    AbsMbridgeDownload.this.mStatus = i4;
                    AbsMbridgeDownload.this.onDownloadAPKStatusChange(i4, str);
                }
            }
        };
        this.keyListenerMap.put(str, iDownloadListener);
        return iDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadAPKProgressChange(int i4, String str) {
        a aVar;
        WindVaneWebView windVaneWebView;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(this.JSON_KEY_UNIQUE, str);
            jSONObject.put(this.JSON_KEY_URL, this.downloadUrl);
            jSONObject.put(this.JSON_KEY_PROGRESS, i4);
            final String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            Object obj = this.currentObject;
            if (!(obj instanceof a) || (windVaneWebView = (aVar = (a) obj).f40326a) == null || windVaneWebView.isDestoryed()) {
                return;
            }
            aVar.f40326a.post(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload.4
                @Override // java.lang.Runnable
                public final void run() {
                    h.a().a(AbsMbridgeDownload.this.currentObject, "onDownloadAPKProgressChange", encodeToString);
                }
            });
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadAPKStatusChange(int i4, String str) {
        a aVar;
        WindVaneWebView windVaneWebView;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(this.JSON_KEY_UNIQUE, str);
            jSONObject.put(this.JSON_KEY_URL, this.downloadUrl);
            jSONObject.put(this.JSON_KEY_STATUS, statusIntToString(i4));
            final String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            Object obj = this.currentObject;
            if (!(obj instanceof a) || (windVaneWebView = (aVar = (a) obj).f40326a) == null || windVaneWebView.isDestoryed()) {
                return;
            }
            aVar.f40326a.post(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload.3
                @Override // java.lang.Runnable
                public final void run() {
                    h.a().a(AbsMbridgeDownload.this.currentObject, "onDownloadAPKStatusChange", encodeToString);
                }
            });
        } catch (JSONException e4) {
            e4.printStackTrace();
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
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private String statusIntToString(int i4) {
        return i4 != 1 ? i4 != 2 ? (i4 == 5 || i4 == 6) ? CampaignEx.JSON_NATIVE_VIDEO_PAUSE : i4 != 8 ? i4 != 9 ? "undownload" : "installed" : "fail" : "downloading" : "success";
    }

    public void activateAPK(Object obj, String str) {
        try {
            getUniqueKeyAndUrl(str);
            parseActionEvent(obj, str);
            callbackSuccess(obj);
        } catch (Exception e4) {
            callbackExcep(obj, e4.getMessage());
        }
    }

    public String addDownloaderListener(Object obj, String str) {
        x.d("=====AbsMbridgeDownload", "====before---params:" + str);
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
            } catch (JSONException e4) {
                e4.printStackTrace();
                callbackExcep(obj, e4.getMessage());
            }
        }
        x.d("=====AbsMbridgeDownload", "====end--params:" + str);
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
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
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
            x.a(this.TAG, th.getMessage());
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
            x.a(this.TAG, th.getMessage());
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
            x.a(this.TAG, th.getMessage());
            callbackExcep(obj, th.getMessage());
        }
    }

    public abstract void sendNoticeAndCallBackClick(Object obj, String str);
}
