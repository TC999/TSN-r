package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKActionConfig;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.utils.FileUitls;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceActionLive {
    private static final String TAG = "FaceActionLive";
    private BDFaceInstance bdFaceInstance;
    private int[] isExist;

    public FaceActionLive(BDFaceInstance bDFaceInstance) {
        this.isExist = new int[1];
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native int nativeActionLive(long j4, int i4, BDFaceImageInstance bDFaceImageInstance, float[] fArr, int[] iArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeActionLiveModelInit(long j4, byte[] bArr, byte[] bArr2);

    private native void nativeActionLoadConfig(long j4, BDFaceSDKActionConfig bDFaceSDKActionConfig);

    private native int nativeClearHistory(long j4);

    private native int nativeUninitActionLiveModel(long j4);

    public int actionLive(BDFaceSDKCommon.BDFaceActionLiveType bDFaceActionLiveType, BDFaceImageInstance bDFaceImageInstance, float[] fArr, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance != null && fArr != null && bDFaceActionLiveType != null && atomicInteger != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1;
            }
            int nativeActionLive = nativeActionLive(index, bDFaceActionLiveType.ordinal(), bDFaceImageInstance, fArr, this.isExist);
            atomicInteger.set(this.isExist[0]);
            return nativeActionLive;
        }
        Log.v(TAG, "Parameter is null");
        return -1;
    }

    public int clearHistory() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeClearHistory(index);
    }

    public void initActionLiveModel(final Context context, final String str, final String str2, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceActionLive.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                long index = FaceActionLive.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                byte[] modelContent2 = FileUitls.getModelContent(context, str2);
                if (modelContent.length == 0 || modelContent2.length == 0) {
                    return;
                }
                int nativeActionLiveModelInit = FaceActionLive.this.nativeActionLiveModelInit(index, modelContent, modelContent2);
                if (nativeActionLiveModelInit == 0) {
                    callback.onResponse(nativeActionLiveModelInit, "\u52a8\u4f5c\u6d3b\u4f53\u6a21\u578b\u52a0\u8f7d\u6210\u529f");
                } else {
                    callback.onResponse(nativeActionLiveModelInit, "\u52a8\u4f5c\u6d3b\u4f53\u6a21\u578b\u52a0\u8f7d\u5931\u8d25");
                }
            }
        });
    }

    public void loadActionConfig(BDFaceSDKActionConfig bDFaceSDKActionConfig) {
        BDFaceInstance bDFaceInstance = this.bdFaceInstance;
        if (bDFaceInstance == null) {
            return;
        }
        long index = bDFaceInstance.getIndex();
        if (index == 0) {
            return;
        }
        nativeActionLoadConfig(index, bDFaceSDKActionConfig);
    }

    public int uninitActionLiveModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitActionLiveModel(index);
    }

    public FaceActionLive() {
        this.isExist = new int[1];
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
