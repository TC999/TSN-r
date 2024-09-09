package com.kwad.components.offline.api.tk.model.report;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class TKDownloadMsg extends BaseOfflineCompoJsonParse<TKDownloadMsg> implements Serializable {
    public static final int ENV_SUCCESS = 3;
    public static final int FAIL = 2;
    private static final int INVALID_DOWNLOAD_STATE = -1;
    public static final int START = 0;
    public static final int SUCCESS = 1;
    private static final long serialVersionUID = -8872909341685100922L;
    public long availableTime;
    public int downloadState = -1;
    public long downloadTime;
    public String errorDetail;
    public String errorReason;
    public int loadingTimes;
    public long offlineLoadTime;
    public int offlineSource;
    public int preload;
    public int retryCount;
    public long soLoadTime;
    public int soSource;
    public String templateId;
    public int threadPoolCoreSize;
    public String versionCode;

    public TKDownloadMsg setDownloadState(int i4) {
        this.downloadState = i4;
        return this;
    }

    public TKDownloadMsg setDownloadTime(long j4) {
        this.downloadTime = j4;
        return this;
    }

    public TKDownloadMsg setErrorDetail(String str) {
        this.errorDetail = str;
        return this;
    }

    public TKDownloadMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public TKDownloadMsg setInitSdkTimeConsuming(long j4) {
        this.availableTime = j4;
        return this;
    }

    public TKDownloadMsg setLoadingTimes(int i4) {
        this.loadingTimes = i4;
        return this;
    }

    public TKDownloadMsg setOfflineLoadTime(long j4) {
        this.offlineLoadTime = j4;
        return this;
    }

    public TKDownloadMsg setOfflineSource(int i4) {
        this.offlineSource = i4;
        return this;
    }

    public TKDownloadMsg setPreload(int i4) {
        this.preload = i4;
        return this;
    }

    public TKDownloadMsg setRetryCount(int i4) {
        this.retryCount = i4;
        return this;
    }

    public TKDownloadMsg setSoLoadTime(long j4) {
        this.soLoadTime = j4;
        return this;
    }

    public TKDownloadMsg setSoSource(int i4) {
        this.soSource = i4;
        return this;
    }

    public TKDownloadMsg setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public TKDownloadMsg setThreadPoolCoreSize(int i4) {
        this.threadPoolCoreSize = i4;
        return this;
    }

    public TKDownloadMsg setVersionCode(String str) {
        this.versionCode = str;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKDownloadMsg.downloadState = jSONObject.optInt("download_state");
        tKDownloadMsg.downloadTime = jSONObject.optLong("download_time");
        tKDownloadMsg.preload = jSONObject.optInt("preload");
        tKDownloadMsg.errorReason = jSONObject.optString("error_reason");
        if (jSONObject.opt("error_reason") == JSONObject.NULL) {
            tKDownloadMsg.errorReason = "";
        }
        tKDownloadMsg.templateId = jSONObject.optString("template_id");
        if (jSONObject.opt("template_id") == JSONObject.NULL) {
            tKDownloadMsg.templateId = "";
        }
        tKDownloadMsg.versionCode = jSONObject.optString("version_code");
        if (jSONObject.opt("version_code") == JSONObject.NULL) {
            tKDownloadMsg.versionCode = "";
        }
        tKDownloadMsg.retryCount = jSONObject.optInt("retry_count");
        tKDownloadMsg.loadingTimes = jSONObject.optInt("loading_times");
        tKDownloadMsg.offlineSource = jSONObject.optInt("offline_source");
        tKDownloadMsg.soSource = jSONObject.optInt("so_source");
        tKDownloadMsg.offlineLoadTime = jSONObject.optLong("offline_load_time");
        tKDownloadMsg.soLoadTime = jSONObject.optLong("so_load_time");
        tKDownloadMsg.errorDetail = jSONObject.optString("error_detail");
        if (jSONObject.opt("error_detail") == JSONObject.NULL) {
            tKDownloadMsg.errorDetail = "";
        }
        tKDownloadMsg.threadPoolCoreSize = jSONObject.optInt("thread_pool_core_size");
        tKDownloadMsg.availableTime = jSONObject.optLong("available_time");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "download_state", tKDownloadMsg.downloadState);
        JsonHelper.putValue(jSONObject, "thread_pool_core_size", tKDownloadMsg.threadPoolCoreSize);
        JsonHelper.putValue(jSONObject, "available_time", tKDownloadMsg.availableTime);
        long j4 = tKDownloadMsg.downloadTime;
        if (j4 != 0) {
            JsonHelper.putValue(jSONObject, "download_time", j4);
        }
        int i4 = tKDownloadMsg.preload;
        if (i4 != 0) {
            JsonHelper.putValue(jSONObject, "preload", i4);
        }
        String str = tKDownloadMsg.errorReason;
        if (str != null && !str.equals("")) {
            JsonHelper.putValue(jSONObject, "error_reason", tKDownloadMsg.errorReason);
        }
        String str2 = tKDownloadMsg.templateId;
        if (str2 != null && !str2.equals("")) {
            JsonHelper.putValue(jSONObject, "template_id", tKDownloadMsg.templateId);
        }
        String str3 = tKDownloadMsg.versionCode;
        if (str3 != null && !str3.equals("")) {
            JsonHelper.putValue(jSONObject, "version_code", tKDownloadMsg.versionCode);
        }
        int i5 = tKDownloadMsg.retryCount;
        if (i5 != 0) {
            JsonHelper.putValue(jSONObject, "retry_count", i5);
        }
        int i6 = tKDownloadMsg.loadingTimes;
        if (i6 != 0) {
            JsonHelper.putValue(jSONObject, "loading_times", i6);
        }
        int i7 = tKDownloadMsg.offlineSource;
        if (i7 != 0) {
            JsonHelper.putValue(jSONObject, "offline_source", i7);
        }
        int i8 = tKDownloadMsg.soSource;
        if (i8 != 0) {
            JsonHelper.putValue(jSONObject, "so_source", i8);
        }
        long j5 = tKDownloadMsg.offlineLoadTime;
        if (j5 != 0) {
            JsonHelper.putValue(jSONObject, "offline_load_time", j5);
        }
        long j6 = tKDownloadMsg.soLoadTime;
        if (j6 != 0) {
            JsonHelper.putValue(jSONObject, "so_load_time", j6);
        }
        String str4 = tKDownloadMsg.errorDetail;
        if (str4 != null && !str4.equals("")) {
            JsonHelper.putValue(jSONObject, "error_detail", tKDownloadMsg.errorDetail);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg) {
        return toJson(tKDownloadMsg, (JSONObject) null);
    }
}
