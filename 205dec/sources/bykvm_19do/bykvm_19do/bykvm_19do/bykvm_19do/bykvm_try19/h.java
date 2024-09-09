package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;

/* compiled from: WaterFallConfig.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h implements Comparable<h> {

    /* renamed from: a  reason: collision with root package name */
    private String f534a;

    /* renamed from: b  reason: collision with root package name */
    private String f535b;

    /* renamed from: c  reason: collision with root package name */
    private String f536c = "1";

    /* renamed from: d  reason: collision with root package name */
    private String f537d = "0";

    /* renamed from: e  reason: collision with root package name */
    private int f538e;

    /* renamed from: f  reason: collision with root package name */
    private int f539f;

    /* renamed from: g  reason: collision with root package name */
    private int f540g;

    /* renamed from: h  reason: collision with root package name */
    private int f541h;

    /* renamed from: i  reason: collision with root package name */
    private String f542i;

    /* renamed from: j  reason: collision with root package name */
    private String f543j;

    /* renamed from: k  reason: collision with root package name */
    private String f544k;

    /* renamed from: l  reason: collision with root package name */
    private int f545l;

    /* renamed from: m  reason: collision with root package name */
    private int f546m;

    /* renamed from: n  reason: collision with root package name */
    private int f547n;

    /* renamed from: o  reason: collision with root package name */
    private int f548o;

    /* renamed from: p  reason: collision with root package name */
    private int f549p;

    /* renamed from: q  reason: collision with root package name */
    private f f550q;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(h hVar) {
        if (hVar != null && this.f539f <= hVar.l()) {
            return this.f539f < hVar.l() ? -1 : 0;
        }
        return 1;
    }

    public h a() {
        for (char c4 = 'R'; c4 != 'P'; c4 = 'P') {
        }
        h hVar = new h();
        hVar.f534a = this.f534a;
        hVar.f535b = this.f535b;
        hVar.f536c = this.f536c;
        hVar.f537d = this.f537d;
        hVar.f538e = this.f538e;
        hVar.f539f = this.f539f;
        hVar.f540g = this.f540g;
        hVar.f541h = this.f541h;
        hVar.f547n = this.f547n;
        hVar.f542i = this.f542i;
        hVar.f543j = this.f543j;
        hVar.f544k = this.f544k;
        hVar.f545l = this.f545l;
        hVar.f546m = this.f546m;
        hVar.f548o = this.f548o;
        hVar.f549p = this.f549p;
        return hVar;
    }

    public void a(int i4) {
        this.f545l = i4;
    }

    public void a(f fVar) {
        this.f550q = fVar;
    }

    public void a(String str) {
        this.f535b = str;
    }

    public int b() {
        int i4 = this.f545l;
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c5) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c5 = '[';
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case '^':
                        if (c5 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i4;
    }

    public void b(int i4) {
        this.f538e = i4;
    }

    public void b(String str) {
        this.f534a = str;
    }

    public String c() {
        return this.f535b;
    }

    public void c(int i4) {
        this.f549p = i4;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.f537d = str;
    }

    public String d() {
        return this.f534a;
    }

    public void d(int i4) {
        this.f548o = i4;
    }

    public void d(String str) {
        this.f536c = str;
    }

    public int e() {
        int i4 = this.f538e;
        while (true) {
            char c4 = '^';
            char c5 = 'K';
            while (true) {
                if (c4 == '\\') {
                    switch (c5) {
                        case 22:
                        case 23:
                            c4 = ']';
                            c5 = ']';
                    }
                } else if (c4 != ']') {
                    c4 = ']';
                    c5 = ']';
                }
            }
            while (true) {
                switch (c5) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c5 = '[';
                }
            }
        }
        return i4;
    }

    public void e(int i4) {
        this.f546m = i4;
    }

    public void e(String str) {
        this.f542i = str;
    }

    public double f() {
        try {
            return Double.valueOf(this.f537d).doubleValue() * Double.valueOf(this.f536c).doubleValue();
        } catch (Exception e4) {
            Logger.e("WaterFallConfig", "getEcpm error " + e4.toString());
            return 0.0d;
        }
    }

    public void f(int i4) {
        this.f539f = i4;
    }

    public void f(String str) {
        this.f544k = str;
    }

    public int g() {
        return this.f538e == 100 ? this.f539f + 300 : this.f539f;
    }

    public void g(int i4) {
        this.f547n = i4;
    }

    public void g(String str) {
        this.f543j = str;
    }

    public String h() {
        return this.f536c;
    }

    public void h(int i4) {
        this.f541h = i4;
    }

    public int i() {
        int i4 = this.f549p;
        while (true) {
            char c4 = '^';
            char c5 = 'K';
            while (true) {
                if (c4 == '\\') {
                    switch (c5) {
                        case 22:
                        case 23:
                            c4 = ']';
                            c5 = ']';
                    }
                } else if (c4 != ']') {
                    c4 = ']';
                    c5 = ']';
                }
            }
            while (true) {
                switch (c5) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c5 = '[';
                }
            }
        }
        return i4;
    }

    public void i(int i4) {
        this.f540g = i4;
    }

    public int j() {
        int i4 = this.f548o;
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c5) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c5 = '[';
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case '^':
                        if (c5 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i4;
    }

    public int k() {
        int i4 = this.f546m;
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c5) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c5 = '[';
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case '^':
                        if (c5 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i4;
    }

    public int l() {
        int i4 = this.f539f;
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c5) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c5 = '[';
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case '^':
                        if (c5 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i4;
    }

    public String m() {
        return this.f542i;
    }

    public int n() {
        int i4 = this.f547n;
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c5) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c5 = '[';
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case '^':
                        if (c5 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i4;
    }

    public int o() {
        int i4 = this.f541h;
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c5) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c5 = '[';
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case '^':
                        if (c5 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i4;
    }

    public double p() {
        f fVar = this.f550q;
        if (fVar != null && !TextUtils.isEmpty(fVar.c())) {
            try {
                return Double.valueOf(this.f550q.c()).doubleValue();
            } catch (Exception e4) {
                Logger.e("WaterFallConfig", "getServerBiddingEcpm error " + e4.toString());
            }
        }
        return -1.0d;
    }

    public String q() {
        return this.f544k;
    }

    public f r() {
        return this.f550q;
    }

    public int s() {
        int i4 = this.f540g;
        while (true) {
            char c4 = '^';
            char c5 = 'K';
            while (true) {
                if (c4 == '\\') {
                    switch (c5) {
                        case 22:
                        case 23:
                            c4 = ']';
                            c5 = ']';
                    }
                } else if (c4 != ']') {
                    c4 = ']';
                    c5 = ']';
                }
            }
            while (true) {
                switch (c5) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c5 = '[';
                }
            }
        }
        return i4;
    }

    public String t() {
        return this.f543j;
    }

    public String toString() {
        return "WaterFallConfig{mAdnetworkName='" + this.f534a + "', mAdnetwokrSlotId='" + this.f535b + "', mExchangeRate=" + this.f536c + ", mSlotEcpm=" + this.f537d + ", mAdnetworkSlotType=" + this.f538e + ", mLoadSort=" + this.f539f + ", mShowSort=" + this.f540g + '}';
    }

    public boolean u() {
        return this.f538e == 2;
    }
}
