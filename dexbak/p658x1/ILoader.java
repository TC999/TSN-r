package p658x1;

import java.io.InputStream;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: x1.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface ILoader {
    /* renamed from: a */
    void mo20a(String str) throws IllegalDataException;

    IDataSource<?> getDataSource();

    void load(InputStream inputStream) throws IllegalDataException;
}
