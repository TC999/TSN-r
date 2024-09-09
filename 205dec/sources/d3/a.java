package d3;

import android.net.Uri;
import java.io.InputStream;
import master.flame.danmaku.danmaku.loader.IllegalDataException;

/* compiled from: AcFunDanmakuLoader.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class a implements c3.a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f54624b;

    /* renamed from: a  reason: collision with root package name */
    private e3.b f54625a;

    private a() {
    }

    public static c3.a c() {
        if (f54624b == null) {
            synchronized (a.class) {
                if (f54624b == null) {
                    f54624b = new a();
                }
            }
        }
        return f54624b;
    }

    @Override // c3.a
    public void a(String str) throws IllegalDataException {
        try {
            this.f54625a = new e3.b(Uri.parse(str));
        } catch (Exception e4) {
            throw new IllegalDataException(e4);
        }
    }

    @Override // c3.a
    /* renamed from: b */
    public e3.b getDataSource() {
        return this.f54625a;
    }

    @Override // c3.a
    public void load(InputStream inputStream) throws IllegalDataException {
        try {
            this.f54625a = new e3.b(inputStream);
        } catch (Exception e4) {
            throw new IllegalDataException(e4);
        }
    }
}
