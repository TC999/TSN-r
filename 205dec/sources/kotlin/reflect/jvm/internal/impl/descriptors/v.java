package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: findClassInModule.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v {

    /* compiled from: findClassInModule.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    /* synthetic */ class a extends FunctionReference implements d2.l<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.name.b> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56632a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: d */
        public final kotlin.reflect.jvm.internal.impl.name.b invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.b p02) {
            kotlin.jvm.internal.f0.p(p02, "p0");
            return p02.g();
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return kotlin.jvm.internal.n0.d(kotlin.reflect.jvm.internal.impl.name.b.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }
    }

    /* compiled from: findClassInModule.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.b, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56633a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Integer invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.b it) {
            kotlin.jvm.internal.f0.p(it, "it");
            return 0;
        }
    }

    @Nullable
    public static final d a(@NotNull d0 d0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(classId, "classId");
        f b4 = b(d0Var, classId);
        if (b4 instanceof d) {
            return (d) b4;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014c  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.f b(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.d0 r10, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.b r11) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.v.b(kotlin.reflect.jvm.internal.impl.descriptors.d0, kotlin.reflect.jvm.internal.impl.name.b):kotlin.reflect.jvm.internal.impl.descriptors.f");
    }

    @NotNull
    public static final d c(@NotNull d0 d0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull f0 notFoundClasses) {
        kotlin.sequences.m q3;
        kotlin.sequences.m d12;
        List<Integer> V2;
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(classId, "classId");
        kotlin.jvm.internal.f0.p(notFoundClasses, "notFoundClasses");
        d a4 = a(d0Var, classId);
        if (a4 != null) {
            return a4;
        }
        q3 = kotlin.sequences.s.q(classId, a.f56632a);
        d12 = SequencesKt___SequencesKt.d1(q3, b.f56633a);
        V2 = SequencesKt___SequencesKt.V2(d12);
        return notFoundClasses.d(classId, V2);
    }

    @Nullable
    public static final z0 d(@NotNull d0 d0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        kotlin.jvm.internal.f0.p(d0Var, "<this>");
        kotlin.jvm.internal.f0.p(classId, "classId");
        f b4 = b(d0Var, classId);
        if (b4 instanceof z0) {
            return (z0) b4;
        }
        return null;
    }
}
