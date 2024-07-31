package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public @interface Dimension {

    /* renamed from: DP */
    public static final int f80DP = 0;

    /* renamed from: PX */
    public static final int f81PX = 1;

    /* renamed from: SP */
    public static final int f82SP = 2;

    int unit() default 1;
}
