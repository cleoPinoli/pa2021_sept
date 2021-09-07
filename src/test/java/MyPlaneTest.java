import CorePackage.MyPlane;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testfx.framework.junit5.ApplicationExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class MyPlaneTest {

    @ParameterizedTest
    @MethodSource("provideSizes")
    void shouldBeHome (int width, int height, int expectedHomeX, int expectedHomeY) {
        MyPlane plane = new MyPlane(width, height);
        assertEquals(plane.getHome().getX(),expectedHomeX);
        assertEquals(plane.getHome().getY(), expectedHomeY);

    }





    private static Stream<Arguments> provideSizes (){
        return Stream.of(
                Arguments.of( 1440, 900, 720, 450),
                Arguments.of(1920, 1080, 960, 540),
                Arguments.of(800, 600, 400, 300)
        );
    }



}
