package at.drizzd;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class threadt extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        sayHello();
    }

    private void sayHello()
    {
        TextView view = (TextView)findViewById(R.id.body);
        view.setText("Hello World from threadt");
    }
}
