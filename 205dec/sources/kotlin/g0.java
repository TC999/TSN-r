package kotlin;

import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Standard.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a\t\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a4\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\b\u0010\t\u001aI\u0010\r\u001a\u00028\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0005*\u00028\u00002\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u00a2\u0006\u0002\b\fH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\r\u0010\u000e\u001aM\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u000f\u001a\u00028\u00002\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u00a2\u0006\u0002\b\fH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\u0010\u0010\u000e\u001aC\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n*\u00028\u00002\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u000b\u00a2\u0006\u0002\b\fH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0012\u0010\u000e\u001a>\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n*\u00028\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u000bH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0013\u0010\u000e\u001aD\u0010\u0014\u001a\u00028\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0005*\u00028\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0014\u0010\u000e\u001a@\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n*\u00028\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u000bH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0017\u0010\u000e\u001a@\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n*\u00028\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u000bH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0018\u0010\u000e\u001a3\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00110\u000bH\u0087\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001d"}, d2 = {"", "a", "", "reason", "b", "R", "Lkotlin/Function0;", "block", "g", "(Ld2/a;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "h", "(Ljava/lang/Object;Ld2/l;)Ljava/lang/Object;", "receiver", "k", "Lkotlin/f1;", "d", "c", "e", "", "predicate", "i", "j", "", "times", "action", "f", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/StandardKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class g0 {
    @InlineOnly
    private static final Void a() {
        throw new NotImplementedError(null, 1, null);
    }

    @InlineOnly
    private static final Void b(String reason) {
        kotlin.jvm.internal.f0.p(reason, "reason");
        throw new NotImplementedError(kotlin.jvm.internal.f0.C("An operation is not implemented: ", reason));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T c(T t3, d2.l<? super T, f1> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        block.invoke(t3);
        return t3;
    }

    @InlineOnly
    private static final <T> T d(T t3, d2.l<? super T, f1> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        block.invoke(t3);
        return t3;
    }

    @InlineOnly
    private static final <T, R> R e(T t3, d2.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return block.invoke(t3);
    }

    @InlineOnly
    private static final void f(int i4, d2.l<? super Integer, f1> action) {
        kotlin.jvm.internal.f0.p(action, "action");
        for (int i5 = 0; i5 < i4; i5++) {
            action.invoke(Integer.valueOf(i5));
        }
    }

    @InlineOnly
    private static final <R> R g(d2.a<? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return block.invoke();
    }

    @InlineOnly
    private static final <T, R> R h(T t3, d2.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return block.invoke(t3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T i(T t3, d2.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if (predicate.invoke(t3).booleanValue()) {
            return t3;
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T j(T t3, d2.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if (predicate.invoke(t3).booleanValue()) {
            return null;
        }
        return t3;
    }

    @InlineOnly
    private static final <T, R> R k(T t3, d2.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return block.invoke(t3);
    }
}
