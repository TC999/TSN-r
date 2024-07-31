package com.baidu.idl.main.facesdk;

import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceCropParam;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceIsOutBoundary;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FaceCrop {
    private static final String TAG = "FaceCrop";
    private BDFaceInstance bdFaceInstance;

    public FaceCrop(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native BDFaceImageInstance nativeCropFaceByBox(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByBoxIsOutofBoundary(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByBoxParam(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmark(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f, boolean z, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByLandmarkIsOutofBoundary(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmarkParam(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeCropImageInit(long j);

    private native BDFaceImageInstance nativeResizeImage(BDFaceImageInstance bDFaceImageInstance, int i, BDFaceSDKCommon.BDFaceImageType bDFaceImageType);

    private native int nativeUnInitCropImage(long j);

    public BDFaceImageInstance cropFaceByBox(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance != null && faceInfo != null && atomicInteger != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            int[] iArr = new int[1];
            BDFaceImageInstance nativeCropFaceByBox = nativeCropFaceByBox(index, bDFaceImageInstance, faceInfo, f, iArr);
            atomicInteger.set(iArr[0]);
            return nativeCropFaceByBox;
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public BDFaceIsOutBoundary cropFaceByBoxIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance != null && faceInfo != null && bDFaceCropParam != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCropFaceByBoxIsOutofBoundary(index, bDFaceImageInstance, faceInfo, bDFaceCropParam);
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public BDFaceImageInstance cropFaceByBoxParam(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance != null && faceInfo != null && bDFaceCropParam != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                Log.v(TAG, "instanceIndex == 0");
                return null;
            }
            return nativeCropFaceByBoxParam(index, bDFaceImageInstance, faceInfo, bDFaceCropParam);
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public BDFaceImageInstance cropFaceByLandmark(BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f, boolean z, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance != null && atomicInteger != null && fArr.length >= 0) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            int[] iArr = new int[1];
            BDFaceImageInstance nativeCropFaceByLandmark = nativeCropFaceByLandmark(index, bDFaceImageInstance, fArr, f, z, iArr);
            atomicInteger.set(iArr[0]);
            return nativeCropFaceByLandmark;
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public BDFaceIsOutBoundary cropFaceByLandmarkIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance != null && fArr != null && bDFaceCropParam != null && fArr.length != 0) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCropFaceByLandmarkIsOutofBoundary(index, bDFaceImageInstance, fArr, bDFaceCropParam);
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public BDFaceImageInstance cropFaceByLandmarkParam(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance != null && fArr != null && bDFaceCropParam != null && fArr.length != 0) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCropFaceByLandmarkParam(index, bDFaceImageInstance, fArr, bDFaceCropParam);
        }
        Log.v(TAG, "Parameter is null");
        return null;
    }

    public void initFaceCrop(final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceCrop.1
            @Override // java.lang.Runnable
            public void run() {
                long index = FaceCrop.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    callback.onResponse(-1, "抠图能力加载失败 instanceIndex=0");
                    return;
                }
                int nativeCropImageInit = FaceCrop.this.nativeCropImageInit(index);
                if (nativeCropImageInit == 0) {
                    callback.onResponse(nativeCropImageInit, "抠图能力加载成功");
                    return;
                }
                Callback callback2 = callback;
                callback2.onResponse(nativeCropImageInit, "抠图能力加载失败: " + nativeCropImageInit);
            }
        });
    }

    public BDFaceImageInstance resizeImage(BDFaceImageInstance bDFaceImageInstance, int i) {
        if (bDFaceImageInstance == null) {
            return null;
        }
        return nativeResizeImage(bDFaceImageInstance, i, bDFaceImageInstance.imageType);
    }

    public int uninitFaceCrop() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUnInitCropImage(index);
    }

    public FaceCrop() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
