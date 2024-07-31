package com.bxkj.student.p094v2.p098ui.p101my;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.beizi.fusion.BeiZis;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.databinding.V2AdSwitchBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: AdSwitchActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\t"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/my/AdSwitchActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2AdSwitchBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.my.AdSwitchActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AdSwitchActivity extends BaseActivity<V2AdSwitchBinding, BaseViewModel> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdSwitchActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.my.AdSwitchActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5693a extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {
        C5693a() {
            super(1);
        }

        /* renamed from: a */
        public final void m38641a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            AdSwitchActivity.this.mo43920M().tagAd.setChecked(true);
            BeiZis.setSupportPersonalized(true);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38641a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdSwitchActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.my.AdSwitchActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5694b extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        public static final C5694b f20533a = new C5694b();

        C5694b() {
            super(1);
        }

        /* renamed from: a */
        public final void m38640a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            LoggedInUser.f15182b.m43634a().m43687D(false);
            BeiZis.setSupportPersonalized(false);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38640a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static final void m38642d(AdSwitchActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        if (c3984b.m43634a().m43660c()) {
            ContextExt.m43857g(this$0, "关闭个性化广告设置", "关闭后，该设备将不再展示个性化广告，但您看到的广告数量并不会减少且可能是您不感兴趣的广告", new C5693a(), C5694b.f20533a, "确认关闭", "我再想想");
            return;
        }
        c3984b.m43634a().m43687D(true);
        BeiZis.setSupportPersonalized(true);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setBackEvent(this);
        mo43920M().tagAd.setChecked(LoggedInUser.f15182b.m43634a().m43660c());
        mo43920M().tagAd.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdSwitchActivity.m38642d(AdSwitchActivity.this, view);
            }
        });
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
