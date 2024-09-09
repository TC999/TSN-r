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
import com.baidu.idl.face.platform.ui.BaseFaceDetectActivity;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.orhanobut.logger.j;
import com.stub.StubApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class FaceDetectExpActivity extends BaseFaceDetectActivity {

    /* renamed from: d  reason: collision with root package name */
    public static final int f22351d = 187;

    /* renamed from: e  reason: collision with root package name */
    public static final int f22352e = 170;

    /* renamed from: a  reason: collision with root package name */
    protected Context f22353a;

    /* renamed from: b  reason: collision with root package name */
    private String f22354b = "";

    /* renamed from: c  reason: collision with root package name */
    private boolean f22355c = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements IInitCallback {
        a() {
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initFailure(int i4, String s3) {
            j.e("FaceSDKManager\u521d\u59cb\u5316\u5931\u8d25i=" + i4 + "s=" + s3, new Object[0]);
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initSuccess() {
            j.c("FaceSDKManager\u521d\u59cb\u5316\u6210\u529f");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            FaceDetectExpActivity.this.O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(View view) {
            FaceDetectExpActivity.this.O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(View view) {
            FaceDetectExpActivity.this.O();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(FaceDetectExpActivity.this.f22353a).setMessage("\u4eba\u8138\u8bc6\u522b\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u518d\u8bd5").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExpActivity.b.this.d(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(FaceDetectExpActivity.this.f22353a).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExpActivity.b.this.e(view);
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
            new iOSOneButtonDialog(FaceDetectExpActivity.this.f22353a).setMessage(errorMessage).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExpActivity.b.this.f(view);
                }
            }).show();
        }
    }

    static {
        StubApp.interface11(11921);
    }

    private void N() {
        if (FaceSDKManager.getInstance().getInitFlag()) {
            return;
        }
        FaceSDKManager.getInstance().initialize(this, com.bxkj.student.run.app.face.a.f22358a, com.bxkj.student.run.app.face.a.f22359b, new a());
    }

    private void Q(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = brightness;
        window.setAttributes(attributes);
    }

    protected void O() {
        setResult(170, getIntent());
        finish();
    }

    public File P(Context context, Bitmap bmp) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (bmp != null && !bmp.isRecycled()) {
            j.c("bmp.getWidth()=" + bmp.getWidth() + "bmp.getHeight()" + bmp.getHeight());
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
                File file2 = new File(file, "avatar" + System.currentTimeMillis() + ".png");
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

    protected void d(String base64ImageMap) {
        File P = P(this.f22353a, base64ToBitmap(base64ImageMap));
        HttpRequest hideOtherStatusMessage = Http.with(this.f22353a).hideOtherStatusMessage();
        if (!this.f22355c) {
            hideOtherStatusMessage.hideSuccessMessage();
        }
        hideOtherStatusMessage.setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).h(RequestParameter.getRequestBody(LoginUser.getLoginUser().getUserId()), RequestParameter.getRequestBody(this.f22354b), RequestParameter.getFilePart("file", P))).setDataListener(new b());
    }

    @Override // com.baidu.idl.face.platform.ui.FaceDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Q(this, -1.0f);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.idl.face.platform.ui.BaseFaceDetectActivity
    public void onFace(String bmpStr) {
        super.onFace(bmpStr);
        d(bmpStr);
    }
}
