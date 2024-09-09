package com.bxkj.student.splash;

import android.content.Intent;
import android.view.View;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.App;
import com.bxkj.student.databinding.AcFacePrivacyAgreementBinding;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class OpenPrivacyAgreementActivity extends BaseActivity<AcFacePrivacyAgreementBinding, BaseViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        startActivity(new Intent(this.f18451c, H5DetailActivity.class).putExtra("title", "\u7528\u6237\u534f\u8bae").putExtra("url", "https://www.boxkj.com/resources/user_agreement_info.html"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(View view) {
        startActivity(new Intent(this.f18451c, H5DetailActivity.class).putExtra("title", "\u9690\u79c1\u653f\u7b56").putExtra("url", "https://www.boxkj.com/resources/user_agreement.html"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        N();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        ((AcFacePrivacyAgreementBinding) this.f18453e).setMActivity(this);
        ((AcFacePrivacyAgreementBinding) this.f18453e).tvUserAgree.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.this.O(view);
            }
        });
        ((AcFacePrivacyAgreementBinding) this.f18453e).tvUserPrivate.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.this.P(view);
            }
        });
        S();
    }

    protected void N() {
        App.n().l();
        LoginUser.getLoginUser().setAgreement(true);
        startActivity(new Intent(this.f18451c, SplashActivity.class));
        finish();
    }

    protected void S() {
        ((AcFacePrivacyAgreementBinding) this.f18453e).btRefuse.setVisibility(0);
        ((AcFacePrivacyAgreementBinding) this.f18453e).btAgree.setVisibility(0);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        ((AcFacePrivacyAgreementBinding) this.f18453e).btRefuse.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.this.Q(view);
            }
        });
        ((AcFacePrivacyAgreementBinding) this.f18453e).btAgree.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.this.R(view);
            }
        });
    }
}
