package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.x1;
import com.qq.e.dl.l.h;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class u extends com.qq.e.dl.l.a<c> {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h.d f42605c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.dl.l.j.c f42606d;

        a(h.d dVar, com.qq.e.dl.l.j.c cVar) {
            this.f42605c = dVar;
            this.f42606d = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f42605c.b(u.this, this.f42606d);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new u(aVar);
        }
    }

    u(com.qq.e.dl.a aVar) {
        super(aVar);
        ((c) this.f47039w).setVisibility(8);
    }

    @Override // com.qq.e.dl.l.h
    public void b(int[] iArr) {
        ((c) this.f47039w).a(iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        super.u();
        com.qq.e.dl.l.i.b bVar = this.f47079q;
        if (bVar == null || !bVar.a() || m() == null) {
            return;
        }
        m().setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends LinearLayout implements com.qq.e.dl.l.e<u> {

        /* renamed from: j  reason: collision with root package name */
        private static int f42608j;

        /* renamed from: k  reason: collision with root package name */
        private static int f42609k;

        /* renamed from: c  reason: collision with root package name */
        private int f42610c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f42611d;

        /* renamed from: e  reason: collision with root package name */
        private int f42612e;

        /* renamed from: f  reason: collision with root package name */
        private int f42613f;

        /* renamed from: g  reason: collision with root package name */
        private int f42614g;

        /* renamed from: h  reason: collision with root package name */
        private u f42615h;

        /* renamed from: i  reason: collision with root package name */
        private View.OnClickListener f42616i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class a implements View.OnTouchListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ TextView f42617c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f42618d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f42619e;

            a(TextView textView, int i4, int i5) {
                this.f42617c = textView;
                this.f42618d = i4;
                this.f42619e = i5;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 && c.this.f42616i != null) {
                        c.this.f42616i.onClick(view);
                        return true;
                    }
                    return false;
                }
                Layout layout = this.f42617c.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) y3), x3);
                return offsetForHorizontal >= this.f42618d && offsetForHorizontal < this.f42619e;
            }
        }

        public c(Context context) {
            super(context);
            this.f42610c = 0;
            this.f42611d = new TextView(getContext());
            if (f42609k == 0) {
                f42609k = com.qq.e.dl.j.f.a(9.0d);
            }
            if (f42608j == 0) {
                f42608j = com.qq.e.dl.j.f.a(12.0d);
            }
            this.f42612e = -1;
            this.f42613f = f42609k;
            setOrientation(1);
        }

        public void b(int i4) {
            this.f42614g = i4;
        }

        public void c(int i4) {
            this.f42613f = i4;
        }

        public void d(int i4) {
            this.f42610c = i4;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int i4;
            com.qq.e.dl.l.i.d g4 = this.f42615h.g();
            int i5 = 0;
            if (g4 != null) {
                i5 = getWidth();
                i4 = getHeight();
                g4.a(canvas, i5, i4);
            } else {
                i4 = 0;
            }
            super.draw(canvas);
            if (g4 != null) {
                g4.b(canvas, i5, i4);
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            this.f42615h.a(view, i4);
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f42616i = onClickListener;
        }

        public void a(com.qq.e.comm.plugin.g0.e eVar) {
            com.qq.e.comm.plugin.g0.b q3;
            com.qq.e.comm.plugin.g0.a b4;
            if (eVar == null || (q3 = eVar.q()) == null || (b4 = q3.b()) == null) {
                return;
            }
            this.f42611d.setTextColor(this.f42612e);
            this.f42611d.setTextSize(0, this.f42613f);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            a(spannableStringBuilder, b4);
            int length = spannableStringBuilder.length();
            a(spannableStringBuilder);
            int length2 = spannableStringBuilder.length();
            this.f42611d.setText(spannableStringBuilder);
            a(this.f42611d, length, length2);
            int i4 = this.f42614g;
            if (i4 > 0) {
                this.f42611d.setMaxLines(i4);
                this.f42611d.setEllipsize(TextUtils.TruncateAt.END);
            }
            addView(this.f42611d, new LinearLayout.LayoutParams(-2, -2));
            setVisibility(0);
        }

        private void a(SpannableStringBuilder spannableStringBuilder, com.qq.e.comm.plugin.g0.a aVar) {
            String format;
            int i4 = this.f42610c;
            String str = i4 == 1 ? "%s | %s | %s | %s | \u9002\u7528\u5e74\u9f84%s | " : i4 == 2 ? "%s | %s | %s | \u9002\u7528\u5e74\u9f84%s | " : i4 == 3 ? "\u5f00\u53d1\u8005\uff1a%s | \u5e94\u7528\u7248\u672c\uff1a%s | \u5907\u6848\u53f7\uff1a%s | \u9002\u7528\u5e74\u9f84\uff1a%s | " : "\u5e94\u7528\u540d\u79f0\uff1a%s | \u5f00\u53d1\u8005\uff1a%s | \u5e94\u7528\u7248\u672c\uff1a%s | \u5907\u6848\u53f7\uff1a%s | \u9002\u7528\u5e74\u9f84\uff1a%s | ";
            String d4 = aVar.d();
            if (TextUtils.isEmpty(d4)) {
                d4 = "\u672a\u5907\u6848";
            }
            int i5 = this.f42610c;
            if (i5 != 2 && i5 != 3) {
                format = String.format(str, aVar.a(), aVar.b(), aVar.i(), d4, aVar.h());
            } else {
                format = String.format(str, aVar.b(), aVar.i(), d4, aVar.h());
            }
            spannableStringBuilder.append((CharSequence) x1.b(format));
        }

        private void a(SpannableStringBuilder spannableStringBuilder) {
            String str;
            String str2;
            String str3;
            if (this.f42610c == 0) {
                str = "\u6743\u9650\u8be6\u60c5";
                str2 = "\u9690\u79c1\u534f\u8bae";
                str3 = "\u529f\u80fd\u4ecb\u7ecd";
            } else {
                str = "\u6743\u9650";
                str2 = "\u9690\u79c1";
                str3 = "\u529f\u80fd";
            }
            if (Build.VERSION.SDK_INT >= 21) {
                spannableStringBuilder.append(str, new UnderlineSpan(), 33);
                spannableStringBuilder.append(" | ");
                spannableStringBuilder.append(str2, new UnderlineSpan(), 33);
                spannableStringBuilder.append(" | ");
                spannableStringBuilder.append(str3, new UnderlineSpan(), 33);
                return;
            }
            spannableStringBuilder.append((CharSequence) String.format("%s > | %s > | %s >", str, str2, str3));
        }

        private void a(TextView textView, int i4, int i5) {
            textView.setOnTouchListener(new a(textView, i4, i5));
        }

        public void a(int i4) {
            this.f42612e = i4;
        }

        public void a(int[] iArr) {
            if (iArr == null || iArr.length != 4) {
                return;
            }
            this.f42611d.setShadowLayer(iArr[2], iArr[0], iArr[1], iArr[3]);
        }

        @Override // com.qq.e.dl.l.e
        public void a(u uVar) {
            this.f42615h = uVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode == -1169023802) {
            if (str.equals("adModel")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else if (hashCode == 1571) {
            if (str.equals("14")) {
                c4 = 3;
            }
            c4 = '\uffff';
        } else if (hashCode == 1692) {
            if (str.equals("51")) {
                c4 = 4;
            }
            c4 = '\uffff';
        } else if (hashCode == 1758) {
            if (str.equals("75")) {
                c4 = 5;
            }
            c4 = '\uffff';
        } else if (hashCode == 3575610) {
            if (str.equals("type")) {
                c4 = 6;
            }
            c4 = '\uffff';
        } else if (hashCode != 1755) {
            if (hashCode == 1756 && str.equals("73")) {
                c4 = 1;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("72")) {
                c4 = 2;
            }
            c4 = '\uffff';
        }
        switch (c4) {
            case 0:
                ((c) this.f47039w).a((com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]));
                break;
            case 1:
                ((c) this.f47039w).a(com.qq.e.dl.k.n.a(gVar));
                break;
            case 2:
                ((c) this.f47039w).c(gVar.a(new JSONObject[0]));
                break;
            case 3:
                ((c) this.f47039w).setGravity(com.qq.e.dl.k.n.b(gVar));
                break;
            case 4:
                ((c) this.f47039w).setOrientation(gVar.b(new JSONObject[0]));
                break;
            case 5:
                ((c) this.f47039w).b(gVar.b(new JSONObject[0]));
                break;
            case 6:
                ((c) this.f47039w).d(gVar.b(new JSONObject[0]));
                break;
            default:
                return super.a(str, gVar);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public c a(com.qq.e.dl.a aVar) {
        return new c(aVar.b());
    }

    @Override // com.qq.e.dl.l.h
    public void a(h.d dVar) {
        if (dVar == null) {
            return;
        }
        List<com.qq.e.dl.l.j.c> h4 = h();
        ((c) this.f47039w).setOnClickListener(new a(dVar, h4.size() > 0 ? h4.get(0) : new com.qq.e.dl.l.j.c(1, "miitActivity")));
    }
}
