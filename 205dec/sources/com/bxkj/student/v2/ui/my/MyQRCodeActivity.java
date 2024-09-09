package com.bxkj.student.v2.ui.my;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bxkj.base.util.u;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.databinding.V2MyQrcodeBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MyQRCodeActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/bxkj/student/v2/ui/my/MyQRCodeActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2MyQrcodeBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Landroid/app/Activity;", "activity", "", "brightness", "Lkotlin/f1;", "g", "E", "p", "onDestroy", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class MyQRCodeActivity extends BaseActivity<V2MyQrcodeBinding, BaseViewModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MyQRCodeActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.C(), FullScreenCodeActivity.class).putExtra("type", 1));
        this$0.overridePendingTransition(2130772068, 2130772069);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MyQRCodeActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.C(), FullScreenCodeActivity.class).putExtra("type", 2));
        this$0.overridePendingTransition(2130771995, 2130772069);
    }

    private final void g(Activity activity, float f4) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f4;
        window.setAttributes(attributes);
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        if ((getIntent().hasExtra("title") ? this : null) != null) {
            M().setTitle(getIntent().getStringExtra("title"));
        }
        M().setBackEvent(this);
        g(this, 1.0f);
        TextView textView = M().tvName;
        a.b bVar = com.bxkj.base.v2.data.a.b;
        textView.setText(bVar.a().u());
        M().ivCode.setImageBitmap(u.f(bVar.a().u(), cn.bluemobi.dylan.base.utils.u.a(260.0f, C()), BitmapFactory.decodeResource(getResources(), 2131558617)));
        M().ivBar.setImageBitmap(u.a(bVar.a().u(), cn.bluemobi.dylan.base.utils.u.a(320.0f, C()), cn.bluemobi.dylan.base.utils.u.a(80.0f, C())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        g(this, -1.0f);
        super.onDestroy();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        M().ivCode.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyQRCodeActivity.e(MyQRCodeActivity.this, view);
            }
        });
        M().ivBar.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyQRCodeActivity.f(MyQRCodeActivity.this, view);
            }
        });
    }
}
