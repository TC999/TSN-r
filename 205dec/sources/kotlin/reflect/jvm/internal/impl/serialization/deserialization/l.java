package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeserializedArrayValue.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l extends kotlin.reflect.jvm.internal.impl.resolve.constants.b {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final e0 f58147c;

    /* compiled from: DeserializedArrayValue.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<d0, e0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e0 f58148a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e0 e0Var) {
            super(1);
            this.f58148a = e0Var;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final e0 invoke(@NotNull d0 it) {
            f0.p(it, "it");
            return this.f58148a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> value, @NotNull e0 type) {
        super(value, new a(type));
        f0.p(value, "value");
        f0.p(type, "type");
        this.f58147c = type;
    }

    @NotNull
    public final e0 getType() {
        return this.f58147c;
    }
}
