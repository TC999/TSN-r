package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.orhanobut.logger.C11792j;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.bxkj.student.run.app.utils.d0 */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class VoiceSpeaker {

    /* renamed from: b */
    private static VoiceSpeaker f19574b;

    /* renamed from: a */
    private ExecutorService f19575a = Executors.newCachedThreadPool();

    private VoiceSpeaker() {
    }

    /* renamed from: e */
    public static synchronized VoiceSpeaker m39665e() {
        VoiceSpeaker voiceSpeaker;
        synchronized (VoiceSpeaker.class) {
            if (f19574b == null) {
                f19574b = new VoiceSpeaker();
            }
            voiceSpeaker = f19574b;
        }
        return voiceSpeaker;
    }

    /* renamed from: h */
    private int m39662h(Context mContext) {
        double streamMaxVolume = ((AudioManager) mContext.getSystemService("audio")).getStreamMaxVolume(2);
        Double.isNaN(streamMaxVolume);
        return (int) (streamMaxVolume * 0.8d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static /* synthetic */ void m39659k(int[] iArr, List list, Context context, MediaPlayer mediaPlayer, CountDownLatch countDownLatch, AudioManager audioManager, MediaPlayer mediaPlayer2) {
        mediaPlayer2.reset();
        iArr[0] = iArr[0] + 1;
        if (iArr[0] < list.size()) {
            try {
                AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(((Integer) list.get(iArr[0])).intValue());
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                mediaPlayer2.prepare();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                countDownLatch.countDown();
                return;
            }
        }
        mediaPlayer2.release();
        audioManager.abandonAudioFocus(null);
        countDownLatch.countDown();
    }

    /* renamed from: l */
    private void m39658l(Context mContext, int volume) {
        ((AudioManager) mContext.getSystemService("audio")).setStreamVolume(2, volume, 0);
    }

    /* renamed from: m */
    private void m39657m(Context mContext, int volume) {
        ((AudioManager) mContext.getSystemService("audio")).setStreamVolume(3, volume, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m39661i(final Context mContext, final List<Integer> list) {
        AssetFileDescriptor openRawResourceFd;
        final int[] iArr;
        synchronized (this) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final MediaPlayer mediaPlayer = new MediaPlayer();
            if (list != null && list.size() > 0) {
                int[] iArr2 = {0};
                AssetFileDescriptor assetFileDescriptor = null;
                try {
                    try {
                        final AudioManager audioManager = (AudioManager) mContext.getSystemService("audio");
                        audioManager.requestAudioFocus(null, 3, 2);
                        openRawResourceFd = mContext.getResources().openRawResourceFd(list.get(iArr2[0]).intValue());
                        try {
                            mediaPlayer.setAudioStreamType(3);
                            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                            mediaPlayer.prepareAsync();
                            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.bxkj.student.run.app.utils.b0
                                @Override // android.media.MediaPlayer.OnPreparedListener
                                public final void onPrepared(MediaPlayer mediaPlayer2) {
                                    mediaPlayer2.start();
                                }
                            });
                            iArr = iArr2;
                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.bxkj.student.run.app.utils.a0
                                @Override // android.media.MediaPlayer.OnCompletionListener
                                public final void onCompletion(MediaPlayer mediaPlayer2) {
                                    VoiceSpeaker.m39659k(iArr, list, mContext, mediaPlayer, countDownLatch, audioManager, mediaPlayer2);
                                }
                            });
                        } catch (Exception e) {
                            e = e;
                            assetFileDescriptor = openRawResourceFd;
                            e.printStackTrace();
                            countDownLatch.countDown();
                            assetFileDescriptor = assetFileDescriptor;
                            if (assetFileDescriptor != null) {
                                try {
                                    assetFileDescriptor.close();
                                    assetFileDescriptor = assetFileDescriptor;
                                } catch (IOException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    countDownLatch.await();
                                    notifyAll();
                                }
                            }
                            countDownLatch.await();
                            notifyAll();
                        } catch (Throwable th) {
                            th = th;
                            assetFileDescriptor = openRawResourceFd;
                            if (assetFileDescriptor != null) {
                                try {
                                    assetFileDescriptor.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                    try {
                        openRawResourceFd.close();
                        assetFileDescriptor = iArr;
                    } catch (IOException e5) {
                        e = e5;
                        e.printStackTrace();
                        countDownLatch.await();
                        notifyAll();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            try {
                countDownLatch.await();
                notifyAll();
            } catch (InterruptedException e6) {
                e6.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public int m39666d(Context mContext) {
        return ((AudioManager) mContext.getSystemService("audio")).getStreamVolume(2);
    }

    /* renamed from: f */
    public int m39664f(Context mContext) {
        return ((AudioManager) mContext.getSystemService("audio")).getStreamMaxVolume(3);
    }

    /* renamed from: g */
    public int m39663g(Context mContext) {
        AudioManager audioManager = (AudioManager) mContext.getSystemService("audio");
        C11792j.m20470c(" audioManager.getMode()=" + audioManager.getMode());
        return audioManager.getStreamVolume(3);
    }

    /* renamed from: n */
    public void m39656n(final Context mContext, final List<Integer> list) {
        ExecutorService executorService = this.f19575a;
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: com.bxkj.student.run.app.utils.c0
                @Override // java.lang.Runnable
                public final void run() {
                    VoiceSpeaker.this.m39661i(mContext, list);
                }
            });
        }
    }
}
