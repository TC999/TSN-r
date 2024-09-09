package com.bxkj.student.common.utils.video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.run.app.utils.i;
import java.text.SimpleDateFormat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LocalVideoPreviewActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private VideoView f19645k;

    /* renamed from: l  reason: collision with root package name */
    private SeekBar f19646l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19647m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f19648n;

    /* renamed from: o  reason: collision with root package name */
    private int f19649o;

    /* renamed from: p  reason: collision with root package name */
    private final String f19650p = "filepath";

    /* renamed from: q  reason: collision with root package name */
    private Runnable f19651q = new b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                LocalVideoPreviewActivity.this.f19645k.seekTo(progress);
                LocalVideoPreviewActivity.this.f19647m.setText(LocalVideoPreviewActivity.this.p0(progress));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = LocalVideoPreviewActivity.this.f19647m;
            LocalVideoPreviewActivity localVideoPreviewActivity = LocalVideoPreviewActivity.this;
            textView.setText(localVideoPreviewActivity.p0(localVideoPreviewActivity.f19645k.getCurrentPosition()));
            if (LocalVideoPreviewActivity.this.f19646l != null) {
                LocalVideoPreviewActivity.this.f19646l.setProgress(LocalVideoPreviewActivity.this.f19645k.getCurrentPosition());
            }
            if (LocalVideoPreviewActivity.this.f19645k.isPlaying()) {
                LocalVideoPreviewActivity.this.f19646l.postDelayed(LocalVideoPreviewActivity.this.f19651q, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p0(long needFromatTime) {
        return new SimpleDateFormat("mm:ss").format(Long.valueOf(needFromatTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(MediaPlayer mediaPlayer, int i4) {
        this.f19647m.setText(i.g(this.f19645k.getCurrentPosition()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(MediaPlayer mediaPlayer) {
        mediaPlayer.setLooping(true);
        int duration = this.f19645k.getDuration();
        this.f19647m.setText(p0(0L));
        this.f19648n.setText(p0(duration));
        this.f19646l.setMax(duration);
        this.f19646l.postDelayed(this.f19651q, 1000L);
        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.bxkj.student.common.utils.video.a
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(MediaPlayer mediaPlayer2, int i4) {
                LocalVideoPreviewActivity.this.q0(mediaPlayer2, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19645k.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.bxkj.student.common.utils.video.b
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                LocalVideoPreviewActivity.this.r0(mediaPlayer);
            }
        });
        this.f19646l.setOnSeekBarChangeListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427521;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f19645k.setVideoURI(Uri.parse(getIntent().getStringExtra("filepath")));
        this.f19645k.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u64ad\u653e\u89c6\u9891");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19645k = (VideoView) findViewById(2131233286);
        this.f19646l = (SeekBar) findViewById(2131232602);
        this.f19647m = (TextView) findViewById(2131233165);
        this.f19648n = (TextView) findViewById(2131232953);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f19649o = this.f19645k.getCurrentPosition();
        this.f19645k.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f19645k.seekTo(this.f19649o);
        this.f19645k.start();
    }
}
