package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OfflineChild.java */
/* renamed from: com.amap.api.col.3l.r3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class r3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private Context f8866b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f8867c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f8868d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f8869e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f8870f;

    /* renamed from: g  reason: collision with root package name */
    private OfflineMapManager f8871g;

    /* renamed from: h  reason: collision with root package name */
    private OfflineMapCity f8872h;

    /* renamed from: k  reason: collision with root package name */
    private View f8875k;

    /* renamed from: l  reason: collision with root package name */
    private DownloadProgressView f8876l;

    /* renamed from: a  reason: collision with root package name */
    private int f8865a = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8873i = false;

    /* renamed from: j  reason: collision with root package name */
    private Handler f8874j = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: OfflineChild.java */
    /* renamed from: com.amap.api.col.3l.r3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                r3.this.c(message.arg1, message.arg2);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public r3(Context context, OfflineMapManager offlineMapManager) {
        this.f8866b = context;
        f();
        this.f8871g = offlineMapManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, int i5) throws Exception {
        if (this.f8865a == 2 && i5 > 3 && i5 < 100) {
            this.f8876l.setVisibility(0);
            this.f8876l.setProgress(i5);
        } else {
            this.f8876l.setVisibility(8);
        }
        if (i4 == -1) {
            k();
        } else if (i4 == 0) {
            if (this.f8865a == 1) {
                this.f8869e.setVisibility(8);
                this.f8870f.setText("\u4e0b\u8f7d\u4e2d");
                this.f8870f.setTextColor(Color.parseColor("#4287ff"));
                return;
            }
            o();
        } else if (i4 == 1) {
            n();
        } else if (i4 == 2) {
            j();
        } else if (i4 == 3) {
            l();
        } else if (i4 == 4) {
            m();
        } else if (i4 == 6) {
            h();
        } else if (i4 != 7) {
            switch (i4) {
                case 101:
                case 102:
                case 103:
                    k();
                    return;
                default:
                    return;
            }
        } else {
            i();
        }
    }

    private void f() {
        View d4 = w3.d(this.f8866b, 2130903042);
        this.f8875k = d4;
        this.f8876l = (DownloadProgressView) d4.findViewById(2131165200);
        this.f8867c = (TextView) this.f8875k.findViewById(2131165195);
        this.f8868d = (TextView) this.f8875k.findViewById(2131165199);
        this.f8869e = (ImageView) this.f8875k.findViewById(2131165198);
        this.f8870f = (TextView) this.f8875k.findViewById(2131165197);
        this.f8869e.setOnClickListener(this);
    }

    private void g(int i4, int i5) {
        OfflineMapCity offlineMapCity = this.f8872h;
        if (offlineMapCity != null) {
            offlineMapCity.setState(i4);
            this.f8872h.setCompleteCode(i5);
        }
        Message message = new Message();
        message.arg1 = i4;
        message.arg2 = i5;
        this.f8874j.sendMessage(message);
    }

    private void h() {
        this.f8870f.setVisibility(8);
        this.f8869e.setVisibility(0);
        this.f8869e.setImageResource(2130837506);
    }

    private void i() {
        this.f8870f.setVisibility(0);
        this.f8869e.setVisibility(0);
        this.f8869e.setImageResource(2130837506);
        this.f8870f.setText("\u5df2\u4e0b\u8f7d-\u6709\u66f4\u65b0");
    }

    private void j() {
        if (this.f8865a == 1) {
            this.f8869e.setVisibility(8);
            this.f8870f.setVisibility(0);
            this.f8870f.setText("\u7b49\u5f85\u4e2d");
            this.f8870f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.f8870f.setVisibility(0);
        this.f8869e.setVisibility(8);
        this.f8870f.setTextColor(Color.parseColor("#4287ff"));
        this.f8870f.setText("\u7b49\u5f85\u4e2d");
    }

    private void k() {
        this.f8870f.setVisibility(0);
        this.f8869e.setVisibility(8);
        this.f8870f.setTextColor(-65536);
        this.f8870f.setText("\u4e0b\u8f7d\u51fa\u73b0\u5f02\u5e38");
    }

    private void l() {
        this.f8870f.setVisibility(0);
        this.f8869e.setVisibility(8);
        this.f8870f.setTextColor(-7829368);
        this.f8870f.setText("\u6682\u505c");
    }

    private void m() {
        this.f8870f.setVisibility(0);
        this.f8869e.setVisibility(8);
        this.f8870f.setText("\u5df2\u4e0b\u8f7d");
        this.f8870f.setTextColor(Color.parseColor("#898989"));
    }

    private void n() {
        if (this.f8865a == 1) {
            return;
        }
        this.f8870f.setVisibility(0);
        this.f8869e.setVisibility(8);
        this.f8870f.setText("\u89e3\u538b\u4e2d");
        this.f8870f.setTextColor(Color.parseColor("#898989"));
    }

    private void o() {
        if (this.f8872h == null) {
            return;
        }
        this.f8870f.setVisibility(0);
        this.f8870f.setText("\u4e0b\u8f7d\u4e2d");
        this.f8869e.setVisibility(8);
        this.f8870f.setTextColor(Color.parseColor("#4287ff"));
    }

    private synchronized void p() {
        this.f8871g.pause();
        this.f8871g.restart();
    }

    private synchronized boolean q() {
        try {
            this.f8871g.downloadByCityName(this.f8872h.getCity());
        } catch (AMapException e4) {
            e4.printStackTrace();
            Toast.makeText(this.f8866b, e4.getErrorMessage(), 0).show();
            return false;
        }
        return true;
    }

    public final View a() {
        return this.f8875k;
    }

    public final void b(int i4) {
        this.f8865a = i4;
    }

    public final void e(OfflineMapCity offlineMapCity) {
        double d4;
        if (offlineMapCity != null) {
            this.f8872h = offlineMapCity;
            this.f8867c.setText(offlineMapCity.getCity());
            double size = offlineMapCity.getSize();
            Double.isNaN(size);
            Double.isNaN((int) (((size / 1024.0d) / 1024.0d) * 100.0d));
            this.f8868d.setText(String.valueOf(d4 / 100.0d) + " M");
            g(this.f8872h.getState(), this.f8872h.getcompleteCode());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (!a3.h0(this.f8866b)) {
                Toast.makeText(this.f8866b, "\u65e0\u7f51\u7edc\u8fde\u63a5", 0).show();
                return;
            }
            OfflineMapCity offlineMapCity = this.f8872h;
            if (offlineMapCity != null) {
                int state = offlineMapCity.getState();
                this.f8872h.getcompleteCode();
                if (state == 0) {
                    p();
                    l();
                } else if (state == 1 || state == 4) {
                } else {
                    if (q()) {
                        j();
                    } else {
                        k();
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
