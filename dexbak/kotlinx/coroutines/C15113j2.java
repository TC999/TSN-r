package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.jvm.JvmName;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* compiled from: Job.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u001a\u0012\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u001b\u0010\u0004\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\n\u001a\u00020\t2\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\b\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tH\u0000\u001a\u0017\u0010\r\u001a\u00020\u0007*\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0012\u001a\u00020\u0007*\u00020\u00002\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u001a\f\u0010\u0013\u001a\u00020\u0007*\u00020\u0000H\u0007\u001a\u0018\u0010\u0015\u001a\u00020\u0007*\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u0007*\u00020\u00162\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u001a\f\u0010\u0018\u001a\u00020\u0007*\u00020\u0016H\u0007\u001a\n\u0010\u0019\u001a\u00020\u0007*\u00020\u0000\u001a\n\u0010\u001a\u001a\u00020\u0007*\u00020\u0016\u001a\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014\u001a\u0018\u0010\u001f\u001a\u00020\u001e*\u00020\u00162\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014H\u0007\u001a\u001c\u0010 \u001a\u00020\u0007*\u00020\u00162\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u001a\f\u0010!\u001a\u00020\u0007*\u00020\u0016H\u0007\u001a\u0018\u0010\"\u001a\u00020\u0007*\u00020\u00162\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014H\u0007\u001a\u001d\u0010$\u001a\u00020\u0014*\u0004\u0018\u00010\u00142\u0006\u0010#\u001a\u00020\u0000H\u0002¢\u0006\u0004\b$\u0010%\"\u0015\u0010(\u001a\u00020\u001e*\u00020\u00168F¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0015\u0010#\u001a\u00020\u0000*\u00020\u00168F¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, m12616d2 = {"Lkotlinx/coroutines/e2;", "parent", "Lkotlinx/coroutines/b0;", "b", "c", "(Lkotlinx/coroutines/e2;)Lkotlinx/coroutines/e2;", "Lkotlin/Function0;", "Lkotlin/f1;", "block", "Lkotlinx/coroutines/i1;", "a", "handle", "x", "m", "(Lkotlinx/coroutines/e2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "s", CampaignEx.JSON_KEY_AD_Q, "", "r", "Lkotlin/coroutines/f;", "g", "f", UMCommonContent.f37777aG, "y", "", "message", "h", "", "i", "p", "n", "o", "job", "C", "(Ljava/lang/Throwable;Lkotlinx/coroutines/e2;)Ljava/lang/Throwable;", "B", "(Lkotlin/coroutines/f;)Z", "isActive", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlin/coroutines/f;)Lkotlinx/coroutines/e2;", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/JobKt")
/* renamed from: kotlinx.coroutines.j2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final /* synthetic */ class C15113j2 {

    /* compiled from: Job.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, m12616d2 = {"kotlinx/coroutines/j2$a", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "dispose", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.j2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15114a implements InterfaceC15064i1 {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15269a f43140a;

        public C15114a(InterfaceC15269a interfaceC15269a) {
            this.f43140a = interfaceC15269a;
        }

        @Override // kotlinx.coroutines.InterfaceC15064i1
        public void dispose() {
            this.f43140a.invoke();
        }
    }

    @NotNull
    /* renamed from: A */
    public static final Job m4124A(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.f42281m0);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    /* renamed from: B */
    public static final boolean m4123B(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.f42281m0);
        return job != null && job.isActive();
    }

    /* renamed from: C */
    private static final Throwable m4122C(Throwable th, Job job) {
        return th != null ? th : new JobCancellationException("Job was cancelled", null, job);
    }

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: a */
    public static final InterfaceC15064i1 m4121a(@NotNull InterfaceC15269a<Unit> interfaceC15269a) {
        return new C15114a(interfaceC15269a);
    }

    @NotNull
    /* renamed from: b */
    public static final CompletableJob m4120b(@Nullable Job job) {
        return new C15055g2(job);
    }

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @JvmName(name = "Job")
    @NotNull
    /* renamed from: c */
    public static final /* synthetic */ Job m4119c(@Nullable Job job) {
        return C15060h2.m4438b(job);
    }

    /* renamed from: d */
    public static /* synthetic */ CompletableJob m4118d(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return C15060h2.m4438b(job);
    }

    /* renamed from: e */
    public static /* synthetic */ Job m4117e(Job job, int i, Object obj) {
        Job m4119c;
        if ((i & 1) != 0) {
            job = null;
        }
        m4119c = m4119c(job);
        return m4119c;
    }

    /* renamed from: g */
    public static final void m4115g(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.f42281m0);
        if (job != null) {
            job.mo3827b(cancellationException);
        }
    }

    /* renamed from: h */
    public static final void m4114h(@NotNull Job job, @NotNull String str, @Nullable Throwable th) {
        job.mo3827b(C15163r1.m3833a(str, th));
    }

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: i */
    public static final /* synthetic */ boolean m4113i(@NotNull CoroutineContext coroutineContext, @Nullable Throwable th) {
        CoroutineContext.InterfaceC14275b interfaceC14275b = coroutineContext.get(Job.f42281m0);
        if (!(interfaceC14275b instanceof C15125l2)) {
            interfaceC14275b = null;
        }
        C15125l2 c15125l2 = (C15125l2) interfaceC14275b;
        if (c15125l2 != null) {
            c15125l2.mo4042d0(m4122C(th, c15125l2));
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public static /* synthetic */ void m4112j(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        C15060h2.m4433g(coroutineContext, cancellationException);
    }

    /* renamed from: k */
    public static /* synthetic */ void m4111k(Job job, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        C15060h2.m4432h(job, str, th);
    }

    /* renamed from: l */
    public static /* synthetic */ boolean m4110l(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        boolean m4113i;
        if ((i & 1) != 0) {
            th = null;
        }
        m4113i = m4113i(coroutineContext, th);
        return m4113i;
    }

    @Nullable
    /* renamed from: m */
    public static final Object m4109m(@NotNull Job job, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Job.C14776a.m5047b(job, null, 1, null);
        Object mo3831E = job.mo3831E(interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo3831E == m8642h ? mo3831E : Unit.f41048a;
    }

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: o */
    public static final /* synthetic */ void m4107o(@NotNull CoroutineContext coroutineContext, @Nullable Throwable th) {
        Job job = (Job) coroutineContext.get(Job.f42281m0);
        if (job != null) {
            for (Job job2 : job.mo3826i()) {
                if (!(job2 instanceof C15125l2)) {
                    job2 = null;
                }
                C15125l2 c15125l2 = (C15125l2) job2;
                if (c15125l2 != null) {
                    c15125l2.mo4042d0(m4122C(th, job));
                }
            }
        }
    }

    /* renamed from: p */
    public static final void m4106p(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Sequence<Job> mo3826i;
        Job job = (Job) coroutineContext.get(Job.f42281m0);
        if (job == null || (mo3826i = job.mo3826i()) == null) {
            return;
        }
        for (Job job2 : mo3826i) {
            job2.mo3827b(cancellationException);
        }
    }

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: r */
    public static final /* synthetic */ void m4104r(@NotNull Job job, @Nullable Throwable th) {
        for (Job job2 : job.mo3826i()) {
            if (!(job2 instanceof C15125l2)) {
                job2 = null;
            }
            C15125l2 c15125l2 = (C15125l2) job2;
            if (c15125l2 != null) {
                c15125l2.mo4042d0(m4122C(th, job));
            }
        }
    }

    /* renamed from: s */
    public static final void m4103s(@NotNull Job job, @Nullable CancellationException cancellationException) {
        for (Job job2 : job.mo3826i()) {
            job2.mo3827b(cancellationException);
        }
    }

    /* renamed from: t */
    public static /* synthetic */ void m4102t(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        m4107o(coroutineContext, th);
    }

    /* renamed from: u */
    public static /* synthetic */ void m4101u(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        C15060h2.m4424p(coroutineContext, cancellationException);
    }

    /* renamed from: v */
    public static /* synthetic */ void m4100v(Job job, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        m4104r(job, th);
    }

    /* renamed from: w */
    public static /* synthetic */ void m4099w(Job job, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        C15060h2.m4421s(job, cancellationException);
    }

    @NotNull
    /* renamed from: x */
    public static final InterfaceC15064i1 m4098x(@NotNull Job job, @NotNull InterfaceC15064i1 interfaceC15064i1) {
        return job.mo3818w(new C15118k1(job, interfaceC15064i1));
    }

    /* renamed from: y */
    public static final void m4097y(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.f42281m0);
        if (job != null) {
            C15060h2.m4442B(job);
        }
    }

    /* renamed from: z */
    public static final void m4096z(@NotNull Job job) {
        if (!job.isActive()) {
            throw job.mo3825l();
        }
    }
}
