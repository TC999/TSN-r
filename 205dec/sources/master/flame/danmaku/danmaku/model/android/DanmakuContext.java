package master.flame.danmaku.danmaku.model.android;

import android.graphics.Typeface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DanmakuContext {

    /* renamed from: o  reason: collision with root package name */
    public master.flame.danmaku.danmaku.model.a f61020o;

    /* renamed from: t  reason: collision with root package name */
    private List<WeakReference<a>> f61025t;

    /* renamed from: x  reason: collision with root package name */
    private b f61029x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f61030y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f61031z;

    /* renamed from: a  reason: collision with root package name */
    public Typeface f61006a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f61007b = master.flame.danmaku.danmaku.model.c.f61143a;

    /* renamed from: c  reason: collision with root package name */
    public float f61008c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public int f61009d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61010e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61011f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61012g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61013h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61014i = true;

    /* renamed from: j  reason: collision with root package name */
    List<Integer> f61015j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public int f61016k = -1;

    /* renamed from: l  reason: collision with root package name */
    public float f61017l = 1.0f;

    /* renamed from: m  reason: collision with root package name */
    public int f61018m = 15;

    /* renamed from: n  reason: collision with root package name */
    public BorderType f61019n = BorderType.SHADOW;

    /* renamed from: p  reason: collision with root package name */
    public int f61021p = 3;

    /* renamed from: q  reason: collision with root package name */
    List<Integer> f61022q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    List<Integer> f61023r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    List<String> f61024s = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    private boolean f61026u = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f61027v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f61028w = false;
    private final master.flame.danmaku.danmaku.model.b A = new master.flame.danmaku.danmaku.model.android.a();
    public final master.flame.danmaku.danmaku.model.j B = new master.flame.danmaku.danmaku.model.j();
    public final master.flame.danmaku.controller.b C = new master.flame.danmaku.controller.b();
    public final d D = d.a();
    public c E = c.f61080n;
    public byte F = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum BorderType {
        NONE,
        SHADOW,
        STROKEN
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a {
        boolean a(DanmakuContext danmakuContext, DanmakuConfigTag danmakuConfigTag, Object... objArr);
    }

    private void F(boolean z3, int i4) {
        if (z3) {
            this.f61015j.remove(Integer.valueOf(i4));
        } else if (this.f61015j.contains(Integer.valueOf(i4))) {
        } else {
            this.f61015j.add(Integer.valueOf(i4));
        }
    }

    private <T> void J(String str, T t3) {
        K(str, t3, true);
    }

    private <T> void K(String str, T t3, boolean z3) {
        this.C.e(str, z3).a(t3);
    }

    public static DanmakuContext e() {
        return new DanmakuContext();
    }

    private void s(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        List<WeakReference<a>> list = this.f61025t;
        if (list != null) {
            for (WeakReference<a> weakReference : list) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }

    public DanmakuContext A(boolean z3) {
        this.A.A(z3);
        s(DanmakuConfigTag.DANMAKU_BOLD, Boolean.valueOf(z3));
        return this;
    }

    public DanmakuContext B(int i4) {
        if (this.f61009d != i4) {
            this.f61009d = i4;
            this.A.k(i4);
            this.B.b();
            this.B.g();
            s(DanmakuConfigTag.DANMAKU_MARGIN, Integer.valueOf(i4));
        }
        return this;
    }

    public DanmakuContext C(int i4, float... fArr) {
        this.A.c(i4, fArr);
        s(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i4), fArr);
        return this;
    }

    public DanmakuContext D(master.flame.danmaku.danmaku.model.a aVar) {
        this.f61020o = aVar;
        return this;
    }

    public DanmakuContext E(float f4) {
        int i4 = (int) (master.flame.danmaku.danmaku.model.c.f61143a * f4);
        if (i4 != this.f61007b) {
            this.f61007b = i4;
            this.A.C(i4);
            s(DanmakuConfigTag.TRANSPARENCY, Float.valueOf(f4));
        }
        return this;
    }

    public DanmakuContext G(boolean z3) {
        if (this.f61027v != z3) {
            this.f61027v = z3;
            this.B.b();
            s(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z3));
        }
        return this;
    }

    public DanmakuContext H(boolean z3) {
        F(z3, 4);
        J("1010_Filter", this.f61015j);
        this.B.b();
        if (this.f61011f != z3) {
            this.f61011f = z3;
            s(DanmakuConfigTag.FB_DANMAKU_VISIBILITY, Boolean.valueOf(z3));
        }
        return this;
    }

    public DanmakuContext I(boolean z3) {
        F(z3, 5);
        J("1010_Filter", this.f61015j);
        this.B.b();
        if (this.f61010e != z3) {
            this.f61010e = z3;
            s(DanmakuConfigTag.FT_DANMAKU_VISIBILITY, Boolean.valueOf(z3));
        }
        return this;
    }

    public DanmakuContext L(boolean z3) {
        F(z3, 6);
        J("1010_Filter", this.f61015j);
        this.B.b();
        if (this.f61012g != z3) {
            this.f61012g = z3;
            s(DanmakuConfigTag.L2R_DANMAKU_VISIBILITY, Boolean.valueOf(z3));
        }
        return this;
    }

    public DanmakuContext M(int i4) {
        this.A.m(i4);
        return this;
    }

    public DanmakuContext N(Map<Integer, Integer> map) {
        this.f61030y = map != null;
        if (map == null) {
            this.C.l("1018_Filter", false);
        } else {
            K("1018_Filter", map, false);
        }
        this.B.b();
        s(DanmakuConfigTag.MAXIMUN_LINES, map);
        return this;
    }

    public DanmakuContext O(int i4) {
        this.f61016k = i4;
        if (i4 == 0) {
            this.C.k("1011_Filter");
            this.C.k("1012_Filter");
            s(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(i4));
            return this;
        } else if (i4 == -1) {
            this.C.k("1011_Filter");
            this.C.f("1012_Filter");
            s(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(i4));
            return this;
        } else {
            J("1011_Filter", Integer.valueOf(i4));
            this.B.b();
            s(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(i4));
            return this;
        }
    }

    @Deprecated
    public DanmakuContext P(Map<Integer, Boolean> map) {
        return t(map);
    }

    public DanmakuContext Q(boolean z3) {
        F(z3, 1);
        J("1010_Filter", this.f61015j);
        this.B.b();
        if (this.f61013h != z3) {
            this.f61013h = z3;
            s(DanmakuConfigTag.R2L_DANMAKU_VISIBILIY, Boolean.valueOf(z3));
        }
        return this;
    }

    public DanmakuContext R(float f4) {
        if (this.f61008c != f4) {
            this.f61008c = f4;
            this.A.u();
            this.A.B(f4);
            this.B.d();
            this.B.g();
            s(DanmakuConfigTag.SCALE_TEXTSIZE, Float.valueOf(f4));
        }
        return this;
    }

    public DanmakuContext S(float f4) {
        if (this.f61017l != f4) {
            this.f61017l = f4;
            this.D.l(f4);
            this.B.d();
            this.B.g();
            s(DanmakuConfigTag.SCROLL_SPEED_FACTOR, Float.valueOf(f4));
        }
        return this;
    }

    public DanmakuContext T(boolean z3) {
        F(z3, 7);
        J("1010_Filter", this.f61015j);
        this.B.b();
        if (this.f61014i != z3) {
            this.f61014i = z3;
            s(DanmakuConfigTag.SPECIAL_DANMAKU_VISIBILITY, Boolean.valueOf(z3));
        }
        return this;
    }

    public DanmakuContext U(Typeface typeface) {
        if (this.f61006a != typeface) {
            this.f61006a = typeface;
            this.A.u();
            this.A.D(typeface);
            s(DanmakuConfigTag.TYPEFACE, new Object[0]);
        }
        return this;
    }

    public DanmakuContext V(String... strArr) {
        this.f61024s.clear();
        if (strArr != null && strArr.length != 0) {
            Collections.addAll(this.f61024s, strArr);
            J("1015_Filter", this.f61024s);
        } else {
            this.C.k("1015_Filter");
        }
        this.B.b();
        s(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.f61024s);
        return this;
    }

    public DanmakuContext W(Integer... numArr) {
        this.f61023r.clear();
        if (numArr != null && numArr.length != 0) {
            Collections.addAll(this.f61023r, numArr);
            J("1014_Filter", this.f61023r);
        } else {
            this.C.k("1014_Filter");
        }
        this.B.b();
        s(DanmakuConfigTag.USER_ID_BLACK_LIST, this.f61023r);
        return this;
    }

    public void X() {
        List<WeakReference<a>> list = this.f61025t;
        if (list != null) {
            list.clear();
            this.f61025t = null;
        }
    }

    public void Y(a aVar) {
        List<WeakReference<a>> list;
        if (aVar == null || (list = this.f61025t) == null) {
            return;
        }
        for (WeakReference<a> weakReference : list) {
            if (aVar.equals(weakReference.get())) {
                this.f61025t.remove(aVar);
                return;
            }
        }
    }

    public DanmakuContext a(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            Collections.addAll(this.f61024s, strArr);
            J("1015_Filter", this.f61024s);
            this.B.b();
            s(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.f61024s);
        }
        return this;
    }

    public DanmakuContext b(Integer... numArr) {
        if (numArr != null && numArr.length != 0) {
            Collections.addAll(this.f61023r, numArr);
            J("1014_Filter", this.f61023r);
            this.B.b();
            s(DanmakuConfigTag.USER_ID_BLACK_LIST, this.f61023r);
        }
        return this;
    }

    public DanmakuContext c(boolean z3) {
        if (this.f61028w != z3) {
            this.f61028w = z3;
            s(DanmakuConfigTag.ALIGN_BOTTOM, Boolean.valueOf(z3));
            this.B.g();
        }
        return this;
    }

    public DanmakuContext d(boolean z3) {
        if (this.f61026u != z3) {
            this.f61026u = z3;
            if (z3) {
                J("1016_Filter", Boolean.valueOf(z3));
            } else {
                this.C.k("1016_Filter");
            }
            this.B.b();
            s(DanmakuConfigTag.BLOCK_GUEST_DANMAKU, Boolean.valueOf(z3));
        }
        return this;
    }

    public List<Integer> f() {
        return this.f61022q;
    }

    public master.flame.danmaku.danmaku.model.b g() {
        return this.A;
    }

    public boolean h() {
        return this.f61011f;
    }

    public boolean i() {
        return this.f61010e;
    }

    public boolean j() {
        return this.f61012g;
    }

    public boolean k() {
        return this.f61013h;
    }

    public boolean l() {
        return this.f61014i;
    }

    public List<String> m() {
        return this.f61024s;
    }

    public List<Integer> n() {
        return this.f61023r;
    }

    public boolean o() {
        return this.f61028w;
    }

    public boolean p() {
        return this.f61027v;
    }

    public boolean q() {
        return this.f61030y;
    }

    public boolean r() {
        return this.f61031z;
    }

    public DanmakuContext t(Map<Integer, Boolean> map) {
        this.f61031z = map != null;
        if (map == null) {
            this.C.l("1019_Filter", false);
        } else {
            K("1019_Filter", map, false);
        }
        this.B.b();
        s(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public void u(a aVar) {
        if (aVar == null || this.f61025t == null) {
            this.f61025t = Collections.synchronizedList(new ArrayList());
        }
        for (WeakReference<a> weakReference : this.f61025t) {
            if (aVar.equals(weakReference.get())) {
                return;
            }
        }
        this.f61025t.add(new WeakReference<>(aVar));
    }

    public DanmakuContext v(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                this.f61024s.remove(str);
            }
            J("1015_Filter", this.f61024s);
            this.B.b();
            s(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.f61024s);
        }
        return this;
    }

    public DanmakuContext w(Integer... numArr) {
        if (numArr != null && numArr.length != 0) {
            for (Integer num : numArr) {
                this.f61023r.remove(num);
            }
            J("1014_Filter", this.f61023r);
            this.B.b();
            s(DanmakuConfigTag.USER_ID_BLACK_LIST, this.f61023r);
        }
        return this;
    }

    public DanmakuContext x(b bVar, b.a aVar) {
        this.f61029x = bVar;
        if (bVar != null) {
            bVar.h(aVar);
            this.A.y(this.f61029x);
        }
        return this;
    }

    public DanmakuContext y(c cVar) {
        this.E = cVar;
        return this;
    }

    public DanmakuContext z(Integer... numArr) {
        this.f61022q.clear();
        if (numArr != null && numArr.length != 0) {
            Collections.addAll(this.f61022q, numArr);
            J("1013_Filter", this.f61022q);
        } else {
            this.C.k("1013_Filter");
        }
        this.B.b();
        s(DanmakuConfigTag.COLOR_VALUE_WHITE_LIST, this.f61022q);
        return this;
    }
}
