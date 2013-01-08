package at.drizzd;

import java.lang.Thread;

import android.util.Log;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Threadt extends Activity
{
    private static final String TAG = Threadt.class.getSimpleName();
    TextView view;
    volatile String s = "";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        view = (TextView)findViewById(R.id.body);

        Runnable appender = new Runnable() {
            private String alphabet = "abcdefghijklmnopqrstuvwxyz";

            public void run() {
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                String tmp = s;
                for (int i = 0; i < alphabet.length(); i++) {
                    s = tmp + alphabet.charAt(i);
                    Threadt.this.runOnUiThread(new Runnable() {
                        public void run() {
                            update();
                        }
                    });
                    tmp = s;
                }
            }
        };
        new Thread(appender).start();
        new Thread(appender).start();
    }

    private void update() {
        view.setText(s);
    }

    private void nap() {
        try {
            Thread.sleep(1);
        } catch (Throwable t) {
            Log.e(TAG, "Error", t);
        }
    }
}
