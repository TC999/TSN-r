package androidx.databinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@Target({ElementType.ANNOTATION_TYPE})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public @interface InverseBindingMethod {
    String attribute();

    String event() default "";

    String method() default "";

    Class type();
}
