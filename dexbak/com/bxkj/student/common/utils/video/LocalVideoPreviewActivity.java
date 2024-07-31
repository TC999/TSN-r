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
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.utils.FormatUtils;
import java.text.SimpleDateFormat;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LocalVideoPreviewActivity extends BaseActivity {

    /* renamed from: k */
    private VideoView f16243k;

    /* renamed from: l */
    private SeekBar f16244l;

    /* renamed from: m */
    private TextView f16245m;

    /* renamed from: n */
    private TextView f16246n;

    /* renamed from: o */
    private int f16247o;

    /* renamed from: p */
    private final String f16248p = "filepath";

    /* renamed from: q */
    private Runnable f16249q = new RunnableC4256b();

    /* renamed from: com.bxkj.student.common.utils.video.LocalVideoPreviewActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4255a implements SeekBar.OnSeekBarChangeListener {
        C4255a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                LocalVideoPreviewActivity.this.f16243k.seekTo(progress);
                LocalVideoPreviewActivity.this.f16245m.setText(LocalVideoPreviewActivity.this.m42782p0(progress));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* renamed from: com.bxkj.student.common.utils.video.LocalVideoPreviewActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC4256b implements Runnable {
        RunnableC4256b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = LocalVideoPreviewActivity.this.f16245m;
            LocalVideoPreviewActivity localVideoPreviewActivity = LocalVideoPreviewActivity.this;
            textView.setText(localVideoPreviewActivity.m42782p0(localVideoPreviewActivity.f16243k.getCurrentPosition()));
            if (LocalVideoPreviewActivity.this.f16244l != null) {
                LocalVideoPreviewActivity.this.f16244l.setProgress(LocalVideoPreviewActivity.this.f16243k.getCurrentPosition());
            }
            if (LocalVideoPreviewActivity.this.f16243k.isPlaying()) {
                LocalVideoPreviewActivity.this.f16244l.postDelayed(LocalVideoPreviewActivity.this.f16249q, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public String m42782p0(long needFromatTime) {
        return new SimpleDateFormat("mm:ss").format(Long.valueOf(needFromatTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void m42781q0(MediaPlayer mediaPlayer, int i) {
        this.f16245m.setText(FormatUtils.m39630g(this.f16243k.getCurrentPosition()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void m42780r0(MediaPlayer mediaPlayer) {
        mediaPlayer.setLooping(true);
        int duration = this.f16243k.getDuration();
        this.f16245m.setText(m42782p0(0L));
        this.f16246n.setText(m42782p0(duration));
        this.f16244l.setMax(duration);
        this.f16244l.postDelayed(this.f16249q, 1000L);
        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.bxkj.student.common.utils.video.a
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(MediaPlayer mediaPlayer2, int i) {
                LocalVideoPreviewActivity.this.m42781q0(mediaPlayer2, i);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16243k.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.bxkj.student.common.utils.video.b
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                LocalVideoPreviewActivity.this.m42780r0(mediaPlayer);
            }
        });
        this.f16244l.setOnSeekBarChangeListener(new C4255a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_video_preview;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f16243k.setVideoURI(Uri.parse(getIntent().getStringExtra("filepath")));
        this.f16243k.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("播放视频");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16243k = (VideoView) findViewById(C4215R.C4219id.videoView);
        this.f16244l = (SeekBar) findViewById(2131232602);
        this.f16245m = (TextView) findViewById(C4215R.C4219id.tv_start);
        this.f16246n = (TextView) findViewById(C4215R.C4219id.tv_end);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
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
        this.f16247o = this.f16243k.getCurrentPosition();
        this.f16243k.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f16243k.seekTo(this.f16247o);
        this.f16243k.start();
    }
}
