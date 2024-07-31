package p608j1;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14305i;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aJ\u0010\u0005\u001a\u00028\u0001\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0000\"\u0004\b\u0001\u0010\u0002*\u00028\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0018\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m12616d2 = {"Ljava/lang/AutoCloseable;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/Function1;", "block", "b", "(Ljava/lang/AutoCloseable;Ll1/l;)Ljava/lang/Object;", "", "cause", "Lkotlin/f1;", "a", "kotlin-stdlib-jdk7"}, m12615k = 2, m12614mv = {1, 5, 1}, m12613pn = "kotlin")
@JvmName(name = "AutoCloseableKt")
/* renamed from: j1.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class AutoCloseable {
    @SinceKotlin(version = "1.2")
    @PublishedApi
    /* renamed from: a */
    public static final void m12666a(@Nullable java.lang.AutoCloseable autoCloseable, @Nullable Throwable th) {
        if (autoCloseable == null) {
            return;
        }
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            C14305i.m8548a(th, th2);
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: b */
    private static final <T extends java.lang.AutoCloseable, R> R m12665b(T t, InterfaceC15280l<? super T, ? extends R> interfaceC15280l) {
        try {
            R invoke = interfaceC15280l.invoke(t);
            InlineMarker.m8228d(1);
            m12666a(t, null);
            InlineMarker.m8229c(1);
            return invoke;
        } finally {
        }
    }
}
