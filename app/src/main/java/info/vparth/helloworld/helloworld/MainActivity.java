package info.vparth.helloworld.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    public static final int REQUEST_CODE_1 = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRunSO = findViewById(R.id.btnRunSO);
        Button btnGetAnswer = findViewById(R.id.btnGetAnswer);

        btnRunSO.setOnClickListener(this);
        btnGetAnswer.setOnClickListener(this);

        Log.i(TAG, "onCreate: called");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_1 && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("result")) {
                Log.i(TAG, String.format("onActivityResult: %s", data.getStringExtra("result")));
                Toast.makeText(this, "Result: " + data.getStringExtra("result"), Toast.LENGTH_LONG)
                        .show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        int id = btn.getId();
        String caption = btn.getText().toString();

        Log.d(TAG, "onClick: " + caption);

        switch (id) {
            case R.id.btnRunSO: {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://stackoverflow.com"));
                startActivity(intent);
                break;
            }
            case R.id.btnGetAnswer: {
                Intent intent = new Intent(this, ExplicitIntentActivity.class);
                startActivityForResult(intent, REQUEST_CODE_1);
                break;
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart: called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume: called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "onRestart: called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause: called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop: called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy: called");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState: called");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState: called");
    }
}
