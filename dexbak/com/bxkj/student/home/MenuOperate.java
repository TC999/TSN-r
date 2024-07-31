package com.bxkj.student.home;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bxkj.base.chat.ConversationListActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.competition.electronicentry.CompeteListActivity;
import com.bxkj.competition.signup.CompetitionListActivity;
import com.bxkj.equipment.ApplyEquipmentActivity;
import com.bxkj.equipment.history.RecordListActivity;
import com.bxkj.place.apply.SchoolDistrictActivity;
import com.bxkj.place.history.ApplyHistoryListActivity;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.physicaltest.AdmissionTicketActivity;
import com.bxkj.student.home.physicaltest.InputEyeScoreActivity;
import com.bxkj.student.home.physicaltest.calc.CalcActivity;
import com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity;
import com.bxkj.student.home.physicaltest.monitor.reservation.MonitorDescriptionActivity;
import com.bxkj.student.home.physicaltest.p089mc.ApplyMcListActivity;
import com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity;
import com.bxkj.student.home.physicaltest.personal.reservation.DescriptionActivity;
import com.bxkj.student.home.physicaltest.scanscore.TestScoreListActivity;
import com.bxkj.student.home.teaching.activity.BookingActivity;
import com.bxkj.student.home.teaching.activity.MyBookingListActivity;
import com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity;
import com.bxkj.student.home.teaching.exam.ExamListActivity;
import com.bxkj.student.home.teaching.healthstatus.ApplyHealthStatusListActivity;
import com.bxkj.student.home.teaching.learning.ready.LearnDescriptionActivity;
import com.bxkj.student.home.teaching.leave.SelectLessenListActivity;
import com.bxkj.student.home.teaching.lesson.LessonDescriptionActivity;
import com.bxkj.student.home.teaching.lesson.ViewTermActivity;
import com.bxkj.student.home.teaching.rollcall.BleSignActivity;
import com.bxkj.student.home.teaching.separateexam.ExamLessonListActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.apply.ApplyAvoidRunListActivity;
import com.bxkj.student.run.app.keep.KeepAuthH5Activity;
import com.bxkj.student.run.app.keep.SyncKeepDataActivity;
import com.bxkj.student.run.extraclass.SignListActivity;
import com.bxkj.student.run.punchcard.TotalActivity;
import com.kuaishou.weapon.p205p0.C7282g;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import p615l.RequestPermission;
import p653w.InterfaceC16236a;

