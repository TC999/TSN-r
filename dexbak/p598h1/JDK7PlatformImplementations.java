package p598h1;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections._ArraysJvm;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, m12616d2 = {"Lh1/a;", "Lkotlin/internal/a;", "", "cause", "exception", "Lkotlin/f1;", "a", "", "d", "<init>", "()V", "kotlin-stdlib-jdk7"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: h1.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class JDK7PlatformImplementations extends PlatformImplementations {
    @Override // kotlin.internal.PlatformImplementations
    /* renamed from: a */
    public void mo8538a(@NotNull Throwable cause, @NotNull Throwable exception) {
        C14342f0.m8184p(cause, "cause");
        C14342f0.m8184p(exception, "exception");
    }

    @Override // kotlin.internal.PlatformImplementations
    @NotNull
    /* renamed from: d */
    public List<Throwable> mo8535d(@NotNull Throwable exception) {
        List<Throwable> m11537t;
        C14342f0.m8184p(exception, "exception");
        Throwable[] thArr = new Throwable[0];
        C14342f0.m8185o(thArr, "exception.suppressed");
        m11537t = _ArraysJvm.m11537t(thArr);
        return m11537t;
    }
}
