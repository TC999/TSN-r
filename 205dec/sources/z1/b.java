package z1;

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
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class b implements master.flame.danmaku.danmaku.parser.b<JSONArray> {

    /* renamed from: d  reason: collision with root package name */
    private JSONArray f65076d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f65077e;

    public b(String str) throws JSONException {
        d(str);
    }

    private void c(InputStream inputStream) throws JSONException {
        if (inputStream != null) {
            this.f65077e = inputStream;
            d(b2.b.d(inputStream));
            return;
        }
        throw new NullPointerException("input stream cannot be null!");
    }

    private void d(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f65076d = new JSONArray(str);
    }

    @Override // master.flame.danmaku.danmaku.parser.b
    /* renamed from: b */
    public JSONArray a() {
        return this.f65076d;
    }

    @Override // master.flame.danmaku.danmaku.parser.b
    public void release() {
        b2.b.a(this.f65077e);
        this.f65077e = null;
        this.f65076d = null;
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
