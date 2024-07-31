package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.C14271e;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p649u1.C16231a;
import p649u1.Undispatched;

/* compiled from: CoroutineStart.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ^\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u00022'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, m12616d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "completion", "Lkotlin/f1;", "invoke", "(Ll1/l;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Ll1/p;Ljava/lang/Object;Lkotlin/coroutines/c;)V", "", "isLazy", "()Z", "isLazy$annotations", "()V", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @InternalCoroutinesApi
    public static /* synthetic */ void isLazy$annotations() {
    }

    @InternalCoroutinesApi
    public final <T> void invoke(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        int i = C15167s0.f43235a[ordinal()];
        if (i == 1) {
            C16231a.m228c(interfaceC15280l, interfaceC14268c);
        } else if (i == 2) {
            C14271e.m8666h(interfaceC15280l, interfaceC14268c);
        } else if (i == 3) {
            Undispatched.m225a(interfaceC15280l, interfaceC14268c);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    @InternalCoroutinesApi
    public final <R, T> void invoke(@NotNull InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, R r, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        int i = C15167s0.f43236b[ordinal()];
        if (i == 1) {
            C16231a.m226e(interfaceC15284p, r, interfaceC14268c, null, 4, null);
        } else if (i == 2) {
            C14271e.m8665i(interfaceC15284p, r, interfaceC14268c);
        } else if (i == 3) {
            Undispatched.m224b(interfaceC15284p, r, interfaceC14268c);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
