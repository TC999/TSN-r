package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface CallableMemberDescriptor extends a, a0 {

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum Kind {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }

    void A0(@NotNull Collection<? extends CallableMemberDescriptor> collection);

    @NotNull
    CallableMemberDescriptor P(k kVar, Modality modality, s sVar, Kind kind, boolean z3);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    CallableMemberDescriptor a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    Collection<? extends CallableMemberDescriptor> d();

    @NotNull
    Kind i();
}
