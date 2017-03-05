package brothersideas.mx.dragonproyect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import app.models.EPrioridad;
import app.models.Meta;
import app.models.Proyect;
import exceptions.ProyectoException;

public class NuevaMeta extends AppCompatActivity {

    EditText claveMeta;
    EditText descripcionMeta;
    Proyect proyecto;
    Integer index;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_meta);
        claveMeta = (EditText) findViewById(R.id.edtClaveMeta);
        descripcionMeta = (EditText) findViewById(R.id.edtDescripcionMeta);
        spinner = (Spinner) findViewById(R.id.prioridadSpinner);
        spinner.setAdapter(new ArrayAdapter<EPrioridad>(this, android.R.layout.simple_spinner_item, EPrioridad.values()));
        index = getIntent().getIntExtra("proyectoP", 0);
        proyecto = MenuActivity.proyectos.get(index);

    }


    public void createMeta(View v){
        Meta m = new Meta(claveMeta.getText().toString(), descripcionMeta.getText().toString(), EPrioridad.valueOf(spinner.getSelectedItem().toString()));
        try {
            proyecto.addMeta(m);
            Intent i = new Intent(getBaseContext(), MetasActivity.class);
            i.putExtra("proyectoP", index);
            startActivity(i);
        } catch (ProyectoException.DuplicateClaveMetaByProyecto duplicateClaveMetaByProyecto) {
            Toast.makeText(v.getContext(), "No se pueden crear metas con claves duplicadas", Toast.LENGTH_LONG).show();
        }

    }
}
