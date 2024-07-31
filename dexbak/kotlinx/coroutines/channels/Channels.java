package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C15057h;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/h0;", "element", "Lkotlin/f1;", "a", "(Lkotlinx/coroutines/channels/h0;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/channels/ChannelsKt")
/* renamed from: kotlinx.coroutines.channels.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final /* synthetic */ class Channels {

    /* compiled from: Channels.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", m8638f = "Channels.kt", m8637i = {0}, m8636l = {25}, m8635m = "invokeSuspend", m8634n = {"$this$runBlocking"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.channels.s$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14730a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private CoroutineScope f42138a;

        /* renamed from: b */
        Object f42139b;

        /* renamed from: c */
        int f42140c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC14704h0 f42141d;

        /* renamed from: e */
        final /* synthetic */ Object f42142e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14730a(InterfaceC14704h0 interfaceC14704h0, Object obj, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42141d = interfaceC14704h0;
            this.f42142e = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14730a c14730a = new C14730a(this.f42141d, this.f42142e, interfaceC14268c);
            c14730a.f42138a = (CoroutineScope) obj;
            return c14730a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14730a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42140c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                CoroutineScope coroutineScope = this.f42138a;
                InterfaceC14704h0 interfaceC14704h0 = this.f42141d;
                Object obj2 = this.f42142e;
                this.f42139b = coroutineScope;
                this.f42140c = 1;
                if (interfaceC14704h0.mo5177P(obj2, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.f42139b;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static final <E> void m5212a(@NotNull InterfaceC14704h0<? super E> interfaceC14704h0, E e) {
        if (interfaceC14704h0.offer(e)) {
            return;
        }
        C15057h.m4446h(null, new C14730a(interfaceC14704h0, e, null), 1, null);
    }
}
