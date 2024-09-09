package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaValueParameter.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b0 extends p implements m2.b0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final z f56574a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Annotation[] f56575b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f56576c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f56577d;

    public b0(@NotNull z type, @NotNull Annotation[] reflectAnnotations, @Nullable String str, boolean z3) {
        f0.p(type, "type");
        f0.p(reflectAnnotations, "reflectAnnotations");
        this.f56574a = type;
        this.f56575b = reflectAnnotations;
        this.f56576c = str;
        this.f56577d = z3;
    }

    @Override // m2.d
    public boolean B() {
        return false;
    }

    @Override // m2.d
    @Nullable
    /* renamed from: P */
    public e b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        return i.a(this.f56575b, fqName);
    }

    @Override // m2.d
    @NotNull
    /* renamed from: Q */
    public List<e> getAnnotations() {
        return i.b(this.f56575b);
    }

    @Override // m2.b0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        String str = this.f56576c;
        if (str == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.name.f.e(str);
    }

    @Override // m2.b0
    public boolean k() {
        return this.f56577d;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(b0.class.getName());
        sb.append(": ");
        sb.append(k() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }

    @Override // m2.b0
    @NotNull
    public z getType() {
        return this.f56574a;
    }
}
