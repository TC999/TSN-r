package cn.jiguang.f;

import android.content.Context;
import android.os.SystemClock;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i {
    public static LinkedHashSet<String> a(Context context, LinkedHashSet<String> linkedHashSet) {
        if (cn.jiguang.cn.a.e(context)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.contains("ipv6")) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
            linkedHashSet.clear();
            linkedHashSet.addAll(arrayList);
            linkedHashSet.addAll(arrayList2);
        }
        return linkedHashSet;
    }

    public static LinkedList<InetAddress> a(Context context, LinkedList<InetAddress> linkedList) {
        if (cn.jiguang.cn.a.e(context)) {
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            Iterator<InetAddress> it = linkedList.iterator();
            while (it.hasNext()) {
                InetAddress next = it.next();
                if (next instanceof Inet6Address) {
                    linkedList2.add(next);
                } else if (next instanceof Inet4Address) {
                    linkedList3.add(next);
                }
            }
            linkedList.clear();
            linkedList.addAll(linkedList2);
            linkedList.addAll(linkedList3);
            return linkedList;
        }
        return linkedList;
    }

    public static <T> LinkedList<T> a(Collection<T> collection) {
        LinkedList<T> linkedList = new LinkedList<>();
        int i4 = 0;
        int size = collection != null ? collection.size() : 0;
        if (size == 0) {
            return linkedList;
        }
        if (size == 1) {
            linkedList.addAll(collection);
            return linkedList;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (T t3 : collection) {
            i4++;
            linkedList.add(secureRandom.nextInt(i4), t3);
        }
        return linkedList;
    }

    public static List<cn.jiguang.bv.g> a(List<cn.jiguang.bv.g> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < list.size() - 1; i4++) {
            cn.jiguang.bv.g gVar = list.get(i4);
            if (gVar.f2943a.contains("ipv6")) {
                arrayList.add(gVar);
            } else {
                arrayList2.add(gVar);
            }
        }
        list.clear();
        list.addAll(arrayList);
        list.addAll(arrayList2);
        return list;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(long j4, long j5) {
        if (j5 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            return j4 <= 0 || elapsedRealtime <= j4 || elapsedRealtime > j4 + j5;
        }
        throw new AssertionError();
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream != null) {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return bArr;
        }
        throw new IOException("InputStream is null");
    }

    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(byteArrayOutputStream);
            a(gZIPOutputStream);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            a(byteArrayOutputStream);
            a(gZIPOutputStream2);
            throw th;
        }
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            a(byteArrayOutputStream2);
            throw th;
        }
    }

    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th2) {
            gZIPInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    a((Closeable) byteArrayInputStream);
                    a((Closeable) gZIPInputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            a(byteArrayOutputStream);
            a((Closeable) byteArrayInputStream);
            a((Closeable) gZIPInputStream);
            throw th;
        }
    }

    public static short c(byte[] bArr) {
        int i4;
        if (bArr == null || bArr.length == 0) {
            throw new Exception("byte could not be empty");
        }
        if (bArr.length == 1) {
            i4 = bArr[0];
        } else {
            i4 = ((short) (bArr[1] & 255)) | ((short) ((bArr[0] & 255) << 8));
        }
        return (short) i4;
    }
}
