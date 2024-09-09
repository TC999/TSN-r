package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.j1;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedPackageMemberScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class h extends DeserializedMemberScope {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final g0 f58085g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final String f58086h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.c f58087i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public h(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.g0 r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r18, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c r19, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a r20, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f r21, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.i r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull d2.a<? extends java.util.Collection<kotlin.reflect.jvm.internal.impl.name.f>> r24) {
        /*
            r16 = this;
            r6 = r16
            r14 = r17
            r15 = r23
            java.lang.String r0 = "packageDescriptor"
            kotlin.jvm.internal.f0.p(r14, r0)
            java.lang.String r0 = "proto"
            r1 = r18
            kotlin.jvm.internal.f0.p(r1, r0)
            java.lang.String r0 = "nameResolver"
            r2 = r19
            kotlin.jvm.internal.f0.p(r2, r0)
            java.lang.String r0 = "metadataVersion"
            r3 = r20
            kotlin.jvm.internal.f0.p(r3, r0)
            java.lang.String r0 = "components"
            r4 = r22
            kotlin.jvm.internal.f0.p(r4, r0)
            java.lang.String r0 = "debugName"
            kotlin.jvm.internal.f0.p(r15, r0)
            java.lang.String r0 = "classNames"
            r5 = r24
            kotlin.jvm.internal.f0.p(r5, r0)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.g r10 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.g
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r0 = r18.getTypeTable()
            java.lang.String r7 = "proto.typeTable"
            kotlin.jvm.internal.f0.o(r0, r7)
            r10.<init>(r0)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.h$a r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.h.f57484b
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r7 = r18.getVersionRequirementTable()
            java.lang.String r8 = "proto.versionRequirementTable"
            kotlin.jvm.internal.f0.o(r7, r8)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.h r11 = r0.a(r7)
            r7 = r22
            r8 = r17
            r9 = r19
            r12 = r20
            r13 = r21
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.k r2 = r7.a(r8, r9, r10, r11, r12, r13)
            java.util.List r3 = r18.getFunctionList()
            java.lang.String r0 = "proto.functionList"
            kotlin.jvm.internal.f0.o(r3, r0)
            java.util.List r4 = r18.getPropertyList()
            java.lang.String r0 = "proto.propertyList"
            kotlin.jvm.internal.f0.o(r4, r0)
            java.util.List r7 = r18.getTypeAliasList()
            java.lang.String r0 = "proto.typeAliasList"
            kotlin.jvm.internal.f0.o(r7, r0)
            r0 = r16
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f58085g = r14
            r6.f58086h = r15
            kotlin.reflect.jvm.internal.impl.name.c r0 = r17.e()
            r6.f58087i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.<init>(kotlin.reflect.jvm.internal.impl.descriptors.g0, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c, kotlin.reflect.jvm.internal.impl.metadata.deserialization.a, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f, kotlin.reflect.jvm.internal.impl.serialization.deserialization.i, java.lang.String, d2.a):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    /* renamed from: A */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.k> o4;
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> l4 = l(kindFilter, nameFilter, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<h2.b> k4 = r().c().k();
        ArrayList arrayList = new ArrayList();
        for (h2.b bVar : k4) {
            c0.o0(arrayList, bVar.a(this.f58087i));
        }
        o4 = kotlin.collections.f0.o4(l4, arrayList);
        return o4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        j2.a.b(r().c().o(), location, this.f58085g, name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        e(name, location);
        return super.h(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected void k(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> result, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        f0.p(result, "result");
        f0.p(nameFilter, "nameFilter");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.name.b o(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(name, "name");
        return new kotlin.reflect.jvm.internal.impl.name.b(this.f58087i, name);
    }

    @NotNull
    public String toString() {
        return this.f58086h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @Nullable
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> u() {
        Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
        k4 = j1.k();
        return k4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> v() {
        Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
        k4 = j1.k();
        return k4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> w() {
        Set<kotlin.reflect.jvm.internal.impl.name.f> k4;
        k4 = j1.k();
        return k4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public boolean y(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        boolean z3;
        f0.p(name, "name");
        if (super.y(name)) {
            return true;
        }
        Iterable<h2.b> k4 = r().c().k();
        if (!(k4 instanceof Collection) || !((Collection) k4).isEmpty()) {
            for (h2.b bVar : k4) {
                if (bVar.b(this.f58087i, name)) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        return z3;
    }
}
