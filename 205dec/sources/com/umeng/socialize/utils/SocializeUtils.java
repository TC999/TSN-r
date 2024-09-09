package com.umeng.socialize.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.FileProvider;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.cache1.DplueCache;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SocializeUtils {
    protected static final String TAG = "SocializeUtils";
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static Set<Uri> deleteUris = new HashSet();
    private static Pattern mDoubleByte_Pattern = null;
    private static int smDip = 0;

    public static byte[] File2byte(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (FileNotFoundException e4) {
            SLog.error(e4);
            return null;
        } catch (IOException e5) {
            SLog.error(e5);
            return null;
        }
    }

    public static boolean assertBinaryInvalid(byte[] bArr) {
        return bArr != null && bArr.length > 0;
    }

    public static Map<String, String> bundleTomap(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return null;
        }
        Set<String> keySet = bundle.keySet();
        HashMap hashMap = new HashMap();
        for (String str : keySet) {
            if (str.equals("com.sina.weibo.intent.extra.USER_ICON")) {
                hashMap.put(CampaignEx.JSON_KEY_ICON_URL, bundle.getString(str));
            }
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public static int countContentLength(String str) {
        int i4;
        String trim = str.trim();
        int i5 = 0;
        while (getDoubleBytePattern().matcher(trim).find()) {
            i5++;
        }
        int length = trim.length() - i5;
        if (length % 2 != 0) {
            i4 = (length + 1) / 2;
        } else {
            i4 = length / 2;
        }
        return i5 + i4;
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
            }
        }
        return bundle;
    }

    public static int dip2Px(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String getAppkey(Context context) {
        Object obj;
        if (context == null) {
            return "";
        }
        String str = SocializeConstants.APPKEY;
        if (TextUtils.isEmpty(str)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                return (applicationInfo == null || (obj = applicationInfo.metaData.get("UMENG_APPKEY")) == null) ? str : obj.toString();
            } catch (Exception e4) {
                SLog.error(e4);
                return str;
            }
        }
        return str;
    }

    private static Pattern getDoubleBytePattern() {
        if (mDoubleByte_Pattern == null) {
            mDoubleByte_Pattern = Pattern.compile("[^\\x00-\\xff]");
        }
        return mDoubleByte_Pattern;
    }

    public static int[] getFloatWindowSize(Context context) {
        return context == null ? new int[2] : new int[]{580, 350};
    }

    public static String hexdigest(String str) {
        try {
            return md5(str.getBytes());
        } catch (Exception e4) {
            SLog.error(e4);
            return null;
        }
    }

    public static Uri insertImage(Context context, String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            try {
                String insertImage = MediaStore.Images.Media.insertImage(context.getContentResolver(), str, "umeng_social_shareimg", (String) null);
                if (!TextUtils.isEmpty(insertImage)) {
                    return Uri.parse(insertImage);
                }
            } catch (Throwable th) {
                SLog.error(th);
            }
            try {
                if (PlatformConfig.getFileProvider() != null && Build.VERSION.SDK_INT >= 24) {
                    return FileProvider.getUriForFile(context, PlatformConfig.getFileProvider(), new File(str));
                }
                return Uri.fromFile(new File(str));
            } catch (Throwable th2) {
                SLog.error(th2);
            }
        }
        return null;
    }

    public static boolean isFloatWindowStyle(Context context) {
        if (context != null && SocializeConstants.SUPPORT_PAD) {
            if (smDip == 0) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                int width = defaultDisplay.getWidth();
                int height = defaultDisplay.getHeight();
                if (width > height) {
                    width = height;
                }
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                smDip = (int) ((width / displayMetrics.density) + 0.5f);
            }
            if ((context.getResources().getConfiguration().screenLayout & 15) >= 3 && smDip >= 550) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHasDplusCache() {
        File filePath = DplueCache.getFilePath("s_e");
        File filePath2 = DplueCache.getFilePath("auth");
        File filePath3 = DplueCache.getFilePath("userinfo");
        File filePath4 = DplueCache.getFilePath("dau");
        File filePath5 = DplueCache.getFilePath("stats");
        return ((filePath == null || filePath.listFiles() == null || filePath.listFiles().length <= 0) && (filePath2 == null || filePath2.listFiles() == null || filePath2.listFiles().length <= 0) && ((filePath3 == null || filePath3.listFiles() == null || filePath3.listFiles().length <= 0) && ((filePath4 == null || filePath4.listFiles() == null || filePath4.listFiles().length <= 0) && (filePath5 == null || filePath5.listFiles() == null || filePath5.listFiles().length <= 0)))) ? false : true;
    }

    public static boolean isToday(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j4));
        return calendar2.get(1) == calendar.get(1) && calendar2.get(6) - calendar.get(6) == 0;
    }

    public static JSONObject jsonObjectExt(String str) {
        new HashMap();
        try {
            return new JSONObject(str);
        } catch (Exception e4) {
            SLog.error(e4);
            return null;
        }
    }

    public static Map<String, String> jsonToMap(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next) + "");
            }
        } catch (Exception e4) {
            SLog.error(e4);
        }
        return hashMap;
    }

    public static Bundle mapToBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    public static String md5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            int i4 = 0;
            for (int i5 = 0; i5 < 16; i5++) {
                byte b4 = digest[i5];
                int i6 = i4 + 1;
                char[] cArr2 = hexDigits;
                cArr[i4] = cArr2[(b4 >>> 4) & 15];
                i4 = i6 + 1;
                cArr[i6] = cArr2[b4 & 15];
            }
            return new String(cArr);
        } catch (Exception e4) {
            SLog.error(e4);
            return null;
        }
    }

    public static void openApplicationMarket(Context context, String str) throws Exception {
        if (Config.isJumptoAppStore) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + str));
            context.startActivity(intent);
        }
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static void safeCloseDialog(Dialog dialog) {
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Exception e4) {
                SLog.error(e4);
            }
        }
    }

    public static void safeShowDialog(Dialog dialog) {
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    return;
                }
                dialog.show();
            } catch (Exception e4) {
                SLog.error(e4);
            }
        }
    }
}
