package com.baidu.idl.face.platform.ui;

import android.content.BroadcastReceiver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.IDetectStrategy;
import com.baidu.idl.face.platform.IDetectStrategyCallback;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.face.platform.ui.utils.BrightnessUtils;
import com.baidu.idl.face.platform.ui.utils.CameraPreviewUtils;
import com.baidu.idl.face.platform.ui.utils.CameraUtils;
import com.baidu.idl.face.platform.ui.utils.VolumeUtils;
import com.baidu.idl.face.platform.ui.widget.FaceDetectRoundView;
import com.baidu.idl.face.platform.utils.Base64Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceDetectActivity extends AppCompatActivity implements SurfaceHolder.Callback, Camera.PreviewCallback, Camera.ErrorCallback, VolumeUtils.VolumeCallback, IDetectStrategyCallback {
    public static final String TAG = FaceDetectActivity.class.getSimpleName();
    protected Camera mCamera;
    protected int mCameraId;
    protected Camera.Parameters mCameraParam;
    protected ImageView mCloseView;
    protected FaceConfig mFaceConfig;
    protected FaceDetectRoundView mFaceDetectRoundView;
    protected FrameLayout mFrameLayout;
    protected boolean mHasShownTimeoutDialog;
    protected IDetectStrategy mIDetectStrategy;
    protected LinearLayout mImageLayout;
    protected LinearLayout mImageLayout2;
    protected int mPreviewDegree;
    protected int mPreviewHight;
    protected int mPreviewWidth;
    protected View mRootView;
    protected ImageView mSoundView;
    protected ImageView mSuccessView;
    protected SurfaceHolder mSurfaceHolder;
    protected SurfaceView mSurfaceView;
    protected Drawable mTipsIcon;
    protected TextView mTipsTopView;
    public View mViewBg;
    protected BroadcastReceiver mVolumeReceiver;
    private Rect mPreviewRect = new Rect();
    protected int mDisplayWidth = 0;
    protected int mDisplayHeight = 0;
    protected int mSurfaceWidth = 0;
    protected int mSurfaceHeight = 0;
    protected volatile boolean mIsEnableSound = true;
    protected HashMap<String, String> mBase64ImageMap = new HashMap<>();
    protected boolean mIsCreateSurface = false;
    protected volatile boolean mIsCompletion = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.baidu.idl.face.platform.ui.FaceDetectActivity$5  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum;

        static {
            int[] iArr = new int[FaceStatusNewEnum.values().length];
            $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum = iArr;
            try {
                iArr[FaceStatusNewEnum.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static Bitmap base64ToBitmap(String str) {
        byte[] decode = Base64Utils.decode(str, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int displayOrientation(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "window"
            java.lang.Object r4 = r4.getSystemService(r0)
            android.view.WindowManager r4 = (android.view.WindowManager) r4
            r0 = 90
            if (r4 != 0) goto Ld
            return r0
        Ld:
            android.view.Display r4 = r4.getDefaultDisplay()
            int r4 = r4.getRotation()
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L28
            if (r4 == r1) goto L29
            r0 = 2
            if (r4 == r0) goto L25
            r0 = 3
            if (r4 == r0) goto L22
            goto L28
        L22:
            r0 = 270(0x10e, float:3.78E-43)
            goto L29
        L25:
            r0 = 180(0xb4, float:2.52E-43)
            goto L29
        L28:
            r0 = 0
        L29:
            int r4 = 0 - r0
            int r4 = r4 + 360
            int r4 = r4 % 360
            boolean r2 = com.baidu.idl.face.platform.utils.APIUtils.hasGingerbread()
            if (r2 == 0) goto L54
            android.hardware.Camera$CameraInfo r4 = new android.hardware.Camera$CameraInfo
            r4.<init>()
            int r2 = r3.mCameraId
            android.hardware.Camera.getCameraInfo(r2, r4)
            int r2 = r4.facing
            if (r2 != r1) goto L4d
            int r4 = r4.orientation
            int r4 = r4 + r0
            int r4 = r4 % 360
            int r4 = 360 - r4
            int r4 = r4 % 360
            goto L54
        L4d:
            int r4 = r4.orientation
            int r4 = r4 - r0
            int r4 = r4 + 360
            int r4 = r4 % 360
        L54:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.ui.FaceDetectActivity.displayOrientation(android.content.Context):int");
    }

    private void onRefreshView(FaceStatusNewEnum faceStatusNewEnum, String str) {
        int i4 = AnonymousClass5.$SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[faceStatusNewEnum.ordinal()];
        if (i4 == 1) {
            this.mFaceDetectRoundView.setTipTopText(str);
        } else if (i4 != 2 && i4 != 3 && i4 != 4 && i4 != 5) {
            this.mFaceDetectRoundView.setTipTopText(str);
        } else {
            this.mFaceDetectRoundView.setTipTopText(str);
        }
    }

    private Camera open() {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            return null;
        }
        int i4 = 0;
        while (i4 < numberOfCameras) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i4, cameraInfo);
            if (cameraInfo.facing == 1) {
                break;
            }
            i4++;
        }
        if (i4 < numberOfCameras) {
            Camera open = Camera.open(i4);
            this.mCameraId = i4;
            return open;
        }
        Camera open2 = Camera.open(0);
        this.mCameraId = 0;
        return open2;
    }

    private void saveAllImage(HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        if (hashMap != null && hashMap.size() > 0) {
            ArrayList arrayList = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.idl.face.platform.ui.FaceDetectActivity.3
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, ImageInfo> entry, Map.Entry<String, ImageInfo> entry2) {
                    return Float.valueOf(entry2.getKey().split("_")[2]).compareTo(Float.valueOf(entry.getKey().split("_")[2]));
                }
            });
            setImageView1(arrayList);
        }
        if (hashMap2 == null || hashMap2.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(hashMap2.entrySet());
        Collections.sort(arrayList2, new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.idl.face.platform.ui.FaceDetectActivity.4
            @Override // java.util.Comparator
            public int compare(Map.Entry<String, ImageInfo> entry, Map.Entry<String, ImageInfo> entry2) {
                return Float.valueOf(entry2.getKey().split("_")[2]).compareTo(Float.valueOf(entry.getKey().split("_")[2]));
            }
        });
        setImageView2(arrayList2);
    }

    private void setImageView1(List<Map.Entry<String, ImageInfo>> list) {
        this.mImageLayout.removeAllViews();
        for (Map.Entry<String, ImageInfo> entry : list) {
            Bitmap base64ToBitmap = base64ToBitmap(entry.getValue().getBase64());
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(base64ToBitmap);
            this.mImageLayout.addView(imageView, new LinearLayout.LayoutParams(300, 300));
        }
    }

    private void setImageView2(List<Map.Entry<String, ImageInfo>> list) {
        this.mImageLayout2.removeAllViews();
        for (Map.Entry<String, ImageInfo> entry : list) {
            Bitmap base64ToBitmap = base64ToBitmap(entry.getValue().getBase64());
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(base64ToBitmap);
            this.mImageLayout2.addView(imageView, new LinearLayout.LayoutParams(300, 300));
        }
    }

    private void setScreenBright() {
        BrightnessUtils.setBrightness(this, BrightnessUtils.getScreenBrightness(this) + 100);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setScreenBright();
        getWindow().addFlags(128);
        setContentView(R.layout.activity_face_detect_v3100);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mDisplayWidth = displayMetrics.widthPixels;
        this.mDisplayHeight = displayMetrics.heightPixels;
        FaceSDKResSettings.initializeResId();
        this.mFaceConfig = FaceSDKManager.getInstance().getFaceConfig();
        this.mIsEnableSound = ((AudioManager) getSystemService("audio")).getStreamVolume(3) > 0 ? this.mFaceConfig.isSound() : false;
        View findViewById = findViewById(R.id.detect_root_layout);
        this.mRootView = findViewById;
        this.mFrameLayout = (FrameLayout) findViewById.findViewById(R.id.detect_surface_layout);
        SurfaceView surfaceView = new SurfaceView(this);
        this.mSurfaceView = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.mSurfaceHolder = holder;
        holder.setSizeFromLayout();
        this.mSurfaceHolder.addCallback(this);
        this.mSurfaceHolder.setType(3);
        float f4 = this.mDisplayWidth * 0.75f * 0.9f;
        this.mSurfaceView.setLayoutParams(new FrameLayout.LayoutParams((int) f4, (int) ((f4 * 640.0f) / 480.0f), 17));
        this.mFrameLayout.addView(this.mSurfaceView);
        View view = this.mRootView;
        int i4 = R.id.detect_close;
        view.findViewById(i4).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.idl.face.platform.ui.FaceDetectActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FaceDetectActivity.this.onBackPressed();
            }
        });
        FaceDetectRoundView faceDetectRoundView = (FaceDetectRoundView) this.mRootView.findViewById(R.id.detect_face_round);
        this.mFaceDetectRoundView = faceDetectRoundView;
        faceDetectRoundView.setIsActiveLive(false);
        this.mCloseView = (ImageView) this.mRootView.findViewById(i4);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.detect_sound);
        this.mSoundView = imageView;
        imageView.setImageResource(this.mIsEnableSound ? R.mipmap.icon_titlebar_voice2 : R.drawable.collect_image_voice_selector);
        this.mSoundView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.idl.face.platform.ui.FaceDetectActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FaceDetectActivity faceDetectActivity = FaceDetectActivity.this;
                faceDetectActivity.mIsEnableSound = !faceDetectActivity.mIsEnableSound;
                FaceDetectActivity faceDetectActivity2 = FaceDetectActivity.this;
                faceDetectActivity2.mSoundView.setImageResource(faceDetectActivity2.mIsEnableSound ? R.mipmap.icon_titlebar_voice2 : R.drawable.collect_image_voice_selector);
                FaceDetectActivity faceDetectActivity3 = FaceDetectActivity.this;
                IDetectStrategy iDetectStrategy = faceDetectActivity3.mIDetectStrategy;
                if (iDetectStrategy != null) {
                    iDetectStrategy.setDetectStrategySoundEnable(faceDetectActivity3.mIsEnableSound);
                }
            }
        });
        this.mTipsTopView = (TextView) this.mRootView.findViewById(R.id.detect_top_tips);
        this.mSuccessView = (ImageView) this.mRootView.findViewById(R.id.detect_success_image);
        this.mImageLayout = (LinearLayout) this.mRootView.findViewById(R.id.detect_result_image_layout);
        this.mImageLayout2 = (LinearLayout) this.mRootView.findViewById(R.id.detect_result_image_layout2);
        this.mViewBg = findViewById(R.id.view_bg);
        HashMap<String, String> hashMap = this.mBase64ImageMap;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void onDetectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        if (this.mIsCompletion) {
            return;
        }
        onRefreshView(faceStatusNewEnum, str);
        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
            this.mIsCompletion = true;
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i4, Camera camera) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IDetectStrategy iDetectStrategy = this.mIDetectStrategy;
        if (iDetectStrategy != null) {
            iDetectStrategy.reset();
        }
        super.onPause();
        VolumeUtils.unRegisterVolumeReceiver(this, this.mVolumeReceiver);
        this.mVolumeReceiver = null;
        this.mIsCompletion = false;
        stopPreview();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        FaceDetectRoundView faceDetectRoundView;
        if (this.mIsCompletion) {
            return;
        }
        if (this.mIDetectStrategy == null && (faceDetectRoundView = this.mFaceDetectRoundView) != null && faceDetectRoundView.getRound() > 0.0f) {
            IDetectStrategy detectStrategyModule = FaceSDKManager.getInstance().getDetectStrategyModule();
            this.mIDetectStrategy = detectStrategyModule;
            detectStrategyModule.setPreviewDegree(this.mPreviewDegree);
            this.mIDetectStrategy.setDetectStrategySoundEnable(this.mIsEnableSound);
            this.mIDetectStrategy.setDetectStrategyConfig(this.mPreviewRect, FaceDetectRoundView.getPreviewDetectRect(this.mDisplayWidth, this.mPreviewHight, this.mPreviewWidth), this);
        }
        IDetectStrategy iDetectStrategy = this.mIDetectStrategy;
        if (iDetectStrategy != null) {
            iDetectStrategy.detectStrategy(bArr);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mHasShownTimeoutDialog) {
            return;
        }
        setVolumeControlStream(3);
        this.mVolumeReceiver = VolumeUtils.registerVolumeReceiver(this, this);
        FaceDetectRoundView faceDetectRoundView = this.mFaceDetectRoundView;
        if (faceDetectRoundView != null) {
            faceDetectRoundView.setTipTopText("\u8bf7\u5c06\u8138\u79fb\u5165\u53d6\u666f\u6846");
        }
        startPreview();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    protected void startPreview() {
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView != null && surfaceView.getHolder() != null) {
            SurfaceHolder holder = this.mSurfaceView.getHolder();
            this.mSurfaceHolder = holder;
            holder.addCallback(this);
        }
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.mCamera.stopPreview();
                this.mCamera.release();
                this.mCamera = null;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (this.mCamera == null) {
            try {
                this.mCamera = open();
            } catch (RuntimeException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        Camera camera2 = this.mCamera;
        if (camera2 == null) {
            return;
        }
        if (this.mCameraParam == null) {
            this.mCameraParam = camera2.getParameters();
        }
        this.mCameraParam.setPictureFormat(256);
        int displayOrientation = displayOrientation(this);
        this.mCamera.setDisplayOrientation(displayOrientation);
        this.mCameraParam.set("rotation", displayOrientation);
        this.mPreviewDegree = displayOrientation;
        IDetectStrategy iDetectStrategy = this.mIDetectStrategy;
        if (iDetectStrategy != null) {
            iDetectStrategy.setPreviewDegree(displayOrientation);
        }
        Point bestPreview = CameraPreviewUtils.getBestPreview(this.mCameraParam, new Point(640, 480));
        int i4 = bestPreview.x;
        this.mPreviewWidth = i4;
        int i5 = bestPreview.y;
        this.mPreviewHight = i5;
        this.mPreviewRect.set(0, 0, i5, i4);
        this.mCameraParam.setPreviewSize(this.mPreviewWidth, this.mPreviewHight);
        this.mCamera.setParameters(this.mCameraParam);
        try {
            this.mCamera.setPreviewDisplay(this.mSurfaceHolder);
            this.mCamera.stopPreview();
            this.mCamera.setErrorCallback(this);
            this.mCamera.setPreviewCallback(this);
            this.mCamera.startPreview();
        } catch (RuntimeException e7) {
            e7.printStackTrace();
            CameraUtils.releaseCamera(this.mCamera);
            this.mCamera = null;
        } catch (Exception e8) {
            e8.printStackTrace();
            CameraUtils.releaseCamera(this.mCamera);
            this.mCamera = null;
        }
    }

    protected void stopPreview() {
        Camera camera = this.mCamera;
        try {
            if (camera != null) {
                try {
                    try {
                        camera.setErrorCallback(null);
                        this.mCamera.setPreviewCallback(null);
                        this.mCamera.stopPreview();
                    } catch (RuntimeException e4) {
                        e4.printStackTrace();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this);
            }
            IDetectStrategy iDetectStrategy = this.mIDetectStrategy;
            if (iDetectStrategy != null) {
                iDetectStrategy.reset();
                this.mIDetectStrategy = null;
            }
        } finally {
            CameraUtils.releaseCamera(this.mCamera);
            this.mCamera = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        this.mSurfaceWidth = i5;
        this.mSurfaceHeight = i6;
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        startPreview();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mIsCreateSurface = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mIsCreateSurface = false;
    }

    @Override // com.baidu.idl.face.platform.ui.utils.VolumeUtils.VolumeCallback
    public void volumeChanged() {
        try {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (audioManager != null) {
                this.mIsEnableSound = audioManager.getStreamVolume(3) > 0;
                this.mSoundView.setImageResource(this.mIsEnableSound ? R.mipmap.icon_titlebar_voice2 : R.mipmap.icon_titlebar_voice1);
                IDetectStrategy iDetectStrategy = this.mIDetectStrategy;
                if (iDetectStrategy != null) {
                    iDetectStrategy.setDetectStrategySoundEnable(this.mIsEnableSound);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
