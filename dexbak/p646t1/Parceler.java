package p646t1;

import android.os.Parcel;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Standard;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J#\u0010\b\u001a\u00020\u0007*\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m12616d2 = {"Lt1/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/os/Parcel;", "parcel", "", "flags", "Lkotlin/f1;", "a", "(Ljava/lang/Object;Landroid/os/Parcel;I)V", "b", "(Landroid/os/Parcel;)Ljava/lang/Object;", "size", "", "newArray", "(I)[Ljava/lang/Object;", "kotlin-android-extensions-runtime"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: t1.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Parceler<T> {

    /* compiled from: Parceler.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    /* renamed from: t1.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16193a {
        @NotNull
        /* renamed from: a */
        public static <T> T[] m303a(@NotNull Parceler<T> parceler, int i) {
            C14342f0.m8184p(parceler, "this");
            throw new Standard("Generated by Android Extensions automatically");
        }
    }

    /* renamed from: a */
    void m305a(T t, @NotNull Parcel parcel, int i);

    /* renamed from: b */
    T m304b(@NotNull Parcel parcel);

    @NotNull
    T[] newArray(int i);
}