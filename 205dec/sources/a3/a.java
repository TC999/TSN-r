package a3;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Parceler.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J#\u0010\b\u001a\u00020\u0007*\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\f\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"La3/a;", "T", "", "Landroid/os/Parcel;", "parcel", "", "flags", "Lkotlin/f1;", "a", "(Ljava/lang/Object;Landroid/os/Parcel;I)V", "b", "(Landroid/os/Parcel;)Ljava/lang/Object;", "size", "", "newArray", "(I)[Ljava/lang/Object;", "parcelize-runtime"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface a<T> {

    /* compiled from: Parceler.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: a3.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class C0008a {
        @NotNull
        public static <T> T[] a(@NotNull a<T> aVar, int i4) {
            f0.p(aVar, "this");
            throw new NotImplementedError("Generated by Android Extensions automatically");
        }
    }

    void a(T t3, @NotNull Parcel parcel, int i4);

    T b(@NotNull Parcel parcel);

    @NotNull
    T[] newArray(int i4);
}
