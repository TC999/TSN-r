package com.bytedance.sdk.component.adexpress.dynamic.xv;

import android.graphics.Color;
import android.text.TextUtils;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.bytedance.sdk.component.adexpress.dynamic.sr.k;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    public int f29374c;

    /* renamed from: f  reason: collision with root package name */
    private String f29375f;
    private f sr;
    private ux ux;

    /* renamed from: w  reason: collision with root package name */
    public String f29376w;
    public JSONObject xv;

    public r(ux uxVar) {
        this.ux = uxVar;
        this.f29374c = uxVar.c();
        this.f29376w = uxVar.w();
        this.xv = uxVar.sr().ge();
        this.f29375f = uxVar.xv();
        if (com.bytedance.sdk.component.adexpress.sr.w() == 1) {
            this.sr = uxVar.f();
        } else {
            this.sr = uxVar.sr();
        }
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            this.sr = uxVar.sr();
        }
    }

    private boolean e() {
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.f29376w) && this.f29376w.contains("adx:")) || k.w();
    }

    private boolean mu() {
        return (com.bytedance.sdk.component.adexpress.sr.c() && (this.ux.getType().contains("logo-union") || this.ux.getType().contains("logounion") || this.ux.getType().contains("logoad"))) || "logo-union".equals(this.ux.getType()) || "logounion".equals(this.ux.getType()) || "logoad".equals(this.ux.getType());
    }

    public String a() {
        return this.f29375f;
    }

    public int au() {
        return this.sr.zr();
    }

    public String b() {
        return this.sr.zg();
    }

    public double ba() {
        return this.sr.ev();
    }

    public int be() {
        return this.sr.kn();
    }

    public boolean bj() {
        return this.sr.gp();
    }

    public double bk() {
        if (this.f29374c == 11) {
            try {
                double parseDouble = Double.parseDouble(this.f29376w);
                return !com.bytedance.sdk.component.adexpress.sr.c() ? (int) parseDouble : parseDouble;
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public String bm() {
        return this.sr.ba();
    }

    public int bs() {
        return this.sr.rh();
    }

    public int bw() {
        return this.sr.g();
    }

    public int c() {
        return (int) this.sr.t();
    }

    public int ck() {
        String pr = this.sr.pr();
        if ("skip-with-time-skip-btn".equals(this.ux.getType()) || "skip".equals(this.ux.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.ux.getType())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.ux.getType()) && !"skip-with-time".equals(this.ux.getType())) {
            if (this.f29374c == 10 && TextUtils.equals(this.sr.bw(), "click")) {
                return 5;
            }
            if (mu() && e()) {
                return 0;
            }
            if (mu()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.ux.getType())) {
                return 3;
            }
            if (!TextUtils.isEmpty(pr) && !pr.equals("none")) {
                if (pr.equals("video") || (this.ux.c() == 7 && TextUtils.equals(pr, "normal"))) {
                    return (com.bytedance.sdk.component.adexpress.sr.c() && this.ux.sr() != null && this.ux.sr().pb()) ? 11 : 4;
                } else if (pr.equals("normal")) {
                    return 1;
                } else {
                    return (pr.equals("creative") || "slide".equals(this.sr.bw())) ? 2 : 0;
                }
            }
        }
        return 0;
    }

    public int eq() {
        return this.sr.w();
    }

    public boolean eu() {
        return this.sr.eb();
    }

    public int ev() {
        String i4 = this.sr.i();
        if ("left".equals(i4)) {
            return 17;
        }
        if (AutoScrollViewPager.f4767g.equals(i4)) {
            return 4;
        }
        return "right".equals(i4) ? 3 : 2;
    }

    public String f() {
        if (this.f29374c == 0) {
            if (!TextUtils.isEmpty(this.f29376w)) {
                return this.f29376w;
            }
            return this.xv.optString(com.bytedance.sdk.component.adexpress.sr.f.sr(com.bytedance.sdk.component.adexpress.sr.getContext()));
        }
        return "";
    }

    public double fm() {
        return this.sr.yu();
    }

    public int fp() {
        return c(this.sr.n());
    }

    public int fz() {
        return this.sr.kr();
    }

    public int g() {
        return this.sr.lw();
    }

    public String gb() {
        return this.sr.tx();
    }

    public int gd() {
        int ev = ev();
        if (ev == 4) {
            return 17;
        }
        return ev == 3 ? 8388613 : 8388611;
    }

    public String ge() {
        return this.sr.db();
    }

    public boolean gw() {
        return this.sr.qy();
    }

    public int h() {
        return this.sr.wv();
    }

    public String i() {
        return this.sr.ls();
    }

    public float ia() {
        return this.sr.a();
    }

    public int j() {
        return this.sr.vc();
    }

    public String k() {
        return this.f29374c == 1 ? this.f29376w : "";
    }

    public boolean lf() {
        return this.sr.gp();
    }

    public String ls() {
        return this.sr.pr();
    }

    public String m() {
        return this.sr.wx();
    }

    public int me() {
        return this.sr.ux();
    }

    public int mt() {
        return this.sr.jd();
    }

    public long n() {
        return this.sr.ju();
    }

    public String ng() {
        return this.sr.y();
    }

    public double oh() {
        return this.sr.xk();
    }

    public int ok() {
        return this.sr.me();
    }

    public int oo() {
        return this.sr.iw();
    }

    public boolean ox() {
        return this.sr.bk();
    }

    public String p() {
        int i4 = this.f29374c;
        return (i4 == 2 || i4 == 13) ? this.f29376w : "";
    }

    public boolean pr() {
        return this.sr.eu();
    }

    public boolean q() {
        return this.sr.gw();
    }

    public int r() {
        return c(this.sr.q());
    }

    public int s() {
        return this.sr.yh();
    }

    public int sr() {
        return (int) this.sr.fp();
    }

    public double t() {
        return this.sr.fz();
    }

    public String ta() {
        return this.sr.zt();
    }

    public int te() {
        return this.sr.o();
    }

    public boolean u() {
        return this.sr.v();
    }

    public int up() {
        return this.sr.yn();
    }

    public float ux() {
        return this.sr.s();
    }

    public int vc() {
        return this.sr.r();
    }

    public int w() {
        return (int) this.sr.ia();
    }

    public String wo() {
        return this.sr.l();
    }

    public int wv() {
        return this.sr.sr();
    }

    public String wx() {
        return this.sr.bw();
    }

    public int x() {
        return this.sr.be();
    }

    public String xg() {
        return this.sr.gb();
    }

    public int xk() {
        return this.sr.gd();
    }

    public boolean xu() {
        return this.sr.eq();
    }

    public int xv() {
        return (int) this.sr.ys();
    }

    public int y() {
        return this.sr.xv();
    }

    public float ys() {
        return this.sr.k();
    }

    public String yu() {
        return this.sr.p();
    }

    public int z() {
        return c(this.sr.j());
    }

    public static float[] w(String str) {
        String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (split == null || split.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3])};
    }

    public void c(float f4) {
        this.sr.c(f4);
    }

    public static int c(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (split.length == 4) {
                    return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2])) | 0;
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return -16777216;
    }

    public boolean c(int i4) {
        ux uxVar = this.ux;
        if (uxVar == null) {
            return false;
        }
        if (i4 == 1) {
            this.sr = uxVar.f();
        } else {
            this.sr = uxVar.sr();
        }
        return this.sr != null;
    }
}
