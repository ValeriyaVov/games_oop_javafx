package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertEquals(Cell.A1, bishopBlack.position());

    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Figure copyBishopBlack = bishopBlack.copy(Cell.C3);
        assertEquals(Cell.C3, copyBishopBlack.position());
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWrongWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C5);
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] bishopBlackWay = bishopBlack.way(Cell.G5);
        Cell[] expectedWay = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expectedWay, bishopBlackWay);
    }
}