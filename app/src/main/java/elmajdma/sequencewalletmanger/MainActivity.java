package elmajdma.sequencewalletmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.seq.api.Key;
import com.seq.exception.ChainException;
import com.seq.exception.ConfigurationException;
import com.seq.http.Client;

public class MainActivity extends AppCompatActivity {
  private Client ledger;
  private Button createKeyId;
  private EditText etkeyId;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initiateView();
    //CUL2VJGCLHQD4USIQ2VI7DIG63XQWXOC
    try {
      ledger=new Client.Builder()
          .setLedgerName("elmajdmaledger")
          .setCredential(System.getenv("CUL2VJGCLHQD4USIQ2VI7DIG63XQWXOC"))
          .build();
    } catch (ConfigurationException e) {
      e.printStackTrace();
    }
    createKeyId.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
    Key keyTest=new Key.Builder().create(ledger);
    Log.i("key_test",keyTest.id);

          //new Key.Builder().setId("majdtest").create(ledger);
          //addKeys(etkeyId.getText().toString(),ledger);
          etkeyId.setText("");
        } catch (ChainException e) {
          e.printStackTrace();
        }
      }
    });

  }

  private void addKeys(String keyId, Client client) throws ChainException {
    new Key.Builder().setId(keyId).create(client);
  }
  private void initiateView(){
    createKeyId=findViewById(R.id.btn_create_key);
    etkeyId=findViewById(R.id.ed_key_id);


  }

}
