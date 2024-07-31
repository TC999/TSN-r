package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.collections._ArraysJvm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0015\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0003R\u001e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, m12616d2 = {"Lkotlinx/coroutines/internal/a;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/f1;", "c", "element", "a", "(Ljava/lang/Object;)V", "e", "()Ljava/lang/Object;", "b", "", "[Ljava/lang/Object;", "elements", "", "I", "head", "tail", "", "d", "()Z", "isEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ArrayQueue<T> {

    /* renamed from: a */
    private Object[] f43025a = new Object[16];

    /* renamed from: b */
    private int f43026b;

    /* renamed from: c */
    private int f43027c;

    /* renamed from: c */
    private final void m4385c() {
        Object[] objArr = this.f43025a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        _ArraysJvm.m11580l1(objArr, objArr2, 0, this.f43026b, 0, 10, null);
        Object[] objArr3 = this.f43025a;
        int length2 = objArr3.length;
        int i = this.f43026b;
        _ArraysJvm.m11580l1(objArr3, objArr2, length2 - i, 0, i, 4, null);
        this.f43025a = objArr2;
        this.f43026b = 0;
        this.f43027c = length;
    }

    /* renamed from: a */
    public final void m4387a(@NotNull T t) {
        Object[] objArr = this.f43025a;
        int i = this.f43027c;
        objArr[i] = t;
        int length = (objArr.length - 1) & (i + 1);
        this.f43027c = length;
        if (length == this.f43026b) {
            m4385c();
        }
    }

    /* renamed from: b */
    public final void m4386b() {
        this.f43026b = 0;
        this.f43027c = 0;
        this.f43025a = new Object[this.f43025a.length];
    }

    /* renamed from: d */
    public final boolean m4384d() {
        return this.f43026b == this.f43027c;
    }

    @Nullable
    /* renamed from: e */
    public final T m4383e() {
        int i = this.f43026b;
        if (i == this.f43027c) {
            return null;
        }
        Object[] objArr = this.f43025a;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.f43026b = (i + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }
}
