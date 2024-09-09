package kotlin.sequences;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.c0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\u001a.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\"\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0087\b\u001a2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0001H\u0007\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004\u001a+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u0004H\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001aE\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0014H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a@\u0010\u0019\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00180\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0013*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u0004\u001a\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u001a&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0007\u001ab\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u001e\"\u0004\b\u0002\u0010\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00020\u0014H\u0000\u001a\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004\u001a&\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020%2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001\u001a?\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020%2\b\u0010(\u001a\u0004\u0018\u00018\u00002\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0007\u00a2\u0006\u0004\b)\u0010*\u001a<\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020%2\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006-"}, d2 = {"T", "Lkotlin/Function0;", "", "iterator", "Lkotlin/sequences/m;", "g", "h", "", "elements", "t", "([Ljava/lang/Object;)Lkotlin/sequences/m;", "j", "s", "defaultValue", "r", "l", "", "n", "(Lkotlin/sequences/m;)Lkotlin/sequences/m;", "R", "Lkotlin/Function1;", "m", "(Lkotlin/sequences/m;Ld2/l;)Lkotlin/sequences/m;", "Lkotlin/Pair;", "", "w", "u", "Lkotlin/random/Random;", "random", "v", "C", "source", "Lkotlin/Function2;", "", "transform", "k", "i", "", "nextFunction", "o", "seed", CampaignEx.JSON_KEY_AD_Q, "(Ljava/lang/Object;Ld2/l;)Lkotlin/sequences/m;", "seedFunction", "p", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class s extends r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements m<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.a<Iterator<T>> f58830a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(d2.a<? extends Iterator<? extends T>> aVar) {
            this.f58830a = aVar;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<T> iterator() {
            return this.f58830a.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> implements m<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f58831a;

        public b(Iterator it) {
            this.f58831a = it;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<T> iterator() {
            return this.f58831a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H\u008a@"}, d2 = {"T", "C", "R", "Lkotlin/sequences/o;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<R> extends RestrictedSuspendLambda implements d2.p<o<? super R>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f58832a;

        /* renamed from: b  reason: collision with root package name */
        int f58833b;

        /* renamed from: c  reason: collision with root package name */
        int f58834c;

        /* renamed from: d  reason: collision with root package name */
        private /* synthetic */ Object f58835d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ m<T> f58836e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ d2.p<Integer, T, C> f58837f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d2.l<C, Iterator<R>> f58838g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(m<? extends T> mVar, d2.p<? super Integer, ? super T, ? extends C> pVar, d2.l<? super C, ? extends Iterator<? extends R>> lVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f58836e = mVar;
            this.f58837f = pVar;
            this.f58838g = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(this.f58836e, this.f58837f, this.f58838g, cVar);
            cVar2.f58835d = obj;
            return cVar2;
        }

        @Override // d2.p
        @Nullable
        /* renamed from: e */
        public final Object invoke(@NotNull o<? super R> oVar, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(oVar, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            int i4;
            Iterator it;
            o oVar;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i5 = this.f58834c;
            if (i5 == 0) {
                d0.n(obj);
                i4 = 0;
                it = this.f58836e.iterator();
                oVar = (o) this.f58835d;
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                i4 = this.f58833b;
                it = (Iterator) this.f58832a;
                oVar = (o) this.f58835d;
                d0.n(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                d2.p<Integer, T, C> pVar = this.f58837f;
                int i6 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__CollectionsKt.X();
                }
                Object invoke = pVar.invoke(kotlin.coroutines.jvm.internal.a.f(i4), next);
                this.f58835d = oVar;
                this.f58832a = it;
                this.f58833b = i6;
                this.f58834c = 1;
                if (oVar.g(this.f58838g.invoke(invoke), this) == h4) {
                    return h4;
                }
                i4 = i6;
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlin/sequences/m;", "it", "", "a", "(Lkotlin/sequences/m;)Ljava/util/Iterator;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T> extends Lambda implements d2.l<m<? extends T>, Iterator<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f58839a = new d();

        d() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Iterator<T> invoke(@NotNull m<? extends T> it) {
            f0.p(it, "it");
            return (Iterator<? extends T>) it.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "it", "", "a", "(Ljava/lang/Iterable;)Ljava/util/Iterator;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e<T> extends Lambda implements d2.l<Iterable<? extends T>, Iterator<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f58840a = new e();

        e() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Iterator<T> invoke(@NotNull Iterable<? extends T> it) {
            f0.p(it, "it");
            return (Iterator<? extends T>) it.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0006\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "R", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f<T> extends Lambda implements d2.l<T, T> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f58841a = new f();

        f() {
            super(1);
        }

        @Override // d2.l
        public final T invoke(T t3) {
            return t3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g<T> extends Lambda implements d2.l<T, T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.a<T> f58842a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g(d2.a<? extends T> aVar) {
            super(1);
            this.f58842a = aVar;
        }

        @Override // d2.l
        @Nullable
        public final T invoke(@NotNull T it) {
            f0.p(it, "it");
            return this.f58842a.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class h<T> extends Lambda implements d2.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ T f58843a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(T t3) {
            super(0);
            this.f58843a = t3;
        }

        @Override // d2.a
        @Nullable
        public final T invoke() {
            return this.f58843a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {"T", "Lkotlin/sequences/o;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class i<T> extends RestrictedSuspendLambda implements d2.p<o<? super T>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f58844a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f58845b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ m<T> f58846c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d2.a<m<T>> f58847d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        i(m<? extends T> mVar, d2.a<? extends m<? extends T>> aVar, kotlin.coroutines.c<? super i> cVar) {
            super(2, cVar);
            this.f58846c = mVar;
            this.f58847d = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            i iVar = new i(this.f58846c, this.f58847d, cVar);
            iVar.f58845b = obj;
            return iVar;
        }

        @Nullable
        public final Object e(@NotNull o<? super T> oVar, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((i) create(oVar, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // d2.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
            return e((o) obj, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f58844a;
            if (i4 == 0) {
                d0.n(obj);
                o oVar = (o) this.f58845b;
                Iterator<? extends T> it = this.f58846c.iterator();
                if (it.hasNext()) {
                    this.f58844a = 1;
                    if (oVar.g(it, this) == h4) {
                        return h4;
                    }
                } else {
                    this.f58844a = 2;
                    if (oVar.h(this.f58847d.invoke(), this) == h4) {
                        return h4;
                    }
                }
            } else if (i4 != 1 && i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {"T", "Lkotlin/sequences/o;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class j<T> extends RestrictedSuspendLambda implements d2.p<o<? super T>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f58848a;

        /* renamed from: b  reason: collision with root package name */
        int f58849b;

        /* renamed from: c  reason: collision with root package name */
        private /* synthetic */ Object f58850c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ m<T> f58851d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Random f58852e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        j(m<? extends T> mVar, Random random, kotlin.coroutines.c<? super j> cVar) {
            super(2, cVar);
            this.f58851d = mVar;
            this.f58852e = random;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            j jVar = new j(this.f58851d, this.f58852e, cVar);
            jVar.f58850c = obj;
            return jVar;
        }

        @Nullable
        public final Object e(@NotNull o<? super T> oVar, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((j) create(oVar, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // d2.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
            return e((o) obj, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            List W2;
            o oVar;
            Object L0;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f58849b;
            if (i4 == 0) {
                d0.n(obj);
                W2 = SequencesKt___SequencesKt.W2(this.f58851d);
                oVar = (o) this.f58850c;
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                W2 = (List) this.f58848a;
                oVar = (o) this.f58850c;
                d0.n(obj);
            }
            while (!W2.isEmpty()) {
                int nextInt = this.f58852e.nextInt(W2.size());
                L0 = c0.L0(W2);
                if (nextInt < W2.size()) {
                    L0 = W2.set(nextInt, L0);
                }
                this.f58850c = oVar;
                this.f58848a = W2;
                this.f58849b = 1;
                if (oVar.e(L0, this) == h4) {
                    return h4;
                }
            }
            return f1.f55527a;
        }
    }

    public s() {
    }

    @InlineOnly
    private static final <T> m<T> g(d2.a<? extends Iterator<? extends T>> iterator) {
        f0.p(iterator, "iterator");
        return new a(iterator);
    }

    @NotNull
    public static <T> m<T> h(@NotNull Iterator<? extends T> it) {
        m<T> i4;
        f0.p(it, "<this>");
        i4 = i(new b(it));
        return i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> m<T> i(@NotNull m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return mVar instanceof kotlin.sequences.a ? mVar : new kotlin.sequences.a(mVar);
    }

    @NotNull
    public static <T> m<T> j() {
        return kotlin.sequences.g.f58789a;
    }

    @NotNull
    public static final <T, C, R> m<R> k(@NotNull m<? extends T> source, @NotNull d2.p<? super Integer, ? super T, ? extends C> transform, @NotNull d2.l<? super C, ? extends Iterator<? extends R>> iterator) {
        m<R> e4;
        f0.p(source, "source");
        f0.p(transform, "transform");
        f0.p(iterator, "iterator");
        e4 = q.e(new c(source, transform, iterator, null));
        return e4;
    }

    @NotNull
    public static final <T> m<T> l(@NotNull m<? extends m<? extends T>> mVar) {
        f0.p(mVar, "<this>");
        return m(mVar, d.f58839a);
    }

    private static final <T, R> m<R> m(m<? extends T> mVar, d2.l<? super T, ? extends Iterator<? extends R>> lVar) {
        if (mVar instanceof y) {
            return ((y) mVar).e(lVar);
        }
        return new kotlin.sequences.i(mVar, f.f58841a, lVar);
    }

    @JvmName(name = "flattenSequenceOfIterable")
    @NotNull
    public static final <T> m<T> n(@NotNull m<? extends Iterable<? extends T>> mVar) {
        f0.p(mVar, "<this>");
        return m(mVar, e.f58840a);
    }

    @NotNull
    public static <T> m<T> o(@NotNull d2.a<? extends T> nextFunction) {
        m<T> i4;
        f0.p(nextFunction, "nextFunction");
        i4 = i(new kotlin.sequences.j(nextFunction, new g(nextFunction)));
        return i4;
    }

    @NotNull
    public static <T> m<T> p(@NotNull d2.a<? extends T> seedFunction, @NotNull d2.l<? super T, ? extends T> nextFunction) {
        f0.p(seedFunction, "seedFunction");
        f0.p(nextFunction, "nextFunction");
        return new kotlin.sequences.j(seedFunction, nextFunction);
    }

    @LowPriorityInOverloadResolution
    @NotNull
    public static <T> m<T> q(@Nullable T t3, @NotNull d2.l<? super T, ? extends T> nextFunction) {
        f0.p(nextFunction, "nextFunction");
        if (t3 == null) {
            return kotlin.sequences.g.f58789a;
        }
        return new kotlin.sequences.j(new h(t3), nextFunction);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> m<T> r(@NotNull m<? extends T> mVar, @NotNull d2.a<? extends m<? extends T>> defaultValue) {
        m<T> e4;
        f0.p(mVar, "<this>");
        f0.p(defaultValue, "defaultValue");
        e4 = q.e(new i(mVar, defaultValue, null));
        return e4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> m<T> s(m<? extends T> mVar) {
        m<T> j4;
        if (mVar == 0) {
            j4 = j();
            return j4;
        }
        return mVar;
    }

    @NotNull
    public static final <T> m<T> t(@NotNull T... elements) {
        m<T> h5;
        m<T> j4;
        f0.p(elements, "elements");
        if (elements.length == 0) {
            j4 = j();
            return j4;
        }
        h5 = kotlin.collections.p.h5(elements);
        return h5;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> m<T> u(@NotNull m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return v(mVar, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> m<T> v(@NotNull m<? extends T> mVar, @NotNull Random random) {
        m<T> e4;
        f0.p(mVar, "<this>");
        f0.p(random, "random");
        e4 = q.e(new j(mVar, random, null));
        return e4;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> w(@NotNull m<? extends Pair<? extends T, ? extends R>> mVar) {
        f0.p(mVar, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair<? extends T, ? extends R> pair : mVar) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return l0.a(arrayList, arrayList2);
    }
}
