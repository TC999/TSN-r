package com.baidu.idl.face.platform.decode;

import android.graphics.Bitmap;
import android.util.Log;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.baidu.idl.main.facesdk.FaceInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FaceModuleNew {
    private static final String TAG = "FaceModuleNew";
    private FaceConfig mFaceConfig;
    private FaceExtInfo mFaceExtInfo;
    private FaceExtInfo[] mFaceExtInfos;

    public ArrayList<ImageInfo> getDetectBestCropImageList(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance) {
        if (faceExtInfo == null) {
            Log.e(TAG, "faceInfo == null");
            return null;
        } else if (bDFaceImageInstance == null) {
            Log.e(TAG, "cropInstance == null");
            return null;
        } else {
            ArrayList<ImageInfo> arrayList = new ArrayList<>();
            ImageInfo imageInfo = new ImageInfo();
            Bitmap instaceBmp = BitmapUtils.getInstaceBmp(bDFaceImageInstance);
            FaceConfig faceConfig = this.mFaceConfig;
            if (faceConfig != null) {
                faceConfig.getSecType();
            }
            String bitmapToBase64 = FaceSDKManager.getInstance().bitmapToBase64(FaceSDKManager.getInstance().compressImage(instaceBmp, 90));
            if (bitmapToBase64 != null && bitmapToBase64.length() > 0) {
                bitmapToBase64 = bitmapToBase64.replace("\\/", "/");
            }
            imageInfo.setBase64(bitmapToBase64);
            arrayList.add(imageInfo);
            if (instaceBmp != null) {
                instaceBmp.recycle();
            }
            return arrayList;
        }
    }

    public ArrayList<ImageInfo> getDetectBestSrcImageList(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance) {
        Bitmap bitmap;
        if (faceExtInfo == null) {
            Log.e(TAG, "faceInfo == null");
            return null;
        } else if (bDFaceImageInstance == null) {
            Log.e(TAG, "imageInstance == null");
            return null;
        } else {
            ArrayList<ImageInfo> arrayList = new ArrayList<>();
            ImageInfo imageInfo = new ImageInfo();
            Bitmap instaceBmp = BitmapUtils.getInstaceBmp(bDFaceImageInstance);
            if (this.mFaceConfig != null) {
                bitmap = FaceSDKManager.getInstance().scaleImage(instaceBmp, this.mFaceConfig.getScale());
                this.mFaceConfig.getSecType();
            } else {
                bitmap = instaceBmp;
            }
            String bitmapToBase64 = FaceSDKManager.getInstance().bitmapToBase64(FaceSDKManager.getInstance().compressImage(bitmap, 90));
            if (bitmapToBase64 != null && bitmapToBase64.length() > 0) {
                bitmapToBase64 = bitmapToBase64.replace("\\/", "/");
            }
            imageInfo.setBase64(bitmapToBase64);
            arrayList.add(imageInfo);
            if (bitmap != null) {
                bitmap.recycle();
            }
            if (instaceBmp != null) {
                instaceBmp.recycle();
            }
            return arrayList;
        }
    }

    public FaceExtInfo[] getFaceExtInfo(FaceInfo[] faceInfoArr) {
        if (this.mFaceExtInfos == null) {
            this.mFaceExtInfos = new FaceExtInfo[1];
            this.mFaceExtInfo = new FaceExtInfo();
        }
        if (faceInfoArr != null && faceInfoArr.length > 0) {
            if (this.mFaceExtInfo == null) {
                this.mFaceExtInfo = new FaceExtInfo();
            }
            this.mFaceExtInfo.addFaceInfo(faceInfoArr[0]);
            this.mFaceExtInfos[0] = this.mFaceExtInfo;
        } else {
            this.mFaceExtInfos[0] = null;
        }
        return this.mFaceExtInfos;
    }

    public void setFaceConfig(FaceConfig faceConfig) {
        this.mFaceConfig = faceConfig;
    }
}
