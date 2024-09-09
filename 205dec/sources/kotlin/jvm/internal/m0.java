package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PrimitiveSpreadBuilders.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001b\u0010\u0014J\u0013\u0010\u0004\u001a\u00020\u0003*\u00028\u0000H$\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\u0004J\u001f\u0010\r\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00168\u0002X\u0082\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0017\u0012\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lkotlin/jvm/internal/m0;", "", "T", "", "c", "(Ljava/lang/Object;)I", "spreadArgument", "Lkotlin/f1;", "a", "(Ljava/lang/Object;)V", "f", "values", "result", "g", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "I", "size", "b", "()I", "e", "(I)V", "position", "", "[Ljava/lang/Object;", "getSpreads$annotations", "()V", "spreads", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class m0<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f55641a;

    /* renamed from: b  reason: collision with root package name */
    private int f55642b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final T[] f55643c;

    public m0(int i4) {
        this.f55641a = i4;
        this.f55643c = (T[]) new Object[i4];
    }

    private static /* synthetic */ void d() {
    }

    public final void a(@NotNull T spreadArgument) {
        f0.p(spreadArgument, "spreadArgument");
        T[] tArr = this.f55643c;
        int i4 = this.f55642b;
        this.f55642b = i4 + 1;
        tArr[i4] = spreadArgument;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b() {
        return this.f55642b;
    }

    protected abstract int c(@NotNull T t3);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(int i4) {
        this.f55642b = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        int i4 = this.f55641a - 1;
        int i5 = 0;
        if (i4 < 0) {
            return 0;
        }
        int i6 = 0;
        while (true) {
            int i7 = i5 + 1;
            T t3 = this.f55643c[i5];
            i6 += t3 == null ? 1 : c(t3);
            if (i5 == i4) {
                return i6;
            }
            i5 = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final T g(@NotNull T values, @NotNull T result) {
        int i4;
        f0.p(values, "values");
        f0.p(result, "result");
        int i5 = this.f55641a - 1;
        int i6 = 0;
        if (i5 >= 0) {
            int i7 = 0;
            int i8 = 0;
            i4 = 0;
            while (true) {
                int i9 = i7 + 1;
                T t3 = this.f55643c[i7];
                if (t3 != null) {
                    if (i8 < i7) {
                        int i10 = i7 - i8;
                        System.arraycopy(values, i8, result, i4, i10);
                        i4 += i10;
                    }
                    int c4 = c(t3);
                    System.arraycopy(t3, 0, result, i4, c4);
                    i4 += c4;
                    i8 = i9;
                }
                if (i7 == i5) {
                    break;
                }
                i7 = i9;
            }
            i6 = i8;
        } else {
            i4 = 0;
        }
        int i11 = this.f55641a;
        if (i6 < i11) {
            System.arraycopy(values, i6, result, i4, i11 - i6);
        }
        return result;
    }
}
