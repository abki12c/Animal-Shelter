package gr.aueb.animalshelter.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import gr.aueb.animalshelter.R;

public class ObligationsRecyclerViewAdapter extends RecyclerView.Adapter<ObligationsListViewHolder> {

    Context context;
    List<ObligationItem> item;

    public ObligationsRecyclerViewAdapter(Context context, List<ObligationItem> item) {
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public ObligationsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ObligationsListViewHolder(LayoutInflater.from(context).inflate(R.layout.obligation_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ObligationsListViewHolder holder, int position) {
        holder.nameView.setText(item.get(position).getName());
        holder.imageView.setImageResource(item.get(position).getImage());
        holder.descriptionView.setText(item.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
