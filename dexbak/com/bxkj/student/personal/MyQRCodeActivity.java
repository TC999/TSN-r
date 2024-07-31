package com.bxkj.student.personal;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.QRCode;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyQRCodeActivity extends BaseActivity {

    /* renamed from: k */
    private ImageView f18719k;

    /* renamed from: l */
    private ImageView f18720l;

    /* renamed from: i0 */
    private void m40573i0(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = brightness;
        window.setAttributes(attributes);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_my_qrcode;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m40573i0(this, 1.0f);
        this.f18719k.setImageBitmap(QRCode.m44024f(LoginUser.getLoginUser().getAccount(), Tools.m57620a(260.0f, this.f1669h), BitmapFactory.decodeResource(getResources(), 2131558617)));
        this.f18720l.setImageBitmap(QRCode.m44029a(LoginUser.getLoginUser().getAccount(), Tools.m57620a(320.0f, this.f1669h), Tools.m57620a(80.0f, this.f1669h)));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的二维码");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18719k = (ImageView) findViewById(C4215R.C4219id.iv_qrcode);
        this.f18720l = (ImageView) findViewById(C4215R.C4219id.iv_code);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m40573i0(this, -1.0f);
        super.onDestroy();
    }
}
