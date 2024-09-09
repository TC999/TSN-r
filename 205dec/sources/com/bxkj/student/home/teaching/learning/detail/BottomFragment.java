package com.bxkj.student.home.teaching.learning.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.student.home.teaching.exam.FaceDetectExamActivity;
import com.bxkj.student.home.teaching.learning.question.list.QuestionListActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import java.util.Map;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class BottomFragment extends BaseFragment {
    private int A;
    private int B;
    private int C;
    private int D;
    private k E;

    /* renamed from: h  reason: collision with root package name */
    private Button f20611h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f20612i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f20613j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20614k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20615l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20616m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20617n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20618o;

    /* renamed from: p  reason: collision with root package name */
    private BaseMediaObject f20619p;

    /* renamed from: q  reason: collision with root package name */
    private ShareAction f20620q;

    /* renamed from: r  reason: collision with root package name */
    private UMShareListener f20621r;

    /* renamed from: s  reason: collision with root package name */
    private String f20622s;

    /* renamed from: t  reason: collision with root package name */
    private String f20623t;

    /* renamed from: u  reason: collision with root package name */
    private int f20624u;

    /* renamed from: v  reason: collision with root package name */
    private int f20625v;

    /* renamed from: w  reason: collision with root package name */
    private int f20626w;

    /* renamed from: x  reason: collision with root package name */
    private int f20627x;

    /* renamed from: y  reason: collision with root package name */
    private int f20628y;

    /* renamed from: z  reason: collision with root package name */
    private int f20629z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements UMShareListener {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.learning.detail.BottomFragment$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class C0237a extends HttpCallBack {
            C0237a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
            }
        }

        a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseFragment) BottomFragment.this).f1665e, " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t3) {
            t3.printStackTrace();
            Context context = ((BaseFragment) BottomFragment.this).f1665e;
            Toast.makeText(context, " \u5206\u4eab\u5931\u8d25\u5566," + t3.getMessage(), 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Http.with(((BaseFragment) BottomFragment.this).f1665e).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).t(BottomFragment.this.f20623t, "3", 1)).setDataListener(new C0237a());
            Toast.makeText(((BaseFragment) BottomFragment.this).f1665e, " \u5206\u4eab\u6210\u529f\u5566", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BottomFragment bottomFragment = BottomFragment.this;
            bottomFragment.f20624u = bottomFragment.f20624u == 0 ? 1 : 0;
            BottomFragment.this.t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BottomFragment bottomFragment = BottomFragment.this;
            bottomFragment.f20625v = bottomFragment.f20625v == 0 ? 1 : 0;
            BottomFragment.this.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        w0(SHARE_MEDIA.WEIXIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(View view) {
        w0(SHARE_MEDIA.WEIXIN_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        w0(SHARE_MEDIA.QQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        w0(SHARE_MEDIA.QZONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        Http.with(this.f1665e).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).t(this.f20623t, "1", this.f20624u == 0 ? 1 : 0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        Http.with(this.f1665e).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).t(this.f20623t, "2", this.f20625v == 0 ? 1 : 0)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        startActivity(new Intent(this.f1665e, QuestionListActivity.class).putExtra("type", 1).putExtra("resourceId", this.f20622s));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 n0(Intent intent, int i4) {
        startActivityForResult(intent.setClass(this.f1665e, FaceDetectExamActivity.class), i4);
        this.f1666f.overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        if (this.f20625v == 1) {
            p0();
        } else {
            q0();
        }
    }

    private void p0() {
        Drawable drawable = getResources().getDrawable(2131558579);
        drawable.setBounds(0, 0, cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1665e), cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1665e));
        this.f20614k.setCompoundDrawables(null, drawable, null, null);
        this.f20614k.setText("\u5df2\u6536\u85cf");
    }

    private void q0() {
        Drawable drawable = getResources().getDrawable(2131558544);
        drawable.setBounds(0, 0, cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1665e), cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1665e));
        this.f20614k.setCompoundDrawables(null, drawable, null, null);
        this.f20614k.setText("\u6536\u85cf");
    }

    private void r0() {
        Drawable drawable = getResources().getDrawable(2131559198);
        drawable.setBounds(0, 0, cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1665e), cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1665e));
        this.f20613j.setCompoundDrawables(null, drawable, null, null);
        this.f20613j.setText("\u5df2\u70b9\u8d5e");
    }

    private void s0() {
        Drawable drawable = getResources().getDrawable(2131559199);
        drawable.setBounds(0, 0, cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1665e), cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1665e));
        this.f20613j.setCompoundDrawables(null, drawable, null, null);
        this.f20613j.setText("\u70b9\u8d5e");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        if (this.f20624u == 1) {
            r0();
        } else {
            s0();
        }
    }

    private void w0(SHARE_MEDIA platform) {
        this.f20620q.setPlatform(platform);
        this.f20620q.setCallback(this.f20621r);
        BaseMediaObject baseMediaObject = this.f20619p;
        if (baseMediaObject instanceof UMVideo) {
            this.f20620q.withMedia((UMVideo) baseMediaObject);
        } else if (baseMediaObject instanceof UMWeb) {
            this.f20620q.withMedia((UMWeb) baseMediaObject);
        }
        this.f20620q.share();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f20621r = new a();
        this.f20615l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.g0(view);
            }
        });
        this.f20616m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.h0(view);
            }
        });
        this.f20617n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.i0(view);
            }
        });
        this.f20618o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.j0(view);
            }
        });
        this.f20613j.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.k0(view);
            }
        });
        this.f20614k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.l0(view);
            }
        });
        this.f20611h.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        Bundle arguments = getArguments();
        if (arguments.containsKey("id")) {
            this.f20622s = arguments.getString("id");
        }
        if (arguments.containsKey("detailId")) {
            this.f20623t = arguments.getString("detailId");
        }
        if (arguments.containsKey("isLike")) {
            this.f20624u = arguments.getInt("isLike", 0);
        }
        if (arguments.containsKey("isCollection")) {
            this.f20625v = arguments.getInt("isCollection", 0);
        }
        if (arguments.containsKey("duration")) {
            this.f20626w = arguments.getInt("duration", 0);
        }
        if (arguments.containsKey("popTime")) {
            this.f20627x = arguments.getInt("popTime", 0);
        }
        if (arguments.containsKey("hasQuestion")) {
            this.f20628y = arguments.getInt("hasQuestion", 0);
        }
        if (arguments.containsKey("isComplete")) {
            this.f20629z = arguments.getInt("isComplete", 0);
        }
        if (arguments.containsKey("isOk")) {
            this.A = arguments.getInt("isOk", 0);
        }
        if (arguments.containsKey("opreateFlag")) {
            this.B = arguments.getInt("opreateFlag", 0);
        }
        if (arguments.containsKey("valType")) {
            this.C = arguments.getInt("valType", 1);
        }
        if (arguments.containsKey("integral")) {
            this.D = arguments.getInt("integral", 1);
        }
        t0();
        o0();
        this.f20620q = new ShareAction(getActivity());
        int i4 = this.B;
        if (i4 == 0) {
            this.E = new k(this, this.f1665e, this.f20626w, this.f20627x, this.f20622s, this.f20623t, this.f20611h, this.f20628y, this.C, this.D);
            if (this.f20626w == 0) {
                this.f20611h.setVisibility(8);
            } else {
                ((LearnDetailActivity) getActivity()).w0(true);
                this.E.T();
            }
            this.f20611h.setEnabled(false);
        } else if (i4 == 1) {
            this.f20611h.setText("\u5df2\u5b8c\u6210");
            this.f20611h.setEnabled(false);
        } else if (i4 == 2) {
            this.f20611h.setText("\u5f00\u59cb\u7b54\u9898");
            this.f20611h.setEnabled(true);
        } else if (i4 == 3) {
            this.f20611h.setText("\u67e5\u770b\u7b54\u9898");
            this.f20611h.setEnabled(true);
        } else {
            this.f20611h.setVisibility(8);
            this.f20611h.setEnabled(false);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f20611h = (Button) c(2131230999);
        this.f20612i = (LinearLayout) c(2131232167);
        this.f20613j = (TextView) c(2131233248);
        this.f20614k = (TextView) c(2131232908);
        this.f20615l = (TextView) c(2131233228);
        this.f20616m = (TextView) c(2131233034);
        this.f20617n = (TextView) c(2131233109);
        this.f20618o = (TextView) c(2131233115);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427622;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(final int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 170 && resultCode == 187) {
            k kVar = this.E;
            if (kVar != null) {
                kVar.D();
            }
            new iOSOneButtonDialog(this.f1665e).setMessage("\u4eba\u8138\u8bc6\u522b\u6210\u529f\uff0c\u8bf7\u7ee7\u7eed\u5b66\u4e60").show();
        } else if (requestCode == 170 && resultCode == 170) {
            com.bxkj.base.v2.common.ext.g.c((FragmentActivity) this.f1665e, "\u4eba\u8138\u8bc6\u522b", new l1.a() { // from class: com.bxkj.student.home.teaching.learning.detail.u
                public final Object invoke() {
                    f1 n02;
                    n02 = BottomFragment.this.n0(data, requestCode);
                    return n02;
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        k kVar = this.E;
        if (kVar != null) {
            kVar.U();
        }
        k kVar2 = this.E;
        if (kVar2 != null) {
            kVar2.Q();
        }
        super.onDestroy();
    }

    public void u0(boolean b4) {
        k kVar = this.E;
        if (kVar != null) {
            kVar.R(b4);
        }
    }

    public void v0(BaseMediaObject baseMediaObject) {
        this.f20619p = baseMediaObject;
    }
}
