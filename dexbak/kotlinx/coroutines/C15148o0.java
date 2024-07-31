package kotlinx.coroutines;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractC14266a;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.C14579x;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: CoroutineContext.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0015B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, m12616d2 = {"Lkotlinx/coroutines/o0;", "Lkotlinx/coroutines/i3;", "", "Lkotlin/coroutines/a;", "toString", "Lkotlin/coroutines/f;", "context", "v", "oldState", "Lkotlin/f1;", "u", "", "p", "id", CampaignEx.JSON_KEY_AD_Q, "", TTDownloadField.TT_HASHCODE, "", AdnName.OTHER, "", "equals", "a", "J", "s", "()J", "<init>", "(J)V", "b", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.o0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15148o0 extends AbstractC14266a implements ThreadContextElement<String> {

    /* renamed from: b */
    public static final C15149a f43205b = new C15149a(null);

    /* renamed from: a */
    private final long f43206a;

    /* compiled from: CoroutineContext.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"Lkotlinx/coroutines/o0$a;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/o0;", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.o0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15149a implements CoroutineContext.InterfaceC14277c<C15148o0> {
        private C15149a() {
        }

        public /* synthetic */ C15149a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public C15148o0(long j) {
        super(f43205b);
        this.f43206a = j;
    }

    /* renamed from: r */
    public static /* synthetic */ C15148o0 m3940r(C15148o0 c15148o0, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c15148o0.f43206a;
        }
        return c15148o0.m3941q(j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof C15148o0) && this.f43206a == ((C15148o0) obj).f43206a;
        }
        return true;
    }

    @Override // kotlin.coroutines.AbstractC14266a, kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
        return (R) ThreadContextElement.C15065a.m4400a(this, r, interfaceC15284p);
    }

    @Override // kotlin.coroutines.AbstractC14266a, kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.InterfaceC14275b> E get(@NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
        return (E) ThreadContextElement.C15065a.m4399b(this, interfaceC14277c);
    }

    public int hashCode() {
        long j = this.f43206a;
        return (int) (j ^ (j >>> 32));
    }

    @Override // kotlin.coroutines.AbstractC14266a, kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
        return ThreadContextElement.C15065a.m4398c(this, interfaceC14277c);
    }

    /* renamed from: p */
    public final long m3942p() {
        return this.f43206a;
    }

    @Override // kotlin.coroutines.AbstractC14266a, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return ThreadContextElement.C15065a.m4397d(this, coroutineContext);
    }

    @NotNull
    /* renamed from: q */
    public final C15148o0 m3941q(long j) {
        return new C15148o0(j);
    }

    /* renamed from: s */
    public final long m3939s() {
        return this.f43206a;
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.f43206a + ')';
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* renamed from: u */
    public void mo3936x(@NotNull CoroutineContext coroutineContext, @NotNull String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    @NotNull
    /* renamed from: v */
    public String mo3943R(@NotNull CoroutineContext coroutineContext) {
        int m6522F3;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.f43212b);
        String str = (coroutineName == null || (str = coroutineName.m3878s()) == null) ? "coroutine" : "coroutine";
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        m6522F3 = C14579x.m6522F3(name, " @", 0, false, 6, null);
        if (m6522F3 < 0) {
            m6522F3 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + m6522F3 + 10);
        if (name != null) {
            String substring = name.substring(0, m6522F3);
            C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(" @");
            sb.append(str);
            sb.append('#');
            sb.append(this.f43206a);
            Unit unit = Unit.f41048a;
            String sb2 = sb.toString();
            C14342f0.m8185o(sb2, "StringBuilder(capacity).…builderAction).toString()");
            currentThread.setName(sb2);
            return name;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
