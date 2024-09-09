package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.f0;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.b0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeserializedTypeParameterDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l extends kotlin.reflect.jvm.internal.impl.descriptors.impl.b {
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.k f58099k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final ProtoBuf.TypeParameter f58100l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final b f58101m;

    /* compiled from: DeserializedTypeParameterDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> G5;
            G5 = f0.G5(l.this.f58099k.c().d().f(l.this.J0(), l.this.f58099k.g()));
            return G5;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public l(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.k r12, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.f0.p(r12, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.f0.p(r13, r0)
            kotlin.reflect.jvm.internal.impl.storage.n r2 = r12.h()
            kotlin.reflect.jvm.internal.impl.descriptors.k r3 = r12.e()
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f$a r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f r4 = r0.b()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.c r0 = r12.g()
            int r1 = r13.getName()
            kotlin.reflect.jvm.internal.impl.name.f r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.v.b(r0, r1)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.y r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.f58199a
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$Variance r1 = r13.getVariance()
            java.lang.String r6 = "proto.variance"
            kotlin.jvm.internal.f0.o(r1, r6)
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = r0.d(r1)
            boolean r7 = r13.getReified()
            kotlin.reflect.jvm.internal.impl.descriptors.v0 r9 = kotlin.reflect.jvm.internal.impl.descriptors.v0.f56634a
            kotlin.reflect.jvm.internal.impl.descriptors.y0$a r10 = kotlin.reflect.jvm.internal.impl.descriptors.y0.a.f56639a
            r1 = r11
            r8 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.f58099k = r12
            r11.f58100l = r13
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b r13 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b
            kotlin.reflect.jvm.internal.impl.storage.n r12 = r12.h()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l$a r14 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l$a
            r14.<init>()
            r13.<init>(r12, r14)
            r11.f58101m = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter, int):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    @NotNull
    protected List<e0> G0() {
        int Z;
        List<e0> l4;
        List<ProtoBuf.Type> p3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.p(this.f58100l, this.f58099k.j());
        if (p3.isEmpty()) {
            l4 = x.l(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(this).y());
            return l4;
        }
        b0 i4 = this.f58099k.i();
        Z = y.Z(p3, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (ProtoBuf.Type type : p3) {
            arrayList.add(i4.p(type));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    /* renamed from: I0 */
    public b getAnnotations() {
        return this.f58101m;
    }

    @NotNull
    public final ProtoBuf.TypeParameter J0() {
        return this.f58100l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.e
    @NotNull
    /* renamed from: K0 */
    public Void F0(@NotNull e0 type) {
        kotlin.jvm.internal.f0.p(type, "type");
        throw new IllegalStateException(kotlin.jvm.internal.f0.C("There should be no cycles for deserialized type parameters, but found for: ", this));
    }
}
