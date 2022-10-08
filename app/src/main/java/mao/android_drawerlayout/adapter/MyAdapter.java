package mao.android_drawerlayout.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Project name(项目名称)：android_DrawerLayout
 * Package(包名): mao.android_drawerlayout.adapter
 * Class(类名): MyAdapter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/8
 * Time(创建时间)： 20:24
 * Version(版本): 1.0
 * Description(描述)： 无
 *
 * @param <T> the type parameter
 */


public abstract class MyAdapter<T> extends BaseAdapter
{
    private ArrayList<T> mData;
    private int mLayoutRes;           //布局id


    /**
     * Instantiates a new My adapter.
     */
    public MyAdapter()
    {
    }

    /**
     * Instantiates a new My adapter.
     *
     * @param mData      the m data
     * @param mLayoutRes the m layout res
     */
    public MyAdapter(ArrayList<T> mData, int mLayoutRes)
    {
        this.mData = mData;
        this.mLayoutRes = mLayoutRes;
    }

    @Override
    public int getCount()
    {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public T getItem(int position)
    {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder = ViewHolder.bind(parent.getContext(), convertView, parent, mLayoutRes
                , position);
        bindView(holder, getItem(position));
        return holder.getItemView();
    }

    /**
     * Bind view.
     *
     * @param holder the holder
     * @param obj    the obj
     */
    public abstract void bindView(ViewHolder holder, T obj);

    /**
     * 添加一个元素
     *
     * @param data the data
     */
    public void add(T data)
    {
        if (mData == null)
        {
            mData = new ArrayList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }

    /**
     * 往特定位置，添加一个元素
     *
     * @param position the position
     * @param data     the data
     */
    public void add(int position, T data)
    {
        if (mData == null)
        {
            mData = new ArrayList<>();
        }
        mData.add(position, data);
        notifyDataSetChanged();
    }

    /**
     * Remove.
     *
     * @param data the data
     */
    public void remove(T data)
    {
        if (mData != null)
        {
            mData.remove(data);
        }
        notifyDataSetChanged();
    }

    /**
     * Remove.
     *
     * @param position the position
     */
    public void remove(int position)
    {
        if (mData != null)
        {
            mData.remove(position);
        }
        notifyDataSetChanged();
    }

    /**
     * Clear.
     */
    public void clear()
    {
        if (mData != null)
        {
            mData.clear();
        }
        notifyDataSetChanged();
    }


    /**
     * The type View holder.
     */
    public static class ViewHolder
    {

        private SparseArray<View> mViews;   //存储ListView 的 item中的View
        private View item;                  //存放convertView
        private int position;               //游标
        private Context context;            //Context上下文

        //构造方法，完成相关初始化
        private ViewHolder(Context context, ViewGroup parent, int layoutRes)
        {
            mViews = new SparseArray<>();
            this.context = context;
            View convertView = LayoutInflater.from(context).inflate(layoutRes, parent, false);
            convertView.setTag(this);
            item = convertView;
        }

        /**
         * Bind view holder.
         *
         * @param context     the context
         * @param convertView the convert view
         * @param parent      the parent
         * @param layoutRes   the layout res
         * @param position    the position
         * @return the view holder
         */
        //绑定ViewHolder与item
        public static ViewHolder bind(Context context, View convertView, ViewGroup parent,
                                      int layoutRes, int position)
        {
            ViewHolder holder;
            if (convertView == null)
            {
                holder = new ViewHolder(context, parent, layoutRes);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
                holder.item = convertView;
            }
            holder.position = position;
            return holder;
        }

        /**
         * Gets view.
         *
         * @param <T> the type parameter
         * @param id  the id
         * @return the view
         */
        @SuppressWarnings("unchecked")
        public <T extends View> T getView(int id)
        {
            T t = (T) mViews.get(id);
            if (t == null)
            {
                t = (T) item.findViewById(id);
                mViews.put(id, t);
            }
            return t;
        }


        /**
         * 获取当前条目
         *
         * @return the item view
         */
        public View getItemView()
        {
            return item;
        }

        /**
         * 获取条目位置
         *
         * @return the item position
         */
        public int getItemPosition()
        {
            return position;
        }

        /**
         * 设置文字
         *
         * @param id   the id
         * @param text the text
         * @return the text
         */
        public ViewHolder setText(int id, CharSequence text)
        {
            View view = getView(id);
            if (view instanceof TextView)
            {
                ((TextView) view).setText(text);
            }
            return this;
        }

        /**
         * 设置图片
         *
         * @param id          the id
         * @param drawableRes the drawable res
         * @return the image resource
         */
        public ViewHolder setImageResource(int id, int drawableRes)
        {
            View view = getView(id);
            if (view instanceof ImageView)
            {
                ((ImageView) view).setImageResource(drawableRes);
            }
            else
            {
                view.setBackgroundResource(drawableRes);
            }
            return this;
        }


        /**
         * 设置点击监听
         *
         * @param id       the id
         * @param listener the listener
         * @return the on click listener
         */
        public ViewHolder setOnClickListener(int id, View.OnClickListener listener)
        {
            getView(id).setOnClickListener(listener);
            return this;
        }

        /**
         * 设置可见
         *
         * @param id      the id
         * @param visible the visible
         * @return the visibility
         */
        public ViewHolder setVisibility(int id, int visible)
        {
            getView(id).setVisibility(visible);
            return this;
        }

        /**
         * 设置标签
         *
         * @param id  the id
         * @param obj the obj
         * @return the tag
         */
        public ViewHolder setTag(int id, Object obj)
        {
            getView(id).setTag(obj);
            return this;
        }
    }
}
