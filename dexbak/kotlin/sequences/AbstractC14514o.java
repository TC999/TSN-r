package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SequenceBuilder.kt */
@SinceKotlin(version = "1.3")
@Continuation
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m12616d2 = {"Lkotlin/sequences/o;", ExifInterface.GPS_DIRECTION_TRUE, "", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "iterator", "g", "(Ljava/util/Iterator;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "elements", "d", "(Ljava/lang/Iterable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/sequences/m;", "sequence", "h", "(Lkotlin/sequences/m;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.o */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14514o<T> {
    @Nullable
    /* renamed from: c */
    public abstract Object mo7018c(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Nullable
    /* renamed from: d */
    public final Object m7017d(@NotNull Iterable<? extends T> iterable, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return Unit.f41048a;
        }
        Object mo7016g = mo7016g(iterable.iterator(), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo7016g == m8642h ? mo7016g : Unit.f41048a;
    }

    @Nullable
    /* renamed from: g */
    public abstract Object mo7016g(@NotNull Iterator<? extends T> it, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Nullable
    /* renamed from: h */
    public final Object m7015h(@NotNull Sequence<? extends T> sequence, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object mo7016g = mo7016g(sequence.iterator(), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo7016g == m8642h ? mo7016g : Unit.f41048a;
    }
}
