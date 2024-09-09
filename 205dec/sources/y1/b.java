package y1;

import java.io.InputStream;
import master.flame.danmaku.danmaku.loader.IllegalDataException;

/* compiled from: BiliDanmakuLoader.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class b implements x1.a {

    /* renamed from: b  reason: collision with root package name */
    private static b f65066b;

    /* renamed from: a  reason: collision with root package name */
    private z1.a f65067a;

    private b() {
    }

    public static b c() {
        if (f65066b == null) {
            f65066b = new b();
        }
        return f65066b;
    }

    public void a(String str) throws IllegalDataException {
        try {
            this.f65067a = new z1.a(str);
        } catch (Exception e4) {
            throw new IllegalDataException(e4);
        }
    }

    /* renamed from: b */
    public z1.a getDataSource() {
        return this.f65067a;
    }

    public void load(InputStream inputStream) {
        this.f65067a = new z1.a(inputStream);
    }
}
