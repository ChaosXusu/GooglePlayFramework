package activity.example.chaosxu.googleplayframework.adapter;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import activity.example.chaosxu.googleplayframework.holder.BaseHolder;

public abstract class BasicAdapter<T> extends BaseAdapter {
        protected ArrayList<T> list;

        public BasicAdapter(ArrayList<T> list) {
                super();
                this.list = list;
        }

        @Override
        public int getCount() {
                return list.size();
        }

        @Override
        public Object getItem(int position) {
                return list.get(position);
        }

        @Override
        public long getItemId(int position) {
                return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                // 1.初始化holder
                BaseHolder<T> holder = null;
                if (convertView == null) {
                        holder = getHolder(position);// 需要一个不固定的holder
                } else {
                        holder = (BaseHolder) convertView.getTag();
                }
                // 3.绑定数据
                holder.bindData(list.get(position));

                // 4.增加炫酷动画
                // 一开始缩小
                ViewCompat.setScaleX(holder.getHolderView(), 0.5f);
                ViewCompat.setScaleY(holder.getHolderView(), 0.5f);
                // 执行放大动画
                ViewCompat.animate(holder.getHolderView()).scaleX(1f).setDuration(400)
                      .setInterpolator(new OvershootInterpolator()).start();
                ViewCompat.animate(holder.getHolderView()).scaleY(1f).setDuration(400)
                      .setInterpolator(new OvershootInterpolator()).start();

                return holder.getHolderView();
        }

        protected abstract BaseHolder<T> getHolder(int position);

}
