package cn.jiguang.br;

import android.content.Context;
import cn.jiguang.cn.d;
import cn.jiguang.f.i;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import java.io.File;
import java.io.RandomAccessFile;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2837a = d.b(new byte[]{65, 87, 92, 29, 117, 43, 125, 38, 37, 123, 22, 96, 109, 94, 107, 8, 75, 85, 64, 78, 126, 120, 114, 78, 78, 37, 71, 94, 107, 44, 101, 94, 93, 106, 22, 111, 79, 87, 114, 88, 20, 99, 98, 115});

    /* renamed from: b  reason: collision with root package name */
    public static final String f2838b = d.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 85, 105, 100, 121, 112, 84, 13, 99, 58, 56, 96, 89, 78, 112, 125, 102, 63, 83, 79, 116});

    public static boolean a(Context context, String str, File file) {
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        HttpResponse httpResponse;
        int responseCode;
        cn.jiguang.bq.d.c("UploadLogUtils", "url is : " + str + "\n fileName is : " + file.getName());
        RandomAccessFile randomAccessFile2 = null;
        try {
            bArr = new byte[(int) file.length()];
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            randomAccessFile.read(bArr);
            HttpRequest httpRequest = new HttpRequest(str);
            httpRequest.setRequestProperty("Connection", "Keep-Alive");
            httpRequest.setRequestProperty("Content-Type", "multipart/form-data");
            httpRequest.setUseCaches(false);
            httpRequest.setHaveRspData(true);
            httpRequest.setDoInPut(true);
            httpRequest.setDoOutPut(true);
            httpRequest.setBody(bArr);
            httpResponse = HttpUtils.httpResponse(context, httpRequest, false, true);
            responseCode = httpResponse.getResponseCode();
            cn.jiguang.bq.d.c("UploadLogUtils", "response code is " + responseCode + ", response message is " + httpResponse.toString());
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            try {
                cn.jiguang.bq.d.c("UploadLogUtils", "error message is : " + th.getMessage());
                return false;
            } finally {
                i.a(randomAccessFile2);
            }
        }
        if (responseCode == 200) {
            i.a(randomAccessFile);
            return true;
        }
        String responseBody = httpResponse.getResponseBody();
        cn.jiguang.bq.a.a(context, false, "", responseBody);
        cn.jiguang.bq.d.c("UploadLogUtils", "error response is : " + responseBody);
        i.a(randomAccessFile);
        return false;
    }
}
