package kotlinx.coroutines.sync;

import com.mbridge.msdk.mbbid.out.BidResponsed;
import io.netty.channel.C13675a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.C15161r;
import kotlinx.coroutines.InterfaceC15064i1;
import kotlinx.coroutines.InterfaceC15146o;
import kotlinx.coroutines.internal.AbstractC15073c0;
import kotlinx.coroutines.internal.AbstractC15074d;
import kotlinx.coroutines.internal.Atomic;
import kotlinx.coroutines.internal.C15072c;
import kotlinx.coroutines.internal.C15091q;
import kotlinx.coroutines.internal.C15093r;
import kotlinx.coroutines.internal.C15094s;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.C15198g;
import kotlinx.coroutines.selects.InterfaceC15196e;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p649u1.C16231a;
import p649u1.Undispatched;

/* compiled from: Mutex.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0006\u0006\u001a\t\u0012\u0015\u0014B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0005¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\nJT\u0010\u0012\u001a\u00020\b\"\u0004\b\u0000\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0007J\u0019\u0010\u0015\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\"\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, m12616d2 = {"Lkotlinx/coroutines/sync/d;", "Lkotlinx/coroutines/sync/c;", "Lkotlinx/coroutines/selects/e;", "", "owner", "", "a", "(Ljava/lang/Object;)Z", "Lkotlin/f1;", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "i", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "block", "d", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ll1/p;)V", "f", "e", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "b", "()Z", "isLocked", "h", "isLockedEmptyQueueState", "g", "()Lkotlinx/coroutines/selects/e;", "onLock", "locked", "<init>", "(Z)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.sync.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15209d implements InterfaceC15207c, InterfaceC15196e<Object, InterfaceC15207c> {

    /* renamed from: a */
    static final AtomicReferenceFieldUpdater f43362a = AtomicReferenceFieldUpdater.newUpdater(C15209d.class, Object.class, "_state");
    volatile Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/sync/d$a;", "Lkotlinx/coroutines/sync/d$c;", "Lkotlinx/coroutines/sync/d;", "", "g0", BidResponsed.KEY_TOKEN, "Lkotlin/f1;", "f0", "", "toString", "Lkotlinx/coroutines/o;", "f", "Lkotlinx/coroutines/o;", "cont", "owner", "<init>", "(Lkotlinx/coroutines/sync/d;Ljava/lang/Object;Lkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15210a extends AbstractC15214c {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: f */
        public final InterfaceC15146o<Unit> f43363f;

        /* compiled from: Mutex.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.sync.d$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        static final class C15211a extends Lambda implements InterfaceC15280l<Throwable, Unit> {
            C15211a() {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                C15210a c15210a = C15210a.this;
                C15209d.this.mo3630e(c15210a.f43370d);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C15210a(@Nullable Object obj, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o) {
            super(obj);
            this.f43363f = interfaceC15146o;
        }

        @Override // kotlinx.coroutines.sync.C15209d.AbstractC15214c
        /* renamed from: f0 */
        public void mo3625f0(@NotNull Object obj) {
            this.f43363f.mo3906T(obj);
        }

        @Override // kotlinx.coroutines.sync.C15209d.AbstractC15214c
        @Nullable
        /* renamed from: g0 */
        public Object mo3624g0() {
            return this.f43363f.mo3911N(Unit.f41048a, null, new C15211a());
        }

        @Override // kotlinx.coroutines.internal.C15094s
        @NotNull
        public String toString() {
            return "LockCont[" + this.f43370d + ", " + this.f43363f + "] for " + C15209d.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BF\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0010ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m12616d2 = {"Lkotlinx/coroutines/sync/d$b;", "R", "Lkotlinx/coroutines/sync/d$c;", "Lkotlinx/coroutines/sync/d;", "", "g0", BidResponsed.KEY_TOKEN, "Lkotlin/f1;", "f0", "", "toString", "Lkotlinx/coroutines/selects/f;", "f", "Lkotlinx/coroutines/selects/f;", "select", "owner", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/c;", "Lkotlin/coroutines/c;", "block", "<init>", "(Lkotlinx/coroutines/sync/d;Ljava/lang/Object;Lkotlinx/coroutines/selects/f;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.d$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15212b<R> extends AbstractC15214c {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: f */
        public final InterfaceC15197f<R> f43366f;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: g */
        public final InterfaceC15284p<InterfaceC15207c, InterfaceC14268c<? super R>, Object> f43367g;

        /* compiled from: Mutex.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"R", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.sync.d$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        static final class C15213a extends Lambda implements InterfaceC15280l<Throwable, Unit> {
            C15213a() {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                C15212b c15212b = C15212b.this;
                C15209d.this.mo3630e(c15212b.f43370d);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C15212b(@Nullable Object obj, @NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15284p<? super InterfaceC15207c, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
            super(obj);
            this.f43366f = interfaceC15197f;
            this.f43367g = interfaceC15284p;
        }

        @Override // kotlinx.coroutines.sync.C15209d.AbstractC15214c
        /* renamed from: f0 */
        public void mo3625f0(@NotNull Object obj) {
            C16231a.m227d(this.f43367g, C15209d.this, this.f43366f.mo3702s(), new C15213a());
        }

        @Override // kotlinx.coroutines.sync.C15209d.AbstractC15214c
        @Nullable
        /* renamed from: g0 */
        public Object mo3624g0() {
            Symbol symbol;
            if (this.f43366f.mo3703o()) {
                symbol = Mutex.f43348c;
                return symbol;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.C15094s
        @NotNull
        public String toString() {
            return "LockSelect[" + this.f43370d + ", " + this.f43366f + "] for " + C15209d.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b¢\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0004\u001a\u00020\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, m12616d2 = {"Lkotlinx/coroutines/sync/d$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "dispose", "", "g0", BidResponsed.KEY_TOKEN, "f0", "d", "Ljava/lang/Object;", "owner", "<init>", "(Lkotlinx/coroutines/sync/d;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.d$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public abstract class AbstractC15214c extends C15094s implements InterfaceC15064i1 {
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: d */
        public final Object f43370d;

        public AbstractC15214c(@Nullable Object obj) {
            this.f43370d = obj;
        }

        @Override // kotlinx.coroutines.InterfaceC15064i1
        public final void dispose() {
            mo4211Y();
        }

        /* renamed from: f0 */
        public abstract void mo3625f0(@NotNull Object obj);

        @Nullable
        /* renamed from: g0 */
        public abstract Object mo3624g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m12616d2 = {"Lkotlinx/coroutines/sync/d$d;", "Lkotlinx/coroutines/internal/q;", "", "toString", "", "d", "Ljava/lang/Object;", "owner", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.d$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15215d extends C15091q {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: d */
        public Object f43372d;

        public C15215d(@NotNull Object obj) {
            this.f43372d = obj;
        }

        @Override // kotlinx.coroutines.internal.C15094s
        @NotNull
        public String toString() {
            return "LockedQueue[" + this.f43372d + ']';
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0019\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u001e\u0010\b\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\r¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/sync/d$e;", "Lkotlinx/coroutines/internal/b;", "Lkotlinx/coroutines/internal/d;", "op", "", "c", "failure", "Lkotlin/f1;", "a", "Lkotlinx/coroutines/sync/d;", "b", "Lkotlinx/coroutines/sync/d;", "mutex", "Ljava/lang/Object;", "owner", "<init>", "(Lkotlinx/coroutines/sync/d;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.d$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C15216e extends Atomic {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: b */
        public final C15209d f43373b;
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: c */
        public final Object f43374c;

        /* compiled from: Mutex.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001e\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/sync/d$e$a;", "Lkotlinx/coroutines/internal/c0;", "", "affected", "c", "Lkotlinx/coroutines/internal/d;", "a", "Lkotlinx/coroutines/internal/d;", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/sync/d$e;Lkotlinx/coroutines/internal/d;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.sync.d$e$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        private final class C15217a extends AbstractC15073c0 {
            @NotNull

            /* renamed from: a */
            private final AbstractC15074d<?> f43375a;

            public C15217a(@NotNull AbstractC15074d<?> abstractC15074d) {
                this.f43375a = abstractC15074d;
            }

            @Override // kotlinx.coroutines.internal.AbstractC15073c0
            @NotNull
            /* renamed from: a */
            public AbstractC15074d<?> mo3621a() {
                return this.f43375a;
            }

            @Override // kotlinx.coroutines.internal.AbstractC15073c0
            @Nullable
            /* renamed from: c */
            public Object mo3620c(@Nullable Object obj) {
                Object mo3621a = mo3621a().m4371h() ? Mutex.f43352g : mo3621a();
                if (obj != null) {
                    C13675a.m12692a(C15209d.f43362a, (C15209d) obj, this, mo3621a);
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
            }
        }

        public C15216e(@NotNull C15209d c15209d, @Nullable Object obj) {
            this.f43373b = c15209d;
            this.f43374c = obj;
        }

        @Override // kotlinx.coroutines.internal.Atomic
        /* renamed from: a */
        public void mo3623a(@NotNull AbstractC15074d<?> abstractC15074d, @Nullable Object obj) {
            C15206b c15206b;
            if (obj != null) {
                c15206b = Mutex.f43352g;
            } else {
                Object obj2 = this.f43374c;
                c15206b = obj2 == null ? Mutex.f43351f : new C15206b(obj2);
            }
            C13675a.m12692a(C15209d.f43362a, this.f43373b, abstractC15074d, c15206b);
        }

        @Override // kotlinx.coroutines.internal.Atomic
        @Nullable
        /* renamed from: c */
        public Object mo3622c(@NotNull AbstractC15074d<?> abstractC15074d) {
            C15206b c15206b;
            Symbol symbol;
            C15217a c15217a = new C15217a(abstractC15074d);
            C15209d c15209d = this.f43373b;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C15209d.f43362a;
            c15206b = Mutex.f43352g;
            if (C13675a.m12692a(atomicReferenceFieldUpdater, c15209d, c15206b, c15217a)) {
                return c15217a.mo3620c(this.f43373b);
            }
            symbol = Mutex.f43346a;
            return symbol;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/sync/d$f;", "Lkotlinx/coroutines/internal/d;", "Lkotlinx/coroutines/sync/d;", "affected", "", "k", "failure", "Lkotlin/f1;", "j", "Lkotlinx/coroutines/sync/d$d;", "b", "Lkotlinx/coroutines/sync/d$d;", "queue", "<init>", "(Lkotlinx/coroutines/sync/d$d;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.d$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15218f extends AbstractC15074d<C15209d> {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: b */
        public final C15215d f43377b;

        public C15218f(@NotNull C15215d c15215d) {
            this.f43377b = c15215d;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        /* renamed from: j */
        public void mo3619d(@NotNull C15209d c15209d, @Nullable Object obj) {
            C13675a.m12692a(C15209d.f43362a, c15209d, this, obj == null ? Mutex.f43352g : this.f43377b);
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        @Nullable
        /* renamed from: k */
        public Object mo3615i(@NotNull C15209d c15209d) {
            Symbol symbol;
            if (this.f43377b.m4245g0()) {
                return null;
            }
            symbol = Mutex.f43347b;
            return symbol;
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007¸\u0006\b"}, m12616d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core", "kotlinx/coroutines/sync/MutexImpl$$special$$inlined$loop$lambda$1"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.d$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15219g extends C15094s.AbstractC15097c {

        /* renamed from: d */
        final /* synthetic */ C15094s f43378d;

        /* renamed from: e */
        final /* synthetic */ Object f43379e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15146o f43380f;

        /* renamed from: g */
        final /* synthetic */ C15210a f43381g;

        /* renamed from: h */
        final /* synthetic */ C15209d f43382h;

        /* renamed from: i */
        final /* synthetic */ Object f43383i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15219g(C15094s c15094s, C15094s c15094s2, Object obj, InterfaceC15146o interfaceC15146o, C15210a c15210a, C15209d c15209d, Object obj2) {
            super(c15094s2);
            this.f43378d = c15094s;
            this.f43379e = obj;
            this.f43380f = interfaceC15146o;
            this.f43381g = c15210a;
            this.f43382h = c15209d;
            this.f43383i = obj2;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        @Nullable
        /* renamed from: k */
        public Object mo3615i(@NotNull C15094s c15094s) {
            if (this.f43382h._state == this.f43379e) {
                return null;
            }
            return C15093r.m4240a();
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/internal/s$f", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.d$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15220h extends C15094s.AbstractC15097c {

        /* renamed from: d */
        final /* synthetic */ C15094s f43384d;

        /* renamed from: e */
        final /* synthetic */ C15209d f43385e;

        /* renamed from: f */
        final /* synthetic */ Object f43386f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15220h(C15094s c15094s, C15094s c15094s2, C15209d c15209d, Object obj) {
            super(c15094s2);
            this.f43384d = c15094s;
            this.f43385e = c15209d;
            this.f43386f = obj;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        @Nullable
        /* renamed from: k */
        public Object mo3615i(@NotNull C15094s c15094s) {
            if (this.f43385e._state == this.f43386f) {
                return null;
            }
            return C15093r.m4240a();
        }
    }

    public C15209d(boolean z) {
        this._state = z ? Mutex.f43351f : Mutex.f43352g;
    }

    @Override // kotlinx.coroutines.sync.InterfaceC15207c
    /* renamed from: a */
    public boolean mo3634a(@Nullable Object obj) {
        Symbol symbol;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof C15206b) {
                Object obj3 = ((C15206b) obj2).f43361a;
                symbol = Mutex.f43350e;
                if (obj3 != symbol) {
                    return false;
                }
                if (C13675a.m12692a(f43362a, this, obj2, obj == null ? Mutex.f43351f : new C15206b(obj))) {
                    return true;
                }
            } else if (obj2 instanceof C15215d) {
                if (((C15215d) obj2).f43372d != obj) {
                    return false;
                }
                throw new IllegalStateException(("Already locked by " + obj).toString());
            } else if (!(obj2 instanceof AbstractC15073c0)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((AbstractC15073c0) obj2).mo3620c(this);
            }
        }
    }

    @Override // kotlinx.coroutines.sync.InterfaceC15207c
    /* renamed from: b */
    public boolean mo3633b() {
        Symbol symbol;
        while (true) {
            Object obj = this._state;
            if (obj instanceof C15206b) {
                Object obj2 = ((C15206b) obj).f43361a;
                symbol = Mutex.f43350e;
                return obj2 != symbol;
            } else if (obj instanceof C15215d) {
                return true;
            } else {
                if (!(obj instanceof AbstractC15073c0)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                ((AbstractC15073c0) obj).mo3620c(this);
            }
        }
    }

    @Override // kotlinx.coroutines.sync.InterfaceC15207c
    @Nullable
    /* renamed from: c */
    public Object mo3632c(@Nullable Object obj, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        if (mo3634a(obj)) {
            return Unit.f41048a;
        }
        Object m3626i = m3626i(obj, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m3626i == m8642h ? m3626i : Unit.f41048a;
    }

    @Override // kotlinx.coroutines.selects.InterfaceC15196e
    /* renamed from: d */
    public <R> void mo3631d(@NotNull InterfaceC15197f<? super R> interfaceC15197f, @Nullable Object obj, @NotNull InterfaceC15284p<? super InterfaceC15207c, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        Symbol symbol;
        Symbol symbol2;
        while (!interfaceC15197f.mo3706i()) {
            Object obj2 = this._state;
            if (obj2 instanceof C15206b) {
                C15206b c15206b = (C15206b) obj2;
                Object obj3 = c15206b.f43361a;
                symbol = Mutex.f43350e;
                if (obj3 != symbol) {
                    C13675a.m12692a(f43362a, this, obj2, new C15215d(c15206b.f43361a));
                } else {
                    Object mo3700u = interfaceC15197f.mo3700u(new C15216e(this, obj));
                    if (mo3700u == null) {
                        Undispatched.m222d(interfaceC15284p, this, interfaceC15197f.mo3702s());
                        return;
                    } else if (mo3700u == C15198g.m3696d()) {
                        return;
                    } else {
                        symbol2 = Mutex.f43346a;
                        if (mo3700u != symbol2 && mo3700u != C15072c.f43034b) {
                            throw new IllegalStateException(("performAtomicTrySelect(TryLockDesc) returned " + mo3700u).toString());
                        }
                    }
                }
            } else if (obj2 instanceof C15215d) {
                C15215d c15215d = (C15215d) obj2;
                boolean z = false;
                if (c15215d.f43372d != obj) {
                    C15212b c15212b = new C15212b(obj, interfaceC15197f, interfaceC15284p);
                    C15220h c15220h = new C15220h(c15212b, c15212b, this, obj2);
                    while (true) {
                        int m4206d0 = c15215d.m4217R().m4206d0(c15212b, c15215d, c15220h);
                        if (m4206d0 == 1) {
                            z = true;
                            break;
                        } else if (m4206d0 == 2) {
                            break;
                        }
                    }
                    if (z) {
                        interfaceC15197f.mo3705k(c15212b);
                        return;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (!(obj2 instanceof AbstractC15073c0)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((AbstractC15073c0) obj2).mo3620c(this);
            }
        }
    }

    @Override // kotlinx.coroutines.sync.InterfaceC15207c
    /* renamed from: e */
    public void mo3630e(@Nullable Object obj) {
        C15206b c15206b;
        Symbol symbol;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof C15206b) {
                if (obj == null) {
                    Object obj3 = ((C15206b) obj2).f43361a;
                    symbol = Mutex.f43350e;
                    if (!(obj3 != symbol)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    C15206b c15206b2 = (C15206b) obj2;
                    if (!(c15206b2.f43361a == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + c15206b2.f43361a + " but expected " + obj).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43362a;
                c15206b = Mutex.f43352g;
                if (C13675a.m12692a(atomicReferenceFieldUpdater, this, obj2, c15206b)) {
                    return;
                }
            } else if (obj2 instanceof AbstractC15073c0) {
                ((AbstractC15073c0) obj2).mo3620c(this);
            } else if (obj2 instanceof C15215d) {
                if (obj != null) {
                    C15215d c15215d = (C15215d) obj2;
                    if (!(c15215d.f43372d == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + c15215d.f43372d + " but expected " + obj).toString());
                    }
                }
                C15215d c15215d2 = (C15215d) obj2;
                C15094s m4209a0 = c15215d2.m4209a0();
                if (m4209a0 == null) {
                    C15218f c15218f = new C15218f(c15215d2);
                    if (C13675a.m12692a(f43362a, this, obj2, c15218f) && c15218f.mo3620c(this) == null) {
                        return;
                    }
                } else {
                    AbstractC15214c abstractC15214c = (AbstractC15214c) m4209a0;
                    Object mo3624g0 = abstractC15214c.mo3624g0();
                    if (mo3624g0 != null) {
                        Object obj4 = abstractC15214c.f43370d;
                        if (obj4 == null) {
                            obj4 = Mutex.f43349d;
                        }
                        c15215d2.f43372d = obj4;
                        abstractC15214c.mo3625f0(mo3624g0);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.InterfaceC15207c
    /* renamed from: f */
    public boolean mo3629f(@NotNull Object obj) {
        Object obj2 = this._state;
        if (obj2 instanceof C15206b) {
            if (((C15206b) obj2).f43361a == obj) {
                return true;
            }
        } else if ((obj2 instanceof C15215d) && ((C15215d) obj2).f43372d == obj) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.InterfaceC15207c
    @NotNull
    /* renamed from: g */
    public InterfaceC15196e<Object, InterfaceC15207c> mo3628g() {
        return this;
    }

    /* renamed from: h */
    public final boolean m3627h() {
        Object obj = this._state;
        return (obj instanceof C15215d) && ((C15215d) obj).m4245g0();
    }

    @Nullable
    /* renamed from: i */
    final /* synthetic */ Object m3626i(@Nullable Object obj, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Symbol symbol;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p m3852b = C15161r.m3852b(m8650d);
        C15210a c15210a = new C15210a(obj, m3852b);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof C15206b) {
                C15206b c15206b = (C15206b) obj2;
                Object obj3 = c15206b.f43361a;
                symbol = Mutex.f43350e;
                if (obj3 != symbol) {
                    C13675a.m12692a(f43362a, this, obj2, new C15215d(c15206b.f43361a));
                } else {
                    if (C13675a.m12692a(f43362a, this, obj2, obj == null ? Mutex.f43351f : new C15206b(obj))) {
                        Unit unit = Unit.f41048a;
                        Result.C14124a c14124a = Result.Companion;
                        m3852b.resumeWith(Result.m60148constructorimpl(unit));
                        break;
                    }
                }
            } else if (obj2 instanceof C15215d) {
                C15215d c15215d = (C15215d) obj2;
                boolean z = false;
                if (c15215d.f43372d != obj) {
                    C15219g c15219g = new C15219g(c15210a, c15210a, obj2, m3852b, c15210a, this, obj);
                    while (true) {
                        int m4206d0 = c15215d.m4217R().m4206d0(c15210a, c15215d, c15219g);
                        if (m4206d0 == 1) {
                            z = true;
                            break;
                        } else if (m4206d0 == 2) {
                            break;
                        }
                    }
                    if (z) {
                        C15161r.m3851c(m3852b, c15210a);
                        break;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (!(obj2 instanceof AbstractC15073c0)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((AbstractC15073c0) obj2).mo3620c(this);
            }
        }
        Object m3883y = m3852b.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof C15206b) {
                return "Mutex[" + ((C15206b) obj).f43361a + ']';
            } else if (!(obj instanceof AbstractC15073c0)) {
                if (!(obj instanceof C15215d)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                return "Mutex[" + ((C15215d) obj).f43372d + ']';
            } else {
                ((AbstractC15073c0) obj).mo3620c(this);
            }
        }
    }
}
