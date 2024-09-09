package kotlinx.coroutines.debug;

import android.annotation.SuppressLint;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.d0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.debug.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Signal;
import sun.misc.SignalHandler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AgentPremain.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c1\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0002R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/debug/a;", "", "", "args", "Ljava/lang/instrument/Instrumentation;", "instrumentation", "Lkotlin/f1;", "c", "a", "", "Z", "b", "()Z", "d", "(Z)V", "isInstalledStatically", "enableCreationStackTraces", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"all"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f59543a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f59544b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f59545c = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AgentPremain.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ:\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/debug/a$a;", "Ljava/lang/instrument/ClassFileTransformer;", "Ljava/lang/ClassLoader;", "loader", "", "className", "Ljava/lang/Class;", "classBeingRedefined", "Ljava/security/ProtectionDomain;", "protectionDomain", "", "classfileBuffer", "transform", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1201a implements ClassFileTransformer {

        /* renamed from: a  reason: collision with root package name */
        public static final C1201a f59546a = new C1201a();

        private C1201a() {
        }

        @Nullable
        public byte[] transform(@NotNull ClassLoader classLoader, @NotNull String str, @Nullable Class<?> cls, @NotNull ProtectionDomain protectionDomain, @Nullable byte[] bArr) {
            if (!f0.g(str, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            a.f59545c.d(true);
            return kotlin.io.a.p(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AgentPremain.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsun/misc/Signal;", "kotlin.jvm.PlatformType", "it", "Lkotlin/f1;", "a", "(Lsun/misc/Signal;)V"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements SignalHandler {

        /* renamed from: a  reason: collision with root package name */
        public static final b f59547a = new b();

        b() {
        }

        public final void a(Signal signal) {
            f fVar = f.f59613l;
            if (fVar.z()) {
                fVar.h(System.out);
            } else {
                System.out.println((Object) "Cannot perform coroutines dump, debug probes are disabled");
            }
        }
    }

    static {
        Object m119constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            m119constructorimpl = Result.m119constructorimpl(property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(d0.a(th));
        }
        Boolean bool = Result.m125isFailureimpl(m119constructorimpl) ? null : m119constructorimpl;
        f59544b = bool != null ? bool.booleanValue() : f.f59613l.u();
    }

    private a() {
    }

    private final void a() {
        try {
            Signal.handle(new Signal("TRAP"), b.f59547a);
        } catch (Throwable unused) {
        }
    }

    @JvmStatic
    public static final void c(@Nullable String str, @NotNull Instrumentation instrumentation) {
        f59543a = true;
        instrumentation.addTransformer(C1201a.f59546a);
        f fVar = f.f59613l;
        fVar.K(f59544b);
        fVar.x();
        f59545c.a();
    }

    public final boolean b() {
        return f59543a;
    }

    public final void d(boolean z3) {
        f59543a = z3;
    }
}
