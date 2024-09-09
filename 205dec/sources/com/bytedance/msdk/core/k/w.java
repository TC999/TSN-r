package com.bytedance.msdk.core.k;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.f.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    private int au;
    private int ba;
    private com.bytedance.msdk.core.gd.r bw;

    /* renamed from: c  reason: collision with root package name */
    private String f28067c;
    private boolean ck;
    private int eq;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private long f28068f;
    private int fp;
    private String fz;
    private int gb;
    private int gw;

    /* renamed from: i  reason: collision with root package name */
    private int f28069i;
    private long ia;

    /* renamed from: j  reason: collision with root package name */
    private int f28070j;
    private String ls;

    /* renamed from: m  reason: collision with root package name */
    private JSONObject f28072m;
    private int me;
    private double mt;

    /* renamed from: n  reason: collision with root package name */
    private long f28073n;
    private long oo;
    private com.bytedance.msdk.core.gd.gd pr;

    /* renamed from: q  reason: collision with root package name */
    private int f28075q;

    /* renamed from: r  reason: collision with root package name */
    private long f28076r;

    /* renamed from: s  reason: collision with root package name */
    private int f28077s;
    private long sr;

    /* renamed from: u  reason: collision with root package name */
    private String f28079u;
    private double up;
    private long ux;

    /* renamed from: w  reason: collision with root package name */
    private int f28080w;
    private int wv;
    private int wx;

    /* renamed from: x  reason: collision with root package name */
    private int f28081x;
    private int xk;
    private int xv;

    /* renamed from: y  reason: collision with root package name */
    private double f28082y;
    private int ys;
    private int yu;

    /* renamed from: z  reason: collision with root package name */
    private boolean f28083z;
    private List<p> gd = new CopyOnWriteArrayList();

    /* renamed from: p  reason: collision with root package name */
    private Map<Integer, List<p>> f28074p = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private Map<Integer, List<p>> f28071k = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f28065a = new ArrayList();
    private double bk = -1.0d;

    /* renamed from: t  reason: collision with root package name */
    private double f28078t = -1.0d;
    private int vc = 1000;
    private int bj = 0;
    private int bm = 2;

    /* renamed from: b  reason: collision with root package name */
    private int f28066b = 0;
    private Map<String, Object> wo = new HashMap();

    public boolean a() {
        return this.f28081x == 1;
    }

    public int au() {
        return this.xk;
    }

    public String ba() {
        return this.fz;
    }

    public int bj() {
        return this.f28066b;
    }

    public int bk() {
        return this.bj;
    }

    public long bw() {
        return this.f28068f;
    }

    public int c() {
        return this.au;
    }

    public long ck() {
        return this.ia;
    }

    public boolean eq() {
        return this.f28083z;
    }

    public com.bytedance.msdk.core.gd.r ev() {
        return this.bw;
    }

    public int f() {
        return this.gw;
    }

    /* renamed from: fp */
    public w clone() {
        w wVar = new w();
        wVar.f28067c = this.f28067c;
        wVar.f28080w = this.f28080w;
        wVar.xv = this.xv;
        wVar.sr = this.sr;
        wVar.ux = this.ux;
        wVar.f28068f = this.f28068f;
        wVar.f28076r = this.f28076r;
        wVar.ev = this.ev;
        wVar.ia = this.ia;
        wVar.f28070j = this.f28070j;
        wVar.f28079u = this.f28079u;
        wVar.f28077s = this.f28077s;
        wVar.fz = this.fz;
        wVar.f28069i = this.f28069i;
        wVar.f28075q = this.f28075q;
        wVar.ls = this.ls;
        wVar.gb = this.gb;
        wVar.f28073n = this.f28073n;
        wVar.ba = this.ba;
        wVar.f28082y = this.f28082y;
        wVar.wv = this.wv;
        wVar.xk = this.xk;
        wVar.yu = this.yu;
        wVar.eq = this.eq;
        wVar.me = this.me;
        wVar.f28081x = this.f28081x;
        wVar.bw = this.bw;
        wVar.pr = this.pr;
        wVar.wx = this.wx;
        wVar.ck = this.ck;
        wVar.f28083z = this.f28083z;
        wVar.f28072m = this.f28072m;
        wVar.bk = this.bk;
        wVar.fp = this.fp;
        wVar.gd = new CopyOnWriteArrayList(this.gd);
        wVar.f28074p = new HashMap(this.f28074p);
        wVar.ys = this.ys;
        wVar.f28065a = new ArrayList(this.f28065a);
        wVar.wo = new HashMap(this.wo);
        wVar.f28071k = new HashMap(this.f28071k);
        wVar.gw = this.gw;
        wVar.vc = this.vc;
        wVar.f28078t = this.f28078t;
        wVar.oo = this.oo;
        wVar.up = this.up;
        wVar.mt = this.mt;
        wVar.bj = this.bj;
        wVar.bm = this.bm;
        wVar.f28066b = this.f28066b;
        return wVar;
    }

    public String fz() {
        return this.ls;
    }

    public double gb() {
        return this.f28078t;
    }

    public com.bytedance.msdk.core.gd.gd gd() {
        return this.pr;
    }

    public int gw() {
        return this.me;
    }

    public long i() {
        return this.f28073n;
    }

    public int ia() {
        return this.yu;
    }

    public int j() {
        return this.fp;
    }

    public boolean k() {
        return this.wv == 3;
    }

    public double ls() {
        return this.bk;
    }

    public int m() {
        return this.eq;
    }

    public String me() {
        return this.ev;
    }

    public String mt() {
        return this.f28079u;
    }

    public Map<Integer, List<p>> n() {
        HashMap hashMap = new HashMap();
        Map<Integer, List<p>> map = this.f28074p;
        if (map != null) {
            for (Map.Entry<Integer, List<p>> entry : map.entrySet()) {
                hashMap.put(Integer.valueOf(entry.getKey().intValue()), new ArrayList(entry.getValue()));
            }
        }
        return hashMap;
    }

    public int oo() {
        return this.wv;
    }

    public boolean p() {
        return this.wx == 1;
    }

    public long pr() {
        return this.ux;
    }

    public int q() {
        return this.f28070j;
    }

    public int r() {
        int min = Math.min(this.vc, 1000);
        if (min <= 0) {
            return 1000;
        }
        return min;
    }

    public double s() {
        return this.f28082y;
    }

    public long sr() {
        return this.oo;
    }

    public int t() {
        int i4 = this.bm;
        if (i4 < 2) {
            return 2;
        }
        return i4;
    }

    public String toString() {
        return "AdsenseRitConfig{mRitId='" + this.f28067c + "', mIsSpeed=" + k() + ", mHasServerbidding=" + this.ck + ", mHasClientOrMultiLevel=" + this.f28083z + ", mRitType=" + this.f28080w + ", mLookType=" + this.xv + ", mMinWaitTime=" + this.sr + ", mLayerTimeOut=" + this.ux + ", mTotalTimeOut=" + this.f28068f + ", mWaterFallConfigList=" + this.gd + ", mWaterFallConfMap=" + this.f28074p + ", mLoadSortLevelList=" + this.f28065a + ", mCurrentCommonAdMaxCpm=" + this.bk + ", mTotalLoadLevelCount=" + this.ys + ", mTotalWaterFallCount=" + this.fp + ", mWaterfallAbTestParam=" + this.f28079u + ", mServerSideVerifyPreRequestTime=" + this.eq + ", mServerSideVerifyRewardType=" + this.me + '}';
    }

    public int u() {
        return this.gb;
    }

    public List<p> up() {
        return this.gd;
    }

    public Map<String, Object> ux() {
        return this.wo;
    }

    public Map<Integer, List<p>> vc() {
        return this.f28071k;
    }

    public double w() {
        return this.mt;
    }

    public List<Integer> wv() {
        return this.f28065a;
    }

    public long wx() {
        return this.sr;
    }

    public long x() {
        return this.f28076r;
    }

    public String xk() {
        return this.f28067c;
    }

    public double xv() {
        return this.up;
    }

    public boolean y() {
        return this.ck;
    }

    public w ys() {
        List<String> c4 = a.c();
        w wVar = new w();
        wVar.f28067c = this.f28067c;
        a.c(c4, "mRitId");
        wVar.f28080w = this.f28080w;
        a.c(c4, "mRitType");
        wVar.xv = this.xv;
        a.c(c4, "mLookType");
        wVar.sr = this.sr;
        a.c(c4, "mMinWaitTime");
        wVar.ux = this.ux;
        a.c(c4, "mLayerTimeOut");
        wVar.f28068f = this.f28068f;
        a.c(c4, "mTotalTimeOut");
        wVar.f28076r = this.f28076r;
        a.c(c4, "mCacheTimeOut");
        wVar.ev = this.ev;
        a.c(c4, "mVersion");
        wVar.ia = this.ia;
        a.c(c4, "mWaterFallId");
        wVar.f28070j = this.f28070j;
        a.c(c4, "reqType");
        wVar.f28079u = this.f28079u;
        a.c(c4, "mWaterfallAbTestParam");
        wVar.f28077s = this.f28077s;
        a.c(c4, "segmentId");
        wVar.fz = this.fz;
        a.c(c4, "segmentVersion");
        wVar.f28069i = this.f28069i;
        a.c(c4, "preLoadSortControl");
        wVar.f28075q = this.f28075q;
        a.c(c4, "preShowSortControl");
        wVar.ls = this.ls;
        a.c(c4, "waterfallExtra");
        wVar.gb = this.gb;
        a.c(c4, "mMultilevelAfterP");
        wVar.f28073n = this.f28073n;
        a.c(c4, "mMultilevelTimeOut");
        wVar.ba = this.ba;
        a.c(c4, "mRefreshTime");
        wVar.f28082y = this.f28082y;
        a.c(c4, "mBidFloor");
        wVar.wv = this.wv;
        a.c(c4, "mParallelType");
        wVar.xk = this.xk;
        a.c(c4, "mReqParallelNum");
        wVar.yu = this.yu;
        a.c(c4, "mAdCount");
        wVar.eq = this.eq;
        a.c(c4, "serverSideVerifyPreRequestTime");
        wVar.me = this.me;
        a.c(c4, "serverSideRewardType");
        wVar.f28081x = this.f28081x;
        a.c(c4, "mAdPrime");
        wVar.bm = this.bm;
        a.c(c4, "mRefreshNum");
        wVar.bj = this.bj;
        a.c(c4, "mIsRefresh");
        wVar.bw = this.bw;
        a.c(c4, "mIntervalFreqctlBean");
        wVar.pr = this.pr;
        a.c(c4, "mIntervalPacingBean");
        wVar.wx = this.wx;
        a.c(c4, "mWaterFallTimingMode");
        wVar.oo = this.oo;
        a.c(c4, "mReqInterval");
        wVar.up = this.up;
        a.c(c4, "mTotalTimeoutRate");
        wVar.mt = this.mt;
        a.c(c4, "mLayerTimeoutRate");
        wVar.wo = new HashMap(this.wo);
        wVar.gw = this.gw;
        wVar.vc = this.vc;
        wVar.f28078t = this.f28078t;
        wVar.f28071k = new HashMap(this.f28071k);
        a.w(c4, "AdsenseRitConfig");
        wVar.f28066b = this.f28066b;
        a.c(c4, "mBehaviorTTL");
        return wVar;
    }

    public int yu() {
        return this.f28080w;
    }

    public int z() {
        return this.f28077s;
    }

    private static Long i(int i4) {
        if (i4 != 1) {
            if (i4 != 2 && i4 != 3) {
                if (i4 != 5) {
                    if (i4 != 7 && i4 != 8) {
                        return 0L;
                    }
                }
            }
            return 0L;
        }
        return 1000L;
    }

    private static Long q(int i4) {
        if (i4 != 1 && i4 != 2) {
            if (i4 == 3) {
                return 5000L;
            }
            if (i4 != 5) {
                if (i4 != 7 && i4 != 8) {
                    return Long.valueOf((long) ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                }
                return 600000L;
            }
        }
        return Long.valueOf((long) ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    public void a(int i4) {
        this.f28070j = i4;
    }

    public void bk(int i4) {
        this.f28077s = i4;
    }

    public void c(int i4) {
        this.au = i4;
    }

    public void ev(int i4) {
        this.yu = i4;
    }

    public void f(int i4) {
        this.bj = i4;
    }

    public void fz(int i4) {
        this.xk = i4;
    }

    public int gd(int i4) {
        if (f() == 2) {
            int c4 = com.bytedance.msdk.core.p.sr.c(this.f28067c, i4, ux());
            if (this.ba != 0 && c4 != 0) {
                return c4;
            }
        }
        return this.ba;
    }

    public void ia(int i4) {
        this.me = i4;
    }

    public void k(int i4) {
        this.gb = i4;
    }

    public void p(int i4) {
        this.ba = i4;
    }

    public void r(int i4) {
        this.bm = i4;
    }

    public void s(int i4) {
        this.wv = i4;
    }

    public void sr(int i4) {
        this.f28081x = i4;
    }

    public void t(int i4) {
        this.f28080w = i4;
    }

    public void u(int i4) {
        this.f28066b = i4;
    }

    public void ux(int i4) {
        this.wx = i4;
    }

    public void w(double d4) {
        if (d4 < 0.01d || d4 > 1.0d) {
            d4 = 0.01d;
        }
        this.up = d4;
    }

    public void xv(int i4) {
        this.vc = i4;
    }

    public void c(double d4) {
        if (d4 < 0.1d || d4 > 1.0d) {
            d4 = 0.1d;
        }
        this.mt = d4;
    }

    public void f(long j4) {
        this.f28068f = j4;
    }

    public void r(long j4) {
        this.f28076r = j4;
    }

    public void sr(double d4) {
        this.bk = d4;
    }

    public void ux(double d4) {
        this.f28078t = d4;
    }

    public void w(int i4) {
        this.gw = i4;
    }

    public void xv(double d4) {
        this.f28082y = d4;
    }

    public static w r(String str) {
        if (TextUtils.isEmpty(str)) {
            com.bytedance.msdk.adapter.sr.xv.c("AdsenseRitConfig", "TMe jsonStr is null or empty");
            return null;
        }
        try {
            return w(new JSONObject(str));
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void c(long j4) {
        if (j4 < 1000) {
            j4 = 1000;
        }
        this.oo = j4;
    }

    public p f(String str) {
        List<p> list;
        if (!TextUtils.isEmpty(str) && (list = this.gd) != null && list.size() != 0) {
            for (p pVar : this.gd) {
                if (str.equals(pVar.ia())) {
                    return pVar;
                }
            }
        }
        return null;
    }

    public void sr(String str) {
        this.f28067c = str;
    }

    public void ux(long j4) {
        this.ux = j4;
    }

    public void w(long j4) {
        this.f28073n = j4;
    }

    public void xv(long j4) {
        this.ia = j4;
    }

    public void c(com.bytedance.msdk.core.gd.r rVar) {
        this.bw = rVar;
    }

    public void sr(long j4) {
        this.sr = j4;
    }

    public void ux(String str) {
        this.f28079u = str;
    }

    public void w(String str) {
        this.fz = str;
    }

    public void xv(String str) {
        this.ev = str;
    }

    private void sr(List<p> list) {
        int i4;
        List<p> list2;
        if (list == null) {
            return;
        }
        this.f28071k.clear();
        int i5 = -1000;
        for (int i6 = 0; i6 < list.size(); i6++) {
            p pVar = list.get(i6);
            if (pVar != null) {
                if (pVar.j() != i5) {
                    list2 = new ArrayList<>();
                    i4 = pVar.j();
                } else {
                    i4 = i5;
                    list2 = this.f28071k.get(Integer.valueOf(i5));
                }
                if (list2 != null) {
                    list2.add(pVar);
                    this.f28071k.put(Integer.valueOf(i4), list2);
                }
                i5 = i4;
            }
        }
    }

    private void xv(List<p> list) {
        ArrayList arrayList;
        int ls;
        if (list == null) {
            return;
        }
        this.f28071k.clear();
        int i4 = -1000;
        for (int i5 = 0; i5 < list.size(); i5++) {
            p pVar = list.get(i5);
            if (pVar != null) {
                if (pVar.s() != 100 && pVar.s() != 0) {
                    if (pVar.j() != i4) {
                        arrayList = new ArrayList();
                        ls = pVar.j();
                    } else {
                        ls = i4;
                        arrayList = this.f28071k.get(Integer.valueOf(i4));
                    }
                } else {
                    arrayList = new ArrayList();
                    ls = pVar.ls();
                }
                if (arrayList != null) {
                    arrayList.add(pVar);
                    this.f28071k.put(Integer.valueOf(ls), arrayList);
                }
                i4 = ls;
            }
        }
    }

    public void c(com.bytedance.msdk.core.gd.gd gdVar) {
        this.pr = gdVar;
    }

    public void w(boolean z3) {
        this.f28083z = z3;
    }

    public void c(String str) {
        this.ls = str;
    }

    public void w(List<p> list) {
        ArrayList arrayList;
        int ls;
        xv(list);
        this.gd = list;
        if (list == null) {
            return;
        }
        this.ys = 0;
        this.f28074p.clear();
        this.f28065a.clear();
        this.fp = this.gd.size();
        int i4 = -1000;
        for (int i5 = 0; i5 < this.gd.size(); i5++) {
            p pVar = list.get(i5);
            if (pVar != null) {
                if (pVar.s() != 100 && pVar.s() != 0) {
                    if (pVar.j() != i4) {
                        this.ys++;
                        arrayList = new ArrayList();
                        ls = pVar.j();
                    } else {
                        ls = i4;
                        arrayList = this.f28074p.get(Integer.valueOf(i4));
                    }
                } else {
                    this.ys++;
                    arrayList = new ArrayList();
                    ls = pVar.ls();
                }
                if (arrayList != null) {
                    arrayList.add(pVar);
                    this.f28074p.put(Integer.valueOf(ls), arrayList);
                }
                i4 = ls;
            }
        }
        this.f28065a.addAll(this.f28074p.keySet());
    }

    public void c(boolean z3) {
        this.ck = z3;
    }

    public void c(List<p> list) {
        int i4;
        List<p> list2;
        sr(list);
        this.gd = list;
        if (list == null) {
            return;
        }
        this.ys = 0;
        this.f28074p.clear();
        this.f28065a.clear();
        this.fp = this.gd.size();
        int i5 = -1000;
        for (int i6 = 0; i6 < this.gd.size(); i6++) {
            p pVar = list.get(i6);
            if (pVar != null) {
                if (pVar.j() != i5) {
                    this.ys++;
                    list2 = new ArrayList<>();
                    i4 = pVar.j();
                } else {
                    i4 = i5;
                    list2 = this.f28074p.get(Integer.valueOf(i5));
                }
                if (list2 != null) {
                    list2.add(pVar);
                    this.f28074p.put(Integer.valueOf(i4), list2);
                }
                i5 = i4;
            }
        }
        this.f28065a.addAll(this.f28074p.keySet());
    }

    private static Map<String, String> xv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            if (keys == null) {
                return null;
            }
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            }
            if (hashMap.size() == 0) {
                return null;
            }
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public void c(JSONObject jSONObject) {
        this.f28072m = jSONObject;
    }

    public static w w(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        p pVar;
        String str2;
        if (jSONObject != null) {
            w wVar = new w();
            wVar.c(jSONObject);
            wVar.xv(jSONObject.optDouble("bid_floor", 0.0d));
            wVar.sr(jSONObject.optString("rit_id"));
            wVar.xv(jSONObject.optString("version"));
            wVar.xv(jSONObject.optLong("waterfall_id", -1L));
            wVar.t(jSONObject.optInt("rit_type"));
            wVar.ys(jSONObject.optInt("look_type", 1));
            wVar.sr(jSONObject.optLong("time_min", i(wVar.yu()).longValue()));
            wVar.ux(jSONObject.optLong("layer_time_out", 2000L));
            wVar.f(jSONObject.optLong("total_time_out", q(wVar.yu()).longValue()));
            wVar.w(jSONObject.optLong("multilevel_time_out", 2000L));
            wVar.r(jSONObject.optLong("cache_time_out", 3000L));
            wVar.a(jSONObject.optInt("req_type", 0));
            com.bytedance.msdk.core.ux.w.w.c().c(wVar.xk(), wVar.q());
            wVar.bk(jSONObject.optInt("segment_id"));
            wVar.w(jSONObject.optString("segment_version"));
            wVar.c(jSONObject.optString("waterfall_extra"));
            wVar.k(jSONObject.optInt("multilevel_after_p", 1));
            wVar.p(jSONObject.optInt(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME, 0));
            wVar.f(jSONObject.optInt("is_refresh", 0));
            wVar.r(jSONObject.optInt("refresh_num", 2));
            wVar.s(jSONObject.optInt("parallel_type", 1));
            wVar.sr(jSONObject.optInt("is_adprime", 0));
            wVar.fz(jSONObject.optInt("req_parallel_num", 2));
            wVar.fp(jSONObject.optInt("reward_start_time", 15000));
            wVar.ia(jSONObject.optInt("reward_callback_type"));
            wVar.c(jSONObject.optLong("req_interval", 1000L));
            wVar.w(jSONObject.optDouble("total_time_rate", 0.01d));
            wVar.c(jSONObject.optDouble("layer_time_rate", 0.1d));
            wVar.c(jSONObject.optInt("support_render_control", 0));
            wVar.u(jSONObject.optInt("behavior_ttl"));
            int optInt = jSONObject.optInt("ad_count", 0);
            if (optInt < 0) {
                optInt = 0;
            } else if (optInt > 3) {
                optInt = 3;
            }
            wVar.ev(optInt);
            wVar.w(jSONObject.optInt("group_type"));
            wVar.xv(jSONObject.optInt("bidding_time_out", 1000));
            String optString = jSONObject.optString("waterfall_abtest");
            if (optString != null) {
                wVar.ux(optString);
            }
            int optInt2 = jSONObject.optInt("waterfall_timing_mode");
            wVar.ux(optInt2);
            if (wVar.p()) {
                JSONObject optJSONObject = jSONObject.optJSONObject("waterfall_show_pacing_rule");
                if (optJSONObject != null) {
                    str2 = "waterfall_show_rules_version";
                    str = "";
                    wVar.c(new com.bytedance.msdk.core.gd.gd(wVar.xk() + "", "", jSONObject.optString("waterfall_show_rules_version"), "", optInt2, optJSONObject.optString("waterfall_show_pacing"), optJSONObject.optString("waterfall_show_pacing_rule_id")));
                } else {
                    str2 = "waterfall_show_rules_version";
                    str = "";
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("waterfall_show_freqctl_rules");
                wVar.c(new com.bytedance.msdk.core.gd.r(wVar.xk() + str, "", jSONObject.optString(str2), "", optInt2, optJSONArray == null ? "[]" : optJSONArray.toString()));
            } else {
                str = "";
            }
            if (jSONObject.optInt("is_ra") == 1) {
                com.bytedance.msdk.core.admanager.reward.rewardagain.c cVar = new com.bytedance.msdk.core.admanager.reward.rewardagain.c();
                cVar.c(jSONObject.optString("ra_id"));
                cVar.w(jSONObject.optInt("ra_max", 0));
                cVar.w(jSONObject.optDouble("ra_ecpm"));
                cVar.c(jSONObject.optLong("ra_in", 0L));
                cVar.c(jSONObject.optInt("ra_h_max", 0));
                cVar.c(jSONObject.optDouble("ra_ra"));
                com.bytedance.msdk.core.admanager.reward.rewardagain.xv.c(wVar.xk(), cVar);
            } else {
                com.bytedance.msdk.core.admanager.reward.rewardagain.xv.p(wVar.xk());
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("adn_rit_conf");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    try {
                        jSONObject2 = optJSONArray2.getJSONObject(i4);
                        pVar = new p();
                        pVar.xv(jSONObject2.optString("adn_name"));
                        if (com.bytedance.msdk.core.c.w().xv(jSONObject2.optString("adn_name"))) {
                            pVar.sr(jSONObject2.optString("custom_adn_name"));
                        } else {
                            pVar.sr((String) null);
                        }
                        pVar.r(wVar.mt());
                        String optString2 = jSONObject2.optString("adn_slot_id");
                        pVar.ux(optString2);
                        int optInt3 = jSONObject2.optInt("freqctl_timing_mode");
                        pVar.c(optInt3);
                        if (pVar.xv()) {
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("show_pacing_rule");
                            if (optJSONObject2 != null) {
                                pVar.c(new com.bytedance.msdk.core.gd.gd(wVar.xk() + str, optString2, "", "", optInt3, optJSONObject2.optString("pacing"), optJSONObject2.optString("rule_id")));
                            }
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray("show_freqctl_rules");
                            pVar.c(new com.bytedance.msdk.core.gd.r(wVar.xk() + str, optString2, "", jSONObject2.optString("show_freqctl_rules_version"), optInt3, optJSONArray3 == null ? "[]" : optJSONArray3.toString()));
                        }
                        pVar.gd(jSONObject2.optInt("req_bidding_type"));
                        pVar.f(jSONObject2.optString("slot_cpm", "0"));
                        pVar.w(jSONObject2.optString("exchange_rate"));
                        pVar.p(jSONObject2.optInt("load_sort"));
                        pVar.k(jSONObject2.optInt("show_sort"));
                        pVar.xv(jSONObject2.optInt("ad_expired_time", 1800000));
                        com.bytedance.msdk.core.ux.w.w.c().c(wVar.xk(), pVar.ia(), pVar.r());
                        com.bytedance.msdk.core.ux.c.c.c().c(wVar.xk(), pVar.ia(), pVar.r());
                        pVar.r(jSONObject2.optInt("if_is_ready", 1));
                        com.bytedance.msdk.core.ux.w.w.c().w(wVar.xk(), pVar.ia(), pVar.k());
                        com.bytedance.msdk.core.ux.c.c.c().w(wVar.xk(), pVar.ia(), pVar.k());
                        pVar.sr(jSONObject2.optInt("if_reuse_ads", 0));
                        com.bytedance.msdk.core.ux.c.c.c().xv(wVar.xk(), pVar.ia(), pVar.ev());
                        pVar.f(jSONObject2.optInt("if_pre_request", 0));
                        com.bytedance.msdk.core.ux.c.c.c().f(wVar.xk(), pVar.ia(), pVar.p());
                        pVar.ev(wVar.yu());
                        pVar.c("%1$s%2$sAdapter");
                        pVar.ux(jSONObject2.optInt("origin_type"));
                        pVar.w(jSONObject2.optInt("sub_adtype"));
                        pVar.c(xv(jSONObject2.optJSONObject("multilevel_slot_cpm")));
                    } catch (JSONException e4) {
                        e = e4;
                    }
                    if (pVar.s() == 1) {
                        wVar.w(true);
                    } else if (pVar.s() == 2) {
                        try {
                            wVar.c(true);
                        } catch (JSONException e5) {
                            e = e5;
                            e.printStackTrace();
                        }
                    } else {
                        if (pVar.s() == 3) {
                            try {
                                wVar.w(true);
                            } catch (JSONException e6) {
                                e = e6;
                                e.printStackTrace();
                            }
                        } else if (pVar.s() != 100) {
                            if (wVar.ls() == -1.0d || wVar.ls() < pVar.q()) {
                                wVar.sr(pVar.q());
                            }
                            if (wVar.gb() == -1.0d || wVar.gb() > pVar.q()) {
                                wVar.ux(pVar.q());
                            }
                        }
                        pVar.gd(jSONObject2.optString("customer_adapter_json"));
                        arrayList.add(pVar);
                    }
                    pVar.gd(jSONObject2.optString("customer_adapter_json"));
                    arrayList.add(pVar);
                }
            }
            Collections.sort(arrayList);
            if (wVar.k()) {
                wVar.w(arrayList);
            } else {
                wVar.c(arrayList);
            }
            return wVar;
        }
        return null;
    }

    public void fp(int i4) {
        this.eq = i4;
    }

    public void ys(int i4) {
        this.xv = i4;
    }
}
