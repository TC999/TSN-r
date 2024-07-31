package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.C14294d0;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.AbstractC14773e;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.C15157q;
import kotlinx.coroutines.C15161r;
import kotlinx.coroutines.DebugStrings;
import kotlinx.coroutines.InterfaceC15064i1;
import kotlinx.coroutines.InterfaceC15146o;
import kotlinx.coroutines.channels.C14719m0;
import kotlinx.coroutines.channels.InterfaceC14725p;
import kotlinx.coroutines.internal.C15070b0;
import kotlinx.coroutines.internal.C15072c;
import kotlinx.coroutines.internal.C15091q;
import kotlinx.coroutines.internal.C15093r;
import kotlinx.coroutines.internal.C15094s;
import kotlinx.coroutines.internal.C15101t;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.StackTraceRecovery;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.C15198g;
import kotlinx.coroutines.selects.InterfaceC15195d;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p649u1.C16231a;
import p649u1.Undispatched;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0007-0VWXYZB)\u0012 \u0010S\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0014\u0018\u00010Qj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`R¢\u0006\u0004\bT\u0010UJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J\u001b\u0010\n\u001a\u0004\u0018\u00018\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJT\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0001\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2$\u0010\u0013\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016JZ\u0010\u0018\u001a\u00020\u0014\"\u0004\b\u0001\u0010\f* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019JT\u0010\u001a\u001a\u00020\u0006\"\u0004\b\u0001\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2$\u0010\u0013\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001e\u001a\u00020\u00142\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001c2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0014J\u0016\u0010 \u001a\u0004\u0018\u00010\b2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0014J\u0013\u0010!\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u00028\u0001\"\u0004\b\u0001\u0010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0016\u0010%\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0014J\u0015\u0010&\u001a\u0004\u0018\u00018\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b&\u0010\"J\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\"J\u000f\u0010)\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b)\u0010*J\u0012\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0007J\u0016\u00100\u001a\u00020\u00142\u000e\u0010,\u001a\n\u0018\u00010.j\u0004\u0018\u0001`/J\u0019\u00101\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0004\b1\u00102J\u0010\u00104\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0006H\u0014J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0086\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0004J\u0010\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000109H\u0014J\b\u0010;\u001a\u00020\u0014H\u0014J\b\u0010<\u001a\u00020\u0014H\u0014R\u0014\u0010?\u001a\u00020\u00068$X¤\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u00068$X¤\u0004¢\u0006\u0006\u001a\u0004\b@\u0010>R\u0014\u0010C\u001a\u00020\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bB\u0010>R\u0014\u0010E\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010>R\u0014\u0010F\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010>R\u0014\u0010H\u001a\u00020\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bG\u0010>R\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000I8F¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0019\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000I8F¢\u0006\u0006\u001a\u0004\bM\u0010KR \u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'0I8Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\bO\u0010K\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006["}, m12616d2 = {"Lkotlinx/coroutines/channels/a;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/c;", "Lkotlinx/coroutines/channels/n;", "Lkotlinx/coroutines/channels/c0;", "receive", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", CommonNetImpl.RESULT, "h0", "(Ljava/lang/Object;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/f;", "select", "", "receiveMode", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "block", "Lkotlin/f1;", "j0", "(Lkotlinx/coroutines/selects/f;ILl1/p;)V", DomainCampaignEx.LOOPBACK_VALUE, "l0", "(Ll1/p;Lkotlinx/coroutines/selects/f;ILjava/lang/Object;)V", "X", "(Lkotlinx/coroutines/selects/f;Ll1/p;I)Z", "Lkotlinx/coroutines/o;", "cont", "k0", "f0", "g0", "K", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "i0", "(ILkotlin/coroutines/c;)Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "H", "Lkotlinx/coroutines/channels/m0;", "B", "poll", "()Ljava/lang/Object;", "", "cause", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Throwable;)Z", "wasClosed", "c0", "Lkotlinx/coroutines/channels/p;", "iterator", "Lkotlinx/coroutines/channels/a$g;", "U", "Lkotlinx/coroutines/channels/e0;", "J", "e0", "d0", "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "Y", "hasReceiveOrClosed", "h", "isClosedForReceive", "isEmpty", "b0", "isEmptyImpl", "Lkotlinx/coroutines/selects/d;", "F", "()Lkotlinx/coroutines/selects/d;", "onReceive", "G", "onReceiveOrNull", "M", "onReceiveOrClosed", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ll1/l;)V", "c", "d", "e", "f", "g", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractChannel<E> extends AbstractC14687c<E> implements InterfaceC14722n<E> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0013\u0010\u0007\u001a\u00020\u0005H\u0096Bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m12616d2 = {"Lkotlinx/coroutines/channels/a$a;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/p;", "", CommonNetImpl.RESULT, "", "d", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "e", "next", "()Ljava/lang/Object;", "a", "Ljava/lang/Object;", "c", "setResult", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/a;", "Lkotlinx/coroutines/channels/a;", "channel", "<init>", "(Lkotlinx/coroutines/channels/a;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C14673a<E> implements InterfaceC14725p<E> {
        @Nullable

        /* renamed from: a */
        private Object f42025a = C14685b.f42054g;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: b */
        public final AbstractChannel<E> f42026b;

        public C14673a(@NotNull AbstractChannel<E> abstractChannel) {
            this.f42026b = abstractChannel;
        }

        /* renamed from: d */
        private final boolean m5514d(Object obj) {
            if (obj instanceof C14731t) {
                C14731t c14731t = (C14731t) obj;
                if (c14731t.f42143d == null) {
                    return false;
                }
                throw StackTraceRecovery.m4316p(c14731t.m5203m0());
            }
            return true;
        }

        @Override // kotlinx.coroutines.channels.InterfaceC14725p
        @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        @Nullable
        /* renamed from: a */
        public /* synthetic */ Object mo5388a(@NotNull InterfaceC14268c<? super E> interfaceC14268c) {
            return InterfaceC14725p.C14726a.m5386a(this, interfaceC14268c);
        }

        @Override // kotlinx.coroutines.channels.InterfaceC14725p
        @Nullable
        /* renamed from: b */
        public Object mo5387b(@NotNull InterfaceC14268c<? super Boolean> interfaceC14268c) {
            Object obj = this.f42025a;
            Symbol symbol = C14685b.f42054g;
            if (obj != symbol) {
                return boxing.m8631a(m5514d(obj));
            }
            Object mo5182f0 = this.f42026b.mo5182f0();
            this.f42025a = mo5182f0;
            if (mo5182f0 != symbol) {
                return boxing.m8631a(m5514d(mo5182f0));
            }
            return m5513e(interfaceC14268c);
        }

        @Nullable
        /* renamed from: c */
        public final Object m5515c() {
            return this.f42025a;
        }

        @Nullable
        /* renamed from: e */
        final /* synthetic */ Object m5513e(@NotNull InterfaceC14268c<? super Boolean> interfaceC14268c) {
            InterfaceC14268c m8650d;
            Object m8642h;
            m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
            C15153p m3852b = C15161r.m3852b(m8650d);
            C14676d c14676d = new C14676d(this, m3852b);
            while (true) {
                if (this.f42026b.m5526V(c14676d)) {
                    this.f42026b.m5517k0(m3852b, c14676d);
                    break;
                }
                Object mo5182f0 = this.f42026b.mo5182f0();
                setResult(mo5182f0);
                if (mo5182f0 instanceof C14731t) {
                    C14731t c14731t = (C14731t) mo5182f0;
                    if (c14731t.f42143d == null) {
                        Boolean m8631a = boxing.m8631a(false);
                        Result.C14124a c14124a = Result.Companion;
                        m3852b.resumeWith(Result.m60148constructorimpl(m8631a));
                    } else {
                        Throwable m5203m0 = c14731t.m5203m0();
                        Result.C14124a c14124a2 = Result.Companion;
                        m3852b.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(m5203m0)));
                    }
                } else if (mo5182f0 != C14685b.f42054g) {
                    Boolean m8631a2 = boxing.m8631a(true);
                    InterfaceC15280l<E, Unit> interfaceC15280l = this.f42026b.f42059b;
                    m3852b.mo3882z(m8631a2, interfaceC15280l != null ? C15070b0.m4380a(interfaceC15280l, mo5182f0, m3852b.getContext()) : null);
                }
            }
            Object m3883y = m3852b.m3883y();
            m8642h = C14287b.m8642h();
            if (m3883y == m8642h) {
                DebugProbes.m8616c(interfaceC14268c);
            }
            return m3883y;
        }

        @Override // kotlinx.coroutines.channels.InterfaceC14725p
        public E next() {
            E e = (E) this.f42025a;
            if (!(e instanceof C14731t)) {
                Symbol symbol = C14685b.f42054g;
                if (e != symbol) {
                    this.f42025a = symbol;
                    return e;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw StackTraceRecovery.m4316p(((C14731t) e).m5203m0());
        }

        public final void setResult(@Nullable Object obj) {
            this.f42025a = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\u0012\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0011\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, m12616d2 = {"Lkotlinx/coroutines/channels/a$b;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/c0;", DomainCampaignEx.LOOPBACK_VALUE, "", "i0", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "v", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/s$d;)Lkotlinx/coroutines/internal/j0;", "Lkotlin/f1;", "j", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/t;", "closed", "h0", "", "toString", "Lkotlinx/coroutines/o;", "d", "Lkotlinx/coroutines/o;", "cont", "", "e", "I", "receiveMode", "<init>", "(Lkotlinx/coroutines/o;I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C14674b<E> extends AbstractC14694c0<E> {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: d */
        public final InterfaceC15146o<Object> f42027d;
        @JvmPlatformAnnotations

        /* renamed from: e */
        public final int f42028e;

        public C14674b(@NotNull InterfaceC15146o<Object> interfaceC15146o, int i) {
            this.f42027d = interfaceC15146o;
            this.f42028e = i;
        }

        @Override // kotlinx.coroutines.channels.AbstractC14694c0
        /* renamed from: h0 */
        public void mo5476h0(@NotNull C14731t<?> c14731t) {
            int i = this.f42028e;
            if (i == 1 && c14731t.f42143d == null) {
                InterfaceC15146o<Object> interfaceC15146o = this.f42027d;
                Result.C14124a c14124a = Result.Companion;
                interfaceC15146o.resumeWith(Result.m60148constructorimpl(null));
            } else if (i == 2) {
                InterfaceC15146o<Object> interfaceC15146o2 = this.f42027d;
                C14719m0.C14721b c14721b = C14719m0.f42114b;
                C14719m0 m5418a = C14719m0.m5418a(C14719m0.m5417b(new C14719m0.C14720a(c14731t.f42143d)));
                Result.C14124a c14124a2 = Result.Companion;
                interfaceC15146o2.resumeWith(Result.m60148constructorimpl(m5418a));
            } else {
                InterfaceC15146o<Object> interfaceC15146o3 = this.f42027d;
                Throwable m5203m0 = c14731t.m5203m0();
                Result.C14124a c14124a3 = Result.Companion;
                interfaceC15146o3.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(m5203m0)));
            }
        }

        @Nullable
        /* renamed from: i0 */
        public final Object m5512i0(E e) {
            if (this.f42028e != 2) {
                return e;
            }
            C14719m0.C14721b c14721b = C14719m0.f42114b;
            return C14719m0.m5418a(C14719m0.m5417b(e));
        }

        @Override // kotlinx.coroutines.channels.InterfaceC14698e0
        /* renamed from: j */
        public void mo5206j(E e) {
            this.f42027d.mo3906T(C15157q.f43218d);
        }

        @Override // kotlinx.coroutines.internal.C15094s
        @NotNull
        public String toString() {
            return "ReceiveElement@" + DebugStrings.m3553b(this) + "[receiveMode=" + this.f42028e + ']';
        }

        @Override // kotlinx.coroutines.channels.InterfaceC14698e0
        @Nullable
        /* renamed from: v */
        public Symbol mo5201v(E e, @Nullable C15094s.C15098d c15098d) {
            if (this.f42027d.mo3911N(m5512i0(e), c15098d != null ? c15098d.f43093c : null, mo5477g0(e)) != null) {
                if (c15098d != null) {
                    c15098d.m4199d();
                }
                return C15157q.f43218d;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B=\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u0012"}, m12616d2 = {"Lkotlinx/coroutines/channels/a$c;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/a$b;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/Function1;", "", "Lkotlin/f1;", "g0", "(Ljava/lang/Object;)Ll1/l;", "Lkotlinx/coroutines/o;", "", "cont", "", "receiveMode", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlinx/coroutines/o;ILl1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14675c<E> extends C14674b<E> {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: f */
        public final InterfaceC15280l<E, Unit> f42029f;

        /* JADX WARN: Multi-variable type inference failed */
        public C14675c(@NotNull InterfaceC15146o<Object> interfaceC15146o, int i, @NotNull InterfaceC15280l<? super E, Unit> interfaceC15280l) {
            super(interfaceC15146o, i);
            this.f42029f = interfaceC15280l;
        }

        @Override // kotlinx.coroutines.channels.AbstractC14694c0
        @Nullable
        /* renamed from: g0 */
        public InterfaceC15280l<Throwable, Unit> mo5477g0(E e) {
            return C15070b0.m4380a(this.f42029f, e, this.f42027d.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000e\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, m12616d2 = {"Lkotlinx/coroutines/channels/a$d;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/c0;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "v", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/s$d;)Lkotlinx/coroutines/internal/j0;", "Lkotlin/f1;", "j", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/t;", "closed", "h0", "Lkotlin/Function1;", "", "g0", "(Ljava/lang/Object;)Ll1/l;", "", "toString", "Lkotlinx/coroutines/channels/a$a;", "d", "Lkotlinx/coroutines/channels/a$a;", "iterator", "Lkotlinx/coroutines/o;", "", "e", "Lkotlinx/coroutines/o;", "cont", "<init>", "(Lkotlinx/coroutines/channels/a$a;Lkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C14676d<E> extends AbstractC14694c0<E> {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: d */
        public final C14673a<E> f42030d;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: e */
        public final InterfaceC15146o<Boolean> f42031e;

        /* JADX WARN: Multi-variable type inference failed */
        public C14676d(@NotNull C14673a<E> c14673a, @NotNull InterfaceC15146o<? super Boolean> interfaceC15146o) {
            this.f42030d = c14673a;
            this.f42031e = interfaceC15146o;
        }

        @Override // kotlinx.coroutines.channels.AbstractC14694c0
        @Nullable
        /* renamed from: g0 */
        public InterfaceC15280l<Throwable, Unit> mo5477g0(E e) {
            InterfaceC15280l<E, Unit> interfaceC15280l = this.f42030d.f42026b.f42059b;
            if (interfaceC15280l != null) {
                return C15070b0.m4380a(interfaceC15280l, e, this.f42031e.getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.AbstractC14694c0
        /* renamed from: h0 */
        public void mo5476h0(@NotNull C14731t<?> c14731t) {
            Object mo3892p;
            if (c14731t.f42143d == null) {
                mo3892p = InterfaceC15146o.C15147a.m3944b(this.f42031e, Boolean.FALSE, null, 2, null);
            } else {
                mo3892p = this.f42031e.mo3892p(c14731t.m5203m0());
            }
            if (mo3892p != null) {
                this.f42030d.setResult(c14731t);
                this.f42031e.mo3906T(mo3892p);
            }
        }

        @Override // kotlinx.coroutines.channels.InterfaceC14698e0
        /* renamed from: j */
        public void mo5206j(E e) {
            this.f42030d.setResult(e);
            this.f42031e.mo3906T(C15157q.f43218d);
        }

        @Override // kotlinx.coroutines.internal.C15094s
        @NotNull
        public String toString() {
            return "ReceiveHasNext@" + DebugStrings.m3553b(this);
        }

        @Override // kotlinx.coroutines.channels.InterfaceC14698e0
        @Nullable
        /* renamed from: v */
        public Symbol mo5201v(E e, @Nullable C15094s.C15098d c15098d) {
            if (this.f42031e.mo3911N(Boolean.TRUE, c15098d != null ? c15098d.f43093c : null, mo5477g0(e)) != null) {
                if (c15098d != null) {
                    c15098d.m4199d();
                }
                return C15157q.f43218d;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u00028\u00020\u00032\u00020\u0004BT\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0018\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012$\u0010'\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010&\u0012\u0006\u0012\u0004\u0018\u00010%0$\u0012\u0006\u0010#\u001a\u00020 ø\u0001\u0000¢\u0006\u0004\b(\u0010)J#\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0010\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00188\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, m12616d2 = {"Lkotlinx/coroutines/channels/a$e;", "R", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/c0;", "Lkotlinx/coroutines/i1;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "v", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/s$d;)Lkotlinx/coroutines/internal/j0;", "Lkotlin/f1;", "j", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/t;", "closed", "h0", "dispose", "Lkotlin/Function1;", "", "g0", "(Ljava/lang/Object;)Ll1/l;", "", "toString", "Lkotlinx/coroutines/channels/a;", "d", "Lkotlinx/coroutines/channels/a;", "channel", "Lkotlinx/coroutines/selects/f;", "e", "Lkotlinx/coroutines/selects/f;", "select", "", "g", "I", "receiveMode", "Lkotlin/Function2;", "", "Lkotlin/coroutines/c;", "block", "<init>", "(Lkotlinx/coroutines/channels/a;Lkotlinx/coroutines/selects/f;Ll1/p;I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14677e<R, E> extends AbstractC14694c0<E> implements InterfaceC15064i1 {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: d */
        public final AbstractChannel<E> f42032d;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: e */
        public final InterfaceC15197f<R> f42033e;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: f */
        public final InterfaceC15284p<Object, InterfaceC14268c<? super R>, Object> f42034f;
        @JvmPlatformAnnotations

        /* renamed from: g */
        public final int f42035g;

        /* JADX WARN: Multi-variable type inference failed */
        public C14677e(@NotNull AbstractChannel<E> abstractChannel, @NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15284p<Object, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p, int i) {
            this.f42032d = abstractChannel;
            this.f42033e = interfaceC15197f;
            this.f42034f = interfaceC15284p;
            this.f42035g = i;
        }

        @Override // kotlinx.coroutines.InterfaceC15064i1
        public void dispose() {
            if (mo4211Y()) {
                this.f42032d.m5522d0();
            }
        }

        @Override // kotlinx.coroutines.channels.AbstractC14694c0
        @Nullable
        /* renamed from: g0 */
        public InterfaceC15280l<Throwable, Unit> mo5477g0(E e) {
            InterfaceC15280l<E, Unit> interfaceC15280l = this.f42032d.f42059b;
            if (interfaceC15280l != null) {
                return C15070b0.m4380a(interfaceC15280l, e, this.f42033e.mo3702s().getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.AbstractC14694c0
        /* renamed from: h0 */
        public void mo5476h0(@NotNull C14731t<?> c14731t) {
            if (this.f42033e.mo3703o()) {
                int i = this.f42035g;
                if (i == 0) {
                    this.f42033e.mo3701t(c14731t.m5203m0());
                } else if (i == 1) {
                    if (c14731t.f42143d == null) {
                        C16231a.m226e(this.f42034f, null, this.f42033e.mo3702s(), null, 4, null);
                    } else {
                        this.f42033e.mo3701t(c14731t.m5203m0());
                    }
                } else if (i != 2) {
                } else {
                    InterfaceC15284p<Object, InterfaceC14268c<? super R>, Object> interfaceC15284p = this.f42034f;
                    C14719m0.C14721b c14721b = C14719m0.f42114b;
                    C16231a.m226e(interfaceC15284p, C14719m0.m5418a(C14719m0.m5417b(new C14719m0.C14720a(c14731t.f42143d))), this.f42033e.mo3702s(), null, 4, null);
                }
            }
        }

        @Override // kotlinx.coroutines.channels.InterfaceC14698e0
        /* renamed from: j */
        public void mo5206j(E e) {
            Object obj;
            InterfaceC15284p<Object, InterfaceC14268c<? super R>, Object> interfaceC15284p = this.f42034f;
            if (this.f42035g == 2) {
                C14719m0.C14721b c14721b = C14719m0.f42114b;
                obj = C14719m0.m5418a(C14719m0.m5417b(e));
            } else {
                obj = e;
            }
            C16231a.m227d(interfaceC15284p, obj, this.f42033e.mo3702s(), mo5477g0(e));
        }

        @Override // kotlinx.coroutines.internal.C15094s
        @NotNull
        public String toString() {
            return "ReceiveSelect@" + DebugStrings.m3553b(this) + '[' + this.f42033e + ",receiveMode=" + this.f42035g + ']';
        }

        @Override // kotlinx.coroutines.channels.InterfaceC14698e0
        @Nullable
        /* renamed from: v */
        public Symbol mo5201v(E e, @Nullable C15094s.C15098d c15098d) {
            return (Symbol) this.f42033e.mo3704l(c15098d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/channels/a$f;", "Lkotlinx/coroutines/e;", "", "cause", "Lkotlin/f1;", "a", "", "toString", "Lkotlinx/coroutines/channels/c0;", "Lkotlinx/coroutines/channels/c0;", "receive", "<init>", "(Lkotlinx/coroutines/channels/a;Lkotlinx/coroutines/channels/c0;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C14678f extends AbstractC14773e {

        /* renamed from: a */
        private final AbstractC14694c0<?> f42036a;

        public C14678f(@NotNull AbstractC14694c0<?> abstractC14694c0) {
            this.f42036a = abstractC14694c0;
        }

        @Override // kotlinx.coroutines.AbstractC15136n
        /* renamed from: a */
        public void mo3521a(@Nullable Throwable th) {
            if (this.f42036a.mo4211Y()) {
                AbstractChannel.this.m5522d0();
            }
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            mo3521a(th);
            return Unit.f41048a;
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f42036a + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, m12616d2 = {"Lkotlinx/coroutines/channels/a$g;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/s$e;", "Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/s;", "affected", "", "e", "Lkotlinx/coroutines/internal/s$d;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "j", "Lkotlin/f1;", "k", "Lkotlinx/coroutines/internal/q;", "queue", "<init>", "(Lkotlinx/coroutines/internal/q;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14679g<E> extends C15094s.C15099e<AbstractC14702g0> {
        public C14679g(@NotNull C15091q c15091q) {
            super(c15091q);
        }

        @Override // kotlinx.coroutines.internal.C15094s.C15099e, kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: e */
        protected Object mo4198e(@NotNull C15094s c15094s) {
            if (c15094s instanceof C14731t) {
                return c15094s;
            }
            if (c15094s instanceof AbstractC14702g0) {
                return null;
            }
            return C14685b.f42054g;
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: j */
        public Object mo4202j(@NotNull C15094s.C15098d c15098d) {
            C15094s c15094s = c15098d.f43091a;
            if (c15094s != null) {
                Symbol mo5207i0 = ((AbstractC14702g0) c15094s).mo5207i0(c15098d);
                if (mo5207i0 != null) {
                    Object obj = C15072c.f43034b;
                    if (mo5207i0 == obj) {
                        return obj;
                    }
                    return null;
                }
                return C15101t.f43100a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        /* renamed from: k */
        public void mo4201k(@NotNull C15094s c15094s) {
            if (c15094s == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
            }
            ((AbstractC14702g0) c15094s).mo5433j0();
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/internal/s$f", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14680h extends C15094s.AbstractC15097c {

        /* renamed from: d */
        final /* synthetic */ C15094s f42038d;

        /* renamed from: e */
        final /* synthetic */ AbstractChannel f42039e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14680h(C15094s c15094s, C15094s c15094s2, AbstractChannel abstractChannel) {
            super(c15094s2);
            this.f42038d = c15094s;
            this.f42039e = abstractChannel;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        @Nullable
        /* renamed from: k */
        public Object mo3615i(@NotNull C15094s c15094s) {
            if (this.f42039e.mo5173a0()) {
                return null;
            }
            return C15093r.m4240a();
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JJ\u0010\n\u001a\u00020\t\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m12616d2 = {"kotlinx/coroutines/channels/a$i", "Lkotlinx/coroutines/selects/d;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "k", "(Lkotlinx/coroutines/selects/f;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14681i implements InterfaceC15195d<E> {
        C14681i() {
        }

        @Override // kotlinx.coroutines.selects.InterfaceC15195d
        /* renamed from: k */
        public <R> void mo3491k(@NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15284p<? super E, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
            AbstractChannel abstractChannel = AbstractChannel.this;
            if (interfaceC15284p == null) {
                throw new NullPointerException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            }
            abstractChannel.m5518j0(interfaceC15197f, 0, interfaceC15284p);
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JS\u0010\u000b\u001a\u00020\n\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m12616d2 = {"kotlinx/coroutines/channels/a$j", "Lkotlinx/coroutines/selects/d;", "Lkotlinx/coroutines/channels/m0;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "k", "(Lkotlinx/coroutines/selects/f;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14682j implements InterfaceC15195d<C14719m0<? extends E>> {
        C14682j() {
        }

        @Override // kotlinx.coroutines.selects.InterfaceC15195d
        /* renamed from: k */
        public <R> void mo3491k(@NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15284p<? super C14719m0<? extends E>, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
            AbstractChannel abstractChannel = AbstractChannel.this;
            if (interfaceC15284p == null) {
                throw new NullPointerException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            }
            abstractChannel.m5518j0(interfaceC15197f, 2, interfaceC15284p);
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001JL\u0010\n\u001a\u00020\t\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032$\u0010\b\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m12616d2 = {"kotlinx/coroutines/channels/a$k", "Lkotlinx/coroutines/selects/d;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "k", "(Lkotlinx/coroutines/selects/f;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$k */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14683k implements InterfaceC15195d<E> {
        C14683k() {
        }

        @Override // kotlinx.coroutines.selects.InterfaceC15195d
        /* renamed from: k */
        public <R> void mo3491k(@NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15284p<? super E, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
            AbstractChannel abstractChannel = AbstractChannel.this;
            if (interfaceC15284p == null) {
                throw new NullPointerException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            }
            abstractChannel.m5518j0(interfaceC15197f, 1, interfaceC15284p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u0086@"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/c;", "Lkotlinx/coroutines/channels/m0;", "continuation", "", "receiveOrClosed"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.channels.AbstractChannel", m8638f = "AbstractChannel.kt", m8637i = {0, 0}, m8636l = {624}, m8635m = "receiveOrClosed-ZYPwvRU", m8634n = {"this", CommonNetImpl.RESULT}, m8633s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.channels.a$l */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14684l extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42043a;

        /* renamed from: b */
        int f42044b;

        /* renamed from: d */
        Object f42046d;

        /* renamed from: e */
        Object f42047e;

        C14684l(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42043a = obj;
            this.f42044b |= Integer.MIN_VALUE;
            return AbstractChannel.this.mo5400B(this);
        }
    }

    public AbstractChannel(@Nullable InterfaceC15280l<? super E, Unit> interfaceC15280l) {
        super(interfaceC15280l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public final boolean m5526V(AbstractC14694c0<? super E> abstractC14694c0) {
        boolean mo5184W = mo5184W(abstractC14694c0);
        if (mo5184W) {
            m5521e0();
        }
        return mo5184W;
    }

    /* renamed from: X */
    private final <R> boolean m5525X(InterfaceC15197f<? super R> interfaceC15197f, InterfaceC15284p<Object, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p, int i) {
        C14677e c14677e = new C14677e(this, interfaceC15197f, interfaceC15284p, i);
        boolean m5526V = m5526V(c14677e);
        if (m5526V) {
            interfaceC15197f.mo3705k(c14677e);
        }
        return m5526V;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h0 */
    private final E m5520h0(Object obj) {
        if (obj instanceof C14731t) {
            Throwable th = ((C14731t) obj).f42143d;
            if (th == null) {
                return null;
            }
            throw StackTraceRecovery.m4316p(th);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public final <R> void m5518j0(InterfaceC15197f<? super R> interfaceC15197f, int i, InterfaceC15284p<Object, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        while (!interfaceC15197f.mo3706i()) {
            if (m5523b0()) {
                if (m5525X(interfaceC15197f, interfaceC15284p, i)) {
                    return;
                }
            } else {
                Object mo5181g0 = mo5181g0(interfaceC15197f);
                if (mo5181g0 == C15198g.m3696d()) {
                    return;
                }
                if (mo5181g0 != C14685b.f42054g && mo5181g0 != C15072c.f43034b) {
                    m5516l0(interfaceC15284p, interfaceC15197f, i, mo5181g0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public final void m5517k0(InterfaceC15146o<?> interfaceC15146o, AbstractC14694c0<?> abstractC14694c0) {
        interfaceC15146o.mo3902e(new C14678f(abstractC14694c0));
    }

    /* renamed from: l0 */
    private final <R> void m5516l0(InterfaceC15284p<Object, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p, InterfaceC15197f<? super R> interfaceC15197f, int i, Object obj) {
        Object m5417b;
        boolean z = obj instanceof C14731t;
        if (!z) {
            if (i == 2) {
                C14719m0.C14721b c14721b = C14719m0.f42114b;
                if (z) {
                    m5417b = C14719m0.m5417b(new C14719m0.C14720a(((C14731t) obj).f42143d));
                } else {
                    m5417b = C14719m0.m5417b(obj);
                }
                Undispatched.m222d(interfaceC15284p, C14719m0.m5418a(m5417b), interfaceC15197f.mo3702s());
                return;
            }
            Undispatched.m222d(interfaceC15284p, obj, interfaceC15197f.mo3702s());
        } else if (i == 0) {
            throw StackTraceRecovery.m4316p(((C14731t) obj).m5203m0());
        } else {
            if (i != 1) {
                if (i == 2 && interfaceC15197f.mo3703o()) {
                    C14719m0.C14721b c14721b2 = C14719m0.f42114b;
                    Undispatched.m222d(interfaceC15284p, C14719m0.m5418a(C14719m0.m5417b(new C14719m0.C14720a(((C14731t) obj).f42143d))), interfaceC15197f.mo3702s());
                    return;
                }
                return;
            }
            C14731t c14731t = (C14731t) obj;
            if (c14731t.f42143d == null) {
                if (interfaceC15197f.mo3703o()) {
                    Undispatched.m222d(interfaceC15284p, null, interfaceC15197f.mo3702s());
                    return;
                }
                return;
            }
            throw StackTraceRecovery.m4316p(c14731t.m5203m0());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @org.jetbrains.annotations.Nullable
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo5400B(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlinx.coroutines.channels.C14719m0<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel.C14684l
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.a$l r0 = (kotlinx.coroutines.channels.AbstractChannel.C14684l) r0
            int r1 = r0.f42044b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42044b = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.a$l r0 = new kotlinx.coroutines.channels.a$l
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f42043a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42044b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f42046d
            kotlinx.coroutines.channels.a r0 = (kotlinx.coroutines.channels.AbstractChannel) r0
            kotlin.C14294d0.m8596n(r5)
            goto L69
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.C14294d0.m8596n(r5)
            java.lang.Object r5 = r4.mo5182f0()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.channels.C14685b.f42054g
            if (r5 == r2) goto L5b
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.C14731t
            if (r0 == 0) goto L54
            kotlinx.coroutines.channels.m0$b r0 = kotlinx.coroutines.channels.C14719m0.f42114b
            kotlinx.coroutines.channels.t r5 = (kotlinx.coroutines.channels.C14731t) r5
            java.lang.Throwable r5 = r5.f42143d
            kotlinx.coroutines.channels.m0$a r0 = new kotlinx.coroutines.channels.m0$a
            r0.<init>(r5)
            java.lang.Object r5 = kotlinx.coroutines.channels.C14719m0.m5417b(r0)
            goto L5a
        L54:
            kotlinx.coroutines.channels.m0$b r0 = kotlinx.coroutines.channels.C14719m0.f42114b
            java.lang.Object r5 = kotlinx.coroutines.channels.C14719m0.m5417b(r5)
        L5a:
            return r5
        L5b:
            r2 = 2
            r0.f42046d = r4
            r0.f42047e = r5
            r0.f42044b = r3
            java.lang.Object r5 = r4.m5519i0(r2, r0)
            if (r5 != r1) goto L69
            return r1
        L69:
            kotlinx.coroutines.channels.m0 r5 = (kotlinx.coroutines.channels.C14719m0) r5
            java.lang.Object r5 = r5.m5405n()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.mo5400B(kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @NotNull
    /* renamed from: F */
    public final InterfaceC15195d<E> mo5399F() {
        return new C14681i();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @NotNull
    /* renamed from: G */
    public final InterfaceC15195d<E> mo5398G() {
        return new C14683k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @Nullable
    /* renamed from: H */
    public final Object mo5397H(@NotNull InterfaceC14268c<? super E> interfaceC14268c) {
        Object mo5182f0 = mo5182f0();
        return (mo5182f0 == C14685b.f42054g || (mo5182f0 instanceof C14731t)) ? m5519i0(1, interfaceC14268c) : mo5182f0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @Nullable
    /* renamed from: J */
    public InterfaceC14698e0<E> mo5495J() {
        InterfaceC14698e0<E> mo5495J = super.mo5495J();
        if (mo5495J != null && !(mo5495J instanceof C14731t)) {
            m5522d0();
        }
        return mo5495J;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @Nullable
    /* renamed from: K */
    public final Object mo5396K(@NotNull InterfaceC14268c<? super E> interfaceC14268c) {
        Object mo5182f0 = mo5182f0();
        return (mo5182f0 == C14685b.f42054g || (mo5182f0 instanceof C14731t)) ? m5519i0(0, interfaceC14268c) : mo5182f0;
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @NotNull
    /* renamed from: M */
    public final InterfaceC15195d<C14719m0<E>> mo5395M() {
        return new C14682j();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    /* renamed from: T */
    public final boolean mo5475a(@Nullable Throwable th) {
        boolean mo5178L = mo5178L(th);
        mo5183c0(mo5178L);
        return mo5178L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: U */
    public final C14679g<E> m5527U() {
        return new C14679g<>(m5486m());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: W */
    public boolean mo5184W(@NotNull AbstractC14694c0<? super E> abstractC14694c0) {
        int m4206d0;
        C15094s m4217R;
        if (mo5174Z()) {
            C15094s m5486m = m5486m();
            do {
                m4217R = m5486m.m4217R();
                if (!(!(m4217R instanceof AbstractC14702g0))) {
                    return false;
                }
            } while (!m4217R.m4226F(abstractC14694c0, m5486m));
        } else {
            C15094s m5486m2 = m5486m();
            C14680h c14680h = new C14680h(abstractC14694c0, abstractC14694c0, this);
            do {
                C15094s m4217R2 = m5486m2.m4217R();
                if (!(!(m4217R2 instanceof AbstractC14702g0))) {
                    return false;
                }
                m4206d0 = m4217R2.m4206d0(abstractC14694c0, m5486m2, c14680h);
                if (m4206d0 != 1) {
                }
            } while (m4206d0 != 2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Y */
    public final boolean m5524Y() {
        return m5486m().m4218Q() instanceof InterfaceC14698e0;
    }

    /* renamed from: Z */
    protected abstract boolean mo5174Z();

    /* renamed from: a0 */
    protected abstract boolean mo5173a0();

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    /* renamed from: b */
    public final void mo5474b(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(DebugStrings.m3554a(this) + " was cancelled");
        }
        mo5475a(cancellationException);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b0 */
    public final boolean m5523b0() {
        return !(m5486m().m4218Q() instanceof AbstractC14702g0) && mo5173a0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c0 */
    public void mo5183c0(boolean z) {
        C14731t<?> m5487l = m5487l();
        if (m5487l != null) {
            Object m4269c = InlineList.m4269c(null, 1, null);
            while (true) {
                C15094s m4217R = m5487l.m4217R();
                if (m4217R instanceof C15091q) {
                    break;
                } else if (!m4217R.mo4211Y()) {
                    m4217R.m4216S();
                } else {
                    m4269c = InlineList.m4264h(m4269c, (AbstractC14702g0) m4217R);
                }
            }
            if (m4269c == null) {
                return;
            }
            if (!(m4269c instanceof ArrayList)) {
                ((AbstractC14702g0) m4269c).mo5208h0(m5487l);
                return;
            }
            ArrayList arrayList = (ArrayList) m4269c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((AbstractC14702g0) arrayList.get(size)).mo5208h0(m5487l);
            }
            return;
        }
        throw new IllegalStateException("Cannot happen".toString());
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        mo5474b(null);
    }

    /* renamed from: d0 */
    protected void m5522d0() {
    }

    /* renamed from: e0 */
    protected void m5521e0() {
    }

    @Nullable
    /* renamed from: f0 */
    protected Object mo5182f0() {
        while (true) {
            AbstractC14702g0 m5494N = m5494N();
            if (m5494N != null) {
                if (m5494N.mo5207i0(null) != null) {
                    m5494N.mo5210f0();
                    return m5494N.mo5209g0();
                }
                m5494N.mo5433j0();
            } else {
                return C14685b.f42054g;
            }
        }
    }

    @Nullable
    /* renamed from: g0 */
    protected Object mo5181g0(@NotNull InterfaceC15197f<?> interfaceC15197f) {
        C14679g<E> m5527U = m5527U();
        Object mo3700u = interfaceC15197f.mo3700u(m5527U);
        if (mo3700u != null) {
            return mo3700u;
        }
        m5527U.m4190o().mo5210f0();
        return m5527U.m4190o().mo5209g0();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    /* renamed from: h */
    public boolean mo5394h() {
        return m5488k() != null && mo5173a0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.a$b] */
    @Nullable
    /* renamed from: i0 */
    final /* synthetic */ <R> Object m5519i0(int i, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        InterfaceC14268c m8650d;
        C14675c c14675c;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p m3852b = C15161r.m3852b(m8650d);
        if (this.f42059b == null) {
            if (m3852b == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
            }
            c14675c = new C14674b(m3852b, i);
        } else if (m3852b != null) {
            c14675c = new C14675c(m3852b, i, this.f42059b);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
        }
        while (true) {
            if (m5526V(c14675c)) {
                m5517k0(m3852b, c14675c);
                break;
            }
            Object mo5182f0 = mo5182f0();
            if (mo5182f0 instanceof C14731t) {
                c14675c.mo5476h0((C14731t) mo5182f0);
                break;
            } else if (mo5182f0 != C14685b.f42054g) {
                m3852b.mo3882z(c14675c.m5512i0(mo5182f0), c14675c.mo5477g0(mo5182f0));
                break;
            }
        }
        Object m3883y = m3852b.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    public boolean isEmpty() {
        return m5523b0();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @NotNull
    public final InterfaceC14725p<E> iterator() {
        return new C14673a(this);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14695d0
    @Nullable
    public final E poll() {
        Object mo5182f0 = mo5182f0();
        if (mo5182f0 == C14685b.f42054g) {
            return null;
        }
        return m5520h0(mo5182f0);
    }
}
