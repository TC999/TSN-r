package kotlinx.coroutines.selects;

import com.kuaishou.weapon.p205p0.C7304t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.InlineMarker;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: Select.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aK\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aG\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\b\u000bH\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\r\u0010\u000e\" \u0010\u0015\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\" \u0010\u0019\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0012\"\u001a\u0010\u001c\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u0012\u0004\b\u001b\u0010\u0014\"\u001a\u0010\u001e\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u0012\u0004\b\u001d\u0010\u0014\"\u001a\u0010#\u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b \u0010!\u0012\u0004\b\"\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, m12616d2 = {"R", "Lkotlinx/coroutines/selects/a;", "Lkotlin/time/d;", "timeout", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "k", "(Lkotlinx/coroutines/selects/a;DLl1/l;)V", "Lkotlin/ExtensionFunctionType;", "builder", C7304t.f25048d, "(Ll1/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "getNOT_SELECTED$annotations", "()V", "NOT_SELECTED", "b", "d", "getALREADY_SELECTED$annotations", "ALREADY_SELECTED", "c", "getUNDECIDED$annotations", "UNDECIDED", "getRESUMED$annotations", "RESUMED", "Lkotlinx/coroutines/selects/i;", "e", "Lkotlinx/coroutines/selects/i;", "getSelectOpSequenceNumber$annotations", "selectOpSequenceNumber", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.selects.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15198g {
    @NotNull

    /* renamed from: a */
    private static final Object f43325a = new Symbol("NOT_SELECTED");
    @NotNull

    /* renamed from: b */
    private static final Object f43326b = new Symbol("ALREADY_SELECTED");

    /* renamed from: c */
    private static final Object f43327c = new Symbol("UNDECIDED");

    /* renamed from: d */
    private static final Object f43328d = new Symbol("RESUMED");

    /* renamed from: e */
    private static final C15199i f43329e = new C15199i();

    /* renamed from: a */
    public static final /* synthetic */ Object m3699a() {
        return f43328d;
    }

    /* renamed from: b */
    public static final /* synthetic */ C15199i m3698b() {
        return f43329e;
    }

    /* renamed from: c */
    public static final /* synthetic */ Object m3697c() {
        return f43327c;
    }

    @NotNull
    /* renamed from: d */
    public static final Object m3696d() {
        return f43326b;
    }

    /* renamed from: e */
    public static /* synthetic */ void m3695e() {
    }

    @NotNull
    /* renamed from: f */
    public static final Object m3694f() {
        return f43325a;
    }

    /* renamed from: g */
    public static /* synthetic */ void m3693g() {
    }

    /* renamed from: h */
    private static /* synthetic */ void m3692h() {
    }

    /* renamed from: i */
    private static /* synthetic */ void m3691i() {
    }

    /* renamed from: j */
    private static /* synthetic */ void m3690j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ExperimentalTime
    @ExperimentalCoroutinesApi
    /* renamed from: k */
    public static final <R> void m3689k(@NotNull Select<? super R> select, double d, @NotNull InterfaceC15280l<? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15280l) {
        select.mo3677m(Delay.m5748e(d), interfaceC15280l);
    }

    @Nullable
    /* renamed from: l */
    public static final <R> Object m3688l(@NotNull InterfaceC15280l<? super Select<? super R>, Unit> interfaceC15280l, @NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        Object m8642h;
        C15188b c15188b = new C15188b(interfaceC14268c);
        try {
            interfaceC15280l.invoke(c15188b);
        } catch (Throwable th) {
            c15188b.m3713n0(th);
        }
        Object m3714m0 = c15188b.m3714m0();
        m8642h = C14287b.m8642h();
        if (m3714m0 == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3714m0;
    }

    @Nullable
    /* renamed from: m */
    private static final Object m3687m(@NotNull InterfaceC15280l interfaceC15280l, @NotNull InterfaceC14268c interfaceC14268c) {
        Object m8642h;
        InlineMarker.m8227e(0);
        C15188b c15188b = new C15188b(interfaceC14268c);
        try {
            interfaceC15280l.invoke(c15188b);
        } catch (Throwable th) {
            c15188b.m3713n0(th);
        }
        Object m3714m0 = c15188b.m3714m0();
        m8642h = C14287b.m8642h();
        if (m3714m0 == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        InlineMarker.m8227e(1);
        return m3714m0;
    }
}
