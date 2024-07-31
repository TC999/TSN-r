package kotlin.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: PrimitiveSpreadBuilders.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u0013J\u0013\u0010\u0004\u001a\u00020\u0003*\u00028\u0000H$¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\u0004J\u001f\u0010\r\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00158\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000f¨\u0006\u001c"}, m12616d2 = {"Lkotlin/jvm/internal/m0;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "c", "(Ljava/lang/Object;)I", "spreadArgument", "Lkotlin/f1;", "a", "(Ljava/lang/Object;)V", "f", "values", CommonNetImpl.RESULT, "g", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "I", "b", "()I", "e", "(I)V", "position", "", "[Ljava/lang/Object;", "getSpreads$annotations", "()V", "spreads", "size", "<init>", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.m0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14353m0<T> {

    /* renamed from: a */
    private int f41151a;

    /* renamed from: b */
    private final T[] f41152b;

    /* renamed from: c */
    private final int f41153c;

    public AbstractC14353m0(int i) {
        this.f41153c = i;
        this.f41152b = (T[]) new Object[i];
    }

    /* renamed from: d */
    private static /* synthetic */ void m8135d() {
    }

    /* renamed from: a */
    public final void m8137a(@NotNull T spreadArgument) {
        C14342f0.m8184p(spreadArgument, "spreadArgument");
        T[] tArr = this.f41152b;
        int i = this.f41151a;
        this.f41151a = i + 1;
        tArr[i] = spreadArgument;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final int m8136b() {
        return this.f41151a;
    }

    /* renamed from: c */
    protected abstract int mo7965c(@NotNull T t);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final void m8134e(int i) {
        this.f41151a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final int m8133f() {
        int i = this.f41153c - 1;
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            while (true) {
                T t = this.f41152b[i3];
                i2 += t != null ? mo7965c(t) : 1;
                if (i3 == i) {
                    break;
                }
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: g */
    public final T m8132g(@NotNull T values, @NotNull T result) {
        int i;
        C14342f0.m8184p(values, "values");
        C14342f0.m8184p(result, "result");
        int i2 = this.f41153c - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int i4 = 0;
            int i5 = 0;
            i = 0;
            while (true) {
                T t = this.f41152b[i4];
                if (t != null) {
                    if (i5 < i4) {
                        int i6 = i4 - i5;
                        System.arraycopy(values, i5, result, i, i6);
                        i += i6;
                    }
                    int mo7965c = mo7965c(t);
                    System.arraycopy(t, 0, result, i, mo7965c);
                    i += mo7965c;
                    i5 = i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4++;
            }
            i3 = i5;
        } else {
            i = 0;
        }
        int i7 = this.f41153c;
        if (i3 < i7) {
            System.arraycopy(values, i3, result, i, i7 - i3);
        }
        return result;
    }
}
