package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@Retention(RetentionPolicy.CLASS)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public @interface Update {
    Class<?> entity() default Object.class;

    @OnConflictStrategy
    int onConflict() default 3;
}
