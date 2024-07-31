package kotlinx.coroutines.debug;

import android.annotation.SuppressLint;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C14342f0;
import kotlin.p613io.IOStreams;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Signal;
import sun.misc.SignalHandler;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0002R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u0013"}, m12616d2 = {"Lkotlinx/coroutines/debug/a;", "", "", "args", "Ljava/lang/instrument/Instrumentation;", "instrumentation", "Lkotlin/f1;", "c", "a", "", "Z", "b", "()Z", "d", "(Z)V", "isInstalledStatically", "enableCreationStackTraces", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
@SuppressLint({"all"})
/* renamed from: kotlinx.coroutines.debug.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class AgentPremain {

    /* renamed from: a */
    private static boolean f42198a;

    /* renamed from: b */
    private static final boolean f42199b;

    /* renamed from: c */
    public static final AgentPremain f42200c = new AgentPremain();

    /* compiled from: AgentPremain.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ:\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/debug/a$a;", "Ljava/lang/instrument/ClassFileTransformer;", "Ljava/lang/ClassLoader;", "loader", "", "className", "Ljava/lang/Class;", "classBeingRedefined", "Ljava/security/ProtectionDomain;", "protectionDomain", "", "classfileBuffer", "transform", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14751a implements ClassFileTransformer {

        /* renamed from: a */
        public static final C14751a f42201a = new C14751a();

        private C14751a() {
        }

        @Nullable
        public byte[] transform(@NotNull ClassLoader classLoader, @NotNull String str, @Nullable Class<?> cls, @NotNull ProtectionDomain protectionDomain, @Nullable byte[] bArr) {
            if (!C14342f0.m8193g(str, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            AgentPremain.f42200c.m5143d(true);
            return IOStreams.m8506p(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AgentPremain.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"Lsun/misc/Signal;", "kotlin.jvm.PlatformType", "it", "Lkotlin/f1;", "a", "(Lsun/misc/Signal;)V"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14752b implements SignalHandler {

        /* renamed from: a */
        public static final C14752b f42202a = new C14752b();

        C14752b() {
        }

        /* renamed from: a */
        public final void m5142a(Signal signal) {
            DebugProbesImpl debugProbesImpl = DebugProbesImpl.f42268l;
            if (debugProbesImpl.m5054z()) {
                debugProbesImpl.m5072h(System.out);
            } else {
                System.out.println((Object) "Cannot perform coroutines dump, debug probes are disabled");
            }
        }
    }

    static {
        Object m60148constructorimpl;
        try {
            Result.C14124a c14124a = Result.Companion;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            m60148constructorimpl = Result.m60148constructorimpl(property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null);
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th));
        }
        Boolean bool = Result.m60154isFailureimpl(m60148constructorimpl) ? null : m60148constructorimpl;
        f42199b = bool != null ? bool.booleanValue() : DebugProbesImpl.f42268l.m5059u();
    }

    private AgentPremain() {
    }

    /* renamed from: a */
    private final void m5146a() {
        try {
            Signal.handle(new Signal("TRAP"), C14752b.f42202a);
        } catch (Throwable unused) {
        }
    }

    @JvmStatic
    /* renamed from: c */
    public static final void m5144c(@Nullable String str, @NotNull Instrumentation instrumentation) {
        f42198a = true;
        instrumentation.addTransformer(C14751a.f42201a);
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.f42268l;
        debugProbesImpl.m5088K(f42199b);
        debugProbesImpl.m5056x();
        f42200c.m5146a();
    }

    /* renamed from: b */
    public final boolean m5145b() {
        return f42198a;
    }

    /* renamed from: d */
    public final void m5143d(boolean z) {
        f42198a = z;
    }
}
