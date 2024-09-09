package kotlin;

import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Preconditions.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a-\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a1\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u0000H\u0087\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001\u00a2\u0006\u0004\b\t\u0010\n\u001aB\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a-\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a1\u0010\u000f\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u0000H\u0087\b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001\u00a2\u0006\u0004\b\u000f\u0010\n\u001aB\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001\u00a2\u0006\u0004\b\u0010\u0010\f\u001a\u0011\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0005H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0014"}, d2 = {"", "value", "Lkotlin/f1;", "h", "Lkotlin/Function0;", "", "lazyMessage", "i", "T", "j", "(Ljava/lang/Object;)Ljava/lang/Object;", "k", "(Ljava/lang/Object;Ld2/a;)Ljava/lang/Object;", "c", "d", "e", "f", "message", "", "g", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/PreconditionsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class b0 extends a0 {
    @InlineOnly
    private static final void c(boolean z3) {
        if (!z3) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @InlineOnly
    private static final void d(boolean z3, d2.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.f0.p(lazyMessage, "lazyMessage");
        if (!z3) {
            throw new IllegalStateException(lazyMessage.invoke().toString());
        }
    }

    @InlineOnly
    private static final <T> T e(T t3) {
        if (t3 != null) {
            return t3;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @InlineOnly
    private static final <T> T f(T t3, d2.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.f0.p(lazyMessage, "lazyMessage");
        if (t3 != null) {
            return t3;
        }
        throw new IllegalStateException(lazyMessage.invoke().toString());
    }

    @InlineOnly
    private static final Void g(Object message) {
        kotlin.jvm.internal.f0.p(message, "message");
        throw new IllegalStateException(message.toString());
    }

    @InlineOnly
    private static final void h(boolean z3) {
        if (!z3) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @InlineOnly
    private static final void i(boolean z3, d2.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.f0.p(lazyMessage, "lazyMessage");
        if (!z3) {
            throw new IllegalArgumentException(lazyMessage.invoke().toString());
        }
    }

    @InlineOnly
    private static final <T> T j(T t3) {
        if (t3 != null) {
            return t3;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @InlineOnly
    private static final <T> T k(T t3, d2.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.f0.p(lazyMessage, "lazyMessage");
        if (t3 != null) {
            return t3;
        }
        throw new IllegalArgumentException(lazyMessage.invoke().toString());
    }
}
