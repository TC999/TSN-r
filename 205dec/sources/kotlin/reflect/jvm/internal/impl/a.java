package kotlin.reflect.jvm.internal.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.load.java.x;
import kotlin.reflect.jvm.internal.impl.load.java.y;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpecialJvmAnnotations.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f56011a = new a();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Set<b> f56012b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final b f56013c;

    /* compiled from: SpecialJvmAnnotations.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1119a implements p.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f56014a;

        C1119a(Ref.BooleanRef booleanRef) {
            this.f56014a = booleanRef;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.c
        @Nullable
        public p.a b(@NotNull b classId, @NotNull v0 source) {
            f0.p(classId, "classId");
            f0.p(source, "source");
            if (f0.g(classId, x.f57101a.a())) {
                this.f56014a.element = true;
                return null;
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.c
        public void visitEnd() {
        }
    }

    static {
        List<c> M;
        M = CollectionsKt__CollectionsKt.M(y.f57105a, y.f57115k, y.f57116l, y.f57108d, y.f57110f, y.f57113i);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (c cVar : M) {
            linkedHashSet.add(b.m(cVar));
        }
        f56012b = linkedHashSet;
        b m4 = b.m(y.f57114j);
        f0.o(m4, "topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION)");
        f56013c = m4;
    }

    private a() {
    }

    @NotNull
    public final b a() {
        return f56013c;
    }

    @NotNull
    public final Set<b> b() {
        return f56012b;
    }

    public final boolean c(@NotNull p klass) {
        f0.p(klass, "klass");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        klass.f(new C1119a(booleanRef), null);
        return booleanRef.element;
    }
}
