package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedPackageFragmentImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class o extends n {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a f58151h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f f58152i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d f58153j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final w f58154k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private ProtoBuf.PackageFragment f58155l;

    /* renamed from: m  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.h f58156m;

    /* compiled from: DeserializedPackageFragmentImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.b, v0> {
        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final v0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.b it) {
            f0.p(it, "it");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVar = o.this.f58152i;
            if (fVar == null) {
                v0 NO_SOURCE = v0.f56634a;
                f0.o(NO_SOURCE, "NO_SOURCE");
                return NO_SOURCE;
            }
            return fVar;
        }
    }

    /* compiled from: DeserializedPackageFragmentImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.impl.name.f>> {
        b() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Collection<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
            int Z;
            Collection<kotlin.reflect.jvm.internal.impl.name.b> b4 = o.this.C0().b();
            ArrayList<kotlin.reflect.jvm.internal.impl.name.b> arrayList = new ArrayList();
            for (Object obj : b4) {
                kotlin.reflect.jvm.internal.impl.name.b bVar = (kotlin.reflect.jvm.internal.impl.name.b) obj;
                if ((bVar.l() || g.f58107c.a().contains(bVar)) ? false : true) {
                    arrayList.add(obj);
                }
            }
            Z = kotlin.collections.y.Z(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(Z);
            for (kotlin.reflect.jvm.internal.impl.name.b bVar2 : arrayList) {
                arrayList2.add(bVar2.j());
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull d0 module, @NotNull ProtoBuf.PackageFragment proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVar) {
        super(fqName, storageManager, module);
        f0.p(fqName, "fqName");
        f0.p(storageManager, "storageManager");
        f0.p(module, "module");
        f0.p(proto, "proto");
        f0.p(metadataVersion, "metadataVersion");
        this.f58151h = metadataVersion;
        this.f58152i = fVar;
        ProtoBuf.StringTable strings = proto.getStrings();
        f0.o(strings, "proto.strings");
        ProtoBuf.QualifiedNameTable qualifiedNames = proto.getQualifiedNames();
        f0.o(qualifiedNames, "proto.qualifiedNames");
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.d(strings, qualifiedNames);
        this.f58153j = dVar;
        this.f58154k = new w(proto, dVar, metadataVersion, new a());
        this.f58155l = proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.n
    public void G0(@NotNull i components) {
        f0.p(components, "components");
        ProtoBuf.PackageFragment packageFragment = this.f58155l;
        if (packageFragment != null) {
            this.f58155l = null;
            ProtoBuf.Package r4 = packageFragment.getPackage();
            f0.o(r4, "proto.`package`");
            this.f58156m = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h(this, r4, this.f58153j, this.f58151h, this.f58152i, components, f0.C("scope of ", this), new b());
            return;
        }
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.n
    @NotNull
    /* renamed from: I0 */
    public w C0() {
        return this.f58154k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h p() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = this.f58156m;
        if (hVar == null) {
            f0.S("_memberScope");
            return null;
        }
        return hVar;
    }
}
