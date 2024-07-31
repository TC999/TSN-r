package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.C15125l2;
import kotlinx.coroutines.C15137n0;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.channels.InterfaceC14704h0;
import kotlinx.coroutines.selects.InterfaceC15196e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B%\u0012\u0006\u00104\u001a\u000203\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u00105\u001a\u00020\b¢\u0006\u0004\b6\u00107J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0016\u0010\f\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0014J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010\u0018\u001a\u00020\u00032#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0014H\u0097\u0001J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0096\u0001J\u001b\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR \u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b+\u0010&R\u0014\u0010.\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b-\u0010&R&\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'0/8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019¨\u00068"}, m12616d2 = {"Lkotlinx/coroutines/channels/l;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/a;", "Lkotlin/f1;", "Lkotlinx/coroutines/channels/b0;", "Lkotlinx/coroutines/channels/j;", "", "cause", "", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "d0", DomainCampaignEx.LOOPBACK_VALUE, "t1", "(Lkotlin/f1;)V", "handled", "n1", "L", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "C", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/d0;", "v", "P", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "Lkotlinx/coroutines/channels/j;", "s1", "()Lkotlinx/coroutines/channels/j;", "_channel", "isActive", "()Z", "Lkotlinx/coroutines/channels/h0;", "getChannel", "()Lkotlinx/coroutines/channels/h0;", "channel", "Q", "isClosedForSend", CampaignEx.JSON_KEY_AD_Q, "isFull", "Lkotlinx/coroutines/selects/e;", "s", "()Lkotlinx/coroutines/selects/e;", "onSend", "Lkotlin/coroutines/f;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/j;Z)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Broadcast<E> extends AbstractCoroutine<Unit> implements InterfaceC14686b0<E>, BroadcastChannel<E> {
    @NotNull

    /* renamed from: d */
    private final BroadcastChannel<E> f42085d;

    public Broadcast(@NotNull CoroutineContext coroutineContext, @NotNull BroadcastChannel<E> broadcastChannel, boolean z) {
        super(coroutineContext, z);
        this.f42085d = broadcastChannel;
    }

    /* renamed from: u1 */
    static /* synthetic */ Object m5427u1(Broadcast broadcast, Object obj, InterfaceC14268c interfaceC14268c) {
        return broadcast.f42085d.mo5177P(obj, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    @ExperimentalCoroutinesApi
    /* renamed from: C */
    public void mo5200C(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        this.f42085d.mo5200C(interfaceC15280l);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: L */
    public boolean mo5178L(@Nullable Throwable th) {
        boolean mo5178L = this.f42085d.mo5178L(th);
        start();
        return mo5178L;
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    @Nullable
    /* renamed from: P */
    public Object mo5177P(E e, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return m5427u1(this, e, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: Q */
    public boolean mo5199Q() {
        return this.f42085d.mo5199Q();
    }

    @Override // kotlinx.coroutines.C15125l2, kotlinx.coroutines.Job, kotlinx.coroutines.channels.BroadcastChannel
    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: a */
    public final /* synthetic */ boolean mo3828a(@Nullable Throwable th) {
        if (th == null) {
            th = new JobCancellationException(mo4036g0(), null, this);
        }
        mo4042d0(th);
        return true;
    }

    @Override // kotlinx.coroutines.C15125l2, kotlinx.coroutines.Job, kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: b */
    public final void mo3827b(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(mo4036g0(), null, this);
        }
        mo4042d0(cancellationException);
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: d0 */
    public void mo4042d0(@NotNull Throwable th) {
        CancellationException m4041d1 = C15125l2.m4041d1(this, th, null, 1, null);
        this.f42085d.mo3827b(m4041d1);
        m4046b0(m4041d1);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14686b0
    @NotNull
    public InterfaceC14704h0<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.C15125l2, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    /* renamed from: n1 */
    protected void mo5431n1(@NotNull Throwable th, boolean z) {
        if (this.f42085d.mo5178L(th) || z) {
            return;
        }
        C15137n0.m3969b(getContext(), th);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    public boolean offer(E e) {
        return this.f42085d.offer(e);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: q */
    public boolean mo5187q() {
        return this.f42085d.mo5187q();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    @NotNull
    /* renamed from: s */
    public InterfaceC15196e<E, InterfaceC14704h0<E>> mo5176s() {
        return this.f42085d.mo5176s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: s1 */
    public final BroadcastChannel<E> m5429s1() {
        return this.f42085d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    /* renamed from: t1 */
    public void mo5430o1(@NotNull Unit unit) {
        InterfaceC14704h0.C14705a.m5442a(this.f42085d, null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @NotNull
    /* renamed from: v */
    public InterfaceC14695d0<E> mo5175v() {
        return this.f42085d.mo5175v();
    }
}
