package androidx.room;

import androidx.annotation.RequiresApi;
import androidx.room.FtsOptions;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@Target({ElementType.TYPE})
@RequiresApi(16)
@Retention(RetentionPolicy.CLASS)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public @interface Fts4 {
    Class<?> contentEntity() default Object.class;

    String languageId() default "";

    FtsOptions.MatchInfo matchInfo() default FtsOptions.MatchInfo.FTS4;

    String[] notIndexed() default {};

    FtsOptions.Order order() default FtsOptions.Order.ASC;

    int[] prefix() default {};

    String tokenizer() default "simple";

    String[] tokenizerArgs() default {};
}
