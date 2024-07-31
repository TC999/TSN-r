package com.p521ss.android.socialbase.appdownloader.p545n;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.p521ss.android.socialbase.appdownloader.C12360q;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12307rh;
import com.p521ss.android.socialbase.appdownloader.view.FragmentC12380ok;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.socialbase.appdownloader.n.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12336s {

    /* renamed from: a */
    private static List<InterfaceC12307rh> f34796a = new ArrayList();

    /* renamed from: bl */
    private static FragmentC12380ok f34797bl = null;

    /* renamed from: ok */
    private static final String f34798ok = "s";

    /* renamed from: s */
    private static AlertDialog f34799s;

    /* renamed from: a */
    public static void m18120a(@NonNull Activity activity, @NonNull InterfaceC12307rh interfaceC12307rh) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = f34798ok;
                    FragmentC12380ok fragmentC12380ok = (FragmentC12380ok) fragmentManager.findFragmentByTag(str);
                    f34797bl = fragmentC12380ok;
                    if (fragmentC12380ok == null) {
                        f34797bl = new FragmentC12380ok();
                        fragmentManager.beginTransaction().add(f34797bl, str).commitAllowingStateLoss();
                        fragmentManager.executePendingTransactions();
                    }
                    f34797bl.m18002ok();
                    return;
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    interfaceC12307rh.mo18033ok();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
        }
        interfaceC12307rh.mo18033ok();
    }

    /* renamed from: ok */
    public static boolean m18119ok() {
        try {
            return NotificationManagerCompat.from(C12490bl.m17807l()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    /* renamed from: ok */
    public static synchronized void m18116ok(boolean z) {
        synchronized (C12336s.class) {
            try {
                AlertDialog alertDialog = f34799s;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    f34799s = null;
                }
                for (InterfaceC12307rh interfaceC12307rh : f34796a) {
                    if (interfaceC12307rh != null) {
                        if (z) {
                            interfaceC12307rh.mo18033ok();
                        } else {
                            interfaceC12307rh.mo18034a();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: ok */
    public static synchronized void m18118ok(@NonNull final Activity activity, @NonNull final InterfaceC12307rh interfaceC12307rh) {
        synchronized (C12336s.class) {
            if (interfaceC12307rh == null) {
                return;
            }
            if (activity != null) {
                try {
                } catch (Throwable th) {
                    th.printStackTrace();
                    m18116ok(false);
                }
                if (!activity.isFinishing()) {
                    int m18083ok = C12360q.m18083ok(C12490bl.m17807l(), "tt_appdownloader_notification_request_title");
                    int m18083ok2 = C12360q.m18083ok(C12490bl.m17807l(), "tt_appdownloader_notification_request_message");
                    int m18083ok3 = C12360q.m18083ok(C12490bl.m17807l(), "tt_appdownloader_notification_request_btn_yes");
                    int m18083ok4 = C12360q.m18083ok(C12490bl.m17807l(), "tt_appdownloader_notification_request_btn_no");
                    f34796a.add(interfaceC12307rh);
                    AlertDialog alertDialog = f34799s;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        f34799s = new AlertDialog.Builder(activity).setTitle(m18083ok).setMessage(m18083ok2).setPositiveButton(m18083ok3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.n.s.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                C12336s.m18120a(activity, interfaceC12307rh);
                                dialogInterface.cancel();
                                AlertDialog unused = C12336s.f34799s = null;
                            }
                        }).setNegativeButton(m18083ok4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.n.s.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                C12336s.m18116ok(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.n.s.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i == 4) {
                                    if (keyEvent.getAction() == 1) {
                                        C12336s.m18116ok(false);
                                    }
                                    return true;
                                }
                                return false;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            }
            interfaceC12307rh.mo18034a();
        }
    }
}
