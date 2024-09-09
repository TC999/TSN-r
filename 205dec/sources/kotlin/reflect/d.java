package kotlin.reflect;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: KClass.kt */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H'J\u0013\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00a6\u0002J\b\u0010\f\u001a\u00020\u000bH&R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\u001f\u001a\u0004\u0018\u00018\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR \u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R \u0010*\u001a\b\u0012\u0004\u0012\u00020'0 8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b)\u0010%\u001a\u0004\b(\u0010#R(\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000 8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b,\u0010%\u001a\u0004\b+\u0010#R\u001c\u00102\u001a\u0004\u0018\u00010.8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b1\u0010%\u001a\u0004\b/\u00100R\u001a\u00103\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b5\u0010%\u001a\u0004\b3\u00104R\u001a\u00106\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b7\u0010%\u001a\u0004\b6\u00104R\u001a\u00108\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b9\u0010%\u001a\u0004\b8\u00104R\u001a\u0010<\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b;\u0010%\u001a\u0004\b:\u00104R\u001a\u0010?\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b>\u0010%\u001a\u0004\b=\u00104R\u001a\u0010B\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bA\u0010%\u001a\u0004\b@\u00104R\u001a\u0010E\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bD\u0010%\u001a\u0004\bC\u00104R\u001a\u0010H\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bG\u0010%\u001a\u0004\bF\u00104R\u001a\u0010K\u001a\u00020\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\bJ\u0010%\u001a\u0004\bI\u00104\u00a8\u0006L"}, d2 = {"Lkotlin/reflect/d;", "", "T", "Lkotlin/reflect/h;", "Lkotlin/reflect/b;", "Lkotlin/reflect/g;", "value", "", "C", "other", "equals", "", "hashCode", "", "E", "()Ljava/lang/String;", "simpleName", "D", "qualifiedName", "", "Lkotlin/reflect/c;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/Collection;", "members", "Lkotlin/reflect/i;", "g", "constructors", "z", "nestedClasses", "A", "()Ljava/lang/Object;", "objectInstance", "", "Lkotlin/reflect/s;", "getTypeParameters", "()Ljava/util/List;", "getTypeParameters$annotations", "()V", "typeParameters", "Lkotlin/reflect/r;", "j", "getSupertypes$annotations", "supertypes", "m", "getSealedSubclasses$annotations", "sealedSubclasses", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility", "isFinal", "()Z", "isFinal$annotations", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "p", "isSealed$annotations", "isSealed", "y", "isData$annotations", "isData", "n", "isInner$annotations", "isInner", "B", "isCompanion$annotations", "isCompanion", "t", "isFun$annotations", "isFun", "v", "isValue$annotations", "isValue", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface d<T> extends h, b, g {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: KClass.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @SinceKotlin(version = "1.3")
        public static /* synthetic */ void a() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void b() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void c() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void d() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void e() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void f() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void g() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void h() {
        }

        @SinceKotlin(version = "1.4")
        public static /* synthetic */ void i() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void j() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void k() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void l() {
        }

        @SinceKotlin(version = "1.5")
        public static /* synthetic */ void m() {
        }
    }

    @Nullable
    T A();

    boolean B();

    @SinceKotlin(version = "1.1")
    boolean C(@Nullable Object obj);

    @Nullable
    String D();

    @Nullable
    String E();

    boolean equals(@Nullable Object obj);

    @NotNull
    Collection<i<T>> g();

    @NotNull
    List<s> getTypeParameters();

    @Nullable
    KVisibility getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    @NotNull
    List<r> j();

    @NotNull
    List<d<? extends T>> m();

    boolean n();

    boolean p();

    @Override // kotlin.reflect.h
    @NotNull
    Collection<c<?>> q();

    boolean t();

    boolean v();

    boolean y();

    @NotNull
    Collection<d<?>> z();
}
