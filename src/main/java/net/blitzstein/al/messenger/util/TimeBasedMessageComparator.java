/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.blitzstein.al.messenger.util;

import java.util.Comparator;
import net.blitzstein.al.messenger.domain.Message;

/**
 *
 * @author jared
 */
public class TimeBasedMessageComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        Message first = (Message) o1;
        Message second = (Message) o2;

        if (first.getInsertedAt().after(second.getInsertedAt())) {
            return 1;
        } else if (first.getInsertedAt().before(second.getInsertedAt())) {
            return -1;
        } else {
            return 0;
        }
    }

}
