package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeserializedAnnotations.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull n storageManager, @NotNull d2.a<? extends List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> compute) {
        super(storageManager, compute);
        f0.p(storageManager, "storageManager");
        f0.p(compute, "compute");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f
    public boolean isEmpty() {
        return false;
    }
}
