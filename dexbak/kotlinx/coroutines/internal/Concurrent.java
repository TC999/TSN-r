package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.ccg.CcgConstant;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002\"\u0004\b\u0000\u0010\u0000H\u0000\u001a,\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\u00060\u0005j\u0002`\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0080\b¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0080\b\u001a\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\"\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015*\f\b\u0000\u0010\u0017\"\u00020\u00052\u00020\u0005¨\u0006\u0018"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "", "Lkotlinx/coroutines/internal/SubscribersList;", "d", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "Lkotlin/Function0;", CcgConstant.f38549t, "e", "(Ljava/util/concurrent/locks/ReentrantLock;Ll1/a;)Ljava/lang/Object;", "", "expectedSize", "", "b", "Ljava/util/concurrent/Executor;", "executor", "", "c", "Ljava/lang/reflect/Method;", "a", "Ljava/lang/reflect/Method;", "REMOVE_FUTURE_ON_CANCEL", "ReentrantLock", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Concurrent {

    /* renamed from: a */
    private static final Method f43036a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        f43036a = method;
    }

    /* renamed from: a */
    public static /* synthetic */ void m4369a() {
    }

    @NotNull
    /* renamed from: b */
    public static final <E> Set<E> m4368b(int i) {
        return Collections.newSetFromMap(new IdentityHashMap(i));
    }

    /* renamed from: c */
    public static final boolean m4367c(@NotNull Executor executor) {
        Method method;
        try {
            if (!(executor instanceof ScheduledThreadPoolExecutor)) {
                executor = null;
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) executor;
            if (scheduledThreadPoolExecutor != null && (method = f43036a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @NotNull
    /* renamed from: d */
    public static final <E> List<E> m4366d() {
        return new CopyOnWriteArrayList();
    }

    /* renamed from: e */
    public static final <T> T m4365e(@NotNull ReentrantLock reentrantLock, @NotNull InterfaceC15269a<? extends T> interfaceC15269a) {
        reentrantLock.lock();
        try {
            return interfaceC15269a.invoke();
        } finally {
            InlineMarker.m8228d(1);
            reentrantLock.unlock();
            InlineMarker.m8229c(1);
        }
    }
}
