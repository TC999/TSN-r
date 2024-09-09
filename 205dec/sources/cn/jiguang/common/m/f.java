package cn.jiguang.common.m;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f3513a;

    /* renamed from: b  reason: collision with root package name */
    public String f3514b;

    /* renamed from: c  reason: collision with root package name */
    public String f3515c;

    /* renamed from: d  reason: collision with root package name */
    public String f3516d;

    /* renamed from: e  reason: collision with root package name */
    public int f3517e;

    /* renamed from: f  reason: collision with root package name */
    public String f3518f;

    /* renamed from: g  reason: collision with root package name */
    public long f3519g;

    /* renamed from: h  reason: collision with root package name */
    public long f3520h;

    /* renamed from: i  reason: collision with root package name */
    public long f3521i;

    /* renamed from: j  reason: collision with root package name */
    public long f3522j;

    /* renamed from: k  reason: collision with root package name */
    public int f3523k;

    /* renamed from: l  reason: collision with root package name */
    public String f3524l;

    /* renamed from: m  reason: collision with root package name */
    public String f3525m;

    /* renamed from: n  reason: collision with root package name */
    public long f3526n;

    /* renamed from: o  reason: collision with root package name */
    public long f3527o;

    /* renamed from: p  reason: collision with root package name */
    public long f3528p;

    /* renamed from: q  reason: collision with root package name */
    public long f3529q;

    /* renamed from: r  reason: collision with root package name */
    public long f3530r;

    /* renamed from: s  reason: collision with root package name */
    public int f3531s;

    /* renamed from: t  reason: collision with root package name */
    public int f3532t;

    /* renamed from: u  reason: collision with root package name */
    public int f3533u;

    private static CharSequence a(CharSequence charSequence, int i4) {
        return (i4 < 0 || i4 >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i4);
    }

    public JSONObject a(int i4) {
        try {
            return new JSONObject().put("uid", this.f3513a).put("pid", this.f3514b).put("ppid", this.f3515c).put("proc_name", a(this.f3516d, i4)).put("foreground", this.f3517e).put("state", this.f3518f).put("start_time", this.f3519g).put("priority", this.f3520h).put("num_threads", this.f3521i).put("size", this.f3522j).put("tpgid", this.f3523k).put("cpuacct", this.f3524l).put("cpu", this.f3525m).put("utime", this.f3526n).put("stime", this.f3527o).put("cutime", this.f3528p).put("cstime", this.f3529q).put("rt_priority", this.f3530r).put("oom_score", this.f3531s).put("oom_adj", this.f3532t).put("oom_score_adj", this.f3533u);
        } catch (JSONException unused) {
            return null;
        }
    }
}
