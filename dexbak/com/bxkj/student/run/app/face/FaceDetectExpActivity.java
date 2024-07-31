package com.bxkj.student.run.app.face;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import cn.bluemobi.dylan.http.RequestParameter;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.baidu.idl.face.platform.p049ui.BaseFaceDetectActivity;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.run.app.RunApiService;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FaceDetectExpActivity extends BaseFaceDetectActivity {

    /* renamed from: d */
    public static final int f19105d = 187;

    /* renamed from: e */
    public static final int f19106e = 170;

    /* renamed from: a */
    protected Context f19107a;

    /* renamed from: b */
    private String f19108b = "";

    /* renamed from: c */
    private boolean f19109c = true;

    /* renamed from: com.bxkj.student.run.app.face.FaceDetectExpActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5230a implements IInitCallback {
        C5230a() {
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initFailure(int i, String s) {
            C11792j.m20468e("FaceSDKManager初始化失败i=" + i + "s=" + s, new Object[0]);
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initSuccess() {
            C11792j.m20470c("FaceSDKManager初始化成功");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.face.FaceDetectExpActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5231b extends HttpCallBack {
        C5231b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m40044d(View view) {
            FaceDetectExpActivity.this.mo40051O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void m40043e(View view) {
            FaceDetectExpActivity.this.mo40051O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void m40042f(View view) {
            FaceDetectExpActivity.this.mo40051O();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(FaceDetectExpActivity.this.f19107a).setMessage("人脸识别失败，请重新再试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExpActivity.C5231b.this.m40044d(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(FaceDetectExpActivity.this.f19107a).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExpActivity.C5231b.this.m40043e(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FaceDetectExpActivity.this.setResult(-1);
            FaceDetectExpActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccessServerError(int code, String errorMessage) {
            new iOSOneButtonDialog(FaceDetectExpActivity.this.f19107a).setMessage(errorMessage).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExpActivity.C5231b.this.m40042f(view);
                }
            }).show();
        }
    }

    static {
        StubApp.interface11(11921);
    }

    /* renamed from: N */
    private void m40052N() {
        if (FaceSDKManager.getInstance().getInitFlag()) {
            return;
        }
        FaceSDKManager.getInstance().initialize(this, C5232a.f19112a, C5232a.f19113b, new C5230a());
    }

    /* renamed from: Q */
    private void m40049Q(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = brightness;
        window.setAttributes(attributes);
    }

    /* renamed from: O */
    protected void mo40051O() {
        setResult(170, getIntent());
        finish();
    }

    /* renamed from: P */
    public File m40050P(Context context, Bitmap bmp) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (bmp != null && !bmp.isRecycled()) {
            C11792j.m20470c("bmp.getWidth()=" + bmp.getWidth() + "bmp.getHeight()" + bmp.getHeight());
            File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
            if (externalCacheDir == null || !externalCacheDir.exists()) {
                externalCacheDir = context.getCacheDir();
            }
            File file = new File(externalCacheDir, "avatar");
            boolean exists = file.exists();
            if (!exists) {
                exists = file.mkdirs();
            }
            if (exists) {
                File file2 = new File(file, "avatar" + System.currentTimeMillis() + PhotoBitmapUtils.f15141c);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (FileNotFoundException unused) {
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                    return file2;
                } catch (FileNotFoundException unused3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    protected Bitmap base64ToBitmap(String base64Data) {
        byte[] decode = Base64Utils.decode(base64Data, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    /* renamed from: d */
    protected void mo40048d(String base64ImageMap) {
        File m40050P = m40050P(this.f19107a, base64ToBitmap(base64ImageMap));
        HttpRequest hideOtherStatusMessage = Http.with(this.f19107a).hideOtherStatusMessage();
        if (!this.f19109c) {
            hideOtherStatusMessage.hideSuccessMessage();
        }
        hideOtherStatusMessage.setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40113h(RequestParameter.getRequestBody(LoginUser.getLoginUser().getUserId()), RequestParameter.getRequestBody(this.f19108b), RequestParameter.getFilePart(IDataSource.f43973c, m40050P))).setDataListener(new C5231b());
    }

    @Override // com.baidu.idl.face.platform.p049ui.FaceDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m40049Q(this, -1.0f);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.idl.face.platform.p049ui.BaseFaceDetectActivity
    public void onFace(String bmpStr) {
        super.onFace(bmpStr);
        mo40048d(bmpStr);
    }
}
