package master.flame.danmaku.danmaku.model.android;

import android.graphics.Typeface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import master.flame.danmaku.controller.DanmakuFilters;
import master.flame.danmaku.danmaku.model.AbsDanmakuSync;
import master.flame.danmaku.danmaku.model.AbsDisplayer;
import master.flame.danmaku.danmaku.model.AlphaValue;
import master.flame.danmaku.danmaku.model.GlobalFlagValues;
import master.flame.danmaku.danmaku.model.android.BaseCacheStuffer;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakuContext {

    /* renamed from: o */
    public AbsDanmakuSync f43710o;

    /* renamed from: t */
    private List<WeakReference<InterfaceC15342a>> f43715t;

    /* renamed from: x */
    private BaseCacheStuffer f43719x;

    /* renamed from: y */
    private boolean f43720y;

    /* renamed from: z */
    private boolean f43721z;

    /* renamed from: a */
    public Typeface f43696a = null;

    /* renamed from: b */
    public int f43697b = AlphaValue.f43835a;

    /* renamed from: c */
    public float f43698c = 1.0f;

    /* renamed from: d */
    public int f43699d = 0;

    /* renamed from: e */
    public boolean f43700e = true;

    /* renamed from: f */
    public boolean f43701f = true;

    /* renamed from: g */
    public boolean f43702g = true;

    /* renamed from: h */
    public boolean f43703h = true;

    /* renamed from: i */
    public boolean f43704i = true;

    /* renamed from: j */
    List<Integer> f43705j = new ArrayList();

    /* renamed from: k */
    public int f43706k = -1;

    /* renamed from: l */
    public float f43707l = 1.0f;

    /* renamed from: m */
    public int f43708m = 15;

    /* renamed from: n */
    public BorderType f43709n = BorderType.SHADOW;

    /* renamed from: p */
    public int f43711p = 3;

    /* renamed from: q */
    List<Integer> f43712q = new ArrayList();

    /* renamed from: r */
    List<Integer> f43713r = new ArrayList();

    /* renamed from: s */
    List<String> f43714s = new ArrayList();

    /* renamed from: u */
    private boolean f43716u = false;

    /* renamed from: v */
    private boolean f43717v = false;

    /* renamed from: w */
    private boolean f43718w = false;

    /* renamed from: A */
    private final AbsDisplayer f43690A = new AndroidDisplayer();

    /* renamed from: B */
    public final GlobalFlagValues f43691B = new GlobalFlagValues();

    /* renamed from: C */
    public final DanmakuFilters f43692C = new DanmakuFilters();

    /* renamed from: D */
    public final DanmakuFactory f43693D = DanmakuFactory.m3158a();

    /* renamed from: E */
    public CachingPolicy f43694E = CachingPolicy.f43772n;

    /* renamed from: F */
    public byte f43695F = 0;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public enum BorderType {
        NONE,
        SHADOW,
        STROKEN
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public enum DanmakuConfigTag {
        FT_DANMAKU_VISIBILITY,
        FB_DANMAKU_VISIBILITY,
        L2R_DANMAKU_VISIBILITY,
        R2L_DANMAKU_VISIBILIY,
        SPECIAL_DANMAKU_VISIBILITY,
        TYPEFACE,
        TRANSPARENCY,
        SCALE_TEXTSIZE,
        MAXIMUM_NUMS_IN_SCREEN,
        DANMAKU_STYLE,
        DANMAKU_BOLD,
        COLOR_VALUE_WHITE_LIST,
        USER_ID_BLACK_LIST,
        USER_HASH_BLACK_LIST,
        SCROLL_SPEED_FACTOR,
        BLOCK_GUEST_DANMAKU,
        DUPLICATE_MERGING_ENABLED,
        MAXIMUN_LINES,
        OVERLAPPING_ENABLE,
        ALIGN_BOTTOM,
        DANMAKU_MARGIN;

        public boolean isVisibilityRelatedTag() {
            return equals(FT_DANMAKU_VISIBILITY) || equals(FB_DANMAKU_VISIBILITY) || equals(L2R_DANMAKU_VISIBILITY) || equals(R2L_DANMAKU_VISIBILIY) || equals(SPECIAL_DANMAKU_VISIBILITY) || equals(COLOR_VALUE_WHITE_LIST) || equals(USER_ID_BLACK_LIST);
        }
    }

    /* renamed from: master.flame.danmaku.danmaku.model.android.DanmakuContext$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15342a {
        /* renamed from: a */
        boolean mo3201a(DanmakuContext danmakuContext, DanmakuConfigTag danmakuConfigTag, Object... objArr);
    }

    /* renamed from: F */
    private void m3247F(boolean z, int i) {
        if (z) {
            this.f43705j.remove(Integer.valueOf(i));
        } else if (this.f43705j.contains(Integer.valueOf(i))) {
        } else {
            this.f43705j.add(Integer.valueOf(i));
        }
    }

    /* renamed from: J */
    private <T> void m3243J(String str, T t) {
        m3242K(str, t, true);
    }

    /* renamed from: K */
    private <T> void m3242K(String str, T t, boolean z) {
        this.f43692C.m3389e(str, z).mo3365a(t);
    }

    /* renamed from: e */
    public static DanmakuContext m3223e() {
        return new DanmakuContext();
    }

    /* renamed from: s */
    private void m3209s(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        List<WeakReference<InterfaceC15342a>> list = this.f43715t;
        if (list != null) {
            for (WeakReference<InterfaceC15342a> weakReference : list) {
                InterfaceC15342a interfaceC15342a = weakReference.get();
                if (interfaceC15342a != null) {
                    interfaceC15342a.mo3201a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }

    /* renamed from: A */
    public DanmakuContext m3252A(boolean z) {
        this.f43690A.mo3106A(z);
        m3209s(DanmakuConfigTag.DANMAKU_BOLD, Boolean.valueOf(z));
        return this;
    }

    /* renamed from: B */
    public DanmakuContext m3251B(int i) {
        if (this.f43699d != i) {
            this.f43699d = i;
            this.f43690A.mo3035k(i);
            this.f43691B.m3064b();
            this.f43691B.m3059g();
            m3209s(DanmakuConfigTag.DANMAKU_MARGIN, Integer.valueOf(i));
        }
        return this;
    }

    /* renamed from: C */
    public DanmakuContext m3250C(int i, float... fArr) {
        this.f43690A.mo3043c(i, fArr);
        m3209s(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    /* renamed from: D */
    public DanmakuContext m3249D(AbsDanmakuSync absDanmakuSync) {
        this.f43710o = absDanmakuSync;
        return this;
    }

    /* renamed from: E */
    public DanmakuContext m3248E(float f) {
        int i = (int) (AlphaValue.f43835a * f);
        if (i != this.f43697b) {
            this.f43697b = i;
            this.f43690A.mo3104C(i);
            m3209s(DanmakuConfigTag.TRANSPARENCY, Float.valueOf(f));
        }
        return this;
    }

    /* renamed from: G */
    public DanmakuContext m3246G(boolean z) {
        if (this.f43717v != z) {
            this.f43717v = z;
            this.f43691B.m3064b();
            m3209s(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z));
        }
        return this;
    }

    /* renamed from: H */
    public DanmakuContext m3245H(boolean z) {
        m3247F(z, 4);
        m3243J(DanmakuFilters.f43565p, this.f43705j);
        this.f43691B.m3064b();
        if (this.f43701f != z) {
            this.f43701f = z;
            m3209s(DanmakuConfigTag.FB_DANMAKU_VISIBILITY, Boolean.valueOf(z));
        }
        return this;
    }

    /* renamed from: I */
    public DanmakuContext m3244I(boolean z) {
        m3247F(z, 5);
        m3243J(DanmakuFilters.f43565p, this.f43705j);
        this.f43691B.m3064b();
        if (this.f43700e != z) {
            this.f43700e = z;
            m3209s(DanmakuConfigTag.FT_DANMAKU_VISIBILITY, Boolean.valueOf(z));
        }
        return this;
    }

    /* renamed from: L */
    public DanmakuContext m3241L(boolean z) {
        m3247F(z, 6);
        m3243J(DanmakuFilters.f43565p, this.f43705j);
        this.f43691B.m3064b();
        if (this.f43702g != z) {
            this.f43702g = z;
            m3209s(DanmakuConfigTag.L2R_DANMAKU_VISIBILITY, Boolean.valueOf(z));
        }
        return this;
    }

    /* renamed from: M */
    public DanmakuContext m3240M(int i) {
        this.f43690A.mo3033m(i);
        return this;
    }

    /* renamed from: N */
    public DanmakuContext m3239N(Map<Integer, Integer> map) {
        this.f43720y = map != null;
        if (map == null) {
            this.f43692C.m3382l(DanmakuFilters.f43573x, false);
        } else {
            m3242K(DanmakuFilters.f43573x, map, false);
        }
        this.f43691B.m3064b();
        m3209s(DanmakuConfigTag.MAXIMUN_LINES, map);
        return this;
    }

    /* renamed from: O */
    public DanmakuContext m3238O(int i) {
        this.f43706k = i;
        if (i == 0) {
            this.f43692C.m3383k(DanmakuFilters.f43566q);
            this.f43692C.m3383k(DanmakuFilters.f43567r);
            m3209s(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(i));
            return this;
        } else if (i == -1) {
            this.f43692C.m3383k(DanmakuFilters.f43566q);
            this.f43692C.m3388f(DanmakuFilters.f43567r);
            m3209s(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(i));
            return this;
        } else {
            m3243J(DanmakuFilters.f43566q, Integer.valueOf(i));
            this.f43691B.m3064b();
            m3209s(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(i));
            return this;
        }
    }

    @Deprecated
    /* renamed from: P */
    public DanmakuContext m3237P(Map<Integer, Boolean> map) {
        return m3208t(map);
    }

    /* renamed from: Q */
    public DanmakuContext m3236Q(boolean z) {
        m3247F(z, 1);
        m3243J(DanmakuFilters.f43565p, this.f43705j);
        this.f43691B.m3064b();
        if (this.f43703h != z) {
            this.f43703h = z;
            m3209s(DanmakuConfigTag.R2L_DANMAKU_VISIBILIY, Boolean.valueOf(z));
        }
        return this;
    }

    /* renamed from: R */
    public DanmakuContext m3235R(float f) {
        if (this.f43698c != f) {
            this.f43698c = f;
            this.f43690A.mo3102u();
            this.f43690A.mo3105B(f);
            this.f43691B.m3062d();
            this.f43691B.m3059g();
            m3209s(DanmakuConfigTag.SCALE_TEXTSIZE, Float.valueOf(f));
        }
        return this;
    }

    /* renamed from: S */
    public DanmakuContext m3234S(float f) {
        if (this.f43707l != f) {
            this.f43707l = f;
            this.f43693D.m3147l(f);
            this.f43691B.m3062d();
            this.f43691B.m3059g();
            m3209s(DanmakuConfigTag.SCROLL_SPEED_FACTOR, Float.valueOf(f));
        }
        return this;
    }

    /* renamed from: T */
    public DanmakuContext m3233T(boolean z) {
        m3247F(z, 7);
        m3243J(DanmakuFilters.f43565p, this.f43705j);
        this.f43691B.m3064b();
        if (this.f43704i != z) {
            this.f43704i = z;
            m3209s(DanmakuConfigTag.SPECIAL_DANMAKU_VISIBILITY, Boolean.valueOf(z));
        }
        return this;
    }

    /* renamed from: U */
    public DanmakuContext m3232U(Typeface typeface) {
        if (this.f43696a != typeface) {
            this.f43696a = typeface;
            this.f43690A.mo3102u();
            this.f43690A.mo3103D(typeface);
            m3209s(DanmakuConfigTag.TYPEFACE, new Object[0]);
        }
        return this;
    }

    /* renamed from: V */
    public DanmakuContext m3231V(String... strArr) {
        this.f43714s.clear();
        if (strArr != null && strArr.length != 0) {
            Collections.addAll(this.f43714s, strArr);
            m3243J(DanmakuFilters.f43570u, this.f43714s);
        } else {
            this.f43692C.m3383k(DanmakuFilters.f43570u);
        }
        this.f43691B.m3064b();
        m3209s(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.f43714s);
        return this;
    }

    /* renamed from: W */
    public DanmakuContext m3230W(Integer... numArr) {
        this.f43713r.clear();
        if (numArr != null && numArr.length != 0) {
            Collections.addAll(this.f43713r, numArr);
            m3243J(DanmakuFilters.f43569t, this.f43713r);
        } else {
            this.f43692C.m3383k(DanmakuFilters.f43569t);
        }
        this.f43691B.m3064b();
        m3209s(DanmakuConfigTag.USER_ID_BLACK_LIST, this.f43713r);
        return this;
    }

    /* renamed from: X */
    public void m3229X() {
        List<WeakReference<InterfaceC15342a>> list = this.f43715t;
        if (list != null) {
            list.clear();
            this.f43715t = null;
        }
    }

    /* renamed from: Y */
    public void m3228Y(InterfaceC15342a interfaceC15342a) {
        List<WeakReference<InterfaceC15342a>> list;
        if (interfaceC15342a == null || (list = this.f43715t) == null) {
            return;
        }
        for (WeakReference<InterfaceC15342a> weakReference : list) {
            if (interfaceC15342a.equals(weakReference.get())) {
                this.f43715t.remove(interfaceC15342a);
                return;
            }
        }
    }

    /* renamed from: a */
    public DanmakuContext m3227a(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            Collections.addAll(this.f43714s, strArr);
            m3243J(DanmakuFilters.f43570u, this.f43714s);
            this.f43691B.m3064b();
            m3209s(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.f43714s);
        }
        return this;
    }

    /* renamed from: b */
    public DanmakuContext m3226b(Integer... numArr) {
        if (numArr != null && numArr.length != 0) {
            Collections.addAll(this.f43713r, numArr);
            m3243J(DanmakuFilters.f43569t, this.f43713r);
            this.f43691B.m3064b();
            m3209s(DanmakuConfigTag.USER_ID_BLACK_LIST, this.f43713r);
        }
        return this;
    }

    /* renamed from: c */
    public DanmakuContext m3225c(boolean z) {
        if (this.f43718w != z) {
            this.f43718w = z;
            m3209s(DanmakuConfigTag.ALIGN_BOTTOM, Boolean.valueOf(z));
            this.f43691B.m3059g();
        }
        return this;
    }

    /* renamed from: d */
    public DanmakuContext m3224d(boolean z) {
        if (this.f43716u != z) {
            this.f43716u = z;
            if (z) {
                m3243J(DanmakuFilters.f43571v, Boolean.valueOf(z));
            } else {
                this.f43692C.m3383k(DanmakuFilters.f43571v);
            }
            this.f43691B.m3064b();
            m3209s(DanmakuConfigTag.BLOCK_GUEST_DANMAKU, Boolean.valueOf(z));
        }
        return this;
    }

    /* renamed from: f */
    public List<Integer> m3222f() {
        return this.f43712q;
    }

    /* renamed from: g */
    public AbsDisplayer m3221g() {
        return this.f43690A;
    }

    /* renamed from: h */
    public boolean m3220h() {
        return this.f43701f;
    }

    /* renamed from: i */
    public boolean m3219i() {
        return this.f43700e;
    }

    /* renamed from: j */
    public boolean m3218j() {
        return this.f43702g;
    }

    /* renamed from: k */
    public boolean m3217k() {
        return this.f43703h;
    }

    /* renamed from: l */
    public boolean m3216l() {
        return this.f43704i;
    }

    /* renamed from: m */
    public List<String> m3215m() {
        return this.f43714s;
    }

    /* renamed from: n */
    public List<Integer> m3214n() {
        return this.f43713r;
    }

    /* renamed from: o */
    public boolean m3213o() {
        return this.f43718w;
    }

    /* renamed from: p */
    public boolean m3212p() {
        return this.f43717v;
    }

    /* renamed from: q */
    public boolean m3211q() {
        return this.f43720y;
    }

    /* renamed from: r */
    public boolean m3210r() {
        return this.f43721z;
    }

    /* renamed from: t */
    public DanmakuContext m3208t(Map<Integer, Boolean> map) {
        this.f43721z = map != null;
        if (map == null) {
            this.f43692C.m3382l(DanmakuFilters.f43574y, false);
        } else {
            m3242K(DanmakuFilters.f43574y, map, false);
        }
        this.f43691B.m3064b();
        m3209s(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    /* renamed from: u */
    public void m3207u(InterfaceC15342a interfaceC15342a) {
        if (interfaceC15342a == null || this.f43715t == null) {
            this.f43715t = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<InterfaceC15342a> weakReference : this.f43715t) {
            if (interfaceC15342a.equals(weakReference.get())) {
                return;
            }
        }
        this.f43715t.add(new WeakReference<>(interfaceC15342a));
    }

    /* renamed from: v */
    public DanmakuContext m3206v(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                this.f43714s.remove(str);
            }
            m3243J(DanmakuFilters.f43570u, this.f43714s);
            this.f43691B.m3064b();
            m3209s(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.f43714s);
        }
        return this;
    }

    /* renamed from: w */
    public DanmakuContext m3205w(Integer... numArr) {
        if (numArr != null && numArr.length != 0) {
            for (Integer num : numArr) {
                this.f43713r.remove(num);
            }
            m3243J(DanmakuFilters.f43569t, this.f43713r);
            this.f43691B.m3064b();
            m3209s(DanmakuConfigTag.USER_ID_BLACK_LIST, this.f43713r);
        }
        return this;
    }

    /* renamed from: x */
    public DanmakuContext m3204x(BaseCacheStuffer baseCacheStuffer, BaseCacheStuffer.AbstractC15344a abstractC15344a) {
        this.f43719x = baseCacheStuffer;
        if (baseCacheStuffer != null) {
            baseCacheStuffer.m3161h(abstractC15344a);
            this.f43690A.mo3098y(this.f43719x);
        }
        return this;
    }

    /* renamed from: y */
    public DanmakuContext m3203y(CachingPolicy cachingPolicy) {
        this.f43694E = cachingPolicy;
        return this;
    }

    /* renamed from: z */
    public DanmakuContext m3202z(Integer... numArr) {
        this.f43712q.clear();
        if (numArr != null && numArr.length != 0) {
            Collections.addAll(this.f43712q, numArr);
            m3243J(DanmakuFilters.f43568s, this.f43712q);
        } else {
            this.f43692C.m3383k(DanmakuFilters.f43568s);
        }
        this.f43691B.m3064b();
        m3209s(DanmakuConfigTag.COLOR_VALUE_WHITE_LIST, this.f43712q);
        return this;
    }
}
