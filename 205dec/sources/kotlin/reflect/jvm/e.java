package kotlin.reflect.jvm;

import d2.p;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.k;
import kotlin.reflect.h;
import kotlin.reflect.i;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;
import kotlin.reflect.jvm.internal.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: reflectLambda.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u00a8\u0006\u0004"}, d2 = {"R", "Lkotlin/k;", "Lkotlin/reflect/i;", "a", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: reflectLambda.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a extends FunctionReference implements p<u, ProtoBuf.Function, u0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f55858a = new a();

        a() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: d */
        public final u0 invoke(@NotNull u p02, @NotNull ProtoBuf.Function p12) {
            f0.p(p02, "p0");
            f0.p(p12, "p1");
            return p02.j(p12);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "loadFunction";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final h getOwner() {
            return n0.d(u.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }
    }

    @ExperimentalReflectionOnLambdas
    @Nullable
    public static final <R> i<R> a(@NotNull k<? extends R> kVar) {
        f0.p(kVar, "<this>");
        Metadata metadata = (Metadata) kVar.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        String[] d12 = metadata.d1();
        if (d12.length == 0) {
            d12 = null;
        }
        if (d12 == null) {
            return null;
        }
        Pair<f, ProtoBuf.Function> j4 = g.j(d12, metadata.d2());
        f component1 = j4.component1();
        ProtoBuf.Function component2 = j4.component2();
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e eVar = new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e(metadata.mv(), (metadata.xi() & 8) != 0);
        Class<?> cls = kVar.getClass();
        ProtoBuf.TypeTable typeTable = component2.getTypeTable();
        f0.o(typeTable, "proto.typeTable");
        return new j(kotlin.reflect.jvm.internal.b.f55876d, (u0) kotlin.reflect.jvm.internal.f0.h(cls, component2, component1, new kotlin.reflect.jvm.internal.impl.metadata.deserialization.g(typeTable), eVar, a.f55858a));
    }
}
