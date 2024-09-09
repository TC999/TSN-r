package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.x;
import kotlin.reflect.jvm.internal.impl.storage.m;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JvmBuiltIns.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class JvmBuiltIns extends kotlin.reflect.jvm.internal.impl.builtins.h {

    /* renamed from: l  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56143l = {n0.u(new PropertyReference1Impl(n0.d(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final Kind f56144i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private d2.a<a> f56145j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56146k;

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final d0 f56147a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f56148b;

        public a(@NotNull d0 ownerModuleDescriptor, boolean z3) {
            f0.p(ownerModuleDescriptor, "ownerModuleDescriptor");
            this.f56147a = ownerModuleDescriptor;
            this.f56148b = z3;
        }

        @NotNull
        public final d0 a() {
            return this.f56147a;
        }

        public final boolean b() {
            return this.f56148b;
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56149a;

        static {
            int[] iArr = new int[Kind.values().length];
            iArr[Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[Kind.FALLBACK.ordinal()] = 3;
            f56149a = iArr;
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<f> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.storage.n f56151b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: JvmBuiltIns.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends Lambda implements d2.a<a> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JvmBuiltIns f56152a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(JvmBuiltIns jvmBuiltIns) {
                super(0);
                this.f56152a = jvmBuiltIns;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final a invoke() {
                d2.a aVar = this.f56152a.f56145j;
                if (aVar != null) {
                    a aVar2 = (a) aVar.invoke();
                    this.f56152a.f56145j = null;
                    return aVar2;
                }
                throw new AssertionError("JvmBuiltins instance has not been initialized properly");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.jvm.internal.impl.storage.n nVar) {
            super(0);
            this.f56151b = nVar;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final f invoke() {
            x builtInsModule = JvmBuiltIns.this.r();
            f0.o(builtInsModule, "builtInsModule");
            return new f(builtInsModule, this.f56151b, new a(JvmBuiltIns.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends Lambda implements d2.a<a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d0 f56153a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f56154b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(d0 d0Var, boolean z3) {
            super(0);
            this.f56153a = d0Var;
            this.f56154b = z3;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final a invoke() {
            return new a(this.f56153a, this.f56154b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull Kind kind) {
        super(storageManager);
        f0.p(storageManager, "storageManager");
        f0.p(kind, "kind");
        this.f56144i = kind;
        this.f56146k = storageManager.g(new c(storageManager));
        int i4 = b.f56149a[kind.ordinal()];
        if (i4 == 2) {
            f(false);
        } else if (i4 != 3) {
        } else {
            f(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.h
    @NotNull
    /* renamed from: F0 */
    public List<h2.b> v() {
        List<h2.b> l4;
        Iterable<h2.b> v3 = super.v();
        f0.o(v3, "super.getClassDescriptorFactories()");
        kotlin.reflect.jvm.internal.impl.storage.n storageManager = U();
        f0.o(storageManager, "storageManager");
        x builtInsModule = r();
        f0.o(builtInsModule, "builtInsModule");
        l4 = kotlin.collections.f0.l4(v3, new e(storageManager, builtInsModule, null, 4, null));
        return l4;
    }

    @NotNull
    public final f G0() {
        return (f) m.a(this.f56146k, this, f56143l[0]);
    }

    public final void H0(@NotNull d0 moduleDescriptor, boolean z3) {
        f0.p(moduleDescriptor, "moduleDescriptor");
        I0(new d(moduleDescriptor, z3));
    }

    public final void I0(@NotNull d2.a<a> computation) {
        f0.p(computation, "computation");
        this.f56145j = computation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.h
    @NotNull
    protected h2.c M() {
        return G0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.h
    @NotNull
    protected h2.a g() {
        return G0();
    }
}
