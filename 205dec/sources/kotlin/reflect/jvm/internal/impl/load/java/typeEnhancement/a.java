package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeEnhancement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class a implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f56991a = new a();

    private a() {
    }

    private final Void b() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.c e() {
        return c.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public v0 getSource() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public e0 getType() {
        b();
        throw null;
    }

    @NotNull
    public String toString() {
        return "[EnhancedType]";
    }
}
