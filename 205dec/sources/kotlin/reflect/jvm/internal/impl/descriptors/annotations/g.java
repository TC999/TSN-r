package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnnotationsImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g implements f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<c> f56244a;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull List<? extends c> annotations) {
        f0.p(annotations, "annotations");
        this.f56244a = annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    @Nullable
    public c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return f.b.a(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean i(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return f.b.b(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean isEmpty() {
        return this.f56244a.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<c> iterator() {
        return this.f56244a.iterator();
    }

    @NotNull
    public String toString() {
        return this.f56244a.toString();
    }
}
