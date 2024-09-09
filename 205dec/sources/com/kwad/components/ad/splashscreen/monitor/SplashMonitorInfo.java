package com.kwad.components.ad.splashscreen.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.Serializable;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class SplashMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int CHECK_BACKUP_FAILED = 4;
    public static final int CHECK_BACKUP_SUCCESS = 3;
    public static final int CHECK_CACHE = 2;
    public static final int CHECK_INVALID_VIDEO = 5;
    public static final int CHECK_LIVE_NO_CACHE = 8;
    public static final int CHECK_TIME_OUT = 7;
    public static final int ERROR_DOWNLOAD = 4;
    public static final int ERROR_NET = 1;
    public static final String ERROR_NET_MSG = "networkError";
    public static final int ERROR_PRELOAD_ID_INVALID = 3;
    public static final String ERROR_PRELOAD_ID_INVALID_MSG = "preloadIdError";
    public static final int ERROR_URL_INVALID = 2;
    public static final String ERROR_URL_INVALID_MSG = "urlError";
    public static final int IMAGE_LOAD_NO_TIMEOUT = 3002;
    public static final int IMAGE_LOAD_START = 3001;
    public static final int IMAGE_LOAD_TIMEOUT = 3003;
    public static final long LOAD_PROCESS_TYPE_NEW = 1;
    public static final long LOAD_PROCESS_TYPE_OLD = 2;
    public static final int LOAD_STATUS_CHECK_FAILED = 5;
    public static final int LOAD_STATUS_CHECK_SUCCESS = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAILED = 4;
    public static final int LOAD_STATUS_LOAD_DATA_PRE = 11;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_CACHE = 2;
    public static final int LOAD_TYPE_ONLINE = 1;
    public static final int MATERIAL_IMAGE = 2;
    public static final int MATERIAL_VIDEO = 1;
    public static final int PRE_LOAD_FAIL = 3;
    public static final int PRE_LOAD_START = 1;
    public static final int PRE_LOAD_SUCCESS = 2;
    public static final int SHOW_AD_CALL = 4;
    public static final int SHOW_CALL = 6;
    public static final int SHOW_CALL_ERROR = 7;
    public static final int SHOW_END_RECORD = 8;
    public static final int SHOW_FAIL = 3;
    public static final int SHOW_START = 1;
    public static final int SHOW_SUCCESS = 2;
    public static final int SHOW_TK_OFFLINE_READY = 5;
    public static final int SINGLE_CACHE_FAIL = 2;
    public static final int SINGLE_CACHE_SUCCESS = 1;
    public static final int SPLASH_FROM_FRAGMENT = 2;
    public static final int SPLASH_FROM_VIEW = 1;
    public static final String TEMPLATE_ID_EMPTY = "template_id_empty";
    public static final String TEMPLATE_RENER_TYPE_ERROR = "template_render_type_error";
    public static final int TK_ENTER = 101;
    public static final int TK_ENV_NOT_READY = 103;
    public static final int TK_LOAD_FAILED = 105;
    public static final int TK_LOAD_START = 102;
    public static final int TK_LOAD_SUCCESS = 104;
    public static final int TK_RENDER_TIMEOUT = 106;
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_UPDATE = 2;
    private static final long serialVersionUID = 3528420046810658543L;
    public int actionType;
    public long beforeLoadDataTime;
    public long cacheValidTime;
    public int callbackType;
    public long checkDataTime;
    public int checkStatus;
    public long costTime;
    public int count;
    public long creativeId;
    public List<String> creativeIds;
    public List<Integer> elementTypes;
    public List<String> ids;
    public String interactiveStyle;
    public String interactivityDefaultStyle;
    public boolean isRotateComposeTimeout;
    public boolean isWebTimeout;
    public long loadAndCheckDataTime;
    public long loadDataTime;
    public long loadProcessType;
    public int materialType;
    public long nativeLoadTime;
    public long offlineLoadTime;
    public int offlineSource;
    public long posId;
    public String preloadId;
    public List<String> preloadIds;
    public long showEndTime;
    public long size;
    public long soLoadTime;
    public int soSource;
    public int status;
    public String templateId;
    public int templateVersionCode;
    public long tkDefaultTimeout;
    public long tkFileLoadTime;
    public long tkInitTime;
    public long tkRenderTime;
    public long tkRenderType;
    public long tkTotalTime;
    public int totalCount;
    public int type;
    public String url;
    public int viewSource;
    public long webLoadTime;

    public SplashMonitorInfo setActionType(int i4) {
        this.actionType = i4;
        return this;
    }

    public SplashMonitorInfo setBeforeLoadDataTime(long j4) {
        this.beforeLoadDataTime = j4;
        return this;
    }

    public SplashMonitorInfo setCacheValidTime(long j4) {
        this.cacheValidTime = j4;
        return this;
    }

    public SplashMonitorInfo setCallbackType(int i4) {
        this.callbackType = i4;
        return this;
    }

    public SplashMonitorInfo setCheckDataTime(long j4) {
        this.checkDataTime = j4;
        return this;
    }

    public SplashMonitorInfo setCheckStatus(int i4) {
        this.checkStatus = i4;
        return this;
    }

    public SplashMonitorInfo setCostTime(long j4) {
        this.costTime = j4;
        return this;
    }

    public SplashMonitorInfo setCount(int i4) {
        this.count = i4;
        return this;
    }

    public SplashMonitorInfo setCreativeId(long j4) {
        this.creativeId = j4;
        return this;
    }

    public SplashMonitorInfo setCreativeIds(List<String> list) {
        this.creativeIds = list;
        return this;
    }

    public SplashMonitorInfo setElementTypes(List<Integer> list) {
        this.elementTypes = list;
        return this;
    }

    public SplashMonitorInfo setIds(List<String> list) {
        this.ids = list;
        return this;
    }

    public SplashMonitorInfo setInteractiveStyle(int i4) {
        this.interactiveStyle = String.valueOf(i4);
        return this;
    }

    public SplashMonitorInfo setInteractivityDefaultStyle(int i4) {
        this.interactivityDefaultStyle = String.valueOf(i4);
        return this;
    }

    public SplashMonitorInfo setLoadAndCheckDataTime(long j4) {
        this.loadAndCheckDataTime = j4;
        return this;
    }

    public SplashMonitorInfo setLoadDataTime(long j4) {
        this.loadDataTime = j4;
        return this;
    }

    public SplashMonitorInfo setLoadProcessType(long j4) {
        this.loadProcessType = j4;
        return this;
    }

    public SplashMonitorInfo setMaterialType(int i4) {
        this.materialType = i4;
        return this;
    }

    public SplashMonitorInfo setNativeLoadTime(long j4) {
        this.nativeLoadTime = j4;
        return this;
    }

    public SplashMonitorInfo setOfflineLoadTime(long j4) {
        this.offlineLoadTime = j4;
        return this;
    }

    public SplashMonitorInfo setOfflineSource(int i4) {
        this.offlineSource = i4;
        return this;
    }

    public SplashMonitorInfo setPreloadId(String str) {
        this.preloadId = str;
        return this;
    }

    public SplashMonitorInfo setPreloadIds(List<String> list) {
        this.preloadIds = list;
        return this;
    }

    public SplashMonitorInfo setRotateComposeTimeout(boolean z3) {
        this.isRotateComposeTimeout = z3;
        return this;
    }

    public SplashMonitorInfo setShowEndTime(long j4) {
        this.showEndTime = j4;
        return this;
    }

    public SplashMonitorInfo setSize(long j4) {
        this.size = j4;
        return this;
    }

    public SplashMonitorInfo setSoLoadTime(long j4) {
        this.soLoadTime = j4;
        return this;
    }

    public SplashMonitorInfo setSoSource(int i4) {
        this.soSource = i4;
        return this;
    }

    public SplashMonitorInfo setStatus(int i4) {
        this.status = i4;
        return this;
    }

    public SplashMonitorInfo setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public SplashMonitorInfo setTemplateVersionCode(int i4) {
        this.templateVersionCode = i4;
        return this;
    }

    public SplashMonitorInfo setTkDefaultTimeout(long j4) {
        this.tkDefaultTimeout = j4;
        return this;
    }

    public SplashMonitorInfo setTkFileLoadTime(long j4) {
        this.tkFileLoadTime = j4;
        return this;
    }

    public SplashMonitorInfo setTkInitTime(long j4) {
        this.tkInitTime = j4;
        return this;
    }

    public SplashMonitorInfo setTkRenderTime(long j4) {
        this.tkRenderTime = j4;
        return this;
    }

    public SplashMonitorInfo setTkRenderType(long j4) {
        this.tkRenderType = j4;
        return this;
    }

    public SplashMonitorInfo setTkTotalTime(long j4) {
        this.tkTotalTime = j4;
        return this;
    }

    public SplashMonitorInfo setTotalCount(int i4) {
        this.totalCount = i4;
        return this;
    }

    public SplashMonitorInfo setType(int i4) {
        this.type = i4;
        return this;
    }

    public SplashMonitorInfo setUrl(String str) {
        this.url = str;
        return this;
    }

    public SplashMonitorInfo setViewSource(int i4) {
        this.viewSource = i4;
        return this;
    }

    public SplashMonitorInfo setWebLoadTime(long j4) {
        this.webLoadTime = j4;
        return this;
    }

    public SplashMonitorInfo setWebTimeout(boolean z3) {
        this.isWebTimeout = z3;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public SplashMonitorInfo setAdTemplate(AdTemplate adTemplate) {
        return (SplashMonitorInfo) super.setAdTemplate(adTemplate);
    }

    @Override // com.kwad.sdk.commercial.c.a
    public SplashMonitorInfo setErrorCode(int i4) {
        super.setErrorCode(i4);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public SplashMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
