package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: KProperty.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002\u000e\u000fR\u001a\u0010\u0004\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0007\u001a\u0004\b\b\u0010\u0005R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m12616d2 = {"Lkotlin/reflect/n;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/c;", "", "isLateinit", "()Z", "isLateinit$annotations", "()V", "isConst", "isConst$annotations", "Lkotlin/reflect/n$c;", "getGetter", "()Lkotlin/reflect/n$c;", "getter", "a", "c", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14446n<V> extends KCallable<V> {

    /* compiled from: KProperty.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, m12616d2 = {"Lkotlin/reflect/n$a;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlin/reflect/n;", "a", "()Lkotlin/reflect/n;", "property", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.n$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC14447a<V> {
        @NotNull
        /* renamed from: a */
        InterfaceC14446n<V> m7323a();
    }

    /* compiled from: KProperty.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.n$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14448b {
        @SinceKotlin(version = "1.1")
        /* renamed from: a */
        public static /* synthetic */ void m7322a() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: b */
        public static /* synthetic */ void m7321b() {
        }
    }

    /* compiled from: KProperty.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0004"}, m12616d2 = {"Lkotlin/reflect/n$c;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/n$a;", "Lkotlin/reflect/i;", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.n$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC14449c<V> extends InterfaceC14447a<V>, KFunction<V> {
    }

    @NotNull
    InterfaceC14449c<V> getGetter();

    boolean isConst();

    boolean isLateinit();
}
