package practice.leetcode.intervals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsIITest {
    private MeetingRoomsII solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.intervals", "MeetingRoomsII"); }
    @Test
    void test() { assertEquals(2, solution.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}})); }
}
