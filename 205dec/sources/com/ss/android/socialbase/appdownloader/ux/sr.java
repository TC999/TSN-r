package com.ss.android.socialbase.appdownloader.ux;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.gd;
import com.ss.android.socialbase.appdownloader.xv.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static final String f49226c = "sr";
    private static AlertDialog sr;

    /* renamed from: w  reason: collision with root package name */
    private static List<t> f49227w = new ArrayList();
    private static com.ss.android.socialbase.appdownloader.view.c xv;

    public static void w(@NonNull Activity activity, @NonNull t tVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = f49226c;
                    com.ss.android.socialbase.appdownloader.view.c cVar = (com.ss.android.socialbase.appdownloader.view.c) fragmentManager.findFragmentByTag(str);
                    xv = cVar;
                    if (cVar == null) {
                        xv = new com.ss.android.socialbase.appdownloader.view.c();
                        fragmentManager.beginTransaction().add(xv, str).commitAllowingStateLoss();
                        fragmentManager.executePendingTransactions();
                    }
                    xv.c();
                    return;
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    tVar.c();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
        }
        tVar.c();
    }

    public static boolean c() {
        try {
            return NotificationManagerCompat.from(com.ss.android.socialbase.downloader.downloader.xv.gw()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void c(boolean z3) {
        synchronized (sr.class) {
            try {
                AlertDialog alertDialog = sr;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    sr = null;
                }
                for (t tVar : f49227w) {
                    if (tVar != null) {
                        if (z3) {
                            tVar.c();
                        } else {
                            tVar.w();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void c(@NonNull final Activity activity, @NonNull final t tVar) {
        synchronized (sr.class) {
            if (tVar == null) {
                return;
            }
            if (activity != null) {
                try {
                } catch (Throwable th) {
                    th.printStackTrace();
                    c(false);
                }
                if (!activity.isFinishing()) {
                    int c4 = gd.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), "tt_appdownloader_notification_request_title");
                    int c5 = gd.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), "tt_appdownloader_notification_request_message");
                    int c6 = gd.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), "tt_appdownloader_notification_request_btn_yes");
                    int c7 = gd.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), "tt_appdownloader_notification_request_btn_no");
                    f49227w.add(tVar);
                    AlertDialog alertDialog = sr;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        sr = new AlertDialog.Builder(activity).setTitle(c4).setMessage(c5).setPositiveButton(c6, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.ux.sr.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i4) {
                                sr.w(activity, tVar);
                                dialogInterface.cancel();
                                AlertDialog unused = sr.sr = null;
                            }
                        }).setNegativeButton(c7, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.ux.sr.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i4) {
                                sr.c(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.ux.sr.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                                if (i4 == 4) {
                                    if (keyEvent.getAction() == 1) {
                                        sr.c(false);
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
            tVar.w();
        }
    }
}
