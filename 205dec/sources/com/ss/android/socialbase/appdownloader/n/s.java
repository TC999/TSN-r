package com.ss.android.socialbase.appdownloader.n;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.bl.rh;
import com.ss.android.socialbase.appdownloader.q;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static List<rh> f49156a = new ArrayList();
    private static com.ss.android.socialbase.appdownloader.view.ok bl = null;
    private static final String ok = "s";

    /* renamed from: s  reason: collision with root package name */
    private static AlertDialog f49157s;

    public static void a(@NonNull Activity activity, @NonNull rh rhVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = ok;
                    com.ss.android.socialbase.appdownloader.view.ok okVar = (com.ss.android.socialbase.appdownloader.view.ok) fragmentManager.findFragmentByTag(str);
                    bl = okVar;
                    if (okVar == null) {
                        bl = new com.ss.android.socialbase.appdownloader.view.ok();
                        fragmentManager.beginTransaction().add(bl, str).commitAllowingStateLoss();
                        fragmentManager.executePendingTransactions();
                    }
                    bl.ok();
                    return;
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    rhVar.ok();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
        }
        rhVar.ok();
    }

    public static boolean ok() {
        try {
            return NotificationManagerCompat.from(com.ss.android.socialbase.downloader.downloader.bl.l()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void ok(boolean z3) {
        synchronized (s.class) {
            try {
                AlertDialog alertDialog = f49157s;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    f49157s = null;
                }
                for (rh rhVar : f49156a) {
                    if (rhVar != null) {
                        if (z3) {
                            rhVar.ok();
                        } else {
                            rhVar.a();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void ok(@NonNull final Activity activity, @NonNull final rh rhVar) {
        synchronized (s.class) {
            if (rhVar == null) {
                return;
            }
            if (activity != null) {
                try {
                } catch (Throwable th) {
                    th.printStackTrace();
                    ok(false);
                }
                if (!activity.isFinishing()) {
                    int ok2 = q.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "tt_appdownloader_notification_request_title");
                    int ok3 = q.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "tt_appdownloader_notification_request_message");
                    int ok4 = q.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "tt_appdownloader_notification_request_btn_yes");
                    int ok5 = q.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "tt_appdownloader_notification_request_btn_no");
                    f49156a.add(rhVar);
                    AlertDialog alertDialog = f49157s;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        f49157s = new AlertDialog.Builder(activity).setTitle(ok2).setMessage(ok3).setPositiveButton(ok4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.n.s.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i4) {
                                s.a(activity, rhVar);
                                dialogInterface.cancel();
                                AlertDialog unused = s.f49157s = null;
                            }
                        }).setNegativeButton(ok5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.n.s.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i4) {
                                s.ok(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.n.s.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                                if (i4 == 4) {
                                    if (keyEvent.getAction() == 1) {
                                        s.ok(false);
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
            rhVar.a();
        }
    }
}
