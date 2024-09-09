package com.bxkj.student.v2.ui.my;

import android.graphics.BitmapFactory;
import android.view.View;
import com.bxkj.base.util.u;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.databinding.V2DialogQrCodeBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FullScreenCodeActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/bxkj/student/v2/ui/my/FullScreenCodeActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2DialogQrCodeBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "E", "p", "", "i", "I", "type", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class FullScreenCodeActivity extends BaseActivity<V2DialogQrCodeBinding, BaseViewModel> {

    /* renamed from: i  reason: collision with root package name */
    private int f23931i = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FullScreenCodeActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.finish();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        if (getIntent().hasExtra("type")) {
            this.f23931i = getIntent().getIntExtra("type", 1);
        }
        if (this.f23931i == 1) {
            M().iv.setImageBitmap(u.f(com.bxkj.base.v2.data.a.b.a().u(), cn.bluemobi.dylan.base.utils.u.a(320.0f, C()), BitmapFactory.decodeResource(getResources(), 2131558617)));
            return;
        }
        M().iv.setImageBitmap(u.g(com.bxkj.base.v2.data.a.b.a().u(), cn.bluemobi.dylan.base.utils.u.a(700.0f, C()), cn.bluemobi.dylan.base.utils.u.a(150.0f, C())));
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        M().root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FullScreenCodeActivity.d(FullScreenCodeActivity.this, view);
            }
        });
    }
}
