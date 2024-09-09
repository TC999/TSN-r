package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface d {

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static boolean a(@NotNull d dVar) {
            f0.p(dVar, "this");
            return dVar.k().getIncludeAnnotationArguments();
        }

        public static boolean b(@NotNull d dVar) {
            f0.p(dVar, "this");
            return dVar.k().getIncludeEmptyAnnotationArguments();
        }
    }

    void a(boolean z3);

    void b(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy);

    void c(boolean z3);

    boolean d();

    void e(boolean z3);

    void f(boolean z3);

    void g(@NotNull RenderingFormat renderingFormat);

    void h(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy);

    @NotNull
    Set<kotlin.reflect.jvm.internal.impl.name.c> i();

    boolean j();

    @NotNull
    AnnotationArgumentsRenderingPolicy k();

    void l(@NotNull Set<kotlin.reflect.jvm.internal.impl.name.c> set);

    void m(@NotNull Set<? extends DescriptorRendererModifier> set);

    void n(boolean z3);

    void o(@NotNull kotlin.reflect.jvm.internal.impl.renderer.a aVar);

    void p(boolean z3);

    void q(boolean z3);

    void r(boolean z3);
}
