package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import org.jetbrains.annotations.NotNull;

/* compiled from: util.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/a;", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/l;", "Lkotlin/reflect/jvm/internal/f;", "Lkotlin/f1;", "Lkotlin/reflect/jvm/internal/impl/descriptors/w;", "descriptor", "data", "visitFunctionDescriptor", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/f1;)Lkotlin/reflect/jvm/internal/f;", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "visitPropertyDescriptor", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/f1;)Lkotlin/reflect/jvm/internal/f;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "a", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a extends kotlin.reflect.jvm.internal.impl.descriptors.impl.l<f<?>, f1> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final KDeclarationContainerImpl f55870a;

    public a(@NotNull KDeclarationContainerImpl container) {
        kotlin.jvm.internal.f0.p(container, "container");
        this.f55870a = container;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.l, kotlin.reflect.jvm.internal.impl.descriptors.m
    @NotNull
    /* renamed from: p */
    public f<?> i(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w descriptor, @NotNull f1 data) {
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        kotlin.jvm.internal.f0.p(data, "data");
        return new j(this.f55870a, descriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.l, kotlin.reflect.jvm.internal.impl.descriptors.m
    @NotNull
    /* renamed from: q */
    public f<?> c(@NotNull p0 descriptor, @NotNull f1 data) {
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        kotlin.jvm.internal.f0.p(data, "data");
        int i4 = (descriptor.M() == null ? 0 : 1) + (descriptor.Q() != null ? 1 : 0);
        if (descriptor.O()) {
            if (i4 == 0) {
                return new k(this.f55870a, descriptor);
            }
            if (i4 == 1) {
                return new l(this.f55870a, descriptor);
            }
            if (i4 == 2) {
                return new m(this.f55870a, descriptor);
            }
        } else if (i4 == 0) {
            return new p(this.f55870a, descriptor);
        } else {
            if (i4 == 1) {
                return new q(this.f55870a, descriptor);
            }
            if (i4 == 2) {
                return new r(this.f55870a, descriptor);
            }
        }
        throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Unsupported property: ", descriptor));
    }
}
