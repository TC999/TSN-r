package kotlin.io;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Closeable.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0006\u001a\u00028\u0001\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0000\"\u0004\b\u0001\u0010\u0002*\u00028\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001\u0082\u0002\u000f\n\u0006\b\u0011(\u00050\u0001\n\u0005\b\u009920\u0001\u00a8\u0006\f"}, d2 = {"Ljava/io/Closeable;", "T", "R", "Lkotlin/Function1;", "block", "Requires newer compiler version to be inlined correctly.", "b", "(Ljava/io/Closeable;Ld2/l;)Ljava/lang/Object;", "", "cause", "Lkotlin/f1;", "a", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "CloseableKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {
    @SinceKotlin(version = "1.1")
    @PublishedApi
    public static final void a(@Nullable Closeable closeable, @Nullable Throwable th) {
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
            kotlin.j.a(th, th2);
        }
    }

    @InlineOnly
    private static final <T extends Closeable, R> R b(T t3, d2.l<? super T, ? extends R> block) {
        f0.p(block, "block");
        try {
            R invoke = block.invoke(t3);
            c0.d(1);
            if (kotlin.internal.b.a(1, 1, 0)) {
                a(t3, null);
            } else if (t3 != null) {
                t3.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (kotlin.internal.b.a(1, 1, 0)) {
                    a(t3, th);
                } else if (t3 != null) {
                    try {
                        t3.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }
}
