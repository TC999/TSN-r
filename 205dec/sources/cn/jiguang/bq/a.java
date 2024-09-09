package cn.jiguang.bq;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.f.g;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f2825a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2826b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f2827c;

    /* renamed from: d  reason: collision with root package name */
    private static LinkedList<String> f2828d;

    static {
        String b4 = cn.jiguang.cn.d.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 124, 59, 115, 38, 5, 68, 44, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, 31, 87, 112, 39, 122, 124, 95, 80, 106});
        f2826b = b4;
        String b5 = cn.jiguang.cn.d.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 83, 69, 42, 109, 33, 36, 84, 21, 52, 97, 102, 103, 6, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 102, 89, 15, 117, 101, 121, 97, 67});
        f2827c = b5;
        f2825a = "";
        LinkedList<String> linkedList = new LinkedList<>();
        f2828d = linkedList;
        linkedList.clear();
        f2828d.add(b4);
        f2828d.add(b5);
    }

    public static String a(Context context, String str) {
        String a4;
        try {
            a4 = cn.jiguang.bk.a.a(context);
        } catch (Throwable th) {
            d.i("LogFileHelper", "getUploadToken error is " + th.getMessage());
        }
        if (TextUtils.isEmpty(a4)) {
            d.i("LogFileHelper", "request upload token failed because can't get appKey");
            return "";
        }
        g.a(context, f2828d);
        Iterator<String> it = f2828d.iterator();
        while (it.hasNext()) {
            String next = it.next();
            long f4 = cn.jiguang.d.a.f(context);
            if (f4 == 0) {
                d.i("LogFileHelper", "request l config failed because can't get uid");
                return null;
            }
            String i4 = cn.jiguang.d.a.i(context);
            if (TextUtils.isEmpty(i4)) {
                d.i("LogFileHelper", "request l config failed because need register first");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", a4);
            jSONObject.put("uid", f4);
            jSONObject.put("platform", "a");
            jSONObject.put(DomainCampaignEx.LOOPBACK_KEY, str);
            String upperCase = g.e(i4).toUpperCase();
            String upperCase2 = g.e(f4 + upperCase).toUpperCase();
            if (TextUtils.isEmpty(upperCase2)) {
                return null;
            }
            String encodeToString = Base64.encodeToString((f4 + ":" + upperCase2).getBytes(), 10);
            if (TextUtils.isEmpty(encodeToString)) {
                return null;
            }
            d.c("LogFileHelper", "url:" + next + ", param json:" + jSONObject.toString());
            HttpRequest httpRequest = new HttpRequest(next);
            httpRequest.setRequestProperty("Content-Type", "application/json");
            httpRequest.setRequestProperty("Accept", "application/json");
            httpRequest.setRequestProperty("X-Http-Platform", "android");
            httpRequest.setRequestProperty("X-Http-Appkey", a4);
            httpRequest.setRequestProperty("Authorization", "Basic " + encodeToString);
            httpRequest.setRequestProperty("Charset", "UTF-8");
            httpRequest.setBody(jSONObject.toString());
            HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
            int responseCode = httpPost.getResponseCode();
            d.c("LogFileHelper", "responseCode:" + responseCode);
            if (200 == responseCode) {
                String responseBody = httpPost.getResponseBody();
                d.c("LogFileHelper", "responseBody:" + responseBody);
                if (TextUtils.isEmpty(responseBody)) {
                    continue;
                } else {
                    d.c("LogFileHelper", "request upload token success,response body:" + responseBody);
                    JSONObject jSONObject2 = new JSONObject(responseBody);
                    if (jSONObject2.optInt("code") == 2000) {
                        return jSONObject2.optJSONObject("data") != null ? jSONObject2.optJSONObject("data").optString("uploadPreSignedURL") : "";
                    }
                    d.i("LogFileHelper", "start to open log ");
                    a(context, false, "", jSONObject2.optString("content"));
                }
            }
        }
        return "";
    }

    public static void a(final Context context) {
        if (context == null) {
            return;
        }
        int intValue = ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ax())).intValue();
        if (intValue <= 10) {
            intValue = 10;
        }
        cn.jiguang.cm.d.a("DELAY_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.bq.a.1
            @Override // cn.jiguang.cm.b
            public void a() {
                try {
                    long f4 = cn.jiguang.d.a.f(context);
                    if (f4 == 0) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getFilesDir());
                    String str = File.separator;
                    sb.append(str);
                    sb.append("nes");
                    String sb2 = sb.toString();
                    String str2 = "android-" + cn.jiguang.f.a.o(context) + "-" + f4 + ".zip";
                    String str3 = context.getFilesDir() + str + str2;
                    cn.jiguang.cj.b.a(sb2, str3);
                    File file = new File(str3);
                    if (!file.getParentFile().exists()) {
                        d.c("LogFileHelper", "there is no log file dir!");
                        return;
                    }
                    if (file.exists() && file.length() != 0) {
                        String a4 = a.a(context, str2);
                        if (TextUtils.isEmpty(a4)) {
                            d.c("LogFileHelper", "getUploadToken url is empty");
                            file.delete();
                            return;
                        }
                        if (cn.jiguang.br.b.a(context, a4, file)) {
                            cn.jiguang.f.c.e(new File(sb2));
                        }
                        file.delete();
                        return;
                    }
                    d.c("LogFileHelper", "there is no log file to upload!");
                } catch (Throwable th) {
                    d.i("LogFileHelper", "startUpload error is " + th.getMessage());
                }
            }
        }, intValue * 1000);
    }

    public static void a(Context context, boolean z3, String str, String str2) {
        if (((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ah())).booleanValue()) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.jiguang.openlog");
            launchIntentForPackage.putExtra("uid", cn.jiguang.d.a.f(context));
            launchIntentForPackage.putExtra("appKey", cn.jiguang.bk.a.a(context));
            launchIntentForPackage.putExtra("appName", str);
            launchIntentForPackage.putExtra("content", str2);
            launchIntentForPackage.putExtra("result", z3);
            context.startActivity(launchIntentForPackage);
        }
    }

    public static void b(final Context context) {
        if (context == null) {
            return;
        }
        int intValue = ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ax())).intValue();
        if (intValue <= 10) {
            intValue = 10;
        }
        cn.jiguang.cm.d.a("DELAY_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.bq.a.2
            @Override // cn.jiguang.cm.b
            public void a() {
                String str;
                try {
                    long f4 = cn.jiguang.d.a.f(context);
                    if (f4 == 0) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getFilesDir());
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append(c.f2831a);
                    sb.append(str2);
                    String sb2 = sb.toString();
                    File file = new File(sb2 + c.f2832b);
                    if (!file.getParentFile().exists()) {
                        d.c("LogFileHelper", "there is no log file dir!");
                        return;
                    }
                    if (file.exists() && file.length() != 0) {
                        String o4 = cn.jiguang.f.a.o(context);
                        String str3 = "android-" + o4 + "-" + f4 + ".aes";
                        File file2 = new File(sb2 + str3);
                        if (file2.exists()) {
                            file2.delete();
                            file2.createNewFile();
                            str = " repeat Create aesFile : " + file2.getName();
                        } else {
                            file2.createNewFile();
                            str = "Create aesFile : " + file2.getName();
                        }
                        d.a("LogFileHelper", str);
                        cn.jiguang.br.a.a(cn.jiguang.bk.a.a(context), file, file2);
                        if (file2.length() == 0) {
                            d.c("LogFileHelper", "aesFile encrypt fail");
                            file2.delete();
                            return;
                        }
                        String a4 = a.a(context, str3);
                        if (TextUtils.isEmpty(a4)) {
                            d.c("LogFileHelper", "getUploadToken url is empty");
                            file2.delete();
                            return;
                        }
                        boolean a5 = cn.jiguang.br.b.a(context, a4, file2);
                        if (a5) {
                            file.delete();
                            a.a(context, a5, o4, "");
                        }
                        file2.delete();
                        return;
                    }
                    d.c("LogFileHelper", "there is no log file to upload!");
                } catch (Throwable th) {
                    d.i("LogFileHelper", "startUpload error is " + th.getMessage());
                }
            }
        }, intValue * 1000);
    }
}
