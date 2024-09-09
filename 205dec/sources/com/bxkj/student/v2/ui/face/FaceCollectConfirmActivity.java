package com.bxkj.student.v2.ui.face;

import android.content.Intent;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.student.databinding.V3FaceCollectConfirmBinding;
import com.bxkj.student.v2.vm.face.FaceCollectVM;
import java.io.File;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: FaceCollectConfirmActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/bxkj/student/v2/ui/face/FaceCollectConfirmActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V3FaceCollectConfirmBinding;", "Lcom/bxkj/student/v2/vm/face/FaceCollectVM;", "Lkotlin/f1;", "E", "p", "N", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class FaceCollectConfirmActivity extends BaseActivity<V3FaceCollectConfirmBinding, FaceCollectVM> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceCollectConfirmActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class a extends Lambda implements d2.a<f1> {
        a() {
            super(0);
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ContextExtKt.q(FaceCollectConfirmActivity.this, "\u4eba\u8138\u91c7\u96c6\u6210\u529f");
            cn.bluemobi.dylan.base.utils.a.n().i(FaceCollectActivity.class);
            FaceCollectConfirmActivity.this.finish();
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setActivity(this);
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
        com.orhanobut.logger.j.d(f0.C("intent.getStringExtra(\"avatar\")=", getIntent().getStringExtra("avatar")), new Object[0]);
        ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.d.C(C()).f(new File(getIntent().getStringExtra("avatar"))).H0(true)).s(com.bumptech.glide.load.engine.j.f17104b)).j1(M().ivFace);
    }

    public final void N() {
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
        x().t(new File(getIntent().getStringExtra("avatar")), new a());
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
