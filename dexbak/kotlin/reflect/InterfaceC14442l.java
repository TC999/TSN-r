package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;

/* compiled from: KProperty.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u000eJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0004\b\b\u0010\tR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m12616d2 = {"Lkotlin/reflect/l;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/p;", "Lkotlin/reflect/j;", SocialConstants.PARAM_RECEIVER, DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/l$a;", "getSetter", "()Lkotlin/reflect/l$a;", "setter", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14442l<T, V> extends InterfaceC14452p<T, V>, KProperty<V> {

    /* compiled from: KProperty.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, m12616d2 = {"Lkotlin/reflect/l$a;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/j$a;", "Lkotlin/Function2;", "Lkotlin/f1;", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.l$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC14443a<T, V> extends KProperty.InterfaceC14439a<V>, InterfaceC15284p<T, V, Unit> {
    }

    @Override // kotlin.reflect.KProperty
    @NotNull
    InterfaceC14443a<T, V> getSetter();

    void set(T t, V v);
}
