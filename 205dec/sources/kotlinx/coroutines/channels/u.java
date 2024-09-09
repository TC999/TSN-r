package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.t0;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ConflatedBroadcastChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u0006*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004*-EFB\u0007\u00a2\u0006\u0004\bC\u00106B\u0011\b\u0016\u0012\u0006\u00107\u001a\u00028\u0000\u00a2\u0006\u0004\bC\u0010DJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J?\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\b2\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ?\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002\u00a2\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014JX\u0010\u001d\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00162\u0006\u0010\u0011\u001a\u00028\u00002(\u0010\u001c\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0018H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016\u00a2\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b#\u0010$J)\u0010(\u001a\u00020\u00052\u0018\u0010'\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00050%j\u0002`&H\u0016\u00a2\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0017\u00a2\u0006\u0004\b*\u0010$J\u001f\u0010-\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,H\u0016\u00a2\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b1\u00102R\u0017\u00107\u001a\u00028\u00008F\u00a2\u0006\f\u0012\u0004\b5\u00106\u001a\u0004\b3\u00104R\u0013\u00109\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b8\u00104R\u0014\u0010<\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010;R&\u0010B\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190?8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010A\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006G"}, d2 = {"Lkotlinx/coroutines/channels/u;", "E", "Lkotlinx/coroutines/channels/j;", "Lkotlinx/coroutines/channels/u$d;", "subscriber", "Lkotlin/f1;", "g", "(Lkotlinx/coroutines/channels/u$d;)V", "", "list", "e", "([Lkotlinx/coroutines/channels/u$d;Lkotlinx/coroutines/channels/u$d;)[Lkotlinx/coroutines/channels/u$d;", "n", "", "cause", "k", "(Ljava/lang/Throwable;)V", "element", "Lkotlinx/coroutines/channels/u$a;", "l", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/u$a;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/coroutines/c;", "", "block", "m", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ld2/p;)V", "Lkotlinx/coroutines/channels/d0;", "t", "()Lkotlinx/coroutines/channels/d0;", "", "K", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "f", "(Ld2/l;)V", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "(Ljava/util/concurrent/CancellationException;)V", "O", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "offer", "(Ljava/lang/Object;)Z", "h", "()Ljava/lang/Object;", "getValue$annotations", "()V", "value", "j", "valueOrNull", "P", "()Z", "isClosedForSend", "p", "isFull", "Lkotlinx/coroutines/selects/e;", "r", "()Lkotlinx/coroutines/selects/e;", "onSend", "<init>", "(Ljava/lang/Object;)V", "c", "d", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@ExperimentalCoroutinesApi
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u<E> implements j<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f59489a;

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f59490b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f59491c;

    /* renamed from: e  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.j0 f59493e;

    /* renamed from: f  reason: collision with root package name */
    private static final c<Object> f59494f;
    private volatile Object _state;
    private volatile int _updating;
    private volatile Object onCloseHandler;

    /* renamed from: g  reason: collision with root package name */
    private static final b f59495g = new b(null);

    /* renamed from: d  reason: collision with root package name */
    private static final a f59492d = new a(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/channels/u$a;", "", "", "a", "Ljava/lang/Throwable;", "closeCause", "()Ljava/lang/Throwable;", "sendException", "b", "valueException", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @JvmField
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f59496a;

        public a(@Nullable Throwable th) {
            this.f59496a = th;
        }

        @NotNull
        public final Throwable a() {
            Throwable th = this.f59496a;
            return th != null ? th : new ClosedSendChannelException("Channel was closed");
        }

        @NotNull
        public final Throwable b() {
            Throwable th = this.f59496a;
            return th != null ? th : new IllegalStateException("Channel was closed");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/u$b;", "", "Lkotlinx/coroutines/channels/u$a;", "CLOSED", "Lkotlinx/coroutines/channels/u$a;", "Lkotlinx/coroutines/channels/u$c;", "INITIAL_STATE", "Lkotlinx/coroutines/channels/u$c;", "Lkotlinx/coroutines/internal/j0;", "UNDEFINED", "Lkotlinx/coroutines/internal/j0;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B'\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0018\u00010\u0006\u00a2\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/u$c;", "E", "", "a", "Ljava/lang/Object;", "value", "", "Lkotlinx/coroutines/channels/u$d;", "b", "[Lkotlinx/coroutines/channels/u$d;", "subscribers", "<init>", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/u$d;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<E> {
        @JvmField
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Object f59497a;
        @JvmField
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final d<E>[] f59498b;

        public c(@Nullable Object obj, @Nullable d<E>[] dVarArr) {
            this.f59497a = obj;
            this.f59498b = dVarArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/u$d;", "E", "Lkotlinx/coroutines/channels/v;", "Lkotlinx/coroutines/channels/d0;", "", "wasClosed", "Lkotlin/f1;", "c0", "element", "", "A", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/u;", "f", "Lkotlinx/coroutines/channels/u;", "broadcastChannel", "<init>", "(Lkotlinx/coroutines/channels/u;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<E> extends v<E> implements d0<E> {

        /* renamed from: f  reason: collision with root package name */
        private final u<E> f59499f;

        public d(@NotNull u<E> uVar) {
            super(null);
            this.f59499f = uVar;
        }

        @Override // kotlinx.coroutines.channels.v, kotlinx.coroutines.channels.c
        @NotNull
        public Object A(E e4) {
            return super.A(e4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.channels.v, kotlinx.coroutines.channels.a
        public void c0(boolean z3) {
            if (z3) {
                this.f59499f.g(this);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JX\u0010\f\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0006\u001a\u00028\u00002(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"kotlinx/coroutines/channels/u$e", "Lkotlinx/coroutines/selects/e;", "Lkotlinx/coroutines/channels/h0;", "R", "Lkotlinx/coroutines/selects/f;", "select", "param", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "D", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e implements kotlinx.coroutines.selects.e<E, h0<? super E>> {
        e() {
        }

        @Override // kotlinx.coroutines.selects.e
        public <R> void D(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, E e4, @NotNull d2.p<? super h0<? super E>, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
            u.this.m(fVar, e4, pVar);
        }
    }

    static {
        kotlinx.coroutines.internal.j0 j0Var = new kotlinx.coroutines.internal.j0("UNDEFINED");
        f59493e = j0Var;
        f59494f = new c<>(j0Var, null);
        f59489a = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_state");
        f59490b = AtomicIntegerFieldUpdater.newUpdater(u.class, "_updating");
        f59491c = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "onCloseHandler");
    }

    public u() {
        this._state = f59494f;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    private final d<E>[] e(d<E>[] dVarArr, d<E> dVar) {
        Object[] T2;
        if (dVarArr != null) {
            T2 = kotlin.collections.o.T2(dVarArr, dVar);
            return (d[]) T2;
        }
        d<E>[] dVarArr2 = new d[1];
        for (int i4 = 0; i4 < 1; i4++) {
            dVarArr2[i4] = dVar;
        }
        return dVarArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(d<E> dVar) {
        Object obj;
        Object obj2;
        d<E>[] dVarArr;
        do {
            obj = this._state;
            if (obj instanceof a) {
                return;
            }
            if (!(obj instanceof c)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
            obj2 = ((c) obj).f59497a;
            if (obj != null) {
                dVarArr = ((c) obj).f59498b;
                kotlin.jvm.internal.f0.m(dVarArr);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
            }
        } while (!io.netty.channel.a.a(f59489a, this, obj, new c(obj2, n(dVarArr, dVar))));
    }

    public static /* synthetic */ void i() {
    }

    private final void k(Throwable th) {
        kotlinx.coroutines.internal.j0 j0Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (j0Var = kotlinx.coroutines.channels.b.f59401i) || !io.netty.channel.a.a(f59491c, this, obj, j0Var)) {
            return;
        }
        ((d2.l) t0.q(obj, 1)).invoke(th);
    }

    private final a l(E e4) {
        Object obj;
        if (f59490b.compareAndSet(this, 0, 1)) {
            do {
                try {
                    obj = this._state;
                    if (obj instanceof a) {
                        return (a) obj;
                    }
                    if (!(obj instanceof c)) {
                        throw new IllegalStateException(("Invalid state " + obj).toString());
                    } else if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                    }
                } finally {
                    this._updating = 0;
                }
            } while (!io.netty.channel.a.a(f59489a, this, obj, new c(e4, ((c) obj).f59498b)));
            d<E>[] dVarArr = ((c) obj).f59498b;
            if (dVarArr != null) {
                for (d<E> dVar : dVarArr) {
                    dVar.A(e4);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void m(kotlinx.coroutines.selects.f<? super R> fVar, E e4, d2.p<? super h0<? super E>, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        if (fVar.p()) {
            a l4 = l(e4);
            if (l4 != null) {
                fVar.v(l4.a());
            } else {
                z2.b.d(pVar, this, fVar.t());
            }
        }
    }

    private final d<E>[] n(d<E>[] dVarArr, d<E> dVar) {
        int ff;
        int length = dVarArr.length;
        ff = kotlin.collections.p.ff(dVarArr, dVar);
        if (length == 1) {
            return null;
        }
        d<E>[] dVarArr2 = new d[length - 1];
        kotlin.collections.o.l1(dVarArr, dVarArr2, 0, 0, ff, 6, null);
        kotlin.collections.o.l1(dVarArr, dVarArr2, ff, ff + 1, 0, 8, null);
        return dVarArr2;
    }

    @Override // kotlinx.coroutines.channels.j
    /* renamed from: K */
    public boolean a(@Nullable Throwable th) {
        Object obj;
        int i4;
        do {
            obj = this._state;
            if (obj instanceof a) {
                return false;
            }
            if (!(obj instanceof c)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!io.netty.channel.a.a(f59489a, this, obj, th == null ? f59492d : new a(th)));
        if (obj != null) {
            d<E>[] dVarArr = ((c) obj).f59498b;
            if (dVarArr != null) {
                for (d<E> dVar : dVarArr) {
                    dVar.K(th);
                }
            }
            k(th);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
    }

    @Override // kotlinx.coroutines.channels.h0
    @Nullable
    public Object O(E e4, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        a l4 = l(e4);
        if (l4 == null) {
            h4 = kotlin.coroutines.intrinsics.b.h();
            return l4 == h4 ? l4 : f1.f55527a;
        }
        throw l4.a();
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean P() {
        return this._state instanceof a;
    }

    @Override // kotlinx.coroutines.channels.j
    public void b(@Nullable CancellationException cancellationException) {
        a(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.h0
    public void f(@NotNull d2.l<? super Throwable, f1> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f59491c;
        if (!io.netty.channel.a.a(atomicReferenceFieldUpdater, this, null, lVar)) {
            Object obj = this.onCloseHandler;
            if (obj == kotlinx.coroutines.channels.b.f59401i) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Object obj2 = this._state;
        if ((obj2 instanceof a) && io.netty.channel.a.a(atomicReferenceFieldUpdater, this, lVar, kotlinx.coroutines.channels.b.f59401i)) {
            lVar.invoke(((a) obj2).f59496a);
        }
    }

    public final E h() {
        Object obj = this._state;
        if (!(obj instanceof a)) {
            if (obj instanceof c) {
                E e4 = (E) ((c) obj).f59497a;
                if (e4 != f59493e) {
                    return e4;
                }
                throw new IllegalStateException("No value");
            }
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
        throw ((a) obj).b();
    }

    @Nullable
    public final E j() {
        Object obj = this._state;
        if (obj instanceof a) {
            return null;
        }
        if (!(obj instanceof c)) {
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
        kotlinx.coroutines.internal.j0 j0Var = f59493e;
        E e4 = (E) ((c) obj).f59497a;
        if (e4 == j0Var) {
            return null;
        }
        return e4;
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean offer(E e4) {
        a l4 = l(e4);
        if (l4 == null) {
            return true;
        }
        throw l4.a();
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean p() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.h0
    @NotNull
    public kotlinx.coroutines.selects.e<E, h0<E>> r() {
        return new e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.j
    @NotNull
    public d0<E> t() {
        Object obj;
        Object obj2;
        d dVar = new d(this);
        do {
            obj = this._state;
            if (obj instanceof a) {
                dVar.K(((a) obj).f59496a);
                return dVar;
            } else if (obj instanceof c) {
                c cVar = (c) obj;
                Object obj3 = cVar.f59497a;
                if (obj3 != f59493e) {
                    dVar.A(obj3);
                }
                obj2 = cVar.f59497a;
                if (obj != null) {
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                }
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!io.netty.channel.a.a(f59489a, this, obj, new c(obj2, e(((c) obj).f59498b, dVar))));
        return dVar;
    }

    public u(E e4) {
        this();
        f59489a.lazySet(this, new c(e4, null));
    }
}
