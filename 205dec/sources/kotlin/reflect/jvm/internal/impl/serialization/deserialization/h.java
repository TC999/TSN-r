package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContractDeserializer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f58114a = a.f58115a;

    /* compiled from: ContractDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f58115a = new a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final h f58116b = new C1177a();

        /* compiled from: ContractDeserializer.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.h$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1177a implements h {
            C1177a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.h
            @Nullable
            public Pair a(@NotNull ProtoBuf.Function proto, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.w ownerFunction, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, @NotNull b0 typeDeserializer) {
                f0.p(proto, "proto");
                f0.p(ownerFunction, "ownerFunction");
                f0.p(typeTable, "typeTable");
                f0.p(typeDeserializer, "typeDeserializer");
                return null;
            }
        }

        private a() {
        }

        @NotNull
        public final h a() {
            return f58116b;
        }
    }

    @Nullable
    Pair<a.InterfaceC1126a<?>, Object> a(@NotNull ProtoBuf.Function function, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.w wVar, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar, @NotNull b0 b0Var);
}
