package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.o;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: BuiltInsPackageFragmentImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c extends o implements kotlin.reflect.jvm.internal.impl.builtins.b {
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public static final a f57977o = new a(null);

    /* renamed from: n  reason: collision with root package name */
    private final boolean f57978n;

    /* compiled from: BuiltInsPackageFragmentImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @NotNull
        public final c a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull n storageManager, @NotNull d0 module, @NotNull InputStream inputStream, boolean z3) {
            n2.a aVar;
            f0.p(fqName, "fqName");
            f0.p(storageManager, "storageManager");
            f0.p(module, "module");
            f0.p(inputStream, "inputStream");
            try {
                n2.a a4 = n2.a.f61495g.a(inputStream);
                if (a4 == null) {
                    f0.S("version");
                    aVar = null;
                } else {
                    aVar = a4;
                }
                if (aVar.h()) {
                    ProtoBuf.PackageFragment proto = ProtoBuf.PackageFragment.parseFrom(inputStream, kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.f57975n.e());
                    kotlin.io.b.a(inputStream, null);
                    f0.o(proto, "proto");
                    return new c(fqName, storageManager, module, proto, a4, z3, null);
                }
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + n2.a.f61496h + ", actual " + a4 + ". Please update Kotlin");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.b.a(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    private c(kotlin.reflect.jvm.internal.impl.name.c cVar, n nVar, d0 d0Var, ProtoBuf.PackageFragment packageFragment, n2.a aVar, boolean z3) {
        super(cVar, nVar, d0Var, packageFragment, aVar, null);
        this.f57978n = z3;
    }

    public /* synthetic */ c(kotlin.reflect.jvm.internal.impl.name.c cVar, n nVar, d0 d0Var, ProtoBuf.PackageFragment packageFragment, n2.a aVar, boolean z3, u uVar) {
        this(cVar, nVar, d0Var, packageFragment, aVar, z3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z, kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    @NotNull
    public String toString() {
        return "builtins package fragment for " + e() + " from " + kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(this);
    }
}
