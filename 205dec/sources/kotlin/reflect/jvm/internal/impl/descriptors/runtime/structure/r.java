package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReflectJavaField.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r extends t implements m2.n {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Field f56614a;

    public r(@NotNull Field member) {
        f0.p(member, "member");
        this.f56614a = member;
    }

    @Override // m2.n
    public boolean G() {
        return S().isEnumConstant();
    }

    @Override // m2.n
    public boolean M() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.t
    @NotNull
    /* renamed from: U */
    public Field S() {
        return this.f56614a;
    }

    @Override // m2.n
    @NotNull
    public z getType() {
        z.a aVar = z.f56622a;
        Type genericType = S().getGenericType();
        f0.o(genericType, "member.genericType");
        return aVar.a(genericType);
    }
}
