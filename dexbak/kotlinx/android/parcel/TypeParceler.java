package kotlinx.android.parcel;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Repeatable;
import p646t1.Parceler;

/* compiled from: TypeParceler.kt */
@Target({ElementType.TYPE})
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0010\b\u0001\u0010\u0003*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u00020\u0004B\u0000¨\u0006\u0005"}, m12616d2 = {"Lkotlinx/android/parcel/TypeParceler;", ExifInterface.GPS_DIRECTION_TRUE, "Lt1/a;", "P", "", "kotlin-android-extensions-runtime"}, m12615k = 1, m12614mv = {1, 5, 1})
@Repeatable
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public @interface TypeParceler<T, P extends Parceler<? super T>> {
}
