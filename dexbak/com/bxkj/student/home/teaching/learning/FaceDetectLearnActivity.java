package com.bxkj.student.home.teaching.learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.bxkj.student.home.teaching.learning.FaceDetectLearnActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FaceDetectLearnActivity extends FaceDetectExpActivity {

    /* renamed from: f */
    private int f17158f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.FaceDetectLearnActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4580a extends HttpCallBack {
        C4580a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m41972c(View view) {
            FaceDetectLearnActivity.this.mo40051O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m41971d(View view) {
            FaceDetectLearnActivity.this.mo40051O();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((FaceDetectExpActivity) FaceDetectLearnActivity.this).f19107a).setMessage("人脸识别失败，请重新再试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectLearnActivity.C4580a.this.m41972c(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((FaceDetectExpActivity) FaceDetectLearnActivity.this).f19107a).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectLearnActivity.C4580a.this.m41971d(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Intent intent = new Intent(((FaceDetectExpActivity) FaceDetectLearnActivity.this).f19107a, ExamActivity.class);
            intent.putExtra("faceIndex", FaceDetectLearnActivity.this.f17158f);
            C11792j.m20470c("setResult-faceIndex=" + FaceDetectLearnActivity.this.f17158f);
            FaceDetectLearnActivity.this.setResult(187, intent);
            FaceDetectLearnActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(11140);
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity
    /* renamed from: O */
    protected void mo40051O() {
        Intent intent = new Intent();
        intent.putExtra("faceIndex", this.f17158f);
        setResult(170, intent);
        finish();
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity
    /* renamed from: d */
    protected void mo40048d(String base64ImageMap) {
        Http.with(this.f19107a).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m168H(base64ImageMap, LoginUser.getLoginUser().getAccount())).setDataListener(new C4580a());
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity, com.baidu.idl.face.platform.p049ui.FaceDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);
}
