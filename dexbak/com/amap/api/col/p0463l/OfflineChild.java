package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* renamed from: com.amap.api.col.3l.r3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OfflineChild implements View.OnClickListener {

    /* renamed from: b */
    private Context f5160b;

    /* renamed from: c */
    private TextView f5161c;

    /* renamed from: d */
    private TextView f5162d;

    /* renamed from: e */
    private ImageView f5163e;

    /* renamed from: f */
    private TextView f5164f;

    /* renamed from: g */
    private OfflineMapManager f5165g;

    /* renamed from: h */
    private OfflineMapCity f5166h;

    /* renamed from: k */
    private View f5169k;

    /* renamed from: l */
    private DownloadProgressView f5170l;

    /* renamed from: a */
    private int f5159a = 0;

    /* renamed from: i */
    private boolean f5167i = false;

    /* renamed from: j */
    private Handler f5168j = new HandlerC1928a();

    /* compiled from: OfflineChild.java */
    /* renamed from: com.amap.api.col.3l.r3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class HandlerC1928a extends Handler {
        HandlerC1928a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                OfflineChild.this.m54059c(message.arg1, message.arg2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public OfflineChild(Context context, OfflineMapManager offlineMapManager) {
        this.f5160b = context;
        m54056f();
        this.f5165g = offlineMapManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m54059c(int i, int i2) throws Exception {
        if (this.f5159a == 2 && i2 > 3 && i2 < 100) {
            this.f5170l.setVisibility(0);
            this.f5170l.setProgress(i2);
        } else {
            this.f5170l.setVisibility(8);
        }
        if (i == -1) {
            m54051k();
        } else if (i == 0) {
            if (this.f5159a == 1) {
                this.f5163e.setVisibility(8);
                this.f5164f.setText("下载中");
                this.f5164f.setTextColor(Color.parseColor("#4287ff"));
                return;
            }
            m54047o();
        } else if (i == 1) {
            m54048n();
        } else if (i == 2) {
            m54052j();
        } else if (i == 3) {
            m54050l();
        } else if (i == 4) {
            m54049m();
        } else if (i == 6) {
            m54054h();
        } else if (i != 7) {
            switch (i) {
                case 101:
                case 102:
                case 103:
                    m54051k();
                    return;
                default:
                    return;
            }
        } else {
            m54053i();
        }
    }

    /* renamed from: f */
    private void m54056f() {
        View m53597d = ServiceUtils.m53597d(this.f5160b, 2130903042);
        this.f5169k = m53597d;
        this.f5170l = (DownloadProgressView) m53597d.findViewById(2131165200);
        this.f5161c = (TextView) this.f5169k.findViewById(2131165195);
        this.f5162d = (TextView) this.f5169k.findViewById(2131165199);
        this.f5163e = (ImageView) this.f5169k.findViewById(2131165198);
        this.f5164f = (TextView) this.f5169k.findViewById(2131165197);
        this.f5163e.setOnClickListener(this);
    }

    /* renamed from: g */
    private void m54055g(int i, int i2) {
        OfflineMapCity offlineMapCity = this.f5166h;
        if (offlineMapCity != null) {
            offlineMapCity.setState(i);
            this.f5166h.setCompleteCode(i2);
        }
        Message message = new Message();
        message.arg1 = i;
        message.arg2 = i2;
        this.f5168j.sendMessage(message);
    }

    /* renamed from: h */
    private void m54054h() {
        this.f5164f.setVisibility(8);
        this.f5163e.setVisibility(0);
        this.f5163e.setImageResource(2130837506);
    }

    /* renamed from: i */
    private void m54053i() {
        this.f5164f.setVisibility(0);
        this.f5163e.setVisibility(0);
        this.f5163e.setImageResource(2130837506);
        this.f5164f.setText("已下载-有更新");
    }

    /* renamed from: j */
    private void m54052j() {
        if (this.f5159a == 1) {
            this.f5163e.setVisibility(8);
            this.f5164f.setVisibility(0);
            this.f5164f.setText("等待中");
            this.f5164f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.f5164f.setVisibility(0);
        this.f5163e.setVisibility(8);
        this.f5164f.setTextColor(Color.parseColor("#4287ff"));
        this.f5164f.setText("等待中");
    }

    /* renamed from: k */
    private void m54051k() {
        this.f5164f.setVisibility(0);
        this.f5163e.setVisibility(8);
        this.f5164f.setTextColor(SupportMenu.CATEGORY_MASK);
        this.f5164f.setText("下载出现异常");
    }

    /* renamed from: l */
    private void m54050l() {
        this.f5164f.setVisibility(0);
        this.f5163e.setVisibility(8);
        this.f5164f.setTextColor(-7829368);
        this.f5164f.setText("暂停");
    }

    /* renamed from: m */
    private void m54049m() {
        this.f5164f.setVisibility(0);
        this.f5163e.setVisibility(8);
        this.f5164f.setText("已下载");
        this.f5164f.setTextColor(Color.parseColor("#898989"));
    }

    /* renamed from: n */
    private void m54048n() {
        if (this.f5159a == 1) {
            return;
        }
        this.f5164f.setVisibility(0);
        this.f5163e.setVisibility(8);
        this.f5164f.setText("解压中");
        this.f5164f.setTextColor(Color.parseColor("#898989"));
    }

    /* renamed from: o */
    private void m54047o() {
        if (this.f5166h == null) {
            return;
        }
        this.f5164f.setVisibility(0);
        this.f5164f.setText("下载中");
        this.f5163e.setVisibility(8);
        this.f5164f.setTextColor(Color.parseColor("#4287ff"));
    }

    /* renamed from: p */
    private synchronized void m54046p() {
        this.f5165g.pause();
        this.f5165g.restart();
    }

    /* renamed from: q */
    private synchronized boolean m54045q() {
        try {
            this.f5165g.downloadByCityName(this.f5166h.getCity());
        } catch (AMapException e) {
            e.printStackTrace();
            Toast.makeText(this.f5160b, e.getErrorMessage(), 0).show();
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final View m54061a() {
        return this.f5169k;
    }

    /* renamed from: b */
    public final void m54060b(int i) {
        this.f5159a = i;
    }

    /* renamed from: e */
    public final void m54057e(OfflineMapCity offlineMapCity) {
        double d;
        if (offlineMapCity != null) {
            this.f5166h = offlineMapCity;
            this.f5161c.setText(offlineMapCity.getCity());
            double size = offlineMapCity.getSize();
            Double.isNaN(size);
            Double.isNaN((int) (((size / 1024.0d) / 1024.0d) * 100.0d));
            this.f5162d.setText(String.valueOf(d / 100.0d) + " M");
            m54055g(this.f5166h.getState(), this.f5166h.getcompleteCode());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (!C1732a3.m55703h0(this.f5160b)) {
                Toast.makeText(this.f5160b, "无网络连接", 0).show();
                return;
            }
            OfflineMapCity offlineMapCity = this.f5166h;
            if (offlineMapCity != null) {
                int state = offlineMapCity.getState();
                this.f5166h.getcompleteCode();
                if (state == 0) {
                    m54046p();
                    m54050l();
                } else if (state == 1 || state == 4) {
                } else {
                    if (m54045q()) {
                        m54052j();
                    } else {
                        m54051k();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
