package p664z1;

import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import master.flame.danmaku.danmaku.parser.IDataSource;
import p025b2.IOUtils;

/* renamed from: z1.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class AndroidFileSource implements IDataSource<InputStream> {

    /* renamed from: d */
    private InputStream f47156d;

    public AndroidFileSource(String str) {
        m6c(new File(str));
    }

    @Override // master.flame.danmaku.danmaku.parser.IDataSource
    /* renamed from: b */
    public InputStream mo3a() {
        return this.f47156d;
    }

    /* renamed from: c */
    public void m6c(File file) {
        try {
            this.f47156d = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public void m5d(Uri uri) {
        try {
            URL url = new URL(uri.getPath());
            url.openConnection();
            this.f47156d = new BufferedInputStream(url.openStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m4e(Uri uri) {
        String scheme = uri.getScheme();
        if (!IDataSource.f43971a.equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            if (IDataSource.f43973c.equalsIgnoreCase(scheme)) {
                m6c(new File(uri.getPath()));
                return;
            }
            return;
        }
        m5d(uri);
    }

    @Override // master.flame.danmaku.danmaku.parser.IDataSource
    public void release() {
        IOUtils.m59956a(this.f47156d);
        this.f47156d = null;
    }

    public AndroidFileSource(Uri uri) {
        m4e(uri);
    }

    public AndroidFileSource(File file) {
        m6c(file);
    }

    public AndroidFileSource(InputStream inputStream) {
        this.f47156d = inputStream;
    }
}
