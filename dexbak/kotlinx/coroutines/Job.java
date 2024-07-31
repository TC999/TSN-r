package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.selects.InterfaceC15194c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 +2\u00020\u0001:\u0001\tJ\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'J\b\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&J\b\u0010\n\u001a\u00020\bH\u0017J\u0014\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u000bH'J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH'J\u0013\u0010\u0011\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0019\u001a\u00020\u00182'\u0010\u0017\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0013j\u0002`\u0016H&JE\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052'\u0010\u0017\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0013j\u0002`\u0016H'J\u0011\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0097\u0002R\u0014\u0010\u001f\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00000#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, m12616d2 = {"Lkotlinx/coroutines/e2;", "Lkotlin/coroutines/f$b;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", C7304t.f25048d, "", CampaignEx.JSON_NATIVE_VIDEO_START, "cause", "Lkotlin/f1;", "b", CommonNetImpl.CANCEL, "", "a", "Lkotlinx/coroutines/w;", "child", "Lkotlinx/coroutines/u;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/i1;", IAdInterListener.AdReqParam.WIDTH, "onCancelling", "invokeImmediately", "o", AdnName.OTHER, UMCommonContent.f37782aL, "isActive", "()Z", "isCompleted", "isCancelled", "Lkotlin/sequences/m;", "i", "()Lkotlin/sequences/m;", "children", "Lkotlinx/coroutines/selects/c;", "O", "()Lkotlinx/coroutines/selects/c;", "onJoin", "m0", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.e2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface Job extends CoroutineContext.InterfaceC14275b {

    /* renamed from: m0 */
    public static final C14777b f42281m0 = C14777b.f42282a;

    /* compiled from: Job.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.e2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C14776a {
        @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        /* renamed from: a */
        public static /* synthetic */ void m5048a(@NotNull Job job) {
            job.mo3827b(null);
        }

        /* renamed from: b */
        public static /* synthetic */ void m5047b(Job job, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                job.mo3827b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        /* renamed from: c */
        public static /* synthetic */ boolean m5046c(Job job, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return job.mo3828a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        /* renamed from: d */
        public static <R> R m5045d(@NotNull Job job, R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
            return (R) CoroutineContext.InterfaceC14275b.C14276a.m8661a(job, r, interfaceC15284p);
        }

        @Nullable
        /* renamed from: e */
        public static <E extends CoroutineContext.InterfaceC14275b> E m5044e(@NotNull Job job, @NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
            return (E) CoroutineContext.InterfaceC14275b.C14276a.m8660b(job, interfaceC14277c);
        }

        /* renamed from: f */
        public static /* synthetic */ InterfaceC15064i1 m5043f(Job job, boolean z, boolean z2, InterfaceC15280l interfaceC15280l, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return job.mo3824o(z, z2, interfaceC15280l);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        @NotNull
        /* renamed from: g */
        public static CoroutineContext m5042g(@NotNull Job job, @NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
            return CoroutineContext.InterfaceC14275b.C14276a.m8659c(job, interfaceC14277c);
        }

        @NotNull
        /* renamed from: h */
        public static CoroutineContext m5041h(@NotNull Job job, @NotNull CoroutineContext coroutineContext) {
            return CoroutineContext.InterfaceC14275b.C14276a.m8658d(job, coroutineContext);
        }

        @Annotations(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        /* renamed from: i */
        public static Job m5040i(@NotNull Job job, @NotNull Job job2) {
            return job2;
        }
    }

    /* compiled from: Job.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"Lkotlinx/coroutines/e2$b;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/e2;", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.e2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14777b implements CoroutineContext.InterfaceC14277c<Job> {

        /* renamed from: a */
        static final /* synthetic */ C14777b f42282a = new C14777b();

        static {
            CoroutineExceptionHandler.C14616b c14616b = CoroutineExceptionHandler.f41684l0;
        }

        private C14777b() {
        }
    }

    @Nullable
    /* renamed from: E */
    Object mo3831E(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @NotNull
    /* renamed from: O */
    InterfaceC15194c mo3830O();

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: S */
    InterfaceC15235u mo3829S(@NotNull InterfaceC15244w interfaceC15244w);

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: a */
    /* synthetic */ boolean mo3828a(@Nullable Throwable th);

    /* renamed from: b */
    void mo3827b(@Nullable CancellationException cancellationException);

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @NotNull
    /* renamed from: i */
    Sequence<Job> mo3826i();

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: l */
    CancellationException mo3825l();

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: o */
    InterfaceC15064i1 mo3824o(boolean z, boolean z2, @NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l);

    boolean start();

    @Annotations(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    /* renamed from: t */
    Job mo3819t(@NotNull Job job);

    @NotNull
    /* renamed from: w */
    InterfaceC15064i1 mo3818w(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l);
}
