package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import d2.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Annotations.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j implements f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f56250a;

    /* compiled from: Annotations.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements l<f, c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.c f56251a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.name.c cVar) {
            super(1);
            this.f56251a = cVar;
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final c invoke(@NotNull f it) {
            f0.p(it, "it");
            return it.b(this.f56251a);
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements l<f, m<? extends c>> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56252a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final m<c> invoke(@NotNull f it) {
            m<c> l12;
            f0.p(it, "it");
            l12 = kotlin.collections.f0.l1(it);
            return l12;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@NotNull List<? extends f> delegates) {
        f0.p(delegates, "delegates");
        this.f56250a = delegates;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    @Nullable
    public c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        m l12;
        m i12;
        Object y02;
        f0.p(fqName, "fqName");
        l12 = kotlin.collections.f0.l1(this.f56250a);
        i12 = SequencesKt___SequencesKt.i1(l12, new a(fqName));
        y02 = SequencesKt___SequencesKt.y0(i12);
        return (c) y02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean i(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        m<f> l12;
        f0.p(fqName, "fqName");
        l12 = kotlin.collections.f0.l1(this.f56250a);
        for (f fVar : l12) {
            if (fVar.i(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean isEmpty() {
        List<f> list = this.f56250a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (f fVar : list) {
            if (!fVar.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<c> iterator() {
        m l12;
        m A0;
        l12 = kotlin.collections.f0.l1(this.f56250a);
        A0 = SequencesKt___SequencesKt.A0(l12, b.f56252a);
        return A0.iterator();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public j(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f... r2) {
        /*
            r1 = this;
            java.lang.String r0 = "delegates"
            kotlin.jvm.internal.f0.p(r2, r0)
            java.util.List r2 = kotlin.collections.l.ey(r2)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.annotations.j.<init>(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f[]):void");
    }
}
