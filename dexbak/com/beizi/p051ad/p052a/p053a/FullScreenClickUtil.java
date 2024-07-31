package com.beizi.p051ad.p052a.p053a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;

/* renamed from: com.beizi.ad.a.a.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FullScreenClickUtil {

    /* renamed from: a */
    private Context f9447a;

    /* renamed from: b */
    private AdSpacesBean.BuyerBean.FullScreenClickBean f9448b;

    /* renamed from: c */
    private AdSpacesBean.BuyerBean.FullScreenClickBean f9449c;

    /* renamed from: e */
    private int f9451e;

    /* renamed from: d */
    private InterfaceC2764a f9450d = null;

    /* renamed from: f */
    private boolean f9452f = false;

    /* compiled from: FullScreenClickUtil.java */
    /* renamed from: com.beizi.ad.a.a.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2764a {
        /* renamed from: a */
        void mo49678a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public FullScreenClickUtil(Context context, AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean, String str) {
        this.f9447a = context;
        this.f9448b = fullScreenClickBean;
        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean m50156a = m50156a(fullScreenClickBean.getOrderData(), str);
        if (m50156a != null && m50156a.getFullScreenClick() != null) {
            this.f9449c = m50156a.getFullScreenClick();
        }
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean2 = this.f9449c;
        if (fullScreenClickBean2 != null) {
            this.f9451e = fullScreenClickBean2.getRandomClickNum();
            return;
        }
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean3 = this.f9448b;
        if (fullScreenClickBean3 != null) {
            this.f9451e = fullScreenClickBean3.getRandomClickNum();
        }
    }

    /* renamed from: a */
    public void m50157a(View view, final InterfaceC2764a interfaceC2764a) {
        if (view == null || interfaceC2764a == null || !m50158a(this.f9451e)) {
            return;
        }
        this.f9452f = true;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.b.1

            /* renamed from: a */
            float f9453a;

            /* renamed from: b */
            float f9454b;

            /* renamed from: c */
            float f9455c;

            /* renamed from: d */
            float f9456d;

            /* renamed from: e */
            float f9457e;

            /* renamed from: f */
            float f9458f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterfaceC2764a interfaceC2764a2;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f9453a = motionEvent.getX();
                    this.f9454b = motionEvent.getY();
                    this.f9455c = motionEvent.getRawX();
                    this.f9456d = motionEvent.getRawY();
                    this.f9457e = motionEvent.getX();
                    this.f9458f = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        this.f9457e = motionEvent.getX();
                        this.f9458f = motionEvent.getY();
                    }
                } else if (Math.abs(this.f9457e - this.f9453a) <= 15.0f && Math.abs(this.f9458f - this.f9454b) <= 15.0f && (interfaceC2764a2 = interfaceC2764a) != null) {
                    interfaceC2764a2.mo49678a(String.valueOf(this.f9453a), String.valueOf(this.f9454b), String.valueOf(this.f9455c), String.valueOf(this.f9456d), String.valueOf(this.f9453a), String.valueOf(this.f9454b), String.valueOf(this.f9455c), String.valueOf(this.f9456d));
                }
                return true;
            }
        });
    }

    /* renamed from: b */
    public void m50155b() {
        this.f9448b = null;
        this.f9449c = null;
        this.f9450d = null;
        this.f9447a = null;
    }

    /* renamed from: a */
    public static boolean m50158a(int i) {
        return ((int) ((Math.random() * 100.0d) + 1.0d)) <= i;
    }

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean m50156a(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
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

    /* renamed from: a */
    public boolean m50159a() {
        return this.f9452f;
    }
}
