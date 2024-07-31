package com.acse.ottn.p035b;

import android.app.Activity;
import android.app.Dialog;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.C1239R;
import com.acse.ottn.util.C1633I;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.widget.ContinueSlideScrollView;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.b.C */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1403C {

    /* renamed from: a */
    private static AlertDialog f2514a = null;

    /* renamed from: b */
    private static ContinueSlideScrollView f2515b = null;

    /* renamed from: c */
    private static TimerTask f2516c = null;

    /* renamed from: d */
    private static final String f2517d = "在使用“一键开启必要权限”服务前，请您仔细阅读我们的《用户协议》和《隐私政策》。请您知悉，您同意用户协议和隐私政策将代表您已了解我们提供的功能，以及功能运行所需的必要个人信息。我们在向您提供服务的过程中，除非单独获得您的同意和授权，否则将不会收集您的非必要个人信息。";

    /* renamed from: e */
    private static final String f2518e = "《用户协议》";

    /* renamed from: f */
    private static final String f2519f = "《隐私政策》";

    /* renamed from: com.acse.ottn.b.C$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1404a {
        void onDismiss();

        void onOpen();
    }

    /* renamed from: a */
    public static AlertDialog m56848a(Activity activity, InterfaceC1404a interfaceC1404a) {
        View inflate = LayoutInflater.from(activity).inflate(C1239R.C1244layout.service_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C1239R.C1246style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        TextView textView = (TextView) inflate.findViewById(C1239R.C1242id.tv_one);
        TextView textView2 = (TextView) inflate.findViewById(C1239R.C1242id.tv_eight);
        TextView textView3 = (TextView) inflate.findViewById(C1239R.C1242id.tv_but2);
        C1633I.m56254a().m56241c(activity, textView3);
        ContinueSlideScrollView continueSlideScrollView = (ContinueSlideScrollView) inflate.findViewById(C1239R.C1242id.info_scroll);
        f2515b = continueSlideScrollView;
        continueSlideScrollView.setScanScrollChangedListener(new C1437u(textView3, interfaceC1404a, activity));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(f2517d);
        spannableStringBuilder.setSpan(new C1438v(activity), 26, 32, 33);
        spannableStringBuilder.setSpan(new C1439w(activity), 33, 39, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
        ((TextView) inflate.findViewById(C1239R.C1242id.tv_two)).setText("由于安卓系统的原因，部分手机或操作系统可能会限制后台应用使用定位权限，或应用存在闪退、崩溃及被系统误杀的可能。" + CommonUtil.appName + "为了能够准确记录您的运动里程、轨迹等，强烈建议您开启必要的运动权限，保障您的运动被稳定、持续、实时记录。");
        ((TextView) inflate.findViewById(C1239R.C1242id.tv_three)).setText("必要的运动权限包括：\n[悬浮窗] 安卓系统悬浮窗功能能够保障APP稳定、实时运行。为保障您的运动轨迹与跑步成绩的完整记录，建议您开启悬浮窗权限。\n[允许后台运行和自启动] 为防止应用被系统误杀、清理，建议您允许程序保持在后台运行，以及允许程序在崩溃时自启动，以便保障稳定、持续为您记录运动轨迹。\n[精准定位] 建议您允许程序始终使用精准定位权限，以便实时、精准记录运动轨迹。");
        ((TextView) inflate.findViewById(C1239R.C1242id.tv_four)).setText(CommonUtil.appName + "APP已经为您提供了详细的手动开启必要权限的教程和指导。如果您在手动开启必要权限的过程中遇到问题，或认为手动操作较为繁琐，您也可以使用我们的“一键开启必要权限”服务，我们将为您自动开启跑步和持续定位所需的必要权限。");
        ((TextView) inflate.findViewById(C1239R.C1242id.tv_five)).setText("为自动开启跑步和持续定位所需的必要权限，我们需要您手动在手机系统设置中开启“无障碍”/“辅助模式”。安卓系统无障碍/辅助模式具有收集信息与自动执行操作等功能，我们将基于无障碍/辅助模式功能为您提供自动开启并配置前述必要的运动权限的服务，以便开启“悬浮窗”、“允许后台运行和自启动”、“精准定位”必要权限，以保障在您跑步过程中，稳定、持续、实时、准确为您记录跑步轨迹。开启必要的运动权限，同时能优化APP的稳定性，减少应用闪退、崩溃、以及被系统误杀的概率。");
        ((TextView) inflate.findViewById(C1239R.C1242id.tv_six)).setText("如您不希望使用“一键开启必要权限”服务，可以按照必要权限开启教程来手动开启其有关权限。在为您提供“一键开启必要权限”服务的同时，我们也将使用您开启的“无障碍”/“辅助模式”向您提供优惠和福利提示的服务。如果您不希望使用优惠和福利提示服务，可以在" + CommonUtil.appName + "的设置选项中关闭本服务。关闭后，您仍可以正常使用" + CommonUtil.appName + "的其他服务。");
        ((TextView) inflate.findViewById(C1239R.C1242id.tv_seven)).setText("但请您注意，由于安卓系统机制，在无障碍/辅助模式及保持后台运行权限开启后，从屏幕底部向上滑动时，" + CommonUtil.appName + "仍将有可能继续在后台实时为您提供记录运动轨迹等服务。如果您不希望再继续使用我们的服务，您可以结束应用进程，或至手机系统设置处关闭无障碍/辅助模式，以及关闭保持后台运行权限。");
        String str = "更多有关产品服务、设备权限、个人信息保护及与合作方共享数据等的信息，请查阅" + CommonUtil.appName + "APP《用户协议》及《隐私政策》。";
        int indexOf = str.indexOf(f2518e);
        int indexOf2 = str.indexOf(f2519f);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
        spannableStringBuilder2.setSpan(new C1440x(activity), indexOf, indexOf + 6, 33);
        spannableStringBuilder2.setSpan(new C1441y(activity), indexOf2, indexOf2 + 6, 33);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setText(spannableStringBuilder2);
        f2516c = C1648S.m56165a().m56163b(8000, 1000, new C1401A(textView3, interfaceC1404a, activity));
        ((TextView) inflate.findViewById(C1239R.C1242id.tv_button)).setOnClickListener(new View$OnClickListenerC1402B(activity));
        AlertDialog create = builder.create();
        f2514a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        m56846b(activity, f2514a);
        return f2514a;
    }

    /* renamed from: a */
    public static void m56849a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m56846b(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || dialog.isShowing()) {
                return;
            }
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception unused) {
        }
    }
}
