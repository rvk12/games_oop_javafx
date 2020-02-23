package ru.job4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author rvk12
 */
public class BishopBlackTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenPositionIsCalledThenItReturnsPositionOfCreatedObject() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B2);
        assertThat(bishopBlack.position(), is(Cell.B2));
    }

    @Test
    public void whenCopyIsCalledPositionReturnsNewCellValue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B2);
        assertThat(bishopBlack.copy(Cell.D4).position(), is(Cell.D4));
    }

    @Test
    public void whenWayOfBishopIsFromC1ToG5ThenFourCellsAreReturned() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] bishopSteps = bishopBlack.way(Cell.C1, Cell.G5);
        assertThat(bishopSteps.length, is(4));
        assertThat(bishopSteps[0], is(Cell.D2));
        assertThat(bishopSteps[1], is(Cell.E3));
        assertThat(bishopSteps[2], is(Cell.F4));
        assertThat(bishopSteps[3], is(Cell.G5));
    }

    @Test()
    public void whenDestinationCellIsNotOnDiagonalThenExceptionIsThrown() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Could not way by diagonal from C1 to G6");
        bishopBlack.way(Cell.C1, Cell.G6);
    }

}