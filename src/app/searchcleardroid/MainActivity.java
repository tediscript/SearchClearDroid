package app.searchcleardroid;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {

	private EditText searchEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initComponents();
	}

	private void initComponents() {
		initSearchEditText();
		// init other components below
	}

	private void initSearchEditText() {
		final ImageButton clearButton = (ImageButton) findViewById(R.id.clearButton);
		clearButton.setVisibility(View.GONE);
		clearButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				searchEditText.setText("");
			}
		});

		searchEditText = (EditText) findViewById(R.id.editText);
		searchEditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (s.length() > 0) {
					clearButton.setVisibility(View.VISIBLE);
				} else {
					clearButton.setVisibility(View.GONE);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}
		});
		searchEditText.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_SEARCH) {
					searchEditTextOnActionSearchListener(v, actionId, event);
					return true;
				}
				return false;
			}
		});

	}

	private void searchEditTextOnActionSearchListener(TextView v, int actionId,
			KeyEvent event) {
		// on search button pressed
		Log.d(getClass().getName(), "Search for: " + v.getText());
	}

}
