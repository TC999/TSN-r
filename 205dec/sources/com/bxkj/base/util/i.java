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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
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
import retrofit2.Response;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DropDownSpinnerDialog.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Context f18399a;

    /* renamed from: b  reason: collision with root package name */
    private List<Map<String, Object>> f18400b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final DateFormat f18401c = new SimpleDateFormat("yyyy-MM-dd");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DropDownSpinnerDialog.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f18402a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18403b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18404c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18405d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f18406e;

        a(TextView textView, String str, String str2, String str3, c cVar) {
            this.f18402a = textView;
            this.f18403b = str;
            this.f18404c = str2;
            this.f18405d = str3;
            this.f18406e = cVar;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            i.this.f18400b = (List) map.get("data");
            i iVar = i.this;
            iVar.i(this.f18402a, this.f18403b, iVar.f18400b, this.f18404c, this.f18405d, this.f18406e);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DropDownSpinnerDialog.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b {
        void a(String str);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DropDownSpinnerDialog.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface c {
        void a(String str, String str2, Map<String, Object> map);
    }

    public i(Context context) {
        this.f18399a = context;
    }

    private void e(Dialog dialog, int i4) {
        View findViewById = dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (findViewById != null) {
            findViewById.setBackgroundColor(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(TextView textView, b bVar, DatePicker datePicker, int i4, int i5, int i6) {
        String str = i4 + "-" + (i5 + 1) + "-" + i6;
        try {
            DateFormat dateFormat = this.f18401c;
            str = dateFormat.format(dateFormat.parse(str));
        } catch (ParseException e4) {
            e4.printStackTrace();
        }
        textView.setText(str);
        if (bVar != null) {
            bVar.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(List list, String str, TextView textView, String[] strArr, c cVar, DialogInterface dialogInterface, int i4) {
        Map<String, Object> map = (Map) list.get(i4);
        String string = JsonParse.getString(map, str);
        textView.setTag(string);
        String str2 = strArr[i4];
        textView.setText(str2);
        if (cVar != null) {
            cVar.a(string, str2, map);
        }
    }

    public void h(final TextView textView, final b bVar) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(new Date());
        new DatePickerDialog(this.f18399a, new DatePickerDialog.OnDateSetListener() { // from class: com.bxkj.base.util.g
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                i.this.f(textView, bVar, datePicker, i4, i5, i6);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    public i i(final TextView textView, String str, final List<Map<String, Object>> list, final String str2, String str3, final c cVar) {
        final String[] strArr = new String[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            strArr[i4] = cn.bluemobi.dylan.base.utils.u.O(list.get(i4), str3);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f18399a);
        View inflate = LayoutInflater.from(this.f18399a).inflate(R.layout.dialog_title, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tvTitle)).setText(str);
        builder.setCustomTitle(inflate);
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.bxkj.base.util.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                i.g(list, str2, textView, strArr, cVar, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        e(create, Color.parseColor("#999999"));
        return this;
    }

    public i j(TextView textView, String str, rx.e<Response<ResponseBody>> eVar, c cVar) {
        k(textView, str, eVar, "id", "name", cVar);
        return this;
    }

    public i k(TextView textView, String str, rx.e<Response<ResponseBody>> eVar, String str2, String str3, c cVar) {
        List<Map<String, Object>> list = this.f18400b;
        if (list != null && list.size() > 0) {
            i(textView, str, this.f18400b, str2, str3, cVar);
        } else {
            Http.with(this.f18399a).setObservable(eVar).setDataListener(new a(textView, str, str2, str3, cVar));
        }
        return this;
    }
}
