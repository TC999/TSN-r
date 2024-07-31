package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.InterfaceC14686b0;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BW\u0012-\u0010\u0014\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010¢\u0006\u0002\b\u0013\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, m12616d2 = {"Lkotlinx/coroutines/flow/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/channels/b0;", Constants.PARAM_SCOPE, "Lkotlin/f1;", "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/internal/e;", "k", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Ll1/p;Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14942b<T> extends C14952f<T> {

    /* renamed from: e */
    private final InterfaceC15284p<InterfaceC14686b0<? super T>, InterfaceC14268c<? super Unit>, Object> f42673e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Builders.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0094@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/b0;", Constants.PARAM_SCOPE, "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "collectTo"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.CallbackFlowBuilder", m8638f = "Builders.kt", m8637i = {0, 0}, m8636l = {358}, m8635m = "collectTo", m8634n = {"this", Constants.PARAM_SCOPE}, m8633s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14943a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42674a;

        /* renamed from: b */
        int f42675b;

        /* renamed from: d */
        Object f42677d;

        /* renamed from: e */
        Object f42678e;

        C14943a(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42674a = obj;
            this.f42675b |= Integer.MIN_VALUE;
            return C14942b.this.mo4770j(null, this);
        }
    }

    public /* synthetic */ C14942b(InterfaceC15284p interfaceC15284p, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC15284p, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    @Override // kotlinx.coroutines.flow.C14952f, kotlinx.coroutines.flow.internal.ChannelFlow
    @org.jetbrains.annotations.Nullable
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo4770j(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.InterfaceC14686b0<? super T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.C14942b.C14943a
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.b$a r0 = (kotlinx.coroutines.flow.C14942b.C14943a) r0
            int r1 = r0.f42675b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42675b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.b$a r0 = new kotlinx.coroutines.flow.b$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f42674a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42675b
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f42678e
            kotlinx.coroutines.channels.b0 r5 = (kotlinx.coroutines.channels.InterfaceC14686b0) r5
            java.lang.Object r0 = r0.f42677d
            kotlinx.coroutines.flow.b r0 = (kotlinx.coroutines.flow.C14942b) r0
            kotlin.C14294d0.m8596n(r6)
            goto L49
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.C14294d0.m8596n(r6)
            r0.f42677d = r4
            r0.f42678e = r5
            r0.f42675b = r3
            java.lang.Object r6 = super.mo4770j(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            boolean r5 = r5.mo5199Q()
            if (r5 == 0) goto L52
            kotlin.f1 r5 = kotlin.Unit.f41048a
            return r5
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C14942b.mo4770j(kotlinx.coroutines.channels.b0, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.C14952f, kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    /* renamed from: k */
    protected ChannelFlow<T> mo4769k(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return new C14942b(this.f42673e, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14942b(@NotNull InterfaceC15284p<? super InterfaceC14686b0<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(interfaceC15284p, coroutineContext, i, bufferOverflow);
        this.f42673e = interfaceC15284p;
    }
}
