package com.bxkj.student.run.app.face.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.RequestParameter;
import com.baidu.idl.face.platform.ui.BaseFaceLivenessActivity;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.run.app.face.widget.FaceDetect5ExpActivity;
import com.bxkj.student.run.app.face.widget.a;
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
public class FaceDetect5ExpActivity extends BaseFaceLivenessActivity {

    /* renamed from: a  reason: collision with root package name */
    private Context f22364a;

    /* renamed from: b  reason: collision with root package name */
    private com.bxkj.student.run.app.face.widget.a f22365b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            FaceDetect5ExpActivity.this.N();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            FaceDetect5ExpActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            new iOSOneButtonDialog(FaceDetect5ExpActivity.this.f22364a).setMessage("\u4e0a\u4f20\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u518d\u8bd5").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetect5ExpActivity.a.this.c(view);
                }
            }).show();
            super.netOnFailure(ex);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            LoginUser.getLoginUser().getBitmapList().clear();
            super.netOnFinish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(FaceDetect5ExpActivity.this.f22364a).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            new iOSOneButtonDialog(FaceDetect5ExpActivity.this.f22364a).setMessage("\u4e0a\u4f20\u6210\u529f").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetect5ExpActivity.a.this.d(view);
                }
            }).show();
        }
    }

    static {
        StubApp.interface11(11927);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        int size = LoginUser.getLoginUser().getBitmapList().size();
        String[] strArr = new String[size];
        for (int i4 = 0; i4 < LoginUser.getLoginUser().getBitmapList().size(); i4++) {
            strArr[i4] = com.bxkj.base.util.c.a(LoginUser.getLoginUser().getBitmapList().get(i4));
        }
        if (size <= 0) {
            startActivity(new Intent(this.f22364a, FaceDetect5ExpActivity.class));
            finish();
            return;
        }
        Http.with(this.f22364a).setObservable(((w.a) Http.getApiService(w.a.class)).x1(RequestParameter.getRequestBody(LoginUser.getLoginUser().getUserId()), RequestParameter.getRequestBody(i(this.f22364a, base64ToBitmap(strArr[0]))))).setDataListener(new a());
    }

    private Bitmap base64ToBitmap(String base64Data) {
        byte[] decode = Base64Utils.decode(base64Data, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        N();
    }

    private void j(String title, String message, String base64ImageMap) {
        if (this.f22365b == null) {
            a.C0278a c0278a = new a.C0278a(this);
            a.C0278a d4 = c0278a.h(title).d(message);
            d4.f("\u672c\u6b21\u9700\u8981\u91c7\u96c61\u5f20\uff0c\u8bf7\u91c7\u96c6\u7b2c" + (LoginUser.getLoginUser().getBitmapList().size() + 1) + "\u5f20", new DialogInterface.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    dialogInterface.dismiss();
                }
            });
            com.bxkj.student.run.app.face.widget.a b4 = c0278a.b();
            this.f22365b = b4;
            b4.setCancelable(true);
        }
        this.f22365b.dismiss();
        this.f22365b.show();
    }

    public File i(Context context, Bitmap bmp) {
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
                File file2 = new File(file, "avatar" + System.currentTimeMillis() + ".jpg");
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (FileNotFoundException unused) {
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bmp.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    @Override // com.baidu.idl.face.platform.ui.FaceLivenessActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.idl.face.platform.ui.BaseFaceLivenessActivity
    public void onFace(String bmpStr) {
        super.onFace(bmpStr);
        LoginUser.getLoginUser().getBitmapList().add(base64ToBitmap(bmpStr));
        this.mImageLayout.removeAllViews();
        for (Bitmap bitmap : LoginUser.getLoginUser().getBitmapList()) {
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(bitmap);
            this.mImageLayout.addView(imageView, new LinearLayout.LayoutParams(300, 300));
        }
        if (LoginUser.getLoginUser().getBitmapList().size() < 1) {
            startActivity(new Intent(this.f22364a, FaceDetect5ExpActivity.class));
            finish();
            return;
        }
        new iOSOneButtonDialog(this.f22364a).setMessage("\u91c7\u96c6\u6210\u529f,\u70b9\u51fb\u786e\u5b9a\u5f00\u59cb\u4e0a\u4f20").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceDetect5ExpActivity.this.g(view);
            }
        }).show();
    }
}
