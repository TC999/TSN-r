package kotlinx.coroutines.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.f1;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.p2;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MainDispatchers.kt */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001b\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\t2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016J\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/z;", "Lkotlinx/coroutines/p2;", "Lkotlinx/coroutines/z0;", "", "B", "Lkotlin/coroutines/f;", "context", "", "isDispatchNeeded", "", "time", "o", "(JLkotlin/coroutines/c;)Ljava/lang/Object;", "timeMillis", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/i1;", "f", "t", "Lkotlinx/coroutines/o;", "Lkotlin/f1;", "continuation", "C", "", "toString", "", "a", "Ljava/lang/Throwable;", "cause", "b", "Ljava/lang/String;", "errorHint", CampaignEx.JSON_KEY_AD_Q, "()Lkotlinx/coroutines/p2;", "immediate", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z extends p2 implements z0 {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f60451a;

    /* renamed from: b  reason: collision with root package name */
    private final String f60452b;

    public /* synthetic */ z(Throwable th, String str, int i4, kotlin.jvm.internal.u uVar) {
        this(th, (i4 & 2) != 0 ? null : str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r1 != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Void B() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f60451a
            if (r0 == 0) goto L37
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f60452b
            if (r1 == 0) goto L26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L26
            goto L28
        L26:
            java.lang.String r1 = ""
        L28:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f60451a
            r1.<init>(r0, r2)
            throw r1
        L37:
            kotlinx.coroutines.internal.y.e()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.z.B():java.lang.Void");
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    /* renamed from: C */
    public Void d(long j4, @NotNull kotlinx.coroutines.o<? super f1> oVar) {
        B();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    public i1 f(long j4, @NotNull Runnable runnable, @NotNull kotlin.coroutines.f fVar) {
        B();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.l0
    public boolean isDispatchNeeded(@NotNull kotlin.coroutines.f fVar) {
        B();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.z0
    @Nullable
    public Object o(long j4, @NotNull kotlin.coroutines.c<?> cVar) {
        B();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.p2
    @NotNull
    public p2 q() {
        return this;
    }

    @Override // kotlinx.coroutines.l0
    @NotNull
    /* renamed from: t */
    public Void dispatch(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable) {
        B();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.p2, kotlinx.coroutines.l0
    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f60451a != null) {
            str = ", cause=" + this.f60451a;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    public z(@Nullable Throwable th, @Nullable String str) {
        this.f60451a = th;
        this.f60452b = str;
    }
}
