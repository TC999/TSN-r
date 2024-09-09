package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.SeedWebViewActivity;
import com.acse.ottn.l0;
import com.acse.ottn.widget.ContinueSlideScrollView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class u3 {

    /* renamed from: a  reason: collision with root package name */
    public static AlertDialog f6663a = null;

    /* renamed from: b  reason: collision with root package name */
    public static ContinueSlideScrollView f6664b = null;

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f6665c = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f6666d = "\u5728\u4f7f\u7528\u201c\u4e00\u952e\u5f00\u542f\u5fc5\u8981\u6743\u9650\u201d\u670d\u52a1\u524d\uff0c\u8bf7\u60a8\u4ed4\u7ec6\u9605\u8bfb\u6211\u4eec\u7684\u300a\u7528\u6237\u534f\u8bae\u300b\u548c\u300a\u9690\u79c1\u653f\u7b56\u300b\u3002\u8bf7\u60a8\u77e5\u6089\uff0c\u60a8\u540c\u610f\u7528\u6237\u534f\u8bae\u548c\u9690\u79c1\u653f\u7b56\u5c06\u4ee3\u8868\u60a8\u5df2\u4e86\u89e3\u6211\u4eec\u63d0\u4f9b\u7684\u529f\u80fd\uff0c\u4ee5\u53ca\u529f\u80fd\u8fd0\u884c\u6240\u9700\u7684\u5fc5\u8981\u4e2a\u4eba\u4fe1\u606f\u3002\u6211\u4eec\u5728\u5411\u60a8\u63d0\u4f9b\u670d\u52a1\u7684\u8fc7\u7a0b\u4e2d\uff0c\u9664\u975e\u5355\u72ec\u83b7\u5f97\u60a8\u7684\u540c\u610f\u548c\u6388\u6743\uff0c\u5426\u5219\u5c06\u4e0d\u4f1a\u6536\u96c6\u60a8\u7684\u975e\u5fc5\u8981\u4e2a\u4eba\u4fe1\u606f\u3002";

    /* renamed from: e  reason: collision with root package name */
    public static final String f6667e = "\u300a\u7528\u6237\u534f\u8bae\u300b";

    /* renamed from: f  reason: collision with root package name */
    public static final String f6668f = "\u300a\u9690\u79c1\u653f\u7b56\u300b";

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements ContinueSlideScrollView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f6669a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f6670b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f6671c;

        /* renamed from: com.acse.ottn.u3$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class View$OnClickListenerC0097a implements View.OnClickListener {
            public View$OnClickListenerC0097a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f6670b.onOpen();
                u3.a(a.this.f6671c, u3.f6663a);
            }
        }

        public a(TextView textView, h hVar, Activity activity) {
            this.f6669a = textView;
            this.f6670b = hVar;
            this.f6671c = activity;
        }

        @Override // com.acse.ottn.widget.ContinueSlideScrollView.a
        public void a() {
            if (u3.f6665c != null) {
                u3.f6665c.cancel();
                this.f6669a.setText("\u6211\u5df2\u77e5\u6653\u5e76\u540c\u610f");
                this.f6669a.setOnClickListener(new View$OnClickListenerC0097a());
                g0.a().c(this.f6671c, this.f6669a);
            }
        }

        @Override // com.acse.ottn.widget.ContinueSlideScrollView.a
        public void b() {
            Log.d("samon-->", "\u5230\u9876\u90e8\u4e86");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6673a;

        public b(Activity activity) {
            this.f6673a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f6673a, SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().d(this.f6673a));
            this.f6673a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            g0.a().a(this.f6673a, textPaint);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6674a;

        public c(Activity activity) {
            this.f6674a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f6674a, SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().b(this.f6674a));
            this.f6674a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            g0.a().a(this.f6674a, textPaint);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6675a;

        public d(Activity activity) {
            this.f6675a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f6675a, SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().c(this.f6675a));
            this.f6675a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            g0.a().a(this.f6675a, textPaint);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6676a;

        public e(Activity activity) {
            this.f6676a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f6676a, SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().a(this.f6676a));
            this.f6676a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            g0.a().a(this.f6676a, textPaint);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6681a;

        public g(Activity activity) {
            this.f6681a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u3.a(this.f6681a, u3.f6663a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface h {
        void onDismiss();

        void onOpen();
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f6677a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f6678b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f6679c;

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.f6678b.onOpen();
                u3.a(f.this.f6679c, u3.f6663a);
            }
        }

        public f(TextView textView, h hVar, Activity activity) {
            this.f6677a = textView;
            this.f6678b = hVar;
            this.f6679c = activity;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            TextView textView = this.f6677a;
            textView.setText("\u8bf7\u4e0b\u62c9\u9605\u8bfb(" + (j4 / 1000) + "s)");
            this.f6677a.setOnClickListener(null);
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            this.f6677a.setText("\u6211\u5df2\u77e5\u6653\u5e76\u540c\u610f");
            this.f6677a.setOnClickListener(new a());
            g0.a().c(this.f6679c, this.f6677a);
        }
    }

    public static AlertDialog a(Activity activity, h hVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.service_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_one);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_eight);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_but2);
        g0.a().c(activity, textView3);
        ContinueSlideScrollView continueSlideScrollView = (ContinueSlideScrollView) inflate.findViewById(R.id.info_scroll);
        f6664b = continueSlideScrollView;
        continueSlideScrollView.setScanScrollChangedListener(new a(textView3, hVar, activity));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(f6666d);
        spannableStringBuilder.setSpan(new b(activity), 26, 32, 33);
        spannableStringBuilder.setSpan(new c(activity), 33, 39, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
        ((TextView) inflate.findViewById(R.id.tv_two)).setText("\u7531\u4e8e\u5b89\u5353\u7cfb\u7edf\u7684\u539f\u56e0\uff0c\u90e8\u5206\u624b\u673a\u6216\u64cd\u4f5c\u7cfb\u7edf\u53ef\u80fd\u4f1a\u9650\u5236\u540e\u53f0\u5e94\u7528\u4f7f\u7528\u5b9a\u4f4d\u6743\u9650\uff0c\u6216\u5e94\u7528\u5b58\u5728\u95ea\u9000\u3001\u5d29\u6e83\u53ca\u88ab\u7cfb\u7edf\u8bef\u6740\u7684\u53ef\u80fd\u3002" + j0.f5759a + "\u4e3a\u4e86\u80fd\u591f\u51c6\u786e\u8bb0\u5f55\u60a8\u7684\u8fd0\u52a8\u91cc\u7a0b\u3001\u8f68\u8ff9\u7b49\uff0c\u5f3a\u70c8\u5efa\u8bae\u60a8\u5f00\u542f\u5fc5\u8981\u7684\u8fd0\u52a8\u6743\u9650\uff0c\u4fdd\u969c\u60a8\u7684\u8fd0\u52a8\u88ab\u7a33\u5b9a\u3001\u6301\u7eed\u3001\u5b9e\u65f6\u8bb0\u5f55\u3002");
        ((TextView) inflate.findViewById(R.id.tv_three)).setText("\u5fc5\u8981\u7684\u8fd0\u52a8\u6743\u9650\u5305\u62ec\uff1a\n[\u60ac\u6d6e\u7a97] \u5b89\u5353\u7cfb\u7edf\u60ac\u6d6e\u7a97\u529f\u80fd\u80fd\u591f\u4fdd\u969cAPP\u7a33\u5b9a\u3001\u5b9e\u65f6\u8fd0\u884c\u3002\u4e3a\u4fdd\u969c\u60a8\u7684\u8fd0\u52a8\u8f68\u8ff9\u4e0e\u8dd1\u6b65\u6210\u7ee9\u7684\u5b8c\u6574\u8bb0\u5f55\uff0c\u5efa\u8bae\u60a8\u5f00\u542f\u60ac\u6d6e\u7a97\u6743\u9650\u3002\n[\u5141\u8bb8\u540e\u53f0\u8fd0\u884c\u548c\u81ea\u542f\u52a8] \u4e3a\u9632\u6b62\u5e94\u7528\u88ab\u7cfb\u7edf\u8bef\u6740\u3001\u6e05\u7406\uff0c\u5efa\u8bae\u60a8\u5141\u8bb8\u7a0b\u5e8f\u4fdd\u6301\u5728\u540e\u53f0\u8fd0\u884c\uff0c\u4ee5\u53ca\u5141\u8bb8\u7a0b\u5e8f\u5728\u5d29\u6e83\u65f6\u81ea\u542f\u52a8\uff0c\u4ee5\u4fbf\u4fdd\u969c\u7a33\u5b9a\u3001\u6301\u7eed\u4e3a\u60a8\u8bb0\u5f55\u8fd0\u52a8\u8f68\u8ff9\u3002\n[\u7cbe\u51c6\u5b9a\u4f4d] \u5efa\u8bae\u60a8\u5141\u8bb8\u7a0b\u5e8f\u59cb\u7ec8\u4f7f\u7528\u7cbe\u51c6\u5b9a\u4f4d\u6743\u9650\uff0c\u4ee5\u4fbf\u5b9e\u65f6\u3001\u7cbe\u51c6\u8bb0\u5f55\u8fd0\u52a8\u8f68\u8ff9\u3002");
        ((TextView) inflate.findViewById(R.id.tv_four)).setText(j0.f5759a + "APP\u5df2\u7ecf\u4e3a\u60a8\u63d0\u4f9b\u4e86\u8be6\u7ec6\u7684\u624b\u52a8\u5f00\u542f\u5fc5\u8981\u6743\u9650\u7684\u6559\u7a0b\u548c\u6307\u5bfc\u3002\u5982\u679c\u60a8\u5728\u624b\u52a8\u5f00\u542f\u5fc5\u8981\u6743\u9650\u7684\u8fc7\u7a0b\u4e2d\u9047\u5230\u95ee\u9898\uff0c\u6216\u8ba4\u4e3a\u624b\u52a8\u64cd\u4f5c\u8f83\u4e3a\u7e41\u7410\uff0c\u60a8\u4e5f\u53ef\u4ee5\u4f7f\u7528\u6211\u4eec\u7684\u201c\u4e00\u952e\u5f00\u542f\u5fc5\u8981\u6743\u9650\u201d\u670d\u52a1\uff0c\u6211\u4eec\u5c06\u4e3a\u60a8\u81ea\u52a8\u5f00\u542f\u8dd1\u6b65\u548c\u6301\u7eed\u5b9a\u4f4d\u6240\u9700\u7684\u5fc5\u8981\u6743\u9650\u3002");
        ((TextView) inflate.findViewById(R.id.tv_five)).setText("\u4e3a\u81ea\u52a8\u5f00\u542f\u8dd1\u6b65\u548c\u6301\u7eed\u5b9a\u4f4d\u6240\u9700\u7684\u5fc5\u8981\u6743\u9650\uff0c\u6211\u4eec\u9700\u8981\u60a8\u624b\u52a8\u5728\u624b\u673a\u7cfb\u7edf\u8bbe\u7f6e\u4e2d\u5f00\u542f\u201c\u65e0\u969c\u788d\u201d/\u201c\u8f85\u52a9\u6a21\u5f0f\u201d\u3002\u5b89\u5353\u7cfb\u7edf\u65e0\u969c\u788d/\u8f85\u52a9\u6a21\u5f0f\u5177\u6709\u6536\u96c6\u4fe1\u606f\u4e0e\u81ea\u52a8\u6267\u884c\u64cd\u4f5c\u7b49\u529f\u80fd\uff0c\u6211\u4eec\u5c06\u57fa\u4e8e\u65e0\u969c\u788d/\u8f85\u52a9\u6a21\u5f0f\u529f\u80fd\u4e3a\u60a8\u63d0\u4f9b\u81ea\u52a8\u5f00\u542f\u5e76\u914d\u7f6e\u524d\u8ff0\u5fc5\u8981\u7684\u8fd0\u52a8\u6743\u9650\u7684\u670d\u52a1\uff0c\u4ee5\u4fbf\u5f00\u542f\u201c\u60ac\u6d6e\u7a97\u201d\u3001\u201c\u5141\u8bb8\u540e\u53f0\u8fd0\u884c\u548c\u81ea\u542f\u52a8\u201d\u3001\u201c\u7cbe\u51c6\u5b9a\u4f4d\u201d\u5fc5\u8981\u6743\u9650\uff0c\u4ee5\u4fdd\u969c\u5728\u60a8\u8dd1\u6b65\u8fc7\u7a0b\u4e2d\uff0c\u7a33\u5b9a\u3001\u6301\u7eed\u3001\u5b9e\u65f6\u3001\u51c6\u786e\u4e3a\u60a8\u8bb0\u5f55\u8dd1\u6b65\u8f68\u8ff9\u3002\u5f00\u542f\u5fc5\u8981\u7684\u8fd0\u52a8\u6743\u9650\uff0c\u540c\u65f6\u80fd\u4f18\u5316APP\u7684\u7a33\u5b9a\u6027\uff0c\u51cf\u5c11\u5e94\u7528\u95ea\u9000\u3001\u5d29\u6e83\u3001\u4ee5\u53ca\u88ab\u7cfb\u7edf\u8bef\u6740\u7684\u6982\u7387\u3002");
        ((TextView) inflate.findViewById(R.id.tv_six)).setText("\u5982\u60a8\u4e0d\u5e0c\u671b\u4f7f\u7528\u201c\u4e00\u952e\u5f00\u542f\u5fc5\u8981\u6743\u9650\u201d\u670d\u52a1\uff0c\u53ef\u4ee5\u6309\u7167\u5fc5\u8981\u6743\u9650\u5f00\u542f\u6559\u7a0b\u6765\u624b\u52a8\u5f00\u542f\u5176\u6709\u5173\u6743\u9650\u3002\u5728\u4e3a\u60a8\u63d0\u4f9b\u201c\u4e00\u952e\u5f00\u542f\u5fc5\u8981\u6743\u9650\u201d\u670d\u52a1\u7684\u540c\u65f6\uff0c\u6211\u4eec\u4e5f\u5c06\u4f7f\u7528\u60a8\u5f00\u542f\u7684\u201c\u65e0\u969c\u788d\u201d/\u201c\u8f85\u52a9\u6a21\u5f0f\u201d\u5411\u60a8\u63d0\u4f9b\u4f18\u60e0\u548c\u798f\u5229\u63d0\u793a\u7684\u670d\u52a1\u3002\u5982\u679c\u60a8\u4e0d\u5e0c\u671b\u4f7f\u7528\u4f18\u60e0\u548c\u798f\u5229\u63d0\u793a\u670d\u52a1\uff0c\u53ef\u4ee5\u5728" + j0.f5759a + "\u7684\u8bbe\u7f6e\u9009\u9879\u4e2d\u5173\u95ed\u672c\u670d\u52a1\u3002\u5173\u95ed\u540e\uff0c\u60a8\u4ecd\u53ef\u4ee5\u6b63\u5e38\u4f7f\u7528" + j0.f5759a + "\u7684\u5176\u4ed6\u670d\u52a1\u3002");
        ((TextView) inflate.findViewById(R.id.tv_seven)).setText("\u4f46\u8bf7\u60a8\u6ce8\u610f\uff0c\u7531\u4e8e\u5b89\u5353\u7cfb\u7edf\u673a\u5236\uff0c\u5728\u65e0\u969c\u788d/\u8f85\u52a9\u6a21\u5f0f\u53ca\u4fdd\u6301\u540e\u53f0\u8fd0\u884c\u6743\u9650\u5f00\u542f\u540e\uff0c\u4ece\u5c4f\u5e55\u5e95\u90e8\u5411\u4e0a\u6ed1\u52a8\u65f6\uff0c" + j0.f5759a + "\u4ecd\u5c06\u6709\u53ef\u80fd\u7ee7\u7eed\u5728\u540e\u53f0\u5b9e\u65f6\u4e3a\u60a8\u63d0\u4f9b\u8bb0\u5f55\u8fd0\u52a8\u8f68\u8ff9\u7b49\u670d\u52a1\u3002\u5982\u679c\u60a8\u4e0d\u5e0c\u671b\u518d\u7ee7\u7eed\u4f7f\u7528\u6211\u4eec\u7684\u670d\u52a1\uff0c\u60a8\u53ef\u4ee5\u7ed3\u675f\u5e94\u7528\u8fdb\u7a0b\uff0c\u6216\u81f3\u624b\u673a\u7cfb\u7edf\u8bbe\u7f6e\u5904\u5173\u95ed\u65e0\u969c\u788d/\u8f85\u52a9\u6a21\u5f0f\uff0c\u4ee5\u53ca\u5173\u95ed\u4fdd\u6301\u540e\u53f0\u8fd0\u884c\u6743\u9650\u3002");
        String str = "\u66f4\u591a\u6709\u5173\u4ea7\u54c1\u670d\u52a1\u3001\u8bbe\u5907\u6743\u9650\u3001\u4e2a\u4eba\u4fe1\u606f\u4fdd\u62a4\u53ca\u4e0e\u5408\u4f5c\u65b9\u5171\u4eab\u6570\u636e\u7b49\u7684\u4fe1\u606f\uff0c\u8bf7\u67e5\u9605" + j0.f5759a + "APP\u300a\u7528\u6237\u534f\u8bae\u300b\u53ca\u300a\u9690\u79c1\u653f\u7b56\u300b\u3002";
        int indexOf = str.indexOf(f6667e);
        int indexOf2 = str.indexOf(f6668f);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
        spannableStringBuilder2.setSpan(new d(activity), indexOf, indexOf + 6, 33);
        spannableStringBuilder2.setSpan(new e(activity), indexOf2, indexOf2 + 6, 33);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setText(spannableStringBuilder2);
        f6665c = l0.a().b(AVMDLDataLoader.KeyIsLiveSetLoaderType, 1000, new f(textView3, hVar, activity));
        ((TextView) inflate.findViewById(R.id.tv_button)).setOnClickListener(new g(activity));
        AlertDialog create = builder.create();
        f6663a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f6663a);
        return f6663a;
    }

    public static void b(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || dialog.isShowing()) {
                return;
            }
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public static void a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }
}
