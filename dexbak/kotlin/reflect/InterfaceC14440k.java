package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: KProperty.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m12616d2 = {"Lkotlin/reflect/k;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/o;", "Lkotlin/reflect/j;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "set", "(Ljava/lang/Object;)V", "Lkotlin/reflect/k$a;", "getSetter", "()Lkotlin/reflect/k$a;", "setter", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14440k<V> extends InterfaceC14450o<V>, KProperty<V> {

    /* compiled from: KProperty.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, m12616d2 = {"Lkotlin/reflect/k$a;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/j$a;", "Lkotlin/Function1;", "Lkotlin/f1;", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.k$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC14441a<V> extends KProperty.InterfaceC14439a<V>, InterfaceC15280l<V, Unit> {
    }

    @Override // kotlin.reflect.KProperty
    @NotNull
    InterfaceC14441a<V> getSetter();

    void set(V v);
}
