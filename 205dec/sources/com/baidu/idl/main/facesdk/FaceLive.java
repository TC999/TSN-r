package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.utils.FileUitls;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceLive {
    private static final String TAG = "FaceLive";
    private BDFaceInstance bdFaceInstance;

    public FaceLive(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native float nativeSilentLive(long j4, int i4, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSilentLiveModelInit(long j4, byte[] bArr, int i4);

    private native int nativeUninitModel(long j4);

    public void initModel(final Context context, final String str, final String str2, final String str3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceLive.1
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                int i5;
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceLive.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                int i6 = -1;
                if (modelContent.length != 0) {
                    i4 = FaceLive.this.nativeSilentLiveModelInit(index, modelContent, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_RGB.ordinal());
                    if (i4 != 0) {
                        callback.onResponse(i4, "Vis \u6d3b\u4f53\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                        return;
                    }
                } else {
                    i4 = -1;
                }
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent2.length != 0) {
                    i5 = FaceLive.this.nativeSilentLiveModelInit(index, modelContent2, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_NIR.ordinal());
                    if (i5 != 0) {
                        callback.onResponse(i5, "Nir \u6d3b\u4f53\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                        return;
                    }
                } else {
                    i5 = -1;
                }
                byte[] modelContent3 = FileUitls.getModelContent(context, str3);
                if (modelContent3.length != 0 && (i6 = FaceLive.this.nativeSilentLiveModelInit(index, modelContent3, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_DEPTH.ordinal())) != 0) {
                    callback.onResponse(i6, "Deep \u6d3b\u4f53\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                    return;
                }
                if (i4 != 0 && i5 != 0 && i6 != 0) {
                    callback.onResponse(1, "\u6d3b\u4f53\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                } else {
                    callback.onResponse(0, "\u6d3b\u4f53\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                }
                Log.e("bdface", "FaceLive initModel");
            }
        });
    }

    public float silentLive(BDFaceSDKCommon.LiveType liveType, BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (liveType != null && bDFaceImageInstance != null && fArr != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1.0f;
            }
            return nativeSilentLive(index, liveType.ordinal(), bDFaceImageInstance, fArr);
        }
        Log.v(TAG, "Parameter is null");
        return -1.0f;
    }

    public int uninitModel() {
        if (this.bdFaceInstance.getIndex() == 0) {
            return -1;
        }
        return nativeUninitModel(this.bdFaceInstance.getIndex());
    }

    public FaceLive() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
