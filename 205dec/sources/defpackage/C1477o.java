package defpackage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarFile;
import sun.net.www.ParseUtil;
import sun.net.www.protocol.jar.Handler;

/* renamed from: o  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1477o extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final String f61570a;

    /* renamed from: b  reason: collision with root package name */
    public final JarFile f61571b;

    public C1477o(String str) {
        this.f61571b = new JarFile(str);
        this.f61570a = new File(str).toURI().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final URL a(String str) {
        if (this.f61571b.getEntry(str) != null) {
            try {
                String encodePath = ParseUtil.encodePath(str, false);
                return new URL("jar", null, -1, this.f61570a + "!/" + encodePath, this);
            } catch (MalformedURLException e4) {
                throw new RuntimeException("Invalid entry name", e4);
            }
        }
        return null;
    }

    public final void finalize() {
        this.f61571b.close();
    }

    public final URLConnection openConnection(URL url) {
        return new C1475n(this, url);
    }
}
