package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import d2.l;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import k2.c;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.h;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.i0;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.t;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BuiltInsLoaderImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b implements kotlin.reflect.jvm.internal.impl.builtins.a {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d f57976b = new d();

    /* compiled from: BuiltInsLoaderImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    /* synthetic */ class a extends FunctionReference implements l<String, InputStream> {
        a(Object obj) {
            super(1, obj);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: d */
        public final InputStream invoke(@NotNull String p02) {
            f0.p(p02, "p0");
            return ((d) this.receiver).a(p02);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "loadResource";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final h getOwner() {
            return n0.d(d.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.a
    @NotNull
    public h0 a(@NotNull n storageManager, @NotNull d0 builtInsModule, @NotNull Iterable<? extends h2.b> classDescriptorFactories, @NotNull h2.c platformDependentDeclarationFilter, @NotNull h2.a additionalClassPartsProvider, boolean z3) {
        f0.p(storageManager, "storageManager");
        f0.p(builtInsModule, "builtInsModule");
        f0.p(classDescriptorFactories, "classDescriptorFactories");
        f0.p(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        f0.p(additionalClassPartsProvider, "additionalClassPartsProvider");
        return b(storageManager, builtInsModule, j.f56089r, classDescriptorFactories, platformDependentDeclarationFilter, additionalClassPartsProvider, z3, new a(this.f57976b));
    }

    @NotNull
    public final h0 b(@NotNull n storageManager, @NotNull d0 module, @NotNull Set<kotlin.reflect.jvm.internal.impl.name.c> packageFqNames, @NotNull Iterable<? extends h2.b> classDescriptorFactories, @NotNull h2.c platformDependentDeclarationFilter, @NotNull h2.a additionalClassPartsProvider, boolean z3, @NotNull l<? super String, ? extends InputStream> loadResource) {
        int Z;
        List F;
        f0.p(storageManager, "storageManager");
        f0.p(module, "module");
        f0.p(packageFqNames, "packageFqNames");
        f0.p(classDescriptorFactories, "classDescriptorFactories");
        f0.p(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        f0.p(additionalClassPartsProvider, "additionalClassPartsProvider");
        f0.p(loadResource, "loadResource");
        Z = y.Z(packageFqNames, 10);
        ArrayList<c> arrayList = new ArrayList(Z);
        for (kotlin.reflect.jvm.internal.impl.name.c cVar : packageFqNames) {
            String n4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.f57975n.n(cVar);
            InputStream invoke = loadResource.invoke(n4);
            if (invoke != null) {
                arrayList.add(c.f57977o.a(cVar, storageManager, module, invoke, z3));
            } else {
                throw new IllegalStateException(f0.C("Resource not found in classpath: ", n4));
            }
        }
        i0 i0Var = new i0(arrayList);
        kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var = new kotlin.reflect.jvm.internal.impl.descriptors.f0(storageManager, module);
        j.a aVar = j.a.f58137a;
        m mVar = new m(i0Var);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a aVar2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.f57975n;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.c cVar2 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.c(module, f0Var, aVar2);
        t.a aVar3 = t.a.f58165a;
        p DO_NOTHING = p.f58159a;
        f0.o(DO_NOTHING, "DO_NOTHING");
        c.a aVar4 = c.a.f55236a;
        q.a aVar5 = q.a.f58160a;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.h a4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.h.f58114a.a();
        f e4 = aVar2.e();
        F = CollectionsKt__CollectionsKt.F();
        i iVar = new i(storageManager, module, aVar, mVar, cVar2, i0Var, aVar3, DO_NOTHING, aVar4, aVar5, classDescriptorFactories, f0Var, a4, additionalClassPartsProvider, platformDependentDeclarationFilter, e4, null, new p2.b(storageManager, F), null, 327680, null);
        for (c cVar3 : arrayList) {
            cVar3.G0(iVar);
        }
        return i0Var;
    }
}
