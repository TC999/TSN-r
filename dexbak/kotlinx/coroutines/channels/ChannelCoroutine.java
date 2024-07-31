package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.C15125l2;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.InterfaceC15195d;
import kotlinx.coroutines.selects.InterfaceC15196e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B%\u0012\u0006\u0010?\u001a\u00020>\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010@\u001a\u00020\b¢\u0006\u0004\bA\u0010BJ\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0016\u0010\f\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0013\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J.\u0010\u0013\u001a\u00020\u00032#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u000fH\u0097\u0001J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0003J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0097Aø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010\u001f\u001a\u0004\u0018\u00018\u0000H\u0097Aø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001cJ\u001b\u0010 \u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b \u0010!R \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010+\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010.\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u00100\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b/\u0010*R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00028\u0000018\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R#\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d018\u0016X\u0097\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b5\u00103R\u001c\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000018\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b7\u00103R&\u0010=\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000:098\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010<\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006C"}, m12616d2 = {"Lkotlinx/coroutines/channels/o;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/a;", "Lkotlin/f1;", "Lkotlinx/coroutines/channels/n;", CommonNetImpl.CANCEL, "", "cause", "", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "d0", "L", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "C", "Lkotlinx/coroutines/channels/p;", "iterator", "element", "offer", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "K", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/m0;", "B", "H", "P", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "Lkotlinx/coroutines/channels/n;", "s1", "()Lkotlinx/coroutines/channels/n;", "_channel", "getChannel", "channel", "h", "()Z", "isClosedForReceive", "Q", "isClosedForSend", "isEmpty", CampaignEx.JSON_KEY_AD_Q, "isFull", "Lkotlinx/coroutines/selects/d;", "F", "()Lkotlinx/coroutines/selects/d;", "onReceive", "M", "onReceiveOrClosed", "G", "onReceiveOrNull", "Lkotlinx/coroutines/selects/e;", "Lkotlinx/coroutines/channels/h0;", "s", "()Lkotlinx/coroutines/selects/e;", "onSend", "Lkotlin/coroutines/f;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/n;Z)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements InterfaceC14722n<E> {
    @NotNull

    /* renamed from: d */
    private final InterfaceC14722n<E> f42132d;

    public ChannelCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC14722n<E> interfaceC14722n, boolean z) {
        super(coroutineContext, z);
        this.f42132d = interfaceC14722n;
    }

    /* renamed from: t1 */
    static /* synthetic */ Object m5392t1(ChannelCoroutine channelCoroutine, InterfaceC14268c interfaceC14268c) {
        return channelCoroutine.f42132d.mo5396K(interfaceC14268c);
    }

    /* renamed from: u1 */
    static /* synthetic */ Object m5391u1(ChannelCoroutine channelCoroutine, InterfaceC14268c interfaceC14268c) {
        return channelCoroutine.f42132d.mo5400B(interfaceC14268c);
    }

    /* renamed from: v1 */
    static /* synthetic */ Object m5390v1(ChannelCoroutine channelCoroutine, InterfaceC14268c interfaceC14268c) {
        return channelCoroutine.f42132d.mo5397H(interfaceC14268c);
    }

    /* renamed from: w1 */
    static /* synthetic */ Object m5389w1(ChannelCoroutine channelCoroutine, Object obj, InterfaceC14268c interfaceC14268c) {
        return channelCoroutine.f42132d.mo5177P(obj, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @InternalCoroutinesApi
    @Nullable
    /* renamed from: B */
    public Object mo5400B(@NotNull InterfaceC14268c<? super C14719m0<? extends E>> interfaceC14268c) {
        return m5391u1(this, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    @ExperimentalCoroutinesApi
    /* renamed from: C */
    public void mo5200C(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        this.f42132d.mo5200C(interfaceC15280l);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @NotNull
    /* renamed from: F */
    public InterfaceC15195d<E> mo5399F() {
        return this.f42132d.mo5399F();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @NotNull
    /* renamed from: G */
    public InterfaceC15195d<E> mo5398G() {
        return this.f42132d.mo5398G();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @ObsoleteCoroutinesApi
    @Nullable
    @Annotations(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @LowPriorityInOverloadResolution
    /* renamed from: H */
    public Object mo5397H(@NotNull InterfaceC14268c<? super E> interfaceC14268c) {
        return m5390v1(this, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @Nullable
    /* renamed from: K */
    public Object mo5396K(@NotNull InterfaceC14268c<? super E> interfaceC14268c) {
        return m5392t1(this, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: L */
    public boolean mo5178L(@Nullable Throwable th) {
        return this.f42132d.mo5178L(th);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @NotNull
    /* renamed from: M */
    public InterfaceC15195d<C14719m0<E>> mo5395M() {
        return this.f42132d.mo5395M();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    @Nullable
    /* renamed from: P */
    public Object mo5177P(E e, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return m5389w1(this, e, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: Q */
    public boolean mo5199Q() {
        return this.f42132d.mo5199Q();
    }

    @Override // kotlinx.coroutines.C15125l2, kotlinx.coroutines.Job, kotlinx.coroutines.channels.BroadcastChannel
    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: a */
    public final /* synthetic */ boolean mo3828a(@Nullable Throwable th) {
        mo4042d0(new JobCancellationException(mo4036g0(), null, this));
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

    @Override // kotlinx.coroutines.C15125l2, kotlinx.coroutines.Job, kotlinx.coroutines.channels.InterfaceC14695d0
    public /* synthetic */ void cancel() {
        mo4042d0(new JobCancellationException(mo4036g0(), null, this));
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: d0 */
    public void mo4042d0(@NotNull Throwable th) {
        CancellationException m4041d1 = C15125l2.m4041d1(this, th, null, 1, null);
        this.f42132d.mo5474b(m4041d1);
        m4046b0(m4041d1);
    }

    @NotNull
    public final InterfaceC14722n<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    /* renamed from: h */
    public boolean mo5394h() {
        return this.f42132d.mo5394h();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    public boolean isEmpty() {
        return this.f42132d.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @NotNull
    public InterfaceC14725p<E> iterator() {
        return this.f42132d.iterator();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    public boolean offer(E e) {
        return this.f42132d.offer(e);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @Nullable
    public E poll() {
        return this.f42132d.poll();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: q */
    public boolean mo5187q() {
        return this.f42132d.mo5187q();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    @NotNull
    /* renamed from: s */
    public InterfaceC15196e<E, InterfaceC14704h0<E>> mo5176s() {
        return this.f42132d.mo5176s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: s1 */
    public final InterfaceC14722n<E> m5393s1() {
        return this.f42132d;
    }
}
