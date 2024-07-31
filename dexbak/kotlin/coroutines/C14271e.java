package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.Standard;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: Continuation.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b\u001a?\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001a\u00020\t2\u001a\b\u0004\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00020\u00030\u000bH\u0087\bø\u0001\u0000ø\u0001\u0001\u001aF\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a_\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a@\u0010\u0019\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aY\u0010\u001b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001aB\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\u00030\u000bH\u0087Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u001e\u0010\u001f\"\u001b\u0010$\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006%"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/c;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "f", "(Lkotlin/coroutines/c;Ljava/lang/Object;)V", "", "exception", "g", "Lkotlin/coroutines/f;", "context", "Lkotlin/Function1;", "Lkotlin/Result;", "resumeWith", "a", "", "completion", "b", "(Ll1/l;Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "c", "(Ll1/p;Ljava/lang/Object;Lkotlin/coroutines/c;)Lkotlin/coroutines/c;", "h", "(Ll1/l;Lkotlin/coroutines/c;)V", "i", "(Ll1/p;Ljava/lang/Object;Lkotlin/coroutines/c;)V", "block", "j", "(Ll1/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "()Lkotlin/coroutines/f;", "getCoroutineContext$annotations", "()V", "coroutineContext", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14271e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Continuation.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J \u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m12616d2 = {"kotlin/coroutines/e$a", "Lkotlin/coroutines/c;", "Lkotlin/Result;", CommonNetImpl.RESULT, "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.e$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14272a<T> implements InterfaceC14268c<T> {

        /* renamed from: a */
        final /* synthetic */ CoroutineContext f41026a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l f41027b;

        public C14272a(CoroutineContext coroutineContext, InterfaceC15280l interfaceC15280l) {
            this.f41026a = coroutineContext;
            this.f41027b = interfaceC15280l;
        }

        @Override // kotlin.coroutines.InterfaceC14268c
        @NotNull
        public CoroutineContext getContext() {
            return this.f41026a;
        }

        @Override // kotlin.coroutines.InterfaceC14268c
        public void resumeWith(@NotNull Object obj) {
            this.f41027b.invoke(Result.m60147boximpl(obj));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: a */
    private static final <T> InterfaceC14268c<T> m8673a(CoroutineContext coroutineContext, InterfaceC15280l<? super Result<? extends T>, Unit> interfaceC15280l) {
        return new C14272a(coroutineContext, interfaceC15280l);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: b */
    public static final <T> InterfaceC14268c<Unit> m8672b(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> createCoroutine, @NotNull InterfaceC14268c<? super T> completion) {
        InterfaceC14268c m8652b;
        InterfaceC14268c m8650d;
        Object m8642h;
        C14342f0.m8184p(createCoroutine, "$this$createCoroutine");
        C14342f0.m8184p(completion, "completion");
        m8652b = IntrinsicsJvm.m8652b(createCoroutine, completion);
        m8650d = IntrinsicsJvm.m8650d(m8652b);
        m8642h = C14287b.m8642h();
        return new SafeContinuationJvm(m8650d, m8642h);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: c */
    public static final <R, T> InterfaceC14268c<Unit> m8671c(@NotNull InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> createCoroutine, R r, @NotNull InterfaceC14268c<? super T> completion) {
        InterfaceC14268c m8651c;
        InterfaceC14268c m8650d;
        Object m8642h;
        C14342f0.m8184p(createCoroutine, "$this$createCoroutine");
        C14342f0.m8184p(completion, "completion");
        m8651c = IntrinsicsJvm.m8651c(createCoroutine, r, completion);
        m8650d = IntrinsicsJvm.m8650d(m8651c);
        m8642h = C14287b.m8642h();
        return new SafeContinuationJvm(m8650d, m8642h);
    }

    /* renamed from: d */
    private static final CoroutineContext m8670d() {
        throw new Standard("Implemented as intrinsic");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: e */
    public static /* synthetic */ void m8669e() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: f */
    private static final <T> void m8668f(InterfaceC14268c<? super T> interfaceC14268c, T t) {
        Result.C14124a c14124a = Result.Companion;
        interfaceC14268c.resumeWith(Result.m60148constructorimpl(t));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: g */
    private static final <T> void m8667g(InterfaceC14268c<? super T> interfaceC14268c, Throwable th) {
        Result.C14124a c14124a = Result.Companion;
        interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: h */
    public static final <T> void m8666h(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> startCoroutine, @NotNull InterfaceC14268c<? super T> completion) {
        InterfaceC14268c m8652b;
        InterfaceC14268c m8650d;
        C14342f0.m8184p(startCoroutine, "$this$startCoroutine");
        C14342f0.m8184p(completion, "completion");
        m8652b = IntrinsicsJvm.m8652b(startCoroutine, completion);
        m8650d = IntrinsicsJvm.m8650d(m8652b);
        Unit unit = Unit.f41048a;
        Result.C14124a c14124a = Result.Companion;
        m8650d.resumeWith(Result.m60148constructorimpl(unit));
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: i */
    public static final <R, T> void m8665i(@NotNull InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> startCoroutine, R r, @NotNull InterfaceC14268c<? super T> completion) {
        InterfaceC14268c m8651c;
        InterfaceC14268c m8650d;
        C14342f0.m8184p(startCoroutine, "$this$startCoroutine");
        C14342f0.m8184p(completion, "completion");
        m8651c = IntrinsicsJvm.m8651c(startCoroutine, r, completion);
        m8650d = IntrinsicsJvm.m8650d(m8651c);
        Unit unit = Unit.f41048a;
        Result.C14124a c14124a = Result.Companion;
        m8650d.resumeWith(Result.m60148constructorimpl(unit));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: j */
    private static final <T> Object m8664j(InterfaceC15280l<? super InterfaceC14268c<? super T>, Unit> interfaceC15280l, InterfaceC14268c<? super T> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        InlineMarker.m8227e(0);
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        SafeContinuationJvm safeContinuationJvm = new SafeContinuationJvm(m8650d);
        interfaceC15280l.invoke(safeContinuationJvm);
        Object m8655b = safeContinuationJvm.m8655b();
        m8642h = C14287b.m8642h();
        if (m8655b == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        InlineMarker.m8227e(1);
        return m8655b;
    }
}
