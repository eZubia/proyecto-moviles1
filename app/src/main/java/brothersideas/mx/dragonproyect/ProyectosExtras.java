package brothersideas.mx.dragonproyect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ProyectosExtras extends AppCompatActivity {

    ListView listaProyectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos_extras);
        listaProyectos = (ListView) findViewById(R.id.listProyectosTerminados);
        Adapter m = new Adapter();
        listaProyectos.setAdapter(m);

    }
    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return MenuActivity.proyectosTerminados.size();
        }

        @Override
        public Object getItem(int position) {
            return MenuActivity.proyectosTerminados.get(position);
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

            txtClave.setText(MenuActivity.proyectosTerminados.get(position).getClave());
            txtDescripcion.setText(MenuActivity.proyectosTerminados.get(position).getDescription());
            return convertView;
        }
    }
}
