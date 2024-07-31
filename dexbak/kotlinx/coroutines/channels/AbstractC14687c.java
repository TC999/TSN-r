package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.channel.C13675a;
import io.netty.handler.codec.http.HttpConstants;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.C14294d0;
import kotlin.C14305i;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.C15157q;
import kotlinx.coroutines.C15161r;
import kotlinx.coroutines.DebugStrings;
import kotlinx.coroutines.InterfaceC15064i1;
import kotlinx.coroutines.internal.C15070b0;
import kotlinx.coroutines.internal.C15072c;
import kotlinx.coroutines.internal.C15091q;
import kotlinx.coroutines.internal.C15093r;
import kotlinx.coroutines.internal.C15094s;
import kotlinx.coroutines.internal.C15101t;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import kotlinx.coroutines.internal.StackTraceRecovery;
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

/* compiled from: AbstractChannel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004FfghB)\u0012 \u0010d\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u000105j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`c¢\u0006\u0004\be\u00109J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\n2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011JX\u0010\u0018\u001a\u00020\n\"\u0004\b\u0001\u0010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u0003\u001a\u00028\u00002(\u0010\u0017\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0014¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010\"\u001a\u0004\u0018\u00010!H\u0004¢\u0006\u0004\b\"\u0010#J\u001d\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010$2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0001\u0010%J#\u0010(\u001a\u000e\u0012\u0002\b\u00030&j\u0006\u0012\u0002\b\u0003`'2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b/\u0010+J\u0019\u00101\u001a\u0004\u0018\u00010\u00162\u0006\u00100\u001a\u00020!H\u0014¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u00020,2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b3\u00104J)\u00108\u001a\u00020\n2\u0018\u00107\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\n05j\u0002`6H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020:H\u0014¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$H\u0014¢\u0006\u0004\b=\u0010>J\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DR\u001a\u0010J\u001a\u00020E8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020B8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010DR\u0014\u0010O\u001a\u00020,8$X¤\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010Q\u001a\u00020,8$X¤\u0004¢\u0006\u0006\u001a\u0004\bP\u0010NR\u001a\u0010T\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u001a\u0010V\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bU\u0010SR\u0011\u0010X\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\bW\u0010NR\u0014\u0010Z\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010NR\u0014\u0010\\\u001a\u00020,8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b[\u0010NR#\u0010`\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020]8F¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0014\u0010b\u001a\u00020B8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\ba\u0010D\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006i"}, m12616d2 = {"Lkotlinx/coroutines/channels/c;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/h0;", "element", "Lkotlinx/coroutines/channels/t;", "closed", "", "p", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/t;)Ljava/lang/Throwable;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "r", "(Lkotlin/coroutines/c;Ljava/lang/Object;Lkotlinx/coroutines/channels/t;)V", "cause", UMCommonContent.f37782aL, "(Ljava/lang/Throwable;)V", "o", "(Lkotlinx/coroutines/channels/t;)V", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "", "block", "D", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ll1/p;)V", "", "e", "()I", "y", "(Ljava/lang/Object;)Ljava/lang/Object;", UMCommonContent.f37777aG, "(Ljava/lang/Object;Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/g0;", "N", "()Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/channels/e0;", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/e0;", "Lkotlinx/coroutines/internal/s$b;", "Lkotlinx/coroutines/internal/AddLastDesc;", "f", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/s$b;", "P", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "offer", "(Ljava/lang/Object;)Z", "I", "send", "i", "(Lkotlinx/coroutines/channels/g0;)Ljava/lang/Object;", "L", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "C", "(Ll1/l;)V", "Lkotlinx/coroutines/internal/s;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/coroutines/internal/s;)V", "J", "()Lkotlinx/coroutines/channels/e0;", "Lkotlinx/coroutines/channels/c$d;", "g", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/c$d;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/q;", "a", "Lkotlinx/coroutines/internal/q;", "m", "()Lkotlinx/coroutines/internal/q;", "queue", "n", "queueDebugStateString", "u", "()Z", "isBufferAlwaysFull", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", C7304t.f25048d, "()Lkotlinx/coroutines/channels/t;", "closedForSend", "k", "closedForReceive", "Q", "isClosedForSend", CampaignEx.JSON_KEY_AD_Q, "isFull", "x", "isFullImpl", "Lkotlinx/coroutines/selects/e;", "s", "()Lkotlinx/coroutines/selects/e;", "onSend", "j", "bufferDebugString", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "b", "c", "d", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14687c<E> implements InterfaceC14704h0<E> {

    /* renamed from: c */
    private static final AtomicReferenceFieldUpdater f42057c = AtomicReferenceFieldUpdater.newUpdater(AbstractC14687c.class, Object.class, "onCloseHandler");
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: b */
    protected final InterfaceC15280l<E, Unit> f42059b;
    @NotNull

    /* renamed from: a */
    private final C15091q f42058a = new C15091q();
    private volatile Object onCloseHandler = null;

    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, m12616d2 = {"Lkotlinx/coroutines/channels/c$a;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "i0", "Lkotlin/f1;", "f0", "Lkotlinx/coroutines/channels/t;", "closed", "h0", "", "toString", "d", "Ljava/lang/Object;", "element", "", "g0", "()Ljava/lang/Object;", "pollResult", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14688a<E> extends AbstractC14702g0 {
        @JvmPlatformAnnotations

        /* renamed from: d */
        public final E f42060d;

        public C14688a(E e) {
            this.f42060d = e;
        }

        @Override // kotlinx.coroutines.channels.AbstractC14702g0
        /* renamed from: f0 */
        public void mo5210f0() {
        }

        @Override // kotlinx.coroutines.channels.AbstractC14702g0
        @Nullable
        /* renamed from: g0 */
        public Object mo5209g0() {
            return this.f42060d;
        }

        @Override // kotlinx.coroutines.channels.AbstractC14702g0
        /* renamed from: h0 */
        public void mo5208h0(@NotNull C14731t<?> c14731t) {
        }

        @Override // kotlinx.coroutines.channels.AbstractC14702g0
        @Nullable
        /* renamed from: i0 */
        public Symbol mo5207i0(@Nullable C15094s.C15098d c15098d) {
            Symbol symbol = C15157q.f43218d;
            if (c15098d != null) {
                c15098d.m4199d();
            }
            return symbol;
        }

        @Override // kotlinx.coroutines.internal.C15094s
        @NotNull
        public String toString() {
            return "SendBuffered@" + DebugStrings.m3553b(this) + '(' + this.f42060d + ')';
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¨\u0006\u000e"}, m12616d2 = {"Lkotlinx/coroutines/channels/c$b;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/s$b;", "Lkotlinx/coroutines/channels/c$a;", "Lkotlinx/coroutines/internal/AddLastDesc;", "Lkotlinx/coroutines/internal/s;", "affected", "", "e", "Lkotlinx/coroutines/internal/q;", "queue", "element", "<init>", "(Lkotlinx/coroutines/internal/q;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static class C14689b<E> extends C15094s.C15096b<C14688a<? extends E>> {
        public C14689b(@NotNull C15091q c15091q, E e) {
            super(c15091q, new C14688a(e));
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: e */
        protected Object mo4198e(@NotNull C15094s c15094s) {
            if (c15094s instanceof C14731t) {
                return c15094s;
            }
            if (c15094s instanceof InterfaceC14698e0) {
                return C14685b.f42053f;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BX\u0012\u0006\u0010\u0016\u001a\u00028\u0001\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b\u0012(\u0010#\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001fø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0016\u001a\u00028\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00178\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, m12616d2 = {"Lkotlinx/coroutines/channels/c$c;", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "i0", "Lkotlin/f1;", "f0", "dispose", "Lkotlinx/coroutines/channels/t;", "closed", "h0", "j0", "", "toString", "d", "Ljava/lang/Object;", "g0", "()Ljava/lang/Object;", "pollResult", "Lkotlinx/coroutines/channels/c;", "e", "Lkotlinx/coroutines/channels/c;", "channel", "Lkotlinx/coroutines/selects/f;", "f", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/coroutines/c;", "", "block", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/c;Lkotlinx/coroutines/selects/f;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.c$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14690c<E, R> extends AbstractC14702g0 implements InterfaceC15064i1 {

        /* renamed from: d */
        private final E f42061d;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: e */
        public final AbstractC14687c<E> f42062e;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: f */
        public final InterfaceC15197f<R> f42063f;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: g */
        public final InterfaceC15284p<InterfaceC14704h0<? super E>, InterfaceC14268c<? super R>, Object> f42064g;

        /* JADX WARN: Multi-variable type inference failed */
        public C14690c(E e, @NotNull AbstractC14687c<E> abstractC14687c, @NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15284p<? super InterfaceC14704h0<? super E>, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
            this.f42061d = e;
            this.f42062e = abstractC14687c;
            this.f42063f = interfaceC15197f;
            this.f42064g = interfaceC15284p;
        }

        @Override // kotlinx.coroutines.InterfaceC15064i1
        public void dispose() {
            if (mo4211Y()) {
                mo5433j0();
            }
        }

        @Override // kotlinx.coroutines.channels.AbstractC14702g0
        /* renamed from: f0 */
        public void mo5210f0() {
            C16231a.m226e(this.f42064g, this.f42062e, this.f42063f.mo3702s(), null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.AbstractC14702g0
        /* renamed from: g0 */
        public E mo5209g0() {
            return this.f42061d;
        }

        @Override // kotlinx.coroutines.channels.AbstractC14702g0
        /* renamed from: h0 */
        public void mo5208h0(@NotNull C14731t<?> c14731t) {
            if (this.f42063f.mo3703o()) {
                this.f42063f.mo3701t(c14731t.m5202n0());
            }
        }

        @Override // kotlinx.coroutines.channels.AbstractC14702g0
        @Nullable
        /* renamed from: i0 */
        public Symbol mo5207i0(@Nullable C15094s.C15098d c15098d) {
            return (Symbol) this.f42063f.mo3704l(c15098d);
        }

        @Override // kotlinx.coroutines.channels.AbstractC14702g0
        /* renamed from: j0 */
        public void mo5433j0() {
            InterfaceC15280l<E, Unit> interfaceC15280l = this.f42062e.f42059b;
            if (interfaceC15280l != null) {
                C15070b0.m4379b(interfaceC15280l, mo5209g0(), this.f42063f.mo3702s().getContext());
            }
        }

        @Override // kotlinx.coroutines.internal.C15094s
        @NotNull
        public String toString() {
            return "SendSelect@" + DebugStrings.m3553b(this) + '(' + mo5209g0() + ")[" + this.f42062e + ", " + this.f42063f + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\u000e\u001a\u00028\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016R\u0014\u0010\u000e\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r¨\u0006\u0013"}, m12616d2 = {"Lkotlinx/coroutines/channels/c$d;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/s$e;", "Lkotlinx/coroutines/channels/e0;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/s;", "affected", "", "e", "Lkotlinx/coroutines/internal/s$d;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "j", "Ljava/lang/Object;", "element", "Lkotlinx/coroutines/internal/q;", "queue", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/q;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.c$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14691d<E> extends C15094s.C15099e<InterfaceC14698e0<? super E>> {
        @JvmPlatformAnnotations

        /* renamed from: e */
        public final E f42065e;

        public C14691d(E e, @NotNull C15091q c15091q) {
            super(c15091q);
            this.f42065e = e;
        }

        @Override // kotlinx.coroutines.internal.C15094s.C15099e, kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: e */
        protected Object mo4198e(@NotNull C15094s c15094s) {
            if (c15094s instanceof C14731t) {
                return c15094s;
            }
            if (c15094s instanceof InterfaceC14698e0) {
                return null;
            }
            return C14685b.f42053f;
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: j */
        public Object mo4202j(@NotNull C15094s.C15098d c15098d) {
            C15094s c15094s = c15098d.f43091a;
            if (c15094s != null) {
                Symbol mo5201v = ((InterfaceC14698e0) c15094s).mo5201v(this.f42065e, c15098d);
                if (mo5201v != null) {
                    Object obj = C15072c.f43034b;
                    if (mo5201v == obj) {
                        return obj;
                    }
                    return null;
                }
                return C15101t.f43100a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveOrClosed<E>");
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/internal/s$f", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.c$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14692e extends C15094s.AbstractC15097c {

        /* renamed from: d */
        final /* synthetic */ C15094s f42066d;

        /* renamed from: e */
        final /* synthetic */ AbstractC14687c f42067e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14692e(C15094s c15094s, C15094s c15094s2, AbstractC14687c abstractC14687c) {
            super(c15094s2);
            this.f42066d = c15094s;
            this.f42067e = abstractC14687c;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        @Nullable
        /* renamed from: k */
        public Object mo3615i(@NotNull C15094s c15094s) {
            if (this.f42067e.mo5171w()) {
                return null;
            }
            return C15093r.m4240a();
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JX\u0010\f\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0006\u001a\u00028\u00002(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m12616d2 = {"kotlinx/coroutines/channels/c$f", "Lkotlinx/coroutines/selects/e;", "Lkotlinx/coroutines/channels/h0;", "R", "Lkotlinx/coroutines/selects/f;", "select", "param", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "d", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.c$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14693f implements InterfaceC15196e<E, InterfaceC14704h0<? super E>> {
        C14693f() {
        }

        @Override // kotlinx.coroutines.selects.InterfaceC15196e
        /* renamed from: d */
        public <R> void mo3631d(@NotNull InterfaceC15197f<? super R> interfaceC15197f, E e, @NotNull InterfaceC15284p<? super InterfaceC14704h0<? super E>, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
            AbstractC14687c.this.m5498D(interfaceC15197f, e, interfaceC15284p);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC14687c(@Nullable InterfaceC15280l<? super E, Unit> interfaceC15280l) {
        this.f42059b = interfaceC15280l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public final <R> void m5498D(InterfaceC15197f<? super R> interfaceC15197f, E e, InterfaceC15284p<? super InterfaceC14704h0<? super E>, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        while (!interfaceC15197f.mo3706i()) {
            if (m5480x()) {
                C14690c c14690c = new C14690c(e, this, interfaceC15197f, interfaceC15284p);
                Object mo5439i = mo5439i(c14690c);
                if (mo5439i == null) {
                    interfaceC15197f.mo3705k(c14690c);
                    return;
                } else if (!(mo5439i instanceof C14731t)) {
                    if (mo5439i != C14685b.f42055h && !(mo5439i instanceof AbstractC14694c0)) {
                        throw new IllegalStateException(("enqueueSend returned " + mo5439i + HttpConstants.SP_CHAR).toString());
                    }
                } else {
                    throw StackTraceRecovery.m4316p(m5483p(e, (C14731t) mo5439i));
                }
            }
            Object mo5169z = mo5169z(e, interfaceC15197f);
            if (mo5169z == C15198g.m3696d()) {
                return;
            }
            if (mo5169z != C14685b.f42053f && mo5169z != C15072c.f43034b) {
                if (mo5169z == C14685b.f42052e) {
                    Undispatched.m222d(interfaceC15284p, this, interfaceC15197f.mo3702s());
                    return;
                } else if (mo5169z instanceof C14731t) {
                    throw StackTraceRecovery.m4316p(m5483p(e, (C14731t) mo5169z));
                } else {
                    throw new IllegalStateException(("offerSelectInternal returned " + mo5169z).toString());
                }
            }
        }
    }

    /* renamed from: e */
    private final int m5491e() {
        C15091q c15091q = this.f42058a;
        Object m4219P = c15091q.m4219P();
        if (m4219P != null) {
            int i = 0;
            for (C15094s c15094s = (C15094s) m4219P; !C14342f0.m8193g(c15094s, c15091q); c15094s = c15094s.m4218Q()) {
                if (c15094s instanceof C15094s) {
                    i++;
                }
            }
            return i;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* renamed from: n */
    private final String m5485n() {
        String str;
        C15094s m4218Q = this.f42058a.m4218Q();
        if (m4218Q == this.f42058a) {
            return "EmptyQueue";
        }
        if (m4218Q instanceof C14731t) {
            str = m4218Q.toString();
        } else if (m4218Q instanceof AbstractC14694c0) {
            str = "ReceiveQueued";
        } else if (m4218Q instanceof AbstractC14702g0) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + m4218Q;
        }
        C15094s m4217R = this.f42058a.m4217R();
        if (m4217R != m4218Q) {
            String str2 = str + ",queueSize=" + m5491e();
            if (m4217R instanceof C14731t) {
                return str2 + ",closedForSend=" + m4217R;
            }
            return str2;
        }
        return str;
    }

    /* renamed from: o */
    private final void m5484o(C14731t<?> c14731t) {
        Object m4269c = InlineList.m4269c(null, 1, null);
        while (true) {
            C15094s m4217R = c14731t.m4217R();
            if (!(m4217R instanceof AbstractC14694c0)) {
                m4217R = null;
            }
            AbstractC14694c0 abstractC14694c0 = (AbstractC14694c0) m4217R;
            if (abstractC14694c0 == null) {
                break;
            } else if (!abstractC14694c0.mo4211Y()) {
                abstractC14694c0.m4216S();
            } else {
                m4269c = InlineList.m4264h(m4269c, abstractC14694c0);
            }
        }
        if (m4269c != null) {
            if (!(m4269c instanceof ArrayList)) {
                ((AbstractC14694c0) m4269c).mo5476h0(c14731t);
            } else {
                ArrayList arrayList = (ArrayList) m4269c;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((AbstractC14694c0) arrayList.get(size)).mo5476h0(c14731t);
                }
            }
        }
        m5499A(c14731t);
    }

    /* renamed from: p */
    private final Throwable m5483p(E e, C14731t<?> c14731t) {
        OnUndeliveredElement m4377d;
        m5484o(c14731t);
        InterfaceC15280l<E, Unit> interfaceC15280l = this.f42059b;
        if (interfaceC15280l != null && (m4377d = C15070b0.m4377d(interfaceC15280l, e, null, 2, null)) != null) {
            C14305i.m8548a(m4377d, c14731t.m5202n0());
            throw m4377d;
        }
        return c14731t.m5202n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public final void m5482r(InterfaceC14268c<?> interfaceC14268c, E e, C14731t<?> c14731t) {
        OnUndeliveredElement m4377d;
        m5484o(c14731t);
        Throwable m5202n0 = c14731t.m5202n0();
        InterfaceC15280l<E, Unit> interfaceC15280l = this.f42059b;
        if (interfaceC15280l != null && (m4377d = C15070b0.m4377d(interfaceC15280l, e, null, 2, null)) != null) {
            C14305i.m8548a(m4377d, m5202n0);
            Result.C14124a c14124a = Result.Companion;
            interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(m4377d)));
            return;
        }
        Result.C14124a c14124a2 = Result.Companion;
        interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(m5202n0)));
    }

    /* renamed from: t */
    private final void m5481t(Throwable th) {
        Symbol symbol;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (symbol = C14685b.f42056i) || !C13675a.m12692a(f42057c, this, obj, symbol)) {
            return;
        }
        ((InterfaceC15280l) TypeIntrinsics.m8010q(obj, 1)).invoke(th);
    }

    /* renamed from: A */
    protected void m5499A(@NotNull C15094s c15094s) {
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: C */
    public void mo5200C(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f42057c;
        if (!C13675a.m12692a(atomicReferenceFieldUpdater, this, null, interfaceC15280l)) {
            Object obj = this.onCloseHandler;
            if (obj == C14685b.f42056i) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        C14731t<?> m5487l = m5487l();
        if (m5487l == null || !C13675a.m12692a(atomicReferenceFieldUpdater, this, interfaceC15280l, C14685b.f42056i)) {
            return;
        }
        interfaceC15280l.invoke(m5487l.f42143d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: E */
    public final InterfaceC14698e0<?> m5497E(E e) {
        C15094s m4217R;
        C15094s c15094s = this.f42058a;
        C14688a c14688a = new C14688a(e);
        do {
            m4217R = c15094s.m4217R();
            if (m4217R instanceof InterfaceC14698e0) {
                return (InterfaceC14698e0) m4217R;
            }
        } while (!m4217R.m4226F(c14688a, c15094s));
        return null;
    }

    @Nullable
    /* renamed from: I */
    final /* synthetic */ Object m5496I(E e, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        AbstractC14702g0 c14708j0;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p m3852b = C15161r.m3852b(m8650d);
        while (true) {
            if (m5480x()) {
                if (this.f42059b == null) {
                    c14708j0 = new C14706i0(e, m3852b);
                } else {
                    c14708j0 = new C14708j0(e, m3852b, this.f42059b);
                }
                Object mo5439i = mo5439i(c14708j0);
                if (mo5439i == null) {
                    C15161r.m3851c(m3852b, c14708j0);
                    break;
                } else if (mo5439i instanceof C14731t) {
                    m5482r(m3852b, e, (C14731t) mo5439i);
                    break;
                } else if (mo5439i != C14685b.f42055h && !(mo5439i instanceof AbstractC14694c0)) {
                    throw new IllegalStateException(("enqueueSend returned " + mo5439i).toString());
                }
            }
            Object mo5170y = mo5170y(e);
            if (mo5170y == C14685b.f42052e) {
                Unit unit = Unit.f41048a;
                Result.C14124a c14124a = Result.Companion;
                m3852b.resumeWith(Result.m60148constructorimpl(unit));
                break;
            } else if (mo5170y != C14685b.f42053f) {
                if (mo5170y instanceof C14731t) {
                    m5482r(m3852b, e, (C14731t) mo5170y);
                } else {
                    throw new IllegalStateException(("offerInternal returned " + mo5170y).toString());
                }
            }
        }
        Object m3883y = m3852b.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        r1 = null;
     */
    @org.jetbrains.annotations.Nullable
    /* renamed from: J */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public kotlinx.coroutines.channels.InterfaceC14698e0<E> mo5495J() {
        /*
            r4 = this;
            kotlinx.coroutines.internal.q r0 = r4.f42058a
        L2:
            java.lang.Object r1 = r0.m4219P()
            if (r1 == 0) goto L2f
            kotlinx.coroutines.internal.s r1 = (kotlinx.coroutines.internal.C15094s) r1
            r2 = 0
            if (r1 != r0) goto Lf
        Ld:
            r1 = r2
            goto L28
        Lf:
            boolean r3 = r1 instanceof kotlinx.coroutines.channels.InterfaceC14698e0
            if (r3 != 0) goto L14
            goto Ld
        L14:
            r2 = r1
            kotlinx.coroutines.channels.e0 r2 = (kotlinx.coroutines.channels.InterfaceC14698e0) r2
            boolean r2 = r2 instanceof kotlinx.coroutines.channels.C14731t
            if (r2 == 0) goto L22
            boolean r2 = r1.mo4214V()
            if (r2 != 0) goto L22
            goto L28
        L22:
            kotlinx.coroutines.internal.s r2 = r1.m4208b0()
            if (r2 != 0) goto L2b
        L28:
            kotlinx.coroutines.channels.e0 r1 = (kotlinx.coroutines.channels.InterfaceC14698e0) r1
            return r1
        L2b:
            r2.m4215U()
            goto L2
        L2f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r0.<init>(r1)
            goto L38
        L37:
            throw r0
        L38:
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractC14687c.mo5495J():kotlinx.coroutines.channels.e0");
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: L */
    public boolean mo5178L(@Nullable Throwable th) {
        boolean z;
        C14731t<?> c14731t = new C14731t<>(th);
        C15094s c15094s = this.f42058a;
        while (true) {
            C15094s m4217R = c15094s.m4217R();
            z = true;
            if (!(!(m4217R instanceof C14731t))) {
                z = false;
                break;
            } else if (m4217R.m4226F(c14731t, c15094s)) {
                break;
            }
        }
        if (!z) {
            C15094s m4217R2 = this.f42058a.m4217R();
            if (m4217R2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
            }
            c14731t = (C14731t) m4217R2;
        }
        m5484o(c14731t);
        if (z) {
            m5481t(th);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        r1 = null;
     */
    @org.jetbrains.annotations.Nullable
    /* renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.channels.AbstractC14702g0 m5494N() {
        /*
            r4 = this;
            kotlinx.coroutines.internal.q r0 = r4.f42058a
        L2:
            java.lang.Object r1 = r0.m4219P()
            if (r1 == 0) goto L2f
            kotlinx.coroutines.internal.s r1 = (kotlinx.coroutines.internal.C15094s) r1
            r2 = 0
            if (r1 != r0) goto Lf
        Ld:
            r1 = r2
            goto L28
        Lf:
            boolean r3 = r1 instanceof kotlinx.coroutines.channels.AbstractC14702g0
            if (r3 != 0) goto L14
            goto Ld
        L14:
            r2 = r1
            kotlinx.coroutines.channels.g0 r2 = (kotlinx.coroutines.channels.AbstractC14702g0) r2
            boolean r2 = r2 instanceof kotlinx.coroutines.channels.C14731t
            if (r2 == 0) goto L22
            boolean r2 = r1.mo4214V()
            if (r2 != 0) goto L22
            goto L28
        L22:
            kotlinx.coroutines.internal.s r2 = r1.m4208b0()
            if (r2 != 0) goto L2b
        L28:
            kotlinx.coroutines.channels.g0 r1 = (kotlinx.coroutines.channels.AbstractC14702g0) r1
            return r1
        L2b:
            r2.m4215U()
            goto L2
        L2f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r0.<init>(r1)
            goto L38
        L37:
            throw r0
        L38:
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractC14687c.m5494N():kotlinx.coroutines.channels.g0");
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    @Nullable
    /* renamed from: P */
    public final Object mo5177P(E e, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        if (mo5170y(e) == C14685b.f42052e) {
            return Unit.f41048a;
        }
        Object m5496I = m5496I(e, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m5496I == m8642h ? m5496I : Unit.f41048a;
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: Q */
    public final boolean mo5199Q() {
        return m5487l() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: f */
    public final C15094s.C15096b<?> m5490f(E e) {
        return new C14689b(this.f42058a, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: g */
    public final C14691d<E> m5489g(E e) {
        return new C14691d<>(e, this.f42058a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: i */
    public Object mo5439i(@NotNull AbstractC14702g0 abstractC14702g0) {
        boolean z;
        C15094s m4217R;
        if (mo5172u()) {
            C15094s c15094s = this.f42058a;
            do {
                m4217R = c15094s.m4217R();
                if (m4217R instanceof InterfaceC14698e0) {
                    return m4217R;
                }
            } while (!m4217R.m4226F(abstractC14702g0, c15094s));
            return null;
        }
        C15094s c15094s2 = this.f42058a;
        C14692e c14692e = new C14692e(abstractC14702g0, abstractC14702g0, this);
        while (true) {
            C15094s m4217R2 = c15094s2.m4217R();
            if (!(m4217R2 instanceof InterfaceC14698e0)) {
                int m4206d0 = m4217R2.m4206d0(abstractC14702g0, c15094s2, c14692e);
                z = true;
                if (m4206d0 != 1) {
                    if (m4206d0 == 2) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return m4217R2;
            }
        }
        if (z) {
            return null;
        }
        return C14685b.f42055h;
    }

    @NotNull
    /* renamed from: j */
    protected String mo5180j() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: k */
    public final C14731t<?> m5488k() {
        C15094s m4218Q = this.f42058a.m4218Q();
        if (!(m4218Q instanceof C14731t)) {
            m4218Q = null;
        }
        C14731t<?> c14731t = (C14731t) m4218Q;
        if (c14731t != null) {
            m5484o(c14731t);
            return c14731t;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: l */
    public final C14731t<?> m5487l() {
        C15094s m4217R = this.f42058a.m4217R();
        if (!(m4217R instanceof C14731t)) {
            m4217R = null;
        }
        C14731t<?> c14731t = (C14731t) m4217R;
        if (c14731t != null) {
            m5484o(c14731t);
            return c14731t;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: m */
    public final C15091q m5486m() {
        return this.f42058a;
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    public final boolean offer(E e) {
        Object mo5170y = mo5170y(e);
        if (mo5170y == C14685b.f42052e) {
            return true;
        }
        if (mo5170y == C14685b.f42053f) {
            C14731t<?> m5487l = m5487l();
            if (m5487l == null) {
                return false;
            }
            throw StackTraceRecovery.m4316p(m5483p(e, m5487l));
        } else if (mo5170y instanceof C14731t) {
            throw StackTraceRecovery.m4316p(m5483p(e, (C14731t) mo5170y));
        } else {
            throw new IllegalStateException(("offerInternal returned " + mo5170y).toString());
        }
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: q */
    public boolean mo5187q() {
        return m5480x();
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14704h0
    @NotNull
    /* renamed from: s */
    public final InterfaceC15196e<E, InterfaceC14704h0<E>> mo5176s() {
        return new C14693f();
    }

    @NotNull
    public String toString() {
        return DebugStrings.m3554a(this) + '@' + DebugStrings.m3553b(this) + '{' + m5485n() + '}' + mo5180j();
    }

    /* renamed from: u */
    protected abstract boolean mo5172u();

    /* renamed from: w */
    protected abstract boolean mo5171w();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x */
    public final boolean m5480x() {
        return !(this.f42058a.m4218Q() instanceof InterfaceC14698e0) && mo5171w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: y */
    public Object mo5170y(E e) {
        InterfaceC14698e0<E> mo5495J;
        do {
            mo5495J = mo5495J();
            if (mo5495J == null) {
                return C14685b.f42053f;
            }
        } while (mo5495J.mo5201v(e, null) == null);
        mo5495J.mo5206j(e);
        return mo5495J.mo5211d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: z */
    public Object mo5169z(E e, @NotNull InterfaceC15197f<?> interfaceC15197f) {
        C14691d<E> m5489g = m5489g(e);
        Object mo3700u = interfaceC15197f.mo3700u(m5489g);
        if (mo3700u != null) {
            return mo3700u;
        }
        InterfaceC14698e0<? super E> m4190o = m5489g.m4190o();
        m4190o.mo5206j(e);
        return m4190o.mo5211d();
    }
}
