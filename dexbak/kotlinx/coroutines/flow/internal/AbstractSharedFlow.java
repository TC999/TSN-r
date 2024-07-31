package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.flow.C15005j0;
import kotlinx.coroutines.flow.InterfaceC15044t;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractC14979c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b*\u0010\u001aJ\u000f\u0010\u0005\u001a\u00028\u0000H$¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t2\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0011H\u0084\bR>\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t8\u0004@BX\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00078\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070'8F¢\u0006\u0006\u001a\u0004\b!\u0010(¨\u0006+"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/a;", "Lkotlinx/coroutines/flow/internal/c;", ExifInterface.LATITUDE_SOUTH, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", C7304t.f25048d, "()Lkotlinx/coroutines/flow/internal/c;", "", "size", "", "m", "(I)[Lkotlinx/coroutines/flow/internal/c;", "k", "slot", "Lkotlin/f1;", "o", "(Lkotlinx/coroutines/flow/internal/c;)V", "Lkotlin/Function1;", "block", "n", "<set-?>", "a", "[Lkotlinx/coroutines/flow/internal/c;", CampaignEx.JSON_KEY_AD_Q, "()[Lkotlinx/coroutines/flow/internal/c;", "getSlots$annotations", "()V", "slots", "b", "I", "p", "()I", "nCollectors", "c", "nextIndex", "Lkotlinx/coroutines/flow/t;", "d", "Lkotlinx/coroutines/flow/t;", "_subscriptionCount", "Lkotlinx/coroutines/flow/h0;", "()Lkotlinx/coroutines/flow/h0;", "subscriptionCount", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractSharedFlow<S extends AbstractC14979c<?>> {
    @Nullable

    /* renamed from: a */
    private S[] f42808a;

    /* renamed from: b */
    private int f42809b;

    /* renamed from: c */
    private int f42810c;

    /* renamed from: d */
    private InterfaceC15044t<Integer> f42811d;

    /* renamed from: r */
    protected static /* synthetic */ void m4787r() {
    }

    @NotNull
    /* renamed from: c */
    public final StateFlow<Integer> m4797c() {
        InterfaceC15044t<Integer> interfaceC15044t;
        synchronized (this) {
            interfaceC15044t = this.f42811d;
            if (interfaceC15044t == null) {
                interfaceC15044t = C15005j0.m4754a(Integer.valueOf(this.f42809b));
                this.f42811d = interfaceC15044t;
            }
        }
        return interfaceC15044t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: k */
    public final S m4792k() {
        S s;
        InterfaceC15044t<Integer> interfaceC15044t;
        synchronized (this) {
            S[] sArr = this.f42808a;
            if (sArr == null) {
                sArr = mo4467m(2);
                this.f42808a = sArr;
            } else if (this.f42809b >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                C14342f0.m8185o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.f42808a = (S[]) ((AbstractC14979c[]) copyOf);
                sArr = (S[]) ((AbstractC14979c[]) copyOf);
            }
            int i = this.f42810c;
            do {
                s = sArr[i];
                if (s == null) {
                    s = mo4468l();
                    sArr[i] = s;
                }
                i++;
                if (i >= sArr.length) {
                    i = 0;
                }
                if (s == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                }
            } while (!s.mo4574a(this));
            this.f42810c = i;
            this.f42809b++;
            interfaceC15044t = this.f42811d;
        }
        if (interfaceC15044t != null) {
            C15005j0.m4748g(interfaceC15044t, 1);
        }
        return s;
    }

    @NotNull
    /* renamed from: l */
    protected abstract S mo4468l();

    @NotNull
    /* renamed from: m */
    protected abstract S[] mo4467m(int i);

    /* renamed from: n */
    protected final void m4791n(@NotNull InterfaceC15280l<? super S, Unit> interfaceC15280l) {
        AbstractC14979c[] abstractC14979cArr;
        if (this.f42809b == 0 || (abstractC14979cArr = this.f42808a) == null) {
            return;
        }
        for (AbstractC14979c abstractC14979c : abstractC14979cArr) {
            if (abstractC14979c != null) {
                interfaceC15280l.invoke(abstractC14979c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public final void m4790o(@NotNull S s) {
        InterfaceC15044t<Integer> interfaceC15044t;
        int i;
        InterfaceC14268c<Unit>[] mo4573b;
        synchronized (this) {
            int i2 = this.f42809b - 1;
            this.f42809b = i2;
            interfaceC15044t = this.f42811d;
            if (i2 == 0) {
                this.f42810c = 0;
            }
            if (s != null) {
                mo4573b = s.mo4573b(this);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            }
        }
        for (InterfaceC14268c<Unit> interfaceC14268c : mo4573b) {
            if (interfaceC14268c != null) {
                Unit unit = Unit.f41048a;
                Result.C14124a c14124a = Result.Companion;
                interfaceC14268c.resumeWith(Result.m60148constructorimpl(unit));
            }
        }
        if (interfaceC15044t != null) {
            C15005j0.m4748g(interfaceC15044t, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public final int m4789p() {
        return this.f42809b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: q */
    public final S[] m4788q() {
        return this.f42808a;
    }
}
