package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
BluetoothAdapter BA;
Button btnTurnOff,btnDiscoverable,btnFindPair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTurnOff=(Button)findViewById(R.id.btnoff);
        btnDiscoverable=(Button)findViewById(R.id.btn);
        btnFindPair=(Button)findViewById(R.id.btnpairdevices);
        BA=BluetoothAdapter.getDefaultAdapter();
        btnTurnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
            BA.disable();

                if(BA.isEnabled())
                {
                    Toast.makeText(MainActivity.this, "Bluetooth is on", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(MainActivity.this, "Bluetooth is off", Toast.LENGTH_SHORT).show();

                     }
                }
        });

        btnDiscoverable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
            Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            startActivity(i);

            }
        });

         btnFindPair.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {

                 Set<BluetoothDevice> pairedDevices=BA.getBondedDevices();
                 ListView listView=(ListView)findViewById(R.id.listviewpaireddevices);
                 ArrayList pairedDevicesArrayList=new ArrayList();
                 for(BluetoothDevice bluetoothDevice:pairedDevices)
                 {
                     pairedDevicesArrayList.add(bluetoothDevice.getName());
                 }
                 ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,pairedDevicesArrayList);
                  listView.setAdapter(arrayAdapter);

             }
         });

       if(BA.isEnabled())
        {
            Toast.makeText(this, "Bluetooth is on", Toast.LENGTH_SHORT).show();
        }
        else {

            Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(i);
              if(BA.isEnabled()) {

                  Toast.makeText(this, "Bluetooth is On", Toast.LENGTH_SHORT).show();
              }
        }
    }
}
/*
package com.example.robpercival.bluetoothdemo;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends Activity {

    BluetoothAdapter BA;


    public void turnBluetoothOff (View view) {

        BA.disable();

        if (BA.isEnabled()) {

            Toast.makeText(getApplicationContext(), "Bluetooth could not be disabled", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(getApplicationContext(), "Bluetooth turned off", Toast.LENGTH_LONG).show();

        }


    }

    public void findDiscoverableDevices (View view) {

        Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivity(i);


    }

    public void viewPairedDevices (View view) {

        Set<BluetoothDevice> pairedDevices = BA.getBondedDevices();

        ListView pairedDevicesListView = (ListView) findViewById(R.id.pairedDevicesListView);

        ArrayList pairedDevicesArrayList = new ArrayList();

        for (BluetoothDevice bluetoothDevice : pairedDevices) {

            pairedDevicesArrayList.add(bluetoothDevice.getName());

        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pairedDevicesArrayList);

        pairedDevicesListView.setAdapter(arrayAdapter);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BA.isEnabled()) {

            Toast.makeText(getApplicationContext(), "Bluetooth is on", Toast.LENGTH_LONG).show();

        } else {

            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(i);

            if (BA.isEnabled()) {

                Toast.makeText(getApplicationContext(), "Bluetooth turned on", Toast.LENGTH_LONG).show();

            }

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


 */
