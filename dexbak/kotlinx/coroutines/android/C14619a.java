package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges._Ranges;
import kotlin.time.C14597e;
import kotlinx.coroutines.InterfaceC15064i1;
import kotlinx.coroutines.InterfaceC15146o;
import kotlinx.coroutines.InterfaceC15263z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: HandlerDispatcher.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010#\u001a\u00020 \u0012\b\u0010&\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010(\u001a\u00020\u0005¢\u0006\u0004\b)\u0010*B\u001d\b\u0016\u0012\u0006\u0010#\u001a\u00020 \u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b)\u0010+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0016J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010'¨\u0006,"}, m12616d2 = {"Lkotlinx/coroutines/android/a;", "Lkotlinx/coroutines/android/b;", "Lkotlinx/coroutines/z0;", "Lkotlin/coroutines/f;", "context", "", "isDispatchNeeded", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "dispatch", "", "timeMillis", "Lkotlinx/coroutines/o;", "continuation", "d", "Lkotlinx/coroutines/i1;", "e", "", "toString", "", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "_immediate", "Lkotlinx/coroutines/android/a;", "a", "B", "()Lkotlinx/coroutines/android/a;", "immediate", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "c", "Ljava/lang/String;", "name", "Z", "invokeImmediately", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "kotlinx-coroutines-android"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.android.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14619a extends AbstractC14623b implements InterfaceC15263z0 {
    private volatile C14619a _immediate;
    @NotNull

    /* renamed from: a */
    private final C14619a f41696a;

    /* renamed from: b */
    private final Handler f41697b;

    /* renamed from: c */
    private final String f41698c;

    /* renamed from: d */
    private final boolean f41699d;

    /* compiled from: HandlerDispatcher.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, m12616d2 = {"kotlinx/coroutines/android/a$a", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "dispose", "kotlinx-coroutines-android"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.android.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14620a implements InterfaceC15064i1 {

        /* renamed from: b */
        final /* synthetic */ Runnable f41701b;

        C14620a(Runnable runnable) {
            this.f41701b = runnable;
        }

        @Override // kotlinx.coroutines.InterfaceC15064i1
        public void dispose() {
            C14619a.this.f41697b.removeCallbacks(this.f41701b);
        }
    }

    /* compiled from: Runnable.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "kotlinx/coroutines/a3$a", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.android.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class RunnableC14621b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ InterfaceC15146o f41703b;

        public RunnableC14621b(InterfaceC15146o interfaceC15146o) {
            this.f41703b = interfaceC15146o;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f41703b.mo3916I(C14619a.this, Unit.f41048a);
        }
    }

    /* compiled from: HandlerDispatcher.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.android.a$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14622c extends Lambda implements InterfaceC15280l<Throwable, Unit> {

        /* renamed from: b */
        final /* synthetic */ Runnable f41705b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14622c(Runnable runnable) {
            super(1);
            this.f41705b = runnable;
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            C14619a.this.f41697b.removeCallbacks(this.f41705b);
        }
    }

    private C14619a(Handler handler, String str, boolean z) {
        super(null);
        this.f41697b = handler;
        this.f41698c = str;
        this.f41699d = z;
        this._immediate = z ? this : null;
        C14619a c14619a = this._immediate;
        if (c14619a == null) {
            c14619a = new C14619a(handler, str, true);
            this._immediate = c14619a;
            Unit unit = Unit.f41048a;
        }
        this.f41696a = c14619a;
    }

    @Override // kotlinx.coroutines.android.AbstractC14623b
    @NotNull
    /* renamed from: B */
    public C14619a mo5740r() {
        return this.f41696a;
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    /* renamed from: d */
    public void mo3487d(long j, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o) {
        long m7457v;
        RunnableC14621b runnableC14621b = new RunnableC14621b(interfaceC15146o);
        Handler handler = this.f41697b;
        m7457v = _Ranges.m7457v(j, C14597e.f41662c);
        handler.postDelayed(runnableC14621b, m7457v);
        interfaceC15146o.mo3902e(new C14622c(runnableC14621b));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        this.f41697b.post(runnable);
    }

    @Override // kotlinx.coroutines.android.AbstractC14623b, kotlinx.coroutines.InterfaceC15263z0
    @NotNull
    /* renamed from: e */
    public InterfaceC15064i1 mo3486e(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        long m7457v;
        Handler handler = this.f41697b;
        m7457v = _Ranges.m7457v(j, C14597e.f41662c);
        handler.postDelayed(runnable, m7457v);
        return new C14620a(runnable);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C14619a) && ((C14619a) obj).f41697b == this.f41697b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f41697b);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        return !this.f41699d || (C14342f0.m8193g(Looper.myLooper(), this.f41697b.getLooper()) ^ true);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String m3874q = m3874q();
        if (m3874q != null) {
            return m3874q;
        }
        String str = this.f41698c;
        if (str == null) {
            str = this.f41697b.toString();
        }
        if (this.f41699d) {
            return str + ".immediate";
        }
        return str;
    }

    public /* synthetic */ C14619a(Handler handler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public C14619a(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
