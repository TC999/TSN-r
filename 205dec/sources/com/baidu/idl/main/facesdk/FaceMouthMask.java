package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.utils.FileUitls;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceMouthMask {
    private static final String TAG = "FaceMouthMask";
    private BDFaceInstance bdFaceInstance;

    public FaceMouthMask(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native float[] nativeCheckMask(long j4, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeInitModel(long j4, byte[] bArr);

    private native int nativeUninitModel(long j4);

    public float[] checkMask(BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr) {
        if (bDFaceImageInstance != null && faceInfoArr != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCheckMask(index, bDFaceImageInstance, faceInfoArr);
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public void initModel(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceMouthMask.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceMouthMask.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                int i4 = -1;
                byte[] modelContent = FileUitls.getModelContent(context, str);
                if (modelContent.length != 0 && (i4 = FaceMouthMask.this.nativeInitModel(index, modelContent)) != 0) {
                    callback.onResponse(i4, "\u53e3\u7f69\u68c0\u6d4b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                    return;
                }
                if (i4 == 0) {
                    callback.onResponse(0, "\u53e3\u7f69\u68c0\u6d4b\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                } else {
                    callback.onResponse(1, "\u53e3\u7f69\u68c0\u6d4b\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                }
                Log.e("bdface", "FaceMouthMask initModel");
            }
        });
    }

    public int uninitModel() {
        if (this.bdFaceInstance.getIndex() == 0) {
            return -1;
        }
        return nativeUninitModel(this.bdFaceInstance.getIndex());
    }

    public FaceMouthMask() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
