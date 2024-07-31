package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlin.sequences.AbstractC14514o;
import kotlin.sequences.C14516q;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: SlidingWindow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010(\n\u0002\b\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000\u001aD\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000\u001aH\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\f\"\u0004\b\u0000\u0010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¨\u0006\u000f"}, m12616d2 = {"", "size", "step", "Lkotlin/f1;", "a", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "", "partialWindows", "reuseBuffer", "", "c", "", "iterator", "b", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.l1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14170l1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SlidingWindow.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/o;", "", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", m8638f = "SlidingWindow.kt", m8637i = {}, m8636l = {34, 40, 49, 55, 58}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: kotlin.collections.l1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14171a<T> extends RestrictedSuspendLambda implements InterfaceC15284p<AbstractC14514o<? super List<? extends T>>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private /* synthetic */ Object f40912a;

        /* renamed from: b */
        Object f40913b;

        /* renamed from: c */
        Object f40914c;

        /* renamed from: d */
        int f40915d;

        /* renamed from: e */
        int f40916e;

        /* renamed from: f */
        final /* synthetic */ int f40917f;

        /* renamed from: g */
        final /* synthetic */ int f40918g;

        /* renamed from: h */
        final /* synthetic */ Iterator f40919h;

        /* renamed from: i */
        final /* synthetic */ boolean f40920i;

        /* renamed from: j */
        final /* synthetic */ boolean f40921j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14171a(int i, int i2, Iterator it, boolean z, boolean z2, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f40917f = i;
            this.f40918g = i2;
            this.f40919h = it;
            this.f40920i = z;
            this.f40921j = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> completion) {
            C14342f0.m8184p(completion, "completion");
            C14171a c14171a = new C14171a(this.f40917f, this.f40918g, this.f40919h, this.f40920i, this.f40921j, completion);
            c14171a.f40912a = obj;
            return c14171a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14171a) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0152  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:30:0x00a8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011b -> B:59:0x011e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0149 -> B:72:0x014c). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 363
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.C14170l1.C14171a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, m12616d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.l1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14172b<T> implements Sequence<List<? extends T>> {

        /* renamed from: a */
        final /* synthetic */ Sequence f40922a;

        /* renamed from: b */
        final /* synthetic */ int f40923b;

        /* renamed from: c */
        final /* synthetic */ int f40924c;

        /* renamed from: d */
        final /* synthetic */ boolean f40925d;

        /* renamed from: e */
        final /* synthetic */ boolean f40926e;

        public C14172b(Sequence sequence, int i, int i2, boolean z, boolean z2) {
            this.f40922a = sequence;
            this.f40923b = i;
            this.f40924c = i2;
            this.f40925d = z;
            this.f40926e = z2;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<List<? extends T>> iterator() {
            return C14170l1.m11920b(this.f40922a.iterator(), this.f40923b, this.f40924c, this.f40925d, this.f40926e);
        }
    }

    /* renamed from: a */
    public static final void m11921a(int i, int i2) {
        String str;
        if (i > 0 && i2 > 0) {
            return;
        }
        if (i != i2) {
            str = "Both size " + i + " and step " + i2 + " must be greater than zero.";
        } else {
            str = "size " + i + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @NotNull
    /* renamed from: b */
    public static final <T> Iterator<List<T>> m11920b(@NotNull Iterator<? extends T> iterator, int i, int i2, boolean z, boolean z2) {
        Iterator<List<T>> m6994d;
        C14342f0.m8184p(iterator, "iterator");
        if (iterator.hasNext()) {
            m6994d = C14516q.m6994d(new C14171a(i, i2, iterator, z2, z, null));
            return m6994d;
        }
        return C14161g0.f40900a;
    }

    @NotNull
    /* renamed from: c */
    public static final <T> Sequence<List<T>> m11919c(@NotNull Sequence<? extends T> windowedSequence, int i, int i2, boolean z, boolean z2) {
        C14342f0.m8184p(windowedSequence, "$this$windowedSequence");
        m11921a(i, i2);
        return new C14172b(windowedSequence, i, i2, z, z2);
    }
}
