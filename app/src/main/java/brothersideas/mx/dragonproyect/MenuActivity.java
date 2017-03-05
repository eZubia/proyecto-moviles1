package brothersideas.mx.dragonproyect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import app.models.Proyect;

public class MenuActivity extends AppCompatActivity {

    public static List<Proyect> proyectos = new ArrayList<>();
    public static List<Proyect> proyectosTerminados = new ArrayList<>();
    public static List<Proyect> proyectosEliminados = new ArrayList<>();

    Button verProyectos;
    Button terminados;
    Button nuevoProyecto;
    Button eliminados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        verProyectos = (Button) findViewById(R.id.btnProyectos);
        terminados = (Button) findViewById(R.id.btnProyectosT);
        nuevoProyecto = (Button) findViewById(R.id.btnNuevoP);
        View.OnClickListener oyente = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ProyectosExtras.class);
                i.putExtra("isFinish", true);
                startActivity(i);
            }
        };
        terminados.setOnClickListener(oyente);
    }

    public void proyectos(View v){
        Intent i = new Intent(getBaseContext(), ProyectsActivity.class);
        startActivity(i);
    }

    public void nuevoProyecto(View v){
        Intent i = new Intent(getBaseContext(), NuevoProyecto.class);
        startActivity(i);
    }

}
