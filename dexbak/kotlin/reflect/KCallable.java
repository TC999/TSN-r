package kotlin.reflect;

import androidx.core.app.NotificationCompat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J'\u0010\u0006\u001a\u00028\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00028\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH&¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010!\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001b\u001a\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001b\u001a\u0004\b&\u0010$R\u001a\u0010(\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u001b\u001a\u0004\b(\u0010$R\u001a\u0010*\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001b\u001a\u0004\b*\u0010$¨\u0006,"}, m12616d2 = {"Lkotlin/reflect/c;", "R", "Lkotlin/reflect/b;", "", "", "args", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "", "Lkotlin/reflect/KParameter;", "callBy", "(Ljava/util/Map;)Ljava/lang/Object;", "", "getName", "()Ljava/lang/String;", "name", "", "getParameters", "()Ljava/util/List;", "parameters", "Lkotlin/reflect/r;", "getReturnType", "()Lkotlin/reflect/r;", "returnType", "Lkotlin/reflect/s;", "getTypeParameters", "getTypeParameters$annotations", "()V", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility", "", "isFinal", "()Z", "isFinal$annotations", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSuspend", "isSuspend$annotations", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface KCallable<R> extends KAnnotatedElement {

    /* compiled from: KCallable.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14436a {
        @SinceKotlin(version = "1.1")
        /* renamed from: a */
        public static /* synthetic */ void m7365a() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: b */
        public static /* synthetic */ void m7364b() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: c */
        public static /* synthetic */ void m7363c() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: d */
        public static /* synthetic */ void m7362d() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: e */
        public static /* synthetic */ void m7361e() {
        }

        @SinceKotlin(version = "1.3")
        /* renamed from: f */
        public static /* synthetic */ void m7360f() {
        }
    }

    R call(@NotNull Object... objArr);

    R callBy(@NotNull Map<KParameter, ? extends Object> map);

    @NotNull
    String getName();

    @NotNull
    List<KParameter> getParameters();

    @NotNull
    KType getReturnType();

    @NotNull
    List<KTypeParameter> getTypeParameters();

    @Nullable
    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
