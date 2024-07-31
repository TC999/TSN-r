package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdsenseRitConfig {

    /* renamed from: a */
    private String f498a;

    /* renamed from: b */
    private int f499b;

    /* renamed from: c */
    private int f500c;

    /* renamed from: d */
    private long f501d;

    /* renamed from: e */
    private long f502e;

    /* renamed from: f */
    private long f503f;

    /* renamed from: g */
    private long f504g;

    /* renamed from: h */
    private String f505h;

    /* renamed from: i */
    private List<WaterFallConfig> f506i = new ArrayList();

    /* renamed from: j */
    private Map<Integer, List<WaterFallConfig>> f507j = new HashMap();

    /* renamed from: k */
    private List<Integer> f508k = new ArrayList();

    /* renamed from: l */
    private double f509l;

    /* renamed from: m */
    private boolean f510m;

    /* renamed from: n */
    private int f511n;

    /* renamed from: o */
    private int f512o;

    /* renamed from: p */
    private int f513p;

    /* renamed from: q */
    private long f514q;

    /* renamed from: r */
    private int f515r;

    /* renamed from: s */
    private String f516s;

    /* renamed from: t */
    private String f517t;

    /* renamed from: u */
    private int f518u;

    /* renamed from: v */
    private int f519v;

    /* renamed from: w */
    private int f520w;

    /* renamed from: x */
    private String f521x;

    /* renamed from: a */
    public AdsenseRitConfig m59571a() {
        AdsenseRitConfig adsenseRitConfig = new AdsenseRitConfig();
        adsenseRitConfig.f498a = this.f498a;
        adsenseRitConfig.f499b = this.f499b;
        adsenseRitConfig.f500c = this.f500c;
        adsenseRitConfig.f501d = this.f501d;
        adsenseRitConfig.f502e = this.f502e;
        adsenseRitConfig.f503f = this.f503f;
        adsenseRitConfig.f504g = this.f504g;
        adsenseRitConfig.f505h = this.f505h;
        adsenseRitConfig.f514q = this.f514q;
        adsenseRitConfig.f520w = this.f520w;
        adsenseRitConfig.f517t = this.f517t;
        adsenseRitConfig.f515r = this.f515r;
        adsenseRitConfig.f516s = this.f516s;
        return adsenseRitConfig;
    }

    /* renamed from: a */
    public WaterFallConfig m59567a(String str) {
        List<WaterFallConfig> list;
        if (!TextUtils.isEmpty(str) && (list = this.f506i) != null && list.size() != 0) {
            for (WaterFallConfig waterFallConfig : this.f506i) {
                if (str.equals(waterFallConfig.m59480c())) {
                    return waterFallConfig;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m59570a(double d) {
        this.f509l = d;
    }

    /* renamed from: a */
    public void m59569a(int i) {
        this.f511n = i;
    }

    /* renamed from: a */
    public void m59568a(long j) {
        this.f504g = j;
    }

    /* renamed from: a */
    public void m59566a(List<WaterFallConfig> list) {
        int i;
        List<WaterFallConfig> list2;
        this.f506i = list;
        if (list == null) {
            return;
        }
        this.f512o = 0;
        this.f507j.clear();
        this.f508k.clear();
        this.f513p = this.f506i.size();
        int i2 = -1000;
        for (int i3 = 0; i3 < this.f506i.size(); i3++) {
            WaterFallConfig waterFallConfig = list.get(i3);
            if (waterFallConfig != null) {
                if (waterFallConfig.m59459l() != i2) {
                    this.f512o++;
                    list2 = new ArrayList<>();
                    i = waterFallConfig.m59459l();
                } else {
                    i = i2;
                    list2 = this.f507j.get(Integer.valueOf(i2));
                }
                if (list2 != null) {
                    list2.add(waterFallConfig);
                    this.f507j.put(Integer.valueOf(i), list2);
                }
                i2 = i;
            }
        }
        this.f508k.addAll(this.f507j.keySet());
    }

    /* renamed from: a */
    public void m59565a(boolean z) {
        this.f510m = z;
    }

    /* renamed from: b */
    public int m59564b() {
        int i = this.f511n;
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    public void m59563b(int i) {
        this.f500c = i;
    }

    /* renamed from: b */
    public void m59562b(long j) {
        this.f502e = j;
    }

    /* renamed from: b */
    public void m59561b(String str) {
        this.f498a = str;
    }

    /* renamed from: c */
    public long m59560c() {
        long j = this.f504g;
        while (true) {
            char c = '^';
            char c2 = 'K';
            while (true) {
                if (c == '\\') {
                    switch (c2) {
                        case 22:
                        case 23:
                            c = ']';
                            c2 = ']';
                    }
                } else if (c != ']') {
                    c = ']';
                    c2 = ']';
                }
            }
            while (true) {
                switch (c2) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c2 = '[';
                }
            }
        }
        return j;
    }

    /* renamed from: c */
    public void m59559c(int i) {
        this.f518u = i;
    }

    /* renamed from: c */
    public void m59558c(long j) {
        this.f501d = j;
    }

    /* renamed from: c */
    public void m59557c(String str) {
        this.f516s = str;
    }

    /* renamed from: d */
    public double m59556d() {
        double d = this.f509l;
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return d;
    }

    /* renamed from: d */
    public void m59555d(int i) {
        this.f519v = i;
    }

    /* renamed from: d */
    public void m59554d(long j) {
        this.f503f = j;
    }

    /* renamed from: d */
    public void m59553d(String str) {
        this.f505h = str;
    }

    /* renamed from: e */
    public long m59552e() {
        long j = this.f502e;
        while (true) {
            char c = '^';
            char c2 = 'K';
            while (true) {
                if (c == '\\') {
                    switch (c2) {
                        case 22:
                        case 23:
                            c = ']';
                            c2 = ']';
                    }
                } else if (c != ']') {
                    c = ']';
                    c2 = ']';
                }
            }
            while (true) {
                switch (c2) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c2 = '[';
                }
            }
        }
        return j;
    }

    /* renamed from: e */
    public void m59551e(int i) {
        this.f520w = i;
    }

    /* renamed from: e */
    public void m59550e(long j) {
        this.f514q = j;
    }

    /* renamed from: e */
    public void m59549e(String str) {
        this.f517t = str;
    }

    /* renamed from: f */
    public List<Integer> m59548f() {
        return this.f508k;
    }

    /* renamed from: f */
    public void m59547f(int i) {
        this.f499b = i;
    }

    /* renamed from: f */
    public void m59546f(String str) {
        this.f521x = str;
    }

    /* renamed from: g */
    public long m59545g() {
        long j = this.f501d;
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return j;
    }

    /* renamed from: g */
    public void m59544g(int i) {
        this.f515r = i;
    }

    /* renamed from: h */
    public int m59543h() {
        int i = this.f518u;
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i;
    }

    /* renamed from: i */
    public int m59542i() {
        int i = this.f519v;
        while (true) {
            char c = '^';
            char c2 = 'K';
            while (true) {
                if (c == '\\') {
                    switch (c2) {
                        case 22:
                        case 23:
                            c = ']';
                            c2 = ']';
                    }
                } else if (c != ']') {
                    c = ']';
                    c2 = ']';
                }
            }
            while (true) {
                switch (c2) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c2 = '[';
                }
            }
        }
        return i;
    }

    /* renamed from: j */
    public int m59541j() {
        int i = this.f520w;
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i;
    }

    /* renamed from: k */
    public String m59540k() {
        return this.f498a;
    }

    /* renamed from: l */
    public int m59539l() {
        int i = this.f499b;
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i;
    }

    /* renamed from: m */
    public int m59538m() {
        int i = this.f515r;
        while (true) {
            char c = '^';
            char c2 = 'K';
            while (true) {
                if (c == '\\') {
                    switch (c2) {
                        case 22:
                        case 23:
                            c = ']';
                            c2 = ']';
                    }
                } else if (c != ']') {
                    c = ']';
                    c2 = ']';
                }
            }
            while (true) {
                switch (c2) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c2 = '[';
                }
            }
        }
        return i;
    }

    /* renamed from: n */
    public String m59537n() {
        return this.f516s;
    }

    /* renamed from: o */
    public long m59536o() {
        long j = this.f503f;
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return j;
    }

    /* renamed from: p */
    public int m59535p() {
        int i = this.f513p;
        while (true) {
            char c = '^';
            char c2 = 'K';
            while (true) {
                if (c == '\\') {
                    switch (c2) {
                        case 22:
                        case 23:
                            c = ']';
                            c2 = ']';
                    }
                } else if (c != ']') {
                    c = ']';
                    c2 = ']';
                }
            }
            while (true) {
                switch (c2) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c2 = '[';
                }
            }
        }
        return i;
    }

    /* renamed from: q */
    public String m59534q() {
        return this.f505h;
    }

    /* renamed from: r */
    public Map<Integer, List<WaterFallConfig>> m59533r() {
        HashMap hashMap = new HashMap();
        Map<Integer, List<WaterFallConfig>> map = this.f507j;
        if (map != null) {
            for (Map.Entry<Integer, List<WaterFallConfig>> entry : map.entrySet()) {
                hashMap.put(Integer.valueOf(entry.getKey().intValue()), new ArrayList(entry.getValue()));
            }
        }
        return hashMap;
    }

    /* renamed from: s */
    public List<WaterFallConfig> m59532s() {
        return this.f506i;
    }

    /* renamed from: t */
    public String m59531t() {
        return this.f517t;
    }

    public String toString() {
        char c = 'G';
        do {
            char c2 = 65497;
            while (true) {
                if (c2 <= 5 || c == '\b') {
                    c2 = 'W';
                    c = '\n';
                }
            }
        } while (c != '\n');
        return "AdsenseRitConfig{mRitId='" + this.f498a + "', mRitType=" + this.f499b + ", mLookType=" + this.f500c + ", mMinWaitTime=" + this.f501d + ", mLayerTimeOut=" + this.f502e + ", mTotalTimeOut=" + this.f503f + ", mWaterFallConfigList=" + this.f506i + ", mWaterFallConfMap=" + this.f507j + ", mLoadSortLevelList=" + this.f508k + ", mCurrentCommonAdMaxCpm=" + this.f509l + ", mHeadBiding=" + this.f510m + ", mBiddingType=" + this.f511n + ", mTotalLoadLevelCount=" + this.f512o + ", mTotalWaterFallCount=" + this.f513p + ", mWaterfallAbTestParam=" + this.f517t + '}';
    }

    /* renamed from: u */
    public String m59530u() {
        return this.f521x;
    }

    /* renamed from: v */
    public long m59529v() {
        long j = this.f514q;
        while (true) {
            char c = '^';
            char c2 = 'K';
            while (true) {
                if (c == '\\') {
                    switch (c2) {
                        case 22:
                        case 23:
                            c = ']';
                            c2 = ']';
                    }
                } else if (c != ']') {
                    c = ']';
                    c2 = ']';
                }
            }
            while (true) {
                switch (c2) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c2 = '[';
                }
            }
        }
        return j;
    }
}
