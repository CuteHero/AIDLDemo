package top.liziyang.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import top.liziyang.aidlservice.IAIDLDemo;
import top.liziyang.aidlservice.Person;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private IAIDLDemo iaidlDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    button.setText("" +
                            iaidlDemo.add(
                                    Integer.parseInt(((EditText) findViewById(R.id.edit_1)).getText().toString()),
                                    Integer.parseInt(((EditText) findViewById(R.id.edit_2)).getText().toString())
                            )
                    );

                    List<Person> personList = iaidlDemo.getPersonList(new Person("(●—●)", 26));
                    Toast.makeText(MainActivity.this, personList.get(0).getName() + " " + personList.get(0).getAge() +
                            "\n" + personList.get(1).getName() + " " + personList.get(1).getAge(), Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });


        Intent intent = new Intent();
        intent.setComponent(new ComponentName("top.liziyang.aidlservice", "top.liziyang.aidlservice.DemoService"));
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                iaidlDemo = IAIDLDemo.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                iaidlDemo = null;
            }
        }, BIND_AUTO_CREATE);

    }

}
