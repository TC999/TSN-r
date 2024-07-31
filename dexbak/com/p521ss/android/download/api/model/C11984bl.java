package com.p521ss.android.download.api.model;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.p521ss.android.download.api.p523bl.C11951a;
import com.p521ss.android.downloadlib.addownload.C12128r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.ss.android.download.api.model.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11984bl {

    /* renamed from: a */
    private final String f33873a;

    /* renamed from: bl */
    private final String f33874bl;

    /* renamed from: h */
    private final long f33875h;

    /* renamed from: i */
    private final JSONObject f33876i;

    /* renamed from: j */
    private final Object f33877j;

    /* renamed from: k */
    private final List<String> f33878k;

    /* renamed from: kf */
    private final String f33879kf;

    /* renamed from: n */
    private final long f33880n;

    /* renamed from: ok */
    private String f33881ok;

    /* renamed from: p */
    private final JSONObject f33882p;

    /* renamed from: q */
    private final JSONObject f33883q;

    /* renamed from: r */
    private final int f33884r;

    /* renamed from: rh */
    private final boolean f33885rh;

    /* renamed from: s */
    private final boolean f33886s;

    /* renamed from: t */
    private final String f33887t;

    /* renamed from: z */
    private final String f33888z;

    /* renamed from: com.ss.android.download.api.model.bl$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C11985ok {

        /* renamed from: a */
        private String f33889a;

        /* renamed from: bl */
        private String f33890bl;

        /* renamed from: h */
        private long f33891h;

        /* renamed from: i */
        private String f33892i;

        /* renamed from: j */
        private int f33893j;

        /* renamed from: k */
        private Map<String, Object> f33894k;

        /* renamed from: kf */
        private String f33895kf;

        /* renamed from: n */
        private long f33896n;

        /* renamed from: ok */
        private String f33897ok;

        /* renamed from: p */
        private JSONObject f33898p;

        /* renamed from: q */
        private JSONObject f33899q;

        /* renamed from: r */
        private List<String> f33900r;

        /* renamed from: rh */
        private String f33901rh;

        /* renamed from: s */
        private boolean f33902s = false;

        /* renamed from: t */
        private boolean f33903t = false;

        /* renamed from: x */
        private JSONObject f33904x;

        /* renamed from: z */
        private Object f33905z;

        /* renamed from: a */
        public C11985ok m19576a(String str) {
            this.f33890bl = str;
            return this;
        }

        /* renamed from: bl */
        public C11985ok m19572bl(String str) {
            this.f33895kf = str;
            return this;
        }

        /* renamed from: ok */
        public C11985ok m19557ok(boolean z) {
            this.f33903t = z;
            return this;
        }

        /* renamed from: s */
        public C11985ok m19551s(String str) {
            this.f33901rh = str;
            return this;
        }

        /* renamed from: a */
        public C11985ok m19578a(long j) {
            this.f33891h = j;
            return this;
        }

        /* renamed from: ok */
        public C11985ok m19560ok(String str) {
            this.f33889a = str;
            return this;
        }

        /* renamed from: a */
        public C11985ok m19574a(boolean z) {
            this.f33902s = z;
            return this;
        }

        /* renamed from: ok */
        public C11985ok m19563ok(long j) {
            this.f33896n = j;
            return this;
        }

        /* renamed from: a */
        public C11985ok m19575a(JSONObject jSONObject) {
            this.f33899q = jSONObject;
            return this;
        }

        /* renamed from: ok */
        public C11985ok m19558ok(JSONObject jSONObject) {
            this.f33898p = jSONObject;
            return this;
        }

        /* renamed from: ok */
        public C11985ok m19559ok(List<String> list) {
            this.f33900r = list;
            return this;
        }

        /* renamed from: ok */
        public C11985ok m19564ok(int i) {
            this.f33893j = i;
            return this;
        }

        /* renamed from: ok */
        public C11985ok m19561ok(Object obj) {
            this.f33905z = obj;
            return this;
        }

        /* renamed from: ok */
        public C11984bl m19565ok() {
            if (TextUtils.isEmpty(this.f33897ok)) {
                this.f33897ok = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f33898p == null) {
                this.f33898p = new JSONObject();
            }
            try {
                Map<String, Object> map = this.f33894k;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f33894k.entrySet()) {
                        if (!this.f33898p.has(entry.getKey())) {
                            this.f33898p.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.f33903t) {
                    this.f33892i = this.f33890bl;
                    JSONObject jSONObject2 = new JSONObject();
                    this.f33904x = jSONObject2;
                    if (this.f33902s) {
                        jSONObject2.put("ad_extra_data", this.f33898p.toString());
                    } else {
                        Iterator<String> keys = this.f33898p.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.f33904x.put(next, this.f33898p.get(next));
                        }
                    }
                    this.f33904x.put("category", this.f33897ok);
                    this.f33904x.put("tag", this.f33889a);
                    this.f33904x.put(DomainCampaignEx.LOOPBACK_VALUE, this.f33896n);
                    this.f33904x.put("ext_value", this.f33891h);
                    if (!TextUtils.isEmpty(this.f33901rh)) {
                        this.f33904x.put(TTDownloadField.TT_REFER, this.f33901rh);
                    }
                    JSONObject jSONObject3 = this.f33899q;
                    if (jSONObject3 != null) {
                        this.f33904x = C11951a.m19659ok(jSONObject3, this.f33904x);
                    }
                    if (this.f33902s) {
                        if (!this.f33904x.has("log_extra") && !TextUtils.isEmpty(this.f33895kf)) {
                            this.f33904x.put("log_extra", this.f33895kf);
                        }
                        this.f33904x.put("is_ad_event", "1");
                    }
                }
                if (this.f33902s) {
                    jSONObject.put("ad_extra_data", this.f33898p.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f33895kf)) {
                        jSONObject.put("log_extra", this.f33895kf);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f33898p);
                }
                if (!TextUtils.isEmpty(this.f33901rh)) {
                    jSONObject.putOpt(TTDownloadField.TT_REFER, this.f33901rh);
                }
                JSONObject jSONObject4 = this.f33899q;
                if (jSONObject4 != null) {
                    jSONObject = C11951a.m19659ok(jSONObject4, jSONObject);
                }
                this.f33898p = jSONObject;
            } catch (Exception e) {
                C12128r.m18940u().mo18637ok(e, "DownloadEventModel build");
            }
            return new C11984bl(this);
        }
    }

    C11984bl(C11985ok c11985ok) {
        this.f33881ok = c11985ok.f33897ok;
        this.f33873a = c11985ok.f33889a;
        this.f33874bl = c11985ok.f33890bl;
        this.f33886s = c11985ok.f33902s;
        this.f33880n = c11985ok.f33896n;
        this.f33879kf = c11985ok.f33895kf;
        this.f33875h = c11985ok.f33891h;
        this.f33882p = c11985ok.f33898p;
        this.f33883q = c11985ok.f33899q;
        this.f33878k = c11985ok.f33900r;
        this.f33884r = c11985ok.f33893j;
        this.f33877j = c11985ok.f33905z;
        this.f33885rh = c11985ok.f33903t;
        this.f33887t = c11985ok.f33892i;
        this.f33876i = c11985ok.f33904x;
        this.f33888z = c11985ok.f33901rh;
    }

    /* renamed from: a */
    public String m19593a() {
        return this.f33873a;
    }

    /* renamed from: bl */
    public String m19592bl() {
        return this.f33874bl;
    }

    /* renamed from: h */
    public long m19591h() {
        return this.f33875h;
    }

    /* renamed from: j */
    public Object m19590j() {
        return this.f33877j;
    }

    /* renamed from: k */
    public List<String> m19589k() {
        return this.f33878k;
    }

    /* renamed from: kf */
    public String m19588kf() {
        return this.f33879kf;
    }

    /* renamed from: n */
    public long m19587n() {
        return this.f33880n;
    }

    /* renamed from: ok */
    public String m19586ok() {
        return this.f33881ok;
    }

    /* renamed from: p */
    public JSONObject m19585p() {
        return this.f33882p;
    }

    /* renamed from: q */
    public JSONObject m19584q() {
        return this.f33883q;
    }

    /* renamed from: r */
    public int m19583r() {
        return this.f33884r;
    }

    /* renamed from: rh */
    public String m19582rh() {
        return this.f33887t;
    }

    /* renamed from: s */
    public boolean m19581s() {
        return this.f33886s;
    }

    /* renamed from: t */
    public JSONObject m19580t() {
        return this.f33876i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f33881ok);
        sb.append("\ttag: ");
        sb.append(this.f33873a);
        sb.append("\tlabel: ");
        sb.append(this.f33874bl);
        sb.append("\nisAd: ");
        sb.append(this.f33886s);
        sb.append("\tadId: ");
        sb.append(this.f33880n);
        sb.append("\tlogExtra: ");
        sb.append(this.f33879kf);
        sb.append("\textValue: ");
        sb.append(this.f33875h);
        sb.append("\nextJson: ");
        sb.append(this.f33882p);
        sb.append("\nparamsJson: ");
        sb.append(this.f33883q);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f33878k;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.f33884r);
        sb.append("\textraObject: ");
        Object obj = this.f33877j;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.f33885rh);
        sb.append("\tV3EventName: ");
        sb.append(this.f33887t);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.f33876i;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    /* renamed from: z */
    public boolean m19579z() {
        return this.f33885rh;
    }
}
