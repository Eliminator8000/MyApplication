package wip.simon.myapplication.activities.storage;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import wip.simon.myapplication.R;


public class MyAdapter extends BaseAdapter  {

    private Data mData;
    private LayoutInflater mInflater;

    MyAdapter(Data data) {
        mData = data;
        mInflater = (LayoutInflater)
                mData.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // How many items are in the data set represented by this Adapter.
    @Override
    public int getCount() {
        return mData.getStorageSize();
    }

    // Get the data item associated with the specified position in the data set.
    @Override
    public Object getItem(int i) {
        return mData.getStorageValue(i);
    }

    // Get the row id associated with the specified position in the list.
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View recycledView, ViewGroup parent) {
        ViewHolder viewHolder;
        long value;

        if ( recycledView == null ) {
            recycledView = mInflater.inflate(R.layout.listviewrow, parent, false);
            viewHolder = new ViewHolder(recycledView);
            recycledView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) recycledView.getTag();
        }
        value = mData.getStorageValue(position);
        viewHolder.mLongValueTextView.setText(Long.toBinaryString(value));
        return recycledView;
    }

    private class ViewHolder {
        private TextView mLongValueTextView;

        public ViewHolder(View view) {
            mLongValueTextView = (TextView) view.findViewById(R.id.idLongValueTextView);
        }
    }

}
