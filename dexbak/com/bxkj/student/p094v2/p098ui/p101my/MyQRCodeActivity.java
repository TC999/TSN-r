package com.bxkj.student.p094v2.p098ui.p101my;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.util.QRCode;
import com.bxkj.student.C4215R;
import com.bxkj.student.databinding.V2MyQrcodeBinding;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;

/* compiled from: MyQRCodeActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0014¨\u0006\u000f"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/my/MyQRCodeActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2MyQrcodeBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "", "brightness", "Lkotlin/f1;", "g", ExifInterface.LONGITUDE_EAST, "p", "onDestroy", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.my.MyQRCodeActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MyQRCodeActivity extends BaseActivity<V2MyQrcodeBinding, BaseViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static final void m38635e(MyQRCodeActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.mo43926C(), FullScreenCodeActivity.class).putExtra("type", 1));
        this$0.overridePendingTransition(C4215R.anim.qr_code_zoom_in, C4215R.anim.qr_code_zoom_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static final void m38634f(MyQRCodeActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.mo43926C(), FullScreenCodeActivity.class).putExtra("type", 2));
        this$0.overridePendingTransition(C4215R.anim.bar_code_zoom_in, C4215R.anim.qr_code_zoom_out);
    }

    /* renamed from: g */
    private final void m38633g(Activity activity, float f) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f;
        window.setAttributes(attributes);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        if ((getIntent().hasExtra("title") ? this : null) != null) {
            mo43920M().setTitle(getIntent().getStringExtra("title"));
        }
        mo43920M().setBackEvent(this);
        m38633g(this, 1.0f);
        TextView textView = mo43920M().tvName;
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        textView.setText(c3984b.m43634a().m43641u());
        mo43920M().ivCode.setImageBitmap(QRCode.m44024f(c3984b.m43634a().m43641u(), Tools.m57620a(260.0f, mo43926C()), BitmapFactory.decodeResource(getResources(), 2131558617)));
        mo43920M().ivBar.setImageBitmap(QRCode.m44029a(c3984b.m43634a().m43641u(), Tools.m57620a(320.0f, mo43926C()), Tools.m57620a(80.0f, mo43926C())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m38633g(this, -1.0f);
        super.onDestroy();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43920M().ivCode.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyQRCodeActivity.m38635e(MyQRCodeActivity.this, view);
            }
        });
        mo43920M().ivBar.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyQRCodeActivity.m38634f(MyQRCodeActivity.this, view);
            }
        });
    }
}
