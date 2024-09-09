package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Process;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class pblo extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object a(int i4, int i5, long j4, String str, Object obj) throws Throwable {
        boolean z3;
        Context c4;
        int i6;
        String[] strArr = {(String) pblk.a(16777217, 0, 0L, "702e9b", new byte[]{39, 60, 69, 3, 9, 124, 48, 95, 115, 48, 52, 63, 72, 2, 21, 124, 59, 31, 45, 28, 8, 6, 100, 35, 40, 80, 0})};
        try {
            c4 = pgla.a().c();
        } catch (Throwable unused) {
        }
        for (i6 = 0; i6 < 1; i6++) {
            if (c4.checkPermission(strArr[i6], Process.myPid(), Process.myUid()) != 0) {
                z3 = false;
                break;
            }
        }
        z3 = true;
        if (z3) {
            switch (i4) {
                case 196609:
                    Object[] objArr = (Object[]) obj;
                    return f(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
                case 196610:
                    Object[] objArr2 = (Object[]) obj;
                    return e(str, (String) objArr2[0], (String) objArr2[1]);
                case 196611:
                    Object[] objArr3 = (Object[]) obj;
                    return g(str, (String) objArr3[0], (String) objArr3[1]);
                default:
                    return super.a(i4, i5, j4, str, obj);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
                String str = (String) pblk.a(16777217, 0, 0L, "50958e", new byte[]{41, 49, 117, 66, 14});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                String str = (String) pblk.a(16777217, 0, 0L, "9c84ee", new byte[]{37, 98, 116, 67, 85});
            }
        }
    }

    public abstract Object[] e(String str, String str2, String str3);

    public abstract Object[] f(String str, byte[] bArr, String str2, String str3);

    public abstract Object[] g(String str, String str2, String str3);
}
