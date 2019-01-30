/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comparator;

import java.util.Comparator;
import pojos.Hordozo;

/**
 *
 * @author Nati
 */
public class HordozoComparator implements Comparator<Hordozo>{

    @Override
    public int compare(Hordozo o1, Hordozo o2) {
        if (o1.getGyarto().compareTo(o2.getGyarto())!=0){
            return o1.getGyarto().compareTo(o2.getGyarto());
        } else {
            return o1.getNev().compareTo(o2.getNev());
        }
                
    }

}
