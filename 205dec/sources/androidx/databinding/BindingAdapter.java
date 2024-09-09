package androidx.databinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@Target({ElementType.METHOD})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public @interface BindingAdapter {
    boolean requireAll() default true;

    String[] value();
}
