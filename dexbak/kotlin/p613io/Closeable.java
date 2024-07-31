package kotlin.p613io;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14305i;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.C14307b;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0006\u001a\u00028\u0001\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0000\"\u0004\b\u0001\u0010\u0002*\u00028\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001\u0082\u0002\u000f\n\u0006\b\u0011(\u00050\u0001\n\u0005\b\u009920\u0001¨\u0006\f"}, m12616d2 = {"Ljava/io/Closeable;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/Function1;", "block", "Requires newer compiler version to be inlined correctly.", "b", "(Ljava/io/Closeable;Ll1/l;)Ljava/lang/Object;", "", "cause", "Lkotlin/f1;", "a", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "CloseableKt")
/* renamed from: kotlin.io.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Closeable {
    @SinceKotlin(version = "1.1")
    @PublishedApi
    /* renamed from: a */
    public static final void m8492a(@Nullable java.io.Closeable closeable, @Nullable Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            C14305i.m8548a(th, th2);
        }
    }

    @InlineOnly
    /* renamed from: b */
    private static final <T extends java.io.Closeable, R> R m8491b(T t, InterfaceC15280l<? super T, ? extends R> interfaceC15280l) {
        try {
            R invoke = interfaceC15280l.invoke(t);
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                m8492a(t, null);
            } else if (t != null) {
                t.close();
            }
            InlineMarker.m8229c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    m8492a(t, th);
                } else if (t != null) {
                    try {
                        t.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }
}
