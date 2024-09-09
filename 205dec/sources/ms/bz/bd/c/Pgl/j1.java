package ms.bz.bd.c.Pgl;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class j1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f61405a;

    static {
        String str = (String) pblk.a(16777217, 0, 0L, "40d08e", new byte[]{30, 110, 86, 26, 58});
        f61405a = (String) pblk.a(16777217, 0, 0L, "6bd35b", new byte[]{51, 116, 40, 73, 14});
    }

    public static synchronized String a(Context context) {
        String c4;
        synchronized (j1.class) {
            StringBuilder sb = new StringBuilder();
            sb.append(com.bytedance.sdk.openadsdk.api.plugin.w.c(context).getAbsolutePath());
            sb.append((String) pblk.a(16777217, 0, 0L, "627ad6", new byte[]{104}));
            String str = f61405a;
            sb.append(str);
            String sb2 = sb.toString();
            if (!new File(sb2).exists() || (c4 = c(sb2)) == null || c4.length() <= 0) {
                InputStream open = context.getResources().getAssets().open(str);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = open.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(sb2);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.close();
                StringBuilder sb3 = new StringBuilder();
                sb3.append((String) pblk.a(16777217, 0, 0L, "90499f", new byte[]{43, 58, 74, 66, 2, 49, 109, 70, 50, 41}));
                sb3.append(sb2);
                c(sb3.toString());
                String c5 = c(sb2);
                if (c5 == null || c5.length() == 0) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(sb2, (String) pblk.a(16777217, 0, 0L, "751efe", new byte[]{52, 32}));
                    randomAccessFile.seek(16L);
                    randomAccessFile.write(new byte[]{2});
                    randomAccessFile.close();
                    c5 = c(sb2);
                }
                if (c5 == null || c5.length() == 0) {
                    c5 = (String) pblk.a(16777217, 0, 0L, "256daa", new byte[]{115, 12, 25, 81, 0, 75, 20, 38, 85, 27, 17, 12, 25, 81, 0, 75});
                }
                return c5;
            }
            return c4;
        }
    }

    private static String b(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception unused) {
                String str = (String) pblk.a(16777217, 0, 0L, "6215d7", new byte[]{34, 57, 65});
            }
        } while (read >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
        if (r5 != null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.j1.c(java.lang.String):java.lang.String");
    }
}
