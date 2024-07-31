package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.InterfaceC14446n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* compiled from: KProperty.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\fJ\u000f\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m12616d2 = {"Lkotlin/reflect/o;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/n;", "Lkotlin/Function0;", "get", "()Ljava/lang/Object;", "", "getDelegate", "Lkotlin/reflect/o$a;", "getGetter", "()Lkotlin/reflect/o$a;", "getter", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.o */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14450o<V> extends InterfaceC14446n<V>, InterfaceC15269a<V> {

    /* compiled from: KProperty.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0004"}, m12616d2 = {"Lkotlin/reflect/o$a;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/n$c;", "Lkotlin/Function0;", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.o$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC14451a<V> extends InterfaceC14446n.InterfaceC14449c<V>, InterfaceC15269a<V> {
    }

    V get();

    @SinceKotlin(version = "1.1")
    @Nullable
    Object getDelegate();

    @Override // kotlin.reflect.InterfaceC14446n
    @NotNull
    InterfaceC14451a<V> getGetter();
}
