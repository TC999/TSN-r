package com.bxkj.student.v2.ui.my;

import android.view.View;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.beizi.fusion.BeiZis;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.databinding.V2AdSwitchBinding;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import l1.l;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AdSwitchActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/student/v2/ui/my/AdSwitchActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2AdSwitchBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "E", "p", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class AdSwitchActivity extends BaseActivity<V2AdSwitchBinding, BaseViewModel> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AdSwitchActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends Lambda implements l<iOSTwoButtonDialog, f1> {
        a() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            AdSwitchActivity.this.M().tagAd.setChecked(true);
            BeiZis.setSupportPersonalized(true);
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AdSwitchActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f23930a = new b();

        b() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            com.bxkj.base.v2.data.a.b.a().D(false);
            BeiZis.setSupportPersonalized(false);
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AdSwitchActivity this$0, View view) {
        f0.p(this$0, "this$0");
        a.b bVar = com.bxkj.base.v2.data.a.b;
        if (bVar.a().c()) {
            ContextExtKt.g(this$0, "\u5173\u95ed\u4e2a\u6027\u5316\u5e7f\u544a\u8bbe\u7f6e", "\u5173\u95ed\u540e\uff0c\u8be5\u8bbe\u5907\u5c06\u4e0d\u518d\u5c55\u793a\u4e2a\u6027\u5316\u5e7f\u544a\uff0c\u4f46\u60a8\u770b\u5230\u7684\u5e7f\u544a\u6570\u91cf\u5e76\u4e0d\u4f1a\u51cf\u5c11\u4e14\u53ef\u80fd\u662f\u60a8\u4e0d\u611f\u5174\u8da3\u7684\u5e7f\u544a", new a(), b.f23930a, "\u786e\u8ba4\u5173\u95ed", "\u6211\u518d\u60f3\u60f3");
            return;
        }
        bVar.a().D(true);
        BeiZis.setSupportPersonalized(true);
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setBackEvent(this);
        M().tagAd.setChecked(com.bxkj.base.v2.data.a.b.a().c());
        M().tagAd.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdSwitchActivity.d(AdSwitchActivity.this, view);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
