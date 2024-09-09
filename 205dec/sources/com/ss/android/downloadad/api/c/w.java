package com.ss.android.downloadad.api.c;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements c {

    /* renamed from: a  reason: collision with root package name */
    private String f48282a;
    private boolean au;

    /* renamed from: b  reason: collision with root package name */
    private boolean f48283b;
    private long ba;
    private boolean bj;
    private int bk;
    private String bm;
    private String bw;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f48284c;
    private long ck;
    private int eq;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private long f48285f;
    private boolean fm;
    private int fp;
    private String fz;
    private int gb;
    private String gd;
    private boolean ge;
    private boolean gw;

    /* renamed from: h  reason: collision with root package name */
    private boolean f48286h;

    /* renamed from: i  reason: collision with root package name */
    private long f48287i;
    private String ia;

    /* renamed from: j  reason: collision with root package name */
    private int f48288j;

    /* renamed from: k  reason: collision with root package name */
    private String f48289k;
    private boolean ls;

    /* renamed from: m  reason: collision with root package name */
    private boolean f48290m;
    private String me;
    private long mt;

    /* renamed from: n  reason: collision with root package name */
    private int f48291n;
    private transient boolean ng;
    private boolean oh;
    private boolean ok;
    private long oo;
    private boolean ox;

    /* renamed from: p  reason: collision with root package name */
    private String f48292p;
    private boolean pr;

    /* renamed from: q  reason: collision with root package name */
    private JSONObject f48293q;

    /* renamed from: r  reason: collision with root package name */
    private String f48294r;

    /* renamed from: s  reason: collision with root package name */
    private String f48295s;
    public final AtomicBoolean sr;

    /* renamed from: t  reason: collision with root package name */
    private int f48296t;
    private String ta;
    private boolean te;

    /* renamed from: u  reason: collision with root package name */
    private boolean f48297u;
    @AdBaseConstants.FunnelType
    private int up;
    private long ux;
    private int vc;

    /* renamed from: w  reason: collision with root package name */
    protected boolean f48298w;
    private boolean wo;
    private boolean wv;
    private boolean wx;

    /* renamed from: x  reason: collision with root package name */
    private String f48299x;
    private String xk;
    private long xu;
    public final AtomicBoolean xv;

    /* renamed from: y  reason: collision with root package name */
    private int f48300y;
    private int ys;
    private boolean yu;

    /* renamed from: z  reason: collision with root package name */
    private long f48301z;

    private w() {
        this.ev = 1;
        this.f48297u = true;
        this.ls = false;
        this.gb = 0;
        this.f48291n = 0;
        this.wv = false;
        this.yu = false;
        this.wx = true;
        this.pr = true;
        this.f48284c = true;
        this.f48298w = true;
        this.xv = new AtomicBoolean(false);
        this.sr = new AtomicBoolean(false);
        this.up = 1;
        this.au = true;
        this.xu = -1L;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public long a() {
        return this.f48285f;
    }

    public long au() {
        return this.mt;
    }

    public String b() {
        return this.xk;
    }

    public long ba() {
        return this.f48301z;
    }

    public AdDownloadController be() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.ls).setLinkMode(this.f48296t).setDownloadMode(this.ys).setEnableShowComplianceDialog(this.au).setEnableAH(this.f48284c).setEnableAM(this.f48298w).build();
    }

    public long bj() {
        return this.oo;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public boolean bk() {
        return this.f48290m;
    }

    public boolean bm() {
        return this.wv;
    }

    public boolean bw() {
        return this.ls;
    }

    public void c(int i4) {
        this.gb = i4;
    }

    public synchronized void ck() {
        this.f48291n++;
    }

    public int eq() {
        return this.eq;
    }

    public AdDownloadEventConfig eu() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.bw).setRefer(this.f48299x).setIsEnableV3Event(this.f48290m).build();
    }

    public void ev(int i4) {
        this.vc = i4;
    }

    public void f(long j4) {
        if (j4 > 0) {
            this.f48287i = j4;
        }
    }

    public boolean fm() {
        return this.ge;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public JSONObject fp() {
        return null;
    }

    public void fp(boolean z3) {
        this.au = z3;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public int fz() {
        return this.f48288j;
    }

    public synchronized void gb() {
        this.gb++;
    }

    public void gd(int i4) {
        this.up = i4;
    }

    public JSONObject ge() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.ux);
            jSONObject.put("mExtValue", this.f48285f);
            jSONObject.put("mLogExtra", this.f48294r);
            jSONObject.put("mDownloadStatus", this.ev);
            jSONObject.put("mPackageName", this.gd);
            jSONObject.put("mIsAd", this.f48297u);
            jSONObject.put("mTimeStamp", this.f48287i);
            jSONObject.put("mExtras", this.f48293q);
            jSONObject.put("mVersionCode", this.fp);
            jSONObject.put("mVersionName", this.ia);
            jSONObject.put("mDownloadId", this.f48288j);
            jSONObject.put("mIsV3Event", this.f48290m);
            jSONObject.put("mScene", this.vc);
            jSONObject.put("mEventTag", this.bw);
            jSONObject.put("mEventRefer", this.f48299x);
            jSONObject.put("mDownloadUrl", this.f48292p);
            jSONObject.put("mEnableBackDialog", this.ls);
            jSONObject.put("hasSendInstallFinish", this.xv.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.sr.get());
            jSONObject.put("mLastFailedErrCode", this.eq);
            jSONObject.put("mLastFailedErrMsg", this.me);
            jSONObject.put("mOpenUrl", this.f48289k);
            jSONObject.put("mLinkMode", this.f48296t);
            jSONObject.put("mDownloadMode", this.ys);
            jSONObject.put("mModelType", this.bk);
            jSONObject.put("mAppName", this.f48295s);
            jSONObject.put("mAppIcon", this.fz);
            jSONObject.put("mDownloadFailedTimes", this.gb);
            long j4 = this.ck;
            if (j4 == 0) {
                j4 = this.f48287i;
            }
            jSONObject.put("mRecentDownloadResumeTime", j4);
            jSONObject.put("mClickPauseTimes", this.f48291n);
            jSONObject.put("mJumpInstallTime", this.f48301z);
            jSONObject.put("mCancelInstallTime", this.ba);
            jSONObject.put("mLastFailedResumeCount", this.f48300y);
            jSONObject.put("mIsUpdateDownload", this.wv);
            jSONObject.put("mOriginMimeType", this.xk);
            jSONObject.put("mIsPatchApplyHandled", this.yu);
            jSONObject.put("downloadFinishReason", this.bm);
            jSONObject.put("clickDownloadTime", this.mt);
            jSONObject.put("clickDownloadSize", this.oo);
            jSONObject.put("installAfterCleanSpace", this.gw);
            jSONObject.put("funnelType", this.up);
            jSONObject.put("webUrl", this.f48282a);
            jSONObject.put("enableShowComplianceDialog", this.au);
            jSONObject.put("isAutoDownloadOnCardShow", this.bj);
            int i4 = 1;
            jSONObject.put("enable_new_activity", this.wx ? 1 : 0);
            jSONObject.put("enable_pause", this.pr ? 1 : 0);
            jSONObject.put("enable_ah", this.f48284c ? 1 : 0);
            if (!this.f48298w) {
                i4 = 0;
            }
            jSONObject.put("enable_am", i4);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.ge));
            jSONObject.put("task_key", this.ta);
        } catch (Exception e4) {
            k.u().c(e4, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public int gw() {
        return this.f48296t;
    }

    public boolean h() {
        return this.fm;
    }

    public void i(boolean z3) {
        this.f48298w = z3;
    }

    public void ia(boolean z3) {
        this.bj = z3;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public DownloadController j() {
        return be();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public JSONObject k() {
        return null;
    }

    public void k(String str) {
        this.fz = str;
    }

    public int ls() {
        return this.gb;
    }

    public String m() {
        return this.f48295s;
    }

    public String me() {
        return this.me;
    }

    public boolean mt() {
        return this.gw;
    }

    public int n() {
        return this.f48291n;
    }

    public boolean ng() {
        return this.oh;
    }

    public boolean oh() {
        return this.te;
    }

    public boolean ok() {
        return this.f48286h;
    }

    public boolean oo() {
        return this.ox;
    }

    public boolean ox() {
        return this.ng;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String p() {
        return this.bw;
    }

    public int pr() {
        return this.vc;
    }

    public void q(boolean z3) {
        this.ge = z3;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public JSONObject r() {
        return this.f48293q;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public JSONObject s() {
        return null;
    }

    public void s(boolean z3) {
        this.wx = z3;
    }

    public void sr(int i4) {
        this.eq = i4;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public List<String> t() {
        return null;
    }

    public void t(boolean z3) {
        this.fm = z3;
    }

    public AdDownloadModel ta() {
        return new AdDownloadModel.Builder().setAdId(this.ux).setExtraValue(this.f48285f).setLogExtra(this.f48294r).setPackageName(this.gd).setExtra(this.f48293q).setIsAd(this.f48297u).setVersionCode(this.fp).setVersionName(this.ia).setDownloadUrl(this.f48292p).setModelType(this.bk).setMimeType(this.xk).setAppName(this.f48295s).setAppIcon(this.fz).setTaskKey(this.ta).setDeepLink(new DeepLink(this.f48289k, this.f48282a, null)).build();
    }

    public String te() {
        return this.ta;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public int u() {
        return -1;
    }

    public void u(boolean z3) {
        this.f48284c = z3;
    }

    public boolean up() {
        return this.wo;
    }

    public void ux(long j4) {
        this.f48285f = j4;
    }

    public String vc() {
        return this.bm;
    }

    public void w(int i4) {
        this.f48291n = i4;
    }

    public boolean wo() {
        return this.yu;
    }

    public int wv() {
        return this.ev;
    }

    public String wx() {
        return this.ia;
    }

    public long x() {
        return this.xu;
    }

    public long xk() {
        return this.f48287i;
    }

    public boolean xu() {
        return this.ok;
    }

    public void xv(long j4) {
        this.ba = j4;
    }

    public int y() {
        return this.f48300y;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public Object ys() {
        return null;
    }

    public void ys(boolean z3) {
        this.te = z3;
    }

    public int yu() {
        return this.fp;
    }

    public long z() {
        long j4 = this.ck;
        return j4 == 0 ? this.f48287i : j4;
    }

    public void a(int i4) {
        this.bk = i4;
    }

    public void bk(String str) {
        this.xk = str;
    }

    public void c(long j4) {
        this.ck = j4;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public int ev() {
        return this.up;
    }

    public void f(int i4) {
        this.fp = i4;
    }

    public void fz(boolean z3) {
        this.pr = z3;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String gd() {
        return this.f48299x;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public DownloadModel i() {
        return ta();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public boolean ia() {
        return this.wx;
    }

    public void k(int i4) {
        this.ys = i4;
    }

    public void p(String str) {
        this.f48295s = str;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public DownloadEventConfig q() {
        return eu();
    }

    public void r(int i4) {
        this.f48288j = i4;
    }

    public void sr(long j4) {
        this.ux = j4;
    }

    public void t(String str) {
        this.ta = str;
    }

    public void ux(int i4) {
        this.ev = i4;
    }

    public void w(long j4) {
        this.f48301z = j4;
    }

    public void xv(int i4) {
        this.f48300y = i4;
    }

    public void a(String str) {
        this.bm = str;
    }

    public void bk(boolean z3) {
        this.f48286h = z3;
    }

    public void c(String str) {
        this.me = str;
    }

    public void ev(String str) {
        this.f48292p = str;
    }

    public void f(String str) {
        this.bw = str;
    }

    public void gd(String str) {
        this.f48289k = str;
    }

    public void k(boolean z3) {
        this.ok = z3;
    }

    public void p(int i4) {
        this.f48296t = i4;
    }

    public void r(String str) {
        this.f48299x = str;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String sr() {
        return this.f48294r;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String ux() {
        return this.gd;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public long w() {
        return this.ux;
    }

    public void xv(String str) {
        this.f48294r = str;
    }

    public void a(boolean z3) {
        this.oh = z3;
    }

    public void c(boolean z3) {
        this.f48297u = z3;
    }

    public void ev(long j4) {
        this.mt = j4;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String f() {
        return this.f48289k;
    }

    public void gd(long j4) {
        this.oo = j4;
    }

    public void p(boolean z3) {
        this.ng = z3;
    }

    public void r(long j4) {
        this.xu = j4;
    }

    public void sr(String str) {
        this.ia = str;
    }

    public void ux(String str) {
        this.f48282a = str;
    }

    public void w(String str) {
        this.gd = str;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public boolean xv() {
        return this.f48297u;
    }

    public void c(JSONObject jSONObject) {
        this.f48293q = jSONObject;
    }

    public void ev(boolean z3) {
        this.wv = z3;
    }

    public void f(boolean z3) {
        this.gw = z3;
    }

    public void gd(boolean z3) {
        this.yu = z3;
    }

    public void r(boolean z3) {
        this.ox = z3;
    }

    public void sr(boolean z3) {
        this.f48283b = z3;
    }

    public void ux(boolean z3) {
        this.wo = z3;
    }

    public void w(boolean z3) {
        this.f48290m = z3;
    }

    public void xv(boolean z3) {
        this.ls = z3;
    }

    public static w w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        w wVar = new w();
        try {
            wVar.sr(com.ss.android.download.api.xv.w.c(jSONObject, "mId"));
            wVar.ux(com.ss.android.download.api.xv.w.c(jSONObject, "mExtValue"));
            wVar.xv(jSONObject.optString("mLogExtra"));
            wVar.ux(jSONObject.optInt("mDownloadStatus"));
            wVar.w(jSONObject.optString("mPackageName"));
            boolean z3 = true;
            wVar.c(jSONObject.optBoolean("mIsAd", true));
            wVar.f(com.ss.android.download.api.xv.w.c(jSONObject, "mTimeStamp"));
            wVar.f(jSONObject.optInt("mVersionCode"));
            wVar.sr(jSONObject.optString("mVersionName"));
            wVar.r(jSONObject.optInt("mDownloadId"));
            wVar.w(jSONObject.optBoolean("mIsV3Event"));
            wVar.ev(jSONObject.optInt("mScene"));
            wVar.f(jSONObject.optString("mEventTag"));
            wVar.r(jSONObject.optString("mEventRefer"));
            wVar.ev(jSONObject.optString("mDownloadUrl"));
            wVar.xv(jSONObject.optBoolean("mEnableBackDialog"));
            wVar.xv.set(jSONObject.optBoolean("hasSendInstallFinish"));
            wVar.sr.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            wVar.sr(jSONObject.optInt("mLastFailedErrCode"));
            wVar.c(jSONObject.optString("mLastFailedErrMsg"));
            wVar.gd(jSONObject.optString("mOpenUrl"));
            wVar.p(jSONObject.optInt("mLinkMode"));
            wVar.k(jSONObject.optInt("mDownloadMode"));
            wVar.a(jSONObject.optInt("mModelType"));
            wVar.p(jSONObject.optString("mAppName"));
            wVar.k(jSONObject.optString("mAppIcon"));
            wVar.c(jSONObject.optInt("mDownloadFailedTimes", 0));
            wVar.c(com.ss.android.download.api.xv.w.c(jSONObject, "mRecentDownloadResumeTime"));
            wVar.w(jSONObject.optInt("mClickPauseTimes"));
            wVar.w(com.ss.android.download.api.xv.w.c(jSONObject, "mJumpInstallTime"));
            wVar.xv(com.ss.android.download.api.xv.w.c(jSONObject, "mCancelInstallTime"));
            wVar.xv(jSONObject.optInt("mLastFailedResumeCount"));
            wVar.a(jSONObject.optString("downloadFinishReason"));
            wVar.gd(jSONObject.optLong("clickDownloadSize"));
            wVar.ev(jSONObject.optLong("clickDownloadTime"));
            wVar.ev(jSONObject.optBoolean("mIsUpdateDownload"));
            wVar.bk(jSONObject.optString("mOriginMimeType"));
            wVar.gd(jSONObject.optBoolean("mIsPatchApplyHandled"));
            wVar.f(jSONObject.optBoolean("installAfterCleanSpace"));
            wVar.gd(jSONObject.optInt("funnelType", 1));
            wVar.ux(jSONObject.optString("webUrl"));
            wVar.fp(jSONObject.optBoolean("enableShowComplianceDialog", true));
            wVar.ia(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            wVar.s(jSONObject.optInt("enable_new_activity", 1) == 1);
            wVar.fz(jSONObject.optInt("enable_pause", 1) == 1);
            wVar.u(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z3 = false;
            }
            wVar.i(z3);
            wVar.c(jSONObject.optJSONObject("mExtras"));
            wVar.q(jSONObject.optBoolean("intent_jump_browser_success"));
            wVar.t(jSONObject.optString("task_key"));
        } catch (Exception e4) {
            k.u().c(e4, "NativeDownloadModel fromJson");
        }
        return wVar;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String c() {
        return this.f48292p;
    }

    public w(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public w(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i4) {
        this.ev = 1;
        this.f48297u = true;
        this.ls = false;
        this.gb = 0;
        this.f48291n = 0;
        this.wv = false;
        this.yu = false;
        this.wx = true;
        this.pr = true;
        this.f48284c = true;
        this.f48298w = true;
        this.xv = new AtomicBoolean(false);
        this.sr = new AtomicBoolean(false);
        this.up = 1;
        this.au = true;
        this.xu = -1L;
        this.ux = downloadModel.getId();
        this.f48285f = downloadModel.getExtraValue();
        this.f48294r = downloadModel.getLogExtra();
        this.gd = downloadModel.getPackageName();
        this.f48293q = downloadModel.getExtra();
        this.f48297u = downloadModel.isAd();
        this.fp = downloadModel.getVersionCode();
        this.ia = downloadModel.getVersionName();
        this.f48292p = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.f48289k = downloadModel.getDeepLink().getOpenUrl();
            this.f48282a = downloadModel.getDeepLink().getWebUrl();
        }
        this.bk = downloadModel.getModelType();
        this.f48295s = downloadModel.getName();
        this.fz = downloadModel.getAppIcon();
        this.xk = downloadModel.getMimeType();
        this.bw = downloadEventConfig.getClickButtonTag();
        this.f48299x = downloadEventConfig.getRefer();
        this.f48290m = downloadEventConfig.isEnableV3Event();
        this.ls = downloadController.isEnableBackDialog();
        this.f48296t = downloadController.getLinkMode();
        this.ys = downloadController.getDownloadMode();
        this.au = downloadController.enableShowComplianceDialog();
        this.bj = downloadController.isAutoDownloadOnCardShow();
        this.wx = downloadController.enableNewActivity();
        this.f48284c = downloadController.enableAH();
        this.f48298w = downloadController.enableAM();
        this.f48288j = i4;
        long currentTimeMillis = System.currentTimeMillis();
        this.f48287i = currentTimeMillis;
        this.ck = currentTimeMillis;
        this.yu = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.ta = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
