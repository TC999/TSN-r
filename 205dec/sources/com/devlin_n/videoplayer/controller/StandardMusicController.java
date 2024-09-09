package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import c1.f;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.controller.BaseVideoController;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class StandardMusicController extends BaseVideoController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    protected SeekBar A;
    protected ImageView B;
    protected ImageView C;
    protected ImageView D;
    protected TextView E;
    private boolean F;
    private boolean G;
    private View H;
    private ProgressBar I;
    private ImageView J;
    private ImageView K;

    /* renamed from: L  reason: collision with root package name */
    private ProgressBar f36901L;
    private ImageView M;
    private LinearLayout N;
    private Animation O;
    private Animation P;
    private PopupMenu Q;

    /* renamed from: v  reason: collision with root package name */
    protected TextView f36902v;

    /* renamed from: w  reason: collision with root package name */
    protected TextView f36903w;

    /* renamed from: x  reason: collision with root package name */
    protected ImageView f36904x;

    /* renamed from: y  reason: collision with root package name */
    protected LinearLayout f36905y;

    /* renamed from: z  reason: collision with root package name */
    protected LinearLayout f36906z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class a implements PopupMenu.OnMenuItemClickListener {
        a() {
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.scale_default) {
                StandardMusicController.this.f36864b.e(0);
            } else if (itemId == R.id.scale_original) {
                StandardMusicController.this.f36864b.e(4);
            } else if (itemId == R.id.scale_match) {
                StandardMusicController.this.f36864b.e(3);
            } else if (itemId == R.id.scale_16_9) {
                StandardMusicController.this.f36864b.e(1);
            } else if (itemId == R.id.scale_4_3) {
                StandardMusicController.this.f36864b.e(2);
            }
            StandardMusicController.this.Q.dismiss();
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StandardMusicController.this.setLayoutParams(new FrameLayout.LayoutParams(c1.a.b, c1.a.a));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public StandardMusicController(@NonNull Context context) {
        this(context, null);
    }

    private void m() {
        if (this.f36868f) {
            this.f36868f = false;
            this.f36865c = false;
            this.f36873k = true;
            g();
            this.D.setSelected(false);
            Toast.makeText(getContext(), R.string.unlocked, 0).show();
        } else {
            d();
            this.f36868f = true;
            this.f36873k = false;
            this.D.setSelected(true);
            Toast.makeText(getContext(), R.string.locked, 0).show();
        }
        this.f36864b.setLock(this.f36868f);
    }

    private void n() {
    }

    private void o(int i4) {
        if (!this.f36865c) {
            if (this.f36864b.b()) {
                this.D.setVisibility(0);
                if (!this.f36868f) {
                    p();
                }
            } else {
                p();
            }
            if (!this.f36868f && !this.F) {
                this.I.setVisibility(8);
                this.I.startAnimation(this.P);
            }
            this.f36865c = true;
        }
        removeCallbacks(this.f36879q);
        if (i4 != 0) {
            postDelayed(this.f36879q, i4);
        }
    }

    private void p() {
        this.f36905y.setVisibility(0);
        this.f36905y.startAnimation(this.O);
        this.f36906z.setVisibility(0);
        this.f36906z.startAnimation(this.O);
        f.n(getContext());
        f.m(getContext());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void d() {
        if (this.f36865c) {
            if (this.f36864b.b()) {
                this.D.setVisibility(8);
                if (!this.f36868f) {
                    n();
                    f.j(getContext());
                    f.i(getContext());
                }
            } else {
                n();
            }
            if (!this.F && !this.f36868f) {
                this.I.setVisibility(0);
                this.I.startAnimation(this.O);
            }
            this.f36865c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void e() {
        super.e();
        ImageView imageView = (ImageView) this.f36863a.findViewById(R.id.more_menu);
        this.B = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.f36863a.findViewById(R.id.fullscreen);
        this.f36904x = imageView2;
        imageView2.setOnClickListener(this);
        this.f36905y = (LinearLayout) this.f36863a.findViewById(R.id.bottom_container);
        this.f36906z = (LinearLayout) this.f36863a.findViewById(R.id.top_container);
        SeekBar seekBar = (SeekBar) this.f36863a.findViewById(R.id.seekBar);
        this.A = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.f36902v = (TextView) this.f36863a.findViewById(R.id.total_time);
        this.f36903w = (TextView) this.f36863a.findViewById(R.id.curr_time);
        ImageView imageView3 = (ImageView) this.f36863a.findViewById(R.id.back);
        this.C = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) this.f36863a.findViewById(R.id.lock);
        this.D = imageView4;
        imageView4.setOnClickListener(this);
        ImageView imageView5 = (ImageView) this.f36863a.findViewById(R.id.thumb);
        this.M = imageView5;
        imageView5.setOnClickListener(this);
        ImageView imageView6 = (ImageView) this.f36863a.findViewById(R.id.iv_play);
        this.J = imageView6;
        imageView6.setOnClickListener(this);
        this.K = (ImageView) this.f36863a.findViewById(R.id.start_play);
        this.f36901L = (ProgressBar) this.f36863a.findViewById(R.id.loading);
        this.I = (ProgressBar) this.f36863a.findViewById(R.id.bottom_progress);
        ((ImageView) this.f36863a.findViewById(R.id.iv_replay)).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f36863a.findViewById(R.id.complete_container);
        this.N = linearLayout;
        linearLayout.setOnClickListener(this);
        this.E = (TextView) this.f36863a.findViewById(R.id.title);
        View findViewById = this.f36863a.findViewById(R.id.status_holder);
        this.H = findViewById;
        findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) f.f(getContext())));
        PopupMenu popupMenu = new PopupMenu(getContext(), this.B, 8388613);
        this.Q = popupMenu;
        popupMenu.getMenuInflater().inflate(R.menu.controller_menu, this.Q.getMenu());
        this.Q.setOnMenuItemClickListener(new a());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int f() {
        BaseVideoController.d dVar = this.f36864b;
        if (dVar == null || this.G) {
            return 0;
        }
        int currentPosition = dVar.getCurrentPosition();
        int duration = this.f36864b.getDuration();
        SeekBar seekBar = this.A;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setEnabled(true);
                double d4 = currentPosition;
                Double.isNaN(d4);
                double d5 = duration;
                Double.isNaN(d5);
                double d6 = (d4 * 1.0d) / d5;
                double max = this.A.getMax();
                Double.isNaN(max);
                int i4 = (int) (d6 * max);
                this.A.setProgress(i4);
                this.I.setProgress(i4);
            } else {
                seekBar.setEnabled(false);
            }
            int bufferPercentage = this.f36864b.getBufferPercentage();
            if (bufferPercentage >= 95) {
                SeekBar seekBar2 = this.A;
                seekBar2.setSecondaryProgress(seekBar2.getMax());
                ProgressBar progressBar = this.I;
                progressBar.setSecondaryProgress(progressBar.getMax());
            } else {
                int i5 = bufferPercentage * 10;
                this.A.setSecondaryProgress(i5);
                this.I.setSecondaryProgress(i5);
            }
        }
        TextView textView = this.f36902v;
        if (textView != null) {
            textView.setText(k(duration));
        }
        TextView textView2 = this.f36903w;
        if (textView2 != null) {
            textView2.setText(k(currentPosition));
        }
        TextView textView3 = this.E;
        if (textView3 != null) {
            textView3.setText(this.f36864b.getTitle());
        }
        return currentPosition;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void g() {
        o(this.f36869g);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return R.layout.layout_standard_music_controller;
    }

    public ImageView getThumb() {
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void i(float f4) {
        if (this.F) {
            this.f36883u = false;
        } else {
            super.i(f4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.fullscreen && id != R.id.back) {
            if (id == R.id.lock) {
                m();
                return;
            } else if (id != R.id.iv_play && id != R.id.thumb && id != R.id.iv_replay) {
                if (id == R.id.more_menu) {
                    this.Q.show();
                    g();
                    return;
                }
                return;
            } else {
                b();
                return;
            }
        }
        c();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
        if (z3) {
            long duration = (this.f36864b.getDuration() * i4) / this.A.getMax();
            TextView textView = this.f36903w;
            if (textView != null) {
                textView.setText(k((int) duration));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.G = true;
        removeCallbacks(this.f36878p);
        removeCallbacks(this.f36879q);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f36864b.seekTo((int) ((this.f36864b.getDuration() * seekBar.getProgress()) / this.A.getMax()));
        this.G = false;
        post(this.f36878p);
        g();
    }

    public void q() {
        this.E.setVisibility(0);
    }

    public void setCanFast(boolean z3) {
        this.A.setOnTouchListener(new c());
    }

    public void setLive(boolean z3) {
        this.F = z3;
        this.I.setVisibility(8);
        this.A.setVisibility(4);
        this.f36902v.setVisibility(4);
        this.B.setVisibility(0);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i4) {
        super.setPlayState(i4);
        switch (i4) {
            case -1:
                c1.c.b("STATE_ERROR");
                return;
            case 0:
                c1.c.b("STATE_IDLE");
                d();
                this.f36868f = false;
                this.D.setSelected(false);
                this.f36864b.setLock(false);
                this.N.setVisibility(8);
                this.I.setVisibility(8);
                this.f36901L.setVisibility(8);
                this.K.setVisibility(0);
                this.M.setVisibility(0);
                return;
            case 1:
                c1.c.b("STATE_PREPARING");
                this.N.setVisibility(8);
                this.K.setVisibility(8);
                this.f36901L.setVisibility(0);
                return;
            case 2:
                c1.c.b("STATE_PREPARED");
                if (!this.F) {
                    this.I.setVisibility(0);
                }
                this.f36901L.setVisibility(8);
                return;
            case 3:
                c1.c.b("STATE_PLAYING");
                post(this.f36878p);
                this.J.setSelected(true);
                this.N.setVisibility(8);
                this.M.setVisibility(8);
                return;
            case 4:
                c1.c.b("STATE_PAUSED");
                this.J.setSelected(false);
                return;
            case 5:
                c1.c.b("STATE_PLAYBACK_COMPLETED");
                d();
                this.M.setVisibility(0);
                this.N.setVisibility(0);
                this.I.setProgress(0);
                this.I.setSecondaryProgress(0);
                this.f36868f = false;
                this.f36864b.setLock(false);
                return;
            case 6:
                c1.c.b("STATE_BUFFERING");
                this.K.setVisibility(8);
                this.f36901L.setVisibility(0);
                return;
            case 7:
                this.f36901L.setVisibility(8);
                c1.c.b("STATE_BUFFERED");
                return;
            default:
                return;
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayerState(int i4) {
        if (i4 == 10) {
            c1.c.b("PLAYER_NORMAL");
            if (this.f36868f) {
                return;
            }
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f36873k = false;
            this.f36904x.setSelected(false);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            this.H.setVisibility(8);
        } else if (i4 != 11) {
        } else {
            c1.c.b("PLAYER_FULL_SCREEN");
            if (this.f36868f) {
                return;
            }
            postDelayed(new b(), 300L);
            this.f36873k = true;
            this.f36904x.setSelected(true);
            this.H.setVisibility(0);
            this.C.setVisibility(0);
            this.E.setVisibility(0);
            if (this.f36865c) {
                this.D.setVisibility(0);
                f.m(getContext());
                f.n(getContext());
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public StandardMusicController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StandardMusicController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        super(context, attributeSet, i4);
        this.O = AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha_in);
        this.P = AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha_out);
    }
}
