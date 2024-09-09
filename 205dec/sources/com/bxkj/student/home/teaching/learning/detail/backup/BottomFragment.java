package com.bxkj.student.home.teaching.learning.detail.backup;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.u;
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
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class BottomFragment extends BaseFragment {
    private int A;
    private int B;
    private int C;
    private j D;

    /* renamed from: h  reason: collision with root package name */
    private Button f20647h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f20648i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f20649j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20650k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20651l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20652m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20653n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20654o;

    /* renamed from: p  reason: collision with root package name */
    private BaseMediaObject f20655p;

    /* renamed from: q  reason: collision with root package name */
    private ShareAction f20656q;

    /* renamed from: r  reason: collision with root package name */
    private UMShareListener f20657r;

    /* renamed from: s  reason: collision with root package name */
    private String f20658s;

    /* renamed from: t  reason: collision with root package name */
    private String f20659t;

    /* renamed from: u  reason: collision with root package name */
    private int f20660u;

    /* renamed from: v  reason: collision with root package name */
    private int f20661v;

    /* renamed from: w  reason: collision with root package name */
    private int f20662w;

    /* renamed from: x  reason: collision with root package name */
    private int f20663x;

    /* renamed from: y  reason: collision with root package name */
    private int f20664y;

    /* renamed from: z  reason: collision with root package name */
    private int f20665z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements UMShareListener {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.BottomFragment$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class C0238a extends HttpCallBack {
            C0238a() {
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
            Http.with(((BaseFragment) BottomFragment.this).f1665e).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).t(BottomFragment.this.f20659t, "3", 1)).setDataListener(new C0238a());
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
            bottomFragment.f20660u = bottomFragment.f20660u == 0 ? 1 : 0;
            BottomFragment.this.r0();
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
            bottomFragment.f20661v = bottomFragment.f20661v == 0 ? 1 : 0;
            BottomFragment.this.m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(View view) {
        t0(SHARE_MEDIA.WEIXIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        t0(SHARE_MEDIA.WEIXIN_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(View view) {
        t0(SHARE_MEDIA.QQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        t0(SHARE_MEDIA.QZONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        Http.with(this.f1665e).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).t(this.f20659t, "1", this.f20660u == 0 ? 1 : 0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        Http.with(this.f1665e).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).t(this.f20659t, "2", this.f20661v == 0 ? 1 : 0)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        startActivity(new Intent(this.f1665e, QuestionListActivity.class).putExtra("type", 1).putExtra("resourceId", this.f20658s));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        if (this.f20661v == 1) {
            n0();
        } else {
            o0();
        }
    }

    private void n0() {
        Drawable drawable = getResources().getDrawable(2131558579);
        drawable.setBounds(0, 0, u.a(21.0f, this.f1665e), u.a(21.0f, this.f1665e));
        this.f20650k.setCompoundDrawables(null, drawable, null, null);
        this.f20650k.setText("\u5df2\u6536\u85cf");
    }

    private void o0() {
        Drawable drawable = getResources().getDrawable(2131558544);
        drawable.setBounds(0, 0, u.a(21.0f, this.f1665e), u.a(21.0f, this.f1665e));
        this.f20650k.setCompoundDrawables(null, drawable, null, null);
        this.f20650k.setText("\u6536\u85cf");
    }

    private void p0() {
        Drawable drawable = getResources().getDrawable(2131559198);
        drawable.setBounds(0, 0, u.a(21.0f, this.f1665e), u.a(21.0f, this.f1665e));
        this.f20649j.setCompoundDrawables(null, drawable, null, null);
        this.f20649j.setText("\u5df2\u70b9\u8d5e");
    }

    private void q0() {
        Drawable drawable = getResources().getDrawable(2131559199);
        drawable.setBounds(0, 0, u.a(21.0f, this.f1665e), u.a(21.0f, this.f1665e));
        this.f20649j.setCompoundDrawables(null, drawable, null, null);
        this.f20649j.setText("\u70b9\u8d5e");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        if (this.f20660u == 1) {
            p0();
        } else {
            q0();
        }
    }

    private void t0(SHARE_MEDIA platform) {
        this.f20656q.setPlatform(platform);
        this.f20656q.setCallback(this.f20657r);
        BaseMediaObject baseMediaObject = this.f20655p;
        if (baseMediaObject instanceof UMVideo) {
            this.f20656q.withMedia((UMVideo) baseMediaObject);
        } else if (baseMediaObject instanceof UMWeb) {
            this.f20656q.withMedia((UMWeb) baseMediaObject);
        }
        this.f20656q.share();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f20657r = new a();
        this.f20651l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.f0(view);
            }
        });
        this.f20652m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.g0(view);
            }
        });
        this.f20653n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.h0(view);
            }
        });
        this.f20654o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.i0(view);
            }
        });
        this.f20649j.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.j0(view);
            }
        });
        this.f20650k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.k0(view);
            }
        });
        this.f20647h.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        Bundle arguments = getArguments();
        if (arguments.containsKey("id")) {
            this.f20658s = arguments.getString("id");
        }
        if (arguments.containsKey("detailId")) {
            this.f20659t = arguments.getString("detailId");
        }
        if (arguments.containsKey("isLike")) {
            this.f20660u = arguments.getInt("isLike", 0);
        }
        if (arguments.containsKey("isCollection")) {
            this.f20661v = arguments.getInt("isCollection", 0);
        }
        if (arguments.containsKey("duration")) {
            this.f20662w = arguments.getInt("duration", 0);
        }
        if (arguments.containsKey("popTime")) {
            this.f20663x = arguments.getInt("popTime", 0);
        }
        if (arguments.containsKey("hasQuestion")) {
            this.f20664y = arguments.getInt("hasQuestion", 0);
        }
        if (arguments.containsKey("isComplete")) {
            this.f20665z = arguments.getInt("isComplete", 0);
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
        r0();
        m0();
        this.f20656q = new ShareAction(getActivity());
        int i4 = this.B;
        if (i4 == 0) {
            j jVar = new j(this, this.f1665e, this.f20662w, this.f20663x, this.f20658s, this.f20659t, this.f20647h, this.f20664y, this.C);
            this.D = jVar;
            if (this.f20662w == 0) {
                this.f20647h.setVisibility(8);
            } else {
                jVar.P();
            }
            this.f20647h.setEnabled(false);
        } else if (i4 == 1) {
            this.f20647h.setText("\u5df2\u5b8c\u6210");
            this.f20647h.setEnabled(false);
        } else if (i4 == 2) {
            this.f20647h.setText("\u5f00\u59cb\u7b54\u9898");
            this.f20647h.setEnabled(true);
        } else if (i4 == 3) {
            this.f20647h.setText("\u67e5\u770b\u7b54\u9898");
            this.f20647h.setEnabled(true);
        } else {
            this.f20647h.setVisibility(8);
            this.f20647h.setEnabled(false);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f20647h = (Button) c(2131230999);
        this.f20648i = (LinearLayout) c(2131232167);
        this.f20649j = (TextView) c(2131233248);
        this.f20650k = (TextView) c(2131232908);
        this.f20651l = (TextView) c(2131233228);
        this.f20652m = (TextView) c(2131233034);
        this.f20653n = (TextView) c(2131233109);
        this.f20654o = (TextView) c(2131233115);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427622;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 170 && resultCode == 187) {
            j jVar = this.D;
            if (jVar != null) {
                jVar.B();
            }
            new iOSOneButtonDialog(this.f1665e).setMessage("\u4eba\u8138\u8bc6\u522b\u6210\u529f\uff0c\u8bf7\u7ee7\u7eed\u5b66\u4e60").show();
        } else if (requestCode == 170 && resultCode == 170) {
            startActivityForResult(data.setClass(this.f1665e, FaceDetectExamActivity.class), requestCode);
            this.f1666f.overridePendingTransition(2130771987, 2130771986);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        j jVar = this.D;
        if (jVar != null) {
            TimerTask timerTask = jVar.f20716m;
            if (timerTask != null) {
                timerTask.cancel();
            }
            Timer timer = this.D.f20715l;
            if (timer != null) {
                timer.cancel();
            }
            j jVar2 = this.D;
            Handler handler = jVar2.f20722s;
            if (handler != null) {
                handler.removeCallbacks(jVar2.f20716m);
            }
        }
        super.onDestroy();
    }

    public void s0(BaseMediaObject baseMediaObject) {
        this.f20655p = baseMediaObject;
    }
}
