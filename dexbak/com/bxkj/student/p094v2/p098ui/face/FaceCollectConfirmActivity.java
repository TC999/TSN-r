package com.bxkj.student.p094v2.p098ui.face;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.utils.AppManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.student.databinding.V3FaceCollectConfirmBinding;
import com.bxkj.student.p094v2.p103vm.face.FaceCollectVM;
import com.orhanobut.logger.C11792j;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import p617l1.InterfaceC15269a;

/* compiled from: FaceCollectConfirmActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/face/FaceCollectConfirmActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V3FaceCollectConfirmBinding;", "Lcom/bxkj/student/v2/vm/face/FaceCollectVM;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "N", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.face.FaceCollectConfirmActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FaceCollectConfirmActivity extends BaseActivity<V3FaceCollectConfirmBinding, FaceCollectVM> {

    /* compiled from: FaceCollectConfirmActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceCollectConfirmActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5616a extends Lambda implements InterfaceC15269a<Unit> {
        C5616a() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ContextExt.m43847q(FaceCollectConfirmActivity.this, "人脸采集成功");
            AppManager.m57776n().m57781i(FaceCollectActivity.class);
            FaceCollectConfirmActivity.this.finish();
        }
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setActivity(this);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if (!intent.hasExtra("avatar")) {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        C11792j.m20469d(C14342f0.m8216C("intent.getStringExtra(\"avatar\")=", getIntent().getStringExtra("avatar")), new Object[0]);
        Glide.m45751C(mo43926C()).mo45503f(new File(getIntent().getStringExtra("avatar"))).m44668G0(true).m44612r(DiskCacheStrategy.f13787b).m45551i1(mo43920M().ivFace);
    }

    /* renamed from: N */
    public final void m38796N() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if (!intent.hasExtra("avatar")) {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        mo43911x().m38116t(new File(getIntent().getStringExtra("avatar")), new C5616a());
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
