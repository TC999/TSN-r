package kotlin.jvm.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15270b;
import p617l1.InterfaceC15271c;
import p617l1.InterfaceC15272d;
import p617l1.InterfaceC15273e;
import p617l1.InterfaceC15274f;
import p617l1.InterfaceC15275g;
import p617l1.InterfaceC15276h;
import p617l1.InterfaceC15277i;
import p617l1.InterfaceC15278j;
import p617l1.InterfaceC15279k;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15281m;
import p617l1.InterfaceC15282n;
import p617l1.InterfaceC15283o;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;
import p617l1.InterfaceC15286r;
import p617l1.InterfaceC15287s;
import p617l1.InterfaceC15288t;
import p617l1.InterfaceC15289u;
import p617l1.InterfaceC15290v;
import p617l1.InterfaceC15291w;
import p620m1.InterfaceC15296b;
import p620m1.InterfaceC15297c;
import p620m1.InterfaceC15298d;
import p620m1.InterfaceC15299e;
import p620m1.InterfaceC15300f;
import p620m1.InterfaceC15301g;
import p620m1.InterfaceC15303h;
import p620m1.KMarkers;

/* renamed from: kotlin.jvm.internal.t0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class TypeIntrinsics {
    /* renamed from: A */
    public static int m8040A(Object obj) {
        if (obj instanceof FunctionBase) {
            return ((FunctionBase) obj).getArity();
        }
        if (obj instanceof InterfaceC15269a) {
            return 0;
        }
        if (obj instanceof InterfaceC15280l) {
            return 1;
        }
        if (obj instanceof InterfaceC15284p) {
            return 2;
        }
        if (obj instanceof InterfaceC15285q) {
            return 3;
        }
        if (obj instanceof InterfaceC15286r) {
            return 4;
        }
        if (obj instanceof InterfaceC15287s) {
            return 5;
        }
        if (obj instanceof InterfaceC15288t) {
            return 6;
        }
        if (obj instanceof InterfaceC15289u) {
            return 7;
        }
        if (obj instanceof InterfaceC15290v) {
            return 8;
        }
        if (obj instanceof InterfaceC15291w) {
            return 9;
        }
        if (obj instanceof InterfaceC15270b) {
            return 10;
        }
        if (obj instanceof InterfaceC15271c) {
            return 11;
        }
        if (obj instanceof InterfaceC15272d) {
            return 12;
        }
        if (obj instanceof InterfaceC15273e) {
            return 13;
        }
        if (obj instanceof InterfaceC15274f) {
            return 14;
        }
        if (obj instanceof InterfaceC15275g) {
            return 15;
        }
        if (obj instanceof InterfaceC15276h) {
            return 16;
        }
        if (obj instanceof InterfaceC15277i) {
            return 17;
        }
        if (obj instanceof InterfaceC15278j) {
            return 18;
        }
        if (obj instanceof InterfaceC15279k) {
            return 19;
        }
        if (obj instanceof InterfaceC15281m) {
            return 20;
        }
        if (obj instanceof InterfaceC15282n) {
            return 21;
        }
        return obj instanceof InterfaceC15283o ? 22 : -1;
    }

    /* renamed from: B */
    public static boolean m8039B(Object obj, int i) {
        return (obj instanceof Function) && m8040A(obj) == i;
    }

    /* renamed from: C */
    public static boolean m8038C(Object obj) {
        return (obj instanceof Collection) && (!(obj instanceof KMarkers) || (obj instanceof InterfaceC15296b));
    }

    /* renamed from: D */
    public static boolean m8037D(Object obj) {
        return (obj instanceof Iterable) && (!(obj instanceof KMarkers) || (obj instanceof InterfaceC15297c));
    }

    /* renamed from: E */
    public static boolean m8036E(Object obj) {
        return (obj instanceof Iterator) && (!(obj instanceof KMarkers) || (obj instanceof InterfaceC15298d));
    }

    /* renamed from: F */
    public static boolean m8035F(Object obj) {
        return (obj instanceof List) && (!(obj instanceof KMarkers) || (obj instanceof InterfaceC15299e));
    }

    /* renamed from: G */
    public static boolean m8034G(Object obj) {
        return (obj instanceof ListIterator) && (!(obj instanceof KMarkers) || (obj instanceof InterfaceC15300f));
    }

    /* renamed from: H */
    public static boolean m8033H(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof KMarkers) || (obj instanceof InterfaceC15301g));
    }

    /* renamed from: I */
    public static boolean m8032I(Object obj) {
        return (obj instanceof Map.Entry) && (!(obj instanceof KMarkers) || (obj instanceof InterfaceC15301g.InterfaceC15302a));
    }

    /* renamed from: J */
    public static boolean m8031J(Object obj) {
        return (obj instanceof Set) && (!(obj instanceof KMarkers) || (obj instanceof InterfaceC15303h));
    }

    /* renamed from: K */
    private static <T extends Throwable> T m8030K(T t) {
        return (T) C14342f0.m8217B(t, TypeIntrinsics.class.getName());
    }

    /* renamed from: L */
    public static ClassCastException m8029L(ClassCastException classCastException) {
        throw ((ClassCastException) m8030K(classCastException));
    }

    /* renamed from: M */
    public static void m8028M(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        m8027N(name + " cannot be cast to " + str);
    }

    /* renamed from: N */
    public static void m8027N(String str) {
        throw m8029L(new ClassCastException(str));
    }

    /* renamed from: a */
    public static Collection m8026a(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15296b)) {
            m8028M(obj, "kotlin.collections.MutableCollection");
        }
        return m8008s(obj);
    }

    /* renamed from: b */
    public static Collection m8025b(Object obj, String str) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15296b)) {
            m8027N(str);
        }
        return m8008s(obj);
    }

    /* renamed from: c */
    public static Iterable m8024c(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15297c)) {
            m8028M(obj, "kotlin.collections.MutableIterable");
        }
        return m8007t(obj);
    }

    /* renamed from: d */
    public static Iterable m8023d(Object obj, String str) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15297c)) {
            m8027N(str);
        }
        return m8007t(obj);
    }

    /* renamed from: e */
    public static Iterator m8022e(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15298d)) {
            m8028M(obj, "kotlin.collections.MutableIterator");
        }
        return m8006u(obj);
    }

    /* renamed from: f */
    public static Iterator m8021f(Object obj, String str) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15298d)) {
            m8027N(str);
        }
        return m8006u(obj);
    }

    /* renamed from: g */
    public static List m8020g(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15299e)) {
            m8028M(obj, "kotlin.collections.MutableList");
        }
        return m8005v(obj);
    }

    /* renamed from: h */
    public static List m8019h(Object obj, String str) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15299e)) {
            m8027N(str);
        }
        return m8005v(obj);
    }

    /* renamed from: i */
    public static ListIterator m8018i(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15300f)) {
            m8028M(obj, "kotlin.collections.MutableListIterator");
        }
        return m8004w(obj);
    }

    /* renamed from: j */
    public static ListIterator m8017j(Object obj, String str) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15300f)) {
            m8027N(str);
        }
        return m8004w(obj);
    }

    /* renamed from: k */
    public static Map m8016k(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15301g)) {
            m8028M(obj, "kotlin.collections.MutableMap");
        }
        return m8003x(obj);
    }

    /* renamed from: l */
    public static Map m8015l(Object obj, String str) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15301g)) {
            m8027N(str);
        }
        return m8003x(obj);
    }

    /* renamed from: m */
    public static Map.Entry m8014m(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15301g.InterfaceC15302a)) {
            m8028M(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return m8002y(obj);
    }

    /* renamed from: n */
    public static Map.Entry m8013n(Object obj, String str) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15301g.InterfaceC15302a)) {
            m8027N(str);
        }
        return m8002y(obj);
    }

    /* renamed from: o */
    public static Set m8012o(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15303h)) {
            m8028M(obj, "kotlin.collections.MutableSet");
        }
        return m8001z(obj);
    }

    /* renamed from: p */
    public static Set m8011p(Object obj, String str) {
        if ((obj instanceof KMarkers) && !(obj instanceof InterfaceC15303h)) {
            m8027N(str);
        }
        return m8001z(obj);
    }

    /* renamed from: q */
    public static Object m8010q(Object obj, int i) {
        if (obj != null && !m8039B(obj, i)) {
            m8028M(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    /* renamed from: r */
    public static Object m8009r(Object obj, int i, String str) {
        if (obj != null && !m8039B(obj, i)) {
            m8027N(str);
        }
        return obj;
    }

    /* renamed from: s */
    public static Collection m8008s(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw m8029L(e);
        }
    }

    /* renamed from: t */
    public static Iterable m8007t(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw m8029L(e);
        }
    }

    /* renamed from: u */
    public static Iterator m8006u(Object obj) {
        try {
            return (Iterator) obj;
        } catch (ClassCastException e) {
            throw m8029L(e);
        }
    }

    /* renamed from: v */
    public static List m8005v(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw m8029L(e);
        }
    }

    /* renamed from: w */
    public static ListIterator m8004w(Object obj) {
        try {
            return (ListIterator) obj;
        } catch (ClassCastException e) {
            throw m8029L(e);
        }
    }

    /* renamed from: x */
    public static Map m8003x(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw m8029L(e);
        }
    }

    /* renamed from: y */
    public static Map.Entry m8002y(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e) {
            throw m8029L(e);
        }
    }

    /* renamed from: z */
    public static Set m8001z(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            throw m8029L(e);
        }
    }
}
