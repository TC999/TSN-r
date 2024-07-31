package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aJ\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u001a5\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u000f*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, m12616d2 = {"", CampaignEx.JSON_NATIVE_VIDEO_START, "isDaemon", "Ljava/lang/ClassLoader;", "contextClassLoader", "", "name", "", "priority", "Lkotlin/Function0;", "Lkotlin/f1;", "block", "Ljava/lang/Thread;", "b", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ThreadLocal;", "default", "a", "(Ljava/lang/ThreadLocal;Ll1/a;)Ljava/lang/Object;", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "ThreadsKt")
/* renamed from: kotlin.concurrent.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Thread {

    /* compiled from: Thread.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, m12616d2 = {"kotlin/concurrent/b$a", "Ljava/lang/Thread;", "Lkotlin/f1;", "run", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.concurrent.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14260a extends java.lang.Thread {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15269a f41015a;

        C14260a(InterfaceC15269a interfaceC15269a) {
            this.f41015a = interfaceC15269a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f41015a.invoke();
        }
    }

    @InlineOnly
    /* renamed from: a */
    private static final <T> T m8702a(ThreadLocal<T> threadLocal, InterfaceC15269a<? extends T> interfaceC15269a) {
        T t = threadLocal.get();
        if (t != null) {
            return t;
        }
        T invoke = interfaceC15269a.invoke();
        threadLocal.set(invoke);
        return invoke;
    }

    @NotNull
    /* renamed from: b */
    public static final java.lang.Thread m8701b(boolean z, boolean z2, @Nullable ClassLoader classLoader, @Nullable String str, int i, @NotNull InterfaceC15269a<Unit> block) {
        C14342f0.m8184p(block, "block");
        C14260a c14260a = new C14260a(block);
        if (z2) {
            c14260a.setDaemon(true);
        }
        if (i > 0) {
            c14260a.setPriority(i);
        }
        if (str != null) {
            c14260a.setName(str);
        }
        if (classLoader != null) {
            c14260a.setContextClassLoader(classLoader);
        }
        if (z) {
            c14260a.start();
        }
        return c14260a;
    }
}
