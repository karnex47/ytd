package strd.karnex.com.stream_downloader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import strd.karnex.com.stream_downloader.extractor.ExtractorFactory;
import strd.karnex.com.stream_downloader.extractor.InfoExtractor;


public class MainActivity extends Activity {
    private Context context;
    private String url;
    private Button btnDownload;
    private EditText txtURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        btnDownload = (Button) findViewById(R.id.btnDownload);
        txtURL = (EditText) findViewById(R.id.txtURL);
        btnDownload.setEnabled(false);
        txtURL.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager inputManager = (InputMethodManager)
                            context.getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.toggleSoftInput(0, 0);
                    url = v.getText().toString().trim();
                    execute(url);
                    handled = true;
                }
                return handled;
            }
        });
        try{
            Bundle extras = getIntent().getExtras();
            url = extras.getString(Intent.EXTRA_TEXT);
        }
        catch (Exception e) {
            url = "https://youtu.be/zsR8YXGuLqI";
        }
        if(url != "") {
            txtURL.setText(url);
            execute(url);
        }
    }

    private void execute(String url) {
        InfoExtractor ie = new ExtractorFactory().createExtractorFor(url);
        if(ie.suitable(url)){

        }
        else {
            // Show error url
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
