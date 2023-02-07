package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test(expected = OccupiedCellException.class)
    public void testWrongMove() throws OccupiedCellException, FigureNotFoundException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        BishopBlack bishopBlack1 = new BishopBlack(Cell.B2);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(bishopBlack1);
        logic.move(Cell.C1, Cell.B2);
    }

    @Test(expected = FigureNotFoundException.class)
    public void testWrongMoveNotFound() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.B2);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWrongMoveImpossible() throws OccupiedCellException, FigureNotFoundException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.move(Cell.C1, Cell.A1);
    }
}