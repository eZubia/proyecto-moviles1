package brothersideas.mx.dragonproyect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import app.models.Proyect;

public class NuevoProyecto extends AppCompatActivity {

    EditText txtClave;
    EditText txtDescripcion;
    EditText txtNombre;
    DatePicker inicio;
    DatePicker fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_proyecto);
        txtClave = (EditText) findViewById(R.id.edtClaveProyecto);
        txtDescripcion = (EditText) findViewById(R.id.edtDescripcion);
        txtNombre = (EditText) findViewById(R.id.edtNombreProyecto);
    }

    public void crearProyecto(View v){
        Calendar inicio = Calendar.getInstance();
        Proyect pro = new Proyect(txtNombre.getText().toString(),
                txtDescripcion.getText().toString(),
                new Date(),
                new Date(),
                true);
        pro.setClave(txtClave.getText().toString());
        MenuActivity.proyectos.add(pro);
        Intent i = new Intent(getBaseContext(), ProyectsActivity.class);
        startActivity(i);

    }


}
