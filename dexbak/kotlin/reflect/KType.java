package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, m12616d2 = {"Lkotlin/reflect/r;", "Lkotlin/reflect/b;", "Lkotlin/reflect/g;", "o", "()Lkotlin/reflect/g;", "getClassifier$annotations", "()V", "classifier", "", "Lkotlin/reflect/t;", "getArguments", "()Ljava/util/List;", "getArguments$annotations", "arguments", "", "f", "()Z", "isMarkedNullable", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.r */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface KType extends KAnnotatedElement {

    /* compiled from: KType.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.r$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14456a {
        @SinceKotlin(version = "1.1")
        /* renamed from: a */
        public static /* synthetic */ void m7318a() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: b */
        public static /* synthetic */ void m7317b() {
        }
    }

    /* renamed from: f */
    boolean mo7320f();

    @NotNull
    List<KTypeProjection> getArguments();

    @Nullable
    /* renamed from: o */
    KClassifier mo7319o();
}
