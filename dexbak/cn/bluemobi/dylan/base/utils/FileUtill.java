package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.kuaishou.weapon.p205p0.AbstractC7249d;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.File;
import java.text.DecimalFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: cn.bluemobi.dylan.base.utils.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class FileUtill {

    /* renamed from: a */
    public static final String f1804a = Environment.getExternalStorageDirectory().getPath() + "/rtCloudTemporary/Image/";

    /* renamed from: b */
    public static String f1805b = "/rtCloudTemporary/Image/";

    /* renamed from: c */
    public static final String f1806c = Environment.getExternalStorageDirectory().getPath() + "/rtCloud/Image/";

    /* renamed from: d */
    public static String f1807d = "/rtCloud/Image/";

    /* renamed from: e */
    private static final String[][] f1808e = {new String[]{".3gp", "video/3gpp"}, new String[]{".apk", "applicationnd.android.package-archive"}, new String[]{".asf", "video/x-ms-asf"}, new String[]{".avi", "video/x-msvideo"}, new String[]{".bin", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE}, new String[]{".bmp", "image/bmp"}, new String[]{".c", "text/plain"}, new String[]{".class", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE}, new String[]{".conf", "text/plain"}, new String[]{".cpp", "text/plain"}, new String[]{".doc", "application/msword"}, new String[]{".docx", "applicationnd.openxmlformats-officedocument.wordprocessingml.document"}, new String[]{".xls", "applicationnd.ms-excel"}, new String[]{".xlsx", "applicationnd.openxmlformats-officedocument.spreadsheetml.sheet"}, new String[]{".exe", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE}, new String[]{".gif", "image/gif"}, new String[]{".gtar", "application/x-gtar"}, new String[]{AbstractC7249d.f24762b, "application/x-gzip"}, new String[]{".h", "text/plain"}, new String[]{".htm", "textml"}, new String[]{".html", "textml"}, new String[]{".jar", "application/java-archive"}, new String[]{".java", "text/plain"}, new String[]{".jpeg", "image/jpeg"}, new String[]{".jpg", "image/jpeg"}, new String[]{".js", "application/x-javascript"}, new String[]{".log", "text/plain"}, new String[]{".m3u", "audio/x-mpegurl"}, new String[]{".m4a", "audio/mp4a-latm"}, new String[]{".m4b", "audio/mp4a-latm"}, new String[]{".m4p", "audio/mp4a-latm"}, new String[]{".m4u", "videond.mpegurl"}, new String[]{".m4v", "video/x-m4v"}, new String[]{".mov", "video/quicktime"}, new String[]{".mp2", "audio/x-mpeg"}, new String[]{".mp3", "audio/x-mpeg"}, new String[]{".mp4", "video/mp4"}, new String[]{".mpc", "applicationnd.mpohun.certificate"}, new String[]{".mpe", "video/mpeg"}, new String[]{".mpeg", "video/mpeg"}, new String[]{".mpg", "video/mpeg"}, new String[]{".mpg4", "video/mp4"}, new String[]{".mpga", "audio/mpeg"}, new String[]{".msg", "applicationnd.ms-outlook"}, new String[]{".ogg", "audio/ogg"}, new String[]{".pdf", "applicationf"}, new String[]{PhotoBitmapUtils.f15141c, "image/png"}, new String[]{".pps", "applicationnd.ms-powerpoint"}, new String[]{".ppt", "applicationnd.ms-powerpoint"}, new String[]{".pptx", "applicationnd.openxmlformats-officedocument.presentationml.presentation"}, new String[]{".prop", "text/plain"}, new String[]{".rc", "text/plain"}, new String[]{".rmvb", "audio/x-pn-realaudio"}, new String[]{".rtf", "application/rtf"}, new String[]{".sh", "text/plain"}, new String[]{".tar", "application/x-tar"}, new String[]{".tgz", "application/x-compressed"}, new String[]{".txt", "text/plain"}, new String[]{".wav", "audio/x-wav"}, new String[]{".wma", "audio/x-ms-wma"}, new String[]{".wmv", "audio/x-ms-wmv"}, new String[]{".wps", "applicationnd.ms-works"}, new String[]{".xml", "text/plain"}, new String[]{".z", "application/x-compress"}, new String[]{".zip", "application/x-zip-compressed"}, new String[]{"", "*/*"}};

    /* renamed from: a */
    public static String m57751a(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        } else if (j < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d = j;
            Double.isNaN(d);
            sb.append(decimalFormat.format(d / 1024.0d));
            sb.append("KB");
            return sb.toString();
        } else if (j < IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            StringBuilder sb2 = new StringBuilder();
            double d2 = j;
            Double.isNaN(d2);
            sb2.append(decimalFormat.format(d2 / 1048576.0d));
            sb2.append("MB");
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            double d3 = j;
            Double.isNaN(d3);
            sb3.append(decimalFormat.format(d3 / 1.073741824E9d));
            sb3.append("GB");
            return sb3.toString();
        }
    }

    /* renamed from: b */
    public static String m57750b() {
        if (m57748d()) {
            return f1804a;
        }
        return f1805b;
    }

    /* renamed from: c */
    private static String m57749c(File file) {
        String lowerCase;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        String str = "*/*";
        if (lastIndexOf < 0 || (lowerCase = name.substring(lastIndexOf, name.length()).toLowerCase()) == "") {
            return "*/*";
        }
        int i = 0;
        while (true) {
            String[][] strArr = f1808e;
            if (i >= strArr.length) {
                return str;
            }
            if (lowerCase.equals(strArr[i][0])) {
                str = strArr[i][1];
            }
            i++;
        }
    }

    /* renamed from: d */
    public static boolean m57748d() {
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

    /* renamed from: e */
    public static String m57747e(String str, String str2) {
        if (m57748d()) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            new File(str, str2);
            return "";
        }
        return "Sd卡不可用！";
    }

    /* renamed from: f */
    public static void m57746f(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), m57749c(file));
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "打开失败，请安装支持打开该类文件的应用。", 1).show();
        }
    }
}
