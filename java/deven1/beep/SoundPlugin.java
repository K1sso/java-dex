package deven1.beep;

import android.app.Activity;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Handler;
import android.os.Looper;

import cat.narezany.margyt.plugin.MargyPlugin;

public final class SoundPlugin extends MargyPlugin {
    private static boolean hasPlayed = false;

    @Override
    public void onActivityResumed(Activity activity) {
        if (hasPlayed) {
            return;
        }

        hasPlayed = true;

        final ToneGenerator tone;

        try {
            tone = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        } catch (RuntimeException ignored) {
            return;
        }

        try {
            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 150);

            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    tone.release();
                }
            }, 400);
        } catch (RuntimeException ignored) {
            try {
                tone.release();
            } catch (RuntimeException ignoredToo) {
            }
        }
    }
}
