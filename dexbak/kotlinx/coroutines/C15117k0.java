package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.ThreadContext;
import kotlinx.coroutines.scheduling.C15176c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* compiled from: CoroutineContext.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a6\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0080\b¢\u0006\u0004\b\u000b\u0010\f\"\u0014\u0010\u000f\u001a\u00020\r8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0001\u0010\u000e\"\u001a\u0010\u0015\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e\"\u001a\u0010\u0018\u001a\u0004\u0018\u00010\r*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0017¨\u0006\u0019"}, m12616d2 = {"Lkotlinx/coroutines/l0;", "a", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "d", ExifInterface.GPS_DIRECTION_TRUE, "", "countOrElement", "Lkotlin/Function0;", "block", "e", "(Lkotlin/coroutines/f;Ljava/lang/Object;Ll1/a;)Ljava/lang/Object;", "", "Ljava/lang/String;", "COROUTINES_SCHEDULER_PROPERTY_NAME", "", "b", "Z", "c", "()Z", "useCoroutinesScheduler", "DEBUG_THREAD_NAME_SEPARATOR", "(Lkotlin/coroutines/f;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.k0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15117k0 {
    @NotNull

    /* renamed from: a */
    public static final String f43142a = "kotlinx.coroutines.scheduler";

    /* renamed from: b */
    private static final boolean f43143b;

    /* renamed from: c */
    private static final String f43144c = " @";

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r0.equals(kotlinx.coroutines.Debug.f43400d) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
        if (r0.equals("") != false) goto L21;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.C15082l0.m4278d(r0)
            if (r0 != 0) goto L9
            goto L33
        L9:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L22
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L37
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            r0 = 0
            goto L34
        L22:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            goto L33
        L2b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
        L33:
            r0 = 1
        L34:
            kotlinx.coroutines.C15117k0.f43143b = r0
            return
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C15117k0.<clinit>():void");
    }

    @NotNull
    /* renamed from: a */
    public static final CoroutineDispatcher m4089a() {
        return f43143b ? C15176c.f43276h : CommonPool.f43444e;
    }

    @Nullable
    /* renamed from: b */
    public static final String m4088b(@NotNull CoroutineContext coroutineContext) {
        return null;
    }

    /* renamed from: c */
    public static final boolean m4087c() {
        return f43143b;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: d */
    public static final CoroutineContext m4086d(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext) {
        CoroutineContext plus = coroutineScope.getCoroutineContext().plus(coroutineContext);
        return (plus == Dispatchers.m5038a() || plus.get(ContinuationInterceptor.f41024k0) != null) ? plus : plus.plus(Dispatchers.m5038a());
    }

    /* renamed from: e */
    public static final <T> T m4085e(@NotNull CoroutineContext coroutineContext, @Nullable Object obj, @NotNull InterfaceC15269a<? extends T> interfaceC15269a) {
        Object m4253c = ThreadContext.m4253c(coroutineContext, obj);
        try {
            return interfaceC15269a.invoke();
        } finally {
            InlineMarker.m8228d(1);
            ThreadContext.m4255a(coroutineContext, m4253c);
            InlineMarker.m8229c(1);
        }
    }
}
