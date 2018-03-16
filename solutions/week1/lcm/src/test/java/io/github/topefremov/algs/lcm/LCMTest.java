/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.topefremov.algs.lcm;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aaefr
 */
public class LCMTest {
    
    @Test
    public void lcmNaiveTest() {
        assertEquals(24, LCM.lcm_naive(6, 8));
        assertEquals(1933053046, LCM.lcm_naive(28851538, 1183019));
    }
    
    @Test
    public void lcmEfficientTest() {
        assertEquals(24, LCM.lcmEfficient(6, 8));
        assertEquals(1933053046, LCM.lcmEfficient(28851538, 1183019));
    }
}
