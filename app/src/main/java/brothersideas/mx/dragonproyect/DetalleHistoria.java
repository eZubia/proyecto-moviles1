package brothersideas.mx.dragonproyect;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetalleHistoria extends AppCompatActivity {

    TextView clave;
    TextView nombre;
    TextView descripcion;
    TextView engargado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_historia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        clave = (TextView) findViewById(R.id.txtClaveHistoria);
        clave.setText(getIntent().getStringExtra("clave"));
        descripcion = (TextView) findViewById(R.id.txtDescripcionHistoria);
        descripcion.setText(getIntent().getStringExtra("descripcion"));
        nombre = (TextView) findViewById(R.id.txtNombreHistoria);
        nombre.setText(getIntent().getStringExtra("nombre"));
        engargado = (TextView) findViewById(R.id.txtEncargado);
        engargado.setText(getIntent().getStringExtra("usuario"));
    }

}
