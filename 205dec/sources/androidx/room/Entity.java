package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public @interface Entity {
    ForeignKey[] foreignKeys() default {};

    String[] ignoredColumns() default {};

    Index[] indices() default {};

    boolean inheritSuperIndices() default false;

    String[] primaryKeys() default {};

    String tableName() default "";
}