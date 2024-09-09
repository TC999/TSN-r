package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.y;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: TypeIntersectionScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n extends kotlin.reflect.jvm.internal.impl.resolve.scopes.a {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f57941d = new a(null);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f57942b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final h f57943c;

    /* compiled from: TypeIntersectionScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final h a(@NotNull String message, @NotNull Collection<? extends e0> types) {
            int Z;
            f0.p(message, "message");
            f0.p(types, "types");
            Z = y.Z(types, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (e0 e0Var : types) {
                arrayList.add(e0Var.p());
            }
            kotlin.reflect.jvm.internal.impl.utils.e<h> b4 = t2.a.b(arrayList);
            h b5 = kotlin.reflect.jvm.internal.impl.resolve.scopes.b.f57884d.b(message, b4);
            return b4.size() <= 1 ? b5 : new n(message, b5, null);
        }
    }

    /* compiled from: TypeIntersectionScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f57944a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.a invoke(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a selectMostSpecificInEachOverridableGroup) {
            f0.p(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
            return selectMostSpecificInEachOverridableGroup;
        }
    }

    /* compiled from: TypeIntersectionScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.l<u0, kotlin.reflect.jvm.internal.impl.descriptors.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f57945a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.a invoke(@NotNull u0 selectMostSpecificInEachOverridableGroup) {
            f0.p(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
            return selectMostSpecificInEachOverridableGroup;
        }
    }

    /* compiled from: TypeIntersectionScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.l<p0, kotlin.reflect.jvm.internal.impl.descriptors.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f57946a = new d();

        d() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.a invoke(@NotNull p0 selectMostSpecificInEachOverridableGroup) {
            f0.p(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
            return selectMostSpecificInEachOverridableGroup;
        }
    }

    private n(String str, h hVar) {
        this.f57942b = str;
        this.f57943c = hVar;
    }

    public /* synthetic */ n(String str, h hVar, u uVar) {
        this(str, hVar);
    }

    @JvmStatic
    @NotNull
    public static final h k(@NotNull String str, @NotNull Collection<? extends e0> collection) {
        return f57941d.a(str, collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        return kotlin.reflect.jvm.internal.impl.resolve.j.a(super.a(name, location), c.f57945a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        return kotlin.reflect.jvm.internal.impl.resolve.j.a(super.c(name, location), d.f57946a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        List o4;
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f4 = super.f(kindFilter, nameFilter);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : f4) {
            if (((kotlin.reflect.jvm.internal.impl.descriptors.k) obj) instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        o4 = kotlin.collections.f0.o4(kotlin.reflect.jvm.internal.impl.resolve.j.a((List) pair.component1(), b.f57944a), (List) pair.component2());
        return o4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a
    @NotNull
    protected h j() {
        return this.f57943c;
    }
}
