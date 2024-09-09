package kotlin.concurrent;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Thread.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aJ\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u001a5\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u000f*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0014"}, d2 = {"", CampaignEx.JSON_NATIVE_VIDEO_START, "isDaemon", "Ljava/lang/ClassLoader;", "contextClassLoader", "", "name", "", "priority", "Lkotlin/Function0;", "Lkotlin/f1;", "block", "Ljava/lang/Thread;", "b", "", "T", "Ljava/lang/ThreadLocal;", "default", "a", "(Ljava/lang/ThreadLocal;Ld2/a;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "ThreadsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Thread.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"kotlin/concurrent/b$a", "Ljava/lang/Thread;", "Lkotlin/f1;", "run", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.a<f1> f55494a;

        a(d2.a<f1> aVar) {
            this.f55494a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f55494a.invoke();
        }
    }

    @InlineOnly
    private static final <T> T a(ThreadLocal<T> threadLocal, d2.a<? extends T> aVar) {
        f0.p(threadLocal, "<this>");
        f0.p(aVar, "default");
        T t3 = threadLocal.get();
        if (t3 == null) {
            T invoke = aVar.invoke();
            threadLocal.set(invoke);
            return invoke;
        }
        return t3;
    }

    @NotNull
    public static final Thread b(boolean z3, boolean z4, @Nullable ClassLoader classLoader, @Nullable String str, int i4, @NotNull d2.a<f1> block) {
        f0.p(block, "block");
        a aVar = new a(block);
        if (z4) {
            aVar.setDaemon(true);
        }
        if (i4 > 0) {
            aVar.setPriority(i4);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z3) {
            aVar.start();
        }
        return aVar;
    }
}
