package kotlin.concurrent;

import d2.l;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Timer.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a3\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u001a3\u0010\u000b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u001a;\u0010\r\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u001a;\u0010\u000e\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u001a;\u0010\u000f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u001a;\u0010\u0010\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u001a\u001a\u0010\u0015\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001\u001aO\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u001aM\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u001aO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u001aM\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u001a'\u0010\u001c\u001a\u00020\u00042\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001d"}, d2 = {"Ljava/util/Timer;", "", "delay", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "action", "f", "Ljava/util/Date;", "time", "h", "period", "e", "g", "i", "j", "", "name", "", "daemon", "k", "initialDelay", "l", "startAt", "m", "a", "b", "p", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "TimersKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Timer.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"kotlin/concurrent/c$a", "Ljava/util/TimerTask;", "Lkotlin/f1;", "run", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l<TimerTask, f1> f55495a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l<? super TimerTask, f1> lVar) {
            this.f55495a = lVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f55495a.invoke(this);
        }
    }

    @InlineOnly
    private static final Timer a(String str, boolean z3, long j4, long j5, l<? super TimerTask, f1> action) {
        f0.p(action, "action");
        Timer k4 = k(str, z3);
        k4.scheduleAtFixedRate(new a(action), j4, j5);
        return k4;
    }

    @InlineOnly
    private static final Timer b(String str, boolean z3, Date startAt, long j4, l<? super TimerTask, f1> action) {
        f0.p(startAt, "startAt");
        f0.p(action, "action");
        Timer k4 = k(str, z3);
        k4.scheduleAtFixedRate(new a(action), startAt, j4);
        return k4;
    }

    static /* synthetic */ Timer c(String str, boolean z3, long j4, long j5, l action, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = null;
        }
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        if ((i4 & 4) != 0) {
            j4 = 0;
        }
        f0.p(action, "action");
        Timer k4 = k(str, z3);
        k4.scheduleAtFixedRate(new a(action), j4, j5);
        return k4;
    }

    static /* synthetic */ Timer d(String str, boolean z3, Date startAt, long j4, l action, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = null;
        }
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        f0.p(startAt, "startAt");
        f0.p(action, "action");
        Timer k4 = k(str, z3);
        k4.scheduleAtFixedRate(new a(action), startAt, j4);
        return k4;
    }

    @InlineOnly
    private static final TimerTask e(Timer timer, long j4, long j5, l<? super TimerTask, f1> action) {
        f0.p(timer, "<this>");
        f0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, j4, j5);
        return aVar;
    }

    @InlineOnly
    private static final TimerTask f(Timer timer, long j4, l<? super TimerTask, f1> action) {
        f0.p(timer, "<this>");
        f0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, j4);
        return aVar;
    }

    @InlineOnly
    private static final TimerTask g(Timer timer, Date time, long j4, l<? super TimerTask, f1> action) {
        f0.p(timer, "<this>");
        f0.p(time, "time");
        f0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, time, j4);
        return aVar;
    }

    @InlineOnly
    private static final TimerTask h(Timer timer, Date time, l<? super TimerTask, f1> action) {
        f0.p(timer, "<this>");
        f0.p(time, "time");
        f0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, time);
        return aVar;
    }

    @InlineOnly
    private static final TimerTask i(Timer timer, long j4, long j5, l<? super TimerTask, f1> action) {
        f0.p(timer, "<this>");
        f0.p(action, "action");
        a aVar = new a(action);
        timer.scheduleAtFixedRate(aVar, j4, j5);
        return aVar;
    }

    @InlineOnly
    private static final TimerTask j(Timer timer, Date time, long j4, l<? super TimerTask, f1> action) {
        f0.p(timer, "<this>");
        f0.p(time, "time");
        f0.p(action, "action");
        a aVar = new a(action);
        timer.scheduleAtFixedRate(aVar, time, j4);
        return aVar;
    }

    @PublishedApi
    @NotNull
    public static final Timer k(@Nullable String str, boolean z3) {
        return str == null ? new Timer(z3) : new Timer(str, z3);
    }

    @InlineOnly
    private static final Timer l(String str, boolean z3, long j4, long j5, l<? super TimerTask, f1> action) {
        f0.p(action, "action");
        Timer k4 = k(str, z3);
        k4.schedule(new a(action), j4, j5);
        return k4;
    }

    @InlineOnly
    private static final Timer m(String str, boolean z3, Date startAt, long j4, l<? super TimerTask, f1> action) {
        f0.p(startAt, "startAt");
        f0.p(action, "action");
        Timer k4 = k(str, z3);
        k4.schedule(new a(action), startAt, j4);
        return k4;
    }

    static /* synthetic */ Timer n(String str, boolean z3, long j4, long j5, l action, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = null;
        }
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        if ((i4 & 4) != 0) {
            j4 = 0;
        }
        f0.p(action, "action");
        Timer k4 = k(str, z3);
        k4.schedule(new a(action), j4, j5);
        return k4;
    }

    static /* synthetic */ Timer o(String str, boolean z3, Date startAt, long j4, l action, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = null;
        }
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        f0.p(startAt, "startAt");
        f0.p(action, "action");
        Timer k4 = k(str, z3);
        k4.schedule(new a(action), startAt, j4);
        return k4;
    }

    @InlineOnly
    private static final TimerTask p(l<? super TimerTask, f1> action) {
        f0.p(action, "action");
        return new a(action);
    }
}
