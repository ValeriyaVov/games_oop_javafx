package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[Math.abs(size)];
        int deltaX = dest.getX() - position.getX();
        int deltaY = dest.getY() - position.getY();
        int x = 0;
        int y = 0;
        for (int index = 0; index < size; index++) {
            if (deltaX < 0 || deltaY < 0) {
                if (deltaX > 0) {
                    x = position().getX() + 1 + index;
                    y = position().getY() - 1 - index;
                } else if (deltaY > 0) {
                    x = position().getX() - 1 - index;
                    y = position().getY() + 1 + index;
                } else {
                    x = position().getX() - 1 - index;
                    y = position().getY() - 1 - index;
                }
            } else {
                x = position().getX() + 1 + index;
                y = position().getY() + 1 + index;
            }
            steps[index] = Cell.findBy(x, y);
        }

        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int sX = source.getX();
        int sY = source.getY();
        int dX = dest.getX();
        int dY = dest.getY();
        if (sX + sY == dX + dY || sX - dX == sY - dY) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
