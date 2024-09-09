package com.bxkj.student.v2.ui.sports.v3.detail;

import android.widget.Toast;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: V3RecordDetailActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/detail/V3RecordDetailActivity$shareImage$1$2", "Lcom/umeng/socialize/UMShareListener;", "Lcom/umeng/socialize/bean/SHARE_MEDIA;", "share_media", "Lkotlin/f1;", "onStart", "platform", "onResult", "", "t", "onError", "onCancel", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class V3RecordDetailActivity$shareImage$1$2 implements UMShareListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ V3RecordDetailActivity f24098a;

    V3RecordDetailActivity$shareImage$1$2(V3RecordDetailActivity v3RecordDetailActivity) {
        this.f24098a = v3RecordDetailActivity;
    }

    @Override // com.umeng.socialize.UMShareListener
    public void onCancel(@NotNull SHARE_MEDIA platform) {
        f0.p(platform, "platform");
        Toast.makeText(this.f24098a.C(), " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
    }

    @Override // com.umeng.socialize.UMShareListener
    public void onError(@NotNull SHARE_MEDIA platform, @NotNull Throwable t3) {
        f0.p(platform, "platform");
        f0.p(t3, "t");
        t3.printStackTrace();
        Toast.makeText(this.f24098a.C(), " \u5206\u4eab\u5931\u8d25\u5566", 0).show();
    }

    @Override // com.umeng.socialize.UMShareListener
    public void onResult(@NotNull SHARE_MEDIA platform) {
        f0.p(platform, "platform");
    }

    @Override // com.umeng.socialize.UMShareListener
    public void onStart(@NotNull SHARE_MEDIA share_media) {
        f0.p(share_media, "share_media");
    }
}
