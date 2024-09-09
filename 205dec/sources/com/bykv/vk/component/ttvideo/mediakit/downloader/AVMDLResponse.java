package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.w;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public w call;
    public long readOff;
    public AVMDLRequest request;
    public fp response;
    public long contentlength = -1;
    public int statusCode = -1;
    public boolean isReadErr = false;

    public AVMDLResponse(AVMDLRequest aVMDLRequest, fp fpVar, w wVar) {
        this.request = aVMDLRequest;
        this.response = fpVar;
        this.call = wVar;
        this.readOff = aVMDLRequest.reqOff;
        parseResponse();
    }

    private void parseResponse() {
        int lastIndexOf;
        fp fpVar = this.response;
        if (fpVar == null) {
            return;
        }
        int xv = fpVar.xv();
        this.statusCode = xv;
        if (xv == 200) {
            this.contentlength = toInt(this.response.c("Content-Length"));
        } else if (xv == 206) {
            String c4 = this.response.c("Content-Range");
            if (TextUtils.isEmpty(c4) || (lastIndexOf = c4.lastIndexOf(TTPathConst.sSeparator)) < 0 || lastIndexOf >= c4.length() - 1) {
                return;
            }
            this.contentlength = toInt(c4.substring(lastIndexOf + 1), -1);
        }
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public void cancel() {
        w wVar = this.call;
        if (wVar != null) {
            wVar.w();
        }
    }

    @SuppressLint({"CI_DefaultLocale"})
    public boolean isFinish() {
        AVMDLRequest aVMDLRequest = this.request;
        long j4 = aVMDLRequest.size;
        long j5 = j4 >= 0 ? aVMDLRequest.reqOff + j4 : this.contentlength;
        long j6 = this.contentlength;
        if (j5 > j6) {
            j5 = j6;
        }
        AVMDLLog.d(TAG, String.format("check readoff:%d reqoff:%d reqsize:%d contentlen:%d endoff:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size), Long.valueOf(this.contentlength), Long.valueOf(j5)));
        return this.readOff >= j5;
    }

    public boolean isOpenSuccessful() {
        int i4 = this.statusCode;
        return i4 >= 200 && i4 < 300;
    }

    public boolean isReadSuccessful() {
        return !this.isReadErr;
    }

    @SuppressLint({"CI_DefaultLocale"})
    public int readData(byte[] bArr) {
        if (this.response.f() == null) {
            return 0;
        }
        try {
            int read = this.response.f().xv().read(bArr);
            if (read > 0) {
                AVMDLLog.d(TAG, String.format("before read off:%d reqoff:%d req size:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size)));
                long j4 = read;
                this.readOff += j4;
                AVMDLRequest aVMDLRequest = this.request;
                aVMDLRequest.reqOff += j4;
                long j5 = aVMDLRequest.size;
                if (j5 > 0) {
                    aVMDLRequest.size = j5 - j4;
                }
                AVMDLLog.d(TAG, String.format("after read,ret:%d off:%d reqoff:%d req size:%d", Integer.valueOf(read), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size)));
                return read;
            }
            return -1;
        } catch (IOException e4) {
            this.isReadErr = true;
            AVMDLLog.e(TAG, "read data exception:" + e4.getLocalizedMessage());
            return -1;
        }
    }

    public void reset() {
        this.response = null;
        this.call = null;
        this.contentlength = -1L;
        this.statusCode = -1;
        this.isReadErr = false;
    }

    public static int toInt(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return i4;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i4;
        }
    }
}
