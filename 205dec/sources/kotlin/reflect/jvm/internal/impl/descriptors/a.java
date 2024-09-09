package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CallableDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface a extends l, o, x0<a> {

    /* compiled from: CallableDescriptor.java */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface InterfaceC1126a<V> {
    }

    @Nullable
    s0 M();

    @Nullable
    s0 Q();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    a a();

    @NotNull
    Collection<? extends a> d();

    boolean e0();

    @Nullable
    kotlin.reflect.jvm.internal.impl.types.e0 getReturnType();

    @NotNull
    List<a1> getTypeParameters();

    @NotNull
    List<d1> h();

    @Nullable
    <V> V s0(InterfaceC1126a<V> interfaceC1126a);
}
