package p661y1;

import android.net.Uri;
import java.io.InputStream;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import p658x1.ILoader;
import p664z1.JSONSource;

/* renamed from: y1.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class AcFunDanmakuLoader implements ILoader {

    /* renamed from: b */
    private static volatile AcFunDanmakuLoader f47150b;

    /* renamed from: a */
    private JSONSource f47151a;

    private AcFunDanmakuLoader() {
    }

    /* renamed from: c */
    public static ILoader m21c() {
        if (f47150b == null) {
            synchronized (AcFunDanmakuLoader.class) {
                if (f47150b == null) {
                    f47150b = new AcFunDanmakuLoader();
                }
            }
        }
        return f47150b;
    }

    @Override // p658x1.ILoader
    /* renamed from: a */
    public void mo20a(String str) throws IllegalDataException {
        try {
            this.f47151a = new JSONSource(Uri.parse(str));
        } catch (Exception e) {
            throw new IllegalDataException(e);
        }
    }

    @Override // p658x1.ILoader
    /* renamed from: b */
    public JSONSource getDataSource() {
        return this.f47151a;
    }

    @Override // p658x1.ILoader
    public void load(InputStream inputStream) throws IllegalDataException {
        try {
            this.f47151a = new JSONSource(inputStream);
        } catch (Exception e) {
            throw new IllegalDataException(e);
        }
    }
}
