/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL.OC;

/**
 *
 * @author dk021998
 */
public interface Transformable {
    public Object toDTO();
    public Transformable fromDTO();
}
