package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StaticScopeForKotlinEnum.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l extends i {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f57932d = {n0.u(new PropertyReference1Impl(n0.d(l.class), "functions", "getFunctions()Ljava/util/List;"))};
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f57933b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f57934c;

    /* compiled from: StaticScopeForKotlinEnum.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<List<? extends u0>> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        public final List<? extends u0> invoke() {
            List<? extends u0> M;
            M = CollectionsKt__CollectionsKt.M(kotlin.reflect.jvm.internal.impl.resolve.c.d(l.this.f57933b), kotlin.reflect.jvm.internal.impl.resolve.c.e(l.this.f57933b));
            return M;
        }
    }

    public l(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d containingClass) {
        f0.p(storageManager, "storageManager");
        f0.p(containingClass, "containingClass");
        this.f57933b = containingClass;
        containingClass.i();
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.f57934c = storageManager.g(new a());
    }

    private final List<u0> m() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f57934c, this, f57932d[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.f h(kotlin.reflect.jvm.internal.impl.name.f fVar, k2.b bVar) {
        return (kotlin.reflect.jvm.internal.impl.descriptors.f) j(fVar, bVar);
    }

    @Nullable
    public Void j(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    /* renamed from: k */
    public List<u0> f(@NotNull d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        return m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    /* renamed from: l */
    public kotlin.reflect.jvm.internal.impl.utils.e<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        List<u0> m4 = m();
        kotlin.reflect.jvm.internal.impl.utils.e<u0> eVar = new kotlin.reflect.jvm.internal.impl.utils.e<>();
        for (Object obj : m4) {
            if (f0.g(((u0) obj).getName(), name)) {
                eVar.add(obj);
            }
        }
        return eVar;
    }
}
