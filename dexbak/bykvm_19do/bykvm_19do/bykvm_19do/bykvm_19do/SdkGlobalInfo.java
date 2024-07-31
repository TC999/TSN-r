package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.SdkSettingsHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.Predicate;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.SPUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.ToolUtils;
import com.bytedance.msdk.api.TTPrivacyConfig;
import com.bytedance.msdk.api.UserInfoForSegment;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SdkGlobalInfo {

    /* renamed from: x */
    private static final SdkGlobalInfo f249x = new SdkGlobalInfo();

    /* renamed from: c */
    private String[] f252c;

    /* renamed from: d */
    private String f253d;

    /* renamed from: e */
    private String f254e;

    /* renamed from: i */
    private String f258i;

    /* renamed from: k */
    private boolean f260k;

    /* renamed from: l */
    private String f261l;

    /* renamed from: m */
    private Map<String, String> f262m;

    /* renamed from: n */
    private String f263n;

    /* renamed from: o */
    private TTCustomController f264o;

    /* renamed from: p */
    private String f265p;

    /* renamed from: t */
    private UserInfoForSegment f269t;

    /* renamed from: w */
    private int[] f272w;

    /* renamed from: a */
    private int f250a = 0;

    /* renamed from: b */
    private boolean f251b = false;

    /* renamed from: f */
    private boolean f255f = true;

    /* renamed from: g */
    private boolean f256g = false;

    /* renamed from: h */
    private boolean f257h = false;

    /* renamed from: j */
    private boolean f259j = true;

    /* renamed from: q */
    private Set<String> f266q = new HashSet();

    /* renamed from: r */
    private Map<String, Map<String, String>> f267r = new HashMap();

    /* renamed from: s */
    private Map<String, Map<String, String>> f268s = new HashMap();

    /* renamed from: u */
    private long f270u = -1;

    /* renamed from: v */
    private TTPrivacyConfig f271v = new TTPrivacyConfig();

    private SdkGlobalInfo() {
    }

    /* renamed from: B */
    public static SdkGlobalInfo m59939B() {
        return f249x;
    }

    /* renamed from: A */
    public boolean m59940A() {
        return ("com.header.app.untext".equals(InternalContainer.m59945d().getPackageName()) && "5001121".equals(this.f253d)) || ("com.bytedance.mediation_demo".equals(InternalContainer.m59945d().getPackageName()) && "5001121".equals(this.f253d));
    }

    /* renamed from: a */
    public void m59937a(int i) {
    }

    /* renamed from: a */
    public void m59936a(long j) {
        try {
            SPUtils m59131a = SPUtils.m59131a("tt_sdk_settings", InternalContainer.m59945d());
            if (m59131a.m59132a("first_install_time", -1L) == -1) {
                this.f270u = j;
                m59131a.m59124b("first_install_time", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m59922b(boolean z) {
        this.f260k = z;
    }

    /* renamed from: c */
    public String m59921c() {
        return this.f253d;
    }

    /* renamed from: d */
    public boolean m59917d() {
        return this.f259j;
    }

    /* renamed from: e */
    public void m59911e(boolean z) {
        this.f257h = z;
    }

    /* renamed from: f */
    public long m59910f() {
        long j = this.f270u;
        if (j != -1) {
            return j;
        }
        try {
            SPUtils m59131a = SPUtils.m59131a("tt_sdk_settings", InternalContainer.m59945d());
            long m59132a = m59131a.m59132a("first_install_time", -1L);
            if (m59132a == -1) {
                long currentTimeMillis = System.currentTimeMillis();
                m59131a.m59124b("first_install_time", currentTimeMillis);
                this.f270u = currentTimeMillis;
                return currentTimeMillis;
            }
            this.f270u = m59132a;
            return m59132a;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: g */
    public String m59907g() {
        return this.f254e;
    }

    /* renamed from: h */
    public Map<String, Map<String, String>> m59905h() {
        return this.f267r;
    }

    @Deprecated
    /* renamed from: i */
    public TTCustomController m59904i() {
        return this.f264o;
    }

    /* renamed from: j */
    public String m59903j() {
        return this.f261l;
    }

    /* renamed from: k */
    public String m59902k() {
        return this.f263n;
    }

    /* renamed from: l */
    public String[] m59901l() {
        return this.f252c;
    }

    /* renamed from: m */
    public int m59900m() {
        return this.f250a;
    }

    /* renamed from: n */
    public int[] m59899n() {
        return this.f272w;
    }

    /* renamed from: o */
    public String m59898o() {
        if (("com.header.app.untext".equals(InternalContainer.m59945d().getPackageName()) && "5001121".equals(this.f253d)) || ("com.bytedance.mediation_demo".equals(InternalContainer.m59945d().getPackageName()) && "5001121".equals(this.f253d))) {
            try {
                return SPUtils.m59131a("tt_mediation_ppe_info", InternalContainer.m59945d()).m59120d("tt_ppe_content");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: p */
    public TTPrivacyConfig m59897p() {
        return this.f271v;
    }

    /* renamed from: q */
    public String m59896q() {
        return this.f258i;
    }

    /* renamed from: r */
    public Map<String, Map<String, String>> m59895r() {
        return this.f268s;
    }

    /* renamed from: s */
    public UserInfoForSegment m59894s() {
        return this.f269t;
    }

    /* renamed from: t */
    public boolean m59893t() {
        return "5001121".equals(this.f253d) || "5001121".equals(this.f253d);
    }

    /* renamed from: u */
    public boolean m59892u() {
        String m59259a = ToolUtils.m59259a();
        return "com.header.app.untext".equals(m59259a) || "com.bytedance.mediation_demo".equals(m59259a);
    }

    /* renamed from: v */
    public boolean m59891v() {
        return this.f260k;
    }

    /* renamed from: w */
    public boolean m59890w() {
        return this.f255f;
    }

    /* renamed from: x */
    public boolean m59889x() {
        return this.f256g;
    }

    /* renamed from: y */
    public boolean m59888y() {
        return this.f257h;
    }

    /* renamed from: z */
    public boolean m59887z() {
        return this.f251b;
    }

    /* renamed from: g */
    private static void m59906g(String str) {
        Predicate.m59162a(str, "name不能为空");
    }

    /* renamed from: b */
    public void m59924b(String str) {
        m59906g(str);
        this.f254e = str;
    }

    /* renamed from: c */
    public void m59920c(String str) {
        this.f261l = str;
    }

    /* renamed from: d */
    public void m59915d(Map<String, String> map) {
        if (this.f262m == null) {
            this.f262m = new HashMap();
        }
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f262m.putAll(map);
    }

    /* renamed from: e */
    public void m59912e(String str) {
        this.f258i = str;
    }

    /* renamed from: c */
    public void m59918c(boolean z) {
        this.f255f = z;
    }

    /* renamed from: e */
    public Map m59913e() {
        return this.f262m;
    }

    /* renamed from: b */
    public void m59925b(int i) {
        this.f250a = i;
    }

    /* renamed from: c */
    public void m59919c(Map<String, Map<String, String>> map) {
        if (map != null) {
            this.f268s.putAll(map);
        }
    }

    /* renamed from: b */
    public String m59926b() {
        if (!TextUtils.isEmpty(this.f265p)) {
            return this.f265p;
        }
        String m59128b = SPUtils.m59131a((String) null, InternalContainer.m59945d()).m59128b();
        this.f265p = m59128b;
        if (!TextUtils.isEmpty(m59128b)) {
            return this.f265p;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        SPUtils.m59131a((String) null, InternalContainer.m59945d()).m59119e(valueOf);
        this.f265p = valueOf;
        return valueOf;
    }

    /* renamed from: a */
    public void m59932a(String str) {
        m59909f(str);
        this.f253d = str;
    }

    /* renamed from: d */
    public void m59914d(boolean z) {
        this.f256g = z;
    }

    /* renamed from: d */
    public void m59916d(String str) {
        this.f263n = str;
    }

    /* renamed from: a */
    public void m59929a(boolean z) {
        this.f259j = z;
    }

    /* renamed from: a */
    public void m59931a(Map<String, String> map) {
        this.f262m = map;
    }

    /* renamed from: f */
    public void m59908f(boolean z) {
        this.f251b = z;
    }

    /* renamed from: f */
    private static void m59909f(String str) {
        Predicate.m59162a(str, "appid不能为空");
    }

    @Deprecated
    /* renamed from: a */
    public void m59933a(TTCustomController tTCustomController) {
        this.f264o = tTCustomController;
    }

    /* renamed from: a */
    public void m59928a(int... iArr) {
        this.f272w = iArr;
    }

    /* renamed from: a */
    public void m59927a(String[] strArr) {
        this.f252c = strArr;
    }

    /* renamed from: a */
    public Set<String> m59938a() {
        return this.f266q;
    }

    /* renamed from: b */
    public void m59923b(Map<String, Map<String, String>> map) {
        if (map != null) {
            this.f267r.putAll(map);
        }
    }

    /* renamed from: a */
    public void m59930a(Set<String> set) {
        if (set != null) {
            this.f266q.addAll(set);
        }
    }

    /* renamed from: a */
    public void m59934a(UserInfoForSegment userInfoForSegment, boolean z) {
        boolean equals;
        if (!z) {
            UserInfoForSegment userInfoForSegment2 = this.f269t;
            if (userInfoForSegment2 == null && userInfoForSegment == null) {
                equals = true;
            } else {
                equals = (userInfoForSegment2 == null || userInfoForSegment == null) ? false : userInfoForSegment2.equals(userInfoForSegment);
            }
            this.f269t = userInfoForSegment;
            if (equals) {
                return;
            }
            SdkSettingsHelper.m59791a(InternalContainer.m59943f()).m59779d().m59792a();
            return;
        }
        this.f269t = userInfoForSegment;
    }

    /* renamed from: a */
    public void m59935a(TTPrivacyConfig tTPrivacyConfig) {
        if (tTPrivacyConfig != null) {
            this.f271v = tTPrivacyConfig;
        }
    }
}
