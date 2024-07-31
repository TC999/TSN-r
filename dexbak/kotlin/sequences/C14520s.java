package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C14294d0;
import kotlin.C14372l0;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MutableCollections;
import kotlin.collections._Arrays;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\u001a.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u0087\bø\u0001\u0000\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\"\u00028\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0087\b\u001a2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0001H\u0007\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004\u001a+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aE\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a@\u0010\u0019\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00180\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0013*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u0004\u001a\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u001a&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0007\u001ab\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u001e\"\u0004\b\u0002\u0010\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00020\u0014H\u0000\u001a\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004\u001a&\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020%2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001\u001a?\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020%2\b\u0010(\u001a\u0004\u0018\u00018\u00002\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0007¢\u0006\u0004\b)\u0010*\u001a<\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020%2\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "", "iterator", "Lkotlin/sequences/m;", "g", "h", "", "elements", UMCommonContent.f37782aL, "([Ljava/lang/Object;)Lkotlin/sequences/m;", "j", "s", "defaultValue", "r", C7304t.f25048d, "", "n", "(Lkotlin/sequences/m;)Lkotlin/sequences/m;", "R", "Lkotlin/Function1;", "m", "(Lkotlin/sequences/m;Ll1/l;)Lkotlin/sequences/m;", "Lkotlin/Pair;", "", IAdInterListener.AdReqParam.WIDTH, "u", "Lkotlin/random/Random;", "random", "v", "C", SocialConstants.PARAM_SOURCE, "Lkotlin/Function2;", "", "transform", "k", "i", "", "nextFunction", "p", "seed", "o", "(Ljava/lang/Object;Ll1/l;)Lkotlin/sequences/m;", "seedFunction", CampaignEx.JSON_KEY_AD_Q, "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/sequences/SequencesKt")
/* renamed from: kotlin.sequences.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14520s extends C14519r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004"}, m12616d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.s$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14521a<T> implements Sequence<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15269a f41479a;

        public C14521a(InterfaceC15269a interfaceC15269a) {
            this.f41479a = interfaceC15269a;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            return (Iterator) this.f41479a.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, m12616d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.s$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14522b<T> implements Sequence<T> {

        /* renamed from: a */
        final /* synthetic */ Iterator f41480a;

        public C14522b(Iterator it) {
            this.f41480a = it;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            return this.f41480a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "C", "R", "Lkotlin/sequences/o;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", m8638f = "Sequences.kt", m8637i = {}, m8636l = {332}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: kotlin.sequences.s$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14523c<R> extends RestrictedSuspendLambda implements InterfaceC15284p<AbstractC14514o<? super R>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private /* synthetic */ Object f41481a;

        /* renamed from: b */
        Object f41482b;

        /* renamed from: c */
        int f41483c;

        /* renamed from: d */
        int f41484d;

        /* renamed from: e */
        final /* synthetic */ Sequence f41485e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15284p f41486f;

        /* renamed from: g */
        final /* synthetic */ InterfaceC15280l f41487g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14523c(Sequence sequence, InterfaceC15284p interfaceC15284p, InterfaceC15280l interfaceC15280l, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f41485e = sequence;
            this.f41486f = interfaceC15284p;
            this.f41487g = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
            C14342f0.m8184p(completion, "completion");
            C14523c c14523c = new C14523c(this.f41485e, this.f41486f, this.f41487g, completion);
            c14523c.f41481a = obj;
            return c14523c;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14523c) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            int i;
            Iterator it;
            AbstractC14514o abstractC14514o;
            m8642h = C14287b.m8642h();
            int i2 = this.f41484d;
            if (i2 == 0) {
                C14294d0.m8596n(obj);
                i = 0;
                it = this.f41485e.iterator();
                abstractC14514o = (AbstractC14514o) this.f41481a;
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                i = this.f41483c;
                it = (Iterator) this.f41482b;
                abstractC14514o = (AbstractC14514o) this.f41481a;
                C14294d0.m8596n(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                InterfaceC15284p interfaceC15284p = this.f41486f;
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.m12460W();
                }
                Object invoke = interfaceC15284p.invoke(boxing.m8626f(i), next);
                this.f41481a = abstractC14514o;
                this.f41482b = it;
                this.f41483c = i3;
                this.f41484d = 1;
                if (abstractC14514o.mo7016g((Iterator) this.f41487g.invoke(invoke), this) == m8642h) {
                    return m8642h;
                }
                i = i3;
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "it", "", "a", "(Lkotlin/sequences/m;)Ljava/util/Iterator;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.s$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14524d<T> extends Lambda implements InterfaceC15280l<Sequence<? extends T>, Iterator<? extends T>> {

        /* renamed from: a */
        public static final C14524d f41488a = new C14524d();

        C14524d() {
            super(1);
        }

        @Override // p617l1.InterfaceC15280l
        @NotNull
        /* renamed from: a */
        public final Iterator<T> invoke(@NotNull Sequence<? extends T> it) {
            C14342f0.m8184p(it, "it");
            return (Iterator<? extends T>) it.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "a", "(Ljava/lang/Iterable;)Ljava/util/Iterator;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.s$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14525e<T> extends Lambda implements InterfaceC15280l<Iterable<? extends T>, Iterator<? extends T>> {

        /* renamed from: a */
        public static final C14525e f41489a = new C14525e();

        C14525e() {
            super(1);
        }

        @Override // p617l1.InterfaceC15280l
        @NotNull
        /* renamed from: a */
        public final Iterator<T> invoke(@NotNull Iterable<? extends T> it) {
            C14342f0.m8184p(it, "it");
            return (Iterator<? extends T>) it.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12617d1 = {"\u0000\u0004\n\u0002\b\u0006\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "R", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.s$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14526f<T> extends Lambda implements InterfaceC15280l<T, T> {

        /* renamed from: a */
        public static final C14526f f41490a = new C14526f();

        C14526f() {
            super(1);
        }

        @Override // p617l1.InterfaceC15280l
        public final T invoke(T t) {
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12617d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.s$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14527g<T> extends Lambda implements InterfaceC15280l<T, T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15269a f41491a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14527g(InterfaceC15269a interfaceC15269a) {
            super(1);
            this.f41491a = interfaceC15269a;
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        public final T invoke(@NotNull T it) {
            C14342f0.m8184p(it, "it");
            return (T) this.f41491a.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12617d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()Ljava/lang/Object;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.s$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14528h<T> extends Lambda implements InterfaceC15269a<T> {

        /* renamed from: a */
        final /* synthetic */ Object f41492a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14528h(Object obj) {
            super(0);
            this.f41492a = obj;
        }

        @Override // p617l1.InterfaceC15269a
        @Nullable
        public final T invoke() {
            return (T) this.f41492a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/o;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", m8638f = "Sequences.kt", m8637i = {}, m8636l = {69, 71}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: kotlin.sequences.s$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14529i<T> extends RestrictedSuspendLambda implements InterfaceC15284p<AbstractC14514o<? super T>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private /* synthetic */ Object f41493a;

        /* renamed from: b */
        int f41494b;

        /* renamed from: c */
        final /* synthetic */ Sequence f41495c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC15269a f41496d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14529i(Sequence sequence, InterfaceC15269a interfaceC15269a, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f41495c = sequence;
            this.f41496d = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
            C14342f0.m8184p(completion, "completion");
            C14529i c14529i = new C14529i(this.f41495c, this.f41496d, completion);
            c14529i.f41493a = obj;
            return c14529i;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14529i) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f41494b;
            if (i == 0) {
                C14294d0.m8596n(obj);
                AbstractC14514o abstractC14514o = (AbstractC14514o) this.f41493a;
                Iterator<? extends T> it = this.f41495c.iterator();
                if (it.hasNext()) {
                    this.f41494b = 1;
                    if (abstractC14514o.mo7016g(it, this) == m8642h) {
                        return m8642h;
                    }
                } else {
                    this.f41494b = 2;
                    if (abstractC14514o.m7015h((Sequence) this.f41496d.invoke(), this) == m8642h) {
                        return m8642h;
                    }
                }
            } else if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/o;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", m8638f = "Sequences.kt", m8637i = {}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: kotlin.sequences.s$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14530j<T> extends RestrictedSuspendLambda implements InterfaceC15284p<AbstractC14514o<? super T>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private /* synthetic */ Object f41497a;

        /* renamed from: b */
        Object f41498b;

        /* renamed from: c */
        int f41499c;

        /* renamed from: d */
        final /* synthetic */ Sequence f41500d;

        /* renamed from: e */
        final /* synthetic */ Random f41501e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14530j(Sequence sequence, Random random, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f41500d = sequence;
            this.f41501e = random;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
            C14342f0.m8184p(completion, "completion");
            C14530j c14530j = new C14530j(this.f41500d, this.f41501e, completion);
            c14530j.f41497a = obj;
            return c14530j;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14530j) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            List m7185W2;
            AbstractC14514o abstractC14514o;
            Object m12425N0;
            m8642h = C14287b.m8642h();
            int i = this.f41499c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                m7185W2 = _Sequences.m7185W2(this.f41500d);
                abstractC14514o = (AbstractC14514o) this.f41497a;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                m7185W2 = (List) this.f41498b;
                abstractC14514o = (AbstractC14514o) this.f41497a;
                C14294d0.m8596n(obj);
            }
            while (!m7185W2.isEmpty()) {
                int nextInt = this.f41501e.nextInt(m7185W2.size());
                m12425N0 = MutableCollections.m12425N0(m7185W2);
                if (nextInt < m7185W2.size()) {
                    m12425N0 = m7185W2.set(nextInt, m12425N0);
                }
                this.f41497a = abstractC14514o;
                this.f41498b = m7185W2;
                this.f41499c = 1;
                if (abstractC14514o.mo7018c(m12425N0, this) == m8642h) {
                    return m8642h;
                }
            }
            return Unit.f41048a;
        }
    }

    @InlineOnly
    /* renamed from: g */
    private static final <T> Sequence<T> m6991g(InterfaceC15269a<? extends Iterator<? extends T>> interfaceC15269a) {
        return new C14521a(interfaceC15269a);
    }

    @NotNull
    /* renamed from: h */
    public static <T> Sequence<T> m6990h(@NotNull Iterator<? extends T> asSequence) {
        Sequence<T> m6989i;
        C14342f0.m8184p(asSequence, "$this$asSequence");
        m6989i = m6989i(new C14522b(asSequence));
        return m6989i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: i */
    public static <T> Sequence<T> m6989i(@NotNull Sequence<? extends T> constrainOnce) {
        C14342f0.m8184p(constrainOnce, "$this$constrainOnce");
        return constrainOnce instanceof SequencesJVM ? constrainOnce : new SequencesJVM(constrainOnce);
    }

    @NotNull
    /* renamed from: j */
    public static <T> Sequence<T> m6988j() {
        return C14503g.f41438a;
    }

    @NotNull
    /* renamed from: k */
    public static final <T, C, R> Sequence<R> m6987k(@NotNull Sequence<? extends T> source, @NotNull InterfaceC15284p<? super Integer, ? super T, ? extends C> transform, @NotNull InterfaceC15280l<? super C, ? extends Iterator<? extends R>> iterator) {
        Sequence<R> m6993e;
        C14342f0.m8184p(source, "source");
        C14342f0.m8184p(transform, "transform");
        C14342f0.m8184p(iterator, "iterator");
        m6993e = C14516q.m6993e(new C14523c(source, transform, iterator, null));
        return m6993e;
    }

    @NotNull
    /* renamed from: l */
    public static final <T> Sequence<T> m6986l(@NotNull Sequence<? extends Sequence<? extends T>> flatten) {
        C14342f0.m8184p(flatten, "$this$flatten");
        return m6985m(flatten, C14524d.f41488a);
    }

    /* renamed from: m */
    private static final <T, R> Sequence<R> m6985m(Sequence<? extends T> sequence, InterfaceC15280l<? super T, ? extends Iterator<? extends R>> interfaceC15280l) {
        if (sequence instanceof C14540y) {
            return ((C14540y) sequence).m6936e(interfaceC15280l);
        }
        return new C14506i(sequence, C14526f.f41490a, interfaceC15280l);
    }

    @JvmName(name = "flattenSequenceOfIterable")
    @NotNull
    /* renamed from: n */
    public static final <T> Sequence<T> m6984n(@NotNull Sequence<? extends Iterable<? extends T>> flatten) {
        C14342f0.m8184p(flatten, "$this$flatten");
        return m6985m(flatten, C14525e.f41489a);
    }

    @LowPriorityInOverloadResolution
    @NotNull
    /* renamed from: o */
    public static <T> Sequence<T> m6983o(@Nullable T t, @NotNull InterfaceC15280l<? super T, ? extends T> nextFunction) {
        C14342f0.m8184p(nextFunction, "nextFunction");
        if (t == null) {
            return C14503g.f41438a;
        }
        return new C14508j(new C14528h(t), nextFunction);
    }

    @NotNull
    /* renamed from: p */
    public static final <T> Sequence<T> m6982p(@NotNull InterfaceC15269a<? extends T> nextFunction) {
        Sequence<T> m6989i;
        C14342f0.m8184p(nextFunction, "nextFunction");
        m6989i = m6989i(new C14508j(nextFunction, new C14527g(nextFunction)));
        return m6989i;
    }

    @NotNull
    /* renamed from: q */
    public static <T> Sequence<T> m6981q(@NotNull InterfaceC15269a<? extends T> seedFunction, @NotNull InterfaceC15280l<? super T, ? extends T> nextFunction) {
        C14342f0.m8184p(seedFunction, "seedFunction");
        C14342f0.m8184p(nextFunction, "nextFunction");
        return new C14508j(seedFunction, nextFunction);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: r */
    public static final <T> Sequence<T> m6980r(@NotNull Sequence<? extends T> ifEmpty, @NotNull InterfaceC15269a<? extends Sequence<? extends T>> defaultValue) {
        Sequence<T> m6993e;
        C14342f0.m8184p(ifEmpty, "$this$ifEmpty");
        C14342f0.m8184p(defaultValue, "defaultValue");
        m6993e = C14516q.m6993e(new C14529i(ifEmpty, defaultValue, null));
        return m6993e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: s */
    private static final <T> Sequence<T> m6979s(Sequence<? extends T> sequence) {
        Sequence<T> m6988j;
        if (sequence != 0) {
            return sequence;
        }
        m6988j = m6988j();
        return m6988j;
    }

    @NotNull
    /* renamed from: t */
    public static final <T> Sequence<T> m6978t(@NotNull T... elements) {
        Sequence<T> m10417h5;
        Sequence<T> m6988j;
        C14342f0.m8184p(elements, "elements");
        if (elements.length == 0) {
            m6988j = m6988j();
            return m6988j;
        }
        m10417h5 = _Arrays.m10417h5(elements);
        return m10417h5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    /* renamed from: u */
    public static final <T> Sequence<T> m6977u(@NotNull Sequence<? extends T> shuffled) {
        C14342f0.m8184p(shuffled, "$this$shuffled");
        return m6976v(shuffled, Random.Default);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    /* renamed from: v */
    public static final <T> Sequence<T> m6976v(@NotNull Sequence<? extends T> shuffled, @NotNull Random random) {
        Sequence<T> m6993e;
        C14342f0.m8184p(shuffled, "$this$shuffled");
        C14342f0.m8184p(random, "random");
        m6993e = C14516q.m6993e(new C14530j(shuffled, random, null));
        return m6993e;
    }

    @NotNull
    /* renamed from: w */
    public static final <T, R> Tuples<List<T>, List<R>> m6975w(@NotNull Sequence<? extends Tuples<? extends T, ? extends R>> unzip) {
        C14342f0.m8184p(unzip, "$this$unzip");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Tuples<? extends T, ? extends R> tuples : unzip) {
            arrayList.add(tuples.getFirst());
            arrayList2.add(tuples.getSecond());
        }
        return C14372l0.m7952a(arrayList, arrayList2);
    }
}
