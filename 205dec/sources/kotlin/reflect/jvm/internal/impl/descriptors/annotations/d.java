package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnnotationDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final e0 f56232a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f56233b;

    /* renamed from: c  reason: collision with root package name */
    private final v0 f56234c;

    public d(@NotNull e0 e0Var, @NotNull Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> map, @NotNull v0 v0Var) {
        if (e0Var == null) {
            b(0);
        }
        if (map == null) {
            b(1);
        }
        if (v0Var == null) {
            b(2);
        }
        this.f56232a = e0Var;
        this.f56233b = map;
        this.f56234c = v0Var;
    }

    private static /* synthetic */ void b(int i4) {
        String str = (i4 == 3 || i4 == 4 || i4 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 3 || i4 == 4 || i4 == 5) ? 2 : 3];
        if (i4 == 1) {
            objArr[0] = "valueArguments";
        } else if (i4 == 2) {
            objArr[0] = "source";
        } else if (i4 == 3 || i4 == 4 || i4 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i4 == 3) {
            objArr[1] = "getType";
        } else if (i4 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i4 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i4 != 3 && i4 != 4 && i4 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i4 != 3 && i4 != 4 && i4 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> map = this.f56233b;
        if (map == null) {
            b(4);
        }
        return map;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.c e() {
        return c.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public v0 getSource() {
        v0 v0Var = this.f56234c;
        if (v0Var == null) {
            b(5);
        }
        return v0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public e0 getType() {
        e0 e0Var = this.f56232a;
        if (e0Var == null) {
            b(3);
        }
        return e0Var;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.b.f57729g.t(this, null);
    }
}
