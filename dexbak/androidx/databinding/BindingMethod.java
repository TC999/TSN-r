package androidx.databinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public @interface BindingMethod {
    String attribute();

    String method();

    Class type();
}
