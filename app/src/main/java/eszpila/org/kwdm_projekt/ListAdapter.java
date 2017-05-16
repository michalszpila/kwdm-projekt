package eszpila.org.kwdm_projekt;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eszpila.org.kwdm_projekt.model.Person;

/**
 * Created by Michał on 2017-05-16.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {


    private List<Person> persons = new ArrayList<>();


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.setPerson(persons.get(position));
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;

        notifyDataSetChanged();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        private Person person;

        private TextView textViewName;
        private TextView textViewSubject;


        public ListViewHolder(View itemView) {
            super(itemView);

            this.textViewName = (TextView) itemView.findViewById(R.id.item_name);
            this.textViewSubject = (TextView) itemView.findViewById(R.id.item_subject);
        }

        public void setPerson(Person person) {
            this.person = person;

            this.textViewName.setText(person.getFirstName() + " " + person.getLastName());
            this.textViewSubject.setText(person.getSubject());
        }
    }
}