/* renamed from: com.bxkj.student.home.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MenuOperate {

    /* renamed from: a */
    private FragmentActivity f16322a;

    /* renamed from: b */
    private Context f16323b;

    /* renamed from: c */
    private String f16324c;

    /* renamed from: d */
    private String f16325d;

    /* renamed from: e */
    private Toast f16326e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuOperate.java */
    /* renamed from: com.bxkj.student.home.d$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4312a implements RequestPermission.InterfaceC15268a {
        C4312a() {
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: a */
        public void mo3478a(@NotNull String[] strings) {
            new iOSOneButtonDialog(MenuOperate.this.f16323b).setMessage(MenuOperate.this.f16323b.getString(C4215R.C4224string.run_permission_hint)).show();
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: b */
        public void mo3477b() {
            MenuOperate.this.f16323b.startActivity(new Intent(MenuOperate.this.f16323b, StartRunActivity.class));
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: c */
        public void mo3476c(@NotNull String[] strings) {
            new iOSOneButtonDialog(MenuOperate.this.f16323b).setMessage(MenuOperate.this.f16323b.getString(C4215R.C4224string.run_permission_hint)).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuOperate.java */
    /* renamed from: com.bxkj.student.home.d$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4313b extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ String f16328a;

        C4313b(final String val$menu) {
            this.f16328a = val$menu;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(MenuOperate.this.f16323b).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (this.f16328a.equals("班长预约")) {
                MenuOperate.this.f16323b.startActivity(new Intent(MenuOperate.this.f16323b, MonitorDescriptionActivity.class));
            } else {
                MenuOperate.this.f16323b.startActivity(new Intent(MenuOperate.this.f16323b, MonitorRecordListActivity.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuOperate.java */
    /* renamed from: com.bxkj.student.home.d$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4314c implements iOSTwoButtonDialog.RightButtonOnClick {

        /* compiled from: MenuOperate.java */
        /* renamed from: com.bxkj.student.home.d$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4315a extends HttpCallBack {
            C4315a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                new iOSOneButtonDialog(MenuOperate.this.f16323b).setMessage(msg).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                new iOSOneButtonDialog(MenuOperate.this.f16323b).setMessage("已提交申请").show();
            }
        }

        C4314c() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(MenuOperate.this.f16323b).hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m183C(LoginUser.getLoginUser().getUserId())).setDataListener(new C4315a());
        }
    }

    public MenuOperate(FragmentActivity mActivity, String icon, String menu) {
        this.f16322a = mActivity;
        this.f16323b = mActivity;
        this.f16324c = icon;
        this.f16325d = menu;
    }

    /* renamed from: c */
    private void m42715c() {
        new iOSTwoButtonDialog(this.f16323b).setMessage("确定要申请班长吗？").setRightButtonOnClickListener(new C4314c()).show();
    }

    /* renamed from: d */
    private void m42714d(final String menu) {
        Http.with(this.f16323b).hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m102j(LoginUser.getLoginUser().getUserId())).setDataListener(new C4313b(menu));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m42713e() {
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        this.f16322a.startActivity(intent);
    }

    /* renamed from: f */
    public void m42712f() {
        if (!LoginUser.getLoginUser().isLogin() && !"体测计算器".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, LoginActivity.class));
        } else if ("更多".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, HomeMenuListActivity.class));
        } else if ("竞赛报名".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, CompetitionListActivity.class));
        } else if ("竞赛记录".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, com.bxkj.competition.score.CompetitionListActivity.class));
        } else if ("发布通讯稿".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, com.bxkj.competition.newsletter.CompetitionListActivity.class));
        } else if ("电子参赛证".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, CompeteListActivity.class));
        } else if ("理论考试".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, ExamListActivity.class).putExtra("title", "理论考试课程").putExtra("onlineType", 0));
        } else if ("体育专业题库".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, ExamListActivity.class).putExtra("title", this.f16325d).putExtra("onlineType", 1));
        } else if ("体育知识竞赛".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, ExamListActivity.class).putExtra("title", this.f16325d).putExtra("onlineType", 2));
        } else if ("评价教师".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, EvaluateListActivity.class));
        } else if ("体测成绩".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, TestScoreListActivity.class));
        } else if ("预约体测".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, DescriptionActivity.class));
        } else if ("体测预约记录".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, MyReservationListActivity.class));
        } else if ("场馆预约记录".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, ApplyHistoryListActivity.class).putExtra("appointType", 1));
        } else if ("班长预约".equals(this.f16325d)) {
            m42714d("班长预约");
        } else if ("申请班长".equals(this.f16325d)) {
            m42715c();
        } else if ("班长记录".equals(this.f16325d)) {
            m42714d("班长记录");
        } else if ("申请免测".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, ApplyMcListActivity.class));
        } else if ("体测计算器".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, CalcActivity.class));
        } else if ("申请状态".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, ApplyHealthStatusListActivity.class));
        } else if ("预约场馆".equals(this.f16325d)) {
            if (LoginUser.getLoginUser().getSchoolId().equals("342")) {
                Context context = this.f16323b;
                Intent putExtra = new Intent(this.f16323b, H5DetailActivity.class).putExtra("title", "预约场馆");
                context.startActivity(putExtra.putExtra("url", "http://swufecg.tsnkj.com/#/pages/login/phone-login?u=" + LoginUser.getLoginUser().getAccount()));
                return;
            }
            this.f16323b.startActivity(new Intent(this.f16323b, SchoolDistrictActivity.class).putExtra("appointType", 1));
        } else if ("申请场馆".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, SchoolDistrictActivity.class).putExtra("appointType", 2));
        } else if ("申请记录".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, ApplyHistoryListActivity.class).putExtra("appointType", 2));
        } else if ("上课请假".equals(this.f16325d)) {
            this.f16323b.startActivity(new Intent(this.f16323b, SelectLessenListActivity.class));
        } else {
            if (("在线选" + LoginUser.getLoginUser().getXuanAfterLabelName()).equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, LessonDescriptionActivity.class));
                return;
            }
            if (("查看" + LoginUser.getLoginUser().getViewAfterLabelName()).equals(this.f16325d)) {
                Context context2 = this.f16323b;
                Intent intent = new Intent(this.f16323b, ViewTermActivity.class);
                context2.startActivity(intent.putExtra(Constants.FROM, "查看" + LoginUser.getLoginUser().getViewAfterLabelName()));
            } else if ("查看点名".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, ViewTermActivity.class).putExtra(Constants.FROM, "查看点名"));
            } else if ("上课签到".equals(this.f16325d)) {
                if (!((LocationManager) this.f16322a.getSystemService(SocializeConstants.KEY_LOCATION)).isProviderEnabled(GeocodeSearch.GPS)) {
                    new iOSTwoButtonDialog(this.f16323b).setTitle("GPS未开启").setMessage("为了正常上课签到，需要你开启GPS定位功能。").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.c
                        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                        public final void buttonRightOnClick() {
                            MenuOperate.this.m42713e();
                        }
                    }).show();
                } else {
                    this.f16323b.startActivity(new Intent(this.f16323b, BleSignActivity.class));
                }
            } else if ("绑定Keep账号".equals(this.f16325d)) {
                if (TextUtils.isEmpty(LoginUser.getLoginUser().getKeepToken())) {
                    this.f16323b.startActivity(new Intent(this.f16323b, KeepAuthH5Activity.class));
                } else {
                    new iOSOneButtonDialog(this.f16323b).setMessage("已绑定keep账号").show();
                }
            } else if ("同步Keep数据".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, SyncKeepDataActivity.class));
            } else if ("App跑步".equals(this.f16325d)) {
                new RequestPermission(this.f16322a).m3480c(C7282g.f24950h, C7282g.f24949g).m3479d(new C4312a());
            } else if ("申请免跑".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, ApplyAvoidRunListActivity.class));
            } else if ("锻炼考勤".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, TotalActivity.class));
            } else if ("期末成绩".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, com.bxkj.student.home.teaching.resultfinal.ViewTermActivity.class));
            } else if ("场馆打卡".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, SignListActivity.class));
            } else if ("预约活动".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, BookingActivity.class));
            } else if ("我的活动".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, MyBookingListActivity.class));
            } else if ("借用器材".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, ApplyEquipmentActivity.class));
            } else if ("借用记录".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, RecordListActivity.class));
            } else if ("在线学习".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, LearnDescriptionActivity.class));
            } else if ("自助视力".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, InputEyeScoreActivity.class));
            } else if ("预约考试".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, ExamLessonListActivity.class));
            } else if ("课后作业".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, com.bxkj.student.home.teaching.homework.ViewTermActivity.class));
            } else if ("师生互动".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, ConversationListActivity.class));
            } else if ("体测准考证".equals(this.f16325d)) {
                this.f16323b.startActivity(new Intent(this.f16323b, AdmissionTicketActivity.class));
            } else {
                m42711g("暂未开放，敬请期待");
            }
        }
    }

    /* renamed from: g */
    public void m42711g(CharSequence charSequence) {
        Toast toast = this.f16326e;
        if (toast == null) {
            this.f16326e = Toast.makeText(this.f16323b, charSequence, 0);
        } else {
            toast.cancel();
            this.f16326e.setText(charSequence);
        }
        this.f16326e.show();
    }
}
