package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class bk {

    /* renamed from: c  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.c.sr f48386c;

    /* renamed from: w  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.c.xv f48387w;

    public static com.ss.android.downloadlib.addownload.c.sr c() {
        return f48386c;
    }

    public static boolean c(int i4) {
        return i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5 || i4 == 7 || i4 == 8;
    }

    public static com.ss.android.downloadlib.addownload.c.xv w() {
        return f48387w;
    }

    public static void c(com.ss.android.downloadlib.addownload.c.sr srVar) {
        f48386c = srVar;
    }

    public static void c(com.ss.android.downloadlib.addownload.c.xv xvVar) {
        f48387w = xvVar;
    }

    public static boolean c(final com.ss.android.downloadad.api.c.w wVar, DownloadInfo downloadInfo, int i4, final com.ss.android.downloadlib.addownload.sr.ev evVar, final boolean z3, final com.ss.android.downloadlib.addownload.c.xv xvVar) {
        boolean w3;
        if (wVar == null) {
            com.ss.android.downloadlib.ux.xv.c().c("tryReverseWifi nativeModel null");
            return false;
        } else if (downloadInfo == null) {
            com.ss.android.downloadlib.ux.xv.c().c("tryReverseWifi info null");
            return false;
        } else {
            final int id = downloadInfo.getId();
            if (z3) {
                w3 = com.ss.android.downloadlib.r.ux.xv(wVar);
            } else {
                w3 = com.ss.android.downloadlib.r.ux.w(wVar);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("switch_status", Integer.valueOf(w3 ? 1 : 0));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (z3) {
                com.ss.android.downloadlib.sr.c.c().c("cancel_pause_reserve_wifi_switch_status", jSONObject, wVar);
            } else {
                com.ss.android.downloadlib.sr.c.c().c("pause_reserve_wifi_switch_status", jSONObject, wVar);
            }
            if (w3 && c(i4) && !com.ss.android.socialbase.downloader.gd.f.w(k.getContext())) {
                if (z3 || !downloadInfo.hasPauseReservedOnWifi()) {
                    c(new com.ss.android.downloadlib.addownload.c.sr() { // from class: com.ss.android.downloadlib.addownload.bk.1
                        @Override // com.ss.android.downloadlib.addownload.c.sr
                        public void c() {
                            bk.c((com.ss.android.downloadlib.addownload.c.sr) null);
                            DownloadInfo downloadInfo2 = Downloader.getInstance(k.getContext()).getDownloadInfo(id);
                            if (downloadInfo2 != null) {
                                downloadInfo2.startPauseReserveOnWifi();
                                com.ss.android.socialbase.downloader.impls.s.c().c(downloadInfo2);
                                if (z3) {
                                    com.ss.android.downloadlib.sr.c.c().c("cancel_pause_reserve_wifi_confirm", wVar);
                                } else {
                                    com.ss.android.downloadlib.sr.c.c().w("pause_reserve_wifi_confirm", wVar);
                                }
                            }
                            evVar.c(wVar);
                        }

                        @Override // com.ss.android.downloadlib.addownload.c.sr
                        public void w() {
                            bk.c((com.ss.android.downloadlib.addownload.c.sr) null);
                            DownloadInfo downloadInfo2 = Downloader.getInstance(k.getContext()).getDownloadInfo(id);
                            if (downloadInfo2 != null) {
                                downloadInfo2.stopPauseReserveOnWifi();
                            }
                            if (z3) {
                                com.ss.android.downloadlib.sr.c.c().c("cancel_pause_reserve_wifi_cancel", wVar);
                            } else {
                                com.ss.android.downloadlib.sr.c.c().w("pause_reserve_wifi_cancel", wVar);
                            }
                            evVar.c(wVar);
                        }
                    });
                    if (z3 && xvVar != null) {
                        c(new com.ss.android.downloadlib.addownload.c.xv() { // from class: com.ss.android.downloadlib.addownload.bk.2
                            @Override // com.ss.android.downloadlib.addownload.c.xv
                            public void delete() {
                                com.ss.android.downloadlib.sr.c.c().c("cancel_pause_reserve_wifi_delete", com.ss.android.downloadad.api.c.w.this);
                                xvVar.delete();
                            }
                        });
                    }
                    if (z3) {
                        TTDelegateActivity.c(wVar, "\u5220\u9664");
                    } else {
                        TTDelegateActivity.w(wVar);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}
