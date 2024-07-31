package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u0019\u0012\u0006\u00105\u001a\u00020-\u0012\b\b\u0002\u0010:\u001a\u00020\u0010¢\u0006\u0004\b;\u0010<J\u000f\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0006H\u0014J\u000f\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0004J\u001e\u0010\u001a\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\rJ\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0013H\u0010¢\u0006\u0004\b\u001f\u0010 J6\u0010%\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u001c\u0010$\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00150#ø\u0001\u0000¢\u0006\u0004\b%\u0010&JO\u0010+\u001a\u00020\u0006\"\u0004\b\u0001\u0010'2\u0006\u0010\"\u001a\u00020!2\u0006\u0010(\u001a\u00028\u00012'\u0010$\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00150)¢\u0006\u0002\b*ø\u0001\u0000¢\u0006\u0004\b+\u0010,R\u001d\u00103\u001a\u00020-8\u0006¢\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b2\u0010\b\u001a\u0004\b0\u00101R\u0014\u00105\u001a\u00020-8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b4\u0010/R\u0014\u00107\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00101R\u0014\u00108\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006="}, m12616d2 = {"Lkotlinx/coroutines/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l2;", "Lkotlinx/coroutines/e2;", "Lkotlin/coroutines/c;", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "m1", "()V", "p1", "T0", DomainCampaignEx.LOOPBACK_VALUE, "o1", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "n1", "", "g0", "", "state", "S0", "Lkotlin/Result;", CommonNetImpl.RESULT, "resumeWith", "k1", "exception", "A0", "(Ljava/lang/Throwable;)V", "M0", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/Function1;", "block", "r1", "(Lkotlinx/coroutines/CoroutineStart;Ll1/l;)V", "R", SocialConstants.PARAM_RECEIVER, "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "q1", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Ll1/p;)V", "Lkotlin/coroutines/f;", "b", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "getContext$annotations", "context", "c", "parentContext", "getCoroutineContext", "coroutineContext", "isActive", "()Z", "active", "<init>", "(Lkotlin/coroutines/f;Z)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractCoroutine<T> extends C15125l2 implements Job, InterfaceC14268c<T>, CoroutineScope {
    @NotNull

    /* renamed from: b */
    private final CoroutineContext f41686b;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: c */
    protected final CoroutineContext f41687c;

    public /* synthetic */ AbstractCoroutine(CoroutineContext coroutineContext, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineContext, (i & 2) != 0 ? true : z);
    }

    /* renamed from: l1 */
    public static /* synthetic */ void m5760l1() {
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: A0 */
    public final void mo4079A0(@NotNull Throwable th) {
        C15137n0.m3969b(this.f41686b, th);
    }

    @Override // kotlinx.coroutines.C15125l2
    @NotNull
    /* renamed from: M0 */
    public String mo3854M0() {
        String m4088b = C15117k0.m4088b(this.f41686b);
        if (m4088b != null) {
            return '\"' + m4088b + "\":" + super.mo3854M0();
        }
        return super.mo3854M0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: S0 */
    protected final void mo4062S0(@Nullable Object obj) {
        if (obj instanceof CompletionState) {
            CompletionState completionState = (CompletionState) obj;
            mo5431n1(completionState.f42189a, completionState.m5156a());
            return;
        }
        mo5430o1(obj);
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: T0 */
    public final void mo4061T0() {
        mo3933p1();
    }

    @Override // kotlinx.coroutines.C15125l2
    @NotNull
    /* renamed from: g0 */
    protected String mo4036g0() {
        return DebugStrings.m3554a(this) + " was cancelled";
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    @NotNull
    public final CoroutineContext getContext() {
        return this.f41686b;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f41686b;
    }

    @Override // kotlinx.coroutines.C15125l2, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    /* renamed from: k1 */
    protected void mo3590k1(@Nullable Object obj) {
        mo4052Y(obj);
    }

    /* renamed from: m1 */
    public final void m5759m1() {
        m4078B0((Job) this.f41687c.get(Job.f42281m0));
    }

    /* renamed from: n1 */
    protected void mo5431n1(@NotNull Throwable th, boolean z) {
    }

    /* renamed from: o1 */
    protected void mo5430o1(T t) {
    }

    /* renamed from: p1 */
    protected void mo3933p1() {
    }

    /* renamed from: q1 */
    public final <R> void m5758q1(@NotNull CoroutineStart coroutineStart, R r, @NotNull InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p) {
        m5759m1();
        coroutineStart.invoke(interfaceC15284p, r, this);
    }

    /* renamed from: r1 */
    public final void m5757r1(@NotNull CoroutineStart coroutineStart, @NotNull InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l) {
        m5759m1();
        coroutineStart.invoke(interfaceC15280l, this);
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    public final void resumeWith(@NotNull Object obj) {
        Object m4069K0 = m4069K0(C15063i0.m4403d(obj, null, 1, null));
        if (m4069K0 == C15134m2.f43181b) {
            return;
        }
        mo3590k1(m4069K0);
    }

    public AbstractCoroutine(@NotNull CoroutineContext coroutineContext, boolean z) {
        super(z);
        this.f41687c = coroutineContext;
        this.f41686b = coroutineContext.plus(this);
    }
}
