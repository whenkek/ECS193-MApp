package edu.ucdavis.nmng.ecs193_mapp;

/**
 * Created by whenkek on 2/26/18.
 */

public interface TaskCompleted {
    // Define data you like to return from AysncTask
    public void onTaskComplete(String result);
}
