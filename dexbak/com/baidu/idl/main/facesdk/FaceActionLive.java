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

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    private native int nativeActionLive(long j, int i, BDFaceImageInstance bDFaceImageInstance, float[] fArr, int[] iArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeActionLiveModelInit(long j, byte[] bArr, byte[] bArr2);

    private native void nativeActionLoadConfig(long j, BDFaceSDKActionConfig bDFaceSDKActionConfig);

    private native int nativeClearHistory(long j);

    private native int nativeUninitActionLiveModel(long j);

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
                    callback.onResponse(1, "没有初始化上下文");
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
                    callback.onResponse(nativeActionLiveModelInit, "动作活体模型加载成功");
                } else {
                    callback.onResponse(nativeActionLiveModelInit, "动作活体模型加载失败");
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
