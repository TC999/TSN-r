package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IteratorsJVM;
import kotlin.internal.InlineOnly;

/* compiled from: SequencesJVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b¨\u0006\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Enumeration;", "Lkotlin/sequences/m;", "f", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/sequences/SequencesKt")
/* renamed from: kotlin.sequences.r */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14519r extends C14516q {
    @InlineOnly
    /* renamed from: f */
    private static final <T> Sequence<T> m6992f(Enumeration<T> enumeration) {
        Iterator m8935f0;
        Sequence<T> m6990h;
        m8935f0 = IteratorsJVM.m8935f0(enumeration);
        m6990h = C14520s.m6990h(m8935f0);
        return m6990h;
    }
}
