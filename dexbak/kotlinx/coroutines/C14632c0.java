package kotlinx.coroutines;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: CancellableContinuationImpl.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B\\\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J&\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J`\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010 R\u0011\u0010#\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006&"}, m12616d2 = {"Lkotlinx/coroutines/c0;", "", "Lkotlinx/coroutines/p;", "cont", "", "cause", "Lkotlin/f1;", "i", "a", "Lkotlinx/coroutines/m;", "b", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "c", "d", "e", CommonNetImpl.RESULT, "cancelHandler", "onCancellation", "idempotentResume", "cancelCause", "f", "", "toString", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "Ljava/lang/Object;", "Lkotlinx/coroutines/m;", "Ljava/lang/Throwable;", "h", "()Z", "cancelled", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/m;Ll1/l;Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.c0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14632c0 {
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: a */
    public final Object f41720a;
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: b */
    public final AbstractC15132m f41721b;
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: c */
    public final InterfaceC15280l<Throwable, Unit> f41722c;
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: d */
    public final Object f41723d;
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: e */
    public final Throwable f41724e;

    /* JADX WARN: Multi-variable type inference failed */
    public C14632c0(@Nullable Object obj, @Nullable AbstractC15132m abstractC15132m, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, @Nullable Object obj2, @Nullable Throwable th) {
        this.f41720a = obj;
        this.f41721b = abstractC15132m;
        this.f41722c = interfaceC15280l;
        this.f41723d = obj2;
        this.f41724e = th;
    }

    /* renamed from: g */
    public static /* synthetic */ C14632c0 m5704g(C14632c0 c14632c0, Object obj, AbstractC15132m abstractC15132m, InterfaceC15280l interfaceC15280l, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = c14632c0.f41720a;
        }
        if ((i & 2) != 0) {
            abstractC15132m = c14632c0.f41721b;
        }
        AbstractC15132m abstractC15132m2 = abstractC15132m;
        InterfaceC15280l<Throwable, Unit> interfaceC15280l2 = interfaceC15280l;
        if ((i & 4) != 0) {
            interfaceC15280l2 = c14632c0.f41722c;
        }
        InterfaceC15280l interfaceC15280l3 = interfaceC15280l2;
        if ((i & 8) != 0) {
            obj2 = c14632c0.f41723d;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = c14632c0.f41724e;
        }
        return c14632c0.m5705f(obj, abstractC15132m2, interfaceC15280l3, obj4, th);
    }

    @Nullable
    /* renamed from: a */
    public final Object m5710a() {
        return this.f41720a;
    }

    @Nullable
    /* renamed from: b */
    public final AbstractC15132m m5709b() {
        return this.f41721b;
    }

    @Nullable
    /* renamed from: c */
    public final InterfaceC15280l<Throwable, Unit> m5708c() {
        return this.f41722c;
    }

    @Nullable
    /* renamed from: d */
    public final Object m5707d() {
        return this.f41723d;
    }

    @Nullable
    /* renamed from: e */
    public final Throwable m5706e() {
        return this.f41724e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof C14632c0) {
                C14632c0 c14632c0 = (C14632c0) obj;
                return C14342f0.m8193g(this.f41720a, c14632c0.f41720a) && C14342f0.m8193g(this.f41721b, c14632c0.f41721b) && C14342f0.m8193g(this.f41722c, c14632c0.f41722c) && C14342f0.m8193g(this.f41723d, c14632c0.f41723d) && C14342f0.m8193g(this.f41724e, c14632c0.f41724e);
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f */
    public final C14632c0 m5705f(@Nullable Object obj, @Nullable AbstractC15132m abstractC15132m, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, @Nullable Object obj2, @Nullable Throwable th) {
        return new C14632c0(obj, abstractC15132m, interfaceC15280l, obj2, th);
    }

    /* renamed from: h */
    public final boolean m5703h() {
        return this.f41724e != null;
    }

    public int hashCode() {
        Object obj = this.f41720a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        AbstractC15132m abstractC15132m = this.f41721b;
        int hashCode2 = (hashCode + (abstractC15132m != null ? abstractC15132m.hashCode() : 0)) * 31;
        InterfaceC15280l<Throwable, Unit> interfaceC15280l = this.f41722c;
        int hashCode3 = (hashCode2 + (interfaceC15280l != null ? interfaceC15280l.hashCode() : 0)) * 31;
        Object obj2 = this.f41723d;
        int hashCode4 = (hashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.f41724e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    /* renamed from: i */
    public final void m5702i(@NotNull C15153p<?> c15153p, @NotNull Throwable th) {
        AbstractC15132m abstractC15132m = this.f41721b;
        if (abstractC15132m != null) {
            c15153p.m3896l(abstractC15132m, th);
        }
        InterfaceC15280l<Throwable, Unit> interfaceC15280l = this.f41722c;
        if (interfaceC15280l != null) {
            c15153p.m3893o(interfaceC15280l, th);
        }
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.f41720a + ", cancelHandler=" + this.f41721b + ", onCancellation=" + this.f41722c + ", idempotentResume=" + this.f41723d + ", cancelCause=" + this.f41724e + ")";
    }

    public /* synthetic */ C14632c0(Object obj, AbstractC15132m abstractC15132m, InterfaceC15280l interfaceC15280l, Object obj2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : abstractC15132m, (i & 4) != 0 ? null : interfaceC15280l, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
