package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@TypeQualifierNickname
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Untainted(when = When.ALWAYS)
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public @interface Detainted {
}
