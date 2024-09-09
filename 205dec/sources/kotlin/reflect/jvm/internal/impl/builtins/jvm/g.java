package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.InputStream;
import java.util.List;
import k2.c;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.t;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.reflect.jvm.internal.impl.types.checker.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JvmBuiltInsPackageFragmentProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.a {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final a f56215f = new a(null);

    /* compiled from: JvmBuiltInsPackageFragmentProvider.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.n finder, @NotNull d0 moduleDescriptor, @NotNull f0 notFoundClasses, @NotNull h2.a additionalClassPartsProvider, @NotNull h2.c platformDependentDeclarationFilter, @NotNull j deserializationConfiguration, @NotNull l kotlinTypeChecker, @NotNull p2.a samConversionResolver) {
        super(storageManager, finder, moduleDescriptor);
        List M;
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        kotlin.jvm.internal.f0.p(finder, "finder");
        kotlin.jvm.internal.f0.p(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.f0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.f0.p(additionalClassPartsProvider, "additionalClassPartsProvider");
        kotlin.jvm.internal.f0.p(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.f0.p(deserializationConfiguration, "deserializationConfiguration");
        kotlin.jvm.internal.f0.p(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.f0.p(samConversionResolver, "samConversionResolver");
        m mVar = new m(this);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a aVar = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.f57975n;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.c cVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.c(moduleDescriptor, notFoundClasses, aVar);
        t.a aVar2 = t.a.f58165a;
        p DO_NOTHING = p.f58159a;
        kotlin.jvm.internal.f0.o(DO_NOTHING, "DO_NOTHING");
        c.a aVar3 = c.a.f55236a;
        q.a aVar4 = q.a.f58160a;
        M = CollectionsKt__CollectionsKt.M(new kotlin.reflect.jvm.internal.impl.builtins.functions.a(storageManager, moduleDescriptor), new e(storageManager, moduleDescriptor, null, 4, null));
        i(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.i(storageManager, moduleDescriptor, deserializationConfiguration, mVar, cVar, this, aVar2, DO_NOTHING, aVar3, aVar4, M, notFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.deserialization.h.f58114a.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, aVar.e(), kotlinTypeChecker, samConversionResolver, null, 262144, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.a
    @Nullable
    protected kotlin.reflect.jvm.internal.impl.serialization.deserialization.n d(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        InputStream a4 = f().a(fqName);
        if (a4 == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.c.f57977o.a(fqName, h(), g(), a4, false);
    }
}
