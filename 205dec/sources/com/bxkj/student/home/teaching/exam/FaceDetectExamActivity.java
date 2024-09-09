package com.bxkj.student.home.teaching.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.exam.FaceDetectExamActivity;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.orhanobut.logger.j;
import com.stub.StubApp;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class FaceDetectExamActivity extends FaceDetectExpActivity {

    /* renamed from: f  reason: collision with root package name */
    private int f20116f = 0;

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
            FaceDetectExamActivity.this.O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            FaceDetectExamActivity.this.O();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((FaceDetectExpActivity) FaceDetectExamActivity.this).f22353a).setMessage("\u4eba\u8138\u8bc6\u522b\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u518d\u8bd5").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExamActivity.a.this.c(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((FaceDetectExpActivity) FaceDetectExamActivity.this).f22353a).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExamActivity.a.this.d(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Intent intent = new Intent(((FaceDetectExpActivity) FaceDetectExamActivity.this).f22353a, ExamActivity.class);
            intent.putExtra("faceIndex", FaceDetectExamActivity.this.f20116f);
            j.c("setResult-faceIndex=" + FaceDetectExamActivity.this.f20116f);
            FaceDetectExamActivity.this.setResult(187, intent);
            FaceDetectExamActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(10983);
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity
    protected void O() {
        Intent intent = new Intent(this.f22353a, ExamActivity.class);
        intent.putExtra("faceIndex", this.f20116f);
        setResult(170, intent);
        finish();
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity
    protected void d(String base64ImageMap) {
        Http.with(this.f22353a).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).H(base64ImageMap, LoginUser.getLoginUser().getAccount())).setDataListener(new a());
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity, com.baidu.idl.face.platform.ui.FaceDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);
}
