/*
 * Copyright (C) 2015 Paul Burke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.paulburke.android.itemtouchhelperdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import co.paulburke.android.itemtouchhelperdemo.helper.ItemTouchHelperAdapter;
import co.paulburke.android.itemtouchhelperdemo.helper.ItemTouchHelperViewHolder;
import co.paulburke.android.itemtouchhelperdemo.helper.OnStartDragListener;
import co.paulburke.android.itemtouchhelperdemo.tree.MainWorkManyTreeNode;

/**
 * Simple RecyclerView.Adapter that implements {@link ItemTouchHelperAdapter} to respond to move and
 * dismiss events from a {@link android.support.v7.widget.helper.ItemTouchHelper}.
 *
 * @author Paul Burke (ipaulpro)
 */
public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder>
        implements ItemTouchHelperAdapter {

    // 用作显示
    private final List<MainWorkManyTreeNode> mItems = new ArrayList<>();
    // 用作存储数据
    private final List<MainWorkManyTreeNode> mOrginItems = new ArrayList<>();

    private final OnStartDragListener mDragStartListener;

    public RecyclerListAdapter(Context context, List<MainWorkManyTreeNode> mainWorkNodeList, OnStartDragListener dragStartListener) {

        mDragStartListener = dragStartListener;
        mItems.addAll(mainWorkNodeList);
        mOrginItems.addAll(mainWorkNodeList);
        //        mItems.addAll(Arrays.asList(context.getResources().getStringArray(R.array.dummy_items)));
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        MainWorkManyTreeNode proMainWorkManyTreeNode = null;
        if (position - 1 >= 0)
            proMainWorkManyTreeNode = mItems.get(position - 1);
        final MainWorkManyTreeNode curMainWorkManyTreeNode = mItems.get(position);

        holder.textView.setText(curMainWorkManyTreeNode.getData().getTitle());

        holder.mLinearLayout.setPadding((curMainWorkManyTreeNode.getLevel() - 1) * 40, 0, 0, 0);
        //         Start a drag whenever the handle view it touched
        // 没有子集
        if ((curMainWorkManyTreeNode.getChildList() == null || curMainWorkManyTreeNode.getChildList().isEmpty())
                && (proMainWorkManyTreeNode != null && proMainWorkManyTreeNode.getLevel() < curMainWorkManyTreeNode.getLevel())) {
            holder.icon.setImageResource(R.drawable.icon_gongzuojianyou_xian);
        }
        // 没有子集 ,而且不是当前的第一位
        else if (curMainWorkManyTreeNode.getChildList() == null || curMainWorkManyTreeNode.getChildList().isEmpty()) {
            holder.icon.setImageResource(R.drawable.btn_hebingziji);
        }
        // 有子集 且是膨胀的
        else if (curMainWorkManyTreeNode.getChildList() != null && !curMainWorkManyTreeNode.getChildList().isEmpty() && curMainWorkManyTreeNode.isExpand()) {
            holder.icon.setImageResource(R.drawable.icon_gongzuojianyou_lan);
        }
        // 有子集 且是非膨胀的
        else if (curMainWorkManyTreeNode.getChildList() != null && !curMainWorkManyTreeNode.getChildList().isEmpty() && !curMainWorkManyTreeNode.isExpand()) {
            holder.icon.setImageResource(R.drawable.icon_gongzuojianyou);
        }

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  根节点 膨胀
                if (curMainWorkManyTreeNode.getChildList() != null && !curMainWorkManyTreeNode.getChildList().isEmpty()) {
                    curMainWorkManyTreeNode.setExpand(!curMainWorkManyTreeNode.isExpand());

                    if (curMainWorkManyTreeNode.isExpand())
                        mItems.addAll(position + 1, curMainWorkManyTreeNode.getChildList());
                    else {
                        removeChilds(curMainWorkManyTreeNode);
                    }


                    notifyDataSetChanged();
                }
            }
        });


        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 没有子集 ,而且不是当前的第一位  成为兄弟的子集
                if (curMainWorkManyTreeNode.getChildList() == null || curMainWorkManyTreeNode.getChildList().isEmpty()) {
                    //
                }
            }
        });

    }

    private void removeChilds(MainWorkManyTreeNode node) {
        if (node.getChildList() == null)
            return;
        mItems.removeAll(node.getChildList());
        for (int i = 0; i < node.getChildList().size(); i++) {
            removeChilds(node.getChildList().get(i));
        }
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public int getItemCount() {
        if (mItems != null)
            return mItems.size();
        return 0;
    }

    public MainWorkManyTreeNode getItem(int position) {
        if (mItems != null)
            return mItems.get(position);
        return null;
    }


    /**
     * Simple example of a view holder that implements {@link ItemTouchHelperViewHolder} and has a
     * "handle" view that initiates a drag event when touched.
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder implements
            ItemTouchHelperViewHolder {
        public final LinearLayout mLinearLayout;
        public final TextView textView;
        public final ImageView icon;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.item);
            textView = (TextView) itemView.findViewById(R.id.title);
            icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }
}
