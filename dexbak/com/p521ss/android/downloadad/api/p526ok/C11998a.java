package com.p521ss.android.downloadad.api.p526ok;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.model.DeepLink;
import com.p521ss.android.download.api.p523bl.C11951a;
import com.p521ss.android.downloadad.api.constant.AdBaseConstants;
import com.p521ss.android.downloadad.api.download.AdDownloadController;
import com.p521ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadlib.addownload.C12128r;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadad.api.ok.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11998a implements InterfaceC11999ok {

    /* renamed from: a */
    protected boolean f33925a;

    /* renamed from: ah */
    private boolean f33926ah;

    /* renamed from: bl */
    public final AtomicBoolean f33927bl;

    /* renamed from: cf */
    private long f33928cf;

    /* renamed from: cs */
    private String f33929cs;

    /* renamed from: d */
    private String f33930d;

    /* renamed from: de */
    private boolean f33931de;

    /* renamed from: dn */
    private boolean f33932dn;

    /* renamed from: dx */
    private boolean f33933dx;

    /* renamed from: e */
    private String f33934e;

    /* renamed from: ej */
    private long f33935ej;

    /* renamed from: em */
    private boolean f33936em;

    /* renamed from: ep */
    private int f33937ep;

    /* renamed from: er */
    private long f33938er;

    /* renamed from: ew */
    private transient boolean f33939ew;

    /* renamed from: fb */
    private int f33940fb;

    /* renamed from: fd */
    private boolean f33941fd;

    /* renamed from: fl */
    private boolean f33942fl;

    /* renamed from: g */
    private int f33943g;

    /* renamed from: h */
    private String f33944h;

    /* renamed from: i */
    private int f33945i;

    /* renamed from: io */
    private long f33946io;

    /* renamed from: j */
    private String f33947j;

    /* renamed from: ju */
    private boolean f33948ju;

    /* renamed from: k */
    private String f33949k;

    /* renamed from: kf */
    private long f33950kf;

    /* renamed from: kz */
    private long f33951kz;

    /* renamed from: l */
    private boolean f33952l;

    /* renamed from: ld */
    private boolean f33953ld;

    /* renamed from: m */
    private int f33954m;

    /* renamed from: n */
    private long f33955n;

    /* renamed from: o */
    private int f33956o;

    /* renamed from: ok */
    protected boolean f33957ok;

    /* renamed from: p */
    private int f33958p;

    /* renamed from: q */
    private String f33959q;

    /* renamed from: qu */
    private String f33960qu;

    /* renamed from: qx */
    private boolean f33961qx;

    /* renamed from: r */
    private String f33962r;

    /* renamed from: rh */
    private int f33963rh;

    /* renamed from: ry */
    private boolean f33964ry;

    /* renamed from: s */
    public final AtomicBoolean f33965s;

    /* renamed from: sg */
    private boolean f33966sg;

    /* renamed from: t */
    private int f33967t;

    /* renamed from: td */
    private String f33968td;

    /* renamed from: tg */
    private boolean f33969tg;

    /* renamed from: to */
    private boolean f33970to;

    /* renamed from: tr */
    private boolean f33971tr;

    /* renamed from: u */
    private boolean f33972u;

    /* renamed from: ul */
    private JSONObject f33973ul;

    /* renamed from: v */
    private String f33974v;
    @AdBaseConstants.FunnelType

    /* renamed from: vk */
    private int f33975vk;

    /* renamed from: vz */
    private long f33976vz;

    /* renamed from: w */
    private boolean f33977w;

    /* renamed from: wv */
    private int f33978wv;

    /* renamed from: x */
    private String f33979x;

    /* renamed from: xy */
    private String f33980xy;

    /* renamed from: y */
    private boolean f33981y;

    /* renamed from: yt */
    private long f33982yt;

    /* renamed from: z */
    private int f33983z;

    /* renamed from: zz */
    private String f33984zz;

    private C11998a() {
        this.f33958p = 1;
        this.f33972u = true;
        this.f33981y = false;
        this.f33954m = 0;
        this.f33937ep = 0;
        this.f33942fl = false;
        this.f33941fd = false;
        this.f33936em = true;
        this.f33966sg = true;
        this.f33957ok = true;
        this.f33925a = true;
        this.f33927bl = new AtomicBoolean(false);
        this.f33965s = new AtomicBoolean(false);
        this.f33975vk = 1;
        this.f33961qx = true;
        this.f33928cf = -1L;
    }

    /* renamed from: a */
    public void m19526a(int i) {
        this.f33937ep = i;
    }

    /* renamed from: ah */
    public String m19521ah() {
        return this.f33968td;
    }

    /* renamed from: bl */
    public void m19519bl(long j) {
        this.f33938er = j;
    }

    /* renamed from: c */
    public AdDownloadController m19516c() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.f33981y).setLinkMode(this.f33963rh).setDownloadMode(this.f33967t).setEnableShowComplianceDialog(this.f33961qx).setEnableAH(this.f33957ok).setEnableAM(this.f33925a).build();
    }

    /* renamed from: cf */
    public boolean m19515cf() {
        return this.f33964ry;
    }

    /* renamed from: cs */
    public boolean m19514cs() {
        return this.f33942fl;
    }

    /* renamed from: d */
    public AdDownloadModel m19513d() {
        return new AdDownloadModel.Builder().setAdId(this.f33955n).setExtraValue(this.f33950kf).setLogExtra(this.f33944h).setPackageName(this.f33959q).setExtra(this.f33973ul).setIsAd(this.f33972u).setVersionCode(this.f33945i).setVersionName(this.f33979x).setDownloadUrl(this.f33949k).setModelType(this.f33983z).setMimeType(this.f33934e).setAppName(this.f33968td).setAppIcon(this.f33984zz).setTaskKey(this.f33930d).setDeepLink(new DeepLink(this.f33962r, this.f33947j, null)).build();
    }

    /* renamed from: de */
    public boolean m19512de() {
        return this.f33970to;
    }

    /* renamed from: dn */
    public boolean m19511dn() {
        return this.f33953ld;
    }

    /* renamed from: dx */
    public boolean m19510dx() {
        return this.f33939ew;
    }

    /* renamed from: e */
    public long m19509e() {
        return this.f33946io;
    }

    /* renamed from: ej */
    public boolean m19508ej() {
        return this.f33933dx;
    }

    /* renamed from: em */
    public String m19507em() {
        return this.f33979x;
    }

    /* renamed from: ep */
    public int m19506ep() {
        return this.f33937ep;
    }

    /* renamed from: er */
    public long m19505er() {
        return this.f33951kz;
    }

    /* renamed from: ew */
    public boolean m19504ew() {
        return this.f33932dn;
    }

    /* renamed from: fb */
    public int m19503fb() {
        return this.f33940fb;
    }

    /* renamed from: fd */
    public int m19502fd() {
        return this.f33945i;
    }

    /* renamed from: fl */
    public int m19501fl() {
        return this.f33958p;
    }

    /* renamed from: g */
    public int m19500g() {
        return this.f33943g;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: h */
    public JSONObject mo19307h() {
        return this.f33973ul;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: i */
    public JSONObject mo19306i() {
        return null;
    }

    /* renamed from: i */
    public void m19495i(boolean z) {
        this.f33961qx = z;
    }

    /* renamed from: io */
    public void m19494io(boolean z) {
        this.f33925a = z;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: j */
    public long mo19304j() {
        return this.f33950kf;
    }

    /* renamed from: ju */
    public JSONObject m19490ju() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.f33955n);
            jSONObject.put("mExtValue", this.f33950kf);
            jSONObject.put("mLogExtra", this.f33944h);
            jSONObject.put("mDownloadStatus", this.f33958p);
            jSONObject.put("mPackageName", this.f33959q);
            jSONObject.put("mIsAd", this.f33972u);
            jSONObject.put("mTimeStamp", this.f33946io);
            jSONObject.put("mExtras", this.f33973ul);
            jSONObject.put("mVersionCode", this.f33945i);
            jSONObject.put("mVersionName", this.f33979x);
            jSONObject.put("mDownloadId", this.f33956o);
            jSONObject.put("mIsV3Event", this.f33926ah);
            jSONObject.put("mScene", this.f33978wv);
            jSONObject.put("mEventTag", this.f33960qu);
            jSONObject.put("mEventRefer", this.f33980xy);
            jSONObject.put("mDownloadUrl", this.f33949k);
            jSONObject.put("mEnableBackDialog", this.f33981y);
            jSONObject.put("hasSendInstallFinish", this.f33927bl.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.f33965s.get());
            jSONObject.put("mLastFailedErrCode", this.f33943g);
            jSONObject.put("mLastFailedErrMsg", this.f33974v);
            jSONObject.put("mOpenUrl", this.f33962r);
            jSONObject.put("mLinkMode", this.f33963rh);
            jSONObject.put("mDownloadMode", this.f33967t);
            jSONObject.put("mModelType", this.f33983z);
            jSONObject.put("mAppName", this.f33968td);
            jSONObject.put("mAppIcon", this.f33984zz);
            jSONObject.put("mDownloadFailedTimes", this.f33954m);
            long j = this.f33976vz;
            if (j == 0) {
                j = this.f33946io;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.f33937ep);
            jSONObject.put("mJumpInstallTime", this.f33951kz);
            jSONObject.put("mCancelInstallTime", this.f33938er);
            jSONObject.put("mLastFailedResumeCount", this.f33940fb);
            jSONObject.put("mIsUpdateDownload", this.f33942fl);
            jSONObject.put("mOriginMimeType", this.f33934e);
            jSONObject.put("mIsPatchApplyHandled", this.f33941fd);
            jSONObject.put("downloadFinishReason", this.f33929cs);
            jSONObject.put("clickDownloadTime", this.f33982yt);
            jSONObject.put("clickDownloadSize", this.f33935ej);
            jSONObject.put("installAfterCleanSpace", this.f33952l);
            jSONObject.put(TTDownloadField.TT_FUNNEL_TYPE, this.f33975vk);
            jSONObject.put(TTDownloadField.TT_WEB_URL, this.f33947j);
            jSONObject.put(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, this.f33961qx);
            jSONObject.put(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, this.f33971tr);
            int i = 1;
            jSONObject.put("enable_new_activity", this.f33936em ? 1 : 0);
            jSONObject.put("enable_pause", this.f33966sg ? 1 : 0);
            jSONObject.put("enable_ah", this.f33957ok ? 1 : 0);
            if (!this.f33925a) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.f33948ju));
            jSONObject.put("task_key", this.f33930d);
        } catch (Exception e) {
            C12128r.m18940u().mo18637ok(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: k */
    public String mo19303k() {
        return this.f33960qu;
    }

    /* renamed from: kf */
    public void m19485kf(long j) {
        if (j > 0) {
            this.f33946io = j;
        }
    }

    /* renamed from: kz */
    public long m19482kz() {
        long j = this.f33976vz;
        return j == 0 ? this.f33946io : j;
    }

    /* renamed from: l */
    public int m19481l() {
        return this.f33963rh;
    }

    /* renamed from: ld */
    public String m19480ld() {
        return this.f33930d;
    }

    /* renamed from: m */
    public synchronized void m19479m() {
        this.f33954m++;
    }

    /* renamed from: n */
    public void m19477n(long j) {
        this.f33950kf = j;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: o */
    public DownloadController mo19299o() {
        return m19516c();
    }

    /* renamed from: ok */
    public void m19474ok(int i) {
        this.f33954m = i;
    }

    /* renamed from: p */
    public void m19469p(int i) {
        this.f33978wv = i;
    }

    /* renamed from: q */
    public void m19465q(int i) {
        this.f33975vk = i;
    }

    /* renamed from: qu */
    public boolean m19461qu() {
        return this.f33981y;
    }

    /* renamed from: qx */
    public long m19460qx() {
        return this.f33982yt;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: r */
    public JSONObject mo19295r() {
        return null;
    }

    /* renamed from: r */
    public void m19458r(String str) {
        this.f33984zz = str;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: rh */
    public List<String> mo19294rh() {
        return null;
    }

    /* renamed from: rh */
    public void m19455rh(boolean z) {
        this.f33970to = z;
    }

    /* renamed from: ry */
    public boolean m19454ry() {
        return this.f33931de;
    }

    /* renamed from: s */
    public void m19453s(int i) {
        this.f33943g = i;
    }

    /* renamed from: sg */
    public int m19449sg() {
        return this.f33978wv;
    }

    /* renamed from: sr */
    public AdDownloadEventConfig m19448sr() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.f33960qu).setRefer(this.f33980xy).setIsEnableV3Event(this.f33926ah).build();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: t */
    public Object mo19292t() {
        return null;
    }

    /* renamed from: t */
    public void m19447t(boolean z) {
        this.f33953ld = z;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: td */
    public JSONObject mo19291td() {
        return null;
    }

    /* renamed from: td */
    public void m19446td(boolean z) {
        this.f33936em = z;
    }

    /* renamed from: tg */
    public boolean m19445tg() {
        return this.f33941fd;
    }

    /* renamed from: to */
    public boolean m19444to() {
        return this.f33948ju;
    }

    /* renamed from: tr */
    public long m19443tr() {
        return this.f33935ej;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: u */
    public int mo19290u() {
        return -1;
    }

    /* renamed from: u */
    public void m19442u(boolean z) {
        this.f33957ok = z;
    }

    /* renamed from: ul */
    public void m19441ul(boolean z) {
        this.f33948ju = z;
    }

    /* renamed from: v */
    public String m19440v() {
        return this.f33974v;
    }

    /* renamed from: vk */
    public boolean m19439vk() {
        return this.f33969tg;
    }

    /* renamed from: vz */
    public synchronized void m19438vz() {
        this.f33937ep++;
    }

    /* renamed from: w */
    public String m19437w() {
        return this.f33934e;
    }

    /* renamed from: wv */
    public String m19436wv() {
        return this.f33929cs;
    }

    /* renamed from: x */
    public void m19435x(boolean z) {
        this.f33971tr = z;
    }

    /* renamed from: xy */
    public long m19434xy() {
        return this.f33928cf;
    }

    /* renamed from: y */
    public int m19433y() {
        return this.f33954m;
    }

    /* renamed from: yt */
    public boolean m19432yt() {
        return this.f33952l;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: z */
    public boolean mo19286z() {
        return this.f33926ah;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: zz */
    public int mo19285zz() {
        return this.f33956o;
    }

    /* renamed from: a */
    public void m19525a(long j) {
        this.f33951kz = j;
    }

    /* renamed from: bl */
    public void m19520bl(int i) {
        this.f33940fb = i;
    }

    /* renamed from: h */
    public void m19499h(int i) {
        this.f33956o = i;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: io */
    public DownloadModel mo19305io() {
        return m19513d();
    }

    /* renamed from: j */
    public void m19493j(int i) {
        this.f33983z = i;
    }

    /* renamed from: k */
    public void m19488k(String str) {
        this.f33968td = str;
    }

    /* renamed from: kf */
    public void m19486kf(int i) {
        this.f33945i = i;
    }

    /* renamed from: n */
    public void m19478n(int i) {
        this.f33958p = i;
    }

    /* renamed from: ok */
    public void m19473ok(long j) {
        this.f33976vz = j;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: p */
    public int mo19297p() {
        return this.f33975vk;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: q */
    public String mo19296q() {
        return this.f33980xy;
    }

    /* renamed from: r */
    public void m19459r(int i) {
        this.f33967t = i;
    }

    /* renamed from: rh */
    public void m19456rh(String str) {
        this.f33930d = str;
    }

    /* renamed from: s */
    public void m19452s(long j) {
        this.f33955n = j;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: ul */
    public DownloadEventConfig mo19289ul() {
        return m19448sr();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: x */
    public boolean mo19288x() {
        return this.f33936em;
    }

    /* renamed from: z */
    public void m19431z(String str) {
        this.f33934e = str;
    }

    /* renamed from: zz */
    public void m19429zz(boolean z) {
        this.f33966sg = z;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: a */
    public long mo19309a() {
        return this.f33955n;
    }

    /* renamed from: bl */
    public void m19518bl(String str) {
        this.f33944h = str;
    }

    /* renamed from: h */
    public void m19497h(String str) {
        this.f33980xy = str;
    }

    /* renamed from: j */
    public void m19492j(String str) {
        this.f33929cs = str;
    }

    /* renamed from: k */
    public void m19489k(int i) {
        this.f33963rh = i;
    }

    /* renamed from: kf */
    public void m19484kf(String str) {
        this.f33960qu = str;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: n */
    public String mo19300n() {
        return this.f33959q;
    }

    /* renamed from: ok */
    public void m19472ok(String str) {
        this.f33974v = str;
    }

    /* renamed from: p */
    public void m19467p(String str) {
        this.f33949k = str;
    }

    /* renamed from: q */
    public void m19463q(String str) {
        this.f33962r = str;
    }

    /* renamed from: r */
    public void m19457r(boolean z) {
        this.f33964ry = z;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: s */
    public String mo19293s() {
        return this.f33944h;
    }

    /* renamed from: z */
    public void m19430z(boolean z) {
        this.f33931de = z;
    }

    /* renamed from: a */
    public void m19524a(String str) {
        this.f33959q = str;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: bl */
    public boolean mo19308bl() {
        return this.f33972u;
    }

    /* renamed from: h */
    public void m19498h(long j) {
        this.f33928cf = j;
    }

    /* renamed from: j */
    public void m19491j(boolean z) {
        this.f33932dn = z;
    }

    /* renamed from: k */
    public void m19487k(boolean z) {
        this.f33939ew = z;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: kf */
    public String mo19302kf() {
        return this.f33962r;
    }

    /* renamed from: n */
    public void m19476n(String str) {
        this.f33947j = str;
    }

    /* renamed from: ok */
    public void m19470ok(boolean z) {
        this.f33972u = z;
    }

    /* renamed from: p */
    public void m19468p(long j) {
        this.f33982yt = j;
    }

    /* renamed from: q */
    public void m19464q(long j) {
        this.f33935ej = j;
    }

    /* renamed from: s */
    public void m19451s(String str) {
        this.f33979x = str;
    }

    /* renamed from: a */
    public void m19522a(boolean z) {
        this.f33926ah = z;
    }

    /* renamed from: bl */
    public void m19517bl(boolean z) {
        this.f33981y = z;
    }

    /* renamed from: h */
    public void m19496h(boolean z) {
        this.f33933dx = z;
    }

    /* renamed from: kf */
    public void m19483kf(boolean z) {
        this.f33952l = z;
    }

    /* renamed from: n */
    public void m19475n(boolean z) {
        this.f33969tg = z;
    }

    /* renamed from: ok */
    public void m19471ok(JSONObject jSONObject) {
        this.f33973ul = jSONObject;
    }

    /* renamed from: p */
    public void m19466p(boolean z) {
        this.f33942fl = z;
    }

    /* renamed from: q */
    public void m19462q(boolean z) {
        this.f33941fd = z;
    }

    /* renamed from: s */
    public void m19450s(boolean z) {
        this.f33977w = z;
    }

    /* renamed from: a */
    public static C11998a m19523a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C11998a c11998a = new C11998a();
        try {
            c11998a.m19452s(C11951a.m19662ok(jSONObject, "mId"));
            c11998a.m19477n(C11951a.m19662ok(jSONObject, "mExtValue"));
            c11998a.m19518bl(jSONObject.optString("mLogExtra"));
            c11998a.m19478n(jSONObject.optInt("mDownloadStatus"));
            c11998a.m19524a(jSONObject.optString("mPackageName"));
            boolean z = true;
            c11998a.m19470ok(jSONObject.optBoolean("mIsAd", true));
            c11998a.m19485kf(C11951a.m19662ok(jSONObject, "mTimeStamp"));
            c11998a.m19486kf(jSONObject.optInt("mVersionCode"));
            c11998a.m19451s(jSONObject.optString("mVersionName"));
            c11998a.m19499h(jSONObject.optInt("mDownloadId"));
            c11998a.m19522a(jSONObject.optBoolean("mIsV3Event"));
            c11998a.m19469p(jSONObject.optInt("mScene"));
            c11998a.m19484kf(jSONObject.optString("mEventTag"));
            c11998a.m19497h(jSONObject.optString("mEventRefer"));
            c11998a.m19467p(jSONObject.optString("mDownloadUrl"));
            c11998a.m19517bl(jSONObject.optBoolean("mEnableBackDialog"));
            c11998a.f33927bl.set(jSONObject.optBoolean("hasSendInstallFinish"));
            c11998a.f33965s.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            c11998a.m19453s(jSONObject.optInt("mLastFailedErrCode"));
            c11998a.m19472ok(jSONObject.optString("mLastFailedErrMsg"));
            c11998a.m19463q(jSONObject.optString("mOpenUrl"));
            c11998a.m19489k(jSONObject.optInt("mLinkMode"));
            c11998a.m19459r(jSONObject.optInt("mDownloadMode"));
            c11998a.m19493j(jSONObject.optInt("mModelType"));
            c11998a.m19488k(jSONObject.optString("mAppName"));
            c11998a.m19458r(jSONObject.optString("mAppIcon"));
            c11998a.m19474ok(jSONObject.optInt("mDownloadFailedTimes", 0));
            c11998a.m19473ok(C11951a.m19662ok(jSONObject, "mRecentDownloadResumeTime"));
            c11998a.m19526a(jSONObject.optInt("mClickPauseTimes"));
            c11998a.m19525a(C11951a.m19662ok(jSONObject, "mJumpInstallTime"));
            c11998a.m19519bl(C11951a.m19662ok(jSONObject, "mCancelInstallTime"));
            c11998a.m19520bl(jSONObject.optInt("mLastFailedResumeCount"));
            c11998a.m19492j(jSONObject.optString("downloadFinishReason"));
            c11998a.m19464q(jSONObject.optLong("clickDownloadSize"));
            c11998a.m19468p(jSONObject.optLong("clickDownloadTime"));
            c11998a.m19466p(jSONObject.optBoolean("mIsUpdateDownload"));
            c11998a.m19431z(jSONObject.optString("mOriginMimeType"));
            c11998a.m19462q(jSONObject.optBoolean("mIsPatchApplyHandled"));
            c11998a.m19483kf(jSONObject.optBoolean("installAfterCleanSpace"));
            c11998a.m19465q(jSONObject.optInt(TTDownloadField.TT_FUNNEL_TYPE, 1));
            c11998a.m19476n(jSONObject.optString(TTDownloadField.TT_WEB_URL));
            c11998a.m19495i(jSONObject.optBoolean(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, true));
            c11998a.m19435x(jSONObject.optBoolean(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW));
            c11998a.m19446td(jSONObject.optInt("enable_new_activity", 1) == 1);
            c11998a.m19429zz(jSONObject.optInt("enable_pause", 1) == 1);
            c11998a.m19442u(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            c11998a.m19494io(z);
            c11998a.m19471ok(jSONObject.optJSONObject("mExtras"));
            c11998a.m19441ul(jSONObject.optBoolean("intent_jump_browser_success"));
            c11998a.m19456rh(jSONObject.optString("task_key"));
        } catch (Exception e) {
            C12128r.m18940u().mo18637ok(e, "NativeDownloadModel fromJson");
        }
        return c11998a;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: ok */
    public String mo19298ok() {
        return this.f33949k;
    }

    public C11998a(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public C11998a(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.f33958p = 1;
        this.f33972u = true;
        this.f33981y = false;
        this.f33954m = 0;
        this.f33937ep = 0;
        this.f33942fl = false;
        this.f33941fd = false;
        this.f33936em = true;
        this.f33966sg = true;
        this.f33957ok = true;
        this.f33925a = true;
        this.f33927bl = new AtomicBoolean(false);
        this.f33965s = new AtomicBoolean(false);
        this.f33975vk = 1;
        this.f33961qx = true;
        this.f33928cf = -1L;
        this.f33955n = downloadModel.getId();
        this.f33950kf = downloadModel.getExtraValue();
        this.f33944h = downloadModel.getLogExtra();
        this.f33959q = downloadModel.getPackageName();
        this.f33973ul = downloadModel.getExtra();
        this.f33972u = downloadModel.isAd();
        this.f33945i = downloadModel.getVersionCode();
        this.f33979x = downloadModel.getVersionName();
        this.f33949k = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.f33962r = downloadModel.getDeepLink().getOpenUrl();
            this.f33947j = downloadModel.getDeepLink().getWebUrl();
        }
        this.f33983z = downloadModel.getModelType();
        this.f33968td = downloadModel.getName();
        this.f33984zz = downloadModel.getAppIcon();
        this.f33934e = downloadModel.getMimeType();
        this.f33960qu = downloadEventConfig.getClickButtonTag();
        this.f33980xy = downloadEventConfig.getRefer();
        this.f33926ah = downloadEventConfig.isEnableV3Event();
        this.f33981y = downloadController.isEnableBackDialog();
        this.f33963rh = downloadController.getLinkMode();
        this.f33967t = downloadController.getDownloadMode();
        this.f33961qx = downloadController.enableShowComplianceDialog();
        this.f33971tr = downloadController.isAutoDownloadOnCardShow();
        this.f33936em = downloadController.enableNewActivity();
        this.f33957ok = downloadController.enableAH();
        this.f33925a = downloadController.enableAM();
        this.f33956o = i;
        long currentTimeMillis = System.currentTimeMillis();
        this.f33946io = currentTimeMillis;
        this.f33976vz = currentTimeMillis;
        this.f33941fd = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.f33930d = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
