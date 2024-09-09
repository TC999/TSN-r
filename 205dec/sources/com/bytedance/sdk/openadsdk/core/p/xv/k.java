package com.bytedance.sdk.openadsdk.core.p.xv;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.wx;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Stack;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {
    public static boolean sr(me meVar) {
        com.bytedance.sdk.openadsdk.core.u.ux zg = meVar.zg();
        return (zg == null || TextUtils.isEmpty(zg.a()) || TextUtils.isEmpty(zg.ux()) || TextUtils.isEmpty(zg.r()) || zg.c() == null || zg.c().size() <= 0 || TextUtils.isEmpty(zg.ev()) || TextUtils.isEmpty(zg.gd())) ? false : true;
    }

    public static String w(me meVar) {
        if (meVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.u.sr ix = meVar.ix();
        if (ix != null && !TextUtils.isEmpty(ix.xv())) {
            return ix.xv();
        }
        if (!TextUtils.isEmpty(meVar.yh())) {
            return meVar.yh();
        }
        if (TextUtils.isEmpty(meVar.ju())) {
            return !TextUtils.isEmpty(meVar.vt()) ? meVar.vt() : "";
        }
        return meVar.ju();
    }

    public static boolean xv(me meVar) {
        if (meVar == null) {
            return false;
        }
        return sr(meVar);
    }

    public static int c(me meVar) {
        if (meVar == null || meVar.jv() != 1) {
            return 0;
        }
        if (meVar.rd() == 0) {
            return 1;
        }
        return meVar.rd() == 1 ? !xv(meVar) ? 1 : 0 : meVar.rd() == 2 ? 2 : 1;
    }

    public static void c(final Context context) {
        if (context == null) {
            context = ls.getContext();
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            Toast makeText = Toast.makeText(context, "", 1);
            makeText.setText("\u5e94\u7528\u4fe1\u606f\u7f3a\u5931\uff0c\u6682\u65e0\u6cd5\u54cd\u5e94\u4e0b\u8f7d");
            makeText.show();
            return;
        }
        q.f().post(new com.bytedance.sdk.component.gd.p("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.p.xv.k.1
            @Override // java.lang.Runnable
            public void run() {
                Toast makeText2 = Toast.makeText(context, "", 1);
                makeText2.setText("\u5e94\u7528\u4fe1\u606f\u7f3a\u5931\uff0c\u6682\u65e0\u6cd5\u54cd\u5e94\u4e0b\u8f7d");
                makeText2.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(me meVar, String str, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_pl_pre_5element", Boolean.valueOf(wx.ls(meVar)));
        hashMap.put("pl_pre_5element_version", Integer.valueOf(i4));
        hashMap.put("event", "csj_sdk_compilance_show");
        com.bytedance.sdk.openadsdk.core.a.xv.p(meVar, str, "playable_track", hashMap);
    }

    public static void c(final me meVar, final ViewGroup viewGroup, Context context, final String str, final boolean z3, com.bytedance.sdk.openadsdk.core.w.f fVar, final boolean z4) {
        int i4;
        boolean z5;
        LinearLayout linearLayout;
        int i5;
        String str2;
        Stack stack;
        Context context2;
        int i6;
        if (meVar == null || viewGroup == null) {
            return;
        }
        if (!wx.ls(meVar)) {
            w(meVar, str, 0);
        } else if (wx.gb(meVar)) {
            if (!sr(meVar)) {
                w(meVar, str, -1);
                return;
            }
            viewGroup.setOnClickListener(null);
            viewGroup.setOnTouchListener(null);
            Context context3 = (Context) new WeakReference(context).get();
            Context context4 = ls.getContext();
            Context context5 = context3 == null ? context4 : context3;
            WeakReference weakReference = new WeakReference(fVar);
            int p3 = xk.p(context4) - xk.ux(context4, 32.0f);
            final int c4 = wx.c(context4, meVar, z4);
            viewGroup.setVisibility(4);
            com.bytedance.sdk.openadsdk.core.u.ux zg = meVar.zg();
            Stack stack2 = new Stack();
            stack2.push("\u9690\u79c1");
            String str3 = "\u6743\u9650";
            stack2.push("\u6743\u9650");
            stack2.push("\u529f\u80fd");
            stack2.push(String.format("\u7248\u672c\u53f7\uff1a%s", zg.ux()));
            stack2.push(String.format("\u5f00\u53d1\u8005\uff1a%s", zg.r()));
            stack2.push(String.format("\u5e94\u7528\u540d\u79f0\uff1a%s", zg.a()));
            LinearLayout c5 = c(viewGroup, context5);
            int i7 = p3;
            while (!stack2.isEmpty()) {
                String str4 = (String) stack2.pop();
                TextView c6 = c(context5, str4, z3);
                float measureText = c6.getPaint().measureText("\u9690");
                boolean z6 = c5.getChildCount() > 0;
                int ux = xk.ux(context4, 21.0f);
                float f4 = ux;
                boolean z7 = f4 + measureText < ((float) i7);
                int length = ((int) (str4.length() * measureText)) + 1;
                if (str3.equals(str4)) {
                    int i8 = ((int) (f4 + (8.0f * measureText))) + 1;
                    z5 = i8 < i7;
                    i4 = i8;
                } else {
                    i4 = length;
                    z5 = z7;
                }
                if (z6 && z5) {
                    i7 -= ux;
                    c5.addView(w(context5));
                }
                if (z5) {
                    linearLayout = c5;
                    i5 = i7;
                } else {
                    linearLayout = c(viewGroup, context5);
                    i5 = p3;
                }
                if (i4 < i5) {
                    str2 = str3;
                    stack = stack2;
                    context2 = context4;
                    int i9 = i5;
                    if (c(meVar, context5, str, stack2, linearLayout, str4, z3)) {
                        break;
                    }
                    linearLayout.addView(c6);
                    i6 = i9 - i4;
                    c5 = linearLayout;
                    i7 = i6;
                    str3 = str2;
                    stack2 = stack;
                    context4 = context2;
                } else {
                    str2 = str3;
                    stack = stack2;
                    context2 = context4;
                    int i10 = i5;
                    LinearLayout c7 = c(viewGroup, context5);
                    if (c(meVar, context5, str, stack, c7, str4, z3)) {
                        break;
                    }
                    int i11 = (int) (i10 / measureText);
                    c6.setText(str4.substring(0, i11));
                    linearLayout.addView(c6);
                    String substring = str4.substring(i11);
                    float f5 = p3;
                    int i12 = (int) (f5 / measureText);
                    while (substring.length() > i12) {
                        String substring2 = substring.substring(0, i12);
                        substring = substring.substring(i12);
                        c7.addView(c(context5, substring2, z3));
                        c7 = c(viewGroup, context5);
                        i10 = p3;
                    }
                    if (TextUtils.isEmpty(substring)) {
                        c5 = linearLayout;
                        i7 = i10;
                        str3 = str2;
                        stack2 = stack;
                        context4 = context2;
                    } else {
                        c7.addView(c(context5, substring, z3));
                        i6 = (int) (f5 - (substring.length() * measureText));
                        c5 = c7;
                        i7 = i6;
                        str3 = str2;
                        stack2 = stack;
                        context4 = context2;
                    }
                }
            }
            final com.bytedance.sdk.openadsdk.core.w.f fVar2 = (com.bytedance.sdk.openadsdk.core.w.f) weakReference.get();
            final Context context6 = context5;
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.k.2
                @Override // java.lang.Runnable
                public void run() {
                    if (viewGroup.getHeight() > c4) {
                        viewGroup.setVisibility(8);
                        viewGroup.removeAllViews();
                        if (z3) {
                            k.c(meVar, viewGroup, context6, str, false, fVar2, z4);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.w.f fVar3 = fVar2;
                        if (fVar3 != null) {
                            fVar3.c();
                        }
                        k.w(meVar, str, 0);
                        return;
                    }
                    viewGroup.setVisibility(0);
                    com.bytedance.sdk.openadsdk.core.w.f fVar4 = fVar2;
                    if (fVar4 != null) {
                        fVar4.w();
                    }
                    k.w(meVar, str, 2);
                }
            });
        }
    }

    private static ImageView w(Context context) {
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(xk.ux(context, 1.0f), xk.ux(context, 8.0f));
        int ux = xk.ux(context, 6.0f);
        layoutParams.leftMargin = ux;
        layoutParams.rightMargin = ux;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(Color.parseColor("#80FFFFFF"));
        return imageView;
    }

    private static boolean c(final me meVar, final Context context, final String str, Stack<String> stack, LinearLayout linearLayout, String str2, boolean z3) {
        if ("\u529f\u80fd".equals(str2)) {
            TextView c4 = c(context, str2, z3);
            c4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.k.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    me meVar2 = me.this;
                    if (meVar2 == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.eq.f.c(context, meVar2, str);
                }
            });
            linearLayout.addView(c4);
            linearLayout.addView(w(context));
            TextView c5 = c(context, stack.pop(), z3);
            c5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.k.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    me meVar2 = me.this;
                    if (meVar2 == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.eq.f.w(meVar2, context, str);
                }
            });
            linearLayout.addView(c5);
            linearLayout.addView(w(context));
            TextView c6 = c(context, stack.pop(), z3);
            c6.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.k.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    me meVar2 = me.this;
                    if (meVar2 == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.eq.f.c(meVar2, context, str);
                }
            });
            linearLayout.addView(c6);
            return true;
        }
        return false;
    }

    private static LinearLayout c(ViewGroup viewGroup, Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        viewGroup.addView(linearLayout);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        return linearLayout;
    }

    private static TextView c(Context context, String str, boolean z3) {
        TextView textView = new TextView(context);
        textView.setText(str);
        if (z3) {
            textView.setTextSize(1, 10.0f);
        } else {
            textView.setTextSize(1, 8.0f);
        }
        textView.setTextColor(Color.parseColor("#80FFFFFF"));
        return textView;
    }
}
