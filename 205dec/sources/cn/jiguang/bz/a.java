package cn.jiguang.bz;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.cn.f;
import cn.jiguang.cn.g;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    public static Pair<c, ByteBuffer> a(Context context, byte[] bArr, String str) {
        ByteBuffer wrap;
        if (bArr.length < 20) {
            cn.jiguang.bq.d.j("JCommands", "Error: received body-length short than common head-length, return null");
            return null;
        }
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        c cVar = new c(false, bArr2);
        cn.jiguang.bq.d.c("JCommands", "parsed head - " + cVar.toString());
        int i4 = cVar.f3168a - 20;
        if (i4 < 0) {
            cn.jiguang.bq.d.j("JCommands", "Error: totalBytes length error with no encrypted, return null");
            return null;
        }
        cn.jiguang.bq.d.a("JCommands", "body size:" + i4);
        if (TextUtils.isEmpty(str)) {
            str = b.a(context);
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr, 20, bArr3, 0, i4);
        if (TextUtils.isEmpty(str)) {
            System.arraycopy(bArr, 20, bArr3, 0, i4);
            wrap = ByteBuffer.wrap(bArr3);
        } else {
            try {
                wrap = ByteBuffer.wrap(cVar.f3171d == 2 ? new f().b(bArr3, str) : g.a(bArr3, str, str.substring(0, 16), false));
            } catch (Exception e4) {
                cn.jiguang.bq.d.c("JCommands", "decryptBytes error:" + e4.getMessage());
                return null;
            }
        }
        return new Pair<>(cVar, wrap);
    }

    public static boolean a(cn.jiguang.ca.a aVar, Context context, byte[] bArr) {
        try {
            Pair<c, ByteBuffer> a4 = a(context, bArr, "");
            if (a4 == null) {
                cn.jiguang.cf.b a5 = cn.jiguang.cf.b.a();
                a5.a(aVar.f3213h + ":" + aVar.f3214i, "unknown_conn", bArr.length);
                return false;
            }
            cn.jiguang.cf.b a6 = cn.jiguang.cf.b.a();
            a6.a(aVar.f3213h + ":" + aVar.f3214i, "conn", bArr.length);
            long f4 = cn.jiguang.d.a.f(context);
            long j4 = ((c) a4.first).f3174g;
            if (f4 == 0 || j4 == 0 || f4 == j4) {
                cn.jiguang.bx.b.a().a(context, (c) a4.first, (ByteBuffer) a4.second);
                return true;
            }
            cn.jiguang.bq.d.c("JCommands", "recv other app msg");
            cn.jiguang.e.a.b().a(context, j4, bArr);
            return true;
        } catch (Throwable th) {
            cn.jiguang.bq.d.j("JCommands", "dispatchMessage error:" + th.getMessage());
            return false;
        }
    }
}
