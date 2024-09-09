package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: typeEnhancement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.c f56992a;

    public b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqNameToMatch) {
        f0.p(fqNameToMatch, "fqNameToMatch");
        this.f56992a = fqNameToMatch;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    @Nullable
    /* renamed from: a */
    public a b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        if (f0.g(fqName, this.f56992a)) {
            return a.f56991a;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean i(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return f.b.b(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        List F;
        F = CollectionsKt__CollectionsKt.F();
        return F.iterator();
    }
}
