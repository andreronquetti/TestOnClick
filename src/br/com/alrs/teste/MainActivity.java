package br.com.alrs.teste;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViewById(R.id.button1).setOnClickListener(
				OnClickDelegate.delegate(this, "showText"));
		findViewById(R.id.button2).setOnClickListener(
				OnClickDelegate.delegate(this, "showText"));
		findViewById(R.id.button3).setOnClickListener(
				OnClickDelegate.delegate(new ClickQualquer(this), "showText"));
	}

	public void showText(View v) {
		Toast.makeText(this, ((Button) v).getText(), Toast.LENGTH_SHORT).show();
	}
}