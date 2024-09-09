package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@Target({})
@Retention(RetentionPolicy.CLASS)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public @interface ForeignKey {
    public static final int CASCADE = 5;
    public static final int NO_ACTION = 1;
    public static final int RESTRICT = 2;
    public static final int SET_DEFAULT = 4;
    public static final int SET_NULL = 3;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public @interface Action {
    }

    String[] childColumns();

    boolean deferred() default false;

    Class<?> entity();

    @Action
    int onDelete() default 1;

    @Action
    int onUpdate() default 1;

    String[] parentColumns();
}
