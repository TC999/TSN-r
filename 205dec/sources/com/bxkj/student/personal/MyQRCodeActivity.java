package com.bxkj.student.personal;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.u;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyQRCodeActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private ImageView f22019k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f22020l;

    private void i0(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = brightness;
        window.setAttributes(attributes);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427441;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        i0(this, 1.0f);
        this.f22019k.setImageBitmap(u.f(LoginUser.getLoginUser().getAccount(), cn.bluemobi.dylan.base.utils.u.a(260.0f, this.f1656h), BitmapFactory.decodeResource(getResources(), 2131558617)));
        this.f22020l.setImageBitmap(u.a(LoginUser.getLoginUser().getAccount(), cn.bluemobi.dylan.base.utils.u.a(320.0f, this.f1656h), cn.bluemobi.dylan.base.utils.u.a(80.0f, this.f1656h)));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u4e8c\u7ef4\u7801");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22019k = (ImageView) findViewById(2131231476);
        this.f22020l = (ImageView) findViewById(2131231400);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        i0(this, -1.0f);
        super.onDestroy();
    }
}
