package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.z;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.o;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.q;
import kotlin.reflect.jvm.internal.impl.load.kotlin.v;
import kotlin.reflect.n;
import m2.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaPackageFragment.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h extends z {

    /* renamed from: n  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56844n = {n0.u(new PropertyReference1Impl(n0.d(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), n0.u(new PropertyReference1Impl(n0.d(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final u f56845g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56846h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56847i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final d f56848j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<List<kotlin.reflect.jvm.internal.impl.name.c>> f56849k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f56850l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56851m;

    /* compiled from: LazyJavaPackageFragment.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<Map<String, ? extends p>> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Map<String, p> invoke() {
            Map<String, p> B0;
            v o4 = h.this.f56846h.a().o();
            String b4 = h.this.e().b();
            f0.o(b4, "fqName.asString()");
            List<String> a4 = o4.a(b4);
            h hVar = h.this;
            ArrayList arrayList = new ArrayList();
            for (String str : a4) {
                kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(kotlin.reflect.jvm.internal.impl.resolve.jvm.d.d(str).e());
                f0.o(m4, "topLevel(JvmClassName.by\u2026velClassMaybeWithDollars)");
                p a5 = o.a(hVar.f56846h.a().j(), m4);
                Pair a6 = a5 == null ? null : l0.a(str, a5);
                if (a6 != null) {
                    arrayList.add(a6);
                }
            }
            B0 = z0.B0(arrayList);
            return B0;
        }
    }

    /* compiled from: LazyJavaPackageFragment.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<HashMap<kotlin.reflect.jvm.internal.impl.resolve.jvm.d, kotlin.reflect.jvm.internal.impl.resolve.jvm.d>> {

        /* compiled from: LazyJavaPackageFragment.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f56854a;

            static {
                int[] iArr = new int[KotlinClassHeader.Kind.values().length];
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
                f56854a = iArr;
            }
        }

        b() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final HashMap<kotlin.reflect.jvm.internal.impl.resolve.jvm.d, kotlin.reflect.jvm.internal.impl.resolve.jvm.d> invoke() {
            HashMap<kotlin.reflect.jvm.internal.impl.resolve.jvm.d, kotlin.reflect.jvm.internal.impl.resolve.jvm.d> hashMap = new HashMap<>();
            for (Map.Entry<String, p> entry : h.this.H0().entrySet()) {
                kotlin.reflect.jvm.internal.impl.resolve.jvm.d d4 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.d(entry.getKey());
                f0.o(d4, "byInternalName(partInternalName)");
                KotlinClassHeader e4 = entry.getValue().e();
                int i4 = a.f56854a[e4.c().ordinal()];
                if (i4 == 1) {
                    String e5 = e4.e();
                    if (e5 != null) {
                        kotlin.reflect.jvm.internal.impl.resolve.jvm.d d5 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.d(e5);
                        f0.o(d5, "byInternalName(header.mu\u2026: continue@kotlinClasses)");
                        hashMap.put(d4, d5);
                    }
                } else if (i4 == 2) {
                    hashMap.put(d4, d4);
                }
            }
            return hashMap;
        }
    }

    /* compiled from: LazyJavaPackageFragment.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.name.c>> {
        c() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.name.c> invoke() {
            int Z;
            Collection<u> u3 = h.this.f56845g.u();
            Z = y.Z(u3, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (u uVar : u3) {
                arrayList.add(uVar.e());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h outerContext, @NotNull u jPackage) {
        super(outerContext.d(), jPackage.e());
        List F;
        f0.p(outerContext, "outerContext");
        f0.p(jPackage, "jPackage");
        this.f56845g = jPackage;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.h d4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.d(outerContext, this, null, 0, 6, null);
        this.f56846h = d4;
        this.f56847i = d4.e().g(new a());
        this.f56848j = new d(d4, jPackage, this);
        kotlin.reflect.jvm.internal.impl.storage.n e4 = d4.e();
        c cVar = new c();
        F = CollectionsKt__CollectionsKt.F();
        this.f56849k = e4.h(cVar, F);
        this.f56850l = d4.a().i().b() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b() : kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(d4, jPackage);
        this.f56851m = d4.e().g(new b());
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d G0(@NotNull m2.g jClass) {
        f0.p(jClass, "jClass");
        return this.f56848j.k().P(jClass);
    }

    @NotNull
    public final Map<String, p> H0() {
        return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56847i, this, f56844n[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    @NotNull
    /* renamed from: I0 */
    public d p() {
        return this.f56848j;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.name.c> J0() {
        return this.f56849k.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return this.f56850l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z, kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public v0 getSource() {
        return new q(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z, kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    @NotNull
    public String toString() {
        return "Lazy Java package fragment: " + e() + " of module " + this.f56846h.a().m();
    }
}
