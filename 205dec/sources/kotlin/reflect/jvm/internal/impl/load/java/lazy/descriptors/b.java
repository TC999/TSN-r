package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.j1;
import kotlin.jvm.internal.f0;
import m2.n;
import m2.r;
import m2.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeclaredMemberIndex.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface b {

    /* compiled from: DeclaredMemberIndex.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements b {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f56783a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> a() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
            k4 = j1.k();
            return k4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
            k4 = j1.k();
            return k4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> c() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
            k4 = j1.k();
            return k4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        @Nullable
        public w e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            f0.p(name, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        @Nullable
        public n f(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            f0.p(name, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        @NotNull
        /* renamed from: g */
        public List<r> d(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            List<r> F;
            f0.p(name, "name");
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
    }

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.f> a();

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.f> b();

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.f> c();

    @NotNull
    Collection<r> d(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    @Nullable
    w e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    @Nullable
    n f(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);
}
