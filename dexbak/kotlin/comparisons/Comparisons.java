package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\u001a[\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u000026\u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004¢\u0006\u0004\b\b\u0010\t\u001aG\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002 \u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003H\u0002¢\u0006\u0004\b\n\u0010\t\u001aC\u0010\f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a_\u0010\u0012\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e2\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u0014\u001a\u00020\u0007\"\f\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a[\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u000026\u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004¢\u0006\u0004\b\u0016\u0010\u0017\u001a>\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0087\bø\u0001\u0000\u001aZ\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\bø\u0001\u0000\u001a>\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0087\bø\u0001\u0000\u001aZ\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\bø\u0001\u0000\u001aR\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0087\bø\u0001\u0000\u001an\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\bø\u0001\u0000\u001aR\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\u0087\bø\u0001\u0000\u001an\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\bø\u0001\u0000\u001ap\u0010#\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u001028\b\u0004\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00070\u001fH\u0087\bø\u0001\u0000\u001aO\u0010$\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010H\u0086\u0004\u001aO\u0010%\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010H\u0086\u0004\u001a@\u0010'\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\b\b\u0000\u0010\u0000*\u00020&2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010\u001a-\u0010(\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0087\b\u001a@\u0010)\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\b\b\u0000\u0010\u0000*\u00020&2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010\u001a-\u0010*\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0087\b\u001a&\u0010+\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005\u001a&\u0010,\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005\u001a0\u0010-\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "a", "b", "", "Lkotlin/Function1;", "", "selectors", "", "j", "(Ljava/lang/Object;Ljava/lang/Object;[Ll1/l;)I", "k", "selector", "i", "(Ljava/lang/Object;Ljava/lang/Object;Ll1/l;)I", "K", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "h", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Ll1/l;)I", "g", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "d", "([Ll1/l;)Ljava/util/Comparator;", "c", "f", "e", "u", UMCommonContent.f37782aL, IAdInterListener.AdReqParam.WIDTH, "v", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comparison", "x", "s", "y", "", "n", "m", "p", "o", C7304t.f25048d, CampaignEx.JSON_KEY_AD_Q, "r", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/comparisons/ComparisonsKt")
/* renamed from: kotlin.comparisons.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Comparisons {

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14242a<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15280l[] f40987a;

        C14242a(InterfaceC15280l[] interfaceC15280lArr) {
            this.f40987a = interfaceC15280lArr;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return Comparisons.m8799k(t, t2, this.f40987a);
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14243b<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15280l f40988a;

        public C14243b(InterfaceC15280l interfaceC15280l) {
            this.f40988a = interfaceC15280l;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            m8803g = Comparisons.m8803g((Comparable) this.f40988a.invoke(t), (Comparable) this.f40988a.invoke(t2));
            return m8803g;
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14244c<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f40989a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l f40990b;

        public C14244c(Comparator comparator, InterfaceC15280l interfaceC15280l) {
            this.f40989a = comparator;
            this.f40990b = interfaceC15280l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return this.f40989a.compare(this.f40990b.invoke(t), this.f40990b.invoke(t2));
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14245d<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15280l f40991a;

        public C14245d(InterfaceC15280l interfaceC15280l) {
            this.f40991a = interfaceC15280l;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            m8803g = Comparisons.m8803g((Comparable) this.f40991a.invoke(t2), (Comparable) this.f40991a.invoke(t));
            return m8803g;
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14246e<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f40992a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l f40993b;

        public C14246e(Comparator comparator, InterfaceC15280l interfaceC15280l) {
            this.f40992a = comparator;
            this.f40993b = interfaceC15280l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return this.f40992a.compare(this.f40993b.invoke(t2), this.f40993b.invoke(t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "a", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14247f<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f40994a;

        C14247f(Comparator comparator) {
            this.f40994a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@Nullable T t, @Nullable T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return -1;
            }
            if (t2 == null) {
                return 1;
            }
            return this.f40994a.compare(t, t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "a", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14248g<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f40995a;

        C14248g(Comparator comparator) {
            this.f40995a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@Nullable T t, @Nullable T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return 1;
            }
            if (t2 == null) {
                return -1;
            }
            return this.f40995a.compare(t, t2);
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14249h<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f40996a;

        /* renamed from: b */
        final /* synthetic */ Comparator f40997b;

        C14249h(Comparator comparator, Comparator comparator2) {
            this.f40996a = comparator;
            this.f40997b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f40996a.compare(t, t2);
            return compare != 0 ? compare : this.f40997b.compare(t, t2);
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14250i<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f40998a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l f40999b;

        public C14250i(Comparator comparator, InterfaceC15280l interfaceC15280l) {
            this.f40998a = comparator;
            this.f40999b = interfaceC15280l;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            int compare = this.f40998a.compare(t, t2);
            if (compare != 0) {
                return compare;
            }
            m8803g = Comparisons.m8803g((Comparable) this.f40999b.invoke(t), (Comparable) this.f40999b.invoke(t2));
            return m8803g;
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14251j<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f41000a;

        /* renamed from: b */
        final /* synthetic */ Comparator f41001b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l f41002c;

        public C14251j(Comparator comparator, Comparator comparator2, InterfaceC15280l interfaceC15280l) {
            this.f41000a = comparator;
            this.f41001b = comparator2;
            this.f41002c = interfaceC15280l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f41000a.compare(t, t2);
            return compare != 0 ? compare : this.f41001b.compare(this.f41002c.invoke(t), this.f41002c.invoke(t2));
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$k */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14252k<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f41003a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l f41004b;

        public C14252k(Comparator comparator, InterfaceC15280l interfaceC15280l) {
            this.f41003a = comparator;
            this.f41004b = interfaceC15280l;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            int compare = this.f41003a.compare(t, t2);
            if (compare != 0) {
                return compare;
            }
            m8803g = Comparisons.m8803g((Comparable) this.f41004b.invoke(t2), (Comparable) this.f41004b.invoke(t));
            return m8803g;
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$l */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14253l<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f41005a;

        /* renamed from: b */
        final /* synthetic */ Comparator f41006b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l f41007c;

        public C14253l(Comparator comparator, Comparator comparator2, InterfaceC15280l interfaceC15280l) {
            this.f41005a = comparator;
            this.f41006b = comparator2;
            this.f41007c = interfaceC15280l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f41005a.compare(t, t2);
            return compare != 0 ? compare : this.f41006b.compare(this.f41007c.invoke(t2), this.f41007c.invoke(t));
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$m */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14254m<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f41008a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15284p f41009b;

        public C14254m(Comparator comparator, InterfaceC15284p interfaceC15284p) {
            this.f41008a = comparator;
            this.f41009b = interfaceC15284p;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f41008a.compare(t, t2);
            return compare != 0 ? compare : ((Number) this.f41009b.invoke(t, t2)).intValue();
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.comparisons.b$n */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14255n<T> implements Comparator {

        /* renamed from: a */
        final /* synthetic */ Comparator f41010a;

        /* renamed from: b */
        final /* synthetic */ Comparator f41011b;

        C14255n(Comparator comparator, Comparator comparator2) {
            this.f41010a = comparator;
            this.f41011b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f41010a.compare(t, t2);
            return compare != 0 ? compare : this.f41011b.compare(t2, t);
        }
    }

    @InlineOnly
    /* renamed from: b */
    private static final <T, K> Comparator<T> m8808b(Comparator<? super K> comparator, InterfaceC15280l<? super T, ? extends K> interfaceC15280l) {
        return new C14244c(comparator, interfaceC15280l);
    }

    @InlineOnly
    /* renamed from: c */
    private static final <T> Comparator<T> m8807c(InterfaceC15280l<? super T, ? extends Comparable<?>> interfaceC15280l) {
        return new C14243b(interfaceC15280l);
    }

    @NotNull
    /* renamed from: d */
    public static final <T> Comparator<T> m8806d(@NotNull InterfaceC15280l<? super T, ? extends Comparable<?>>... selectors) {
        C14342f0.m8184p(selectors, "selectors");
        if (selectors.length > 0) {
            return new C14242a(selectors);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @InlineOnly
    /* renamed from: e */
    private static final <T, K> Comparator<T> m8805e(Comparator<? super K> comparator, InterfaceC15280l<? super T, ? extends K> interfaceC15280l) {
        return new C14246e(comparator, interfaceC15280l);
    }

    @InlineOnly
    /* renamed from: f */
    private static final <T> Comparator<T> m8804f(InterfaceC15280l<? super T, ? extends Comparable<?>> interfaceC15280l) {
        return new C14245d(interfaceC15280l);
    }

    /* renamed from: g */
    public static <T extends Comparable<?>> int m8803g(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    @InlineOnly
    /* renamed from: h */
    private static final <T, K> int m8802h(T t, T t2, Comparator<? super K> comparator, InterfaceC15280l<? super T, ? extends K> interfaceC15280l) {
        return comparator.compare((K) interfaceC15280l.invoke(t), (K) interfaceC15280l.invoke(t2));
    }

    @InlineOnly
    /* renamed from: i */
    private static final <T> int m8801i(T t, T t2, InterfaceC15280l<? super T, ? extends Comparable<?>> interfaceC15280l) {
        int m8803g;
        m8803g = m8803g(interfaceC15280l.invoke(t), interfaceC15280l.invoke(t2));
        return m8803g;
    }

    /* renamed from: j */
    public static final <T> int m8800j(T t, T t2, @NotNull InterfaceC15280l<? super T, ? extends Comparable<?>>... selectors) {
        C14342f0.m8184p(selectors, "selectors");
        if (selectors.length > 0) {
            return m8799k(t, t2, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static final <T> int m8799k(T t, T t2, InterfaceC15280l<? super T, ? extends Comparable<?>>[] interfaceC15280lArr) {
        int m8803g;
        for (InterfaceC15280l<? super T, ? extends Comparable<?>> interfaceC15280l : interfaceC15280lArr) {
            m8803g = m8803g(interfaceC15280l.invoke(t), interfaceC15280l.invoke(t2));
            if (m8803g != 0) {
                return m8803g;
            }
        }
        return 0;
    }

    @NotNull
    /* renamed from: l */
    public static <T extends Comparable<? super T>> Comparator<T> m8798l() {
        C14256e c14256e = C14256e.f41012a;
        if (c14256e != null) {
            return c14256e;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }

    @InlineOnly
    /* renamed from: m */
    private static final <T extends Comparable<? super T>> Comparator<T> m8797m() {
        Comparator m8798l;
        m8798l = m8798l();
        return m8796n(m8798l);
    }

    @NotNull
    /* renamed from: n */
    public static final <T> Comparator<T> m8796n(@NotNull Comparator<? super T> comparator) {
        C14342f0.m8184p(comparator, "comparator");
        return new C14247f(comparator);
    }

    @InlineOnly
    /* renamed from: o */
    private static final <T extends Comparable<? super T>> Comparator<T> m8795o() {
        Comparator m8798l;
        m8798l = m8798l();
        return m8794p(m8798l);
    }

    @NotNull
    /* renamed from: p */
    public static final <T> Comparator<T> m8794p(@NotNull Comparator<? super T> comparator) {
        C14342f0.m8184p(comparator, "comparator");
        return new C14248g(comparator);
    }

    @NotNull
    /* renamed from: q */
    public static <T extends Comparable<? super T>> Comparator<T> m8793q() {
        C14257f c14257f = C14257f.f41013a;
        if (c14257f != null) {
            return c14257f;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }

    @NotNull
    /* renamed from: r */
    public static final <T> Comparator<T> m8792r(@NotNull Comparator<T> reversed) {
        C14342f0.m8184p(reversed, "$this$reversed");
        if (reversed instanceof C14258g) {
            return ((C14258g) reversed).m8734a();
        }
        Comparator<T> comparator = C14256e.f41012a;
        if (C14342f0.m8193g(reversed, comparator)) {
            C14257f c14257f = C14257f.f41013a;
            if (c14257f != null) {
                return c14257f;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        }
        if (!C14342f0.m8193g(reversed, C14257f.f41013a)) {
            comparator = new C14258g<>(reversed);
        } else if (comparator == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        }
        return comparator;
    }

    @NotNull
    /* renamed from: s */
    public static final <T> Comparator<T> m8791s(@NotNull Comparator<T> then, @NotNull Comparator<? super T> comparator) {
        C14342f0.m8184p(then, "$this$then");
        C14342f0.m8184p(comparator, "comparator");
        return new C14249h(then, comparator);
    }

    @InlineOnly
    /* renamed from: t */
    private static final <T, K> Comparator<T> m8790t(Comparator<T> comparator, Comparator<? super K> comparator2, InterfaceC15280l<? super T, ? extends K> interfaceC15280l) {
        return new C14251j(comparator, comparator2, interfaceC15280l);
    }

    @InlineOnly
    /* renamed from: u */
    private static final <T> Comparator<T> m8789u(Comparator<T> comparator, InterfaceC15280l<? super T, ? extends Comparable<?>> interfaceC15280l) {
        return new C14250i(comparator, interfaceC15280l);
    }

    @InlineOnly
    /* renamed from: v */
    private static final <T, K> Comparator<T> m8788v(Comparator<T> comparator, Comparator<? super K> comparator2, InterfaceC15280l<? super T, ? extends K> interfaceC15280l) {
        return new C14253l(comparator, comparator2, interfaceC15280l);
    }

    @InlineOnly
    /* renamed from: w */
    private static final <T> Comparator<T> m8787w(Comparator<T> comparator, InterfaceC15280l<? super T, ? extends Comparable<?>> interfaceC15280l) {
        return new C14252k(comparator, interfaceC15280l);
    }

    @InlineOnly
    /* renamed from: x */
    private static final <T> Comparator<T> m8786x(Comparator<T> comparator, InterfaceC15284p<? super T, ? super T, Integer> interfaceC15284p) {
        return new C14254m(comparator, interfaceC15284p);
    }

    @NotNull
    /* renamed from: y */
    public static final <T> Comparator<T> m8785y(@NotNull Comparator<T> thenDescending, @NotNull Comparator<? super T> comparator) {
        C14342f0.m8184p(thenDescending, "$this$thenDescending");
        C14342f0.m8184p(comparator, "comparator");
        return new C14255n(thenDescending, comparator);
    }
}
