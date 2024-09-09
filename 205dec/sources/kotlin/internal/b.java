package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlin.m;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PlatformImplementations.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0083\b\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\b\u0010\u0006\u001a\u00020\u0005H\u0002\u001a \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\"\u0014\u0010\u000e\u001a\u00020\f8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u000f"}, d2 = {"", "T", "instance", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "c", "major", "minor", "patch", "", "a", "Lkotlin/internal/a;", "Lkotlin/internal/a;", "IMPLEMENTATIONS", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {
    @JvmField
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f55545a;

    static {
        a aVar;
        Object newInstance;
        int c4 = c();
        if (c4 >= 65544) {
            try {
                try {
                    Object newInstance2 = a2.a.class.newInstance();
                    f0.o(newInstance2, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                    try {
                        aVar = (a) newInstance2;
                    } catch (ClassCastException e4) {
                        ClassLoader classLoader = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader2 = a.class.getClassLoader();
                        Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e4);
                        f0.o(initCause, "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                        throw initCause;
                    }
                } catch (ClassNotFoundException unused) {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    f0.o(newInstance3, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                    try {
                        aVar = (a) newInstance3;
                    } catch (ClassCastException e5) {
                        ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                        ClassLoader classLoader4 = a.class.getClassLoader();
                        Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e5);
                        f0.o(initCause2, "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                        throw initCause2;
                    }
                }
            } catch (ClassNotFoundException unused2) {
            }
            f55545a = aVar;
        }
        if (c4 >= 65543) {
            try {
                newInstance = z1.a.class.newInstance();
                f0.o(newInstance, "forName(\"kotlin.internal\u2026entations\").newInstance()");
            } catch (ClassNotFoundException unused3) {
                Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                f0.o(newInstance4, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                try {
                    aVar = (a) newInstance4;
                } catch (ClassCastException e6) {
                    ClassLoader classLoader5 = newInstance4.getClass().getClassLoader();
                    ClassLoader classLoader6 = a.class.getClassLoader();
                    Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e6);
                    f0.o(initCause3, "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                    throw initCause3;
                }
            }
            try {
                try {
                    aVar = (a) newInstance;
                } catch (ClassNotFoundException unused4) {
                }
                f55545a = aVar;
            } catch (ClassCastException e7) {
                ClassLoader classLoader7 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader8 = a.class.getClassLoader();
                Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e7);
                f0.o(initCause4, "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                throw initCause4;
            }
        }
        aVar = new a();
        f55545a = aVar;
    }

    @SinceKotlin(version = "1.2")
    @PublishedApi
    public static final boolean a(int i4, int i5, int i6) {
        return m.f55726g.g(i4, i5, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final /* synthetic */ <T> T b(Object obj) {
        try {
            f0.y(1, "T");
            return obj;
        } catch (ClassCastException e4) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            f0.y(4, "T");
            ClassLoader classLoader2 = Object.class.getClassLoader();
            Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e4);
            f0.o(initCause, "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
            throw initCause;
        }
    }

    private static final int c() {
        int q3;
        int q32;
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        q3 = x.q3(property, '.', 0, false, 6, null);
        if (q3 < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i4 = q3 + 1;
        q32 = x.q3(property, '.', i4, false, 4, null);
        if (q32 < 0) {
            q32 = property.length();
        }
        String substring = property.substring(0, q3);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String substring2 = property.substring(i4, q32);
        f0.o(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}
