package robbesenesael.howest.newsnma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;

    private TextView uname;
    private TextView pass;
    private TextView err;

    OkHttpClient client = new OkHttpClient();
    Request req = new Request
            .Builder()
            .url("")
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = (TextView) findViewById(R.id.editUname);
        pass = (TextView) findViewById(R.id.editPass);
        err = (TextView) findViewById(R.id.editError);

        btnLogin = (Button) findViewById(R.id.button);

        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Response res = client.newCall(req).execute();
                            String username = (String) uname.getText();
                            String password = (String) pass.getText();
                            if (res.body().toString().equals( "true")) {
                                //go to next page
                                Intent intent = new Intent(MainActivity.this, ArticleMakerActivity.class);
                                intent.putExtra("robbesenesael.howest.newsnma", username);
                                startActivity(intent);

                            } else {
                                err.setText("Either the username or password was incorrect!");
                            }
                        } catch (IOException e) {
                            err.setText("You are unable to login! Please try again later");
                        }
                    }
                }
        );
    }
}
