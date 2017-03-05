package brothersideas.mx.dragonproyect;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ProyectsActivity extends AppCompatActivity {

    ListView listaProyectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyects);

        listaProyectos = (ListView) findViewById(R.id.listProyectos);
        Adapter m = new Adapter();
        listaProyectos.setAdapter(m);
        listaProyectos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), MetasActivity.class);
                i.putExtra("proyectoP", position);
                startActivity(i);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), NuevoProyecto.class);
                startActivity(i);
            }
        });

    }

    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return MenuActivity.proyectos.size();
        }

        @Override
        public Object getItem(int position) {
            return MenuActivity.proyectos.get(position);
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

            txtClave.setText(MenuActivity.proyectos.get(position).getClave());
            txtDescripcion.setText(MenuActivity.proyectos.get(position).getDescription());
            return convertView;
        }
    }
}
