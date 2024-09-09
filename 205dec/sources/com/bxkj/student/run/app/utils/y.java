package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import com.bxkj.base.user.LoginUser;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SoundManagerUtil.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class y {

    /* renamed from: b  reason: collision with root package name */
    private static MediaPlayer f22951b;

    /* renamed from: a  reason: collision with root package name */
    private static List<Integer> f22950a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private static MediaPlayer.OnCompletionListener f22952c = new MediaPlayer.OnCompletionListener() { // from class: com.bxkj.student.run.app.utils.x
        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            y.i();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static MediaPlayer.OnErrorListener f22953d = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SoundManagerUtil.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements MediaPlayer.OnErrorListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mp, int what, int extra) {
            if (y.f22951b != null) {
                y.f22951b.reset();
                return false;
            }
            return false;
        }
    }

    private static MediaPlayer c(Context context, int resid) {
        MediaPlayer create = MediaPlayer.create(context, resid);
        f22951b = create;
        create.setOnCompletionListener(f22952c);
        f22951b.setOnErrorListener(f22953d);
        return f22951b;
    }

    private static void d(Context context, int resid) {
        f22951b = c(context, resid);
    }

    public static void f(Context mContext, long tempTime, int countStep) {
        if (LoginUser.getLoginUser().getFrequency() != 3 && tempTime <= 216000000) {
            long j4 = 60;
            if (LoginUser.getLoginUser().getFrequency() != 0) {
                if (LoginUser.getLoginUser().getFrequency() == 1) {
                    j4 = 120;
                } else if (LoginUser.getLoginUser().getFrequency() == 2) {
                    j4 = 300;
                }
            }
            if (tempTime % j4 == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(2131755015);
                arrayList.add(2131755008);
                int i4 = (countStep / 100000) % 10;
                if (i4 > 0) {
                    Resources resources = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources.getIdentifier("num_" + i4, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755100);
                }
                int i5 = (countStep / 10000) % 10;
                if (i5 > 0) {
                    Resources resources2 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources2.getIdentifier("num_" + i5, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755109);
                } else if (i4 > 0) {
                    arrayList.add(2131755036);
                }
                int i6 = (countStep / 1000) % 10;
                if (i6 > 0) {
                    Resources resources3 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources3.getIdentifier("num_" + i6, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755025);
                } else if (i5 > 0) {
                    arrayList.add(2131755036);
                }
                int i7 = (countStep / 100) % 10;
                if (i7 > 0) {
                    Resources resources4 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources4.getIdentifier("num_" + i7, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755009);
                } else if (i6 > 0) {
                    arrayList.add(2131755036);
                }
                int i8 = (countStep / 10) % 10;
                if (i8 > 0) {
                    Resources resources5 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources5.getIdentifier("num_" + i8, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755100);
                } else if (i7 > 0) {
                    arrayList.add(2131755036);
                }
                int i9 = (countStep / 1) % 10;
                if (i9 > 0) {
                    Resources resources6 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources6.getIdentifier("num_" + i9, "raw", mContext.getApplicationInfo().packageName)));
                }
                if (countStep > 0 && arrayList.size() > 0 && ((Integer) arrayList.get(arrayList.size() - 1)).equals(2131755036)) {
                    arrayList.remove(arrayList.size() - 1);
                } else if (countStep == 0) {
                    arrayList.add(2131755036);
                }
                arrayList.add(2131755102);
                com.orhanobut.logger.j.c("\u6587\u5b57=" + i4 + "\u5341" + i5 + "\u4e07" + i6 + "\u5343" + i7 + "\u767e" + i8 + "\u5341" + i9 + "\u4e2a");
                arrayList.add(2131755017);
                String[] split = i.g(tempTime).split("\\:");
                int parseInt = Integer.parseInt(split[0]);
                if (parseInt > 0) {
                    Resources resources7 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources7.getIdentifier("num_" + parseInt, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755024);
                }
                int parseInt2 = Integer.parseInt(split[1]);
                Resources resources8 = mContext.getResources();
                arrayList.add(Integer.valueOf(resources8.getIdentifier("num_" + parseInt2, "raw", mContext.getApplicationInfo().packageName)));
                arrayList.add(2131755035);
                d0.e().n(mContext, arrayList);
            }
        }
    }

    public static void g(Context context, int resid) {
        f22950a.add(Integer.valueOf(resid));
        try {
            MediaPlayer mediaPlayer = f22951b;
            if (mediaPlayer == null) {
                d(context, resid);
            } else {
                try {
                    if (mediaPlayer.isPlaying()) {
                        i();
                    }
                } catch (Exception unused) {
                }
            }
            d(context, resid);
            MediaPlayer mediaPlayer2 = f22951b;
            if (mediaPlayer2 == null) {
                com.orhanobut.logger.j.e("cant find soundName", new Object[0]);
            } else {
                mediaPlayer2.start();
            }
        } catch (IllegalStateException e4) {
            e4.printStackTrace();
        }
    }

    public static void h(Context mContext, long tempTime, double tempDistance, int countStep) {
        if (LoginUser.getLoginUser().getFrequency() != 3 && tempTime <= 216000000 && tempDistance <= 60000.0d) {
            long j4 = 60;
            if (LoginUser.getLoginUser().getFrequency() != 0) {
                if (LoginUser.getLoginUser().getFrequency() == 1) {
                    j4 = 120;
                } else if (LoginUser.getLoginUser().getFrequency() == 2) {
                    j4 = 300;
                }
            }
            if (tempTime % j4 == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(2131755015);
                arrayList.add(2131755008);
                String d4 = i.d(tempDistance);
                com.orhanobut.logger.j.c("formatDistance=" + d4);
                String[] split = d4.split("\\.");
                int parseInt = Integer.parseInt(split[0]);
                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + parseInt, "raw", mContext.getApplicationInfo().packageName)));
                arrayList.add(2131755016);
                for (char c4 : split[1].toCharArray()) {
                    String valueOf = String.valueOf(c4);
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + valueOf, "raw", mContext.getApplicationInfo().packageName)));
                }
                arrayList.add(2131755027);
                int i4 = (countStep / 100000) % 10;
                if (i4 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i4, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755100);
                }
                int i5 = (countStep / 10000) % 10;
                if (i5 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i5, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755109);
                } else if (i4 > 0) {
                    arrayList.add(2131755036);
                }
                int i6 = (countStep / 1000) % 10;
                if (i6 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i6, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755025);
                } else if (i5 > 0) {
                    arrayList.add(2131755036);
                }
                int i7 = (countStep / 100) % 10;
                if (i7 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i7, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755009);
                } else if (i6 > 0) {
                    arrayList.add(2131755036);
                }
                int i8 = (countStep / 10) % 10;
                if (i8 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i8, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755100);
                } else if (i7 > 0) {
                    arrayList.add(2131755036);
                }
                int i9 = (countStep / 1) % 10;
                if (i9 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i9, "raw", mContext.getApplicationInfo().packageName)));
                }
                if (countStep > 0 && arrayList.size() > 0 && ((Integer) arrayList.get(arrayList.size() - 1)).equals(2131755036)) {
                    arrayList.remove(arrayList.size() - 1);
                } else if (countStep == 0) {
                    arrayList.add(2131755036);
                }
                arrayList.add(2131755102);
                com.orhanobut.logger.j.c("\u6587\u5b57=" + i4 + "\u5341" + i5 + "\u4e07" + i6 + "\u5343" + i7 + "\u767e" + i8 + "\u5341" + i9 + "\u4e2a");
                arrayList.add(2131755017);
                String[] split2 = i.g(tempTime).split("\\:");
                int parseInt2 = Integer.parseInt(split2[0]);
                if (parseInt2 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + parseInt2, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(2131755024);
                }
                int parseInt3 = Integer.parseInt(split2[1]);
                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + parseInt3, "raw", mContext.getApplicationInfo().packageName)));
                arrayList.add(2131755035);
                d0.e().n(mContext, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        MediaPlayer mediaPlayer = f22951b;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            f22951b.release();
            f22951b = null;
        }
    }
}
