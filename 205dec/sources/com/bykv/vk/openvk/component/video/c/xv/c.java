package com.bykv.vk.openvk.component.video.c.xv;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.openvk.component.video.c.w.gd;
import com.bykv.vk.openvk.component.video.c.w.ux;
import com.bykv.vk.openvk.component.video.c.w.w.xv;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: w  reason: collision with root package name */
    private static final Handler f25165w = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f25164c = Charset.forName("UTF-8");

    /* renamed from: com.bykv.vk.openvk.component.video.c.xv.c$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class AnonymousClass1 implements FilenameFilter {

        /* renamed from: c  reason: collision with root package name */
        private Pattern f25166c = Pattern.compile("^cpu[0-9]+$");

        AnonymousClass1() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f25166c.matcher(str).matches();
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int w(String str) {
        return c(str, 0);
    }

    public static boolean xv(String str) {
        return str != null && (str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str));
    }

    public static void c(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String w(int i4, int i5) {
        if (i4 >= 0 && i5 > 0) {
            return i4 + "-" + i5;
        } else if (i4 > 0) {
            return i4 + "-";
        } else if (i4 >= 0 || i5 <= 0) {
            return null;
        } else {
            return "-" + i5;
        }
    }

    public static void c(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean w() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean c(String str) {
        return str != null && (str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE));
    }

    public static String w(List<gd.w> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            gd.w wVar = list.get(0);
            if (wVar != null) {
                sb.append(wVar.f25101c);
                sb.append(": ");
                sb.append(wVar.f25102w);
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

    public static int c(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return i4;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i4;
        }
    }

    public static String c(com.bykv.vk.openvk.component.video.c.w.ux.c cVar, int i4) {
        int c4;
        if (cVar == null || !cVar.w()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.ux().toUpperCase());
        sb.append(' ');
        sb.append(cVar.c());
        sb.append(' ');
        sb.append(cVar.f());
        sb.append("\r\n");
        if (ux.xv) {
            Log.i("TAG_PROXY_headers", cVar.ux().toUpperCase() + " " + cVar.c() + " " + cVar.f());
        }
        List<gd.w> c5 = c(cVar.xv());
        boolean z3 = true;
        if (c5 != null) {
            int size = c5.size();
            for (int i5 = 0; i5 < size; i5++) {
                gd.w wVar = c5.get(i5);
                if (wVar != null) {
                    String str = wVar.f25101c;
                    String str2 = wVar.f25102w;
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    sb.append("\r\n");
                    if ("Content-Range".equalsIgnoreCase(str) || ("Accept-Ranges".equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z3 = false;
                    }
                }
            }
        }
        if (z3 && (c4 = c(cVar)) > 0) {
            sb.append("Content-Range: bytes ");
            sb.append(Math.max(i4, 0));
            sb.append("-");
            sb.append(c4 - 1);
            sb.append(TTPathConst.sSeparator);
            sb.append(c4);
            sb.append("\r\n");
        }
        sb.append("Connection: close");
        sb.append("\r\n");
        sb.append("\r\n");
        String sb2 = sb.toString();
        if (ux.xv) {
            Log.i("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    public static String w(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey());
            sb.append(": ");
            sb.append((Object) entry.getValue());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public static String c(int i4, int i5) {
        String w3 = w(i4, i5);
        if (w3 == null) {
            return null;
        }
        return "bytes=" + w3;
    }

    public static List<String> c(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (c(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String c(com.bykv.vk.openvk.component.video.c.w.w.c cVar, int i4) {
        StringBuilder sb = new StringBuilder();
        if (i4 <= 0) {
            sb.append("HTTP/1.1 200 OK");
            sb.append("\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content");
            sb.append("\r\n");
        }
        sb.append("Accept-Ranges: bytes");
        sb.append("\r\n");
        sb.append("Content-Type: ");
        sb.append(cVar.f25148w);
        sb.append("\r\n");
        if (i4 <= 0) {
            sb.append("Content-Length: ");
            sb.append(cVar.xv);
            sb.append("\r\n");
        } else {
            sb.append("Content-Range: bytes ");
            sb.append(i4);
            sb.append("-");
            sb.append(cVar.xv - 1);
            sb.append(TTPathConst.sSeparator);
            sb.append(cVar.xv);
            sb.append("\r\n");
            sb.append("Content-Length: ");
            sb.append(cVar.xv - i4);
            sb.append("\r\n");
        }
        sb.append("Connection: close");
        sb.append("\r\n");
        sb.append("\r\n");
        String sb2 = sb.toString();
        if (ux.xv) {
            Log.i("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    public static int c() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    public static int c(com.bykv.vk.openvk.component.video.c.w.ux.c cVar) {
        int lastIndexOf;
        if (cVar == null) {
            return -1;
        }
        if (cVar.c() == 200) {
            return c(cVar.c("Content-Length", null), -1);
        }
        if (cVar.c() == 206) {
            String c4 = cVar.c("Content-Range", null);
            if (!TextUtils.isEmpty(c4) && (lastIndexOf = c4.lastIndexOf(TTPathConst.sSeparator)) >= 0 && lastIndexOf < c4.length() - 1) {
                return c(c4.substring(lastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String c(com.bykv.vk.openvk.component.video.c.w.ux.c cVar, boolean z3, boolean z4) {
        String c4;
        if (cVar == null) {
            if (ux.xv) {
                Log.e("TAG_PROXY_Response", "response null");
            }
            return "response null";
        } else if (!cVar.w()) {
            if (ux.xv) {
                Log.e("TAG_PROXY_Response", "response code: " + cVar.c());
            }
            return "response code: " + cVar.c();
        } else {
            String c5 = cVar.c("Content-Type", null);
            if (!xv(c5)) {
                if (ux.xv) {
                    Log.e("TAG_PROXY_Response", "Content-Type: " + c5);
                }
                return "Content-Type: " + c5;
            }
            int c6 = c(cVar);
            if (c6 <= 0) {
                if (ux.xv) {
                    Log.e("TAG_PROXY_Response", "Content-Length: " + c6);
                }
                return "Content-Length: " + c6;
            } else if (z3 && ((c4 = cVar.c("Accept-Ranges", null)) == null || !c4.contains("bytes"))) {
                if (ux.xv) {
                    Log.e("TAG_PROXY_Response", "Accept-Ranges: " + c4);
                }
                return "Accept-Ranges: " + c4;
            } else if (z4 && cVar.sr() == null) {
                if (ux.xv) {
                    Log.e("TAG_PROXY_Response", "response body null");
                }
                return "response body null";
            } else {
                return null;
            }
        }
    }

    public static void c(p pVar) {
        if (pVar != null) {
            if (w()) {
                ev.w(pVar);
                if (ux.xv) {
                    Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            pVar.run();
            if (ux.xv) {
                Log.e("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void c(Runnable runnable) {
        if (runnable != null) {
            if (w()) {
                runnable.run();
            } else {
                f25165w.post(runnable);
            }
        }
    }

    public static List<gd.w> c(List<gd.w> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (ux.xv) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                gd.w wVar = list.get(i4);
                if (wVar != null) {
                    Log.i("TAG_PROXY_PRE_FILTER", wVar.f25101c + ": " + wVar.f25101c);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (gd.w wVar2 : list) {
            if ("Host".equals(wVar2.f25101c) || "Keep-Alive".equals(wVar2.f25101c) || "Connection".equals(wVar2.f25101c) || "Proxy-Connection".equals(wVar2.f25101c)) {
                arrayList.add(wVar2);
            }
        }
        list.removeAll(arrayList);
        if (ux.xv) {
            int size2 = list.size();
            for (int i5 = 0; i5 < size2; i5++) {
                gd.w wVar3 = list.get(i5);
                if (wVar3 != null) {
                    Log.i("TAG_PROXY_POST_FILTER", wVar3.f25101c + ": " + wVar3.f25102w);
                }
            }
        }
        return list;
    }

    public static List<gd.w> c(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> entrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : entrySet) {
                    arrayList.add(new gd.w(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static com.bykv.vk.openvk.component.video.c.w.w.c c(com.bykv.vk.openvk.component.video.c.w.ux.c cVar, xv xvVar, String str, int i4) {
        String str2;
        String str3;
        String str4;
        com.bykv.vk.openvk.component.video.c.w.w.c query = xvVar.query(str, i4);
        if (query == null) {
            int c4 = c(cVar);
            String c5 = cVar.c("Content-Type", null);
            if (c4 <= 0 || TextUtils.isEmpty(c5)) {
                return query;
            }
            com.bykv.vk.openvk.component.video.c.w.ux.ux r3 = cVar.r();
            if (r3 != null) {
                str3 = r3.f25143w;
                str2 = w(r3.ux);
            } else {
                str2 = "";
                str3 = str2;
            }
            String w3 = w(cVar.xv());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("requestUrl", str3);
                jSONObject.put("requestHeaders", str2);
                jSONObject.put("responseHeaders", w3);
                str4 = jSONObject.toString();
            } catch (Throwable unused) {
                str4 = "";
            }
            com.bykv.vk.openvk.component.video.c.w.w.c cVar2 = new com.bykv.vk.openvk.component.video.c.w.w.c(str, c5, c4, i4, str4);
            xvVar.insert(cVar2);
            return cVar2;
        }
        return query;
    }
}
