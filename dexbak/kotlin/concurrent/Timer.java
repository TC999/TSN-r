package kotlin.concurrent;

import com.kuaishou.weapon.p205p0.C7304t;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.ccg.CcgConstant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Date;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a3\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001a3\u0010\u000b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001a;\u0010\r\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001a;\u0010\u000e\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001a;\u0010\u000f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001a;\u0010\u0010\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001a\u001a\u0010\u0015\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001\u001aO\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001aM\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001aO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001aM\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001a'\u0010\u001c\u001a\u00020\u00042\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m12616d2 = {"Ljava/util/Timer;", "", "delay", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", CcgConstant.f38549t, "f", "Ljava/util/Date;", RtspHeaders.Values.TIME, "h", AnalyticsConfig.RTD_PERIOD, "e", "g", "i", "j", "", "name", "", "daemon", "k", "initialDelay", C7304t.f25048d, "startAt", "m", "a", "b", "p", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "TimersKt")
/* renamed from: kotlin.concurrent.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Timer {

    /* compiled from: Timer.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, m12616d2 = {"kotlin/concurrent/c$a", "Ljava/util/TimerTask;", "Lkotlin/f1;", "run", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.concurrent.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14261a extends TimerTask {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15280l f41016a;

        public C14261a(InterfaceC15280l interfaceC15280l) {
            this.f41016a = interfaceC15280l;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f41016a.invoke(this);
        }
    }

    @InlineOnly
    /* renamed from: a */
    private static final java.util.Timer m8699a(String str, boolean z, long j, long j2, InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        java.util.Timer m8689k = m8689k(str, z);
        m8689k.scheduleAtFixedRate(new C14261a(interfaceC15280l), j, j2);
        return m8689k;
    }

    @InlineOnly
    /* renamed from: b */
    private static final java.util.Timer m8698b(String str, boolean z, Date date, long j, InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        java.util.Timer m8689k = m8689k(str, z);
        m8689k.scheduleAtFixedRate(new C14261a(interfaceC15280l), date, j);
        return m8689k;
    }

    /* renamed from: c */
    static /* synthetic */ java.util.Timer m8697c(String str, boolean z, long j, long j2, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        java.util.Timer m8689k = m8689k(str, z);
        m8689k.scheduleAtFixedRate(new C14261a(interfaceC15280l), j, j2);
        return m8689k;
    }

    /* renamed from: d */
    static /* synthetic */ java.util.Timer m8696d(String str, boolean z, Date date, long j, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        java.util.Timer m8689k = m8689k(str, z);
        m8689k.scheduleAtFixedRate(new C14261a(interfaceC15280l), date, j);
        return m8689k;
    }

    @InlineOnly
    /* renamed from: e */
    private static final TimerTask m8695e(java.util.Timer timer, long j, long j2, InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        C14261a c14261a = new C14261a(interfaceC15280l);
        timer.schedule(c14261a, j, j2);
        return c14261a;
    }

    @InlineOnly
    /* renamed from: f */
    private static final TimerTask m8694f(java.util.Timer timer, long j, InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        C14261a c14261a = new C14261a(interfaceC15280l);
        timer.schedule(c14261a, j);
        return c14261a;
    }

    @InlineOnly
    /* renamed from: g */
    private static final TimerTask m8693g(java.util.Timer timer, Date date, long j, InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        C14261a c14261a = new C14261a(interfaceC15280l);
        timer.schedule(c14261a, date, j);
        return c14261a;
    }

    @InlineOnly
    /* renamed from: h */
    private static final TimerTask m8692h(java.util.Timer timer, Date date, InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        C14261a c14261a = new C14261a(interfaceC15280l);
        timer.schedule(c14261a, date);
        return c14261a;
    }

    @InlineOnly
    /* renamed from: i */
    private static final TimerTask m8691i(java.util.Timer timer, long j, long j2, InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        C14261a c14261a = new C14261a(interfaceC15280l);
        timer.scheduleAtFixedRate(c14261a, j, j2);
        return c14261a;
    }

    @InlineOnly
    /* renamed from: j */
    private static final TimerTask m8690j(java.util.Timer timer, Date date, long j, InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        C14261a c14261a = new C14261a(interfaceC15280l);
        timer.scheduleAtFixedRate(c14261a, date, j);
        return c14261a;
    }

    @PublishedApi
    @NotNull
    /* renamed from: k */
    public static final java.util.Timer m8689k(@Nullable String str, boolean z) {
        return str == null ? new java.util.Timer(z) : new java.util.Timer(str, z);
    }

    @InlineOnly
    /* renamed from: l */
    private static final java.util.Timer m8688l(String str, boolean z, long j, long j2, InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        java.util.Timer m8689k = m8689k(str, z);
        m8689k.schedule(new C14261a(interfaceC15280l), j, j2);
        return m8689k;
    }

    @InlineOnly
    /* renamed from: m */
    private static final java.util.Timer m8687m(String str, boolean z, Date date, long j, InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        java.util.Timer m8689k = m8689k(str, z);
        m8689k.schedule(new C14261a(interfaceC15280l), date, j);
        return m8689k;
    }

    /* renamed from: n */
    static /* synthetic */ java.util.Timer m8686n(String str, boolean z, long j, long j2, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        java.util.Timer m8689k = m8689k(str, z);
        m8689k.schedule(new C14261a(interfaceC15280l), j, j2);
        return m8689k;
    }

    /* renamed from: o */
    static /* synthetic */ java.util.Timer m8685o(String str, boolean z, Date date, long j, InterfaceC15280l interfaceC15280l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        java.util.Timer m8689k = m8689k(str, z);
        m8689k.schedule(new C14261a(interfaceC15280l), date, j);
        return m8689k;
    }

    @InlineOnly
    /* renamed from: p */
    private static final TimerTask m8684p(InterfaceC15280l<? super TimerTask, Unit> interfaceC15280l) {
        return new C14261a(interfaceC15280l);
    }
}
