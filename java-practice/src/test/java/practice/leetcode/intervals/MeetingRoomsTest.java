package practice.leetcode.intervals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsTest {
    private MeetingRooms solution;
    @BeforeEach
    void setUp() throws Exception { solution = TargetResolver.resolve("practice.leetcode.intervals", "MeetingRooms"); }
    @Test
    void test() { assertFalse(solution.canAttendMeetings(new int[][]{{0,30},{5,10},{15,20}})); }
}
