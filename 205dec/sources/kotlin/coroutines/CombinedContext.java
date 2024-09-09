package kotlin.coroutines;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.p;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.f;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineContextImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001$B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0000H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J*\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000e*\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u0014\u0010\u001f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!\u00a8\u0006%"}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/f;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "size", "Lkotlin/coroutines/f$b;", "element", "", "contains", "context", "containsAll", "", "writeReplace", "E", "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, f3.f5657f, "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Ld2/p;)Ljava/lang/Object;", "minusKey", "other", "equals", "hashCode", "", "toString", "left", "Lkotlin/coroutines/f;", "Lkotlin/coroutines/f$b;", "<init>", "(Lkotlin/coroutines/f;Lkotlin/coroutines/f$b;)V", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class CombinedContext implements f, Serializable {
    @NotNull
    private final f.b element;
    @NotNull
    private final f left;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineContextImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \r2\u00060\u0001j\u0002`\u0002:\u0001\u0007B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lkotlin/coroutines/CombinedContext$a;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "", "Lkotlin/coroutines/f;", "a", "[Lkotlin/coroutines/f;", "()[Lkotlin/coroutines/f;", "elements", "<init>", "([Lkotlin/coroutines/f;)V", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class a implements Serializable {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final C1097a f55496b = new C1097a(null);
        private static final long serialVersionUID = 0;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final f[] f55497a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CoroutineContextImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lkotlin/coroutines/CombinedContext$a$a;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
        /* renamed from: kotlin.coroutines.CombinedContext$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1097a {
            private C1097a() {
            }

            public /* synthetic */ C1097a(u uVar) {
                this();
            }
        }

        public a(@NotNull f[] elements) {
            f0.p(elements, "elements");
            this.f55497a = elements;
        }

        private final Object readResolve() {
            f[] fVarArr = this.f55497a;
            f fVar = EmptyCoroutineContext.INSTANCE;
            int length = fVarArr.length;
            int i4 = 0;
            while (i4 < length) {
                f fVar2 = fVarArr[i4];
                i4++;
                fVar = fVar.plus(fVar2);
            }
            return fVar;
        }

        @NotNull
        public final f[] a() {
            return this.f55497a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineContextImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "acc", "Lkotlin/coroutines/f$b;", "element", "a", "(Ljava/lang/String;Lkotlin/coroutines/f$b;)Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements p<String, f.b, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f55498a = new b();

        b() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull String acc, @NotNull f.b element) {
            f0.p(acc, "acc");
            f0.p(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineContextImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/f1;", "<anonymous parameter 0>", "Lkotlin/coroutines/f$b;", "element", "a", "(Lkotlin/f1;Lkotlin/coroutines/f$b;)V"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements p<f1, f.b, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f[] f55499a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f55500b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(f[] fVarArr, Ref.IntRef intRef) {
            super(2);
            this.f55499a = fVarArr;
            this.f55500b = intRef;
        }

        public final void a(@NotNull f1 noName_0, @NotNull f.b element) {
            f0.p(noName_0, "$noName_0");
            f0.p(element, "element");
            f[] fVarArr = this.f55499a;
            Ref.IntRef intRef = this.f55500b;
            int i4 = intRef.element;
            intRef.element = i4 + 1;
            fVarArr[i4] = element;
        }

        @Override // d2.p
        public /* bridge */ /* synthetic */ f1 invoke(f1 f1Var, f.b bVar) {
            a(f1Var, bVar);
            return f1.f55527a;
        }
    }

    public CombinedContext(@NotNull f left, @NotNull f.b element) {
        f0.p(left, "left");
        f0.p(element, "element");
        this.left = left;
        this.element = element;
    }

    private final boolean contains(f.b bVar) {
        return f0.g(get(bVar.getKey()), bVar);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            f fVar = combinedContext.left;
            if (fVar instanceof CombinedContext) {
                combinedContext = (CombinedContext) fVar;
            } else {
                return contains((f.b) fVar);
            }
        }
        return false;
    }

    private final int size() {
        int i4 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            f fVar = combinedContext.left;
            combinedContext = fVar instanceof CombinedContext ? (CombinedContext) fVar : null;
            if (combinedContext == null) {
                return i4;
            }
            i4++;
        }
    }

    private final Object writeReplace() {
        int size = size();
        f[] fVarArr = new f[size];
        Ref.IntRef intRef = new Ref.IntRef();
        fold(f1.f55527a, new c(fVarArr, intRef));
        if (intRef.element == size) {
            return new a(fVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.size() != size() || !combinedContext.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r3, @NotNull p<? super R, ? super f.b, ? extends R> operation) {
        f0.p(operation, "operation");
        return operation.invoke((Object) this.left.fold(r3, operation), this.element);
    }

    @Override // kotlin.coroutines.f
    @Nullable
    public <E extends f.b> E get(@NotNull f.c<E> key) {
        f0.p(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e4 = (E) combinedContext.element.get(key);
            if (e4 != null) {
                return e4;
            }
            f fVar = combinedContext.left;
            if (fVar instanceof CombinedContext) {
                combinedContext = (CombinedContext) fVar;
            } else {
                return (E) fVar.get(key);
            }
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.f
    @NotNull
    public f minusKey(@NotNull f.c<?> key) {
        f0.p(key, "key");
        if (this.element.get(key) == null) {
            f minusKey = this.left.minusKey(key);
            return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(minusKey, this.element);
        }
        return this.left;
    }

    @Override // kotlin.coroutines.f
    @NotNull
    public f plus(@NotNull f fVar) {
        return f.a.a(this, fVar);
    }

    @NotNull
    public String toString() {
        return '[' + ((String) fold("", b.f55498a)) + ']';
    }
}
