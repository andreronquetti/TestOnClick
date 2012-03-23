package br.com.alrs.teste;

import android.app.Activity;
import android.widget.Toast;

public class ClickQualquer {
	
	private Activity activity;

	public ClickQualquer(Activity activity) {
		this.activity = activity;
	}
	
	public void showText() {
		Toast.makeText(activity, "Teste qualquer", Toast.LENGTH_SHORT).show();
	}

}
