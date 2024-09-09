package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.bk;
import com.bytedance.sdk.component.w.c.f;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.t;
import com.bytedance.sdk.component.w.c.w;
import com.bytedance.sdk.component.w.c.ys;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static a okHttpClient;

    public static String buildRangeHeader(long j4, long j5) {
        String formRangeStrBySize = formRangeStrBySize(j4, j5);
        if (formRangeStrBySize == null) {
            return null;
        }
        return "bytes=" + formRangeStrBySize;
    }

    @SuppressLint({"CI_DefaultLocale"})
    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i4) throws IOException {
        t.c cVar = new t.c();
        cVar.c(aVMDLRequest.urls[i4]);
        cVar.c("GET", (ys) null);
        cVar.c(toOkHttpHeaders(aVMDLRequest));
        w c4 = getOkHttpClient().c(cVar.w());
        try {
            long currentTimeMillis = System.currentTimeMillis();
            fp c5 = c4.c();
            long currentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i4;
            AVMDLLog.d(TAG, String.format("http open cost time:%d url:%s", Long.valueOf(currentTimeMillis2 - currentTimeMillis), aVMDLRequest.urls[i4]));
            return new AVMDLResponse(aVMDLRequest, c5, c4);
        } catch (Exception e4) {
            AVMDLLog.e(TAG, "request exception is " + e4.getLocalizedMessage());
            throw e4;
        }
    }

    public static String formRangeStrByPos(long j4, long j5) {
        if (j4 >= 0 && j5 > 0) {
            return j4 + "-" + j5;
        } else if (j4 >= 0) {
            return j4 + "-";
        } else if (j4 >= 0 || j5 <= 0) {
            return null;
        } else {
            return "-" + j5;
        }
    }

    public static String formRangeStrBySize(long j4, long j5) {
        return formRangeStrByPos(j4, j5 > 0 ? (j5 + j4) - 1 : -1L);
    }

    private static synchronized a getOkHttpClient() {
        a aVar;
        long j4;
        int i4;
        synchronized (AVMDLHttpExcutor.class) {
            if (okHttpClient == null) {
                AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
                long j5 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
                if (config != null) {
                    long j6 = config.mOpenTimeOut > 0 ? i4 * 1000 : 10000L;
                    int i5 = config.mRWTimeOut;
                    if (i5 > 0) {
                        j5 = i5 * 1000;
                    }
                    long j7 = j5;
                    j5 = j6;
                    j4 = j7;
                } else {
                    j4 = 10000;
                }
                AVMDLLog.d(TAG, "connect timeout:" + j5 + " rwtimeout:" + j4);
                a.c cVar = new a.c();
                cVar.c(Collections.singletonList(bk.HTTP_1_1));
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                cVar.c(j5, timeUnit).w(j4, timeUnit).xv(j4, timeUnit);
                okHttpClient = cVar.c();
            }
            aVar = okHttpClient;
        }
        return aVar;
    }

    private static f toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        f.c cVar = new f.c();
        HashMap<String, String> hashMap = aVMDLRequest.headers;
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                AVMDLLog.d(TAG, "custom header key:" + entry.getKey() + "  value:" + entry.getValue());
                cVar.w(entry.getKey(), entry.getValue());
            }
        }
        String buildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (buildRangeHeader != null) {
            AVMDLLog.d(TAG, "range str: " + buildRangeHeader);
            cVar.w("Range", buildRangeHeader);
        }
        cVar.w("Accept-Encoding", "identity");
        return cVar.c();
    }
}
