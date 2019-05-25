package robbesenesael.howest.newsnma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.w3c.dom.Text;

import java.io.IOException;

public class ArticleMakerActivity extends AppCompatActivity {
    private TextView tv_cat;
    private EditText et_cat;
    private EditText et_body;
    private Button btn_send;

    OkHttpClient client = new OkHttpClient();
    Request req = new Request
            .Builder()
            .url("")
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_maker);

        btn_send = (Button) findViewById(R.id.button2);
        tv_cat = (TextView) findViewById(R.id.textView3);
        et_body = (EditText) findViewById(R.id.editText2);
        et_cat = (EditText) findViewById(R.id.editText3);


        //TODO: do a post to NodeJS API
        btn_send.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });


    }

//    String post(String url, String json) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            return response.body().string();
//        } catch (IOException err) {
//            System.out.println(err.toString());
//        }
//    }
}

