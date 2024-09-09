package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    private final String f48215a;
    private final String bl;

    /* renamed from: h  reason: collision with root package name */
    private final long f48216h;

    /* renamed from: i  reason: collision with root package name */
    private final JSONObject f48217i;

    /* renamed from: j  reason: collision with root package name */
    private final Object f48218j;

    /* renamed from: k  reason: collision with root package name */
    private final List<String> f48219k;
    private final String kf;

    /* renamed from: n  reason: collision with root package name */
    private final long f48220n;
    private String ok;

    /* renamed from: p  reason: collision with root package name */
    private final JSONObject f48221p;

    /* renamed from: q  reason: collision with root package name */
    private final JSONObject f48222q;

    /* renamed from: r  reason: collision with root package name */
    private final int f48223r;
    private final boolean rh;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f48224s;

    /* renamed from: t  reason: collision with root package name */
    private final String f48225t;

    /* renamed from: z  reason: collision with root package name */
    private final String f48226z;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        private String f48227a;
        private String bl;

        /* renamed from: h  reason: collision with root package name */
        private long f48228h;

        /* renamed from: i  reason: collision with root package name */
        private String f48229i;

        /* renamed from: j  reason: collision with root package name */
        private int f48230j;

        /* renamed from: k  reason: collision with root package name */
        private Map<String, Object> f48231k;
        private String kf;

        /* renamed from: n  reason: collision with root package name */
        private long f48232n;
        private String ok;

        /* renamed from: p  reason: collision with root package name */
        private JSONObject f48233p;

        /* renamed from: q  reason: collision with root package name */
        private JSONObject f48234q;

        /* renamed from: r  reason: collision with root package name */
        private List<String> f48235r;
        private String rh;

        /* renamed from: s  reason: collision with root package name */
        private boolean f48236s = false;

        /* renamed from: t  reason: collision with root package name */
        private boolean f48237t = false;

        /* renamed from: x  reason: collision with root package name */
        private JSONObject f48238x;

        /* renamed from: z  reason: collision with root package name */
        private Object f48239z;

        public ok a(String str) {
            this.bl = str;
            return this;
        }

        public ok bl(String str) {
            this.kf = str;
            return this;
        }

        public ok ok(boolean z3) {
            this.f48237t = z3;
            return this;
        }

        public ok s(String str) {
            this.rh = str;
            return this;
        }

        public ok a(long j4) {
            this.f48228h = j4;
            return this;
        }

        public ok ok(String str) {
            this.f48227a = str;
            return this;
        }

        public ok a(boolean z3) {
            this.f48236s = z3;
            return this;
        }

        public ok ok(long j4) {
            this.f48232n = j4;
            return this;
        }

        public ok a(JSONObject jSONObject) {
            this.f48234q = jSONObject;
            return this;
        }

        public ok ok(JSONObject jSONObject) {
            this.f48233p = jSONObject;
            return this;
        }

        public ok ok(List<String> list) {
            this.f48235r = list;
            return this;
        }

        public ok ok(int i4) {
            this.f48230j = i4;
            return this;
        }

        public ok ok(Object obj) {
            this.f48239z = obj;
            return this;
        }

        public bl ok() {
            if (TextUtils.isEmpty(this.ok)) {
                this.ok = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f48233p == null) {
                this.f48233p = new JSONObject();
            }
            try {
                Map<String, Object> map = this.f48231k;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f48231k.entrySet()) {
                        if (!this.f48233p.has(entry.getKey())) {
                            this.f48233p.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.f48237t) {
                    this.f48229i = this.bl;
                    JSONObject jSONObject2 = new JSONObject();
                    this.f48238x = jSONObject2;
                    if (this.f48236s) {
                        jSONObject2.put("ad_extra_data", this.f48233p.toString());
                    } else {
                        Iterator<String> keys = this.f48233p.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.f48238x.put(next, this.f48233p.get(next));
                        }
                    }
                    this.f48238x.put("category", this.ok);
                    this.f48238x.put("tag", this.f48227a);
                    this.f48238x.put("value", this.f48232n);
                    this.f48238x.put("ext_value", this.f48228h);
                    if (!TextUtils.isEmpty(this.rh)) {
                        this.f48238x.put("refer", this.rh);
                    }
                    JSONObject jSONObject3 = this.f48234q;
                    if (jSONObject3 != null) {
                        this.f48238x = com.ss.android.download.api.bl.a.ok(jSONObject3, this.f48238x);
                    }
                    if (this.f48236s) {
                        if (!this.f48238x.has("log_extra") && !TextUtils.isEmpty(this.kf)) {
                            this.f48238x.put("log_extra", this.kf);
                        }
                        this.f48238x.put("is_ad_event", "1");
                    }
                }
                if (this.f48236s) {
                    jSONObject.put("ad_extra_data", this.f48233p.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.kf)) {
                        jSONObject.put("log_extra", this.kf);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f48233p);
                }
                if (!TextUtils.isEmpty(this.rh)) {
                    jSONObject.putOpt("refer", this.rh);
                }
                JSONObject jSONObject4 = this.f48234q;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.bl.a.ok(jSONObject4, jSONObject);
                }
                this.f48233p = jSONObject;
            } catch (Exception e4) {
                r.u().ok(e4, "DownloadEventModel build");
            }
            return new bl(this);
        }
    }

    bl(ok okVar) {
        this.ok = okVar.ok;
        this.f48215a = okVar.f48227a;
        this.bl = okVar.bl;
        this.f48224s = okVar.f48236s;
        this.f48220n = okVar.f48232n;
        this.kf = okVar.kf;
        this.f48216h = okVar.f48228h;
        this.f48221p = okVar.f48233p;
        this.f48222q = okVar.f48234q;
        this.f48219k = okVar.f48235r;
        this.f48223r = okVar.f48230j;
        this.f48218j = okVar.f48239z;
        this.rh = okVar.f48237t;
        this.f48225t = okVar.f48229i;
        this.f48217i = okVar.f48238x;
        this.f48226z = okVar.rh;
    }

    public String a() {
        return this.f48215a;
    }

    public String bl() {
        return this.bl;
    }

    public long h() {
        return this.f48216h;
    }

    public Object j() {
        return this.f48218j;
    }

    public List<String> k() {
        return this.f48219k;
    }

    public String kf() {
        return this.kf;
    }

    public long n() {
        return this.f48220n;
    }

    public String ok() {
        return this.ok;
    }

    public JSONObject p() {
        return this.f48221p;
    }

    public JSONObject q() {
        return this.f48222q;
    }

    public int r() {
        return this.f48223r;
    }

    public String rh() {
        return this.f48225t;
    }

    public boolean s() {
        return this.f48224s;
    }

    public JSONObject t() {
        return this.f48217i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.ok);
        sb.append("\ttag: ");
        sb.append(this.f48215a);
        sb.append("\tlabel: ");
        sb.append(this.bl);
        sb.append("\nisAd: ");
        sb.append(this.f48224s);
        sb.append("\tadId: ");
        sb.append(this.f48220n);
        sb.append("\tlogExtra: ");
        sb.append(this.kf);
        sb.append("\textValue: ");
        sb.append(this.f48216h);
        sb.append("\nextJson: ");
        sb.append(this.f48221p);
        sb.append("\nparamsJson: ");
        sb.append(this.f48222q);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f48219k;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.f48223r);
        sb.append("\textraObject: ");
        Object obj = this.f48218j;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.rh);
        sb.append("\tV3EventName: ");
        sb.append(this.f48225t);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.f48217i;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    public boolean z() {
        return this.rh;
    }
}
