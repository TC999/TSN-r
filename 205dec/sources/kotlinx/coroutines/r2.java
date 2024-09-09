package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NonCancellable.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b0\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\u0013\u0010\u0006\u001a\u00020\u0005H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\n\u001a\u00060\bj\u0002`\tH\u0017J1\u0010\u0013\u001a\u00020\u00122'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\u0010H\u0017JA\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\u0010H\u0017J\u0018\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0017J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0017J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0017J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u001a\u0010\u001f\u001a\u00020\u00038VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\u00020\u00038VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b$\u0010\"\u001a\u0004\b#\u0010 R\u001a\u0010%\u001a\u00020\u00038VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b&\u0010\"\u001a\u0004\b%\u0010 R\u0014\u0010*\u001a\u00020'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R \u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020+8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b.\u0010\"\u001a\u0004\b,\u0010-\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lkotlinx/coroutines/r2;", "Lkotlin/coroutines/a;", "Lkotlinx/coroutines/e2;", "", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/f1;", "A", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "l", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/i1;", "m", "onCancelling", "invokeImmediately", "z", "b", "a", "Lkotlinx/coroutines/w;", "child", "Lkotlinx/coroutines/u;", "R", "", "toString", "isActive", "()Z", "isActive$annotations", "()V", "isCompleted", "isCompleted$annotations", "isCancelled", "isCancelled$annotations", "Lkotlinx/coroutines/selects/c;", "M", "()Lkotlinx/coroutines/selects/c;", "onJoin", "Lkotlin/sequences/m;", "h", "()Lkotlin/sequences/m;", "getChildren$annotations", "children", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class r2 extends kotlin.coroutines.a implements e2 {

    /* renamed from: a  reason: collision with root package name */
    public static final r2 f60545a = new r2();

    private r2() {
        super(e2.f59626i0);
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void B() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void q() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void r() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void t() {
    }

    @Override // kotlinx.coroutines.e2
    @InternalCoroutinesApi
    @Nullable
    public Object A(@NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public kotlinx.coroutines.selects.c M() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.e2
    @InternalCoroutinesApi
    @NotNull
    public u R(@NotNull w wVar) {
        return s2.f60556a;
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.j
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean a(@Nullable Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.j
    @InternalCoroutinesApi
    public void b(@Nullable CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.d0
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        b(null);
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public kotlin.sequences.m<e2> h() {
        kotlin.sequences.m<e2> j4;
        j4 = kotlin.sequences.s.j();
        return j4;
    }

    @Override // kotlinx.coroutines.e2
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.e2
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.e2
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.e2
    @InternalCoroutinesApi
    @NotNull
    public CancellationException l() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.e2
    @InternalCoroutinesApi
    @NotNull
    public i1 m(@NotNull d2.l<? super Throwable, kotlin.f1> lVar) {
        return s2.f60556a;
    }

    @Override // kotlinx.coroutines.e2
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    public e2 s(@NotNull e2 e2Var) {
        return e2.a.i(this, e2Var);
    }

    @Override // kotlinx.coroutines.e2
    @InternalCoroutinesApi
    public boolean start() {
        return false;
    }

    @NotNull
    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.e2
    @InternalCoroutinesApi
    @NotNull
    public i1 z(boolean z3, boolean z4, @NotNull d2.l<? super Throwable, kotlin.f1> lVar) {
        return s2.f60556a;
    }
}
