package p661y1;

import java.io.InputStream;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import p658x1.ILoader;
import p664z1.AndroidFileSource;

/* renamed from: y1.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class BiliDanmakuLoader implements ILoader {

    /* renamed from: b */
    private static BiliDanmakuLoader f47152b;

    /* renamed from: a */
    private AndroidFileSource f47153a;

    private BiliDanmakuLoader() {
    }

    /* renamed from: c */
    public static BiliDanmakuLoader m18c() {
        if (f47152b == null) {
            f47152b = new BiliDanmakuLoader();
        }
        return f47152b;
    }

    @Override // p658x1.ILoader
    /* renamed from: a */
    public void mo20a(String str) throws IllegalDataException {
        try {
            this.f47153a = new AndroidFileSource(str);
        } catch (Exception e) {
            throw new IllegalDataException(e);
        }
    }

    @Override // p658x1.ILoader
    /* renamed from: b */
    public AndroidFileSource getDataSource() {
        return this.f47153a;
    }

    @Override // p658x1.ILoader
    public void load(InputStream inputStream) {
        this.f47153a = new AndroidFileSource(inputStream);
    }
}
