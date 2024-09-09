package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Caller.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b`\u0018\u0000*\f\b\u0000\u0010\u0002 \u0001*\u0004\u0018\u00010\u00012\u00020\u0003J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00028\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/c;", "Ljava/lang/reflect/Member;", "M", "", "", "args", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/f1;", "checkArguments", "([Ljava/lang/Object;)V", "b", "()Ljava/lang/reflect/Member;", "member", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "", "a", "()Ljava/util/List;", "parameterTypes", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface c<M extends Member> {

    /* compiled from: Caller.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        public static <M extends Member> void a(@NotNull c<? extends M> cVar, @NotNull Object[] args) {
            f0.p(cVar, "this");
            f0.p(args, "args");
            if (e.a(cVar) == args.length) {
                return;
            }
            throw new IllegalArgumentException("Callable expects " + e.a(cVar) + " arguments, but " + args.length + " were provided.");
        }
    }

    @NotNull
    List<Type> a();

    M b();

    @Nullable
    Object call(@NotNull Object[] objArr);

    @NotNull
    Type getReturnType();
}