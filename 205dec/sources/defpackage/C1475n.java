package defpackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* renamed from: n  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1475n extends JarURLConnection {

    /* renamed from: a  reason: collision with root package name */
    public JarFile f61483a;

    /* renamed from: b  reason: collision with root package name */
    public ZipEntry f61484b;

    /* renamed from: c  reason: collision with root package name */
    public C1473m f61485c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61486d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ C1477o f61487e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1475n(C1477o c1477o, URL url) {
        super(url);
        this.f61487e = c1477o;
        this.f61483a = null;
        this.f61484b = null;
        this.f61485c = null;
        this.f61486d = false;
        super.setUseCaches(false);
    }

    @Override // java.net.URLConnection
    public final void connect() {
        if (this.f61486d) {
            throw new IllegalStateException("JarURLConnection has been closed");
        }
        if (((JarURLConnection) this).connected) {
            return;
        }
        C1477o c1477o = this.f61487e;
        ZipEntry entry = c1477o.f61571b.getEntry(getEntryName());
        this.f61484b = entry;
        if (entry != null) {
            ((JarURLConnection) this).connected = true;
            return;
        }
        throw new FileNotFoundException("URL=" + ((JarURLConnection) this).url + ", zipfile=" + c1477o.f61571b.getName());
    }

    @Override // java.net.URLConnection
    public final int getContentLength() {
        try {
            connect();
            return (int) getJarEntry().getSize();
        } catch (IOException unused) {
            return -1;
        }
    }

    @Override // java.net.URLConnection
    public final String getContentType() {
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(getEntryName());
        return guessContentTypeFromName == null ? "content/unknown" : guessContentTypeFromName;
    }

    @Override // java.net.URLConnection
    public final InputStream getInputStream() {
        connect();
        C1473m c1473m = this.f61485c;
        if (c1473m != null) {
            return c1473m;
        }
        C1473m c1473m2 = new C1473m(this, this.f61487e.f61571b.getInputStream(this.f61484b));
        this.f61485c = c1473m2;
        return c1473m2;
    }

    @Override // java.net.JarURLConnection
    public final JarFile getJarFile() {
        connect();
        JarFile jarFile = this.f61483a;
        if (jarFile != null) {
            return jarFile;
        }
        JarFile jarFile2 = new JarFile(this.f61487e.f61571b.getName());
        this.f61483a = jarFile2;
        return jarFile2;
    }

    @Override // java.net.URLConnection
    public final void setUseCaches(boolean z3) {
        super.setUseCaches(false);
    }
}
