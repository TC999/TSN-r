package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavaFlexibleTypeDeserializer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.q {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final h f57197a = new h();

    private h() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.q
    @NotNull
    public e0 a(@NotNull ProtoBuf.Type proto, @NotNull String flexibleId, @NotNull m0 lowerBound, @NotNull m0 upperBound) {
        f0.p(proto, "proto");
        f0.p(flexibleId, "flexibleId");
        f0.p(lowerBound, "lowerBound");
        f0.p(upperBound, "upperBound");
        if (!f0.g(flexibleId, "kotlin.jvm.PlatformType")) {
            m0 j4 = kotlin.reflect.jvm.internal.impl.types.w.j("Error java flexible type with id: " + flexibleId + ". (" + lowerBound + ".." + upperBound + ')');
            f0.o(j4, "createErrorType(\"Error j\u2026owerBound..$upperBound)\")");
            return j4;
        } else if (proto.hasExtension(JvmProtoBuf.f57493g)) {
            return new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.e(lowerBound, upperBound);
        } else {
            return kotlin.reflect.jvm.internal.impl.types.f0.d(lowerBound, upperBound);
        }
    }
}
