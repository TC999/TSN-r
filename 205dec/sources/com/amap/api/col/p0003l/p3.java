package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BottomDialog.java */
/* renamed from: com.amap.api.col.3l.p3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p3 extends q3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private OfflineMapManager f8614a;

    /* renamed from: b  reason: collision with root package name */
    private View f8615b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f8616c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f8617d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f8618e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f8619f;

    /* renamed from: g  reason: collision with root package name */
    private int f8620g;

    /* renamed from: h  reason: collision with root package name */
    private String f8621h;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BottomDialog.java */
    /* renamed from: com.amap.api.col.3l.p3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            p3.this.dismiss();
        }
    }

    public p3(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.f8614a = offlineMapManager;
    }

    @Override // com.amap.api.col.p0003l.q3
    protected final void a() {
        View d4 = w3.d(getContext(), 2130903041);
        this.f8615b = d4;
        setContentView(d4);
        this.f8615b.setOnClickListener(new a());
        this.f8616c = (TextView) this.f8615b.findViewById(2131165191);
        TextView textView = (TextView) this.f8615b.findViewById(2131165192);
        this.f8617d = textView;
        textView.setText("\u6682\u505c\u4e0b\u8f7d");
        this.f8618e = (TextView) this.f8615b.findViewById(2131165193);
        this.f8619f = (TextView) this.f8615b.findViewById(2131165194);
        this.f8617d.setOnClickListener(this);
        this.f8618e.setOnClickListener(this);
        this.f8619f.setOnClickListener(this);
    }

    public final void c(int i4, String str) {
        this.f8616c.setText(str);
        if (i4 == 0) {
            this.f8617d.setText("\u6682\u505c\u4e0b\u8f7d");
            this.f8617d.setVisibility(0);
            this.f8618e.setText("\u53d6\u6d88\u4e0b\u8f7d");
        }
        if (i4 == 2) {
            this.f8617d.setVisibility(8);
            this.f8618e.setText("\u53d6\u6d88\u4e0b\u8f7d");
        } else if (i4 == -1 || i4 == 101 || i4 == 102 || i4 == 103) {
            this.f8617d.setText("\u7ee7\u7eed\u4e0b\u8f7d");
            this.f8617d.setVisibility(0);
        } else if (i4 == 3) {
            this.f8617d.setVisibility(0);
            this.f8617d.setText("\u7ee7\u7eed\u4e0b\u8f7d");
            this.f8618e.setText("\u53d6\u6d88\u4e0b\u8f7d");
        } else if (i4 == 4) {
            this.f8618e.setText("\u5220\u9664");
            this.f8617d.setVisibility(8);
        }
        this.f8620g = i4;
        this.f8621h = str;
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
                } else if (TextUtils.isEmpty(this.f8621h)) {
                    return;
                } else {
                    this.f8614a.remove(this.f8621h);
                    dismiss();
                    return;
                }
            }
            int i4 = this.f8620g;
            if (i4 == 0) {
                this.f8617d.setText("\u7ee7\u7eed\u4e0b\u8f7d");
                this.f8614a.pauseByName(this.f8621h);
            } else if (i4 == 3 || i4 == -1 || i4 == 101 || i4 == 102 || i4 == 103) {
                this.f8617d.setText("\u6682\u505c\u4e0b\u8f7d");
                this.f8614a.downloadByCityName(this.f8621h);
            }
            dismiss();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
