package brothersideas.mx.dragonproyect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.models.GenericUser;
import app.models.Meta;
import app.models.Proyect;
import app.models.UserHistory;
import exceptions.MetasException;

public class NuevaHistoria extends AppCompatActivity {

    EditText claveHistoria;
    EditText descripcionHistoria;
    EditText nombreHistoria;
    Meta m;
    Integer proyectoP;
    Integer metaP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_historia);
        claveHistoria = (EditText) findViewById(R.id.edtClaveHistoria);
        descripcionHistoria = (EditText) findViewById(R.id.edtDescripcionHistoria);
        nombreHistoria = (EditText) findViewById(R.id.edtNombreHistoria);
        proyectoP = getIntent().getIntExtra("proyectoP", 0);
        metaP = getIntent().getIntExtra("metaP", 0);
        m = MenuActivity.proyectos.get(proyectoP).getMetasByProyecto().get(metaP);
    }

    public void crearHistoria(View v){
        UserHistory u = new UserHistory(claveHistoria.getText().toString(),nombreHistoria.getText().toString() , descripcionHistoria.getText().toString(),
                new GenericUser("userName", "1234", "email@email.com"));
        try {
            m.addHistoria(u);
            Intent i = new Intent(getBaseContext(), HisotoriasActivity.class);
            i.putExtra("proyectoP", proyectoP);
            i.putExtra("metaP", metaP);
            startActivity(i);
        } catch (MetasException.DuplicateClaveHistoriaByProyecto duplicateClaveHistoriaByProyecto) {
            Toast.makeText(v.getContext(), "No se pueden crear historias con claves duplicadas", Toast.LENGTH_LONG).show();
        }
    }
}
