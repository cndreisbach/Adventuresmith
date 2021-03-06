/*
 * Copyright (c) 2016 Steve Christensen
 *
 * This file is part of RPG-Pad.
 *
 * RPG-Pad is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RPG-Pad is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RPG-Pad.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.stevesea.adventuresmith.data

import groovy.transform.CompileStatic
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

import static org.mockito.Matchers.any
import static org.mockito.Mockito.when

@CompileStatic
@RunWith(MockitoJUnitRunner)
class DiceTest {
    @Mock
    Random mockRandom

    Shuffler shuffler

    @Before
    void setup() {
        // set the shuffler up so that it's always just returning the first item
        shuffler = new Shuffler(mockRandom);
        when(mockRandom.nextInt(any(Integer.class))).thenReturn(0)
    }

    @Test
    void testStringParsingWithModifier() {
        Dice d = Dice.dice("2d20+4", mockRandom)
        Assert.assertEquals(2, d.nDice)
        Assert.assertEquals(20, d.nSides)
        Assert.assertEquals(4, d.mod)

        Assert.assertEquals(6, d.roll())
        Assert.assertEquals("2d20+4", d.toString())
    }

    @Test
    void testStringParsing() {
        Dice d = Dice.dice("34d12", mockRandom)
        Assert.assertEquals(34, d.nDice)
        Assert.assertEquals(12, d.nSides)
        Assert.assertEquals(0, d.mod)

        Assert.assertEquals(34, d.roll())
        Assert.assertEquals("34d12", d.toString())
    }

    @Test
    void testDiceRoller3d6() {
        AbstractGenerator generator = DiceRoller.generators.get('3d6')
        generator.shuffler = shuffler
        Assert.assertEquals("<strong><small>3d6</small></strong> : 3 <small>[1, 1, 1]</small>", generator.generate())
    }
    @Test
    void testDiceRoller1d20() {
        AbstractGenerator generator = DiceRoller.generators.get('1d20')
        generator.shuffler = shuffler
        Assert.assertEquals("<strong><small>1d20</small></strong> : 1", generator.generate())
    }
    @Test
    public void testDiceRoller1d20adv() {
        AbstractGenerator generator = DiceRoller.generators.get('1d20adv')
        generator.shuffler = shuffler
        Assert.assertEquals("<strong><small>1d20 adv</small></strong> : 1 <small>[1, 1]</small>", generator.generate())
    }
    @Test
    public void testDiceRoller1d20disadv() {
        AbstractGenerator generator = DiceRoller.generators.get('1d20disadv')
        generator.shuffler = shuffler
        Assert.assertEquals("<strong><small>1d20 disadv</small></strong> : 1 <small>[1, 1]</small>", generator.generate())
    }
}
