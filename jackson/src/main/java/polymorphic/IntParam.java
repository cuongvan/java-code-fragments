/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphic;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 *
 * @author cuong
 */
public class IntParam extends Param {
    public int value;

    @Override
    public String toString() {
        return "int " + value;
    }
}
