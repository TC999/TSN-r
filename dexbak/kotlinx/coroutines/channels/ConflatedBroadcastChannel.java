package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.channel.C13675a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections._Arrays;
import kotlin.collections._ArraysJvm;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.InterfaceC15196e;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p649u1.Undispatched;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 3*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004*-EFB\u0007¢\u0006\u0004\bC\u00106B\u0011\b\u0016\u0012\u0006\u00107\u001a\u00028\u0000¢\u0006\u0004\bC\u0010DJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\b2\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014JX\u0010\u001d\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00162\u0006\u0010\u0011\u001a\u00028\u00002(\u0010\u001c\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b#\u0010$J)\u0010(\u001a\u00020\u00052\u0018\u0010'\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00050%j\u0002`&H\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b*\u0010$J\u001f\u0010-\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,H\u0016¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102R\u0017\u00107\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b5\u00106\u001a\u0004\b3\u00104R\u0013\u00109\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b8\u00104R\u0014\u0010<\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010;R&\u0010B\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, m12616d2 = {"Lkotlinx/coroutines/channels/u;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/j;", "Lkotlinx/coroutines/channels/u$d;", "subscriber", "Lkotlin/f1;", "f", "(Lkotlinx/coroutines/channels/u$d;)V", "", "list", "e", "([Lkotlinx/coroutines/channels/u$d;Lkotlinx/coroutines/channels/u$d;)[Lkotlinx/coroutines/channels/u$d;", "m", "", "cause", "j", "(Ljava/lang/Throwable;)V", "element", "Lkotlinx/coroutines/channels/u$a;", "k", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/u$a;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/coroutines/c;", "", "block", C7304t.f25048d, "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ll1/p;)V", "Lkotlinx/coroutines/channels/d0;", "v", "()Lkotlinx/coroutines/channels/d0;", "", "L", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "C", "(Ll1/l;)V", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "(Ljava/util/concurrent/CancellationException;)V", "P", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "offer", "(Ljava/lang/Object;)Z", "g", "()Ljava/lang/Object;", "getValue$annotations", "()V", DomainCampaignEx.LOOPBACK_VALUE, "i", "valueOrNull", "Q", "()Z", "isClosedForSend", CampaignEx.JSON_KEY_AD_Q, "isFull", "Lkotlinx/coroutines/selects/e;", "s", "()Lkotlinx/coroutines/selects/e;", "onSend", "<init>", "(Ljava/lang/Object;)V", "c", "d", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
@ExperimentalCoroutinesApi
/* renamed from: kotlinx.coroutines.channels.u */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater f42144a;

    /* renamed from: b */
    private static final AtomicIntegerFieldUpdater f42145b;

    /* renamed from: c */
    private static final AtomicReferenceFieldUpdater f42146c;

    /* renamed from: e */
    private static final Symbol f42148e;

    /* renamed from: f */
    private static final C14734c<Object> f42149f;
    private volatile Object _state;
    private volatile int _updating;
    private volatile Object onCloseHandler;

    /* renamed from: g */
    private static final C14733b f42150g = new C14733b(null);

    /* renamed from: d */
    private static final C14732a f42147d = new C14732a(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/channels/u$a;", "", "", "a", "Ljava/lang/Throwable;", "closeCause", "()Ljava/lang/Throwable;", "sendException", "b", "valueException", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.u$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14732a {
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: a */
        public final Throwable f42151a;

        public C14732a(@Nullable Throwable th) {
            this.f42151a = th;
        }

        @NotNull
        /* renamed from: a */
        public final Throwable m5186a() {
            Throwable th = this.f42151a;
            return th != null ? th : new ClosedSendChannelException(C14729r.f42137a);
        }

        @NotNull
        /* renamed from: b */
        public final Throwable m5185b() {
            Throwable th = this.f42151a;
            return th != null ? th : new IllegalStateException(C14729r.f42137a);
        }
    }

    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/channels/u$b;", "", "Lkotlinx/coroutines/channels/u$a;", "CLOSED", "Lkotlinx/coroutines/channels/u$a;", "Lkotlinx/coroutines/channels/u$c;", "INITIAL_STATE", "Lkotlinx/coroutines/channels/u$c;", "Lkotlinx/coroutines/internal/j0;", "UNDEFINED", "Lkotlinx/coroutines/internal/j0;", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.u$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C14733b {
        private C14733b() {
        }

        public /* synthetic */ C14733b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B'\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/channels/u$c;", ExifInterface.LONGITUDE_EAST, "", "a", "Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "", "Lkotlinx/coroutines/channels/u$d;", "b", "[Lkotlinx/coroutines/channels/u$d;", "subscribers", "<init>", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/u$d;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.u$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14734c<E> {
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: a */
        public final Object f42152a;
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: b */
        public final C14735d<E>[] f42153b;

        public C14734c(@Nullable Object obj, @Nullable C14735d<E>[] c14735dArr) {
            this.f42152a = obj;
            this.f42153b = c14735dArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m12616d2 = {"Lkotlinx/coroutines/channels/u$d;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/v;", "Lkotlinx/coroutines/channels/d0;", "", "wasClosed", "Lkotlin/f1;", "c0", "element", "", "y", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/u;", "f", "Lkotlinx/coroutines/channels/u;", "broadcastChannel", "<init>", "(Lkotlinx/coroutines/channels/u;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.u$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14735d<E> extends ConflatedChannel<E> implements InterfaceC14695d0<E> {

        /* renamed from: f */
        private final ConflatedBroadcastChannel<E> f42154f;

        public C14735d(@NotNull ConflatedBroadcastChannel<E> conflatedBroadcastChannel) {
            super(null);
            this.f42154f = conflatedBroadcastChannel;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractChannel
        /* renamed from: c0 */
        public void mo5183c0(boolean z) {
            if (z) {
                this.f42154f.m5195f(this);
            }
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractC14687c
        @NotNull
        /* renamed from: y */
        public Object mo5170y(E e) {
            return super.mo5170y(e);
        }
    }

    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JX\u0010\f\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0006\u001a\u00028\u00002(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m12616d2 = {"kotlinx/coroutines/channels/u$e", "Lkotlinx/coroutines/selects/e;", "Lkotlinx/coroutines/channels/h0;", "R", "Lkotlinx/coroutines/selects/f;", "select", "param", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "d", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.u$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14736e implements InterfaceC15196e<E, InterfaceC14704h0<? super E>> {
        C14736e() {
        }

        @Override // kotlinx.coroutines.selects.InterfaceC15196e
        /* renamed from: d */
        public <R> void mo3631d(@NotNull InterfaceC15197f<? super R> interfaceC15197f, E e, @NotNull InterfaceC15284p<? super InterfaceC14704h0<? super E>, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
            ConflatedBroadcastChannel.this.m5189l(interfaceC15197f, e, interfaceC15284p);
        }
    }

    static {
        Symbol symbol = new Symbol("UNDEFINED");
        f42148e = symbol;
        f42149f = new C14734c<>(symbol, null);
        f42144a = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "_state");
        f42145b = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "_updating");
        f42146c = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "onCloseHandler");
    }

    public ConflatedBroadcastChannel() {
        this._state = f42149f;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    /* renamed from: e */
    private final C14735d<E>[] m5196e(C14735d<E>[] c14735dArr, C14735d<E> c14735d) {
        Object[] m11668T2;
        if (c14735dArr != null) {
            m11668T2 = _ArraysJvm.m11668T2(c14735dArr, c14735d);
            return (C14735d[]) m11668T2;
        }
        C14735d<E>[] c14735dArr2 = new C14735d[1];
        for (int i = 0; i < 1; i++) {
            c14735dArr2[i] = c14735d;
        }
        return c14735dArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public final void m5195f(C14735d<E> c14735d) {
        Object obj;
        Object obj2;
        C14735d<E>[] c14735dArr;
        do {
            obj = this._state;
            if (obj instanceof C14732a) {
                return;
            }
            if (!(obj instanceof C14734c)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
            obj2 = ((C14734c) obj).f42152a;
            if (obj != null) {
                c14735dArr = ((C14734c) obj).f42153b;
                C14342f0.m8187m(c14735dArr);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
            }
        } while (!C13675a.m12692a(f42144a, this, obj, new C14734c(obj2, m5188m(c14735dArr, c14735d))));
    }

    /* renamed from: h */
    public static /* synthetic */ void m5193h() {
    }

    /* renamed from: j */
    private final void m5191j(Throwable th) {
        Symbol symbol;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (symbol = C14685b.f42056i) || !C13675a.m12692a(f42146c, this, obj, symbol)) {
            return;
        }
        ((InterfaceC15280l) TypeIntrinsics.m8010q(obj, 1)).invoke(th);
    }

    /* renamed from: k */
    private final C14732a m5190k(E e) {
        Object obj;
        if (f42145b.compareAndSet(this, 0, 1)) {
            do {
                try {
                    obj = this._state;
                    if (obj instanceof C14732a) {
                        return (C14732a) obj;
                    }
                    if (!(obj instanceof C14734c)) {
                        throw new IllegalStateException(("Invalid state " + obj).toString());
                    } else if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                    }
                } finally {
                    this._updating = 0;
                }
            } while (!C13675a.m12692a(f42144a, this, obj, new C14734c(e, ((C14734c) obj).f42153b)));
            C14735d<E>[] c14735dArr = ((C14734c) obj).f42153b;
            if (c14735dArr != null) {
                for (C14735d<E> c14735d : c14735dArr) {
                    c14735d.mo5170y(e);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public final <R> void m5189l(InterfaceC15197f<? super R> interfaceC15197f, E e, InterfaceC15284p<? super InterfaceC14704h0<? super E>, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        if (interfaceC15197f.mo3703o()) {
            C14732a m5190k = m5190k(e);
            if (m5190k != null) {
                interfaceC15197f.mo3701t(m5190k.m5186a());
            } else {
                Undispatched.m222d(interfaceC15284p, this, interfaceC15197f.mo3702s());
            }
        }
    }

    /* renamed from: m */
    private final C14735d<E>[] m5188m(C14735d<E>[] c14735dArr, C14735d<E> c14735d) {
        int m10469ff;
        int length = c14735dArr.length;
        m10469ff = _Arrays.m10469ff(c14735dArr, c14735d);
        if (length == 1) {
            return null;
        }
        C14735d<E>[] c14735dArr2 = new C14735d[length - 1];
        _ArraysJvm.m11580l1(c14735dArr, c14735dArr2, 0, 0, m10469ff, 6, null);
        _ArraysJvm.m11580l1(c14735dArr, c14735dArr2, m10469ff, m10469ff + 1, 0, 8, null);
        return c14735dArr2;
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: C */
    public void mo5200C(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f42146c;
        if (!C13675a.m12692a(atomicReferenceFieldUpdater, this, null, interfaceC15280l)) {
            Object obj = this.onCloseHandler;
            if (obj == C14685b.f42056i) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Object obj2 = this._state;
        if ((obj2 instanceof C14732a) && C13675a.m12692a(atomicReferenceFieldUpdater, this, interfaceC15280l, C14685b.f42056i)) {
            interfaceC15280l.invoke(((C14732a) obj2).f42151a);
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: L */
    public boolean mo3828a(@Nullable Throwable th) {
        Object obj;
        int i;
        do {
            obj = this._state;
            if (obj instanceof C14732a) {
                return false;
            }
            if (!(obj instanceof C14734c)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!C13675a.m12692a(f42144a, this, obj, th == null ? f42147d : new C14732a(th)));
        if (obj != null) {
            C14735d<E>[] c14735dArr = ((C14734c) obj).f42153b;
            if (c14735dArr != null) {
                for (C14735d<E> c14735d : c14735dArr) {
                    c14735d.mo5178L(th);
                }
            }
            m5191j(th);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    @Nullable
    /* renamed from: P */
    public Object mo5177P(E e, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        C14732a m5190k = m5190k(e);
        if (m5190k == null) {
            m8642h = C14287b.m8642h();
            return m5190k == m8642h ? m5190k : Unit.f41048a;
        }
        throw m5190k.m5186a();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: Q */
    public boolean mo5199Q() {
        return this._state instanceof C14732a;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: b */
    public void mo3827b(@Nullable CancellationException cancellationException) {
        mo3828a(cancellationException);
    }

    /* renamed from: g */
    public final E m5194g() {
        Object obj = this._state;
        if (!(obj instanceof C14732a)) {
            if (obj instanceof C14734c) {
                E e = (E) ((C14734c) obj).f42152a;
                if (e != f42148e) {
                    return e;
                }
                throw new IllegalStateException("No value");
            }
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
        throw ((C14732a) obj).m5185b();
    }

    @Nullable
    /* renamed from: i */
    public final E m5192i() {
        Object obj = this._state;
        if (obj instanceof C14732a) {
            return null;
        }
        if (!(obj instanceof C14734c)) {
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
        Symbol symbol = f42148e;
        E e = (E) ((C14734c) obj).f42152a;
        if (e == symbol) {
            return null;
        }
        return e;
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    public boolean offer(E e) {
        C14732a m5190k = m5190k(e);
        if (m5190k == null) {
            return true;
        }
        throw m5190k.m5186a();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: q */
    public boolean mo5187q() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    @NotNull
    /* renamed from: s */
    public InterfaceC15196e<E, InterfaceC14704h0<E>> mo5176s() {
        return new C14736e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @NotNull
    /* renamed from: v */
    public InterfaceC14695d0<E> mo5175v() {
        Object obj;
        Object obj2;
        C14735d c14735d = new C14735d(this);
        do {
            obj = this._state;
            if (obj instanceof C14732a) {
                c14735d.mo5178L(((C14732a) obj).f42151a);
                return c14735d;
            } else if (obj instanceof C14734c) {
                C14734c c14734c = (C14734c) obj;
                Object obj3 = c14734c.f42152a;
                if (obj3 != f42148e) {
                    c14735d.mo5170y(obj3);
                }
                obj2 = c14734c.f42152a;
                if (obj != null) {
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                }
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!C13675a.m12692a(f42144a, this, obj, new C14734c(obj2, m5196e(((C14734c) obj).f42153b, c14735d))));
        return c14735d;
    }

    public ConflatedBroadcastChannel(E e) {
        this();
        f42144a.lazySet(this, new C14734c(e, null));
    }
}
