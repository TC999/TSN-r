package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.j1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MemberScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface h extends k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f57927a = a.f57928a;

    /* compiled from: MemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f57928a = new a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final d2.l<kotlin.reflect.jvm.internal.impl.name.f, Boolean> f57929b = C1171a.f57930a;

        /* compiled from: MemberScope.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.scopes.h$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1171a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public static final C1171a f57930a = new C1171a();

            C1171a() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final Boolean invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f it) {
                f0.p(it, "it");
                return Boolean.TRUE;
            }
        }

        private a() {
        }

        @NotNull
        public final d2.l<kotlin.reflect.jvm.internal.impl.name.f, Boolean> a() {
            return f57929b;
        }
    }

    /* compiled from: MemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        public static void a(@NotNull h hVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
            f0.p(hVar, "this");
            f0.p(name, "name");
            f0.p(location, "location");
            k.a.b(hVar, name, location);
        }
    }

    /* compiled from: MemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends i {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final c f57931b = new c();

        private c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
            k4 = j1.k();
            return k4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
            k4 = j1.k();
            return k4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
            k4 = j1.k();
            return k4;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    Collection<? extends u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar);

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.f> b();

    @NotNull
    Collection<? extends p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar);

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.f> d();

    @Nullable
    Set<kotlin.reflect.jvm.internal.impl.name.f> g();
}
