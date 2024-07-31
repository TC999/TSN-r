package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.channel.C13675a;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsH;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: CancellableContinuationImpl.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001f\u0012\f\u0010w\u001a\b\u0012\u0004\u0012\u00028\u00000t\u0012\u0006\u0010+\u001a\u00020%¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014JB\u0010\u001a\u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\bJB\u0010 \u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J8\u0010#\u001a\u00020\"2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u0018H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(JZ\u0010.\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020%2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u00152\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b.\u0010/JH\u00100\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020%2%\b\u0002\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0002¢\u0006\u0004\b0\u00101JJ\u00103\u001a\u0004\u0018\u0001022\b\u0010*\u001a\u0004\u0018\u00010\u001e2\b\u0010-\u001a\u0004\u0018\u00010\u001e2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0002¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u0002052\b\u0010*\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\tH\u0002¢\u0006\u0004\b8\u0010\u000bJ\u000f\u00109\u001a\u00020\tH\u0016¢\u0006\u0004\b9\u0010\u000bJ\u000f\u0010:\u001a\u00020\u0006H\u0001¢\u0006\u0004\b:\u0010\bJ\u0017\u0010=\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<H\u0016¢\u0006\u0004\b=\u0010>J\u0011\u0010?\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\b?\u0010@J!\u0010B\u001a\u00020\t2\b\u0010A\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bD\u0010\u0010J\u0017\u0010E\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bE\u0010FJ\u001f\u0010G\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bG\u0010HJ8\u0010I\u001a\u00020\t2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bI\u0010\u001bJ\u0017\u0010L\u001a\u00020\r2\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ\u0011\u0010N\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\bN\u0010@J \u0010Q\u001a\u00020\t2\f\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000OH\u0016ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ<\u0010T\u001a\u00020\t2\u0006\u0010S\u001a\u00028\u00002#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0016¢\u0006\u0004\bT\u0010UJ8\u0010V\u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u0018H\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\tH\u0000¢\u0006\u0004\bX\u0010\u000bJ#\u0010Y\u001a\u0004\u0018\u00010\u001e2\u0006\u0010S\u001a\u00028\u00002\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\bY\u0010ZJH\u0010[\u001a\u0004\u0018\u00010\u001e2\u0006\u0010S\u001a\u00028\u00002\b\u0010-\u001a\u0004\u0018\u00010\u001e2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0016¢\u0006\u0004\b[\u0010\\J\u0019\u0010^\u001a\u0004\u0018\u00010\u001e2\u0006\u0010]\u001a\u00020\rH\u0016¢\u0006\u0004\b^\u0010_J\u0017\u0010\u0001\u001a\u00020\t2\u0006\u0010`\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u0001\u0010RJ\u001b\u0010b\u001a\u00020\t*\u00020a2\u0006\u0010S\u001a\u00028\u0000H\u0016¢\u0006\u0004\bb\u0010cJ\u001b\u0010d\u001a\u00020\t*\u00020a2\u0006\u0010]\u001a\u00020\rH\u0016¢\u0006\u0004\bd\u0010eJ\u001f\u0010f\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bf\u0010gJ\u001b\u0010h\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bh\u0010iJ\u000f\u0010k\u001a\u00020jH\u0016¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020jH\u0014¢\u0006\u0004\bm\u0010lR\u001a\u0010s\u001a\u00020n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR \u0010w\u001a\b\u0012\u0004\u0012\u00028\u00000t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bV\u0010u\u001a\u0004\bo\u0010vR(\u0010}\u001a\u0004\u0018\u00010x2\b\u0010S\u001a\u0004\u0018\u00010x8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b~\u0010@R\u0014\u0010\u007f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010\bR\u0016\u0010\u0080\u0001\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\bR\u0016\u0010\u0081\u0001\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010\bR\u001f\u0010\u0084\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0087\u0001"}, m12616d2 = {"Lkotlinx/coroutines/p;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/c1;", "Lkotlinx/coroutines/o;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "B", "()Z", "Lkotlin/f1;", "O", "()V", "s", "", "cause", CampaignEx.JSON_KEY_AD_Q, "(Ljava/lang/Throwable;)Z", "Lkotlin/Function0;", "block", "n", "(Ll1/a;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "m", "(Ll1/l;Ljava/lang/Throwable;)V", "R", "P", "", "state", "D", "(Ll1/l;Ljava/lang/Object;)V", "Lkotlinx/coroutines/m;", "C", "(Ll1/l;)Lkotlinx/coroutines/m;", "", RtspHeaders.Values.MODE, "v", "(I)V", "Lkotlinx/coroutines/t2;", "proposedUpdate", "resumeMode", "onCancellation", "idempotent", "L", "(Lkotlinx/coroutines/t2;Ljava/lang/Object;ILl1/l;Ljava/lang/Object;)Ljava/lang/Object;", "H", "(Ljava/lang/Object;ILl1/l;)V", "Lkotlinx/coroutines/internal/j0;", "Q", "(Ljava/lang/Object;Ljava/lang/Object;Ll1/l;)Lkotlinx/coroutines/internal/j0;", "", "k", "(Ljava/lang/Object;)Ljava/lang/Void;", "u", "J", "G", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "j", "()Ljava/lang/Object;", "takenState", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "a", "F", "(Ljava/lang/Throwable;)V", C7304t.f25048d, "(Lkotlinx/coroutines/m;Ljava/lang/Throwable;)V", "o", "Lkotlinx/coroutines/e2;", "parent", IAdInterListener.AdReqParam.WIDTH, "(Lkotlinx/coroutines/e2;)Ljava/lang/Throwable;", "y", "Lkotlin/Result;", CommonNetImpl.RESULT, "resumeWith", "(Ljava/lang/Object;)V", DomainCampaignEx.LOOPBACK_VALUE, UMCommonContent.f37777aG, "(Ljava/lang/Object;Ll1/l;)V", "e", "(Ll1/l;)V", UMCommonContent.f37782aL, "f", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "N", "(Ljava/lang/Object;Ljava/lang/Object;Ll1/l;)Ljava/lang/Object;", "exception", "p", "(Ljava/lang/Throwable;)Ljava/lang/Object;", BidResponsed.KEY_TOKEN, "Lkotlinx/coroutines/l0;", "I", "(Lkotlinx/coroutines/l0;Ljava/lang/Object;)V", "r", "(Lkotlinx/coroutines/l0;Ljava/lang/Throwable;)V", "h", "(Ljava/lang/Object;)Ljava/lang/Object;", "g", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/f;", "d", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/c;", "()Lkotlin/coroutines/c;", "delegate", "Lkotlinx/coroutines/i1;", "x", "()Lkotlinx/coroutines/i1;", "M", "(Lkotlinx/coroutines/i1;)V", "parentHandle", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isActive", "isCompleted", "isCancelled", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "<init>", "(Lkotlin/coroutines/c;I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
@PublishedApi
/* renamed from: kotlinx.coroutines.p */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C15153p<T> extends DispatchedTask<T> implements InterfaceC15146o<T>, CoroutineStackFrame {

    /* renamed from: f */
    private static final AtomicIntegerFieldUpdater f43208f = AtomicIntegerFieldUpdater.newUpdater(C15153p.class, "_decision");

    /* renamed from: g */
    private static final AtomicReferenceFieldUpdater f43209g = AtomicReferenceFieldUpdater.newUpdater(C15153p.class, Object.class, "_state");
    private volatile int _decision;
    private volatile Object _parentHandle;
    private volatile Object _state;
    @NotNull

    /* renamed from: d */
    private final CoroutineContext f43210d;
    @NotNull

    /* renamed from: e */
    private final InterfaceC14268c<T> f43211e;

    /* JADX WARN: Multi-variable type inference failed */
    public C15153p(@NotNull InterfaceC14268c<? super T> interfaceC14268c, int i) {
        super(i);
        this.f43211e = interfaceC14268c;
        this.f43210d = interfaceC14268c.getContext();
        this._decision = 0;
        this._state = CancellableContinuationImpl.f41710a;
        this._parentHandle = null;
    }

    /* renamed from: B */
    private final boolean m3923B() {
        InterfaceC14268c<T> interfaceC14268c = this.f43211e;
        return (interfaceC14268c instanceof DispatchedContinuation) && ((DispatchedContinuation) interfaceC14268c).m4306q(this);
    }

    /* renamed from: C */
    private final AbstractC15132m m3922C(InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        return interfaceC15280l instanceof AbstractC15132m ? (AbstractC15132m) interfaceC15280l : new C14629b2(interfaceC15280l);
    }

    /* renamed from: D */
    private final void m3921D(InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + interfaceC15280l + ", already has " + obj).toString());
    }

    /* renamed from: H */
    private final void m3917H(Object obj, int i, InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof InterfaceC15227t2) {
            } else {
                if (obj2 instanceof C15166s) {
                    C15166s c15166s = (C15166s) obj2;
                    if (c15166s.m3811c()) {
                        if (interfaceC15280l != null) {
                            m3893o(interfaceC15280l, c15166s.f42189a);
                            return;
                        }
                        return;
                    }
                }
                m3897k(obj);
                throw new ExceptionsH();
            }
        } while (!C13675a.m12692a(f43209g, this, obj2, m3913L((InterfaceC15227t2) obj2, obj, i, interfaceC15280l, null)));
        m3887u();
        m3886v(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: K */
    static /* synthetic */ void m3914K(C15153p c15153p, Object obj, int i, InterfaceC15280l interfaceC15280l, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                interfaceC15280l = null;
            }
            c15153p.m3917H(obj, i, interfaceC15280l);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    /* renamed from: L */
    private final Object m3913L(InterfaceC15227t2 interfaceC15227t2, Object obj, int i, InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, Object obj2) {
        if (obj instanceof CompletionState) {
            return obj;
        }
        if (C14748d1.m5152c(i) || obj2 != null) {
            if (interfaceC15280l != null || (((interfaceC15227t2 instanceof AbstractC15132m) && !(interfaceC15227t2 instanceof AbstractC14773e)) || obj2 != null)) {
                if (!(interfaceC15227t2 instanceof AbstractC15132m)) {
                    interfaceC15227t2 = null;
                }
                return new C14632c0(obj, (AbstractC15132m) interfaceC15227t2, interfaceC15280l, obj2, null, 16, null);
            }
            return obj;
        }
        return obj;
    }

    /* renamed from: M */
    private final void m3912M(InterfaceC15064i1 interfaceC15064i1) {
        this._parentHandle = interfaceC15064i1;
    }

    /* renamed from: O */
    private final void m3910O() {
        Job job;
        if (m3889s() || m3884x() != null || (job = (Job) this.f43211e.getContext().get(Job.f42281m0)) == null) {
            return;
        }
        InterfaceC15064i1 m5043f = Job.C14776a.m5043f(job, true, false, new C15225t(job, this), 2, null);
        m3912M(m5043f);
        if (!isCompleted() || m3923B()) {
            return;
        }
        m5043f.dispose();
        m3912M(C15171s2.f43239a);
    }

    /* renamed from: P */
    private final boolean m3909P() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f43208f.compareAndSet(this, 0, 2));
        return true;
    }

    /* renamed from: Q */
    private final Symbol m3908Q(Object obj, Object obj2, InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof InterfaceC15227t2) {
            } else if ((obj3 instanceof C14632c0) && obj2 != null && ((C14632c0) obj3).f41723d == obj2) {
                return C15157q.f43218d;
            } else {
                return null;
            }
        } while (!C13675a.m12692a(f43209g, this, obj3, m3913L((InterfaceC15227t2) obj3, obj, this.f41725c, interfaceC15280l, obj2)));
        m3887u();
        return C15157q.f43218d;
    }

    /* renamed from: R */
    private final boolean m3907R() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f43208f.compareAndSet(this, 0, 1));
        return true;
    }

    /* renamed from: k */
    private final Void m3897k(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    /* renamed from: m */
    private final void m3895m(InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, Throwable th) {
        try {
            interfaceC15280l.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            C15137n0.m3969b(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    /* renamed from: n */
    private final void m3894n(InterfaceC15269a<Unit> interfaceC15269a) {
        try {
            interfaceC15269a.invoke();
        } catch (Throwable th) {
            CoroutineContext context = getContext();
            C15137n0.m3969b(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    /* renamed from: q */
    private final boolean m3891q(Throwable th) {
        if (C14748d1.m5151d(this.f41725c)) {
            InterfaceC14268c<T> interfaceC14268c = this.f43211e;
            if (!(interfaceC14268c instanceof DispatchedContinuation)) {
                interfaceC14268c = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) interfaceC14268c;
            if (dispatchedContinuation != null) {
                return dispatchedContinuation.m4305s(th);
            }
            return false;
        }
        return false;
    }

    /* renamed from: s */
    private final boolean m3889s() {
        Throwable m4311k;
        boolean isCompleted = isCompleted();
        if (C14748d1.m5151d(this.f41725c)) {
            InterfaceC14268c<T> interfaceC14268c = this.f43211e;
            if (!(interfaceC14268c instanceof DispatchedContinuation)) {
                interfaceC14268c = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) interfaceC14268c;
            if (dispatchedContinuation == null || (m4311k = dispatchedContinuation.m4311k(this)) == null) {
                return isCompleted;
            }
            if (!isCompleted) {
                mo3905a(m4311k);
            }
            return true;
        }
        return isCompleted;
    }

    /* renamed from: u */
    private final void m3887u() {
        if (m3923B()) {
            return;
        }
        m3888t();
    }

    /* renamed from: v */
    private final void m3886v(int i) {
        if (m3909P()) {
            return;
        }
        C14748d1.m5154a(this, i);
    }

    /* renamed from: x */
    private final InterfaceC15064i1 m3884x() {
        return (InterfaceC15064i1) this._parentHandle;
    }

    @Nullable
    /* renamed from: A */
    public final Object m3924A() {
        return this._state;
    }

    @NotNull
    /* renamed from: E */
    protected String mo3920E() {
        return "CancellableContinuation";
    }

    /* renamed from: F */
    public final void m3919F(@NotNull Throwable th) {
        if (m3891q(th)) {
            return;
        }
        mo3905a(th);
        m3887u();
    }

    @JvmName(name = "resetStateReusable")
    /* renamed from: G */
    public final boolean m3918G() {
        Object obj = this._state;
        if ((obj instanceof C14632c0) && ((C14632c0) obj).f41723d != null) {
            m3888t();
            return false;
        }
        this._decision = 0;
        this._state = CancellableContinuationImpl.f41710a;
        return true;
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    /* renamed from: I */
    public void mo3916I(@NotNull CoroutineDispatcher coroutineDispatcher, T t) {
        InterfaceC14268c<T> interfaceC14268c = this.f43211e;
        if (!(interfaceC14268c instanceof DispatchedContinuation)) {
            interfaceC14268c = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) interfaceC14268c;
        m3914K(this, t, (dispatchedContinuation != null ? dispatchedContinuation.f43055g : null) == coroutineDispatcher ? 4 : this.f41725c, null, 4, null);
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    /* renamed from: J */
    public void mo3915J() {
        m3910O();
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    @Nullable
    /* renamed from: N */
    public Object mo3911N(T t, @Nullable Object obj, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        return m3908Q(t, obj, interfaceC15280l);
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    /* renamed from: T */
    public void mo3906T(@NotNull Object obj) {
        m3886v(this.f41725c);
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    /* renamed from: a */
    public boolean mo3905a(@Nullable Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof InterfaceC15227t2)) {
                return false;
            }
            z = obj instanceof AbstractC15132m;
        } while (!C13675a.m12692a(f43209g, this, obj, new C15166s(this, th, z)));
        if (!z) {
            obj = null;
        }
        AbstractC15132m abstractC15132m = (AbstractC15132m) obj;
        if (abstractC15132m != null) {
            m3896l(abstractC15132m, th);
        }
        m3887u();
        m3886v(this.f41725c);
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    /* renamed from: c */
    public void mo3904c(@Nullable Object obj, @NotNull Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof InterfaceC15227t2)) {
                if (obj2 instanceof CompletionState) {
                    return;
                }
                if (obj2 instanceof C14632c0) {
                    C14632c0 c14632c0 = (C14632c0) obj2;
                    if (!c14632c0.m5703h()) {
                        if (C13675a.m12692a(f43209g, this, obj2, C14632c0.m5704g(c14632c0, null, null, null, null, th, 15, null))) {
                            c14632c0.m5702i(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (C13675a.m12692a(f43209g, this, obj2, new C14632c0(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @NotNull
    /* renamed from: d */
    public final InterfaceC14268c<T> mo3903d() {
        return this.f43211e;
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    /* renamed from: e */
    public void mo3902e(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        AbstractC15132m m3922C = m3922C(interfaceC15280l);
        while (true) {
            Object obj = this._state;
            if (obj instanceof CancellableContinuationImpl) {
                if (C13675a.m12692a(f43209g, this, obj, m3922C)) {
                    return;
                }
            } else if (obj instanceof AbstractC15132m) {
                m3921D(interfaceC15280l, obj);
            } else {
                boolean z = obj instanceof CompletionState;
                if (z) {
                    if (!((CompletionState) obj).m5155b()) {
                        m3921D(interfaceC15280l, obj);
                    }
                    if (obj instanceof C15166s) {
                        if (!z) {
                            obj = null;
                        }
                        CompletionState completionState = (CompletionState) obj;
                        m3895m(interfaceC15280l, completionState != null ? completionState.f42189a : null);
                        return;
                    }
                    return;
                } else if (obj instanceof C14632c0) {
                    C14632c0 c14632c0 = (C14632c0) obj;
                    if (c14632c0.f41721b != null) {
                        m3921D(interfaceC15280l, obj);
                    }
                    if (m3922C instanceof AbstractC14773e) {
                        return;
                    }
                    if (c14632c0.m5703h()) {
                        m3895m(interfaceC15280l, c14632c0.f41724e);
                        return;
                    } else {
                        if (C13675a.m12692a(f43209g, this, obj, C14632c0.m5704g(c14632c0, null, m3922C, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else if (m3922C instanceof AbstractC14773e) {
                    return;
                } else {
                    if (C13675a.m12692a(f43209g, this, obj, new C14632c0(obj, m3922C, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    @Nullable
    /* renamed from: f */
    public Object mo3901f(T t, @Nullable Object obj) {
        return m3908Q(t, obj, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    /* renamed from: g */
    public Throwable mo3900g(@Nullable Object obj) {
        Throwable mo3900g = super.mo3900g(obj);
        if (mo3900g != null) {
            return mo3900g;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        InterfaceC14268c<T> interfaceC14268c = this.f43211e;
        if (!(interfaceC14268c instanceof CoroutineStackFrame)) {
            interfaceC14268c = null;
        }
        return (CoroutineStackFrame) interfaceC14268c;
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    @NotNull
    public CoroutineContext getContext() {
        return this.f43210d;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    /* renamed from: h */
    public <T> T mo3899h(@Nullable Object obj) {
        return obj instanceof C14632c0 ? (T) ((C14632c0) obj).f41720a : obj;
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    public boolean isActive() {
        return m3924A() instanceof InterfaceC15227t2;
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    public boolean isCancelled() {
        return m3924A() instanceof C15166s;
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    public boolean isCompleted() {
        return !(m3924A() instanceof InterfaceC15227t2);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    /* renamed from: j */
    public Object mo3898j() {
        return m3924A();
    }

    /* renamed from: l */
    public final void m3896l(@NotNull AbstractC15132m abstractC15132m, @Nullable Throwable th) {
        try {
            abstractC15132m.mo3521a(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            C15137n0.m3969b(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    /* renamed from: o */
    public final void m3893o(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, @NotNull Throwable th) {
        try {
            interfaceC15280l.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            C15137n0.m3969b(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    @Nullable
    /* renamed from: p */
    public Object mo3892p(@NotNull Throwable th) {
        return m3908Q(new CompletionState(th, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    /* renamed from: r */
    public void mo3890r(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th) {
        InterfaceC14268c<T> interfaceC14268c = this.f43211e;
        if (!(interfaceC14268c instanceof DispatchedContinuation)) {
            interfaceC14268c = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) interfaceC14268c;
        m3914K(this, new CompletionState(th, false, 2, null), (dispatchedContinuation != null ? dispatchedContinuation.f43055g : null) == coroutineDispatcher ? 4 : this.f41725c, null, 4, null);
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    public void resumeWith(@NotNull Object obj) {
        m3914K(this, C15063i0.m4405b(obj, this), this.f41725c, null, 4, null);
    }

    /* renamed from: t */
    public final void m3888t() {
        InterfaceC15064i1 m3884x = m3884x();
        if (m3884x != null) {
            m3884x.dispose();
        }
        m3912M(C15171s2.f43239a);
    }

    @NotNull
    public String toString() {
        return mo3920E() + '(' + DebugStrings.m3552c(this.f43211e) + "){" + m3924A() + "}@" + DebugStrings.m3553b(this);
    }

    @NotNull
    /* renamed from: w */
    public Throwable mo3885w(@NotNull Job job) {
        return job.mo3825l();
    }

    @PublishedApi
    @Nullable
    /* renamed from: y */
    public final Object m3883y() {
        Job job;
        Object m8642h;
        m3910O();
        if (m3907R()) {
            m8642h = C14287b.m8642h();
            return m8642h;
        }
        Object m3924A = m3924A();
        if (!(m3924A instanceof CompletionState)) {
            if (C14748d1.m5152c(this.f41725c) && (job = (Job) getContext().get(Job.f42281m0)) != null && !job.isActive()) {
                CancellationException mo3825l = job.mo3825l();
                mo3904c(m3924A, mo3825l);
                throw mo3825l;
            }
            return mo3899h(m3924A);
        }
        throw ((CompletionState) m3924A).f42189a;
    }

    @Override // kotlinx.coroutines.InterfaceC15146o
    /* renamed from: z */
    public void mo3882z(T t, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        m3917H(t, this.f41725c, interfaceC15280l);
    }
}
