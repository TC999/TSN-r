package com.bxkj.base.util;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.C3801R;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;

/* renamed from: com.bxkj.base.util.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DropDownSpinnerDialog {

    /* renamed from: a */
    private Context f14915a;

    /* renamed from: b */
    private List<Map<String, Object>> f14916b = new ArrayList();

    /* renamed from: c */
    final DateFormat f14917c = new SimpleDateFormat("yyyy-MM-dd");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropDownSpinnerDialog.java */
    /* renamed from: com.bxkj.base.util.i$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3902a extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ TextView f14918a;

        /* renamed from: b */
        final /* synthetic */ String f14919b;

        /* renamed from: c */
        final /* synthetic */ String f14920c;

        /* renamed from: d */
        final /* synthetic */ String f14921d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC3904c f14922e;

        C3902a(TextView textView, String str, String str2, String str3, InterfaceC3904c interfaceC3904c) {
            this.f14918a = textView;
            this.f14919b = str;
            this.f14920c = str2;
            this.f14921d = str3;
            this.f14922e = interfaceC3904c;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            DropDownSpinnerDialog.this.f14916b = (List) map.get("data");
            DropDownSpinnerDialog dropDownSpinnerDialog = DropDownSpinnerDialog.this;
            dropDownSpinnerDialog.m44082i(this.f14918a, this.f14919b, dropDownSpinnerDialog.f14916b, this.f14920c, this.f14921d, this.f14922e);
        }
    }

    /* compiled from: DropDownSpinnerDialog.java */
    /* renamed from: com.bxkj.base.util.i$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3903b {
        /* renamed from: a */
        void m44079a(String str);
    }

    /* compiled from: DropDownSpinnerDialog.java */
    /* renamed from: com.bxkj.base.util.i$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3904c {
        /* renamed from: a */
        void mo41979a(String str, String str2, Map<String, Object> map);
    }

    public DropDownSpinnerDialog(Context context) {
        this.f14915a = context;
    }

    /* renamed from: e */
    private void m44086e(Dialog dialog, int i) {
        View findViewById = dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (findViewById != null) {
            findViewById.setBackgroundColor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m44085f(TextView textView, InterfaceC3903b interfaceC3903b, DatePicker datePicker, int i, int i2, int i3) {
        String str = i + "-" + (i2 + 1) + "-" + i3;
        try {
            DateFormat dateFormat = this.f14917c;
            str = dateFormat.format(dateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        textView.setText(str);
        if (interfaceC3903b != null) {
            interfaceC3903b.m44079a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static /* synthetic */ void m44084g(List list, String str, TextView textView, String[] strArr, InterfaceC3904c interfaceC3904c, DialogInterface dialogInterface, int i) {
        Map<String, Object> map = (Map) list.get(i);
        String string = JsonParse.getString(map, str);
        textView.setTag(string);
        String str2 = strArr[i];
        textView.setText(str2);
        if (interfaceC3904c != null) {
            interfaceC3904c.mo41979a(string, str2, map);
        }
    }

    /* renamed from: h */
    public void m44083h(final TextView textView, final InterfaceC3903b interfaceC3903b) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(new Date());
        new DatePickerDialog(this.f14915a, new DatePickerDialog.OnDateSetListener() { // from class: com.bxkj.base.util.g
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                DropDownSpinnerDialog.this.m44085f(textView, interfaceC3903b, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    /* renamed from: i */
    public DropDownSpinnerDialog m44082i(final TextView textView, String str, final List<Map<String, Object>> list, final String str2, String str3, final InterfaceC3904c interfaceC3904c) {
        final String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = Tools.m57632O(list.get(i), str3);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f14915a);
        View inflate = LayoutInflater.from(this.f14915a).inflate(C3801R.C3807layout.dialog_title, (ViewGroup) null);
        ((TextView) inflate.findViewById(C3801R.C3805id.tvTitle)).setText(str);
        builder.setCustomTitle(inflate);
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.bxkj.base.util.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                DropDownSpinnerDialog.m44084g(list, str2, textView, strArr, interfaceC3904c, dialogInterface, i2);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        m44086e(create, Color.parseColor("#999999"));
        return this;
    }

    /* renamed from: j */
    public DropDownSpinnerDialog m44081j(TextView textView, String str, Observable<Response<ResponseBody>> observable, InterfaceC3904c interfaceC3904c) {
        m44080k(textView, str, observable, "id", "name", interfaceC3904c);
        return this;
    }

    /* renamed from: k */
    public DropDownSpinnerDialog m44080k(TextView textView, String str, Observable<Response<ResponseBody>> observable, String str2, String str3, InterfaceC3904c interfaceC3904c) {
        List<Map<String, Object>> list = this.f14916b;
        if (list != null && list.size() > 0) {
            m44082i(textView, str, this.f14916b, str2, str3, interfaceC3904c);
        } else {
            Http.with(this.f14915a).setObservable(observable).setDataListener(new C3902a(textView, str, str2, str3, interfaceC3904c));
        }
        return this;
    }
}
