package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import ms.bz.bd.c.Pgl.m0;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l0 implements m0.pgla {

    /* renamed from: a  reason: collision with root package name */
    private final long f61409a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f61410b;

    /* renamed from: c  reason: collision with root package name */
    private final a f61411c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(a aVar, Context context, long j4) {
        if (context == null) {
            throw new NullPointerException("context could not be null");
        }
        this.f61411c = aVar;
        this.f61410b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f61409a = j4;
    }

    @Override // ms.bz.bd.c.Pgl.m0.pgla
    public Map<String, String> c(String str, byte[] bArr) {
        String[] strArr;
        HashMap hashMap = new HashMap();
        if (str != null && str.length() != 0 && (strArr = (String[]) pblb.a(33554438, 0, this.f61409a, str, bArr)) != null && strArr.length % 2 == 0) {
            for (int i4 = 0; i4 < strArr.length; i4 += 2) {
                String str2 = strArr[i4];
                String str3 = strArr[i4 + 1];
                if (str2 != null && str3 != null) {
                    hashMap.put(str2, str3);
                }
            }
        }
        return hashMap;
    }

    @Override // ms.bz.bd.c.Pgl.m0.pgla
    public void c(String str) {
        if (this.f61409a == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        pblb.a(33554433, 0, this.f61409a, str, this.f61410b);
    }

    @Override // ms.bz.bd.c.Pgl.m0.pgla
    public void w(String str) {
        this.f61411c.f61371c = str;
        long j4 = this.f61409a;
        if (j4 != -1) {
            pblb.a(33554434, 0, j4, str, this.f61410b);
        }
    }
}
