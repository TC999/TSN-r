package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0010\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000\"\u001a\u0010\b\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\u0006\u0010\u0007\"\u001a\u0010\u000b\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u0012\u0004\b\n\u0010\u0007\"\u001a\u0010\u000e\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u0012\u0004\b\r\u0010\u0007\"\u001a\u0010\u0011\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u0012\u0004\b\u0010\u0010\u0007\"\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014\"\u0014\u0010\u0018\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0014\"\u001a\u0010\u001b\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u0012\u0004\b\u001a\u0010\u0007\"\u001a\u0010 \u001a\u00020\u001c8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u0007\"\u001a\u0010#\u001a\u00020\u001c8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u0012\u0004\b\"\u0010\u0007¨\u0006$"}, m12616d2 = {"", "g", "o", "Lkotlinx/coroutines/internal/j0;", "a", "Lkotlinx/coroutines/internal/j0;", "getCOMPLETING_ALREADY$annotations", "()V", "COMPLETING_ALREADY", "b", "getCOMPLETING_WAITING_CHILDREN$annotations", "COMPLETING_WAITING_CHILDREN", "c", "getCOMPLETING_RETRY$annotations", "COMPLETING_RETRY", "d", "getTOO_LATE_TO_CANCEL$annotations", "TOO_LATE_TO_CANCEL", "", "e", "I", "RETRY", "f", "FALSE", "TRUE", "h", "getSEALED$annotations", "SEALED", "Lkotlinx/coroutines/l1;", "i", "Lkotlinx/coroutines/l1;", "getEMPTY_NEW$annotations", "EMPTY_NEW", "j", "getEMPTY_ACTIVE$annotations", "EMPTY_ACTIVE", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.m2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15134m2 {

    /* renamed from: e */
    private static final int f43184e = -1;

    /* renamed from: f */
    private static final int f43185f = 0;

    /* renamed from: g */
    private static final int f43186g = 1;

    /* renamed from: a */
    private static final Symbol f43180a = new Symbol("COMPLETING_ALREADY");
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: b */
    public static final Symbol f43181b = new Symbol("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c */
    private static final Symbol f43182c = new Symbol("COMPLETING_RETRY");

    /* renamed from: d */
    private static final Symbol f43183d = new Symbol("TOO_LATE_TO_CANCEL");

    /* renamed from: h */
    private static final Symbol f43187h = new Symbol("SEALED");

    /* renamed from: i */
    private static final C15124l1 f43188i = new C15124l1(false);

    /* renamed from: j */
    private static final C15124l1 f43189j = new C15124l1(true);

    /* renamed from: a */
    public static final /* synthetic */ Symbol m3987a() {
        return f43180a;
    }

    /* renamed from: b */
    public static final /* synthetic */ Symbol m3986b() {
        return f43182c;
    }

    /* renamed from: c */
    public static final /* synthetic */ C15124l1 m3985c() {
        return f43189j;
    }

    /* renamed from: d */
    public static final /* synthetic */ C15124l1 m3984d() {
        return f43188i;
    }

    /* renamed from: e */
    public static final /* synthetic */ Symbol m3983e() {
        return f43187h;
    }

    /* renamed from: f */
    public static final /* synthetic */ Symbol m3982f() {
        return f43183d;
    }

    @Nullable
    /* renamed from: g */
    public static final Object m3981g(@Nullable Object obj) {
        return obj instanceof InterfaceC15259y1 ? new C15265z1((InterfaceC15259y1) obj) : obj;
    }

    /* renamed from: h */
    private static /* synthetic */ void m3980h() {
    }

    /* renamed from: i */
    private static /* synthetic */ void m3979i() {
    }

    /* renamed from: j */
    public static /* synthetic */ void m3978j() {
    }

    /* renamed from: k */
    private static /* synthetic */ void m3977k() {
    }

    /* renamed from: l */
    private static /* synthetic */ void m3976l() {
    }

    /* renamed from: m */
    private static /* synthetic */ void m3975m() {
    }

    /* renamed from: n */
    private static /* synthetic */ void m3974n() {
    }

    @Nullable
    /* renamed from: o */
    public static final Object m3973o(@Nullable Object obj) {
        InterfaceC15259y1 interfaceC15259y1;
        C15265z1 c15265z1 = (C15265z1) (!(obj instanceof C15265z1) ? null : obj);
        return (c15265z1 == null || (interfaceC15259y1 = c15265z1.f43459a) == null) ? obj : interfaceC15259y1;
    }
}
