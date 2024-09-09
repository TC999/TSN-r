package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJavaAnnotations.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final h f56914a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final m2.d f56915b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f56916c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.h<m2.a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f56917d;

    /* compiled from: LazyJavaAnnotations.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<m2.a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> {
        a() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c invoke(@NotNull m2.a annotation) {
            f0.p(annotation, "annotation");
            return kotlin.reflect.jvm.internal.impl.load.java.components.c.f56688a.e(annotation, e.this.f56914a, e.this.f56916c);
        }
    }

    public e(@NotNull h c4, @NotNull m2.d annotationOwner, boolean z3) {
        f0.p(c4, "c");
        f0.p(annotationOwner, "annotationOwner");
        this.f56914a = c4;
        this.f56915b = annotationOwner;
        this.f56916c = z3;
        this.f56917d = c4.a().u().e(new a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        m2.a b4 = this.f56915b.b(fqName);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c invoke = b4 == null ? null : this.f56917d.invoke(b4);
        return invoke == null ? kotlin.reflect.jvm.internal.impl.load.java.components.c.f56688a.a(fqName, this.f56915b, this.f56914a) : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean i(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return f.b.b(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean isEmpty() {
        return this.f56915b.getAnnotations().isEmpty() && !this.f56915b.B();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        m l12;
        m d12;
        m g22;
        m o02;
        l12 = kotlin.collections.f0.l1(this.f56915b.getAnnotations());
        d12 = SequencesKt___SequencesKt.d1(l12, this.f56917d);
        g22 = SequencesKt___SequencesKt.g2(d12, kotlin.reflect.jvm.internal.impl.load.java.components.c.f56688a.a(j.a.f56139y, this.f56915b, this.f56914a));
        o02 = SequencesKt___SequencesKt.o0(g22);
        return o02.iterator();
    }

    public /* synthetic */ e(h hVar, m2.d dVar, boolean z3, int i4, u uVar) {
        this(hVar, dVar, (i4 & 4) != 0 ? false : z3);
    }
}
