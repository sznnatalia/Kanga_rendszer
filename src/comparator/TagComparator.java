/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comparator;

import java.util.Comparator;
import pojos.Tag;

/**
 *
 * @author Nati
 */
public class TagComparator implements Comparator<Tag>{

    @Override
    public int compare(Tag o1, Tag o2) {
        return o1.getNev().compareTo(o2.getNev());
    }

}
