package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv {

    /* renamed from: a  reason: collision with root package name */
    private final Object f48266a;
    private final String bk;

    /* renamed from: c  reason: collision with root package name */
    private String f48267c;
    private final JSONObject ev;

    /* renamed from: f  reason: collision with root package name */
    private final String f48268f;
    private final JSONObject fp;
    private final JSONObject gd;

    /* renamed from: k  reason: collision with root package name */
    private final int f48269k;

    /* renamed from: p  reason: collision with root package name */
    private final List<String> f48270p;

    /* renamed from: r  reason: collision with root package name */
    private final long f48271r;
    private final boolean sr;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f48272t;
    private final long ux;

    /* renamed from: w  reason: collision with root package name */
    private final String f48273w;
    private final String xv;
    private final String ys;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private int f48274a;
        private Object bk;

        /* renamed from: c  reason: collision with root package name */
        private String f48275c;
        private JSONObject ev;

        /* renamed from: f  reason: collision with root package name */
        private String f48276f;
        private String fp;
        private JSONObject gd;
        private JSONObject ia;

        /* renamed from: k  reason: collision with root package name */
        private List<String> f48277k;

        /* renamed from: p  reason: collision with root package name */
        private Map<String, Object> f48278p;

        /* renamed from: r  reason: collision with root package name */
        private long f48279r;

        /* renamed from: t  reason: collision with root package name */
        private String f48280t;
        private long ux;

        /* renamed from: w  reason: collision with root package name */
        private String f48281w;
        private String xv;
        private boolean sr = false;
        private boolean ys = false;

        public c c(boolean z3) {
            this.ys = z3;
            return this;
        }

        public c sr(String str) {
            this.f48280t = str;
            return this;
        }

        public c w(String str) {
            this.xv = str;
            return this;
        }

        public c xv(String str) {
            this.f48276f = str;
            return this;
        }

        public c c(String str) {
            this.f48281w = str;
            return this;
        }

        public c w(long j4) {
            this.f48279r = j4;
            return this;
        }

        public c c(long j4) {
            this.ux = j4;
            return this;
        }

        public c w(boolean z3) {
            this.sr = z3;
            return this;
        }

        public c c(JSONObject jSONObject) {
            this.ev = jSONObject;
            return this;
        }

        public c w(JSONObject jSONObject) {
            this.gd = jSONObject;
            return this;
        }

        public c c(List<String> list) {
            this.f48277k = list;
            return this;
        }

        public c c(int i4) {
            this.f48274a = i4;
            return this;
        }

        public c c(Object obj) {
            this.bk = obj;
            return this;
        }

        public xv c() {
            if (TextUtils.isEmpty(this.f48275c)) {
                this.f48275c = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.ev == null) {
                this.ev = new JSONObject();
            }
            try {
                Map<String, Object> map = this.f48278p;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f48278p.entrySet()) {
                        if (!this.ev.has(entry.getKey())) {
                            this.ev.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.ys) {
                    this.fp = this.xv;
                    JSONObject jSONObject2 = new JSONObject();
                    this.ia = jSONObject2;
                    if (this.sr) {
                        jSONObject2.put("ad_extra_data", this.ev.toString());
                    } else {
                        Iterator<String> keys = this.ev.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.ia.put(next, this.ev.get(next));
                        }
                    }
                    this.ia.put("category", this.f48275c);
                    this.ia.put("tag", this.f48281w);
                    this.ia.put("value", this.ux);
                    this.ia.put("ext_value", this.f48279r);
                    if (!TextUtils.isEmpty(this.f48280t)) {
                        this.ia.put("refer", this.f48280t);
                    }
                    JSONObject jSONObject3 = this.gd;
                    if (jSONObject3 != null) {
                        this.ia = com.ss.android.download.api.xv.w.c(jSONObject3, this.ia);
                    }
                    if (this.sr) {
                        if (!this.ia.has("log_extra") && !TextUtils.isEmpty(this.f48276f)) {
                            this.ia.put("log_extra", this.f48276f);
                        }
                        this.ia.put("is_ad_event", "1");
                    }
                }
                if (this.sr) {
                    jSONObject.put("ad_extra_data", this.ev.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f48276f)) {
                        jSONObject.put("log_extra", this.f48276f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.ev);
                }
                if (!TextUtils.isEmpty(this.f48280t)) {
                    jSONObject.putOpt("refer", this.f48280t);
                }
                JSONObject jSONObject4 = this.gd;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.xv.w.c(jSONObject4, jSONObject);
                }
                this.ev = jSONObject;
            } catch (Exception e4) {
                k.u().c(e4, "DownloadEventModel build");
            }
            return new xv(this);
        }
    }

    xv(c cVar) {
        this.f48267c = cVar.f48275c;
        this.f48273w = cVar.f48281w;
        this.xv = cVar.xv;
        this.sr = cVar.sr;
        this.ux = cVar.ux;
        this.f48268f = cVar.f48276f;
        this.f48271r = cVar.f48279r;
        this.ev = cVar.ev;
        this.gd = cVar.gd;
        this.f48270p = cVar.f48277k;
        this.f48269k = cVar.f48274a;
        this.f48266a = cVar.bk;
        this.f48272t = cVar.ys;
        this.ys = cVar.fp;
        this.fp = cVar.ia;
        this.bk = cVar.f48280t;
    }

    public Object a() {
        return this.f48266a;
    }

    public boolean bk() {
        return this.f48272t;
    }

    public String c() {
        return this.f48267c;
    }

    public JSONObject ev() {
        return this.ev;
    }

    public String f() {
        return this.f48268f;
    }

    public JSONObject gd() {
        return this.gd;
    }

    public int k() {
        return this.f48269k;
    }

    public List<String> p() {
        return this.f48270p;
    }

    public long r() {
        return this.f48271r;
    }

    public boolean sr() {
        return this.sr;
    }

    public String t() {
        return this.ys;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f48267c);
        sb.append("\ttag: ");
        sb.append(this.f48273w);
        sb.append("\tlabel: ");
        sb.append(this.xv);
        sb.append("\nisAd: ");
        sb.append(this.sr);
        sb.append("\tadId: ");
        sb.append(this.ux);
        sb.append("\tlogExtra: ");
        sb.append(this.f48268f);
        sb.append("\textValue: ");
        sb.append(this.f48271r);
        sb.append("\nextJson: ");
        sb.append(this.ev);
        sb.append("\nparamsJson: ");
        sb.append(this.gd);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f48270p;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.f48269k);
        sb.append("\textraObject: ");
        Object obj = this.f48266a;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.f48272t);
        sb.append("\tV3EventName: ");
        sb.append(this.ys);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.fp;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    public long ux() {
        return this.ux;
    }

    public String w() {
        return this.f48273w;
    }

    public String xv() {
        return this.xv;
    }

    public JSONObject ys() {
        return this.fp;
    }
}
