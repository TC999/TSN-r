package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class f implements m2.b {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f56592b = new a(null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.f f56593a;

    /* compiled from: ReflectJavaAnnotationArguments.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final f a(@NotNull Object value, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar) {
            f0.p(value, "value");
            return d.h(value.getClass()) ? new q(fVar, (Enum) value) : value instanceof Annotation ? new g(fVar, (Annotation) value) : value instanceof Object[] ? new j(fVar, (Object[]) value) : value instanceof Class ? new m(fVar, (Class) value) : new s(fVar, value);
        }
    }

    private f(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        this.f56593a = fVar;
    }

    public /* synthetic */ f(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.jvm.internal.u uVar) {
        this(fVar);
    }

    @Override // m2.b
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        return this.f56593a;
    }
}
