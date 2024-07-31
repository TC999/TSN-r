package kotlinx.coroutines;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: CompletionState.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001B4\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J$\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J:\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012#\b\u0002\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0014¨\u0006\u0017"}, m12616d2 = {"Lkotlinx/coroutines/e0;", "", "a", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "b", CommonNetImpl.RESULT, "onCancellation", "c", "", "toString", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;Ll1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.e0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14774e0 {
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: a */
    public final Object f42278a;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: b */
    public final InterfaceC15280l<Throwable, Unit> f42279b;

    /* JADX WARN: Multi-variable type inference failed */
    public C14774e0(@Nullable Object obj, @NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        this.f42278a = obj;
        this.f42279b = interfaceC15280l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static /* synthetic */ C14774e0 m5049d(C14774e0 c14774e0, Object obj, InterfaceC15280l interfaceC15280l, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = c14774e0.f42278a;
        }
        if ((i & 2) != 0) {
            interfaceC15280l = c14774e0.f42279b;
        }
        return c14774e0.m5050c(obj, interfaceC15280l);
    }

    @Nullable
    /* renamed from: a */
    public final Object m5052a() {
        return this.f42278a;
    }

    @NotNull
    /* renamed from: b */
    public final InterfaceC15280l<Throwable, Unit> m5051b() {
        return this.f42279b;
    }

    @NotNull
    /* renamed from: c */
    public final C14774e0 m5050c(@Nullable Object obj, @NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        return new C14774e0(obj, interfaceC15280l);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof C14774e0) {
                C14774e0 c14774e0 = (C14774e0) obj;
                return C14342f0.m8193g(this.f42278a, c14774e0.f42278a) && C14342f0.m8193g(this.f42279b, c14774e0.f42279b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.f42278a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        InterfaceC15280l<Throwable, Unit> interfaceC15280l = this.f42279b;
        return hashCode + (interfaceC15280l != null ? interfaceC15280l.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.f42278a + ", onCancellation=" + this.f42279b + ")";
    }
}
