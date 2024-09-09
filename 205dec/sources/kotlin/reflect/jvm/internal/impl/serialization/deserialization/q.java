package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: FlexibleTypeDeserializer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface q {

    /* compiled from: FlexibleTypeDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements q {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f58160a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.q
        @NotNull
        public e0 a(@NotNull ProtoBuf.Type proto, @NotNull String flexibleId, @NotNull m0 lowerBound, @NotNull m0 upperBound) {
            f0.p(proto, "proto");
            f0.p(flexibleId, "flexibleId");
            f0.p(lowerBound, "lowerBound");
            f0.p(upperBound, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    @NotNull
    e0 a(@NotNull ProtoBuf.Type type, @NotNull String str, @NotNull m0 m0Var, @NotNull m0 m0Var2);
}
