package se.mah.ae2513.myactivity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by John on 15-04-02.
 */
public class Client extends ActionBarActivity {

    public static final String SERVERIP = "10.2.15.111"; //your computer IP address
    public static final int SERVERPORT = 4444;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainframe);
        setupConnectButton();
    }

    private void setupConnectButton() {
        Button connectButton = (Button) findViewById(R.id.btnConnect);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // new connectTask();
                InetAddress serverAddr = null;
                try {
                    serverAddr = InetAddress.getByName(SERVERIP);
                    Socket socket = new Socket(serverAddr, SERVERPORT);
                } catch (UnknownHostException e) {
                    Log.e("TCP", "S: Error", e);
                } catch (IOException e) {
                    Log.e("TCP", "S: Error", e);
                }
                Toast.makeText(Client.this,"Connected",Toast.LENGTH_LONG).show();
            }
        });
    }
}
