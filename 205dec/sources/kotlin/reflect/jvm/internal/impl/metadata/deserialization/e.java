package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProtoBufUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T a(@NotNull GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @NotNull GeneratedMessageLite.f<M, T> extension) {
        f0.p(extendableMessage, "<this>");
        f0.p(extension, "extension");
        if (extendableMessage.hasExtension(extension)) {
            return (T) extendableMessage.getExtension(extension);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T b(@NotNull GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @NotNull GeneratedMessageLite.f<M, List<T>> extension, int i4) {
        f0.p(extendableMessage, "<this>");
        f0.p(extension, "extension");
        if (i4 < extendableMessage.getExtensionCount(extension)) {
            return (T) extendableMessage.getExtension(extension, i4);
        }
        return null;
    }
}
