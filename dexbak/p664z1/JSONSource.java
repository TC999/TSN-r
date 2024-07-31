package p664z1;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONArray;
import org.json.JSONException;
import p025b2.IOUtils;

/* renamed from: z1.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class JSONSource implements IDataSource<JSONArray> {

    /* renamed from: d */
    private JSONArray f47157d;

    /* renamed from: e */
    private InputStream f47158e;

    public JSONSource(String str) throws JSONException {
        m0d(str);
    }

    /* renamed from: c */
    private void m1c(InputStream inputStream) throws JSONException {
        if (inputStream != null) {
            this.f47158e = inputStream;
            m0d(IOUtils.m59953d(inputStream));
            return;
        }
        throw new NullPointerException("input stream cannot be null!");
    }

    /* renamed from: d */
    private void m0d(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f47157d = new JSONArray(str);
    }

    @Override // master.flame.danmaku.danmaku.parser.IDataSource
    /* renamed from: b */
    public JSONArray mo3a() {
        return this.f47157d;
    }

    @Override // master.flame.danmaku.danmaku.parser.IDataSource
    public void release() {
        IOUtils.m59956a(this.f47158e);
        this.f47158e = null;
        this.f47157d = null;
    }

    public JSONSource(InputStream inputStream) throws JSONException {
        m1c(inputStream);
    }

    public JSONSource(URL url) throws JSONException, IOException {
        this(url.openStream());
    }

    public JSONSource(File file) throws FileNotFoundException, JSONException {
        m1c(new FileInputStream(file));
    }

    public JSONSource(Uri uri) throws IOException, JSONException {
        String scheme = uri.getScheme();
        if (!IDataSource.f43971a.equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            if (IDataSource.f43973c.equalsIgnoreCase(scheme)) {
                m1c(new FileInputStream(uri.getPath()));
                return;
            }
            return;
        }
        m1c(new URL(uri.getPath()).openStream());
    }
}
