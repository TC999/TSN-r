package kotlinx.coroutines.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: StackTraceRecovery.kt */
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u001a!\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004\u001a.\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0080\b\u00a2\u0006\u0004\b\b\u0010\t\u001a-\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0007\u001a\u00060\nj\u0002`\u000bH\u0002\u00a2\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0014\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u0010H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a3\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00170\u0016\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a3\u0010\u001c\u001a\u00020\u001b2\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00172\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u0010H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0000H\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 \u001a\"\u0010!\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0080\b\u00a2\u0006\u0004\b!\u0010\u0004\u001a!\u0010\"\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b\"\u0010\u0004\u001a\u001e\u0010#\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00102\n\u0010\u0007\u001a\u00060\nj\u0002`\u000bH\u0002\u001a\u0014\u0010&\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010%\u001a\u00020$H\u0007\u001a\u0010\u0010(\u001a\u00020'*\u00060\u0011j\u0002`\u0012H\u0000\u001a%\u0010+\u001a\u00020**\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00172\u0006\u0010)\u001a\u00020$H\u0002\u00a2\u0006\u0004\b+\u0010,\u001a\u001c\u0010-\u001a\u00020'*\u00060\u0011j\u0002`\u00122\n\u0010\u0018\u001a\u00060\u0011j\u0002`\u0012H\u0002\u001a\u0014\u0010.\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0000\"\u0014\u00101\u001a\u00020$8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u00100\"\u0014\u00103\u001a\u00020$8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b2\u00100\"\u001c\u00106\u001a\n 4*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00100\"\u001c\u00107\u001a\n 4*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u00100*\f\b\u0000\u00108\"\u00020\n2\u00020\n*\f\b\u0000\u00109\"\u00020\u00112\u00020\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"", "E", "exception", "p", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "r", "Lkotlin/coroutines/c;", "continuation", CampaignEx.JSON_KEY_AD_Q, "(Ljava/lang/Throwable;Lkotlin/coroutines/c;)Ljava/lang/Throwable;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "o", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/c;)Ljava/lang/Throwable;", "cause", "result", "Ljava/util/ArrayDeque;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "resultStackTrace", "f", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "Lkotlin/Pair;", "", "e", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "recoveredStacktrace", "Lkotlin/f1;", "l", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "", "m", "(Ljava/lang/Throwable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "s", "t", "g", "", "message", "d", "", "k", "methodName", "", "i", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "h", "j", "a", "Ljava/lang/String;", "baseContinuationImplClass", "b", "stackTraceRecoveryClass", "kotlin.jvm.PlatformType", "c", "baseContinuationImplClassName", "stackTraceRecoveryClassName", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f60364a = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";

    /* renamed from: b  reason: collision with root package name */
    private static final String f60365b = "kotlinx.coroutines.internal.StackTraceRecoveryKt";

    /* renamed from: c  reason: collision with root package name */
    private static final String f60366c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f60367d;

    static {
        Object m119constructorimpl;
        Object m119constructorimpl2;
        try {
            Result.a aVar = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th));
        }
        if (Result.m122exceptionOrNullimpl(m119constructorimpl) != null) {
            m119constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f60366c = (String) m119constructorimpl;
        try {
            Result.a aVar3 = Result.Companion;
            m119constructorimpl2 = Result.m119constructorimpl(i0.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar4 = Result.Companion;
            m119constructorimpl2 = Result.m119constructorimpl(kotlin.d0.a(th2));
        }
        if (Result.m122exceptionOrNullimpl(m119constructorimpl2) != null) {
            m119constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f60367d = (String) m119constructorimpl2;
    }

    public static /* synthetic */ void a() {
    }

    public static /* synthetic */ void b() {
    }

    @InternalCoroutinesApi
    @NotNull
    public static final StackTraceElement d(@NotNull String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> e(E e4) {
        boolean z3;
        Throwable cause = e4.getCause();
        if (cause != null && kotlin.jvm.internal.f0.g(cause.getClass(), e4.getClass())) {
            StackTraceElement[] stackTrace = e4.getStackTrace();
            int length = stackTrace.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z3 = false;
                    break;
                } else if (k(stackTrace[i4])) {
                    z3 = true;
                    break;
                } else {
                    i4++;
                }
            }
            if (z3) {
                return kotlin.l0.a(cause, stackTrace);
            }
            return kotlin.l0.a(e4, new StackTraceElement[0]);
        }
        return kotlin.l0.a(e4, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E f(E e4, E e5, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(d("Coroutine boundary"));
        StackTraceElement[] stackTrace = e4.getStackTrace();
        int i4 = i(stackTrace, f60366c);
        int i5 = 0;
        if (i4 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e5.setStackTrace((StackTraceElement[]) array);
                return e5;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + i4];
        for (int i6 = 0; i6 < i4; i6++) {
            stackTraceElementArr[i6] = stackTrace[i6];
        }
        for (StackTraceElement stackTraceElement : arrayDeque) {
            stackTraceElementArr[i4 + i5] = stackTraceElement;
            i5++;
        }
        e5.setStackTrace(stackTraceElementArr);
        return e5;
    }

    private static final ArrayDeque<StackTraceElement> g(kotlin.coroutines.jvm.internal.c cVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = cVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = cVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    private static final boolean h(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kotlin.jvm.internal.f0.g(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && kotlin.jvm.internal.f0.g(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && kotlin.jvm.internal.f0.g(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int i(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (kotlin.jvm.internal.f0.g(str, stackTraceElementArr[i4].getClassName())) {
                return i4;
            }
        }
        return -1;
    }

    public static final void j(@NotNull Throwable th, @NotNull Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean k(@NotNull StackTraceElement stackTraceElement) {
        boolean u22;
        u22 = kotlin.text.w.u2(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
        return u22;
    }

    private static final void l(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                i4 = -1;
                break;
            } else if (k(stackTraceElementArr[i4])) {
                break;
            } else {
                i4++;
            }
        }
        int i5 = i4 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i5) {
            return;
        }
        while (true) {
            if (h(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i5) {
                return;
            }
            length2--;
        }
    }

    @Nullable
    public static final Object m(@NotNull Throwable th, @NotNull kotlin.coroutines.c<?> cVar) {
        throw th;
    }

    @Nullable
    private static final Object n(@NotNull Throwable th, @NotNull kotlin.coroutines.c cVar) {
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> E o(E e4, kotlin.coroutines.jvm.internal.c cVar) {
        Pair e5 = e(e4);
        Throwable th = (Throwable) e5.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) e5.component2();
        Throwable f4 = ExceptionsConstuctorKt.f(th);
        if (f4 == null || (!kotlin.jvm.internal.f0.g(f4.getMessage(), th.getMessage()))) {
            return e4;
        }
        ArrayDeque<StackTraceElement> g4 = g(cVar);
        if (g4.isEmpty()) {
            return e4;
        }
        if (th != e4) {
            l(stackTraceElementArr, g4);
        }
        return (E) f(th, f4, g4);
    }

    @NotNull
    public static final <E extends Throwable> E p(@NotNull E e4) {
        return e4;
    }

    @NotNull
    public static final <E extends Throwable> E q(@NotNull E e4, @NotNull kotlin.coroutines.c<?> cVar) {
        return e4;
    }

    private static final <E extends Throwable> E r(E e4) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e4.getStackTrace();
        int length = stackTrace.length;
        int i4 = i(stackTrace, f60367d);
        int i5 = i4 + 1;
        int i6 = i(stackTrace, f60366c);
        int i7 = (length - i4) - (i6 == -1 ? 0 : length - i6);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            if (i8 == 0) {
                stackTraceElement = d("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i5 + i8) - 1];
            }
            stackTraceElementArr[i8] = stackTraceElement;
        }
        e4.setStackTrace(stackTraceElementArr);
        return e4;
    }

    @NotNull
    public static final <E extends Throwable> E s(@NotNull E e4) {
        return e4;
    }

    @NotNull
    public static final <E extends Throwable> E t(@NotNull E e4) {
        E e5 = (E) e4.getCause();
        if (e5 != null) {
            boolean z3 = true;
            if (!(!kotlin.jvm.internal.f0.g(e5.getClass(), e4.getClass()))) {
                StackTraceElement[] stackTrace = e4.getStackTrace();
                int length = stackTrace.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        z3 = false;
                        break;
                    } else if (k(stackTrace[i4])) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z3) {
                    return e5;
                }
            }
        }
        return e4;
    }
}
