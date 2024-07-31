package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.C15117k0;
import kotlinx.coroutines.C15125l2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: Actor.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u009e\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062-\b\u0002\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000e2-\u0010\u0015\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/f;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/channels/h0;", "a", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILkotlinx/coroutines/CoroutineStart;Ll1/l;Ll1/p;)Lkotlinx/coroutines/channels/h0;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14697e {
    @ObsoleteCoroutinesApi
    @NotNull
    /* renamed from: a */
    public static final <E> InterfaceC14704h0<E> m5466a(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i, @NotNull CoroutineStart coroutineStart, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, @NotNull InterfaceC15284p<? super InterfaceC14699f<E>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        Actor actor;
        CoroutineContext m4086d = C15117k0.m4086d(coroutineScope, coroutineContext);
        InterfaceC14722n m5382d = C14728q.m5382d(i, null, null, 6, null);
        if (coroutineStart.isLazy()) {
            actor = new C14737w(m4086d, m5382d, interfaceC15284p);
        } else {
            actor = new Actor(m4086d, m5382d, true);
        }
        if (interfaceC15280l != null) {
            ((C15125l2) actor).mo3818w(interfaceC15280l);
        }
        ((AbstractCoroutine) actor).m5758q1(coroutineStart, actor, interfaceC15284p);
        return actor;
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC14704h0 m5465b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, InterfaceC15280l interfaceC15280l, InterfaceC15284p interfaceC15284p, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i3 = (i2 & 2) != 0 ? 0 : i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            interfaceC15280l = null;
        }
        return m5466a(coroutineScope, coroutineContext2, i3, coroutineStart2, interfaceC15280l, interfaceC15284p);
    }
}
