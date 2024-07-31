package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H'J\u0013\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0001H¦\u0002J\b\u0010\f\u001a\u00020\u000bH&R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\u001f\u001a\u0004\u0018\u00018\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR \u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R \u0010*\u001a\b\u0012\u0004\u0012\u00020'0 8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010%\u001a\u0004\b(\u0010#R(\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000 8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010%\u001a\u0004\b+\u0010#R\u001c\u00102\u001a\u0004\u0018\u00010.8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010%\u001a\u0004\b/\u00100R\u001a\u00103\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010%\u001a\u0004\b3\u00104R\u001a\u00106\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010%\u001a\u0004\b6\u00104R\u001a\u00108\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010%\u001a\u0004\b8\u00104R\u001a\u0010<\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b;\u0010%\u001a\u0004\b:\u00104R\u001a\u0010?\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b>\u0010%\u001a\u0004\b=\u00104R\u001a\u0010B\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010%\u001a\u0004\b@\u00104R\u001a\u0010E\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bD\u0010%\u001a\u0004\bC\u00104R\u001a\u0010H\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bG\u0010%\u001a\u0004\bF\u00104R\u001a\u0010K\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bJ\u0010%\u001a\u0004\bI\u00104¨\u0006L"}, m12616d2 = {"Lkotlin/reflect/d;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/h;", "Lkotlin/reflect/b;", "Lkotlin/reflect/g;", DomainCampaignEx.LOOPBACK_VALUE, "", "p", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "", "u", "()Ljava/lang/String;", "simpleName", "r", "qualifiedName", "", "Lkotlin/reflect/c;", "a", "()Ljava/util/Collection;", "members", "Lkotlin/reflect/i;", "d", "constructors", "c", "nestedClasses", "j", "()Ljava/lang/Object;", "objectInstance", "", "Lkotlin/reflect/s;", "getTypeParameters", "()Ljava/util/List;", "getTypeParameters$annotations", "()V", "typeParameters", "Lkotlin/reflect/r;", "v", "getSupertypes$annotations", "supertypes", "g", "getSealedSubclasses$annotations", "sealedSubclasses", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility", "isFinal", "()Z", "isFinal$annotations", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "m", "isSealed$annotations", "isSealed", "y", "isData$annotations", "isData", "h", "isInner$annotations", "isInner", C7304t.f25048d, "isCompanion$annotations", "isCompanion", "s", "isFun$annotations", "isFun", UMCommonContent.f37782aL, "isValue$annotations", "isValue", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {

    /* compiled from: KClass.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14437a {
        @SinceKotlin(version = "1.3")
        /* renamed from: a */
        public static /* synthetic */ void m7345a() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: b */
        public static /* synthetic */ void m7344b() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: c */
        public static /* synthetic */ void m7343c() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: d */
        public static /* synthetic */ void m7342d() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: e */
        public static /* synthetic */ void m7341e() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: f */
        public static /* synthetic */ void m7340f() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: g */
        public static /* synthetic */ void m7339g() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: h */
        public static /* synthetic */ void m7338h() {
        }

        @SinceKotlin(version = BuildConfig.VERSION_NAME)
        /* renamed from: i */
        public static /* synthetic */ void m7337i() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: j */
        public static /* synthetic */ void m7336j() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: k */
        public static /* synthetic */ void m7335k() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: l */
        public static /* synthetic */ void m7334l() {
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: m */
        public static /* synthetic */ void m7333m() {
        }
    }

    @Override // kotlin.reflect.KDeclarationContainer
    @NotNull
    /* renamed from: a */
    Collection<KCallable<?>> mo7329a();

    @NotNull
    /* renamed from: c */
    Collection<KClass<?>> mo7359c();

    @NotNull
    /* renamed from: d */
    Collection<KFunction<T>> mo7358d();

    boolean equals(@Nullable Object obj);

    @NotNull
    /* renamed from: g */
    List<KClass<? extends T>> mo7357g();

    @NotNull
    List<KTypeParameter> getTypeParameters();

    @Nullable
    KVisibility getVisibility();

    /* renamed from: h */
    boolean mo7356h();

    int hashCode();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    @Nullable
    /* renamed from: j */
    T mo7355j();

    /* renamed from: l */
    boolean mo7354l();

    /* renamed from: m */
    boolean mo7353m();

    @SinceKotlin(version = "1.1")
    /* renamed from: p */
    boolean mo7352p(@Nullable Object obj);

    @Nullable
    /* renamed from: r */
    String mo7351r();

    /* renamed from: s */
    boolean mo7350s();

    /* renamed from: t */
    boolean mo7349t();

    @Nullable
    /* renamed from: u */
    String mo7348u();

    @NotNull
    /* renamed from: v */
    List<KType> mo7347v();

    /* renamed from: y */
    boolean mo7346y();
}
