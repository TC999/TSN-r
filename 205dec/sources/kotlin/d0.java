package kotlin;

import kotlin.Result;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Result.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0004H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\f\u001aE\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\b*\u00028\u00002\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e\u00a2\u0006\u0002\b\u000fH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a`\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\r*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u0017\u0010\u0011\u001a5\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\r*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0018\u001a\u00028\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a\u0089\u0001\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001ab\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b \u0010\u0011\u001aU\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\u0011\u001af\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\r*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\"\u0010\u0011\u001aY\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\r*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b#\u0010\u0011\u001a\\\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00020\u00050\u000eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b%\u0010\u0011\u001a\\\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042!\u0010$\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00050\u000eH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b&\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006'"}, d2 = {"", "exception", "", "a", "Lkotlin/Result;", "Lkotlin/f1;", "n", "(Ljava/lang/Object;)V", "R", "Lkotlin/Function0;", "block", "l", "(Ld2/a;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "m", "(Ljava/lang/Object;Ld2/l;)Ljava/lang/Object;", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/ParameterName;", "name", "onFailure", "d", "defaultValue", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "value", "onSuccess", "b", "(Ljava/lang/Object;Ld2/l;Ld2/l;)Ljava/lang/Object;", "transform", "f", "g", "j", "k", "action", "h", "i", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d0 {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Object a(@NotNull Throwable exception) {
        kotlin.jvm.internal.f0.p(exception, "exception");
        return new Result.Failure(exception);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> R b(Object obj, d2.l<? super T, ? extends R> onSuccess, d2.l<? super Throwable, ? extends R> onFailure) {
        kotlin.jvm.internal.f0.p(onSuccess, "onSuccess");
        kotlin.jvm.internal.f0.p(onFailure, "onFailure");
        Throwable m122exceptionOrNullimpl = Result.m122exceptionOrNullimpl(obj);
        if (m122exceptionOrNullimpl == null) {
            return onSuccess.invoke(obj);
        }
        return onFailure.invoke(m122exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R c(Object obj, R r3) {
        return Result.m125isFailureimpl(obj) ? r3 : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R d(Object obj, d2.l<? super Throwable, ? extends R> onFailure) {
        kotlin.jvm.internal.f0.p(onFailure, "onFailure");
        Throwable m122exceptionOrNullimpl = Result.m122exceptionOrNullimpl(obj);
        return m122exceptionOrNullimpl == null ? obj : onFailure.invoke(m122exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> T e(Object obj) {
        n(obj);
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object f(Object obj, d2.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(transform, "transform");
        if (Result.m126isSuccessimpl(obj)) {
            Result.a aVar = Result.Companion;
            return Result.m119constructorimpl(transform.invoke(obj));
        }
        return Result.m119constructorimpl(obj);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object g(Object obj, d2.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(transform, "transform");
        if (Result.m126isSuccessimpl(obj)) {
            try {
                Result.a aVar = Result.Companion;
                return Result.m119constructorimpl(transform.invoke(obj));
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                return Result.m119constructorimpl(a(th));
            }
        }
        return Result.m119constructorimpl(obj);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object h(Object obj, d2.l<? super Throwable, f1> action) {
        kotlin.jvm.internal.f0.p(action, "action");
        Throwable m122exceptionOrNullimpl = Result.m122exceptionOrNullimpl(obj);
        if (m122exceptionOrNullimpl != null) {
            action.invoke(m122exceptionOrNullimpl);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object i(Object obj, d2.l<? super T, f1> action) {
        kotlin.jvm.internal.f0.p(action, "action");
        if (Result.m126isSuccessimpl(obj)) {
            action.invoke(obj);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object j(Object obj, d2.l<? super Throwable, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(transform, "transform");
        Throwable m122exceptionOrNullimpl = Result.m122exceptionOrNullimpl(obj);
        if (m122exceptionOrNullimpl == null) {
            return obj;
        }
        Result.a aVar = Result.Companion;
        return Result.m119constructorimpl(transform.invoke(m122exceptionOrNullimpl));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object k(Object obj, d2.l<? super Throwable, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(transform, "transform");
        Throwable m122exceptionOrNullimpl = Result.m122exceptionOrNullimpl(obj);
        if (m122exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            Result.a aVar = Result.Companion;
            return Result.m119constructorimpl(transform.invoke(m122exceptionOrNullimpl));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            return Result.m119constructorimpl(a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R> Object l(d2.a<? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        try {
            Result.a aVar = Result.Companion;
            return Result.m119constructorimpl(block.invoke());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            return Result.m119constructorimpl(a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T, R> Object m(T t3, d2.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        try {
            Result.a aVar = Result.Companion;
            return Result.m119constructorimpl(block.invoke(t3));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            return Result.m119constructorimpl(a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void n(@NotNull Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
