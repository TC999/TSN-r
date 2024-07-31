package p588f;

import android.util.Log;
import cn.bluemobi.dylan.uncaughtexception.CustomActivityOnCrash;
import com.tencent.connect.common.Constants;

/* renamed from: f.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ReportByEmail {
    /* renamed from: a */
    public static boolean m12781a(String str, String str2) {
        MyMail myMail = new MyMail("dylanandroid2dev@163.com", "dylanandroid2dev");
        myMail.m12786v("smtp.163.com");
        myMail.m12783y(Constants.VIA_REPORT_TYPE_CHAT_AUDIO);
        myMail.m12788t(true);
        String[] m57439E = CustomActivityOnCrash.m57439E();
        if (m57439E != null && m57439E.length > 0) {
            myMail.m12809B(m57439E);
            myMail.m12787u("dylanandroid2dev@163.com");
            myMail.m12810A("【" + str + "】异常崩溃");
            myMail.m12791q(str2.toString());
            try {
                if (myMail.m12792p()) {
                    Log.i(str, "邮件发送成功");
                    return true;
                }
                Log.i(str, "邮件发送失败");
                return false;
            } catch (Exception e) {
                Log.e(str, "邮件发送异常", e);
            }
        }
        return false;
    }
}
