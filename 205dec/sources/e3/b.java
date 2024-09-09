package e3;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: JSONSource.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class b implements master.flame.danmaku.danmaku.parser.b<JSONArray> {

    /* renamed from: d  reason: collision with root package name */
    private JSONArray f54644d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f54645e;

    public b(String str) throws JSONException {
        d(str);
    }

    private void c(InputStream inputStream) throws JSONException {
        if (inputStream != null) {
            this.f54645e = inputStream;
            d(g3.b.d(inputStream));
            return;
        }
        throw new NullPointerException("input stream cannot be null!");
    }

    private void d(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f54644d = new JSONArray(str);
    }

    @Override // master.flame.danmaku.danmaku.parser.b
    /* renamed from: b */
    public JSONArray a() {
        return this.f54644d;
    }

    @Override // master.flame.danmaku.danmaku.parser.b
    public void release() {
        g3.b.a(this.f54645e);
        this.f54645e = null;
        this.f54644d = null;
    }

    public b(InputStream inputStream) throws JSONException {
        c(inputStream);
    }

    public b(URL url) throws JSONException, IOException {
        this(url.openStream());
    }

    public b(File file) throws FileNotFoundException, JSONException {
        c(new FileInputStream(file));
    }

    public b(Uri uri) throws IOException, JSONException {
        String scheme = uri.getScheme();
        if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            if ("file".equalsIgnoreCase(scheme)) {
                c(new FileInputStream(uri.getPath()));
                return;
            }
            return;
        }
        c(new URL(uri.getPath()).openStream());
    }
}
