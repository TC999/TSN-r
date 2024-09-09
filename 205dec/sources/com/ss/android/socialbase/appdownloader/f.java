package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.bk;
import com.ss.android.socialbase.downloader.depend.ls;
import com.ss.android.socialbase.downloader.depend.me;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.downloader.fz;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {
    private me au;

    /* renamed from: b  reason: collision with root package name */
    private String f49051b;
    private int ba;
    private boolean bj;
    private IDownloadListener bk;
    private JSONObject bm;
    private int bw;

    /* renamed from: c  reason: collision with root package name */
    private Activity f49052c;
    private boolean ck;
    private String eq;
    private List<com.ss.android.socialbase.downloader.model.xv> ev;

    /* renamed from: f  reason: collision with root package name */
    private String f49053f;
    private com.ss.android.socialbase.downloader.downloader.ev fz;
    private String gb;
    private int[] ge;
    private t gw;

    /* renamed from: i  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.notification.c f49055i;
    private boolean ia;

    /* renamed from: j  reason: collision with root package name */
    private boolean f49056j;
    private String ls;

    /* renamed from: m  reason: collision with root package name */
    private ls f49058m;
    private com.ss.android.socialbase.downloader.depend.s mt;

    /* renamed from: n  reason: collision with root package name */
    private long f49059n;
    private int ng;
    private String oh;
    private boolean ok;
    private boolean oo;
    private int ox;

    /* renamed from: q  reason: collision with root package name */
    private boolean f49061q;

    /* renamed from: r  reason: collision with root package name */
    private String f49062r;

    /* renamed from: s  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.r f49063s;
    private List<String> sr;

    /* renamed from: t  reason: collision with root package name */
    private IDownloadListener f49064t;
    private String te;

    /* renamed from: u  reason: collision with root package name */
    private fz f49065u;
    private IDownloadFileUriProvider up;
    private String ux;
    private com.ss.android.socialbase.appdownloader.xv.ux vc;

    /* renamed from: w  reason: collision with root package name */
    private Context f49066w;
    private boolean wv;
    private boolean xk;
    private long xu;
    private String xv;

    /* renamed from: y  reason: collision with root package name */
    private boolean f49068y;
    private String ys;
    private boolean yu;
    private boolean gd = true;

    /* renamed from: p  reason: collision with root package name */
    private boolean f49060p = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f49057k = true;

    /* renamed from: a  reason: collision with root package name */
    private boolean f49050a = false;
    private String fp = "application/vnd.android.package-archive";

    /* renamed from: z  reason: collision with root package name */
    private int f49069z = 5;
    private boolean me = true;
    private EnqueueType wx = EnqueueType.ENQUEUE_NONE;
    private int pr = 150;

    /* renamed from: x  reason: collision with root package name */
    private boolean f49067x = true;
    private List<bk> wo = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private boolean f49054h = true;
    private boolean fm = true;

    public f(@NonNull Context context, @NonNull String str) {
        this.f49066w = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.xv = str;
    }

    public String a() {
        return this.fp;
    }

    public boolean au() {
        return this.bj;
    }

    public boolean b() {
        return this.fm;
    }

    public fz ba() {
        return this.f49065u;
    }

    public int bj() {
        return this.ox;
    }

    public boolean bk() {
        return this.ia;
    }

    public long bm() {
        return this.xu;
    }

    public String bw() {
        return this.f49053f;
    }

    public String c() {
        return this.xv;
    }

    public boolean ck() {
        return this.me;
    }

    public int eq() {
        return this.bw;
    }

    public boolean ev() {
        return this.f49050a;
    }

    public boolean f() {
        return this.f49060p;
    }

    public JSONObject fm() {
        return this.bm;
    }

    public com.ss.android.socialbase.downloader.downloader.r fp() {
        return this.f49063s;
    }

    public int fz() {
        return this.ng;
    }

    public boolean gb() {
        return this.f49068y;
    }

    public IDownloadListener gd() {
        return this.bk;
    }

    public Activity getActivity() {
        return this.f49052c;
    }

    public Context getContext() {
        return this.f49066w;
    }

    public com.ss.android.socialbase.appdownloader.xv.ux gw() {
        return this.vc;
    }

    public List<String> h() {
        return this.sr;
    }

    public String i() {
        return this.gb;
    }

    public boolean ia() {
        return this.f49061q;
    }

    public int j() {
        return this.f49069z;
    }

    public String k() {
        return this.ys;
    }

    public int ls() {
        return this.ba;
    }

    public t m() {
        return this.gw;
    }

    public boolean me() {
        return this.xk;
    }

    public List<bk> mt() {
        return this.wo;
    }

    public String n() {
        return this.eq;
    }

    public boolean ng() {
        return this.f49054h;
    }

    public com.ss.android.socialbase.downloader.depend.s oh() {
        return this.mt;
    }

    public String ok() {
        return this.f49051b;
    }

    public String oo() {
        return this.oh;
    }

    public int[] ox() {
        return this.ge;
    }

    public IDownloadListener p() {
        return this.f49064t;
    }

    public boolean pr() {
        return this.ck;
    }

    public long q() {
        return this.f49059n;
    }

    public boolean r() {
        return this.f49057k;
    }

    public boolean s() {
        return this.f49056j;
    }

    public List<com.ss.android.socialbase.downloader.model.xv> sr() {
        return this.ev;
    }

    public com.ss.android.socialbase.downloader.notification.c t() {
        return this.f49055i;
    }

    public String u() {
        return this.ls;
    }

    public me up() {
        return this.au;
    }

    public boolean ux() {
        return this.gd;
    }

    public IDownloadFileUriProvider vc() {
        return this.up;
    }

    public String w() {
        return this.ux;
    }

    public String wo() {
        return this.te;
    }

    public boolean wv() {
        return this.yu;
    }

    public EnqueueType wx() {
        return this.wx;
    }

    public ls x() {
        return this.f49058m;
    }

    public boolean xk() {
        return this.f49067x;
    }

    public boolean xu() {
        return this.ok;
    }

    public String xv() {
        return this.f49062r;
    }

    public int y() {
        return this.pr;
    }

    public com.ss.android.socialbase.downloader.downloader.ev ys() {
        return this.fz;
    }

    public boolean yu() {
        return this.oo;
    }

    public boolean z() {
        return this.wv;
    }

    public f a(boolean z3) {
        this.yu = z3;
        return this;
    }

    public f bk(boolean z3) {
        this.f49067x = z3;
        return this;
    }

    public void c(int i4) {
        this.ng = i4;
    }

    public f ev(String str) {
        this.gb = str;
        return this;
    }

    public f f(String str) {
        this.fp = str;
        return this;
    }

    public f fp(boolean z3) {
        this.f49054h = z3;
        return this;
    }

    public f gd(String str) {
        this.eq = str;
        return this;
    }

    public f k(boolean z3) {
        this.xk = z3;
        return this;
    }

    public f p(boolean z3) {
        this.wv = z3;
        return this;
    }

    public f r(String str) {
        this.ls = str;
        return this;
    }

    public f sr(String str) {
        this.oh = str;
        return this;
    }

    public f t(boolean z3) {
        this.ck = z3;
        return this;
    }

    public f ux(String str) {
        this.ys = str;
        return this;
    }

    public f w(String str) {
        this.f49053f = str;
        return this;
    }

    public f xv(@NonNull String str) {
        this.f49062r = str;
        return this;
    }

    public f ys(boolean z3) {
        this.ok = z3;
        return this;
    }

    public f c(String str) {
        this.ux = str;
        return this;
    }

    public f ev(boolean z3) {
        this.oo = z3;
        return this;
    }

    public f f(boolean z3) {
        this.f49056j = z3;
        return this;
    }

    public f gd(boolean z3) {
        this.me = z3;
        return this;
    }

    public f k(String str) {
        this.f49051b = str;
        return this;
    }

    public f p(String str) {
        this.te = str;
        return this;
    }

    public f r(boolean z3) {
        this.f49068y = z3;
        return this;
    }

    public f sr(boolean z3) {
        this.ia = z3;
        return this;
    }

    public f ux(boolean z3) {
        this.f49061q = z3;
        return this;
    }

    public f w(boolean z3) {
        this.f49060p = z3;
        return this;
    }

    public f xv(boolean z3) {
        this.f49050a = z3;
        return this;
    }

    public f c(List<com.ss.android.socialbase.downloader.model.xv> list) {
        this.ev = list;
        return this;
    }

    public f f(int i4) {
        this.ox = i4;
        return this;
    }

    public f sr(int i4) {
        this.pr = i4;
        return this;
    }

    public f ux(int i4) {
        this.bw = i4;
        return this;
    }

    public f w(int i4) {
        this.f49069z = i4;
        return this;
    }

    public f xv(int i4) {
        this.ba = i4;
        return this;
    }

    public f c(boolean z3) {
        this.gd = z3;
        return this;
    }

    public f w(List<String> list) {
        this.sr = list;
        return this;
    }

    public f c(IDownloadListener iDownloadListener) {
        this.bk = iDownloadListener;
        return this;
    }

    public f c(long j4) {
        this.f49059n = j4;
        return this;
    }

    public f c(EnqueueType enqueueType) {
        this.wx = enqueueType;
        return this;
    }

    public f c(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.up = iDownloadFileUriProvider;
        return this;
    }

    public f c(com.ss.android.socialbase.downloader.depend.s sVar) {
        this.mt = sVar;
        return this;
    }

    public f c(JSONObject jSONObject) {
        this.bm = jSONObject;
        return this;
    }

    public f c(bk bkVar) {
        synchronized (this.wo) {
            if (bkVar != null) {
                if (!this.wo.contains(bkVar)) {
                    this.wo.add(bkVar);
                    return this;
                }
            }
            return this;
        }
    }
}
