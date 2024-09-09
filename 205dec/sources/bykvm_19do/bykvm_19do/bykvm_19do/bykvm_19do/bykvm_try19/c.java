package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AdsenseRitConfig.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f491a;

    /* renamed from: b  reason: collision with root package name */
    private int f492b;

    /* renamed from: c  reason: collision with root package name */
    private int f493c;

    /* renamed from: d  reason: collision with root package name */
    private long f494d;

    /* renamed from: e  reason: collision with root package name */
    private long f495e;

    /* renamed from: f  reason: collision with root package name */
    private long f496f;

    /* renamed from: g  reason: collision with root package name */
    private long f497g;

    /* renamed from: h  reason: collision with root package name */
    private String f498h;

    /* renamed from: i  reason: collision with root package name */
    private List<h> f499i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private Map<Integer, List<h>> f500j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private List<Integer> f501k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private double f502l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f503m;

    /* renamed from: n  reason: collision with root package name */
    private int f504n;

    /* renamed from: o  reason: collision with root package name */
    private int f505o;

    /* renamed from: p  reason: collision with root package name */
    private int f506p;

    /* renamed from: q  reason: collision with root package name */
    private long f507q;

    /* renamed from: r  reason: collision with root package name */
    private int f508r;

    /* renamed from: s  reason: collision with root package name */
    private String f509s;

    /* renamed from: t  reason: collision with root package name */
    private String f510t;

    /* renamed from: u  reason: collision with root package name */
    private int f511u;

    /* renamed from: v  reason: collision with root package name */
    private int f512v;

    /* renamed from: w  reason: collision with root package name */
    private int f513w;

    /* renamed from: x  reason: collision with root package name */
    private String f514x;

    public c a() {
        c cVar = new c();
        cVar.f491a = this.f491a;
        cVar.f492b = this.f492b;
        cVar.f493c = this.f493c;
        cVar.f494d = this.f494d;
        cVar.f495e = this.f495e;
        cVar.f496f = this.f496f;
        cVar.f497g = this.f497g;
        cVar.f498h = this.f498h;
        cVar.f507q = this.f507q;
        cVar.f513w = this.f513w;
        cVar.f510t = this.f510t;
        cVar.f508r = this.f508r;
        cVar.f509s = this.f509s;
        return cVar;
    }

    public h a(String str) {
        List<h> list;
        if (!TextUtils.isEmpty(str) && (list = this.f499i) != null && list.size() != 0) {
            for (h hVar : this.f499i) {
                if (str.equals(hVar.c())) {
                    return hVar;
                }
            }
        }
        return null;
    }

    public void a(double d4) {
        this.f502l = d4;
    }

    public void a(int i4) {
        this.f504n = i4;
    }

    public void a(long j4) {
        this.f497g = j4;
    }

    public void a(List<h> list) {
        int i4;
        List<h> list2;
        this.f499i = list;
        if (list == null) {
            return;
        }
        this.f505o = 0;
        this.f500j.clear();
        this.f501k.clear();
        this.f506p = this.f499i.size();
        int i5 = -1000;
        for (int i6 = 0; i6 < this.f499i.size(); i6++) {
            h hVar = list.get(i6);
            if (hVar != null) {
                if (hVar.l() != i5) {
                    this.f505o++;
                    list2 = new ArrayList<>();
                    i4 = hVar.l();
                } else {
                    i4 = i5;
                    list2 = this.f500j.get(Integer.valueOf(i5));
                }
                if (list2 != null) {
                    list2.add(hVar);
                    this.f500j.put(Integer.valueOf(i4), list2);
                }
                i5 = i4;
            }
        }
        this.f501k.addAll(this.f500j.keySet());
    }

    public void a(boolean z3) {
        this.f503m = z3;
    }

    public int b() {
        int i4 = this.f504n;
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
        this.f493c = i4;
    }

    public void b(long j4) {
        this.f495e = j4;
    }

    public void b(String str) {
        this.f491a = str;
    }

    public long c() {
        long j4 = this.f497g;
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
        return j4;
    }

    public void c(int i4) {
        this.f511u = i4;
    }

    public void c(long j4) {
        this.f494d = j4;
    }

    public void c(String str) {
        this.f509s = str;
    }

    public double d() {
        double d4 = this.f502l;
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
        return d4;
    }

    public void d(int i4) {
        this.f512v = i4;
    }

    public void d(long j4) {
        this.f496f = j4;
    }

    public void d(String str) {
        this.f498h = str;
    }

    public long e() {
        long j4 = this.f495e;
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
        return j4;
    }

    public void e(int i4) {
        this.f513w = i4;
    }

    public void e(long j4) {
        this.f507q = j4;
    }

    public void e(String str) {
        this.f510t = str;
    }

    public List<Integer> f() {
        return this.f501k;
    }

    public void f(int i4) {
        this.f492b = i4;
    }

    public void f(String str) {
        this.f514x = str;
    }

    public long g() {
        long j4 = this.f494d;
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
        return j4;
    }

    public void g(int i4) {
        this.f508r = i4;
    }

    public int h() {
        int i4 = this.f511u;
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

    public int i() {
        int i4 = this.f512v;
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

    public int j() {
        int i4 = this.f513w;
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

    public String k() {
        return this.f491a;
    }

    public int l() {
        int i4 = this.f492b;
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

    public int m() {
        int i4 = this.f508r;
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

    public String n() {
        return this.f509s;
    }

    public long o() {
        long j4 = this.f496f;
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
        return j4;
    }

    public int p() {
        int i4 = this.f506p;
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

    public String q() {
        return this.f498h;
    }

    public Map<Integer, List<h>> r() {
        HashMap hashMap = new HashMap();
        Map<Integer, List<h>> map = this.f500j;
        if (map != null) {
            for (Map.Entry<Integer, List<h>> entry : map.entrySet()) {
                hashMap.put(Integer.valueOf(entry.getKey().intValue()), new ArrayList(entry.getValue()));
            }
        }
        return hashMap;
    }

    public List<h> s() {
        return this.f499i;
    }

    public String t() {
        return this.f510t;
    }

    public String toString() {
        char c4 = 'G';
        do {
            char c5 = '\uffd9';
            while (true) {
                if (c5 <= 5 || c4 == '\b') {
                    c5 = 'W';
                    c4 = '\n';
                }
            }
        } while (c4 != '\n');
        return "AdsenseRitConfig{mRitId='" + this.f491a + "', mRitType=" + this.f492b + ", mLookType=" + this.f493c + ", mMinWaitTime=" + this.f494d + ", mLayerTimeOut=" + this.f495e + ", mTotalTimeOut=" + this.f496f + ", mWaterFallConfigList=" + this.f499i + ", mWaterFallConfMap=" + this.f500j + ", mLoadSortLevelList=" + this.f501k + ", mCurrentCommonAdMaxCpm=" + this.f502l + ", mHeadBiding=" + this.f503m + ", mBiddingType=" + this.f504n + ", mTotalLoadLevelCount=" + this.f505o + ", mTotalWaterFallCount=" + this.f506p + ", mWaterfallAbTestParam=" + this.f510t + '}';
    }

    public String u() {
        return this.f514x;
    }

    public long v() {
        long j4 = this.f507q;
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
        return j4;
    }
}
