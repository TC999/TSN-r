package com.qq.e.comm.plugin.f0;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.f0.g;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;
import com.qq.e.comm.plugin.util.q1;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {
    public static LinearLayout a(Context context, int i4, int i5, boolean z3) {
        String b4;
        if (z3) {
            b4 = com.qq.e.comm.plugin.d0.a.d().f().b("bxguivbtapp", "\u70b9\u51fb\u4e0b\u8f7d\u6216\u8df3\u8f6c\u7b2c\u4e09\u65b9\u5e94\u7528");
        } else {
            b4 = com.qq.e.comm.plugin.d0.a.d().f().b("bxguivbtnonapp", "\u70b9\u51fb\u8df3\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
        }
        return a(context, b4, i4, i5, false);
    }

    public static LinearLayout a(Context context, String str, int i4, int i5, boolean z3) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setAlpha(127);
        float f4 = i4 >> 1;
        gradientDrawable.setCornerRadius(f4);
        int a4 = (int) f1.a(context, 1.5f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f4);
        gradientDrawable2.setColor(0);
        gradientDrawable2.setStroke(a4, -1);
        gradientDrawable2.setAlpha(76);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
        layerDrawable.setLayerInset(0, a4, a4, a4, a4);
        linearLayout.setBackgroundDrawable(layerDrawable);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(-1);
        textView.setTextSize(2, i5);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setText(str);
        linearLayout.addView(textView, new FrameLayout.LayoutParams(-2, -2));
        if (z3) {
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(m1.a("iVBORw0KGgoAAAANSUhEUgAAACMAAAAhCAYAAABTERJSAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAUGVYSWZNTQAqAAAACAACARIAAwAAAAEAAQAAh2kABAAAAAEAAAAmAAAAAAADoAEAAwAAAAEAAQAAoAIABAAAAAEAAAAjoAMABAAAAAEAAAAhAAAAANChPtkAAAIwaVRYdFhNTDpjb20uYWRvYmUueG1wAAAAAAA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJYTVAgQ29yZSA2LjAuMCI+CiAgIDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+CiAgICAgIDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiCiAgICAgICAgICAgIHhtbG5zOmV4aWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20vZXhpZi8xLjAvIgogICAgICAgICAgICB4bWxuczp0aWZmPSJodHRwOi8vbnMuYWRvYmUuY29tL3RpZmYvMS4wLyI+CiAgICAgICAgIDxleGlmOlBpeGVsWURpbWVuc2lvbj4zNTwvZXhpZjpQaXhlbFlEaW1lbnNpb24+CiAgICAgICAgIDxleGlmOlBpeGVsWERpbWVuc2lvbj4zMzwvZXhpZjpQaXhlbFhEaW1lbnNpb24+CiAgICAgICAgIDxleGlmOkNvbG9yU3BhY2U+MTwvZXhpZjpDb2xvclNwYWNlPgogICAgICAgICA8dGlmZjpPcmllbnRhdGlvbj4xPC90aWZmOk9yaWVudGF0aW9uPgogICAgICA8L3JkZjpEZXNjcmlwdGlvbj4KICAgPC9yZGY6UkRGPgo8L3g6eG1wbWV0YT4KN1CXDgAAAQZJREFUWAntlTEOwjAMRVMWYESszNyAjZWBiYmdi/QsDGwMIBg5BQNnYOMCIFReJKpEVqiqpo0YbOmrjuU6v69VY0xEFEUxRJOIEe3ciokZeiAbRzRoZ3KDKWy+ty68uJBHGeo18FHeci+T73XB9RxrSMyst2TTEboiGdGE6jkQXbgYIzUkuLilEnIswpkSCnNxVSXkWIQzJRTm4qoVhHLXZUzMQenPqcyzLHvQsA00TQO1bkuQ2aA38uPJYt7tzmI6G/4yshKt3S7ViOSrRJSIJCDX+o38M5Elryf0i0/7Z7WEMHJAftizJspIzKl9817bi3zN6XzyaulSKPRRjnYo7emb4jE/Fej5smeLowoAAAAASUVORK5CYII="));
            int a5 = f1.a(context, i5);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a5, a5);
            layoutParams.leftMargin = f1.a(context, 6);
            linearLayout.addView(imageView, layoutParams);
        }
        return linearLayout;
    }

    public static String a(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.g0.b q3;
        com.qq.e.comm.plugin.g0.a b4;
        if (eVar == null || (q3 = eVar.q()) == null || (b4 = q3.b()) == null) {
            return null;
        }
        String d4 = b4.d();
        if (TextUtils.isEmpty(d4)) {
            d4 = "\u672a\u5907\u6848";
        }
        String format = String.format("\u5e94\u7528\u540d\u79f0\uff1a%s | \u5e94\u7528\u7248\u672c\uff1a%s | \u5f00\u53d1\u8005\uff1a%s | \u5907\u6848\u53f7\uff1a%s | \u9002\u7528\u5e74\u9f84\uff1a%s | ", b4.a(), b4.i(), b4.b(), d4, b4.h());
        return format + String.format("%s > | %s > | %s >", "\u6743\u9650\u8be6\u60c5", "\u9690\u79c1\u534f\u8bae", "\u529f\u80fd\u4ecb\u7ecd");
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar, g.b bVar) {
        if (eVar == null || eVar.q() == null || eVar.q().b() == null) {
            return;
        }
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        Intent intent = new Intent();
        intent.setClassName(a4, q1.a());
        intent.putExtra("gdt_activity_delegate_name", com.qq.e.comm.plugin.a.MIIT_INFO_DISPLAY);
        intent.putExtra("appid", com.qq.e.comm.plugin.d0.a.d().b().a());
        intent.putExtra("objectId", eVar.l0());
        ((com.qq.e.comm.plugin.d0.b.a) com.qq.e.comm.plugin.d0.b.e.a(eVar.l0(), com.qq.e.comm.plugin.d0.b.a.class)).a(eVar);
        intent.addFlags(268435456);
        a4.startActivity(intent);
        if (bVar != null) {
            g.b.f43113a.put(eVar.e0(), new WeakReference<>(bVar));
            bVar.h();
        }
    }

    public static void a(Context context, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.i.d0.c cVar, int i4) {
        if (eVar == null || eVar.q() == null || eVar.q().b() == null) {
            return;
        }
        try {
            if (com.qq.e.comm.plugin.apkmanager.x.c.b(eVar) == 4) {
                new b(context, eVar, cVar).show();
            } else {
                new c(context, eVar, cVar, i4).show();
            }
        } catch (Throwable th) {
            d1.a("showMiitDialog", "showMiitDialog error", th);
            if (cVar != null) {
                cVar.a(false);
            }
        }
    }
}
