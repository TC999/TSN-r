package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DebugMetadata.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0001\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0002\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u001b\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f*\u00020\u0000H\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Ljava/lang/StackTraceElement;", "e", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "b", "", "c", "expected", "actual", "Lkotlin/f1;", "a", "", "", "d", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "I", "COROUTINES_DEBUG_METADATA_VERSION", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int f55512a = 1;

    private static final void a(int i4, int i5) {
        if (i5 <= i4) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i4 + ", got " + i5 + ". Please update the Kotlin standard library.").toString());
    }

    private static final DebugMetadata b(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num == null ? 0 : num.intValue()) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getSpilledVariableFieldMapping")
    @Nullable
    public static final String[] d(@NotNull BaseContinuationImpl baseContinuationImpl) {
        f0.p(baseContinuationImpl, "<this>");
        DebugMetadata b4 = b(baseContinuationImpl);
        if (b4 == null) {
            return null;
        }
        a(1, b4.v());
        ArrayList arrayList = new ArrayList();
        int c4 = c(baseContinuationImpl);
        int[] i4 = b4.i();
        int length = i4.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            if (i4[i5] == c4) {
                arrayList.add(b4.s()[i5]);
                arrayList.add(b4.n()[i5]);
            }
            i5 = i6;
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getStackTraceElement")
    @Nullable
    public static final StackTraceElement e(@NotNull BaseContinuationImpl baseContinuationImpl) {
        String b4;
        String str;
        f0.p(baseContinuationImpl, "<this>");
        DebugMetadata b5 = b(baseContinuationImpl);
        if (b5 == null) {
            return null;
        }
        a(1, b5.v());
        int c4 = c(baseContinuationImpl);
        int i4 = c4 < 0 ? -1 : b5.l()[c4];
        if (f.f55513a.b(baseContinuationImpl) == null) {
            str = b5.c();
        } else {
            str = ((Object) b4) + '/' + b5.c();
        }
        return new StackTraceElement(str, b5.m(), b5.f(), i4);
    }
}
