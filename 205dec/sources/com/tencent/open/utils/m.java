package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.content.FileProvider;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static String f51850a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f51851b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f51852c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f51853d = "";

    /* renamed from: e  reason: collision with root package name */
    private static int f51854e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static String f51855f = "0123456789ABCDEF";

    private static char a(int i4) {
        int i5 = i4 & 15;
        return (char) (i5 < 10 ? i5 + 48 : (i5 - 10) + 97);
    }

    public static Bundle a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            try {
                for (String str2 : str.split("&")) {
                    String[] a4 = a(str2, "=");
                    if (a4.length == 2) {
                        bundle.putString(URLDecoder.decode(a4[0]), URLDecoder.decode(a4[1]));
                    }
                }
                return bundle;
            } catch (Exception unused) {
                return null;
            }
        }
        return bundle;
    }

    public static Bundle b(String str) {
        try {
            URL url = new URL(str.replace("auth://", JPushConstants.HTTP_PRE));
            Bundle a4 = a(url.getQuery());
            a4.putAll(a(url.getRef()));
            return a4;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static JSONObject c(String str) {
        try {
            URL url = new URL(str.replace("auth://", JPushConstants.HTTP_PRE));
            JSONObject a4 = a((JSONObject) null, url.getQuery());
            a(a4, url.getRef());
            return a4;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    public static JSONObject d(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    public static boolean e(String str) {
        return str == null || str.length() == 0;
    }

    public static String f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            SLog.e("openSDK_LOG.Util", "urlEncode: UnsupportedEncodingException", e4);
            return "";
        }
    }

    private static boolean g(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (k.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(signatureArr[0].toByteArray());
                    String a4 = a(messageDigest.digest());
                    messageDigest.reset();
                    if (a4.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e4) {
                    SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e4.getMessage());
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean h(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE);
    }

    public static boolean i(String str) {
        return str != null && new File(str).exists();
    }

    public static byte[] j(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e4) {
            SLog.e("openSDK_LOG.Util", "getBytesUTF8: UnsupportedEncodingException", e4);
            return new byte[0];
        }
    }

    public static String k(String str) {
        return a(str, 2);
    }

    public static File l(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                } else {
                    SLog.d("openSDK_LOG.Util", "createFile failed" + str);
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static boolean m(String str) {
        String b4 = b();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(b4) || !str.contains(b4)) ? false : true;
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return "";
        }
        String d4 = d(context, str);
        f51852c = d4;
        return d4;
    }

    public static File h(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            File[] externalFilesDirs = context.getExternalFilesDirs(str);
            if (externalFilesDirs == null || externalFilesDirs.length <= 0) {
                return null;
            }
            return externalFilesDirs[0];
        }
        return context.getExternalFilesDir(str);
    }

    public static boolean e(Context context) {
        return k.c(context, "8.1.8") >= 0;
    }

    public static boolean f(Context context, String str) {
        boolean z3 = !c(context) || k.a(context, "com.tencent.minihd.qq") == null;
        if (z3 && k.a(context, "com.tencent.tim") != null) {
            z3 = false;
        }
        if (z3) {
            return k.c(context, str) < 0;
        }
        return z3;
    }

    private static boolean i(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                return context.checkSelfPermission(str) != 0;
            } catch (Exception e4) {
                SLog.e("openSDK_LOG.Util", "checkSelfPermission exception", e4);
                return false;
            }
        }
        return false;
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || i(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return true;
        }
        NetworkInfo[] networkInfoArr = null;
        try {
            networkInfoArr = connectivityManager.getAllNetworkInfo();
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.Util", "Util.isNetWorkAvailable has exception: ", e4);
        }
        if (networkInfoArr != null && networkInfoArr.length != 0) {
            for (NetworkInfo networkInfo : networkInfoArr) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return f51851b;
    }

    public static boolean f(Context context) {
        return k.c(context, "5.9.5") >= 0;
    }

    public static String[] a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        return indexOf == -1 ? new String[]{str} : new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length())};
    }

    public static boolean c(Context context) {
        double d4;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d4 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            d4 = 0.0d;
        }
        return d4 > 6.5d;
    }

    public static String d(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return f51850a;
    }

    public static JSONObject a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    try {
                        split[0] = URLDecoder.decode(split[0]);
                        split[1] = URLDecoder.decode(split[1]);
                    } catch (Exception unused) {
                    }
                    try {
                        jSONObject.put(split[0], split[1]);
                    } catch (JSONException e4) {
                        SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e4.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static boolean d(Context context) {
        return k.c(context, "8.1.5") >= 0;
    }

    public static String g(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(j(str));
            byte[] digest = messageDigest.digest();
            if (digest != null) {
                StringBuilder sb = new StringBuilder();
                for (byte b4 : digest) {
                    sb.append(a(b4 >>> 4));
                    sb.append(a(b4));
                }
                return sb.toString();
            }
            return str;
        } catch (NoSuchAlgorithmException e4) {
            SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e4.getMessage());
            return str;
        }
    }

    public static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo.versionName;
            f51851b = str2;
            f51850a = str2.substring(0, str2.lastIndexOf(46));
            String str3 = f51851b;
            f51853d = str3.substring(str3.lastIndexOf(46) + 1, f51851b.length());
            f51854e = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e4) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e4.getMessage());
        } catch (Exception e5) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e5.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0200 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r13, android.net.Uri r14) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.m.c(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static boolean a(Context context, String str) {
        boolean z3;
        try {
            z3 = g(context);
            try {
                if (z3) {
                    a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                } else {
                    a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                }
                return true;
            } catch (Exception unused) {
                if (z3) {
                    try {
                        try {
                            try {
                                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            } catch (Exception unused2) {
                                a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            }
                        } catch (Exception unused3) {
                            a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                            return true;
                        }
                    } catch (Exception unused4) {
                        return false;
                    }
                }
                try {
                    try {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (Exception unused5) {
                        a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                        return true;
                    }
                } catch (Exception unused6) {
                    return false;
                }
            }
        } catch (Exception unused7) {
            z3 = false;
        }
    }

    @SuppressLint({"NewApi"})
    public static String b(Context context, Uri uri) {
        Uri uri2;
        if (uri == null) {
            return null;
        }
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            String authority = uri.getAuthority();
            if ("com.android.externalstorage.documents".equals(authority)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                String str = split[0];
                if ("primary".equals(str)) {
                    return Environment.getExternalStorageDirectory().getAbsolutePath().concat(TTPathConst.sSeparator).concat(split[1]);
                }
                return "/storage/".concat(str).concat(TTPathConst.sSeparator).concat(split[1]);
            } else if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.replaceFirst("raw:", "");
                }
                return c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)));
            } else {
                if ("com.android.providers.media.documents".equals(authority)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str2 = split2[0];
                    if ("image".equals(str2)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str2)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str2)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return c(context, ContentUris.withAppendedId(uri2, Long.parseLong(split2[1])));
                }
                return null;
            }
        }
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            return c(context, uri);
        }
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        return null;
    }

    public static boolean g(Context context, String str) {
        boolean z3 = !c(context) || k.a(context, "com.tencent.minihd.qq") == null;
        if (z3) {
            return k.c(context, str) < 0;
        }
        return z3;
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static boolean a() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            String num = Integer.toString(b4 & 255, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static final String a(Context context) {
        CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    public static final String a(String str, int i4, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length <= i4) {
                return str;
            }
            int i5 = 0;
            int i6 = 0;
            while (i5 < str.length()) {
                int i7 = i5 + 1;
                i6 += str.substring(i5, i7).getBytes(str2).length;
                if (i6 > i4) {
                    String substring = str.substring(0, i5);
                    if (TextUtils.isEmpty(str3)) {
                        return substring;
                    }
                    return substring + str3;
                }
                i5 = i7;
            }
            return str;
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e4.getMessage());
            return str;
        }
    }

    public static String b() {
        File e4 = g.e();
        if (e4 != null) {
            if (!e4.exists()) {
                e4.mkdirs();
            }
            return e4.toString();
        }
        return null;
    }

    public static Bundle a(Bundle bundle, String str) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("result", str);
        return bundle;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("type", str6);
        bundle.putString("login_status", str7);
        bundle.putString("need_user_auth", str8);
        bundle.putString("to_uin", str9);
        bundle.putString("call_source", str10);
        bundle.putString("to_type", str11);
        bundle.putString("platform", "1");
        return bundle;
    }

    public static boolean b(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return a(file, l(str2));
            } catch (IOException e4) {
                SLog.d("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + " ", e4);
            }
        }
        return false;
    }

    public static boolean c() {
        Context a4 = g.a();
        return a4 != null && a4.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", a4.getPackageName()) == 0;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5) {
        return a(str, str3, str4, str2, str5, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return a(a(str, str2, str3, str4, str5, str7, str8, str9, str10, str11, str12), str6);
    }

    public static boolean a(Context context, boolean z3) {
        return (c(context) && k.a(context, "com.tencent.minihd.qq") != null) || k.c(context, "4.1") >= 0 || k.a(context, "com.tencent.tim") != null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0036 -> B:19:0x0043). Please submit an issue!!! */
    public static long a(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
        if (query != null) {
            try {
            } catch (Exception e4) {
                SLog.e("openSDK_LOG.Util", "cursor exception", e4);
            }
            if (query.getCount() != 0) {
                try {
                    try {
                        r2 = query.moveToFirst() ? query.getLong(query.getColumnIndexOrThrow("_size")) : 0L;
                        query.close();
                    } catch (Throwable th) {
                        try {
                            query.close();
                        } catch (Exception e5) {
                            SLog.e("openSDK_LOG.Util", "cursor exception", e5);
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    SLog.e("openSDK_LOG.Util", "cursor exception", e6);
                    query.close();
                }
                return r2;
            }
        }
        return 0L;
    }

    public static String a(String str, int i4) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.encodeToString(str.getBytes("UTF-8"), i4);
            } catch (UnsupportedEncodingException e4) {
                SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e4.getMessage());
            }
        }
        return "";
    }

    public static Drawable a(String str, Context context) {
        InputStream inputStream;
        StringBuilder sb;
        InputStream inputStream2 = null;
        r1 = null;
        Drawable drawable = null;
        if (context == null) {
            SLog.e("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
        } catch (IOException e4) {
            e = e4;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            try {
                inputStream2.close();
            } catch (Exception e5) {
                SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e5.getMessage());
            }
            throw th;
        }
        try {
            try {
                drawable = Drawable.createFromStream(inputStream, str);
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                inputStream2.close();
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
            try {
                inputStream.close();
            } catch (Exception e7) {
                e = e7;
                sb = new StringBuilder();
                sb.append("inputStream close exception: ");
                sb.append(e.getMessage());
                SLog.e("openSDK_LOG.Util", sb.toString());
                return drawable;
            }
            return drawable;
        }
        try {
            inputStream.close();
        } catch (Exception e8) {
            e = e8;
            sb = new StringBuilder();
            sb.append("inputStream close exception: ");
            sb.append(e.getMessage());
            SLog.e("openSDK_LOG.Util", sb.toString());
            return drawable;
        }
        return drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0056 -> B:83:0x0098). Please submit an issue!!! */
    public static boolean a(File file, File file2) {
        int read;
        boolean z3 = false;
        FileOutputStream fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        try {
            try {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream((File) file2);
                    try {
                        file2 = new BufferedInputStream(new FileInputStream(file));
                        try {
                            byte[] bArr = new byte[102400];
                            while (true) {
                                read = file2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                                fileOutputStream2.flush();
                            }
                            z3 = true;
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e4) {
                                SLog.e("openSDK_LOG.Util", "copyFile error, ", e4);
                            }
                            file2.close();
                            fileOutputStream = read;
                            file2 = file2;
                        } catch (IOException e5) {
                            e = e5;
                            fileOutputStream = fileOutputStream2;
                            file2 = file2;
                            SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e6) {
                                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e6);
                                }
                            }
                            if (file2 != 0) {
                                file2.close();
                                fileOutputStream = fileOutputStream;
                                file2 = file2;
                            }
                            return z3;
                        } catch (OutOfMemoryError e7) {
                            e = e7;
                            fileOutputStream = fileOutputStream2;
                            file2 = file2;
                            SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e8) {
                                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e8);
                                }
                            }
                            if (file2 != 0) {
                                file2.close();
                                fileOutputStream = fileOutputStream;
                                file2 = file2;
                            }
                            return z3;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e9) {
                                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e9);
                                }
                            }
                            if (file2 != 0) {
                                try {
                                    file2.close();
                                } catch (IOException e10) {
                                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e10);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e11) {
                        e = e11;
                        file2 = 0;
                    } catch (OutOfMemoryError e12) {
                        e = e12;
                        file2 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        file2 = 0;
                    }
                } catch (IOException e13) {
                    e = e13;
                    file2 = 0;
                } catch (OutOfMemoryError e14) {
                    e = e14;
                    file2 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    file2 = 0;
                }
            } catch (IOException e15) {
                SLog.e("openSDK_LOG.Util", "copyFile error, ", e15);
                fileOutputStream = fileOutputStream;
                file2 = file2;
            }
            return z3;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        boolean b4;
        if (Build.VERSION.SDK_INT < 19) {
            b4 = context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0 ? b(str, str2) : false;
        } else {
            b4 = b(str, str2);
        }
        SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + b4);
        return b4;
    }

    public static String a(String str, Activity activity, String str2, IUiListener iUiListener) {
        File a4;
        File cacheDir;
        String str3;
        try {
            boolean m4 = m(str2);
            SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + m4 + ",hasSDPermission=" + c());
            if (!m4) {
                if (g.a("Images") != null) {
                    str3 = a4.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                } else {
                    if (g.a().getCacheDir() == null) {
                        SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    str3 = cacheDir.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                }
                File file = new File(str2);
                String absolutePath = file.getAbsolutePath();
                String str4 = str3 + File.separator + file.getName();
                str2 = b(absolutePath, str4) ? str4 : null;
            }
            Uri a5 = a(activity, str, str2);
            if (a5 == null) {
                return null;
            }
            return a5.toString();
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e4);
            return null;
        }
    }

    public static boolean a(Map<String, Object> map, String str, boolean z3) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
            return z3;
        } else if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
            return z3;
        } else {
            Object obj = map.get(str);
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z3;
        }
    }

    public static String a(Map<String, Object> map, String str, String str2) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getString error, params==null");
            return str2;
        } else if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + str);
            return str2;
        } else {
            Object obj = map.get(str);
            return obj instanceof String ? (String) obj : str2;
        }
    }

    public static Uri a(Activity activity, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion -- stringForFileUri is empty");
            return null;
        }
        try {
            String authorities = Tencent.getAuthorities(str);
            if (TextUtils.isEmpty(authorities)) {
                return null;
            }
            Uri uriForFile = FileProvider.getUriForFile(activity, authorities, new File(str2));
            activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
            activity.grantUriPermission("com.tencent.tim", uriForFile, 3);
            activity.grantUriPermission("com.tencent.minihd.qq", uriForFile, 3);
            activity.grantUriPermission("com.tencent.qqlite", uriForFile, 3);
            return uriForFile;
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion exception:", e4);
            return null;
        }
    }
}
