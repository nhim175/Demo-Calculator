package com.thinhpham.icalculator;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	StringBuilder exp; 
	TextView result; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_main);
		exp = new StringBuilder();
		result = (TextView) findViewById(R.id.textResult);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void btnClick(View v) {
		Button b = (Button) v;
		String s = b.getText().toString();
		exp.append(s);
		result.setText(exp);
	}
	
	public void calculate(View v) {
		Evaluator evaluator = new Evaluator();
		try {
			result.setText(evaluator.evaluate(exp.toString()));
			
		} catch (EvaluationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exp.setLength(0);
	}
	
	public void reset(View v) {
		exp.setLength(0);
		result.setText("0");
	}

}
