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
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.sdk.collector.AppStatusRules;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
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
import kotlin.UByte;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.m */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13071m {

    /* renamed from: a */
    private static String f37450a = "";

    /* renamed from: b */
    private static String f37451b = "";

    /* renamed from: c */
    private static String f37452c = "";

    /* renamed from: d */
    private static String f37453d = "";

    /* renamed from: e */
    private static int f37454e = -1;

    /* renamed from: f */
    private static String f37455f = "0123456789ABCDEF";

    /* renamed from: a */
    private static char m14970a(int i) {
        int i2 = i & 15;
        return (char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 97);
    }

    /* renamed from: a */
    public static Bundle m14960a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            try {
                for (String str2 : str.split("&")) {
                    String[] m14955a = m14955a(str2, "=");
                    if (m14955a.length == 2) {
                        bundle.putString(URLDecoder.decode(m14955a[0]), URLDecoder.decode(m14955a[1]));
                    }
                }
                return bundle;
            } catch (Exception unused) {
                return null;
            }
        }
        return bundle;
    }

    /* renamed from: b */
    public static Bundle m14942b(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            Bundle m14960a = m14960a(url.getQuery());
            m14960a.putAll(m14960a(url.getRef()));
            return m14960a;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    /* renamed from: c */
    public static JSONObject m14936c(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            JSONObject m14948a = m14948a((JSONObject) null, url.getQuery());
            m14948a(m14948a, url.getRef());
            return m14948a;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    /* renamed from: d */
    public static JSONObject m14933d(String str) throws JSONException {
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

    /* renamed from: e */
    public static boolean m14930e(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: f */
    public static String m14927f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            SLog.m15128e("openSDK_LOG.Util", "urlEncode: UnsupportedEncodingException", e);
            return "";
        }
    }

    /* renamed from: g */
    private static boolean m14926g(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (C13066k.m14992a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(signatureArr[0].toByteArray());
                    String m14947a = m14947a(messageDigest.digest());
                    messageDigest.reset();
                    if (m14947a.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e) {
                    SLog.m15129e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e.getMessage());
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: h */
    public static final boolean m14922h(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    /* renamed from: i */
    public static boolean m14920i(String str) {
        return str != null && new File(str).exists();
    }

    /* renamed from: j */
    public static byte[] m14919j(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            SLog.m15128e("openSDK_LOG.Util", "getBytesUTF8: UnsupportedEncodingException", e);
            return new byte[0];
        }
    }

    /* renamed from: k */
    public static String m14918k(String str) {
        return m14959a(str, 2);
    }

    /* renamed from: l */
    public static File m14917l(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                } else {
                    SLog.m15131d("openSDK_LOG.Util", "createFile failed" + str);
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    /* renamed from: m */
    public static boolean m14916m(String str) {
        String m14946b = m14946b();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(m14946b) || !str.contains(m14946b)) ? false : true;
    }

    /* renamed from: e */
    public static String m14931e(Context context, String str) {
        if (context == null) {
            return "";
        }
        String m14934d = m14934d(context, str);
        f37452c = m14934d;
        return m14934d;
    }

    /* renamed from: h */
    public static File m14923h(Context context, String str) {
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

    /* renamed from: e */
    public static boolean m14932e(Context context) {
        return C13066k.m14983c(context, "8.1.8") >= 0;
    }

    /* renamed from: f */
    public static boolean m14928f(Context context, String str) {
        boolean z = !m14939c(context) || C13066k.m14996a(context, Constants.PACKAGE_QQ_PAD) == null;
        if (z && C13066k.m14996a(context, Constants.PACKAGE_TIM) != null) {
            z = false;
        }
        if (z) {
            return C13066k.m14983c(context, str) < 0;
        }
        return z;
    }

    /* renamed from: i */
    private static boolean m14921i(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                return context.checkSelfPermission(str) != 0;
            } catch (Exception e) {
                SLog.m15128e("openSDK_LOG.Util", "checkSelfPermission exception", e);
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m14945b(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || m14921i(context, C7282g.f24944b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return true;
        }
        NetworkInfo[] networkInfoArr = null;
        try {
            networkInfoArr = connectivityManager.getAllNetworkInfo();
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.Util", "Util.isNetWorkAvailable has exception: ", e);
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

    /* renamed from: c */
    public static String m14937c(Context context, String str) {
        if (context == null) {
            return "";
        }
        m14943b(context, str);
        return f37451b;
    }

    /* renamed from: f */
    public static boolean m14929f(Context context) {
        return C13066k.m14983c(context, "5.9.5") >= 0;
    }

    /* renamed from: a */
    public static String[] m14955a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        return indexOf == -1 ? new String[]{str} : new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length())};
    }

    /* renamed from: c */
    public static boolean m14939c(Context context) {
        double d;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            d = Utils.DOUBLE_EPSILON;
        }
        return d > 6.5d;
    }

    /* renamed from: d */
    public static String m14934d(Context context, String str) {
        if (context == null) {
            return "";
        }
        m14943b(context, str);
        return f37450a;
    }

    /* renamed from: a */
    public static JSONObject m14948a(JSONObject jSONObject, String str) {
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
                    } catch (JSONException e) {
                        SLog.m15129e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: d */
    public static boolean m14935d(Context context) {
        return C13066k.m14983c(context, "8.1.5") >= 0;
    }

    /* renamed from: g */
    public static String m14924g(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(m14919j(str));
            byte[] digest = messageDigest.digest();
            if (digest != null) {
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(m14970a(b >>> 4));
                    sb.append(m14970a(b));
                }
                return sb.toString();
            }
            return str;
        } catch (NoSuchAlgorithmException e) {
            SLog.m15129e("openSDK_LOG.Util", "encrypt has exception: " + e.getMessage());
            return str;
        }
    }

    /* renamed from: b */
    public static void m14943b(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo.versionName;
            f37451b = str2;
            f37450a = str2.substring(0, str2.lastIndexOf(46));
            String str3 = f37451b;
            f37453d = str3.substring(str3.lastIndexOf(46) + 1, f37451b.length());
            f37454e = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            SLog.m15129e("openSDK_LOG.Util", "getPackageInfo has exception: " + e.getMessage());
        } catch (Exception e2) {
            SLog.m15129e("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0200 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m14938c(android.content.Context r13, android.net.Uri r14) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.C13071m.m14938c(android.content.Context, android.net.Uri):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m14966a(Context context, String str) {
        boolean z;
        try {
            z = m14926g(context);
            try {
                if (z) {
                    m14964a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                } else {
                    m14964a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                }
                return true;
            } catch (Exception unused) {
                if (z) {
                    try {
                        try {
                            try {
                                m14964a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            } catch (Exception unused2) {
                                m14964a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            }
                        } catch (Exception unused3) {
                            m14964a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                            return true;
                        }
                    } catch (Exception unused4) {
                        return false;
                    }
                }
                try {
                    try {
                        m14964a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (Exception unused5) {
                        m14964a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                        return true;
                    }
                } catch (Exception unused6) {
                    return false;
                }
            }
        } catch (Exception unused7) {
            z = false;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public static String m14944b(Context context, Uri uri) {
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
                    return Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(split[1]);
                }
                return "/storage/".concat(str).concat("/").concat(split[1]);
            } else if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.replaceFirst("raw:", "");
                }
                return m14938c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)));
            } else {
                if ("com.android.providers.media.documents".equals(authority)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str2 = split2[0];
                    if (SocializeProtocolConstants.IMAGE.equals(str2)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str2)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str2)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return m14938c(context, ContentUris.withAppendedId(uri2, Long.parseLong(split2[1])));
                }
                return null;
            }
        }
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            return m14938c(context, uri);
        }
        if (IDataSource.f43973c.equals(scheme)) {
            return uri.getPath();
        }
        return null;
    }

    /* renamed from: g */
    public static boolean m14925g(Context context, String str) {
        boolean z = !m14939c(context) || C13066k.m14996a(context, Constants.PACKAGE_QQ_PAD) == null;
        if (z) {
            return C13066k.m14983c(context, str) < 0;
        }
        return z;
    }

    /* renamed from: a */
    private static void m14964a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static boolean m14971a() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    /* renamed from: a */
    public static String m14947a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String num = Integer.toString(b & UByte.f41242c, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static final String m14968a(Context context) {
        CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    /* renamed from: a */
    public static final String m14958a(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length()) {
                int i4 = i2 + 1;
                i3 += str.substring(i2, i4).getBytes(str2).length;
                if (i3 > i) {
                    String substring = str.substring(0, i2);
                    if (TextUtils.isEmpty(str3)) {
                        return substring;
                    }
                    return substring + str3;
                }
                i2 = i4;
            }
            return str;
        } catch (Exception e) {
            SLog.m15129e("openSDK_LOG.Util", "Util.subString has exception: " + e.getMessage());
            return str;
        }
    }

    /* renamed from: b */
    public static String m14946b() {
        File m15021e = C13061g.m15021e();
        if (m15021e != null) {
            if (!m15021e.exists()) {
                m15021e.mkdirs();
            }
            return m15021e.toString();
        }
        return null;
    }

    /* renamed from: a */
    public static Bundle m14962a(Bundle bundle, String str) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(CommonNetImpl.RESULT, str);
        return bundle;
    }

    /* renamed from: a */
    public static Bundle m14952a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA, str4);
        bundle.putString("app_id", str5);
        bundle.putString("type", str6);
        bundle.putString("login_status", str7);
        bundle.putString("need_user_auth", str8);
        bundle.putString("to_uin", str9);
        bundle.putString("call_source", str10);
        bundle.putString("to_type", str11);
        bundle.putString(Constants.PARAM_PLATFORM, "1");
        return bundle;
    }

    /* renamed from: b */
    public static boolean m14941b(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return m14961a(file, m14917l(str2));
            } catch (IOException e) {
                SLog.m15130d("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + " ", e);
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m14940c() {
        Context m15027a = C13061g.m15027a();
        return m15027a != null && m15027a.getPackageManager().checkPermission(C7282g.f24952j, m15027a.getPackageName()) == 0;
    }

    /* renamed from: a */
    public static Bundle m14954a(String str, String str2, String str3, String str4, String str5) {
        return m14952a(str, str3, str4, str2, str5, "", "", "", "", "", "");
    }

    /* renamed from: a */
    public static Bundle m14953a(String str, String str2, String str3, String str4, String str5, String str6) {
        return m14951a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    /* renamed from: a */
    public static Bundle m14951a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return m14962a(m14952a(str, str2, str3, str4, str5, str7, str8, str9, str10, str11, str12), str6);
    }

    /* renamed from: a */
    public static boolean m14963a(Context context, boolean z) {
        return (m14939c(context) && C13066k.m14996a(context, Constants.PACKAGE_QQ_PAD) != null) || C13066k.m14983c(context, "4.1") >= 0 || C13066k.m14996a(context, Constants.PACKAGE_TIM) != null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0036 -> B:19:0x0043). Please submit an issue!!! */
    /* renamed from: a */
    public static long m14967a(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
        if (query != null) {
            try {
            } catch (Exception e) {
                SLog.m15128e("openSDK_LOG.Util", "cursor exception", e);
            }
            if (query.getCount() != 0) {
                try {
                    try {
                        r2 = query.moveToFirst() ? query.getLong(query.getColumnIndexOrThrow("_size")) : 0L;
                        query.close();
                    } catch (Throwable th) {
                        try {
                            query.close();
                        } catch (Exception e2) {
                            SLog.m15128e("openSDK_LOG.Util", "cursor exception", e2);
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    SLog.m15128e("openSDK_LOG.Util", "cursor exception", e3);
                    query.close();
                }
                return r2;
            }
        }
        return 0L;
    }

    /* renamed from: a */
    public static String m14959a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.encodeToString(str.getBytes("UTF-8"), i);
            } catch (UnsupportedEncodingException e) {
                SLog.m15129e("openSDK_LOG.Util", "convert2Base64String exception: " + e.getMessage());
            }
        }
        return "";
    }

    /* renamed from: a */
    public static Drawable m14956a(String str, Context context) {
        InputStream inputStream;
        StringBuilder sb;
        InputStream inputStream2 = null;
        r1 = null;
        Drawable drawable = null;
        if (context == null) {
            SLog.m15129e("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
        } catch (IOException e) {
            e = e;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            try {
                inputStream2.close();
            } catch (Exception e2) {
                SLog.m15129e("openSDK_LOG.Util", "inputStream close exception: " + e2.getMessage());
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
        } catch (IOException e3) {
            e = e3;
            SLog.m15129e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
            try {
                inputStream.close();
            } catch (Exception e4) {
                e = e4;
                sb = new StringBuilder();
                sb.append("inputStream close exception: ");
                sb.append(e.getMessage());
                SLog.m15129e("openSDK_LOG.Util", sb.toString());
                return drawable;
            }
            return drawable;
        }
        try {
            inputStream.close();
        } catch (Exception e5) {
            e = e5;
            sb = new StringBuilder();
            sb.append("inputStream close exception: ");
            sb.append(e.getMessage());
            SLog.m15129e("openSDK_LOG.Util", sb.toString());
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
    /* renamed from: a */
    public static boolean m14961a(File file, File file2) {
        int read;
        boolean z = false;
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
                            byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
                            while (true) {
                                read = file2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                                fileOutputStream2.flush();
                            }
                            z = true;
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e) {
                                SLog.m15128e("openSDK_LOG.Util", "copyFile error, ", e);
                            }
                            file2.close();
                            fileOutputStream = read;
                            file2 = file2;
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            file2 = file2;
                            SLog.m15128e("openSDK_LOG.Util", "copyFile error, ", e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    SLog.m15128e("openSDK_LOG.Util", "copyFile error, ", e3);
                                }
                            }
                            if (file2 != 0) {
                                file2.close();
                                fileOutputStream = fileOutputStream;
                                file2 = file2;
                            }
                            return z;
                        } catch (OutOfMemoryError e4) {
                            e = e4;
                            fileOutputStream = fileOutputStream2;
                            file2 = file2;
                            SLog.m15128e("openSDK_LOG.Util", "copyFile error, ", e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    SLog.m15128e("openSDK_LOG.Util", "copyFile error, ", e5);
                                }
                            }
                            if (file2 != 0) {
                                file2.close();
                                fileOutputStream = fileOutputStream;
                                file2 = file2;
                            }
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e6) {
                                    SLog.m15128e("openSDK_LOG.Util", "copyFile error, ", e6);
                                }
                            }
                            if (file2 != 0) {
                                try {
                                    file2.close();
                                } catch (IOException e7) {
                                    SLog.m15128e("openSDK_LOG.Util", "copyFile error, ", e7);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        file2 = 0;
                    } catch (OutOfMemoryError e9) {
                        e = e9;
                        file2 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        file2 = 0;
                    }
                } catch (IOException e10) {
                    e = e10;
                    file2 = 0;
                } catch (OutOfMemoryError e11) {
                    e = e11;
                    file2 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    file2 = 0;
                }
            } catch (IOException e12) {
                SLog.m15128e("openSDK_LOG.Util", "copyFile error, ", e12);
                fileOutputStream = fileOutputStream;
                file2 = file2;
            }
            return z;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: a */
    public static boolean m14965a(Context context, String str, String str2) {
        boolean m14941b;
        if (Build.VERSION.SDK_INT < 19) {
            m14941b = context.getPackageManager().checkPermission(C7282g.f24952j, context.getPackageName()) == 0 ? m14941b(str, str2) : false;
        } else {
            m14941b = m14941b(str, str2);
        }
        SLog.m15127i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + m14941b);
        return m14941b;
    }

    /* renamed from: a */
    public static String m14957a(String str, Activity activity, String str2, IUiListener iUiListener) {
        File m15025a;
        File cacheDir;
        String str3;
        try {
            boolean m14916m = m14916m(str2);
            SLog.m15127i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + m14916m + ",hasSDPermission=" + m14940c());
            if (!m14916m) {
                if (C13061g.m15025a("Images") != null) {
                    str3 = m15025a.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                } else {
                    if (C13061g.m15027a().getCacheDir() == null) {
                        SLog.m15129e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    str3 = cacheDir.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                }
                File file = new File(str2);
                String absolutePath = file.getAbsolutePath();
                String str4 = str3 + File.separator + file.getName();
                str2 = m14941b(absolutePath, str4) ? str4 : null;
            }
            Uri m14969a = m14969a(activity, str, str2);
            if (m14969a == null) {
                return null;
            }
            return m14969a.toString();
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.Util", "getMediaFileUri error", e);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m14949a(Map<String, Object> map, String str, boolean z) {
        if (map == null) {
            SLog.m15129e("openSDK_LOG.Util", "getBoolean error, params==null");
            return z;
        } else if (!map.containsKey(str)) {
            SLog.m15129e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
            return z;
        } else {
            Object obj = map.get(str);
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }
    }

    /* renamed from: a */
    public static String m14950a(Map<String, Object> map, String str, String str2) {
        if (map == null) {
            SLog.m15129e("openSDK_LOG.Util", "getString error, params==null");
            return str2;
        } else if (!map.containsKey(str)) {
            SLog.m15129e("openSDK_LOG.Util", "getString error, not comtain : " + str);
            return str2;
        } else {
            Object obj = map.get(str);
            return obj instanceof String ? (String) obj : str2;
        }
    }

    /* renamed from: a */
    public static Uri m14969a(Activity activity, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            SLog.m15129e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion -- stringForFileUri is empty");
            return null;
        }
        try {
            String authorities = Tencent.getAuthorities(str);
            if (TextUtils.isEmpty(authorities)) {
                return null;
            }
            Uri uriForFile = FileProvider.getUriForFile(activity, authorities, new File(str2));
            activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_TIM, uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_QQ_PAD, uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_QQ_SPEED, uriForFile, 3);
            return uriForFile;
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion exception:", e);
            return null;
        }
    }
}
