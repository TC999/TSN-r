package com.baidu.idl.main.facesdk;

import android.content.Context;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceGazeInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.utils.FileUitls;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceGaze {
    private static final String TAG = "FaceGaze";
    private BDFaceInstance bdFaceInstance;

    public FaceGaze(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native BDFaceGazeInfo nativeGaze(long j4, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGazeModelInit(long j4, byte[] bArr);

    private native int nativeUninitGazeModel(long j4);

    public BDFaceGazeInfo gaze(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (bDFaceImageInstance == null || fArr == null || fArr.length < 0) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeGaze(index, bDFaceImageInstance, fArr);
    }

    public void initModel(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceGaze.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceGaze.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                int i4 = -1;
                byte[] modelContent = FileUitls.getModelContent(context, str);
                if (modelContent.length != 0 && (i4 = FaceGaze.this.nativeGazeModelInit(index, modelContent)) != 0) {
                    callback.onResponse(i4, "\u6ce8\u610f\u529b\u68c0\u6d4b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                } else if (i4 == 0) {
                    callback.onResponse(0, "\u6ce8\u610f\u529b\u68c0\u6d4b\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                } else {
                    callback.onResponse(1, "\u6ce8\u610f\u529b\u68c0\u6d4b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                }
            }
        });
    }

    public int uninitGazeModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitGazeModel(index);
    }

    public FaceGaze() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
