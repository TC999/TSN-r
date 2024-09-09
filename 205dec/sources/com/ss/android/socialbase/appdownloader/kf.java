package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.depend.td;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.zz;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf {

    /* renamed from: a  reason: collision with root package name */
    private Context f49100a;
    private y ah;
    private String bl;
    private long cf;
    private JSONObject cs;
    private String dn;
    private int dx;

    /* renamed from: e  reason: collision with root package name */
    private boolean f49101e;
    private boolean ej;
    private long ep;
    private int er;
    private int ew;
    private boolean fb;
    private boolean fd;
    private boolean fl;

    /* renamed from: g  reason: collision with root package name */
    private String f49102g;

    /* renamed from: h  reason: collision with root package name */
    private String f49103h;

    /* renamed from: io  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.notification.ok f49105io;
    private int[] ju;
    private String kf;

    /* renamed from: l  reason: collision with root package name */
    private rh f49108l;
    private String ld;

    /* renamed from: m  reason: collision with root package name */
    private String f49109m;

    /* renamed from: n  reason: collision with root package name */
    private String f49110n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f49111o;
    private Activity ok;

    /* renamed from: p  reason: collision with root package name */
    private List<com.ss.android.socialbase.downloader.model.bl> f49112p;
    private int qu;
    private v qx;
    private IDownloadListener rh;
    private boolean ry;

    /* renamed from: s  reason: collision with root package name */
    private List<String> f49115s;

    /* renamed from: t  reason: collision with root package name */
    private String f49116t;
    private com.ss.android.socialbase.downloader.downloader.h td;
    private boolean tr;

    /* renamed from: u  reason: collision with root package name */
    private zz f49117u;
    private boolean ul;
    private IDownloadFileUriProvider vk;
    private boolean vz;

    /* renamed from: w  reason: collision with root package name */
    private String f49119w;
    private com.ss.android.socialbase.appdownloader.bl.n wv;

    /* renamed from: x  reason: collision with root package name */
    private boolean f49120x;

    /* renamed from: y  reason: collision with root package name */
    private String f49121y;
    private td yt;

    /* renamed from: z  reason: collision with root package name */
    private IDownloadListener f49122z;
    private com.ss.android.socialbase.downloader.downloader.p zz;

    /* renamed from: q  reason: collision with root package name */
    private boolean f49113q = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f49107k = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f49114r = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f49106j = false;

    /* renamed from: i  reason: collision with root package name */
    private String f49104i = "application/vnd.android.package-archive";
    private int kz = 5;

    /* renamed from: v  reason: collision with root package name */
    private boolean f49118v = true;
    private EnqueueType em = EnqueueType.ENQUEUE_NONE;
    private int sg = 150;
    private boolean xy = true;
    private List<z> tg = new ArrayList();
    private boolean de = true;
    private boolean to = true;

    public kf(@NonNull Context context, @NonNull String str) {
        this.f49100a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.bl = str;
    }

    public String a() {
        return this.f49110n;
    }

    public rh ah() {
        return this.f49108l;
    }

    public String bl() {
        return this.f49103h;
    }

    public boolean cf() {
        return this.ry;
    }

    public long cs() {
        return this.cf;
    }

    public List<String> de() {
        return this.f49115s;
    }

    public td dn() {
        return this.yt;
    }

    public int[] dx() {
        return this.ju;
    }

    public boolean e() {
        return this.xy;
    }

    public String ej() {
        return this.dn;
    }

    public EnqueueType em() {
        return this.em;
    }

    public String ep() {
        return this.f49102g;
    }

    public zz er() {
        return this.f49117u;
    }

    public boolean ew() {
        return this.de;
    }

    public int fb() {
        return this.sg;
    }

    public boolean fd() {
        return this.ej;
    }

    public boolean fl() {
        return this.fd;
    }

    public int g() {
        return this.qu;
    }

    public Activity getActivity() {
        return this.ok;
    }

    public Context getContext() {
        return this.f49100a;
    }

    public boolean h() {
        return this.f49114r;
    }

    public com.ss.android.socialbase.downloader.downloader.h i() {
        return this.td;
    }

    public String io() {
        return this.f49109m;
    }

    public String j() {
        return this.f49104i;
    }

    public IDownloadListener k() {
        return this.rh;
    }

    public boolean kf() {
        return this.f49107k;
    }

    public boolean kz() {
        return this.fl;
    }

    public com.ss.android.socialbase.appdownloader.bl.n l() {
        return this.wv;
    }

    public boolean m() {
        return this.fb;
    }

    public boolean n() {
        return this.f49113q;
    }

    public int o() {
        return this.kz;
    }

    public String ok() {
        return this.bl;
    }

    public boolean p() {
        return this.f49106j;
    }

    public IDownloadListener q() {
        return this.f49122z;
    }

    public String qu() {
        return this.kf;
    }

    public boolean qx() {
        return this.tr;
    }

    public String r() {
        return this.f49116t;
    }

    public com.ss.android.socialbase.downloader.notification.ok rh() {
        return this.f49105io;
    }

    public String ry() {
        return this.f49119w;
    }

    public List<com.ss.android.socialbase.downloader.model.bl> s() {
        return this.f49112p;
    }

    public boolean sg() {
        return this.vz;
    }

    public com.ss.android.socialbase.downloader.downloader.p t() {
        return this.zz;
    }

    public boolean td() {
        return this.f49111o;
    }

    public String tg() {
        return this.ld;
    }

    public JSONObject to() {
        return this.cs;
    }

    public int tr() {
        return this.dx;
    }

    public String u() {
        return this.f49121y;
    }

    public long ul() {
        return this.ep;
    }

    public boolean v() {
        return this.f49101e;
    }

    public v vk() {
        return this.qx;
    }

    public boolean vz() {
        return this.f49118v;
    }

    public boolean w() {
        return this.to;
    }

    public IDownloadFileUriProvider wv() {
        return this.vk;
    }

    public boolean x() {
        return this.ul;
    }

    public y xy() {
        return this.ah;
    }

    public int y() {
        return this.er;
    }

    public List<z> yt() {
        return this.tg;
    }

    public boolean z() {
        return this.f49120x;
    }

    public int zz() {
        return this.ew;
    }

    public kf a(String str) {
        this.kf = str;
        return this;
    }

    public kf bl(@NonNull String str) {
        this.f49103h = str;
        return this;
    }

    public kf h(String str) {
        this.f49121y = str;
        return this;
    }

    public kf i(boolean z3) {
        this.de = z3;
        return this;
    }

    public kf j(boolean z3) {
        this.fd = z3;
        return this;
    }

    public kf k(boolean z3) {
        this.fl = z3;
        return this;
    }

    public kf kf(String str) {
        this.f49104i = str;
        return this;
    }

    public kf n(String str) {
        this.f49116t = str;
        return this;
    }

    public void ok(int i4) {
        this.ew = i4;
    }

    public kf p(String str) {
        this.f49109m = str;
        return this;
    }

    public kf q(String str) {
        this.f49102g = str;
        return this;
    }

    public kf r(boolean z3) {
        this.f49101e = z3;
        return this;
    }

    public kf rh(boolean z3) {
        this.vz = z3;
        return this;
    }

    public kf s(String str) {
        this.dn = str;
        return this;
    }

    public kf t(boolean z3) {
        this.ry = z3;
        return this;
    }

    public kf z(boolean z3) {
        this.xy = z3;
        return this;
    }

    public kf a(boolean z3) {
        this.f49107k = z3;
        return this;
    }

    public kf bl(boolean z3) {
        this.f49106j = z3;
        return this;
    }

    public kf h(boolean z3) {
        this.fb = z3;
        return this;
    }

    public kf k(String str) {
        this.ld = str;
        return this;
    }

    public kf kf(boolean z3) {
        this.f49111o = z3;
        return this;
    }

    public kf n(boolean z3) {
        this.ul = z3;
        return this;
    }

    public kf ok(String str) {
        this.f49110n = str;
        return this;
    }

    public kf p(boolean z3) {
        this.ej = z3;
        return this;
    }

    public kf q(boolean z3) {
        this.f49118v = z3;
        return this;
    }

    public kf r(String str) {
        this.f49119w = str;
        return this;
    }

    public kf s(boolean z3) {
        this.f49120x = z3;
        return this;
    }

    public kf a(int i4) {
        this.kz = i4;
        return this;
    }

    public kf bl(int i4) {
        this.er = i4;
        return this;
    }

    public kf kf(int i4) {
        this.dx = i4;
        return this;
    }

    public kf n(int i4) {
        this.qu = i4;
        return this;
    }

    public kf ok(List<com.ss.android.socialbase.downloader.model.bl> list) {
        this.f49112p = list;
        return this;
    }

    public kf s(int i4) {
        this.sg = i4;
        return this;
    }

    public kf a(List<String> list) {
        this.f49115s = list;
        return this;
    }

    public kf ok(boolean z3) {
        this.f49113q = z3;
        return this;
    }

    public kf ok(IDownloadListener iDownloadListener) {
        this.f49122z = iDownloadListener;
        return this;
    }

    public kf ok(long j4) {
        this.ep = j4;
        return this;
    }

    public kf ok(EnqueueType enqueueType) {
        this.em = enqueueType;
        return this;
    }

    public kf ok(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.vk = iDownloadFileUriProvider;
        return this;
    }

    public kf ok(td tdVar) {
        this.yt = tdVar;
        return this;
    }

    public kf ok(JSONObject jSONObject) {
        this.cs = jSONObject;
        return this;
    }

    public kf ok(z zVar) {
        synchronized (this.tg) {
            if (zVar != null) {
                if (!this.tg.contains(zVar)) {
                    this.tg.add(zVar);
                    return this;
                }
            }
            return this;
        }
    }
}
