package z1;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.l;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JDK7PlatformImplementations.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lz1/a;", "Lkotlin/internal/a;", "", "cause", "exception", "Lkotlin/f1;", "a", "", "d", "<init>", "()V", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a extends kotlin.internal.a {
    @Override // kotlin.internal.a
    public void a(@NotNull Throwable cause, @NotNull Throwable exception) {
        f0.p(cause, "cause");
        f0.p(exception, "exception");
    }

    @Override // kotlin.internal.a
    @NotNull
    public List<Throwable> d(@NotNull Throwable exception) {
        f0.p(exception, "exception");
        Throwable[] thArr = new Throwable[0];
        f0.o(thArr, "exception.suppressed");
        return l.t(thArr);
    }
}
