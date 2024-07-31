package com.bxkj.student.run.app.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.student.C4215R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/* renamed from: com.bxkj.student.run.app.utils.w */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ShareDialog {

    /* renamed from: a */
    private Activity f19715a;

    /* renamed from: b */
    private Bitmap f19716b;

    /* renamed from: c */
    private iOSOneButtonDialog f19717c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareDialog.java */
    /* renamed from: com.bxkj.student.run.app.utils.w$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5410a implements UMShareListener {
        C5410a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ShareDialog.this.f19715a, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t) {
            t.printStackTrace();
            Activity activity = ShareDialog.this.f19715a;
            Toast.makeText(activity, " 分享失败啦," + t.getMessage(), 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ShareDialog.this.f19715a, " 分享成功啦", 0).show();
            ShareDialog.this.f19717c.dismiss();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    public ShareDialog(Activity mContext) {
        this.f19715a = mContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m39524g(View view) {
        m39519l(SHARE_MEDIA.WEIXIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m39523h(View view) {
        m39519l(SHARE_MEDIA.WEIXIN_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void m39522i(View view) {
        m39519l(SHARE_MEDIA.QQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void m39521j(View view) {
        m39519l(SHARE_MEDIA.QZONE);
    }

    /* renamed from: l */
    private void m39519l(SHARE_MEDIA platform) {
        new ShareAction(this.f19715a).setPlatform(platform).setCallback(new C5410a()).withMedia(new UMImage(this.f19715a, this.f19716b)).share();
        this.f19717c.dismiss();
    }

    /* renamed from: k */
    public void m39520k(Bitmap bitmap) {
        this.f19716b = bitmap;
        iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f19715a);
        this.f19717c = iosonebuttondialog;
        iosonebuttondialog.setTitle("分享到");
        this.f19717c.setTitleLineVisiBility(0);
        this.f19717c.setCenterCustomView(C4215R.C4221layout.dialog_share);
        this.f19717c.setMessageGrivity(17);
        this.f19717c.setOneButtonText("关闭");
        this.f19717c.show();
        ((LinearLayout) this.f19717c.findViewById(2131232234)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareDialog.this.m39524g(view);
            }
        });
        ((LinearLayout) this.f19717c.findViewById(2131232204)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareDialog.this.m39523h(view);
            }
        });
        ((LinearLayout) this.f19717c.findViewById(2131232213)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareDialog.this.m39522i(view);
            }
        });
        ((LinearLayout) this.f19717c.findViewById(2131232215)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.utils.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareDialog.this.m39521j(view);
            }
        });
    }
}
