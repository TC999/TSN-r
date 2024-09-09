package com.baidu.idl.main.facesdk;

import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceCropParam;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceIsOutBoundary;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceCrop {
    private static final String TAG = "FaceCrop";
    private BDFaceInstance bdFaceInstance;

    public FaceCrop(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native BDFaceImageInstance nativeCropFaceByBox(long j4, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f4, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByBoxIsOutofBoundary(long j4, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByBoxParam(long j4, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmark(long j4, BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f4, boolean z3, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByLandmarkIsOutofBoundary(long j4, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmarkParam(long j4, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeCropImageInit(long j4);

    private native BDFaceImageInstance nativeResizeImage(BDFaceImageInstance bDFaceImageInstance, int i4, BDFaceSDKCommon.BDFaceImageType bDFaceImageType);

    private native int nativeUnInitCropImage(long j4);

    public BDFaceImageInstance cropFaceByBox(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f4, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance != null && faceInfo != null && atomicInteger != null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            int[] iArr = new int[1];
            BDFaceImageInstance nativeCropFaceByBox = nativeCropFaceByBox(index, bDFaceImageInstance, faceInfo, f4, iArr);
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

    public BDFaceImageInstance cropFaceByLandmark(BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f4, boolean z3, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance != null && atomicInteger != null && fArr.length >= 0) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            int[] iArr = new int[1];
            BDFaceImageInstance nativeCropFaceByLandmark = nativeCropFaceByLandmark(index, bDFaceImageInstance, fArr, f4, z3, iArr);
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
                    callback.onResponse(-1, "\u62a0\u56fe\u80fd\u529b\u52a0\u8f7d\u5931\u8d25 instanceIndex=0");
                    return;
                }
                int nativeCropImageInit = FaceCrop.this.nativeCropImageInit(index);
                if (nativeCropImageInit == 0) {
                    callback.onResponse(nativeCropImageInit, "\u62a0\u56fe\u80fd\u529b\u52a0\u8f7d\u6210\u529f");
                    return;
                }
                Callback callback2 = callback;
                callback2.onResponse(nativeCropImageInit, "\u62a0\u56fe\u80fd\u529b\u52a0\u8f7d\u5931\u8d25: " + nativeCropImageInit);
            }
        });
    }

    public BDFaceImageInstance resizeImage(BDFaceImageInstance bDFaceImageInstance, int i4) {
        if (bDFaceImageInstance == null) {
            return null;
        }
        return nativeResizeImage(bDFaceImageInstance, i4, bDFaceImageInstance.imageType);
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
