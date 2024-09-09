package com.bxkj.student.run.app.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ShareDialog.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private Activity f22945a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f22946b;

    /* renamed from: c  reason: collision with root package name */
    private iOSOneButtonDialog f22947c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ShareDialog.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements UMShareListener {
        a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(w.this.f22945a, " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t3) {
            t3.printStackTrace();
            Activity activity = w.this.f22945a;
            Toast.makeText(activity, " \u5206\u4eab\u5931\u8d25\u5566," + t3.getMessage(), 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(w.this.f22945a, " \u5206\u4eab\u6210\u529f\u5566", 0).show();
            w.this.f22947c.dismiss();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    public w(Activity mContext) {
        this.f22945a = mContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        l(SHARE_MEDIA.WEIXIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        l(SHARE_MEDIA.WEIXIN_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        l(SHARE_MEDIA.QQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        l(SHARE_MEDIA.QZONE);
    }

    private void l(SHARE_MEDIA platform) {
        new ShareAction(this.f22945a).setPlatform(platform).setCallback(new a()).withMedia(new UMImage(this.f22945a, this.f22946b)).share();
        this.f22947c.dismiss();
    }

    public void k(Bitmap bitmap) {
        this.f22946b = bitmap;
        iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f22945a);
        this.f22947c = iosonebuttondialog;
        iosonebuttondialog.setTitle("\u5206\u4eab\u5230");
        this.f22947c.setTitleLineVisiBility(0);
        this.f22947c.setCenterCustomView(2131427604);
        this.f22947c.setMessageGrivity(17);
        this.f22947c.setOneButtonText("\u5173\u95ed");
        this.f22947c.show();
        ((LinearLayout) this.f22947c.findViewById(2131232234)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.this.g(view);
            }
        });
        ((LinearLayout) this.f22947c.findViewById(2131232204)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.this.h(view);
            }
        });
        ((LinearLayout) this.f22947c.findViewById(2131232213)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.this.i(view);
            }
        });
        ((LinearLayout) this.f22947c.findViewById(2131232215)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.this.j(view);
            }
        });
    }
}
