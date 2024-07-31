package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlinx.coroutines.selects.InterfaceC15196e;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p649u1.C16231a;

/* compiled from: Actor.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003BO\u0012\u0006\u0010!\u001a\u00020 \u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"\u0012-\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0014¢\u0006\u0002\b%ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016JX\u0010\u0018\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0013\u001a\u00028\u00002(\u0010\u0017\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR&\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, m12616d2 = {"Lkotlinx/coroutines/channels/w;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/d;", "Lkotlinx/coroutines/selects/e;", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/f1;", "p1", "element", "P", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "offer", "(Ljava/lang/Object;)Z", "", "cause", "L", "R", "Lkotlinx/coroutines/selects/f;", "select", "param", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "d", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ll1/p;)V", "e", "Lkotlin/coroutines/c;", "continuation", "s", "()Lkotlinx/coroutines/selects/e;", "onSend", "Lkotlin/coroutines/f;", "parentContext", "Lkotlinx/coroutines/channels/n;", "channel", "Lkotlinx/coroutines/channels/f;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/n;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.w */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14737w<E> extends Actor<E> implements InterfaceC15196e<E, InterfaceC14704h0<? super E>> {

    /* renamed from: e */
    private InterfaceC14268c<? super Unit> f42158e;

    public C14737w(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC14722n<E> interfaceC14722n, @NotNull InterfaceC15284p<? super InterfaceC14699f<E>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        super(coroutineContext, interfaceC14722n, false);
        InterfaceC14268c<? super Unit> m8651c;
        m8651c = IntrinsicsJvm.m8651c(interfaceC15284p, this, this);
        this.f42158e = m8651c;
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: L */
    public boolean mo5178L(@Nullable Throwable th) {
        boolean mo5178L = super.mo5178L(th);
        start();
        return mo5178L;
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.InterfaceC14704h0
    @Nullable
    /* renamed from: P */
    public Object mo5177P(E e, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        start();
        Object mo5177P = super.mo5177P(e, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo5177P == m8642h ? mo5177P : Unit.f41048a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.InterfaceC15196e
    /* renamed from: d */
    public <R> void mo3631d(@NotNull InterfaceC15197f<? super R> interfaceC15197f, E e, @NotNull InterfaceC15284p<? super InterfaceC14704h0<? super E>, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        start();
        super.mo5176s().mo3631d(interfaceC15197f, e, interfaceC15284p);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.InterfaceC14704h0
    public boolean offer(E e) {
        start();
        return super.offer(e);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    /* renamed from: p1 */
    protected void mo3933p1() {
        C16231a.m229b(this.f42158e, this);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.InterfaceC14704h0
    @NotNull
    /* renamed from: s */
    public InterfaceC15196e<E, InterfaceC14704h0<E>> mo5176s() {
        return this;
    }
}
