package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.clj.fastble.BleManager;
import com.orhanobut.logger.C11792j;
import com.tencent.bugly.BUGLY;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bxkj.student.run.app.utils.y */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SoundManagerUtil {

    /* renamed from: b */
    private static MediaPlayer f19721b;

    /* renamed from: a */
    private static List<Integer> f19720a = new ArrayList();

    /* renamed from: c */
    private static MediaPlayer.OnCompletionListener f19722c = new MediaPlayer.OnCompletionListener() { // from class: com.bxkj.student.run.app.utils.x
        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            SoundManagerUtil.m39510i();
        }
    };

    /* renamed from: d */
    private static MediaPlayer.OnErrorListener f19723d = new C5412a();

    /* compiled from: SoundManagerUtil.java */
    /* renamed from: com.bxkj.student.run.app.utils.y$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5412a implements MediaPlayer.OnErrorListener {
        C5412a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mp, int what, int extra) {
            if (SoundManagerUtil.f19721b != null) {
                SoundManagerUtil.f19721b.reset();
                return false;
            }
            return false;
        }
    }

    /* renamed from: c */
    private static MediaPlayer m39516c(Context context, int resid) {
        MediaPlayer create = MediaPlayer.create(context, resid);
        f19721b = create;
        create.setOnCompletionListener(f19722c);
        f19721b.setOnErrorListener(f19723d);
        return f19721b;
    }

    /* renamed from: d */
    private static void m39515d(Context context, int resid) {
        f19721b = m39516c(context, resid);
    }

    /* renamed from: f */
    public static void m39513f(Context mContext, long tempTime, int countStep) {
        if (LoginUser.getLoginUser().getFrequency() != 3 && tempTime <= 216000000) {
            long j = 60;
            if (LoginUser.getLoginUser().getFrequency() != 0) {
                if (LoginUser.getLoginUser().getFrequency() == 1) {
                    j = 120;
                } else if (LoginUser.getLoginUser().getFrequency() == 2) {
                    j = 300;
                }
            }
            if (tempTime % j == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf((int) C4215R.raw.dingdong));
                arrayList.add(Integer.valueOf((int) C4215R.raw.active_for));
                int i = (countStep / BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH) % 10;
                if (i > 0) {
                    Resources resources = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources.getIdentifier("num_" + i, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.f16023s));
                }
                int i2 = (countStep / BleManager.f22896l) % 10;
                if (i2 > 0) {
                    Resources resources2 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources2.getIdentifier("num_" + i2, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.f16024w));
                } else if (i > 0) {
                    arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                }
                int i3 = (countStep / 1000) % 10;
                if (i3 > 0) {
                    Resources resources3 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources3.getIdentifier("num_" + i3, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.f16022k));
                } else if (i2 > 0) {
                    arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                }
                int i4 = (countStep / 100) % 10;
                if (i4 > 0) {
                    Resources resources4 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources4.getIdentifier("num_" + i4, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.f16020b));
                } else if (i3 > 0) {
                    arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                }
                int i5 = (countStep / 10) % 10;
                if (i5 > 0) {
                    Resources resources5 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources5.getIdentifier("num_" + i5, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.f16023s));
                } else if (i4 > 0) {
                    arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                }
                int i6 = (countStep / 1) % 10;
                if (i6 > 0) {
                    Resources resources6 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources6.getIdentifier("num_" + i6, "raw", mContext.getApplicationInfo().packageName)));
                }
                if (countStep > 0 && arrayList.size() > 0 && ((Integer) arrayList.get(arrayList.size() - 1)).equals(Integer.valueOf((int) C4215R.raw.num_0))) {
                    arrayList.remove(arrayList.size() - 1);
                } else if (countStep == 0) {
                    arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                }
                arrayList.add(Integer.valueOf((int) C4215R.raw.step));
                C11792j.m20470c("文字=" + i + "十" + i2 + "万" + i3 + "千" + i4 + "百" + i5 + "十" + i6 + "个");
                arrayList.add(Integer.valueOf((int) C4215R.raw.duration));
                String[] split = FormatUtils.m39630g(tempTime).split("\\:");
                int parseInt = Integer.parseInt(split[0]);
                if (parseInt > 0) {
                    Resources resources7 = mContext.getResources();
                    arrayList.add(Integer.valueOf(resources7.getIdentifier("num_" + parseInt, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.hour));
                }
                int parseInt2 = Integer.parseInt(split[1]);
                Resources resources8 = mContext.getResources();
                arrayList.add(Integer.valueOf(resources8.getIdentifier("num_" + parseInt2, "raw", mContext.getApplicationInfo().packageName)));
                arrayList.add(Integer.valueOf((int) C4215R.raw.minute));
                VoiceSpeaker.m39665e().m39656n(mContext, arrayList);
            }
        }
    }

    /* renamed from: g */
    public static void m39512g(Context context, int resid) {
        f19720a.add(Integer.valueOf(resid));
        try {
            MediaPlayer mediaPlayer = f19721b;
            if (mediaPlayer == null) {
                m39515d(context, resid);
            } else {
                try {
                    if (mediaPlayer.isPlaying()) {
                        m39510i();
                    }
                } catch (Exception unused) {
                }
            }
            m39515d(context, resid);
            MediaPlayer mediaPlayer2 = f19721b;
            if (mediaPlayer2 == null) {
                C11792j.m20468e("cant find soundName", new Object[0]);
            } else {
                mediaPlayer2.start();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: h */
    public static void m39511h(Context mContext, long tempTime, double tempDistance, int countStep) {
        if (LoginUser.getLoginUser().getFrequency() != 3 && tempTime <= 216000000 && tempDistance <= 60000.0d) {
            long j = 60;
            if (LoginUser.getLoginUser().getFrequency() != 0) {
                if (LoginUser.getLoginUser().getFrequency() == 1) {
                    j = 120;
                } else if (LoginUser.getLoginUser().getFrequency() == 2) {
                    j = 300;
                }
            }
            if (tempTime % j == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf((int) C4215R.raw.dingdong));
                arrayList.add(Integer.valueOf((int) C4215R.raw.active_for));
                String m39633d = FormatUtils.m39633d(tempDistance);
                C11792j.m20470c("formatDistance=" + m39633d);
                String[] split = m39633d.split("\\.");
                int parseInt = Integer.parseInt(split[0]);
                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + parseInt, "raw", mContext.getApplicationInfo().packageName)));
                arrayList.add(Integer.valueOf((int) C4215R.raw.dot));
                for (char c : split[1].toCharArray()) {
                    String valueOf = String.valueOf(c);
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + valueOf, "raw", mContext.getApplicationInfo().packageName)));
                }
                arrayList.add(Integer.valueOf((int) C4215R.raw.kilometer));
                int i = (countStep / BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH) % 10;
                if (i > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.f16023s));
                }
                int i2 = (countStep / BleManager.f22896l) % 10;
                if (i2 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i2, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.f16024w));
                } else if (i > 0) {
                    arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                }
                int i3 = (countStep / 1000) % 10;
                if (i3 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i3, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.f16022k));
                } else if (i2 > 0) {
                    arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                }
                int i4 = (countStep / 100) % 10;
                if (i4 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i4, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.f16020b));
                } else if (i3 > 0) {
                    arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                }
                int i5 = (countStep / 10) % 10;
                if (i5 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i5, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.f16023s));
                } else if (i4 > 0) {
                    arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                }
                int i6 = (countStep / 1) % 10;
                if (i6 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i6, "raw", mContext.getApplicationInfo().packageName)));
                }
                if (countStep > 0 && arrayList.size() > 0 && ((Integer) arrayList.get(arrayList.size() - 1)).equals(Integer.valueOf((int) C4215R.raw.num_0))) {
                    arrayList.remove(arrayList.size() - 1);
                } else if (countStep == 0) {
                    arrayList.add(Integer.valueOf((int) C4215R.raw.num_0));
                }
                arrayList.add(Integer.valueOf((int) C4215R.raw.step));
                C11792j.m20470c("文字=" + i + "十" + i2 + "万" + i3 + "千" + i4 + "百" + i5 + "十" + i6 + "个");
                arrayList.add(Integer.valueOf((int) C4215R.raw.duration));
                String[] split2 = FormatUtils.m39630g(tempTime).split("\\:");
                int parseInt2 = Integer.parseInt(split2[0]);
                if (parseInt2 > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + parseInt2, "raw", mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf((int) C4215R.raw.hour));
                }
                int parseInt3 = Integer.parseInt(split2[1]);
                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + parseInt3, "raw", mContext.getApplicationInfo().packageName)));
                arrayList.add(Integer.valueOf((int) C4215R.raw.minute));
                VoiceSpeaker.m39665e().m39656n(mContext, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static void m39510i() {
        MediaPlayer mediaPlayer = f19721b;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            f19721b.release();
            f19721b = null;
        }
    }
}
