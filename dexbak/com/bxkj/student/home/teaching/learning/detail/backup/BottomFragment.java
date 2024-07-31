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
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.exam.FaceDetectExamActivity;
import com.bxkj.student.home.teaching.learning.LearningApiService;
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

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BottomFragment extends BaseFragment {

    /* renamed from: A */
    private int f17299A;

    /* renamed from: B */
    private int f17300B;

    /* renamed from: C */
    private int f17301C;

    /* renamed from: D */
    private AlertConfirmReadDialog f17302D;

    /* renamed from: h */
    private Button f17303h;

    /* renamed from: i */
    private LinearLayout f17304i;

    /* renamed from: j */
    private TextView f17305j;

    /* renamed from: k */
    private TextView f17306k;

    /* renamed from: l */
    private TextView f17307l;

    /* renamed from: m */
    private TextView f17308m;

    /* renamed from: n */
    private TextView f17309n;

    /* renamed from: o */
    private TextView f17310o;

    /* renamed from: p */
    private BaseMediaObject f17311p;

    /* renamed from: q */
    private ShareAction f17312q;

    /* renamed from: r */
    private UMShareListener f17313r;

    /* renamed from: s */
    private String f17314s;

    /* renamed from: t */
    private String f17315t;

    /* renamed from: u */
    private int f17316u;

    /* renamed from: v */
    private int f17317v;

    /* renamed from: w */
    private int f17318w;

    /* renamed from: x */
    private int f17319x;

    /* renamed from: y */
    private int f17320y;

    /* renamed from: z */
    private int f17321z;

    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.BottomFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4618a implements UMShareListener {

        /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.BottomFragment$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4619a extends HttpCallBack {
            C4619a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
            }
        }

        C4618a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseFragment) BottomFragment.this).f1678e, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t) {
            t.printStackTrace();
            Context context = ((BaseFragment) BottomFragment.this).f1678e;
            Toast.makeText(context, " 分享失败啦," + t.getMessage(), 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Http.with(((BaseFragment) BottomFragment.this).f1678e).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41622t(BottomFragment.this.f17315t, "3", 1)).setDataListener(new C4619a());
            Toast.makeText(((BaseFragment) BottomFragment.this).f1678e, " 分享成功啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.BottomFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4620b extends HttpCallBack {
        C4620b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BottomFragment bottomFragment = BottomFragment.this;
            bottomFragment.f17316u = bottomFragment.f17316u == 0 ? 1 : 0;
            BottomFragment.this.m41789r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.BottomFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4621c extends HttpCallBack {
        C4621c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BottomFragment bottomFragment = BottomFragment.this;
            bottomFragment.f17317v = bottomFragment.f17317v == 0 ? 1 : 0;
            BottomFragment.this.m41794m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ void m41801f0(View view) {
        m41787t0(SHARE_MEDIA.WEIXIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void m41800g0(View view) {
        m41787t0(SHARE_MEDIA.WEIXIN_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public /* synthetic */ void m41799h0(View view) {
        m41787t0(SHARE_MEDIA.QQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void m41798i0(View view) {
        m41787t0(SHARE_MEDIA.QZONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ void m41797j0(View view) {
        Http.with(this.f1678e).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41622t(this.f17315t, "1", this.f17316u == 0 ? 1 : 0)).setDataListener(new C4620b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void m41796k0(View view) {
        Http.with(this.f1678e).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41622t(this.f17315t, "2", this.f17317v == 0 ? 1 : 0)).setDataListener(new C4621c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ void m41795l0(View view) {
        startActivity(new Intent(this.f1678e, QuestionListActivity.class).putExtra("type", 1).putExtra("resourceId", this.f17314s));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public void m41794m0() {
        if (this.f17317v == 1) {
            m41793n0();
        } else {
            m41792o0();
        }
    }

    /* renamed from: n0 */
    private void m41793n0() {
        Drawable drawable = getResources().getDrawable(C4215R.mipmap.goods_collection_star_red);
        drawable.setBounds(0, 0, Tools.m57620a(21.0f, this.f1678e), Tools.m57620a(21.0f, this.f1678e));
        this.f17306k.setCompoundDrawables(null, drawable, null, null);
        this.f17306k.setText("已收藏");
    }

    /* renamed from: o0 */
    private void m41792o0() {
        Drawable drawable = getResources().getDrawable(C4215R.mipmap.empty_star);
        drawable.setBounds(0, 0, Tools.m57620a(21.0f, this.f1678e), Tools.m57620a(21.0f, this.f1678e));
        this.f17306k.setCompoundDrawables(null, drawable, null, null);
        this.f17306k.setText("收藏");
    }

    /* renamed from: p0 */
    private void m41791p0() {
        Drawable drawable = getResources().getDrawable(C4215R.mipmap.zan_focus);
        drawable.setBounds(0, 0, Tools.m57620a(21.0f, this.f1678e), Tools.m57620a(21.0f, this.f1678e));
        this.f17305j.setCompoundDrawables(null, drawable, null, null);
        this.f17305j.setText("已点赞");
    }

    /* renamed from: q0 */
    private void m41790q0() {
        Drawable drawable = getResources().getDrawable(C4215R.mipmap.zan_normal);
        drawable.setBounds(0, 0, Tools.m57620a(21.0f, this.f1678e), Tools.m57620a(21.0f, this.f1678e));
        this.f17305j.setCompoundDrawables(null, drawable, null, null);
        this.f17305j.setText("点赞");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public void m41789r0() {
        if (this.f17316u == 1) {
            m41791p0();
        } else {
            m41790q0();
        }
    }

    /* renamed from: t0 */
    private void m41787t0(SHARE_MEDIA platform) {
        this.f17312q.setPlatform(platform);
        this.f17312q.setCallback(this.f17313r);
        BaseMediaObject baseMediaObject = this.f17311p;
        if (baseMediaObject instanceof UMVideo) {
            this.f17312q.withMedia((UMVideo) baseMediaObject);
        } else if (baseMediaObject instanceof UMWeb) {
            this.f17312q.withMedia((UMWeb) baseMediaObject);
        }
        this.f17312q.share();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f17313r = new C4618a();
        this.f17307l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41801f0(view);
            }
        });
        this.f17308m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41800g0(view);
            }
        });
        this.f17309n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41799h0(view);
            }
        });
        this.f17310o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41798i0(view);
            }
        });
        this.f17305j.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41797j0(view);
            }
        });
        this.f17306k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41796k0(view);
            }
        });
        this.f17303h.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m41795l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        Bundle arguments = getArguments();
        if (arguments.containsKey("id")) {
            this.f17314s = arguments.getString("id");
        }
        if (arguments.containsKey("detailId")) {
            this.f17315t = arguments.getString("detailId");
        }
        if (arguments.containsKey("isLike")) {
            this.f17316u = arguments.getInt("isLike", 0);
        }
        if (arguments.containsKey("isCollection")) {
            this.f17317v = arguments.getInt("isCollection", 0);
        }
        if (arguments.containsKey("duration")) {
            this.f17318w = arguments.getInt("duration", 0);
        }
        if (arguments.containsKey("popTime")) {
            this.f17319x = arguments.getInt("popTime", 0);
        }
        if (arguments.containsKey("hasQuestion")) {
            this.f17320y = arguments.getInt("hasQuestion", 0);
        }
        if (arguments.containsKey("isComplete")) {
            this.f17321z = arguments.getInt("isComplete", 0);
        }
        if (arguments.containsKey("isOk")) {
            this.f17299A = arguments.getInt("isOk", 0);
        }
        if (arguments.containsKey("opreateFlag")) {
            this.f17300B = arguments.getInt("opreateFlag", 0);
        }
        if (arguments.containsKey("valType")) {
            this.f17301C = arguments.getInt("valType", 1);
        }
        m41789r0();
        m41794m0();
        this.f17312q = new ShareAction(getActivity());
        int i = this.f17300B;
        if (i == 0) {
            AlertConfirmReadDialog alertConfirmReadDialog = new AlertConfirmReadDialog(this, this.f1678e, this.f17318w, this.f17319x, this.f17314s, this.f17315t, this.f17303h, this.f17320y, this.f17301C);
            this.f17302D = alertConfirmReadDialog;
            if (this.f17318w == 0) {
                this.f17303h.setVisibility(8);
            } else {
                alertConfirmReadDialog.m41747P();
            }
            this.f17303h.setEnabled(false);
        } else if (i == 1) {
            this.f17303h.setText("已完成");
            this.f17303h.setEnabled(false);
        } else if (i == 2) {
            this.f17303h.setText("开始答题");
            this.f17303h.setEnabled(true);
        } else if (i == 3) {
            this.f17303h.setText("查看答题");
            this.f17303h.setEnabled(true);
        } else {
            this.f17303h.setVisibility(8);
            this.f17303h.setEnabled(false);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f17303h = (Button) m57916c(C4215R.C4219id.bt_question);
        this.f17304i = (LinearLayout) m57916c(2131232167);
        this.f17305j = (TextView) m57916c(C4215R.C4219id.tv_zan);
        this.f17306k = (TextView) m57916c(C4215R.C4219id.tv_collect);
        this.f17307l = (TextView) m57916c(C4215R.C4219id.tv_wechat);
        this.f17308m = (TextView) m57916c(C4215R.C4219id.tv_moments);
        this.f17309n = (TextView) m57916c(C4215R.C4219id.tv_qq);
        this.f17310o = (TextView) m57916c(C4215R.C4219id.tv_qzone);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_bottom;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 170 && resultCode == 187) {
            AlertConfirmReadDialog alertConfirmReadDialog = this.f17302D;
            if (alertConfirmReadDialog != null) {
                alertConfirmReadDialog.m41761B();
            }
            new iOSOneButtonDialog(this.f1678e).setMessage("人脸识别成功，请继续学习").show();
        } else if (requestCode == 170 && resultCode == 170) {
            startActivityForResult(data.setClass(this.f1678e, FaceDetectExamActivity.class), requestCode);
            this.f1679f.overridePendingTransition(2130771987, 2130771986);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        AlertConfirmReadDialog alertConfirmReadDialog = this.f17302D;
        if (alertConfirmReadDialog != null) {
            TimerTask timerTask = alertConfirmReadDialog.f17372m;
            if (timerTask != null) {
                timerTask.cancel();
            }
            Timer timer = this.f17302D.f17371l;
            if (timer != null) {
                timer.cancel();
            }
            AlertConfirmReadDialog alertConfirmReadDialog2 = this.f17302D;
            Handler handler = alertConfirmReadDialog2.f17378s;
            if (handler != null) {
                handler.removeCallbacks(alertConfirmReadDialog2.f17372m);
            }
        }
        super.onDestroy();
    }

    /* renamed from: s0 */
    public void m41788s0(BaseMediaObject baseMediaObject) {
        this.f17311p = baseMediaObject;
    }
}
