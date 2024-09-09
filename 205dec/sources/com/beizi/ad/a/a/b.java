package com.beizi.ad.a.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FullScreenClickUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f13152a;

    /* renamed from: b  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.FullScreenClickBean f13153b;

    /* renamed from: c  reason: collision with root package name */
    private AdSpacesBean.BuyerBean.FullScreenClickBean f13154c;

    /* renamed from: e  reason: collision with root package name */
    private int f13156e;

    /* renamed from: d  reason: collision with root package name */
    private a f13155d = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13157f = false;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: FullScreenClickUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public b(Context context, AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean, String str) {
        this.f13152a = context;
        this.f13153b = fullScreenClickBean;
        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean a4 = a(fullScreenClickBean.getOrderData(), str);
        if (a4 != null && a4.getFullScreenClick() != null) {
            this.f13154c = a4.getFullScreenClick();
        }
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean2 = this.f13154c;
        if (fullScreenClickBean2 != null) {
            this.f13156e = fullScreenClickBean2.getRandomClickNum();
            return;
        }
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean3 = this.f13153b;
        if (fullScreenClickBean3 != null) {
            this.f13156e = fullScreenClickBean3.getRandomClickNum();
        }
    }

    public void a(View view, final a aVar) {
        if (view == null || aVar == null || !a(this.f13156e)) {
            return;
        }
        this.f13157f = true;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.b.1

            /* renamed from: a  reason: collision with root package name */
            float f13158a;

            /* renamed from: b  reason: collision with root package name */
            float f13159b;

            /* renamed from: c  reason: collision with root package name */
            float f13160c;

            /* renamed from: d  reason: collision with root package name */
            float f13161d;

            /* renamed from: e  reason: collision with root package name */
            float f13162e;

            /* renamed from: f  reason: collision with root package name */
            float f13163f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a aVar2;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f13158a = motionEvent.getX();
                    this.f13159b = motionEvent.getY();
                    this.f13160c = motionEvent.getRawX();
                    this.f13161d = motionEvent.getRawY();
                    this.f13162e = motionEvent.getX();
                    this.f13163f = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        this.f13162e = motionEvent.getX();
                        this.f13163f = motionEvent.getY();
                    }
                } else if (Math.abs(this.f13162e - this.f13158a) <= 15.0f && Math.abs(this.f13163f - this.f13159b) <= 15.0f && (aVar2 = aVar) != null) {
                    aVar2.a(String.valueOf(this.f13158a), String.valueOf(this.f13159b), String.valueOf(this.f13160c), String.valueOf(this.f13161d), String.valueOf(this.f13158a), String.valueOf(this.f13159b), String.valueOf(this.f13160c), String.valueOf(this.f13161d));
                }
                return true;
            }
        });
    }

    public void b() {
        this.f13153b = null;
        this.f13154c = null;
        this.f13155d = null;
        this.f13152a = null;
    }

    public static boolean a(int i4) {
        return ((int) ((Math.random() * 100.0d) + 1.0d)) <= i4;
    }

    private AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean a(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean : list) {
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
                }
            }
        }
        return null;
    }

    public boolean a() {
        return this.f13157f;
    }
}
