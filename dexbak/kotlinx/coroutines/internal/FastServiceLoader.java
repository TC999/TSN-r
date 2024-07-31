package kotlinx.coroutines.internal;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.C14305i;
import kotlin.Metadata;
import kotlin.collections.C14236x;
import kotlin.collections.MutableCollections;
import kotlin.collections._Collections;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.p613io.Closeable;
import kotlin.text.C14579x;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J!\u0010\u0007\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0082\bJ*\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J3\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J.\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0014*\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00028\u00000\u0016H\u0082\b¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ1\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010!¨\u0006%"}, m12616d2 = {"Lkotlinx/coroutines/internal/l;", "", "Ljava/lang/Class;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "", "serviceClass", "a", ExifInterface.LATITUDE_SOUTH, NotificationCompat.CATEGORY_SERVICE, "Ljava/lang/ClassLoader;", "loader", "", "c", "name", "b", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/net/URL;", "url", "f", "R", "Ljava/util/jar/JarFile;", "Lkotlin/Function1;", "block", "h", "(Ljava/util/jar/JarFile;Ll1/l;)Ljava/lang/Object;", "Ljava/io/BufferedReader;", "r", "g", "d", "()Ljava/util/List;", "e", "(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/List;", "Ljava/lang/String;", "PREFIX", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FastServiceLoader {

    /* renamed from: a */
    private static final String f43060a = "META-INF/services/";

    /* renamed from: b */
    public static final FastServiceLoader f43061b = new FastServiceLoader();

    private FastServiceLoader() {
    }

    /* renamed from: a */
    private final MainDispatcherFactory m4289a(Class<MainDispatcherFactory> cls, String str) {
        try {
            return cls.cast(Class.forName(str, true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: b */
    private final <S> S m4288b(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    /* renamed from: c */
    private final <S> List<S> m4287c(Class<S> cls, ClassLoader classLoader) {
        List<S> m12233I5;
        try {
            return m4285e(cls, classLoader);
        } catch (Throwable unused) {
            m12233I5 = _Collections.m12233I5(ServiceLoader.load(cls, classLoader));
            return m12233I5;
        }
    }

    /* renamed from: f */
    private final List<String> m4284f(URL url) {
        boolean m6548u2;
        String m6402p5;
        String m6381w5;
        String m6402p52;
        String url2 = url.toString();
        m6548u2 = StringsJVM.m6548u2(url2, "jar", false, 2, null);
        if (m6548u2) {
            m6402p5 = C14579x.m6402p5(url2, "jar:file:", null, 2, null);
            m6381w5 = C14579x.m6381w5(m6402p5, '!', null, 2, null);
            m6402p52 = C14579x.m6402p5(url2, "!/", null, 2, null);
            JarFile jarFile = new JarFile(m6381w5, false);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(m6402p52)), "UTF-8"));
                List<String> m4283g = f43061b.m4283g(bufferedReader);
                Closeable.m8492a(bufferedReader, null);
                jarFile.close();
                return m4283g;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        jarFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        C14305i.m8548a(th, th3);
                        throw th;
                    }
                }
            }
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(url.openStream()));
        try {
            List<String> m4283g2 = f43061b.m4283g(bufferedReader2);
            Closeable.m8492a(bufferedReader2, null);
            return m4283g2;
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                Closeable.m8492a(bufferedReader2, th4);
                throw th5;
            }
        }
    }

    /* renamed from: g */
    private final List<String> m4283g(BufferedReader bufferedReader) {
        List<String> m12233I5;
        String m6378x5;
        CharSequence m6523E5;
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                m6378x5 = C14579x.m6378x5(readLine, "#", null, 2, null);
                if (m6378x5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                m6523E5 = C14579x.m6523E5(m6378x5);
                String obj = m6523E5.toString();
                int i = 0;
                while (true) {
                    if (i >= obj.length()) {
                        z = true;
                        break;
                    }
                    char charAt = obj.charAt(i);
                    if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    if (obj.length() > 0) {
                        linkedHashSet.add(obj);
                    }
                } else {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                }
            } else {
                m12233I5 = _Collections.m12233I5(linkedHashSet);
                return m12233I5;
            }
        }
    }

    /* renamed from: h */
    private final <R> R m4282h(JarFile jarFile, InterfaceC15280l<? super JarFile, ? extends R> interfaceC15280l) {
        try {
            R invoke = interfaceC15280l.invoke(jarFile);
            InlineMarker.m8228d(1);
            jarFile.close();
            InlineMarker.m8229c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                try {
                    jarFile.close();
                    InlineMarker.m8229c(1);
                    throw th2;
                } catch (Throwable th3) {
                    C14305i.m8548a(th, th3);
                    throw th;
                }
            }
        }
    }

    @NotNull
    /* renamed from: d */
    public final List<MainDispatcherFactory> m4286d() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!C15083m.m4274a()) {
            return m4287c(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
                return arrayList;
            }
            return arrayList;
        } catch (Throwable unused3) {
            return m4287c(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    @NotNull
    /* renamed from: e */
    public final <S> List<S> m4285e(@NotNull Class<S> cls, @NotNull ClassLoader classLoader) {
        Set<String> m12208N5;
        int m8957Y;
        ArrayList<URL> list = Collections.list(classLoader.getResources(f43060a + cls.getName()));
        C14342f0.m8185o(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            MutableCollections.m12416q0(arrayList, f43061b.m4284f(url));
        }
        m12208N5 = _Collections.m12208N5(arrayList);
        if (!m12208N5.isEmpty()) {
            m8957Y = C14236x.m8957Y(m12208N5, 10);
            ArrayList arrayList2 = new ArrayList(m8957Y);
            for (String str : m12208N5) {
                arrayList2.add(f43061b.m4288b(str, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
