package brothersideas.mx.dragonproyect;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import app.models.Proyect;

public class MetasActivity extends AppCompatActivity {

    Proyect actualProyect;
    ListView listaMetas;
    TextView txtClave;
    TextView txtDescripcion;
    TextView txtFechaInicio;
    TextView txtFechaFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metas);
        Integer s = getIntent().getIntExtra("proyectoP", 0);
        actualProyect = MenuActivity.proyectos.get(s);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaMetas = (ListView) findViewById(R.id.listMetas);
        txtClave = (TextView) findViewById(R.id.txtClaveMeta);
        txtClave.setText(actualProyect.getClave());
        txtDescripcion = (TextView) findViewById(R.id.txtDescripciónProyecto);
        txtDescripcion.setText(actualProyect.getDescription());
        Adapter m = new Adapter();
        listaMetas.setAdapter(m);
        listaMetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), HisotoriasActivity.class);
                i.putExtra("proyectoP", MenuActivity.proyectos.indexOf(actualProyect));
                i.putExtra("metaP", position);
                startActivity(i);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), NuevaMeta.class);
                i.putExtra("proyectoP", MenuActivity.proyectos.indexOf(actualProyect));
                startActivity(i);
            }
        });
    }

    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return actualProyect.getMetasByProyecto().size();
        }

        @Override
        public Object getItem(int position) {
            return actualProyect.getMetasByProyecto().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(position %2 == 0) {
                convertView = getLayoutInflater().inflate(R.layout.celda, null);
                convertView.setBackgroundColor(1);
            } else {
                convertView = getLayoutInflater().inflate(R.layout.celda2, null);
                convertView.setBackgroundColor(3);
            }
            TextView txtClave = (TextView) convertView.findViewById(R.id.txtCeldaNombre);
            TextView txtDescripcion = (TextView) convertView.findViewById(R.id.txtCeldaDescripcion);

            txtClave.setText(actualProyect.getMetasByProyecto().get(position).getClaveMeta());
            txtDescripcion.setText(actualProyect.getMetasByProyecto().get(position).getDescripcionMeta());
            return convertView;
        }
    }

}
