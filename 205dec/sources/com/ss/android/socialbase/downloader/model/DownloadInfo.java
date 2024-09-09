package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.h;
import com.ss.android.socialbase.downloader.depend.fd;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.q.kf;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = new Parcelable.Creator<DownloadInfo>() { // from class: com.ss.android.socialbase.downloader.model.DownloadInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public DownloadInfo createFromParcel(Parcel parcel) {
            return new DownloadInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public DownloadInfo[] newArray(int i4) {
            return new DownloadInfo[i4];
        }
    };
    private static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    private static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
    private static final int RESERVE_STATUS_NEVER = 0;
    private static final int RESERVE_STATUS_NOW = 2;
    private static final int RESERVE_STATUS_ONCE = 1;
    private static final String TAG = "DownloadInfo";
    private boolean addListenerToSameTask;
    private AtomicLong allConnectTime;
    private int appVersionCode;
    private com.ss.android.socialbase.downloader.constants.ok asyncHandleStatus;
    private boolean autoResumed;
    private int backUpUrlRetryCount;
    private boolean backUpUrlUsed;
    private List<String> backUpUrls;
    private String backUpUrlsStr;
    private int bindValueCount;
    private com.ss.android.socialbase.downloader.constants.a byteInvalidRetryStatus;
    private int chunkCount;
    private boolean chunkDowngradeRetryUsed;
    private int curBackUpUrlIndex;
    private AtomicLong curBytes;
    private int curRetryTime;
    private JSONObject dbJsonData;
    private String dbJsonDataString;
    private boolean deleteCacheIfCheckFailed;
    private boolean distinctDirectory;
    private long downloadTime;
    private String eTag;
    private EnqueueType enqueueType;
    private StringBuffer errorBytesLog;
    private boolean expiredRedownload;
    private String extra;
    private List<bl> extraHeaders;
    private int[] extraMonitorStatus;
    private BaseException failedException;
    private String filePackageName;
    private List<String> forbiddenBackupUrls;
    private boolean force;
    private boolean forceIgnoreRecommendSize;
    private boolean headConnectionAvailable;
    private String headConnectionException;
    private int httpStatusCode;
    private String httpStatusMessage;
    private boolean httpsToHttpRetryUsed;
    private String iconUrl;
    private int id;
    private boolean ignoreDataVerify;
    private Boolean isAutoInstallWithoutNotification;
    private boolean isFirstDownload;
    private boolean isFirstSuccess;
    private boolean isForbiddenRetryed;
    private volatile boolean isSaveTempFile;
    private AtomicLong lastNotifyProgressTime;
    private boolean mDownloadFromReserveWifi;
    private int maxBytes;
    private int maxProgressCount;
    private String md5;
    private String mimeType;
    private int minProgressTimeMsInterval;
    private String monitorScene;
    private String name;
    private boolean needChunkDowngradeRetry;
    private boolean needDefaultHttpServiceBackUp;
    private boolean needHttpsToHttpRetry;
    private boolean needIndependentProcess;
    private boolean needPostProgress;
    private boolean needRetryDelay;
    private boolean needReuseChunkRunnable;
    private boolean needReuseFirstConnection;
    private boolean needSDKMonitor;
    private String networkQuality;
    private int notificationVisibility;
    private boolean onlyWifi;
    private boolean openLimitSpeed;
    private String[] outIp;
    private int[] outSize;
    private SoftReference<PackageInfo> packageInfoRef;
    private String packageName;
    private long realDownloadTime;
    private long realStartDownloadTime;
    private int retryCount;
    private h retryDelayStatus;
    private String retryDelayTimeArray;
    @Deprecated
    private int retryScheduleMinutes;
    private String savePath;
    private boolean showNotification;
    private boolean showNotificationForAutoResumed;
    private boolean showNotificationForNetworkResumed;
    private JSONObject spData;
    private long startDownloadTime;
    private AtomicInteger status;
    private int statusAtDbInit;
    private boolean successByCache;
    private boolean supportPartial;
    private String taskId;
    private ConcurrentHashMap<String, Object> tempCacheData;
    private volatile List<fd> tempFileSaveCompleteCallbacks;
    private String tempPath;
    private long throttleNetSpeed;
    private String title;
    private long totalBytes;
    private long ttnetProtectTimeout;
    private String url;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private int f49905a;
        private int au;

        /* renamed from: b  reason: collision with root package name */
        private long f49906b;
        private long ba;
        private boolean bj;
        private int bk;
        private boolean bm;
        private String bw;

        /* renamed from: c  reason: collision with root package name */
        private String f49907c;
        private String ck;
        private String eq;
        private List<xv> ev;

        /* renamed from: f  reason: collision with root package name */
        private boolean f49908f;
        private int fp;
        private boolean fz;
        private int gd;
        private boolean gw;

        /* renamed from: i  reason: collision with root package name */
        private String f49909i;
        private int ia;

        /* renamed from: j  reason: collision with root package name */
        private boolean f49910j;

        /* renamed from: k  reason: collision with root package name */
        private int[] f49911k;
        private boolean ls;

        /* renamed from: m  reason: collision with root package name */
        private boolean f49912m;
        private boolean me;
        private String mt;

        /* renamed from: n  reason: collision with root package name */
        private boolean f49913n;
        private int[] oo;
        private String ox;

        /* renamed from: p  reason: collision with root package name */
        private String[] f49914p;
        private boolean pr;

        /* renamed from: q  reason: collision with root package name */
        private boolean f49915q;

        /* renamed from: r  reason: collision with root package name */
        private String f49916r;

        /* renamed from: s  reason: collision with root package name */
        private List<String> f49917s;
        private String sr;

        /* renamed from: t  reason: collision with root package name */
        private boolean f49918t;
        private String ux;
        private JSONObject vc;

        /* renamed from: w  reason: collision with root package name */
        private String f49920w;
        private boolean wo;
        private boolean wv;
        private boolean wx;

        /* renamed from: x  reason: collision with root package name */
        private long f49921x;
        private String xv;

        /* renamed from: y  reason: collision with root package name */
        private boolean f49922y;
        private boolean yu;

        /* renamed from: z  reason: collision with root package name */
        private String f49923z;
        private boolean ys = true;

        /* renamed from: u  reason: collision with root package name */
        private boolean f49919u = true;
        private boolean gb = true;
        private EnqueueType xk = EnqueueType.ENQUEUE_NONE;
        private boolean up = true;

        public c() {
        }

        public c a(boolean z3) {
            this.wv = z3;
            return this;
        }

        public c bk(boolean z3) {
            this.yu = z3;
            return this;
        }

        public c c(String str) {
            this.f49907c = str;
            return this;
        }

        public c ev(String str) {
            this.f49909i = str;
            return this;
        }

        public c f(String str) {
            this.ux = str;
            return this;
        }

        public c fp(boolean z3) {
            this.gw = z3;
            return this;
        }

        public c fz(boolean z3) {
            this.bj = z3;
            return this;
        }

        public c gd(boolean z3) {
            this.f49913n = z3;
            return this;
        }

        public c i(boolean z3) {
            this.wo = z3;
            return this;
        }

        public c ia(boolean z3) {
            this.up = z3;
            return this;
        }

        public c k(String str) {
            this.eq = str;
            return this;
        }

        public c p(String str) {
            this.f49923z = str;
            return this;
        }

        public c q(boolean z3) {
            this.f49919u = z3;
            return this;
        }

        public c r(String str) {
            this.f49916r = str;
            return this;
        }

        public c s(boolean z3) {
            this.f49912m = z3;
            return this;
        }

        public c sr(String str) {
            this.ox = str;
            return this;
        }

        public c t(boolean z3) {
            this.wx = z3;
            return this;
        }

        public c u(boolean z3) {
            this.bm = z3;
            return this;
        }

        public c ux(String str) {
            this.sr = str;
            return this;
        }

        public c w(String str) {
            this.f49920w = str;
            return this;
        }

        public c xv(String str) {
            this.xv = str;
            return this;
        }

        public c ys(boolean z3) {
            this.pr = z3;
            return this;
        }

        public c a(String str) {
            this.mt = str;
            return this;
        }

        public c bk(String str) {
            this.bw = str;
            return this;
        }

        public c c(boolean z3) {
            this.f49908f = z3;
            return this;
        }

        public c ev(boolean z3) {
            this.gb = z3;
            return this;
        }

        public c f(boolean z3) {
            this.f49910j = z3;
            return this;
        }

        public c gd(String str) {
            this.ck = str;
            return this;
        }

        public c k(boolean z3) {
            this.me = z3;
            return this;
        }

        public c p(boolean z3) {
            this.f49922y = z3;
            return this;
        }

        public c r(boolean z3) {
            this.ls = z3;
            return this;
        }

        public c sr(int i4) {
            this.fp = i4;
            return this;
        }

        public c ux(int i4) {
            this.ia = i4;
            return this;
        }

        public c w(int i4) {
            this.f49905a = i4;
            return this;
        }

        public c xv(int i4) {
            this.bk = i4;
            return this;
        }

        public c c(List<xv> list) {
            this.ev = list;
            return this;
        }

        public c f(int i4) {
            this.au = i4;
            return this;
        }

        public c sr(boolean z3) {
            this.f49915q = z3;
            return this;
        }

        public c ux(boolean z3) {
            this.fz = z3;
            return this;
        }

        public c w(boolean z3) {
            this.f49918t = z3;
            return this;
        }

        public c xv(boolean z3) {
            this.ys = z3;
            return this;
        }

        public c c(int i4) {
            this.gd = i4;
            return this;
        }

        public c w(List<String> list) {
            this.f49917s = list;
            return this;
        }

        public c xv(long j4) {
            this.f49906b = j4;
            return this;
        }

        public c c(String[] strArr) {
            this.f49914p = strArr;
            return this;
        }

        public c w(int[] iArr) {
            this.oo = iArr;
            return this;
        }

        public c(String str) {
            this.xv = str;
        }

        public c c(int[] iArr) {
            this.f49911k = iArr;
            return this;
        }

        public c w(long j4) {
            this.f49921x = j4;
            return this;
        }

        public c c(long j4) {
            this.ba = j4;
            return this;
        }

        public c c(EnqueueType enqueueType) {
            this.xk = enqueueType;
            return this;
        }

        public c c(JSONObject jSONObject) {
            this.vc = jSONObject;
            return this;
        }

        public DownloadInfo c() {
            return new DownloadInfo(this, (AnonymousClass1) null);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        private String f49924a;
        private boolean ah;
        private String bl;
        private boolean cs;
        private String dx;
        private int[] ej;
        private boolean em;
        private boolean ep;
        private long er;
        private boolean fb;
        private boolean fd;
        private boolean fl;

        /* renamed from: g  reason: collision with root package name */
        private String f49926g;

        /* renamed from: h  reason: collision with root package name */
        private String f49927h;

        /* renamed from: i  reason: collision with root package name */
        private int f49928i;

        /* renamed from: io  reason: collision with root package name */
        private String f49929io;

        /* renamed from: j  reason: collision with root package name */
        private int f49930j;

        /* renamed from: k  reason: collision with root package name */
        private String[] f49931k;
        private boolean kf;
        private String kz;

        /* renamed from: l  reason: collision with root package name */
        private boolean f49932l;

        /* renamed from: n  reason: collision with root package name */
        private String f49934n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f49935o;
        private String ok;

        /* renamed from: p  reason: collision with root package name */
        private List<bl> f49936p;

        /* renamed from: q  reason: collision with root package name */
        private int f49937q;
        private String qu;
        private int qx;

        /* renamed from: r  reason: collision with root package name */
        private int[] f49938r;
        private boolean rh;

        /* renamed from: s  reason: collision with root package name */
        private String f49939s;
        private boolean sg;
        private List<String> td;
        private boolean tg;
        private boolean tr;
        private boolean ul;

        /* renamed from: v  reason: collision with root package name */
        private boolean f49942v;
        private String vz;

        /* renamed from: w  reason: collision with root package name */
        private long f49943w;
        private JSONObject wv;

        /* renamed from: x  reason: collision with root package name */
        private int f49944x;
        private long xy;

        /* renamed from: y  reason: collision with root package name */
        private boolean f49945y;
        private String yt;

        /* renamed from: z  reason: collision with root package name */
        private int f49946z;
        private boolean zz;

        /* renamed from: t  reason: collision with root package name */
        private boolean f49940t = true;

        /* renamed from: u  reason: collision with root package name */
        private boolean f49941u = true;

        /* renamed from: m  reason: collision with root package name */
        private boolean f49933m = true;

        /* renamed from: e  reason: collision with root package name */
        private EnqueueType f49925e = EnqueueType.ENQUEUE_NONE;
        private boolean vk = true;

        public ok() {
        }

        public ok a(String str) {
            this.f49924a = str;
            return this;
        }

        public ok bl(String str) {
            this.bl = str;
            return this;
        }

        public ok h(String str) {
            this.f49927h = str;
            return this;
        }

        public ok i(boolean z3) {
            this.f49932l = z3;
            return this;
        }

        public ok io(boolean z3) {
            this.tg = z3;
            return this;
        }

        public ok j(boolean z3) {
            this.fl = z3;
            return this;
        }

        public ok k(String str) {
            this.kz = str;
            return this;
        }

        public ok kf(String str) {
            this.f49934n = str;
            return this;
        }

        public ok n(String str) {
            this.f49939s = str;
            return this;
        }

        public ok ok(String str) {
            this.ok = str;
            return this;
        }

        public ok p(String str) {
            this.f49929io = str;
            return this;
        }

        public ok q(boolean z3) {
            this.ep = z3;
            return this;
        }

        public ok r(String str) {
            this.f49926g = str;
            return this;
        }

        public ok rh(boolean z3) {
            this.em = z3;
            return this;
        }

        public ok s(String str) {
            this.dx = str;
            return this;
        }

        public ok t(boolean z3) {
            this.sg = z3;
            return this;
        }

        public ok td(boolean z3) {
            this.ah = z3;
            return this;
        }

        public ok u(boolean z3) {
            this.cs = z3;
            return this;
        }

        public ok ul(boolean z3) {
            this.f49941u = z3;
            return this;
        }

        public ok x(boolean z3) {
            this.vk = z3;
            return this;
        }

        public ok z(boolean z3) {
            this.fd = z3;
            return this;
        }

        public ok zz(boolean z3) {
            this.tr = z3;
            return this;
        }

        public ok a(int i4) {
            this.f49930j = i4;
            return this;
        }

        public ok bl(int i4) {
            this.f49946z = i4;
            return this;
        }

        public ok h(boolean z3) {
            this.f49945y = z3;
            return this;
        }

        public ok j(String str) {
            this.yt = str;
            return this;
        }

        public ok k(boolean z3) {
            this.fb = z3;
            return this;
        }

        public ok kf(boolean z3) {
            this.f49935o = z3;
            return this;
        }

        public ok n(int i4) {
            this.f49944x = i4;
            return this;
        }

        public ok ok(boolean z3) {
            this.kf = z3;
            return this;
        }

        public ok p(boolean z3) {
            this.f49933m = z3;
            return this;
        }

        public ok q(String str) {
            this.vz = str;
            return this;
        }

        public ok r(boolean z3) {
            this.f49942v = z3;
            return this;
        }

        public ok s(int i4) {
            this.f49928i = i4;
            return this;
        }

        public ok z(String str) {
            this.qu = str;
            return this;
        }

        public ok a(boolean z3) {
            this.rh = z3;
            return this;
        }

        public ok bl(boolean z3) {
            this.f49940t = z3;
            return this;
        }

        public ok kf(int i4) {
            this.qx = i4;
            return this;
        }

        public ok n(boolean z3) {
            this.zz = z3;
            return this;
        }

        public ok ok(List<bl> list) {
            this.f49936p = list;
            return this;
        }

        public ok s(boolean z3) {
            this.ul = z3;
            return this;
        }

        public ok a(List<String> list) {
            this.td = list;
            return this;
        }

        public ok bl(long j4) {
            this.f49943w = j4;
            return this;
        }

        public ok ok(int i4) {
            this.f49937q = i4;
            return this;
        }

        public ok a(int[] iArr) {
            this.ej = iArr;
            return this;
        }

        public ok ok(String[] strArr) {
            this.f49931k = strArr;
            return this;
        }

        public ok(String str) {
            this.bl = str;
        }

        public ok a(long j4) {
            this.xy = j4;
            return this;
        }

        public ok ok(int[] iArr) {
            this.f49938r = iArr;
            return this;
        }

        public ok ok(long j4) {
            this.er = j4;
            return this;
        }

        public ok ok(EnqueueType enqueueType) {
            this.f49925e = enqueueType;
            return this;
        }

        public ok ok(JSONObject jSONObject) {
            this.wv = jSONObject;
            return this;
        }

        public DownloadInfo ok() {
            return new DownloadInfo(this);
        }
    }

    private void convertEnqueueType(int i4) {
        EnqueueType enqueueType = EnqueueType.ENQUEUE_HEAD;
        if (i4 == enqueueType.ordinal()) {
            this.enqueueType = enqueueType;
            return;
        }
        EnqueueType enqueueType2 = EnqueueType.ENQUEUE_TAIL;
        if (i4 == enqueueType2.ordinal()) {
            this.enqueueType = enqueueType2;
        } else {
            this.enqueueType = EnqueueType.ENQUEUE_NONE;
        }
    }

    private void convertRetryDelayStatus(int i4) {
        h hVar = h.DELAY_RETRY_WAITING;
        if (i4 == hVar.ordinal()) {
            this.retryDelayStatus = hVar;
            return;
        }
        h hVar2 = h.DELAY_RETRY_DOWNLOADING;
        if (i4 == hVar2.ordinal()) {
            this.retryDelayStatus = hVar2;
            return;
        }
        h hVar3 = h.DELAY_RETRY_DOWNLOADED;
        if (i4 == hVar3.ordinal()) {
            this.retryDelayStatus = hVar3;
        } else {
            this.retryDelayStatus = h.DELAY_RETRY_NONE;
        }
    }

    private JSONObject convertStrToJson(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void ensureDBJsonData() {
        if (this.dbJsonData == null) {
            synchronized (this) {
                if (this.dbJsonData == null) {
                    if (!TextUtils.isEmpty(this.dbJsonDataString)) {
                        this.dbJsonData = new JSONObject(this.dbJsonDataString);
                        this.dbJsonDataString = null;
                    } else {
                        this.dbJsonData = new JSONObject();
                    }
                }
            }
        }
    }

    private void ensureSpData() {
        if (this.spData == null) {
            Context l4 = com.ss.android.socialbase.downloader.downloader.bl.l();
            if (l4 != null) {
                String string = l4.getSharedPreferences("sp_download_info", 0).getString(Long.toString(getId()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.spData = new JSONObject(string);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
            if (this.spData == null) {
                this.spData = new JSONObject();
            }
        }
    }

    private void ensureTempCacheData() {
        if (this.tempCacheData == null) {
            synchronized (this) {
                if (this.tempCacheData == null) {
                    this.tempCacheData = new ConcurrentHashMap<>();
                }
            }
        }
    }

    private String getBackUpUrlsStr() {
        List<String> list;
        if (this.backUpUrlsStr == null && (list = this.backUpUrls) != null && !list.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.backUpUrls) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                this.backUpUrlsStr = jSONArray.toString();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (this.backUpUrlsStr == null) {
            this.backUpUrlsStr = "";
        }
        return this.backUpUrlsStr;
    }

    private String getDBJsonDataString() {
        String jSONObject;
        String str = this.dbJsonDataString;
        if (str != null) {
            return str;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            jSONObject = this.dbJsonData.toString();
            this.dbJsonDataString = jSONObject;
        }
        return jSONObject;
    }

    private int getReserveWifiStatus() {
        ensureSpData();
        try {
            return this.spData.optInt("pause_reserve_on_wifi", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private void mergeAuxiliaryJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject.opt(next);
                    if (!this.dbJsonData.has(next) && opt != null) {
                        this.dbJsonData.put(next, opt);
                    }
                }
            } catch (Exception unused) {
            }
            this.dbJsonDataString = null;
        }
        parseMonitorSetting();
    }

    private void parseMonitorSetting() {
        ensureDBJsonData();
        this.needSDKMonitor = this.dbJsonData.optBoolean("need_sdk_monitor", false);
        this.monitorScene = this.dbJsonData.optString("monitor_scene", "");
        JSONArray optJSONArray = this.dbJsonData.optJSONArray("extra_monitor_status");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.extraMonitorStatus = new int[optJSONArray.length()];
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            this.extraMonitorStatus[i4] = optJSONArray.optInt(i4);
        }
    }

    private void putMonitorSetting() {
        safePutToDBJsonData("need_sdk_monitor", Boolean.valueOf(this.needSDKMonitor));
        safePutToDBJsonData("monitor_scene", this.monitorScene);
        try {
            JSONArray jSONArray = new JSONArray();
            int[] iArr = this.extraMonitorStatus;
            if (iArr != null && iArr.length > 0) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = this.extraMonitorStatus;
                    if (i4 >= iArr2.length) {
                        break;
                    }
                    jSONArray.put(iArr2[i4]);
                    i4++;
                }
            }
            safePutToDBJsonData("extra_monitor_status", jSONArray);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshBackupUrls(boolean z3) {
        List<String> list = this.forbiddenBackupUrls;
        if (list == null || list.size() <= z3) {
            return;
        }
        List<String> list2 = this.backUpUrls;
        if (list2 == null) {
            this.backUpUrls = new ArrayList();
        } else {
            list2.clear();
        }
        this.backUpUrlUsed = false;
        this.curBackUpUrlIndex = 0;
        for (int i4 = z3; i4 < this.forbiddenBackupUrls.size(); i4++) {
            this.backUpUrls.add(this.forbiddenBackupUrls.get(i4));
        }
    }

    private void setBackUpUrlsStr(String str) {
        if (TextUtils.isEmpty(str) || getStatus() == -3) {
            return;
        }
        this.backUpUrlsStr = str;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    String optString = jSONArray.optString(i4);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                this.backUpUrls = arrayList;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void addErrorBytesLog(long j4, int i4, String str) {
        try {
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                if (this.errorBytesLog == null) {
                    this.errorBytesLog = new StringBuffer();
                }
                if (this.errorBytesLog.length() != 0) {
                    this.errorBytesLog.append(",");
                }
                StringBuffer stringBuffer = this.errorBytesLog;
                stringBuffer.append("[type:");
                stringBuffer.append(i4);
                stringBuffer.append(",bytes:");
                stringBuffer.append(j4);
                stringBuffer.append(",method:");
                stringBuffer.append(str);
                stringBuffer.append("]");
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void bindValue(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i4 = this.bindValueCount + 1;
        this.bindValueCount = i4;
        sQLiteStatement.bindLong(i4, this.id);
        int i5 = this.bindValueCount + 1;
        this.bindValueCount = i5;
        String str = this.url;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(i5, str);
        int i6 = this.bindValueCount + 1;
        this.bindValueCount = i6;
        String str2 = this.savePath;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(i6, str2);
        int i7 = this.bindValueCount + 1;
        this.bindValueCount = i7;
        String str3 = this.tempPath;
        if (str3 == null) {
            str3 = "";
        }
        sQLiteStatement.bindString(i7, str3);
        int i8 = this.bindValueCount + 1;
        this.bindValueCount = i8;
        String str4 = this.name;
        if (str4 == null) {
            str4 = "";
        }
        sQLiteStatement.bindString(i8, str4);
        int i9 = this.bindValueCount + 1;
        this.bindValueCount = i9;
        sQLiteStatement.bindLong(i9, this.chunkCount);
        int i10 = this.bindValueCount + 1;
        this.bindValueCount = i10;
        sQLiteStatement.bindLong(i10, getStatus());
        int i11 = this.bindValueCount + 1;
        this.bindValueCount = i11;
        sQLiteStatement.bindLong(i11, getCurBytes());
        int i12 = this.bindValueCount + 1;
        this.bindValueCount = i12;
        sQLiteStatement.bindLong(i12, this.totalBytes);
        int i13 = this.bindValueCount + 1;
        this.bindValueCount = i13;
        String str5 = this.eTag;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(i13, str5);
        int i14 = this.bindValueCount + 1;
        this.bindValueCount = i14;
        sQLiteStatement.bindLong(i14, this.onlyWifi ? 1L : 0L);
        int i15 = this.bindValueCount + 1;
        this.bindValueCount = i15;
        sQLiteStatement.bindLong(i15, this.force ? 1L : 0L);
        int i16 = this.bindValueCount + 1;
        this.bindValueCount = i16;
        sQLiteStatement.bindLong(i16, this.retryCount);
        int i17 = this.bindValueCount + 1;
        this.bindValueCount = i17;
        String str6 = this.extra;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement.bindString(i17, str6);
        int i18 = this.bindValueCount + 1;
        this.bindValueCount = i18;
        String str7 = this.mimeType;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement.bindString(i18, str7);
        int i19 = this.bindValueCount + 1;
        this.bindValueCount = i19;
        String str8 = this.title;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement.bindString(i19, str8);
        int i20 = this.bindValueCount + 1;
        this.bindValueCount = i20;
        sQLiteStatement.bindLong(i20, this.showNotification ? 1L : 0L);
        int i21 = this.bindValueCount + 1;
        this.bindValueCount = i21;
        sQLiteStatement.bindLong(i21, this.notificationVisibility);
        int i22 = this.bindValueCount + 1;
        this.bindValueCount = i22;
        sQLiteStatement.bindLong(i22, this.isFirstDownload ? 1L : 0L);
        int i23 = this.bindValueCount + 1;
        this.bindValueCount = i23;
        sQLiteStatement.bindLong(i23, this.isFirstSuccess ? 1L : 0L);
        int i24 = this.bindValueCount + 1;
        this.bindValueCount = i24;
        sQLiteStatement.bindLong(i24, this.needHttpsToHttpRetry ? 1L : 0L);
        int i25 = this.bindValueCount + 1;
        this.bindValueCount = i25;
        sQLiteStatement.bindLong(i25, this.downloadTime);
        int i26 = this.bindValueCount + 1;
        this.bindValueCount = i26;
        String str9 = this.packageName;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement.bindString(i26, str9);
        int i27 = this.bindValueCount + 1;
        this.bindValueCount = i27;
        String str10 = this.md5;
        if (str10 == null) {
            str10 = "";
        }
        sQLiteStatement.bindString(i27, str10);
        int i28 = this.bindValueCount + 1;
        this.bindValueCount = i28;
        sQLiteStatement.bindLong(i28, this.needRetryDelay ? 1L : 0L);
        int i29 = this.bindValueCount + 1;
        this.bindValueCount = i29;
        sQLiteStatement.bindLong(i29, this.curRetryTime);
        int i30 = this.bindValueCount + 1;
        this.bindValueCount = i30;
        sQLiteStatement.bindLong(i30, this.retryDelayStatus.ordinal());
        int i31 = this.bindValueCount + 1;
        this.bindValueCount = i31;
        sQLiteStatement.bindLong(i31, this.needDefaultHttpServiceBackUp ? 1L : 0L);
        int i32 = this.bindValueCount + 1;
        this.bindValueCount = i32;
        sQLiteStatement.bindLong(i32, this.needReuseChunkRunnable ? 1L : 0L);
        int i33 = this.bindValueCount + 1;
        this.bindValueCount = i33;
        String str11 = this.retryDelayTimeArray;
        if (str11 == null) {
            str11 = "";
        }
        sQLiteStatement.bindString(i33, str11);
        int i34 = this.bindValueCount + 1;
        this.bindValueCount = i34;
        sQLiteStatement.bindLong(i34, this.needChunkDowngradeRetry ? 1L : 0L);
        int i35 = this.bindValueCount + 1;
        this.bindValueCount = i35;
        sQLiteStatement.bindString(i35, getBackUpUrlsStr());
        int i36 = this.bindValueCount + 1;
        this.bindValueCount = i36;
        sQLiteStatement.bindLong(i36, this.backUpUrlRetryCount);
        int i37 = this.bindValueCount + 1;
        this.bindValueCount = i37;
        sQLiteStatement.bindLong(i37, this.realDownloadTime);
        int i38 = this.bindValueCount + 1;
        this.bindValueCount = i38;
        sQLiteStatement.bindLong(i38, this.retryScheduleMinutes);
        int i39 = this.bindValueCount + 1;
        this.bindValueCount = i39;
        sQLiteStatement.bindLong(i39, this.needIndependentProcess ? 1L : 0L);
        int i40 = this.bindValueCount + 1;
        this.bindValueCount = i40;
        sQLiteStatement.bindString(i40, getDBJsonDataString());
        int i41 = this.bindValueCount + 1;
        this.bindValueCount = i41;
        String str12 = this.iconUrl;
        if (str12 == null) {
            str12 = "";
        }
        sQLiteStatement.bindString(i41, str12);
        int i42 = this.bindValueCount + 1;
        this.bindValueCount = i42;
        sQLiteStatement.bindLong(i42, this.appVersionCode);
        int i43 = this.bindValueCount + 1;
        this.bindValueCount = i43;
        String str13 = this.taskId;
        sQLiteStatement.bindString(i43, str13 != null ? str13 : "");
    }

    public boolean cacheExpierd() {
        if (isDownloaded()) {
            return kf.s(this);
        }
        return true;
    }

    public boolean canNotifyProgress() {
        long j4 = this.lastNotifyProgressTime.get();
        return j4 == 0 || SystemClock.uptimeMillis() - j4 > 20;
    }

    public boolean canReStartAsyncTask() {
        return getStatus() != -3 && this.asyncHandleStatus == com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_WAITING;
    }

    public boolean canReplaceHttpForRetry() {
        return !TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && !this.httpsToHttpRetryUsed;
    }

    public boolean canShowNotification() {
        boolean z3 = this.autoResumed;
        return (!z3 && this.showNotification) || (z3 && (this.showNotificationForAutoResumed || this.showNotificationForNetworkResumed));
    }

    public boolean canSkipStatusHandler() {
        com.ss.android.socialbase.downloader.constants.ok okVar;
        int status = getStatus();
        return status == 7 || this.retryDelayStatus == h.DELAY_RETRY_WAITING || status == 8 || (okVar = this.asyncHandleStatus) == com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_WAITING || okVar == com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_RESTART || this.byteInvalidRetryStatus == com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    public boolean canStartRetryDelayTask() {
        return isNeedRetryDelay() && getStatus() != -3 && this.retryDelayStatus == h.DELAY_RETRY_WAITING;
    }

    public void changeSkipStatus() {
        com.ss.android.socialbase.downloader.constants.ok okVar;
        int status = getStatus();
        if (status == 7 || this.retryDelayStatus == h.DELAY_RETRY_WAITING) {
            setRetryDelayStatus(h.DELAY_RETRY_DOWNLOADING);
        }
        if (status == 8 || (okVar = this.asyncHandleStatus) == com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_WAITING || okVar == com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_RESTART) {
            setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.byteInvalidRetryStatus == com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_RESTART) {
            setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public int checkMd5Status() {
        return kf.a(getSavePath(), getName(), this.md5);
    }

    public boolean checkMd5Valid() {
        return kf.bl(getSavePath(), getName(), this.md5);
    }

    public void clearSpData() {
        Context l4 = com.ss.android.socialbase.downloader.downloader.bl.l();
        if (l4 != null) {
            try {
                l4.getSharedPreferences("sp_download_info", 0).edit().remove(Integer.toString(getId())).apply();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void copyFromCacheData(DownloadInfo downloadInfo, boolean z3) {
        if (downloadInfo == null) {
            return;
        }
        setChunkCount(downloadInfo.getChunkCount());
        setTotalBytes(downloadInfo.getTotalBytes());
        setCurBytes(downloadInfo.getCurBytes(), true);
        this.realDownloadTime = downloadInfo.realDownloadTime;
        if (!downloadInfo.canSkipStatusHandler() && !canSkipStatusHandler()) {
            this.curRetryTime = 0;
            this.isForbiddenRetryed = false;
            this.backUpUrlUsed = false;
            this.curBackUpUrlIndex = 0;
            this.httpsToHttpRetryUsed = false;
        } else {
            this.curRetryTime = downloadInfo.getCurRetryTime();
        }
        seteTag(downloadInfo.geteTag());
        if (z3) {
            setStatus(downloadInfo.getStatus());
        }
        this.isFirstDownload = downloadInfo.getIsFirstDownload();
        this.isFirstSuccess = downloadInfo.isFirstSuccess();
        this.retryDelayStatus = downloadInfo.getRetryDelayStatus();
        mergeAuxiliaryJSONObject(downloadInfo.dbJsonData);
    }

    public void copyTaskIdFromCacheData(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.taskId = downloadInfo.getTaskId();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equalsTask(DownloadInfo downloadInfo) {
        String str;
        String str2;
        return (downloadInfo == null || (str = this.url) == null || !str.equals(downloadInfo.getUrl()) || (str2 = this.savePath) == null || !str2.equals(downloadInfo.getSavePath())) ? false : true;
    }

    public void erase() {
        setCurBytes(0L, true);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
        this.curRetryTime = 0;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.backUpUrlUsed = false;
        this.httpsToHttpRetryUsed = false;
        this.eTag = null;
        this.failedException = null;
        this.tempCacheData = null;
        this.packageInfoRef = null;
    }

    public void generateTaskId() {
        this.taskId = UUID.randomUUID().toString();
    }

    public long getAllConnectTime() {
        ensureDBJsonData();
        if (this.allConnectTime == null) {
            this.allConnectTime = new AtomicLong(this.dbJsonData.optLong("dbjson_key_all_connect_time"));
        }
        return this.allConnectTime.get();
    }

    public int getAntiHijackErrorCode(int i4) {
        ensureDBJsonData();
        return this.dbJsonData.optInt("anti_hijack_error_code", i4);
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public com.ss.android.socialbase.downloader.constants.ok getAsyncHandleStatus() {
        return this.asyncHandleStatus;
    }

    public String getBackUpUrl() {
        List<String> list;
        int i4;
        if (this.backUpUrlUsed && (list = this.backUpUrls) != null && list.size() > 0 && (i4 = this.curBackUpUrlIndex) >= 0 && i4 < this.backUpUrls.size()) {
            String str = this.backUpUrls.get(this.curBackUpUrlIndex);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public List<String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public com.ss.android.socialbase.downloader.constants.a getByteInvalidRetryStatus() {
        return this.byteInvalidRetryStatus;
    }

    public String getCacheControl() {
        ensureSpData();
        try {
            return this.spData.optString("cache-control", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public long getCacheExpiredTime() {
        ensureSpData();
        try {
            return this.spData.optLong("cache-control/expired_time", -1L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public int getChunkCount() {
        return this.chunkCount;
    }

    public String getConnectionUrl() {
        List<String> list;
        int i4;
        List<String> list2;
        String str = this.url;
        if (getStatus() == 8 && (list2 = this.forbiddenBackupUrls) != null && !list2.isEmpty() && !this.backUpUrlUsed) {
            return this.forbiddenBackupUrls.get(0);
        }
        if (!this.backUpUrlUsed || (list = this.backUpUrls) == null || list.size() <= 0 || (i4 = this.curBackUpUrlIndex) < 0 || i4 >= this.backUpUrls.size()) {
            return (!TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && this.httpsToHttpRetryUsed) ? this.url.replaceFirst("https", "http") : str;
        }
        String str2 = this.backUpUrls.get(this.curBackUpUrlIndex);
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public int getCurBackUpUrlIndex() {
        return this.curBackUpUrlIndex;
    }

    public long getCurBytes() {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public int getCurRetryTime() {
        return this.curRetryTime;
    }

    public int getCurRetryTimeInTotal() {
        int i4 = this.curRetryTime;
        if (this.backUpUrlUsed) {
            int i5 = i4 + this.retryCount;
            int i6 = this.curBackUpUrlIndex;
            return i6 > 0 ? i5 + (i6 * this.backUpUrlRetryCount) : i5;
        }
        return i4;
    }

    public int getDBJsonInt(String str) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(str);
    }

    public String getDBJsonString(String str) {
        ensureDBJsonData();
        return this.dbJsonData.optString(str);
    }

    public long getDownloadPrepareTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_download_prepare_time");
    }

    public int getDownloadProcess() {
        if (this.totalBytes <= 0) {
            return 0;
        }
        if (getCurBytes() > this.totalBytes) {
            return 100;
        }
        return (int) ((getCurBytes() * 100) / this.totalBytes);
    }

    public String getDownloadSettingString() {
        ensureDBJsonData();
        return this.dbJsonData.optString("download_setting");
    }

    public double getDownloadSpeed() {
        double curBytes = getCurBytes();
        Double.isNaN(curBytes);
        double d4 = curBytes / 1048576.0d;
        double realDownloadTime = getRealDownloadTime();
        Double.isNaN(realDownloadTime);
        double d5 = realDownloadTime / 1000.0d;
        if (d4 <= 0.0d || d5 <= 0.0d) {
            return -1.0d;
        }
        return d4 / d5;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public EnqueueType getEnqueueType() {
        return this.enqueueType;
    }

    public String getErrorBytesLog() {
        StringBuffer stringBuffer = this.errorBytesLog;
        return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.errorBytesLog.toString();
    }

    public int getExecutorGroup() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("executor_group", 2);
    }

    public long getExpectFileLength() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_expect_file_length");
    }

    public String getExtra() {
        return this.extra;
    }

    public List<bl> getExtraHeaders() {
        return this.extraHeaders;
    }

    public int[] getExtraMonitorStatus() {
        return this.extraMonitorStatus;
    }

    public BaseException getFailedException() {
        return this.failedException;
    }

    public int getFailedResumeCount() {
        ensureSpData();
        return this.spData.optInt("failed_resume_count", 0);
    }

    public String getFilePackageName() {
        return this.filePackageName;
    }

    public long getFirstSpeedTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_key_first_speed_time");
    }

    public List<String> getForbiddenBackupUrls() {
        return this.forbiddenBackupUrls;
    }

    public String getHeadConnectionException() {
        return this.headConnectionException;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public String getHttpStatusMessage() {
        return this.httpStatusMessage;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getId() {
        if (this.id == 0) {
            this.id = com.ss.android.socialbase.downloader.downloader.bl.ok(this);
        }
        return this.id;
    }

    public boolean getIsFirstDownload() {
        return this.isFirstDownload;
    }

    public long getLastDownloadTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong("dbjson_last_start_download_time", 0L);
    }

    public long getLastFailedResumeTime() {
        ensureSpData();
        return this.spData.optLong("last_failed_resume_time", 0L);
    }

    public String getLastModified() {
        ensureSpData();
        try {
            return this.spData.optString("last-modified", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public long getLastUninstallResumeTime() {
        ensureSpData();
        return this.spData.optLong("last_unins_resume_time", 0L);
    }

    public int getLinkMode() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("link_mode");
    }

    public int getMaxBytes() {
        return this.maxBytes;
    }

    public int getMaxProgressCount() {
        return this.maxProgressCount;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public long getMinByteIntervalForPostToMainThread(long j4) {
        int i4 = this.maxProgressCount;
        if (i4 <= 0) {
            i4 = 100;
        }
        long j5 = j4 / (i4 + 1);
        if (j5 <= 0) {
            return 1048576L;
        }
        return j5;
    }

    public int getMinProgressTimeMsInterval() {
        int i4 = this.minProgressTimeMsInterval;
        if (i4 < 1000) {
            return 1000;
        }
        return i4;
    }

    public String getMonitorScene() {
        return this.monitorScene;
    }

    public String getName() {
        return this.name;
    }

    public String getNetworkQuality() {
        return this.networkQuality;
    }

    public int getNotificationVisibility() {
        return this.notificationVisibility;
    }

    public boolean getOpenLimitSpeed() {
        return this.openLimitSpeed;
    }

    public String[] getOutIp() {
        return this.outIp;
    }

    public int[] getOutSize() {
        return this.outSize;
    }

    public PackageInfo getPackageInfo() {
        SoftReference<PackageInfo> softReference = this.packageInfoRef;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getPausedResumeCount() {
        ensureSpData();
        return this.spData.optInt("paused_resume_count", 0);
    }

    public int getPreconnectLevel() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("dbjson_key_preconnect_level", 0);
    }

    public long getRealDownloadTime() {
        return TimeUnit.NANOSECONDS.toMillis(this.realDownloadTime);
    }

    public int getRealStatus() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public h getRetryDelayStatus() {
        return this.retryDelayStatus;
    }

    public String getRetryDelayTimeArray() {
        return this.retryDelayTimeArray;
    }

    public int getRetryScheduleCount() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("retry_schedule_count", 0);
    }

    public String getSavePath() {
        return this.savePath;
    }

    public int getSpIntVal(String str) {
        ensureSpData();
        return this.spData.optInt(str, 0);
    }

    public long getSpLongVal(String str) {
        ensureSpData();
        return this.spData.optLong(str, 0L);
    }

    public String getSpStringVal(String str) {
        ensureSpData();
        return this.spData.optString(str, null);
    }

    public int getStatus() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            int i4 = atomicInteger.get();
            if (i4 == -5) {
                return -2;
            }
            return i4;
        }
        return 0;
    }

    public int getStatusAtDbInit() {
        return this.statusAtDbInit;
    }

    public int getTTMd5CheckStatus() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("ttmd5_check_status", -1);
    }

    public String getTargetFilePath() {
        return kf.ok(this.savePath, this.name);
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTaskKey() {
        ensureDBJsonData();
        return this.dbJsonData.optString("task_key");
    }

    public ConcurrentHashMap<String, Object> getTempCacheData() {
        ensureTempCacheData();
        return this.tempCacheData;
    }

    public String getTempFilePath() {
        return kf.ok(this.savePath, this.tempPath, this.name);
    }

    public String getTempName() {
        return kf.bl(this.name);
    }

    public String getTempPath() {
        return kf.a(this.savePath, this.tempPath);
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public String getTitle() {
        if (TextUtils.isEmpty(this.title)) {
            return this.name;
        }
        return this.title;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public int getTotalRetryCount() {
        int i4 = this.retryCount;
        List<String> list = this.backUpUrls;
        return (list == null || list.isEmpty()) ? i4 : i4 + (this.backUpUrlRetryCount * this.backUpUrls.size());
    }

    public long getTtnetProtectTimeout() {
        return this.ttnetProtectTimeout;
    }

    public int getUninstallResumeCount() {
        ensureSpData();
        return this.spData.optInt("unins_resume_count", 0);
    }

    public String getUrl() {
        return this.url;
    }

    public String geteTag() {
        return this.eTag;
    }

    public synchronized void handleTempSaveCallback(boolean z3, BaseException baseException) {
        this.isSaveTempFile = false;
        if (this.tempFileSaveCompleteCallbacks == null) {
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.a("DownloadInfo", "handleTempSaveCallback isSuccess " + z3 + " callback size:" + this.tempFileSaveCompleteCallbacks.size());
        for (fd fdVar : this.tempFileSaveCompleteCallbacks) {
            if (fdVar != null) {
                if (z3) {
                    fdVar.ok();
                } else {
                    fdVar.ok(baseException);
                }
            }
        }
    }

    public boolean hasNextBackupUrl() {
        List<String> list = this.backUpUrls;
        if (list != null && list.size() > 0) {
            if (!this.backUpUrlUsed) {
                return true;
            }
            int i4 = this.curBackUpUrlIndex;
            if (i4 >= 0 && i4 < this.backUpUrls.size() - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPauseReservedOnWifi() {
        return (getReserveWifiStatus() & 1) > 0;
    }

    public void increaseAllConnectTime(long j4) {
        if (j4 > 0) {
            getAllConnectTime();
            safePutToDBJsonData("dbjson_key_all_connect_time", Long.valueOf(this.allConnectTime.addAndGet(j4)));
        }
    }

    public void increaseCurBytes(long j4) {
        this.curBytes.addAndGet(j4);
    }

    public void increaseDownloadPrepareTime(long j4) {
        if (j4 > 0) {
            safePutToDBJsonData("dbjson_key_download_prepare_time", Long.valueOf(getDownloadPrepareTime() + j4));
        }
    }

    public boolean isAddListenerToSameTask() {
        return this.addListenerToSameTask;
    }

    public boolean isAutoInstall() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("auto_install", 1) == 1;
    }

    public boolean isAutoInstallWithoutNotification() {
        if (this.isAutoInstallWithoutNotification == null) {
            if (!TextUtils.isEmpty(this.extra)) {
                try {
                    this.isAutoInstallWithoutNotification = Boolean.valueOf(new JSONObject(this.extra).optBoolean("auto_install_without_notification", false));
                } catch (JSONException unused) {
                    this.isAutoInstallWithoutNotification = Boolean.FALSE;
                }
            } else {
                this.isAutoInstallWithoutNotification = Boolean.FALSE;
            }
        }
        return this.isAutoInstallWithoutNotification.booleanValue();
    }

    public boolean isAutoResumed() {
        return this.autoResumed;
    }

    public boolean isBackUpUrlUsed() {
        return this.backUpUrlUsed;
    }

    public boolean isBreakpointAvailable() {
        if (isFileDataValid()) {
            return isChunkBreakpointAvailable();
        }
        return false;
    }

    public boolean isCanResumeFromBreakPointStatus() {
        int status = getStatus();
        if (status == 4 || status == 3 || status == -1 || status == 5 || status == 8) {
            return true;
        }
        return (status == 1 || status == 2) && getCurBytes() > 0;
    }

    public boolean isChunkBreakpointAvailable() {
        k m4;
        if (this.chunkCount > 1 && (m4 = com.ss.android.socialbase.downloader.downloader.bl.m()) != null) {
            List<a> bl = m4.bl(getId());
            if (bl == null || bl.size() != this.chunkCount) {
                return false;
            }
            long j4 = 0;
            for (a aVar : bl) {
                if (aVar != null) {
                    j4 += aVar.t();
                }
            }
            if (j4 != getCurBytes()) {
                setCurBytes(j4);
            }
        }
        return true;
    }

    public boolean isChunkDowngradeRetryUsed() {
        return this.chunkDowngradeRetryUsed;
    }

    public boolean isChunked() {
        return kf.a(this.totalBytes);
    }

    public boolean isDeleteCacheIfCheckFailed() {
        return this.deleteCacheIfCheckFailed;
    }

    public boolean isDownloadFromReserveWifi() {
        return this.mDownloadFromReserveWifi;
    }

    public boolean isDownloadOverStatus() {
        return DownloadStatus.isDownloadOver(getStatus());
    }

    public boolean isDownloadWithWifiValid() {
        return !isOnlyWifi() || kf.a(com.ss.android.socialbase.downloader.downloader.bl.l());
    }

    public boolean isDownloaded() {
        return kf.bl(this);
    }

    public boolean isDownloadingStatus() {
        return DownloadStatus.isDownloading(getStatus());
    }

    public boolean isEntityInvalid() {
        return TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.savePath);
    }

    public boolean isExpiredRedownload() {
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("force_close_download_cache_check", 0) == 1) {
            com.ss.android.socialbase.downloader.bl.ok.bl("isExpiredRedownload force to false, reason(global setting) id=" + getId() + " name=" + getName());
            return false;
        }
        return this.expiredRedownload;
    }

    public boolean isFileDataExists() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        return file.exists() && !file.isDirectory();
    }

    public boolean isFileDataValid() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long curBytes = getCurBytes();
            if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_file_data_valid")) {
                if (curBytes > 0) {
                    long j4 = this.totalBytes;
                    if (j4 > 0 && this.chunkCount > 0 && length >= curBytes && length <= j4) {
                        return true;
                    }
                }
                com.ss.android.socialbase.downloader.bl.ok.s("DownloadInfo", "isFileDataValid: cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
                return false;
            }
            if (length > 0 && curBytes > 0) {
                long j5 = this.totalBytes;
                if (j5 > 0 && this.chunkCount > 0 && length >= curBytes && length <= j5 && curBytes < j5) {
                    return true;
                }
            }
            com.ss.android.socialbase.downloader.bl.ok.s("DownloadInfo", "isFileDataValid: cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
        }
        return false;
    }

    public boolean isFirstDownload() {
        if (!this.isFirstDownload || TextUtils.isEmpty(getTempPath()) || TextUtils.isEmpty(getTempName())) {
            return false;
        }
        return !new File(getTempPath(), getTempName()).exists();
    }

    public boolean isFirstSuccess() {
        return this.isFirstSuccess;
    }

    public boolean isForbiddenRetryed() {
        return this.isForbiddenRetryed;
    }

    public boolean isForce() {
        return this.force;
    }

    public boolean isForceIgnoreRecommendSize() {
        return this.forceIgnoreRecommendSize;
    }

    public boolean isHeadConnectionAvailable() {
        return this.headConnectionAvailable;
    }

    public boolean isHttpsToHttpRetryUsed() {
        return this.httpsToHttpRetryUsed;
    }

    public boolean isIgnoreDataVerify() {
        return this.ignoreDataVerify;
    }

    public boolean isNeedChunkDowngradeRetry() {
        return this.needChunkDowngradeRetry;
    }

    public boolean isNeedDefaultHttpServiceBackUp() {
        return this.needDefaultHttpServiceBackUp;
    }

    public boolean isNeedHttpsToHttpRetry() {
        return this.needHttpsToHttpRetry;
    }

    public boolean isNeedIndependentProcess() {
        return this.needIndependentProcess;
    }

    public boolean isNeedPostProgress() {
        return this.needPostProgress;
    }

    public boolean isNeedRetryDelay() {
        return false;
    }

    public boolean isNeedReuseChunkRunnable() {
        return this.needReuseChunkRunnable;
    }

    public boolean isNeedReuseFirstConnection() {
        return this.needReuseFirstConnection;
    }

    public boolean isNeedSDKMonitor() {
        return this.needSDKMonitor;
    }

    public boolean isNewTask() {
        return getStatus() == 0;
    }

    public boolean isOnlyWifi() {
        return this.onlyWifi;
    }

    public boolean isPauseReserveOnWifi() {
        return (getReserveWifiStatus() & 2) > 0;
    }

    public boolean isPauseReserveWithWifiValid() {
        if (this.mDownloadFromReserveWifi) {
            return isPauseReserveOnWifi() && kf.a(com.ss.android.socialbase.downloader.downloader.bl.l());
        }
        return true;
    }

    public boolean isRwConcurrent() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("rw_concurrent", 0) == 1;
    }

    public boolean isSavePathRedirected() {
        ensureDBJsonData();
        return this.dbJsonData.optBoolean("is_save_path_redirected", false);
    }

    public synchronized boolean isSaveTempFile() {
        return this.isSaveTempFile;
    }

    public boolean isShowNotification() {
        return this.showNotification;
    }

    public boolean isShowNotificationForAutoResumed() {
        return this.showNotificationForAutoResumed;
    }

    public boolean isShowNotificationForNetworkResumed() {
        return this.showNotificationForNetworkResumed;
    }

    public boolean isSuccessByCache() {
        return this.successByCache;
    }

    public boolean isSupportPartial() {
        return this.supportPartial;
    }

    public boolean isWaitingWifiStatus() {
        BaseException baseException = this.failedException;
        return baseException != null && baseException.getErrorCode() == 1013;
    }

    public void readFromParcel(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.title = parcel.readString();
        this.url = parcel.readString();
        this.savePath = parcel.readString();
        this.tempPath = parcel.readString();
        this.onlyWifi = parcel.readByte() != 0;
        this.extra = parcel.readString();
        this.extraHeaders = parcel.createTypedArrayList(bl.CREATOR);
        this.maxBytes = parcel.readInt();
        this.outIp = parcel.createStringArray();
        this.outSize = parcel.createIntArray();
        this.retryCount = parcel.readInt();
        this.backUpUrlRetryCount = parcel.readInt();
        this.force = parcel.readByte() != 0;
        this.needPostProgress = parcel.readByte() != 0;
        this.maxProgressCount = parcel.readInt();
        this.minProgressTimeMsInterval = parcel.readInt();
        this.backUpUrls = parcel.createStringArrayList();
        this.showNotification = parcel.readByte() != 0;
        this.mimeType = parcel.readString();
        this.needHttpsToHttpRetry = parcel.readByte() != 0;
        this.packageName = parcel.readString();
        this.md5 = parcel.readString();
        this.needRetryDelay = parcel.readByte() != 0;
        this.needDefaultHttpServiceBackUp = parcel.readByte() != 0;
        this.needReuseChunkRunnable = parcel.readByte() != 0;
        this.retryDelayTimeArray = parcel.readString();
        this.eTag = parcel.readString();
        this.curRetryTime = parcel.readInt();
        convertRetryDelayStatus(parcel.readInt());
        this.needReuseFirstConnection = parcel.readByte() != 0;
        this.forceIgnoreRecommendSize = parcel.readByte() != 0;
        this.networkQuality = parcel.readString();
        this.curBackUpUrlIndex = parcel.readInt();
        this.notificationVisibility = parcel.readInt();
        this.chunkCount = parcel.readInt();
        setCurBytes(parcel.readLong());
        this.totalBytes = parcel.readLong();
        setStatus(parcel.readInt());
        this.downloadTime = parcel.readLong();
        this.realDownloadTime = parcel.readLong();
        this.backUpUrlUsed = parcel.readByte() != 0;
        this.httpsToHttpRetryUsed = parcel.readByte() != 0;
        try {
            StringBuffer stringBuffer = this.errorBytesLog;
            if (stringBuffer == null) {
                this.errorBytesLog = new StringBuffer(parcel.readString());
            } else {
                stringBuffer.delete(0, stringBuffer.length()).append(parcel.readString());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.autoResumed = parcel.readByte() != 0;
        this.showNotificationForAutoResumed = parcel.readByte() != 0;
        this.showNotificationForNetworkResumed = parcel.readByte() != 0;
        this.forbiddenBackupUrls = parcel.createStringArrayList();
        this.needIndependentProcess = parcel.readByte() != 0;
        convertEnqueueType(parcel.readInt());
        this.headConnectionAvailable = parcel.readByte() != 0;
        this.httpStatusCode = parcel.readInt();
        this.httpStatusMessage = parcel.readString();
        this.isSaveTempFile = parcel.readByte() != 0;
        this.isForbiddenRetryed = parcel.readByte() != 0;
        this.addListenerToSameTask = parcel.readByte() != 0;
        this.needChunkDowngradeRetry = parcel.readByte() != 0;
        this.chunkDowngradeRetryUsed = parcel.readByte() != 0;
        this.failedException = (BaseException) parcel.readParcelable(BaseException.class.getClassLoader());
        this.retryScheduleMinutes = parcel.readInt();
        this.dbJsonDataString = parcel.readString();
        this.supportPartial = parcel.readByte() != 0;
        this.iconUrl = parcel.readString();
        this.appVersionCode = parcel.readInt();
        this.taskId = parcel.readString();
        this.expiredRedownload = parcel.readByte() != 0;
        this.deleteCacheIfCheckFailed = parcel.readByte() != 0;
        this.successByCache = parcel.readByte() != 0;
        parseMonitorSetting();
    }

    public synchronized void registerTempFileSaveCallback(fd fdVar) {
        if (fdVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.bl.ok.a("DownloadInfo", "registerTempFileSaveCallback");
            if (this.tempFileSaveCompleteCallbacks == null) {
                this.tempFileSaveCompleteCallbacks = new ArrayList();
            }
            if (!this.tempFileSaveCompleteCallbacks.contains(fdVar)) {
                this.tempFileSaveCompleteCallbacks.add(fdVar);
            }
        } finally {
        }
    }

    public void reset() {
        setCurBytes(0L, true);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
    }

    public void resetDataForEtagEndure(String str) {
        setCurBytes(0L, true);
        setTotalBytes(0L);
        seteTag(str);
        setChunkCount(1);
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
    }

    public void resetRealStartDownloadTime() {
        this.realStartDownloadTime = 0L;
    }

    public void safePutToDBJsonData(String str, Object obj) {
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                this.dbJsonData.put(str, obj);
            } catch (Exception unused) {
            }
            this.dbJsonDataString = null;
        }
    }

    public void setAddListenerToSameTask(boolean z3) {
        this.addListenerToSameTask = z3;
    }

    public void setAntiHijackErrorCode(int i4) {
        safePutToDBJsonData("anti_hijack_error_code", Integer.valueOf(i4));
    }

    public void setAppVersionCode(int i4) {
        this.appVersionCode = i4;
    }

    public void setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ok okVar) {
        this.asyncHandleStatus = okVar;
    }

    public void setAutoResumed(boolean z3) {
        this.autoResumed = z3;
    }

    public void setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.a aVar) {
        this.byteInvalidRetryStatus = aVar;
    }

    public void setCacheControl(String str) {
        ensureSpData();
        try {
            this.spData.put("cache-control", str);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public void setCacheExpiredTime(long j4) {
        ensureSpData();
        try {
            this.spData.put("cache-control/expired_time", j4);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public void setChunkCount(int i4) {
        this.chunkCount = i4;
    }

    public void setChunkDowngradeRetryUsed(boolean z3) {
        this.chunkDowngradeRetryUsed = z3;
    }

    public void setCurBytes(long j4) {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            atomicLong.set(j4);
        } else {
            this.curBytes = new AtomicLong(j4);
        }
    }

    public void setDeleteCacheIfCheckFailed() {
        this.deleteCacheIfCheckFailed = true;
    }

    public void setDownloadFromReserveWifi(boolean z3) {
        this.mDownloadFromReserveWifi = z3;
    }

    public void setDownloadTime(long j4) {
        if (j4 >= 0) {
            this.downloadTime = j4;
        }
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setFailedException(BaseException baseException) {
        this.failedException = baseException;
    }

    public void setFailedResumeCount(int i4) {
        ensureSpData();
        try {
            this.spData.put("failed_resume_count", i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setFilePackageName(String str) {
        this.filePackageName = str;
    }

    public void setFirstDownload(boolean z3) {
        this.isFirstDownload = z3;
    }

    public void setFirstSpeedTime(long j4) {
        safePutToDBJsonData("dbjson_key_first_speed_time", Long.valueOf(j4));
    }

    public void setFirstSuccess(boolean z3) {
        this.isFirstSuccess = z3;
    }

    public void setForbiddenBackupUrls(List<String> list, boolean z3) {
        this.forbiddenBackupUrls = list;
        refreshBackupUrls(z3);
    }

    public void setForbiddenRetryed() {
        this.isForbiddenRetryed = true;
    }

    public void setForceIgnoreRecommendSize(boolean z3) {
        this.forceIgnoreRecommendSize = z3;
    }

    public void setHeadConnectionException(String str) {
        this.headConnectionException = str;
    }

    public void setHttpStatusCode(int i4) {
        this.httpStatusCode = i4;
    }

    public void setHttpStatusMessage(String str) {
        this.httpStatusMessage = str;
    }

    public void setHttpsToHttpRetryUsed(boolean z3) {
        this.httpsToHttpRetryUsed = z3;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(int i4) {
        this.id = i4;
    }

    public void setIsRwConcurrent(boolean z3) {
        safePutToDBJsonData("rw_concurrent", Integer.valueOf(z3 ? 1 : 0));
    }

    public synchronized void setIsSaveTempFile(boolean z3) {
        this.isSaveTempFile = z3;
    }

    public void setLastFailedResumeTime(long j4) {
        ensureSpData();
        try {
            this.spData.put("last_failed_resume_time", j4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setLastModified(String str) {
        ensureSpData();
        try {
            this.spData.put("last-modified", str);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public void setLastNotifyProgressTime() {
        this.lastNotifyProgressTime.set(SystemClock.uptimeMillis());
    }

    public void setLastUninstallResumeTime(long j4) {
        ensureSpData();
        try {
            this.spData.put("last_unins_resume_time", j4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setLinkMode(int i4) {
        safePutToDBJsonData("link_mode", Integer.valueOf(i4));
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNetworkQuality(String str) {
        this.networkQuality = str;
    }

    public void setNotificationVisibility(int i4) {
        this.notificationVisibility = i4;
    }

    public void setOnlyWifi(boolean z3) {
        this.onlyWifi = z3;
    }

    public void setOpenLimitSpeed(boolean z3) {
        this.openLimitSpeed = z3;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfoRef = new SoftReference<>(packageInfo);
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPausedResumeCount(int i4) {
        ensureSpData();
        try {
            this.spData.put("paused_resume_count", i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setPreconnectLevel(int i4) {
        ensureDBJsonData();
        safePutToDBJsonData("dbjson_key_preconnect_level", Integer.valueOf(i4));
    }

    public void setRetryDelayStatus(h hVar) {
        this.retryDelayStatus = hVar;
    }

    public void setRetryScheduleCount(int i4) {
        safePutToDBJsonData("retry_schedule_count", Integer.valueOf(i4));
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    public void setSavePathRedirected(boolean z3) {
        safePutToDBJsonData("is_save_path_redirected", Boolean.valueOf(z3));
    }

    public void setShowNotification(boolean z3) {
        this.showNotification = z3;
    }

    public void setShowNotificationForAutoResumed(boolean z3) {
        this.showNotificationForAutoResumed = z3;
    }

    public void setShowNotificationForNetworkResumed(boolean z3) {
        this.showNotificationForNetworkResumed = z3;
    }

    public void setSpValue(String str, String str2) {
        ensureSpData();
        try {
            this.spData.put(str, str2);
            updateSpData();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setStatus(int i4) {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            atomicInteger.set(i4);
        } else {
            this.status = new AtomicInteger(i4);
        }
    }

    public void setStatusAtDbInit(int i4) {
        this.statusAtDbInit = i4;
    }

    public void setSuccessByCache(boolean z3) {
        this.successByCache = z3;
    }

    public void setSupportPartial(boolean z3) {
        this.supportPartial = z3;
    }

    public void setTTMd5CheckStatus(int i4) {
        safePutToDBJsonData("ttmd5_check_status", Integer.valueOf(i4));
    }

    public void setThrottleNetSpeed(long j4) {
        this.throttleNetSpeed = j4;
    }

    public void setTotalBytes(long j4) {
        this.totalBytes = j4;
    }

    public void setUninstallResumeCount(int i4) {
        ensureSpData();
        try {
            this.spData.put("unins_resume_count", i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void seteTag(String str) {
        this.eTag = str;
    }

    public void startPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put("pause_reserve_on_wifi", 3);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public boolean statusInPause() {
        return getRealStatus() == -2 || getRealStatus() == -5;
    }

    public void stopPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put("pause_reserve_on_wifi", 1);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.id));
        contentValues.put("url", this.url);
        contentValues.put("savePath", this.savePath);
        contentValues.put("tempPath", this.tempPath);
        contentValues.put("name", this.name);
        contentValues.put("chunkCount", Integer.valueOf(this.chunkCount));
        contentValues.put("status", Integer.valueOf(getStatus()));
        contentValues.put("curBytes", Long.valueOf(getCurBytes()));
        contentValues.put("totalBytes", Long.valueOf(this.totalBytes));
        contentValues.put("eTag", this.eTag);
        contentValues.put("onlyWifi", Integer.valueOf(this.onlyWifi ? 1 : 0));
        contentValues.put("force", Integer.valueOf(this.force ? 1 : 0));
        contentValues.put("retryCount", Integer.valueOf(this.retryCount));
        contentValues.put("extra", this.extra);
        contentValues.put("mimeType", this.mimeType);
        contentValues.put("title", this.title);
        contentValues.put("notificationEnable", Integer.valueOf(this.showNotification ? 1 : 0));
        contentValues.put("notificationVisibility", Integer.valueOf(this.notificationVisibility));
        contentValues.put("isFirstDownload", Integer.valueOf(this.isFirstDownload ? 1 : 0));
        contentValues.put("isFirstSuccess", Integer.valueOf(this.isFirstSuccess ? 1 : 0));
        contentValues.put("needHttpsToHttpRetry", Integer.valueOf(this.needHttpsToHttpRetry ? 1 : 0));
        contentValues.put("downloadTime", Long.valueOf(this.downloadTime));
        contentValues.put("packageName", this.packageName);
        contentValues.put("md5", this.md5);
        contentValues.put("retryDelay", Integer.valueOf(this.needRetryDelay ? 1 : 0));
        contentValues.put("curRetryTime", Integer.valueOf(this.curRetryTime));
        contentValues.put("retryDelayStatus", Integer.valueOf(this.retryDelayStatus.ordinal()));
        contentValues.put("defaultHttpServiceBackUp", Integer.valueOf(this.needDefaultHttpServiceBackUp ? 1 : 0));
        contentValues.put("chunkRunnableReuse", Integer.valueOf(this.needReuseChunkRunnable ? 1 : 0));
        contentValues.put("retryDelayTimeArray", this.retryDelayTimeArray);
        contentValues.put("chunkDowngradeRetry", Integer.valueOf(this.needChunkDowngradeRetry ? 1 : 0));
        contentValues.put("backUpUrlsStr", getBackUpUrlsStr());
        contentValues.put("backUpUrlRetryCount", Integer.valueOf(this.backUpUrlRetryCount));
        contentValues.put("realDownloadTime", Long.valueOf(this.realDownloadTime));
        contentValues.put("retryScheduleMinutes", Integer.valueOf(this.retryScheduleMinutes));
        contentValues.put("independentProcess", Integer.valueOf(this.needIndependentProcess ? 1 : 0));
        contentValues.put("auxiliaryJsonobjectString", getDBJsonDataString());
        contentValues.put("iconUrl", this.iconUrl);
        contentValues.put("appVersionCode", Integer.valueOf(this.appVersionCode));
        contentValues.put("taskId", this.taskId);
        return contentValues;
    }

    public String toString() {
        return "DownloadInfo{id=" + this.id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "'}";
    }

    public boolean trySwitchToNextBackupUrl() {
        if (this.backUpUrlUsed) {
            this.curBackUpUrlIndex++;
        }
        List<String> list = this.backUpUrls;
        if (list != null && list.size() != 0 && this.curBackUpUrlIndex >= 0) {
            while (this.curBackUpUrlIndex < this.backUpUrls.size()) {
                if (!TextUtils.isEmpty(this.backUpUrls.get(this.curBackUpUrlIndex))) {
                    this.backUpUrlUsed = true;
                    return true;
                }
                this.curBackUpUrlIndex++;
            }
        }
        return false;
    }

    public void updateCurRetryTime(int i4) {
        int i5 = (this.backUpUrlUsed ? this.backUpUrlRetryCount : this.retryCount) - i4;
        this.curRetryTime = i5;
        if (i5 < 0) {
            this.curRetryTime = 0;
        }
    }

    public void updateDownloadTime() {
        if (this.startDownloadTime == 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startDownloadTime;
        if (this.downloadTime < 0) {
            this.downloadTime = 0L;
        }
        if (uptimeMillis > 0) {
            this.downloadTime = uptimeMillis;
        }
    }

    public void updateRealDownloadTime(boolean z3) {
        long nanoTime = System.nanoTime();
        long j4 = this.realStartDownloadTime;
        if (j4 <= 0) {
            if (z3) {
                this.realStartDownloadTime = nanoTime;
                return;
            }
            return;
        }
        long j5 = nanoTime - j4;
        if (z3) {
            this.realStartDownloadTime = nanoTime;
        } else {
            this.realStartDownloadTime = 0L;
        }
        if (j5 > 0) {
            this.realDownloadTime += j5;
        }
    }

    public void updateRealStartDownloadTime() {
        if (this.realStartDownloadTime == 0) {
            this.realStartDownloadTime = System.nanoTime();
        }
    }

    public void updateSpData() {
        Context l4;
        if (this.spData == null || (l4 = com.ss.android.socialbase.downloader.downloader.bl.l()) == null) {
            return;
        }
        l4.getSharedPreferences("sp_download_info", 0).edit().putString(Integer.toString(getId()), this.spData.toString()).apply();
    }

    public void updateStartDownloadTime() {
        this.startDownloadTime = SystemClock.uptimeMillis();
        safePutToDBJsonData("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeString(this.savePath);
        parcel.writeString(this.tempPath);
        parcel.writeByte(this.onlyWifi ? (byte) 1 : (byte) 0);
        parcel.writeString(this.extra);
        parcel.writeTypedList(this.extraHeaders);
        parcel.writeInt(this.maxBytes);
        parcel.writeStringArray(this.outIp);
        parcel.writeIntArray(this.outSize);
        parcel.writeInt(this.retryCount);
        parcel.writeInt(this.backUpUrlRetryCount);
        parcel.writeByte(this.force ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needPostProgress ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.maxProgressCount);
        parcel.writeInt(this.minProgressTimeMsInterval);
        parcel.writeStringList(this.backUpUrls);
        parcel.writeByte(this.showNotification ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mimeType);
        parcel.writeByte(this.needHttpsToHttpRetry ? (byte) 1 : (byte) 0);
        parcel.writeString(this.packageName);
        parcel.writeString(this.md5);
        parcel.writeByte(this.needRetryDelay ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needDefaultHttpServiceBackUp ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needReuseChunkRunnable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.retryDelayTimeArray);
        parcel.writeString(this.eTag);
        parcel.writeInt(this.curRetryTime);
        parcel.writeInt(this.retryDelayStatus.ordinal());
        parcel.writeByte(this.needReuseFirstConnection ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.forceIgnoreRecommendSize ? (byte) 1 : (byte) 0);
        parcel.writeString(this.networkQuality);
        parcel.writeInt(this.curBackUpUrlIndex);
        parcel.writeInt(this.notificationVisibility);
        parcel.writeInt(this.chunkCount);
        parcel.writeLong(getCurBytes());
        parcel.writeLong(this.totalBytes);
        parcel.writeInt(getRealStatus());
        parcel.writeLong(this.downloadTime);
        parcel.writeLong(this.realDownloadTime);
        parcel.writeByte(this.backUpUrlUsed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.httpsToHttpRetryUsed ? (byte) 1 : (byte) 0);
        StringBuffer stringBuffer = this.errorBytesLog;
        parcel.writeString(stringBuffer != null ? stringBuffer.toString() : "");
        parcel.writeByte(this.autoResumed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showNotificationForAutoResumed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showNotificationForNetworkResumed ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.forbiddenBackupUrls);
        parcel.writeByte(this.needIndependentProcess ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.enqueueType.ordinal());
        parcel.writeByte(this.headConnectionAvailable ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.httpStatusCode);
        parcel.writeString(this.httpStatusMessage);
        parcel.writeByte(this.isSaveTempFile ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isForbiddenRetryed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.addListenerToSameTask ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needChunkDowngradeRetry ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.chunkDowngradeRetryUsed ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.failedException, i4);
        parcel.writeInt(this.retryScheduleMinutes);
        parcel.writeString(getDBJsonDataString());
        parcel.writeByte(this.supportPartial ? (byte) 1 : (byte) 0);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.appVersionCode);
        parcel.writeString(this.taskId);
        parcel.writeByte(this.expiredRedownload ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.deleteCacheIfCheckFailed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.successByCache ? (byte) 1 : (byte) 0);
    }

    public DownloadInfo() {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
    }

    public void setCurBytes(long j4, boolean z3) {
        if (z3) {
            setCurBytes(j4);
        } else if (j4 > getCurBytes()) {
            setCurBytes(j4);
        }
    }

    private DownloadInfo(ok okVar) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        if (okVar == null) {
            return;
        }
        this.name = okVar.ok;
        this.title = okVar.f49924a;
        this.url = okVar.bl;
        String str = okVar.f49939s;
        if (TextUtils.isEmpty(str)) {
            try {
                str = kf.n();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.savePath = str;
        String str2 = okVar.f49934n;
        this.tempPath = str2;
        if (TextUtils.isEmpty(str2) && !kf.p(str)) {
            this.tempPath = kf.kf();
        }
        safePutToDBJsonData("task_key", okVar.dx);
        if (okVar.tg) {
            if (com.ss.android.socialbase.downloader.downloader.bl.m().a(getId()) == null) {
                this.savePath = kf.n(this.savePath, this.url);
                this.tempPath = kf.n(this.tempPath, this.url);
            }
        } else {
            com.ss.android.socialbase.downloader.bl.ok.n("DownloadInfo", "The distinct directory option is not set, which may cause 1005 problems and file downloads being covered");
        }
        this.status = new AtomicInteger(0);
        this.curBytes = new AtomicLong(0L);
        this.extra = okVar.f49927h;
        this.onlyWifi = okVar.kf;
        this.extraHeaders = okVar.f49936p;
        this.maxBytes = okVar.f49937q;
        this.retryCount = okVar.f49930j;
        this.backUpUrlRetryCount = okVar.f49946z;
        this.force = okVar.rh;
        this.outIp = okVar.f49931k;
        this.outSize = okVar.f49938r;
        this.needPostProgress = okVar.f49940t;
        this.maxProgressCount = okVar.f49928i;
        this.minProgressTimeMsInterval = okVar.f49944x;
        this.backUpUrls = okVar.td;
        this.showNotification = okVar.zz;
        this.mimeType = okVar.f49929io;
        this.needHttpsToHttpRetry = okVar.ul;
        this.needRetryDelay = okVar.fb;
        this.retryDelayTimeArray = okVar.f49926g;
        this.autoResumed = okVar.f49935o;
        this.showNotificationForAutoResumed = okVar.f49945y;
        this.needDefaultHttpServiceBackUp = okVar.f49933m;
        this.needReuseChunkRunnable = okVar.ep;
        this.packageName = okVar.vz;
        this.md5 = okVar.kz;
        this.needReuseFirstConnection = okVar.f49942v;
        this.needIndependentProcess = okVar.fl;
        this.enqueueType = okVar.f49925e;
        this.headConnectionAvailable = okVar.fd;
        this.ignoreDataVerify = okVar.em;
        this.addListenerToSameTask = okVar.f49932l;
        this.needChunkDowngradeRetry = okVar.sg;
        this.iconUrl = okVar.qu;
        this.throttleNetSpeed = okVar.xy;
        this.openLimitSpeed = okVar.ah;
        JSONObject jSONObject = okVar.wv;
        if (jSONObject != null) {
            safePutToDBJsonData("download_setting", jSONObject.toString());
        }
        safePutToDBJsonData("dbjson_key_expect_file_length", Long.valueOf(okVar.er));
        safePutToDBJsonData("executor_group", Integer.valueOf(okVar.qx));
        safePutToDBJsonData("auto_install", Integer.valueOf(okVar.f49941u ? 1 : 0));
        this.needSDKMonitor = okVar.vk;
        this.monitorScene = okVar.yt;
        this.extraMonitorStatus = okVar.ej;
        this.expiredRedownload = okVar.tr;
        this.deleteCacheIfCheckFailed = okVar.cs;
        this.ttnetProtectTimeout = okVar.f49943w;
        this.distinctDirectory = okVar.tg;
        if (this.expiredRedownload && this.retryCount <= 0) {
            this.retryCount = 1;
        }
        putMonitorSetting();
    }

    protected DownloadInfo(Parcel parcel) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = h.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        readFromParcel(parcel);
    }

    public DownloadInfo(Cursor cursor) {
        boolean z3 = true;
        this.needDefaultHttpServiceBackUp = true;
        h hVar = h.DELAY_RETRY_NONE;
        this.retryDelayStatus = hVar;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        if (cursor == null) {
            return;
        }
        try {
            int columnIndex = cursor.getColumnIndex("_id");
            if (columnIndex != -1) {
                this.id = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("name");
            if (columnIndex2 != -1) {
                this.name = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("title");
            if (columnIndex3 != -1) {
                this.title = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("url");
            if (columnIndex4 != -1) {
                this.url = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("savePath");
            if (columnIndex5 != -1) {
                this.savePath = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("tempPath");
            if (columnIndex6 != -1) {
                this.tempPath = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("chunkCount");
            if (columnIndex7 != -1) {
                this.chunkCount = cursor.getInt(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex("status");
            if (columnIndex8 != -1) {
                this.status = new AtomicInteger(cursor.getInt(columnIndex8));
            } else {
                this.status = new AtomicInteger(0);
            }
            int columnIndex9 = cursor.getColumnIndex("curBytes");
            if (columnIndex9 != -1) {
                this.curBytes = new AtomicLong(cursor.getLong(columnIndex9));
            } else {
                this.curBytes = new AtomicLong(0L);
            }
            int columnIndex10 = cursor.getColumnIndex("totalBytes");
            if (columnIndex10 != -1) {
                this.totalBytes = cursor.getLong(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("eTag");
            if (columnIndex11 != -1) {
                this.eTag = cursor.getString(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("onlyWifi");
            if (columnIndex12 != -1) {
                this.onlyWifi = cursor.getInt(columnIndex12) != 0;
            }
            int columnIndex13 = cursor.getColumnIndex("force");
            if (columnIndex13 != -1) {
                this.force = cursor.getInt(columnIndex13) != 0;
            }
            int columnIndex14 = cursor.getColumnIndex("retryCount");
            if (columnIndex14 != -1) {
                this.retryCount = cursor.getInt(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex("extra");
            if (columnIndex15 != -1) {
                this.extra = cursor.getString(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("mimeType");
            if (columnIndex16 != -1) {
                this.mimeType = cursor.getString(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex("notificationEnable");
            if (columnIndex17 != -1) {
                this.showNotification = cursor.getInt(columnIndex17) != 0;
            }
            int columnIndex18 = cursor.getColumnIndex("notificationVisibility");
            if (columnIndex18 != -1) {
                this.notificationVisibility = cursor.getInt(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex("isFirstDownload");
            if (columnIndex19 != -1) {
                this.isFirstDownload = cursor.getInt(columnIndex19) == 1;
            }
            int columnIndex20 = cursor.getColumnIndex("isFirstSuccess");
            if (columnIndex20 != -1) {
                this.isFirstSuccess = cursor.getInt(columnIndex20) == 1;
            }
            int columnIndex21 = cursor.getColumnIndex("needHttpsToHttpRetry");
            if (columnIndex21 != -1) {
                this.needHttpsToHttpRetry = cursor.getInt(columnIndex21) == 1;
            }
            int columnIndex22 = cursor.getColumnIndex("downloadTime");
            if (columnIndex22 != -1) {
                this.downloadTime = cursor.getLong(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex("packageName");
            if (columnIndex23 != -1) {
                this.packageName = cursor.getString(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex("md5");
            if (columnIndex24 != -1) {
                this.md5 = cursor.getString(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex("retryDelay");
            if (columnIndex25 != -1) {
                this.needRetryDelay = cursor.getInt(columnIndex25) == 1;
            }
            int columnIndex26 = cursor.getColumnIndex("curRetryTime");
            if (columnIndex26 != -1) {
                this.curRetryTime = cursor.getInt(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex("retryDelayStatus");
            if (columnIndex27 != -1) {
                int i4 = cursor.getInt(columnIndex27);
                h hVar2 = h.DELAY_RETRY_WAITING;
                if (i4 == hVar2.ordinal()) {
                    this.retryDelayStatus = hVar2;
                } else {
                    h hVar3 = h.DELAY_RETRY_DOWNLOADING;
                    if (i4 == hVar3.ordinal()) {
                        this.retryDelayStatus = hVar3;
                    } else {
                        h hVar4 = h.DELAY_RETRY_DOWNLOADED;
                        if (i4 == hVar4.ordinal()) {
                            this.retryDelayStatus = hVar4;
                        } else {
                            this.retryDelayStatus = hVar;
                        }
                    }
                }
            }
            int columnIndex28 = cursor.getColumnIndex("defaultHttpServiceBackUp");
            if (columnIndex28 != -1) {
                this.needDefaultHttpServiceBackUp = cursor.getInt(columnIndex28) == 1;
            }
            int columnIndex29 = cursor.getColumnIndex("chunkRunnableReuse");
            if (columnIndex29 != -1) {
                this.needReuseChunkRunnable = cursor.getInt(columnIndex29) == 1;
            }
            int columnIndex30 = cursor.getColumnIndex("retryDelayTimeArray");
            if (columnIndex30 != -1) {
                this.retryDelayTimeArray = cursor.getString(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex("chunkDowngradeRetry");
            if (columnIndex31 != -1) {
                this.needChunkDowngradeRetry = cursor.getInt(columnIndex31) == 1;
            }
            int columnIndex32 = cursor.getColumnIndex("backUpUrlsStr");
            if (columnIndex32 != -1) {
                setBackUpUrlsStr(cursor.getString(columnIndex32));
            }
            int columnIndex33 = cursor.getColumnIndex("backUpUrlRetryCount");
            if (columnIndex33 != -1) {
                this.backUpUrlRetryCount = cursor.getInt(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex("realDownloadTime");
            if (columnIndex34 != -1) {
                this.realDownloadTime = cursor.getLong(columnIndex34);
            }
            int columnIndex35 = cursor.getColumnIndex("retryScheduleMinutes");
            if (columnIndex35 != -1) {
                this.retryScheduleMinutes = cursor.getInt(columnIndex35);
            }
            int columnIndex36 = cursor.getColumnIndex("independentProcess");
            if (columnIndex36 != -1) {
                if (cursor.getInt(columnIndex36) != 1) {
                    z3 = false;
                }
                this.needIndependentProcess = z3;
            }
            int columnIndex37 = cursor.getColumnIndex("auxiliaryJsonobjectString");
            if (columnIndex37 != -1) {
                this.dbJsonDataString = cursor.getString(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex("iconUrl");
            if (columnIndex38 != -1) {
                this.iconUrl = cursor.getString(columnIndex38);
            }
            int columnIndex39 = cursor.getColumnIndex("appVersionCode");
            if (columnIndex39 != -1) {
                this.appVersionCode = cursor.getInt(columnIndex39);
            }
            int columnIndex40 = cursor.getColumnIndex("taskId");
            if (columnIndex40 != -1) {
                this.taskId = cursor.getString(columnIndex40);
            }
            parseMonitorSetting();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
