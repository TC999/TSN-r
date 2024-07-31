package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* renamed from: com.amap.api.col.3l.p3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BottomDialog extends BottomDialogBase implements View.OnClickListener {

    /* renamed from: a */
    private OfflineMapManager f5061a;

    /* renamed from: b */
    private View f5062b;

    /* renamed from: c */
    private TextView f5063c;

    /* renamed from: d */
    private TextView f5064d;

    /* renamed from: e */
    private TextView f5065e;

    /* renamed from: f */
    private TextView f5066f;

    /* renamed from: g */
    private int f5067g;

    /* renamed from: h */
    private String f5068h;

    /* compiled from: BottomDialog.java */
    /* renamed from: com.amap.api.col.3l.p3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class View$OnClickListenerC1924a implements View.OnClickListener {
        View$OnClickListenerC1924a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BottomDialog.this.dismiss();
        }
    }

    public BottomDialog(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.f5061a = offlineMapManager;
    }

    @Override // com.amap.api.col.p0463l.BottomDialogBase
    /* renamed from: a */
    protected final void mo54144a() {
        View m53597d = ServiceUtils.m53597d(getContext(), 2130903041);
        this.f5062b = m53597d;
        setContentView(m53597d);
        this.f5062b.setOnClickListener(new View$OnClickListenerC1924a());
        this.f5063c = (TextView) this.f5062b.findViewById(2131165191);
        TextView textView = (TextView) this.f5062b.findViewById(2131165192);
        this.f5064d = textView;
        textView.setText("暂停下载");
        this.f5065e = (TextView) this.f5062b.findViewById(2131165193);
        this.f5066f = (TextView) this.f5062b.findViewById(2131165194);
        this.f5064d.setOnClickListener(this);
        this.f5065e.setOnClickListener(this);
        this.f5066f.setOnClickListener(this);
    }

    /* renamed from: c */
    public final void m54211c(int i, String str) {
        this.f5063c.setText(str);
        if (i == 0) {
            this.f5064d.setText("暂停下载");
            this.f5064d.setVisibility(0);
            this.f5065e.setText("取消下载");
        }
        if (i == 2) {
            this.f5064d.setVisibility(8);
            this.f5065e.setText("取消下载");
        } else if (i == -1 || i == 101 || i == 102 || i == 103) {
            this.f5064d.setText("继续下载");
            this.f5064d.setVisibility(0);
        } else if (i == 3) {
            this.f5064d.setVisibility(0);
            this.f5064d.setText("继续下载");
            this.f5065e.setText("取消下载");
        } else if (i == 4) {
            this.f5065e.setText("删除");
            this.f5064d.setVisibility(8);
        }
        this.f5067g = i;
        this.f5068h = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            int id = view.getId();
            if (id != 2131165192) {
                if (id != 2131165193) {
                    if (id == 2131165194) {
                        dismiss();
                        return;
                    }
                    return;
                } else if (TextUtils.isEmpty(this.f5068h)) {
                    return;
                } else {
                    this.f5061a.remove(this.f5068h);
                    dismiss();
                    return;
                }
            }
            int i = this.f5067g;
            if (i == 0) {
                this.f5064d.setText("继续下载");
                this.f5061a.pauseByName(this.f5068h);
            } else if (i == 3 || i == -1 || i == 101 || i == 102 || i == 103) {
                this.f5064d.setText("暂停下载");
                this.f5061a.downloadByCityName(this.f5068h);
            }
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
