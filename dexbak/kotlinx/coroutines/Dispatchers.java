package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.internal.C15108x;
import kotlinx.coroutines.scheduling.C15176c;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0007R \u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\u0005R \u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\n\u0010\u0005R \u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0004\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\r\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m12616d2 = {"Lkotlinx/coroutines/f1;", "", "Lkotlinx/coroutines/l0;", "a", "Lkotlinx/coroutines/l0;", "()Lkotlinx/coroutines/l0;", "getDefault$annotations", "()V", "Default", "b", "g", "getUnconfined$annotations", "Unconfined", "c", "getIO$annotations", "IO", "Lkotlinx/coroutines/p2;", "e", "()Lkotlinx/coroutines/p2;", "getMain$annotations", "Main", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.f1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Dispatchers {

    /* renamed from: d */
    public static final Dispatchers f42288d = new Dispatchers();
    @NotNull

    /* renamed from: a */
    private static final CoroutineDispatcher f42285a = C15117k0.m4089a();
    @NotNull

    /* renamed from: b */
    private static final CoroutineDispatcher f42286b = Unconfined.f43240a;
    @NotNull

    /* renamed from: c */
    private static final CoroutineDispatcher f42287c = C15176c.f43276h.m3751G();

    private Dispatchers() {
    }

    @NotNull
    /* renamed from: a */
    public static final CoroutineDispatcher m5038a() {
        return f42285a;
    }

    @JvmStatic
    /* renamed from: b */
    public static /* synthetic */ void m5037b() {
    }

    @NotNull
    /* renamed from: c */
    public static final CoroutineDispatcher m5036c() {
        return f42287c;
    }

    @JvmStatic
    /* renamed from: d */
    public static /* synthetic */ void m5035d() {
    }

    @NotNull
    /* renamed from: e */
    public static final MainCoroutineDispatcher m5034e() {
        return C15108x.f43130b;
    }

    @JvmStatic
    /* renamed from: f */
    public static /* synthetic */ void m5033f() {
    }

    @NotNull
    /* renamed from: g */
    public static final CoroutineDispatcher m5032g() {
        return f42286b;
    }

    @JvmStatic
    /* renamed from: h */
    public static /* synthetic */ void m5031h() {
    }
}
