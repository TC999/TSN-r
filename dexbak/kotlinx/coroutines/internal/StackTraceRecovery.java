package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayDeque;
import kotlin.C14294d0;
import kotlin.C14372l0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Tuples;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000`\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u001a!\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a.\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0080\b¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0007\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0014\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a3\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00170\u0016\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a3\u0010\u001c\u001a\u00020\u001b2\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00172\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0000H\u0080Hø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\"\u0010!\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b!\u0010\u0004\u001a!\u0010\"\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\"\u0010\u0004\u001a\u001e\u0010#\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00102\n\u0010\u0007\u001a\u00060\nj\u0002`\u000bH\u0002\u001a\u0014\u0010&\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010%\u001a\u00020$H\u0007\u001a\u0010\u0010(\u001a\u00020'*\u00060\u0011j\u0002`\u0012H\u0000\u001a%\u0010+\u001a\u00020**\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00172\u0006\u0010)\u001a\u00020$H\u0002¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010-\u001a\u00020'*\u00060\u0011j\u0002`\u00122\n\u0010\u0018\u001a\u00060\u0011j\u0002`\u0012H\u0002\u001a\u0014\u0010.\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0000\"\u0014\u00101\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100\"\u0014\u00103\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00100\"\u001c\u00106\u001a\n 4*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00100\"\u001c\u00107\u001a\n 4*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u00100*\f\b\u0000\u00108\"\u00020\n2\u00020\n*\f\b\u0000\u00109\"\u00020\u00112\u00020\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, m12616d2 = {"", ExifInterface.LONGITUDE_EAST, "exception", "p", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "r", "Lkotlin/coroutines/c;", "continuation", CampaignEx.JSON_KEY_AD_Q, "(Ljava/lang/Throwable;Lkotlin/coroutines/c;)Ljava/lang/Throwable;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "o", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/c;)Ljava/lang/Throwable;", "cause", CommonNetImpl.RESULT, "Ljava/util/ArrayDeque;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "resultStackTrace", "f", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "Lkotlin/Pair;", "", "e", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "recoveredStacktrace", "Lkotlin/f1;", C7304t.f25048d, "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "", "m", "(Ljava/lang/Throwable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "s", UMCommonContent.f37782aL, "g", "", "message", "d", "", "k", "methodName", "", "i", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "h", "j", "a", "Ljava/lang/String;", "baseContinuationImplClass", "b", "stackTraceRecoveryClass", "kotlin.jvm.PlatformType", "c", "baseContinuationImplClassName", "stackTraceRecoveryClassName", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.i0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class StackTraceRecovery {

    /* renamed from: a */
    private static final String f43047a = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";

    /* renamed from: b */
    private static final String f43048b = "kotlinx.coroutines.internal.StackTraceRecoveryKt";

    /* renamed from: c */
    private static final String f43049c;

    /* renamed from: d */
    private static final String f43050d;

    static {
        Object m60148constructorimpl;
        Object m60148constructorimpl2;
        try {
            Result.C14124a c14124a = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(Class.forName(f43047a).getCanonicalName());
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th));
        }
        if (Result.m60151exceptionOrNullimpl(m60148constructorimpl) != null) {
            m60148constructorimpl = f43047a;
        }
        f43049c = (String) m60148constructorimpl;
        try {
            Result.C14124a c14124a3 = Result.Companion;
            m60148constructorimpl2 = Result.m60148constructorimpl(StackTraceRecovery.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.C14124a c14124a4 = Result.Companion;
            m60148constructorimpl2 = Result.m60148constructorimpl(C14294d0.m8609a(th2));
        }
        if (Result.m60151exceptionOrNullimpl(m60148constructorimpl2) != null) {
            m60148constructorimpl2 = f43048b;
        }
        f43050d = (String) m60148constructorimpl2;
    }

    /* renamed from: a */
    public static /* synthetic */ void m4331a() {
    }

    /* renamed from: b */
    public static /* synthetic */ void m4330b() {
    }

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: d */
    public static final StackTraceElement m4328d(@NotNull String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    /* renamed from: e */
    private static final <E extends Throwable> Tuples<E, StackTraceElement[]> m4327e(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause != null && C14342f0.m8193g(cause.getClass(), e.getClass())) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (m4321k(stackTrace[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return C14372l0.m7952a(cause, stackTrace);
            }
            return C14372l0.m7952a(e, new StackTraceElement[0]);
        }
        return C14372l0.m7952a(e, new StackTraceElement[0]);
    }

    /* renamed from: f */
    private static final <E extends Throwable> E m4326f(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(m4328d("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int m4323i = m4323i(stackTrace, f43049c);
        int i = 0;
        if (m4323i == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e2.setStackTrace((StackTraceElement[]) array);
                return e2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + m4323i];
        for (int i2 = 0; i2 < m4323i; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        for (StackTraceElement stackTraceElement : arrayDeque) {
            stackTraceElementArr[m4323i + i] = stackTraceElement;
            i++;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    /* renamed from: g */
    private static final ArrayDeque<StackTraceElement> m4325g(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    /* renamed from: h */
    private static final boolean m4324h(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && C14342f0.m8193g(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && C14342f0.m8193g(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && C14342f0.m8193g(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    /* renamed from: i */
    private static final int m4323i(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (C14342f0.m8193g(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: j */
    public static final void m4322j(@NotNull Throwable th, @NotNull Throwable th2) {
        th.initCause(th2);
    }

    /* renamed from: k */
    public static final boolean m4321k(@NotNull StackTraceElement stackTraceElement) {
        boolean m6548u2;
        m6548u2 = StringsJVM.m6548u2(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
        return m6548u2;
    }

    /* renamed from: l */
    private static final void m4320l(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (m4321k(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i2) {
            return;
        }
        while (true) {
            if (m4324h(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            }
            length2--;
        }
    }

    @Nullable
    /* renamed from: m */
    public static final Object m4319m(@NotNull Throwable th, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        throw th;
    }

    @Nullable
    /* renamed from: n */
    private static final Object m4318n(@NotNull Throwable th, @NotNull InterfaceC14268c interfaceC14268c) {
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static final <E extends Throwable> E m4317o(E e, CoroutineStackFrame coroutineStackFrame) {
        Tuples m4327e = m4327e(e);
        Throwable th = (Throwable) m4327e.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) m4327e.component2();
        Throwable m4391f = ExceptionsConstuctor.m4391f(th);
        if (m4391f == null || (!C14342f0.m8193g(m4391f.getMessage(), th.getMessage()))) {
            return e;
        }
        ArrayDeque<StackTraceElement> m4325g = m4325g(coroutineStackFrame);
        if (m4325g.isEmpty()) {
            return e;
        }
        if (th != e) {
            m4320l(stackTraceElementArr, m4325g);
        }
        return (E) m4326f(th, m4391f, m4325g);
    }

    @NotNull
    /* renamed from: p */
    public static final <E extends Throwable> E m4316p(@NotNull E e) {
        return e;
    }

    @NotNull
    /* renamed from: q */
    public static final <E extends Throwable> E m4315q(@NotNull E e, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        return e;
    }

    /* renamed from: r */
    private static final <E extends Throwable> E m4314r(E e) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int m4323i = m4323i(stackTrace, f43050d);
        int i = m4323i + 1;
        int m4323i2 = m4323i(stackTrace, f43049c);
        int i2 = (length - m4323i) - (m4323i2 == -1 ? 0 : length - m4323i2);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stackTraceElement = m4328d("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i + i3) - 1];
            }
            stackTraceElementArr[i3] = stackTraceElement;
        }
        e.setStackTrace(stackTraceElementArr);
        return e;
    }

    @NotNull
    /* renamed from: s */
    public static final <E extends Throwable> E m4313s(@NotNull E e) {
        return e;
    }

    @NotNull
    /* renamed from: t */
    public static final <E extends Throwable> E m4312t(@NotNull E e) {
        E e2 = (E) e.getCause();
        if (e2 != null) {
            boolean z = true;
            if (!(!C14342f0.m8193g(e2.getClass(), e.getClass()))) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else if (m4321k(stackTrace[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return e2;
                }
            }
        }
        return e;
    }
}
