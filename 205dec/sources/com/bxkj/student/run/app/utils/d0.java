package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: VoiceSpeaker.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class d0 {

    /* renamed from: b  reason: collision with root package name */
    private static d0 f22804b;

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f22805a = Executors.newCachedThreadPool();

    private d0() {
    }

    public static synchronized d0 e() {
        d0 d0Var;
        synchronized (d0.class) {
            if (f22804b == null) {
                f22804b = new d0();
            }
            d0Var = f22804b;
        }
        return d0Var;
    }

    private int h(Context mContext) {
        double streamMaxVolume = ((AudioManager) mContext.getSystemService("audio")).getStreamMaxVolume(2);
        Double.isNaN(streamMaxVolume);
        return (int) (streamMaxVolume * 0.8d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(int[] iArr, List list, Context context, MediaPlayer mediaPlayer, CountDownLatch countDownLatch, AudioManager audioManager, MediaPlayer mediaPlayer2) {
        mediaPlayer2.reset();
        iArr[0] = iArr[0] + 1;
        if (iArr[0] < list.size()) {
            try {
                AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(((Integer) list.get(iArr[0])).intValue());
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                mediaPlayer2.prepare();
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                countDownLatch.countDown();
                return;
            }
        }
        mediaPlayer2.release();
        audioManager.abandonAudioFocus(null);
        countDownLatch.countDown();
    }

    private void l(Context mContext, int volume) {
        ((AudioManager) mContext.getSystemService("audio")).setStreamVolume(2, volume, 0);
    }

    private void m(Context mContext, int volume) {
        ((AudioManager) mContext.getSystemService("audio")).setStreamVolume(3, volume, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void i(final Context mContext, final List<Integer> list) {
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
                                    d0.k(iArr, list, mContext, mediaPlayer, countDownLatch, audioManager, mediaPlayer2);
                                }
                            });
                        } catch (Exception e4) {
                            e = e4;
                            assetFileDescriptor = openRawResourceFd;
                            e.printStackTrace();
                            countDownLatch.countDown();
                            assetFileDescriptor = assetFileDescriptor;
                            if (assetFileDescriptor != null) {
                                try {
                                    assetFileDescriptor.close();
                                    assetFileDescriptor = assetFileDescriptor;
                                } catch (IOException e5) {
                                    e = e5;
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
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                    }
                    try {
                        openRawResourceFd.close();
                        assetFileDescriptor = iArr;
                    } catch (IOException e8) {
                        e = e8;
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
            } catch (InterruptedException e9) {
                e9.printStackTrace();
            }
        }
    }

    public int d(Context mContext) {
        return ((AudioManager) mContext.getSystemService("audio")).getStreamVolume(2);
    }

    public int f(Context mContext) {
        return ((AudioManager) mContext.getSystemService("audio")).getStreamMaxVolume(3);
    }

    public int g(Context mContext) {
        AudioManager audioManager = (AudioManager) mContext.getSystemService("audio");
        com.orhanobut.logger.j.c(" audioManager.getMode()=" + audioManager.getMode());
        return audioManager.getStreamVolume(3);
    }

    public void n(final Context mContext, final List<Integer> list) {
        ExecutorService executorService = this.f22805a;
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: com.bxkj.student.run.app.utils.c0
                @Override // java.lang.Runnable
                public final void run() {
                    d0.this.i(mContext, list);
                }
            });
        }
    }
}
