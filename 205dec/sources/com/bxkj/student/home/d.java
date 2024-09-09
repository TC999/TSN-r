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
import com.bxkj.base.chat.ConversationListActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.competition.electronicentry.CompeteListActivity;
import com.bxkj.competition.signup.CompetitionListActivity;
import com.bxkj.equipment.ApplyEquipmentActivity;
import com.bxkj.equipment.history.RecordListActivity;
import com.bxkj.place.apply.SchoolDistrictActivity;
import com.bxkj.place.history.ApplyHistoryListActivity;
import com.bxkj.student.home.physicaltest.AdmissionTicketActivity;
import com.bxkj.student.home.physicaltest.InputEyeScoreActivity;
import com.bxkj.student.home.physicaltest.calc.CalcActivity;
import com.bxkj.student.home.physicaltest.mc.ApplyMcListActivity;
import com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity;
import com.bxkj.student.home.physicaltest.monitor.reservation.MonitorDescriptionActivity;
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
import java.util.Map;
import l.b;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MenuOperate.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private FragmentActivity f19712a;

    /* renamed from: b  reason: collision with root package name */
    private Context f19713b;

    /* renamed from: c  reason: collision with root package name */
    private String f19714c;

    /* renamed from: d  reason: collision with root package name */
    private String f19715d;

    /* renamed from: e  reason: collision with root package name */
    private Toast f19716e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MenuOperate.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements b.a {
        a() {
        }

        @Override // l.b.a
        public void a(@NotNull String[] strings) {
            new iOSOneButtonDialog(d.this.f19713b).setMessage(d.this.f19713b.getString(2131821263)).show();
        }

        @Override // l.b.a
        public void b() {
            d.this.f19713b.startActivity(new Intent(d.this.f19713b, StartRunActivity.class));
        }

        @Override // l.b.a
        public void c(@NotNull String[] strings) {
            new iOSOneButtonDialog(d.this.f19713b).setMessage(d.this.f19713b.getString(2131821263)).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MenuOperate.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19718a;

        b(final String val$menu) {
            this.f19718a = val$menu;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(d.this.f19713b).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (this.f19718a.equals("\u73ed\u957f\u9884\u7ea6")) {
                d.this.f19713b.startActivity(new Intent(d.this.f19713b, MonitorDescriptionActivity.class));
            } else {
                d.this.f19713b.startActivity(new Intent(d.this.f19713b, MonitorRecordListActivity.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MenuOperate.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements iOSTwoButtonDialog.RightButtonOnClick {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: MenuOperate.java */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                new iOSOneButtonDialog(d.this.f19713b).setMessage(msg).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                new iOSOneButtonDialog(d.this.f19713b).setMessage("\u5df2\u63d0\u4ea4\u7533\u8bf7").show();
            }
        }

        c() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(d.this.f19713b).hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).C(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
        }
    }

    public d(FragmentActivity mActivity, String icon, String menu) {
        this.f19712a = mActivity;
        this.f19713b = mActivity;
        this.f19714c = icon;
        this.f19715d = menu;
    }

    private void c() {
        new iOSTwoButtonDialog(this.f19713b).setMessage("\u786e\u5b9a\u8981\u7533\u8bf7\u73ed\u957f\u5417\uff1f").setRightButtonOnClickListener(new c()).show();
    }

    private void d(final String menu) {
        Http.with(this.f19713b).hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).j(LoginUser.getLoginUser().getUserId())).setDataListener(new b(menu));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        this.f19712a.startActivity(intent);
    }

    public void f() {
        if (!LoginUser.getLoginUser().isLogin() && !"\u4f53\u6d4b\u8ba1\u7b97\u5668".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, LoginActivity.class));
        } else if ("\u66f4\u591a".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, HomeMenuListActivity.class));
        } else if ("\u7ade\u8d5b\u62a5\u540d".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, CompetitionListActivity.class));
        } else if ("\u7ade\u8d5b\u8bb0\u5f55".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, com.bxkj.competition.score.CompetitionListActivity.class));
        } else if ("\u53d1\u5e03\u901a\u8baf\u7a3f".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, com.bxkj.competition.newsletter.CompetitionListActivity.class));
        } else if ("\u7535\u5b50\u53c2\u8d5b\u8bc1".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, CompeteListActivity.class));
        } else if ("\u7406\u8bba\u8003\u8bd5".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, ExamListActivity.class).putExtra("title", "\u7406\u8bba\u8003\u8bd5\u8bfe\u7a0b").putExtra("onlineType", 0));
        } else if ("\u4f53\u80b2\u4e13\u4e1a\u9898\u5e93".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, ExamListActivity.class).putExtra("title", this.f19715d).putExtra("onlineType", 1));
        } else if ("\u4f53\u80b2\u77e5\u8bc6\u7ade\u8d5b".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, ExamListActivity.class).putExtra("title", this.f19715d).putExtra("onlineType", 2));
        } else if ("\u8bc4\u4ef7\u6559\u5e08".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, EvaluateListActivity.class));
        } else if ("\u4f53\u6d4b\u6210\u7ee9".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, TestScoreListActivity.class));
        } else if ("\u9884\u7ea6\u4f53\u6d4b".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, DescriptionActivity.class));
        } else if ("\u4f53\u6d4b\u9884\u7ea6\u8bb0\u5f55".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, MyReservationListActivity.class));
        } else if ("\u573a\u9986\u9884\u7ea6\u8bb0\u5f55".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, ApplyHistoryListActivity.class).putExtra("appointType", 1));
        } else if ("\u73ed\u957f\u9884\u7ea6".equals(this.f19715d)) {
            d("\u73ed\u957f\u9884\u7ea6");
        } else if ("\u7533\u8bf7\u73ed\u957f".equals(this.f19715d)) {
            c();
        } else if ("\u73ed\u957f\u8bb0\u5f55".equals(this.f19715d)) {
            d("\u73ed\u957f\u8bb0\u5f55");
        } else if ("\u7533\u8bf7\u514d\u6d4b".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, ApplyMcListActivity.class));
        } else if ("\u4f53\u6d4b\u8ba1\u7b97\u5668".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, CalcActivity.class));
        } else if ("\u7533\u8bf7\u72b6\u6001".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, ApplyHealthStatusListActivity.class));
        } else if ("\u9884\u7ea6\u573a\u9986".equals(this.f19715d)) {
            if (LoginUser.getLoginUser().getSchoolId().equals("342")) {
                Context context = this.f19713b;
                Intent putExtra = new Intent(this.f19713b, H5DetailActivity.class).putExtra("title", "\u9884\u7ea6\u573a\u9986");
                context.startActivity(putExtra.putExtra("url", "http://swufecg.tsnkj.com/#/pages/login/phone-login?u=" + LoginUser.getLoginUser().getAccount()));
                return;
            }
            this.f19713b.startActivity(new Intent(this.f19713b, SchoolDistrictActivity.class).putExtra("appointType", 1));
        } else if ("\u7533\u8bf7\u573a\u9986".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, SchoolDistrictActivity.class).putExtra("appointType", 2));
        } else if ("\u7533\u8bf7\u8bb0\u5f55".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, ApplyHistoryListActivity.class).putExtra("appointType", 2));
        } else if ("\u4e0a\u8bfe\u8bf7\u5047".equals(this.f19715d)) {
            this.f19713b.startActivity(new Intent(this.f19713b, SelectLessenListActivity.class));
        } else {
            if (("\u5728\u7ebf\u9009" + LoginUser.getLoginUser().getXuanAfterLabelName()).equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, LessonDescriptionActivity.class));
                return;
            }
            if (("\u67e5\u770b" + LoginUser.getLoginUser().getViewAfterLabelName()).equals(this.f19715d)) {
                Context context2 = this.f19713b;
                Intent intent = new Intent(this.f19713b, ViewTermActivity.class);
                context2.startActivity(intent.putExtra("from", "\u67e5\u770b" + LoginUser.getLoginUser().getViewAfterLabelName()));
            } else if ("\u67e5\u770b\u70b9\u540d".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, ViewTermActivity.class).putExtra("from", "\u67e5\u770b\u70b9\u540d"));
            } else if ("\u4e0a\u8bfe\u7b7e\u5230".equals(this.f19715d)) {
                if (!((LocationManager) this.f19712a.getSystemService("location")).isProviderEnabled("gps")) {
                    new iOSTwoButtonDialog(this.f19713b).setTitle("GPS\u672a\u5f00\u542f").setMessage("\u4e3a\u4e86\u6b63\u5e38\u4e0a\u8bfe\u7b7e\u5230\uff0c\u9700\u8981\u4f60\u5f00\u542fGPS\u5b9a\u4f4d\u529f\u80fd\u3002").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.c
                        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                        public final void buttonRightOnClick() {
                            d.this.e();
                        }
                    }).show();
                } else {
                    this.f19713b.startActivity(new Intent(this.f19713b, BleSignActivity.class));
                }
            } else if ("\u7ed1\u5b9aKeep\u8d26\u53f7".equals(this.f19715d)) {
                if (TextUtils.isEmpty(LoginUser.getLoginUser().getKeepToken())) {
                    this.f19713b.startActivity(new Intent(this.f19713b, KeepAuthH5Activity.class));
                } else {
                    new iOSOneButtonDialog(this.f19713b).setMessage("\u5df2\u7ed1\u5b9akeep\u8d26\u53f7").show();
                }
            } else if ("\u540c\u6b65Keep\u6570\u636e".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, SyncKeepDataActivity.class));
            } else if ("App\u8dd1\u6b65".equals(this.f19715d)) {
                new l.b(this.f19712a).c("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION").d(new a());
            } else if ("\u7533\u8bf7\u514d\u8dd1".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, ApplyAvoidRunListActivity.class));
            } else if ("\u953b\u70bc\u8003\u52e4".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, TotalActivity.class));
            } else if ("\u671f\u672b\u6210\u7ee9".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, com.bxkj.student.home.teaching.resultfinal.ViewTermActivity.class));
            } else if ("\u573a\u9986\u6253\u5361".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, SignListActivity.class));
            } else if ("\u9884\u7ea6\u6d3b\u52a8".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, BookingActivity.class));
            } else if ("\u6211\u7684\u6d3b\u52a8".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, MyBookingListActivity.class));
            } else if ("\u501f\u7528\u5668\u6750".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, ApplyEquipmentActivity.class));
            } else if ("\u501f\u7528\u8bb0\u5f55".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, RecordListActivity.class));
            } else if ("\u5728\u7ebf\u5b66\u4e60".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, LearnDescriptionActivity.class));
            } else if ("\u81ea\u52a9\u89c6\u529b".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, InputEyeScoreActivity.class));
            } else if ("\u9884\u7ea6\u8003\u8bd5".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, ExamLessonListActivity.class));
            } else if ("\u8bfe\u540e\u4f5c\u4e1a".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, com.bxkj.student.home.teaching.homework.ViewTermActivity.class));
            } else if ("\u5e08\u751f\u4e92\u52a8".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, ConversationListActivity.class));
            } else if ("\u4f53\u6d4b\u51c6\u8003\u8bc1".equals(this.f19715d)) {
                this.f19713b.startActivity(new Intent(this.f19713b, AdmissionTicketActivity.class));
            } else {
                g("\u6682\u672a\u5f00\u653e\uff0c\u656c\u8bf7\u671f\u5f85");
            }
        }
    }

    public void g(CharSequence charSequence) {
        Toast toast = this.f19716e;
        if (toast == null) {
            this.f19716e = Toast.makeText(this.f19713b, charSequence, 0);
        } else {
            toast.cancel();
            this.f19716e.setText(charSequence);
        }
        this.f19716e.show();
    }
}
