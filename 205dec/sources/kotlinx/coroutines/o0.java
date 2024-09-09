package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlinx.coroutines.i3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineContext.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0015B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016J\t\u0010\f\u001a\u00020\u000bH\u00c6\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u000bH\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/o0;", "Lkotlinx/coroutines/i3;", "", "Lkotlin/coroutines/a;", "toString", "Lkotlin/coroutines/f;", "context", "D", "oldState", "Lkotlin/f1;", "C", "", CampaignEx.JSON_KEY_AD_Q, "id", "t", "", "hashCode", "", "other", "", "equals", "a", "J", "B", "()J", "<init>", "(J)V", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o0 extends kotlin.coroutines.a implements i3<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f60522b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final long f60523a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineContext.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/o0$a;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/o0;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements f.c<o0> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public o0(long j4) {
        super(f60522b);
        this.f60523a = j4;
    }

    public static /* synthetic */ o0 w(o0 o0Var, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = o0Var.f60523a;
        }
        return o0Var.t(j4);
    }

    public final long B() {
        return this.f60523a;
    }

    @Override // kotlinx.coroutines.i3
    /* renamed from: C */
    public void u(@NotNull kotlin.coroutines.f fVar, @NotNull String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.i3
    @NotNull
    /* renamed from: D */
    public String Q(@NotNull kotlin.coroutines.f fVar) {
        int F3;
        p0 p0Var = (p0) fVar.get(p0.f60529b);
        String str = (p0Var == null || (str = p0Var.B()) == null) ? "coroutine" : "coroutine";
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        F3 = kotlin.text.x.F3(name, " @", 0, false, 6, null);
        if (F3 < 0) {
            F3 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + F3 + 10);
        if (name != null) {
            String substring = name.substring(0, F3);
            kotlin.jvm.internal.f0.o(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(" @");
            sb.append(str);
            sb.append('#');
            sb.append(this.f60523a);
            kotlin.f1 f1Var = kotlin.f1.f55527a;
            String sb2 = sb.toString();
            kotlin.jvm.internal.f0.o(sb2, "StringBuilder(capacity).\u2026builderAction).toString()");
            currentThread.setName(sb2);
            return name;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof o0) && this.f60523a == ((o0) obj).f60523a;
        }
        return true;
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.f.b, kotlin.coroutines.f
    public <R> R fold(R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) i3.a.a(this, r3, pVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.f.b, kotlin.coroutines.f
    @Nullable
    public <E extends f.b> E get(@NotNull f.c<E> cVar) {
        return (E) i3.a.b(this, cVar);
    }

    public int hashCode() {
        long j4 = this.f60523a;
        return (int) (j4 ^ (j4 >>> 32));
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.f.b, kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f minusKey(@NotNull f.c<?> cVar) {
        return i3.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f plus(@NotNull kotlin.coroutines.f fVar) {
        return i3.a.d(this, fVar);
    }

    public final long q() {
        return this.f60523a;
    }

    @NotNull
    public final o0 t(long j4) {
        return new o0(j4);
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.f60523a + ')';
    }
}
