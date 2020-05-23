package mx.edu.itsmt.operacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText numero1, numero2;
    Button btSumar,btRestar,btMultiplicar,btDividir;
    TextView tvResultado;
    double num1,num2;
    Operaciones operacion=null;
    public  void vincular() {
        numero1 = findViewById(R.id.etnumero1);
        numero2 = findViewById(R.id.etnumero2);
        btSumar = findViewById(R.id.btsuma);
        btRestar = findViewById(R.id.btresta);
        btMultiplicar = findViewById(R.id.btmultiplica);
        btDividir = findViewById(R.id.btdivide);
        tvResultado = findViewById(R.id.resultado);
        btSumar.setOnClickListener(this);
        btRestar.setOnClickListener(this);
        btMultiplicar.setOnClickListener(this);
        btDividir.setOnClickListener(this);
    }

    public void obtenerDatos() {
        if (numero1.getText().toString().isEmpty()||
            numero2.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),
                    "Llenar ambos campos",Toast.LENGTH_LONG).show();
        }else{
            num1 = Double.parseDouble(numero1.getText().toString());
            num2 = Double.parseDouble(numero2.getText().toString());
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vincular();
    }

    @Override
    public void onClick(View v) {
        obtenerDatos();
        operacion= new Operaciones(num1,num2);
        double resultado=0;
        switch (v.getId()){
            case R.id.btsuma:
                 resultado=operacion.sumar();
                break;
            case R.id.btresta:
                 resultado=operacion.restar();
                break;
            case R.id.btmultiplica:
                 resultado=operacion.multiplicar();
                break;
            case R.id.btdivide:
                resultado=operacion.dividir();
                break;
        }//fin sw
        tvResultado.setText(String.valueOf(resultado));

    }
}
