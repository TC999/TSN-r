package cn.jpush.android.w;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.m;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4504a = cn.jpush.android.ad.d.b(new byte[]{32, 0, 14, 41, 38, 38, 63, 1, 23, 43});

    public static d a(Context context, c cVar) {
        return a(context, cVar, true, false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:14|15|16|17|18|(6:117|118|(1:120)|121|(1:123)(1:126)|124)|(3:(1:101)(1:116)|102|(18:104|105|106|107|23|24|25|26|27|28|(9:31|32|(3:48|49|(1:51))|(1:39)|(1:41)(1:47)|42|43|44|45)|56|(3:35|37|39)|(0)(0)|42|43|44|45))|22|23|24|25|26|27|28|(9:31|32|(0)|(0)|(0)(0)|42|43|44|45)|56|(0)|(0)(0)|42|43|44|45) */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x029d, code lost:
        if (r13 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a5, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a6, code lost:
        r1 = r2;
        r2 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a9, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01aa, code lost:
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ac, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ad, code lost:
        r1 = r2;
        r2 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01b1, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b2, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b5, code lost:
        r1 = null;
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b8, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b9, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0207, code lost:
        if (r13 != null) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x021e A[Catch: all -> 0x026a, TryCatch #7 {all -> 0x026a, blocks: (B:102:0x0211, B:104:0x021e, B:105:0x0226, B:112:0x0243, B:106:0x022a, B:108:0x022e, B:109:0x0237, B:111:0x023b), top: B:138:0x0211 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x022a A[Catch: all -> 0x026a, TryCatch #7 {all -> 0x026a, blocks: (B:102:0x0211, B:104:0x021e, B:105:0x0226, B:112:0x0243, B:106:0x022a, B:108:0x022e, B:109:0x0237, B:111:0x023b), top: B:138:0x0211 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017b A[Catch: all -> 0x01a5, IOException -> 0x01a9, MalformedURLException -> 0x01ac, TryCatch #14 {MalformedURLException -> 0x01ac, IOException -> 0x01a9, all -> 0x01a5, blocks: (B:52:0x0149, B:66:0x016b, B:68:0x0171, B:70:0x017b, B:72:0x0189), top: B:146:0x0149 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0188  */
    /* JADX WARN: Type inference failed for: r1v0, types: [cn.jpush.android.w.c] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jpush.android.w.d a(android.content.Context r16, cn.jpush.android.w.c r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 693
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.w.e.a(android.content.Context, cn.jpush.android.w.c, boolean, boolean):cn.jpush.android.w.d");
    }

    public static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Map.Entry<String, String> next = it.next();
                    sb.append(next.getKey());
                    sb.append("=");
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    if (it.hasNext()) {
                        sb.append("&");
                    }
                } catch (Exception unused) {
                }
            }
        }
        return sb.toString();
    }

    public static HttpURLConnection a(Context context, String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    private static void a(c cVar, HttpURLConnection httpURLConnection) {
        if (cVar == null || httpURLConnection == null) {
            return;
        }
        a(cVar.i(), httpURLConnection);
        if (cVar.b() >= 0) {
            httpURLConnection.setConnectTimeout(cVar.b());
        }
        if (cVar.c() >= 0) {
            httpURLConnection.setReadTimeout(cVar.c());
        }
    }

    private static void a(HttpURLConnection httpURLConnection, d dVar) {
        if (dVar == null || httpURLConnection == null) {
            return;
        }
        dVar.a(httpURLConnection.getResponseCode());
        dVar.b(httpURLConnection.getResponseCode());
        dVar.a("expires", httpURLConnection.getHeaderField("Expires"));
        dVar.a("cache-control", httpURLConnection.getHeaderField("Cache-Control"));
    }

    public static void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map == null || map.size() == 0 || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        return m.b(inputStream);
    }
}
