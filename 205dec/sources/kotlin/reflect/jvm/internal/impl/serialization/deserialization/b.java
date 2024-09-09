package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.x;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnnotationAndConstantLoader.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface b<A, C> {
    @NotNull
    List<A> a(@NotNull x xVar, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n nVar, @NotNull AnnotatedCallableKind annotatedCallableKind, int i4, @NotNull ProtoBuf.ValueParameter valueParameter);

    @NotNull
    List<A> b(@NotNull x.a aVar);

    @NotNull
    List<A> c(@NotNull ProtoBuf.Type type, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar);

    @NotNull
    List<A> d(@NotNull x xVar, @NotNull ProtoBuf.EnumEntry enumEntry);

    @NotNull
    List<A> e(@NotNull x xVar, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n nVar, @NotNull AnnotatedCallableKind annotatedCallableKind);

    @NotNull
    List<A> f(@NotNull ProtoBuf.TypeParameter typeParameter, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar);

    @Nullable
    C g(@NotNull x xVar, @NotNull ProtoBuf.Property property, @NotNull e0 e0Var);

    @NotNull
    List<A> h(@NotNull x xVar, @NotNull ProtoBuf.Property property);

    @NotNull
    List<A> i(@NotNull x xVar, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n nVar, @NotNull AnnotatedCallableKind annotatedCallableKind);

    @NotNull
    List<A> j(@NotNull x xVar, @NotNull ProtoBuf.Property property);
}
