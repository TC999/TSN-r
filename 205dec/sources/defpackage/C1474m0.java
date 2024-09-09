package defpackage;

import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.jar.JarFile;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import sun.misc.CompoundEnumeration;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;

/* renamed from: m0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1474m0 extends AbstractC1471l {

    /* renamed from: c  reason: collision with root package name */
    public static final ArrayList f60823c = b(System.getProperty("java.library.path"));

    /* renamed from: a  reason: collision with root package name */
    public final String f60824a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f60825b;

    public C1474m0(ClassLoader classLoader, String str, ByteBuffer[] byteBufferArr) {
        super(byteBufferArr, classLoader);
        this.f60825b = new ArrayList();
        this.f60824a = str;
    }

    public static C1474m0 a(String str, ArrayList arrayList, String str2, ClassLoader classLoader) {
        C1474m0 c1474m0;
        ByteBuffer[] byteBufferArr = (ByteBuffer[]) ((Stream) arrayList.stream().parallel()).map(new L0(3)).filter(new Object()).toArray(new Object());
        if (Build.VERSION.SDK_INT >= 29) {
            c1474m0 = new C1474m0(byteBufferArr, str2, classLoader, str);
        } else {
            c1474m0 = new C1474m0(classLoader, str, byteBufferArr);
            ArrayList b4 = b(str2);
            ArrayList arrayList2 = c1474m0.f60825b;
            arrayList2.addAll(b4);
            arrayList2.addAll(f60823c);
        }
        ((Stream) Arrays.stream(byteBufferArr).parallel()).forEach(new L(1));
        ((Stream) arrayList.stream().parallel()).forEach(new L(2));
        return c1474m0;
    }

    public static ArrayList b(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        for (String str2 : str.split(File.pathSeparator)) {
            arrayList.add(new File(str2));
        }
        return arrayList;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String[] split;
        String mapLibraryName = System.mapLibraryName(str);
        Iterator it = this.f60825b.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String path = file.getPath();
            if (path.contains("!/")) {
                try {
                    JarFile jarFile = new JarFile(path.split("!/", 2)[0]);
                    String str2 = split[1] + '/' + mapLibraryName;
                    ZipEntry entry = jarFile.getEntry(str2);
                    if (entry != null && entry.getMethod() == 0) {
                        String str3 = split[0] + "!/" + str2;
                        jarFile.close();
                        return str3;
                    }
                    jarFile.close();
                } catch (IOException e4) {
                    Log.e(XposedBridge.TAG, "Can not open " + split[0], e4);
                }
            } else if (file.isDirectory()) {
                String path2 = new File(file, mapLibraryName).getPath();
                try {
                    Os.close(Os.open(path2, OsConstants.O_RDONLY, 0));
                    return path2;
                } catch (ErrnoException unused) {
                    continue;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final URL findResource(String str) {
        try {
            C1477o c1477o = new C1477o(this.f60824a);
            URL a4 = c1477o.a(str);
            if (a4 == null) {
                c1477o.finalize();
            }
            return a4;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Enumeration findResources(String str) {
        ArrayList arrayList = new ArrayList();
        URL findResource = findResource(str);
        if (findResource != null) {
            arrayList.add(findResource);
        }
        return Collections.enumeration(arrayList);
    }

    public final String getLdLibraryPath() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f60825b.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (sb.length() > 0) {
                sb.append(':');
            }
            sb.append(file);
        }
        return sb.toString();
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        URL resource = Object.class.getClassLoader().getResource(str);
        if (resource != null) {
            return resource;
        }
        URL findResource = findResource(str);
        if (findResource != null) {
            return findResource;
        }
        ClassLoader parent = getParent();
        if (parent == null) {
            return null;
        }
        return parent.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public final Enumeration getResources(String str) {
        Enumeration[] enumerationArr = new Enumeration[3];
        enumerationArr[0] = Object.class.getClassLoader().getResources(str);
        enumerationArr[1] = findResources(str);
        enumerationArr[2] = getParent() == null ? null : getParent().getResources(str);
        return new CompoundEnumeration(enumerationArr);
    }

    @Override // java.lang.ClassLoader
    public final Class loadClass(String str, boolean z3) {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            try {
                return Object.class.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused) {
                return findClass(str);
            }
        } catch (ClassNotFoundException e4) {
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException unused2) {
                throw e4;
            }
        }
    }

    @Override // dalvik.system.BaseDexClassLoader
    public final String toString() {
        String str = this.f60824a;
        if (str == null) {
            return "LspModuleClassLoader[instantiating]";
        }
        return "LspModuleClassLoader[module=" + str + ", " + super.toString() + "]";
    }

    public C1474m0(ByteBuffer[] byteBufferArr, String str, ClassLoader classLoader, String str2) {
        super(byteBufferArr, str, classLoader);
        ArrayList arrayList = new ArrayList();
        this.f60825b = arrayList;
        arrayList.addAll(b(str));
        arrayList.addAll(f60823c);
        this.f60824a = str2;
    }
}
