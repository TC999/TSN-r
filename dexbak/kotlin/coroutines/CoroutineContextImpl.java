package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.beizi.fusion.widget.ScrollClickView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001$B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0000H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J*\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000e*\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u0014\u0010\u001f\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010!¨\u0006%"}, m12616d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/f;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "size", "Lkotlin/coroutines/f$b;", "element", "", "contains", "context", "containsAll", "", "writeReplace", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "get", "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Ll1/p;)Ljava/lang/Object;", "minusKey", AdnName.OTHER, "equals", TTDownloadField.TT_HASHCODE, "", "toString", ScrollClickView.DIR_LEFT, "Lkotlin/coroutines/f;", "Lkotlin/coroutines/f$b;", "<init>", "(Lkotlin/coroutines/f;Lkotlin/coroutines/f$b;)V", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.CombinedContext */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CoroutineContextImpl implements CoroutineContext, Serializable {
    private final CoroutineContext.InterfaceC14275b element;
    private final CoroutineContext left;

    /* compiled from: CoroutineContextImpl.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \r2\u00060\u0001j\u0002`\u0002:\u0001\u0007B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\u000e"}, m12616d2 = {"Lkotlin/coroutines/CombinedContext$a;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "", "Lkotlin/coroutines/f;", "a", "[Lkotlin/coroutines/f;", "()[Lkotlin/coroutines/f;", "elements", "<init>", "([Lkotlin/coroutines/f;)V", "b", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.CombinedContext$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C14262a implements Serializable {
        @NotNull

        /* renamed from: b */
        public static final C14263a f41017b = new C14263a(null);
        private static final long serialVersionUID = 0;
        @NotNull

        /* renamed from: a */
        private final CoroutineContext[] f41018a;

        /* compiled from: CoroutineContextImpl.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m12616d2 = {"Lkotlin/coroutines/CombinedContext$a$a;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: kotlin.coroutines.CombinedContext$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14263a {
            private C14263a() {
            }

            public /* synthetic */ C14263a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public C14262a(@NotNull CoroutineContext[] elements) {
            C14342f0.m8184p(elements, "elements");
            this.f41018a = elements;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.f41018a;
            CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
            for (CoroutineContext coroutineContext2 : coroutineContextArr) {
                coroutineContext = coroutineContext.plus(coroutineContext2);
            }
            return coroutineContext;
        }

        @NotNull
        /* renamed from: a */
        public final CoroutineContext[] m8683a() {
            return this.f41018a;
        }
    }

    /* compiled from: CoroutineContextImpl.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"", "acc", "Lkotlin/coroutines/f$b;", "element", "a", "(Ljava/lang/String;Lkotlin/coroutines/f$b;)Ljava/lang/String;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.CombinedContext$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14264b extends Lambda implements InterfaceC15284p<String, CoroutineContext.InterfaceC14275b, String> {

        /* renamed from: a */
        public static final C14264b f41019a = new C14264b();

        C14264b() {
            super(2);
        }

        @Override // p617l1.InterfaceC15284p
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull String acc, @NotNull CoroutineContext.InterfaceC14275b element) {
            C14342f0.m8184p(acc, "acc");
            C14342f0.m8184p(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    /* compiled from: CoroutineContextImpl.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"Lkotlin/f1;", "<anonymous parameter 0>", "Lkotlin/coroutines/f$b;", "element", "a", "(Lkotlin/f1;Lkotlin/coroutines/f$b;)V"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.CombinedContext$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14265c extends Lambda implements InterfaceC15284p<Unit, CoroutineContext.InterfaceC14275b, Unit> {

        /* renamed from: a */
        final /* synthetic */ CoroutineContext[] f41020a;

        /* renamed from: b */
        final /* synthetic */ Ref.IntRef f41021b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14265c(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef) {
            super(2);
            this.f41020a = coroutineContextArr;
            this.f41021b = intRef;
        }

        /* renamed from: a */
        public final void m8681a(@NotNull Unit unit, @NotNull CoroutineContext.InterfaceC14275b element) {
            C14342f0.m8184p(unit, "<anonymous parameter 0>");
            C14342f0.m8184p(element, "element");
            CoroutineContext[] coroutineContextArr = this.f41020a;
            Ref.IntRef intRef = this.f41021b;
            int i = intRef.element;
            intRef.element = i + 1;
            coroutineContextArr[i] = element;
        }

        @Override // p617l1.InterfaceC15284p
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit, CoroutineContext.InterfaceC14275b interfaceC14275b) {
            m8681a(unit, interfaceC14275b);
            return Unit.f41048a;
        }
    }

    public CoroutineContextImpl(@NotNull CoroutineContext left, @NotNull CoroutineContext.InterfaceC14275b element) {
        C14342f0.m8184p(left, "left");
        C14342f0.m8184p(element, "element");
        this.left = left;
        this.element = element;
    }

    private final boolean contains(CoroutineContext.InterfaceC14275b interfaceC14275b) {
        return C14342f0.m8193g(get(interfaceC14275b.getKey()), interfaceC14275b);
    }

    private final boolean containsAll(CoroutineContextImpl coroutineContextImpl) {
        while (contains(coroutineContextImpl.element)) {
            CoroutineContext coroutineContext = coroutineContextImpl.left;
            if (!(coroutineContext instanceof CoroutineContextImpl)) {
                if (coroutineContext != null) {
                    return contains((CoroutineContext.InterfaceC14275b) coroutineContext);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
            coroutineContextImpl = (CoroutineContextImpl) coroutineContext;
        }
        return false;
    }

    private final int size() {
        int i = 2;
        CoroutineContextImpl coroutineContextImpl = this;
        while (true) {
            CoroutineContext coroutineContext = coroutineContextImpl.left;
            if (!(coroutineContext instanceof CoroutineContextImpl)) {
                coroutineContext = null;
            }
            coroutineContextImpl = (CoroutineContextImpl) coroutineContext;
            if (coroutineContextImpl == null) {
                return i;
            }
            i++;
        }
    }

    private final Object writeReplace() {
        int size = size();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[size];
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        fold(Unit.f41048a, new C14265c(coroutineContextArr, intRef));
        if (intRef.element == size) {
            return new C14262a(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CoroutineContextImpl) {
                CoroutineContextImpl coroutineContextImpl = (CoroutineContextImpl) obj;
                if (coroutineContextImpl.size() != size() || !coroutineContextImpl.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> operation) {
        C14342f0.m8184p(operation, "operation");
        return operation.invoke((Object) this.left.fold(r, operation), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.InterfaceC14275b> E get(@NotNull CoroutineContext.InterfaceC14277c<E> key) {
        C14342f0.m8184p(key, "key");
        CoroutineContextImpl coroutineContextImpl = this;
        while (true) {
            E e = (E) coroutineContextImpl.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = coroutineContextImpl.left;
            if (coroutineContext instanceof CoroutineContextImpl) {
                coroutineContextImpl = (CoroutineContextImpl) coroutineContext;
            } else {
                return (E) coroutineContext.get(key);
            }
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.InterfaceC14277c<?> key) {
        C14342f0.m8184p(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext minusKey = this.left.minusKey(key);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CoroutineContextImpl(minusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext context) {
        C14342f0.m8184p(context, "context");
        return CoroutineContext.C14273a.m8663a(this, context);
    }

    @NotNull
    public String toString() {
        return "[" + ((String) fold("", C14264b.f41019a)) + "]";
    }
}
