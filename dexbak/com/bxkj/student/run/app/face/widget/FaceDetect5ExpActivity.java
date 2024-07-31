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
import com.baidu.idl.face.platform.p049ui.BaseFaceLivenessActivity;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.BitmapUtils;
import com.bxkj.student.run.app.face.widget.DefaultDialog;
import com.bxkj.student.run.app.face.widget.FaceDetect5ExpActivity;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FaceDetect5ExpActivity extends BaseFaceLivenessActivity {

    /* renamed from: a */
    private Context f19118a;

    /* renamed from: b */
    private DefaultDialog f19119b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.face.widget.FaceDetect5ExpActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5236a extends HttpCallBack {
        C5236a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m40030c(View view) {
            FaceDetect5ExpActivity.this.m40041N();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m40029d(View view) {
            FaceDetect5ExpActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            new iOSOneButtonDialog(FaceDetect5ExpActivity.this.f19118a).setMessage("上传失败，请重新再试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetect5ExpActivity.C5236a.this.m40030c(view);
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
            new iOSOneButtonDialog(FaceDetect5ExpActivity.this.f19118a).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            new iOSOneButtonDialog(FaceDetect5ExpActivity.this.f19118a).setMessage("上传成功").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetect5ExpActivity.C5236a.this.m40029d(view);
                }
            }).show();
        }
    }

    static {
        StubApp.interface11(11927);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m40041N() {
        int size = LoginUser.getLoginUser().getBitmapList().size();
        String[] strArr = new String[size];
        for (int i = 0; i < LoginUser.getLoginUser().getBitmapList().size(); i++) {
            strArr[i] = BitmapUtils.m44133a(LoginUser.getLoginUser().getBitmapList().get(i));
        }
        if (size <= 0) {
            startActivity(new Intent(this.f19118a, FaceDetect5ExpActivity.class));
            finish();
            return;
        }
        Http.with(this.f19118a).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m58x1(RequestParameter.getRequestBody(LoginUser.getLoginUser().getUserId()), RequestParameter.getRequestBody(m40034i(this.f19118a, base64ToBitmap(strArr[0]))))).setDataListener(new C5236a());
    }

    private Bitmap base64ToBitmap(String base64Data) {
        byte[] decode = Base64Utils.decode(base64Data, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m40036g(View view) {
        m40041N();
    }

    /* renamed from: j */
    private void m40033j(String title, String message, String base64ImageMap) {
        if (this.f19119b == null) {
            DefaultDialog.C5237a c5237a = new DefaultDialog.C5237a(this);
            DefaultDialog.C5237a m40025d = c5237a.m40021h(title).m40025d(message);
            m40025d.m40023f("本次需要采集1张，请采集第" + (LoginUser.getLoginUser().getBitmapList().size() + 1) + "张", new DialogInterface.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            DefaultDialog m40027b = c5237a.m40027b();
            this.f19119b = m40027b;
            m40027b.setCancelable(true);
        }
        this.f19119b.dismiss();
        this.f19119b.show();
    }

    /* renamed from: i */
    public File m40034i(Context context, Bitmap bmp) {
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

    @Override // com.baidu.idl.face.platform.p049ui.FaceLivenessActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.idl.face.platform.p049ui.BaseFaceLivenessActivity
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
            startActivity(new Intent(this.f19118a, FaceDetect5ExpActivity.class));
            finish();
            return;
        }
        new iOSOneButtonDialog(this.f19118a).setMessage("采集成功,点击确定开始上传").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.face.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceDetect5ExpActivity.this.m40036g(view);
            }
        }).show();
    }
}
