package androidx.room;

import androidx.annotation.RestrictTo;
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
public @interface Database {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    Class<?>[] autoMigrations() default {};

    Class<?>[] entities();

    boolean exportSchema() default true;

    int version();

    Class<?>[] views() default {};
}
