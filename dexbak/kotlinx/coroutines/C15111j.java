package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.debug.internal.C14762e;
import kotlinx.coroutines.internal.Scopes;
import kotlinx.coroutines.internal.ThreadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p649u1.C16231a;
import p649u1.Undispatched;

/* compiled from: Builders.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001aQ\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a]\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u000e*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001aW\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001aH\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e*\u00020\u00142)\b\b\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086Jø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018\"\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018\"\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/e2;", "e", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;Lkotlinx/coroutines/CoroutineStart;Ll1/p;)Lkotlinx/coroutines/e2;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/x0;", "a", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;Lkotlinx/coroutines/CoroutineStart;Ll1/p;)Lkotlinx/coroutines/x0;", "g", "(Lkotlin/coroutines/f;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/l0;", "c", "(Lkotlinx/coroutines/l0;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "I", "UNDECIDED", "b", C14762e.f42256c, "RESUMED", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/BuildersKt")
/* renamed from: kotlinx.coroutines.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C15111j {

    /* renamed from: a */
    private static final int f43136a = 0;

    /* renamed from: b */
    private static final int f43137b = 1;

    /* renamed from: c */
    private static final int f43138c = 2;

    @NotNull
    /* renamed from: a */
    public static final <T> Deferred<T> m4131a(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p) {
        C15257y0 c15257y0;
        CoroutineContext m4086d = C15117k0.m4086d(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            c15257y0 = new C15144n2(m4086d, interfaceC15284p);
        } else {
            c15257y0 = new C15257y0(m4086d, true);
        }
        ((AbstractCoroutine) c15257y0).m5758q1(coroutineStart, c15257y0, interfaceC15284p);
        return c15257y0;
    }

    /* renamed from: b */
    public static /* synthetic */ Deferred m4130b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, InterfaceC15284p interfaceC15284p, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return C15057h.m4453a(coroutineScope, coroutineContext, coroutineStart, interfaceC15284p);
    }

    @Nullable
    /* renamed from: c */
    public static final <T> Object m4129c(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return C15057h.m4445i(coroutineDispatcher, interfaceC15284p, interfaceC14268c);
    }

    @Nullable
    /* renamed from: d */
    private static final Object m4128d(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull InterfaceC15284p interfaceC15284p, @NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(0);
        Object m4445i = C15057h.m4445i(coroutineDispatcher, interfaceC15284p, interfaceC14268c);
        InlineMarker.m8227e(1);
        return m4445i;
    }

    @NotNull
    /* renamed from: e */
    public static final Job m4127e(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        AbstractCoroutine c14778e3;
        CoroutineContext m4086d = C15117k0.m4086d(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            c14778e3 = new C15151o2(m4086d, interfaceC15284p);
        } else {
            c14778e3 = new C14778e3(m4086d, true);
        }
        c14778e3.m5758q1(coroutineStart, c14778e3, interfaceC15284p);
        return c14778e3;
    }

    /* renamed from: f */
    public static /* synthetic */ Job m4126f(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, InterfaceC15284p interfaceC15284p, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return C15057h.m4449e(coroutineScope, coroutineContext, coroutineStart, interfaceC15284p);
    }

    @Nullable
    /* renamed from: g */
    public static final <T> Object m4125g(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        Object m5723t1;
        Object m8642h;
        CoroutineContext context = interfaceC14268c.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        Yield.m3531a(plus);
        if (plus == context) {
            Scopes scopes = new Scopes(plus, interfaceC14268c);
            m5723t1 = Undispatched.m220f(scopes, scopes, interfaceC15284p);
        } else {
            ContinuationInterceptor.C14270b c14270b = ContinuationInterceptor.f41024k0;
            if (C14342f0.m8193g((ContinuationInterceptor) plus.get(c14270b), (ContinuationInterceptor) context.get(c14270b))) {
                C15228t3 c15228t3 = new C15228t3(plus, interfaceC14268c);
                Object m4253c = ThreadContext.m4253c(plus, null);
                try {
                    Object m220f = Undispatched.m220f(c15228t3, c15228t3, interfaceC15284p);
                    ThreadContext.m4255a(plus, m4253c);
                    m5723t1 = m220f;
                } catch (Throwable th) {
                    ThreadContext.m4255a(plus, m4253c);
                    throw th;
                }
            } else {
                C14628b1 c14628b1 = new C14628b1(plus, interfaceC14268c);
                c14628b1.m5759m1();
                C16231a.m226e(interfaceC15284p, c14628b1, c14628b1, null, 4, null);
                m5723t1 = c14628b1.m5723t1();
            }
        }
        m8642h = C14287b.m8642h();
        if (m5723t1 == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m5723t1;
    }
}
