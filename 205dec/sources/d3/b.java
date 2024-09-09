package d3;

import java.io.InputStream;
import master.flame.danmaku.danmaku.loader.IllegalDataException;

/* compiled from: BiliDanmakuLoader.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class b implements c3.a {

    /* renamed from: b  reason: collision with root package name */
    private static b f54626b;

    /* renamed from: a  reason: collision with root package name */
    private e3.a f54627a;

    private b() {
    }

    public static b c() {
        if (f54626b == null) {
            f54626b = new b();
        }
        return f54626b;
    }

    @Override // c3.a
    public void a(String str) throws IllegalDataException {
        try {
            this.f54627a = new e3.a(str);
        } catch (Exception e4) {
            throw new IllegalDataException(e4);
        }
    }

    @Override // c3.a
    /* renamed from: b */
    public e3.a getDataSource() {
        return this.f54627a;
    }

    @Override // c3.a
    public void load(InputStream inputStream) {
        this.f54627a = new e3.a(inputStream);
    }
}
