package c3;

import java.io.InputStream;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: ILoader.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface a {
    void a(String str) throws IllegalDataException;

    b<?> getDataSource();

    void load(InputStream inputStream) throws IllegalDataException;
}
