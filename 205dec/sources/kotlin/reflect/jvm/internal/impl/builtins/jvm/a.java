package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.x;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: CloneableClassScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a extends kotlin.reflect.jvm.internal.impl.resolve.scopes.e {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final C1124a f56155e = new C1124a(null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.f f56156f;

    /* compiled from: CloneableClassScope.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1124a {
        private C1124a() {
        }

        public /* synthetic */ C1124a(u uVar) {
            this();
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.f a() {
            return a.f56156f;
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f("clone");
        f0.o(f4, "identifier(\"clone\")");
        f56156f = f4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d containingClass) {
        super(storageManager, containingClass);
        f0.p(storageManager, "storageManager");
        f0.p(containingClass, "containingClass");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.e
    @NotNull
    protected List<w> j() {
        List<? extends a1> F;
        List<d1> F2;
        List<w> l4;
        g0 g12 = g0.g1(m(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), f56156f, CallableMemberDescriptor.Kind.DECLARATION, v0.f56634a);
        s0 E0 = m().E0();
        F = CollectionsKt__CollectionsKt.F();
        F2 = CollectionsKt__CollectionsKt.F();
        g12.M0(null, E0, F, F2, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(m()).i(), Modality.OPEN, r.f56529c);
        l4 = x.l(g12);
        return l4;
    }
}
