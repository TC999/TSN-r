package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.acse.ottn.f3;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: AnnotationUseSiteTarget.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum AnnotationUseSiteTarget {
    FIELD(null, 1, null),
    FILE(null, 1, null),
    PROPERTY(null, 1, null),
    PROPERTY_GETTER(f3.f5657f),
    PROPERTY_SETTER(f3.f5659h),
    RECEIVER(null, 1, null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");
    
    @NotNull
    private final String renderName;

    AnnotationUseSiteTarget(String str) {
        this.renderName = str == null ? s2.a.f(name()) : str;
    }

    @NotNull
    public final String getRenderName() {
        return this.renderName;
    }

    /* synthetic */ AnnotationUseSiteTarget(String str, int i4, u uVar) {
        this((i4 & 1) != 0 ? null : str);
    }
}
