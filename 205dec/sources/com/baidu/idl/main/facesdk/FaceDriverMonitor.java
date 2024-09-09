package com.baidu.idl.main.facesdk;

import android.content.Context;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceDriverMonitorInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.utils.FileUitls;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceDriverMonitor {
    private BDFaceInstance bdFaceInstance;

    public FaceDriverMonitor(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    public BDFaceDriverMonitorInfo driverMonitor(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo) {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0 || bDFaceImageInstance == null || faceInfo == null) {
            return null;
        }
        return nativeDriverMonitor(index, bDFaceImageInstance, faceInfo);
    }

    public void initDriverMonitor(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDriverMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceDriverMonitor.this.bdFaceInstance.getIndex();
                int i4 = -1;
                if (index == 0) {
                    callback.onResponse(-1, "\u9a7e\u9a76\u884c\u4e3a\u76d1\u6d4b\u80fd\u529b\u52a0\u8f7d\u5931\u8d25 instanceIndex=0");
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                if (modelContent.length != 0 && (i4 = FaceDriverMonitor.this.nativeDriverMonitorInit(index, modelContent)) != 0) {
                    callback.onResponse(i4, "\u9a7e\u9a76\u884c\u4e3a\u76d1\u6d4b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                } else if (i4 == 0) {
                    callback.onResponse(0, "\u9a7e\u9a76\u884c\u4e3a\u76d1\u6d4b\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                } else {
                    callback.onResponse(1, "\u9a7e\u9a76\u884c\u4e3a\u76d1\u6d4b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                }
            }
        });
    }

    public native BDFaceDriverMonitorInfo nativeDriverMonitor(long j4, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo);

    public native int nativeDriverMonitorInit(long j4, byte[] bArr);

    public native int nativeUnInitDriverMonitor(long j4);

    public int uninitDriverMonitor() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUnInitDriverMonitor(index);
    }

    public FaceDriverMonitor() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
