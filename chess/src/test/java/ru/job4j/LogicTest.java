package ru.job4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author rvk12
 */
public class LogicTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenDestCellIsEmptyAndWayIsCorrectThenMoveTrue() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        PawnWhite pawn = new PawnWhite(Cell.B2);
        logic.add(bishop);
        logic.add(pawn);
        assertThat(logic.move(Cell.C1, Cell.E3), is(true));
    }

    @Test
    public void whenDestCellIsBusyThenThrownException() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Position B2 is busy");
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        PawnWhite pawn = new PawnWhite(Cell.B2);
        logic.add(bishop);
        logic.add(pawn);
        logic.move(Cell.C1, Cell.A3);
    }

    @Test
    public void whenDestCellIsNotBusyButFigurePresentOnWayThenThrownException() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Position B2 is busy");
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        PawnWhite pawn = new PawnWhite(Cell.B2);
        logic.add(bishop);
        logic.add(pawn);
        logic.move(Cell.C1, Cell.B2);

    }

    @Test
    public void whenWayNotCorrectThrowException() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Could not way by diagonal from C1 to B3");
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        logic.move(Cell.C1, Cell.B3);

    }

}