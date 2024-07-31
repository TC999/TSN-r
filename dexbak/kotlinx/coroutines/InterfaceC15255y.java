package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: CompletableDeferred.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\n"}, m12616d2 = {"Lkotlinx/coroutines/y;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/x0;", DomainCampaignEx.LOOPBACK_VALUE, "", "y", "(Ljava/lang/Object;)Z", "", "exception", "c", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC15255y<T> extends Deferred<T> {

    /* compiled from: CompletableDeferred.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.y$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C15256a {
        /* renamed from: b */
        public static <T, R> R m3502b(@NotNull InterfaceC15255y<T> interfaceC15255y, R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
            return (R) Deferred.C15252a.m3508b(interfaceC15255y, r, interfaceC15284p);
        }

        @Nullable
        /* renamed from: c */
        public static <T, E extends CoroutineContext.InterfaceC14275b> E m3501c(@NotNull InterfaceC15255y<T> interfaceC15255y, @NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
            return (E) Deferred.C15252a.m3507c(interfaceC15255y, interfaceC14277c);
        }

        @NotNull
        /* renamed from: d */
        public static <T> CoroutineContext m3500d(@NotNull InterfaceC15255y<T> interfaceC15255y, @NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
            return Deferred.C15252a.m3506d(interfaceC15255y, interfaceC14277c);
        }

        @NotNull
        /* renamed from: e */
        public static <T> CoroutineContext m3499e(@NotNull InterfaceC15255y<T> interfaceC15255y, @NotNull CoroutineContext coroutineContext) {
            return Deferred.C15252a.m3505e(interfaceC15255y, coroutineContext);
        }

        @Annotations(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        /* renamed from: f */
        public static <T> Job m3498f(@NotNull InterfaceC15255y<T> interfaceC15255y, @NotNull Job job) {
            return Deferred.C15252a.m3504f(interfaceC15255y, job);
        }
    }

    /* renamed from: c */
    boolean mo3493c(@NotNull Throwable th);

    /* renamed from: y */
    boolean mo3488y(T t);
}
