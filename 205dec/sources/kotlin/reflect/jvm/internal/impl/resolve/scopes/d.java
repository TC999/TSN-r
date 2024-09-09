package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MemberScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final a f57890c;

    /* renamed from: d  reason: collision with root package name */
    private static int f57891d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f57892e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f57893f;

    /* renamed from: g  reason: collision with root package name */
    private static final int f57894g;

    /* renamed from: h  reason: collision with root package name */
    private static final int f57895h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f57896i;

    /* renamed from: j  reason: collision with root package name */
    private static final int f57897j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f57898k;

    /* renamed from: l  reason: collision with root package name */
    private static final int f57899l;

    /* renamed from: m  reason: collision with root package name */
    private static final int f57900m;

    /* renamed from: n  reason: collision with root package name */
    private static final int f57901n;
    @JvmField
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public static final d f57902o;
    @JvmField
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    public static final d f57903p;
    @JvmField
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    public static final d f57904q;
    @JvmField
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    public static final d f57905r;
    @JvmField
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    public static final d f57906s;
    @JvmField
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    public static final d f57907t;
    @JvmField
    @NotNull

    /* renamed from: u  reason: collision with root package name */
    public static final d f57908u;
    @JvmField
    @NotNull

    /* renamed from: v  reason: collision with root package name */
    public static final d f57909v;
    @JvmField
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    public static final d f57910w;
    @JvmField
    @NotNull

    /* renamed from: x  reason: collision with root package name */
    public static final d f57911x;
    @NotNull

    /* renamed from: y  reason: collision with root package name */
    private static final List<a.C1170a> f57912y;
    @NotNull

    /* renamed from: z  reason: collision with root package name */
    private static final List<a.C1170a> f57913z;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<c> f57914a;

    /* renamed from: b  reason: collision with root package name */
    private final int f57915b;

    /* compiled from: MemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* compiled from: MemberScope.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.scopes.d$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        private static final class C1170a {

            /* renamed from: a  reason: collision with root package name */
            private final int f57916a;
            @NotNull

            /* renamed from: b  reason: collision with root package name */
            private final String f57917b;

            public C1170a(int i4, @NotNull String name) {
                f0.p(name, "name");
                this.f57916a = i4;
                this.f57917b = name;
            }

            public final int a() {
                return this.f57916a;
            }

            @NotNull
            public final String b() {
                return this.f57917b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int j() {
            int i4 = d.f57891d;
            a aVar = d.f57890c;
            d.f57891d <<= 1;
            return i4;
        }

        public final int b() {
            return d.f57898k;
        }

        public final int c() {
            return d.f57899l;
        }

        public final int d() {
            return d.f57896i;
        }

        public final int e() {
            return d.f57892e;
        }

        public final int f() {
            return d.f57895h;
        }

        public final int g() {
            return d.f57893f;
        }

        public final int h() {
            return d.f57894g;
        }

        public final int i() {
            return d.f57897j;
        }
    }

    static {
        a.C1170a c1170a;
        a.C1170a c1170a2;
        a aVar = new a(null);
        f57890c = aVar;
        f57891d = 1;
        int j4 = aVar.j();
        f57892e = j4;
        int j5 = aVar.j();
        f57893f = j5;
        int j6 = aVar.j();
        f57894g = j6;
        int j7 = aVar.j();
        f57895h = j7;
        int j8 = aVar.j();
        f57896i = j8;
        int j9 = aVar.j();
        f57897j = j9;
        int j10 = aVar.j() - 1;
        f57898k = j10;
        int i4 = j4 | j5 | j6;
        f57899l = i4;
        int i5 = j5 | j8 | j9;
        f57900m = i5;
        int i6 = j8 | j9;
        f57901n = i6;
        f57902o = new d(j10, null, 2, null);
        f57903p = new d(i6, null, 2, null);
        f57904q = new d(j4, null, 2, null);
        f57905r = new d(j5, null, 2, null);
        f57906s = new d(j6, null, 2, null);
        f57907t = new d(i4, null, 2, null);
        f57908u = new d(j7, null, 2, null);
        f57909v = new d(j8, null, 2, null);
        f57910w = new d(j9, null, 2, null);
        f57911x = new d(i5, null, 2, null);
        Field[] fields = d.class.getFields();
        f0.o(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        int length = fields.length;
        int i7 = 0;
        while (i7 < length) {
            Field field = fields[i7];
            i7++;
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                int m4 = dVar.m();
                String name = field2.getName();
                f0.o(name, "field.name");
                c1170a2 = new a.C1170a(m4, name);
            } else {
                c1170a2 = null;
            }
            if (c1170a2 != null) {
                arrayList2.add(c1170a2);
            }
        }
        f57912y = arrayList2;
        Field[] fields2 = d.class.getFields();
        f0.o(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        int length2 = fields2.length;
        int i8 = 0;
        while (i8 < length2) {
            Field field3 = fields2[i8];
            i8++;
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (f0.g(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field4.getName();
                f0.o(name2, "field.name");
                c1170a = new a.C1170a(intValue, name2);
            } else {
                c1170a = null;
            }
            if (c1170a != null) {
                arrayList5.add(c1170a);
            }
        }
        f57913z = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i4, @NotNull List<? extends c> excludes) {
        f0.p(excludes, "excludes");
        this.f57914a = excludes;
        for (c cVar : excludes) {
            i4 &= cVar.a() ^ (-1);
        }
        this.f57915b = i4;
    }

    public final boolean a(int i4) {
        return (i4 & this.f57915b) != 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(d.class, obj == null ? null : obj.getClass())) {
            if (obj != null) {
                d dVar = (d) obj;
                return f0.g(this.f57914a, dVar.f57914a) && this.f57915b == dVar.f57915b;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        }
        return false;
    }

    public int hashCode() {
        return (this.f57914a.hashCode() * 31) + this.f57915b;
    }

    @NotNull
    public final List<c> l() {
        return this.f57914a;
    }

    public final int m() {
        return this.f57915b;
    }

    @Nullable
    public final d n(int i4) {
        int i5 = i4 & this.f57915b;
        if (i5 == 0) {
            return null;
        }
        return new d(i5, this.f57914a);
    }

    @NotNull
    public String toString() {
        Object obj;
        boolean z3;
        Iterator<T> it = f57912y.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((a.C1170a) obj).a() == m()) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                break;
            }
        }
        a.C1170a c1170a = (a.C1170a) obj;
        String b4 = c1170a == null ? null : c1170a.b();
        if (b4 == null) {
            List<a.C1170a> list = f57913z;
            ArrayList arrayList = new ArrayList();
            for (a.C1170a c1170a2 : list) {
                String b5 = a(c1170a2.a()) ? c1170a2.b() : null;
                if (b5 != null) {
                    arrayList.add(b5);
                }
            }
            b4 = kotlin.collections.f0.X2(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + b4 + ", " + this.f57914a + ')';
    }

    public /* synthetic */ d(int i4, List list, int i5, u uVar) {
        this(i4, (i5 & 2) != 0 ? CollectionsKt__CollectionsKt.F() : list);
    }
}
