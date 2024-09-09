package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import d2.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Annotations.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k implements f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final f f56253a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f56254b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final l<kotlin.reflect.jvm.internal.impl.name.c, Boolean> f56255c;

    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull f delegate, boolean z3, @NotNull l<? super kotlin.reflect.jvm.internal.impl.name.c, Boolean> fqNameFilter) {
        f0.p(delegate, "delegate");
        f0.p(fqNameFilter, "fqNameFilter");
        this.f56253a = delegate;
        this.f56254b = z3;
        this.f56255c = fqNameFilter;
    }

    private final boolean a(c cVar) {
        kotlin.reflect.jvm.internal.impl.name.c e4 = cVar.e();
        return e4 != null && this.f56255c.invoke(e4).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    @Nullable
    public c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        if (this.f56255c.invoke(fqName).booleanValue()) {
            return this.f56253a.b(fqName);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean i(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        if (this.f56255c.invoke(fqName).booleanValue()) {
            return this.f56253a.i(fqName);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean isEmpty() {
        boolean z3;
        f<c> fVar = this.f56253a;
        if (!(fVar instanceof Collection) || !((Collection) fVar).isEmpty()) {
            for (c cVar : fVar) {
                if (a(cVar)) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        return this.f56254b ? !z3 : z3;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<c> iterator() {
        f fVar = this.f56253a;
        ArrayList arrayList = new ArrayList();
        for (c cVar : fVar) {
            if (a(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList.iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(@NotNull f delegate, @NotNull l<? super kotlin.reflect.jvm.internal.impl.name.c, Boolean> fqNameFilter) {
        this(delegate, false, fqNameFilter);
        f0.p(delegate, "delegate");
        f0.p(fqNameFilter, "fqNameFilter");
    }
}
