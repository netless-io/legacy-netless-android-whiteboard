package com.netless.whiteboard.components;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.herewhite.sdk.Room;
import com.herewhite.sdk.domain.Scene;
import com.herewhite.sdk.domain.SceneState;
import com.netless.whiteboard.R;

public class SlidesTable extends ArrayAdapter<Scene> {

    private final AppCompatActivity activity;
    private final ListView listView;

    private Scene[] scenes = new Scene[] {};
    private Room room;
    private String scenePath = "";
    private Button btnAdd;
    private int sceneIndex = 0;

    public SlidesTable(AppCompatActivity activity) {
        super(activity, R.layout.room_page_slide);
        this.activity = activity;
        this.btnAdd = activity.findViewById(R.id.btnAdd);
        this.listView = activity.findViewById(R.id.listView);
        this.listView.setAdapter(this);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onChangeToScene(i);
            }
        });
        this.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                onRemoveScene(i);
                return true;
            }
        });
        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAdd();
            }
        });
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setSceneState(SceneState sceneState) {
        boolean willChangeIndex = false;

        if (sceneState.getIndex() != sceneIndex) {
            willChangeIndex = true;
        }
        this.scenePath = sceneState.getScenePath();
        this.sceneIndex = sceneState.getIndex();
        this.scenes = sceneState.getScenes();

        this.clear();
        this.addAll(this.scenes);

        if (willChangeIndex) {
            int firstIndex = this.listView.getFirstVisiblePosition();
            int lastIndex = this.listView.getLastVisiblePosition();

            if (this.sceneIndex < firstIndex || this.sceneIndex > lastIndex) {
                this.listView.setSelection(this.sceneIndex);
            }
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.activity).inflate(R.layout.room_page_slide, viewGroup, false);
        }
        Scene scene = this.getItem(i);
        TextView textView = view.findViewById(R.id.txtIndex);
        textView.setText("" + i);

        if (this.sceneIndex == i) {
            view.setBackgroundColor(this.activity.getResources().getColor(R.color.colorGrayBorder));
        } else {
            view.setBackgroundColor(this.activity.getResources().getColor(R.color.colorGray));
        }
        return view;
    }

    private void onClickAdd() {
        int insertedIndex = this.sceneIndex + 1;
        String directory = this.getSceneDirectory(insertedIndex);
        Scene scene = new Scene();
        this.room.putScenes(directory, new Scene[] {scene}, insertedIndex);
    }

    private void onChangeToScene(int index) {
        if (this.sceneIndex != index) {
            this.room.setScenePath(this.getScenePathWithIndex(index));
        }
    }

    private void onRemoveScene(final int index) {
        new AlertDialog.Builder(this.activity)
                .setTitle("确认删除")
                .setMessage("确定删除这一页吗？")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        removeScene(index);
                    }})
                .setNegativeButton(android.R.string.no, null).show();
    }

    private void removeScene(int index) {
        this.room.removeScenes(this.getScenePathWithIndex(index));
    }

    private String getScenePathWithIndex(int index) {
        return this.getSceneDirectory(index) + "/" + this.scenes[index].getName();
    }

    private String getSceneDirectory(int index) {
        int lastSemicolonIndex = this.scenePath.lastIndexOf('/');
        return this.scenePath.substring(0,lastSemicolonIndex);
    }
}
