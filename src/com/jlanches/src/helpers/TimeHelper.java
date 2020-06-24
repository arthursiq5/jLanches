/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers;

/**
 *
 * @author arthur
 */
public class TimeHelper {

    public static int[] getPossibleHours() {
        int[] hours = new int[24];

        for (int i = 0; i < hours.length; i++) {
            hours[i] = i;
        }

        return hours;
    }

    public static int[] getPossibleMinutes() {
        int[] minutes = new int[60];

        for (int i = 0; i < minutes.length; i++) {
            minutes[i] = i;
        }

        return minutes;
    }
}
