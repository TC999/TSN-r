package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import java.io.File;
import java.text.DecimalFormat;
import xyz.adscope.common.network.Headers;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FileUtill.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1790a = Environment.getExternalStorageDirectory().getPath() + "/rtCloudTemporary/Image/";

    /* renamed from: b  reason: collision with root package name */
    public static String f1791b = "/rtCloudTemporary/Image/";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1792c = Environment.getExternalStorageDirectory().getPath() + "/rtCloud/Image/";

    /* renamed from: d  reason: collision with root package name */
    public static String f1793d = "/rtCloud/Image/";

    /* renamed from: e  reason: collision with root package name */
    private static final String[][] f1794e = {new String[]{".3gp", "video/3gpp"}, new String[]{".apk", "applicationnd.android.package-archive"}, new String[]{".asf", "video/x-ms-asf"}, new String[]{".avi", "video/x-msvideo"}, new String[]{".bin", "application/octet-stream"}, new String[]{".bmp", "image/bmp"}, new String[]{".c", "text/plain"}, new String[]{".class", "application/octet-stream"}, new String[]{".conf", "text/plain"}, new String[]{".cpp", "text/plain"}, new String[]{".doc", "application/msword"}, new String[]{".docx", "applicationnd.openxmlformats-officedocument.wordprocessingml.document"}, new String[]{".xls", "applicationnd.ms-excel"}, new String[]{".xlsx", "applicationnd.openxmlformats-officedocument.spreadsheetml.sheet"}, new String[]{".exe", "application/octet-stream"}, new String[]{".gif", "image/gif"}, new String[]{".gtar", "application/x-gtar"}, new String[]{".gz", "application/x-gzip"}, new String[]{".h", "text/plain"}, new String[]{".htm", "textml"}, new String[]{".html", "textml"}, new String[]{".jar", "application/java-archive"}, new String[]{".java", "text/plain"}, new String[]{".jpeg", "image/jpeg"}, new String[]{".jpg", "image/jpeg"}, new String[]{".js", "application/x-javascript"}, new String[]{".log", "text/plain"}, new String[]{".m3u", "audio/x-mpegurl"}, new String[]{".m4a", "audio/mp4a-latm"}, new String[]{".m4b", "audio/mp4a-latm"}, new String[]{".m4p", "audio/mp4a-latm"}, new String[]{".m4u", "videond.mpegurl"}, new String[]{".m4v", "video/x-m4v"}, new String[]{".mov", "video/quicktime"}, new String[]{".mp2", "audio/x-mpeg"}, new String[]{".mp3", "audio/x-mpeg"}, new String[]{".mp4", "video/mp4"}, new String[]{".mpc", "applicationnd.mpohun.certificate"}, new String[]{".mpe", "video/mpeg"}, new String[]{".mpeg", "video/mpeg"}, new String[]{".mpg", "video/mpeg"}, new String[]{".mpg4", "video/mp4"}, new String[]{".mpga", "audio/mpeg"}, new String[]{".msg", "applicationnd.ms-outlook"}, new String[]{".ogg", "audio/ogg"}, new String[]{".pdf", "applicationf"}, new String[]{".png", "image/png"}, new String[]{".pps", "applicationnd.ms-powerpoint"}, new String[]{".ppt", "applicationnd.ms-powerpoint"}, new String[]{".pptx", "applicationnd.openxmlformats-officedocument.presentationml.presentation"}, new String[]{".prop", "text/plain"}, new String[]{".rc", "text/plain"}, new String[]{".rmvb", "audio/x-pn-realaudio"}, new String[]{".rtf", "application/rtf"}, new String[]{".sh", "text/plain"}, new String[]{".tar", "application/x-tar"}, new String[]{".tgz", "application/x-compressed"}, new String[]{".txt", "text/plain"}, new String[]{".wav", "audio/x-wav"}, new String[]{".wma", "audio/x-ms-wma"}, new String[]{".wmv", "audio/x-ms-wmv"}, new String[]{".wps", "applicationnd.ms-works"}, new String[]{".xml", "text/plain"}, new String[]{".z", "application/x-compress"}, new String[]{".zip", "application/x-zip-compressed"}, new String[]{"", Headers.VALUE_ACCEPT_ALL}};

    public static String a(long j4) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j4 < 1024) {
            return decimalFormat.format(j4) + "B";
        } else if (j4 < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d4 = j4;
            Double.isNaN(d4);
            sb.append(decimalFormat.format(d4 / 1024.0d));
            sb.append("KB");
            return sb.toString();
        } else if (j4 < 1073741824) {
            StringBuilder sb2 = new StringBuilder();
            double d5 = j4;
            Double.isNaN(d5);
            sb2.append(decimalFormat.format(d5 / 1048576.0d));
            sb2.append("MB");
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            double d6 = j4;
            Double.isNaN(d6);
            sb3.append(decimalFormat.format(d6 / 1.073741824E9d));
            sb3.append("GB");
            return sb3.toString();
        }
    }

    public static String b() {
        if (d()) {
            return f1790a;
        }
        return f1791b;
    }

    private static String c(File file) {
        String lowerCase;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        String str = Headers.VALUE_ACCEPT_ALL;
        if (lastIndexOf < 0 || (lowerCase = name.substring(lastIndexOf, name.length()).toLowerCase()) == "") {
            return Headers.VALUE_ACCEPT_ALL;
        }
        int i4 = 0;
        while (true) {
            String[][] strArr = f1794e;
            if (i4 >= strArr.length) {
                return str;
            }
            if (lowerCase.equals(strArr[i4][0])) {
                str = strArr[i4][1];
            }
            i4++;
        }
    }

    public static boolean d() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void delete(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    delete(file2);
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }

    public static String e(String str, String str2) {
        if (d()) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            new File(str, str2);
            return "";
        }
        return "Sd\u5361\u4e0d\u53ef\u7528\uff01";
    }

    public static void f(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), c(file));
        try {
            context.startActivity(intent);
        } catch (Exception e4) {
            e4.printStackTrace();
            Toast.makeText(context, "\u6253\u5f00\u5931\u8d25\uff0c\u8bf7\u5b89\u88c5\u652f\u6301\u6253\u5f00\u8be5\u7c7b\u6587\u4ef6\u7684\u5e94\u7528\u3002", 1).show();
        }
    }
}
