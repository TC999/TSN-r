package com.ss.android.downloadad.api.ok;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.r;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements ok {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f48302a;
    private boolean ah;
    public final AtomicBoolean bl;
    private long cf;
    private String cs;

    /* renamed from: d  reason: collision with root package name */
    private String f48303d;
    private boolean de;
    private boolean dn;
    private boolean dx;

    /* renamed from: e  reason: collision with root package name */
    private String f48304e;
    private long ej;
    private boolean em;
    private int ep;
    private long er;
    private transient boolean ew;
    private int fb;
    private boolean fd;
    private boolean fl;

    /* renamed from: g  reason: collision with root package name */
    private int f48305g;

    /* renamed from: h  reason: collision with root package name */
    private String f48306h;

    /* renamed from: i  reason: collision with root package name */
    private int f48307i;

    /* renamed from: io  reason: collision with root package name */
    private long f48308io;

    /* renamed from: j  reason: collision with root package name */
    private String f48309j;
    private boolean ju;

    /* renamed from: k  reason: collision with root package name */
    private String f48310k;
    private long kf;
    private long kz;

    /* renamed from: l  reason: collision with root package name */
    private boolean f48311l;
    private boolean ld;

    /* renamed from: m  reason: collision with root package name */
    private int f48312m;

    /* renamed from: n  reason: collision with root package name */
    private long f48313n;

    /* renamed from: o  reason: collision with root package name */
    private int f48314o;
    protected boolean ok;

    /* renamed from: p  reason: collision with root package name */
    private int f48315p;

    /* renamed from: q  reason: collision with root package name */
    private String f48316q;
    private String qu;
    private boolean qx;

    /* renamed from: r  reason: collision with root package name */
    private String f48317r;
    private int rh;
    private boolean ry;

    /* renamed from: s  reason: collision with root package name */
    public final AtomicBoolean f48318s;
    private boolean sg;

    /* renamed from: t  reason: collision with root package name */
    private int f48319t;
    private String td;
    private boolean tg;
    private boolean to;
    private boolean tr;

    /* renamed from: u  reason: collision with root package name */
    private boolean f48320u;
    private JSONObject ul;

    /* renamed from: v  reason: collision with root package name */
    private String f48321v;
    @AdBaseConstants.FunnelType
    private int vk;
    private long vz;

    /* renamed from: w  reason: collision with root package name */
    private boolean f48322w;
    private int wv;

    /* renamed from: x  reason: collision with root package name */
    private String f48323x;
    private String xy;

    /* renamed from: y  reason: collision with root package name */
    private boolean f48324y;
    private long yt;

    /* renamed from: z  reason: collision with root package name */
    private int f48325z;
    private String zz;

    private a() {
        this.f48315p = 1;
        this.f48320u = true;
        this.f48324y = false;
        this.f48312m = 0;
        this.ep = 0;
        this.fl = false;
        this.fd = false;
        this.em = true;
        this.sg = true;
        this.ok = true;
        this.f48302a = true;
        this.bl = new AtomicBoolean(false);
        this.f48318s = new AtomicBoolean(false);
        this.vk = 1;
        this.qx = true;
        this.cf = -1L;
    }

    public void a(int i4) {
        this.ep = i4;
    }

    public String ah() {
        return this.td;
    }

    public void bl(long j4) {
        this.er = j4;
    }

    public AdDownloadController c() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.f48324y).setLinkMode(this.rh).setDownloadMode(this.f48319t).setEnableShowComplianceDialog(this.qx).setEnableAH(this.ok).setEnableAM(this.f48302a).build();
    }

    public boolean cf() {
        return this.ry;
    }

    public boolean cs() {
        return this.fl;
    }

    public AdDownloadModel d() {
        return new AdDownloadModel.Builder().setAdId(this.f48313n).setExtraValue(this.kf).setLogExtra(this.f48306h).setPackageName(this.f48316q).setExtra(this.ul).setIsAd(this.f48320u).setVersionCode(this.f48307i).setVersionName(this.f48323x).setDownloadUrl(this.f48310k).setModelType(this.f48325z).setMimeType(this.f48304e).setAppName(this.td).setAppIcon(this.zz).setTaskKey(this.f48303d).setDeepLink(new DeepLink(this.f48317r, this.f48309j, null)).build();
    }

    public boolean de() {
        return this.to;
    }

    public boolean dn() {
        return this.ld;
    }

    public boolean dx() {
        return this.ew;
    }

    public long e() {
        return this.f48308io;
    }

    public boolean ej() {
        return this.dx;
    }

    public String em() {
        return this.f48323x;
    }

    public int ep() {
        return this.ep;
    }

    public long er() {
        return this.kz;
    }

    public boolean ew() {
        return this.dn;
    }

    public int fb() {
        return this.fb;
    }

    public int fd() {
        return this.f48307i;
    }

    public int fl() {
        return this.f48315p;
    }

    public int g() {
        return this.f48305g;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject h() {
        return this.ul;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject i() {
        return null;
    }

    public void i(boolean z3) {
        this.qx = z3;
    }

    public void io(boolean z3) {
        this.f48302a = z3;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public long j() {
        return this.kf;
    }

    public JSONObject ju() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.f48313n);
            jSONObject.put("mExtValue", this.kf);
            jSONObject.put("mLogExtra", this.f48306h);
            jSONObject.put("mDownloadStatus", this.f48315p);
            jSONObject.put("mPackageName", this.f48316q);
            jSONObject.put("mIsAd", this.f48320u);
            jSONObject.put("mTimeStamp", this.f48308io);
            jSONObject.put("mExtras", this.ul);
            jSONObject.put("mVersionCode", this.f48307i);
            jSONObject.put("mVersionName", this.f48323x);
            jSONObject.put("mDownloadId", this.f48314o);
            jSONObject.put("mIsV3Event", this.ah);
            jSONObject.put("mScene", this.wv);
            jSONObject.put("mEventTag", this.qu);
            jSONObject.put("mEventRefer", this.xy);
            jSONObject.put("mDownloadUrl", this.f48310k);
            jSONObject.put("mEnableBackDialog", this.f48324y);
            jSONObject.put("hasSendInstallFinish", this.bl.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.f48318s.get());
            jSONObject.put("mLastFailedErrCode", this.f48305g);
            jSONObject.put("mLastFailedErrMsg", this.f48321v);
            jSONObject.put("mOpenUrl", this.f48317r);
            jSONObject.put("mLinkMode", this.rh);
            jSONObject.put("mDownloadMode", this.f48319t);
            jSONObject.put("mModelType", this.f48325z);
            jSONObject.put("mAppName", this.td);
            jSONObject.put("mAppIcon", this.zz);
            jSONObject.put("mDownloadFailedTimes", this.f48312m);
            long j4 = this.vz;
            if (j4 == 0) {
                j4 = this.f48308io;
            }
            jSONObject.put("mRecentDownloadResumeTime", j4);
            jSONObject.put("mClickPauseTimes", this.ep);
            jSONObject.put("mJumpInstallTime", this.kz);
            jSONObject.put("mCancelInstallTime", this.er);
            jSONObject.put("mLastFailedResumeCount", this.fb);
            jSONObject.put("mIsUpdateDownload", this.fl);
            jSONObject.put("mOriginMimeType", this.f48304e);
            jSONObject.put("mIsPatchApplyHandled", this.fd);
            jSONObject.put("downloadFinishReason", this.cs);
            jSONObject.put("clickDownloadTime", this.yt);
            jSONObject.put("clickDownloadSize", this.ej);
            jSONObject.put("installAfterCleanSpace", this.f48311l);
            jSONObject.put("funnelType", this.vk);
            jSONObject.put("webUrl", this.f48309j);
            jSONObject.put("enableShowComplianceDialog", this.qx);
            jSONObject.put("isAutoDownloadOnCardShow", this.tr);
            int i4 = 1;
            jSONObject.put("enable_new_activity", this.em ? 1 : 0);
            jSONObject.put("enable_pause", this.sg ? 1 : 0);
            jSONObject.put("enable_ah", this.ok ? 1 : 0);
            if (!this.f48302a) {
                i4 = 0;
            }
            jSONObject.put("enable_am", i4);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.ju));
            jSONObject.put("task_key", this.f48303d);
        } catch (Exception e4) {
            r.u().ok(e4, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String k() {
        return this.qu;
    }

    public void kf(long j4) {
        if (j4 > 0) {
            this.f48308io = j4;
        }
    }

    public long kz() {
        long j4 = this.vz;
        return j4 == 0 ? this.f48308io : j4;
    }

    public int l() {
        return this.rh;
    }

    public String ld() {
        return this.f48303d;
    }

    public synchronized void m() {
        this.f48312m++;
    }

    public void n(long j4) {
        this.kf = j4;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadController o() {
        return c();
    }

    public void ok(int i4) {
        this.f48312m = i4;
    }

    public void p(int i4) {
        this.wv = i4;
    }

    public void q(int i4) {
        this.vk = i4;
    }

    public boolean qu() {
        return this.f48324y;
    }

    public long qx() {
        return this.yt;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject r() {
        return null;
    }

    public void r(String str) {
        this.zz = str;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public List<String> rh() {
        return null;
    }

    public void rh(boolean z3) {
        this.to = z3;
    }

    public boolean ry() {
        return this.de;
    }

    public void s(int i4) {
        this.f48305g = i4;
    }

    public int sg() {
        return this.wv;
    }

    public AdDownloadEventConfig sr() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.qu).setRefer(this.xy).setIsEnableV3Event(this.ah).build();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public Object t() {
        return null;
    }

    public void t(boolean z3) {
        this.ld = z3;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject td() {
        return null;
    }

    public void td(boolean z3) {
        this.em = z3;
    }

    public boolean tg() {
        return this.fd;
    }

    public boolean to() {
        return this.ju;
    }

    public long tr() {
        return this.ej;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int u() {
        return -1;
    }

    public void u(boolean z3) {
        this.ok = z3;
    }

    public void ul(boolean z3) {
        this.ju = z3;
    }

    public String v() {
        return this.f48321v;
    }

    public boolean vk() {
        return this.tg;
    }

    public synchronized void vz() {
        this.ep++;
    }

    public String w() {
        return this.f48304e;
    }

    public String wv() {
        return this.cs;
    }

    public void x(boolean z3) {
        this.tr = z3;
    }

    public long xy() {
        return this.cf;
    }

    public int y() {
        return this.f48312m;
    }

    public boolean yt() {
        return this.f48311l;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean z() {
        return this.ah;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int zz() {
        return this.f48314o;
    }

    public void a(long j4) {
        this.kz = j4;
    }

    public void bl(int i4) {
        this.fb = i4;
    }

    public void h(int i4) {
        this.f48314o = i4;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadModel io() {
        return d();
    }

    public void j(int i4) {
        this.f48325z = i4;
    }

    public void k(String str) {
        this.td = str;
    }

    public void kf(int i4) {
        this.f48307i = i4;
    }

    public void n(int i4) {
        this.f48315p = i4;
    }

    public void ok(long j4) {
        this.vz = j4;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int p() {
        return this.vk;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String q() {
        return this.xy;
    }

    public void r(int i4) {
        this.f48319t = i4;
    }

    public void rh(String str) {
        this.f48303d = str;
    }

    public void s(long j4) {
        this.f48313n = j4;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadEventConfig ul() {
        return sr();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean x() {
        return this.em;
    }

    public void z(String str) {
        this.f48304e = str;
    }

    public void zz(boolean z3) {
        this.sg = z3;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public long a() {
        return this.f48313n;
    }

    public void bl(String str) {
        this.f48306h = str;
    }

    public void h(String str) {
        this.xy = str;
    }

    public void j(String str) {
        this.cs = str;
    }

    public void k(int i4) {
        this.rh = i4;
    }

    public void kf(String str) {
        this.qu = str;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String n() {
        return this.f48316q;
    }

    public void ok(String str) {
        this.f48321v = str;
    }

    public void p(String str) {
        this.f48310k = str;
    }

    public void q(String str) {
        this.f48317r = str;
    }

    public void r(boolean z3) {
        this.ry = z3;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String s() {
        return this.f48306h;
    }

    public void z(boolean z3) {
        this.de = z3;
    }

    public void a(String str) {
        this.f48316q = str;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean bl() {
        return this.f48320u;
    }

    public void h(long j4) {
        this.cf = j4;
    }

    public void j(boolean z3) {
        this.dn = z3;
    }

    public void k(boolean z3) {
        this.ew = z3;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String kf() {
        return this.f48317r;
    }

    public void n(String str) {
        this.f48309j = str;
    }

    public void ok(boolean z3) {
        this.f48320u = z3;
    }

    public void p(long j4) {
        this.yt = j4;
    }

    public void q(long j4) {
        this.ej = j4;
    }

    public void s(String str) {
        this.f48323x = str;
    }

    public void a(boolean z3) {
        this.ah = z3;
    }

    public void bl(boolean z3) {
        this.f48324y = z3;
    }

    public void h(boolean z3) {
        this.dx = z3;
    }

    public void kf(boolean z3) {
        this.f48311l = z3;
    }

    public void n(boolean z3) {
        this.tg = z3;
    }

    public void ok(JSONObject jSONObject) {
        this.ul = jSONObject;
    }

    public void p(boolean z3) {
        this.fl = z3;
    }

    public void q(boolean z3) {
        this.fd = z3;
    }

    public void s(boolean z3) {
        this.f48322w = z3;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.s(com.ss.android.download.api.bl.a.ok(jSONObject, "mId"));
            aVar.n(com.ss.android.download.api.bl.a.ok(jSONObject, "mExtValue"));
            aVar.bl(jSONObject.optString("mLogExtra"));
            aVar.n(jSONObject.optInt("mDownloadStatus"));
            aVar.a(jSONObject.optString("mPackageName"));
            boolean z3 = true;
            aVar.ok(jSONObject.optBoolean("mIsAd", true));
            aVar.kf(com.ss.android.download.api.bl.a.ok(jSONObject, "mTimeStamp"));
            aVar.kf(jSONObject.optInt("mVersionCode"));
            aVar.s(jSONObject.optString("mVersionName"));
            aVar.h(jSONObject.optInt("mDownloadId"));
            aVar.a(jSONObject.optBoolean("mIsV3Event"));
            aVar.p(jSONObject.optInt("mScene"));
            aVar.kf(jSONObject.optString("mEventTag"));
            aVar.h(jSONObject.optString("mEventRefer"));
            aVar.p(jSONObject.optString("mDownloadUrl"));
            aVar.bl(jSONObject.optBoolean("mEnableBackDialog"));
            aVar.bl.set(jSONObject.optBoolean("hasSendInstallFinish"));
            aVar.f48318s.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            aVar.s(jSONObject.optInt("mLastFailedErrCode"));
            aVar.ok(jSONObject.optString("mLastFailedErrMsg"));
            aVar.q(jSONObject.optString("mOpenUrl"));
            aVar.k(jSONObject.optInt("mLinkMode"));
            aVar.r(jSONObject.optInt("mDownloadMode"));
            aVar.j(jSONObject.optInt("mModelType"));
            aVar.k(jSONObject.optString("mAppName"));
            aVar.r(jSONObject.optString("mAppIcon"));
            aVar.ok(jSONObject.optInt("mDownloadFailedTimes", 0));
            aVar.ok(com.ss.android.download.api.bl.a.ok(jSONObject, "mRecentDownloadResumeTime"));
            aVar.a(jSONObject.optInt("mClickPauseTimes"));
            aVar.a(com.ss.android.download.api.bl.a.ok(jSONObject, "mJumpInstallTime"));
            aVar.bl(com.ss.android.download.api.bl.a.ok(jSONObject, "mCancelInstallTime"));
            aVar.bl(jSONObject.optInt("mLastFailedResumeCount"));
            aVar.j(jSONObject.optString("downloadFinishReason"));
            aVar.q(jSONObject.optLong("clickDownloadSize"));
            aVar.p(jSONObject.optLong("clickDownloadTime"));
            aVar.p(jSONObject.optBoolean("mIsUpdateDownload"));
            aVar.z(jSONObject.optString("mOriginMimeType"));
            aVar.q(jSONObject.optBoolean("mIsPatchApplyHandled"));
            aVar.kf(jSONObject.optBoolean("installAfterCleanSpace"));
            aVar.q(jSONObject.optInt("funnelType", 1));
            aVar.n(jSONObject.optString("webUrl"));
            aVar.i(jSONObject.optBoolean("enableShowComplianceDialog", true));
            aVar.x(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            aVar.td(jSONObject.optInt("enable_new_activity", 1) == 1);
            aVar.zz(jSONObject.optInt("enable_pause", 1) == 1);
            aVar.u(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z3 = false;
            }
            aVar.io(z3);
            aVar.ok(jSONObject.optJSONObject("mExtras"));
            aVar.ul(jSONObject.optBoolean("intent_jump_browser_success"));
            aVar.rh(jSONObject.optString("task_key"));
        } catch (Exception e4) {
            r.u().ok(e4, "NativeDownloadModel fromJson");
        }
        return aVar;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String ok() {
        return this.f48310k;
    }

    public a(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public a(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i4) {
        this.f48315p = 1;
        this.f48320u = true;
        this.f48324y = false;
        this.f48312m = 0;
        this.ep = 0;
        this.fl = false;
        this.fd = false;
        this.em = true;
        this.sg = true;
        this.ok = true;
        this.f48302a = true;
        this.bl = new AtomicBoolean(false);
        this.f48318s = new AtomicBoolean(false);
        this.vk = 1;
        this.qx = true;
        this.cf = -1L;
        this.f48313n = downloadModel.getId();
        this.kf = downloadModel.getExtraValue();
        this.f48306h = downloadModel.getLogExtra();
        this.f48316q = downloadModel.getPackageName();
        this.ul = downloadModel.getExtra();
        this.f48320u = downloadModel.isAd();
        this.f48307i = downloadModel.getVersionCode();
        this.f48323x = downloadModel.getVersionName();
        this.f48310k = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.f48317r = downloadModel.getDeepLink().getOpenUrl();
            this.f48309j = downloadModel.getDeepLink().getWebUrl();
        }
        this.f48325z = downloadModel.getModelType();
        this.td = downloadModel.getName();
        this.zz = downloadModel.getAppIcon();
        this.f48304e = downloadModel.getMimeType();
        this.qu = downloadEventConfig.getClickButtonTag();
        this.xy = downloadEventConfig.getRefer();
        this.ah = downloadEventConfig.isEnableV3Event();
        this.f48324y = downloadController.isEnableBackDialog();
        this.rh = downloadController.getLinkMode();
        this.f48319t = downloadController.getDownloadMode();
        this.qx = downloadController.enableShowComplianceDialog();
        this.tr = downloadController.isAutoDownloadOnCardShow();
        this.em = downloadController.enableNewActivity();
        this.ok = downloadController.enableAH();
        this.f48302a = downloadController.enableAM();
        this.f48314o = i4;
        long currentTimeMillis = System.currentTimeMillis();
        this.f48308io = currentTimeMillis;
        this.vz = currentTimeMillis;
        this.fd = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.f48303d = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
