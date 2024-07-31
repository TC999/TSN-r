package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.comparisons.Comparisons;
import kotlin.jvm.internal.Lambda;
import p617l1.InterfaceC15280l;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collections.kt */
@Metadata(m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", "", "it", "invoke", "(Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1<T> extends Lambda implements InterfaceC15280l<T, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ InterfaceC15280l $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(InterfaceC15280l interfaceC15280l, Comparable comparable) {
        super(1);
        this.$selector = interfaceC15280l;
        this.$key = comparable;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final int invoke2(T t) {
        int m8803g;
        m8803g = Comparisons.m8803g((Comparable) this.$selector.invoke(t), this.$key);
        return m8803g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke2((CollectionsKt__CollectionsKt$binarySearchBy$1<T>) obj));
    }
}
