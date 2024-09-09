package ms.bz.bd.c.Pgl;

import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class pblg extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    protected Object b(int i4, long j4, String str, Object obj) throws Throwable {
        InputStream inputStream;
        IOException e4;
        FileOutputStream fileOutputStream;
        AssetManager assets = pgla.a().c().getAssets();
        if (!str.startsWith((String) pblk.a(16777217, 0, 0L, "a7871d", new byte[]{62}))) {
            str = ((String) pblk.a(16777217, 0, 0L, "f04a8c", new byte[]{57})) + str;
        }
        String[] list = assets.list("");
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < list.length; i5++) {
            if (list[i5].endsWith(str)) {
                String str2 = list[i5];
                String absolutePath = File.createTempFile((String) pblk.a(16777217, 0, 0L, "6b6aea", new byte[]{42, 115, 64, 13, 78}), "").getAbsolutePath();
                FileOutputStream fileOutputStream2 = null;
                try {
                    inputStream = assets.open(str2);
                } catch (IOException e5) {
                    e4 = e5;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                }
                try {
                    try {
                        fileOutputStream = new FileOutputStream(absolutePath);
                        try {
                            if (pbly.a(inputStream, fileOutputStream) > 0) {
                                arrayList.add(absolutePath);
                            }
                        } catch (IOException e6) {
                            e4 = e6;
                            fileOutputStream2 = fileOutputStream;
                            e4.printStackTrace();
                            fileOutputStream = fileOutputStream2;
                            pbly.c(inputStream);
                            pbly.c(fileOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            pbly.c(inputStream);
                            pbly.c(fileOutputStream2);
                            throw th;
                        }
                    } catch (IOException e7) {
                        e4 = e7;
                    }
                    pbly.c(inputStream);
                    pbly.c(fileOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
        return arrayList.toArray(new String[0]);
    }
}
