package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;

/* compiled from: Builders.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/f;", "context", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "(Lkotlin/coroutines/f;Ll1/p;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/BuildersKt")
/* renamed from: kotlinx.coroutines.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C15062i {
    /* renamed from: a */
    public static final <T> T m4408a(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC15284p<? super CoroutineScope, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p) throws InterruptedException {
        AbstractC15133m1 m4084a;
        CoroutineContext m4086d;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.f41024k0);
        if (continuationInterceptor == null) {
            m4084a = C15120k3.f43148b.m4083b();
            m4086d = C15117k0.m4086d(C15247w1.f43439a, coroutineContext.plus(m4084a));
        } else {
            if (!(continuationInterceptor instanceof AbstractC15133m1)) {
                continuationInterceptor = null;
            }
            AbstractC15133m1 abstractC15133m1 = (AbstractC15133m1) continuationInterceptor;
            if (abstractC15133m1 != null) {
                AbstractC15133m1 abstractC15133m12 = abstractC15133m1.mo3562L() ? abstractC15133m1 : null;
                if (abstractC15133m12 != null) {
                    m4084a = abstractC15133m12;
                    m4086d = C15117k0.m4086d(C15247w1.f43439a, coroutineContext);
                }
            }
            m4084a = C15120k3.f43148b.m4084a();
            m4086d = C15117k0.m4086d(C15247w1.f43439a, coroutineContext);
        }
        Builders builders = new Builders(m4086d, currentThread, m4084a);
        builders.m5758q1(CoroutineStart.DEFAULT, builders, interfaceC15284p);
        return (T) builders.m5039s1();
    }

    /* renamed from: b */
    public static /* synthetic */ Object m4407b(CoroutineContext coroutineContext, InterfaceC15284p interfaceC15284p, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return C15057h.m4447g(coroutineContext, interfaceC15284p);
    }
}
