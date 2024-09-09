package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.util.S;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.u  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1449u implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PageSettingTypeModel f6885a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6886b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ A f6887c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1449u(A a4, PageSettingTypeModel pageSettingTypeModel, String str) {
        this.f6887c = a4;
        this.f6885a = pageSettingTypeModel;
        this.f6886b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        String str;
        A a4;
        AccessibilityService accessibilityService;
        boolean z3;
        PageSettingTypeModel pageSettingTypeModel;
        Handler handler;
        Runnable runnableC1447s;
        String str2;
        String b4;
        String str3;
        String str4;
        String str5;
        try {
            A a5 = this.f6887c;
            if (a5.f6699r) {
                if (a5.f6692k == null) {
                    a5.f6692k = new ArrayList();
                    this.f6887c.f6693l = 0;
                }
                if (!V.a().b(this.f6887c.f6692k) || !V.a().a(this.f6887c.f6692k)) {
                    a4 = this.f6887c;
                    accessibilityService = a4.f6695n;
                    z3 = a4.f6699r;
                    pageSettingTypeModel = this.f6885a;
                    a4.a(accessibilityService, z3, pageSettingTypeModel.getRead_description());
                    return;
                }
                TimerTask timerTask = A.f6683b;
                if (timerTask != null) {
                    timerTask.cancel();
                    str5 = A.f6686e;
                    ra.a(str5, "gainContent cancle2");
                    A.f6683b = null;
                }
                str4 = A.f6686e;
                ra.a(str4, this.f6887c.f6692k.toString());
                handler = new Handler(Looper.getMainLooper());
                runnableC1447s = new r(this);
                handler.postDelayed(runnableC1447s, 0L);
            }
            if (a5.f6692k != null) {
                str3 = A.f6686e;
                ra.a(str3, this.f6887c.f6692k.toString());
            } else {
                a5.f6693l = 0;
                a5.f6692k = new ArrayList();
            }
            if (!V.a().a(this.f6887c.f6692k, this.f6885a.getPackage_name(), this.f6885a.getRead_length())) {
                a4 = this.f6887c;
                accessibilityService = a4.f6695n;
                z3 = a4.f6699r;
                pageSettingTypeModel = this.f6885a;
                a4.a(accessibilityService, z3, pageSettingTypeModel.getRead_description());
                return;
            }
            TimerTask timerTask2 = A.f6683b;
            if (timerTask2 != null) {
                timerTask2.cancel();
                A.f6683b = null;
            }
            this.f6887c.f6700s = "";
            if (this.f6885a.getPackage_name().equals(H.a().ta) && this.f6885a.getIs_click_jd_title().equals("0")) {
                String d4 = C1419ba.a().d("jd_view_id");
                str2 = A.f6686e;
                StringBuilder sb = new StringBuilder();
                sb.append("jd id =");
                sb.append(d4);
                ra.a(str2, sb.toString());
                if (!TextUtils.isEmpty(d4)) {
                    A a6 = this.f6887c;
                    b4 = a6.b(a6.f6695n, d4);
                    a6.f6700s = b4;
                    if (!TextUtils.isEmpty(this.f6887c.f6700s)) {
                        A a7 = this.f6887c;
                        a7.f6692k.add(a7.f6700s);
                    }
                }
            }
            handler = new Handler(Looper.getMainLooper());
            runnableC1447s = new RunnableC1447s(this);
            handler.postDelayed(runnableC1447s, 0L);
        } catch (Exception e4) {
            str = A.f6686e;
            ra.a(str, "gainContent=" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        String str;
        String str2;
        String str3;
        String str4;
        String b4;
        TimerTask timerTask = A.f6683b;
        if (timerTask != null) {
            timerTask.cancel();
            A.f6683b = null;
        }
        str = A.f6686e;
        ra.a(str, "gainContent finish");
        List<String> list = this.f6887c.f6692k;
        if (list == null || list.size() < 6) {
            return;
        }
        this.f6887c.f6700s = "";
        str2 = A.f6686e;
        ra.a(str2, "model.getPackage_name() =" + this.f6885a.getPackage_name() + "   model.getIs_click_jd_title()=" + this.f6885a.getIs_click_jd_title());
        if (this.f6885a.getPackage_name().equals(H.a().ta) && this.f6885a.getIs_click_jd_title().equals("0")) {
            String d4 = C1419ba.a().d("jd_view_id");
            str4 = A.f6686e;
            ra.a(str4, "jd id =" + d4);
            if (!TextUtils.isEmpty(d4)) {
                A a4 = this.f6887c;
                b4 = a4.b(a4.f6695n, d4);
                a4.f6700s = b4;
                if (!TextUtils.isEmpty(this.f6887c.f6700s)) {
                    A a5 = this.f6887c;
                    a5.f6692k.add(a5.f6700s);
                }
            }
        }
        str3 = A.f6686e;
        ra.a(str3, this.f6887c.f6692k.toString());
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1448t(this), 0L);
    }
}
