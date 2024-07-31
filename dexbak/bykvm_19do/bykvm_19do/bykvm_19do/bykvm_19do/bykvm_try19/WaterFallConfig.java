package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.github.mikephil.charting.utils.Utils;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class WaterFallConfig implements Comparable<WaterFallConfig> {

    /* renamed from: a */
    private String f541a;

    /* renamed from: b */
    private String f542b;

    /* renamed from: c */
    private String f543c = "1";

    /* renamed from: d */
    private String f544d = "0";

    /* renamed from: e */
    private int f545e;

    /* renamed from: f */
    private int f546f;

    /* renamed from: g */
    private int f547g;

    /* renamed from: h */
    private int f548h;

    /* renamed from: i */
    private String f549i;

    /* renamed from: j */
    private String f550j;

    /* renamed from: k */
    private String f551k;

    /* renamed from: l */
    private int f552l;

    /* renamed from: m */
    private int f553m;

    /* renamed from: n */
    private int f554n;

    /* renamed from: o */
    private int f555o;

    /* renamed from: p */
    private int f556p;

    /* renamed from: q */
    private ServerBiddingWinner f557q;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(WaterFallConfig waterFallConfig) {
        if (waterFallConfig != null && this.f546f <= waterFallConfig.m59459l()) {
            return this.f546f < waterFallConfig.m59459l() ? -1 : 0;
        }
        return 1;
    }

    /* renamed from: a */
    public WaterFallConfig m59488a() {
        for (char c = 'R'; c != 'P'; c = 'P') {
        }
        WaterFallConfig waterFallConfig = new WaterFallConfig();
        waterFallConfig.f541a = this.f541a;
        waterFallConfig.f542b = this.f542b;
        waterFallConfig.f543c = this.f543c;
        waterFallConfig.f544d = this.f544d;
        waterFallConfig.f545e = this.f545e;
        waterFallConfig.f546f = this.f546f;
        waterFallConfig.f547g = this.f547g;
        waterFallConfig.f548h = this.f548h;
        waterFallConfig.f554n = this.f554n;
        waterFallConfig.f549i = this.f549i;
        waterFallConfig.f550j = this.f550j;
        waterFallConfig.f551k = this.f551k;
        waterFallConfig.f552l = this.f552l;
        waterFallConfig.f553m = this.f553m;
        waterFallConfig.f555o = this.f555o;
        waterFallConfig.f556p = this.f556p;
        return waterFallConfig;
    }

    /* renamed from: a */
    public void m59487a(int i) {
        this.f552l = i;
    }

    /* renamed from: a */
    public void m59486a(ServerBiddingWinner serverBiddingWinner) {
        this.f557q = serverBiddingWinner;
    }

    /* renamed from: a */
    public void m59484a(String str) {
        this.f542b = str;
    }

    /* renamed from: b */
    public int m59483b() {
        int i = this.f552l;
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
    public void m59482b(int i) {
        this.f545e = i;
    }

    /* renamed from: b */
    public void m59481b(String str) {
        this.f541a = str;
    }

    /* renamed from: c */
    public String m59480c() {
        return this.f542b;
    }

    /* renamed from: c */
    public void m59479c(int i) {
        this.f556p = i;
    }

    /* renamed from: c */
    public void m59478c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.f544d = str;
    }

    /* renamed from: d */
    public String m59477d() {
        return this.f541a;
    }

    /* renamed from: d */
    public void m59476d(int i) {
        this.f555o = i;
    }

    /* renamed from: d */
    public void m59475d(String str) {
        this.f543c = str;
    }

    /* renamed from: e */
    public int m59474e() {
        int i = this.f545e;
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

    /* renamed from: e */
    public void m59473e(int i) {
        this.f553m = i;
    }

    /* renamed from: e */
    public void m59472e(String str) {
        this.f549i = str;
    }

    /* renamed from: f */
    public double m59471f() {
        try {
            return Double.valueOf(this.f544d).doubleValue() * Double.valueOf(this.f543c).doubleValue();
        } catch (Exception e) {
            Logger.m37557e("WaterFallConfig", "getEcpm error " + e.toString());
            return Utils.DOUBLE_EPSILON;
        }
    }

    /* renamed from: f */
    public void m59470f(int i) {
        this.f546f = i;
    }

    /* renamed from: f */
    public void m59469f(String str) {
        this.f551k = str;
    }

    /* renamed from: g */
    public int m59468g() {
        return this.f545e == 100 ? this.f546f + 300 : this.f546f;
    }

    /* renamed from: g */
    public void m59467g(int i) {
        this.f554n = i;
    }

    /* renamed from: g */
    public void m59466g(String str) {
        this.f550j = str;
    }

    /* renamed from: h */
    public String m59465h() {
        return this.f543c;
    }

    /* renamed from: h */
    public void m59464h(int i) {
        this.f548h = i;
    }

    /* renamed from: i */
    public int m59463i() {
        int i = this.f556p;
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

    /* renamed from: i */
    public void m59462i(int i) {
        this.f547g = i;
    }

    /* renamed from: j */
    public int m59461j() {
        int i = this.f555o;
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
    public int m59460k() {
        int i = this.f553m;
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

    /* renamed from: l */
    public int m59459l() {
        int i = this.f546f;
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
    public String m59458m() {
        return this.f549i;
    }

    /* renamed from: n */
    public int m59457n() {
        int i = this.f554n;
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

    /* renamed from: o */
    public int m59456o() {
        int i = this.f548h;
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

    /* renamed from: p */
    public double m59455p() {
        ServerBiddingWinner serverBiddingWinner = this.f557q;
        if (serverBiddingWinner != null && !TextUtils.isEmpty(serverBiddingWinner.m59496c())) {
            try {
                return Double.valueOf(this.f557q.m59496c()).doubleValue();
            } catch (Exception e) {
                Logger.m37557e("WaterFallConfig", "getServerBiddingEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    /* renamed from: q */
    public String m59454q() {
        return this.f551k;
    }

    /* renamed from: r */
    public ServerBiddingWinner m59453r() {
        return this.f557q;
    }

    /* renamed from: s */
    public int m59452s() {
        int i = this.f547g;
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

    /* renamed from: t */
    public String m59451t() {
        return this.f550j;
    }

    public String toString() {
        return "WaterFallConfig{mAdnetworkName='" + this.f541a + "', mAdnetwokrSlotId='" + this.f542b + "', mExchangeRate=" + this.f543c + ", mSlotEcpm=" + this.f544d + ", mAdnetworkSlotType=" + this.f545e + ", mLoadSort=" + this.f546f + ", mShowSort=" + this.f547g + '}';
    }

    /* renamed from: u */
    public boolean m59450u() {
        return this.f545e == 2;
    }
}
