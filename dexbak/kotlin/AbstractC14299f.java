package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeepRecursive.kt */
@SinceKotlin(version = BuildConfig.VERSION_NAME)
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\t\b\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\n\u001a\u00028\u0003\"\u0004\b\u0002\u0010\u0007\"\u0004\b\u0003\u0010\b*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\t2\u0006\u0010\u0004\u001a\u00028\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\f*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0087\u0002\u0082\u0001\u0001\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m12616d2 = {"Lkotlin/f;", ExifInterface.GPS_DIRECTION_TRUE, "R", "", DomainCampaignEx.LOOPBACK_VALUE, "b", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "U", ExifInterface.LATITUDE_SOUTH, "Lkotlin/d;", "c", "(Lkotlin/d;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "d", "<init>", "()V", "Lkotlin/g;", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalStdlibApi
@Continuation
/* renamed from: kotlin.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC14299f<T, R> {
    private AbstractC14299f() {
    }

    @Nullable
    /* renamed from: b */
    public abstract Object mo8584b(T t, @NotNull InterfaceC14268c<? super R> interfaceC14268c);

    @Nullable
    /* renamed from: c */
    public abstract <U, S> Object mo8583c(@NotNull DeepRecursive<U, S> deepRecursive, U u, @NotNull InterfaceC14268c<? super S> interfaceC14268c);

    @Annotations(level = DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @ReplaceWith(expression = "this.callRecursive(value)", imports = {}))
    @NotNull
    /* renamed from: d */
    public final Void m8585d(@NotNull DeepRecursive<?, ?> invoke, @Nullable Object obj) {
        C14342f0.m8184p(invoke, "$this$invoke");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }

    public /* synthetic */ AbstractC14299f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
