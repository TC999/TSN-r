package com.bxkj.student.p094v2.p098ui.p101my;

import android.graphics.BitmapFactory;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.util.QRCode;
import com.bxkj.student.databinding.V2DialogQrCodeBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;

/* compiled from: FullScreenCodeActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/my/FullScreenCodeActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2DialogQrCodeBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "", "i", "I", "type", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.my.FullScreenCodeActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FullScreenCodeActivity extends BaseActivity<V2DialogQrCodeBinding, BaseViewModel> {

    /* renamed from: i */
    private int f20534i = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static final void m38638d(FullScreenCodeActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.finish();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        if (getIntent().hasExtra("type")) {
            this.f20534i = getIntent().getIntExtra("type", 1);
        }
        if (this.f20534i == 1) {
            mo43920M().f16285iv.setImageBitmap(QRCode.m44024f(LoggedInUser.f15182b.m43634a().m43641u(), Tools.m57620a(320.0f, mo43926C()), BitmapFactory.decodeResource(getResources(), 2131558617)));
            return;
        }
        mo43920M().f16285iv.setImageBitmap(QRCode.m44023g(LoggedInUser.f15182b.m43634a().m43641u(), Tools.m57620a(700.0f, mo43926C()), Tools.m57620a(150.0f, mo43926C())));
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43920M().root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FullScreenCodeActivity.m38638d(FullScreenCodeActivity.this, view);
            }
        });
    }
}
