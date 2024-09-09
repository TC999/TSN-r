package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;

/* compiled from: PackageFragmentProvider.kt */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface h0 {
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    List<g0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    @NotNull
    Collection<kotlin.reflect.jvm.internal.impl.name.c> u(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar);
}
