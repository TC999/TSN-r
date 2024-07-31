package kotlin.coroutines.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DebugMetadata.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0002\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u001b\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f*\u00020\u0000H\u0001¢\u0006\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010¨\u0006\u0012"}, m12616d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Ljava/lang/StackTraceElement;", "e", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "b", "", "c", "expected", "actual", "Lkotlin/f1;", "a", "", "", "d", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "I", "COROUTINES_DEBUG_METADATA_VERSION", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.jvm.internal.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14289d {

    /* renamed from: a */
    private static final int f41033a = 1;

    /* renamed from: a */
    private static final void m8623a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    /* renamed from: b */
    private static final DebugMetadata m8622b(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    /* renamed from: c */
    private static final int m8621c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field field = baseContinuationImpl.getClass().getDeclaredField(TTDownloadField.TT_LABEL);
            C14342f0.m8185o(field, "field");
            field.setAccessible(true);
            Object obj = field.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getSpilledVariableFieldMapping")
    @Nullable
    /* renamed from: d */
    public static final String[] m8620d(@NotNull BaseContinuationImpl getSpilledVariableFieldMapping) {
        C14342f0.m8184p(getSpilledVariableFieldMapping, "$this$getSpilledVariableFieldMapping");
        DebugMetadata m8622b = m8622b(getSpilledVariableFieldMapping);
        if (m8622b != null) {
            m8623a(1, m8622b.m8632v());
            ArrayList arrayList = new ArrayList();
            int m8621c = m8621c(getSpilledVariableFieldMapping);
            int[] m8637i = m8622b.m8637i();
            int length = m8637i.length;
            for (int i = 0; i < length; i++) {
                if (m8637i[i] == m8621c) {
                    arrayList.add(m8622b.m8633s()[i]);
                    arrayList.add(m8622b.m8634n()[i]);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getStackTraceElement")
    @Nullable
    /* renamed from: e */
    public static final StackTraceElement m8619e(@NotNull BaseContinuationImpl getStackTraceElementImpl) {
        String str;
        C14342f0.m8184p(getStackTraceElementImpl, "$this$getStackTraceElementImpl");
        DebugMetadata m8622b = m8622b(getStackTraceElementImpl);
        if (m8622b != null) {
            m8623a(1, m8622b.m8632v());
            int m8621c = m8621c(getStackTraceElementImpl);
            int i = m8621c < 0 ? -1 : m8622b.m8636l()[m8621c];
            String m8614b = C14290f.f41036c.m8614b(getStackTraceElementImpl);
            if (m8614b == null) {
                str = m8622b.m8639c();
            } else {
                str = m8614b + '/' + m8622b.m8639c();
            }
            return new StackTraceElement(str, m8622b.m8635m(), m8622b.m8638f(), i);
        }
        return null;
    }
}
