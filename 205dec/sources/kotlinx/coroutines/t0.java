package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Debug.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0017\u0010\u0005\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0081\b\"\u0014\u0010\b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\"\u0014\u0010\n\u001a\u00020\u00068\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\"\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\"\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007\"\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007\"\u001a\u0010\u0013\u001a\u00020\u00038\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u001a\u0010\u0015\u001a\u00020\u00038\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\r\u0010\u0012\"\u001a\u0010\u0017\u001a\u00020\u00038\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u000f\u0010\u0012\"\u001a\u0010\u001c\u001a\u00020\u00188\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Lkotlin/f1;", "f", "Lkotlin/Function0;", "", "value", "a", "", "Ljava/lang/String;", "DEBUG_PROPERTY_NAME", "b", "STACKTRACE_RECOVERY_PROPERTY_NAME", "c", "DEBUG_PROPERTY_VALUE_AUTO", "d", "DEBUG_PROPERTY_VALUE_ON", "e", "DEBUG_PROPERTY_VALUE_OFF", "Z", "()Z", "ASSERTIONS_ENABLED", "g", "DEBUG", "h", "RECOVER_STACK_TRACES", "Ljava/util/concurrent/atomic/AtomicLong;", "i", "Ljava/util/concurrent/atomic/AtomicLong;", "()Ljava/util/concurrent/atomic/AtomicLong;", "COROUTINE_ID", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final String f60714a = "kotlinx.coroutines.debug";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final String f60715b = "kotlinx.coroutines.stacktrace.recovery";
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final String f60716c = "auto";
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final String f60717d = "on";
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final String f60718e = "off";

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f60719f = false;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f60720g;

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f60721h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicLong f60722i;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r0.equals("on") != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r0.equals("") != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        r0 = true;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.l0.d(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Lb
            goto L27
        Lb:
            int r3 = r0.hashCode()
            if (r3 == 0) goto L3b
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L32
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L29
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L5e
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
        L27:
            r0 = 0
            goto L44
        L29:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
            goto L27
        L32:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
            goto L43
        L3b:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
        L43:
            r0 = 1
        L44:
            kotlinx.coroutines.t0.f60720g = r0
            if (r0 == 0) goto L51
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.l0.e(r0, r1)
            if (r0 == 0) goto L51
            goto L52
        L51:
            r1 = 0
        L52:
            kotlinx.coroutines.t0.f60721h = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            kotlinx.coroutines.t0.f60722i = r0
            return
        L5e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            goto L7f
        L7e:
            throw r1
        L7f:
            goto L7e
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.t0.<clinit>():void");
    }

    @InlineOnly
    private static final void a(d2.a<Boolean> aVar) {
    }

    public static final boolean b() {
        return f60719f;
    }

    @NotNull
    public static final AtomicLong c() {
        return f60722i;
    }

    public static final boolean d() {
        return f60720g;
    }

    public static final boolean e() {
        return f60721h;
    }

    public static final void f() {
        f60722i.set(0L);
    }
}
