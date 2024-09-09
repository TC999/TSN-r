package cn.jiguang.cj;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.bq.d;
import cn.jiguang.internal.JConstants;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class b {
    public static String a(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i4 = applicationInfo.labelRes;
            if (i4 == 0) {
                CharSequence charSequence = applicationInfo.nonLocalizedLabel;
                return charSequence != null ? charSequence.toString() : context.getPackageManager().getApplicationLabel(applicationInfo).toString();
            }
            return context.getString(i4);
        } catch (Exception e4) {
            d.a("SentryUtils", "Error getting application name.", e4);
            return null;
        }
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.contains("cn.jpush.im") ? "JMessage" : str.contains("cn.jiguang.analytics") ? "JAnalysis" : str.contains("cn.jiguang.share") ? "JShare" : (str.contains("cn.jiguang.union.ads") || str.contains("cn.jiguang.ads")) ? "JAd" : str.contains("cn.jiguang.verifysdk") ? "JVerification" : str.contains("cn.jiguang.jmlinksdk") ? "JMlink" : str.contains("cn.jiguang.junion") ? "JUnion" : str.contains("cn.jiguang.portrait") ? "JPortrait" : (str.contains("cn.jpush.android") || str.contains("cn.jpush")) ? "JPush" : (str.contains("cn.jiguang.common") || str.contains("cn.jiguang")) ? JConstants.SDK_TYPE : "";
    }

    public static JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "sentry.java.android");
            jSONObject.put("version", "5.0.1");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "maven:io.sentry:sentry");
            jSONObject2.put("version", "5.0.1");
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", "maven:io.sentry:sentry-android-core");
            jSONObject3.put("version", "5.0.1");
            jSONArray.put(jSONObject3);
            jSONObject.put("packages", jSONArray);
            return jSONObject;
        } catch (JSONException e4) {
            d.a("SentryUtils", "Error getting SDK version.", e4);
            return null;
        }
    }

    public static void a(String str, String str2) {
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        File file = new File(str);
        a(zipOutputStream, file, file.getName());
        zipOutputStream.flush();
        fileOutputStream.getFD().sync();
        zipOutputStream.close();
        fileOutputStream.close();
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str) {
        File[] listFiles;
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                a(zipOutputStream, file2, str + TTPathConst.sSeparator + file2.getName());
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        zipOutputStream.putNextEntry(new ZipEntry(str));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read < 0) {
                zipOutputStream.closeEntry();
                fileInputStream.close();
                return;
            }
            zipOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean a(long j4, long j5) {
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            Long l4 = new Long(j4);
            Long l5 = new Long(j5);
            calendar.setTime(simpleDateFormat.parse(simpleDateFormat.format(l4)));
            calendar2.setTime(simpleDateFormat2.parse(simpleDateFormat2.format(l5)));
            return a(calendar, calendar2);
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean a(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            return true;
        }
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static long b() {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static JSONObject b(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "sentry_getDevice", null, null);
            if (a4 instanceof JSONObject) {
                return (JSONObject) a4;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            Pair<String, Long> d4 = cn.jiguang.bk.a.d(context);
            jSONObject.put("app_build", Long.toString(((Long) d4.second).longValue()));
            jSONObject.put("app_identifier", cn.jiguang.f.a.c(context));
            jSONObject.put("app_name", a(context));
            jSONObject.put("app_start_time", cn.jiguang.a.a.f2016h);
            jSONObject.put("app_version", d4.first);
            return jSONObject;
        } catch (JSONException e4) {
            d.a("SentryUtils", "Error getting App.", e4);
            return null;
        }
    }

    public static JSONObject d(Context context) {
        try {
            Object a4 = cn.jiguang.bl.a.a(context, "sentry_getOperatingSystem", null, null);
            if (a4 instanceof JSONObject) {
                return (JSONObject) a4;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static JSONObject e(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String a4 = cn.jiguang.bk.a.a(context);
            String b4 = cn.jiguang.d.a.b(context);
            jSONObject.put("id", a4 + "|" + b4);
            return jSONObject;
        } catch (JSONException e4) {
            d.a("SentryUtils", "Error getting user.", e4);
            return null;
        }
    }
}
