package com.bxkj.student.p094v2.p098ui.p101my;

import android.content.Context;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.util.SystemUtils;
import com.bxkj.student.common.utils.SoundUtils;
import com.bxkj.student.databinding.V2AcScanQrcodeBinding;
import com.bxkj.student.p094v2.common.utils.H5Utils;
import com.orhanobut.logger.C11792j;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.LinkedHashMap;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsJVM;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15284p;

/* compiled from: ScanQrCodeActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/my/ScanQrCodeActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2AcScanQrcodeBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "N", ExifInterface.LONGITUDE_EAST, "onResume", "onStop", "onDestroy", "p", "", "i", "Z", "isRefuse", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.my.ScanQrCodeActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ScanQrCodeActivity extends BaseActivity<V2AcScanQrcodeBinding, BaseViewModel> {

    /* renamed from: i */
    private boolean f20535i;

    /* compiled from: ScanQrCodeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/student/v2/ui/my/ScanQrCodeActivity$a", "Lcn/bingoogolapple/qrcode/core/QRCodeView$f;", "", CommonNetImpl.RESULT, "Lkotlin/f1;", "H", "", "isDark", "b", "D", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.my.ScanQrCodeActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5695a implements QRCodeView.InterfaceC1099f {

        /* renamed from: a */
        final /* synthetic */ SoundUtils f20536a;

        /* renamed from: b */
        final /* synthetic */ ScanQrCodeActivity f20537b;

        /* compiled from: ScanQrCodeActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.my.ScanQrCodeActivity$initUiData$1$onScanQRCodeSuccess$2", m8638f = "ScanQrCodeActivity.kt", m8637i = {}, m8636l = {46}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
        /* renamed from: com.bxkj.student.v2.ui.my.ScanQrCodeActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        static final class C5696a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

            /* renamed from: a */
            int f20538a;

            /* renamed from: b */
            final /* synthetic */ ScanQrCodeActivity f20539b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5696a(ScanQrCodeActivity scanQrCodeActivity, InterfaceC14268c<? super C5696a> interfaceC14268c) {
                super(2, interfaceC14268c);
                this.f20539b = scanQrCodeActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
                return new C5696a(this.f20539b, interfaceC14268c);
            }

            @Override // p617l1.InterfaceC15284p
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
                return ((C5696a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object m8642h;
                m8642h = C14287b.m8642h();
                int i = this.f20538a;
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    this.f20538a = 1;
                    if (Delay.m5751b(3000L, this) == m8642h) {
                        return m8642h;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    C14294d0.m8596n(obj);
                }
                this.f20539b.m38632N();
                return Unit.f41048a;
            }
        }

        C5695a(SoundUtils soundUtils, ScanQrCodeActivity scanQrCodeActivity) {
            this.f20536a = soundUtils;
            this.f20537b = scanQrCodeActivity;
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
        /* renamed from: D */
        public void mo38629D() {
            Toast.makeText(this.f20537b.mo43926C(), "打开相机出错", 0).show();
            C11792j.m20468e("打开相机出错", new Object[0]);
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
        /* renamed from: H */
        public void mo38628H(@Nullable String str) {
            boolean m6548u2;
            boolean z = false;
            C11792j.m20469d(C14342f0.m8216C("result:", str), new Object[0]);
            this.f20536a.m42883g(2131755010);
            if (str != null) {
                m6548u2 = StringsJVM.m6548u2(str, IDataSource.f43971a, false, 2, null);
                if (m6548u2) {
                    z = true;
                }
            }
            if (z) {
                H5Utils h5Utils = H5Utils.f20124a;
                Context mo43926C = this.f20537b.mo43926C();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("name", "扫一扫");
                linkedHashMap.put("linkUrl", str);
                Unit unit = Unit.f41048a;
                h5Utils.m39075b(mo43926C, linkedHashMap);
                this.f20537b.finish();
                return;
            }
            ContextExt.m43847q(this.f20537b, C14342f0.m8216C("扫码结果:", str));
            C15111j.m4126f(LifecycleOwnerKt.getLifecycleScope(this.f20537b), Dispatchers.m5036c(), null, new C5696a(this.f20537b, null), 2, null);
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
        /* renamed from: b */
        public void mo38627b(boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScanQrCodeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.my.ScanQrCodeActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5697b extends Lambda implements InterfaceC15269a<Unit> {
        C5697b() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            C11792j.m20469d("开始扫码", new Object[0]);
            ScanQrCodeActivity.this.f20535i = false;
            ScanQrCodeActivity.this.mo43920M().zbarview.m57999z();
            ScanQrCodeActivity.this.mo43920M().zbarview.m58027D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScanQrCodeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.my.ScanQrCodeActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5698c extends Lambda implements InterfaceC15269a<Unit> {
        C5698c() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ScanQrCodeActivity.this.f20535i = true;
            C11792j.m20469d("用户拒绝摄像头权限扫码", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public final void m38632N() {
        C11792j.m20469d(C14342f0.m8216C("isRefuse=", Boolean.valueOf(this.f20535i)), new Object[0]);
        String str = "您拒绝了摄像头权限,无法进行扫码,请去手机【设置】->【应用管理】->【" + ((Object) SystemUtils.m44004b(BaseApp.m44341b())) + "】中打开摄像头权限";
        ScanQrCodeActivity scanQrCodeActivity = this.f20535i ? this : null;
        if (scanQrCodeActivity == null) {
            PermissionExt.m43840d(this, "扫一扫", new C5697b(), new C5698c());
        } else {
            ContextExt.m43851m(scanQrCodeActivity.mo43926C(), str);
        }
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setBackEvent(this);
        SoundUtils soundUtils = new SoundUtils(mo43912w());
        soundUtils.m42877m(2131755010);
        mo43920M().zbarview.setDelegate(new C5695a(soundUtils, this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        mo43920M().zbarview.m58026E();
        mo43920M().zbarview.m58024G();
        mo43920M().zbarview.m58007o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m38632N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        mo43920M().zbarview.m58026E();
        mo43920M().zbarview.m58024G();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
