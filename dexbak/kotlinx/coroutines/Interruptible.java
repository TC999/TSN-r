package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u001a1\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\f\"\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\f\"\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/f;", "context", "Lkotlin/Function0;", "block", "b", "(Lkotlin/coroutines/f;Ll1/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "coroutineContext", "d", "(Lkotlin/coroutines/f;Ll1/a;)Ljava/lang/Object;", "", "a", "I", "WORKING", "FINISHED", "c", "INTERRUPTING", "INTERRUPTED", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.a2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Interruptible {

    /* renamed from: a */
    private static final int f41688a = 0;

    /* renamed from: b */
    private static final int f41689b = 1;

    /* renamed from: c */
    private static final int f41690c = 2;

    /* renamed from: d */
    private static final int f41691d = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Interruptible.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", m8638f = "Interruptible.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: kotlinx.coroutines.a2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14617a<T> extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super T>, Object> {

        /* renamed from: a */
        private CoroutineScope f41692a;

        /* renamed from: b */
        int f41693b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15269a f41694c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14617a(InterfaceC15269a interfaceC15269a, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f41694c = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14617a c14617a = new C14617a(this.f41694c, interfaceC14268c);
            c14617a.f41692a = (CoroutineScope) obj;
            return c14617a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(CoroutineScope coroutineScope, Object obj) {
            return ((C14617a) create(coroutineScope, (InterfaceC14268c) obj)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f41693b == 0) {
                C14294d0.m8596n(obj);
                return Interruptible.m5744d(this.f41692a.getCoroutineContext(), this.f41694c);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    /* renamed from: b */
    public static final <T> Object m5746b(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC15269a<? extends T> interfaceC15269a, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return C15057h.m4445i(coroutineContext, new C14617a(interfaceC15269a, null), interfaceC14268c);
    }

    /* renamed from: c */
    public static /* synthetic */ Object m5745c(CoroutineContext coroutineContext, InterfaceC15269a interfaceC15269a, InterfaceC14268c interfaceC14268c, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return m5746b(coroutineContext, interfaceC15269a, interfaceC14268c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static final <T> T m5744d(CoroutineContext coroutineContext, InterfaceC15269a<? extends T> interfaceC15269a) {
        try {
            C15145n3 c15145n3 = new C15145n3(C15060h2.m4441C(coroutineContext));
            c15145n3.m3946d();
            T invoke = interfaceC15269a.invoke();
            c15145n3.m3949a();
            return invoke;
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }
}
