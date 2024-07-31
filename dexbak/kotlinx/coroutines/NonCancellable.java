package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractC14266a;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.sequences.C14520s;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.InterfaceC15194c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b0\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\u0013\u0010\u0006\u001a\u00020\u0005H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\n\u001a\u00060\bj\u0002`\tH\u0017J1\u0010\u0013\u001a\u00020\u00122'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\u0010H\u0017JA\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\u0010H\u0017J\u0018\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0017J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0017J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0017J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u001a\u0010\u001f\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010\"\u001a\u0004\b#\u0010 R\u001a\u0010%\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b&\u0010\"\u001a\u0004\b%\u0010 R\u0014\u0010*\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R \u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020+8VX\u0097\u0004¢\u0006\f\u0012\u0004\b.\u0010\"\u001a\u0004\b,\u0010-\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, m12616d2 = {"Lkotlinx/coroutines/r2;", "Lkotlin/coroutines/a;", "Lkotlinx/coroutines/e2;", "", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", C7304t.f25048d, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/i1;", IAdInterListener.AdReqParam.WIDTH, "onCancelling", "invokeImmediately", "o", "b", "a", "Lkotlinx/coroutines/w;", "child", "Lkotlinx/coroutines/u;", ExifInterface.LATITUDE_SOUTH, "", "toString", "isActive", "()Z", "isActive$annotations", "()V", "isCompleted", "isCompleted$annotations", "isCancelled", "isCancelled$annotations", "Lkotlinx/coroutines/selects/c;", "O", "()Lkotlinx/coroutines/selects/c;", "onJoin", "Lkotlin/sequences/m;", "i", "()Lkotlin/sequences/m;", "getChildren$annotations", "children", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.r2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class NonCancellable extends AbstractC14266a implements Job {

    /* renamed from: a */
    public static final NonCancellable f43228a = new NonCancellable();

    private NonCancellable() {
        super(Job.f42281m0);
    }

    @InternalCoroutinesApi
    /* renamed from: p */
    public static /* synthetic */ void m3823p() {
    }

    @InternalCoroutinesApi
    /* renamed from: q */
    public static /* synthetic */ void m3822q() {
    }

    @InternalCoroutinesApi
    /* renamed from: r */
    public static /* synthetic */ void m3821r() {
    }

    @InternalCoroutinesApi
    /* renamed from: s */
    public static /* synthetic */ void m3820s() {
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    @Nullable
    /* renamed from: E */
    public Object mo3831E(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    /* renamed from: O */
    public InterfaceC15194c mo3830O() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    @NotNull
    /* renamed from: S */
    public InterfaceC15235u mo3829S(@NotNull InterfaceC15244w interfaceC15244w) {
        return C15171s2.f43239a;
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.channels.BroadcastChannel
    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: a */
    public /* synthetic */ boolean mo3828a(@Nullable Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.channels.BroadcastChannel
    @InternalCoroutinesApi
    /* renamed from: b */
    public void mo3827b(@Nullable CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.Job, kotlinx.coroutines.channels.InterfaceC14695d0
    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        mo3827b(null);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    /* renamed from: i */
    public Sequence<Job> mo3826i() {
        Sequence<Job> m6988j;
        m6988j = C14520s.m6988j();
        return m6988j;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    @NotNull
    /* renamed from: l */
    public CancellationException mo3825l() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    @NotNull
    /* renamed from: o */
    public InterfaceC15064i1 mo3824o(boolean z, boolean z2, @NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        return C15171s2.f43239a;
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    public boolean start() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @Annotations(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    /* renamed from: t */
    public Job mo3819t(@NotNull Job job) {
        return Job.C14776a.m5040i(this, job);
    }

    @NotNull
    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.Job
    @InternalCoroutinesApi
    @NotNull
    /* renamed from: w */
    public InterfaceC15064i1 mo3818w(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        return C15171s2.f43239a;
    }
}
