package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;
import p649u1.C16231a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Broadcast.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BO\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f¢\u0006\u0002\b\u0012ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m12616d2 = {"Lkotlinx/coroutines/channels/x;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/l;", "Lkotlinx/coroutines/channels/d0;", "v", "Lkotlin/f1;", "p1", "Lkotlin/coroutines/c;", "e", "Lkotlin/coroutines/c;", "continuation", "Lkotlin/coroutines/f;", "parentContext", "Lkotlinx/coroutines/channels/j;", "channel", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/b0;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/j;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.x */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14738x<E> extends Broadcast<E> {

    /* renamed from: e */
    private final InterfaceC14268c<Unit> f42159e;

    public C14738x(@NotNull CoroutineContext coroutineContext, @NotNull BroadcastChannel<E> broadcastChannel, @NotNull InterfaceC15284p<? super InterfaceC14686b0<? super E>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        super(coroutineContext, broadcastChannel, false);
        InterfaceC14268c<Unit> m8651c;
        m8651c = IntrinsicsJvm.m8651c(interfaceC15284p, this, this);
        this.f42159e = m8651c;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    /* renamed from: p1 */
    protected void mo3933p1() {
        C16231a.m229b(this.f42159e, this);
    }

    @Override // kotlinx.coroutines.channels.Broadcast, kotlinx.coroutines.channels.BroadcastChannel
    @NotNull
    /* renamed from: v */
    public InterfaceC14695d0<E> mo5175v() {
        InterfaceC14695d0<E> mo5175v = m5429s1().mo5175v();
        start();
        return mo5175v;
    }
}
