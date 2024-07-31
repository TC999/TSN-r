package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\b\u0004B\u001d\u0012\u0014\u0010\n\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/c;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/x0;", "a", "[Lkotlinx/coroutines/x0;", "deferreds", "<init>", "([Lkotlinx/coroutines/x0;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Await<T> {

    /* renamed from: b */
    static final AtomicIntegerFieldUpdater f41713b = AtomicIntegerFieldUpdater.newUpdater(Await.class, "notCompletedCount");

    /* renamed from: a */
    private final Deferred<T>[] f41714a;
    volatile int notCompletedCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Await.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R<\u0010\u001c\u001a\u000e\u0018\u00010\u0015R\b\u0012\u0004\u0012\u00028\u00000\u00162\u0012\u0010\u0017\u001a\u000e\u0018\u00010\u0015R\b\u0012\u0004\u0012\u00028\u00000\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006 "}, m12616d2 = {"Lkotlinx/coroutines/c$a;", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "f0", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/i1;", "e", "Lkotlinx/coroutines/i1;", "h0", "()Lkotlinx/coroutines/i1;", "j0", "(Lkotlinx/coroutines/i1;)V", "handle", "Lkotlinx/coroutines/o;", "", "f", "Lkotlinx/coroutines/o;", "continuation", "Lkotlinx/coroutines/c$b;", "Lkotlinx/coroutines/c;", DomainCampaignEx.LOOPBACK_VALUE, "g0", "()Lkotlinx/coroutines/c$b;", "i0", "(Lkotlinx/coroutines/c$b;)V", "disposer", "job", "<init>", "(Lkotlinx/coroutines/c;Lkotlinx/coroutines/o;Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C14630a extends AbstractC15119k2<Job> {
        private volatile Object _disposer;
        @NotNull

        /* renamed from: e */
        public InterfaceC15064i1 f41715e;

        /* renamed from: f */
        private final InterfaceC15146o<List<? extends T>> f41716f;

        /* JADX WARN: Multi-variable type inference failed */
        public C14630a(@NotNull InterfaceC15146o<? super List<? extends T>> interfaceC15146o, @NotNull Job job) {
            super(job);
            this.f41716f = interfaceC15146o;
            this._disposer = null;
        }

        @Override // kotlinx.coroutines.CompletionHandler
        /* renamed from: f0 */
        public void mo3495f0(@Nullable Throwable th) {
            if (th != null) {
                Object mo3892p = this.f41716f.mo3892p(th);
                if (mo3892p != null) {
                    this.f41716f.mo3906T(mo3892p);
                    Await<T>.C14631b m5715g0 = m5715g0();
                    if (m5715g0 != null) {
                        m5715g0.m5711b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (Await.f41713b.decrementAndGet(Await.this) == 0) {
                InterfaceC15146o<List<? extends T>> interfaceC15146o = this.f41716f;
                Deferred[] deferredArr = Await.this.f41714a;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred deferred : deferredArr) {
                    arrayList.add(deferred.mo3492g());
                }
                Result.C14124a c14124a = Result.Companion;
                interfaceC15146o.resumeWith(Result.m60148constructorimpl(arrayList));
            }
        }

        @Nullable
        /* renamed from: g0 */
        public final Await<T>.C14631b m5715g0() {
            return (C14631b) this._disposer;
        }

        @NotNull
        /* renamed from: h0 */
        public final InterfaceC15064i1 m5714h0() {
            InterfaceC15064i1 interfaceC15064i1 = this.f41715e;
            if (interfaceC15064i1 == null) {
                C14342f0.m8200S("handle");
            }
            return interfaceC15064i1;
        }

        /* renamed from: i0 */
        public final void m5713i0(@Nullable Await<T>.C14631b c14631b) {
            this._disposer = c14631b;
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            mo3495f0(th);
            return Unit.f41048a;
        }

        /* renamed from: j0 */
        public final void m5712j0(@NotNull InterfaceC15064i1 interfaceC15064i1) {
            this.f41715e = interfaceC15064i1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Await.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\r\u001a\u0012\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R$\u0010\r\u001a\u0012\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u000b0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\f¨\u0006\u0010"}, m12616d2 = {"Lkotlinx/coroutines/c$b;", "Lkotlinx/coroutines/m;", "Lkotlin/f1;", "b", "", "cause", "a", "", "toString", "", "Lkotlinx/coroutines/c$a;", "Lkotlinx/coroutines/c;", "[Lkotlinx/coroutines/c$a;", "nodes", "<init>", "(Lkotlinx/coroutines/c;[Lkotlinx/coroutines/c$a;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C14631b extends AbstractC15132m {

        /* renamed from: a */
        private final Await<T>.C14630a[] f41718a;

        public C14631b(@NotNull Await<T>.C14630a[] c14630aArr) {
            this.f41718a = c14630aArr;
        }

        @Override // kotlinx.coroutines.AbstractC15136n
        /* renamed from: a */
        public void mo3521a(@Nullable Throwable th) {
            m5711b();
        }

        /* renamed from: b */
        public final void m5711b() {
            for (Await<T>.C14630a c14630a : this.f41718a) {
                c14630a.m5714h0().dispose();
            }
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            mo3521a(th);
            return Unit.f41048a;
        }

        @NotNull
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f41718a + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Await(@NotNull Deferred<? extends T>[] deferredArr) {
        this.f41714a = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    @Nullable
    /* renamed from: b */
    public final Object m5716b(@NotNull InterfaceC14268c<? super List<? extends T>> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3915J();
        int length = this.f41714a.length;
        C14630a[] c14630aArr = new C14630a[length];
        for (int i = 0; i < length; i++) {
            Deferred deferred = this.f41714a[boxing.m8626f(i).intValue()];
            deferred.start();
            C14630a c14630a = new C14630a(c15153p, deferred);
            c14630a.m5712j0(deferred.mo3818w(c14630a));
            c14630aArr[i] = c14630a;
        }
        Await<T>.C14631b c14631b = new C14631b(c14630aArr);
        for (int i2 = 0; i2 < length; i2++) {
            c14630aArr[i2].m5713i0(c14631b);
        }
        if (c15153p.isCompleted()) {
            c14631b.m5711b();
        } else {
            c15153p.mo3902e(c14631b);
        }
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }
}
