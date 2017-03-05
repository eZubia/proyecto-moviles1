package brothersideas.mx.dragonproyect;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import app.models.Meta;
import app.models.UserHistory;

public class HisotoriasActivity extends AppCompatActivity {

    Meta meta;
    TextView txtClave;
    TextView txtDescripcion;
    Integer proyectoP;
    Integer metaP;
    ListView listaHistorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hisotorias);
        proyectoP = getIntent().getIntExtra("proyectoP", 0);
        metaP = getIntent().getIntExtra("metaP", 0);
        meta = MenuActivity.proyectos.get(proyectoP).getMetasByProyecto().get(metaP);
        txtClave = (TextView) findViewById(R.id.txtClaveMeta);
        txtClave.setText(meta.getClaveMeta());
        txtDescripcion = (TextView) findViewById(R.id.txtDescripciónMeta);
        txtDescripcion.setText(meta.getDescripcionMeta());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaHistorias = (ListView) findViewById(R.id.listHistorias);
        Adapter m = new Adapter();
        listaHistorias.setAdapter(m);
        listaHistorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserHistory u = meta.getHistoriasByProyecto().get(position);
                Intent i = new Intent(getBaseContext(), DetalleHistoria.class);
                i.putExtra("clave", u.getClave());
                i.putExtra("descripcion", u.getDescripcion());
                i.putExtra("nombre", u.getNombre());
                i.putExtra("usuario", u.getEncargado().getUserName());
                startActivity(i);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), NuevaHistoria.class);
                i.putExtra("proyectoP", proyectoP);
                i.putExtra("metaP", metaP);
                startActivity(i);
            }
        });
    }

    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return meta.getHistoriasByProyecto().size();
        }

        @Override
        public Object getItem(int position) {
            return meta.getHistoriasByProyecto().get(position);
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

            txtClave.setText(meta.getHistoriasByProyecto().get(position).getClave());
            txtDescripcion.setText(meta.getHistoriasByProyecto().get(position).getDescripcion());
            return convertView;
        }
    }

}
