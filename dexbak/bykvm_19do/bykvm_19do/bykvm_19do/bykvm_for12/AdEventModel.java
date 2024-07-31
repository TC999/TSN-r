package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdEventModel {

    /* renamed from: a */
    protected String f576a;

    /* renamed from: b */
    protected String f577b;

    /* renamed from: c */
    protected String f578c;

    /* renamed from: d */
    protected String f579d;

    /* renamed from: e */
    protected String f580e;

    /* renamed from: f */
    protected String f581f;

    /* renamed from: g */
    protected String f582g;

    /* renamed from: h */
    protected String f583h;

    /* renamed from: i */
    protected long f584i;

    /* renamed from: j */
    protected String f585j;

    /* renamed from: k */
    protected String f586k;

    /* renamed from: l */
    protected String f587l;

    /* renamed from: m */
    protected String f588m;

    /* renamed from: n */
    protected int f589n;

    /* renamed from: o */
    protected String f590o;

    /* renamed from: p */
    protected String f591p;

    /* renamed from: q */
    protected int f592q;

    /* renamed from: r */
    protected long f593r;

    /* renamed from: u */
    protected String f596u;

    /* renamed from: s */
    protected int f594s = -1;

    /* renamed from: t */
    protected int f595t = -1;

    /* renamed from: v */
    protected Map<String, Object> f597v = new HashMap();

    protected AdEventModel() {
    }

    /* renamed from: a */
    public static AdEventModel m59380a() {
        return new AdEventModel();
    }

    /* renamed from: a */
    public AdEventModel m59379a(int i) {
        this.f588m = String.valueOf(i);
        return this;
    }

    /* renamed from: a */
    public AdEventModel m59378a(long j) {
        this.f593r = j;
        return this;
    }

    /* renamed from: a */
    public AdEventModel m59377a(String str) {
        this.f579d = str;
        return this;
    }

    /* renamed from: a */
    public AdEventModel m59376a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f597v.put(str, obj);
        }
        return this;
    }

    /* renamed from: a */
    public AdEventModel m59375a(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.f597v.putAll(map);
        }
        return this;
    }

    /* renamed from: b */
    public AdEventModel m59374b(int i) {
        this.f592q = i;
        return this;
    }

    /* renamed from: b */
    public AdEventModel m59373b(long j) {
        this.f584i = j;
        return this;
    }

    /* renamed from: b */
    public AdEventModel m59372b(String str) {
        this.f578c = str;
        return this;
    }

    /* renamed from: c */
    public AdEventModel m59371c(int i) {
        this.f589n = i;
        return this;
    }

    /* renamed from: c */
    public AdEventModel m59370c(String str) {
        this.f581f = str;
        return this;
    }

    /* renamed from: d */
    public AdEventModel m59369d(int i) {
        this.f590o = String.valueOf(i);
        return this;
    }

    /* renamed from: d */
    public AdEventModel m59368d(String str) {
        this.f586k = str;
        return this;
    }

    /* renamed from: e */
    public AdEventModel m59367e(int i) {
        this.f594s = i;
        return this;
    }

    /* renamed from: e */
    public AdEventModel m59366e(String str) {
        this.f576a = str;
        return this;
    }

    /* renamed from: f */
    public AdEventModel m59365f(int i) {
        this.f591p = String.valueOf(i);
        return this;
    }

    /* renamed from: f */
    public AdEventModel m59364f(String str) {
        this.f596u = str;
        return this;
    }

    /* renamed from: g */
    public AdEventModel m59363g(int i) {
        this.f595t = i;
        return this;
    }

    /* renamed from: g */
    public AdEventModel m59362g(String str) {
        this.f577b = str;
        return this;
    }

    /* renamed from: h */
    public AdEventModel m59361h(String str) {
        this.f580e = str;
        return this;
    }

    /* renamed from: i */
    public AdEventModel m59360i(String str) {
        this.f583h = str;
        return this;
    }

    /* renamed from: j */
    public AdEventModel m59359j(String str) {
        this.f582g = str;
        return this;
    }

    /* renamed from: k */
    public AdEventModel m59358k(String str) {
        this.f585j = str;
        return this;
    }
}
