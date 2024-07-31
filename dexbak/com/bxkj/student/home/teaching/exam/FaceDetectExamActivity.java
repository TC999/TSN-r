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
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FaceDetectExamActivity extends FaceDetectExpActivity {

    /* renamed from: f */
    private int f16726f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.FaceDetectExamActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4448a extends HttpCallBack {
        C4448a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m42340c(View view) {
            FaceDetectExamActivity.this.mo40051O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m42339d(View view) {
            FaceDetectExamActivity.this.mo40051O();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((FaceDetectExpActivity) FaceDetectExamActivity.this).f19107a).setMessage("人脸识别失败，请重新再试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExamActivity.C4448a.this.m42340c(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((FaceDetectExpActivity) FaceDetectExamActivity.this).f19107a).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectExamActivity.C4448a.this.m42339d(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Intent intent = new Intent(((FaceDetectExpActivity) FaceDetectExamActivity.this).f19107a, ExamActivity.class);
            intent.putExtra("faceIndex", FaceDetectExamActivity.this.f16726f);
            C11792j.m20470c("setResult-faceIndex=" + FaceDetectExamActivity.this.f16726f);
            FaceDetectExamActivity.this.setResult(187, intent);
            FaceDetectExamActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(10983);
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity
    /* renamed from: O */
    protected void mo40051O() {
        Intent intent = new Intent(this.f19107a, ExamActivity.class);
        intent.putExtra("faceIndex", this.f16726f);
        setResult(170, intent);
        finish();
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity
    /* renamed from: d */
    protected void mo40048d(String base64ImageMap) {
        Http.with(this.f19107a).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m168H(base64ImageMap, LoginUser.getLoginUser().getAccount())).setDataListener(new C4448a());
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity, com.baidu.idl.face.platform.p049ui.FaceDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);
}
