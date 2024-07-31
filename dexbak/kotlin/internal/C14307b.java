package kotlin.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.C14579x;
import org.jetbrains.annotations.NotNull;
import p598h1.JDK7PlatformImplementations;
import p602i1.JDK8PlatformImplementations;

/* compiled from: PlatformImplementations.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0083\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\b\u0010\u0006\u001a\u00020\u0005H\u0002\u001a \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\"\u0014\u0010\u000e\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\r¨\u0006\u000f"}, m12616d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "instance", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "c", "major", "minor", "patch", "", "a", "Lkotlin/internal/a;", "Lkotlin/internal/a;", "IMPLEMENTATIONS", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.internal.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14307b {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: a */
    public static final PlatformImplementations f41062a;

    static {
        PlatformImplementations platformImplementations;
        Object newInstance;
        Object newInstance2;
        int m8532c = m8532c();
        if (m8532c >= 65544) {
            try {
                newInstance = JDK8PlatformImplementations.class.newInstance();
                C14342f0.m8185o(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
            } catch (ClassNotFoundException unused) {
                Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                C14342f0.m8185o(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (newInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    platformImplementations = (PlatformImplementations) newInstance3;
                } catch (ClassCastException e) {
                    ClassLoader classLoader = newInstance3.getClass().getClassLoader();
                    ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
                    Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e);
                    C14342f0.m8185o(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause;
                }
            }
            try {
                if (newInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                platformImplementations = (PlatformImplementations) newInstance;
                f41062a = platformImplementations;
            } catch (ClassCastException e2) {
                ClassLoader classLoader3 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader4 = PlatformImplementations.class.getClassLoader();
                Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e2);
                C14342f0.m8185o(initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause2;
            }
        }
        if (m8532c >= 65543) {
            try {
                newInstance2 = JDK7PlatformImplementations.class.newInstance();
                C14342f0.m8185o(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    try {
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader6 = PlatformImplementations.class.getClassLoader();
                        Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e3);
                        C14342f0.m8185o(initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause3;
                    }
                } catch (ClassNotFoundException unused2) {
                }
            } catch (ClassNotFoundException unused3) {
                Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                C14342f0.m8185o(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (newInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    platformImplementations = (PlatformImplementations) newInstance4;
                } catch (ClassCastException e4) {
                    ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = PlatformImplementations.class.getClassLoader();
                    Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e4);
                    C14342f0.m8185o(initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause4;
                }
            }
            if (newInstance2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            platformImplementations = (PlatformImplementations) newInstance2;
            f41062a = platformImplementations;
        }
        platformImplementations = new PlatformImplementations();
        f41062a = platformImplementations;
    }

    @SinceKotlin(version = "1.2")
    @PublishedApi
    /* renamed from: a */
    public static final boolean m8534a(int i, int i2, int i3) {
        return KotlinVersion.f41225f.m7954f(i, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: b */
    private static final /* synthetic */ <T> T m8533b(Object obj) {
        try {
            C14342f0.m8175y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        } catch (ClassCastException e) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            C14342f0.m8175y(4, ExifInterface.GPS_DIRECTION_TRUE);
            ClassLoader classLoader2 = Object.class.getClassLoader();
            Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e);
            C14342f0.m8185o(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            throw initCause;
        }
    }

    /* renamed from: c */
    private static final int m8532c() {
        int m6401q3;
        int m6401q32;
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            m6401q3 = C14579x.m6401q3(property, '.', 0, false, 6, null);
            if (m6401q3 < 0) {
                try {
                    return Integer.parseInt(property) * 65536;
                } catch (NumberFormatException unused) {
                    return 65542;
                }
            }
            int i = m6401q3 + 1;
            m6401q32 = C14579x.m6401q3(property, '.', i, false, 4, null);
            if (m6401q32 < 0) {
                m6401q32 = property.length();
            }
            String substring = property.substring(0, m6401q3);
            C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String substring2 = property.substring(i, m6401q32);
            C14342f0.m8185o(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            try {
                return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
            } catch (NumberFormatException unused2) {
                return 65542;
            }
        }
        return 65542;
    }
}
