package com.bxkj.student.splash;

import android.content.Intent;
import android.view.View;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.App;
import com.bxkj.student.databinding.AcFacePrivacyAgreementBinding;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OpenPrivacyAgreementActivity extends BaseActivity<AcFacePrivacyAgreementBinding, BaseViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public /* synthetic */ void m39432O(View view) {
        startActivity(new Intent(this.f14967c, H5DetailActivity.class).putExtra("title", "用户协议").putExtra("url", "https://www.boxkj.com/resources/user_agreement_info.html"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void m39431P(View view) {
        startActivity(new Intent(this.f14967c, H5DetailActivity.class).putExtra("title", "隐私政策").putExtra("url", "https://www.boxkj.com/resources/user_agreement.html"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public /* synthetic */ void m39430Q(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ void m39429R(View view) {
        m39433N();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        ((AcFacePrivacyAgreementBinding) this.f14969e).setMActivity(this);
        ((AcFacePrivacyAgreementBinding) this.f14969e).tvUserAgree.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.this.m39432O(view);
            }
        });
        ((AcFacePrivacyAgreementBinding) this.f14969e).tvUserPrivate.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.this.m39431P(view);
            }
        });
        m39428S();
    }

    /* renamed from: N */
    protected void m39433N() {
        App.m43006n().m43008l();
        LoginUser.getLoginUser().setAgreement(true);
        startActivity(new Intent(this.f14967c, SplashActivity.class));
        finish();
    }

    /* renamed from: S */
    protected void m39428S() {
        ((AcFacePrivacyAgreementBinding) this.f14969e).btRefuse.setVisibility(0);
        ((AcFacePrivacyAgreementBinding) this.f14969e).btAgree.setVisibility(0);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        ((AcFacePrivacyAgreementBinding) this.f14969e).btRefuse.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.this.m39430Q(view);
            }
        });
        ((AcFacePrivacyAgreementBinding) this.f14969e).btAgree.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenPrivacyAgreementActivity.this.m39429R(view);
            }
        });
    }
}
