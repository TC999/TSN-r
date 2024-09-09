package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.k1;
import org.jetbrains.annotations.NotNull;

/* compiled from: JvmAnnotationNames.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f57125a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f57126b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f57127c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final List<kotlin.reflect.jvm.internal.impl.name.c> f57128d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f57129e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f57130f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final List<kotlin.reflect.jvm.internal.impl.name.c> f57131g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f57132h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f57133i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f57134j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f57135k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f57136l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private static final List<kotlin.reflect.jvm.internal.impl.name.c> f57137m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private static final List<kotlin.reflect.jvm.internal.impl.name.c> f57138n;

    static {
        List<kotlin.reflect.jvm.internal.impl.name.c> M;
        List<kotlin.reflect.jvm.internal.impl.name.c> M2;
        Set C;
        Set D;
        Set C2;
        Set D2;
        Set D3;
        Set D4;
        Set D5;
        Set D6;
        Set D7;
        Set<kotlin.reflect.jvm.internal.impl.name.c> D8;
        List<kotlin.reflect.jvm.internal.impl.name.c> M3;
        List<kotlin.reflect.jvm.internal.impl.name.c> M4;
        kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.nullness.Nullable");
        f57125a = cVar;
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.nullness.NullnessUnspecified");
        f57126b = cVar2;
        kotlin.reflect.jvm.internal.impl.name.c cVar3 = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.nullness.NullMarked");
        f57127c = cVar3;
        M = CollectionsKt__CollectionsKt.M(y.f57116l, new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("android.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("com.android.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("org.eclipse.jdt.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.qual.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.CheckForNull"), new kotlin.reflect.jvm.internal.impl.name.c("edu.umd.cs.findbugs.annotations.CheckForNull"), new kotlin.reflect.jvm.internal.impl.name.c("edu.umd.cs.findbugs.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("edu.umd.cs.findbugs.annotations.PossiblyNull"), new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.rxjava3.annotations.Nullable"));
        f57128d = M;
        kotlin.reflect.jvm.internal.impl.name.c cVar4 = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.Nonnull");
        f57129e = cVar4;
        f57130f = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.CheckForNull");
        M2 = CollectionsKt__CollectionsKt.M(y.f57115k, new kotlin.reflect.jvm.internal.impl.name.c("edu.umd.cs.findbugs.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("android.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("com.android.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("org.eclipse.jdt.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.qual.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("lombok.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.rxjava3.annotations.NonNull"));
        f57131g = M2;
        kotlin.reflect.jvm.internal.impl.name.c cVar5 = new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        f57132h = cVar5;
        kotlin.reflect.jvm.internal.impl.name.c cVar6 = new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        f57133i = cVar6;
        kotlin.reflect.jvm.internal.impl.name.c cVar7 = new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.RecentlyNullable");
        f57134j = cVar7;
        kotlin.reflect.jvm.internal.impl.name.c cVar8 = new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.RecentlyNonNull");
        f57135k = cVar8;
        C = k1.C(new LinkedHashSet(), M);
        D = k1.D(C, cVar4);
        C2 = k1.C(D, M2);
        D2 = k1.D(C2, cVar5);
        D3 = k1.D(D2, cVar6);
        D4 = k1.D(D3, cVar7);
        D5 = k1.D(D4, cVar8);
        D6 = k1.D(D5, cVar);
        D7 = k1.D(D6, cVar2);
        D8 = k1.D(D7, cVar3);
        f57136l = D8;
        M3 = CollectionsKt__CollectionsKt.M(y.f57118n, y.f57119o);
        f57137m = M3;
        M4 = CollectionsKt__CollectionsKt.M(y.f57117m, y.f57120p);
        f57138n = M4;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c a() {
        return f57135k;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c b() {
        return f57134j;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c c() {
        return f57133i;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c d() {
        return f57132h;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c e() {
        return f57130f;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f() {
        return f57129e;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c g() {
        return f57125a;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c h() {
        return f57126b;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c i() {
        return f57127c;
    }

    @NotNull
    public static final List<kotlin.reflect.jvm.internal.impl.name.c> j() {
        return f57138n;
    }

    @NotNull
    public static final List<kotlin.reflect.jvm.internal.impl.name.c> k() {
        return f57131g;
    }

    @NotNull
    public static final List<kotlin.reflect.jvm.internal.impl.name.c> l() {
        return f57128d;
    }

    @NotNull
    public static final List<kotlin.reflect.jvm.internal.impl.name.c> m() {
        return f57137m;
    }
}
