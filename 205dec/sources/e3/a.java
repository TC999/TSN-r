package e3;

import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: AndroidFileSource.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class a implements master.flame.danmaku.danmaku.parser.b<InputStream> {

    /* renamed from: d  reason: collision with root package name */
    private InputStream f54643d;

    public a(String str) {
        c(new File(str));
    }

    @Override // master.flame.danmaku.danmaku.parser.b
    /* renamed from: b */
    public InputStream a() {
        return this.f54643d;
    }

    public void c(File file) {
        try {
            this.f54643d = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
        }
    }

    public void d(Uri uri) {
        try {
            URL url = new URL(uri.getPath());
            url.openConnection();
            this.f54643d = new BufferedInputStream(url.openStream());
        } catch (MalformedURLException e4) {
            e4.printStackTrace();
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public void e(Uri uri) {
        String scheme = uri.getScheme();
        if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            if ("file".equalsIgnoreCase(scheme)) {
                c(new File(uri.getPath()));
                return;
            }
            return;
        }
        d(uri);
    }

    @Override // master.flame.danmaku.danmaku.parser.b
    public void release() {
        g3.b.a(this.f54643d);
        this.f54643d = null;
    }

    public a(Uri uri) {
        e(uri);
    }

    public a(File file) {
        c(file);
    }

    public a(InputStream inputStream) {
        this.f54643d = inputStream;
    }
}
