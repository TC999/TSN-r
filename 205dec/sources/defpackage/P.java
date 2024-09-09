package defpackage;

import io.github.libxposed.api.utils.DexParser;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.jar.JarFile;
import org.slf4j.ILoggerFactory;

/* renamed from: P  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class P implements DexParser.Array, ILoggerFactory {

    /* renamed from: a  reason: collision with root package name */
    public final Object f53a;

    public P(File file) {
        this.f53a = new HashMap();
        JarFile jarFile = new JarFile(file);
        try {
            InputStream inputStream = jarFile.getInputStream(jarFile.getEntry("AndroidManifest.xml"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        new C1465i(byteArray).a(new q0(this));
                        inputStream.close();
                        jarFile.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                jarFile.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static int b(String str) {
        int length = str.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if ('0' > charAt || charAt > '9') {
                break;
            }
            i4 = (i4 * 10) + (charAt - '0');
        }
        return i4;
    }

    @Override // org.slf4j.ILoggerFactory
    public final void a(String str) {
        synchronized (((List) this.f53a)) {
            ((List) this.f53a).add(str);
        }
    }

    @Override // io.github.libxposed.api.utils.DexParser.Array
    public final DexParser.Value[] getValues() {
        return (DexParser.Value[]) this.f53a;
    }

    public P() {
        this.f53a = new ArrayList();
    }

    public P(int[] iArr, Object[] objArr) {
        this.f53a = new DexParser.Value[objArr.length];
        for (int i4 = 0; i4 < objArr.length; i4++) {
            ((DexParser.Value[]) this.f53a)[i4] = new Y(iArr[i4], (ByteBuffer) objArr[i4]);
        }
    }
}
